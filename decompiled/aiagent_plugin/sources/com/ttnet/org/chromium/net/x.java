package com.ttnet.org.chromium.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TTAppSecurityManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class x {
    private static final String TAG = "x";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile x f38301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f38302b;

    /* JADX INFO: compiled from: TTAppSecurityManager.java */
    public interface a {
        int a();

        int b();

        String c();

        String d();
    }

    /* JADX INFO: compiled from: TTAppSecurityManager.java */
    interface b {
        boolean a();

        boolean b();
    }

    static {
    }

    public x() {
    }

    public static x a() {
        if (f38301a != null) goto L15;
        monitor-enter(x.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f38301a != null) goto L9;
        f38301a = new x();     // Catch: Throwable -> L11
    L9:
        monitor-exit(x.class);     // Catch: Throwable -> L11
    L15:
        return f38301a;
    }

    boolean b() {
        return y.c().a();
    }

    boolean c() {
        return y.c().b();
    }

    public void a(a r3) {
        this.f38302b = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public int d() {
        a r0 = this.f38302b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.a();
    }

    public int e() {
        a r0 = this.f38302b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b();
    }

    public String f() {
        a r0 = this.f38302b;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.c();
    }

    public String g() {
        a r0 = this.f38302b;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.d();
    }
}
