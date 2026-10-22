package com.stepos.widget.divider;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010\u001e\u001a\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\"\u0010!\u001a\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/stepos/widget/divider/StepOSDividerPainter;", "", "<init>", "()V", "Landroid/graphics/Canvas;", "canvas", "", "top", "", "spanLeft", "spanRight", "layoutDirection", "alphaScale", "LY8/t;", "draw$StepOSWidget_release", "(Landroid/graphics/Canvas;FIIIF)V", "draw", "width", "drawInView$StepOSWidget_release", "(Landroid/graphics/Canvas;FIIF)V", "drawInView", "thickness", "I", "getThickness$StepOSWidget_release", "()I", "setThickness$StepOSWidget_release", "(I)V", "color", "getColor$StepOSWidget_release", "setColor$StepOSWidget_release", "insetStart", "getInsetStart$StepOSWidget_release", "setInsetStart$StepOSWidget_release", "insetEnd", "getInsetEnd$StepOSWidget_release", "setInsetEnd$StepOSWidget_release", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSDividerPainter {
    private int color;
    private int insetEnd;
    private int insetStart;
    private final Paint paint = new Paint(1);
    private int thickness;

    public static /* synthetic */ void draw$StepOSWidget_release$default(StepOSDividerPainter stepOSDividerPainter, Canvas canvas, float f10, int i10, int i11, int i12, float f11, int i13, Object obj) {
        if ((i13 & 32) != 0) {
            f11 = 1.0f;
        }
        stepOSDividerPainter.draw$StepOSWidget_release(canvas, f10, i10, i11, i12, f11);
    }

    public static /* synthetic */ void drawInView$StepOSWidget_release$default(StepOSDividerPainter stepOSDividerPainter, Canvas canvas, float f10, int i10, int i11, float f11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            f11 = 1.0f;
        }
        stepOSDividerPainter.drawInView$StepOSWidget_release(canvas, f10, i10, i11, f11);
    }

    public final void draw$StepOSWidget_release(Canvas canvas, float top, int spanLeft, int spanRight, int layoutDirection, float alphaScale) {
        p.i(canvas, "canvas");
        if (this.thickness <= 0) {
            return;
        }
        boolean z10 = layoutDirection == 1;
        int i10 = spanLeft + (z10 ? this.insetEnd : this.insetStart);
        int i11 = spanRight - (z10 ? this.insetStart : this.insetEnd);
        if (i11 <= i10) {
            return;
        }
        this.paint.setColor(this.color);
        if (alphaScale < 1.0f) {
            this.paint.setAlpha(C5685n.n((int) (Color.alpha(this.color) * alphaScale), 0, 255));
        }
        canvas.drawRect(i10, top, i11, top + this.thickness, this.paint);
    }

    public final void drawInView$StepOSWidget_release(Canvas canvas, float top, int width, int layoutDirection, float alphaScale) {
        p.i(canvas, "canvas");
        draw$StepOSWidget_release(canvas, top, 0, width, layoutDirection, alphaScale);
    }

    /* renamed from: getColor$StepOSWidget_release, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* renamed from: getInsetEnd$StepOSWidget_release, reason: from getter */
    public final int getInsetEnd() {
        return this.insetEnd;
    }

    /* renamed from: getInsetStart$StepOSWidget_release, reason: from getter */
    public final int getInsetStart() {
        return this.insetStart;
    }

    /* renamed from: getThickness$StepOSWidget_release, reason: from getter */
    public final int getThickness() {
        return this.thickness;
    }

    public final void setColor$StepOSWidget_release(int i10) {
        this.color = i10;
    }

    public final void setInsetEnd$StepOSWidget_release(int i10) {
        this.insetEnd = i10;
    }

    public final void setInsetStart$StepOSWidget_release(int i10) {
        this.insetStart = i10;
    }

    public final void setThickness$StepOSWidget_release(int i10) {
        this.thickness = i10;
    }
}
