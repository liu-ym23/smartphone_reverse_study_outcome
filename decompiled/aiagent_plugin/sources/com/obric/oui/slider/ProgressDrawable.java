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

/* JADX INFO: compiled from: ProgressDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ProgressDrawable extends Drawable {
    private final Paint backgroundPaint;
    private float cornerRadius;
    private int defaultHeight;
    private int defaultMargin;
    private Drawable imageIcon;
    private boolean imageIconVisibility;
    private Context mContext;
    private final Paint processPaint;
    private float smallCornerRadius;

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

    public ProgressDrawable(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        this.defaultHeight = g.a(r6, 8);
        this.defaultMargin = g.a(r6, 6);
        this.cornerRadius = g.b(r6, 16);
        this.smallCornerRadius = g.b(r6, 1);
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.imageIcon = androidx.core.content.a.a(r6, ZeusTransformUtils.mapRes(R.drawable.o_slider_audio_white_icon, "drawable", "o_slider_audio_white_icon"));
        Paint r0 = new Paint();
        r0.setColor(androidx.core.content.a.c(r6, ZeusTransformUtils.mapRes(R.color.oui_accent_bg, "color", "oui_accent_bg")));
        r0.setStyle(Paint.Style.FILL);
        this.processPaint = r0;
        Paint r1 = new Paint();
        r1.setColor(androidx.core.content.a.c(r6, ZeusTransformUtils.mapRes(R.color.oui_line_2, "color", "oui_line_2")));
        r1.setStyle(Paint.Style.FILL);
        this.backgroundPaint = r1;
    }

    public final void setDefaultMargin(int r1) {
        this.defaultMargin = r1;
        invalidateSelf();
    }

    public final void setProcessColor(int r2) {
        this.processPaint.setColor(androidx.core.content.a.c(this.mContext, r2));
    }

    public final void setBackGroundColor(int r2) {
        this.backgroundPaint.setColor(androidx.core.content.a.c(this.mContext, r2));
    }

    public final void setDefaultHeight(int r4) {
        this.defaultHeight = r4;
        if (r4 < g.a(this.mContext, 32)) goto L6;
        setCornerRadius(g.b(this.mContext, 8));
    L10:
        if (r4 != g.a(this.mContext, 6)) goto L12;
        setProcessColor(ZeusTransformUtils.mapRes(R.color.oui_text_1, "color", "oui_text_1"));
    L13:
        invalidateSelf();
        return;
    L12:
        setProcessColor(ZeusTransformUtils.mapRes(R.color.oui_accent_bg, "color", "oui_accent_bg"));
        goto L13
    L6:
        if (r4 <= g.a(this.mContext, 6)) goto L8;
        setCornerRadius(r4 / 2.0f);
        goto L10
    L8:
        setCornerRadius(g.b(this.mContext, 4));
        goto L10
    }

    public final void setImageIcon(Drawable r2) {
        o.e(r2, "imageIcon");
        this.imageIcon = r2;
        invalidateSelf();
    }

    public final void hideImageIcon() {
        this.imageIconVisibility = false;
        invalidateSelf();
    }

    public final void showImageIcon() {
        this.imageIconVisibility = true;
        invalidateSelf();
    }

    private final void setCornerRadius(float r1) {
        this.cornerRadius = r1;
    }

    private final void drawImageIcon(Canvas r9) {
        if (this.imageIcon != null) goto L5;
        return;
    L5:
        if (this.imageIconVisibility == false) goto L16;
        Rect r0 = getBounds();
        o.c(r0, "bounds");
        int r1 = r0.left;
        int r2 = r0.top;
        int r3 = r0.right;
        int r4 = r0.bottom;
        Rect r5 = new Rect(g.a(this.mContext, 8) + r1, r2 + g.a(this.mContext, 8), r1 + g.a(this.mContext, 32), r4 - g.a(this.mContext, 8));
        Drawable r6 = this.imageIcon;
        if (r6 == null) goto L10;
        r6.setBounds(r5);
    L10:
        Drawable r8 = this.imageIcon;
        if (r8 == null) goto L17;
        r8.draw(r9);
        return;
    L17:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r21) {
        o.e(r21, "canvas");
        Rect r2 = getBounds();
        o.c(r2, "bounds");
        float r3 = r2.left;
        float r4 = r2.top;
        float r5 = r2.right;
        float r6 = r2.bottom;
        int r7 = r2.width();
        r2.height();
        r21.drawColor(0);
        float r8 = (getLevel() * r7) / 10000.0f;
        int r9 = this.defaultMargin;
        float r11 = 0.0f;
        if ((r8 - r9) < 0.0f) goto L7;
        r11 = r8 - r9;
    L7:
        if ((r9 + r8) <= r5) goto L9;
        float r10 = r7;
    L10:
        RectF r12 = new RectF(r3, r4, r11 + r3, r6);
        Path r13 = new Path();
        float r14 = this.cornerRadius;
        float r15 = this.smallCornerRadius;
        r13.addRoundRect(r12, new float[]{r14, r14, r15, r15, r15, r15, r14, r14}, Path.Direction.CW);
        r21.drawPath(r13, this.processPaint);
        RectF r16 = new RectF(r3 + r10, r4, r5, r6);
        Path r17 = new Path();
        float r18 = this.smallCornerRadius;
        float r19 = this.cornerRadius;
        r17.addRoundRect(r16, new float[]{r18, r18, r19, r19, r19, r19, r18, r18}, Path.Direction.CW);
        r21.drawPath(r17, this.backgroundPaint);
        drawImageIcon(r21);
        return;
    L9:
        r10 = r9 + r8;
        goto L10
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
