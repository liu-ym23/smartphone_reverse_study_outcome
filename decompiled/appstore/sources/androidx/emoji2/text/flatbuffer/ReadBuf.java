package androidx.emoji2.text.flatbuffer;

/* JADX INFO: loaded from: classes.dex */
interface ReadBuf {
    byte[] data();

    byte get(int r10);

    boolean getBoolean(int r10);

    double getDouble(int r10);

    float getFloat(int r10);

    int getInt(int r10);

    long getLong(int r10);

    short getShort(int r10);

    String getString(int r10, int r11);

    int limit();
}
