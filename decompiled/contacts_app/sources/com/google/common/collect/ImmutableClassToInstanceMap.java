package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Primitives;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ImmutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
    private final ImmutableMap<Class<? extends B>, B> delegate;

    /* JADX INFO: renamed from: com.google.common.collect.ImmutableClassToInstanceMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder<B> {
        private final ImmutableMap.Builder<Class<? extends B>, B> mapBuilder;

        public Builder() {
            this.mapBuilder = ImmutableMap.builder();
        }

        public <T extends B> Builder<B> put(Class<T> r2, T r3) {
            this.mapBuilder.put(r2, r3);
            return this;
        }

        public <T extends B> Builder<B> putAll(Map<? extends Class<? extends T>, ? extends T> r4) {
            Iterator<Map.Entry<? extends Class<? extends T>, ? extends T>> r5 = r4.entrySet().iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            Map.Entry<? extends Class<? extends T>, ? extends T> r0 = r5.next();
            Class r1 = r0.getKey();
            T r2 = r0.getValue();
            ImmutableMap.Builder<Class<? extends B>, B> r3 = this.mapBuilder;
            Object r6 = cast(r1, r2);
            r3.put((Class<? extends B>) r1, (B) r6);
            goto L4
        L6:
            return this;
        }

        private static <B, T extends B> T cast(Class<T> r0, B r1) {
            return (T) Primitives.wrap(r0).cast(r1);
        }

        public ImmutableClassToInstanceMap<B> build() {
            return new ImmutableClassToInstanceMap(this.mapBuilder.build(), null);
        }
    }

    /* synthetic */ ImmutableClassToInstanceMap(ImmutableMap r1, AnonymousClass1 r2) {
        this(r1);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    public static <B> Builder<B> builder() {
        return new Builder();
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> r1) {
        if ((r1 instanceof ImmutableClassToInstanceMap) == false) goto L7;
        return (ImmutableClassToInstanceMap) r1;
    L7:
        return new Builder().putAll(r1).build();
    }

    private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> r1) {
        this.delegate = r1;
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    @Nullable
    public <T extends B> T getInstance(Class<T> r1) {
        return this.delegate.get(Preconditions.checkNotNull(r1));
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    @Deprecated
    public <T extends B> T putInstance(Class<T> r1, T r2) {
        throw new UnsupportedOperationException();
    }
}
