package com.stepos.agentframework.uikit;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ;\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018JW\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010!R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\"R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\"R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010#R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010#R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010$R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010#R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\"R\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010#R\u0014\u0010%\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/stepos/agentframework/uikit/C;", "Landroid/text/style/ReplacementSpan;", "", "textColor", "heightPx", "", "leftPaddingPx", "textSizePx", "", "bold", "bottomPaddingPx", "backgroundColor", "radiusPx", "<init>", "(IIFFZFIF)V", "Landroid/graphics/Paint;", "paint", "", "text", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "(Landroid/graphics/Paint;Ljava/lang/CharSequence;IILandroid/graphics/Paint$FontMetricsInt;)I", "Landroid/graphics/Canvas;", "canvas", "x", "top", "y", "bottom", "LY8/t;", "draw", "(Landroid/graphics/Canvas;Ljava/lang/CharSequence;IIFIIILandroid/graphics/Paint;)V", "I", "F", "Z", "textPaint", "Landroid/graphics/Paint;", "bgPaint", "Landroid/graphics/Path;", "bgPath", "Landroid/graphics/Path;", "Landroid/graphics/RectF;", "bgRect", "Landroid/graphics/RectF;", "", "radii", "[F", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class C extends ReplacementSpan {
    private final int backgroundColor;
    private final Paint bgPaint;
    private final Path bgPath;
    private final RectF bgRect;
    private final boolean bold;
    private final float bottomPaddingPx;
    private final int heightPx;
    private final float leftPaddingPx;
    private final float[] radii;
    private final float radiusPx;
    private final int textColor;
    private final Paint textPaint;
    private final float textSizePx;

    public C(int i10, int i11, float f10, float f11, boolean z10, float f12, int i12, float f13) {
        this.textColor = i10;
        this.heightPx = i11;
        this.leftPaddingPx = f10;
        this.textSizePx = f11;
        this.bold = z10;
        this.bottomPaddingPx = f12;
        this.backgroundColor = i12;
        this.radiusPx = f13;
        Paint paint = new Paint(1);
        paint.setColor(i10);
        paint.setTextSize(f11);
        paint.setTypeface(z10 ? MarkwonHelper.z0(C2145t.b()) : Typeface.MONOSPACE);
        paint.setFakeBoldText(false);
        this.textPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(i12);
        this.bgPaint = paint2;
        this.bgPath = new Path();
        this.bgRect = new RectF();
        this.radii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x10, int top, int y10, int bottom, Paint paint) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        kotlin.jvm.internal.p.i(text, "text");
        kotlin.jvm.internal.p.i(paint, "paint");
        if (this.backgroundColor != 0) {
            kotlin.jvm.internal.p.h(canvas.getClipBounds(), "getClipBounds(...)");
            this.bgRect.set(r7.left, top, r7.right, bottom);
            float[] fArr = this.radii;
            float f10 = this.radiusPx;
            fArr[0] = f10;
            fArr[1] = f10;
            fArr[2] = f10;
            fArr[3] = f10;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            this.bgPath.reset();
            this.bgPath.addRoundRect(this.bgRect, this.radii, Path.Direction.CW);
            canvas.drawPath(this.bgPath, this.bgPaint);
        }
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        canvas.drawText(text.subSequence(start, end).toString(), this.leftPaddingPx, ((top + bottom) / 2.0f) - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.textPaint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        kotlin.jvm.internal.p.i(paint, "paint");
        if (fm == null) {
            return 0;
        }
        int i10 = this.heightPx;
        int i11 = -((i10 * 3) / 4);
        int i12 = i10 + i11;
        fm.ascent = i11;
        fm.top = i11;
        float f10 = this.bottomPaddingPx;
        fm.descent = ((int) f10) + i12;
        fm.bottom = i12 + ((int) f10);
        return 0;
    }
}
