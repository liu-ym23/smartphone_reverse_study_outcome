package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f150308a = 0;

    static {
    }

    public static String a(long r100) {
        if (r100 <= 0) goto L18;
        StringBuilder r101 = new StringBuilder();
        if (r100 <= 3600000) goto L10;
        long r102 = r100 / 3600000;
        r100 = r100 - (3600000 * r102);
        if (r102 > 9) goto L9;
        r101.append(0);
    L9:
        r101.append(r102);
        r101.append(":");
    L10:
        long r103 = r100 / 60000;
        long r104 = r100 - (60000 * r103);
        long r105 = 9;
        if (r103 > r105) goto L13;
        r101.append(0);
    L13:
        r101.append(r103);
        r101.append(":");
        long r106 = r104 / 1000;
        if (r106 > r105) goto L16;
        r101.append(0);
    L16:
        r101.append(r106);
        return r101.toString();
    L18:
        return "";
    }
}
