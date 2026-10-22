package h4;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class y extends FilterOutputStream {

    /* renamed from: f, reason: collision with root package name */
    public final w f4173f;

    /* renamed from: g, reason: collision with root package name */
    public final int f4174g;

    /* renamed from: h, reason: collision with root package name */
    public final ByteBuffer f4175h;

    /* renamed from: i, reason: collision with root package name */
    public final ByteBuffer f4176i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4177j;

    public y(q qVar, FileOutputStream fileOutputStream, byte[] bArr) throws IOException {
        super(fileOutputStream);
        w wVarH = qVar.h(bArr);
        this.f4173f = wVarH;
        int iF = qVar.f();
        this.f4174g = iF;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iF);
        this.f4175h = byteBufferAllocate;
        this.f4176i = ByteBuffer.allocate(qVar.d());
        byteBufferAllocate.limit(iF - qVar.c());
        ByteBuffer byteBufferH = wVarH.h();
        byte[] bArr2 = new byte[byteBufferH.remaining()];
        byteBufferH.get(bArr2);
        ((FilterOutputStream) this).out.write(bArr2);
        this.f4177j = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.f4177j) {
            try {
                this.f4175h.flip();
                this.f4176i.clear();
                this.f4173f.j(this.f4175h, this.f4176i);
                this.f4176i.flip();
                ((FilterOutputStream) this).out.write(this.f4176i.array(), this.f4176i.position(), this.f4176i.remaining());
                this.f4177j = false;
                super.close();
            } catch (GeneralSecurityException e10) {
                throw new IOException("ptBuffer.remaining():" + this.f4175h.remaining() + " ctBuffer.remaining():" + this.f4176i.remaining(), e10);
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i2) {
        write(new byte[]{(byte) i2}, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i2, int i10) {
        try {
            if (this.f4177j) {
                while (i10 > this.f4175h.remaining()) {
                    int iRemaining = this.f4175h.remaining();
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i2, iRemaining);
                    i2 += iRemaining;
                    i10 -= iRemaining;
                    try {
                        this.f4175h.flip();
                        this.f4176i.clear();
                        this.f4173f.b(this.f4175h, byteBufferWrap, this.f4176i);
                        this.f4176i.flip();
                        ((FilterOutputStream) this).out.write(this.f4176i.array(), this.f4176i.position(), this.f4176i.remaining());
                        this.f4175h.clear();
                        this.f4175h.limit(this.f4174g);
                    } catch (GeneralSecurityException e10) {
                        throw new IOException(e10);
                    }
                }
                this.f4175h.put(bArr, i2, i10);
            } else {
                throw new IOException("Trying to write to closed stream");
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
