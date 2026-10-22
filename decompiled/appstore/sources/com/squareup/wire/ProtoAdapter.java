package com.squareup.wire;

import fg.j;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ProtoAdapter<E> {
    public static final ProtoAdapter<Boolean> BOOL = null;
    public static final ProtoAdapter<ByteString> BYTES = null;
    public static final ProtoAdapter<Double> DOUBLE = null;
    public static final ProtoAdapter<Integer> FIXED32 = null;
    public static final ProtoAdapter<Long> FIXED64 = null;
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final int FIXED_BOOL_SIZE = 1;
    public static final ProtoAdapter<Float> FLOAT = null;
    public static final ProtoAdapter<Integer> INT32 = null;
    public static final ProtoAdapter<Long> INT64 = null;
    public static final ProtoAdapter<Integer> SFIXED32 = null;
    public static final ProtoAdapter<Long> SFIXED64 = null;
    public static final ProtoAdapter<Integer> SINT32 = null;
    public static final ProtoAdapter<Long> SINT64 = null;
    public static final ProtoAdapter<String> STRING = null;
    public static final ProtoAdapter<Integer> UINT32 = null;
    public static final ProtoAdapter<Long> UINT64 = null;
    private final FieldEncoding fieldEncoding;
    final Class<?> javaType;
    ProtoAdapter<List<E>> packedAdapter;
    ProtoAdapter<List<E>> repeatedAdapter;

    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        public EnumConstantNotFoundException(int r10, Class<?> r11) {
            super("Unknown enum tag " + r10 + " for " + r11.getCanonicalName());
            this.value = r10;
        }
    }

    public static final class MapEntryProtoAdapter<K, V> extends ProtoAdapter<Map.Entry<K, V>> {
        final ProtoAdapter<K> keyAdapter;
        final ProtoAdapter<V> valueAdapter;

        public MapEntryProtoAdapter(ProtoAdapter<K> r10, ProtoAdapter<V> r11) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.keyAdapter = r10;
            this.valueAdapter = r11;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) throws IOException {
            return decode(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) throws IOException {
            encode(r10, (Map.Entry) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return encodedSize((Map.Entry) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public Map.Entry<K, V> decode(ProtoReader r10) {
            throw new UnsupportedOperationException();
        }

        public void encode(ProtoWriter r10, Map.Entry<K, V> r11) throws IOException {
            this.keyAdapter.encodeWithTag(r10, 1, r11.getKey());
            this.valueAdapter.encodeWithTag(r10, 2, r11.getValue());
        }

        public int encodedSize(Map.Entry<K, V> r10) {
            return this.keyAdapter.encodedSizeWithTag(1, r10.getKey()) + this.valueAdapter.encodedSizeWithTag(2, r10.getValue());
        }
    }

    public static final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, V>> {
        private final MapEntryProtoAdapter<K, V> entryAdapter;

        public MapProtoAdapter(ProtoAdapter<K> r10, ProtoAdapter<V> r11) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.entryAdapter = new MapEntryProtoAdapter(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) throws IOException {
            return decode(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) throws IOException {
            encode(r10, (Map) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encodeWithTag(ProtoWriter r10, int r11, Object r12) throws IOException {
            encodeWithTag(r10, r11, (Map) r12);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return encodedSize((Map) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSizeWithTag(int r10, Object r11) {
            return encodedSizeWithTag(r10, (Map) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return redact((Map) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public Map<K, V> decode(ProtoReader r10) throws IOException {
            long r11 = r10.beginMessage();
            K r12 = null;
            V r13 = null;
        L3:
            int r14 = r10.nextTag();
            if (r14 == (-1)) goto L12;
            if (r14 != 1) goto L8;
            r12 = this.entryAdapter.keyAdapter.decode(r10);
            goto L3
        L8:
            if (r14 != 2) goto L3;
            r13 = this.entryAdapter.valueAdapter.decode(r10);
            goto L3
        L12:
            r10.endMessage(r11);
            if (r12 == null) goto L20;
            if (r13 == null) goto L18;
            return Collections.singletonMap(r12, r13);
        L18:
            throw new IllegalStateException("Map entry with null value");
        L20:
            throw new IllegalStateException("Map entry with null key");
        }

        public void encode(ProtoWriter r10, Map<K, V> r11) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        public void encodeWithTag(ProtoWriter r10, int r11, Map<K, V> r12) throws IOException {
            Iterator<Map.Entry<K, V>> r13 = r12.entrySet().iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            Map.Entry<K, V> r14 = r13.next();
            this.entryAdapter.encodeWithTag(r10, r11, r14);
            goto L4
        }

        public int encodedSize(Map<K, V> r10) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        public int encodedSizeWithTag(int r10, Map<K, V> r11) {
            Iterator<Map.Entry<K, V>> r12 = r11.entrySet().iterator();
            int r13 = 0;
        L4:
            if (r12.hasNext() == false) goto L6;
            Map.Entry<K, V> r14 = r12.next();
            r13 = r13 + this.entryAdapter.encodedSizeWithTag(r10, r14);
            goto L4
        L6:
            return r13;
        }

        public Map<K, V> redact(Map<K, V> r10) {
            return Collections.emptyMap();
        }
    }

    static {
        final FieldEncoding r10 = FieldEncoding.VARINT;
        final Class<Boolean> r11 = Boolean.class;
        BOOL = new AnonymousClass1(r10, r11);
        final Class<Integer> r12 = Integer.class;
        INT32 = new AnonymousClass2(r10, r12);
        UINT32 = new AnonymousClass3(r10, r12);
        SINT32 = new AnonymousClass4(r10, r12);
        final FieldEncoding r13 = FieldEncoding.FIXED32;
        ProtoAdapter<Integer> r14 = new AnonymousClass5(r13, r12);
        FIXED32 = r14;
        SFIXED32 = r14;
        final Class<Long> r15 = Long.class;
        INT64 = new AnonymousClass6(r10, r15);
        UINT64 = new AnonymousClass7(r10, r15);
        SINT64 = new AnonymousClass8(r10, r15);
        final FieldEncoding r16 = FieldEncoding.FIXED64;
        ProtoAdapter<Long> r17 = new AnonymousClass9(r16, r15);
        FIXED64 = r17;
        SFIXED64 = r17;
        final Class<Float> r18 = Float.class;
        FLOAT = new AnonymousClass10(r13, r18);
        final Class<Double> r19 = Double.class;
        DOUBLE = new AnonymousClass11(r16, r19);
        final FieldEncoding r20 = FieldEncoding.LENGTH_DELIMITED;
        final Class<String> r21 = String.class;
        STRING = new AnonymousClass12(r20, r21);
        final Class<ByteString> r22 = ByteString.class;
        BYTES = new AnonymousClass13(r20, r22);
    }

    public ProtoAdapter(FieldEncoding r10, Class<?> r11) {
        this.fieldEncoding = r10;
        this.javaType = r11;
    }

    private ProtoAdapter<List<E>> createPacked() {
        FieldEncoding r10 = this.fieldEncoding;
        final FieldEncoding r11 = FieldEncoding.LENGTH_DELIMITED;
        if (r10 == r11) goto L7;
        final Class<List> r12 = List.class;
        return new AnonymousClass14(this, r11, r12);
    L7:
        throw new IllegalArgumentException("Unable to pack a length-delimited type.");
    }

    private ProtoAdapter<List<E>> createRepeated() {
        final FieldEncoding r10 = this.fieldEncoding;
        final Class<List> r11 = List.class;
        return new AnonymousClass15(this, r10, r11);
    }

    public static <M extends Message> ProtoAdapter<M> get(M r10) {
        return get(r10.getClass());
    }

    public static <E extends WireEnum> RuntimeEnumAdapter<E> newEnumAdapter(Class<E> r10) {
        return new RuntimeEnumAdapter(r10);
    }

    public static <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> r10, ProtoAdapter<V> r11) {
        return new MapProtoAdapter(r10, r11);
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> r10) {
        return RuntimeMessageAdapter.create(r10);
    }

    public final ProtoAdapter<List<E>> asPacked() {
        ProtoAdapter<List<E>> r10 = this.packedAdapter;
        if (r10 != null) goto L7;
        ProtoAdapter<List<E>> r11 = createPacked();
        this.packedAdapter = r11;
        return r11;
    L7:
        return r10;
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> r10 = this.repeatedAdapter;
        if (r10 != null) goto L7;
        ProtoAdapter<List<E>> r11 = createRepeated();
        this.repeatedAdapter = r11;
        return r11;
    L7:
        return r10;
    }

    public abstract E decode(ProtoReader r10) throws IOException;

    public final E decode(byte[] r10) throws IOException {
        Preconditions.checkNotNull(r10, "bytes == null");
        return decode(new Buffer().r(r10));
    }

    public abstract void encode(ProtoWriter r10, E r11) throws IOException;

    public final void encode(BufferedSink r10, E r11) throws IOException {
        Preconditions.checkNotNull(r11, "value == null");
        Preconditions.checkNotNull(r10, "sink == null");
        encode(new ProtoWriter(r10), r11);
    }

    public void encodeWithTag(ProtoWriter r10, int r11, E r12) throws IOException {
        if (r12 != null) goto L4;
        return;
    L4:
        r10.writeTag(r11, this.fieldEncoding);
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) goto L7;
        r10.writeVarint32(encodedSize(r12));
    L7:
        encode(r10, r12);
    }

    public abstract int encodedSize(E r10);

    public int encodedSizeWithTag(int r10, E r11) {
        if (r11 != null) goto L5;
        return 0;
    L5:
        int r12 = encodedSize(r11);
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) goto L9;
        r12 = r12 + ProtoWriter.varint32Size(r12);
    L9:
        return r12 + ProtoWriter.tagSize(r10);
    }

    public E redact(E r10) {
        return null;
    }

    public String toString(E r10) {
        return r10.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoAdapter<?> withLabel(WireField.Label r10) {
        if (r10.isRepeated() == true) goto L5;
        return this;
    L5:
        if (r10.isPacked() == false) goto L8;
        return asPacked();
    L8:
        return asRepeated();
    }

    public static <M> ProtoAdapter<M> get(Class<M> r10) {
        return (ProtoAdapter) r10.getField("ADAPTER").get(null);
    L4:
        e = move-exception;
        throw new IllegalArgumentException("failed to access " + r10.getName() + "#ADAPTER", e);
    }

    public final E decode(ByteString r10) throws IOException {
        Preconditions.checkNotNull(r10, "bytes == null");
        return decode(new Buffer().q(r10));
    }

    public static ProtoAdapter<?> get(String r10) {
        int r11 = r10.indexOf(35);     // Catch: Throwable -> L5
        String r12 = r10.substring(0, r11);     // Catch: Throwable -> L5
        return (ProtoAdapter) Class.forName(r12).getField(r10.substring(r11 + 1)).get(null);
    L5:
        e = move-exception;
        throw new IllegalArgumentException("failed to access " + r10, e);
    }

    public final byte[] encode(E r10) {
        Preconditions.checkNotNull(r10, "value == null");
        Buffer r11 = new Buffer();
        encode(r11, r10);     // Catch: IOException -> L6
        return r11.readByteArray();
    L6:
        e = move-exception;
        throw new AssertionError(e);
    }

    public final E decode(InputStream r10) throws IOException {
        Preconditions.checkNotNull(r10, "stream == null");
        return decode(j.d(j.l(r10)));
    }

    public final E decode(BufferedSource r10) throws IOException {
        Preconditions.checkNotNull(r10, "source == null");
        return decode(new ProtoReader(r10));
    }

    public final void encode(OutputStream r10, E r11) throws IOException {
        Preconditions.checkNotNull(r11, "value == null");
        Preconditions.checkNotNull(r10, "stream == null");
        BufferedSink r12 = j.c(j.h(r10));
        encode(r12, r11);
        r12.emit();
    }
}
