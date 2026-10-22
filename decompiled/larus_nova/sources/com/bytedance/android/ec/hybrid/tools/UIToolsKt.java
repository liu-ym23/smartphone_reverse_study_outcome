package com.bytedance.android.ec.hybrid.tools;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes44.dex */
public final class UIToolsKt {
    public static final int a(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dp");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        return (int) TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public static final void b(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$removeParent");
        Function1<ViewGroup, Unit> r101 = new UIToolsKt$removeParent$1(r100);
        ViewParent r102 = r100.getParent();
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r102 instanceof ViewGroup) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L12;
        r101.invoke((ViewGroup) r102);
        return;
    }

    public static void c(View r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$setCusScale");
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r103 = null;
    L5:
        final ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        if (r104 != null) goto L8;
        return;
    L8:
        if (d(1.0f, 0, null, new UIToolsKt$setCusScale$1$6(r104), d(1.0f, 0, null, new UIToolsKt$setCusScale$1$5(r104), d(1.0f, r102, null, new UIToolsKt$setCusScale$1$4(r104), d(1.0f, r101, null, new UIToolsKt$setCusScale$1$3(r104), d(1.0f, 0, null, new UIToolsKt$setCusScale$1$2(r104), d(1.0f, 0, null, new UIToolsKt$setCusScale$1$1(r104), false)))))) == false) goto L12;
        r100.requestLayout();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean d(float r100, int r101, Integer r102, MutablePropertyReference0Impl r103, boolean r104) {
        if (r102 == null) goto L4;
        int r105 = r102.intValue();
    L5:
        int r106 = (int) (r105 * r100);
        if (r101 > 0) goto L8;
    L11:
        return r104;
    L8:
        if (r106 == ((Number) r103.get()).intValue()) goto L11;
        r103.set(Integer.valueOf(r106));
        return true;
    L4:
        r105 = r101;
        goto L5
    }
}
