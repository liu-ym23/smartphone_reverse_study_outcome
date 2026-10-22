package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
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

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Boolean> mutableCopyWithCapacity2(int r1) {
            return mutableCopyWithCapacity(r1);
        }
    }

    public interface DoubleList extends ProtobufList<Double> {
        void addDouble(double r1);

        double getDouble(int r1);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Double> mutableCopyWithCapacity(int r1);

        double setDouble(int r1, double r2);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
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

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Float> mutableCopyWithCapacity(int r1);

        float setFloat(int r1, float r2);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Float> mutableCopyWithCapacity2(int r1) {
            return mutableCopyWithCapacity(r1);
        }
    }

    public interface IntList extends ProtobufList<Integer> {
        void addInt(int r1);

        int getInt(int r1);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Integer> mutableCopyWithCapacity(int r1);

        int setInt(int r1, int r2);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Integer> mutableCopyWithCapacity2(int r1) {
            return mutableCopyWithCapacity(r1);
        }
    }

    public static class IntListAdapter<T> extends AbstractList<T> {
        private final IntConverter<T> converter;
        private final IntList fromList;

        public interface IntConverter<T> {
            T convert(int r1);
        }

        public IntListAdapter(IntList r3, IntConverter<T> r4) {
            IntList r5 = (IntList) ZeusTransformUtils.wrapperContextForParams(r3, IntList.class, "com.obric.aiagent.plugin");
            IntConverter<T> r6 = (IntConverter) ZeusTransformUtils.wrapperContextForParams(r4, IntConverter.class, "com.obric.aiagent.plugin");
            this.fromList = r5;
            this.converter = r6;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int r2) {
            return this.converter.convert(this.fromList.getInt(r2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public static class ListAdapter<F, T> extends AbstractList<T> {
        private final Converter<F, T> converter;
        private final List<F> fromList;

        public interface Converter<F, T> {
            T convert(F r1);
        }

        public ListAdapter(List<F> r3, Converter<F, T> r4) {
            List<F> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            Converter<F, T> r6 = (Converter) ZeusTransformUtils.wrapperContextForParams(r4, Converter.class, "com.obric.aiagent.plugin");
            this.fromList = r5;
            this.converter = r6;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int r2) {
            return (T) this.converter.convert(this.fromList.get(r2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public interface LongList extends ProtobufList<Long> {
        void addLong(long r1);

        long getLong(int r1);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Long> mutableCopyWithCapacity(int r1);

        long setLong(int r1, long r2);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
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

            public EntryAdapter(MapAdapter r3, Map.Entry<K, RealValue> r4) {
                Map.Entry<K, RealValue> r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.aiagent.plugin");
                this.this$0 = r3;
                this.realEntry = r5;
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
                RealValue r4 = this.realEntry.setValue((RealValue) MapAdapter.access$000(this.this$0).doBackward(r3));
                if (r4 != null) goto L7;
                return null;
            L7:
                return (V) MapAdapter.access$000(this.this$0).doForward(r4);
            }

            @Override // java.util.Map.Entry
            public boolean equals(Object r5) {
                if (r5 != this) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, Map.Entry.class) == true) goto L8;
                return false;
            L8:
                Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.aiagent.plugin");
                if (getKey().equals(r6.getKey()) == false) goto L14;
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

            public IteratorAdapter(MapAdapter r3, Iterator<Map.Entry<K, RealValue>> r4) {
                Iterator<Map.Entry<K, RealValue>> r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.aiagent.plugin");
                this.this$0 = r3;
                this.realIterator = r5;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.realIterator.hasNext();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return new EntryAdapter(this.this$0, (Map.Entry) ZeusTransformUtils.preCheckCast(this.realIterator.next(), Map.Entry.class, "com.obric.aiagent.plugin"));
            }

            @Override // java.util.Iterator
            public void remove() {
                this.realIterator.remove();
            }
        }

        private class SetAdapter extends AbstractSet<Map.Entry<K, V>> {
            private final Set<Map.Entry<K, RealValue>> realSet;
            final /* synthetic */ MapAdapter this$0;

            public SetAdapter(MapAdapter r3, Set<Map.Entry<K, RealValue>> r4) {
                Set<Map.Entry<K, RealValue>> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
                this.this$0 = r3;
                this.realSet = r5;
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

        static /* synthetic */ Converter access$000(MapAdapter r0) {
            return r0.valueConverter;
        }

        public static <T extends EnumLite> Converter<Integer, T> newEnumConverter(EnumLiteMap<T> r2, T r3) {
            final EnumLiteMap r4 = (EnumLiteMap) ZeusTransformUtils.wrapperContextForParams(r2, EnumLiteMap.class, "com.obric.aiagent.plugin");
            final EnumLite r5 = (EnumLite) ZeusTransformUtils.wrapperContextForParams(r3, EnumLite.class, "com.obric.aiagent.plugin");
            return (Converter<Integer, T>) new AnonymousClass1(r4, r5);
        }

        public MapAdapter(Map<K, RealValue> r3, Converter<RealValue, V> r4) {
            Map<K, RealValue> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            Converter<RealValue, V> r6 = (Converter) ZeusTransformUtils.wrapperContextForParams(r4, Converter.class, "com.obric.aiagent.plugin");
            this.realMap = r5;
            this.valueConverter = r6;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object r2) {
            RealValue r3 = this.realMap.get(r2);
            if (r3 != null) goto L7;
            return null;
        L7:
            return this.valueConverter.doForward(r3);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.AbstractMap, java.util.Map
        public V put(K r3, V r4) {
            RealValue r5 = this.realMap.put(r3, this.valueConverter.doBackward(r4));
            if (r5 != null) goto L7;
            return null;
        L7:
            return this.valueConverter.doForward(r5);
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

    public static int hashBoolean(boolean r0) {
        if (r0 == false) goto L4;
        return 1231;
    L4:
        return 1237;
    }

    public static int hashLong(long r2) {
        return (int) (r2 ^ (r2 >>> 32));
    }

    private Internal() {
    }

    static {
        US_ASCII = Charset.forName("US-ASCII");
        UTF_8 = Charset.forName("UTF-8");
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        byte[] r0 = new byte[0];
        EMPTY_BYTE_ARRAY = r0;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(r0);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(r0);
    }

    static <T> T checkNotNull(T r0) {
        Objects.requireNonNull(r0);
        return r0;
    }

    static <T> T checkNotNull(T r0, String r1) {
        Objects.requireNonNull(r0, r1);
        return r0;
    }

    public static String stringDefaultValue(String r2) {
        return new String(r2.getBytes(ISO_8859_1), UTF_8);
    }

    public static ByteString bytesDefaultValue(String r1) {
        return ByteString.copyFrom(r1.getBytes(ISO_8859_1));
    }

    public static byte[] byteArrayDefaultValue(String r1) {
        return r1.getBytes(ISO_8859_1);
    }

    public static ByteBuffer byteBufferDefaultValue(String r0) {
        return ByteBuffer.wrap(byteArrayDefaultValue(r0));
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer r1) {
        ByteBuffer r2 = r1.duplicate();
        r2.clear();
        ByteBuffer r0 = ByteBuffer.allocate(r2.capacity());
        r0.put(r2);
        r0.clear();
        return r0;
    }

    public static boolean isValidUtf8(ByteString r0) {
        return r0.isValidUtf8();
    }

    public static boolean isValidUtf8(byte[] r0) {
        return Utf8.isValidUtf8(r0);
    }

    public static byte[] toByteArray(String r1) {
        return r1.getBytes(UTF_8);
    }

    public static String toStringUtf8(byte[] r2) {
        return new String(r2, UTF_8);
    }

    public static int hashEnum(EnumLite r2) {
        return ((EnumLite) ZeusTransformUtils.wrapperContextForParams(r2, EnumLite.class, "com.obric.aiagent.plugin")).getNumber();
    }

    public static int hashEnumList(List<? extends EnumLite> r4) {
        Iterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin")).iterator();
        int r0 = 1;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = (r0 * 31) + hashEnum((EnumLite) ZeusTransformUtils.preCheckCast(r5.next(), EnumLite.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        return r0;
    }

    public static boolean equals(List<byte[]> r6, List<byte[]> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r8.size() == r9.size()) goto L5;
        return false;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= r8.size()) goto L12;
        if (Arrays.equals((byte[]) ZeusTransformUtils.preCheckCast(r8.get(r1), byte[].class, "com.obric.aiagent.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(r9.get(r1), byte[].class, "com.obric.aiagent.plugin")) == false) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static int hashCode(List<byte[]> r4) {
        Iterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin")).iterator();
        int r0 = 1;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = (r0 * 31) + hashCode((byte[]) ZeusTransformUtils.preCheckCast(r5.next(), byte[].class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        return r0;
    }

    public static int hashCode(byte[] r2) {
        return hashCode(r2, 0, r2.length);
    }

    static int hashCode(byte[] r0, int r1, int r2) {
        int r3 = partialHash(r2, r0, r1, r2);
        if (r3 != 0) goto L6;
        return 1;
    L6:
        return r3;
    }

    static int partialHash(int r2, byte[] r3, int r4, int r5) {
        int r0 = r4;
    L4:
        if (r0 >= (r4 + r5)) goto L6;
        r2 = (r2 * 31) + r3[r0];
        r0 = r0 + 1;
        goto L4
    L6:
        return r2;
    }

    public static boolean equalsByteBuffer(ByteBuffer r2, ByteBuffer r3) {
        if (r2.capacity() == r3.capacity()) goto L6;
        return false;
    L6:
        ByteBuffer r4 = r2.duplicate();
        Java8Compatibility.clear(r4);
        ByteBuffer r5 = r3.duplicate();
        Java8Compatibility.clear(r5);
        return r4.equals(r5);
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> r6, List<ByteBuffer> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r8.size() == r9.size()) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r8.size()) goto L12;
        if (equalsByteBuffer((ByteBuffer) ZeusTransformUtils.preCheckCast(r8.get(r0), ByteBuffer.class, "com.obric.aiagent.plugin"), (ByteBuffer) ZeusTransformUtils.preCheckCast(r9.get(r0), ByteBuffer.class, "com.obric.aiagent.plugin")) == false) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> r4) {
        Iterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin")).iterator();
        int r0 = 1;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = (r0 * 31) + hashCodeByteBuffer((ByteBuffer) ZeusTransformUtils.preCheckCast(r5.next(), ByteBuffer.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        return r0;
    }

    public static int hashCodeByteBuffer(ByteBuffer r6) {
        if (r6.hasArray() == false) goto L9;
        int r7 = partialHash(r6.capacity(), r6.array(), r6.arrayOffset(), r6.capacity());
        if (r7 != 0) goto L8;
        return 1;
    L8:
        return r7;
    L9:
        int r2 = 4096;
        if (r6.capacity() > 4096) goto L13;
        r2 = r6.capacity();
    L13:
        byte[] r0 = new byte[r2];
        ByteBuffer r3 = r6.duplicate();
        Java8Compatibility.clear(r3);
        int r8 = r6.capacity();
    L15:
        if (r3.remaining() <= 0) goto L21;
        if (r3.remaining() > r2) goto L19;
        int r4 = r3.remaining();
    L20:
        r3.get(r0, 0, r4);
        r8 = partialHash(r8, r0, 0, r4);
        goto L15
    L19:
        r4 = r2;
        goto L20
    L21:
        if (r8 != 0) goto L24;
        return 1;
    L24:
        return r8;
    }

    public static <T extends MessageLite> T getDefaultInstance(Class<T> r4) {
        java.lang.reflect.Method r0 = r4.getMethod("getDefaultInstance", new Class[0]);     // Catch: Exception -> L4
        return (T) ZeusTransformUtils.preCheckCast(r0.invoke(r0, new Object[0]), MessageLite.class, "com.obric.aiagent.plugin");
    L4:
        e = move-exception;
        throw new RuntimeException("Failed to get default instance for " + r4, e);
    }

    static Object mergeMessage(Object r2, Object r3) {
        return ((MessageLite) ZeusTransformUtils.preCheckCast(r2, MessageLite.class, "com.obric.aiagent.plugin")).toBuilder().mergeFrom((MessageLite) ZeusTransformUtils.preCheckCast(r3, MessageLite.class, "com.obric.aiagent.plugin")).buildPartial();
    }
}
