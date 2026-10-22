package com.bytedance.android.livesdk.gift.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class m3 {
    public static final boolean a(l3 r100, l3 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$equal");
        if (r100 != r101) goto L6;
        return true;
    L6:
        if ((r101 instanceof l3) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r100.getName(), r101.getName()) == true) goto L11;
    L15:
        return false;
    L11:
        if (r100.getFullSend() != r101.getFullSend()) goto L15;
        if (Intrinsics.areEqual(r100.getSeriesGiftList(), r101.getSeriesGiftList()) == false) goto L15;
        return true;
    }
}
