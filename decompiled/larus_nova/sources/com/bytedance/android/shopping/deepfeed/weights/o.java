package com.bytedance.android.shopping.deepfeed.weights;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class o {
    public static final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$updateLayoutParamsHeight");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 != null) goto L5;
        return;
    L5:
        com.bytedance.android.shopping.deepfeed.ui.view.a r103 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r102.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r100.getContext(), r101);
        r100.setLayoutParams(r102);
    }
}
