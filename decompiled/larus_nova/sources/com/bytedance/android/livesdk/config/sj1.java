package com.bytedance.android.livesdk.config;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class sj1 {
    @JvmStatic
    public static final boolean b(int r100) {
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 8) goto L7;
        return true;
    L7:
        if (r100 != 12) goto L9;
        return true;
    L9:
        if (r100 == 16) goto L15;
        return false;
    L15:
        return true;
    }

    @JvmStatic
    public static final boolean c() {
        return com.bytedance.android.livesdk.l4.f146988a.getValue().booleanValue();
    }

    static {
    }

    @JvmStatic
    public static final boolean a(int r100, boolean r101) {
        if (c() == true) goto L5;
        return false;
    L5:
        if (r101 == true) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (b(r100) == false) goto L9;
        r102 = true;
        goto L10
    }

    @JvmStatic
    public static final int d(int r100, boolean r101) {
        if (a(r100, r101) == true) goto L5;
    L11:
        return 2;
    L5:
        if (com.bytedance.android.live.core.setting.b6.f65234g.getValue().booleanValue() == false) goto L11;
        if (com.bytedance.android.live.core.setting.b6.f65236h.getValue().booleanValue() == false) goto L11;
        if (us1.d.b(false, true) == false) goto L11;
        return 1;
    }
}
