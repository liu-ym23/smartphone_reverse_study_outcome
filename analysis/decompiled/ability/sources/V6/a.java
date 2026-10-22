package V6;

import com.volcengine.tos.TosClientException;
import com.volcengine.tos.model.object.TosObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class a extends TosObjectInputStream {

    /* renamed from: a, reason: collision with root package name */
    public final b f1386a;
    public final long b;
    public long c;
    public long d;

    public a(FileInputStream fileInputStream, long j5) {
        super(fileInputStream);
        this.d = -1L;
        this.f1386a = new b(fileInputStream, 0);
        if (j5 < 0) {
            throw new TosClientException("TosRepeatableBoundedFileInputStream input size is invalid, please make it not less than 0", null);
        }
        this.b = j5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        long j5 = this.b;
        if (j5 < 0 || this.c < j5) {
            return this.f1386a.b.available();
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f1386a.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        this.f1386a.mark(i);
        this.d = this.c;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        this.f1386a.reset();
        this.c = this.d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j5) throws IOException {
        long j6 = this.b;
        if (j6 >= 0) {
            j5 = Math.min(j5, j6 - this.c);
        }
        long jSkip = this.f1386a.b.skip(j5);
        this.c += jSkip;
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        long j5 = this.b;
        if (j5 >= 0 && this.c >= j5) {
            return -1;
        }
        int i = this.f1386a.b.read();
        this.c++;
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i6) throws IOException {
        long j5 = this.b;
        if (j5 >= 0 && this.c >= j5) {
            return -1;
        }
        if (j5 >= 0) {
            i6 = Math.min(i6, (int) (j5 - this.c));
        }
        int i10 = this.f1386a.b.read(bArr, i, i6);
        if (i10 > -1) {
            this.c += i10;
        }
        return i10;
    }
}
