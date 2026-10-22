package com.google.common.collect;

import com.google.common.primitives.Primitives;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class MutableClassToInstanceMap<B> extends MapConstraints.ConstrainedMap<Class<? extends B>, B> implements ClassToInstanceMap<B> {
    private static final MapConstraint<Class<?>, Object> VALUE_CAN_BE_CAST_TO_KEY = null;
    private static final long serialVersionUID = 0;

    static /* synthetic */ Object access$000(Class r0, Object r1) {
        return cast(r0, r1);
    }

    @Override // com.google.common.collect.MapConstraints.ConstrainedMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.MapConstraints.ConstrainedMap, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ void putAll(Map r1) {
        super.putAll(r1);
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap(new HashMap());
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> r1) {
        return new MutableClassToInstanceMap(r1);
    }

    private MutableClassToInstanceMap(Map<Class<? extends B>, B> r2) {
        super(r2, VALUE_CAN_BE_CAST_TO_KEY);
    }

    static {
        VALUE_CAN_BE_CAST_TO_KEY = new AnonymousClass1();
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    public <T extends B> T putInstance(Class<T> r1, T r2) {
        return (T) cast(r1, put(r1, r2));
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    public <T extends B> T getInstance(Class<T> r1) {
        return (T) cast(r1, get(r1));
    }

    private static <B, T extends B> T cast(Class<T> r0, B r1) {
        return (T) Primitives.wrap(r0).cast(r1);
    }
}
