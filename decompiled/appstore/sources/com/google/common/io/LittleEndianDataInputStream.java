package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class LittleEndianDataInputStream extends FilterInputStream implements DataInput {
    public LittleEndianDataInputStream(InputStream r10) {
        super((InputStream) Preconditions.checkNotNull(r10));
    }

    private byte readAndCheckByte() throws IOException, EOFException {
        int r10 = ((FilterInputStream) this).in.read();
        if ((-1) == r10) goto L7;
        return (byte) r10;
    L7:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    @CanIgnoreReturnValue
    public boolean readBoolean() throws IOException {
        if (readUnsignedByte() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.io.DataInput
    @CanIgnoreReturnValue
    public byte readByte() throws IOException {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    @CanIgnoreReturnValue
    public char readChar() throws IOException {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    @CanIgnoreReturnValue
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    @CanIgnoreReturnValue
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] r10) throws IOException {
        ByteStreams.readFully(this, r10);
    }

    @Override // java.io.DataInput
    @CanIgnoreReturnValue
    public int readInt() throws IOException {
        byte r10 = readAndCheckByte();
        byte r11 = readAndCheckByte();
        byte r12 = readAndCheckByte();
        return Ints.fromBytes(readAndCheckByte(), r12, r11, r10);
    }

    @Override // java.io.DataInput
    @CanIgnoreReturnValue
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    @CanIgnoreReturnValue
    public long readLong() throws IOException {
        byte r10 = readAndCheckByte();
        byte r11 = readAndCheckByte();
        byte r12 = readAndCheckByte();
        byte r13 = readAndCheckByte();
        byte r14 = readAndCheckByte();
        byte r15 = readAndCheckByte();
        byte r16 = readAndCheckByte();
        return Longs.fromBytes(readAndCheckByte(), r16, r15, r14, r13, r12, r11, r10);
    }

    @Override // java.io.DataInput
    @CanIgnoreReturnValue
    public short readShort() throws IOException {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    @CanIgnoreReturnValue
    public String readUTF() throws IOException {
        return new DataInputStream(((FilterInputStream) this).in).readUTF();
    }

    @Override // java.io.DataInput
    @CanIgnoreReturnValue
    public int readUnsignedByte() throws IOException {
        int r10 = ((FilterInputStream) this).in.read();
        if (r10 < 0) goto L6;
        return r10;
    L6:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    @CanIgnoreReturnValue
    public int readUnsignedShort() throws IOException {
        byte r10 = readAndCheckByte();
        return Ints.fromBytes((byte) 0, (byte) 0, readAndCheckByte(), r10);
    }

    @Override // java.io.DataInput
    public int skipBytes(int r10) throws IOException {
        return (int) ((FilterInputStream) this).in.skip(r10);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] r10, int r11, int r12) throws IOException {
        ByteStreams.readFully(this, r10, r11, r12);
    }
}
