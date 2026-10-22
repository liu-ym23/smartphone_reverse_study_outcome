package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* loaded from: classes.dex */
class i implements TypeEvaluator<Rect> {

    /* renamed from: a, reason: collision with root package name */
    private Rect f11421a;

    i() {
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float f5, Rect rect, Rect rect2) {
        int i5 = rect.left + ((int) ((rect2.left - r0) * f5));
        int i6 = rect.top + ((int) ((rect2.top - r1) * f5));
        int i7 = rect.right + ((int) ((rect2.right - r2) * f5));
        int i8 = rect.bottom + ((int) ((rect2.bottom - r6) * f5));
        Rect rect3 = this.f11421a;
        if (rect3 == null) {
            return new Rect(i5, i6, i7, i8);
        }
        rect3.set(i5, i6, i7, i8);
        return this.f11421a;
    }
}
