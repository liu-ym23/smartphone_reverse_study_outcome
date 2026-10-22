package com.obric.oui.indicator;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IndicatorExternals.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static final void a(View r1, int r2) {
        o.e(r1, "<this>");
        r1.getLayoutParams().width = r2;
        r1.requestLayout();
    }

    public static final void b(View r7, int r8) {
        o.e(r7, "<this>");
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        ViewGroup.LayoutParams r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L25;
        ViewGroup.LayoutParams r3 = r7.getLayoutParams();
        int r5 = 0;
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L11;
        int r4 = androidx.core.view.g.a((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"));
    L12:
        ViewGroup.LayoutParams r6 = r7.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.MarginLayoutParams.class) == false) goto L16;
        r2 = r6;
    L16:
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L19;
        int r10 = r9.topMargin;
    L20:
        ViewGroup.LayoutParams r11 = r7.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r11, ViewGroup.MarginLayoutParams.class) == false) goto L23;
        r5 = androidx.core.view.g.b((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"));
    L23:
        r1.setMargins(r4, r10, r5, r8);
        r7.requestLayout();
        return;
    L19:
        r10 = 0;
        goto L20
    L11:
        r4 = 0;
        goto L12
    L25:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final void c(View r4, int r5) {
        o.e(r4, "<this>");
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        ViewGroup.MarginLayoutParams r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L9;
        r1.setMarginStart(r5);
        r1.setMarginEnd(r5);
        r4.requestLayout();
        r3 = r1;
    L9:
        r4.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final boolean a(ViewPager r1) {
        o.e(r1, "<this>");
        androidx.viewpager.widget.a r2 = r1.getAdapter();
        if (r2 != null) goto L5;
        int r3 = 0;
    L6:
        if (r3 <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r3 = r2.a();
        goto L6
    }
}
