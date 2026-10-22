package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.util.Pair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: QueryInterceptorDatabase.java */
/* JADX INFO: loaded from: classes.dex */
final class j implements androidx.sqlite.db.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.sqlite.db.c f2653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p.f f2654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f2655c;

    /* JADX INFO: renamed from: lambda$2eNEqyIDmgMp5P-89vnxa3pws2I, reason: not valid java name */
    public static /* synthetic */ void m8lambda$2eNEqyIDmgMp5P89vnxa3pws2I(j r0, String r1) {
        r0.d(r1);
    }

    /* JADX INFO: renamed from: lambda$B_ccszToGJ8-sT_qRqs1VNUcQLw, reason: not valid java name */
    public static /* synthetic */ void m9lambda$B_ccszToGJ8sT_qRqs1VNUcQLw(j r0, androidx.sqlite.db.f r1, m r2) {
        r0.b(r1, r2);
    }

    public static /* synthetic */ void lambda$Ck_G609Xj4AtjtgrymKWqF4E7MA(j r0) {
        r0.m();
    }

    public static /* synthetic */ void lambda$LkskR_chnj_pFWBu5jIFWyTCovw(j r0, androidx.sqlite.db.f r1, m r2) {
        r0.a(r1, r2);
    }

    public static /* synthetic */ void lambda$N4Gkgmi1JkhlOYbt_wZurHbKKUo(j r0, String r1, List r2) {
        r0.a(r1, r2);
    }

    public static /* synthetic */ void lambda$TODrmrfk2v9qL90XFaHFhkyMX4c(j r0) {
        r0.k();
    }

    public static /* synthetic */ void lambda$eEcH7pfQYk9cea1mX2OJpwzxApY(j r0) {
        r0.l();
    }

    /* JADX INFO: renamed from: lambda$fMvciDPEQD1d1K-mAb6tTLDLz2w, reason: not valid java name */
    public static /* synthetic */ void m10lambda$fMvciDPEQD1d1KmAb6tTLDLz2w(j r0, String r1) {
        r0.c(r1);
    }

    public static /* synthetic */ void lambda$gnIN1cicrWNvkwzG9A_aXks3y5U(j r0) {
        r0.a();
    }

    j(androidx.sqlite.db.c r3, p.f r4, Executor r5) {
        androidx.sqlite.db.c r6 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        p.f r7 = (p.f) ZeusTransformUtils.wrapperContextForParams(r4, p.f.class, "com.obric.aiagent.plugin");
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin");
        this.f2653a = r6;
        this.f2654b = r7;
        this.f2655c = r8;
    }

    @Override // androidx.sqlite.db.c
    public androidx.sqlite.db.g a(String r4) {
        return new n(this.f2653a.a(r4), this.f2654b, r4, this.f2655c);
    }

    private /* synthetic */ void m() {
        this.f2654b.a("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }

    @Override // androidx.sqlite.db.c
    public void b() {
        this.f2655c.execute(new $$Lambda$j$Ck_G609Xj4AtjtgrymKWqF4E7MA(this));
        this.f2653a.b();
    }

    private /* synthetic */ void l() {
        this.f2654b.a("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }

    @Override // androidx.sqlite.db.c
    public void c() {
        this.f2655c.execute(new $$Lambda$j$eEcH7pfQYk9cea1mX2OJpwzxApY(this));
        this.f2653a.c();
    }

    private /* synthetic */ void k() {
        this.f2654b.a("END TRANSACTION", Collections.emptyList());
    }

    @Override // androidx.sqlite.db.c
    public void d() {
        this.f2655c.execute(new $$Lambda$j$TODrmrfk2v9qL90XFaHFhkyMX4c(this));
        this.f2653a.d();
    }

    private /* synthetic */ void a() {
        this.f2654b.a("TRANSACTION SUCCESSFUL", Collections.emptyList());
    }

    @Override // androidx.sqlite.db.c
    public void e() {
        this.f2655c.execute(new $$Lambda$j$gnIN1cicrWNvkwzG9A_aXks3y5U(this));
        this.f2653a.e();
    }

    @Override // androidx.sqlite.db.c
    public boolean f() {
        return this.f2653a.f();
    }

    @Override // androidx.sqlite.db.c
    public void a(int r1) {
        this.f2653a.a(r1);
    }

    private /* synthetic */ void d(String r2) {
        this.f2654b.a(r2, Collections.emptyList());
    }

    @Override // androidx.sqlite.db.c
    public Cursor query(final String r3) {
        this.f2655c.execute(new $$Lambda$j$2eNEqyIDmgMp5P89vnxa3pws2I(this, r3));
        return this.f2653a.query(r3);
    }

    @Override // androidx.sqlite.db.c
    public Cursor query(final String r4, Object[] r5) {
        final ArrayList r0 = new ArrayList();
        r0.addAll(Arrays.asList(r5));
        this.f2655c.execute(new $$Lambda$j$N4Gkgmi1JkhlOYbt_wZurHbKKUo(this, r4, r0));
        return this.f2653a.query(r4, r5);
    }

    private /* synthetic */ void a(String r3, List r4) {
        List<Object> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.f2654b.a(r3, r5);
    }

    @Override // androidx.sqlite.db.c
    public Cursor query(androidx.sqlite.db.f r4) {
        final androidx.sqlite.db.f r5 = (androidx.sqlite.db.f) ZeusTransformUtils.wrapperContextForParams(r4, androidx.sqlite.db.f.class, "com.obric.aiagent.plugin");
        final m r0 = new m();
        r5.a(r0);
        this.f2655c.execute(new $$Lambda$j$B_ccszToGJ8sT_qRqs1VNUcQLw(this, r5, r0));
        return this.f2653a.query(r5);
    }

    private /* synthetic */ void b(androidx.sqlite.db.f r3, m r4) {
        androidx.sqlite.db.f r5 = (androidx.sqlite.db.f) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.f.class, "com.obric.aiagent.plugin");
        this.f2654b.a(r5.b(), r4.a());
    }

    @Override // androidx.sqlite.db.c
    public Cursor query(androidx.sqlite.db.f r3, CancellationSignal r4) {
        final androidx.sqlite.db.f r5 = (androidx.sqlite.db.f) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.f.class, "com.obric.aiagent.plugin");
        final m r6 = new m();
        r5.a(r6);
        this.f2655c.execute(new $$Lambda$j$LkskR_chnj_pFWBu5jIFWyTCovw(this, r5, r6));
        return this.f2653a.query(r5);
    }

    private /* synthetic */ void a(androidx.sqlite.db.f r3, m r4) {
        androidx.sqlite.db.f r5 = (androidx.sqlite.db.f) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.f.class, "com.obric.aiagent.plugin");
        this.f2654b.a(r5.b(), r4.a());
    }

    @Override // androidx.sqlite.db.c
    public long insert(String r1, int r2, ContentValues r3) {
        return this.f2653a.insert(r1, r2, r3);
    }

    @Override // androidx.sqlite.db.c
    public int delete(String r1, String r2, Object[] r3) {
        return this.f2653a.delete(r1, r2, r3);
    }

    @Override // androidx.sqlite.db.c
    public int update(String r7, int r8, ContentValues r9, String r10, Object[] r11) {
        return this.f2653a.update(r7, r8, r9, r10, r11);
    }

    private /* synthetic */ void c(String r3) {
        this.f2654b.a(r3, new ArrayList(0));
    }

    @Override // androidx.sqlite.db.c
    public void b(final String r3) {
        this.f2655c.execute(new $$Lambda$j$fMvciDPEQD1d1KmAb6tTLDLz2w(this, r3));
        this.f2653a.b(r3);
    }

    @Override // androidx.sqlite.db.c
    public boolean g() {
        return this.f2653a.g();
    }

    @Override // androidx.sqlite.db.c
    public String h() {
        return this.f2653a.h();
    }

    @Override // androidx.sqlite.db.c
    public boolean i() {
        return this.f2653a.i();
    }

    @Override // androidx.sqlite.db.c
    public List<Pair<String, String>> j() {
        return this.f2653a.j();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2653a.close();
    }
}
