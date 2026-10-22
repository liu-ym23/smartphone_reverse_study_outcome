package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ Rect evaluate(float r1, Rect r2, Rect r3) {
        return evaluate2(r1, r2, r3);
    }

    RectEvaluator() {
    }

    RectEvaluator(Rect r1) {
        this.mRect = r1;
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Rect evaluate2(float r6, Rect r7, Rect r8) {
        int r0 = r7.left + ((int) ((r8.left - r7.left) * r6));
        int r1 = r7.top + ((int) ((r8.top - r7.top) * r6));
        int r2 = r7.right + ((int) ((r8.right - r7.right) * r6));
        int r3 = r7.bottom + ((int) ((r8.bottom - r7.bottom) * r6));
        Rect r9 = this.mRect;
        if (r9 == null) goto L5;
        r9.set(r0, r1, r2, r3);
        return this.mRect;
    L5:
        return new Rect(r0, r1, r2, r3);
    }
}
