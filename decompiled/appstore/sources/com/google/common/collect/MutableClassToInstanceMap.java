package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final class MutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
    private final Map<Class<? extends B>, B> delegate;

    public static final class SerializedForm<B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Map<Class<? extends B>, B> backingMap;

        public SerializedForm(Map<Class<? extends B>, B> r10) {
            this.backingMap = r10;
        }

        public Object readResolve() {
            return MutableClassToInstanceMap.create(this.backingMap);
        }
    }

    private MutableClassToInstanceMap(Map<Class<? extends B>, B> r10) {
        this.delegate = (Map) Preconditions.checkNotNull(r10);
    }

    public static /* synthetic */ Object access$000(Class r10, Object r11) {
        return cast(r10, r11);
    }

    @CanIgnoreReturnValue
    private static <B, T extends B> T cast(Class<T> r10, B r11) {
        return (T) Primitives.wrap(r10).cast(r11);
    }

    public static <B> Map.Entry<Class<? extends B>, B> checkedEntry(final Map.Entry<Class<? extends B>, B> r10) {
        return new AnonymousClass1(r10);
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap(new HashMap());
    }

    private Object writeReplace() {
        return new SerializedForm(delegate());
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new AnonymousClass2(this);
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    public <T extends B> T getInstance(Class<T> r10) {
        return (T) cast(r10, get(r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object put(Object r10, Object r11) {
        return put((Class) r10, r11);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public void putAll(Map<? extends Class<? extends B>, ? extends B> r10) {
        LinkedHashMap r11 = new LinkedHashMap(r10);
        Iterator r12 = r11.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry r13 = (Map.Entry) r12.next();
        cast((Class) r13.getKey(), r13.getValue());
        goto L4
    L6:
        super.putAll(r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ClassToInstanceMap
    @CanIgnoreReturnValue
    public <T extends B> T putInstance(Class<T> r10, T r11) {
        return (T) cast(r10, put(r10, r11));
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> r10) {
        return new MutableClassToInstanceMap(r10);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    @CanIgnoreReturnValue
    public B put(Class<? extends B> r10, B r11) {
        return (B) super.put(r10, cast(r10, r11));
    }
}
