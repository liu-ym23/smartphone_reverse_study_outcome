package com.bytedance.location.protobuf;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes3.dex */
public final class Internal {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY = null;
    public static final ByteBuffer EMPTY_BYTE_BUFFER = null;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM = null;
    static final Charset ISO_8859_1 = null;
    static final Charset US_ASCII = null;
    static final Charset UTF_8 = null;

    public interface BooleanList extends ProtobufList<Boolean> {
        void addBoolean(boolean r1);

        boolean getBoolean(int r1);

        @Override // 
        ProtobufList<Boolean> mutableCopyWithCapacity(int r1);

        boolean setBoolean(int r1, boolean r2);

        @Override // com.bytedance.location.protobuf.Internal.ProtobufList, com.bytedance.location.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Boolean> mutableCopyWithCapacity2(int r1) {
            return mutableCopyWithCapacity(r1);
        }
    }

    public interface DoubleList extends ProtobufList<Double> {
        void addDouble(double r1);

        double getDouble(int r1);

        @Override // com.bytedance.location.protobuf.Internal.ProtobufList, com.bytedance.location.protobuf.Internal.BooleanList
        ProtobufList<Double> mutableCopyWithCapacity(int r1);

        double setDouble(int r1, double r2);

        @Override // com.bytedance.location.protobuf.Internal.ProtobufList, com.bytedance.location.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Double> mutableCopyWithCapacity2(int r1) {
            return mutableCopyWithCapacity(r1);
        }
    }

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int r1);
    }

    public interface EnumVerifier {
        boolean isInRange(int r1);
    }

    public interface FloatList extends ProtobufList<Float> {
        void addFloat(float r1);

        float getFloat(int r1);

        @Override // com.bytedance.location.protobuf.Internal.ProtobufList, com.bytedance.location.protobuf.Internal.BooleanList
        ProtobufList<Float> mutableCopyWithCapacity(int r1);

        float setFloat(int r1, float r2);

        @Override // com.bytedance.location.protobuf.Internal.ProtobufList, com.bytedance.location.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Float> mutableCopyWithCapacity2(int r1) {
            return mutableCopyWithCapacity(r1);
        }
    }

    public interface IntList extends ProtobufList<Integer> {
        void addInt(int r1);

        int getInt(int r1);

        @Override // com.bytedance.location.protobuf.Internal.ProtobufList, com.bytedance.location.protobuf.Internal.BooleanList
        ProtobufList<Integer> mutableCopyWithCapacity(int r1);

        int setInt(int r1, int r2);

        @Override // com.bytedance.location.protobuf.Internal.ProtobufList, com.bytedance.location.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Integer> mutableCopyWithCapacity2(int r1) {
            return mutableCopyWithCapacity(r1);
        }
    }

    public static class ListAdapter<F, T> extends AbstractList<T> {
        private final Converter<F, T> converter;
        private final List<F> fromList;

        public interface Converter<F, T> {
            T convert(F r1);
        }

        public ListAdapter(List<F> fromList, Converter<F, T> converter) {
            this.fromList = fromList;
            this.converter = converter;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int r3) {
            return (T) this.converter.convert(this.fromList.get(r3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public interface LongList extends ProtobufList<Long> {
        void addLong(long r1);

        long getLong(int r1);

        @Override // com.bytedance.location.protobuf.Internal.ProtobufList, com.bytedance.location.protobuf.Internal.BooleanList
        ProtobufList<Long> mutableCopyWithCapacity(int r1);

        long setLong(int r1, long r2);

        @Override // com.bytedance.location.protobuf.Internal.ProtobufList, com.bytedance.location.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Long> mutableCopyWithCapacity2(int r1) {
            return mutableCopyWithCapacity(r1);
        }
    }

    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {
        private final Map<K, RealValue> realMap;
        private final Converter<RealValue, V> valueConverter;

        public interface Converter<A, B> {
            A doBackward(B r1);

            B doForward(A r1);
        }

        private class EntryAdapter implements Map.Entry<K, V> {
            private final Map.Entry<K, RealValue> realEntry;
            final /* synthetic */ MapAdapter this$0;

            public EntryAdapter(MapAdapter r1, Map.Entry<K, RealValue> realEntry) {
                this.this$0 = r1;
                this.realEntry = realEntry;
            }

            @Override // java.util.Map.Entry
            public K getKey() {
                return this.realEntry.getKey();
            }

            @Override // java.util.Map.Entry
            public V getValue() {
                return (V) MapAdapter.access$000(this.this$0).doForward(this.realEntry.getValue());
            }

            @Override // java.util.Map.Entry
            public V setValue(V r3) {
                RealValue r0 = this.realEntry.setValue((RealValue) MapAdapter.access$000(this.this$0).doBackward(r3));
                if (r0 != null) goto L7;
                return null;
            L7:
                return (V) MapAdapter.access$000(this.this$0).doForward(r0);
            }

            @Override // java.util.Map.Entry
            public boolean equals(Object o) {
                if (o != this) goto L6;
                return true;
            L6:
                if ((o instanceof Map.Entry) == true) goto L8;
                return false;
            L8:
                Map.Entry<?, ?> other = (Map.Entry) o;
                if (getKey().equals(other.getKey()) == false) goto L14;
                if (getValue().equals(getValue()) == false) goto L14;
                return true;
            L14:
                return false;
            }

            @Override // java.util.Map.Entry
            public int hashCode() {
                return this.realEntry.hashCode();
            }
        }

        private class IteratorAdapter implements Iterator<Map.Entry<K, V>> {
            private final Iterator<Map.Entry<K, RealValue>> realIterator;
            final /* synthetic */ MapAdapter this$0;

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ Object next() {
                return next();
            }

            public IteratorAdapter(MapAdapter r1, Iterator<Map.Entry<K, RealValue>> realIterator) {
                this.this$0 = r1;
                this.realIterator = realIterator;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.realIterator.hasNext();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return new EntryAdapter(this.this$0, this.realIterator.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.realIterator.remove();
            }
        }

        private class SetAdapter extends AbstractSet<Map.Entry<K, V>> {
            private final Set<Map.Entry<K, RealValue>> realSet;
            final /* synthetic */ MapAdapter this$0;

            public SetAdapter(MapAdapter r1, Set<Map.Entry<K, RealValue>> realSet) {
                this.this$0 = r1;
                this.realSet = realSet;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return new IteratorAdapter(this.this$0, this.realSet.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.realSet.size();
            }
        }

        static /* synthetic */ Converter access$000(MapAdapter x0) {
            return x0.valueConverter;
        }

        public static <T extends EnumLite> Converter<Integer, T> newEnumConverter(final EnumLiteMap<T> r1, final T r2) {
            return (Converter<Integer, T>) new AnonymousClass1(r1, r2);
        }

        public MapAdapter(Map<K, RealValue> realMap, Converter<RealValue, V> valueConverter) {
            this.realMap = realMap;
            this.valueConverter = valueConverter;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object key) {
            RealValue result = this.realMap.get(key);
            if (result != null) goto L7;
            return null;
        L7:
            return this.valueConverter.doForward(result);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.AbstractMap, java.util.Map
        public V put(K r3, V r4) {
            RealValue r0 = this.realMap.put(r3, this.valueConverter.doBackward(r4));
            if (r0 != null) goto L7;
            return null;
        L7:
            return this.valueConverter.doForward(r0);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new SetAdapter(this, this.realMap.entrySet());
        }
    }

    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList<E> mutableCopyWithCapacity(int r1);
    }

    private Internal() {
    }

    static {
        US_ASCII = Charset.forName(CharsetNames.US_ASCII);
        UTF_8 = Charset.forName(CharsetNames.UTF_8);
        ISO_8859_1 = Charset.forName(CharsetNames.ISO_8859_1);
        EMPTY_BYTE_ARRAY = new byte[0];
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(EMPTY_BYTE_ARRAY);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(EMPTY_BYTE_ARRAY);
    }

    static <T> T checkNotNull(T obj) {
        if (obj == null) goto L5;
        return obj;
    L5:
        throw new NullPointerException();
    }

    static <T> T checkNotNull(T obj, String message) {
        if (obj == null) goto L5;
        return obj;
    L5:
        throw new NullPointerException(message);
    }

    public static String stringDefaultValue(String bytes) {
        return new String(bytes.getBytes(ISO_8859_1), UTF_8);
    }

    public static ByteString bytesDefaultValue(String bytes) {
        return ByteString.copyFrom(bytes.getBytes(ISO_8859_1));
    }

    public static byte[] byteArrayDefaultValue(String bytes) {
        return bytes.getBytes(ISO_8859_1);
    }

    public static ByteBuffer byteBufferDefaultValue(String bytes) {
        return ByteBuffer.wrap(byteArrayDefaultValue(bytes));
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer source) {
        ByteBuffer temp = source.duplicate();
        temp.clear();
        ByteBuffer result = ByteBuffer.allocate(temp.capacity());
        result.put(temp);
        result.clear();
        return result;
    }

    public static boolean isValidUtf8(ByteString byteString) {
        return byteString.isValidUtf8();
    }

    public static boolean isValidUtf8(byte[] byteArray) {
        return Utf8.isValidUtf8(byteArray);
    }

    public static byte[] toByteArray(String value) {
        return value.getBytes(UTF_8);
    }

    public static String toStringUtf8(byte[] bytes) {
        return new String(bytes, UTF_8);
    }

    public static int hashLong(long n) {
        return (int) ((n >>> 32) ^ n);
    }

    public static int hashBoolean(boolean b) {
        if (b == false) goto L4;
        return 1231;
    L4:
        return 1237;
    }

    public static int hashEnum(EnumLite e) {
        return e.getNumber();
    }

    public static int hashEnumList(List<? extends EnumLite> list) {
        int hash = 1;
        Iterator<? extends EnumLite> r1 = list.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        EnumLite e = r1.next();
        hash = (hash * 31) + hashEnum(e);
        goto L4
    L6:
        return hash;
    }

    public static boolean equals(List<byte[]> a, List<byte[]> b) {
        if (a.size() == b.size()) goto L5;
        return false;
    L5:
        int i = 0;
    L7:
        if (i >= a.size()) goto L12;
        if (Arrays.equals(a.get(i), b.get(i)) == false) goto L10;
        i = i + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static int hashCode(List<byte[]> list) {
        int hash = 1;
        Iterator<byte[]> r1 = list.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        byte[] bytes = r1.next();
        hash = (hash * 31) + hashCode(bytes);
        goto L4
    L6:
        return hash;
    }

    public static int hashCode(byte[] bytes) {
        return hashCode(bytes, 0, bytes.length);
    }

    static int hashCode(byte[] bytes, int offset, int length) {
        int h = partialHash(length, bytes, offset, length);
        if (h != 0) goto L6;
        return 1;
    L6:
        return h;
    }

    static int partialHash(int h, byte[] bytes, int offset, int length) {
        int i = offset;
    L4:
        if (i >= (offset + length)) goto L7;
        h = (h * 31) + bytes[i];
        i = i + 1;
        goto L4
    L7:
        return h;
    }

    public static boolean equalsByteBuffer(ByteBuffer a, ByteBuffer b) {
        if (a.capacity() == b.capacity()) goto L7;
        return false;
    L7:
        return a.duplicate().clear().equals(b.duplicate().clear());
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> a, List<ByteBuffer> b) {
        if (a.size() == b.size()) goto L5;
        return false;
    L5:
        int i = 0;
    L7:
        if (i >= a.size()) goto L12;
        if (equalsByteBuffer(a.get(i), b.get(i)) == false) goto L10;
        i = i + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> list) {
        int hash = 1;
        Iterator<ByteBuffer> r1 = list.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ByteBuffer bytes = r1.next();
        hash = (hash * 31) + hashCodeByteBuffer(bytes);
        goto L4
    L6:
        return hash;
    }

    public static int hashCodeByteBuffer(ByteBuffer bytes) {
        if (bytes.hasArray() == false) goto L9;
        int h = partialHash(bytes.capacity(), bytes.array(), bytes.arrayOffset(), bytes.capacity());
        if (h != 0) goto L8;
        return 1;
    L8:
        return h;
    L9:
        int h2 = bytes.capacity();
        int bufferSize = 4096;
        if (h2 > 4096) goto L13;
        bufferSize = bytes.capacity();
    L13:
        byte[] buffer = new byte[bufferSize];
        ByteBuffer duplicated = bytes.duplicate();
        duplicated.clear();
        int h3 = bytes.capacity();
    L15:
        if (duplicated.remaining() <= 0) goto L21;
        if (duplicated.remaining() > bufferSize) goto L19;
        int length = duplicated.remaining();
    L20:
        duplicated.get(buffer, 0, length);
        h3 = partialHash(h3, buffer, 0, length);
        goto L15
    L19:
        length = bufferSize;
        goto L20
    L21:
        if (h3 != 0) goto L24;
        return 1;
    L24:
        return h3;
    }

    public static <T extends MessageLite> T getDefaultInstance(Class<T> clazz) {
        Method r0 = clazz.getMethod("getDefaultInstance", new Class[0]);     // Catch: Exception -> L4
        return (T) r0.invoke(r0, new Object[0]);
    L4:
        e = move-exception;
        throw new RuntimeException("Failed to get default instance for " + clazz, e);
    }

    static Object mergeMessage(Object destination, Object source) {
        return ((MessageLite) destination).toBuilder().mergeFrom((MessageLite) source).buildPartial();
    }
}
