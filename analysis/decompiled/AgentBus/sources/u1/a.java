package u1;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes.dex */
public final class a extends MetricAffectingSpan {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f9930f;

    /* renamed from: g, reason: collision with root package name */
    public final float f9931g;

    public /* synthetic */ a(int i2, float f10) {
        this.f9930f = i2;
        this.f9931g = f10;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        switch (this.f9930f) {
            case 0:
                textPaint.baselineShift += (int) Math.ceil(textPaint.ascent() * this.f9931g);
                break;
            default:
                textPaint.setTextSkewX(textPaint.getTextSkewX() + this.f9931g);
                break;
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        switch (this.f9930f) {
            case 0:
                textPaint.baselineShift += (int) Math.ceil(textPaint.ascent() * this.f9931g);
                break;
            default:
                textPaint.setTextSkewX(textPaint.getTextSkewX() + this.f9931g);
                break;
        }
    }
}
