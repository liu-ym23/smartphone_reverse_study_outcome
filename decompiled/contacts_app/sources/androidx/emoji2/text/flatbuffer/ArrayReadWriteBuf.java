package androidx.emoji2.text.flatbuffer;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ArrayReadWriteBuf implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf() {
        this(10);
    }

    public ArrayReadWriteBuf(int r1) {
        this(new byte[r1]);
    }

    public ArrayReadWriteBuf(byte[] r1) {
        this.buffer = r1;
        this.writePos = 0;
    }

    public ArrayReadWriteBuf(byte[] r1, int r2) {
        this.buffer = r1;
        this.writePos = r2;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int r1) {
        if (this.buffer[r1] == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int r1) {
        return this.buffer[r1];
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int r2) {
        byte[] r1 = this.buffer;
        int r0 = r1[r2 + 1] << 8;
        return (short) ((r1[r2] & 255) | r0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int r3) {
        byte[] r2 = this.buffer;
        int r0 = ((r2[r3 + 3] << Ascii.CAN) | ((r2[r3 + 2] & 255) << 16)) | ((r2[r3 + 1] & 255) << 8);
        return (r2[r3] & 255) | r0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int r8) {
        byte[] r7 = this.buffer;
        int r0 = r8 + 1;
        long r1 = ((long) r7[r8]) & 255;
        int r9 = r0 + 1;
        int r2 = r9 + 1;
        long r3 = (r1 | ((((long) r7[r0]) & 255) << 8)) | ((((long) r7[r9]) & 255) << 16);
        int r10 = r2 + 1;
        long r4 = r3 | ((((long) r7[r2]) & 255) << 24);
        int r5 = r10 + 1;
        long r6 = r4 | ((((long) r7[r10]) & 255) << 32);
        int r11 = r5 + 1;
        long r12 = r6 | ((((long) r7[r5]) & 255) << 40);
        int r13 = r11 + 1;
        long r14 = r12 | ((255 & ((long) r7[r11])) << 48);
        return (((long) r7[r13]) << 56) | r14;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int r1) {
        return Float.intBitsToFloat(getInt(r1));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int r1) {
        return Double.longBitsToDouble(getLong(r1));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int r1, int r2) {
        return Utf8Safe.decodeUtf8Array(this.buffer, r1, r2);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean r2) {
        setBoolean(this.writePos, r2);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] r2, int r3, int r4) {
        set(this.writePos, r2, r3, r4);
        this.writePos += r4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte r2) {
        set(this.writePos, r2);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short r2) {
        setShort(this.writePos, r2);
        this.writePos += 2;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int r2) {
        setInt(this.writePos, r2);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long r2) {
        setLong(this.writePos, r2);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float r2) {
        setFloat(this.writePos, r2);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double r2) {
        setDouble(this.writePos, r2);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int r1, boolean r2) {
        set(r1, r2 ? 1 : 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int r2, byte r3) {
        requestCapacity(r2 + 1);
        this.buffer[r2] = r3;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int r2, byte[] r3, int r4, int r5) {
        requestCapacity((r5 - r4) + r2);
        System.arraycopy(r3, r4, this.buffer, r2, r5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int r3, short r4) {
        requestCapacity(r3 + 2);
        byte[] r2 = this.buffer;
        r2[r3] = (byte) (r4 & 255);
        r2[r3 + 1] = (byte) ((r4 >> 8) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int r3, int r4) {
        requestCapacity(r3 + 4);
        byte[] r2 = this.buffer;
        int r0 = r3 + 1;
        r2[r3] = (byte) (r4 & 255);
        int r5 = r0 + 1;
        r2[r0] = (byte) ((r4 >> 8) & 255);
        r2[r5] = (byte) ((r4 >> 16) & 255);
        r2[r5 + 1] = (byte) ((r4 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int r4, long r5) {
        requestCapacity(r4 + 8);
        int r0 = (int) r5;
        byte[] r3 = this.buffer;
        int r1 = r4 + 1;
        r3[r4] = (byte) (r0 & 255);
        int r6 = r1 + 1;
        r3[r1] = (byte) ((r0 >> 8) & 255);
        int r2 = r6 + 1;
        r3[r6] = (byte) ((r0 >> 16) & 255);
        int r7 = r2 + 1;
        r3[r2] = (byte) ((r0 >> 24) & 255);
        int r8 = (int) (r5 >> 32);
        int r9 = r7 + 1;
        r3[r7] = (byte) (r8 & 255);
        int r10 = r9 + 1;
        r3[r9] = (byte) ((r8 >> 8) & 255);
        r3[r10] = (byte) ((r8 >> 16) & 255);
        r3[r10 + 1] = (byte) ((r8 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int r3, float r4) {
        requestCapacity(r3 + 4);
        int r5 = Float.floatToRawIntBits(r4);
        byte[] r2 = this.buffer;
        int r0 = r3 + 1;
        r2[r3] = (byte) (r5 & 255);
        int r6 = r0 + 1;
        r2[r0] = (byte) ((r5 >> 8) & 255);
        r2[r6] = (byte) ((r5 >> 16) & 255);
        r2[r6 + 1] = (byte) ((r5 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int r4, double r5) {
        requestCapacity(r4 + 8);
        long r6 = Double.doubleToRawLongBits(r5);
        int r0 = (int) r6;
        byte[] r3 = this.buffer;
        int r1 = r4 + 1;
        r3[r4] = (byte) (r0 & 255);
        int r7 = r1 + 1;
        r3[r1] = (byte) ((r0 >> 8) & 255);
        int r2 = r7 + 1;
        r3[r7] = (byte) ((r0 >> 16) & 255);
        int r8 = r2 + 1;
        r3[r2] = (byte) ((r0 >> 24) & 255);
        int r9 = (int) (r6 >> 32);
        int r10 = r8 + 1;
        r3[r8] = (byte) (r9 & 255);
        int r11 = r10 + 1;
        r3[r10] = (byte) ((r9 >> 8) & 255);
        r3[r11] = (byte) ((r9 >> 16) & 255);
        r3[r11 + 1] = (byte) ((r9 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.writePos;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.writePos;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int r4) {
        byte[] r0 = this.buffer;
        if (r0.length <= r4) goto L5;
        return true;
    L5:
        int r5 = r0.length;
        this.buffer = Arrays.copyOf(r0, r5 + (r5 >> 1));
        return true;
    }
}
