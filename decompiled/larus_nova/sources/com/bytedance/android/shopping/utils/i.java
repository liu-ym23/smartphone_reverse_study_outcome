package com.bytedance.android.shopping.utils;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f187147a = false;

    static {
        if (ECSettingKeys.s0() != 2) goto L5;
    L8:
        boolean r100 = true;
    L9:
        f187147a = r100;
        return;
    L5:
        if (ECSettingKeys.s0() == 3) goto L8;
        r100 = false;
        goto L9
    }

    public static boolean a() {
        if (ECSettingKeys.s0() != 2) goto L5;
    L8:
        return true;
    L5:
        if (ECSettingKeys.s0() == 3) goto L8;
        return false;
    }
}
