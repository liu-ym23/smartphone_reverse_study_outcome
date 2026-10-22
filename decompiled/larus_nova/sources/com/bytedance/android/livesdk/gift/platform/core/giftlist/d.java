package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        String r102 = "[GIFT_LIST]".concat(r100);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        jy0.b.c(r102, r101, null, 4);
    }
}
