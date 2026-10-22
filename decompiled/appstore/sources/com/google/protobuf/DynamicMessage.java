package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class DynamicMessage extends AbstractMessage {
    private final FieldSet<Descriptors.FieldDescriptor> fields;
    private int memoizedSize;
    private final Descriptors.FieldDescriptor[] oneofCases;
    private final Descriptors.Descriptor type;
    private final UnknownFieldSet unknownFields;

    public static final class Builder extends AbstractMessage.Builder<Builder> {
        private FieldSet<Descriptors.FieldDescriptor> fields;
        private final Descriptors.FieldDescriptor[] oneofCases;
        private final Descriptors.Descriptor type;
        private UnknownFieldSet unknownFields;

        public /* synthetic */ Builder(Descriptors.Descriptor r10, AnonymousClass1 r11) {
            this(r10);
        }

        public static /* synthetic */ DynamicMessage access$000(Builder r10) throws InvalidProtocolBufferException {
            return r10.buildParsed();
        }

        private DynamicMessage buildParsed() throws InvalidProtocolBufferException {
            if (isInitialized() == true) goto L5;
            Descriptors.Descriptor r10 = this.type;
            FieldSet<Descriptors.FieldDescriptor> r11 = this.fields;
            Descriptors.FieldDescriptor[] r12 = this.oneofCases;
            throw AbstractMessage.Builder.newUninitializedMessageException(new DynamicMessage(r10, r11, (Descriptors.FieldDescriptor[]) Arrays.copyOf(r12, r12.length), this.unknownFields)).asInvalidProtocolBufferException();
        L5:
            return buildPartial();
        }

        private void ensureEnumValueDescriptor(Descriptors.FieldDescriptor r10, Object r11) {
            if (r10.isRepeated() == false) goto L8;
            Iterator r12 = ((List) r11).iterator();
        L6:
            if (r12.hasNext() == false) goto L11;
            ensureSingularEnumValueDescriptor(r10, r12.next());
            goto L6
        L11:
            return;
        L8:
            ensureSingularEnumValueDescriptor(r10, r11);
        }

        private void ensureIsMutable() {
            if (this.fields.isImmutable() == false) goto L6;
            this.fields = this.fields.clone();
            return;
        }

        private void ensureSingularEnumValueDescriptor(Descriptors.FieldDescriptor r10, Object r11) {
            if (r11 == null) goto L9;
            if ((r11 instanceof Descriptors.EnumValueDescriptor) == false) goto L7;
            return;
        L7:
            throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
        L9:
            throw null;
        }

        private void verifyContainingType(Descriptors.FieldDescriptor r10) {
            if (r10.getContainingType() != this.type) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        private void verifyOneofContainingType(Descriptors.OneofDescriptor r10) {
            if (r10.getContainingType() != this.type) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            return addRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r10) {
            return clearField(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r10) {
            return clearOneof(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return this.fields.getAllFields();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return this.type;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor r10) {
            verifyContainingType(r10);
            Object r11 = this.fields.getField(r10);
            if (r11 == null) goto L5;
            return r11;
        L5:
            if (r10.isRepeated() == false) goto L8;
            return Collections.emptyList();
        L8:
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
            return DynamicMessage.getDefaultInstance(r10.getMessageType());
        L11:
            return r10.getDefaultValue();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor r10) {
            throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r10) {
            verifyOneofContainingType(r10);
            return this.oneofCases[r10.getIndex()];
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor r10, int r11) {
            verifyContainingType(r10);
            return this.fields.getRepeatedField(r10, r11);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor r10, int r11) {
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a dynamic message type.");
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor r10) {
            verifyContainingType(r10);
            return this.fields.getRepeatedFieldCount(r10);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor r10) {
            verifyContainingType(r10);
            return this.fields.hasField(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(Descriptors.OneofDescriptor r10) {
            verifyOneofContainingType(r10);
            if (this.oneofCases[r10.getIndex()] != null) goto L6;
            return false;
        L6:
            return true;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return DynamicMessage.isInitialized(this.type, this.fields);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r10) {
            return mergeUnknownFields(r10);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForField(Descriptors.FieldDescriptor r10) {
            return newBuilderForField(r10);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            return setField(r10, r11);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            return setRepeatedField(r10, r11, r12);
        }

        @Override // com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r10) {
            return setUnknownFields(r10);
        }

        private Builder(Descriptors.Descriptor r10) {
            this.type = r10;
            this.fields = FieldSet.newFieldSet();
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            this.oneofCases = new Descriptors.FieldDescriptor[r10.toProto().getOneofDeclCount()];
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r10, Object r11) {
            verifyContainingType(r10);
            ensureIsMutable();
            this.fields.addRepeatedField(r10, r11);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor r10) {
            verifyContainingType(r10);
            ensureIsMutable();
            Descriptors.OneofDescriptor r11 = r10.getContainingOneof();
            if (r11 == null) goto L7;
            int r12 = r11.getIndex();
            Descriptors.FieldDescriptor[] r13 = this.oneofCases;
            if (r13[r12] != r10) goto L7;
            r13[r12] = null;
        L7:
            this.fields.clearField(r10);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r10) {
            return clearOneof(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r10) {
            return mergeUnknownFields(r10);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder newBuilderForField(Descriptors.FieldDescriptor r10) {
            verifyContainingType(r10);
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L7;
            return new Builder(r10.getMessageType());
        L7:
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor r10, Object r11) {
            verifyContainingType(r10);
            ensureIsMutable();
            if (r10.getType() != Descriptors.FieldDescriptor.Type.ENUM) goto L5;
            ensureEnumValueDescriptor(r10, r11);
        L5:
            Descriptors.OneofDescriptor r12 = r10.getContainingOneof();
            if (r12 == null) goto L13;
            int r13 = r12.getIndex();
            Descriptors.FieldDescriptor r14 = this.oneofCases[r13];
            if (r14 == null) goto L11;
            if (r14 == r10) goto L11;
            this.fields.clearField(r14);
        L11:
            this.oneofCases[r13] = r10;
        L22:
            this.fields.setField(r10, r11);
            return this;
        L13:
            if (r10.getFile().getSyntax() != Descriptors.FileDescriptor.Syntax.PROTO3) goto L22;
            if (r10.isRepeated() == true) goto L22;
            if (r10.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L22;
            if (r11.equals(r10.getDefaultValue()) == false) goto L22;
            this.fields.clearField(r10);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor r10, int r11, Object r12) {
            verifyContainingType(r10);
            ensureIsMutable();
            this.fields.setRepeatedField(r10, r11, r12);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setUnknownFields(UnknownFieldSet r10) {
            if (getDescriptorForType().getFile().getSyntax() != Descriptors.FileDescriptor.Syntax.PROTO3) goto L5;
            return this;
        L5:
            this.unknownFields = r10;
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public DynamicMessage build() {
            if (isInitialized() == true) goto L5;
            Descriptors.Descriptor r10 = this.type;
            FieldSet<Descriptors.FieldDescriptor> r11 = this.fields;
            Descriptors.FieldDescriptor[] r12 = this.oneofCases;
            throw AbstractMessage.Builder.newUninitializedMessageException(new DynamicMessage(r10, r11, (Descriptors.FieldDescriptor[]) Arrays.copyOf(r12, r12.length), this.unknownFields));
        L5:
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public DynamicMessage buildPartial() {
            this.fields.makeImmutable();
            Descriptors.Descriptor r10 = this.type;
            FieldSet<Descriptors.FieldDescriptor> r11 = this.fields;
            Descriptors.FieldDescriptor[] r12 = this.oneofCases;
            return new DynamicMessage(r10, r11, (Descriptors.FieldDescriptor[]) Arrays.copyOf(r12, r12.length), this.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor r10) {
            verifyOneofContainingType(r10);
            Descriptors.FieldDescriptor r11 = this.oneofCases[r10.getIndex()];
            if (r11 == null) goto L5;
            clearField(r11);
        L5:
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DynamicMessage getDefaultInstanceForType() {
            return DynamicMessage.getDefaultInstance(this.type);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof DynamicMessage) == false) goto L22;
            DynamicMessage r11 = (DynamicMessage) r10;
            if (DynamicMessage.access$200(r11) != this.type) goto L20;
            ensureIsMutable();
            this.fields.mergeFrom(DynamicMessage.access$300(r11));
            mergeUnknownFields(DynamicMessage.access$400(r11));
            int r12 = 0;
        L7:
            Descriptors.FieldDescriptor[] r13 = this.oneofCases;
            if (r12 >= r13.length) goto L18;
            if (r13[r12] != null) goto L13;
            r13[r12] = DynamicMessage.access$500(r11)[r12];
        L17:
            r12 = r12 + 1;
            goto L7
        L13:
            if (DynamicMessage.access$500(r11)[r12] == null) goto L17;
            if (this.oneofCases[r12] == DynamicMessage.access$500(r11)[r12]) goto L17;
            this.fields.clearField(this.oneofCases[r12]);
            this.oneofCases[r12] = DynamicMessage.access$500(r11)[r12];
            goto L17
        L18:
            return this;
        L20:
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        L22:
            return (Builder) super.mergeFrom(r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeUnknownFields(UnknownFieldSet r10) {
            if (getDescriptorForType().getFile().getSyntax() != Descriptors.FileDescriptor.Syntax.PROTO3) goto L5;
            return this;
        L5:
            this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(r10).build();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            if (this.fields.isImmutable() == false) goto L5;
            this.fields = FieldSet.newFieldSet();
        L6:
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            return this;
        L5:
            this.fields.clear();
            goto L6
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            Builder r10 = new Builder(this.type);
            r10.fields.mergeFrom(this.fields);
            r10.mergeUnknownFields(this.unknownFields);
            Descriptors.FieldDescriptor[] r11 = this.oneofCases;
            System.arraycopy(r11, 0, r10.oneofCases, 0, r11.length);
            return r10;
        }
    }

    public DynamicMessage(Descriptors.Descriptor r10, FieldSet<Descriptors.FieldDescriptor> r11, Descriptors.FieldDescriptor[] r12, UnknownFieldSet r13) {
        this.memoizedSize = -1;
        this.type = r10;
        this.fields = r11;
        this.oneofCases = r12;
        this.unknownFields = r13;
    }

    public static /* synthetic */ Descriptors.Descriptor access$200(DynamicMessage r10) {
        return r10.type;
    }

    public static /* synthetic */ FieldSet access$300(DynamicMessage r10) {
        return r10.fields;
    }

    public static /* synthetic */ UnknownFieldSet access$400(DynamicMessage r10) {
        return r10.unknownFields;
    }

    public static /* synthetic */ Descriptors.FieldDescriptor[] access$500(DynamicMessage r10) {
        return r10.oneofCases;
    }

    public static DynamicMessage getDefaultInstance(Descriptors.Descriptor r10) {
        Descriptors.FieldDescriptor[] r11 = new Descriptors.FieldDescriptor[r10.toProto().getOneofDeclCount()];
        return new DynamicMessage(r10, FieldSet.emptySet(), r11, UnknownFieldSet.getDefaultInstance());
    }

    public static boolean isInitialized(Descriptors.Descriptor r10, FieldSet<Descriptors.FieldDescriptor> r11) {
        Iterator<Descriptors.FieldDescriptor> r12 = r10.getFields().iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        Descriptors.FieldDescriptor r13 = r12.next();
        if (r13.isRequired() == false) goto L4;
        if (r11.hasField(r13) == true) goto L4;
        return false;
    L12:
        return r11.isInitialized();
    }

    public static Builder newBuilder(Descriptors.Descriptor r10) {
        return new Builder(r10, null);
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r10, CodedInputStream r11) throws IOException {
        return Builder.access$000(newBuilder(r10).mergeFrom(r11));
    }

    private void verifyContainingType(Descriptors.FieldDescriptor r10) {
        if (r10.getContainingType() != this.type) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }

    private void verifyOneofContainingType(Descriptors.OneofDescriptor r10) {
        if (r10.getContainingType() != this.type) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("OneofDescriptor does not match message type.");
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return this.fields.getAllFields();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return this.type;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor r10) {
        verifyContainingType(r10);
        Object r11 = this.fields.getField(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        if (r10.isRepeated() == false) goto L8;
        return Collections.emptyList();
    L8:
        if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
        return getDefaultInstance(r10.getMessageType());
    L11:
        return r10.getDefaultValue();
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor r10) {
        verifyOneofContainingType(r10);
        return this.oneofCases[r10.getIndex()];
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<DynamicMessage> getParserForType() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor r10, int r11) {
        verifyContainingType(r10);
        return this.fields.getRepeatedField(r10, r11);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor r10) {
        verifyContainingType(r10);
        return this.fields.getRepeatedFieldCount(r10);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L6;
        return r10;
    L6:
        if (this.type.getOptions().getMessageSetWireFormat() == false) goto L9;
        int r11 = this.fields.getMessageSetSerializedSize();
        int r12 = this.unknownFields.getSerializedSizeAsMessageSet();
    L8:
        int r13 = r11 + r12;
        this.memoizedSize = r13;
        return r13;
    L9:
        r11 = this.fields.getSerializedSize();
        r12 = this.unknownFields.getSerializedSize();
        goto L8
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor r10) {
        verifyContainingType(r10);
        return this.fields.hasField(r10);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(Descriptors.OneofDescriptor r10) {
        verifyOneofContainingType(r10);
        if (this.oneofCases[r10.getIndex()] != null) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r10) throws IOException {
        if (this.type.getOptions().getMessageSetWireFormat() == false) goto L5;
        this.fields.writeMessageSetTo(r10);
        this.unknownFields.writeAsMessageSetTo(r10);
        return;
    L5:
        this.fields.writeTo(r10);
        this.unknownFields.writeTo(r10);
    }

    public static Builder newBuilder(Message r10) {
        return new Builder(r10.getDescriptorForType(), null).mergeFrom(r10);
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r10, CodedInputStream r11, ExtensionRegistry r12) throws IOException {
        return Builder.access$000(newBuilder(r10).mergeFrom(r11, r12));
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r10, ByteString r11) throws InvalidProtocolBufferException {
        return Builder.access$000(newBuilder(r10).mergeFrom(r11));
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public DynamicMessage getDefaultInstanceForType() {
        return getDefaultInstance(this.type);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return new Builder(this.type, null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return newBuilderForType().mergeFrom(this);
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r10, ByteString r11, ExtensionRegistry r12) throws InvalidProtocolBufferException {
        return Builder.access$000(newBuilder(r10).mergeFrom(r11, r12));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r10, byte[] r11) throws InvalidProtocolBufferException {
        return Builder.access$000(newBuilder(r10).mergeFrom(r11));
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return isInitialized(this.type, this.fields);
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r10, byte[] r11, ExtensionRegistry r12) throws InvalidProtocolBufferException {
        return Builder.access$000(newBuilder(r10).mergeFrom(r11, r12));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r10, InputStream r11) throws IOException {
        return Builder.access$000(newBuilder(r10).mergeFrom(r11));
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor r10, InputStream r11, ExtensionRegistry r12) throws IOException {
        return Builder.access$000(newBuilder(r10).mergeFrom(r11, r12));
    }
}
