package com.bytedance.location.protobuf;

import com.bytedance.location.protobuf.AbstractMessageLite;
import com.bytedance.location.protobuf.AbstractMessageLite.Builder;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode;

    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {

        static final class LimitedInputStream extends FilterInputStream {
            private int limit;

            LimitedInputStream(InputStream in, int limit) {
                super(in);
                this.limit = limit;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.limit);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.limit > 0) goto L6;
                return -1;
            L6:
                int result = super.read();
                if (result < 0) goto L9;
                this.limit--;
            L9:
                return result;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] b, int off, int len) throws IOException {
                if (this.limit > 0) goto L6;
                return -1;
            L6:
                int result = super.read(b, off, Math.min(len, this.limit));
                if (result < 0) goto L9;
                this.limit -= result;
            L9:
                return result;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long n) throws IOException {
                int result = (int) super.skip(Math.min(n, this.limit));
                if (result < 0) goto L6;
                this.limit -= result;
            L6:
                return result;
            }
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public abstract BuilderType clone();

        protected abstract BuilderType internalMergeFrom(MessageType r1);

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public abstract BuilderType mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException;

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object mo10504clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r1) throws InvalidProtocolBufferException {
            return mergeFrom(r1);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return mergeFrom(r1, r2);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1) throws IOException {
            return mergeFrom(r1);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
            return mergeFrom(r1, r2);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(MessageLite r1) {
            return mergeFrom(r1);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r1) throws IOException {
            return mergeFrom(r1);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return mergeFrom(r1, r2);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1) throws InvalidProtocolBufferException {
            return mergeFrom(r1);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1, int r2, int r3) throws InvalidProtocolBufferException {
            return mergeFrom(r1, r2, r3);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
            return mergeFrom(r1, r2, r3, r4);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return mergeFrom(r1, r2);
        }

        public Builder() {
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(CodedInputStream r2) throws IOException {
            return (BuilderType) mergeFrom(r2, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(ByteString data) throws InvalidProtocolBufferException {
            CodedInputStream input = data.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            mergeFrom(input);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            input.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            return this;
        L6:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("ByteString"), e);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            CodedInputStream input = data.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            mergeFrom(input, extensionRegistry);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            input.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            return this;
        L6:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("ByteString"), e);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] r3) throws InvalidProtocolBufferException {
            return (BuilderType) mergeFrom(r3, 0, r3.length);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
            CodedInputStream input = CodedInputStream.newInstance(data, off, len);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            mergeFrom(input);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            input.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            return this;
        L6:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("byte array"), e);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
            return (BuilderType) mergeFrom(r3, 0, r3.length, r4);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            CodedInputStream input = CodedInputStream.newInstance(data, off, len);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            mergeFrom(input, extensionRegistry);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            input.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            return this;
        L6:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("byte array"), e);
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(InputStream input) throws IOException {
            CodedInputStream codedInput = CodedInputStream.newInstance(input);
            mergeFrom(codedInput);
            codedInput.checkLastTagWas(0);
            return this;
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            CodedInputStream codedInput = CodedInputStream.newInstance(input);
            mergeFrom(codedInput, extensionRegistry);
            codedInput.checkLastTagWas(0);
            return this;
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            int firstByte = input.read();
            if (firstByte != (-1)) goto L6;
            return false;
        L6:
            int size = CodedInputStream.readRawVarint32(firstByte, input);
            InputStream limitedInput = new LimitedInputStream(input, size);
            mergeFrom(limitedInput, extensionRegistry);
            return true;
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream input) throws IOException {
            return mergeDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.bytedance.location.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(MessageLite r3) {
            if (getDefaultInstanceForType().getClass().isInstance(r3) == false) goto L7;
            return (BuilderType) internalMergeFrom((AbstractMessageLite) r3);
        L7:
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        private String getReadingExceptionMessage(String target) {
            return "Reading " + getClass().getName() + " from a " + target + " threw an IOException (should never happen).";
        }

        private static <T> void addAllCheckingNulls(Iterable<T> values, List<? super T> list) {
            if ((list instanceof ArrayList) == true) goto L5;
        L7:
            int begin = list.size();
            Iterator<T> r1 = values.iterator();
        L9:
            if (r1.hasNext() == false) goto L18;
            T value = r1.next();
            if (value == null) goto L12;
            list.add(value);
            goto L9
        L12:
            String message = "Element at index " + (list.size() - begin) + " is null.";
            int i = list.size() - 1;
        L13:
            if (i < begin) goto L16;
            list.remove(i);
            i = i - 1;
            goto L13
        L16:
            throw new NullPointerException(message);
        L18:
            return;
        L5:
            if ((values instanceof Collection) == false) goto L7;
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) values).size());
            goto L7
        }

        protected static UninitializedMessageException newUninitializedMessageException(MessageLite message) {
            return new UninitializedMessageException(message);
        }

        @Deprecated
        protected static <T> void addAll(Iterable<T> values, Collection<? super T> list) {
            addAll(values, (List) list);
        }

        protected static <T> void addAll(Iterable<T> values, List<? super T> list) {
            Internal.checkNotNull(values);
            if ((values instanceof LazyStringList) == false) goto L21;
            List<?> lazyValues = ((LazyStringList) values).getUnderlyingElements();
            LazyStringList lazyList = (LazyStringList) list;
            int begin = list.size();
            Iterator<?> r3 = lazyValues.iterator();
        L6:
            if (r3.hasNext() == false) goto L34;
            Object value = r3.next();
            if (value == null) goto L9;
            if ((value instanceof ByteString) == true) goto L16;
            lazyList.add((String) value);
            goto L6
        L16:
            lazyList.add((ByteString) value);
            goto L6
        L9:
            String message = "Element at index " + (lazyList.size() - begin) + " is null.";
            int i = lazyList.size() - 1;
        L10:
            if (i < begin) goto L13;
            lazyList.remove(i);
            i = i - 1;
            goto L10
        L13:
            throw new NullPointerException(message);
        L34:
            return;
        L21:
            if ((values instanceof PrimitiveNonBoxingCollection) == false) goto L23;
            list.addAll((Collection) values);
            return;
        L23:
            addAllCheckingNulls(values, list);
        }
    }

    protected interface InternalOneOfEnum {
        int getNumber();
    }

    public AbstractMessageLite() {
        this.memoizedHashCode = 0;
    }

    @Override // com.bytedance.location.protobuf.MessageLite
    public ByteString toByteString() {
        ByteString.CodedBuilder out = ByteString.newCodedBuilder(getSerializedSize());     // Catch: IOException -> L4
        writeTo(out.getCodedOutput());     // Catch: IOException -> L4
        return out.build();
    L4:
        e = move-exception;
        throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e);
    }

    @Override // com.bytedance.location.protobuf.MessageLite
    public byte[] toByteArray() {
        byte[] result = new byte[getSerializedSize()];     // Catch: IOException -> L4
        CodedOutputStream output = CodedOutputStream.newInstance(result);     // Catch: IOException -> L4
        writeTo(output);     // Catch: IOException -> L4
        output.checkNoSpaceLeft();     // Catch: IOException -> L4
        return result;
    L4:
        e = move-exception;
        throw new RuntimeException(getSerializingExceptionMessage("byte array"), e);
    }

    @Override // com.bytedance.location.protobuf.MessageLite
    public void writeTo(OutputStream output) throws IOException {
        int bufferSize = CodedOutputStream.computePreferredBufferSize(getSerializedSize());
        CodedOutputStream codedOutput = CodedOutputStream.newInstance(output, bufferSize);
        writeTo(codedOutput);
        codedOutput.flush();
    }

    @Override // com.bytedance.location.protobuf.MessageLite
    public void writeDelimitedTo(OutputStream output) throws IOException {
        int serialized = getSerializedSize();
        int bufferSize = CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeUInt32SizeNoTag(serialized) + serialized);
        CodedOutputStream codedOutput = CodedOutputStream.newInstance(output, bufferSize);
        codedOutput.writeUInt32NoTag(serialized);
        writeTo(codedOutput);
        codedOutput.flush();
    }

    int getMemoizedSerializedSize() {
        throw new UnsupportedOperationException();
    }

    void setMemoizedSerializedSize(int size) {
        throw new UnsupportedOperationException();
    }

    int getSerializedSize(Schema schema) {
        int memoizedSerializedSize = getMemoizedSerializedSize();
        if (memoizedSerializedSize != (-1)) goto L6;
        int memoizedSerializedSize2 = schema.getSerializedSize(this);
        setMemoizedSerializedSize(memoizedSerializedSize2);
        return memoizedSerializedSize2;
    L6:
        return memoizedSerializedSize;
    }

    UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    private String getSerializingExceptionMessage(String target) {
        return "Serializing " + getClass().getName() + " to a " + target + " threw an IOException (should never happen).";
    }

    protected static void checkByteStringIsUtf8(ByteString byteString) throws IllegalArgumentException {
        if (byteString.isValidUtf8() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Byte string is not UTF-8.");
    }

    @Deprecated
    protected static <T> void addAll(Iterable<T> values, Collection<? super T> list) {
        Builder.addAll(values, (List) list);
    }

    protected static <T> void addAll(Iterable<T> values, List<? super T> list) {
        Builder.addAll(values, list);
    }
}
