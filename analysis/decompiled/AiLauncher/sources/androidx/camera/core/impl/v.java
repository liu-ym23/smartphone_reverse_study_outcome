package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.camera.core.impl.Config;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class v implements Config {

    /* renamed from: S, reason: collision with root package name */
    public static final Comparator<Config.a<?>> f11535S;

    /* renamed from: T, reason: collision with root package name */
    public static final v f11536T;

    /* renamed from: R, reason: collision with root package name */
    public final TreeMap<Config.a<?>, Map<Config.OptionPriority, Object>> f11537R;

    static {
        Comparator<Config.a<?>> comparator = new Comparator() { // from class: K.q0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Config.a) obj).c().compareTo(((Config.a) obj2).c());
            }
        };
        f11535S = comparator;
        f11536T = new v(new TreeMap(comparator));
    }

    public v(TreeMap<Config.a<?>, Map<Config.OptionPriority, Object>> treeMap) {
        this.f11537R = treeMap;
    }

    public static v i0() {
        return f11536T;
    }

    public static v j0(Config config) {
        if (v.class.equals(config.getClass())) {
            return (v) config;
        }
        TreeMap treeMap = new TreeMap(f11535S);
        for (Config.a<?> aVar : config.e()) {
            Set<Config.OptionPriority> setF = config.f(aVar);
            ArrayMap arrayMap = new ArrayMap();
            for (Config.OptionPriority optionPriority : setF) {
                arrayMap.put(optionPriority, config.d(aVar, optionPriority));
            }
            treeMap.put(aVar, arrayMap);
        }
        return new v(treeMap);
    }

    @Override // androidx.camera.core.impl.Config
    public <ValueT> ValueT a(Config.a<ValueT> aVar) {
        Map<Config.OptionPriority, Object> map = this.f11537R.get(aVar);
        if (map != null) {
            return (ValueT) map.get((Config.OptionPriority) Collections.min(map.keySet()));
        }
        throw new IllegalArgumentException("Option does not exist: " + aVar);
    }

    @Override // androidx.camera.core.impl.Config
    public boolean b(Config.a<?> aVar) {
        return this.f11537R.containsKey(aVar);
    }

    @Override // androidx.camera.core.impl.Config
    public void c(String str, Config.b bVar) {
        for (Map.Entry<Config.a<?>, Map<Config.OptionPriority, Object>> entry : this.f11537R.tailMap(Config.a.a(str, Void.class)).entrySet()) {
            if (!entry.getKey().c().startsWith(str) || !bVar.a(entry.getKey())) {
                return;
            }
        }
    }

    @Override // androidx.camera.core.impl.Config
    public <ValueT> ValueT d(Config.a<ValueT> aVar, Config.OptionPriority optionPriority) {
        Map<Config.OptionPriority, Object> map = this.f11537R.get(aVar);
        if (map == null) {
            throw new IllegalArgumentException("Option does not exist: " + aVar);
        }
        if (map.containsKey(optionPriority)) {
            return (ValueT) map.get(optionPriority);
        }
        throw new IllegalArgumentException("Option does not exist: " + aVar + " with priority=" + optionPriority);
    }

    @Override // androidx.camera.core.impl.Config
    public Set<Config.a<?>> e() {
        return Collections.unmodifiableSet(this.f11537R.keySet());
    }

    @Override // androidx.camera.core.impl.Config
    public Set<Config.OptionPriority> f(Config.a<?> aVar) {
        Map<Config.OptionPriority, Object> map = this.f11537R.get(aVar);
        return map == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(map.keySet());
    }

    @Override // androidx.camera.core.impl.Config
    public <ValueT> ValueT g(Config.a<ValueT> aVar, ValueT valuet) {
        Map<Config.OptionPriority, Object> map = this.f11537R.get(aVar);
        return map == null ? valuet : (ValueT) map.get((Config.OptionPriority) Collections.min(map.keySet()));
    }

    @Override // androidx.camera.core.impl.Config
    public Config.OptionPriority h(Config.a<?> aVar) {
        Map<Config.OptionPriority, Object> map = this.f11537R.get(aVar);
        if (map != null) {
            return (Config.OptionPriority) Collections.min(map.keySet());
        }
        throw new IllegalArgumentException("Option does not exist: " + aVar);
    }
}
