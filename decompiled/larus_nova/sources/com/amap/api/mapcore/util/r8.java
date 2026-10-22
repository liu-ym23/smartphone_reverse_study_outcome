package com.amap.api.mapcore.util;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes28.dex */
public class r8 extends v8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f27939b;

    @Override // com.amap.api.mapcore.util.v8
    public boolean c() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.f27939b);     // Catch: Throwable -> L8
        if (r100.exists() == false) goto L10;
        int r101 = r100.list().length;     // Catch: Throwable -> L8
    L12:
        if (r101 >= 30) goto L14;
        return false;
    L14:
        return true;
    L10:
        r101 = 0;
    L8:
        th = move-exception;
        t6.a(th, "fus", "gfn");
        goto L10
    }

    public r8(int r100, String r101, v8 r102) {
        super(r102);
        this.f27939b = r101;
    }
}
