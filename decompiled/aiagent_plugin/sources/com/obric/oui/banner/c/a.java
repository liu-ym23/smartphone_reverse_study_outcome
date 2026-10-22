package com.obric.oui.banner.c;

/* JADX INFO: compiled from: BannerUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f34047a = null;

    static {
        f34047a = new a();
    }

    private a() {
    }

    public final int a(boolean r1, int r2, int r3) {
        if (r1 == false) goto L9;
        if (r3 > 0) goto L8;
        r3 = 1;
    L8:
        return r2 % r3;
    L9:
        return r2;
    }
}
