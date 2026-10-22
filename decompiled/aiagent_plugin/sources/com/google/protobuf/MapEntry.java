package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class MapEntry<K, V> extends AbstractMessage {
    private volatile int cachedSerializedSize;
    private final K key;
    private final Metadata<K, V> metadata;
    private final V value;

    /* JADX INFO: renamed from: com.google.protobuf.MapEntry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder<K, V> extends AbstractMessage.Builder<Builder<K, V>> {
        private boolean hasKey;
        private boolean hasValue;
        private K key;
        private final Metadata<K, V> metadata;
        private V value;

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> setUnknownFields(UnknownFieldSet r1) {
            return this;
        }

        /* synthetic */ Builder(Metadata r1, AnonymousClass1 r2) {
            this(r1);
        }

        /* synthetic */ Builder(Metadata r1, Object r2, Object r3, boolean r4, boolean r5, AnonymousClass1 r6) {
            this(r1, r2, r3, r4, r5);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            return addRepeatedField(r1, r2);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r1) {
            return clearField(r1);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo47clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
            return setField(r1, r2);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            return setRepeatedField(r1, r2, r3);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r1) {
            return setUnknownFields(r1);
        }

        private Builder(Metadata<K, V> r7) {
            this(r7, r7.defaultKey, r7.defaultValue, false, false);
        }

        private Builder(Metadata<K, V> r1, K r2, V r3, boolean r4, boolean r5) {
            this.metadata = r1;
            this.key = r2;
            this.value = r3;
            this.hasKey = r4;
            this.hasValue = r5;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public Builder<K, V> setKey(K r1) {
            this.key = r1;
            this.hasKey = true;
            return this;
        }

        public Builder<K, V> clearKey() {
            this.key = this.metadata.defaultKey;
            this.hasKey = false;
            return this;
        }

        public Builder<K, V> setValue(V r1) {
            this.value = r1;
            this.hasValue = true;
            return this;
        }

        public Builder<K, V> clearValue() {
            this.value = this.metadata.defaultValue;
            this.hasValue = false;
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MapEntry<K, V> build() {
            MapEntry<K, V> r1 = buildPartial();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw newUninitializedMessageException(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MapEntry<K, V> buildPartial() {
            return new MapEntry(this.metadata, this.key, this.value, null);
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return this.metadata.descriptor;
        }

        private void checkFieldDescriptor(Descriptors.FieldDescriptor r4) {
            if (r4.getContainingType() != this.metadata.descriptor) goto L6;
            return;
        L6:
            throw new RuntimeException("Wrong FieldDescriptor \"" + r4.getFullName() + "\" used in message \"" + this.metadata.descriptor.getFullName());
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor r3) {
            checkFieldDescriptor(r3);
            if (r3.getNumber() != 2) goto L9;
            if (r3.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L9;
            return ((Message) ZeusTransformUtils.preCheckCast(this.value, Message.class, "com.obric.aiagent.plugin")).newBuilderForType();
        L9:
            throw new RuntimeException("\"" + r3.getFullName() + "\" is not a message value field.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> setField(Descriptors.FieldDescriptor r4, Object r5) {
            checkFieldDescriptor(r4);
            if (r5 == null) goto L18;
            if (r4.getNumber() != 1) goto L8;
            setKey(r5);
        L16:
            return this;
        L8:
            if (r4.getType() != Descriptors.FieldDescriptor.Type.ENUM) goto L11;
            r5 = Integer.valueOf(((Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(r5, Descriptors.EnumValueDescriptor.class, "com.obric.aiagent.plugin")).getNumber());
        L15:
            setValue(r5);
            goto L16
        L11:
            if (r4.getType() != Descriptors.FieldDescriptor.Type.MESSAGE) goto L15;
            if (ZeusTransformUtils.instanceOf(this.metadata.defaultValue.getClass(), r5) == true) goto L15;
            r5 = ((Message) ZeusTransformUtils.preCheckCast(this.metadata.defaultValue, Message.class, "com.obric.aiagent.plugin")).toBuilder().mergeFrom((Message) ZeusTransformUtils.preCheckCast(r5, Message.class, "com.obric.aiagent.plugin")).build();
            goto L15
        L18:
            throw new NullPointerException(r4.getFullName() + " is null");
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> clearField(Descriptors.FieldDescriptor r2) {
            checkFieldDescriptor(r2);
            if (r2.getNumber() != 1) goto L5;
            clearKey();
        L6:
            return this;
        L5:
            clearValue();
            goto L6
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder<K, V> addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MapEntry<K, V> getDefaultInstanceForType() {
            Metadata<K, V> r1 = this.metadata;
            return new MapEntry(r1, r1.defaultKey, this.metadata.defaultValue, null);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return MapEntry.access$600(this.metadata, this.value);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            TreeMap r0 = new TreeMap();
            Iterator<Descriptors.FieldDescriptor> r1 = this.metadata.descriptor.getFields().iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            Descriptors.FieldDescriptor r2 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r1.next(), Descriptors.FieldDescriptor.class, "com.obric.aiagent.plugin");
            if (hasField(r2) == false) goto L4;
            r0.put(r2, getField(r2));
            goto L4
        L9:
            return Collections.unmodifiableMap(r0);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r2) {
            checkFieldDescriptor(r2);
            if (r2.getNumber() != 1) goto L6;
            return this.hasKey;
        L6:
            return this.hasValue;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r3) {
            checkFieldDescriptor(r3);
            if (r3.getNumber() != 1) goto L5;
            Object r2 = getKey();
        L7:
            if (r3.getType() == Descriptors.FieldDescriptor.Type.ENUM) goto L9;
            return r2;
        L9:
            return r3.getEnumType().findValueByNumberCreatingIfUnknown(((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin")).intValue());
        L5:
            r2 = getValue();
            goto L7
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r1) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r1, int r2) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public UnknownFieldSet getUnknownFields() {
            return UnknownFieldSet.getDefaultInstance();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder<K, V> clone() {
            return new Builder(this.metadata, this.key, this.value, this.hasKey, this.hasValue);
        }
    }

    private static final class Metadata<K, V> extends MapEntryLite.Metadata<K, V> {
        public final Descriptors.Descriptor descriptor;
        public final Parser<MapEntry<K, V>> parser;

        public Metadata(Descriptors.Descriptor r2, MapEntry<K, V> r3, WireFormat.FieldType r4, WireFormat.FieldType r5) {
            super(r4, MapEntry.access$000(r3), r5, MapEntry.access$100(r3));
            this.descriptor = r2;
            this.parser = new AnonymousClass1(this);
        }
    }

    /* synthetic */ MapEntry(Metadata r1, CodedInputStream r2, ExtensionRegistryLite r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    /* synthetic */ MapEntry(Metadata r1, Object r2, Object r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    static /* synthetic */ Object access$000(MapEntry r0) {
        return r0.key;
    }

    static /* synthetic */ Object access$100(MapEntry r0) {
        return r0.value;
    }

    static /* synthetic */ boolean access$600(Metadata r0, Object r1) {
        return isInitialized(r0, r1);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    private MapEntry(Descriptors.Descriptor r2, WireFormat.FieldType r3, K r4, WireFormat.FieldType r5, V r6) {
        this.cachedSerializedSize = -1;
        this.key = r4;
        this.value = r6;
        this.metadata = new Metadata(r2, this, r3, r5);
    }

    private MapEntry(Metadata r2, K r3, V r4) {
        this.cachedSerializedSize = -1;
        this.key = r3;
        this.value = r4;
        this.metadata = r2;
    }

    private MapEntry(Metadata<K, V> r2, CodedInputStream r3, ExtensionRegistryLite r4) {
        this.cachedSerializedSize = -1;
        this.metadata = r2;     // Catch: IOException -> L5 InvalidProtocolBufferException -> L8
        Map.Entry r5 = MapEntryLite.parseEntry(r3, r2, r4);     // Catch: IOException -> L5 InvalidProtocolBufferException -> L8
        this.key = (K) r5.getKey();     // Catch: IOException -> L5 InvalidProtocolBufferException -> L8
        this.value = (V) r5.getValue();     // Catch: IOException -> L5 InvalidProtocolBufferException -> L8
        return;
    L8:
        e = move-exception;
        throw e.setUnfinishedMessage(this);
    L5:
        e = move-exception;
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    }

    public static <K, V> MapEntry<K, V> newDefaultInstance(Descriptors.Descriptor r7, WireFormat.FieldType r8, K r9, WireFormat.FieldType r10, V r11) {
        return new MapEntry(r7, r8, r9, r10, r11);
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        if (this.cachedSerializedSize != (-1)) goto L5;
        int r0 = MapEntryLite.computeSerializedSize(this.metadata, this.key, this.value);
        this.cachedSerializedSize = r0;
        return r0;
    L5:
        return this.cachedSerializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r3) {
        MapEntryLite.writeTo(r3, this.metadata, this.key, this.value);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return isInitialized(this.metadata, this.value);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<MapEntry<K, V>> getParserForType() {
        return this.metadata.parser;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder<K, V> newBuilderForType() {
        return new Builder(this.metadata, null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder<K, V> toBuilder() {
        return new Builder(this.metadata, this.key, this.value, true, true, null);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public MapEntry<K, V> getDefaultInstanceForType() {
        Metadata<K, V> r1 = this.metadata;
        return new MapEntry(r1, r1.defaultKey, this.metadata.defaultValue);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return this.metadata.descriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        TreeMap r0 = new TreeMap();
        Iterator<Descriptors.FieldDescriptor> r1 = this.metadata.descriptor.getFields().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Descriptors.FieldDescriptor r2 = (Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(r1.next(), Descriptors.FieldDescriptor.class, "com.obric.aiagent.plugin");
        if (hasField(r2) == false) goto L4;
        r0.put(r2, getField(r2));
        goto L4
    L9:
        return Collections.unmodifiableMap(r0);
    }

    private void checkFieldDescriptor(Descriptors.FieldDescriptor r4) {
        if (r4.getContainingType() != this.metadata.descriptor) goto L6;
        return;
    L6:
        throw new RuntimeException("Wrong FieldDescriptor \"" + r4.getFullName() + "\" used in message \"" + this.metadata.descriptor.getFullName());
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor r1) {
        checkFieldDescriptor(r1);
        return true;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor r3) {
        checkFieldDescriptor(r3);
        if (r3.getNumber() != 1) goto L5;
        Object r2 = getKey();
    L7:
        if (r3.getType() == Descriptors.FieldDescriptor.Type.ENUM) goto L9;
        return r2;
    L9:
        return r3.getEnumType().findValueByNumberCreatingIfUnknown(((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin")).intValue());
    L5:
        r2 = getValue();
        goto L7
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor r1) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor r1, int r2) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private static <V> boolean isInitialized(Metadata r1, V r2) {
        if (r1.valueType.getJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
        return true;
    L5:
        return ((MessageLite) ZeusTransformUtils.preCheckCast(r2, MessageLite.class, "com.obric.aiagent.plugin")).isInitialized();
    }

    final Metadata<K, V> getMetadata() {
        return this.metadata;
    }
}
