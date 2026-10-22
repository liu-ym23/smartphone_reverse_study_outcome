package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferReadWriteBuf implements ReadWriteBuf {
    private final ByteBuffer buffer;

    public ByteBufferReadWriteBuf(ByteBuffer r1) {
        this.buffer = r1;
        r1.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int r1) {
        if (get(r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int r1) {
        return this.buffer.get(r1);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int r1) {
        return this.buffer.getShort(r1);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int r1) {
        return this.buffer.getInt(r1);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int r1) {
        return this.buffer.getLong(r1);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int r1) {
        return this.buffer.getFloat(r1);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int r1) {
        return this.buffer.getDouble(r1);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int r1, int r2) {
        return Utf8Safe.decodeUtf8Buffer(this.buffer, r1, r2);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer.array();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean r1) {
        this.buffer.put(r1 ? 1 : 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] r1, int r2, int r3) {
        this.buffer.put(r1, r2, r3);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte r1) {
        this.buffer.put(r1);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short r1) {
        this.buffer.putShort(r1);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int r1) {
        this.buffer.putInt(r1);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long r1) {
        this.buffer.putLong(r1);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float r1) {
        this.buffer.putFloat(r1);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double r1) {
        this.buffer.putDouble(r1);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int r1, boolean r2) {
        set(r1, r2 ? 1 : 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int r2, byte r3) {
        requestCapacity(r2 + 1);
        this.buffer.put(r2, r3);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int r3, byte[] r4, int r5, int r6) {
        requestCapacity((r6 - r5) + r3);
        int r0 = this.buffer.position();
        this.buffer.position(r3);
        this.buffer.put(r4, r5, r6);
        this.buffer.position(r0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int r2, short r3) {
        requestCapacity(r2 + 2);
        this.buffer.putShort(r2, r3);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int r2, int r3) {
        requestCapacity(r2 + 4);
        this.buffer.putInt(r2, r3);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int r2, long r3) {
        requestCapacity(r2 + 8);
        this.buffer.putLong(r2, r3);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int r2, float r3) {
        requestCapacity(r2 + 4);
        this.buffer.putFloat(r2, r3);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int r2, double r3) {
        requestCapacity(r2 + 8);
        this.buffer.putDouble(r2, r3);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.buffer.position();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.buffer.limit();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int r1) {
        if (r1 > this.buffer.limit()) goto L5;
        return true;
    L5:
        return false;
    }
}
