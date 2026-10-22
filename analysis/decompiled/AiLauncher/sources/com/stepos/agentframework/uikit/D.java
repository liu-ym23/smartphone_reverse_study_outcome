package com.stepos.agentframework.uikit;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 $2\u00020\u0001:\u0001%B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJo\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010 R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010 R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010!R\u0014\u0010\"\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/stepos/agentframework/uikit/D;", "Landroid/text/style/LeadingMarginSpan;", "", "gutterWidthPx", "codePaddingPx", "color", "", "textSizePx", "<init>", "(IIIF)V", "", AMapLocationStaticsEntity.FIRST_LOCATE, "getLeadingMargin", "(Z)I", "Landroid/graphics/Canvas;", "c", "Landroid/graphics/Paint;", "p", "x", Const.JSON_KEY_DIR, "top", "baseline", "bottom", "", "text", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "Landroid/text/Layout;", "layout", "LY8/t;", "drawLeadingMargin", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;IIIIILjava/lang/CharSequence;IIZLandroid/text/Layout;)V", "I", "F", "numberPaint", "Landroid/graphics/Paint;", "Companion", Const.INTENT_KEY_APIKEY, "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class D implements LeadingMarginSpan {
    private final int codePaddingPx;
    private final int color;
    private final int gutterWidthPx;
    private final Paint numberPaint;
    private final float textSizePx;

    public D(int i10, int i11, int i12, float f10) {
        this.gutterWidthPx = i10;
        this.codePaddingPx = i11;
        this.color = i12;
        this.textSizePx = f10;
        Paint paint = new Paint(1);
        paint.setColor(i12);
        paint.setTextSize(f10);
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextAlign(Paint.Align.RIGHT);
        this.numberPaint = paint;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas c10, Paint p10, int x10, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
        kotlin.jvm.internal.p.i(c10, "c");
        kotlin.jvm.internal.p.i(p10, "p");
        kotlin.jvm.internal.p.i(text, "text");
        kotlin.jvm.internal.p.i(layout, "layout");
        if (text instanceof Spanned) {
            Spanned spanned = (Spanned) text;
            int spanStart = spanned.getSpanStart(this);
            int spanEnd = spanned.getSpanEnd(this);
            if (spanStart < 0 || start < spanStart || start >= spanEnd) {
                return;
            }
            if ((start == spanStart || text.charAt(start - 1) == '\n') && !La.H.x0(text.subSequence(start, spanEnd))) {
                int i10 = 1;
                while (spanStart < start) {
                    if (text.charAt(spanStart) == '\n') {
                        i10++;
                    }
                    spanStart++;
                }
                c10.drawText(String.valueOf(i10), x10 + this.gutterWidthPx, baseline, this.numberPaint);
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        return this.gutterWidthPx + this.codePaddingPx;
    }
}
