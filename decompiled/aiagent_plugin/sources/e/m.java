package e;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: InflaterSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f38735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Inflater f38736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f38737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f38738d;

    public m(g r3, Inflater r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r4, "inflater");
        this.f38735a = r5;
        this.f38736b = r4;
    }

    @Override // e.aa
    public long a(e r5, long r6) {
        d.h.b.o.e(r5, "sink");
    L3:
        long r0 = b(r5, r6);
        if (r0 > 0) goto L5;
        if (this.f38736b.finished() == true) goto L16;
        if (this.f38736b.needsDictionary() == true) goto L23;
        if (this.f38735a.h() == false) goto L3;
        throw new EOFException("source exhausted prematurely");
    L23:
        return -1;
    L16:
        return -1;
    L5:
        return r0;
    }

    public final long b(e r6, long r7) {
        d.h.b.o.e(r6, "sink");
        if (r7 < 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L25;
        if ((!this.f38738d) == false) goto L23;
        if (r7 != 0) goto L26;
        return 0;
    L26:
        v r2 = r6.f(1);     // Catch: DataFormatException -> L19
        int r8 = (int) Math.min(r7, 8192 - r2.f38758d);     // Catch: DataFormatException -> L19
        b();     // Catch: DataFormatException -> L19
        int r9 = this.f38736b.inflate(r2.f38756b, r2.f38758d, r8);     // Catch: DataFormatException -> L19
        c();     // Catch: DataFormatException -> L19
        if (r9 <= 0) goto L16;
        r2.f38758d += r9;     // Catch: DataFormatException -> L19
        long r10 = r9;
        r6.a(r6.b() + r10);     // Catch: DataFormatException -> L19
        return r10;
    L16:
        if (r2.f38757c != r2.f38758d) goto L18;
        r6.f38713a = r2.c();     // Catch: DataFormatException -> L19
        w.a(r2);     // Catch: DataFormatException -> L19
    L18:
        return 0;
    L19:
        e = move-exception;
        throw new IOException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L23:
        throw new IllegalStateException("closed".toString());
    L25:
        throw new IllegalArgumentException(("byteCount < 0: " + r7).toString());
    L5:
        r4 = false;
        goto L6
    }

    public final boolean b() {
        if (this.f38736b.needsInput() == true) goto L6;
        return false;
    L6:
        if (this.f38735a.h() == false) goto L9;
        return true;
    L9:
        v r0 = this.f38735a.d().f38713a;
        d.h.b.o.a(r0);
        this.f38737c = r0.f38758d - r0.f38757c;
        this.f38736b.setInput(r0.f38756b, r0.f38757c, this.f38737c);
        return false;
    }

    private final void c() {
        int r0 = this.f38737c;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = r0 - this.f38736b.getRemaining();
        this.f38737c -= r1;
        this.f38735a.h(r1);
    }

    @Override // e.aa
    public ab a() {
        return this.f38735a.a();
    }

    @Override // e.aa, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f38738d == false) goto L5;
        return;
    L5:
        this.f38736b.end();
        this.f38738d = true;
        this.f38735a.close();
    }
}
