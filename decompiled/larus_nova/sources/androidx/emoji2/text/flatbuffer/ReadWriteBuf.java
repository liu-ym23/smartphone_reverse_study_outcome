package androidx.emoji2.text.flatbuffer;

/* JADX INFO: loaded from: classes17.dex */
interface ReadWriteBuf extends ReadBuf {
    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    int limit();

    void put(byte r100);

    void put(byte[] r100, int r101, int r102);

    void putBoolean(boolean r100);

    void putDouble(double r100);

    void putFloat(float r100);

    void putInt(int r100);

    void putLong(long r100);

    void putShort(short r100);

    boolean requestCapacity(int r100);

    void set(int r100, byte r101);

    void set(int r100, byte[] r101, int r102, int r103);

    void setBoolean(int r100, boolean r101);

    void setDouble(int r100, double r101);

    void setFloat(int r100, float r101);

    void setInt(int r100, int r101);

    void setLong(int r100, long r101);

    void setShort(int r100, short r101);

    int writePosition();
}
