package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class ImmutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
    private final ImmutableMap<TypeToken<? extends B>, B> delegate;

    /* JADX INFO: renamed from: com.google.common.reflect.ImmutableTypeToInstanceMap$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    @Beta
    public static final class Builder<B> {
        private final ImmutableMap.Builder<TypeToken<? extends B>, B> mapBuilder;

        public /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        public ImmutableTypeToInstanceMap<B> build() {
            return new ImmutableTypeToInstanceMap(this.mapBuilder.build(), null);
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> put(Class<T> r10, T r11) {
            this.mapBuilder.put(TypeToken.of(r10), r11);
            return this;
        }

        private Builder() {
            this.mapBuilder = ImmutableMap.builder();
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> put(TypeToken<T> r10, T r11) {
            this.mapBuilder.put(r10.rejectTypeVariables(), r11);
            return this;
        }
    }

    public /* synthetic */ ImmutableTypeToInstanceMap(ImmutableMap r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static <B> Builder<B> builder() {
        return new Builder(null);
    }

    public static <B> ImmutableTypeToInstanceMap<B> of() {
        return new ImmutableTypeToInstanceMap(ImmutableMap.of());
    }

    private <T extends B> T trustedGet(TypeToken<T> r10) {
        return this.delegate.get(r10);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    public <T extends B> T getInstance(TypeToken<T> r10) {
        return (T) trustedGet(r10.rejectTypeVariables());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ Object put(Object r10, Object r11) {
        return put((TypeToken) r10, r11);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CanIgnoreReturnValue
    @Deprecated
    public <T extends B> T putInstance(TypeToken<T> r10, T r11) {
        throw new UnsupportedOperationException();
    }

    private ImmutableTypeToInstanceMap(ImmutableMap<TypeToken<? extends B>, B> r10) {
        this.delegate = r10;
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<TypeToken<? extends B>, B> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    public <T extends B> T getInstance(Class<T> r10) {
        return (T) trustedGet(TypeToken.of(r10));
    }

    @CanIgnoreReturnValue
    @Deprecated
    public B put(TypeToken<? extends B> r10, B r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CanIgnoreReturnValue
    @Deprecated
    public <T extends B> T putInstance(Class<T> r10, T r11) {
        throw new UnsupportedOperationException();
    }
}
