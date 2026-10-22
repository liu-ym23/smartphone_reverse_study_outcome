package t1;

import android.graphics.Rect;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import q7.k;

/* loaded from: classes.dex */
public abstract class e {
    public static StaticLayout a(CharSequence charSequence, TextPaint textPaint, int i2, int i10, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i11, TextUtils.TruncateAt truncateAt, int i12, int i13, boolean z4, int i14, int i15, int i16, int i17) {
        if (i10 < 0) {
            x1.a.a("invalid start value");
        }
        int length = charSequence.length();
        if (i10 < 0 || i10 > length) {
            x1.a.a("invalid end value");
        }
        if (i11 < 0) {
            x1.a.a("invalid maxLines value");
        }
        if (i2 < 0) {
            x1.a.a("invalid width value");
        }
        if (i12 < 0) {
            x1.a.a("invalid ellipsizedWidth value");
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, i10, textPaint, i2);
        builderObtain.setTextDirection(textDirectionHeuristic);
        builderObtain.setAlignment(alignment);
        builderObtain.setMaxLines(i11);
        builderObtain.setEllipsize(truncateAt);
        builderObtain.setEllipsizedWidth(i12);
        builderObtain.setLineSpacing(0.0f, 1.0f);
        builderObtain.setIncludePad(z4);
        builderObtain.setBreakStrategy(i14);
        builderObtain.setHyphenationFrequency(i17);
        builderObtain.setIndents(null, null);
        int i18 = Build.VERSION.SDK_INT;
        builderObtain.setJustificationMode(i13);
        builderObtain.setUseLineSpacingFromFallbacks(true);
        if (i18 >= 33) {
            builderObtain.setLineBreakConfig(c.a.b().setLineBreakStyle(i15).setLineBreakWordStyle(i16).build());
        }
        if (i18 >= 35) {
            builderObtain.setUseBoundsForWidth(false);
        }
        return builderObtain.build();
    }

    public static final Rect b(TextPaint textPaint, CharSequence charSequence, int i2, int i10) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            if (spanned.nextSpanTransition(i2 - 1, i10, MetricAffectingSpan.class) != i10) {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                TextPaint textPaint2 = new TextPaint();
                while (i2 < i10) {
                    int iNextSpanTransition = spanned.nextSpanTransition(i2, i10, MetricAffectingSpan.class);
                    MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spanned.getSpans(i2, iNextSpanTransition, MetricAffectingSpan.class);
                    textPaint2.set(textPaint);
                    d7.c cVarH = k.h(metricAffectingSpanArr);
                    while (cVarH.hasNext()) {
                        MetricAffectingSpan metricAffectingSpan = (MetricAffectingSpan) cVarH.next();
                        if (spanned.getSpanStart(metricAffectingSpan) != spanned.getSpanEnd(metricAffectingSpan)) {
                            metricAffectingSpan.updateMeasureState(textPaint2);
                        }
                    }
                    textPaint2.getTextBounds(charSequence, i2, iNextSpanTransition, rect2);
                    rect.right = rect2.width() + rect.right;
                    rect.top = Math.min(rect.top, rect2.top);
                    rect.bottom = Math.max(rect.bottom, rect2.bottom);
                    i2 = iNextSpanTransition;
                }
                return rect;
            }
        }
        Rect rect3 = new Rect();
        textPaint.getTextBounds(charSequence, i2, i10, rect3);
        return rect3;
    }

    public static final boolean c(Spanned spanned, Class cls) {
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }
}
