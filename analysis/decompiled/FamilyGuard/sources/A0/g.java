package A0;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class g extends FilterInputStream {

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f10c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f11d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f12e;

    /* renamed from: a, reason: collision with root package name */
    private final byte f13a;

    /* renamed from: b, reason: collision with root package name */
    private int f14b;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f10c = bArr;
        int length = bArr.length;
        f11d = length;
        f12e = length + 2;
    }

    public g(InputStream inputStream, int i5) {
        super(inputStream);
        if (i5 >= -1 && i5 <= 8) {
            this.f13a = (byte) i5;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i5);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int i5;
        int i6 = this.f14b;
        int i7 = (i6 < 2 || i6 > (i5 = f12e)) ? super.read() : i6 == i5 ? this.f13a : f10c[i6 - 2] & 255;
        if (i7 != -1) {
            this.f14b++;
        }
        return i7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j5) throws IOException {
        long jSkip = super.skip(j5);
        if (jSkip > 0) {
            this.f14b = (int) (this.f14b + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        int i7;
        int i8 = this.f14b;
        int i9 = f12e;
        if (i8 > i9) {
            i7 = super.read(bArr, i5, i6);
        } else if (i8 == i9) {
            bArr[i5] = this.f13a;
            i7 = 1;
        } else if (i8 < 2) {
            i7 = super.read(bArr, i5, 2 - i8);
        } else {
            int iMin = Math.min(i9 - i8, i6);
            System.arraycopy(f10c, this.f14b - 2, bArr, i5, iMin);
            i7 = iMin;
        }
        if (i7 > 0) {
            this.f14b += i7;
        }
        return i7;
    }
}
