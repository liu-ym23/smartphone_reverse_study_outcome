package com.stepos.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes3.dex */
public class RectClipView extends LinearLayout {
    private Rect mRect;

    public RectClipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRect = new Rect();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int iSave = canvas.save();
        canvas.clipRect(this.mRect);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }
}
