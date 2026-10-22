package v1;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    public Matrix f14580a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f14581b;

    public void a(View view, float[] fArr) {
        int[] iArr = this.f14581b;
        Matrix matrix = this.f14580a;
        matrix.reset();
        View view2 = view;
        view2.transformMatrixToGlobal(matrix);
        ViewParent parent = view2.getParent();
        while (parent instanceof View) {
            view2 = parent;
            parent = view2.getParent();
        }
        view2.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i3 = iArr[1];
        view2.getLocationInWindow(iArr);
        matrix.postTranslate(iArr[0] - i, iArr[1] - i3);
        matrix.getValues(fArr);
        float f5 = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[2];
        float f12 = fArr[3];
        float f13 = fArr[4];
        float f14 = fArr[5];
        float f15 = fArr[6];
        float f16 = fArr[7];
        float f17 = fArr[8];
        fArr[0] = f5;
        fArr[1] = f12;
        fArr[2] = 0.0f;
        fArr[3] = f15;
        fArr[4] = f10;
        fArr[5] = f13;
        fArr[6] = 0.0f;
        fArr[7] = f16;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = f11;
        fArr[13] = f14;
        fArr[14] = 0.0f;
        fArr[15] = f17;
    }
}
