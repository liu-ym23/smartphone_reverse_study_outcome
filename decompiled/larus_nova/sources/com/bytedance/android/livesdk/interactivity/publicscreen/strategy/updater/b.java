package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final void a(a r100, int r101) {
        if ((r100 instanceof c) == true) goto L5;
        r100 = null;
    L5:
        c r102 = (c) r100;
        if (r102 == null) goto L11;
        r102.f139606s = (int) Math.ceil(((double) r101) / ((double) Math.max(r102.f139599l.c(), 1)));
        if (r102.f139599l.a() == true) goto L12;
        r102.f139606s = 0;
        return;
    L12:
        return;
    }
}
