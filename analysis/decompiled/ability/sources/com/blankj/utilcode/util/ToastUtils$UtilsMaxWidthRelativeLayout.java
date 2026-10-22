package com.blankj.utilcode.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/* loaded from: classes2.dex */
public final class ToastUtils$UtilsMaxWidthRelativeLayout extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public static final int f2200a = (int) ((80.0f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);

    public ToastUtils$UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        int i10;
        WindowManager windowManager = (WindowManager) S0.b.X0().getSystemService("window");
        if (windowManager == null) {
            i10 = -1;
        } else {
            Point point = new Point();
            windowManager.getDefaultDisplay().getSize(point);
            i10 = point.x;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i10 - f2200a, Integer.MIN_VALUE), i6);
    }
}
