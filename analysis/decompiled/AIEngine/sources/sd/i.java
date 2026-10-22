package sd;

import java.io.IOException;
import java.util.zip.Deflater;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public final y f11943a;

    /* renamed from: b, reason: collision with root package name */
    public final Deflater f11944b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11945c;

    public i(y yVar, Deflater deflater) {
        this.f11943a = yVar;
        this.f11944b = deflater;
    }

    public final void a(boolean z) throws IOException {
        a0 a0VarM0;
        int iDeflate;
        y yVar = this.f11943a;
        e eVar = yVar.f11984b;
        while (true) {
            a0VarM0 = eVar.M0(1);
            byte[] bArr = a0VarM0.f11901a;
            Deflater deflater = this.f11944b;
            if (z) {
                try {
                    int i10 = a0VarM0.f11903c;
                    iDeflate = deflater.deflate(bArr, i10, 8192 - i10, 2);
                } catch (NullPointerException e10) {
                    throw new IOException("Deflater already closed", e10);
                }
            } else {
                int i11 = a0VarM0.f11903c;
                iDeflate = deflater.deflate(bArr, i11, 8192 - i11);
            }
            if (iDeflate > 0) {
                a0VarM0.f11903c += iDeflate;
                eVar.f11926b += iDeflate;
                yVar.a();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (a0VarM0.f11902b == a0VarM0.f11903c) {
            eVar.f11925a = a0VarM0.a();
            b0.a(a0VarM0);
        }
    }

    @Override // sd.c0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        Deflater deflater = this.f11944b;
        if (this.f11945c) {
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
            this.f11943a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f11945c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // sd.c0, java.io.Flushable
    public final void flush() throws IOException {
        a(true);
        this.f11943a.flush();
    }

    @Override // sd.c0
    public final void j0(e source, long j10) throws IOException {
        kotlin.jvm.internal.g.f(source, "source");
        a.b(source.f11926b, 0L, j10);
        while (j10 > 0) {
            a0 a0Var = source.f11925a;
            kotlin.jvm.internal.g.c(a0Var);
            int iMin = (int) Math.min(j10, a0Var.f11903c - a0Var.f11902b);
            this.f11944b.setInput(a0Var.f11901a, a0Var.f11902b, iMin);
            a(false);
            long j11 = iMin;
            source.f11926b -= j11;
            int i10 = a0Var.f11902b + iMin;
            a0Var.f11902b = i10;
            if (i10 == a0Var.f11903c) {
                source.f11925a = a0Var.a();
                b0.a(a0Var);
            }
            j10 -= j11;
        }
    }

    @Override // sd.c0
    public final f0 timeout() {
        return this.f11943a.f11983a.timeout();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f11943a + ')';
    }
}
