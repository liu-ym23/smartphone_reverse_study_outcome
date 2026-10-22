package com.google.common.reflect;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ImmutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
    private final ImmutableMap<TypeToken<? extends B>, B> delegate;

    /* JADX INFO: renamed from: com.google.common.reflect.ImmutableTypeToInstanceMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder<B> {
        private final ImmutableMap.Builder<TypeToken<? extends B>, B> mapBuilder;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.mapBuilder = ImmutableMap.builder();
        }

        public <T extends B> Builder<B> put(Class<T> r2, T r3) {
            this.mapBuilder.put(TypeToken.of(r2), r3);
            return this;
        }

        public <T extends B> Builder<B> put(TypeToken<T> r2, T r3) {
            this.mapBuilder.put(r2.rejectTypeVariables(), r3);
            return this;
        }

        public ImmutableTypeToInstanceMap<B> build() {
            return new ImmutableTypeToInstanceMap(this.mapBuilder.build(), null);
        }
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    /* synthetic */ ImmutableTypeToInstanceMap(ImmutableMap r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static <B> ImmutableTypeToInstanceMap<B> of() {
        return new ImmutableTypeToInstanceMap(ImmutableMap.of());
    }

    public static <B> Builder<B> builder() {
        return new Builder(null);
    }

    private ImmutableTypeToInstanceMap(ImmutableMap<TypeToken<? extends B>, B> r1) {
        this.delegate = r1;
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    public <T extends B> T getInstance(TypeToken<T> r1) {
        return (T) trustedGet(r1.rejectTypeVariables());
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    public <T extends B> T putInstance(TypeToken<T> r1, T r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    public <T extends B> T getInstance(Class<T> r1) {
        return (T) trustedGet(TypeToken.of(r1));
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    public <T extends B> T putInstance(Class<T> r1, T r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected Map<TypeToken<? extends B>, B> delegate() {
        return this.delegate;
    }

    private <T extends B> T trustedGet(TypeToken<T> r1) {
        return this.delegate.get(r1);
    }
}
