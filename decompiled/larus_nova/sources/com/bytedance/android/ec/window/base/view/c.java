package com.bytedance.android.ec.window.base.view;

import android.view.ViewGroup;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {
    public static final void a(ECDraweeView r100, ECUrlModel r110) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        r101.width = -2;
        if (r110 == null) goto L5;
        int r102 = r110.getHeight();
    L6:
        r101.height = r100.getDp(Integer.valueOf(r102));
        Unit r103 = Unit.INSTANCE;
        r100.setLayoutParams(r101);
        Intrinsics.checkNotNullParameter(h0.f44678a, "$this$bindImage");
        Intrinsics.checkNotNullParameter(r100, "draweeView");
        h0.d(r100, r110, new r("redundancy", "redundancy", "redundancy"), null, null, null, null, 120);
        return;
    L5:
        r102 = 14;
        goto L6
    }
}
