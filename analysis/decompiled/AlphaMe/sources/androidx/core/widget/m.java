package androidx.core.widget;

import android.icu.text.DecimalFormatSymbols;
import android.text.PrecomputedText;
import android.widget.TextView;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class m {
    @DoNotInline
    public static CharSequence a(PrecomputedText precomputedText) {
        return precomputedText;
    }

    @DoNotInline
    public static String[] b(DecimalFormatSymbols decimalFormatSymbols) {
        return decimalFormatSymbols.getDigitStrings();
    }

    @DoNotInline
    public static PrecomputedText.Params c(TextView textView) {
        return textView.getTextMetricsParams();
    }

    @DoNotInline
    public static void d(TextView textView, int i4) {
        textView.setFirstBaselineToTopHeight(i4);
    }
}
