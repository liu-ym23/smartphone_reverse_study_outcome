package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes17.dex */
class ViewUtilsBase {
    private float[] mMatrixValues;

    public ViewUtilsBase() {
    }

    public void clearNonTransitionAlpha(View r100) {
        if (r100.getVisibility() != 0) goto L6;
        r100.setTag(R.id.save_non_transition_alpha, null);
        return;
    }

    public float getTransitionAlpha(View r100) {
        Float r101 = (Float) r100.getTag(R.id.save_non_transition_alpha);
        if (r101 == null) goto L7;
        return r100.getAlpha() / r101.floatValue();
    L7:
        return r100.getAlpha();
    }

    public void saveNonTransitionAlpha(View r100) {
        if (r100.getTag(R.id.save_non_transition_alpha) != null) goto L6;
        r100.setTag(R.id.save_non_transition_alpha, Float.valueOf(r100.getAlpha()));
        return;
    }

    public void setAnimationMatrix(View r110, Matrix r111) {
        if (r111 != null) goto L5;
    L15:
        r110.setPivotX(r110.getWidth() / 2);
        r110.setPivotY(r110.getHeight() / 2);
        r110.setTranslationX(0.0f);
        r110.setTranslationY(0.0f);
        r110.setScaleX(1.0f);
        r110.setScaleY(1.0f);
        r110.setRotation(0.0f);
        return;
    L5:
        if (r111.isIdentity() == true) goto L15;
        float[] r100 = this.mMatrixValues;
        if (r100 != null) goto L10;
        r100 = new float[9];
        this.mMatrixValues = r100;
    L10:
        r111.getValues(r100);
        float r112 = r100[3];
        float r101 = (float) Math.sqrt(1.0f - (r112 * r112));
        if (r100[0] >= 0.0f) goto L13;
        int r102 = -1;
    L14:
        float r103 = r101 * r102;
        float r113 = (float) Math.toDegrees(Math.atan2(r112, r103));
        float r104 = r100[0] / r103;
        float r105 = r100[4] / r103;
        float r106 = r100[2];
        float r107 = r100[5];
        r110.setPivotX(0.0f);
        r110.setPivotY(0.0f);
        r110.setTranslationX(r106);
        r110.setTranslationY(r107);
        r110.setRotation(r113);
        r110.setScaleX(r104);
        r110.setScaleY(r105);
        return;
    L13:
        r102 = 1;
        goto L14
    }

    public void setTransitionAlpha(View r100, float r101) {
        Float r102 = (Float) r100.getTag(R.id.save_non_transition_alpha);
        if (r102 == null) goto L5;
        r100.setAlpha(r102.floatValue() * r101);
        return;
    L5:
        r100.setAlpha(r101);
    }

    public void transformMatrixToGlobal(View r100, Matrix r101) {
        Object r102 = r100.getParent();
        if ((r102 instanceof View) == false) goto L5;
        View r103 = (View) r102;
        transformMatrixToGlobal(r103, r101);
        r101.preTranslate(-r103.getScrollX(), -r103.getScrollY());
    L5:
        r101.preTranslate(r100.getLeft(), r100.getTop());
        Matrix r104 = r100.getMatrix();
        if (r104.isIdentity() == true) goto L9;
        r101.preConcat(r104);
        return;
    }

    public void transformMatrixToLocal(View r100, Matrix r101) {
        Object r102 = r100.getParent();
        if ((r102 instanceof View) == false) goto L5;
        View r103 = (View) r102;
        transformMatrixToLocal(r103, r101);
        r101.postTranslate(r103.getScrollX(), r103.getScrollY());
    L5:
        r101.postTranslate(r100.getLeft(), r100.getTop());
        Matrix r104 = r100.getMatrix();
        if (r104.isIdentity() == true) goto L11;
        Matrix r105 = new Matrix();
        if (r104.invert(r105) == false) goto L12;
        r101.postConcat(r105);
        return;
    L12:
        return;
    }

    public void setLeftTopRightBottom(View r100, int r101, int r102, int r103, int r104) {
        r100.setLeft(r101);
        r100.setTop(r102);
        r100.setRight(r103);
        r100.setBottom(r104);
    }
}
