package com.bytedance.android.livesdk.gift.util;

import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;

/* JADX INFO: loaded from: classes9.dex */
public final class c {
    public static final boolean b() {
        if (FoldScreenUtils.e() == false) goto L8;
        if (nz1.a.i().a() == true) goto L8;
    L9:
        if (nz1.a.q().b() == false) goto L17;
        return true;
    L17:
        return false;
    L8:
        if (PadConfigUtils.a() == true) goto L9;
        return false;
    L18:
        return false;
    }

    public static final int a() {
        if (b() == true) goto L5;
        return 0;
    L5:
        if (nz1.a.q().a() >= 1) goto L7;
        return 0;
    L7:
        return nz1.a.q().a();
    }

    public static final boolean c() {
        if (b() == true) goto L5;
    L7:
        return false;
    L5:
        if (nz1.a.q().c() <= 1.0f) goto L7;
        return true;
    }
}
