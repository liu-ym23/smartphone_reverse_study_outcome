package com.bytedance.android.livesdk.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes8.dex */
public class EllipsizeLayout extends LinearLayout {
    public EllipsizeLayout(Context r100) {
        this(r100, null);
    }

    public EllipsizeLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        if (getOrientation() != 0) goto L41;
        if (View.MeasureSpec.getMode(r110) != 1073741824) goto L41;
        int r100 = getChildCount();
        int r101 = 0;
        TextView r102 = null;
        int r103 = 0;
        boolean r104 = false;
        int r105 = 0;
    L7:
        boolean r106 = true;
        if (r103 >= r100) goto L28;
        if (r104 == true) goto L28;
        View r112 = getChildAt(r103);
        if (r112 == null) goto L26;
        if (r112.getVisibility() == 8) goto L26;
        if ((r112 instanceof TextView) == false) goto L21;
        TextView r107 = (TextView) r112;
        if (r107.getEllipsize() == null) goto L21;
        if (r102 != null) goto L20;
        r107.setMaxWidth(Integer.MAX_VALUE);
        r102 = r107;
        goto L21
    L20:
        r104 = true;
    L21:
        LinearLayout.LayoutParams r113 = (LinearLayout.LayoutParams) r112.getLayoutParams();
        if (r113.weight > 0.0f) goto L25;
        r106 = false;
    L25:
        r104 = r104 | r106;
        measureChildWithMargins(r112, r110, 0, r111, 0);
        r105 = r105 + ((r112.getMeasuredWidth() + r113.leftMargin) + r113.rightMargin);
    L26:
        r103 = r103 + 1;
    L28:
        if (r102 == null) goto L32;
        if (r105 == 0) goto L32;
        r106 = false;
    L32:
        boolean r108 = r104 | r106;
        int r109 = View.MeasureSpec.getSize(r110);
        if (r108 == true) goto L41;
        if (r105 <= r109) goto L41;
        int r114 = r102.getMeasuredWidth() - (r105 - r109);
        if (r114 < 0) goto L39;
        r101 = r114;
    L39:
        r102.setMaxWidth(r101);
    L41:
        super.onMeasure(r110, r111);
    }

    public EllipsizeLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
