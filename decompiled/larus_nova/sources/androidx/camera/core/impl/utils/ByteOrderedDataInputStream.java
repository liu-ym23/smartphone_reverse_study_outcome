package androidx.camera.core.impl.utils;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
final class ByteOrderedDataInputStream extends InputStream implements DataInput {
    private static final ByteOrder BIG_ENDIAN = null;
    private static final ByteOrder LITTLE_ENDIAN = null;
    private ByteOrder mByteOrder;
    private final DataInputStream mDataInputStream;
    final int mLength;
    int mPosition;

    static {
        LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.mDataInputStream.available();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.mPosition++;
        return this.mDataInputStream.read();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        this.mPosition++;
        return this.mDataInputStream.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        int r100 = this.mPosition + 1;
        this.mPosition = r100;
        if (r100 > this.mLength) goto L11;
        int r101 = this.mDataInputStream.read();
        if (r101 < 0) goto L9;
        return (byte) r101;
    L9:
        throw new EOFException();
    L11:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        this.mPosition += 2;
        return this.mDataInputStream.readChar();
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        int r100 = this.mPosition + 4;
        this.mPosition = r100;
        if (r100 > this.mLength) goto L19;
        int r101 = this.mDataInputStream.read();
        int r102 = this.mDataInputStream.read();
        int r103 = this.mDataInputStream.read();
        int r104 = this.mDataInputStream.read();
        if ((((r101 | r102) | r103) | r104) < 0) goto L17;
        ByteOrder r105 = this.mByteOrder;
        if (r105 != LITTLE_ENDIAN) goto L11;
        return (((r104 << 24) + (r103 << 16)) + (r102 << 8)) + r101;
    L11:
        if (r105 != BIG_ENDIAN) goto L15;
        return (((r101 << 24) + (r102 << 16)) + (r103 << 8)) + r104;
    L15:
        throw new IOException("Invalid byte order: " + this.mByteOrder);
    L17:
        throw new EOFException();
    L19:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public String readLine() {
        throw new UnsupportedOperationException("readLine() not implemented.");
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        int r100 = this.mPosition + 8;
        this.mPosition = r100;
        if (r100 > this.mLength) goto L19;
        int r101 = this.mDataInputStream.read();
        int r102 = this.mDataInputStream.read();
        int r103 = this.mDataInputStream.read();
        int r104 = this.mDataInputStream.read();
        int r105 = this.mDataInputStream.read();
        int r106 = this.mDataInputStream.read();
        int r107 = this.mDataInputStream.read();
        int r108 = this.mDataInputStream.read();
        if ((((((((r101 | r102) | r103) | r104) | r105) | r106) | r107) | r108) < 0) goto L17;
        ByteOrder r110 = this.mByteOrder;
        if (r110 != LITTLE_ENDIAN) goto L11;
        return (((((((((long) r108) << 56) + (((long) r107) << 48)) + (((long) r106) << 40)) + (((long) r105) << 32)) + (((long) r104) << 24)) + (((long) r103) << 16)) + (((long) r102) << 8)) + ((long) r101);
    L11:
        if (r110 != BIG_ENDIAN) goto L15;
        return (((((((((long) r101) << 56) + (((long) r102) << 48)) + (((long) r103) << 40)) + (((long) r104) << 32)) + (((long) r105) << 24)) + (((long) r106) << 16)) + (((long) r107) << 8)) + ((long) r108);
    L15:
        throw new IOException("Invalid byte order: " + this.mByteOrder);
    L17:
        throw new EOFException();
    L19:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        int r100 = this.mPosition + 2;
        this.mPosition = r100;
        if (r100 > this.mLength) goto L19;
        int r101 = this.mDataInputStream.read();
        int r102 = this.mDataInputStream.read();
        if ((r101 | r102) < 0) goto L17;
        ByteOrder r103 = this.mByteOrder;
        if (r103 != LITTLE_ENDIAN) goto L11;
        return (short) ((r102 << 8) + r101);
    L11:
        if (r103 != BIG_ENDIAN) goto L15;
        return (short) ((r101 << 8) + r102);
    L15:
        throw new IOException("Invalid byte order: " + this.mByteOrder);
    L17:
        throw new EOFException();
    L19:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        this.mPosition += 2;
        return this.mDataInputStream.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        this.mPosition++;
        return this.mDataInputStream.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        int r100 = this.mPosition + 2;
        this.mPosition = r100;
        if (r100 > this.mLength) goto L19;
        int r101 = this.mDataInputStream.read();
        int r102 = this.mDataInputStream.read();
        if ((r101 | r102) < 0) goto L17;
        ByteOrder r103 = this.mByteOrder;
        if (r103 != LITTLE_ENDIAN) goto L11;
        return (r102 << 8) + r101;
    L11:
        if (r103 != BIG_ENDIAN) goto L15;
        return (r101 << 8) + r102;
    L15:
        throw new IOException("Invalid byte order: " + this.mByteOrder);
    L17:
        throw new EOFException();
    L19:
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    public long readUnsignedInt() throws IOException {
        return ((long) readInt()) & BodyPartID.bodyIdMax;
    }

    public int getLength() {
        return this.mLength;
    }

    public int peek() {
        return this.mPosition;
    }

    public ByteOrderedDataInputStream(byte[] r100) throws IOException {
        this(new ByteArrayInputStream(r100));
    }

    @Override // java.io.InputStream
    public void mark(int r100) {
        DataInputStream r101 = this.mDataInputStream;
        monitor-enter(r101);
        this.mDataInputStream.mark(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.DataInput
    public void readFully(byte[] r100) throws IOException {
        int r101 = this.mPosition + r100.length;
        this.mPosition = r101;
        if (r101 > this.mLength) goto L10;
        if (this.mDataInputStream.read(r100, 0, r100.length) != r100.length) goto L8;
        return;
    L8:
        throw new IOException("Couldn't read up to the length of buffer");
    L10:
        throw new EOFException();
    }

    public void seek(long r100) throws IOException {
        int r101 = this.mPosition;
        if (r101 <= r100) goto L5;
        this.mPosition = 0;
        this.mDataInputStream.reset();
        this.mDataInputStream.mark(this.mLength);
    L6:
        int r102 = (int) r100;
        if (skipBytes(r102) != r102) goto L10;
        return;
    L10:
        throw new IOException("Couldn't seek up to the byteCount");
    L5:
        r100 = r100 - ((long) r101);
        goto L6
    }

    public void setByteOrder(ByteOrder r100) {
        this.mByteOrder = r100;
    }

    @Override // java.io.DataInput
    public int skipBytes(int r100) throws IOException {
        int r101 = Math.min(r100, this.mLength - this.mPosition);
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r102 = r102 + this.mDataInputStream.skipBytes(r101 - r102);
        goto L3
    L5:
        this.mPosition += r102;
        return r102;
    }

    public ByteOrderedDataInputStream(InputStream r100) throws IOException {
        this(r100, ByteOrder.BIG_ENDIAN);
    }

    public ByteOrderedDataInputStream(InputStream r100, ByteOrder r101) throws IOException {
        this.mByteOrder = ByteOrder.BIG_ENDIAN;
        DataInputStream r102 = new DataInputStream(r100);
        this.mDataInputStream = r102;
        int r103 = r102.available();
        this.mLength = r103;
        this.mPosition = 0;
        r102.mark(r103);
        this.mByteOrder = r101;
    }

    @Override // java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = this.mDataInputStream.read(r100, r101, r102);
        this.mPosition += r103;
        return r103;
    }

    @Override // java.io.DataInput
    public void readFully(byte[] r100, int r101, int r102) throws IOException {
        int r103 = this.mPosition + r102;
        this.mPosition = r103;
        if (r103 > this.mLength) goto L10;
        if (this.mDataInputStream.read(r100, r101, r102) != r102) goto L8;
        return;
    L8:
        throw new IOException("Couldn't read up to the length of buffer");
    L10:
        throw new EOFException();
    }
}
