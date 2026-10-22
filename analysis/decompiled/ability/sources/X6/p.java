package X6;

import F9.B;
import F9.K;
import a7.AbstractC0307c;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class p extends K implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f1520a;
    public final B b;
    public final long c;
    public volatile long d = 0;

    public p(B b, InputStream inputStream, long j5) {
        AbstractC0307c.a(inputStream, "Content");
        this.f1520a = inputStream;
        this.b = b;
        this.c = j5;
        if (j5 < 0) {
            this.c = -1L;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        InputStream inputStream = this.f1520a;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // F9.K
    public final long contentLength() {
        return this.c;
    }

    @Override // F9.K
    public final B contentType() {
        return this.b;
    }

    @Override // F9.K
    public final void writeTo(V9.h hVar) throws IOException {
        InputStream inputStream;
        if (this.d > 0 && (inputStream = this.f1520a) != null && inputStream.markSupported()) {
            a7.f.e.debug("tos: okhttp writeTo call reset");
            this.f1520a.reset();
            this.d = 0L;
        }
        long j5 = this.c;
        if (j5 < 0) {
            byte[] bArr = new byte[8192];
            int i = this.f1520a.read(bArr);
            while (i != -1) {
                hVar.write(bArr, 0, i);
                this.d += i;
                i = this.f1520a.read(bArr);
            }
            return;
        }
        byte[] bArr2 = new byte[8192];
        while (j5 > 0) {
            int i6 = this.f1520a.read(bArr2, 0, ((long) 8192) < j5 ? 8192 : (int) j5);
            if (i6 == -1) {
                return;
            }
            hVar.write(bArr2, 0, i6);
            long j6 = i6;
            this.d += j6;
            j5 -= j6;
        }
    }
}
