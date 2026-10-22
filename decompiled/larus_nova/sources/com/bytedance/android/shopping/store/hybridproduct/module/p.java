package com.bytedance.android.shopping.store.hybridproduct.module;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class p {
    public static final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$visibleWithHeight");
        r100.setVisibility(0);
        r100.setAlpha(1.0f);
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        r102.height = RangesKt.coerceAtLeast(r101, 0);
        Unit r103 = Unit.INSTANCE;
        r100.setLayoutParams(r102);
        r100.requestLayout();
    }
}
