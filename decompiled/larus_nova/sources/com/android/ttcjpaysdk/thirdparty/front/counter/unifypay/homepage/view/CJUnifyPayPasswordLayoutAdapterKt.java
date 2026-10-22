package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.view;

import android.graphics.Rect;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"isNear", "", "Landroid/graphics/Rect;", "other", "tolerance", "", "bdpay-front-counter_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayPasswordLayoutAdapterKt {
    public static final /* synthetic */ boolean access$isNear(Rect r100, Rect r101, int r102) {
        return isNear(r100, r101, r102);
    }

    private static final boolean isNear(Rect r100, Rect r101, int r102) {
        if (Math.abs(r100.left - r101.left) <= r102) goto L5;
    L11:
        return false;
    L5:
        if (Math.abs(r100.top - r101.top) > r102) goto L11;
        if (Math.abs(r100.right - r101.right) > r102) goto L11;
        if (Math.abs(r100.bottom - r101.bottom) > r102) goto L11;
        return true;
    }
}
