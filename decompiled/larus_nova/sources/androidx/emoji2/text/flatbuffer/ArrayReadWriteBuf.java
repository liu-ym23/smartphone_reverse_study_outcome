package androidx.emoji2.text.flatbuffer;

import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes17.dex */
public class ArrayReadWriteBuf implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf() {
        this(10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.writePos;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.writePos;
    }

    public ArrayReadWriteBuf(byte[] r100) {
        this.buffer = r100;
        this.writePos = 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int r100) {
        return this.buffer[r100];
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int r100) {
        if (this.buffer[r100] == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int r100) {
        return Double.longBitsToDouble(getLong(r100));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int r100) {
        return Float.intBitsToFloat(getInt(r100));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int r100) {
        byte[] r101 = this.buffer;
        int r102 = ((r101[r100 + 3] << 24) | ((r101[r100 + 2] & UByte.MAX_VALUE) << 16)) | ((r101[r100 + 1] & UByte.MAX_VALUE) << 8);
        return (r101[r100] & UByte.MAX_VALUE) | r102;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int r100) {
        byte[] r101 = this.buffer;
        int r102 = r100 + 1;
        long r103 = ((long) r101[r100]) & 255;
        int r104 = r102 + 1;
        int r105 = r104 + 1;
        long r106 = (r103 | ((((long) r101[r102]) & 255) << 8)) | ((((long) r101[r104]) & 255) << 16);
        int r107 = r105 + 1;
        long r108 = r106 | ((((long) r101[r105]) & 255) << 24);
        int r109 = r107 + 1;
        long r110 = r108 | ((((long) r101[r107]) & 255) << 32);
        int r111 = r109 + 1;
        long r112 = r110 | ((((long) r101[r109]) & 255) << 40);
        int r113 = r111 + 1;
        return (r112 | ((255 & ((long) r101[r111])) << 48)) | (((long) r101[r113]) << 56);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int r100) {
        byte[] r101 = this.buffer;
        int r102 = r101[r100 + 1] << 8;
        return (short) ((r101[r100] & UByte.MAX_VALUE) | r102);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte r100) {
        set(this.writePos, r100);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean r100) {
        setBoolean(this.writePos, r100);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double r100) {
        setDouble(this.writePos, r100);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float r100) {
        setFloat(this.writePos, r100);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int r100) {
        setInt(this.writePos, r100);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long r100) {
        setLong(this.writePos, r100);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short r100) {
        setShort(this.writePos, r100);
        this.writePos += 2;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int r100) {
        byte[] r101 = this.buffer;
        if (r101.length <= r100) goto L5;
        return true;
    L5:
        int r102 = r101.length;
        this.buffer = Arrays.copyOf(r101, r102 + (r102 >> 1));
        return true;
    }

    public ArrayReadWriteBuf(int r100) {
        this(new byte[r100]);
    }

    public ArrayReadWriteBuf(byte[] r100, int r101) {
        this.buffer = r100;
        this.writePos = r101;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int r100, int r101) {
        return Utf8Safe.decodeUtf8Array(this.buffer, r100, r101);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int r100, byte r101) {
        requestCapacity(r100 + 1);
        this.buffer[r100] = r101;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int r100, boolean r101) {
        set(r100, r101 ? 1 : 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int r100, double r101) {
        requestCapacity(r100 + 8);
        long r102 = Double.doubleToRawLongBits(r101);
        int r103 = (int) r102;
        byte[] r104 = this.buffer;
        int r105 = r100 + 1;
        r104[r100] = (byte) (r103 & 255);
        int r106 = r105 + 1;
        r104[r105] = (byte) ((r103 >> 8) & 255);
        int r107 = r106 + 1;
        r104[r106] = (byte) ((r103 >> 16) & 255);
        int r108 = r107 + 1;
        r104[r107] = (byte) ((r103 >> 24) & 255);
        int r109 = (int) (r102 >> 32);
        int r110 = r108 + 1;
        r104[r108] = (byte) (r109 & 255);
        int r111 = r110 + 1;
        r104[r110] = (byte) ((r109 >> 8) & 255);
        r104[r111] = (byte) ((r109 >> 16) & 255);
        r104[r111 + 1] = (byte) ((r109 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int r100, float r101) {
        requestCapacity(r100 + 4);
        int r102 = Float.floatToRawIntBits(r101);
        byte[] r103 = this.buffer;
        int r104 = r100 + 1;
        r103[r100] = (byte) (r102 & 255);
        int r105 = r104 + 1;
        r103[r104] = (byte) ((r102 >> 8) & 255);
        r103[r105] = (byte) ((r102 >> 16) & 255);
        r103[r105 + 1] = (byte) ((r102 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int r100, int r101) {
        requestCapacity(r100 + 4);
        byte[] r102 = this.buffer;
        int r103 = r100 + 1;
        r102[r100] = (byte) (r101 & 255);
        int r104 = r103 + 1;
        r102[r103] = (byte) ((r101 >> 8) & 255);
        r102[r104] = (byte) ((r101 >> 16) & 255);
        r102[r104 + 1] = (byte) ((r101 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int r100, long r101) {
        requestCapacity(r100 + 8);
        int r102 = (int) r101;
        byte[] r103 = this.buffer;
        int r104 = r100 + 1;
        r103[r100] = (byte) (r102 & 255);
        int r105 = r104 + 1;
        r103[r104] = (byte) ((r102 >> 8) & 255);
        int r106 = r105 + 1;
        r103[r105] = (byte) ((r102 >> 16) & 255);
        int r107 = r106 + 1;
        r103[r106] = (byte) ((r102 >> 24) & 255);
        int r108 = (int) (r101 >> 32);
        int r109 = r107 + 1;
        r103[r107] = (byte) (r108 & 255);
        int r110 = r109 + 1;
        r103[r109] = (byte) ((r108 >> 8) & 255);
        r103[r110] = (byte) ((r108 >> 16) & 255);
        r103[r110 + 1] = (byte) ((r108 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int r100, short r101) {
        requestCapacity(r100 + 2);
        byte[] r102 = this.buffer;
        r102[r100] = (byte) (r101 & 255);
        r102[r100 + 1] = (byte) ((r101 >> 8) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] r100, int r101, int r102) {
        set(this.writePos, r100, r101, r102);
        this.writePos += r102;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int r100, byte[] r101, int r102, int r103) {
        requestCapacity((r103 - r102) + r100);
        System.arraycopy(r101, r102, this.buffer, r100, r103);
    }
}
