package com.bytedance.android.live.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.Layout;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes45.dex */
public class GradientEditText extends LiveEditText {
    private float getMaxLineRight() {
        Layout r100 = getLayout();
        float r101 = 0.0f;
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        int r102 = 0;
    L7:
        if (r102 >= r100.getLineCount()) goto L9;
        r101 = Math.max(r101, r100.getLineRight(r102));
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    public GradientEditText(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    @Override // android.widget.TextView
    public void setTextColor(int r100) {
        getPaint().setShader(null);
        super.setTextColor(r100);
    }

    public GradientEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
        new Matrix();
        c(r101);
    }

    public GradientEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        new Matrix();
    }
}
