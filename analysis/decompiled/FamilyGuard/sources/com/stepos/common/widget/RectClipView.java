package com.stepos.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class RectClipView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Rect f14084a;

    public RectClipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14084a = new Rect();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int iSave = canvas.save();
        canvas.clipRect(this.f14084a);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }
}
