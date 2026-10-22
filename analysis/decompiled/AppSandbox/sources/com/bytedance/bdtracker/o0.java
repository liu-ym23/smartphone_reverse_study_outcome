package com.bytedance.bdtracker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class o0 extends p0 {
    public final Paint b;

    public o0(Drawable drawable) {
        super(drawable);
        Paint paint = new Paint();
        this.b = paint;
        paint.setColor(-256);
        paint.setStrokeWidth(8.0f);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        canvas.drawRect(new Rect(0, 0, canvas.getWidth(), canvas.getHeight()), this.b);
    }
}
