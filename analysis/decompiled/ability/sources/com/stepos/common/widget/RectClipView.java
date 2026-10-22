package com.stepos.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class RectClipView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f3739a;

    public RectClipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3739a = new Rect();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int iSave = canvas.save();
        canvas.clipRect(this.f3739a);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }
}
