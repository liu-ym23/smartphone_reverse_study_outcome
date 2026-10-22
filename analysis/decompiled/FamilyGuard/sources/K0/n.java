package K0;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class n extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private volatile byte[] f3554a;

    /* renamed from: b, reason: collision with root package name */
    private int f3555b;

    /* renamed from: c, reason: collision with root package name */
    private int f3556c;

    /* renamed from: d, reason: collision with root package name */
    private int f3557d;

    /* renamed from: e, reason: collision with root package name */
    private int f3558e;

    /* renamed from: f, reason: collision with root package name */
    private final D0.b f3559f;

    static class a extends IOException {
        a(String str) {
            super(str);
        }
    }

    public n(InputStream inputStream, D0.b bVar) {
        this(inputStream, bVar, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i5 = this.f3557d;
        if (i5 != -1) {
            int i6 = this.f3558e - i5;
            int i7 = this.f3556c;
            if (i6 < i7) {
                if (i5 == 0 && i7 > bArr.length && this.f3555b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i7) {
                        i7 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f3559f.d(i7, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f3554a = bArr2;
                    this.f3559f.put(bArr);
                    bArr = bArr2;
                } else if (i5 > 0) {
                    System.arraycopy(bArr, i5, bArr, 0, bArr.length - i5);
                }
                int i8 = this.f3558e - this.f3557d;
                this.f3558e = i8;
                this.f3557d = 0;
                this.f3555b = 0;
                int i9 = inputStream.read(bArr, i8, bArr.length - i8);
                int i10 = this.f3558e;
                if (i9 > 0) {
                    i10 += i9;
                }
                this.f3555b = i10;
                return i9;
            }
        }
        int i11 = inputStream.read(bArr);
        if (i11 > 0) {
            this.f3557d = -1;
            this.f3558e = 0;
            this.f3555b = i11;
        }
        return i11;
    }

    private static IOException m() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f3554a == null || inputStream == null) {
            throw m();
        }
        return (this.f3555b - this.f3558e) + inputStream.available();
    }

    public synchronized void c() {
        this.f3556c = this.f3554a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f3554a != null) {
            this.f3559f.put(this.f3554a);
            this.f3554a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void f() {
        if (this.f3554a != null) {
            this.f3559f.put(this.f3554a);
            this.f3554a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i5) {
        this.f3556c = Math.max(this.f3556c, i5);
        this.f3557d = this.f3558e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f3554a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw m();
        }
        if (this.f3558e >= this.f3555b && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f3554a && (bArr = this.f3554a) == null) {
            throw m();
        }
        int i5 = this.f3555b;
        int i6 = this.f3558e;
        if (i5 - i6 <= 0) {
            return -1;
        }
        this.f3558e = i6 + 1;
        return bArr[i6] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.f3554a == null) {
            throw new IOException("Stream is closed");
        }
        int i5 = this.f3557d;
        if (-1 == i5) {
            throw new a("Mark has been invalidated, pos: " + this.f3558e + " markLimit: " + this.f3556c);
        }
        this.f3558e = i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j5) {
        if (j5 < 1) {
            return 0L;
        }
        byte[] bArr = this.f3554a;
        if (bArr == null) {
            throw m();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw m();
        }
        int i5 = this.f3555b;
        int i6 = this.f3558e;
        if (i5 - i6 >= j5) {
            this.f3558e = (int) (i6 + j5);
            return j5;
        }
        long j6 = i5 - i6;
        this.f3558e = i5;
        if (this.f3557d == -1 || j5 > this.f3556c) {
            return j6 + inputStream.skip(j5 - j6);
        }
        if (a(inputStream, bArr) == -1) {
            return j6;
        }
        int i7 = this.f3555b;
        int i8 = this.f3558e;
        if (i7 - i8 >= j5 - j6) {
            this.f3558e = (int) ((i8 + j5) - j6);
            return j5;
        }
        long j7 = (j6 + i7) - i8;
        this.f3558e = i7;
        return j7;
    }

    n(InputStream inputStream, D0.b bVar, int i5) {
        super(inputStream);
        this.f3557d = -1;
        this.f3559f = bVar;
        this.f3554a = (byte[]) bVar.d(i5, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i5, int i6) {
        int i7;
        int i8;
        byte[] bArr2 = this.f3554a;
        if (bArr2 == null) {
            throw m();
        }
        if (i6 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i9 = this.f3558e;
            int i10 = this.f3555b;
            if (i9 < i10) {
                int i11 = i10 - i9 >= i6 ? i6 : i10 - i9;
                System.arraycopy(bArr2, i9, bArr, i5, i11);
                this.f3558e += i11;
                if (i11 == i6 || inputStream.available() == 0) {
                    return i11;
                }
                i5 += i11;
                i7 = i6 - i11;
            } else {
                i7 = i6;
            }
            while (true) {
                if (this.f3557d == -1 && i7 >= bArr2.length) {
                    i8 = inputStream.read(bArr, i5, i7);
                    if (i8 == -1) {
                        return i7 != i6 ? i6 - i7 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i7 != i6 ? i6 - i7 : -1;
                    }
                    if (bArr2 != this.f3554a && (bArr2 = this.f3554a) == null) {
                        throw m();
                    }
                    int i12 = this.f3555b;
                    int i13 = this.f3558e;
                    i8 = i12 - i13 >= i7 ? i7 : i12 - i13;
                    System.arraycopy(bArr2, i13, bArr, i5, i8);
                    this.f3558e += i8;
                }
                i7 -= i8;
                if (i7 == 0) {
                    return i6;
                }
                if (inputStream.available() == 0) {
                    return i6 - i7;
                }
                i5 += i8;
            }
        } else {
            throw m();
        }
    }
}
