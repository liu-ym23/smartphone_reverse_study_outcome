package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class MapField<K, V> extends MapFieldReflectionAccessor implements MutabilityOracle {
    private final Converter<K, V> converter;
    private volatile boolean isMutable;
    private List<Message> listData;
    private MutabilityAwareMap<K, V> mapData;
    private volatile StorageMode mode;

    private interface Converter<K, V> {
        Message convertKeyAndValueToMessage(K r1, V r2);

        void convertMessageToKeyAndValue(Message r1, Map<K, V> r2);

        Message getMessageDefaultInstance();
    }

    private static class ImmutableMessageConverter<K, V> implements Converter<K, V> {
        private final MapEntry<K, V> defaultEntry;

        public ImmutableMessageConverter(MapEntry<K, V> r1) {
            this.defaultEntry = r1;
        }

        @Override // com.google.protobuf.MapField.Converter
        public Message convertKeyAndValueToMessage(K r1, V r2) {
            return this.defaultEntry.newBuilderForType().setKey(r1).setValue(r2).buildPartial();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.MapField.Converter
        public void convertMessageToKeyAndValue(Message r2, Map<K, V> r3) {
            Message r1 = (Message) ZeusTransformUtils.wrapperContextForParams(r2, Message.class, "com.obric.aiagent.plugin");
            Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            MapEntry r5 = (MapEntry) ZeusTransformUtils.preCheckCast(r1, MapEntry.class, "com.obric.aiagent.plugin");
            r4.put(r5.getKey(), r5.getValue());
        }

        @Override // com.google.protobuf.MapField.Converter
        public Message getMessageDefaultInstance() {
            return this.defaultEntry;
        }
    }

    static class MutabilityAwareMap<K, V> implements Map<K, V> {
        private final Map<K, V> delegate;
        private final MutabilityOracle mutabilityOracle;

        private static class MutabilityAwareCollection<E> implements Collection<E> {
            private final Collection<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            MutabilityAwareCollection(MutabilityOracle r3, Collection<E> r4) {
                MutabilityOracle r5 = (MutabilityOracle) ZeusTransformUtils.wrapperContextForParams(r3, MutabilityOracle.class, "com.obric.aiagent.plugin");
                Collection<E> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
                this.mutabilityOracle = r5;
                this.delegate = r6;
            }

            @Override // java.util.Collection
            public int size() {
                return this.delegate.size();
            }

            @Override // java.util.Collection
            public boolean isEmpty() {
                return this.delegate.isEmpty();
            }

            @Override // java.util.Collection
            public boolean contains(Object r1) {
                return this.delegate.contains(r1);
            }

            @Override // java.util.Collection, java.lang.Iterable
            public Iterator<E> iterator() {
                return new MutabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
            }

            @Override // java.util.Collection
            public Object[] toArray() {
                return this.delegate.toArray();
            }

            @Override // java.util.Collection
            public <T> T[] toArray(T[] r1) {
                return (T[]) this.delegate.toArray(r1);
            }

            @Override // java.util.Collection
            public boolean add(E r1) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public boolean remove(Object r2) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.remove(r2);
            }

            @Override // java.util.Collection
            public boolean containsAll(Collection<?> r3) {
                Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
                return this.delegate.containsAll(r4);
            }

            @Override // java.util.Collection
            public boolean addAll(Collection<? extends E> r2) {
                Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public boolean removeAll(Collection<?> r3) {
                Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
                this.mutabilityOracle.ensureMutable();
                return this.delegate.removeAll(r4);
            }

            @Override // java.util.Collection
            public boolean retainAll(Collection<?> r3) {
                Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
                this.mutabilityOracle.ensureMutable();
                return this.delegate.retainAll(r4);
            }

            @Override // java.util.Collection
            public void clear() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.clear();
            }

            @Override // java.util.Collection
            public boolean equals(Object r1) {
                return this.delegate.equals(r1);
            }

            @Override // java.util.Collection
            public int hashCode() {
                return this.delegate.hashCode();
            }

            public String toString() {
                return this.delegate.toString();
            }
        }

        private static class MutabilityAwareIterator<E> implements Iterator<E> {
            private final Iterator<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            MutabilityAwareIterator(MutabilityOracle r3, Iterator<E> r4) {
                MutabilityOracle r5 = (MutabilityOracle) ZeusTransformUtils.wrapperContextForParams(r3, MutabilityOracle.class, "com.obric.aiagent.plugin");
                Iterator<E> r6 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.aiagent.plugin");
                this.mutabilityOracle = r5;
                this.delegate = r6;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.delegate.hasNext();
            }

            @Override // java.util.Iterator
            public E next() {
                return this.delegate.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.remove();
            }

            public boolean equals(Object r1) {
                return this.delegate.equals(r1);
            }

            public int hashCode() {
                return this.delegate.hashCode();
            }

            public String toString() {
                return this.delegate.toString();
            }
        }

        private static class MutabilityAwareSet<E> implements Set<E> {
            private final Set<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            MutabilityAwareSet(MutabilityOracle r3, Set<E> r4) {
                MutabilityOracle r5 = (MutabilityOracle) ZeusTransformUtils.wrapperContextForParams(r3, MutabilityOracle.class, "com.obric.aiagent.plugin");
                Set<E> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
                this.mutabilityOracle = r5;
                this.delegate = r6;
            }

            @Override // java.util.Set, java.util.Collection
            public int size() {
                return this.delegate.size();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean isEmpty() {
                return this.delegate.isEmpty();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean contains(Object r1) {
                return this.delegate.contains(r1);
            }

            @Override // java.util.Set, java.util.Collection, java.lang.Iterable
            public Iterator<E> iterator() {
                return new MutabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
            }

            @Override // java.util.Set, java.util.Collection
            public Object[] toArray() {
                return this.delegate.toArray();
            }

            @Override // java.util.Set, java.util.Collection
            public <T> T[] toArray(T[] r1) {
                return (T[]) this.delegate.toArray(r1);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean add(E r2) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.add(r2);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean remove(Object r2) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.remove(r2);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean containsAll(Collection<?> r3) {
                Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
                return this.delegate.containsAll(r4);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean addAll(Collection<? extends E> r3) {
                Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
                this.mutabilityOracle.ensureMutable();
                return this.delegate.addAll(r4);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean retainAll(Collection<?> r3) {
                Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
                this.mutabilityOracle.ensureMutable();
                return this.delegate.retainAll(r4);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean removeAll(Collection<?> r3) {
                Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
                this.mutabilityOracle.ensureMutable();
                return this.delegate.removeAll(r4);
            }

            @Override // java.util.Set, java.util.Collection
            public void clear() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.clear();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean equals(Object r1) {
                return this.delegate.equals(r1);
            }

            @Override // java.util.Set, java.util.Collection
            public int hashCode() {
                return this.delegate.hashCode();
            }

            public String toString() {
                return this.delegate.toString();
            }
        }

        MutabilityAwareMap(MutabilityOracle r3, Map<K, V> r4) {
            MutabilityOracle r5 = (MutabilityOracle) ZeusTransformUtils.wrapperContextForParams(r3, MutabilityOracle.class, "com.obric.aiagent.plugin");
            Map<K, V> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            this.mutabilityOracle = r5;
            this.delegate = r6;
        }

        @Override // java.util.Map
        public int size() {
            return this.delegate.size();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.delegate.isEmpty();
        }

        @Override // java.util.Map
        public boolean containsKey(Object r1) {
            return this.delegate.containsKey(r1);
        }

        @Override // java.util.Map
        public boolean containsValue(Object r1) {
            return this.delegate.containsValue(r1);
        }

        @Override // java.util.Map
        public V get(Object r1) {
            return this.delegate.get(r1);
        }

        @Override // java.util.Map
        public V put(K r2, V r3) {
            this.mutabilityOracle.ensureMutable();
            Internal.checkNotNull(r2);
            Internal.checkNotNull(r3);
            return this.delegate.put(r2, r3);
        }

        @Override // java.util.Map
        public V remove(Object r2) {
            this.mutabilityOracle.ensureMutable();
            return this.delegate.remove(r2);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> r3) {
            Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            this.mutabilityOracle.ensureMutable();
            Iterator<K> r0 = r4.keySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            K r1 = r0.next();
            Internal.checkNotNull(r1);
            Internal.checkNotNull(r4.get(r1));
            goto L4
        L6:
            this.delegate.putAll(r4);
        }

        @Override // java.util.Map
        public void clear() {
            this.mutabilityOracle.ensureMutable();
            this.delegate.clear();
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            return new MutabilityAwareSet(this.mutabilityOracle, this.delegate.keySet());
        }

        @Override // java.util.Map
        public Collection<V> values() {
            return new MutabilityAwareCollection(this.mutabilityOracle, this.delegate.values());
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new MutabilityAwareSet(this.mutabilityOracle, this.delegate.entrySet());
        }

        @Override // java.util.Map
        public boolean equals(Object r1) {
            return this.delegate.equals(r1);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.delegate.hashCode();
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    private static final enum StorageMode extends java.lang.Enum<StorageMode> {
        private static final /* synthetic */ StorageMode[] $VALUES = null;
        public static final StorageMode BOTH = null;
        public static final StorageMode LIST = null;
        public static final StorageMode MAP = null;

        private static /* synthetic */ StorageMode[] $values() {
            return new StorageMode[]{MAP, LIST, BOTH};
        }

        private StorageMode(String r1, int r2) {
            super(r1, r2);
        }

        public static StorageMode valueOf(String r2) {
            return (StorageMode) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(StorageMode.class, r2), StorageMode.class, "com.obric.aiagent.plugin");
        }

        public static StorageMode[] values() {
            return (StorageMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StorageMode[].class, "com.obric.aiagent.plugin");
        }

        static {
            MAP = new StorageMode("MAP", 0);
            LIST = new StorageMode("LIST", 1);
            BOTH = new StorageMode("BOTH", 2);
            $VALUES = $values();
        }
    }

    private MapField(Converter<K, V> r3, StorageMode r4, Map<K, V> r5) {
        Converter<K, V> r6 = (Converter) ZeusTransformUtils.wrapperContextForParams(r3, Converter.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        this.converter = r6;
        this.isMutable = true;
        this.mode = r4;
        this.mapData = new MutabilityAwareMap(this, r7);
        this.listData = null;
    }

    private MapField(MapEntry<K, V> r3, StorageMode r4, Map<K, V> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        this(new ImmutableMessageConverter(r3), r4, r6);
    }

    public static <K, V> MapField<K, V> emptyMapField(MapEntry<K, V> r3) {
        return new MapField(r3, StorageMode.MAP, Collections.emptyMap());
    }

    public static <K, V> MapField<K, V> newMapField(MapEntry<K, V> r3) {
        return new MapField(r3, StorageMode.MAP, new LinkedHashMap());
    }

    private Message convertKeyAndValueToMessage(K r1, V r2) {
        return this.converter.convertKeyAndValueToMessage(r1, r2);
    }

    private void convertMessageToKeyAndValue(Message r3, Map<K, V> r4) {
        Message r5 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.aiagent.plugin");
        Map<K, V> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        this.converter.convertMessageToKeyAndValue(r5, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<Message> convertMapToList(MutabilityAwareMap<K, V> r5) {
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<K, V>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.add(convertKeyAndValueToMessage(r1.getKey(), r1.getValue()));
        goto L4
    L6:
        return r0;
    }

    private MutabilityAwareMap<K, V> convertListToMap(List<Message> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        convertMessageToKeyAndValue((Message) ZeusTransformUtils.preCheckCast(r7.next(), Message.class, "com.obric.aiagent.plugin"), r0);
        goto L4
    L7:
        return new MutabilityAwareMap(this, r0);
    }

    public Map<K, V> getMap() {
        if (this.mode != StorageMode.LIST) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mode != StorageMode.LIST) goto L8;
        this.mapData = convertListToMap(this.listData);     // Catch: Throwable -> L10
        this.mode = StorageMode.BOTH;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return Collections.unmodifiableMap(this.mapData);
    }

    public Map<K, V> getMutableMap() {
        if (this.mode == StorageMode.MAP) goto L9;
        if (this.mode != StorageMode.LIST) goto L7;
        this.mapData = convertListToMap(this.listData);
    L7:
        this.listData = null;
        this.mode = StorageMode.MAP;
    L9:
        return this.mapData;
    }

    public void mergeFrom(MapField<K, V> r1) {
        getMutableMap().putAll(MapFieldLite.copy(r1.getMap()));
    }

    public void clear() {
        this.mapData = new MutabilityAwareMap(this, new LinkedHashMap());
        this.mode = StorageMode.MAP;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, MapField.class) == true) goto L6;
        return false;
    L6:
        MapField r4 = (MapField) ZeusTransformUtils.preCheckCast(r3, MapField.class, "com.obric.aiagent.plugin");
        return MapFieldLite.equals(getMap(), r4.getMap());
    }

    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(getMap());
    }

    public MapField<K, V> copy() {
        return new MapField(this.converter, StorageMode.MAP, MapFieldLite.copy(getMap()));
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    List<Message> getList() {
        if (this.mode != StorageMode.MAP) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mode != StorageMode.MAP) goto L8;
        this.listData = convertMapToList(this.mapData);     // Catch: Throwable -> L10
        this.mode = StorageMode.BOTH;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return Collections.unmodifiableList(this.listData);
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    List<Message> getMutableList() {
        if (this.mode == StorageMode.LIST) goto L9;
        if (this.mode != StorageMode.MAP) goto L7;
        this.listData = convertMapToList(this.mapData);
    L7:
        this.mapData = null;
        this.mode = StorageMode.LIST;
    L9:
        return this.listData;
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    Message getMapEntryMessageDefaultInstance() {
        return this.converter.getMessageDefaultInstance();
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    @Override // com.google.protobuf.MutabilityOracle
    public void ensureMutable() {
        if (isMutable() == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }
}
