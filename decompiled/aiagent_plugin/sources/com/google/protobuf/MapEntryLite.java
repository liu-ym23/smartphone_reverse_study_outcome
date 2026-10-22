package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MapEntryLite<K, V> {
    private static final int KEY_FIELD_NUMBER = 1;
    private static final int VALUE_FIELD_NUMBER = 2;
    private final K key;
    private final Metadata<K, V> metadata;
    private final V value;

    /* JADX INFO: renamed from: com.google.protobuf.MapEntryLite$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[WireFormat.FieldType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static class Metadata<K, V> {
        public final K defaultKey;
        public final V defaultValue;
        public final WireFormat.FieldType keyType;
        public final WireFormat.FieldType valueType;

        public Metadata(WireFormat.FieldType r1, K r2, WireFormat.FieldType r3, V r4) {
            this.keyType = r1;
            this.defaultKey = r2;
            this.valueType = r3;
            this.defaultValue = r4;
        }
    }

    private MapEntryLite(WireFormat.FieldType r2, K r3, WireFormat.FieldType r4, V r5) {
        this.metadata = new Metadata(r2, r3, r4, r5);
        this.key = r3;
        this.value = r5;
    }

    private MapEntryLite(Metadata<K, V> r1, K r2, V r3) {
        this.metadata = r1;
        this.key = r2;
        this.value = r3;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType r1, K r2, WireFormat.FieldType r3, V r4) {
        return new MapEntryLite(r1, r2, r3, r4);
    }

    static <K, V> void writeTo(CodedOutputStream r2, Metadata<K, V> r3, K r4, V r5) {
        FieldSet.writeElement(r2, r3.keyType, 1, r4);
        FieldSet.writeElement(r2, r3.valueType, 2, r5);
    }

    static <K, V> int computeSerializedSize(Metadata<K, V> r2, K r3, V r4) {
        return FieldSet.computeElementSize(r2.keyType, 1, r3) + FieldSet.computeElementSize(r2.valueType, 2, r4);
    }

    static <T> T parseField(CodedInputStream r2, ExtensionRegistryLite r3, WireFormat.FieldType r4, T r5) {
        int r0 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r4.ordinal()];
        if (r0 != 1) goto L5;
        MessageLite.Builder r6 = ((MessageLite) ZeusTransformUtils.preCheckCast(r5, MessageLite.class, "com.obric.aiagent.plugin")).toBuilder();
        r2.readMessage(r6, r3);
        return (T) r6.buildPartial();
    L5:
        if (r0 == 2) goto L13;
        if (r0 == 3) goto L11;
        return (T) FieldSet.readPrimitiveField(r2, r4, true);
    L11:
        throw new RuntimeException("Groups are not allowed in maps.");
    L13:
        return (T) Integer.valueOf(r2.readEnum());
    }

    public void serializeTo(CodedOutputStream r2, int r3, K r4, V r5) {
        r2.writeTag(r3, 2);
        r2.writeUInt32NoTag(computeSerializedSize(this.metadata, r4, r5));
        writeTo(r2, this.metadata, r4, r5);
    }

    public int computeMessageSize(int r1, K r2, V r3) {
        return CodedOutputStream.computeTagSize(r1) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSerializedSize(this.metadata, r2, r3));
    }

    public Map.Entry<K, V> parseEntry(ByteString r1, ExtensionRegistryLite r2) {
        return parseEntry(r1.newCodedInput(), this.metadata, r2);
    }

    static <K, V> Map.Entry<K, V> parseEntry(CodedInputStream r5, Metadata<K, V> r6, ExtensionRegistryLite r7) {
        Object r0 = r6.defaultKey;
        Object r1 = r6.defaultValue;
    L3:
        int r2 = r5.readTag();
        if (r2 == 0) goto L15;
        if (r2 == WireFormat.makeTag(1, r6.keyType.getWireType())) goto L8;
        if (r2 == WireFormat.makeTag(2, r6.valueType.getWireType())) goto L11;
        if (r5.skipField(r2) == true) goto L3;
    L11:
        r1 = parseField(r5, r7, r6.valueType, r1);
        goto L3
    L8:
        r0 = parseField(r5, r7, r6.keyType, r0);
    L15:
        return new AbstractMap.SimpleImmutableEntry(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void parseInto(MapFieldLite<K, V> r7, CodedInputStream r8, ExtensionRegistryLite r9) {
        int r0 = r8.pushLimit(r8.readRawVarint32());
        Object r1 = this.metadata.defaultKey;
        Object r2 = this.metadata.defaultValue;
    L3:
        int r3 = r8.readTag();
        if (r3 == 0) goto L14;
        if (r3 == WireFormat.makeTag(1, this.metadata.keyType.getWireType())) goto L8;
        if (r3 == WireFormat.makeTag(2, this.metadata.valueType.getWireType())) goto L11;
        if (r8.skipField(r3) == true) goto L3;
    L11:
        r2 = parseField(r8, r9, this.metadata.valueType, r2);
        goto L3
    L8:
        r1 = parseField(r8, r9, this.metadata.keyType, r1);
    L14:
        r8.checkLastTagWas(0);
        r8.popLimit(r0);
        r7.put(r1, r2);
    }

    Metadata<K, V> getMetadata() {
        return this.metadata;
    }
}
