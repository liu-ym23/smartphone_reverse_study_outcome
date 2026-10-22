package T;

import h2.d;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class a extends InputStream {
    public static final d f = W.a.f1470a;

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f1192a;
    public long b;
    public final C4.a c;
    public final ByteBuffer d;
    public final boolean e;

    public a(InputStream inputStream) {
        this.b = 0L;
        this.c = new C4.a();
        this.e = false;
        this.f1192a = inputStream;
        this.d = null;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        try {
            return (this.e ? this.d.remaining() : 0) + this.f1192a.available();
        } catch (IOException e) {
            this.c(e);
            throw e;
        }
    }

    public final int b(byte[] bArr, int i, int i6) {
        ByteBuffer byteBuffer = this.d;
        if (!byteBuffer.hasRemaining()) {
            return -1;
        }
        int iRemaining = byteBuffer.remaining();
        byteBuffer.get(bArr, i, i6);
        return iRemaining - byteBuffer.remaining();
    }

    public final void c(IOException iOException) {
        C4.a aVar = this.c;
        if (aVar.g()) {
            return;
        }
        aVar.e(new cc.dd.dd.cc.dd.dd.c(this, this.b, iOException));
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        try {
            this.f1192a.close();
            g();
        } catch (IOException e) {
            c(e);
            throw e;
        }
    }

    public final boolean f(long j5) {
        return ((long) this.d.remaining()) >= j5;
    }

    public final void g() {
        C4.a aVar = this.c;
        if (aVar.g()) {
            return;
        }
        aVar.a(new cc.dd.dd.cc.dd.dd.c(this, this.b, null));
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        InputStream inputStream = this.f1192a;
        if (inputStream.markSupported()) {
            inputStream.mark(i);
        }
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f1192a.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.e) {
            synchronized (this.d) {
                try {
                    if (f(1L)) {
                        byte b = !this.d.hasRemaining() ? (byte) -1 : this.d.get();
                        if (b >= 0) {
                            this.b++;
                        }
                        return b;
                    }
                } finally {
                }
            }
        }
        try {
            int i = this.f1192a.read();
            if (i >= 0) {
                this.b++;
                return i;
            }
            g();
            return i;
        } catch (IOException e) {
            c(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final void reset() throws IOException {
        InputStream inputStream = this.f1192a;
        if (inputStream.markSupported()) {
            try {
                inputStream.reset();
            } catch (IOException e) {
                c(e);
                throw e;
            }
        }
    }

    @Override // java.io.InputStream
    public final long skip(long j5) throws IOException {
        if (this.e) {
            synchronized (this.d) {
                try {
                    if (f(j5)) {
                        this.d.position((int) j5);
                        this.b += j5;
                        return j5;
                    }
                    j5 -= this.d.remaining();
                    if (j5 <= 0) {
                        throw new IOException("partial read from buffer (skip) failed");
                    }
                    ByteBuffer byteBuffer = this.d;
                    byteBuffer.position(byteBuffer.remaining());
                } finally {
                }
            }
        }
        try {
            long jSkip = this.f1192a.skip(j5);
            this.b += jSkip;
            return jSkip;
        } catch (IOException e) {
            c(e);
            throw e;
        }
    }

    public a(InputStream inputStream, int i) {
        int i6;
        this.b = 0L;
        this.c = new C4.a();
        this.f1192a = inputStream;
        this.e = true;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(2048);
        this.d = byteBufferAllocate;
        if (byteBufferAllocate == null || !byteBufferAllocate.hasArray()) {
            return;
        }
        synchronized (byteBufferAllocate) {
            try {
                i6 = inputStream.read(byteBufferAllocate.array(), 0, byteBufferAllocate.capacity());
            } catch (IOException e) {
                d dVar = f;
                e.toString();
                dVar.t();
                i6 = 0;
            }
            if (i6 <= 0) {
                this.d.limit(0);
            } else if (i6 < this.d.capacity()) {
                this.d.limit(i6);
            }
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        int length = bArr.length;
        int iB = 0;
        if (this.e) {
            synchronized (this.d) {
                try {
                    if (f(length)) {
                        int iB2 = b(bArr, 0, bArr.length);
                        if (iB2 >= 0) {
                            this.b += iB2;
                            return iB2;
                        }
                        throw new IOException("readBufferBytes failed");
                    }
                    int iRemaining = this.d.remaining();
                    if (iRemaining > 0) {
                        iB = b(bArr, 0, iRemaining);
                        if (iB >= 0) {
                            length -= iB;
                            this.b += iB;
                        } else {
                            throw new IOException("partial read from buffer failed");
                        }
                    }
                } finally {
                }
            }
        }
        try {
            int i = this.f1192a.read(bArr, iB, length);
            if (i >= 0) {
                this.b += i;
                return i + iB;
            }
            if (iB > 0) {
                return iB;
            }
            g();
            return i;
        } catch (IOException e) {
            d dVar = f;
            e.toString();
            dVar.t();
            System.out.println("NOTIFY STREAM ERROR: " + e);
            e.printStackTrace();
            c(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i6) throws IOException {
        int iB = 0;
        if (this.e) {
            synchronized (this.d) {
                try {
                    if (f(i6)) {
                        int iB2 = b(bArr, i, i6);
                        if (iB2 >= 0) {
                            this.b += iB2;
                            return iB2;
                        }
                        throw new IOException("readBufferBytes failed");
                    }
                    int iRemaining = this.d.remaining();
                    if (iRemaining > 0) {
                        iB = b(bArr, i, iRemaining);
                        if (iB >= 0) {
                            i6 -= iB;
                            this.b += iB;
                        } else {
                            throw new IOException("partial read from buffer failed");
                        }
                    }
                } finally {
                }
            }
        }
        try {
            int i10 = this.f1192a.read(bArr, i + iB, i6);
            if (i10 >= 0) {
                this.b += i10;
                return i10 + iB;
            }
            if (iB > 0) {
                return iB;
            }
            g();
            return i10;
        } catch (IOException e) {
            c(e);
            throw e;
        }
    }
}
