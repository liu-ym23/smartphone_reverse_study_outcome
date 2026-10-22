package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Immutable(containerOf = {"B"})
@GwtIncompatible
public final class ImmutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
    private static final ImmutableClassToInstanceMap<Object> EMPTY = null;
    private final ImmutableMap<Class<? extends B>, B> delegate;

    /* JADX INFO: renamed from: com.google.common.collect.ImmutableClassToInstanceMap$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder<B> {
        private final ImmutableMap.Builder<Class<? extends B>, B> mapBuilder;

        public Builder() {
            this.mapBuilder = ImmutableMap.builder();
        }

        private static <B, T extends B> T cast(Class<T> r10, B r11) {
            return (T) Primitives.wrap(r10).cast(r11);
        }

        public ImmutableClassToInstanceMap<B> build() {
            ImmutableMap<Class<? extends B>, B> r10 = this.mapBuilder.build();
            if (r10.isEmpty() == false) goto L7;
            return ImmutableClassToInstanceMap.of();
        L7:
            return new ImmutableClassToInstanceMap(r10, null);
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> put(Class<T> r10, T r11) {
            this.mapBuilder.put(r10, r11);
            return this;
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> putAll(Map<? extends Class<? extends T>, ? extends T> r10) {
            Iterator<Map.Entry<? extends Class<? extends T>, ? extends T>> r11 = r10.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry<? extends Class<? extends T>, ? extends T> r12 = r11.next();
            Class r13 = r12.getKey();
            T r14 = r12.getValue();
            ImmutableMap.Builder<Class<? extends B>, B> r15 = this.mapBuilder;
            Object r16 = cast(r13, r14);
            r15.put((Class<? extends B>) r13, (B) r16);
            goto L4
        L6:
            return this;
        }
    }

    static {
        EMPTY = new ImmutableClassToInstanceMap(ImmutableMap.of());
    }

    public /* synthetic */ ImmutableClassToInstanceMap(ImmutableMap r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static <B> Builder<B> builder() {
        return new Builder();
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> r10) {
        if ((r10 instanceof ImmutableClassToInstanceMap) == false) goto L7;
        return (ImmutableClassToInstanceMap) r10;
    L7:
        return new Builder().putAll(r10).build();
    }

    public static <B> ImmutableClassToInstanceMap<B> of() {
        return (ImmutableClassToInstanceMap<B>) EMPTY;
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    @NullableDecl
    public <T extends B> T getInstance(Class<T> r10) {
        return this.delegate.get(Preconditions.checkNotNull(r10));
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    @CanIgnoreReturnValue
    @Deprecated
    public <T extends B> T putInstance(Class<T> r10, T r11) {
        throw new UnsupportedOperationException();
    }

    public Object readResolve() {
        if (isEmpty() == true) goto L5;
        return this;
    L5:
        return of();
    }

    private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> r10) {
        this.delegate = r10;
    }

    public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> r10, T r11) {
        return new ImmutableClassToInstanceMap(ImmutableMap.of(r10, r11));
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }
}
