package com.google.common.io;

import com.google.common.base.Preconditions;
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
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class ByteStreams {
    private static final int BUF_SIZE = 4096;
    private static final OutputStream NULL_OUTPUT_STREAM = null;

    private static class ByteArrayDataInputStream implements ByteArrayDataInput {
        final DataInput input;

        ByteArrayDataInputStream(ByteArrayInputStream r2) {
            this.input = new DataInputStream(r2);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] r1) {
            this.input.readFully(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] r1, int r2, int r3) {
            this.input.readFully(r1, r2, r3);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int skipBytes(int r1) {
            return this.input.skipBytes(r1);
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
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
        L7:
            e = move-exception;
            throw new IllegalStateException(e);
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedByte() {
            return this.input.readUnsignedByte();
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
        public int readUnsignedShort() {
            return this.input.readUnsignedShort();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public char readChar() {
            return this.input.readChar();
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
        public long readLong() {
            return this.input.readLong();
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
        public double readDouble() {
            return this.input.readDouble();
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
        public String readUTF() {
            return this.input.readUTF();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }
    }

    private static class ByteArrayDataOutputStream implements ByteArrayDataOutput {
        final ByteArrayOutputStream byteArrayOutputSteam;
        final DataOutput output;

        ByteArrayDataOutputStream(ByteArrayOutputStream r2) {
            this.byteArrayOutputSteam = r2;
            this.output = new DataOutputStream(r2);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(int r1) {
            this.output.write(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] r1) {
            this.output.write(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] r1, int r2, int r3) {
            this.output.write(r1, r2, r3);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBoolean(boolean r1) {
            this.output.writeBoolean(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeByte(int r1) {
            this.output.writeByte(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBytes(String r1) {
            this.output.writeBytes(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChar(int r1) {
            this.output.writeChar(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChars(String r1) {
            this.output.writeChars(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeDouble(double r1) {
            this.output.writeDouble(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeFloat(float r1) {
            this.output.writeFloat(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeInt(int r1) {
            this.output.writeInt(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeLong(long r1) {
            this.output.writeLong(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeShort(int r1) {
            this.output.writeShort(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeUTF(String r1) {
            this.output.writeUTF(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput
        public byte[] toByteArray() {
            return this.byteArrayOutputSteam.toByteArray();
        }
    }

    private static final class FastByteArrayOutputStream extends ByteArrayOutputStream {
        private FastByteArrayOutputStream() {
        }

        /* synthetic */ FastByteArrayOutputStream(AnonymousClass1 r1) {
            this();
        }

        void writeTo(byte[] r3, int r4) {
            System.arraycopy(this.buf, 0, r3, r4, this.count);
        }
    }

    private static final class LimitedInputStream extends FilterInputStream {
        private long left;
        private long mark;

        LimitedInputStream(InputStream r3, long r4) {
            super(r3);
            this.mark = -1;
            Preconditions.checkNotNull(r3);
            if (r4 < 0) goto L5;
            boolean r5 = true;
        L6:
            Preconditions.checkArgument(r5, "limit must be non-negative");
            this.left = r4;
            return;
        L5:
            r5 = false;
            goto L6
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(this.in.available(), this.left);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int r3) {
            monitor-enter(this);
            this.in.mark(r3);     // Catch: Throwable -> L6
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
            int r0 = this.in.read();
            if (r0 == (-1)) goto L8;
            this.left--;
        L8:
            return r0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] r7, int r8, int r9) throws IOException {
            long r0 = this.left;
            if (r0 != 0) goto L5;
            return -1;
        L5:
            int r10 = this.in.read(r7, r8, (int) Math.min(r9, r0));
            if (r10 == (-1)) goto L8;
            this.left -= (long) r10;
        L8:
            return r10;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L4:
            if (this.in.markSupported() == false) goto L13;
            if (this.mark == (-1)) goto L11;
            this.in.reset();     // Catch: Throwable -> L14
            this.left = this.mark;     // Catch: Throwable -> L14
            monitor-exit(this);
            return;
        L11:
            throw new IOException("Mark not set");     // Catch: Throwable -> L14
        L13:
            throw new IOException("Mark not supported");     // Catch: Throwable -> L14
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long r3) throws IOException {
            long r4 = this.in.skip(Math.min(r3, this.left));
            this.left -= r4;
            return r4;
        }
    }

    private ByteStreams() {
    }

    public static long copy(InputStream r5, OutputStream r6) throws IOException {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        byte[] r0 = new byte[4096];
        long r1 = 0;
    L3:
        int r3 = r5.read(r0);
        if (r3 == (-1)) goto L5;
        r6.write(r0, 0, r3);
        r1 = r1 + ((long) r3);
        goto L3
    L5:
        return r1;
    }

    public static long copy(ReadableByteChannel r5, WritableByteChannel r6) throws IOException {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        ByteBuffer r0 = ByteBuffer.allocate(4096);
        long r1 = 0;
    L4:
        if (r5.read(r0) == (-1)) goto L10;
        r0.flip();
    L7:
        if (r0.hasRemaining() == false) goto L9;
        r1 = r1 + ((long) r6.write(r0));
        goto L7
    L9:
        r0.clear();
        goto L4
    L10:
        return r1;
    }

    public static byte[] toByteArray(InputStream r1) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        copy(r1, r0);
        return r0.toByteArray();
    }

    static byte[] toByteArray(InputStream r5, int r6) throws IOException {
        byte[] r0 = new byte[r6];
        int r1 = r6;
    L4:
        if (r1 <= 0) goto L10;
        int r3 = r6 - r1;
        int r4 = r5.read(r0, r3, r1);
        if (r4 == (-1)) goto L8;
        r1 = r1 - r4;
        goto L4
    L8:
        return Arrays.copyOf(r0, r3);
    L10:
        int r2 = r5.read();
        if (r2 != (-1)) goto L13;
        return r0;
    L13:
        FastByteArrayOutputStream r7 = new FastByteArrayOutputStream(null);
        r7.write(r2);
        copy(r5, r7);
        byte[] r8 = new byte[r7.size() + r6];
        System.arraycopy(r0, 0, r8, 0, r6);
        r7.writeTo(r8, r6);
        return r8;
    }

    public static ByteArrayDataInput newDataInput(byte[] r1) {
        return newDataInput(new ByteArrayInputStream(r1));
    }

    public static ByteArrayDataInput newDataInput(byte[] r2, int r3) {
        Preconditions.checkPositionIndex(r3, r2.length);
        return newDataInput(new ByteArrayInputStream(r2, r3, r2.length - r3));
    }

    public static ByteArrayDataInput newDataInput(ByteArrayInputStream r1) {
        return new ByteArrayDataInputStream((ByteArrayInputStream) Preconditions.checkNotNull(r1));
    }

    public static ByteArrayDataOutput newDataOutput() {
        return newDataOutput(new ByteArrayOutputStream());
    }

    public static ByteArrayDataOutput newDataOutput(int r4) {
        if (r4 < 0) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "Invalid size: %s", new Object[]{Integer.valueOf(r4)});
        return newDataOutput(new ByteArrayOutputStream(r4));
    L5:
        r2 = false;
        goto L6
    }

    public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream r1) {
        return new ByteArrayDataOutputStream((ByteArrayOutputStream) Preconditions.checkNotNull(r1));
    }

    static {
        NULL_OUTPUT_STREAM = new AnonymousClass1();
    }

    public static OutputStream nullOutputStream() {
        return NULL_OUTPUT_STREAM;
    }

    public static InputStream limit(InputStream r1, long r2) {
        return new LimitedInputStream(r1, r2);
    }

    public static void readFully(InputStream r2, byte[] r3) throws IOException {
        readFully(r2, r3, 0, r3.length);
    }

    public static void readFully(InputStream r1, byte[] r2, int r3, int r4) throws IOException {
        int r5 = read(r1, r2, r3, r4);
        if (r5 != r4) goto L6;
        return;
    L6:
        throw new EOFException("reached end of stream after reading " + r5 + " bytes; " + r4 + " bytes expected");
    }

    public static void skipFully(InputStream r6, long r7) throws IOException {
        long r0 = r7;
    L4:
        if (r0 <= 0) goto L13;
        long r4 = r6.skip(r0);
        if (r4 == 0) goto L8;
        r0 = r0 - r4;
        goto L4
    L8:
        if (r6.read() == (-1)) goto L10;
        r0 = r0 - 1;
        goto L4
    L10:
        StringBuilder r2 = new StringBuilder("reached end of stream after skipping ");
        throw new EOFException(r2.append(r7 - r0).append(" bytes; ").append(r7).append(" bytes expected").toString());
    }

    public static <T> T readBytes(InputStream r3, ByteProcessor<T> r4) throws IOException {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        byte[] r0 = new byte[4096];
    L3:
        int r1 = r3.read(r0);
        if (r1 == (-1)) goto L8;
        if (r4.processBytes(r0, 0, r1) == true) goto L3;
    L8:
        return r4.getResult();
    }

    public static int read(InputStream r3, byte[] r4, int r5, int r6) throws IOException {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        if (r6 < 0) goto L12;
        int r0 = 0;
    L5:
        if (r0 >= r6) goto L10;
        int r1 = r3.read(r4, r5 + r0, r6 - r0);
        if (r1 == (-1)) goto L10;
        r0 = r0 + r1;
    L10:
        return r0;
    L12:
        throw new IndexOutOfBoundsException("len is negative");
    }
}
