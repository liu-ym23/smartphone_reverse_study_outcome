package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput {
    public LittleEndianDataOutputStream(OutputStream r10) {
        super(new DataOutputStream((OutputStream) Preconditions.checkNotNull(r10)));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
    public void write(byte[] r10, int r11, int r12) throws IOException {
        ((FilterOutputStream) this).out.write(r10, r11, r12);
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean r10) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBoolean(r10);
    }

    @Override // java.io.DataOutput
    public void writeByte(int r10) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeByte(r10);
    }

    @Override // java.io.DataOutput
    @Deprecated
    public void writeBytes(String r10) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBytes(r10);
    }

    @Override // java.io.DataOutput
    public void writeChar(int r10) throws IOException {
        writeShort(r10);
    }

    @Override // java.io.DataOutput
    public void writeChars(String r10) throws IOException {
        int r11 = 0;
    L4:
        if (r11 >= r10.length()) goto L6;
        writeChar(r10.charAt(r11));
        r11 = r11 + 1;
        goto L4
    }

    @Override // java.io.DataOutput
    public void writeDouble(double r10) throws IOException {
        writeLong(Double.doubleToLongBits(r10));
    }

    @Override // java.io.DataOutput
    public void writeFloat(float r10) throws IOException {
        writeInt(Float.floatToIntBits(r10));
    }

    @Override // java.io.DataOutput
    public void writeInt(int r10) throws IOException {
        ((FilterOutputStream) this).out.write(r10 & PrivateKeyType.INVALID);
        ((FilterOutputStream) this).out.write((r10 >> 8) & PrivateKeyType.INVALID);
        ((FilterOutputStream) this).out.write((r10 >> 16) & PrivateKeyType.INVALID);
        ((FilterOutputStream) this).out.write((r10 >> 24) & PrivateKeyType.INVALID);
    }

    @Override // java.io.DataOutput
    public void writeLong(long r10) throws IOException {
        byte[] r11 = Longs.toByteArray(Long.reverseBytes(r10));
        write(r11, 0, r11.length);
    }

    @Override // java.io.DataOutput
    public void writeShort(int r10) throws IOException {
        ((FilterOutputStream) this).out.write(r10 & PrivateKeyType.INVALID);
        ((FilterOutputStream) this).out.write((r10 >> 8) & PrivateKeyType.INVALID);
    }

    @Override // java.io.DataOutput
    public void writeUTF(String r10) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeUTF(r10);
    }
}
