package u1;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes.dex */
public final class b extends MetricAffectingSpan {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f9932f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f9933g;

    public /* synthetic */ b(int i2, Object obj) {
        this.f9932f = i2;
        this.f9933g = obj;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        switch (this.f9932f) {
            case 0:
                textPaint.setFontFeatureSettings((String) this.f9933g);
                break;
            default:
                textPaint.setTypeface((Typeface) this.f9933g);
                break;
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        switch (this.f9932f) {
            case 0:
                textPaint.setFontFeatureSettings((String) this.f9933g);
                break;
            default:
                textPaint.setTypeface((Typeface) this.f9933g);
                break;
        }
    }
}
