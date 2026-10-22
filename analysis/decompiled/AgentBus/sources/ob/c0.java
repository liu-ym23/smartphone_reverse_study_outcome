package ob;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class c0 implements i {

    /* renamed from: f, reason: collision with root package name */
    public final i0 f7954f;

    /* renamed from: g, reason: collision with root package name */
    public final h f7955g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7956h;

    public c0(i0 i0Var) {
        q7.k.e(i0Var, "sink");
        this.f7954f = i0Var;
        this.f7955g = new h();
    }

    @Override // ob.i
    public final i M(String str) {
        q7.k.e(str, "string");
        if (this.f7956h) {
            throw new IllegalStateException("closed");
        }
        this.f7955g.U(str);
        a();
        return this;
    }

    public final i a() {
        if (this.f7956h) {
            throw new IllegalStateException("closed");
        }
        h hVar = this.f7955g;
        long jB = hVar.b();
        if (jB > 0) {
            this.f7954f.write(hVar, jB);
        }
        return this;
    }

    @Override // ob.i
    public final h c() {
        return this.f7955g;
    }

    @Override // ob.i0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        i0 i0Var = this.f7954f;
        if (this.f7956h) {
            return;
        }
        try {
            h hVar = this.f7955g;
            long j2 = hVar.f7993g;
            if (j2 > 0) {
                i0Var.write(hVar, j2);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            i0Var.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f7956h = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // ob.i
    public final i f(String str, int i2, int i10) {
        if (this.f7956h) {
            throw new IllegalStateException("closed");
        }
        this.f7955g.V(str, i2, i10);
        a();
        return this;
    }

    @Override // ob.i, ob.i0, java.io.Flushable
    public final void flush() {
        if (this.f7956h) {
            throw new IllegalStateException("closed");
        }
        h hVar = this.f7955g;
        long j2 = hVar.f7993g;
        i0 i0Var = this.f7954f;
        if (j2 > 0) {
            i0Var.write(hVar, j2);
        }
        i0Var.flush();
    }

    @Override // ob.i
    public final i h(long j2) {
        if (this.f7956h) {
            throw new IllegalStateException("closed");
        }
        this.f7955g.R(j2);
        a();
        return this;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f7956h;
    }

    @Override // ob.i
    public final i m() {
        if (this.f7956h) {
            throw new IllegalStateException("closed");
        }
        h hVar = this.f7955g;
        long j2 = hVar.f7993g;
        if (j2 > 0) {
            this.f7954f.write(hVar, j2);
        }
        return this;
    }

    @Override // ob.i0
    public final m0 timeout() {
        return this.f7954f.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f7954f + ')';
    }

    @Override // ob.i
    public final i v(k kVar) {
        q7.k.e(kVar, "byteString");
        if (this.f7956h) {
            throw new IllegalStateException("closed");
        }
        this.f7955g.H(kVar);
        a();
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        q7.k.e(byteBuffer, "source");
        if (this.f7956h) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f7955g.write(byteBuffer);
        a();
        return iWrite;
    }

    @Override // ob.i
    public final i writeByte(int i2) {
        if (this.f7956h) {
            throw new IllegalStateException("closed");
        }
        this.f7955g.Q(i2);
        a();
        return this;
    }

    @Override // ob.i
    public final i writeInt(int i2) {
        if (this.f7956h) {
            throw new IllegalStateException("closed");
        }
        this.f7955g.S(i2);
        a();
        return this;
    }

    @Override // ob.i
    public final i writeShort(int i2) {
        if (this.f7956h) {
            throw new IllegalStateException("closed");
        }
        this.f7955g.T(i2);
        a();
        return this;
    }

    @Override // ob.i0
    public final void write(h hVar, long j2) {
        q7.k.e(hVar, "source");
        if (!this.f7956h) {
            this.f7955g.write(hVar, j2);
            a();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // ob.i
    public final i write(byte[] bArr) {
        if (!this.f7956h) {
            this.f7955g.m22write(bArr);
            a();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
