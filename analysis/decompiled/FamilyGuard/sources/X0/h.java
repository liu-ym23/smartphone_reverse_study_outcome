package X0;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class h extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private int f5795a;

    public h(InputStream inputStream) {
        super(inputStream);
        this.f5795a = Integer.MIN_VALUE;
    }

    private long a(long j5) {
        int i5 = this.f5795a;
        if (i5 == 0) {
            return -1L;
        }
        return (i5 == Integer.MIN_VALUE || j5 <= ((long) i5)) ? j5 : i5;
    }

    private void c(long j5) {
        int i5 = this.f5795a;
        if (i5 == Integer.MIN_VALUE || j5 == -1) {
            return;
        }
        this.f5795a = (int) (i5 - j5);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i5 = this.f5795a;
        return i5 == Integer.MIN_VALUE ? super.available() : Math.min(i5, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i5) {
        super.mark(i5);
        this.f5795a = i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int i5 = super.read();
        c(1L);
        return i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.f5795a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j5) throws IOException {
        long jA = a(j5);
        if (jA == -1) {
            return 0L;
        }
        long jSkip = super.skip(jA);
        c(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        int iA = (int) a(i6);
        if (iA == -1) {
            return -1;
        }
        int i7 = super.read(bArr, i5, iA);
        c(i7);
        return i7;
    }
}
