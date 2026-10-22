package com.google.protobuf;

import com.bytedance.apm.constant.CommonKey;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractMessage extends AbstractMessageLite implements Message {
    protected int memoizedSize;

    public static abstract class Builder<BuilderType extends Builder<BuilderType>> extends AbstractMessageLite.Builder implements Message.Builder {
        public Builder() {
        }

        public static UninitializedMessageException newUninitializedMessageException(Message r10) {
            return new UninitializedMessageException(MessageReflection.findMissingFields(r10));
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r10) {
            return clearOneof(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public abstract BuilderType clone();

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        public void dispose() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public List<String> findInitializationErrors() {
            return MessageReflection.findMissingFields(this);
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r10) {
            throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public String getInitializationErrorString() {
            return MessageReflection.delimitWithCommas(findInitializationErrors());
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r10) {
            throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r10, int r11) {
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on an unsupported message type.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(Descriptors.OneofDescriptor r10) {
            throw new UnsupportedOperationException("hasOneof() is not implemented.");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite r10) {
            return internalMergeFrom(r10);
        }

        public void markClean() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(InputStream r10) throws IOException {
            return super.mergeDelimitedFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(ByteString r10) throws InvalidProtocolBufferException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r10) {
            return mergeUnknownFields(r10);
        }

        public String toString() {
            return TextFormat.printToString(this);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType clearOneof(Descriptors.OneofDescriptor r10) {
            throw new UnsupportedOperationException("clearOneof() is not implemented.");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.AbstractMessageLite.Builder
        public BuilderType internalMergeFrom(AbstractMessageLite r10) {
            return (BuilderType) mergeFrom((Message) r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
            return super.mergeDelimitedFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType mergeUnknownFields(UnknownFieldSet r10) {
            setUnknownFields(UnknownFieldSet.newBuilder(getUnknownFields()).mergeFrom(r10).build());
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r10 = getAllFields().entrySet().iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            clearField(r10.next().getKey());
            goto L4
        L6:
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10) throws IOException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(InputStream r10) throws IOException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r10) throws InvalidProtocolBufferException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r10, int r11, int r12) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11, r12);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11, r12, r13);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(ByteString r10) throws InvalidProtocolBufferException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r10) throws IOException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(InputStream r10) throws IOException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(byte[] r10) throws InvalidProtocolBufferException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(byte[] r10, int r11, int r12) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11, r12);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11, r12, r13);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r10) throws InvalidProtocolBufferException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10) throws IOException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r10) throws IOException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10) throws InvalidProtocolBufferException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10, int r11, int r12) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11, r12);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11, r12, r13);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(Message r10) {
            if (r10.getDescriptorForType() != getDescriptorForType()) goto L23;
            Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r11 = r10.getAllFields().entrySet().iterator();
        L6:
            if (r11.hasNext() == false) goto L20;
            Map.Entry<Descriptors.FieldDescriptor, Object> r12 = r11.next();
            Descriptors.FieldDescriptor r13 = r12.getKey();
            if (r13.isRepeated() == true) goto L9;
            if (r13.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L15;
            setField(r13, r12.getValue());
            goto L6
        L15:
            Message r14 = (Message) getField(r13);
            if (r14 == r14.getDefaultInstanceForType()) goto L17;
            setField(r13, r14.newBuilderForType().mergeFrom(r14).mergeFrom((Message) r12.getValue()).build());
            goto L6
        L17:
            setField(r13, r12.getValue());
            goto L6
        L9:
            Iterator r15 = ((List) r12.getValue()).iterator();
        L11:
            if (r15.hasNext() == false) goto L6;
            addRepeatedField(r13, r15.next());
            goto L11
        L20:
            mergeUnknownFields(r10.getUnknownFields());
            return this;
        L23:
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream r10) throws IOException {
            return (BuilderType) mergeFrom(r10, ExtensionRegistry.getEmptyRegistry());
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            UnknownFieldSet.Builder r12 = UnknownFieldSet.newBuilder(getUnknownFields());
        L3:
            int r13 = r10.readTag();
            if (r13 == 0) goto L8;
            MessageReflection.BuilderAdapter r14 = new MessageReflection.BuilderAdapter(this);
            if (MessageReflection.mergeFieldFrom(r10, r12, r11, getDescriptorForType(), r14, r13) == true) goto L3;
        L8:
            setUnknownFields(r12.build());
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r10) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r10) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r10, int r11, int r12) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(r10, r11, r12);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(r10, r11, r12, r13);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r10) throws IOException {
            return (BuilderType) super.mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
            return (BuilderType) super.mergeFrom(r10, r11);
        }
    }

    public interface BuilderParent {
        void markDirty();
    }

    public AbstractMessage() {
        this.memoizedSize = -1;
    }

    private static boolean compareBytes(Object r10, Object r11) {
        if ((r10 instanceof byte[]) == false) goto L9;
        if ((r11 instanceof byte[]) == false) goto L9;
        return Arrays.equals((byte[]) r10, (byte[]) r11);
    L9:
        return toByteString(r10).equals(toByteString(r11));
    }

    public static boolean compareFields(Map<Descriptors.FieldDescriptor, Object> r10, Map<Descriptors.FieldDescriptor, Object> r11) {
        if (r10.size() == r11.size()) goto L5;
        return false;
    L5:
        Iterator<Descriptors.FieldDescriptor> r12 = r10.keySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L36;
        Descriptors.FieldDescriptor r13 = r12.next();
        if (r11.containsKey(r13) == false) goto L10;
        Object r14 = r10.get(r13);
        Object r15 = r11.get(r13);
        if (r13.getType() == Descriptors.FieldDescriptor.Type.BYTES) goto L14;
        if (r13.isMapField() == true) goto L31;
        if (r14.equals(r15) == true) goto L7;
        return false;
    L31:
        if (compareMapField(r14, r15) == true) goto L7;
        return false;
    L14:
        if (r13.isRepeated() == true) goto L15;
        if (compareBytes(r14, r15) == true) goto L7;
        return false;
    L15:
        List r16 = (List) r14;
        List r17 = (List) r15;
        if (r16.size() != r17.size()) goto L17;
        int r18 = 0;
    L20:
        if (r18 >= r16.size()) goto L7;
        if (compareBytes(r16.get(r18), r17.get(r18)) == false) goto L23;
        r18 = r18 + 1;
        goto L20
    L23:
        return false;
    L17:
        return false;
    L10:
        return false;
    L36:
        return true;
    }

    private static boolean compareMapField(Object r10, Object r11) {
        return MapFieldLite.equals(convertMapEntryListToMap((List) r10), convertMapEntryListToMap((List) r11));
    }

    private static Map convertMapEntryListToMap(List r10) {
        if (r10.isEmpty() == true) goto L5;
        HashMap r11 = new HashMap();
        Iterator r12 = r10.iterator();
        Message r13 = (Message) r12.next();
        Descriptors.Descriptor r14 = r13.getDescriptorForType();
        Descriptors.FieldDescriptor r15 = r14.findFieldByName("key");
        Descriptors.FieldDescriptor r16 = r14.findFieldByName(CommonKey.KEY_VALUE);
        Object r17 = r13.getField(r16);
        if ((r17 instanceof Descriptors.EnumValueDescriptor) == false) goto L9;
        r17 = Integer.valueOf(((Descriptors.EnumValueDescriptor) r17).getNumber());
    L9:
        r11.put(r13.getField(r15), r17);
    L11:
        if (r12.hasNext() == false) goto L16;
        Message r18 = (Message) r12.next();
        Object r19 = r18.getField(r16);
        if ((r19 instanceof Descriptors.EnumValueDescriptor) == false) goto L15;
        r19 = Integer.valueOf(((Descriptors.EnumValueDescriptor) r19).getNumber());
    L15:
        r11.put(r18.getField(r15), r19);
        goto L11
    L16:
        return r11;
    L5:
        return Collections.emptyMap();
    }

    @Deprecated
    public static int hashBoolean(boolean r10) {
        if (r10 == false) goto L4;
        return 1231;
    L4:
        return 1237;
    }

    @Deprecated
    public static int hashEnum(Internal.EnumLite r10) {
        return r10.getNumber();
    }

    @Deprecated
    public static int hashEnumList(List<? extends Internal.EnumLite> r10) {
        Iterator<? extends Internal.EnumLite> r11 = r10.iterator();
        int r12 = 1;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = (r12 * 31) + hashEnum(r11.next());
        goto L4
    L6:
        return r12;
    }

    public static int hashFields(int r10, Map<Descriptors.FieldDescriptor, Object> r11) {
        Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r12 = r11.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L16;
        Map.Entry<Descriptors.FieldDescriptor, Object> r13 = r12.next();
        Descriptors.FieldDescriptor r14 = r13.getKey();
        Object r15 = r13.getValue();
        int r16 = (r10 * 37) + r14.getNumber();
        if (r14.isMapField() == false) goto L10;
        int r17 = r16 * 53;
        int r18 = hashMapField(r15);
    L8:
        r10 = r17 + r18;
        goto L4
    L10:
        if (r14.getType() == Descriptors.FieldDescriptor.Type.ENUM) goto L13;
        r17 = r16 * 53;
        r18 = r15.hashCode();
        goto L8
    L13:
        if (r14.isRepeated() == false) goto L15;
        r17 = r16 * 53;
        r18 = Internal.hashEnumList((List) r15);
        goto L8
    L15:
        r17 = r16 * 53;
        r18 = Internal.hashEnum((Internal.EnumLite) r15);
        goto L8
    L16:
        return r10;
    }

    @Deprecated
    public static int hashLong(long r10) {
        return (int) (r10 ^ (r10 >>> 32));
    }

    private static int hashMapField(Object r10) {
        return MapFieldLite.calculateHashCodeForMap(convertMapEntryListToMap((List) r10));
    }

    private static ByteString toByteString(Object r10) {
        if ((r10 instanceof byte[]) == false) goto L7;
        return ByteString.copyFrom((byte[]) r10);
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Message) == true) goto L8;
        return false;
    L8:
        Message r11 = (Message) r10;
        if (getDescriptorForType() == r11.getDescriptorForType()) goto L12;
        return false;
    L12:
        if (compareFields(getAllFields(), r11.getAllFields()) == false) goto L17;
        if (getUnknownFields().equals(r11.getUnknownFields()) == false) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public List<String> findInitializationErrors() {
        return MessageReflection.findMissingFields(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public String getInitializationErrorString() {
        return MessageReflection.delimitWithCommas(findInitializationErrors());
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r10) {
        throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = MessageReflection.getSerializedSize(this, getAllFields());
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(Descriptors.OneofDescriptor r10) {
        throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }

    @Override // com.google.protobuf.Message
    public int hashCode() {
        int r10 = this.memoizedHashCode;
        if (r10 != 0) goto L6;
        int r11 = (hashFields(779 + getDescriptorForType().hashCode(), getAllFields()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return MessageReflection.isInitialized(this);
    }

    public Message.Builder newBuilderForType(BuilderParent r10) {
        throw new UnsupportedOperationException("Nested builder is not supported for this type.");
    }

    @Override // com.google.protobuf.AbstractMessageLite
    public UninitializedMessageException newUninitializedMessageException() {
        return Builder.newUninitializedMessageException(this);
    }

    @Override // com.google.protobuf.Message
    public final String toString() {
        return TextFormat.printToString(this);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r10) throws IOException {
        MessageReflection.writeMessageTo(this, getAllFields(), r10, false);
    }
}
