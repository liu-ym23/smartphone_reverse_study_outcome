package h4;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class x extends FilterInputStream {

    /* renamed from: f, reason: collision with root package name */
    public final ByteBuffer f4161f;

    /* renamed from: g, reason: collision with root package name */
    public final ByteBuffer f4162g;

    /* renamed from: h, reason: collision with root package name */
    public final int f4163h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4164i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4165j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4166k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4167l;

    /* renamed from: m, reason: collision with root package name */
    public final byte[] f4168m;

    /* renamed from: n, reason: collision with root package name */
    public int f4169n;

    /* renamed from: o, reason: collision with root package name */
    public final v f4170o;

    /* renamed from: p, reason: collision with root package name */
    public final int f4171p;

    /* renamed from: q, reason: collision with root package name */
    public final int f4172q;

    public x(q qVar, InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.f4170o = qVar.g();
        this.f4163h = qVar.e();
        this.f4168m = Arrays.copyOf(bArr, bArr.length);
        int iD = qVar.d();
        this.f4171p = iD;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iD + 1);
        this.f4161f = byteBufferAllocate;
        byteBufferAllocate.limit(0);
        this.f4172q = iD - qVar.c();
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(qVar.f() + 16);
        this.f4162g = byteBufferAllocate2;
        byteBufferAllocate2.limit(0);
        this.f4164i = false;
        this.f4165j = false;
        this.f4166k = false;
        this.f4169n = 0;
        this.f4167l = false;
    }

    public final void a() throws IOException {
        byte b10;
        while (!this.f4165j && this.f4161f.remaining() > 0) {
            int i2 = ((FilterInputStream) this).in.read(this.f4161f.array(), this.f4161f.position(), this.f4161f.remaining());
            if (i2 > 0) {
                ByteBuffer byteBuffer = this.f4161f;
                byteBuffer.position(byteBuffer.position() + i2);
            } else if (i2 == -1) {
                this.f4165j = true;
            } else if (i2 == 0) {
                throw new IOException("Could not read bytes from the ciphertext stream");
            }
        }
        if (this.f4165j) {
            b10 = 0;
        } else {
            ByteBuffer byteBuffer2 = this.f4161f;
            b10 = byteBuffer2.get(byteBuffer2.position() - 1);
            ByteBuffer byteBuffer3 = this.f4161f;
            byteBuffer3.position(byteBuffer3.position() - 1);
        }
        this.f4161f.flip();
        this.f4162g.clear();
        try {
            this.f4170o.q(this.f4161f, this.f4169n, this.f4165j, this.f4162g);
            this.f4169n++;
            this.f4162g.flip();
            this.f4161f.clear();
            if (this.f4165j) {
                return;
            }
            this.f4161f.clear();
            this.f4161f.limit(this.f4171p + 1);
            this.f4161f.put(b10);
        } catch (GeneralSecurityException e10) {
            this.f4167l = true;
            this.f4162g.limit(0);
            throw new IOException(e10.getMessage() + "\n" + toString() + "\nsegmentNr:" + this.f4169n + " endOfCiphertext:" + this.f4165j, e10);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        return this.f4162g.remaining();
    }

    public final void b() throws IOException {
        if (this.f4164i) {
            this.f4167l = true;
            this.f4162g.limit(0);
            throw new IOException("Decryption failed.");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.f4163h);
        while (byteBufferAllocate.remaining() > 0) {
            int i2 = ((FilterInputStream) this).in.read(byteBufferAllocate.array(), byteBufferAllocate.position(), byteBufferAllocate.remaining());
            if (i2 == -1) {
                this.f4167l = true;
                this.f4162g.limit(0);
                throw new IOException("Ciphertext is too short");
            }
            if (i2 == 0) {
                throw new IOException("Could not read bytes from the ciphertext stream");
            }
            byteBufferAllocate.position(byteBufferAllocate.position() + i2);
        }
        byteBufferAllocate.flip();
        try {
            this.f4170o.f(byteBufferAllocate, this.f4168m);
            this.f4164i = true;
        } catch (GeneralSecurityException e10) {
            throw new IOException(e10);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i2) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        byte[] bArr = new byte[1];
        int i2 = read(bArr, 0, 1);
        if (i2 == 1) {
            return bArr[0] & 255;
        }
        if (i2 == -1) {
            return i2;
        }
        throw new IOException("Reading failed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) {
        int i2;
        long j4 = this.f4171p;
        if (j2 <= 0) {
            return 0L;
        }
        int iMin = (int) Math.min(j4, j2);
        byte[] bArr = new byte[iMin];
        long j10 = j2;
        while (j10 > 0 && (i2 = read(bArr, 0, (int) Math.min(iMin, j10))) > 0) {
            j10 -= i2;
        }
        return j2 - j10;
    }

    public final synchronized String toString() {
        return "StreamingAeadDecryptingStream\nsegmentNr:" + this.f4169n + "\nciphertextSegmentSize:" + this.f4171p + "\nheaderRead:" + this.f4164i + "\nendOfCiphertext:" + this.f4165j + "\nendOfPlaintext:" + this.f4166k + "\ndecryptionErrorOccured:" + this.f4167l + "\nciphertextSgement position:" + this.f4161f.position() + " limit:" + this.f4161f.limit() + "\nplaintextSegment position:" + this.f4162g.position() + " limit:" + this.f4162g.limit();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i2, int i10) {
        try {
            if (!this.f4167l) {
                if (!this.f4164i) {
                    b();
                    this.f4161f.clear();
                    this.f4161f.limit(this.f4172q + 1);
                }
                if (this.f4166k) {
                    return -1;
                }
                int i11 = 0;
                while (true) {
                    if (i11 >= i10) {
                        break;
                    }
                    if (this.f4162g.remaining() == 0) {
                        if (this.f4165j) {
                            this.f4166k = true;
                            break;
                        }
                        a();
                    }
                    int iMin = Math.min(this.f4162g.remaining(), i10 - i11);
                    this.f4162g.get(bArr, i11 + i2, iMin);
                    i11 += iMin;
                }
                if (i11 == 0 && this.f4166k) {
                    return -1;
                }
                return i11;
            }
            throw new IOException("Decryption failed.");
        } catch (Throwable th) {
            throw th;
        }
    }
}
