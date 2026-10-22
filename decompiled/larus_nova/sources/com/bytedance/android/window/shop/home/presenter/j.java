package com.bytedance.android.window.shop.home.presenter;

import kotlin.Pair;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public abstract class j extends AbsECWindowPresenter {
    @Override // com.bytedance.android.window.shop.home.presenter.AbsECWindowPresenter
    public final float E() {
        return 1.0f;
    }

    public j() {
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsECWindowPresenter
    public final float Y(int r100) {
        if (r100 > 0) goto L5;
        return 0.0f;
    L5:
        Pair<Integer, Integer> r101 = O().getOffsetState().getValue();
        if (r101 == null) goto L16;
        int r102 = Math.abs(r101.getFirst().intValue());
        if (O().isCroppedStyle() == false) goto L15;
        if (r102 <= W()) goto L13;
        r102 = r102 - W();
        goto L15
    L13:
        r102 = 0;
    L15:
        return RangesKt.coerceAtMost(r102 / r100, 1.0f);
    L16:
        return 0.0f;
    }

    public final float Z(int r100) {
        Pair<Integer, Integer> r101 = O().getOffsetState().getValue();
        if (r101 != null) goto L7;
        return 0.0f;
    L7:
        return RangesKt.coerceAtMost(Math.abs(r101.getFirst().intValue()) / r100, 1.0f);
    }
}
