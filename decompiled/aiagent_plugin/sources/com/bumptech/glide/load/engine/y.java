package com.bumptech.glide.load.engine;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SourceGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class y implements f, f.a {
    private static final String TAG = "SourceGenerator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g<?> f3748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f.a f3749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f3751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f3752e;
    private volatile com.bumptech.glide.load.b.n.a<?> f;
    private d g;

    y(g<?> r3, f.a r4) {
        f.a r5 = (f.a) ZeusTransformUtils.wrapperContextForParams(r4, f.a.class, "com.obric.aiagent.plugin");
        this.f3748a = r3;
        this.f3749b = r5;
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean a() {
        Object r0 = this.f3752e;
        if (r0 == null) goto L5;
        this.f3752e = null;
        a(r0);
    L5:
        c r1 = this.f3751d;
        if (r1 != null) goto L8;
    L10:
        this.f3751d = null;
        this.f = null;
        boolean r2 = false;
    L11:
        if (r2 == true) goto L21;
        if (d() == false) goto L21;
        List<com.bumptech.glide.load.b.n.a<?>> r3 = this.f3748a.n();
        int r4 = this.f3750c;
        this.f3750c = r4 + 1;
        this.f = (com.bumptech.glide.load.b.n.a) ZeusTransformUtils.preCheckCast(r3.get(r4), com.bumptech.glide.load.b.n.a.class, "com.obric.aiagent.plugin");
        if (this.f == null) goto L11;
        if (this.f3748a.c().a(this.f.f3468c.d()) == true) goto L20;
        if (this.f3748a.a(this.f.f3468c.a()) == false) goto L11;
    L20:
        b(this.f);
        r2 = true;
    L21:
        return r2;
    L8:
        if (r1.a() == false) goto L10;
        return true;
    }

    private void b(final com.bumptech.glide.load.b.n.a<?> r4) {
        this.f.f3468c.a(this.f3748a.d(), new AnonymousClass1(this, r4));
    }

    boolean a(com.bumptech.glide.load.b.n.a<?> r1) {
        com.bumptech.glide.load.b.n.a<?> r0 = this.f;
        if (r0 == null) goto L6;
        if (r0 != r1) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean d() {
        if (this.f3750c >= this.f3748a.n().size()) goto L5;
        return true;
    L5:
        return false;
    }

    private void a(Object r9) {
        long r1 = com.bumptech.glide.f.f.a();
        com.bumptech.glide.load.d<X> r3 = this.f3748a.a(r9);     // Catch: Throwable -> L8
        e r4 = new e(r3, r9, this.f3748a.e());     // Catch: Throwable -> L8
        this.g = new d(this.f.f3466a, this.f3748a.f());     // Catch: Throwable -> L8
        this.f3748a.b().a(this.g, r4);     // Catch: Throwable -> L8
        if (a(TAG, 2) == false) goto L6;
        a(TAG, "Finished encoding source to cache, key: " + this.g + ", data: " + r9 + ", encoder: " + r3 + ", duration: " + com.bumptech.glide.f.f.a(r1));     // Catch: Throwable -> L8
    L6:
        this.f.f3468c.b();
        this.f3751d = new c(Collections.singletonList(this.f.f3466a), this.f3748a, this);
        return;
    L8:
        th = move-exception;
        this.f.f3468c.b();
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.f
    public void b() {
        com.bumptech.glide.load.b.n.a<?> r0 = this.f;
        if (r0 == null) goto L6;
        r0.f3468c.c();
        return;
    }

    void a(com.bumptech.glide.load.b.n.a<?> r7, Object r8) {
        j r0 = this.f3748a.c();
        if (r8 != null) goto L5;
    L7:
        this.f3749b.a(r7.f3466a, r8, r7.f3468c, r7.f3468c.d(), this.g);
        return;
    L5:
        if (r0.a(r7.f3468c.d()) == false) goto L7;
        this.f3752e = r8;
        this.f3749b.c();
    }

    void a(com.bumptech.glide.load.b.n.a<?> r3, Exception r4) {
        this.f3749b.a(this.g, r4, r3.f3468c, r3.f3468c.d());
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void c() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void a(com.bumptech.glide.load.g r8, Object r9, com.bumptech.glide.load.a.d<?> r10, com.bumptech.glide.load.a r11, com.bumptech.glide.load.g r12) {
        com.bumptech.glide.load.g r6 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r8, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.a.d<?> r4 = (com.bumptech.glide.load.a.d) ZeusTransformUtils.wrapperContextForParams(r10, com.bumptech.glide.load.a.d.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.g r13 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r12, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        this.f3749b.a(r6, r9, r4, this.f.f3468c.d(), r6);
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void a(com.bumptech.glide.load.g r2, Exception r3, com.bumptech.glide.load.a.d<?> r4, com.bumptech.glide.load.a r5) {
        com.bumptech.glide.load.g r6 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.a.d<?> r7 = (com.bumptech.glide.load.a.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.a.d.class, "com.obric.aiagent.plugin");
        this.f3749b.a(r6, r3, r7, this.f.f3468c.d());
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }
}
