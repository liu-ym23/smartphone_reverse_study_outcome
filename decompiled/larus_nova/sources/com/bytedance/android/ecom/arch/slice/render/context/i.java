package com.bytedance.android.ecom.arch.slice.render.context;

/* JADX INFO: loaded from: classes44.dex */
public final class i {
    public static final double a(zp.a r100) {
        long r101 = System.currentTimeMillis();
        if (r100 == null) goto L5;
        Object r102 = r100.getService();
    L7:
        return (r101 - (com.bytedance.android.ecom.arch.slice.render.util.b.l(r102, 0) * ((long) 1000))) / 1000.0d;
    L5:
        r102 = null;
        goto L7
    }
}
