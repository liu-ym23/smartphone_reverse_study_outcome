package e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes4.dex */
class n implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f38739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ab f38740b;

    public n(InputStream r2, ab r3) {
        d.h.b.o.e(r2, "input");
        d.h.b.o.e(r3, "timeout");
        this.f38739a = r2;
        this.f38740b = r3;
    }

    @Override // e.aa
    public long a(e r4, long r5) {
        d.h.b.o.e(r4, "sink");
        if (r5 != 0) goto L6;
        return 0;
    L6:
        if (r5 < 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L26;
        this.f38740b.x_();     // Catch: AssertionError -> L19
        v r0 = r4.f(1);     // Catch: AssertionError -> L19
        int r3 = this.f38739a.read(r0.f38756b, r0.f38758d, (int) Math.min(r5, 8192 - r0.f38758d));     // Catch: AssertionError -> L19
        if (r3 == (-1)) goto L13;
        r0.f38758d += r3;     // Catch: AssertionError -> L19
        long r2 = r3;
        r4.a(r4.b() + r2);     // Catch: AssertionError -> L19
        return r2;
    L13:
        if (r0.f38757c != r0.f38758d) goto L28;
        r4.f38713a = r0.c();     // Catch: AssertionError -> L19
        w.a(r0);     // Catch: AssertionError -> L19
        return -1;
    L28:
        return -1;
    L19:
        e = move-exception;
        if (o.a(e) == true) goto L23;
        throw e;
    L23:
        throw new IOException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L26:
        throw new IllegalArgumentException(("byteCount < 0: " + r5).toString());
    L8:
        r1 = false;
        goto L9
    }

    @Override // e.aa, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f38739a.close();
    }

    @Override // e.aa
    public ab a() {
        return this.f38740b;
    }

    public String toString() {
        return "source(" + this.f38739a + ')';
    }
}
