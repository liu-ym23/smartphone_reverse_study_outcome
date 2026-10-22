package androidx.emoji2.text.flatbuffer;

/* loaded from: classes2.dex */
interface ReadWriteBuf extends ReadBuf {
    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    int limit();

    void put(byte b);

    void put(byte[] bArr, int i, int i6);

    void putBoolean(boolean z10);

    void putDouble(double d);

    void putFloat(float f);

    void putInt(int i);

    void putLong(long j5);

    void putShort(short s5);

    boolean requestCapacity(int i);

    void set(int i, byte b);

    void set(int i, byte[] bArr, int i6, int i10);

    void setBoolean(int i, boolean z10);

    void setDouble(int i, double d);

    void setFloat(int i, float f);

    void setInt(int i, int i6);

    void setLong(int i, long j5);

    void setShort(int i, short s5);

    int writePosition();
}
