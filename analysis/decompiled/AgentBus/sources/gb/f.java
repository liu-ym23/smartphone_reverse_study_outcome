package gb;

import java.io.IOException;
import java.util.zip.Deflater;
import ob.c0;
import ob.f0;
import ob.g0;
import ob.i;
import ob.i0;
import ob.m0;
import ob.r;
import q7.k;

/* loaded from: classes.dex */
public final class f implements i0 {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4046f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4047g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f4048h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f4049i;

    public f(ob.h hVar, Deflater deflater) {
        this.f4048h = ob.b.b(hVar);
        this.f4049i = deflater;
    }

    public void a(boolean z4) throws IOException {
        f0 f0VarE;
        int iDeflate;
        Deflater deflater = (Deflater) this.f4049i;
        c0 c0Var = (c0) this.f4048h;
        ob.h hVar = c0Var.f7955g;
        while (true) {
            f0VarE = hVar.E(1);
            byte[] bArr = f0VarE.f7975a;
            if (z4) {
                try {
                    int i2 = f0VarE.f7977c;
                    iDeflate = deflater.deflate(bArr, i2, 8192 - i2, 2);
                } catch (NullPointerException e10) {
                    throw new IOException("Deflater already closed", e10);
                }
            } else {
                int i10 = f0VarE.f7977c;
                iDeflate = deflater.deflate(bArr, i10, 8192 - i10);
            }
            if (iDeflate > 0) {
                f0VarE.f7977c += iDeflate;
                hVar.f7993g += iDeflate;
                c0Var.a();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (f0VarE.f7976b == f0VarE.f7977c) {
            hVar.f7992f = f0VarE.a();
            g0.a(f0VarE);
        }
    }

    @Override // ob.i0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        switch (this.f4046f) {
            case 0:
                h hVar = (h) this.f4049i;
                if (this.f4047g) {
                    return;
                }
                this.f4047g = true;
                r rVar = (r) this.f4048h;
                m0 m0Var = rVar.f8024e;
                rVar.f8024e = m0.f8007d;
                m0Var.a();
                m0Var.b();
                hVar.f4052b = 3;
                return;
            default:
                Deflater deflater = (Deflater) this.f4049i;
                if (this.f4047g) {
                    return;
                }
                try {
                    deflater.finish();
                    a(false);
                    th = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    deflater.end();
                } catch (Throwable th2) {
                    if (th == null) {
                        th = th2;
                    }
                }
                try {
                    ((c0) this.f4048h).close();
                } catch (Throwable th3) {
                    if (th == null) {
                        th = th3;
                    }
                }
                this.f4047g = true;
                if (th != null) {
                    throw th;
                }
                return;
        }
    }

    @Override // ob.i0, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.f4046f) {
            case 0:
                if (!this.f4047g) {
                    ((i) ((h) this.f4049i).f4056f).flush();
                    break;
                }
                break;
            default:
                a(true);
                ((c0) this.f4048h).flush();
                break;
        }
    }

    @Override // ob.i0
    public final m0 timeout() {
        switch (this.f4046f) {
            case 0:
                return (r) this.f4048h;
            default:
                return ((c0) this.f4048h).f7954f.timeout();
        }
    }

    public String toString() {
        switch (this.f4046f) {
            case 1:
                return "DeflaterSink(" + ((c0) this.f4048h) + ')';
            default:
                return super.toString();
        }
    }

    @Override // ob.i0
    public final void write(ob.h hVar, long j2) throws IOException {
        switch (this.f4046f) {
            case 0:
                k.e(hVar, "source");
                if (this.f4047g) {
                    throw new IllegalStateException("closed");
                }
                bb.b.c(hVar.f7993g, 0L, j2);
                ((i) ((h) this.f4049i).f4056f).write(hVar, j2);
                return;
            default:
                k.e(hVar, "source");
                ob.b.e(hVar.f7993g, 0L, j2);
                while (j2 > 0) {
                    f0 f0Var = hVar.f7992f;
                    k.b(f0Var);
                    int iMin = (int) Math.min(j2, f0Var.f7977c - f0Var.f7976b);
                    ((Deflater) this.f4049i).setInput(f0Var.f7975a, f0Var.f7976b, iMin);
                    a(false);
                    long j4 = iMin;
                    hVar.f7993g -= j4;
                    int i2 = f0Var.f7976b + iMin;
                    f0Var.f7976b = i2;
                    if (i2 == f0Var.f7977c) {
                        hVar.f7992f = f0Var.a();
                        g0.a(f0Var);
                    }
                    j2 -= j4;
                }
                return;
        }
    }

    public f(h hVar) {
        this.f4049i = hVar;
        this.f4048h = new r(((i) hVar.f4056f).timeout());
    }
}
