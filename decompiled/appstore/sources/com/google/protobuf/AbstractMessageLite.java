package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractMessageLite.Builder;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode;

    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {

        public static final class LimitedInputStream extends FilterInputStream {
            private int limit;

            public LimitedInputStream(InputStream r10, int r11) {
                super(r10);
                this.limit = r11;
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
                int r10 = super.read();
                if (r10 < 0) goto L9;
                this.limit--;
            L9:
                return r10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long r10) throws IOException {
                long r11 = super.skip(Math.min(r10, this.limit));
                if (r11 < 0) goto L5;
                this.limit = (int) (((long) this.limit) - r11);
            L5:
                return r11;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] r10, int r11, int r12) throws IOException {
                int r13 = this.limit;
                if (r13 > 0) goto L6;
                return -1;
            L6:
                int r14 = super.read(r10, r11, Math.min(r12, r13));
                if (r14 < 0) goto L9;
                this.limit -= r14;
            L9:
                return r14;
            }
        }

        public Builder() {
        }

        public static <T> void addAll(Iterable<T> r10, Collection<? super T> r11) {
            if (r10 != null) goto L5;
            throw null;
        L5:
            if ((r10 instanceof LazyStringList) == false) goto L8;
            checkForNullValues(((LazyStringList) r10).getUnderlyingElements());
            r11.addAll((Collection) r10);
            return;
        L8:
            if ((r10 instanceof Collection) == false) goto L10;
            checkForNullValues(r10);
            r11.addAll((Collection) r10);
            return;
        L10:
            Iterator<T> r12 = r10.iterator();
        L12:
            if (r12.hasNext() == false) goto L22;
            T r13 = r12.next();
            if (r13 == null) goto L16;
            r11.add(r13);
            goto L12
        L16:
            throw null;
        }

        private static void checkForNullValues(Iterable<?> r10) {
            Iterator<?> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L10;
            if (r11.next() != null) goto L4;
            throw null;
        }

        private String getReadingExceptionMessage(String r10) {
            return "Reading " + getClass().getName() + " from a " + r10 + " threw an IOException (should never happen).";
        }

        public static UninitializedMessageException newUninitializedMessageException(MessageLite r10) {
            return new UninitializedMessageException(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public abstract BuilderType clone();

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        public abstract BuilderType internalMergeFrom(MessageType r10);

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
            int r12 = r10.read();
            if (r12 != (-1)) goto L6;
            return false;
        L6:
            mergeFrom(new LimitedInputStream(r10, CodedInputStream.readRawVarint32(r12, r10)), r11);
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public abstract BuilderType mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException;

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r10) throws InvalidProtocolBufferException {
            return mergeFrom(r10);
        }

        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return mergeFrom(r10, r11);
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
        public boolean mergeDelimitedFrom(InputStream r10) throws IOException {
            return mergeDelimitedFrom(r10, ExtensionRegistryLite.getEmptyRegistry());
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

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream r10) throws IOException {
            return (BuilderType) mergeFrom(r10, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r10) throws InvalidProtocolBufferException {
            CodedInputStream r11 = r10.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            mergeFrom(r11);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            r11.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            return this;
        L6:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("ByteString"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            CodedInputStream r12 = r10.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            mergeFrom(r12, r11);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            r12.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            return this;
        L6:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("ByteString"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r10) throws InvalidProtocolBufferException {
            return (BuilderType) mergeFrom(r10, 0, r10.length);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r10, int r11, int r12) throws InvalidProtocolBufferException {
            CodedInputStream r13 = CodedInputStream.newInstance(r10, r11, r12);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            mergeFrom(r13);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            r13.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            return this;
        L6:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("byte array"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            return (BuilderType) mergeFrom(r10, 0, r10.length, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
            CodedInputStream r14 = CodedInputStream.newInstance(r10, r11, r12);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            mergeFrom(r14, r13);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            r14.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L6
            return this;
        L6:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("byte array"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r10) throws IOException {
            CodedInputStream r11 = CodedInputStream.newInstance(r10);
            mergeFrom(r11);
            r11.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r10, ExtensionRegistryLite r11) throws IOException {
            CodedInputStream r12 = CodedInputStream.newInstance(r10);
            mergeFrom(r12, r11);
            r12.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(MessageLite r10) {
            if (getDefaultInstanceForType().getClass().isInstance(r10) == false) goto L7;
            return (BuilderType) internalMergeFrom((AbstractMessageLite) r10);
        L7:
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    public AbstractMessageLite() {
        this.memoizedHashCode = 0;
    }

    public static <T> void addAll(Iterable<T> r10, Collection<? super T> r11) {
        Builder.addAll(r10, r11);
    }

    public static void checkByteStringIsUtf8(ByteString r10) throws IllegalArgumentException {
        if (r10.isValidUtf8() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Byte string is not UTF-8.");
    }

    private String getSerializingExceptionMessage(String r10) {
        return "Serializing " + getClass().getName() + " to a " + r10 + " threw an IOException (should never happen).";
    }

    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
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
        throw new RuntimeException(getSerializingExceptionMessage("byte array"), e);
    }

    @Override // com.google.protobuf.MessageLite
    public ByteString toByteString() {
        ByteString.CodedBuilder r10 = ByteString.newCodedBuilder(getSerializedSize());     // Catch: IOException -> L4
        writeTo(r10.getCodedOutput());     // Catch: IOException -> L4
        return r10.build();
    L4:
        e = move-exception;
        throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeDelimitedTo(OutputStream r10) throws IOException {
        int r11 = getSerializedSize();
        CodedOutputStream r12 = CodedOutputStream.newInstance(r10, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(r11) + r11));
        r12.writeRawVarint32(r11);
        writeTo(r12);
        r12.flush();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(OutputStream r10) throws IOException {
        CodedOutputStream r11 = CodedOutputStream.newInstance(r10, CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
        writeTo(r11);
        r11.flush();
    }
}
