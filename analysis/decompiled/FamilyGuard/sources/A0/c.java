package A0;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class c extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final OutputStream f3a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f4b;

    /* renamed from: c, reason: collision with root package name */
    private D0.b f5c;

    /* renamed from: d, reason: collision with root package name */
    private int f6d;

    public c(OutputStream outputStream, D0.b bVar) {
        this(outputStream, bVar, 65536);
    }

    private void a() throws IOException {
        int i5 = this.f6d;
        if (i5 > 0) {
            this.f3a.write(this.f4b, 0, i5);
            this.f6d = 0;
        }
    }

    private void c() throws IOException {
        if (this.f6d == this.f4b.length) {
            a();
        }
    }

    private void f() {
        byte[] bArr = this.f4b;
        if (bArr != null) {
            this.f5c.put(bArr);
            this.f4b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f3a.close();
            f();
        } catch (Throwable th) {
            this.f3a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f3a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i5) throws IOException {
        byte[] bArr = this.f4b;
        int i6 = this.f6d;
        this.f6d = i6 + 1;
        bArr[i6] = (byte) i5;
        c();
    }

    c(OutputStream outputStream, D0.b bVar, int i5) {
        this.f3a = outputStream;
        this.f5c = bVar;
        this.f4b = (byte[]) bVar.d(i5, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) throws IOException {
        int i7 = 0;
        do {
            int i8 = i6 - i7;
            int i9 = i5 + i7;
            int i10 = this.f6d;
            if (i10 == 0 && i8 >= this.f4b.length) {
                this.f3a.write(bArr, i9, i8);
                return;
            }
            int iMin = Math.min(i8, this.f4b.length - i10);
            System.arraycopy(bArr, i9, this.f4b, this.f6d, iMin);
            this.f6d += iMin;
            i7 += iMin;
            c();
        } while (i7 < i6);
    }
}
