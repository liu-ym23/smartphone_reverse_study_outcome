package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes17.dex */
class TransitionUtils {
    private static final boolean HAS_IS_ATTACHED_TO_WINDOW = false;
    private static final boolean HAS_OVERLAY = false;
    private static final boolean HAS_PICTURE_BITMAP = false;
    private static final int MAX_IMAGE_SIZE = 1048576;

    public static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        final float[] mTempEndValues;
        final Matrix mTempMatrix;
        final float[] mTempStartValues;

        public MatrixEvaluator() {
            this.mTempStartValues = new float[9];
            this.mTempEndValues = new float[9];
            this.mTempMatrix = new Matrix();
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public Matrix evaluate2(float r100, Matrix r101, Matrix r102) {
            r101.getValues(this.mTempStartValues);
            r102.getValues(this.mTempEndValues);
            int r103 = 0;
        L4:
            if (r103 >= 9) goto L6;
            float[] r104 = this.mTempEndValues;
            float r105 = r104[r103];
            float r106 = this.mTempStartValues[r103];
            r104[r103] = r106 + ((r105 - r106) * r100);
            r103 = r103 + 1;
            goto L4
        L6:
            this.mTempMatrix.setValues(this.mTempEndValues);
            return this.mTempMatrix;
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Matrix evaluate(float r100, Matrix r101, Matrix r102) {
            return evaluate2(r100, r101, r102);
        }
    }

    static {
        int r100 = Build.VERSION.SDK_INT;
        boolean r101 = true;
        HAS_IS_ATTACHED_TO_WINDOW = true;
        HAS_OVERLAY = true;
        if (r100 >= 28) goto L6;
        r101 = false;
    L6:
        HAS_PICTURE_BITMAP = r101;
    }

    private TransitionUtils() {
    }

    public static Animator mergeAnimators(Animator r100, Animator r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        if (r101 != null) goto L6;
        return r100;
    L6:
        AnimatorSet r102 = new AnimatorSet();
        r102.playTogether(new Animator[]{r100, r101});
        return r102;
    }

    public static View copyViewImage(ViewGroup r100, View r101, View r102) {
        Matrix r103 = new Matrix();
        r103.setTranslate(-r102.getScrollX(), -r102.getScrollY());
        ViewUtils.transformMatrixToGlobal(r101, r103);
        ViewUtils.transformMatrixToLocal(r100, r103);
        RectF r104 = new RectF(0.0f, 0.0f, r101.getWidth(), r101.getHeight());
        r103.mapRect(r104);
        int r105 = Math.round(r104.left);
        int r106 = Math.round(r104.top);
        int r107 = Math.round(r104.right);
        int r108 = Math.round(r104.bottom);
        ImageView r109 = new ImageView(r101.getContext());
        r109.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap r110 = createViewBitmap(r101, r103, r104, r100);
        if (r110 == null) goto L5;
        r109.setImageBitmap(r110);
    L5:
        r109.measure(View.MeasureSpec.makeMeasureSpec(r107 - r105, 1073741824), View.MeasureSpec.makeMeasureSpec(r108 - r106, 1073741824));
        r109.layout(r105, r106, r107, r108);
        return r109;
    }

    private static Bitmap createViewBitmap(View r100, Matrix r101, RectF r110, ViewGroup r111) {
        if (HAS_IS_ATTACHED_TO_WINDOW == false) goto L8;
        boolean r102 = !r100.isAttachedToWindow();
        if (r111 == null) goto L9;
        boolean r103 = r111.isAttachedToWindow();
    L10:
        boolean r104 = HAS_OVERLAY;
        Bitmap r105 = null;
        if (r104 == false) goto L16;
        if (r102 == false) goto L16;
        if (r103 == true) goto L15;
        return null;
    L15:
        ViewGroup r106 = (ViewGroup) r100.getParent();
        int r107 = r106.indexOfChild(r100);
        r111.getOverlay().add(r100);
    L17:
        int r108 = Math.round(r110.width());
        int r109 = Math.round(r110.height());
        if (r108 <= 0) goto L24;
        if (r109 <= 0) goto L24;
        float r112 = Math.min(1.0f, 1048576.0f / (r108 * r109));
        int r113 = Math.round(r108 * r112);
        int r114 = Math.round(r109 * r112);
        r101.postTranslate(-r110.left, -r110.top);
        r101.postScale(r112, r112);
        if (HAS_PICTURE_BITMAP == false) goto L23;
        Picture r115 = new Picture();
        Canvas r116 = r115.beginRecording(r113, r114);
        r116.concat(r101);
        r100.draw(r116);
        r115.endRecording();
        r105 = Bitmap.createBitmap(r115);
        goto L24
    L23:
        r105 = Bitmap.createBitmap(r113, r114, Bitmap.Config.ARGB_8888);
        Canvas r117 = new Canvas(r105);
        r117.concat(r101);
        r100.draw(r117);
    L24:
        if (r104 == false) goto L27;
        if (r102 == false) goto L27;
        r111.getOverlay().remove(r100);
        r106.addView(r100, r107);
    L27:
        return r105;
    L16:
        r106 = null;
        r107 = 0;
    L9:
        r103 = false;
        goto L10
    L8:
        r102 = false;
        goto L9
    }
}
