package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import java.io.DataOutput;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public interface ByteArrayDataOutput extends DataOutput {
    byte[] toByteArray();

    @Override // java.io.DataOutput
    void write(int r10);

    @Override // java.io.DataOutput
    void write(byte[] r10);

    @Override // java.io.DataOutput
    void write(byte[] r10, int r11, int r12);

    @Override // java.io.DataOutput
    void writeBoolean(boolean r10);

    @Override // java.io.DataOutput
    void writeByte(int r10);

    @Override // java.io.DataOutput
    @Deprecated
    void writeBytes(String r10);

    @Override // java.io.DataOutput
    void writeChar(int r10);

    @Override // java.io.DataOutput
    void writeChars(String r10);

    @Override // java.io.DataOutput
    void writeDouble(double r10);

    @Override // java.io.DataOutput
    void writeFloat(float r10);

    @Override // java.io.DataOutput
    void writeInt(int r10);

    @Override // java.io.DataOutput
    void writeLong(long r10);

    @Override // java.io.DataOutput
    void writeShort(int r10);

    @Override // java.io.DataOutput
    void writeUTF(String r10);
}
