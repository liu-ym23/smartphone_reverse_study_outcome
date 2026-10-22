package androidx.compose.ui.text.android;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a \u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u0006\f"}, d2 = {"stripNonMetricAffectingCharSpans", "", "getStripNonMetricAffectingCharSpans$annotations", "()V", "stripNonMetricAffectingCharacterStyleSpans", "", "charSequence", "shouldIncreaseMaxIntrinsic", "desiredWidth", "", "textPaint", "Landroid/text/TextPaint;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LayoutIntrinsics_androidKt {
    private static final boolean stripNonMetricAffectingCharSpans = true;

    private static /* synthetic */ void getStripNonMetricAffectingCharSpans$annotations() {
    }

    public static final /* synthetic */ boolean access$getStripNonMetricAffectingCharSpans$p() {
        return stripNonMetricAffectingCharSpans;
    }

    public static final /* synthetic */ CharSequence access$stripNonMetricAffectingCharacterStyleSpans(CharSequence r100) {
        return stripNonMetricAffectingCharacterStyleSpans(r100);
    }

    private static final CharSequence stripNonMetricAffectingCharacterStyleSpans(CharSequence r100) {
        if ((r100 instanceof Spanned) == false) goto L33;
        Spanned r101 = (Spanned) r100;
        if (SpannedExtensions_androidKt.hasSpan(r101, CharacterStyle.class) == false) goto L35;
        boolean r102 = false;
        CharacterStyle[] r103 = (CharacterStyle[]) r101.getSpans(0, r100.length(), CharacterStyle.class);
        if (r103 != null) goto L10;
    L14:
        r102 = true;
    L15:
        if (r102 == false) goto L17;
        return r100;
    L17:
        Iterator r104 = ArrayIteratorKt.iterator(r103);
        SpannableString r105 = null;
    L19:
        if (r104.hasNext() == false) goto L25;
        CharacterStyle r106 = (CharacterStyle) r104.next();
        if ((r106 instanceof MetricAffectingSpan) == true) goto L19;
        if (r105 != null) goto L24;
        r105 = new SpannableString(r100);
    L24:
        r105.removeSpan(r106);
        goto L19
    L25:
        if (r105 != null) goto L27;
        return r100;
    L27:
        return r105;
    L10:
        if (r103.length != 0) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L15;
    L12:
        r107 = false;
        goto L13
    L35:
        return r100;
    L33:
        return r100;
    }

    public static final /* synthetic */ boolean access$shouldIncreaseMaxIntrinsic(float r100, CharSequence r101, TextPaint r102) {
        return shouldIncreaseMaxIntrinsic(r100, r101, r102);
    }

    private static final boolean shouldIncreaseMaxIntrinsic(float r100, CharSequence r101, TextPaint r102) {
        if (r100 != 0.0f) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
    L19:
        return false;
    L8:
        if ((r101 instanceof Spanned) == false) goto L14;
        Spanned r104 = (Spanned) r101;
        if (SpannedExtensions_androidKt.hasSpan(r104, LetterSpacingSpanPx.class) == false) goto L12;
        return true;
    L12:
        if (SpannedExtensions_androidKt.hasSpan(r104, LetterSpacingSpanEm.class) == false) goto L14;
        return true;
    L14:
        if (r102.getLetterSpacing() != 0.0f) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == true) goto L19;
        return true;
    L16:
        r105 = false;
        goto L17
    L5:
        r103 = false;
        goto L6
    }
}
