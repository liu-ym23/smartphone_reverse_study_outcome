package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
class D extends C {
    D() {
    }

    @Override // androidx.transition.z
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // androidx.transition.z
    public void d(View view, int i5, int i6, int i7, int i8) {
        view.setLeftTopRightBottom(i5, i6, i7, i8);
    }

    @Override // androidx.transition.z
    public void e(View view, float f5) {
        view.setTransitionAlpha(f5);
    }

    @Override // androidx.transition.z
    public void f(View view, int i5) {
        view.setTransitionVisibility(i5);
    }

    @Override // androidx.transition.z
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.z
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
