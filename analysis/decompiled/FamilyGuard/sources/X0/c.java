package X0;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class c extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private final long f5782a;

    /* renamed from: b, reason: collision with root package name */
    private int f5783b;

    private c(InputStream inputStream, long j5) {
        super(inputStream);
        this.f5782a = j5;
    }

    private int a(int i5) throws IOException {
        if (i5 >= 0) {
            this.f5783b += i5;
            return i5;
        }
        if (this.f5782a - this.f5783b <= 0) {
            return i5;
        }
        throw new IOException("Failed to read all expected data, expected: " + this.f5782a + ", but read: " + this.f5783b);
    }

    public static InputStream c(InputStream inputStream, long j5) {
        return new c(inputStream, j5);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.f5782a - this.f5783b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int i5;
        i5 = super.read();
        a(i5 >= 0 ? 1 : -1);
        return i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i5, int i6) {
        return a(super.read(bArr, i5, i6));
    }
}
