package p1;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
public class F extends E {
    @Override // p1.C5039B
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // p1.C5039B
    public void d(View view, int i10, int i11, int i12, int i13) {
        view.setLeftTopRightBottom(i10, i11, i12, i13);
    }

    @Override // p1.C5039B
    public void e(View view, float f10) {
        view.setTransitionAlpha(f10);
    }

    @Override // p1.C5039B
    public void f(View view, int i10) {
        view.setTransitionVisibility(i10);
    }

    @Override // p1.C5039B
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // p1.C5039B
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
