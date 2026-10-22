package com.google.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = null;
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final ByteArrayCopier byteArrayCopier = null;
    private int hash;

    public static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        @Override // com.google.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] r10, int r11, int r12) {
            return Arrays.copyOfRange(r10, r11, r12 + r11);
        }

        public /* synthetic */ ArraysByteArrayCopier(AnonymousClass1 r10) {
            this();
        }
    }

    public static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        public BoundedByteString(byte[] r10, int r11, int r12) {
            super(r10);
            ByteString.checkRange(r11, r11 + r12, r10.length);
            this.bytesOffset = r11;
            this.bytesLength = r12;
        }

        private void readObject(ObjectInputStream r10) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public byte byteAt(int r10) {
            ByteString.checkIndex(r10, size());
            return this.bytes[this.bytesOffset + r10];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public void copyToInternal(byte[] r10, int r11, int r12, int r13) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + r11, r10, r12, r13);
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString
        public int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        public Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }
    }

    public interface ByteArrayCopier {
        byte[] copyFrom(byte[] r10, int r11, int r12);
    }

    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    public static final class CodedBuilder {
        private final byte[] buffer;
        private final CodedOutputStream output;

        public /* synthetic */ CodedBuilder(int r10, AnonymousClass1 r11) {
            this(r10);
        }

        public ByteString build() {
            this.output.checkNoSpaceLeft();
            return new LiteralByteString(this.buffer);
        }

        public CodedOutputStream getCodedOutput() {
            return this.output;
        }

        private CodedBuilder(int r10) {
            byte[] r11 = new byte[r10];
            this.buffer = r11;
            this.output = CodedOutputStream.newInstance(r11);
        }
    }

    public static abstract class LeafByteString extends ByteString {
        public LeafByteString() {
        }

        public abstract boolean equalsRange(ByteString r10, int r11, int r12);

        @Override // com.google.protobuf.ByteString
        public final int getTreeDepth() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isBalanced() {
            return true;
        }

        @Override // com.google.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator();
        }
    }

    public static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        public LiteralByteString(byte[] r10) {
            this.bytes = r10;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.protobuf.ByteString
        public byte byteAt(int r10) {
            return this.bytes[r10];
        }

        @Override // com.google.protobuf.ByteString
        public final void copyTo(ByteBuffer r10) {
            r10.put(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        public void copyToInternal(byte[] r10, int r11, int r12, int r13) {
            System.arraycopy(this.bytes, r11, r10, r12, r13);
        }

        @Override // com.google.protobuf.ByteString
        public final boolean equals(Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof ByteString) == true) goto L9;
            return false;
        L9:
            if (size() == ((ByteString) r10).size()) goto L12;
            return false;
        L12:
            if (size() != 0) goto L15;
            return true;
        L15:
            if ((r10 instanceof LiteralByteString) == false) goto L24;
            LiteralByteString r11 = (LiteralByteString) r10;
            int r12 = peekCachedHashCode();
            int r13 = r11.peekCachedHashCode();
            if (r12 == 0) goto L22;
            if (r13 == 0) goto L22;
            if (r12 == r13) goto L22;
            return false;
        L22:
            return equalsRange(r11, 0, size());
        L24:
            return r10.equals(this);
        }

        @Override // com.google.protobuf.ByteString.LeafByteString
        public final boolean equalsRange(ByteString r10, int r11, int r12) {
            if (r12 > r10.size()) goto L21;
            int r13 = r11 + r12;
            if (r13 > r10.size()) goto L19;
            if ((r10 instanceof LiteralByteString) == false) goto L17;
            LiteralByteString r14 = (LiteralByteString) r10;
            byte[] r15 = this.bytes;
            byte[] r16 = r14.bytes;
            int r17 = getOffsetIntoBytes() + r12;
            int r18 = getOffsetIntoBytes();
            int r19 = r14.getOffsetIntoBytes() + r11;
        L9:
            if (r18 >= r17) goto L14;
            if (r15[r18] != r16[r19]) goto L12;
            r18 = r18 + 1;
            r19 = r19 + 1;
            goto L9
        L12:
            return false;
        L14:
            return true;
        L17:
            return r10.substring(r11, r13).equals(substring(0, r12));
        L19:
            throw new IllegalArgumentException("Ran off end of other: " + r11 + ", " + r12 + ", " + r10.size());
        L21:
            throw new IllegalArgumentException("Length too large: " + r12 + size());
        }

        public int getOffsetIntoBytes() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isValidUtf8() {
            int r10 = getOffsetIntoBytes();
            return Utf8.isValidUtf8(this.bytes, r10, size() + r10);
        }

        @Override // com.google.protobuf.ByteString
        public final CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size(), true);
        }

        @Override // com.google.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        public final int partialHash(int r10, int r11, int r12) {
            return Internal.partialHash(r10, this.bytes, getOffsetIntoBytes() + r11, r12);
        }

        @Override // com.google.protobuf.ByteString
        public final int partialIsValidUtf8(int r10, int r11, int r12) {
            int r13 = getOffsetIntoBytes() + r11;
            return Utf8.partialIsValidUtf8(r10, this.bytes, r13, r12 + r13);
        }

        @Override // com.google.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteString substring(int r10, int r11) {
            int r12 = ByteString.checkRange(r10, r11, size());
            if (r12 != 0) goto L7;
            return ByteString.EMPTY;
        L7:
            return new BoundedByteString(this.bytes, getOffsetIntoBytes() + r10, r12);
        }

        @Override // com.google.protobuf.ByteString
        public final String toStringInternal(Charset r10) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), r10);
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo(OutputStream r10) throws IOException {
            r10.write(toByteArray());
        }

        @Override // com.google.protobuf.ByteString
        public final void writeToInternal(OutputStream r10, int r11, int r12) throws IOException {
            r10.write(this.bytes, getOffsetIntoBytes() + r11, r12);
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo(ByteOutput r10) throws IOException {
            r10.writeLazy(this.bytes, getOffsetIntoBytes(), size());
        }
    }

    public static final class Output extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = null;
        private byte[] buffer;
        private int bufferPos;
        private final ArrayList<ByteString> flushedBuffers;
        private int flushedBuffersTotalBytes;
        private final int initialCapacity;

        static {
            EMPTY_BYTE_ARRAY = new byte[0];
        }

        public Output(int r10) {
            if (r10 < 0) goto L7;
            this.initialCapacity = r10;
            this.flushedBuffers = new ArrayList();
            this.buffer = new byte[r10];
            return;
        L7:
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private byte[] copyArray(byte[] r10, int r11) {
            byte[] r12 = new byte[r11];
            System.arraycopy(r10, 0, r12, 0, Math.min(r10.length, r11));
            return r12;
        }

        private void flushFullBuffer(int r10) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int r11 = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = r11;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(r10, r11 >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int r10 = this.bufferPos;
            byte[] r11 = this.buffer;
            if (r10 >= r11.length) goto L6;
            if (r10 <= 0) goto L7;
            this.flushedBuffers.add(new LiteralByteString(copyArray(r11, r10)));
        L7:
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
            return;
        L6:
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            this.buffer = EMPTY_BYTE_ARRAY;
            goto L7
        }

        public synchronized void reset() {
            monitor-enter(this);
            this.flushedBuffers.clear();     // Catch: Throwable -> L6
            this.flushedBuffersTotalBytes = 0;     // Catch: Throwable -> L6
            this.bufferPos = 0;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized int size() {
            monitor-enter(this);
            int r10 = this.flushedBuffersTotalBytes + this.bufferPos;
            monitor-exit(this);
            return r10;
        L7:
            th = move-exception;
            throw th;
        }

        public synchronized ByteString toByteString() {
            monitor-enter(this);
            flushLastBuffer();     // Catch: Throwable -> L6
            ByteString r10 = ByteString.copyFrom(this.flushedBuffers);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r10;
        L6:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
        }

        @Override // java.io.OutputStream
        public synchronized void write(int r10) {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.bufferPos != this.buffer.length) goto L8;
            flushFullBuffer(1);     // Catch: Throwable -> L6
        L8:
            byte[] r11 = this.buffer;     // Catch: Throwable -> L6
            int r12 = this.bufferPos;     // Catch: Throwable -> L6
            this.bufferPos = r12 + 1;     // Catch: Throwable -> L6
            r11[r12] = (byte) r10;     // Catch: Throwable -> L6
            monitor-exit(this);
        }

        public void writeTo(OutputStream r10) throws IOException {
            monitor-enter(this);
            ArrayList<ByteString> r11 = this.flushedBuffers;     // Catch: Throwable -> L10
            ByteString[] r12 = (ByteString[]) r11.toArray(new ByteString[r11.size()]);     // Catch: Throwable -> L10
            byte[] r13 = this.buffer;     // Catch: Throwable -> L10
            int r14 = this.bufferPos;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            int r15 = r12.length;
            int r16 = 0;
        L6:
            if (r16 >= r15) goto L8;
            r12[r16].writeTo(r10);
            r16 = r16 + 1;
            goto L6
        L8:
            r10.write(copyArray(r13, r14));
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] r10, int r11, int r12) {
            monitor-enter(this);
            byte[] r13 = this.buffer;     // Catch: Throwable -> L6
            int r14 = r13.length;     // Catch: Throwable -> L6
            int r15 = this.bufferPos;     // Catch: Throwable -> L6
            if (r12 > (r14 - r15)) goto L8;
            System.arraycopy(r10, r11, r13, r15, r12);     // Catch: Throwable -> L6
            this.bufferPos += r12;     // Catch: Throwable -> L6
        L9:
            monitor-exit(this);
            return;
        L8:
            int r16 = r13.length - r15;     // Catch: Throwable -> L6
            System.arraycopy(r10, r11, r13, r15, r16);     // Catch: Throwable -> L6
            int r17 = r12 - r16;     // Catch: Throwable -> L6
            flushFullBuffer(r17);     // Catch: Throwable -> L6
            System.arraycopy(r10, r11 + r16, this.buffer, 0, r17);     // Catch: Throwable -> L6
            this.bufferPos = r17;     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }
    }

    public static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        @Override // com.google.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] r10, int r11, int r12) {
            byte[] r13 = new byte[r12];
            System.arraycopy(r10, r11, r13, 0, r12);
            return r13;
        }

        public /* synthetic */ SystemByteArrayCopier(AnonymousClass1 r10) {
            this();
        }
    }

    static {
        EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
        AnonymousClass1 r10 = null;
        Class.forName("android.content.Context");     // Catch: ClassNotFoundException -> L5
        ByteArrayCopier r11 = new SystemByteArrayCopier(r10);
    L6:
        byteArrayCopier = r11;
        return;
    L5:
        r11 = new ArraysByteArrayCopier(r10);
        goto L6
    }

    public ByteString() {
        this.hash = 0;
    }

    private static ByteString balancedConcat(Iterator<ByteString> r10, int r11) {
        if (r11 == 1) goto L7;
        int r12 = r11 >>> 1;
        return balancedConcat(r10, r12).concat(balancedConcat(r10, r11 - r12));
    L7:
        return r10.next();
    }

    public static void checkIndex(int r10, int r11) {
        if (((r11 - (r10 + 1)) | r10) >= 0) goto L9;
        if (r10 >= 0) goto L8;
        throw new ArrayIndexOutOfBoundsException("Index < 0: " + r10);
    L8:
        throw new ArrayIndexOutOfBoundsException("Index > length: " + r10 + ", " + r11);
    }

    public static int checkRange(int r10, int r11, int r12) {
        int r13 = r11 - r10;
        if ((((r10 | r11) | r13) | (r12 - r11)) >= 0) goto L12;
        if (r10 < 0) goto L11;
        if (r11 >= r10) goto L9;
        throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + r10 + ", " + r11);
    L9:
        throw new IndexOutOfBoundsException("End index: " + r11 + " >= " + r12);
    L11:
        throw new IndexOutOfBoundsException("Beginning index: " + r10 + " < 0");
    L12:
        return r13;
    }

    public static ByteString copyFrom(byte[] r10, int r11, int r12) {
        return new LiteralByteString(byteArrayCopier.copyFrom(r10, r11, r12));
    }

    public static ByteString copyFromUtf8(String r10) {
        return new LiteralByteString(r10.getBytes(Internal.UTF_8));
    }

    public static CodedBuilder newCodedBuilder(int r10) {
        return new CodedBuilder(r10, null);
    }

    public static Output newOutput(int r10) {
        return new Output(r10);
    }

    private static ByteString readChunk(InputStream r10, int r11) throws IOException {
        byte[] r12 = new byte[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L8;
        int r14 = r10.read(r12, r13, r11 - r13);
        if (r14 == (-1)) goto L8;
        r13 = r13 + r14;
    L8:
        if (r13 != 0) goto L12;
        return null;
    L12:
        return copyFrom(r12, 0, r13);
    }

    public static ByteString readFrom(InputStream r10) throws IOException {
        return readFrom(r10, 256, 8192);
    }

    public static ByteString wrap(byte[] r10) {
        return new LiteralByteString(r10);
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int r10);

    public final ByteString concat(ByteString r10) {
        if ((Channel.UNLIMITED - size()) < r10.size()) goto L7;
        return RopeByteString.concatenate(this, r10);
    L7:
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + r10.size());
    }

    public abstract void copyTo(ByteBuffer r10);

    public void copyTo(byte[] r10, int r11) {
        copyTo(r10, 0, r11, size());
    }

    public abstract void copyToInternal(byte[] r10, int r11, int r12, int r13);

    public final boolean endsWith(ByteString r10) {
        if (size() >= r10.size()) goto L5;
    L7:
        return false;
    L5:
        if (substring(size() - r10.size()).equals(r10) == false) goto L7;
        return true;
    }

    public abstract boolean equals(Object r10);

    public abstract int getTreeDepth();

    public final int hashCode() {
        int r10 = this.hash;
        if (r10 != 0) goto L8;
        int r11 = size();
        r10 = partialHash(r11, 0, r11);
        if (r10 != 0) goto L7;
        r10 = 1;
    L7:
        this.hash = r10;
    L8:
        return r10;
    }

    public abstract boolean isBalanced();

    public final boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract boolean isValidUtf8();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    public abstract int partialHash(int r10, int r11, int r12);

    public abstract int partialIsValidUtf8(int r10, int r11, int r12);

    public final int peekCachedHashCode() {
        return this.hash;
    }

    public abstract int size();

    public final boolean startsWith(ByteString r10) {
        if (size() >= r10.size()) goto L5;
        return false;
    L5:
        if (substring(0, r10.size()).equals(r10) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final ByteString substring(int r10) {
        return substring(r10, size());
    }

    public abstract ByteString substring(int r10, int r11);

    public final byte[] toByteArray() {
        int r10 = size();
        if (r10 == 0) goto L5;
        byte[] r11 = new byte[r10];
        copyToInternal(r11, 0, 0, r10);
        return r11;
    L5:
        return Internal.EMPTY_BYTE_ARRAY;
    }

    public final String toString(String r10) throws UnsupportedEncodingException {
        return toString(Charset.forName(r10));
    L4:
        e = move-exception;
        UnsupportedEncodingException r11 = new UnsupportedEncodingException(r10);
        r11.initCause(e);
        throw r11;
    }

    public abstract String toStringInternal(Charset r10);

    public final String toStringUtf8() {
        return toString(Internal.UTF_8);
    }

    public abstract void writeTo(ByteOutput r10) throws IOException;

    public abstract void writeTo(OutputStream r10) throws IOException;

    public final void writeTo(OutputStream r10, int r11, int r12) throws IOException {
        checkRange(r11, r11 + r12, size());
        if (r12 <= 0) goto L6;
        writeToInternal(r10, r11, r12);
        return;
    }

    public abstract void writeToInternal(OutputStream r10, int r11, int r12) throws IOException;

    public static ByteString copyFrom(byte[] r10) {
        return copyFrom(r10, 0, r10.length);
    }

    public static Output newOutput() {
        return new Output(128);
    }

    public static ByteString readFrom(InputStream r10, int r11) throws IOException {
        return readFrom(r10, r11, r11);
    }

    public static ByteString wrap(byte[] r10, int r11, int r12) {
        return new BoundedByteString(r10, r11, r12);
    }

    public final void copyTo(byte[] r10, int r11, int r12, int r13) {
        checkRange(r11, r11 + r13, size());
        checkRange(r12, r12 + r13, r10.length);
        if (r13 <= 0) goto L6;
        copyToInternal(r10, r11, r12, r13);
        return;
    }

    @Override // java.lang.Iterable
    public final Iterator<Byte> iterator() {
        return new AnonymousClass1(this);
    }

    public static ByteString copyFrom(ByteBuffer r10, int r11) {
        byte[] r12 = new byte[r11];
        r10.get(r12);
        return new LiteralByteString(r12);
    }

    public static ByteString readFrom(InputStream r10, int r11, int r12) throws IOException {
        ArrayList r13 = new ArrayList();
    L3:
        ByteString r14 = readChunk(r10, r11);
        if (r14 == null) goto L6;
        r13.add(r14);
        r11 = Math.min(r11 * 2, r12);
        goto L3
    L6:
        return copyFrom(r13);
    }

    public final String toString(Charset r10) {
        if (size() != 0) goto L6;
        return "";
    L6:
        return toStringInternal(r10);
    }

    public static ByteString copyFrom(ByteBuffer r10) {
        return copyFrom(r10, r10.remaining());
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public static ByteString copyFrom(String r10, String r11) throws UnsupportedEncodingException {
        return new LiteralByteString(r10.getBytes(r11));
    }

    public static ByteString copyFrom(String r10, Charset r11) {
        return new LiteralByteString(r10.getBytes(r11));
    }

    public static ByteString copyFrom(Iterable<ByteString> r10) {
        if ((r10 instanceof Collection) == true) goto L8;
        Iterator<ByteString> r11 = r10.iterator();
        int r12 = 0;
    L6:
        if (r11.hasNext() == false) goto L9;
        r11.next();
        r12 = r12 + 1;
    L9:
        if (r12 != 0) goto L13;
        return EMPTY;
    L13:
        return balancedConcat(r10.iterator(), r12);
    L8:
        r12 = ((Collection) r10).size();
        goto L9
    }
}
