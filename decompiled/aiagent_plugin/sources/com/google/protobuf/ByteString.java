package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
public abstract class ByteString implements Serializable, Iterable<Byte> {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = null;
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = null;
    private static final ByteArrayCopier byteArrayCopier = null;
    private static final long serialVersionUID = 1;
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

        /* synthetic */ ArraysByteArrayCopier(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] r1, int r2, int r3) {
            return Arrays.copyOfRange(r1, r2, r3 + r2);
        }
    }

    private static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        BoundedByteString(byte[] r2, int r3, int r4) {
            super(r2);
            checkRange(r3, r3 + r4, r2.length);
            this.bytesOffset = r3;
            this.bytesLength = r4;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public byte byteAt(int r2) {
            checkIndex(r2, size());
            return this.bytes[this.bytesOffset + r2];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        byte internalByteAt(int r2) {
            return this.bytes[this.bytesOffset + r2];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString
        public int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public void copyToInternal(byte[] r2, int r3, int r4, int r5) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + r3, r2, r4, r5);
        }

        Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }

        private void readObject(ObjectInputStream r1) {
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

        /* synthetic */ CodedBuilder(int r1, AnonymousClass1 r2) {
            this(r1);
        }

        private CodedBuilder(int r1) {
            byte[] r2 = new byte[r1];
            this.buffer = r2;
            this.output = CodedOutputStream.newInstance(r2);
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
        private static final long serialVersionUID = 1;

        abstract boolean equalsRange(ByteString r1, int r2, int r3);

        @Override // com.google.protobuf.ByteString
        public final int getTreeDepth() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isBalanced() {
            return true;
        }

        /* synthetic */ LeafByteString(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator();
        }

        @Override // com.google.protobuf.ByteString
        void writeToReverse(ByteOutput r1) {
            writeTo(r1);
        }

        private LeafByteString() {
        }
    }

    private static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        public int getOffsetIntoBytes() {
            return 0;
        }

        LiteralByteString(byte[] r2) {
            super(null);
            Objects.requireNonNull(r2);
            this.bytes = r2;
        }

        @Override // com.google.protobuf.ByteString
        public byte byteAt(int r1) {
            return this.bytes[r1];
        }

        @Override // com.google.protobuf.ByteString
        byte internalByteAt(int r1) {
            return this.bytes[r1];
        }

        @Override // com.google.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteString substring(int r3, int r4) {
            int r5 = checkRange(r3, r4, size());
            if (r5 != 0) goto L7;
            return ByteString.EMPTY;
        L7:
            return new BoundedByteString(this.bytes, getOffsetIntoBytes() + r3, r5);
        }

        @Override // com.google.protobuf.ByteString
        public void copyToInternal(byte[] r1, int r2, int r3, int r4) {
            System.arraycopy(this.bytes, r2, r1, r3, r4);
        }

        @Override // com.google.protobuf.ByteString
        public final void copyTo(ByteBuffer r3) {
            r3.put(this.bytes, getOffsetIntoBytes(), size());
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
        public final void writeTo(OutputStream r1) {
            r1.write(toByteArray());
        }

        @Override // com.google.protobuf.ByteString
        final void writeToInternal(OutputStream r2, int r3, int r4) {
            r2.write(this.bytes, getOffsetIntoBytes() + r3, r4);
        }

        @Override // com.google.protobuf.ByteString
        final void writeTo(ByteOutput r3) {
            r3.writeLazy(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        public final String toStringInternal(Charset r4) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), r4);
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isValidUtf8() {
            int r0 = getOffsetIntoBytes();
            return Utf8.isValidUtf8(this.bytes, r0, size() + r0);
        }

        @Override // com.google.protobuf.ByteString
        public final int partialIsValidUtf8(int r2, int r3, int r4) {
            int r0 = getOffsetIntoBytes() + r3;
            return Utf8.partialIsValidUtf8(r2, this.bytes, r0, r4 + r0);
        }

        @Override // com.google.protobuf.ByteString
        public final boolean equals(Object r7) {
            if (r7 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, ByteString.class) == true) goto L9;
            return false;
        L9:
            if (size() == ((ByteString) ZeusTransformUtils.preCheckCast(r7, ByteString.class, "com.obric.aiagent.plugin")).size()) goto L12;
            return false;
        L12:
            if (size() != 0) goto L15;
            return true;
        L15:
            if (ZeusTransformUtils.instanceOf(r7, LiteralByteString.class) == false) goto L24;
            LiteralByteString r1 = (LiteralByteString) ZeusTransformUtils.preCheckCast(r7, LiteralByteString.class, "com.obric.aiagent.plugin");
            int r2 = peekCachedHashCode();
            int r3 = r1.peekCachedHashCode();
            if (r2 == 0) goto L22;
            if (r3 == 0) goto L22;
            if (r2 == r3) goto L22;
            return false;
        L22:
            return equalsRange((LiteralByteString) ZeusTransformUtils.preCheckCast(r7, LiteralByteString.class, "com.obric.aiagent.plugin"), 0, size());
        L24:
            return r7.equals(this);
        }

        @Override // com.google.protobuf.ByteString.LeafByteString
        final boolean equalsRange(ByteString r5, int r6, int r7) {
            if (r7 > r5.size()) goto L21;
            int r1 = r6 + r7;
            if (r1 > r5.size()) goto L19;
            if (ZeusTransformUtils.instanceOf(r5, LiteralByteString.class) == false) goto L17;
            LiteralByteString r8 = (LiteralByteString) ZeusTransformUtils.preCheckCast(r5, LiteralByteString.class, "com.obric.aiagent.plugin");
            byte[] r0 = this.bytes;
            byte[] r2 = r8.bytes;
            int r3 = getOffsetIntoBytes() + r7;
            int r4 = getOffsetIntoBytes();
            int r9 = r8.getOffsetIntoBytes() + r6;
        L9:
            if (r4 >= r3) goto L14;
            if (r0[r4] != r2[r9]) goto L12;
            r4 = r4 + 1;
            r9 = r9 + 1;
            goto L9
        L12:
            return false;
        L14:
            return true;
        L17:
            return r5.substring(r6, r1).equals(substring(0, r7));
        L19:
            throw new IllegalArgumentException("Ran off end of other: " + r6 + ", " + r7 + ", " + r5.size());
        L21:
            throw new IllegalArgumentException("Length too large: " + r7 + size());
        }

        @Override // com.google.protobuf.ByteString
        public final int partialHash(int r2, int r3, int r4) {
            return Internal.partialHash(r2, this.bytes, getOffsetIntoBytes() + r3, r4);
        }

        @Override // com.google.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        public final CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size(), true);
        }
    }

    private static final class NioByteString extends LeafByteString {
        private final ByteBuffer buffer;

        static /* synthetic */ ByteBuffer access$500(NioByteString r0) {
            return r0.buffer;
        }

        NioByteString(ByteBuffer r2) {
            super(null);
            Internal.checkNotNull(r2, "buffer");
            this.buffer = r2.slice().order(ByteOrder.nativeOrder());
        }

        private Object writeReplace() {
            return ByteString.copyFrom(this.buffer.slice());
        }

        private void readObject(ObjectInputStream r1) {
            throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
        }

        @Override // com.google.protobuf.ByteString
        public byte byteAt(int r1) {
            return this.buffer.get(r1);
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
        }

        @Override // com.google.protobuf.ByteString
        public byte internalByteAt(int r1) {
            return byteAt(r1);
        }

        @Override // com.google.protobuf.ByteString
        public int size() {
            return this.buffer.remaining();
        }

        @Override // com.google.protobuf.ByteString
        public ByteString substring(int r1, int r2) {
            return new NioByteString(slice(r1, r2));
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
        }

        @Override // com.google.protobuf.ByteString
        public void copyToInternal(byte[] r1, int r2, int r3, int r4) {
            ByteBuffer r0 = this.buffer.slice();
            Java8Compatibility.position(r0, r2);
            r0.get(r1, r3, r4);
        }

        @Override // com.google.protobuf.ByteString
        public void copyTo(ByteBuffer r1) {
            r1.put(this.buffer.slice());
        }

        @Override // com.google.protobuf.ByteString
        public void writeTo(OutputStream r1) {
            r1.write(toByteArray());
        }

        @Override // com.google.protobuf.ByteString.LeafByteString
        boolean equalsRange(ByteString r2, int r3, int r4) {
            return substring(0, r4).equals(r2.substring(r3, r4 + r3));
        }

        @Override // com.google.protobuf.ByteString
        void writeToInternal(OutputStream r3, int r4, int r5) {
            if (this.buffer.hasArray() == false) goto L6;
            int r0 = (this.buffer.arrayOffset() + this.buffer.position()) + r4;
            r3.write(this.buffer.array(), r0, r5);
            return;
        L6:
            ByteBufferWriter.write(slice(r4, r5 + r4), r3);
        }

        @Override // com.google.protobuf.ByteString
        void writeTo(ByteOutput r1) {
            r1.writeLazy(this.buffer.slice());
        }

        @Override // com.google.protobuf.ByteString
        public ByteBuffer asReadOnlyByteBuffer() {
            return this.buffer.asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.ByteString
        public List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.protobuf.ByteString
        public String toStringInternal(Charset r4) {
            if (this.buffer.hasArray() == false) goto L5;
            byte[] r0 = this.buffer.array();
            int r1 = this.buffer.arrayOffset() + this.buffer.position();
            int r3 = this.buffer.remaining();
        L7:
            return new String(r0, r1, r3, r4);
        L5:
            r0 = toByteArray();
            r1 = 0;
            r3 = r0.length;
            goto L7
        }

        @Override // com.google.protobuf.ByteString
        public boolean isValidUtf8() {
            return Utf8.isValidUtf8(this.buffer);
        }

        @Override // com.google.protobuf.ByteString
        public int partialIsValidUtf8(int r1, int r2, int r3) {
            return Utf8.partialIsValidUtf8(r1, this.buffer, r2, r3 + r2);
        }

        @Override // com.google.protobuf.ByteString
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r8, ByteString.class) == true) goto L8;
            return false;
        L8:
            ByteString r2 = (ByteString) ZeusTransformUtils.preCheckCast(r8, ByteString.class, "com.obric.aiagent.plugin");
            if (size() == r2.size()) goto L12;
            return false;
        L12:
            if (size() != 0) goto L15;
            return true;
        L15:
            if (ZeusTransformUtils.instanceOf(r8, NioByteString.class) == false) goto L19;
            return this.buffer.equals(((NioByteString) ZeusTransformUtils.preCheckCast(r8, NioByteString.class, "com.obric.aiagent.plugin")).buffer);
        L19:
            if (ZeusTransformUtils.instanceOf(r8, RopeByteString.class) == false) goto L23;
            return r8.equals(this);
        L23:
            return this.buffer.equals(r2.asReadOnlyByteBuffer());
        }

        @Override // com.google.protobuf.ByteString
        public int partialHash(int r3, int r4, int r5) {
            int r0 = r4;
        L4:
            if (r0 >= (r4 + r5)) goto L6;
            r3 = (r3 * 31) + this.buffer.get(r0);
            r0 = r0 + 1;
            goto L4
        L6:
            return r3;
        }

        @Override // com.google.protobuf.ByteString
        public InputStream newInput() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.protobuf.ByteString
        public CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.buffer, true);
        }

        private ByteBuffer slice(int r3, int r4) {
            if (r3 < this.buffer.position()) goto L10;
            if (r4 > this.buffer.limit()) goto L10;
            if (r3 > r4) goto L10;
            ByteBuffer r0 = this.buffer.slice();
            Java8Compatibility.position(r0, r3 - this.buffer.position());
            Java8Compatibility.limit(r0, r4 - this.buffer.position());
            return r0;
        L10:
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(r3), Integer.valueOf(r4)}));
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

        Output(int r2) {
            if (r2 < 0) goto L7;
            this.initialCapacity = r2;
            this.flushedBuffers = new ArrayList();
            this.buffer = new byte[r2];
            return;
        L7:
            throw new IllegalArgumentException("Buffer size < 0");
        }

        @Override // java.io.OutputStream
        public synchronized void write(int r4) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.bufferPos != this.buffer.length) goto L6;
            flushFullBuffer(1);     // Catch: Throwable -> L9
        L6:
            byte[] r0 = this.buffer;     // Catch: Throwable -> L9
            int r1 = this.bufferPos;     // Catch: Throwable -> L9
            this.bufferPos = r1 + 1;     // Catch: Throwable -> L9
            r0[r1] = (byte) r4;     // Catch: Throwable -> L9
            monitor-exit(this);
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] r4, int r5, int r6) {
            monitor-enter(this);
            byte[] r0 = this.buffer;     // Catch: Throwable -> L9
            int r1 = r0.length;     // Catch: Throwable -> L9
            int r2 = this.bufferPos;     // Catch: Throwable -> L9
            if (r6 > (r1 - r2)) goto L6;
            System.arraycopy(r4, r5, r0, r2, r6);     // Catch: Throwable -> L9
            this.bufferPos += r6;     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L6:
            int r3 = r0.length - r2;     // Catch: Throwable -> L9
            System.arraycopy(r4, r5, r0, r2, r3);     // Catch: Throwable -> L9
            int r7 = r6 - r3;     // Catch: Throwable -> L9
            flushFullBuffer(r7);     // Catch: Throwable -> L9
            System.arraycopy(r4, r5 + r3, this.buffer, 0, r7);     // Catch: Throwable -> L9
            this.bufferPos = r7;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
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

        public void writeTo(OutputStream r6) {
            monitor-enter(this);
            int r1 = 0;
            ByteString[] r0 = (ByteString[]) ZeusTransformUtils.preCheckCast(this.flushedBuffers.toArray(new ByteString[0]), ByteString[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            byte[] r2 = this.buffer;     // Catch: Throwable -> L10
            int r3 = this.bufferPos;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            int r5 = r0.length;
        L6:
            if (r1 >= r5) goto L8;
            r0[r1].writeTo(r6);
            r1 = r1 + 1;
            goto L6
        L8:
            r6.write(Arrays.copyOf(r2, r3));
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

        private void flushFullBuffer(int r4) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int r0 = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = r0;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(r4, r0 >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int r0 = this.bufferPos;
            byte[] r1 = this.buffer;
            if (r0 >= r1.length) goto L6;
            if (r0 <= 0) goto L7;
            this.flushedBuffers.add(new LiteralByteString(Arrays.copyOf(r1, r0)));
        L7:
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
            return;
        L6:
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            this.buffer = EMPTY_BYTE_ARRAY;
            goto L7
        }
    }

    private static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        /* synthetic */ SystemByteArrayCopier(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] r2, int r3, int r4) {
            byte[] r1 = new byte[r4];
            System.arraycopy(r2, r3, r1, 0, r4);
            return r1;
        }
    }

    private static int hexDigit(char r2) {
        if (r2 >= '0') goto L5;
    L8:
        char r0 = 'A';
        if (r2 >= 'A') goto L11;
    L14:
        r0 = 'a';
        if (r2 >= 'a') goto L17;
        return -1;
    L17:
        if (r2 <= 'f') goto L13;
        return -1;
    L13:
        return (r2 - r0) + 10;
    L11:
        if (r2 > 'F') goto L14;
    L5:
        if (r2 > '9') goto L8;
        return r2 - '0';
    }

    private static int toInt(byte r0) {
        return r0 & 255;
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int r1);

    public abstract void copyTo(ByteBuffer r1);

    public abstract void copyToInternal(byte[] r1, int r2, int r3, int r4);

    public abstract boolean equals(Object r1);

    public abstract int getTreeDepth();

    abstract byte internalByteAt(int r1);

    public abstract boolean isBalanced();

    public abstract boolean isValidUtf8();

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    public abstract int partialHash(int r1, int r2, int r3);

    public abstract int partialIsValidUtf8(int r1, int r2, int r3);

    public abstract int size();

    public abstract ByteString substring(int r1, int r2);

    public abstract String toStringInternal(Charset r1);

    abstract void writeTo(ByteOutput r1);

    public abstract void writeTo(OutputStream r1);

    abstract void writeToInternal(OutputStream r1, int r2, int r3);

    abstract void writeToReverse(ByteOutput r1);

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    static /* synthetic */ int access$200(byte r0) {
        return toInt(r0);
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

    private static int extractHexDigit(String r3, int r4) {
        int r0 = hexDigit(r3.charAt(r4));
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        throw new NumberFormatException("Invalid hexString " + r3 + " must only contain [0-9a-fA-F] but contained " + r3.charAt(r4) + " at index " + r4);
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    public final ByteString substring(int r2) {
        return substring(r2, size());
    }

    public final boolean startsWith(ByteString r4) {
        if (size() >= r4.size()) goto L5;
        return false;
    L5:
        if (substring(0, r4.size()).equals(r4) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean endsWith(ByteString r3) {
        if (size() >= r3.size()) goto L5;
    L7:
        return false;
    L5:
        if (substring(size() - r3.size()).equals(r3) == false) goto L7;
        return true;
    }

    public static ByteString fromHex(String r5) {
        if ((r5.length() % 2) != 0) goto L10;
        int r0 = r5.length() / 2;
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L8;
        int r3 = r2 * 2;
        r1[r2] = (byte) (extractHexDigit(r5, r3 + 1) | (extractHexDigit(r5, r3) << 4));
        r2 = r2 + 1;
        goto L5
    L8:
        return new LiteralByteString(r1);
    L10:
        throw new NumberFormatException("Invalid hexString " + r5 + " of length " + r5.length() + " must be even.");
    }

    public static ByteString copyFrom(byte[] r2, int r3, int r4) {
        checkRange(r3, r3 + r4, r2.length);
        return new LiteralByteString(byteArrayCopier.copyFrom(r2, r3, r4));
    }

    public static ByteString copyFrom(byte[] r2) {
        return copyFrom(r2, 0, r2.length);
    }

    static ByteString wrap(ByteBuffer r3) {
        if (r3.hasArray() == false) goto L7;
        int r0 = r3.arrayOffset();
        return wrap(r3.array(), r0 + r3.position(), r3.remaining());
    L7:
        return new NioByteString(r3);
    }

    static ByteString nioByteString(ByteBuffer r1) {
        return new NioByteString(r1);
    }

    static ByteString wrap(byte[] r1) {
        return new LiteralByteString(r1);
    }

    static ByteString wrap(byte[] r1, int r2, int r3) {
        return new BoundedByteString(r1, r2, r3);
    }

    public static ByteString copyFrom(ByteBuffer r2, int r3) {
        checkRange(0, r3, r2.remaining());
        byte[] r4 = new byte[r3];
        r2.get(r4);
        return new LiteralByteString(r4);
    }

    public static ByteString copyFrom(ByteBuffer r1) {
        return copyFrom(r1, r1.remaining());
    }

    public static ByteString copyFrom(String r1, String r2) {
        return new LiteralByteString(r1.getBytes(r2));
    }

    public static ByteString copyFrom(String r1, Charset r2) {
        return new LiteralByteString(r1.getBytes(r2));
    }

    public static ByteString copyFromUtf8(String r2) {
        return new LiteralByteString(r2.getBytes(Internal.UTF_8));
    }

    public static ByteString readFrom(InputStream r2) {
        return readFrom(r2, 256, 8192);
    }

    public static ByteString readFrom(InputStream r0, int r1) {
        return readFrom(r0, r1, r1);
    }

    public static ByteString readFrom(InputStream r2, int r3, int r4) {
        ArrayList r0 = new ArrayList();
    L3:
        ByteString r1 = readChunk(r2, r3);
        if (r1 == null) goto L6;
        r0.add(r1);
        r3 = Math.min(r3 * 2, r4);
        goto L3
    L6:
        return copyFrom(r0);
    }

    private static ByteString readChunk(InputStream r5, int r6) {
        byte[] r0 = new byte[r6];
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L8;
        int r3 = r5.read(r0, r2, r6 - r2);
        if (r3 == (-1)) goto L8;
        r2 = r2 + r3;
    L8:
        if (r2 != 0) goto L12;
        return null;
    L12:
        return copyFrom(r0, 0, r2);
    }

    public final ByteString concat(ByteString r4) {
        if ((Integer.MAX_VALUE - size()) < r4.size()) goto L7;
        return RopeByteString.concatenate(this, r4);
    L7:
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + r4.size());
    }

    public static ByteString copyFrom(Iterable<ByteString> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L8;
        int r0 = 0;
        Iterator r1 = r4.iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        r1.next();
        r0 = r0 + 1;
    L9:
        if (r0 != 0) goto L13;
        return EMPTY;
    L13:
        return balancedConcat(r4.iterator(), r0);
    L8:
        r0 = ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).size();
        goto L9
    }

    private static ByteString balancedConcat(Iterator<ByteString> r2, int r3) {
        Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.aiagent.plugin");
        if (r3 < 1) goto L9;
        if (r3 == 1) goto L10;
        int r0 = r3 >>> 1;
        return balancedConcat(r4, r0).concat(balancedConcat(r4, r3 - r0));
    L10:
        return (ByteString) ZeusTransformUtils.preCheckCast(r4.next(), ByteString.class, "com.obric.aiagent.plugin");
    L9:
        throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(r3)}));
    }

    public void copyTo(byte[] r3, int r4) {
        copyTo(r3, 0, r4, size());
    }

    @Deprecated
    public final void copyTo(byte[] r3, int r4, int r5, int r6) {
        checkRange(r4, r4 + r6, size());
        checkRange(r5, r5 + r6, r3.length);
        if (r6 <= 0) goto L6;
        copyToInternal(r3, r4, r5, r6);
        return;
    }

    public final byte[] toByteArray() {
        int r0 = size();
        if (r0 == 0) goto L5;
        byte[] r1 = new byte[r0];
        copyToInternal(r1, 0, 0, r0);
        return r1;
    L5:
        return Internal.EMPTY_BYTE_ARRAY;
    }

    final void writeTo(OutputStream r3, int r4, int r5) {
        checkRange(r4, r4 + r5, size());
        if (r5 <= 0) goto L6;
        writeToInternal(r3, r4, r5);
        return;
    }

    public final String toString(String r2) {
        return toString(Charset.forName(r2));
    L4:
        e = move-exception;
        UnsupportedEncodingException r0 = new UnsupportedEncodingException(r2);
        r0.initCause(e);
        throw r0;
    }

    public final String toString(Charset r2) {
        if (size() != 0) goto L6;
        return "";
    L6:
        return toStringInternal(r2);
    }

    public final String toStringUtf8() {
        return toString(Internal.UTF_8);
    }

    public final int hashCode() {
        int r0 = this.hash;
        if (r0 != 0) goto L8;
        int r1 = size();
        r0 = partialHash(r1, 0, r1);
        if (r0 != 0) goto L7;
        r0 = 1;
    L7:
        this.hash = r0;
    L8:
        return r0;
    }

    public static Output newOutput(int r1) {
        return new Output(r1);
    }

    public static Output newOutput() {
        return new Output(128);
    }

    static CodedBuilder newCodedBuilder(int r2) {
        return new CodedBuilder(r2, null);
    }

    public final int peekCachedHashCode() {
        return this.hash;
    }

    static void checkIndex(int r3, int r4) {
        if (((r4 - (r3 + 1)) | r3) >= 0) goto L9;
        if (r3 >= 0) goto L8;
        throw new ArrayIndexOutOfBoundsException("Index < 0: " + r3);
    L8:
        throw new ArrayIndexOutOfBoundsException("Index > length: " + r3 + ", " + r4);
    }

    static int checkRange(int r3, int r4, int r5) {
        int r0 = r4 - r3;
        if ((((r3 | r4) | r0) | (r5 - r4)) >= 0) goto L12;
        if (r3 < 0) goto L11;
        if (r4 >= r3) goto L9;
        throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + r3 + ", " + r4);
    L9:
        throw new IndexOutOfBoundsException("End index: " + r4 + " >= " + r5);
    L11:
        throw new IndexOutOfBoundsException("Beginning index: " + r3 + " < 0");
    L12:
        return r0;
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
