package com.bytedance.android.livesdk.gift.platform.core.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a0 {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a0) == false) goto L10;
        ((a0) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(null, null) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (((((int) 0) * 31) + 0) * 31) + 0;
    }

    public final String toString() {
        return "RecommendFastGiftEvent(giftId=0, scene=null, logExtra=null)";
    }
}
