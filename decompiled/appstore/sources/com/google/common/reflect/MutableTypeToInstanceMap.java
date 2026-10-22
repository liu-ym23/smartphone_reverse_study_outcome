package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class MutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
    private final Map<TypeToken<? extends B>, B> backingMap;

    /* JADX INFO: renamed from: com.google.common.reflect.MutableTypeToInstanceMap$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class UnmodifiableEntry<K, V> extends ForwardingMapEntry<K, V> {
        private final Map.Entry<K, V> delegate;

        public /* synthetic */ UnmodifiableEntry(Map.Entry r10, AnonymousClass1 r11) {
            this(r10);
        }

        public static /* synthetic */ Iterator access$000(Iterator r10) {
            return transformEntries(r10);
        }

        public static <K, V> Set<Map.Entry<K, V>> transformEntries(final Set<Map.Entry<K, V>> r10) {
            return new AnonymousClass1(r10);
        }

        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
        public V setValue(V r10) {
            throw new UnsupportedOperationException();
        }

        private UnmodifiableEntry(Map.Entry<K, V> r10) {
            this.delegate = (Map.Entry) Preconditions.checkNotNull(r10);
        }

        private static <K, V> Iterator<Map.Entry<K, V>> transformEntries(Iterator<Map.Entry<K, V>> r10) {
            return Iterators.transform(r10, new AnonymousClass2());
        }

        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        public Map.Entry<K, V> delegate() {
            return this.delegate;
        }
    }

    public MutableTypeToInstanceMap() {
        this.backingMap = Maps.newHashMap();
    }

    @NullableDecl
    private <T extends B> T trustedGet(TypeToken<T> r10) {
        return this.backingMap.get(r10);
    }

    @NullableDecl
    private <T extends B> T trustedPut(TypeToken<T> r10, @NullableDecl T r11) {
        return this.backingMap.put(r10, r11);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<TypeToken<? extends B>, B>> entrySet() {
        return UnmodifiableEntry.transformEntries(super.entrySet());
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @NullableDecl
    public <T extends B> T getInstance(Class<T> r10) {
        return (T) trustedGet(TypeToken.of(r10));
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
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CanIgnoreReturnValue
    @NullableDecl
    public <T extends B> T putInstance(Class<T> r10, @NullableDecl T r11) {
        return (T) trustedPut(TypeToken.of(r10), r11);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<TypeToken<? extends B>, B> delegate() {
        return this.backingMap;
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @NullableDecl
    public <T extends B> T getInstance(TypeToken<T> r10) {
        return (T) trustedGet(r10.rejectTypeVariables());
    }

    @CanIgnoreReturnValue
    @Deprecated
    public B put(TypeToken<? extends B> r10, B r11) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CanIgnoreReturnValue
    @NullableDecl
    public <T extends B> T putInstance(TypeToken<T> r10, @NullableDecl T r11) {
        return (T) trustedPut(r10.rejectTypeVariables(), r11);
    }
}
