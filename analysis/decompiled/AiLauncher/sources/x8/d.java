package x8;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import v8.C5671a;

/* loaded from: classes4.dex */
public class d extends MetricAffectingSpan {

    /* renamed from: a, reason: collision with root package name */
    public final C5671a f43584a;

    public d(C5671a c5671a) {
        this.f43584a = c5671a;
    }

    public final void a(TextPaint textPaint) {
        this.f43584a.c(textPaint);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
        textPaint.bgColor = this.f43584a.n(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
