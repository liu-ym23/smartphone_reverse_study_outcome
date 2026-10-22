package com.obric.oui.slider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BackgroundDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BackgroundDrawable extends Drawable {
    private final Paint backgroundPaint;
    private int defaultHeight;
    private int margin;
    private int radius;
    private int tickMarkCount;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }

    public BackgroundDrawable(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        this.tickMarkCount = 3;
        this.defaultHeight = g.a(r6, 8);
        this.margin = g.a(r6, 14);
        this.radius = g.a(r6, 16);
        this.tickMarkCount = 3;
        Paint r0 = new Paint();
        r0.setColor(androidx.core.content.a.c(r6, ZeusTransformUtils.mapRes(R.color.oui_fill_sunken_variable, "color", "oui_fill_sunken_variable")));
        r0.setStyle(Paint.Style.FILL);
        this.backgroundPaint = r0;
    }

    public final void setTickMarkCount(int r1) {
        this.tickMarkCount = r1;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r18) {
        o.e(r18, "canvas");
        Rect r2 = getBounds();
        o.c(r2, "bounds");
        float r3 = r2.left;
        float r4 = r2.top;
        int r5 = r2.right;
        float r6 = r2.bottom;
        int r7 = r2.width();
        r2.height();
        int r8 = this.margin;
        int r9 = this.tickMarkCount;
        int r10 = (r7 - (r9 * r8)) / (r9 + 1);
        if (r9 < 0) goto L9;
        char r11 = 0;
        int r12 = 0;
    L5:
        int r13 = r12 + 1;
        float r14 = ((r10 + r8) * r12) + r3;
        RectF r15 = new RectF(r14, r4, r10 + r14, r6);
        Path r16 = new Path();
        float[] r17 = new float[8];
        int r19 = this.radius;
        r17[r11] = r19;
        r17[1] = r19;
        r17[2] = r19;
        r17[3] = r19;
        r17[4] = r19;
        r17[5] = r19;
        r17[6] = r19;
        r17[7] = r19;
        r16.addRoundRect(r15, r17, Path.Direction.CW);
        r18.drawPath(r16, this.backgroundPaint);
        if (r12 == r9) goto L11;
        r12 = r13;
        r11 = 0;
        goto L5
    L11:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r1) {
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.defaultHeight;
    }
}
