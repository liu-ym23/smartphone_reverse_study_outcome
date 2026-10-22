package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes17.dex */
public class ByteBufferReadWriteBuf implements ReadWriteBuf {
    private final ByteBuffer buffer;

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer.array();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.buffer.limit();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.buffer.position();
    }

    public ByteBufferReadWriteBuf(ByteBuffer r100) {
        this.buffer = r100;
        r100.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int r100) {
        return this.buffer.get(r100);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int r100) {
        if (get(r100) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int r100) {
        return this.buffer.getDouble(r100);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int r100) {
        return this.buffer.getFloat(r100);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int r100) {
        return this.buffer.getInt(r100);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int r100) {
        return this.buffer.getLong(r100);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int r100) {
        return this.buffer.getShort(r100);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte r100) {
        this.buffer.put(r100);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean r100) {
        this.buffer.put(r100 ? 1 : 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double r100) {
        this.buffer.putDouble(r100);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float r100) {
        this.buffer.putFloat(r100);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int r100) {
        this.buffer.putInt(r100);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long r100) {
        this.buffer.putLong(r100);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short r100) {
        this.buffer.putShort(r100);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int r100) {
        if (r100 > this.buffer.limit()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int r100, int r101) {
        return Utf8Safe.decodeUtf8Buffer(this.buffer, r100, r101);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int r100, byte r101) {
        requestCapacity(r100 + 1);
        this.buffer.put(r100, r101);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int r100, boolean r101) {
        set(r100, r101 ? 1 : 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int r100, double r101) {
        requestCapacity(r100 + 8);
        this.buffer.putDouble(r100, r101);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int r100, float r101) {
        requestCapacity(r100 + 4);
        this.buffer.putFloat(r100, r101);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int r100, int r101) {
        requestCapacity(r100 + 4);
        this.buffer.putInt(r100, r101);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int r100, long r101) {
        requestCapacity(r100 + 8);
        this.buffer.putLong(r100, r101);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int r100, short r101) {
        requestCapacity(r100 + 2);
        this.buffer.putShort(r100, r101);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] r100, int r101, int r102) {
        this.buffer.put(r100, r101, r102);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int r100, byte[] r101, int r102, int r103) {
        requestCapacity((r103 - r102) + r100);
        int r104 = this.buffer.position();
        this.buffer.position(r100);
        this.buffer.put(r101, r102, r103);
        this.buffer.position(r104);
    }
}
