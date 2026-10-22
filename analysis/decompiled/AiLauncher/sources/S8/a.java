package S8;

import io.objectbox.flatbuffers.Utf8Safe;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f5650a;

    /* renamed from: b, reason: collision with root package name */
    public int f5651b;

    public a(int i10) {
        this(new byte[i10]);
    }

    @Override // S8.c
    public int a() {
        return this.f5651b;
    }

    @Override // S8.d
    public void b(double d10) {
        o(this.f5651b, d10);
        this.f5651b += 8;
    }

    @Override // S8.c
    public byte[] c() {
        return this.f5650a;
    }

    @Override // S8.d
    public void clear() {
        this.f5651b = 0;
    }

    @Override // S8.c
    public String d(int i10, int i11) {
        return Utf8Safe.e(this.f5650a, i10, i11);
    }

    @Override // S8.d
    public int e() {
        return this.f5651b;
    }

    @Override // S8.d
    public void f(float f10) {
        p(this.f5651b, f10);
        this.f5651b += 4;
    }

    @Override // S8.d
    public void g(byte b10) {
        m(this.f5651b, b10);
        this.f5651b++;
    }

    @Override // S8.c
    public byte get(int i10) {
        return this.f5650a[i10];
    }

    @Override // S8.c
    public double getDouble(int i10) {
        return Double.longBitsToDouble(getLong(i10));
    }

    @Override // S8.c
    public float getFloat(int i10) {
        return Float.intBitsToFloat(getInt(i10));
    }

    @Override // S8.c
    public int getInt(int i10) {
        byte[] bArr = this.f5650a;
        return (bArr[i10] & 255) | (bArr[i10 + 3] << 24) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 1] & 255) << 8);
    }

    @Override // S8.c
    public long getLong(int i10) {
        byte[] bArr = this.f5650a;
        return (bArr[i10 + 7] << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
    }

    @Override // S8.c
    public short getShort(int i10) {
        byte[] bArr = this.f5650a;
        return (short) ((bArr[i10] & 255) | (bArr[i10 + 1] << 8));
    }

    @Override // S8.d
    public void h(short s10) {
        s(this.f5651b, s10);
        this.f5651b += 2;
    }

    @Override // S8.d
    public void i(int i10) {
        q(this.f5651b, i10);
        this.f5651b += 4;
    }

    @Override // S8.d
    public void j(byte[] bArr, int i10, int i11) {
        n(this.f5651b, bArr, i10, i11);
        this.f5651b += i11;
    }

    @Override // S8.d
    public void k(long j10) {
        r(this.f5651b, j10);
        this.f5651b += 8;
    }

    public boolean l(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Capacity may not be negative (likely a previous int overflow)");
        }
        byte[] bArr = this.f5650a;
        if (bArr.length >= i10) {
            return true;
        }
        int length = bArr.length;
        int i11 = length + (length >> 1);
        if (i11 >= i10) {
            i10 = i11;
        }
        this.f5650a = Arrays.copyOf(bArr, i10);
        return true;
    }

    public void m(int i10, byte b10) {
        l(i10 + 1);
        this.f5650a[i10] = b10;
    }

    public void n(int i10, byte[] bArr, int i11, int i12) {
        l((i12 - i11) + i10);
        System.arraycopy(bArr, i11, this.f5650a, i10, i12);
    }

    public void o(int i10, double d10) {
        l(i10 + 8);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d10);
        int i11 = (int) jDoubleToRawLongBits;
        byte[] bArr = this.f5650a;
        bArr[i10] = (byte) (i11 & 255);
        bArr[i10 + 1] = (byte) ((i11 >> 8) & 255);
        bArr[i10 + 2] = (byte) ((i11 >> 16) & 255);
        bArr[i10 + 3] = (byte) ((i11 >> 24) & 255);
        int i12 = (int) (jDoubleToRawLongBits >> 32);
        bArr[i10 + 4] = (byte) (i12 & 255);
        bArr[i10 + 5] = (byte) ((i12 >> 8) & 255);
        bArr[i10 + 6] = (byte) ((i12 >> 16) & 255);
        bArr[i10 + 7] = (byte) ((i12 >> 24) & 255);
    }

    public void p(int i10, float f10) {
        l(i10 + 4);
        int iFloatToRawIntBits = Float.floatToRawIntBits(f10);
        byte[] bArr = this.f5650a;
        bArr[i10] = (byte) (iFloatToRawIntBits & 255);
        bArr[i10 + 1] = (byte) ((iFloatToRawIntBits >> 8) & 255);
        bArr[i10 + 2] = (byte) ((iFloatToRawIntBits >> 16) & 255);
        bArr[i10 + 3] = (byte) ((iFloatToRawIntBits >> 24) & 255);
    }

    public void q(int i10, int i11) {
        l(i10 + 4);
        byte[] bArr = this.f5650a;
        bArr[i10] = (byte) (i11 & 255);
        bArr[i10 + 1] = (byte) ((i11 >> 8) & 255);
        bArr[i10 + 2] = (byte) ((i11 >> 16) & 255);
        bArr[i10 + 3] = (byte) ((i11 >> 24) & 255);
    }

    public void r(int i10, long j10) {
        l(i10 + 8);
        int i11 = (int) j10;
        byte[] bArr = this.f5650a;
        bArr[i10] = (byte) (i11 & 255);
        bArr[i10 + 1] = (byte) ((i11 >> 8) & 255);
        bArr[i10 + 2] = (byte) ((i11 >> 16) & 255);
        bArr[i10 + 3] = (byte) ((i11 >> 24) & 255);
        int i12 = (int) (j10 >> 32);
        bArr[i10 + 4] = (byte) (i12 & 255);
        bArr[i10 + 5] = (byte) ((i12 >> 8) & 255);
        bArr[i10 + 6] = (byte) ((i12 >> 16) & 255);
        bArr[i10 + 7] = (byte) ((i12 >> 24) & 255);
    }

    public void s(int i10, short s10) {
        l(i10 + 2);
        byte[] bArr = this.f5650a;
        bArr[i10] = (byte) (s10 & 255);
        bArr[i10 + 1] = (byte) ((s10 >> 8) & 255);
    }

    public a(byte[] bArr) {
        this.f5650a = bArr;
        this.f5651b = 0;
    }

    public a(byte[] bArr, int i10) {
        this.f5650a = bArr;
        this.f5651b = i10;
    }
}
