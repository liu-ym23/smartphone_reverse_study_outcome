package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.camera.core.impl.Config;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class u extends v implements t {

    /* renamed from: U, reason: collision with root package name */
    public static final Config.OptionPriority f11496U = Config.OptionPriority.OPTIONAL;

    public u(TreeMap<Config.a<?>, Map<Config.OptionPriority, Object>> treeMap) {
        super(treeMap);
    }

    public static u k0() {
        return new u(new TreeMap(v.f11535S));
    }

    public static u l0(Config config) {
        TreeMap treeMap = new TreeMap(v.f11535S);
        for (Config.a<?> aVar : config.e()) {
            Set<Config.OptionPriority> setF = config.f(aVar);
            ArrayMap arrayMap = new ArrayMap();
            for (Config.OptionPriority optionPriority : setF) {
                arrayMap.put(optionPriority, config.d(aVar, optionPriority));
            }
            treeMap.put(aVar, arrayMap);
        }
        return new u(treeMap);
    }

    public <ValueT> ValueT m0(Config.a<ValueT> aVar) {
        return (ValueT) this.f11537R.remove(aVar);
    }

    @Override // androidx.camera.core.impl.t
    public <ValueT> void q(Config.a<ValueT> aVar, Config.OptionPriority optionPriority, ValueT valuet) {
        Map<Config.OptionPriority, Object> map = this.f11537R.get(aVar);
        if (map == null) {
            ArrayMap arrayMap = new ArrayMap();
            this.f11537R.put(aVar, arrayMap);
            arrayMap.put(optionPriority, valuet);
            return;
        }
        Config.OptionPriority optionPriority2 = (Config.OptionPriority) Collections.min(map.keySet());
        if (Objects.equals(map.get(optionPriority2), valuet) || !Config.C(optionPriority2, optionPriority)) {
            map.put(optionPriority, valuet);
            return;
        }
        throw new IllegalArgumentException("Option values conflicts: " + aVar.c() + ", existing value (" + optionPriority2 + ")=" + map.get(optionPriority2) + ", conflicting (" + optionPriority + ")=" + valuet);
    }

    @Override // androidx.camera.core.impl.t
    public <ValueT> void t(Config.a<ValueT> aVar, ValueT valuet) {
        q(aVar, f11496U, valuet);
    }
}
