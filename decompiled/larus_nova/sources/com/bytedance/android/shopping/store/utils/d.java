package com.bytedance.android.shopping.store.utils;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d {
    public static final int[] a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getGoneViewSize");
        r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new int[]{r100.getMeasuredWidth(), r100.getMeasuredHeight()};
    }
}
