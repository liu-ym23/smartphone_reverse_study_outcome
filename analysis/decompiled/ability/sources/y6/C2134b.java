package y6;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.k;

/* renamed from: y6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2134b extends MetricAffectingSpan {

    /* renamed from: a, reason: collision with root package name */
    public final float f6907a;

    public C2134b(float f) {
        this.f6907a = f;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint tp) {
        k.f(tp, "tp");
        tp.setLetterSpacing(this.f6907a);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint tp) {
        k.f(tp, "tp");
        tp.setLetterSpacing(this.f6907a);
    }
}
