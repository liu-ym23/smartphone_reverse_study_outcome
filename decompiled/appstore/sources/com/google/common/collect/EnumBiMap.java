package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends AbstractBiMap<K, V> {

    @GwtIncompatible
    private static final long serialVersionUID = 0;
    private transient Class<K> keyType;
    private transient Class<V> valueType;

    private EnumBiMap(Class<K> r10, Class<V> r11) {
        super(new EnumMap(r10), new EnumMap(r11));
        this.keyType = r10;
        this.valueType = r11;
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Class<K> r10, Class<V> r11) {
        return new EnumBiMap(r10, r11);
    }

    public static <K extends Enum<K>> Class<K> inferKeyType(Map<K, ?> r10) {
        if ((r10 instanceof EnumBiMap) == false) goto L7;
        return ((EnumBiMap) r10).keyType();
    L7:
        if ((r10 instanceof EnumHashBiMap) == true) goto L9;
        Preconditions.checkArgument(!r10.isEmpty());
        return r10.keySet().iterator().next().getDeclaringClass();
    L9:
        return ((EnumHashBiMap) r10).keyType();
    }

    private static <V extends Enum<V>> Class<V> inferValueType(Map<?, V> r10) {
        if ((r10 instanceof EnumBiMap) == true) goto L5;
        Preconditions.checkArgument(!r10.isEmpty());
        return r10.values().iterator().next().getDeclaringClass();
    L5:
        return ((EnumBiMap) r10).valueType;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        r10.defaultReadObject();
        this.keyType = (Class) r10.readObject();
        this.valueType = (Class) r10.readObject();
        setDelegates(new EnumMap(this.keyType), new EnumMap(this.valueType));
        Serialization.populateMap(this, r10);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream r10) throws IOException {
        r10.defaultWriteObject();
        r10.writeObject(this.keyType);
        r10.writeObject(this.valueType);
        Serialization.writeMap(this, r10);
    }

    @Override // com.google.common.collect.AbstractBiMap
    public /* bridge */ /* synthetic */ Object checkKey(Object r10) {
        return checkKey((Enum) r10);
    }

    @Override // com.google.common.collect.AbstractBiMap
    public /* bridge */ /* synthetic */ Object checkValue(Object r10) {
        return checkValue((Enum) r10);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsValue(@NullableDecl Object r10) {
        return super.containsValue(r10);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ BiMap inverse() {
        return super.inverse();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public Class<K> keyType() {
        return this.keyType;
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ void putAll(Map r10) {
        super.putAll(r10);
    }

    public Class<V> valueType() {
        return this.valueType;
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Map<K, V> r10) {
        EnumBiMap<K, V> r11 = create(inferKeyType(r10), inferValueType(r10));
        r11.putAll(r10);
        return r11;
    }

    public K checkKey(K r10) {
        return (K) Preconditions.checkNotNull(r10);
    }

    public V checkValue(V r10) {
        return (V) Preconditions.checkNotNull(r10);
    }
}
