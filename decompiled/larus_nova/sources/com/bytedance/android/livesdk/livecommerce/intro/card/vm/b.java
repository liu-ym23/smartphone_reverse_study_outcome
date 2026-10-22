package com.bytedance.android.livesdk.livecommerce.intro.card.vm;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        ((b) r100).getClass();
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
        return 0;
    }

    public final String toString() {
        return "IntroOpenPriceAnimationStateEvent(promotionId=null, productId=null, executionKey=0, isRunning=false)";
    }
}
