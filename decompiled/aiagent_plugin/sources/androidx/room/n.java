package androidx.room;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: QueryInterceptorStatement.java */
/* JADX INFO: loaded from: classes.dex */
final class n implements androidx.sqlite.db.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.sqlite.db.g f2663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p.f f2664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Object> f2666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f2667e;

    /* JADX INFO: renamed from: lambda$4L1kObJA-Jo5vlNJjLFsivXAQHs, reason: not valid java name */
    public static /* synthetic */ void m11lambda$4L1kObJAJo5vlNJjLFsivXAQHs(n r0) {
        r0.d();
    }

    public static /* synthetic */ void lambda$E_r7p0qNEQ3C_LATJ3tPT6XvZUk(n r0) {
        r0.c();
    }

    n(androidx.sqlite.db.g r3, p.f r4, String r5, Executor r6) {
        androidx.sqlite.db.g r7 = (androidx.sqlite.db.g) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.g.class, "com.obric.aiagent.plugin");
        p.f r8 = (p.f) ZeusTransformUtils.wrapperContextForParams(r4, p.f.class, "com.obric.aiagent.plugin");
        Executor r9 = (Executor) ZeusTransformUtils.wrapperContextForParams(r6, Executor.class, "com.obric.aiagent.plugin");
        this.f2666d = new ArrayList();
        this.f2663a = r7;
        this.f2664b = r8;
        this.f2665c = r5;
        this.f2667e = r9;
    }

    private /* synthetic */ void d() {
        this.f2664b.a(this.f2665c, this.f2666d);
    }

    @Override // androidx.sqlite.db.g
    public int a() {
        this.f2667e.execute(new $$Lambda$n$4L1kObJAJo5vlNJjLFsivXAQHs(this));
        return this.f2663a.a();
    }

    private /* synthetic */ void c() {
        this.f2664b.a(this.f2665c, this.f2666d);
    }

    @Override // androidx.sqlite.db.g
    public long b() {
        this.f2667e.execute(new $$Lambda$n$E_r7p0qNEQ3C_LATJ3tPT6XvZUk(this));
        return this.f2663a.b();
    }

    @Override // androidx.sqlite.db.e
    public void a(int r2) {
        a(r2, this.f2666d.toArray());
        this.f2663a.a(r2);
    }

    @Override // androidx.sqlite.db.e
    public void a(int r2, long r3) {
        a(r2, Long.valueOf(r3));
        this.f2663a.a(r2, r3);
    }

    @Override // androidx.sqlite.db.e
    public void a(int r2, double r3) {
        a(r2, Double.valueOf(r3));
        this.f2663a.a(r2, r3);
    }

    @Override // androidx.sqlite.db.e
    public void a(int r1, String r2) {
        a(r1, r2);
        this.f2663a.a(r1, r2);
    }

    @Override // androidx.sqlite.db.e
    public void a(int r1, byte[] r2) {
        a(r1, r2);
        this.f2663a.a(r1, r2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2663a.close();
    }

    private void a(int r4, Object r5) {
        int r6 = r4 - 1;
        if (r6 < this.f2666d.size()) goto L7;
        int r0 = this.f2666d.size();
    L5:
        if (r0 > r6) goto L7;
        this.f2666d.add(null);
        r0 = r0 + 1;
    L7:
        this.f2666d.set(r6, r5);
    }
}
