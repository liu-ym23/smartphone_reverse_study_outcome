package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes17.dex */
class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    public RectEvaluator() {
    }

    public RectEvaluator(Rect r100) {
        this.mRect = r100;
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Rect evaluate2(float r100, Rect r101, Rect r102) {
        int r103 = r101.left;
        int r104 = r103 + ((int) ((r102.left - r103) * r100));
        int r105 = r101.top;
        int r106 = r105 + ((int) ((r102.top - r105) * r100));
        int r107 = r101.right;
        int r108 = r107 + ((int) ((r102.right - r107) * r100));
        int r109 = r101.bottom;
        int r110 = r109 + ((int) ((r102.bottom - r109) * r100));
        Rect r111 = this.mRect;
        if (r111 == null) goto L5;
        r111.set(r104, r106, r108, r110);
        return this.mRect;
    L5:
        return new Rect(r104, r106, r108, r110);
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ Rect evaluate(float r100, Rect r101, Rect r102) {
        return evaluate2(r100, r101, r102);
    }
}
