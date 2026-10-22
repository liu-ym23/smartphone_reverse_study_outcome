package com.stepos.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class RectClipView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f6979a;

    public RectClipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6979a = new Rect();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int iSave = canvas.save();
        canvas.clipRect(this.f6979a);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }
}
