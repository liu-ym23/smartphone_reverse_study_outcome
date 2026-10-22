package f2;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends MetricAffectingSpan {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3869c;

    /* renamed from: f, reason: collision with root package name */
    public float f3870f;

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        switch (this.f3869c) {
            case 0:
                textPaint.baselineShift += (int) Math.ceil(textPaint.ascent() * this.f3870f);
                break;
            default:
                textPaint.setTextSkewX(textPaint.getTextSkewX() + this.f3870f);
                break;
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        switch (this.f3869c) {
            case 0:
                textPaint.baselineShift += (int) Math.ceil(textPaint.ascent() * this.f3870f);
                break;
            default:
                textPaint.setTextSkewX(textPaint.getTextSkewX() + this.f3870f);
                break;
        }
    }
}
