package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

import java.util.Comparator;

/* JADX INFO: loaded from: classes9.dex */
public final class i<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f141673a = null;

    static {
        f141673a = new i();
    }

    public i() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r102 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r100;
        tc2.f r103 = (tc2.f) ((com.bytedance.android.livesdk.interactivity.zdanmaku.i) r101).b().e(tc2.f.class);
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.f545386e;
    L6:
        tc2.f r106 = (tc2.f) r102.b().e(tc2.f.class);
        if (r106 == null) goto L10;
        r104 = r106.f545386e;
    L10:
        return r105 - r104;
    L5:
        r105 = 0;
        goto L6
    }
}
