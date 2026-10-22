package com.squareup.wire;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import e.e;
import e.f;
import e.g;
import e.h;
import e.o;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ProtoAdapter<E> {
    public static final ProtoAdapter<Boolean> BOOL = null;
    public static final ProtoAdapter<h> BYTES = null;
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

        EnumConstantNotFoundException(int r3, Class<?> r4) {
            super("Unknown enum tag " + r3 + " for " + r4.getCanonicalName());
            this.value = r3;
        }
    }

    private static final class MapEntryProtoAdapter<K, V> extends ProtoAdapter<Map.Entry<K, V>> {
        final ProtoAdapter<K> keyAdapter;
        final ProtoAdapter<V> valueAdapter;

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r1) {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, Object r4) {
            encode(r3, (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(Object r3) {
            return encodedSize((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin"));
        }

        MapEntryProtoAdapter(ProtoAdapter<K> r3, ProtoAdapter<V> r4) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.keyAdapter = r3;
            this.valueAdapter = r4;
        }

        public int encodedSize(Map.Entry<K, V> r4) {
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.aiagent.plugin");
            return this.keyAdapter.encodedSizeWithTag(1, (K) r5.getKey()) + this.valueAdapter.encodedSizeWithTag(2, (V) r5.getValue());
        }

        public void encode(ProtoWriter r4, Map.Entry<K, V> r5) {
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r5, Map.Entry.class, "com.obric.aiagent.plugin");
            this.keyAdapter.encodeWithTag(r4, 1, (K) r6.getKey());
            this.valueAdapter.encodeWithTag(r4, 2, (V) r6.getValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public Map.Entry<K, V> decode(ProtoReader r1) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, V>> {
        private final MapEntryProtoAdapter<K, V> entryAdapter;

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r1) {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, Object r4) {
            encode(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encodeWithTag(ProtoWriter r3, int r4, Object r5) {
            encodeWithTag(r3, r4, (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(Object r3) {
            return encodedSize((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSizeWithTag(int r3, Object r4) {
            return encodedSizeWithTag(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Object redact(Object r3) {
            return redact((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin"));
        }

        MapProtoAdapter(ProtoAdapter<K> r3, ProtoAdapter<V> r4) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.entryAdapter = new MapEntryProtoAdapter(r3, r4);
        }

        public int encodedSize(Map<K, V> r2) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        public int encodedSizeWithTag(int r5, Map<K, V> r6) {
            Iterator<Map.Entry<K, V>> r7 = ((Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
            int r0 = 0;
        L4:
            if (r7.hasNext() == false) goto L6;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            r0 = r0 + this.entryAdapter.encodedSizeWithTag(r5, r2);
            goto L4
        L6:
            return r0;
        }

        public void encode(ProtoWriter r1, Map<K, V> r2) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        public void encodeWithTag(ProtoWriter r4, int r5, Map<K, V> r6) {
            Iterator<Map.Entry<K, V>> r7 = ((Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            this.entryAdapter.encodeWithTag(r4, r5, r0);
            goto L4
        }

        @Override // com.squareup.wire.ProtoAdapter
        public Map<K, V> decode(ProtoReader r7) {
            long r0 = r7.beginMessage();
            K r2 = null;
            V r3 = null;
        L3:
            int r4 = r7.nextTag();
            if (r4 == (-1)) goto L12;
            if (r4 != 1) goto L8;
            r2 = this.entryAdapter.keyAdapter.decode(r7);
            goto L3
        L8:
            if (r4 != 2) goto L3;
            r3 = this.entryAdapter.valueAdapter.decode(r7);
            goto L3
        L12:
            r7.endMessage(r0);
            if (r2 == null) goto L20;
            if (r3 == null) goto L18;
            return Collections.singletonMap(r2, r3);
        L18:
            throw new IllegalStateException("Map entry with null value");
        L20:
            throw new IllegalStateException("Map entry with null key");
        }

        public Map<K, V> redact(Map<K, V> r2) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
            return Collections.emptyMap();
        }
    }

    public abstract E decode(ProtoReader r1);

    public abstract void encode(ProtoWriter r1, E r2);

    public abstract int encodedSize(E r1);

    public E redact(E r1) {
        return null;
    }

    public ProtoAdapter(FieldEncoding r1, Class<?> r2) {
        this.fieldEncoding = r1;
        this.javaType = r2;
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> r0) {
        return RuntimeMessageAdapter.create(r0);
    }

    public static <E extends WireEnum> RuntimeEnumAdapter<E> newEnumAdapter(Class<E> r1) {
        return new RuntimeEnumAdapter(r1);
    }

    public static <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> r1, ProtoAdapter<V> r2) {
        return new MapProtoAdapter(r1, r2);
    }

    public static <M extends Message> ProtoAdapter<M> get(M r0) {
        return get(r0.getClass());
    }

    public static <M> ProtoAdapter<M> get(Class<M> r4) {
        return (ProtoAdapter) ZeusTransformUtils.preCheckCast(r4.getField("ADAPTER").get(null), ProtoAdapter.class, "com.obric.aiagent.plugin");
    L4:
        e = move-exception;
        throw new IllegalArgumentException("failed to access " + r4.getName() + "#ADAPTER", e);
    }

    public static ProtoAdapter<?> get(String r4) {
        int r1 = r4.indexOf(35);     // Catch: Throwable -> L5
        String r2 = r4.substring(0, r1);     // Catch: Throwable -> L5
        return (ProtoAdapter) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName(r2, "com.obric.aiagent.plugin").getField(r4.substring(r1 + 1)).get(null), ProtoAdapter.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        throw new IllegalArgumentException("failed to access " + r4, e);
    }

    public int encodedSizeWithTag(int r2, E r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        int r4 = encodedSize(r3);
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) goto L9;
        r4 = r4 + ProtoWriter.varint32Size(r4);
    L9:
        return r4 + ProtoWriter.tagSize(r2);
    }

    public void encodeWithTag(ProtoWriter r2, int r3, E r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        r2.writeTag(r3, this.fieldEncoding);
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) goto L7;
        r2.writeVarint32(encodedSize(r4));
    L7:
        encode(r2, r4);
    }

    public final void encode(f r3, E r4) {
        f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
        Preconditions.checkNotNull(r4, "value == null");
        Preconditions.checkNotNull(r5, "sink == null");
        encode(new ProtoWriter(r5), r4);
    }

    public final byte[] encode(E r2) {
        Preconditions.checkNotNull(r2, "value == null");
        e r0 = new e();
        encode(r0, r2);     // Catch: IOException -> L6
        return r0.w();
    L6:
        e = move-exception;
        throw new AssertionError(e);
    }

    public final void encode(OutputStream r2, E r3) {
        Preconditions.checkNotNull(r3, "value == null");
        Preconditions.checkNotNull(r2, "stream == null");
        f r4 = o.a(o.a(r2));
        encode(r4, r3);
        r4.C();
    }

    public final E decode(byte[] r2) {
        Preconditions.checkNotNull(r2, "bytes == null");
        return decode(new e().b(r2));
    }

    public final E decode(h r2) {
        Preconditions.checkNotNull(r2, "bytes == null");
        return decode(new e().a(r2));
    }

    public final E decode(InputStream r2) {
        Preconditions.checkNotNull(r2, "stream == null");
        return decode(o.a(o.a(r2)));
    }

    public final E decode(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        Preconditions.checkNotNull(r4, "source == null");
        return decode(new ProtoReader(r4));
    }

    public String toString(E r1) {
        return r1.toString();
    }

    static {
        final FieldEncoding r1 = FieldEncoding.VARINT;
        final Class<Boolean> r2 = Boolean.class;
        BOOL = new AnonymousClass1(r1, r2);
        final FieldEncoding r3 = FieldEncoding.VARINT;
        final Class<Integer> r4 = Integer.class;
        INT32 = new AnonymousClass2(r3, r4);
        final FieldEncoding r5 = FieldEncoding.VARINT;
        final Class<Integer> r6 = Integer.class;
        UINT32 = new AnonymousClass3(r5, r6);
        final FieldEncoding r7 = FieldEncoding.VARINT;
        final Class<Integer> r8 = Integer.class;
        SINT32 = new AnonymousClass4(r7, r8);
        final FieldEncoding r9 = FieldEncoding.FIXED32;
        final Class<Integer> r10 = Integer.class;
        ProtoAdapter<Integer> r0 = new AnonymousClass5(r9, r10);
        FIXED32 = r0;
        SFIXED32 = r0;
        final FieldEncoding r11 = FieldEncoding.VARINT;
        final Class<Long> r12 = Long.class;
        INT64 = new AnonymousClass6(r11, r12);
        final FieldEncoding r13 = FieldEncoding.VARINT;
        final Class<Long> r14 = Long.class;
        UINT64 = new AnonymousClass7(r13, r14);
        final FieldEncoding r15 = FieldEncoding.VARINT;
        final Class<Long> r16 = Long.class;
        SINT64 = new AnonymousClass8(r15, r16);
        final FieldEncoding r17 = FieldEncoding.FIXED64;
        final Class<Long> r18 = Long.class;
        ProtoAdapter<Long> r19 = new AnonymousClass9(r17, r18);
        FIXED64 = r19;
        SFIXED64 = r19;
        final FieldEncoding r20 = FieldEncoding.FIXED32;
        final Class<Float> r21 = Float.class;
        FLOAT = new AnonymousClass10(r20, r21);
        final FieldEncoding r22 = FieldEncoding.FIXED64;
        final Class<Double> r23 = Double.class;
        DOUBLE = new AnonymousClass11(r22, r23);
        final FieldEncoding r24 = FieldEncoding.LENGTH_DELIMITED;
        final Class<String> r25 = String.class;
        STRING = new AnonymousClass12(r24, r25);
        final FieldEncoding r26 = FieldEncoding.LENGTH_DELIMITED;
        final Class<h> r27 = h.class;
        BYTES = new AnonymousClass13(r26, r27);
    }

    /* JADX WARN: Multi-variable type inference failed */
    ProtoAdapter<?> withLabel(WireField.Label r2) {
        if (r2.isRepeated() == true) goto L5;
        return this;
    L5:
        if (r2.isPacked() == false) goto L8;
        return asPacked();
    L8:
        return asRepeated();
    }

    public final ProtoAdapter<List<E>> asPacked() {
        ProtoAdapter<List<E>> r0 = this.packedAdapter;
        if (r0 != null) goto L7;
        ProtoAdapter<List<E>> r1 = createPacked();
        this.packedAdapter = r1;
        return r1;
    L7:
        return r0;
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> r0 = this.repeatedAdapter;
        if (r0 != null) goto L7;
        ProtoAdapter<List<E>> r1 = createRepeated();
        this.repeatedAdapter = r1;
        return r1;
    L7:
        return r0;
    }

    private ProtoAdapter<List<E>> createPacked() {
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) goto L7;
        final FieldEncoding r1 = FieldEncoding.LENGTH_DELIMITED;
        final Class<List> r2 = List.class;
        return new AnonymousClass14(this, r1, r2);
    L7:
        throw new IllegalArgumentException("Unable to pack a length-delimited type.");
    }

    private ProtoAdapter<List<E>> createRepeated() {
        final FieldEncoding r1 = this.fieldEncoding;
        final Class<List> r2 = List.class;
        return new AnonymousClass15(this, r1, r2);
    }
}
