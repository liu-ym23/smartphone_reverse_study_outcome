package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/android/style/LetterSpacingSpanPx;", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "", "<init>", "(F)V", "getLetterSpacing", "()F", "updatePaint", "", "Landroid/text/TextPaint;", "updateDrawState", "textPaint", "updateMeasureState", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LetterSpacingSpanPx extends MetricAffectingSpan {
    public static final int $stable = 8;
    private final float letterSpacing;

    public final float getLetterSpacing() {
        return this.letterSpacing;
    }

    public LetterSpacingSpanPx(float r100) {
        this.letterSpacing = r100;
    }

    private final void updatePaint(TextPaint r100) {
        float r101 = r100.getTextSize() * r100.getTextScaleX();
        if (r101 != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r100.setLetterSpacing(this.letterSpacing / r101);
        return;
    L9:
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        updatePaint(r100);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint r100) {
        updatePaint(r100);
    }
}
