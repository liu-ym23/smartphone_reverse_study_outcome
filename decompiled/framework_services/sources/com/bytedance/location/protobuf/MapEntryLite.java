package com.bytedance.location.protobuf;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MapEntryLite<K, V> {
    private static final int KEY_FIELD_NUMBER = 1;
    private static final int VALUE_FIELD_NUMBER = 2;
    private final K key;
    private final Metadata<K, V> metadata;
    private final V value;

    /* JADX INFO: renamed from: com.bytedance.location.protobuf.MapEntryLite$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L17:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L13:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static class Metadata<K, V> {
        public final K defaultKey;
        public final V defaultValue;
        public final WireFormat.FieldType keyType;
        public final WireFormat.FieldType valueType;

        public Metadata(WireFormat.FieldType keyType, K defaultKey, WireFormat.FieldType valueType, V defaultValue) {
            this.keyType = keyType;
            this.defaultKey = defaultKey;
            this.valueType = valueType;
            this.defaultValue = defaultValue;
        }
    }

    private MapEntryLite(WireFormat.FieldType keyType, K defaultKey, WireFormat.FieldType valueType, V defaultValue) {
        this.metadata = new Metadata(keyType, defaultKey, valueType, defaultValue);
        this.key = defaultKey;
        this.value = defaultValue;
    }

    private MapEntryLite(Metadata<K, V> metadata, K key, V value) {
        this.metadata = metadata;
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType keyType, K defaultKey, WireFormat.FieldType valueType, V defaultValue) {
        return new MapEntryLite(keyType, defaultKey, valueType, defaultValue);
    }

    static <K, V> void writeTo(CodedOutputStream output, Metadata<K, V> metadata, K key, V value) throws IOException {
        FieldSet.writeElement(output, metadata.keyType, 1, key);
        FieldSet.writeElement(output, metadata.valueType, 2, value);
    }

    static <K, V> int computeSerializedSize(Metadata<K, V> metadata, K key, V value) {
        return FieldSet.computeElementSize(metadata.keyType, 1, key) + FieldSet.computeElementSize(metadata.valueType, 2, value);
    }

    static <T> T parseField(CodedInputStream r2, ExtensionRegistryLite r3, WireFormat.FieldType r4, T r5) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r4.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L7;
            default: goto L5;
        };
    L10:
        MessageLite.Builder r0 = ((MessageLite) r5).toBuilder();
        r2.readMessage(r0, r3);
        return (T) r0.buildPartial();
    L5:
        return (T) FieldSet.readPrimitiveField(r2, r4, true);
    L7:
        throw new RuntimeException("Groups are not allowed in maps.");
    L9:
        return (T) Integer.valueOf(r2.readEnum());
    }

    public void serializeTo(CodedOutputStream output, int fieldNumber, K key, V value) throws IOException {
        output.writeTag(fieldNumber, 2);
        output.writeUInt32NoTag(computeSerializedSize(this.metadata, key, value));
        writeTo(output, this.metadata, key, value);
    }

    public int computeMessageSize(int fieldNumber, K key, V value) {
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSerializedSize(this.metadata, key, value));
    }

    public Map.Entry<K, V> parseEntry(ByteString bytes, ExtensionRegistryLite extensionRegistry) throws IOException {
        return parseEntry(bytes.newCodedInput(), this.metadata, extensionRegistry);
    }

    static <K, V> Map.Entry<K, V> parseEntry(CodedInputStream input, Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistry) throws IOException {
        Object r0 = metadata.defaultKey;
        Object r1 = metadata.defaultValue;
    L3:
        int tag = input.readTag();
        if (tag == 0) goto L15;
        if (tag == WireFormat.makeTag(1, metadata.keyType.getWireType())) goto L8;
        if (tag == WireFormat.makeTag(2, metadata.valueType.getWireType())) goto L11;
        if (input.skipField(tag) == true) goto L3;
    L11:
        r1 = parseField(input, extensionRegistry, metadata.valueType, r1);
        goto L3
    L8:
        r0 = parseField(input, extensionRegistry, metadata.keyType, r0);
    L15:
        return new AbstractMap.SimpleImmutableEntry(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void parseInto(MapFieldLite<K, V> r8, CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        int length = input.readRawVarint32();
        int oldLimit = input.pushLimit(length);
        Object r2 = this.metadata.defaultKey;
        Object r3 = this.metadata.defaultValue;
    L3:
        int tag = input.readTag();
        if (tag == 0) goto L14;
        if (tag == WireFormat.makeTag(1, this.metadata.keyType.getWireType())) goto L8;
        if (tag == WireFormat.makeTag(2, this.metadata.valueType.getWireType())) goto L11;
        if (input.skipField(tag) == true) goto L3;
    L11:
        r3 = parseField(input, extensionRegistry, this.metadata.valueType, r3);
        goto L3
    L8:
        r2 = parseField(input, extensionRegistry, this.metadata.keyType, r2);
    L14:
        input.checkLastTagWas(0);
        input.popLimit(oldLimit);
        r8.put(r2, r3);
    }

    Metadata<K, V> getMetadata() {
        return this.metadata;
    }
}
