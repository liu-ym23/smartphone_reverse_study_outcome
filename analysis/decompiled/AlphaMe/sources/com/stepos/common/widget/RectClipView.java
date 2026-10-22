package com.stepos.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class RectClipView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f11733a;

    public RectClipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11733a = new Rect();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int iSave = canvas.save();
        canvas.clipRect(this.f11733a);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }
}
