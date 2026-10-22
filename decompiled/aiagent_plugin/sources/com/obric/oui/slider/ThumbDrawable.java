package com.obric.oui.slider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ThumbDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ThumbDrawable extends Drawable {
    private int curHeight;
    private int defaultHeight;
    private int defaultMaxHeight;
    private int defaultWidth;
    private boolean isPressed;
    private Context mContext;
    private final Paint paint;
    private int thumbIntrinsicHeight;
    private float thumbRadius;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    public ThumbDrawable(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        this.thumbIntrinsicHeight = r5;
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        Paint r7 = new Paint();
        r7.setColor(androidx.core.content.a.c(r6, ZeusTransformUtils.mapRes(R.color.oui_accent_bg, "color", "oui_accent_bg")));
        r7.setStyle(Paint.Style.FILL);
        r7.setAntiAlias(true);
        this.paint = r7;
        this.defaultHeight = g.a(r6, 16);
        this.defaultMaxHeight = g.a(r6, 24);
        this.curHeight = this.defaultHeight;
        this.defaultWidth = g.a(r6, 4);
        this.thumbRadius = g.b(r6, 8);
    }

    public /* synthetic */ ThumbDrawable(Context r2, int r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = g.a(r6, 48);
    L5:
        this(r6, r3);
    }

    public final int getThumbIntrinsicHeight() {
        return this.thumbIntrinsicHeight;
    }

    public final void setThumbIntrinsicHeight(int r1) {
        this.thumbIntrinsicHeight = r1;
    }

    public final void setDefaultHeight(int r6, int r7) {
        this.defaultHeight = r6;
        if (r6 != g.a(this.mContext, 14)) goto L5;
        this.paint.setColor(androidx.core.content.a.c(this.mContext, ZeusTransformUtils.mapRes(R.color.oui_text_1, "color", "oui_text_1")));
    L6:
        this.defaultMaxHeight = r7;
        this.curHeight = r6;
        invalidateSelf();
        return;
    L5:
        this.paint.setColor(androidx.core.content.a.c(this.mContext, ZeusTransformUtils.mapRes(R.color.oui_accent_bg, "color", "oui_accent_bg")));
        goto L6
    }

    public final void setThumbColor(int r3) {
        this.paint.setColor(androidx.core.content.a.c(this.mContext, r3));
        invalidateSelf();
    }

    public final void setDefaultWidth(int r1) {
        this.defaultWidth = r1;
        invalidateSelf();
    }

    public final void setPressed(boolean r1) {
        this.isPressed = r1;
        if (r1 == false) goto L5;
        this.curHeight = this.defaultMaxHeight;
    L6:
        invalidateSelf();
        return;
    L5:
        this.curHeight = this.defaultHeight;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.thumbIntrinsicHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r7) {
        o.e(r7, "canvas");
        Rect r0 = getBounds();
        o.c(r0, "bounds");
        int r1 = (r0.height() - this.curHeight) / 2;
        RectF r2 = new RectF(r0.left, r1, r0.right, r1 + this.curHeight);
        float r3 = this.thumbRadius;
        r7.drawRoundRect(r2, r3, r3, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.paint.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.paint.setColorFilter(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.defaultWidth;
    }
}
