package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;

/* JADX INFO: loaded from: classes17.dex */
public class ChangeImageTransform extends Transition {
    private static final Property<ImageView, Matrix> ANIMATED_TRANSFORM_PROPERTY = null;
    private static final TypeEvaluator<Matrix> NULL_MATRIX_EVALUATOR = null;
    private static final String PROPNAME_BOUNDS = "android:changeImageTransform:bounds";
    private static final String PROPNAME_MATRIX = "android:changeImageTransform:matrix";
    private static final String[] sTransitionProperties = null;

    /* JADX INFO: renamed from: androidx.transition.ChangeImageTransform$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = null;

        static {
            int[] r100 = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = r100;
            r100[ImageView.ScaleType.FIT_XY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_BOUNDS};
        NULL_MATRIX_EVALUATOR = new AnonymousClass1();
        final Class<Matrix> r100 = Matrix.class;
        final String r101 = "animatedTransform";
        ANIMATED_TRANSFORM_PROPERTY = new AnonymousClass2(r100, r101);
    }

    public ChangeImageTransform() {
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    private void captureValues(TransitionValues r100) {
        View r101 = r100.view;
        if ((r101 instanceof ImageView) == true) goto L5;
        return;
    L5:
        if (r101.getVisibility() != 0) goto L13;
        ImageView r102 = (ImageView) r101;
        if (r102.getDrawable() != null) goto L10;
        return;
    L10:
        Map<String, Object> r103 = r100.values;
        r103.put(PROPNAME_BOUNDS, new Rect(r101.getLeft(), r101.getTop(), r101.getRight(), r101.getBottom()));
        r103.put(PROPNAME_MATRIX, copyImageMatrix(r102));
        return;
    }

    private static Matrix centerCropMatrix(ImageView r100) {
        Drawable r101 = r100.getDrawable();
        int r102 = r101.getIntrinsicWidth();
        float r103 = r100.getWidth();
        float r104 = r102;
        int r105 = r101.getIntrinsicHeight();
        float r106 = r100.getHeight();
        float r107 = r105;
        float r108 = Math.max(r103 / r104, r106 / r107);
        int r109 = Math.round((r103 - (r104 * r108)) / 2.0f);
        int r110 = Math.round((r106 - (r107 * r108)) / 2.0f);
        Matrix r111 = new Matrix();
        r111.postScale(r108, r108);
        r111.postTranslate(r109, r110);
        return r111;
    }

    private static Matrix copyImageMatrix(ImageView r100) {
        int r101 = AnonymousClass3.$SwitchMap$android$widget$ImageView$ScaleType[r100.getScaleType().ordinal()];
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L9;
        return new Matrix(r100.getImageMatrix());
    L9:
        return centerCropMatrix(r100);
    L11:
        return fitXYMatrix(r100);
    }

    private ObjectAnimator createNullAnimator(ImageView r100) {
        return ObjectAnimator.ofObject(r100, ANIMATED_TRANSFORM_PROPERTY, NULL_MATRIX_EVALUATOR, new Matrix[]{null, null});
    }

    private static Matrix fitXYMatrix(ImageView r100) {
        Drawable r101 = r100.getDrawable();
        Matrix r102 = new Matrix();
        r102.postScale(r100.getWidth() / r101.getIntrinsicWidth(), r100.getHeight() / r101.getIntrinsicHeight());
        return r102;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r100) {
        captureValues(r100);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r100) {
        captureValues(r100);
    }

    public ChangeImageTransform(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    private ObjectAnimator createMatrixAnimator(ImageView r100, Matrix r101, Matrix r102) {
        return ObjectAnimator.ofObject(r100, ANIMATED_TRANSFORM_PROPERTY, new TransitionUtils.MatrixEvaluator(), new Matrix[]{r101, r102});
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r100, TransitionValues r101, TransitionValues r102) {
        if (r101 == null) goto L34;
        if (r102 == null) goto L34;
        Rect r103 = (Rect) r101.values.get(PROPNAME_BOUNDS);
        Rect r104 = (Rect) r102.values.get(PROPNAME_BOUNDS);
        if (r103 == null) goto L34;
        if (r104 == null) goto L34;
        Matrix r105 = (Matrix) r101.values.get(PROPNAME_MATRIX);
        Matrix r106 = (Matrix) r102.values.get(PROPNAME_MATRIX);
        if (r105 != null) goto L13;
        if (r106 != null) goto L13;
    L16:
        boolean r107 = true;
    L19:
        if (r103.equals(r104) == false) goto L22;
        if (r107 == false) goto L22;
        return null;
    L22:
        ImageView r108 = (ImageView) r102.view;
        Drawable r109 = r108.getDrawable();
        int r110 = r109.getIntrinsicWidth();
        int r111 = r109.getIntrinsicHeight();
        ImageViewUtils.startAnimateTransform(r108);
        if (r110 == 0) goto L31;
        if (r111 == 0) goto L31;
        if (r105 != null) goto L28;
        r105 = MatrixUtils.IDENTITY_MATRIX;
    L28:
        if (r106 != null) goto L30;
        r106 = MatrixUtils.IDENTITY_MATRIX;
    L30:
        ANIMATED_TRANSFORM_PROPERTY.set(r108, r105);
        ObjectAnimator r112 = createMatrixAnimator(r108, r105, r106);
    L32:
        ImageViewUtils.reserveEndAnimateTransform(r108, r112);
        return r112;
    L31:
        r112 = createNullAnimator(r108);
    L13:
        if (r105 != null) goto L15;
    L17:
        r107 = false;
        goto L19
    L15:
        if (r105.equals(r106) == false) goto L17;
    L34:
        return null;
    }
}
