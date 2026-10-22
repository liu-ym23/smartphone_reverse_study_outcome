package androidx.datastore.preferences.core;

import D7.v;
import androidx.datastore.preferences.core.Preferences;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\r\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000e\u0010\fJ$\u0010\u0012\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J&\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J,\u0010\u001a\u001a\u00020\n\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0019\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001d\u001a\u00020\n2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u001c\u0010\u001bJ\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u001f\u0010 J\u001c\u0010\u001f\u001a\u00020\n2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030!H\u0086\u0002¢\u0006\u0004\b\u001f\u0010#J\u001c\u0010$\u001a\u00020\n2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0086\u0002¢\u0006\u0004\b$\u0010%J)\u0010(\u001a\u00020\n2\u001a\u0010'\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030!0&\"\u0006\u0012\u0002\b\u00030!¢\u0006\u0004\b(\u0010)J!\u0010*\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b*\u0010\u0015J\r\u0010+\u001a\u00020\n¢\u0006\u0004\b+\u0010\fJ\u001a\u0010-\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104R*\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u00105\u001a\u0004\b6\u0010\u0018R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006:"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "Landroidx/datastore/preferences/core/Preferences;", "", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "preferencesMap", "", "startFrozen", AppAgent.CONSTRUCT, "(Ljava/util/Map;Z)V", "LC7/r;", "checkNotFrozen$datastore_preferences_core", "()V", "checkNotFrozen", "freeze$datastore_preferences_core", "freeze", ExifInterface.GPS_DIRECTION_TRUE, "key", "contains", "(Landroidx/datastore/preferences/core/Preferences$Key;)Z", "get", "(Landroidx/datastore/preferences/core/Preferences$Key;)Ljava/lang/Object;", "", "asMap", "()Ljava/util/Map;", "value", "set", "(Landroidx/datastore/preferences/core/Preferences$Key;Ljava/lang/Object;)V", "setUnchecked$datastore_preferences_core", "setUnchecked", "prefs", "plusAssign", "(Landroidx/datastore/preferences/core/Preferences;)V", "Landroidx/datastore/preferences/core/Preferences$Pair;", "pair", "(Landroidx/datastore/preferences/core/Preferences$Pair;)V", "minusAssign", "(Landroidx/datastore/preferences/core/Preferences$Key;)V", "", "pairs", "putAll", "([Landroidx/datastore/preferences/core/Preferences$Pair;)V", "remove", "clear", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/Map;", "getPreferencesMap$datastore_preferences_core", "Ljava/util/concurrent/atomic/AtomicBoolean;", "frozen", "Ljava/util/concurrent/atomic/AtomicBoolean;", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class MutablePreferences extends Preferences {
    private final AtomicBoolean frozen;
    private final Map<Preferences.Key<?>, Object> preferencesMap;

    /* JADX WARN: Multi-variable type inference failed */
    public MutablePreferences() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public Map<Preferences.Key<?>, Object> asMap() {
        Map<Preferences.Key<?>, Object> mapUnmodifiableMap = Collections.unmodifiableMap(this.preferencesMap);
        k.e(mapUnmodifiableMap, "unmodifiableMap(preferencesMap)");
        return mapUnmodifiableMap;
    }

    public final void checkNotFrozen$datastore_preferences_core() {
        if (this.frozen.get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public final void clear() {
        checkNotFrozen$datastore_preferences_core();
        this.preferencesMap.clear();
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public <T> boolean contains(Preferences.Key<T> key) {
        k.f(key, "key");
        return this.preferencesMap.containsKey(key);
    }

    public boolean equals(Object other) {
        if (other instanceof MutablePreferences) {
            return k.b(this.preferencesMap, ((MutablePreferences) other).preferencesMap);
        }
        return false;
    }

    public final void freeze$datastore_preferences_core() {
        this.frozen.set(true);
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public <T> T get(Preferences.Key<T> key) {
        k.f(key, "key");
        return (T) this.preferencesMap.get(key);
    }

    public final Map<Preferences.Key<?>, Object> getPreferencesMap$datastore_preferences_core() {
        return this.preferencesMap;
    }

    public int hashCode() {
        return this.preferencesMap.hashCode();
    }

    public final void minusAssign(Preferences.Key<?> key) {
        k.f(key, "key");
        checkNotFrozen$datastore_preferences_core();
        remove(key);
    }

    public final void plusAssign(Preferences prefs) {
        k.f(prefs, "prefs");
        checkNotFrozen$datastore_preferences_core();
        this.preferencesMap.putAll(prefs.asMap());
    }

    public final void putAll(Preferences.Pair<?>... pairs) {
        k.f(pairs, "pairs");
        checkNotFrozen$datastore_preferences_core();
        for (Preferences.Pair<?> pair : pairs) {
            setUnchecked$datastore_preferences_core(pair.getKey$datastore_preferences_core(), pair.getValue$datastore_preferences_core());
        }
    }

    public final <T> T remove(Preferences.Key<T> key) {
        k.f(key, "key");
        checkNotFrozen$datastore_preferences_core();
        return (T) this.preferencesMap.remove(key);
    }

    public final <T> void set(Preferences.Key<T> key, T value) {
        k.f(key, "key");
        setUnchecked$datastore_preferences_core(key, value);
    }

    public final void setUnchecked$datastore_preferences_core(Preferences.Key<?> key, Object value) {
        k.f(key, "key");
        checkNotFrozen$datastore_preferences_core();
        if (value == null) {
            remove(key);
            return;
        }
        if (!(value instanceof Set)) {
            this.preferencesMap.put(key, value);
            return;
        }
        Map<Preferences.Key<?>, Object> map = this.preferencesMap;
        Set setUnmodifiableSet = Collections.unmodifiableSet(v.j1((Iterable) value));
        k.e(setUnmodifiableSet, "unmodifiableSet(value.toSet())");
        map.put(key, setUnmodifiableSet);
    }

    public String toString() {
        return v.I0(this.preferencesMap.entrySet(), ",\n", "{\n", "\n}", new S7.k() { // from class: androidx.datastore.preferences.core.MutablePreferences.toString.1
            @Override // S7.k
            public final CharSequence invoke(Map.Entry<Preferences.Key<?>, Object> entry) {
                k.f(entry, "entry");
                return "  " + entry.getKey().getName() + " = " + entry.getValue();
            }
        }, 24);
    }

    public /* synthetic */ MutablePreferences(Map map, boolean z10, int i, e eVar) {
        this((i & 1) != 0 ? new LinkedHashMap() : map, (i & 2) != 0 ? true : z10);
    }

    public final void plusAssign(Preferences.Pair<?> pair) {
        k.f(pair, "pair");
        checkNotFrozen$datastore_preferences_core();
        putAll(pair);
    }

    public MutablePreferences(Map<Preferences.Key<?>, Object> preferencesMap, boolean z10) {
        k.f(preferencesMap, "preferencesMap");
        this.preferencesMap = preferencesMap;
        this.frozen = new AtomicBoolean(z10);
    }
}
