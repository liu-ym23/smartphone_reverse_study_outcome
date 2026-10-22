package androidx.camera.core.impl.utils;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
class ByteOrderedDataOutputStream extends FilterOutputStream {
    private ByteOrder mByteOrder;
    final OutputStream mOutputStream;

    public void setByteOrder(ByteOrder r100) {
        this.mByteOrder = r100;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r100) throws IOException {
        this.mOutputStream.write(r100);
    }

    public void writeByte(int r100) throws IOException {
        this.mOutputStream.write(r100);
    }

    public void writeInt(int r100) throws IOException {
        ByteOrder r101 = this.mByteOrder;
        if (r101 != ByteOrder.LITTLE_ENDIAN) goto L6;
        this.mOutputStream.write((r100 >>> 0) & 255);
        this.mOutputStream.write((r100 >>> 8) & 255);
        this.mOutputStream.write((r100 >>> 16) & 255);
        this.mOutputStream.write((r100 >>> 24) & 255);
        return;
    L6:
        if (r101 != ByteOrder.BIG_ENDIAN) goto L10;
        this.mOutputStream.write((r100 >>> 24) & 255);
        this.mOutputStream.write((r100 >>> 16) & 255);
        this.mOutputStream.write((r100 >>> 8) & 255);
        this.mOutputStream.write((r100 >>> 0) & 255);
        return;
    }

    public void writeShort(short r100) throws IOException {
        ByteOrder r101 = this.mByteOrder;
        if (r101 != ByteOrder.LITTLE_ENDIAN) goto L6;
        this.mOutputStream.write((r100 >>> 0) & 255);
        this.mOutputStream.write((r100 >>> 8) & 255);
        return;
    L6:
        if (r101 != ByteOrder.BIG_ENDIAN) goto L10;
        this.mOutputStream.write((r100 >>> 8) & 255);
        this.mOutputStream.write((r100 >>> 0) & 255);
        return;
    }

    public void writeUnsignedInt(long r100) throws IOException {
        writeInt((int) r100);
    }

    public void writeUnsignedShort(int r100) throws IOException {
        writeShort((short) r100);
    }

    public ByteOrderedDataOutputStream(OutputStream r100, ByteOrder r101) {
        super(r100);
        this.mOutputStream = r100;
        this.mByteOrder = r101;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        this.mOutputStream.write(r100, r101, r102);
    }
}
