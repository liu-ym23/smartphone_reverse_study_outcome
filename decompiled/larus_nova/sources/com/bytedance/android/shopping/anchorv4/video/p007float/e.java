package com.bytedance.android.shopping.anchorv4.video.p007float;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f167605a = 0;

    static {
        f167605a = ECSettingKeys.N();
    }

    public static boolean a() {
        int r100 = f167605a;
        if (r100 != 1) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L17;
        if (r100 != 1) goto L12;
    L15:
        boolean r102 = true;
    L16:
        if (r102 == true) goto L17;
        return false;
    L12:
        if (r100 == 3) goto L15;
        r102 = false;
    L17:
        return true;
    L5:
        if (r100 == 2) goto L8;
        r101 = false;
        goto L9
    }

    public static boolean b() {
        int r100 = f167605a;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 4) goto L10;
        return false;
    L10:
        return true;
    }
}
