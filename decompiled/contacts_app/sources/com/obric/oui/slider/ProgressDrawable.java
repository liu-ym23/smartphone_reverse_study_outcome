package com.obric.oui.slider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProgressDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\u0006\u0010\u0019\u001a\u00020\u0013J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\nH\u0014J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\nJ\u0012\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\bH\u0002J\u000e\u0010%\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010'\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0001J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010)\u001a\u00020\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/oui/slider/ProgressDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "backgroundPaint", "Landroid/graphics/Paint;", "cornerRadius", "", "defaultHeight", "", "defaultMargin", "imageIcon", "imageIconVisibility", "", "mContext", "processPaint", "smallCornerRadius", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawImageIcon", "getIntrinsicHeight", "getOpacity", "hideImageIcon", "onLevelChange", "level", "setAlpha", "alpha", "setBackGroundColor", "colorResId", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setCornerRadius", "radius", "setDefaultHeight", "setDefaultMargin", "setImageIcon", "setProcessColor", "showImageIcon", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public ProgressDrawable(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.defaultHeight = OUnitExtensionKt.cdp(r3, 8);
        this.defaultMargin = OUnitExtensionKt.cdp(r3, 6);
        this.cornerRadius = OUnitExtensionKt.cdpFloat(r3, 16);
        this.smallCornerRadius = OUnitExtensionKt.cdpFloat(r3, 1);
        this.mContext = r3;
        this.imageIcon = ContextCompat.getDrawable(r3, R.drawable.o_slider_audio_white_icon);
        Paint r0 = new Paint();
        r0.setColor(ContextCompat.getColor(r3, R.color.oui_accent_bg));
        r0.setStyle(Paint.Style.FILL);
        this.processPaint = r0;
        Paint r1 = new Paint();
        r1.setColor(ContextCompat.getColor(r3, R.color.oui_line_2));
        r1.setStyle(Paint.Style.FILL);
        this.backgroundPaint = r1;
    }

    public final void setDefaultMargin(int r1) {
        this.defaultMargin = r1;
        invalidateSelf();
    }

    public final void setProcessColor(int r2) {
        this.processPaint.setColor(ContextCompat.getColor(this.mContext, r2));
    }

    public final void setBackGroundColor(int r2) {
        this.backgroundPaint.setColor(ContextCompat.getColor(this.mContext, r2));
    }

    public final void setDefaultHeight(int r4) {
        this.defaultHeight = r4;
        if (r4 < OUnitExtensionKt.cdp(this.mContext, 32)) goto L6;
        setCornerRadius(OUnitExtensionKt.cdpFloat(this.mContext, 8));
    L10:
        if (r4 != OUnitExtensionKt.cdp(this.mContext, 6)) goto L12;
        setProcessColor(R.color.oui_text_1);
    L13:
        invalidateSelf();
        return;
    L12:
        setProcessColor(R.color.oui_accent_bg);
        goto L13
    L6:
        if (r4 <= OUnitExtensionKt.cdp(this.mContext, 6)) goto L8;
        setCornerRadius(r4 / 2.0f);
        goto L10
    L8:
        setCornerRadius(OUnitExtensionKt.cdpFloat(this.mContext, 4));
        goto L10
    }

    public final void setImageIcon(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "imageIcon");
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
        Intrinsics.checkNotNullExpressionValue(r0, "bounds");
        int r1 = r0.left;
        int r2 = r0.top;
        int r3 = r0.right;
        int r4 = r0.bottom;
        Rect r5 = new Rect(OUnitExtensionKt.cdp(this.mContext, 8) + r1, r2 + OUnitExtensionKt.cdp(this.mContext, 8), r1 + OUnitExtensionKt.cdp(this.mContext, 32), r4 - OUnitExtensionKt.cdp(this.mContext, 8));
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
        Intrinsics.checkNotNullParameter(r21, "canvas");
        Rect r2 = getBounds();
        Intrinsics.checkNotNullExpressionValue(r2, "bounds");
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
    protected boolean onLevelChange(int r1) {
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.defaultHeight;
    }
}
