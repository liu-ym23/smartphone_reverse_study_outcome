package com.bytedance.location.protobuf;

import android.hardware.tv.hdmi.cec.CecDeviceType;
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
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = null;
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = null;
    private static final ByteArrayCopier byteArrayCopier = null;
    private int hash;

    static abstract class AbstractByteIterator implements ByteIterator {
        AbstractByteIterator() {
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Byte next() {
            return next();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        /* synthetic */ ArraysByteArrayCopier(AnonymousClass1 x0) {
            this();
        }

        @Override // com.bytedance.location.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bytes, int offset, int size) {
            return Arrays.copyOfRange(bytes, offset, offset + size);
        }
    }

    private static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        BoundedByteString(byte[] bytes, int offset, int length) {
            super(bytes);
            ByteString.checkRange(offset, offset + length, bytes.length);
            this.bytesOffset = offset;
            this.bytesLength = length;
        }

        @Override // com.bytedance.location.protobuf.ByteString.LiteralByteString, com.bytedance.location.protobuf.ByteString
        public byte byteAt(int index) {
            ByteString.checkIndex(index, size());
            return this.bytes[this.bytesOffset + index];
        }

        @Override // com.bytedance.location.protobuf.ByteString.LiteralByteString, com.bytedance.location.protobuf.ByteString
        byte internalByteAt(int index) {
            return this.bytes[this.bytesOffset + index];
        }

        @Override // com.bytedance.location.protobuf.ByteString.LiteralByteString, com.bytedance.location.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        @Override // com.bytedance.location.protobuf.ByteString.LiteralByteString
        protected int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // com.bytedance.location.protobuf.ByteString.LiteralByteString, com.bytedance.location.protobuf.ByteString
        protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + sourceOffset, target, targetOffset, numberToCopy);
        }

        Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }

        private void readObject(ObjectInputStream in) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }
    }

    private interface ByteArrayCopier {
        byte[] copyFrom(byte[] r1, int r2, int r3);
    }

    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    static final class CodedBuilder {
        private final byte[] buffer;
        private final CodedOutputStream output;

        /* synthetic */ CodedBuilder(int x0, AnonymousClass1 x1) {
            this(x0);
        }

        private CodedBuilder(int size) {
            this.buffer = new byte[size];
            this.output = CodedOutputStream.newInstance(this.buffer);
        }

        public ByteString build() {
            this.output.checkNoSpaceLeft();
            return new LiteralByteString(this.buffer);
        }

        public CodedOutputStream getCodedOutput() {
            return this.output;
        }
    }

    static abstract class LeafByteString extends ByteString {
        abstract boolean equalsRange(ByteString r1, int r2, int r3);

        LeafByteString() {
        }

        @Override // com.bytedance.location.protobuf.ByteString
        protected final int getTreeDepth() {
            return 0;
        }

        @Override // com.bytedance.location.protobuf.ByteString
        protected final boolean isBalanced() {
            return true;
        }

        @Override // com.bytedance.location.protobuf.ByteString
        void writeToReverse(ByteOutput byteOutput) throws IOException {
            writeTo(byteOutput);
        }
    }

    private static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        LiteralByteString(byte[] bytes) {
            if (bytes == null) goto L7;
            this.bytes = bytes;
            return;
        L7:
            throw new NullPointerException();
        }

        @Override // com.bytedance.location.protobuf.ByteString
        public byte byteAt(int index) {
            return this.bytes[index];
        }

        @Override // com.bytedance.location.protobuf.ByteString
        byte internalByteAt(int index) {
            return this.bytes[index];
        }

        @Override // com.bytedance.location.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.bytedance.location.protobuf.ByteString
        public final ByteString substring(int beginIndex, int endIndex) {
            int length = ByteString.checkRange(beginIndex, endIndex, size());
            if (length != 0) goto L7;
            return ByteString.EMPTY;
        L7:
            return new BoundedByteString(this.bytes, getOffsetIntoBytes() + beginIndex, length);
        }

        @Override // com.bytedance.location.protobuf.ByteString
        protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
            System.arraycopy(this.bytes, sourceOffset, target, targetOffset, numberToCopy);
        }

        @Override // com.bytedance.location.protobuf.ByteString
        public final void copyTo(ByteBuffer target) {
            target.put(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.bytedance.location.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        @Override // com.bytedance.location.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.bytedance.location.protobuf.ByteString
        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        @Override // com.bytedance.location.protobuf.ByteString
        final void writeToInternal(OutputStream outputStream, int sourceOffset, int numberToWrite) throws IOException {
            outputStream.write(this.bytes, getOffsetIntoBytes() + sourceOffset, numberToWrite);
        }

        @Override // com.bytedance.location.protobuf.ByteString
        final void writeTo(ByteOutput output) throws IOException {
            output.writeLazy(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.bytedance.location.protobuf.ByteString
        protected final String toStringInternal(Charset charset) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), charset);
        }

        @Override // com.bytedance.location.protobuf.ByteString
        public final boolean isValidUtf8() {
            int offset = getOffsetIntoBytes();
            return Utf8.isValidUtf8(this.bytes, offset, size() + offset);
        }

        @Override // com.bytedance.location.protobuf.ByteString
        protected final int partialIsValidUtf8(int state, int offset, int length) {
            int index = getOffsetIntoBytes() + offset;
            return Utf8.partialIsValidUtf8(state, this.bytes, index, index + length);
        }

        @Override // com.bytedance.location.protobuf.ByteString
        public final boolean equals(Object other) {
            if (other != this) goto L6;
            return true;
        L6:
            if ((other instanceof ByteString) == true) goto L9;
            return false;
        L9:
            if (size() == ((ByteString) other).size()) goto L12;
            return false;
        L12:
            if (size() != 0) goto L15;
            return true;
        L15:
            if ((other instanceof LiteralByteString) == false) goto L24;
            LiteralByteString otherAsLiteral = (LiteralByteString) other;
            int thisHash = peekCachedHashCode();
            int thatHash = otherAsLiteral.peekCachedHashCode();
            if (thisHash == 0) goto L22;
            if (thatHash == 0) goto L22;
            if (thisHash == thatHash) goto L22;
            return false;
        L22:
            return equalsRange((LiteralByteString) other, 0, size());
        L24:
            return other.equals(this);
        }

        @Override // com.bytedance.location.protobuf.ByteString.LeafByteString
        final boolean equalsRange(ByteString other, int offset, int length) {
            if (length > other.size()) goto L21;
            if ((offset + length) > other.size()) goto L19;
            if ((other instanceof LiteralByteString) == false) goto L17;
            LiteralByteString lbsOther = (LiteralByteString) other;
            byte[] thisBytes = this.bytes;
            byte[] otherBytes = lbsOther.bytes;
            int thisLimit = getOffsetIntoBytes() + length;
            int thisIndex = getOffsetIntoBytes();
            int otherIndex = lbsOther.getOffsetIntoBytes() + offset;
        L9:
            if (thisIndex >= thisLimit) goto L14;
            if (thisBytes[thisIndex] != otherBytes[otherIndex]) goto L12;
            thisIndex = thisIndex + 1;
            otherIndex = otherIndex + 1;
            goto L9
        L12:
            return false;
        L14:
            return true;
        L17:
            return other.substring(offset, offset + length).equals(substring(0, length));
        L19:
            throw new IllegalArgumentException("Ran off end of other: " + offset + ", " + length + ", " + other.size());
        L21:
            throw new IllegalArgumentException("Length too large: " + length + size());
        }

        @Override // com.bytedance.location.protobuf.ByteString
        protected final int partialHash(int h, int offset, int length) {
            return Internal.partialHash(h, this.bytes, getOffsetIntoBytes() + offset, length);
        }

        @Override // com.bytedance.location.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.bytedance.location.protobuf.ByteString
        public final CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size(), true);
        }

        protected int getOffsetIntoBytes() {
            return 0;
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

        Output(int initialCapacity) {
            if (initialCapacity < 0) goto L7;
            this.initialCapacity = initialCapacity;
            this.flushedBuffers = new ArrayList();
            this.buffer = new byte[initialCapacity];
            return;
        L7:
            throw new IllegalArgumentException("Buffer size < 0");
        }

        @Override // java.io.OutputStream
        public synchronized void write(int b) {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.bufferPos != this.buffer.length) goto L8;
            flushFullBuffer(1);     // Catch: Throwable -> L6
        L8:
            byte[] r0 = this.buffer;     // Catch: Throwable -> L6
            int r1 = this.bufferPos;     // Catch: Throwable -> L6
            this.bufferPos = r1 + 1;     // Catch: Throwable -> L6
            r0[r1] = (byte) b;     // Catch: Throwable -> L6
            monitor-exit(this);
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] b, int offset, int length) {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (length > (this.buffer.length - this.bufferPos)) goto L8;
            System.arraycopy(b, offset, this.buffer, this.bufferPos, length);     // Catch: Throwable -> L6
            this.bufferPos += length;     // Catch: Throwable -> L6
        L9:
            monitor-exit(this);
            return;
        L8:
            int copySize = this.buffer.length - this.bufferPos;     // Catch: Throwable -> L6
            System.arraycopy(b, offset, this.buffer, this.bufferPos, copySize);     // Catch: Throwable -> L6
            int length2 = length - copySize;     // Catch: Throwable -> L6
            flushFullBuffer(length2);     // Catch: Throwable -> L6
            System.arraycopy(b, offset + copySize, this.buffer, 0, length2);     // Catch: Throwable -> L6
            this.bufferPos = length2;     // Catch: Throwable -> L6
            goto L9
        }

        public synchronized ByteString toByteString() {
            monitor-enter(this);
            flushLastBuffer();     // Catch: Throwable -> L6
            ByteString r0 = ByteString.copyFrom(this.flushedBuffers);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        private byte[] copyArray(byte[] buffer, int length) {
            byte[] result = new byte[length];
            System.arraycopy(buffer, 0, result, 0, Math.min(buffer.length, length));
            return result;
        }

        public void writeTo(OutputStream out) throws IOException {
            monitor-enter(this);
            ByteString[] cachedFlushBuffers = (ByteString[]) this.flushedBuffers.toArray(new ByteString[this.flushedBuffers.size()]);     // Catch: Throwable -> L10
            byte[] cachedBuffer = this.buffer;     // Catch: Throwable -> L10
            int cachedBufferPos = this.bufferPos;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            int r3 = cachedFlushBuffers.length;
            int r4 = 0;
        L6:
            if (r4 >= r3) goto L8;
            ByteString byteString = cachedFlushBuffers[r4];
            byteString.writeTo(out);
            r4 = r4 + 1;
            goto L6
        L8:
            out.write(copyArray(cachedBuffer, cachedBufferPos));
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public synchronized int size() {
            monitor-enter(this);
            int r0 = this.flushedBuffersTotalBytes + this.bufferPos;
            monitor-exit(this);
            return r0;
        L7:
            th = move-exception;
            throw th;
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

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
        }

        private void flushFullBuffer(int minSize) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            this.flushedBuffersTotalBytes += this.buffer.length;
            int newSize = Math.max(this.initialCapacity, Math.max(minSize, this.flushedBuffersTotalBytes >>> 1));
            this.buffer = new byte[newSize];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            if (this.bufferPos < this.buffer.length) goto L5;
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            this.buffer = EMPTY_BYTE_ARRAY;
        L8:
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
            return;
        L5:
            if (this.bufferPos <= 0) goto L8;
            byte[] bufferCopy = copyArray(this.buffer, this.bufferPos);
            this.flushedBuffers.add(new LiteralByteString(bufferCopy));
            goto L8
        }
    }

    private static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        /* synthetic */ SystemByteArrayCopier(AnonymousClass1 x0) {
            this();
        }

        @Override // com.bytedance.location.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bytes, int offset, int size) {
            byte[] copy = new byte[size];
            System.arraycopy(bytes, offset, copy, 0, size);
            return copy;
        }
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int r1);

    public abstract void copyTo(ByteBuffer r1);

    protected abstract void copyToInternal(byte[] r1, int r2, int r3, int r4);

    public abstract boolean equals(Object r1);

    protected abstract int getTreeDepth();

    abstract byte internalByteAt(int r1);

    protected abstract boolean isBalanced();

    public abstract boolean isValidUtf8();

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    protected abstract int partialHash(int r1, int r2, int r3);

    protected abstract int partialIsValidUtf8(int r1, int r2, int r3);

    public abstract int size();

    public abstract ByteString substring(int r1, int r2);

    protected abstract String toStringInternal(Charset r1);

    abstract void writeTo(ByteOutput r1) throws IOException;

    public abstract void writeTo(OutputStream r1) throws IOException;

    abstract void writeToInternal(OutputStream r1, int r2, int r3) throws IOException;

    abstract void writeToReverse(ByteOutput r1) throws IOException;

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    static /* synthetic */ int access$200(byte x0) {
        return toInt(x0);
    }

    static {
        EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
        AnonymousClass1 r1 = null;
        if (Android.isOnAndroidDevice() == false) goto L5;
        ByteArrayCopier r0 = new SystemByteArrayCopier(r1);
    L6:
        byteArrayCopier = r0;
        UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new AnonymousClass2();
        return;
    L5:
        r0 = new ArraysByteArrayCopier(r1);
        goto L6
    }

    ByteString() {
        this.hash = 0;
    }

    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new AnonymousClass1(this);
    }

    public final boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final ByteString empty() {
        return EMPTY;
    }

    private static int toInt(byte value) {
        return value & CecDeviceType.INACTIVE;
    }

    private static int hexDigit(char c) {
        if (c < '0') goto L9;
        if (c > '9') goto L9;
        return c - '0';
    L9:
        if (c < 'A') goto L15;
        if (c > 'F') goto L15;
        return (c - 'A') + 10;
    L15:
        if (c >= 'a') goto L17;
        return -1;
    L17:
        if (c <= 'f') goto L19;
        return -1;
    L19:
        return (c - 'a') + 10;
    }

    private static int extractHexDigit(String hexString, int index) {
        int digit = hexDigit(hexString.charAt(index));
        if (digit == (-1)) goto L6;
        return digit;
    L6:
        throw new NumberFormatException("Invalid hexString " + hexString + " must only contain [0-9a-fA-F] but contained " + hexString.charAt(index) + " at index " + index);
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    public final ByteString substring(int beginIndex) {
        return substring(beginIndex, size());
    }

    public final boolean startsWith(ByteString prefix) {
        if (size() >= prefix.size()) goto L5;
        return false;
    L5:
        if (substring(0, prefix.size()).equals(prefix) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean endsWith(ByteString suffix) {
        if (size() >= suffix.size()) goto L5;
    L7:
        return false;
    L5:
        if (substring(size() - suffix.size()).equals(suffix) == false) goto L7;
        return true;
    }

    public static ByteString fromHex(String hexString) {
        if ((hexString.length() % 2) != 0) goto L11;
        byte[] bytes = new byte[hexString.length() / 2];
        int i = 0;
    L6:
        if (i >= bytes.length) goto L9;
        int d1 = extractHexDigit(hexString, i * 2);
        int d2 = extractHexDigit(hexString, (i * 2) + 1);
        bytes[i] = (byte) ((d1 << 4) | d2);
        i = i + 1;
        goto L6
    L9:
        return new LiteralByteString(bytes);
    L11:
        throw new NumberFormatException("Invalid hexString " + hexString + " of length " + hexString.length() + " must be even.");
    }

    public static ByteString copyFrom(byte[] bytes, int offset, int size) {
        checkRange(offset, offset + size, bytes.length);
        return new LiteralByteString(byteArrayCopier.copyFrom(bytes, offset, size));
    }

    public static ByteString copyFrom(byte[] bytes) {
        return copyFrom(bytes, 0, bytes.length);
    }

    static ByteString wrap(ByteBuffer buffer) {
        if (buffer.hasArray() == false) goto L7;
        int offset = buffer.arrayOffset();
        return wrap(buffer.array(), buffer.position() + offset, buffer.remaining());
    L7:
        return new NioByteString(buffer);
    }

    static ByteString wrap(byte[] bytes) {
        return new LiteralByteString(bytes);
    }

    static ByteString wrap(byte[] bytes, int offset, int length) {
        return new BoundedByteString(bytes, offset, length);
    }

    public static ByteString copyFrom(ByteBuffer bytes, int size) {
        checkRange(0, size, bytes.remaining());
        byte[] copy = new byte[size];
        bytes.get(copy);
        return new LiteralByteString(copy);
    }

    public static ByteString copyFrom(ByteBuffer bytes) {
        return copyFrom(bytes, bytes.remaining());
    }

    public static ByteString copyFrom(String text, String charsetName) throws UnsupportedEncodingException {
        return new LiteralByteString(text.getBytes(charsetName));
    }

    public static ByteString copyFrom(String text, Charset charset) {
        return new LiteralByteString(text.getBytes(charset));
    }

    public static ByteString copyFromUtf8(String text) {
        return new LiteralByteString(text.getBytes(Internal.UTF_8));
    }

    public static ByteString readFrom(InputStream streamToDrain) throws IOException {
        return readFrom(streamToDrain, 256, 8192);
    }

    public static ByteString readFrom(InputStream streamToDrain, int chunkSize) throws IOException {
        return readFrom(streamToDrain, chunkSize, chunkSize);
    }

    public static ByteString readFrom(InputStream streamToDrain, int minChunkSize, int maxChunkSize) throws IOException {
        Collection<ByteString> results = new ArrayList();
        int chunkSize = minChunkSize;
    L3:
        ByteString chunk = readChunk(streamToDrain, chunkSize);
        if (chunk == null) goto L6;
        results.add(chunk);
        chunkSize = Math.min(chunkSize * 2, maxChunkSize);
        goto L3
    L6:
        return copyFrom(results);
    }

    private static ByteString readChunk(InputStream in, int chunkSize) throws IOException {
        byte[] buf = new byte[chunkSize];
        int bytesRead = 0;
    L3:
        if (bytesRead >= chunkSize) goto L8;
        int count = in.read(buf, bytesRead, chunkSize - bytesRead);
        if (count == (-1)) goto L8;
        bytesRead = bytesRead + count;
    L8:
        if (bytesRead != 0) goto L12;
        return null;
    L12:
        return copyFrom(buf, 0, bytesRead);
    }

    public final ByteString concat(ByteString other) {
        if ((Integer.MAX_VALUE - size()) < other.size()) goto L7;
        return RopeByteString.concatenate(this, other);
    L7:
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + other.size());
    }

    public static ByteString copyFrom(Iterable<ByteString> byteStrings) {
        if ((byteStrings instanceof Collection) == true) goto L9;
        int tempSize = 0;
        Iterator<ByteString> iter = byteStrings.iterator();
    L6:
        if (iter.hasNext() == false) goto L10;
        iter.next();
        tempSize = tempSize + 1;
    L10:
        if (tempSize != 0) goto L14;
        return EMPTY;
    L14:
        return balancedConcat(byteStrings.iterator(), tempSize);
    L9:
        tempSize = ((Collection) byteStrings).size();
        goto L10
    }

    private static ByteString balancedConcat(Iterator<ByteString> iterator, int length) {
        if (length < 1) goto L9;
        if (length != 1) goto L6;
        ByteString result = iterator.next();
        return result;
    L6:
        int halfLength = length >>> 1;
        ByteString left = balancedConcat(iterator, halfLength);
        ByteString right = balancedConcat(iterator, length - halfLength);
        ByteString result2 = left.concat(right);
        return result2;
    L9:
        throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(length)}));
    }

    public void copyTo(byte[] target, int offset) {
        copyTo(target, 0, offset, size());
    }

    @Deprecated
    public final void copyTo(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
        checkRange(sourceOffset, sourceOffset + numberToCopy, size());
        checkRange(targetOffset, targetOffset + numberToCopy, target.length);
        if (numberToCopy <= 0) goto L6;
        copyToInternal(target, sourceOffset, targetOffset, numberToCopy);
        return;
    }

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) goto L5;
        byte[] result = new byte[size];
        copyToInternal(result, 0, 0, size);
        return result;
    L5:
        return Internal.EMPTY_BYTE_ARRAY;
    }

    final void writeTo(OutputStream out, int sourceOffset, int numberToWrite) throws IOException {
        checkRange(sourceOffset, sourceOffset + numberToWrite, size());
        if (numberToWrite <= 0) goto L6;
        writeToInternal(out, sourceOffset, numberToWrite);
        return;
    }

    public final String toString(String charsetName) throws UnsupportedEncodingException {
        return toString(Charset.forName(charsetName));
    L4:
        e = move-exception;
        UnsupportedEncodingException exception = new UnsupportedEncodingException(charsetName);
        exception.initCause(e);
        throw exception;
    }

    public final String toString(Charset charset) {
        if (size() != 0) goto L6;
        return "";
    L6:
        return toStringInternal(charset);
    }

    public final String toStringUtf8() {
        return toString(Internal.UTF_8);
    }

    public final int hashCode() {
        int h = this.hash;
        if (h != 0) goto L8;
        int size = size();
        h = partialHash(size, 0, size);
        if (h != 0) goto L7;
        h = 1;
    L7:
        this.hash = h;
    L8:
        return h;
    }

    public static Output newOutput(int initialCapacity) {
        return new Output(initialCapacity);
    }

    public static Output newOutput() {
        return new Output(128);
    }

    static CodedBuilder newCodedBuilder(int size) {
        return new CodedBuilder(size, null);
    }

    protected final int peekCachedHashCode() {
        return this.hash;
    }

    static void checkIndex(int index, int size) {
        if (((size - (index + 1)) | index) >= 0) goto L9;
        if (index >= 0) goto L8;
        throw new ArrayIndexOutOfBoundsException("Index < 0: " + index);
    L8:
        throw new ArrayIndexOutOfBoundsException("Index > length: " + index + ", " + size);
    }

    static int checkRange(int startIndex, int endIndex, int size) {
        int length = endIndex - startIndex;
        if ((((startIndex | endIndex) | length) | (size - endIndex)) >= 0) goto L12;
        if (startIndex < 0) goto L11;
        if (endIndex >= startIndex) goto L9;
        throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + startIndex + ", " + endIndex);
    L9:
        throw new IndexOutOfBoundsException("End index: " + endIndex + " >= " + size);
    L11:
        throw new IndexOutOfBoundsException("Beginning index: " + startIndex + " < 0");
    L12:
        return length;
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), truncateAndEscapeForDisplay()});
    }

    private String truncateAndEscapeForDisplay() {
        if (size() > 50) goto L6;
        return TextFormatEscaper.escapeBytes(this);
    L6:
        return TextFormatEscaper.escapeBytes(substring(0, 47)) + "...";
    }
}
