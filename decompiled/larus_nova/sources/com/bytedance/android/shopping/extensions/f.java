package com.bytedance.android.shopping.extensions;

import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {
    public static void a(ViewGroup r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$addViewWithMatchMatchLayoutParams");
        Intrinsics.checkNotNullParameter(r101, "view");
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r100.addView(r101);
    }

    public static void b(ViewGroup r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$addViewWithMatchWrapLayoutParams");
        Intrinsics.checkNotNullParameter(r101, "view");
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r100.addView(r101);
    }

    public static final void e(TextView r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setTextWeight");
        if (r101 != null) goto L5;
        r100.getPaint().setStrokeWidth(0.0f);
        r100.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        return;
    L5:
        r100.getPaint().setStrokeWidth((Math.max(400, r101.intValue()) - 400) / 150);
        r100.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public static final void c(ViewGroup r100, View r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$addViewWithWrapMatchLayoutParams");
        Intrinsics.checkNotNullParameter(r101, "view");
        r101.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        if (r102 == null) goto L5;
        r100.addView(r101, r102.intValue());
        return;
    L5:
        r100.addView(r101);
    }

    public static final void d(LinearLayout r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$setEmptyDivider");
        ShapeDrawable r103 = new ShapeDrawable();
        r103.getPaint().setColor(0);
        r100.setShowDividers(r102);
        r103.setIntrinsicWidth(r101);
        Unit r104 = Unit.INSTANCE;
        r100.setDividerDrawable(r103);
    }
}
