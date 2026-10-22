package com.bytedance.android.live.liveinteract.hamlet.model;

/* JADX INFO: loaded from: classes46.dex */
public final class o {
    public static final boolean a(l r100, l r101) {
        if (r101 != null) goto L7;
        if (r100 != null) goto L7;
        return true;
    L7:
        if (r101 == null) goto L24;
        if (r100 == null) goto L24;
        Double r102 = r101.a();
        Double r103 = r101.b();
        if (r100.a() == null) goto L24;
        if (r100.b() == null) goto L24;
        if (r102 == null) goto L24;
        if (r103 == null) goto L24;
        double r104 = 0.05f;
        if (Math.abs(r100.a().doubleValue() - r102.doubleValue()) <= r104) goto L20;
    L22:
        return false;
    L20:
        if (Math.abs(r100.b().doubleValue() - r103.doubleValue()) > r104) goto L22;
        return true;
    L24:
        return false;
    }
}
