package com.bytedance.android.gamecp.business.gamedetail.component;

import android.content.Context;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.gamecp.common.utils.d1;
import com.bytedance.android.gamecp.common.utils.y0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {
    public static final void a(ConstraintLayout r100, boolean r101, Context r102, int r103) {
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100 == null) goto L18;
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();
        if (r104 == null) goto L17;
        ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r104;
        if (r101 == false) goto L15;
        ((ViewGroup.MarginLayoutParams) r105).topMargin = y0.b(8.0f);
        if (d1.c(r102) == true) goto L11;
    L13:
        ((ViewGroup.MarginLayoutParams) r105).bottomMargin = y0.b(8.0f);
    L14:
        r100.setLayoutParams(r105);
        return;
    L11:
        if (vt.c.a() == false) goto L13;
        ((ViewGroup.MarginLayoutParams) r105).bottomMargin = y0.b(34.0f);
        goto L14
    L15:
        ((ViewGroup.MarginLayoutParams) r105).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) r105).bottomMargin = r103;
        r100.setLayoutParams(r105);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }
}
