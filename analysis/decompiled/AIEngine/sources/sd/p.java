package sd;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public final y f11963a;

    /* renamed from: b, reason: collision with root package name */
    public final Deflater f11964b;

    /* renamed from: c, reason: collision with root package name */
    public final i f11965c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11966d;

    /* renamed from: e, reason: collision with root package name */
    public final CRC32 f11967e;

    public p(g sink) {
        kotlin.jvm.internal.g.f(sink, "sink");
        y yVar = new y(sink);
        this.f11963a = yVar;
        Deflater deflater = new Deflater(-1, true);
        this.f11964b = deflater;
        this.f11965c = new i(yVar, deflater);
        this.f11967e = new CRC32();
        e eVar = yVar.f11984b;
        eVar.S0(8075);
        eVar.O0(8);
        eVar.O0(0);
        eVar.R0(0);
        eVar.O0(0);
        eVar.O0(0);
    }

    @Override // sd.c0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        int value;
        boolean z;
        e eVar;
        Deflater deflater = this.f11964b;
        y yVar = this.f11963a;
        if (this.f11966d) {
            return;
        }
        try {
            i iVar = this.f11965c;
            iVar.f11944b.finish();
            iVar.a(false);
            value = (int) this.f11967e.getValue();
            z = yVar.f11985c;
            eVar = yVar.f11984b;
        } catch (Throwable th) {
            th = th;
        }
        if (z) {
            throw new IllegalStateException("closed");
        }
        eVar.getClass();
        eVar.R0(a.d(value));
        yVar.a();
        int bytesRead = (int) deflater.getBytesRead();
        if (yVar.f11985c) {
            throw new IllegalStateException("closed");
        }
        eVar.getClass();
        eVar.R0(a.d(bytesRead));
        yVar.a();
        th = null;
        try {
            deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            yVar.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f11966d = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // sd.c0, java.io.Flushable
    public final void flush() throws IOException {
        this.f11965c.flush();
    }

    @Override // sd.c0
    public final void j0(e source, long j10) throws IOException {
        kotlin.jvm.internal.g.f(source, "source");
        if (j10 < 0) {
            throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "byteCount < 0: ").toString());
        }
        if (j10 == 0) {
            return;
        }
        a0 a0Var = source.f11925a;
        kotlin.jvm.internal.g.c(a0Var);
        long j11 = j10;
        while (j11 > 0) {
            int iMin = (int) Math.min(j11, a0Var.f11903c - a0Var.f11902b);
            this.f11967e.update(a0Var.f11901a, a0Var.f11902b, iMin);
            j11 -= iMin;
            a0Var = a0Var.f11906f;
            kotlin.jvm.internal.g.c(a0Var);
        }
        this.f11965c.j0(source, j10);
    }

    @Override // sd.c0
    public final f0 timeout() {
        return this.f11963a.f11983a.timeout();
    }
}
