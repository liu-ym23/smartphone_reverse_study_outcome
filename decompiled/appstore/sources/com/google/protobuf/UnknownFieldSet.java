package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public final class UnknownFieldSet implements MessageLite {
    private static final Parser PARSER = null;
    private static final UnknownFieldSet defaultInstance = null;
    private Map<Integer, Field> fields;

    /* JADX INFO: renamed from: com.google.protobuf.UnknownFieldSet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder implements MessageLite.Builder {
        private Map<Integer, Field> fields;
        private Field.Builder lastField;
        private int lastFieldNumber;

        private Builder() {
        }

        public static /* synthetic */ Builder access$000() {
            return create();
        }

        private static Builder create() {
            Builder r10 = new Builder();
            r10.reinitialize();
            return r10;
        }

        private Field.Builder getFieldBuilder(int r10) {
            Field.Builder r11 = this.lastField;
            if (r11 == null) goto L8;
            int r12 = this.lastFieldNumber;
            if (r10 != r12) goto L7;
            return r11;
        L7:
            addField(r12, r11.build());
        L8:
            if (r10 != 0) goto L11;
            return null;
        L11:
            Field r13 = this.fields.get(Integer.valueOf(r10));
            this.lastFieldNumber = r10;
            Field.Builder r14 = Field.newBuilder();
            this.lastField = r14;
            if (r13 == null) goto L15;
            r14.mergeFrom(r13);
        L15:
            return this.lastField;
        }

        private void reinitialize() {
            this.fields = Collections.emptyMap();
            this.lastFieldNumber = 0;
            this.lastField = null;
        }

        public Builder addField(int r10, Field r11) {
            if (r10 == 0) goto L14;
            if (this.lastField == null) goto L9;
            if (this.lastFieldNumber != r10) goto L9;
            this.lastField = null;
            this.lastFieldNumber = 0;
        L9:
            if (this.fields.isEmpty() == false) goto L11;
            this.fields = new TreeMap();
        L11:
            this.fields.put(Integer.valueOf(r10), r11);
            return this;
        L14:
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public Map<Integer, Field> asMap() {
            getFieldBuilder(0);
            return Collections.unmodifiableMap(this.fields);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        public Builder clearField(int r10) {
            if (r10 == 0) goto L13;
            if (this.lastField == null) goto L9;
            if (this.lastFieldNumber != r10) goto L9;
            this.lastField = null;
            this.lastFieldNumber = 0;
        L9:
            if (this.fields.containsKey(Integer.valueOf(r10)) == false) goto L11;
            this.fields.remove(Integer.valueOf(r10));
        L11:
            return this;
        L13:
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public boolean hasField(int r10) {
            if (r10 == 0) goto L12;
            if (r10 != this.lastFieldNumber) goto L6;
        L9:
            return true;
        L6:
            if (this.fields.containsKey(Integer.valueOf(r10)) == true) goto L9;
            return false;
        L12:
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(InputStream r10) throws IOException {
            int r11 = r10.read();
            if (r11 != (-1)) goto L6;
            return false;
        L6:
            mergeFrom(new AbstractMessageLite.Builder.LimitedInputStream(r10, CodedInputStream.readRawVarint32(r11, r10)));
            return true;
        }

        public Builder mergeField(int r10, Field r11) {
            if (r10 == 0) goto L9;
            if (hasField(r10) == false) goto L6;
            getFieldBuilder(r10).mergeFrom(r11);
        L7:
            return this;
        L6:
            addField(r10, r11);
            goto L7
        L9:
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public boolean mergeFieldFrom(int r10, CodedInputStream r11) throws IOException {
            int r12 = WireFormat.getTagFieldNumber(r10);
            int r13 = WireFormat.getTagWireType(r10);
            if (r13 == 0) goto L25;
            if (r13 != 1) goto L6;
            getFieldBuilder(r12).addFixed64(r11.readFixed64());
            return true;
        L6:
            if (r13 != 2) goto L8;
            getFieldBuilder(r12).addLengthDelimited(r11.readBytes());
            return true;
        L8:
            if (r13 != 3) goto L10;
            Builder r14 = UnknownFieldSet.newBuilder();
            r11.readGroup(r12, r14, ExtensionRegistry.getEmptyRegistry());
            getFieldBuilder(r12).addGroup(r14.build());
            return true;
        L10:
            if (r13 != 4) goto L12;
            return false;
        L12:
            if (r13 != 5) goto L16;
            getFieldBuilder(r12).addFixed32(r11.readFixed32());
            return true;
        L16:
            throw InvalidProtocolBufferException.invalidWireType();
        L25:
            getFieldBuilder(r12).addVarint(r11.readInt64());
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r10) throws InvalidProtocolBufferException {
            return mergeFrom(r10);
        }

        public Builder mergeLengthDelimitedField(int r10, ByteString r11) {
            if (r10 == 0) goto L6;
            getFieldBuilder(r10).addLengthDelimited(r11);
            return this;
        L6:
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public Builder mergeVarintField(int r10, int r11) {
            if (r10 == 0) goto L6;
            getFieldBuilder(r10).addVarint(r11);
            return this;
        L6:
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public UnknownFieldSet build() {
            getFieldBuilder(0);
            AnonymousClass1 r10 = null;
            if (this.fields.isEmpty() == false) goto L5;
            UnknownFieldSet r11 = UnknownFieldSet.getDefaultInstance();
        L6:
            this.fields = null;
            return r11;
        L5:
            r11 = new UnknownFieldSet(Collections.unmodifiableMap(this.fields), r10);
            goto L6
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public UnknownFieldSet buildPartial() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            reinitialize();
            return this;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m13clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UnknownFieldSet getDefaultInstanceForType() {
            return UnknownFieldSet.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            getFieldBuilder(0);
            return UnknownFieldSet.newBuilder().mergeFrom(new UnknownFieldSet(this.fields, null));
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10) throws IOException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeDelimitedFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(MessageLite r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r10) throws IOException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10) throws InvalidProtocolBufferException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10, int r11, int r12) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11, r12);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11, r12, r13);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11);
        }

        public Builder mergeFrom(UnknownFieldSet r10) {
            if (r10 == UnknownFieldSet.getDefaultInstance()) goto L8;
            Iterator r11 = UnknownFieldSet.access$200(r10).entrySet().iterator();
        L6:
            if (r11.hasNext() == false) goto L8;
            Map.Entry r12 = (Map.Entry) r11.next();
            mergeField(((Integer) r12.getKey()).intValue(), (Field) r12.getValue());
        L8:
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r10) throws IOException {
        L2:
            int r11 = r10.readTag();
            if (r11 == 0) goto L6;
            if (mergeFieldFrom(r11, r10) == true) goto L2;
        L6:
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(ByteString r10) throws InvalidProtocolBufferException {
            CodedInputStream r11 = r10.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            mergeFrom(r11);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            r11.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            return this;
        L6:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r10) throws InvalidProtocolBufferException {
            CodedInputStream r11 = CodedInputStream.newInstance(r10);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            mergeFrom(r11);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            r11.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            return this;
        L6:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(InputStream r10) throws IOException {
            CodedInputStream r11 = CodedInputStream.newInstance(r10);
            mergeFrom(r11);
            r11.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r10, int r11, int r12) throws InvalidProtocolBufferException {
            CodedInputStream r13 = CodedInputStream.newInstance(r10, r11, r12);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            mergeFrom(r13);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            r13.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            return this;
        L6:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11, r12);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(MessageLite r10) {
            if ((r10 instanceof UnknownFieldSet) == false) goto L7;
            return mergeFrom((UnknownFieldSet) r10);
        L7:
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    public static final class Field {
        private static final Field fieldDefaultInstance = null;
        private List<Integer> fixed32;
        private List<Long> fixed64;
        private List<UnknownFieldSet> group;
        private List<ByteString> lengthDelimited;
        private List<Long> varint;

        public static final class Builder {
            private Field result;

            private Builder() {
            }

            public static /* synthetic */ Builder access$300() {
                return create();
            }

            private static Builder create() {
                Builder r10 = new Builder();
                r10.result = new Field(null);
                return r10;
            }

            public Builder addFixed32(int r10) {
                if (Field.access$600(this.result) != null) goto L5;
                Field.access$602(this.result, new ArrayList());
            L5:
                Field.access$600(this.result).add(Integer.valueOf(r10));
                return this;
            }

            public Builder addFixed64(long r10) {
                if (Field.access$700(this.result) != null) goto L5;
                Field.access$702(this.result, new ArrayList());
            L5:
                Field.access$700(this.result).add(Long.valueOf(r10));
                return this;
            }

            public Builder addGroup(UnknownFieldSet r10) {
                if (Field.access$900(this.result) != null) goto L5;
                Field.access$902(this.result, new ArrayList());
            L5:
                Field.access$900(this.result).add(r10);
                return this;
            }

            public Builder addLengthDelimited(ByteString r10) {
                if (Field.access$800(this.result) != null) goto L5;
                Field.access$802(this.result, new ArrayList());
            L5:
                Field.access$800(this.result).add(r10);
                return this;
            }

            public Builder addVarint(long r10) {
                if (Field.access$500(this.result) != null) goto L5;
                Field.access$502(this.result, new ArrayList());
            L5:
                Field.access$500(this.result).add(Long.valueOf(r10));
                return this;
            }

            public Field build() {
                if (Field.access$500(this.result) != null) goto L5;
                Field.access$502(this.result, Collections.emptyList());
            L7:
                if (Field.access$600(this.result) != null) goto L9;
                Field.access$602(this.result, Collections.emptyList());
            L11:
                if (Field.access$700(this.result) != null) goto L13;
                Field.access$702(this.result, Collections.emptyList());
            L15:
                if (Field.access$800(this.result) != null) goto L17;
                Field.access$802(this.result, Collections.emptyList());
            L19:
                if (Field.access$900(this.result) != null) goto L21;
                Field.access$902(this.result, Collections.emptyList());
            L22:
                Field r10 = this.result;
                this.result = null;
                return r10;
            L21:
                Field r11 = this.result;
                Field.access$902(r11, Collections.unmodifiableList(Field.access$900(r11)));
                goto L22
            L17:
                Field r12 = this.result;
                Field.access$802(r12, Collections.unmodifiableList(Field.access$800(r12)));
                goto L19
            L13:
                Field r13 = this.result;
                Field.access$702(r13, Collections.unmodifiableList(Field.access$700(r13)));
                goto L15
            L9:
                Field r14 = this.result;
                Field.access$602(r14, Collections.unmodifiableList(Field.access$600(r14)));
                goto L11
            L5:
                Field r15 = this.result;
                Field.access$502(r15, Collections.unmodifiableList(Field.access$500(r15)));
                goto L7
            }

            public Builder clear() {
                this.result = new Field(null);
                return this;
            }

            public Builder mergeFrom(Field r10) {
                if (Field.access$500(r10).isEmpty() == true) goto L9;
                if (Field.access$500(this.result) != null) goto L7;
                Field.access$502(this.result, new ArrayList());
            L7:
                Field.access$500(this.result).addAll(Field.access$500(r10));
            L9:
                if (Field.access$600(r10).isEmpty() == true) goto L15;
                if (Field.access$600(this.result) != null) goto L13;
                Field.access$602(this.result, new ArrayList());
            L13:
                Field.access$600(this.result).addAll(Field.access$600(r10));
            L15:
                if (Field.access$700(r10).isEmpty() == true) goto L21;
                if (Field.access$700(this.result) != null) goto L19;
                Field.access$702(this.result, new ArrayList());
            L19:
                Field.access$700(this.result).addAll(Field.access$700(r10));
            L21:
                if (Field.access$800(r10).isEmpty() == true) goto L27;
                if (Field.access$800(this.result) != null) goto L25;
                Field.access$802(this.result, new ArrayList());
            L25:
                Field.access$800(this.result).addAll(Field.access$800(r10));
            L27:
                if (Field.access$900(r10).isEmpty() == false) goto L29;
            L32:
                return this;
            L29:
                if (Field.access$900(this.result) != null) goto L31;
                Field.access$902(this.result, new ArrayList());
            L31:
                Field.access$900(this.result).addAll(Field.access$900(r10));
                goto L32
            }
        }

        static {
            fieldDefaultInstance = newBuilder().build();
        }

        public /* synthetic */ Field(AnonymousClass1 r10) {
            this();
        }

        public static /* synthetic */ List access$500(Field r10) {
            return r10.varint;
        }

        public static /* synthetic */ List access$502(Field r10, List r11) {
            r10.varint = r11;
            return r11;
        }

        public static /* synthetic */ List access$600(Field r10) {
            return r10.fixed32;
        }

        public static /* synthetic */ List access$602(Field r10, List r11) {
            r10.fixed32 = r11;
            return r11;
        }

        public static /* synthetic */ List access$700(Field r10) {
            return r10.fixed64;
        }

        public static /* synthetic */ List access$702(Field r10, List r11) {
            r10.fixed64 = r11;
            return r11;
        }

        public static /* synthetic */ List access$800(Field r10) {
            return r10.lengthDelimited;
        }

        public static /* synthetic */ List access$802(Field r10, List r11) {
            r10.lengthDelimited = r11;
            return r11;
        }

        public static /* synthetic */ List access$900(Field r10) {
            return r10.group;
        }

        public static /* synthetic */ List access$902(Field r10, List r11) {
            r10.group = r11;
            return r11;
        }

        public static Field getDefaultInstance() {
            return fieldDefaultInstance;
        }

        private Object[] getIdentityArray() {
            return new Object[]{this.varint, this.fixed32, this.fixed64, this.lengthDelimited, this.group};
        }

        public static Builder newBuilder() {
            return Builder.access$300();
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Field) == true) goto L10;
            return false;
        L10:
            return Arrays.equals(getIdentityArray(), ((Field) r10).getIdentityArray());
        }

        public List<Integer> getFixed32List() {
            return this.fixed32;
        }

        public List<Long> getFixed64List() {
            return this.fixed64;
        }

        public List<UnknownFieldSet> getGroupList() {
            return this.group;
        }

        public List<ByteString> getLengthDelimitedList() {
            return this.lengthDelimited;
        }

        public int getSerializedSize(int r10) {
            Iterator<Long> r11 = this.varint.iterator();
            int r12 = 0;
        L4:
            if (r11.hasNext() == false) goto L6;
            r12 = r12 + CodedOutputStream.computeUInt64Size(r10, r11.next().longValue());
            goto L4
        L6:
            Iterator<Integer> r13 = this.fixed32.iterator();
        L8:
            if (r13.hasNext() == false) goto L10;
            r12 = r12 + CodedOutputStream.computeFixed32Size(r10, r13.next().intValue());
            goto L8
        L10:
            Iterator<Long> r14 = this.fixed64.iterator();
        L12:
            if (r14.hasNext() == false) goto L14;
            r12 = r12 + CodedOutputStream.computeFixed64Size(r10, r14.next().longValue());
            goto L12
        L14:
            Iterator<ByteString> r15 = this.lengthDelimited.iterator();
        L16:
            if (r15.hasNext() == false) goto L18;
            r12 = r12 + CodedOutputStream.computeBytesSize(r10, r15.next());
            goto L16
        L18:
            Iterator<UnknownFieldSet> r16 = this.group.iterator();
        L20:
            if (r16.hasNext() == false) goto L22;
            r12 = r12 + CodedOutputStream.computeGroupSize(r10, r16.next());
            goto L20
        L22:
            return r12;
        }

        public int getSerializedSizeAsMessageSetExtension(int r10) {
            Iterator<ByteString> r11 = this.lengthDelimited.iterator();
            int r12 = 0;
        L4:
            if (r11.hasNext() == false) goto L6;
            r12 = r12 + CodedOutputStream.computeRawMessageSetExtensionSize(r10, r11.next());
            goto L4
        L6:
            return r12;
        }

        public List<Long> getVarintList() {
            return this.varint;
        }

        public int hashCode() {
            return Arrays.hashCode(getIdentityArray());
        }

        public void writeAsMessageSetExtensionTo(int r10, CodedOutputStream r11) throws IOException {
            Iterator<ByteString> r12 = this.lengthDelimited.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            r11.writeRawMessageSetExtension(r10, r12.next());
            goto L4
        }

        public void writeTo(int r10, CodedOutputStream r11) throws IOException {
            Iterator<Long> r12 = this.varint.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            r11.writeUInt64(r10, r12.next().longValue());
            goto L4
        L6:
            Iterator<Integer> r13 = this.fixed32.iterator();
        L8:
            if (r13.hasNext() == false) goto L10;
            r11.writeFixed32(r10, r13.next().intValue());
            goto L8
        L10:
            Iterator<Long> r14 = this.fixed64.iterator();
        L12:
            if (r14.hasNext() == false) goto L14;
            r11.writeFixed64(r10, r14.next().longValue());
            goto L12
        L14:
            Iterator<ByteString> r15 = this.lengthDelimited.iterator();
        L16:
            if (r15.hasNext() == false) goto L18;
            r11.writeBytes(r10, r15.next());
            goto L16
        L18:
            Iterator<UnknownFieldSet> r16 = this.group.iterator();
        L20:
            if (r16.hasNext() == false) goto L22;
            r11.writeGroup(r10, r16.next());
            goto L20
        }

        private Field() {
        }

        public static Builder newBuilder(Field r10) {
            return newBuilder().mergeFrom(r10);
        }
    }

    public static final class Parser extends AbstractParser<UnknownFieldSet> {
        public Parser() {
        }

        @Override // com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return parsePartialFrom(r10, r11);
        }

        @Override // com.google.protobuf.Parser
        public UnknownFieldSet parsePartialFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            Builder r12 = UnknownFieldSet.newBuilder();
            r12.mergeFrom(r10);     // Catch: IOException -> L6 InvalidProtocolBufferException -> L9
        L5:
            return r12.buildPartial();
        L9:
            e = move-exception;
            throw e.setUnfinishedMessage(r12.buildPartial());
        L6:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(r12.buildPartial());
        }
    }

    static {
        defaultInstance = new UnknownFieldSet(Collections.emptyMap());
        PARSER = new Parser();
    }

    public /* synthetic */ UnknownFieldSet(Map r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static /* synthetic */ Map access$200(UnknownFieldSet r10) {
        return r10.fields;
    }

    public static UnknownFieldSet getDefaultInstance() {
        return defaultInstance;
    }

    public static Builder newBuilder() {
        return Builder.access$000();
    }

    public static UnknownFieldSet parseFrom(CodedInputStream r10) throws IOException {
        return newBuilder().mergeFrom(r10).build();
    }

    public Map<Integer, Field> asMap() {
        return this.fields;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof UnknownFieldSet) == true) goto L8;
    L10:
        return false;
    L8:
        if (this.fields.equals(((UnknownFieldSet) r10).fields) == false) goto L10;
        return true;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public Field getField(int r10) {
        Field r11 = this.fields.get(Integer.valueOf(r10));
        if (r11 == null) goto L5;
        return r11;
    L5:
        return Field.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ com.google.protobuf.Parser getParserForType() {
        return getParserForType();
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        Iterator<Map.Entry<Integer, Field>> r10 = this.fields.entrySet().iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<Integer, Field> r12 = r10.next();
        r11 = r11 + r12.getValue().getSerializedSize(r12.getKey().intValue());
        goto L4
    L6:
        return r11;
    }

    public int getSerializedSizeAsMessageSet() {
        Iterator<Map.Entry<Integer, Field>> r10 = this.fields.entrySet().iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<Integer, Field> r12 = r10.next();
        r11 = r11 + r12.getValue().getSerializedSizeAsMessageSetExtension(r12.getKey().intValue());
        goto L4
    L6:
        return r11;
    }

    public boolean hasField(int r10) {
        return this.fields.containsKey(Integer.valueOf(r10));
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLite
    public byte[] toByteArray() {
        byte[] r10 = new byte[getSerializedSize()];     // Catch: IOException -> L4
        CodedOutputStream r11 = CodedOutputStream.newInstance(r10);     // Catch: IOException -> L4
        writeTo(r11);     // Catch: IOException -> L4
        r11.checkNoSpaceLeft();     // Catch: IOException -> L4
        return r10;
    L4:
        e = move-exception;
        throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
    }

    @Override // com.google.protobuf.MessageLite
    public ByteString toByteString() {
        ByteString.CodedBuilder r10 = ByteString.newCodedBuilder(getSerializedSize());     // Catch: IOException -> L4
        writeTo(r10.getCodedOutput());     // Catch: IOException -> L4
        return r10.build();
    L4:
        e = move-exception;
        throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
    }

    public String toString() {
        return TextFormat.printToString(this);
    }

    public void writeAsMessageSetTo(CodedOutputStream r10) throws IOException {
        Iterator<Map.Entry<Integer, Field>> r11 = this.fields.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<Integer, Field> r12 = r11.next();
        r12.getValue().writeAsMessageSetExtensionTo(r12.getKey().intValue(), r10);
        goto L4
    }

    @Override // com.google.protobuf.MessageLite
    public void writeDelimitedTo(OutputStream r10) throws IOException {
        CodedOutputStream r11 = CodedOutputStream.newInstance(r10);
        r11.writeRawVarint32(getSerializedSize());
        writeTo(r11);
        r11.flush();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r10) throws IOException {
        Iterator<Map.Entry<Integer, Field>> r11 = this.fields.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<Integer, Field> r12 = r11.next();
        r12.getValue().writeTo(r12.getKey().intValue(), r10);
        goto L4
    }

    private UnknownFieldSet() {
    }

    public static Builder newBuilder(UnknownFieldSet r10) {
        return newBuilder().mergeFrom(r10);
    }

    public static UnknownFieldSet parseFrom(ByteString r10) throws InvalidProtocolBufferException {
        return newBuilder().mergeFrom(r10).build();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getDefaultInstanceForType() {
        return defaultInstance;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public final Parser getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return newBuilder().mergeFrom(this);
    }

    private UnknownFieldSet(Map<Integer, Field> r10) {
        this.fields = r10;
    }

    public static UnknownFieldSet parseFrom(byte[] r10) throws InvalidProtocolBufferException {
        return newBuilder().mergeFrom(r10).build();
    }

    public static UnknownFieldSet parseFrom(InputStream r10) throws IOException {
        return newBuilder().mergeFrom(r10).build();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(OutputStream r10) throws IOException {
        CodedOutputStream r11 = CodedOutputStream.newInstance(r10);
        writeTo(r11);
        r11.flush();
    }
}
