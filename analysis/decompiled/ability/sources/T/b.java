package T;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class b extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final OutputStream f1193a;
    public long b = 0;
    public final C4.a c = new C4.a();

    public b(OutputStream outputStream) {
        this.f1193a = outputStream;
    }

    public final void b(IOException iOException) {
        C4.a aVar = this.c;
        if (aVar.g()) {
            return;
        }
        aVar.e(new cc.dd.dd.cc.dd.dd.c(this, this.b, iOException));
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        C4.a aVar = this.c;
        try {
            this.f1193a.close();
            if (aVar.g()) {
                return;
            }
            aVar.a(new cc.dd.dd.cc.dd.dd.c(this, this.b, null));
        } catch (IOException e) {
            b(e);
            throw e;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        try {
            this.f1193a.flush();
        } catch (IOException e) {
            b(e);
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        try {
            this.f1193a.write(i);
            this.b++;
        } catch (IOException e) {
            b(e);
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        try {
            this.f1193a.write(bArr);
            this.b += bArr.length;
        } catch (IOException e) {
            b(e);
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i6) throws IOException {
        try {
            this.f1193a.write(bArr, i, i6);
            this.b += i6;
        } catch (IOException e) {
            b(e);
            throw e;
        }
    }
}
