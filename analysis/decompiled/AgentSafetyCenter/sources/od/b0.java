package od;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 implements j {

    /* renamed from: c, reason: collision with root package name */
    public g0 f9421c;

    /* renamed from: f, reason: collision with root package name */
    public i f9422f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9423g;

    @Override // od.j
    public final j I(long j10) {
        if (this.f9423g) {
            f.e("closed");
            return null;
        }
        this.f9422f.c0(j10);
        d();
        return this;
    }

    @Override // od.j
    public final i a() {
        return this.f9422f;
    }

    @Override // od.g0
    public final k0 b() {
        return this.f9421c.b();
    }

    @Override // od.g0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        g0 g0Var = this.f9421c;
        if (this.f9423g) {
            return;
        }
        try {
            i iVar = this.f9422f;
            long j10 = iVar.f9454f;
            if (j10 > 0) {
                g0Var.f(iVar, j10);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            g0Var.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f9423g = true;
        if (th != null) {
            throw th;
        }
    }

    public final j d() {
        i iVar = this.f9422f;
        if (this.f9423g) {
            f.e("closed");
            return null;
        }
        long jN = iVar.n();
        if (jN > 0) {
            this.f9421c.f(iVar, jN);
        }
        return this;
    }

    public final j e(int i) {
        if (this.f9423g) {
            f.e("closed");
            return null;
        }
        this.f9422f.e0(i);
        d();
        return this;
    }

    @Override // od.g0
    public final void f(i iVar, long j10) {
        iVar.getClass();
        if (this.f9423g) {
            f.e("closed");
        } else {
            this.f9422f.f(iVar, j10);
            d();
        }
    }

    @Override // od.j, od.g0, java.io.Flushable
    public final void flush() {
        g0 g0Var = this.f9421c;
        if (this.f9423g) {
            f.e("closed");
            return;
        }
        i iVar = this.f9422f;
        long j10 = iVar.f9454f;
        if (j10 > 0) {
            g0Var.f(iVar, j10);
        }
        g0Var.flush();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f9423g;
    }

    @Override // od.j
    public final j t(l lVar) {
        lVar.getClass();
        if (this.f9423g) {
            f.e("closed");
            return null;
        }
        this.f9422f.Z(lVar);
        d();
        return this;
    }

    public final String toString() {
        return "buffer(" + this.f9421c + ')';
    }

    @Override // od.j
    public final j u(int i, byte[] bArr) {
        if (this.f9423g) {
            f.e("closed");
            return null;
        }
        this.f9422f.write(bArr, 0, i);
        d();
        return this;
    }

    @Override // od.j
    public final j v(String str) {
        str.getClass();
        if (this.f9423g) {
            f.e("closed");
            return null;
        }
        this.f9422f.g0(str);
        d();
        return this;
    }

    @Override // od.j
    public final j write(byte[] bArr) {
        bArr.getClass();
        if (this.f9423g) {
            f.e("closed");
            return null;
        }
        i iVar = this.f9422f;
        iVar.getClass();
        iVar.write(bArr, 0, bArr.length);
        d();
        return this;
    }

    @Override // od.j
    public final j writeByte(int i) {
        if (this.f9423g) {
            f.e("closed");
            return null;
        }
        this.f9422f.b0(i);
        d();
        return this;
    }

    @Override // od.j
    public final j y(long j10) {
        if (this.f9423g) {
            f.e("closed");
            return null;
        }
        this.f9422f.d0(j10);
        d();
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        if (!this.f9423g) {
            int iWrite = this.f9422f.write(byteBuffer);
            d();
            return iWrite;
        }
        f.e("closed");
        return 0;
    }
}
