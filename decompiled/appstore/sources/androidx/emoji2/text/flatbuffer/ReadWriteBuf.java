package androidx.emoji2.text.flatbuffer;

/* JADX INFO: loaded from: classes.dex */
interface ReadWriteBuf extends ReadBuf {
    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    int limit();

    void put(byte r10);

    void put(byte[] r10, int r11, int r12);

    void putBoolean(boolean r10);

    void putDouble(double r10);

    void putFloat(float r10);

    void putInt(int r10);

    void putLong(long r10);

    void putShort(short r10);

    boolean requestCapacity(int r10);

    void set(int r10, byte r11);

    void set(int r10, byte[] r11, int r12, int r13);

    void setBoolean(int r10, boolean r11);

    void setDouble(int r10, double r11);

    void setFloat(int r10, float r11);

    void setInt(int r10, int r11);

    void setLong(int r10, long r11);

    void setShort(int r10, short r11);

    int writePosition();
}
