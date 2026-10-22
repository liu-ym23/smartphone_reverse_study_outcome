package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi29.java */
/* JADX INFO: loaded from: classes.dex */
class ak extends aj {
    ak() {
    }

    @Override // androidx.transition.ag, androidx.transition.al
    public void a(View r1, float r2) {
        r1.setTransitionAlpha(r2);
    }

    @Override // androidx.transition.ag, androidx.transition.al
    public float a(View r1) {
        return r1.getTransitionAlpha();
    }

    @Override // androidx.transition.aj, androidx.transition.al
    public void a(View r1, int r2) {
        r1.setTransitionVisibility(r2);
    }

    @Override // androidx.transition.ai, androidx.transition.al
    public void a(View r1, int r2, int r3, int r4, int r5) {
        r1.setLeftTopRightBottom(r2, r3, r4, r5);
    }

    @Override // androidx.transition.ah, androidx.transition.al
    public void a(View r1, Matrix r2) {
        r1.transformMatrixToGlobal(r2);
    }

    @Override // androidx.transition.ah, androidx.transition.al
    public void b(View r1, Matrix r2) {
        r1.transformMatrixToLocal(r2);
    }

    @Override // androidx.transition.ah, androidx.transition.al
    public void c(View r1, Matrix r2) {
        r1.setAnimationMatrix(r2);
    }
}
