package com.stepos.agentframework.uikit;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.style.LineBackgroundSpan;
import android.text.style.LineHeightSpan;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJg\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJA\u0010#\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010%R\u0014\u0010\u0005\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010%R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010&R\u0014\u0010\b\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010%R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010&R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010&R\u0014\u0010\u000b\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010%R\u0014\u0010'\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/stepos/agentframework/uikit/x;", "Landroid/text/style/LineBackgroundSpan;", "Landroid/text/style/LineHeightSpan;", "", "headerBackgroundColor", "bodyBackgroundColor", "", "radiusPx", "headerHeightPx", "bodyBottomPaddingPx", "bodyTopPaddingPx", "codeStartOffset", "<init>", "(IIFIFFI)V", "Landroid/graphics/Canvas;", "canvas", "Landroid/graphics/Paint;", "paint", "left", "right", "top", "baseline", "bottom", "", "text", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "lineNumber", "LY8/t;", "drawBackground", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;IIIIILjava/lang/CharSequence;III)V", "spanStartv", "spanEndv", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "chooseHeight", "(Ljava/lang/CharSequence;IIIILandroid/graphics/Paint$FontMetricsInt;)V", "I", "F", "headerPaint", "Landroid/graphics/Paint;", "bodyPaint", "Landroid/graphics/RectF;", "rect", "Landroid/graphics/RectF;", "Landroid/graphics/Path;", "path", "Landroid/graphics/Path;", "", "radii", "[F", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.uikit.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2149x implements LineBackgroundSpan, LineHeightSpan {
    private final int bodyBackgroundColor;
    private final float bodyBottomPaddingPx;
    private final Paint bodyPaint;
    private final float bodyTopPaddingPx;
    private final int codeStartOffset;
    private final int headerBackgroundColor;
    private final int headerHeightPx;
    private final Paint headerPaint;
    private final Path path;
    private final float[] radii;
    private final float radiusPx;
    private final RectF rect;

    public C2149x(int i10, int i11, float f10, int i12, float f11, float f12, int i13) {
        this.headerBackgroundColor = i10;
        this.bodyBackgroundColor = i11;
        this.radiusPx = f10;
        this.headerHeightPx = i12;
        this.bodyBottomPaddingPx = f11;
        this.bodyTopPaddingPx = f12;
        this.codeStartOffset = i13;
        Paint paint = new Paint(1);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setColor(i10);
        this.headerPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(style);
        paint2.setColor(i11);
        this.bodyPaint = paint2;
        this.rect = new RectF();
        this.path = new Path();
        this.radii = new float[8];
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int start, int end, int spanStartv, int spanEndv, Paint.FontMetricsInt fm) {
        int i10;
        kotlin.jvm.internal.p.i(text, "text");
        if (fm == null || !(text instanceof Spanned)) {
            return;
        }
        Spanned spanned = (Spanned) text;
        int spanStart = spanned.getSpanStart(this);
        int spanEnd = spanned.getSpanEnd(this);
        boolean z10 = start <= spanStart;
        boolean z11 = end >= spanEnd;
        if (!z10) {
            fm.descent -= 3;
            fm.bottom -= 3;
        }
        if (!z10 && (i10 = this.codeStartOffset) > 0 && start <= i10 && end > i10) {
            int i11 = (int) this.bodyTopPaddingPx;
            fm.ascent -= i11;
            fm.top -= i11;
        }
        if (z11) {
            int i12 = fm.descent;
            float f10 = this.bodyBottomPaddingPx;
            fm.descent = i12 + ((int) f10);
            fm.bottom += (int) f10;
        }
    }

    @Override // android.text.style.LineBackgroundSpan
    public void drawBackground(Canvas canvas, Paint paint, int left, int right, int top, int baseline, int bottom, CharSequence text, int start, int end, int lineNumber) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        kotlin.jvm.internal.p.i(paint, "paint");
        kotlin.jvm.internal.p.i(text, "text");
        if (text instanceof Spanned) {
            Spanned spanned = (Spanned) text;
            int spanStart = spanned.getSpanStart(this);
            int spanEnd = spanned.getSpanEnd(this);
            boolean z10 = start <= spanStart;
            boolean z11 = end >= spanEnd;
            float f10 = left;
            float f11 = right;
            float f12 = top;
            if (z10) {
                canvas.drawRect(f10, f12, f11, bottom, this.bodyPaint);
                return;
            }
            if (!z11) {
                canvas.drawRect(f10, f12, f11, bottom, this.bodyPaint);
                return;
            }
            this.rect.set(f10, f12, f11, bottom);
            float[] fArr = this.radii;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            float f13 = this.radiusPx;
            fArr[4] = f13;
            fArr[5] = f13;
            fArr[6] = f13;
            fArr[7] = f13;
            this.path.reset();
            this.path.addRoundRect(this.rect, this.radii, Path.Direction.CW);
            canvas.drawPath(this.path, this.bodyPaint);
        }
    }
}
