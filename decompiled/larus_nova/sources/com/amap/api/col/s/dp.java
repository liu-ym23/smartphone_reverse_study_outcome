package com.amap.api.col.s;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes28.dex */
public final class dp extends dt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f26583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f26584b;

    @Override // com.amap.api.col.s.dt
    public final boolean a() {
        if (a(this.f26584b) >= this.f26583a) goto L6;
        return false;
    L6:
        return true;
    }

    private static int a(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L8
        if (r101.exists() == true) goto L6;
        return 0;
    L6:
        return r101.list().length;
    L8:
        th = move-exception;
        cg.c(th, "fus", "gfn");
        return 0;
    }

    public dp(String r100, dt r101) {
        super(r101);
        this.f26583a = 30;
        this.f26584b = r100;
    }
}
