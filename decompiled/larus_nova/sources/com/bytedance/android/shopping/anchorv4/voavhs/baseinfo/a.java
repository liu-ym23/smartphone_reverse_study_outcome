package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean a(ActivityVO r110) {
        if (r110 != null) goto L6;
        return false;
    L6:
        if (r110.getSubsidy() == null) goto L9;
        return true;
    L9:
        if (r110.getActivityBgUrl() != null) goto L11;
    L13:
        boolean r100 = false;
    L14:
        ActivityTime r101 = r110.getActivityTime();
        if (r101 == null) goto L17;
        long r102 = r101.getServerTime();
    L18:
        ActivityTime r103 = r110.getActivityTime();
        if (r103 == null) goto L21;
        long r104 = r103.getPreStartTime();
    L22:
        ActivityTime r105 = r110.getActivityTime();
        if (r105 == null) goto L25;
        long r111 = r105.getStartTime();
    L26:
        ActivityTime r106 = r110.getActivityTime();
        if (r106 == null) goto L29;
        long r112 = r106.getEndTime();
    L30:
        ActivityTime r107 = r110.getActivityTime();
        if (r107 == null) goto L33;
        r107.getRestBeginTime();
    L33:
        ActivityTime r113 = r110.getActivityTime();
        if (r113 == null) goto L37;
        r113.getRestEndTime();
    L37:
        if (r104 <= 0) goto L39;
    L47:
        if (r104 > 0) goto L49;
    L59:
        return r100;
    L49:
        if (r102 <= 0) goto L59;
        if (r111 > 0) goto L59;
        if (r112 > 0) goto L59;
        if (r100 == true) goto L56;
        return false;
    L56:
        if (r104 < r102) goto L63;
        return true;
    L63:
        return false;
    L39:
        if (r111 > 0) goto L47;
        if (r112 <= 0) goto L47;
        if (r100 == true) goto L44;
        return false;
    L44:
        if (r102 > r112) goto L61;
        return true;
    L61:
        return false;
    L29:
        r112 = 0;
        goto L30
    L25:
        r111 = 0;
        goto L26
    L21:
        r104 = 0;
        goto L22
    L17:
        r102 = 0;
        goto L18
    L11:
        if (r110.getPrice() == null) goto L13;
        r100 = true;
        goto L14
    }
}
