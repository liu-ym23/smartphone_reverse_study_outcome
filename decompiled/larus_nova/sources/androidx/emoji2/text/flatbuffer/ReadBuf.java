package androidx.emoji2.text.flatbuffer;

/* JADX INFO: loaded from: classes17.dex */
interface ReadBuf {
    byte[] data();

    byte get(int r100);

    boolean getBoolean(int r100);

    double getDouble(int r100);

    float getFloat(int r100);

    int getInt(int r100);

    long getLong(int r100);

    short getShort(int r100);

    String getString(int r100, int r101);

    int limit();
}
