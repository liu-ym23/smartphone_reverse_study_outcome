package com.android.server.display.plugin;

import android.util.Slog;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class PluginStorage {
    static final String GLOBAL_ID = "GLOBAL";
    private static final String TAG = "PluginStorage";
    private final Set<PluginType<?>> mEnabledTypes;
    private final Map<PluginType<?>, ListenersContainer<?>> mListeners;
    private final Object mLock;
    private final Map<String, PluginEventStorage> mPluginEventStorages;
    private final Map<PluginType<?>, ValuesContainer<?>> mValues;

    private static final class ListenersContainer<T> {
        private final Map<String, Set<PluginManager.PluginChangeListener<T>>> mListeners;

        public static /* synthetic */ Set $r8$lambda$8J1D9eKOUj6h71CCHekepdYyQMU(String r0) {
            return lambda$addListenerLocked$0(r0);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmListeners, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m4144$$Nest$fgetmListeners(ListenersContainer r0) {
            return r0.mListeners;
        }

        /* JADX INFO: renamed from: -$$Nest$maddListenerLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m4145$$Nest$maddListenerLocked(ListenersContainer r0, String r1, PluginManager.PluginChangeListener r2) {
            return r0.addListenerLocked(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mremoveListenerLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4146$$Nest$mremoveListenerLocked(ListenersContainer r0, String r1, PluginManager.PluginChangeListener r2) {
            r0.removeListenerLocked(r1, r2);
        }

        /* synthetic */ ListenersContainer(PluginStorageIA r1) {
            this();
        }

        private ListenersContainer() {
            this.mListeners = new LinkedHashMap();
        }

        private boolean addListenerLocked(String uniqueDisplayId, PluginManager.PluginChangeListener<T> listener) {
            Set<PluginManager.PluginChangeListener<T>> listenersForDisplay = this.mListeners.computeIfAbsent(uniqueDisplayId, new PluginStorage$ListenersContainer$$ExternalSyntheticLambda0());
            return listenersForDisplay.add(listener);
        }

        private static /* synthetic */ Set lambda$addListenerLocked$0(String k) {
            return new LinkedHashSet();
        }

        private void removeListenerLocked(String uniqueDisplayId, PluginManager.PluginChangeListener<T> listener) {
            Set<PluginManager.PluginChangeListener<T>> listenersForDisplay = this.mListeners.get(uniqueDisplayId);
            if (listenersForDisplay != null) goto L5;
            return;
        L5:
            listenersForDisplay.remove(listener);
            if (listenersForDisplay.isEmpty() == false) goto L9;
            this.mListeners.remove(uniqueDisplayId);
            return;
        }
    }

    private static final class ValuesContainer<T> {
        private final Map<String, T> mValues;

        /* JADX INFO: renamed from: -$$Nest$fgetmValues, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m4147$$Nest$fgetmValues(ValuesContainer r0) {
            return r0.mValues;
        }

        /* JADX INFO: renamed from: -$$Nest$mgetNonGlobalDisplaysLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ Set m4148$$Nest$mgetNonGlobalDisplaysLocked(ValuesContainer r0) {
            return r0.getNonGlobalDisplaysLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetValueLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ Object m4149$$Nest$mgetValueLocked(ValuesContainer r0, String r1) {
            return r0.getValueLocked(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateValueLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4150$$Nest$mupdateValueLocked(ValuesContainer r0, String r1, Object r2) {
            r0.updateValueLocked(r1, r2);
        }

        /* synthetic */ ValuesContainer(PluginStorageIA r1) {
            this();
        }

        private ValuesContainer() {
            this.mValues = new HashMap();
        }

        private void updateValueLocked(String uniqueDisplayId, T value) {
            if (value != null) goto L4;
            this.mValues.remove(uniqueDisplayId);
            return;
        L4:
            this.mValues.put(uniqueDisplayId, value);
        }

        private Set<String> getNonGlobalDisplaysLocked() {
            Set<String> keys = new HashSet(this.mValues.keySet());
            keys.remove(PluginStorage.GLOBAL_ID);
            return keys;
        }

        private T getValueLocked(String r4) {
            return (T) this.mValues.getOrDefault(r4, this.mValues.get(PluginStorage.GLOBAL_ID));
        }
    }

    public static /* synthetic */ void $r8$lambda$4NHpfRXNSqkyR96RLPGoHeG_OGc(Object r0, PluginManager.PluginChangeListener r1) {
        lambda$updateValue$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$7xBCmlHDr7uu0vLhFjyfPldxcU4(Map r0, PluginType r1, ListenersContainer r2) {
        lambda$dump$5(r0, r1, r2);
    }

    public static /* synthetic */ PluginEventStorage $r8$lambda$JPyfKrTJKUXeM22epagmQ5vWvYk(String r0) {
        return lambda$updateValue$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$ZNHg48vVXUJO_sfoVRF99TeZVfQ(Set r0, Set r1, String r2, Set r3) {
        lambda$getListenersForUpdateLocked$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$qNwLvSRZ35HnWhFOq_w2xbndio4(Map r0, String r1, PluginEventStorage r2) {
        lambda$dump$3(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$yLyukOKWn1ZeoT9KYUV67YzOHvM(Map r0, PluginType r1, ValuesContainer r2) {
        lambda$dump$4(r0, r1, r2);
    }

    public <T> void updateGlobalValue(PluginType<T> type, T value) {
        updateValue(type, GLOBAL_ID, value);
    }

    PluginStorage(Set<PluginType<?>> enabledTypes) {
        this.mLock = new Object();
        this.mValues = new HashMap();
        this.mListeners = new HashMap();
        this.mPluginEventStorages = new HashMap();
        this.mEnabledTypes = Collections.unmodifiableSet(enabledTypes);
    }

    public <T> void updateValue(PluginType<T> type, String uniqueDisplayId, T value) {
        if (isTypeDisabled(type) == false) goto L6;
        Slog.d(TAG, "updateValue ignored for disabled type=" + type.mName);
        return;
    L6:
        Slog.d(TAG, "updateValue, type=" + type.mName + "; value=" + value + "; displayId=" + uniqueDisplayId);
        Object r0 = this.mLock;
        monitor-enter(r0);
        ValuesContainer<T> valuesByType = getValuesContainerLocked(type);     // Catch: Throwable -> L12
        ValuesContainer.m4150$$Nest$mupdateValueLocked(valuesByType, uniqueDisplayId, value);     // Catch: Throwable -> L12
        final Object r2 = ValuesContainer.m4149$$Nest$mgetValueLocked(valuesByType, uniqueDisplayId);     // Catch: Throwable -> L12
        PluginEventStorage storage = this.mPluginEventStorages.computeIfAbsent(uniqueDisplayId, new PluginStorage$$ExternalSyntheticLambda0());     // Catch: Throwable -> L12
        storage.onValueUpdated(type);     // Catch: Throwable -> L12
        Set<PluginManager.PluginChangeListener<T>> localListeners = getListenersForUpdateLocked(type, uniqueDisplayId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        Slog.d(TAG, "updateValue, notifying listeners=" + localListeners);
        localListeners.forEach(new PluginStorage$$ExternalSyntheticLambda1(r2));
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ PluginEventStorage lambda$updateValue$0(String d) {
        return new PluginEventStorage();
    }

    private static /* synthetic */ void lambda$updateValue$1(Object valueToNotify, PluginManager.PluginChangeListener l) {
        l.onChanged(valueToNotify);
    }

    private <T> Set<PluginManager.PluginChangeListener<T>> getListenersForUpdateLocked(PluginType<T> type, String uniqueDisplayId) {
        ListenersContainer<T> listenersContainer = getListenersContainerLocked(type);
        final Set<PluginManager.PluginChangeListener<T>> localListeners = new LinkedHashSet();
        if (GLOBAL_ID.equals(uniqueDisplayId) == false) goto L5;
        ValuesContainer<T> valuesContainer = getValuesContainerLocked(type);
        final Set<String> excludedDisplayIds = ValuesContainer.m4148$$Nest$mgetNonGlobalDisplaysLocked(valuesContainer);
        ListenersContainer.m4144$$Nest$fgetmListeners(listenersContainer).forEach(new PluginStorage$$ExternalSyntheticLambda5(excludedDisplayIds, localListeners));
    L6:
        return localListeners;
    L5:
        localListeners.addAll((Collection) ListenersContainer.m4144$$Nest$fgetmListeners(listenersContainer).getOrDefault(uniqueDisplayId, Set.of()));
        goto L6
    }

    private static /* synthetic */ void lambda$getListenersForUpdateLocked$2(Set excludedDisplayIds, Set localListeners, String localDisplayId, Set listeners) {
        if (excludedDisplayIds.contains(localDisplayId) == true) goto L6;
        localListeners.addAll(listeners);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T> void addListener(PluginType<T> type, String uniqueDisplayId, PluginManager.PluginChangeListener<T> r8) {
        if (isTypeDisabled(type) == false) goto L7;
        Slog.d(TAG, "addListener ignored for disabled type=" + type.mName);
        return;
    L7:
        if (GLOBAL_ID.equals(uniqueDisplayId) == false) goto L10;
        Slog.d(TAG, "addListener ignored for GLOBAL_ID, type=" + type.mName);
        return;
    L10:
        Object r0 = null;
        Object r1 = this.mLock;
        monitor-enter(r1);
        ListenersContainer<T> container = getListenersContainerLocked(type);     // Catch: Throwable -> L15
        if (ListenersContainer.m4145$$Nest$maddListenerLocked(container, uniqueDisplayId, r8) == false) goto L17;
        ValuesContainer<T> valuesContainer = getValuesContainerLocked(type);     // Catch: Throwable -> L15
        r0 = ValuesContainer.m4149$$Nest$mgetValueLocked(valuesContainer, uniqueDisplayId);     // Catch: Throwable -> L15
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L15
        if (r0 == null) goto L25;
        r8.onChanged(r0);
        return;
    L25:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    <T> void removeListener(PluginType<T> type, String uniqueDisplayId, PluginManager.PluginChangeListener<T> listener) {
        if (isTypeDisabled(type) == false) goto L7;
        Slog.d(TAG, "removeListener ignored for disabled type=" + type.mName);
        return;
    L7:
        if (GLOBAL_ID.equals(uniqueDisplayId) == false) goto L10;
        Slog.d(TAG, "removeListener ignored for GLOBAL_ID, type=" + type.mName);
        return;
    L10:
        Object r0 = this.mLock;
        monitor-enter(r0);
        ListenersContainer<T> container = getListenersContainerLocked(type);     // Catch: Throwable -> L15
        ListenersContainer.m4146$$Nest$mremoveListenerLocked(container, uniqueDisplayId, listener);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    void dump(PrintWriter pw) {
        final Map<PluginType<?>, Map<String, Object>> localValues = new HashMap();
        final Map<PluginType, Map<String, Set>> localListeners = new HashMap();
        final Map<String, List<PluginEventStorage.TimeFrame>> timeFrames = new HashMap();
        Object r3 = this.mLock;
        monitor-enter(r3);
        this.mPluginEventStorages.forEach(new PluginStorage$$ExternalSyntheticLambda2(timeFrames));     // Catch: Throwable -> L15
        this.mValues.forEach(new PluginStorage$$ExternalSyntheticLambda3(localValues));     // Catch: Throwable -> L15
        this.mListeners.forEach(new PluginStorage$$ExternalSyntheticLambda4(localListeners));     // Catch: Throwable -> L15
        monitor-exit(r3);     // Catch: Throwable -> L15
        pw.println("PluginStorage:");
        pw.println("values=" + localValues);
        pw.println("listeners=" + localListeners);
        pw.println("PluginEventStorage:");
        Iterator<Map.Entry<String, List<PluginEventStorage.TimeFrame>>> r4 = timeFrames.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        Map.Entry<String, List<PluginEventStorage.TimeFrame>> timeFrameEntry = r4.next();
        pw.println("TimeFrames for displayId=" + timeFrameEntry.getKey());
        Iterator<PluginEventStorage.TimeFrame> r5 = timeFrameEntry.getValue().iterator();
    L11:
        if (r5.hasNext() == false) goto L8;
        PluginEventStorage.TimeFrame timeFrame = r5.next();
        timeFrame.dump(pw);
        goto L11
    L14:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$dump$3(Map timeFrames, String displayId, PluginEventStorage storage) {
        timeFrames.put(displayId, storage.getTimeFrames());
    }

    private static /* synthetic */ void lambda$dump$4(Map localValues, PluginType type, ValuesContainer valueContainer) {
        localValues.put(type, new HashMap(ValuesContainer.m4147$$Nest$fgetmValues(valueContainer)));
    }

    private static /* synthetic */ void lambda$dump$5(Map localListeners, PluginType type, ListenersContainer container) {
        localListeners.put(type, new HashMap(ListenersContainer.m4144$$Nest$fgetmListeners(container)));
    }

    private boolean isTypeDisabled(PluginType<?> type) {
        return !this.mEnabledTypes.contains(type);
    }

    private <T> ListenersContainer<T> getListenersContainerLocked(PluginType<T> type) {
        ListenersContainer<T> r0 = (ListenersContainer) this.mListeners.get(type);
        if (r0 != null) goto L6;
        ListenersContainer<T> lc = new ListenersContainer(null);
        this.mListeners.put(type, lc);
        return lc;
    L6:
        return r0;
    }

    private <T> ValuesContainer<T> getValuesContainerLocked(PluginType<T> type) {
        ValuesContainer<T> r0 = (ValuesContainer) this.mValues.get(type);
        if (r0 != null) goto L6;
        ValuesContainer<T> vc = new ValuesContainer(null);
        this.mValues.put(type, vc);
        return vc;
    L6:
        return r0;
    }
}
