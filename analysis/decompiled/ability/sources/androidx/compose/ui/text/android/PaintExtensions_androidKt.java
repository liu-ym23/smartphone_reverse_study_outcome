package androidx.compose.ui.text.android;

import C7.i;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.VisibleForTesting;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a+\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\u000b\u001a\u00020\n*\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a+\u0010\u0010\u001a\u00020\u0006*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a3\u0010\u0012\u001a\u00020\n*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroid/text/TextPaint;", "", "text", "", "startInclusive", "endExclusive", "Landroid/graphics/Rect;", "getCharSequenceBounds", "(Landroid/text/TextPaint;Ljava/lang/CharSequence;II)Landroid/graphics/Rect;", "rect", "LC7/r;", "extendWith", "(Landroid/graphics/Rect;Landroid/graphics/Rect;)V", "Landroid/graphics/Paint;", "start", "end", "getStringBounds", "(Landroid/graphics/Paint;Ljava/lang/CharSequence;II)Landroid/graphics/Rect;", "fillStringBounds", "(Landroid/graphics/Paint;Ljava/lang/CharSequence;IILandroid/graphics/Rect;)V", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaintExtensions_androidKt {
    private static final void extendWith(Rect rect, Rect rect2) {
        rect.right = rect2.width() + rect.right;
        rect.top = Math.min(rect.top, rect2.top);
        rect.bottom = Math.max(rect.bottom, rect2.bottom);
    }

    private static final void fillStringBounds(Paint paint, CharSequence charSequence, int i, int i6, Rect rect) {
        Paint29.getTextBounds(paint, charSequence, i, i6, rect);
    }

    public static final Rect getCharSequenceBounds(TextPaint textPaint, CharSequence charSequence, int i, int i6) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            if (SpannedExtensions_androidKt.hasSpan(spanned, MetricAffectingSpan.class, i, i6)) {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                TextPaint textPaint2 = new TextPaint();
                while (i < i6) {
                    int iNextSpanTransition = spanned.nextSpanTransition(i, i6, MetricAffectingSpan.class);
                    MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spanned.getSpans(i, iNextSpanTransition, MetricAffectingSpan.class);
                    textPaint2.set(textPaint);
                    i iVarJ = k.j(metricAffectingSpanArr);
                    while (iVarJ.hasNext()) {
                        MetricAffectingSpan metricAffectingSpan = (MetricAffectingSpan) iVarJ.next();
                        if (spanned.getSpanStart(metricAffectingSpan) != spanned.getSpanEnd(metricAffectingSpan)) {
                            metricAffectingSpan.updateMeasureState(textPaint2);
                        }
                    }
                    fillStringBounds(textPaint2, charSequence, i, iNextSpanTransition, rect2);
                    extendWith(rect, rect2);
                    i = iNextSpanTransition;
                }
                return rect;
            }
        }
        return getStringBounds(textPaint, charSequence, i, i6);
    }

    @VisibleForTesting
    public static final Rect getStringBounds(Paint paint, CharSequence charSequence, int i, int i6) {
        Rect rect = new Rect();
        fillStringBounds(paint, charSequence, i, i6, rect);
        return rect;
    }
}
