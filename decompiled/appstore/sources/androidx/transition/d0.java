package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class d0 extends c0 {
    public d0() {
    }

    @Override // androidx.transition.e0
    public float b(View r10) {
        return r10.getTransitionAlpha();
    }

    @Override // androidx.transition.e0
    public void d(View r10, Matrix r11) {
        r10.setAnimationMatrix(r11);
    }

    @Override // androidx.transition.e0
    public void e(View r10, int r11, int r12, int r13, int r14) {
        r10.setLeftTopRightBottom(r11, r12, r13, r14);
    }

    @Override // androidx.transition.e0
    public void f(View r10, float r11) {
        r10.setTransitionAlpha(r11);
    }

    @Override // androidx.transition.e0
    public void g(View r10, int r11) {
        r10.setTransitionVisibility(r11);
    }

    @Override // androidx.transition.e0
    public void h(View r10, Matrix r11) {
        r10.transformMatrixToGlobal(r11);
    }

    @Override // androidx.transition.e0
    public void i(View r10, Matrix r11) {
        r10.transformMatrixToLocal(r11);
    }
}
