package com.google.common.io;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final class ByteStreams {
    private static final int BUFFER_SIZE = 8192;
    private static final int MAX_ARRAY_LEN = 2147483639;
    private static final OutputStream NULL_OUTPUT_STREAM = null;
    private static final int TO_BYTE_ARRAY_DEQUE_SIZE = 20;
    private static final int ZERO_COPY_CHUNK_SIZE = 524288;

    public static class ByteArrayDataInputStream implements ByteArrayDataInput {
        final DataInput input;

        public ByteArrayDataInputStream(ByteArrayInputStream r10) {
            this.input = new DataInputStream(r10);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public boolean readBoolean() {
            return this.input.readBoolean();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public byte readByte() {
            return this.input.readByte();
        L6:
            e = move-exception;
            throw new IllegalStateException(e);
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public char readChar() {
            return this.input.readChar();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public double readDouble() {
            return this.input.readDouble();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public float readFloat() {
            return this.input.readFloat();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] r10) {
            this.input.readFully(r10);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readInt() {
            return this.input.readInt();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public String readLine() {
            return this.input.readLine();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public long readLong() {
            return this.input.readLong();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public short readShort() {
            return this.input.readShort();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public String readUTF() {
            return this.input.readUTF();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedByte() {
            return this.input.readUnsignedByte();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedShort() {
            return this.input.readUnsignedShort();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int skipBytes(int r10) {
            return this.input.skipBytes(r10);
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] r10, int r11, int r12) {
            this.input.readFully(r10, r11, r12);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }
    }

    public static class ByteArrayDataOutputStream implements ByteArrayDataOutput {
        final ByteArrayOutputStream byteArrayOutputSteam;
        final DataOutput output;

        public ByteArrayDataOutputStream(ByteArrayOutputStream r10) {
            this.byteArrayOutputSteam = r10;
            this.output = new DataOutputStream(r10);
        }

        @Override // com.google.common.io.ByteArrayDataOutput
        public byte[] toByteArray() {
            return this.byteArrayOutputSteam.toByteArray();
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(int r10) {
            this.output.write(r10);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBoolean(boolean r10) {
            this.output.writeBoolean(r10);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeByte(int r10) {
            this.output.writeByte(r10);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBytes(String r10) {
            this.output.writeBytes(r10);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChar(int r10) {
            this.output.writeChar(r10);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChars(String r10) {
            this.output.writeChars(r10);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeDouble(double r10) {
            this.output.writeDouble(r10);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeFloat(float r10) {
            this.output.writeFloat(r10);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeInt(int r10) {
            this.output.writeInt(r10);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeLong(long r10) {
            this.output.writeLong(r10);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeShort(int r10) {
            this.output.writeShort(r10);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeUTF(String r10) {
            this.output.writeUTF(r10);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] r10) {
            this.output.write(r10);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] r10, int r11, int r12) {
            this.output.write(r10, r11, r12);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }
    }

    public static final class LimitedInputStream extends FilterInputStream {
        private long left;
        private long mark;

        public LimitedInputStream(InputStream r10, long r11) {
            super(r10);
            this.mark = -1;
            Preconditions.checkNotNull(r10);
            if (r11 < 0) goto L5;
            boolean r12 = true;
        L6:
            Preconditions.checkArgument(r12, "limit must be non-negative");
            this.left = r11;
            return;
        L5:
            r12 = false;
            goto L6
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.left);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int r10) {
            monitor-enter(this);
            ((FilterInputStream) this).in.mark(r10);     // Catch: Throwable -> L6
            this.mark = this.left;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.left != 0) goto L5;
            return -1;
        L5:
            int r10 = ((FilterInputStream) this).in.read();
            if (r10 == (-1)) goto L8;
            this.left--;
        L8:
            return r10;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (((FilterInputStream) this).in.markSupported() == false) goto L15;
            if (this.mark == (-1)) goto L13;
            ((FilterInputStream) this).in.reset();     // Catch: Throwable -> L10
            this.left = this.mark;     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L13:
            throw new IOException("Mark not set");     // Catch: Throwable -> L10
        L15:
            throw new IOException("Mark not supported");     // Catch: Throwable -> L10
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long r10) throws IOException {
            long r11 = ((FilterInputStream) this).in.skip(Math.min(r10, this.left));
            this.left -= r11;
            return r11;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] r10, int r11, int r12) throws IOException {
            long r13 = this.left;
            if (r13 != 0) goto L5;
            return -1;
        L5:
            int r14 = ((FilterInputStream) this).in.read(r10, r11, (int) Math.min(r12, r13));
            if (r14 == (-1)) goto L8;
            this.left -= (long) r14;
        L8:
            return r14;
        }
    }

    static {
        NULL_OUTPUT_STREAM = new AnonymousClass1();
    }

    private ByteStreams() {
    }

    private static byte[] combineBuffers(Deque<byte[]> r10, int r11) {
        byte[] r12 = new byte[r11];
        int r13 = r11;
    L3:
        if (r13 <= 0) goto L5;
        byte[] r14 = r10.removeFirst();
        int r15 = Math.min(r13, r14.length);
        System.arraycopy(r14, 0, r12, r11 - r13, r15);
        r13 = r13 - r15;
        goto L3
    L5:
        return r12;
    }

    @CanIgnoreReturnValue
    public static long copy(InputStream r10, OutputStream r11) throws IOException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        byte[] r12 = createBuffer();
        long r13 = 0;
    L3:
        int r14 = r10.read(r12);
        if (r14 == (-1)) goto L5;
        r11.write(r12, 0, r14);
        r13 = r13 + ((long) r14);
        goto L3
    L5:
        return r13;
    }

    public static byte[] createBuffer() {
        return new byte[8192];
    }

    @CanIgnoreReturnValue
    @Beta
    public static long exhaust(InputStream r10) throws IOException {
        byte[] r11 = createBuffer();
        long r12 = 0;
    L3:
        long r13 = r10.read(r11);
        if (r13 == (-1)) goto L6;
        r12 = r12 + r13;
        goto L3
    L6:
        return r12;
    }

    @Beta
    public static InputStream limit(InputStream r10, long r11) {
        return new LimitedInputStream(r10, r11);
    }

    @Beta
    public static ByteArrayDataInput newDataInput(byte[] r10) {
        return newDataInput(new ByteArrayInputStream(r10));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput() {
        return newDataOutput(new ByteArrayOutputStream());
    }

    @Beta
    public static OutputStream nullOutputStream() {
        return NULL_OUTPUT_STREAM;
    }

    @CanIgnoreReturnValue
    @Beta
    public static int read(InputStream r10, byte[] r11, int r12, int r13) throws IOException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        if (r13 < 0) goto L12;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L10;
        int r15 = r10.read(r11, r12 + r14, r13 - r14);
        if (r15 == (-1)) goto L10;
        r14 = r14 + r15;
    L10:
        return r14;
    L12:
        throw new IndexOutOfBoundsException("len is negative");
    }

    @CanIgnoreReturnValue
    @Beta
    public static <T> T readBytes(InputStream r10, ByteProcessor<T> r11) throws IOException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        byte[] r12 = createBuffer();
    L3:
        int r13 = r10.read(r12);
        if (r13 == (-1)) goto L8;
        if (r11.processBytes(r12, 0, r13) == true) goto L3;
    L8:
        return r11.getResult();
    }

    @Beta
    public static void readFully(InputStream r10, byte[] r11) throws IOException {
        readFully(r10, r11, 0, r11.length);
    }

    @Beta
    public static void skipFully(InputStream r10, long r11) throws IOException {
        long r12 = skipUpTo(r10, r11);
        if (r12 < r11) goto L6;
        return;
    L6:
        throw new EOFException("reached end of stream after skipping " + r12 + " bytes; " + r11 + " bytes expected");
    }

    private static long skipSafely(InputStream r10, long r11) throws IOException {
        int r12 = r10.available();
        if (r12 != 0) goto L6;
        return 0;
    L6:
        return r10.skip(Math.min(r12, r11));
    }

    public static long skipUpTo(InputStream r10, long r11) throws IOException {
        byte[] r12 = createBuffer();
        long r13 = 0;
    L4:
        if (r13 >= r11) goto L11;
        long r14 = r11 - r13;
        long r15 = skipSafely(r10, r14);
        if (r15 != 0) goto L10;
        r15 = r10.read(r12, 0, (int) Math.min(r14, r12.length));
        if (r15 == (-1)) goto L11;
    L10:
        r13 = r13 + r15;
    L11:
        return r13;
    }

    public static byte[] toByteArray(InputStream r10) throws IOException {
        Preconditions.checkNotNull(r10);
        return toByteArrayInternal(r10, new ArrayDeque(20), 0);
    }

    private static byte[] toByteArrayInternal(InputStream r10, Deque<byte[]> r11, int r12) throws IOException {
        int r13 = 8192;
    L4:
        if (r12 >= MAX_ARRAY_LEN) goto L14;
        int r14 = Math.min(r13, MAX_ARRAY_LEN - r12);
        byte[] r15 = new byte[r14];
        r11.add(r15);
        int r16 = 0;
    L6:
        if (r16 >= r14) goto L12;
        int r17 = r10.read(r15, r16, r14 - r16);
        if (r17 == (-1)) goto L10;
        r16 = r16 + r17;
        r12 = r12 + r17;
        goto L6
    L10:
        return combineBuffers(r11, r12);
    L12:
        r13 = IntMath.saturatedMultiply(r13, 2);
        goto L4
    L14:
        if (r10.read() != (-1)) goto L18;
        return combineBuffers(r11, MAX_ARRAY_LEN);
    L18:
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    @Beta
    public static ByteArrayDataInput newDataInput(byte[] r10, int r11) {
        Preconditions.checkPositionIndex(r11, r10.length);
        return newDataInput(new ByteArrayInputStream(r10, r11, r10.length - r11));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput(int r10) {
        if (r10 < 0) goto L6;
        return newDataOutput(new ByteArrayOutputStream(r10));
    L6:
        throw new IllegalArgumentException(String.format("Invalid size: %s", new Object[]{Integer.valueOf(r10)}));
    }

    @Beta
    public static void readFully(InputStream r10, byte[] r11, int r12, int r13) throws IOException {
        int r14 = read(r10, r11, r12, r13);
        if (r14 != r13) goto L6;
        return;
    L6:
        throw new EOFException("reached end of stream after reading " + r14 + " bytes; " + r13 + " bytes expected");
    }

    public static byte[] toByteArray(InputStream r10, long r11) throws IOException {
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "expectedSize (%s) must be non-negative", r11);
        if (r11 > 2147483639) goto L22;
        int r13 = (int) r11;
        byte[] r14 = new byte[r13];
        int r15 = r13;
    L10:
        if (r15 <= 0) goto L16;
        int r16 = r13 - r15;
        int r17 = r10.read(r14, r16, r15);
        if (r17 == (-1)) goto L14;
        r15 = r15 - r17;
        goto L10
    L14:
        return Arrays.copyOf(r14, r16);
    L16:
        int r18 = r10.read();
        if (r18 != (-1)) goto L19;
        return r14;
    L19:
        ArrayDeque r19 = new ArrayDeque(22);
        r19.add(r14);
        r19.add(new byte[]{(byte) r18});
        return toByteArrayInternal(r10, r19, r13 + 1);
    L22:
        throw new OutOfMemoryError(r11 + " bytes is too large to fit in a byte array");
    L5:
        r12 = false;
        goto L6
    }

    @Beta
    public static ByteArrayDataInput newDataInput(ByteArrayInputStream r10) {
        return new ByteArrayDataInputStream((ByteArrayInputStream) Preconditions.checkNotNull(r10));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream r10) {
        return new ByteArrayDataOutputStream((ByteArrayOutputStream) Preconditions.checkNotNull(r10));
    }

    @CanIgnoreReturnValue
    public static long copy(ReadableByteChannel r13, WritableByteChannel r14) throws IOException {
        Preconditions.checkNotNull(r13);
        Preconditions.checkNotNull(r14);
        long r10 = 0;
        if ((r13 instanceof FileChannel) == false) goto L11;
        FileChannel r11 = (FileChannel) r13;
        long r12 = r11.position();
        long r15 = r12;
    L5:
        long r16 = r11.transferTo(r15, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, r14);
        r15 = r15 + r16;
        r11.position(r15);
        if (r16 > 0) goto L5;
        if (r15 < r11.size()) goto L5;
        return r15 - r12;
    L11:
        ByteBuffer r17 = ByteBuffer.wrap(createBuffer());
    L13:
        if (r13.read(r17) == (-1)) goto L19;
        r17.flip();
    L16:
        if (r17.hasRemaining() == false) goto L18;
        r10 = r10 + ((long) r14.write(r17));
        goto L16
    L18:
        r17.clear();
        goto L13
    L19:
        return r10;
    }
}
