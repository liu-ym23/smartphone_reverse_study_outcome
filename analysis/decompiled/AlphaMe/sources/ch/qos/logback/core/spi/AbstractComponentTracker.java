package ch.qos.logback.core.spi;

import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class AbstractComponentTracker<C> implements ComponentTracker<C> {
    private static final boolean ACCESS_ORDERED = true;
    public static final long LINGERING_TIMEOUT = 10000;
    public static final long WAIT_BETWEEN_SUCCESSIVE_REMOVAL_ITERATIONS = 1000;
    protected int maxComponents = Integer.MAX_VALUE;
    protected long timeout = VehicleBluetoothManager.FAIL_START_TIMEOUT;
    LinkedHashMap<String, Entry<C>> liveMap = new LinkedHashMap<>(32, 0.75f, true);
    LinkedHashMap<String, Entry<C>> lingerersMap = new LinkedHashMap<>(16, 0.75f, true);
    long lastCheck = 0;
    private RemovalPredicator<C> byExcedent = new RemovalPredicator<C>() { // from class: ch.qos.logback.core.spi.AbstractComponentTracker.1
        @Override // ch.qos.logback.core.spi.AbstractComponentTracker.RemovalPredicator
        public boolean isSlatedForRemoval(Entry<C> entry, long j4) {
            return AbstractComponentTracker.this.liveMap.size() > AbstractComponentTracker.this.maxComponents;
        }
    };
    private RemovalPredicator<C> byTimeout = new RemovalPredicator<C>() { // from class: ch.qos.logback.core.spi.AbstractComponentTracker.2
        @Override // ch.qos.logback.core.spi.AbstractComponentTracker.RemovalPredicator
        public boolean isSlatedForRemoval(Entry<C> entry, long j4) {
            return AbstractComponentTracker.this.isEntryStale(entry, j4);
        }
    };
    private RemovalPredicator<C> byLingering = new RemovalPredicator<C>() { // from class: ch.qos.logback.core.spi.AbstractComponentTracker.3
        @Override // ch.qos.logback.core.spi.AbstractComponentTracker.RemovalPredicator
        public boolean isSlatedForRemoval(Entry<C> entry, long j4) {
            return AbstractComponentTracker.this.isEntryDoneLingering(entry, j4);
        }
    };

    public static class Entry<C> {
        C component;
        String key;
        long timestamp;

        public Entry(String str, C c4, long j4) {
            this.key = str;
            this.component = c4;
            this.timestamp = j4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            String str = this.key;
            if (str == null) {
                if (entry.key != null) {
                    return false;
                }
            } else if (!str.equals(entry.key)) {
                return false;
            }
            C c4 = this.component;
            if (c4 == null) {
                if (entry.component != null) {
                    return false;
                }
            } else if (!c4.equals(entry.component)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.key.hashCode();
        }

        public void setTimestamp(long j4) {
            this.timestamp = j4;
        }

        public String toString() {
            return "(" + this.key + ", " + this.component + ")";
        }
    }

    public interface RemovalPredicator<C> {
        boolean isSlatedForRemoval(Entry<C> entry, long j4);
    }

    private void genericStaleComponentRemover(LinkedHashMap<String, Entry<C>> linkedHashMap, long j4, RemovalPredicator<C> removalPredicator) {
        Iterator<Map.Entry<String, Entry<C>>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry<C> value = it.next().getValue();
            if (!removalPredicator.isSlatedForRemoval(value, j4)) {
                return;
            }
            it.remove();
            processPriorToRemoval(value.component);
        }
    }

    private Entry<C> getFromEitherMap(String str) {
        Entry<C> entry = this.liveMap.get(str);
        return entry != null ? entry : this.lingerersMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEntryDoneLingering(Entry entry, long j4) {
        return entry.timestamp + LINGERING_TIMEOUT < j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEntryStale(Entry<C> entry, long j4) {
        return isComponentStale(entry.component) || entry.timestamp + this.timeout < j4;
    }

    private boolean isTooSoonForRemovalIteration(long j4) {
        if (this.lastCheck + 1000 > j4) {
            return true;
        }
        this.lastCheck = j4;
        return false;
    }

    private void removeExcedentComponents() {
        genericStaleComponentRemover(this.liveMap, 0L, this.byExcedent);
    }

    private void removeStaleComponentsFromLingerersMap(long j4) {
        genericStaleComponentRemover(this.lingerersMap, j4, this.byLingering);
    }

    private void removeStaleComponentsFromMainMap(long j4) {
        genericStaleComponentRemover(this.liveMap, j4, this.byTimeout);
    }

    @Override // ch.qos.logback.core.spi.ComponentTracker
    public Collection<C> allComponents() {
        ArrayList arrayList = new ArrayList();
        Iterator<Entry<C>> it = this.liveMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().component);
        }
        Iterator<Entry<C>> it2 = this.lingerersMap.values().iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().component);
        }
        return arrayList;
    }

    @Override // ch.qos.logback.core.spi.ComponentTracker
    public Set<String> allKeys() {
        HashSet hashSet = new HashSet(this.liveMap.keySet());
        hashSet.addAll(this.lingerersMap.keySet());
        return hashSet;
    }

    public abstract C buildComponent(String str);

    @Override // ch.qos.logback.core.spi.ComponentTracker
    public void endOfLife(String str) {
        Entry<C> entryRemove = this.liveMap.remove(str);
        if (entryRemove == null) {
            return;
        }
        this.lingerersMap.put(str, entryRemove);
    }

    @Override // ch.qos.logback.core.spi.ComponentTracker
    public synchronized C find(String str) {
        Entry<C> fromEitherMap = getFromEitherMap(str);
        if (fromEitherMap == null) {
            return null;
        }
        return fromEitherMap.component;
    }

    @Override // ch.qos.logback.core.spi.ComponentTracker
    public int getComponentCount() {
        return this.lingerersMap.size() + this.liveMap.size();
    }

    public int getMaxComponents() {
        return this.maxComponents;
    }

    @Override // ch.qos.logback.core.spi.ComponentTracker
    public synchronized C getOrCreate(String str, long j4) {
        Entry<C> fromEitherMap;
        try {
            fromEitherMap = getFromEitherMap(str);
            if (fromEitherMap == null) {
                Entry<C> entry = new Entry<>(str, buildComponent(str), j4);
                this.liveMap.put(str, entry);
                fromEitherMap = entry;
            } else {
                fromEitherMap.setTimestamp(j4);
            }
        } catch (Throwable th) {
            throw th;
        }
        return fromEitherMap.component;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public abstract boolean isComponentStale(C c4);

    public abstract void processPriorToRemoval(C c4);

    @Override // ch.qos.logback.core.spi.ComponentTracker
    public synchronized void removeStaleComponents(long j4) {
        if (isTooSoonForRemovalIteration(j4)) {
            return;
        }
        removeExcedentComponents();
        removeStaleComponentsFromMainMap(j4);
        removeStaleComponentsFromLingerersMap(j4);
    }

    public void setMaxComponents(int i4) {
        this.maxComponents = i4;
    }

    public void setTimeout(long j4) {
        this.timeout = j4;
    }
}
