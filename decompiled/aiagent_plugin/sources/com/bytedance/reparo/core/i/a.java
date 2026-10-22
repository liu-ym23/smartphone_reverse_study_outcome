package com.bytedance.reparo.core.i;

/* JADX INFO: compiled from: AutoFailSyncHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9272a = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.reparo.core.h.d f9273c;

    static {
    }

    public a(final com.bytedance.reparo.core.h.d r8, String r9) {
        super(r8.f9262c.k(), "auto_fail_sync", 3, r9, new AnonymousClass1(r8));
        this.f9273c = r8;
    }

    public void a() {
        if (f9272a == true) goto L5;
        return;
    L5:
        d();
    }

    public void b() {
        if (f9272a == true) goto L5;
        return;
    L5:
        if (this.f9273c.g().r() == true) goto L7;
        return;
    L7:
        if (c() == true) goto L13;
        e();
        return;
    }
}
