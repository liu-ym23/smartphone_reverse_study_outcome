package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes17.dex */
public class ChangeTransform extends Transition {
    private static final Property<PathAnimatorMatrix, float[]> NON_TRANSLATIONS_PROPERTY = null;
    private static final String PROPNAME_INTERMEDIATE_MATRIX = "android:changeTransform:intermediateMatrix";
    private static final String PROPNAME_INTERMEDIATE_PARENT_MATRIX = "android:changeTransform:intermediateParentMatrix";
    private static final String PROPNAME_MATRIX = "android:changeTransform:matrix";
    private static final String PROPNAME_PARENT = "android:changeTransform:parent";
    private static final String PROPNAME_PARENT_MATRIX = "android:changeTransform:parentMatrix";
    private static final String PROPNAME_TRANSFORMS = "android:changeTransform:transforms";
    private static final boolean SUPPORTS_VIEW_REMOVAL_SUPPRESSION = false;
    private static final Property<PathAnimatorMatrix, PointF> TRANSLATIONS_PROPERTY = null;
    private static final String[] sTransitionProperties = null;
    private boolean mReparent;
    private Matrix mTempMatrix;
    boolean mUseOverlay;

    public static class GhostListener extends TransitionListenerAdapter {
        private GhostViewImpl mGhostView;
        private View mView;

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r100) {
            r100.removeListener(this);
            GhostViewUtils.removeGhost(this.mView);
            this.mView.setTag(R.id.transition_transform, null);
            this.mView.setTag(R.id.parent_matrix, null);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r100) {
            this.mGhostView.setVisibility(4);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r100) {
            this.mGhostView.setVisibility(0);
        }

        public GhostListener(View r100, GhostViewImpl r101) {
            this.mView = r100;
            this.mGhostView = r101;
        }
    }

    public static class PathAnimatorMatrix {
        private final Matrix mMatrix;
        private float mTranslationX;
        private float mTranslationY;
        private final float[] mValues;
        private final View mView;

        private void setAnimationMatrix() {
            float[] r100 = this.mValues;
            r100[2] = this.mTranslationX;
            r100[5] = this.mTranslationY;
            this.mMatrix.setValues(r100);
            ViewUtils.setAnimationMatrix(this.mView, this.mMatrix);
        }

        public Matrix getMatrix() {
            return this.mMatrix;
        }

        public void setTranslation(PointF r100) {
            this.mTranslationX = r100.x;
            this.mTranslationY = r100.y;
            setAnimationMatrix();
        }

        public void setValues(float[] r100) {
            System.arraycopy(r100, 0, this.mValues, 0, r100.length);
            setAnimationMatrix();
        }

        public PathAnimatorMatrix(View r100, float[] r101) {
            this.mMatrix = new Matrix();
            this.mView = r100;
            float[] r102 = (float[]) r101.clone();
            this.mValues = r102;
            this.mTranslationX = r102[2];
            this.mTranslationY = r102[5];
            setAnimationMatrix();
        }
    }

    public static class Transforms {
        final float mRotationX;
        final float mRotationY;
        final float mRotationZ;
        final float mScaleX;
        final float mScaleY;
        final float mTranslationX;
        final float mTranslationY;
        final float mTranslationZ;

        public int hashCode() {
            float r100 = this.mTranslationX;
            int r101 = 0;
            if (r100 == 0.0f) goto L5;
            int r102 = Float.floatToIntBits(r100);
        L6:
            int r103 = r102 * 31;
            float r104 = this.mTranslationY;
            if (r104 == 0.0f) goto L9;
            int r105 = Float.floatToIntBits(r104);
        L10:
            int r106 = (r103 + r105) * 31;
            float r107 = this.mTranslationZ;
            if (r107 == 0.0f) goto L13;
            int r108 = Float.floatToIntBits(r107);
        L14:
            int r109 = (r106 + r108) * 31;
            float r110 = this.mScaleX;
            if (r110 == 0.0f) goto L17;
            int r111 = Float.floatToIntBits(r110);
        L18:
            int r112 = (r109 + r111) * 31;
            float r113 = this.mScaleY;
            if (r113 == 0.0f) goto L21;
            int r114 = Float.floatToIntBits(r113);
        L22:
            int r115 = (r112 + r114) * 31;
            float r116 = this.mRotationX;
            if (r116 == 0.0f) goto L25;
            int r117 = Float.floatToIntBits(r116);
        L26:
            int r118 = (r115 + r117) * 31;
            float r119 = this.mRotationY;
            if (r119 == 0.0f) goto L29;
            int r120 = Float.floatToIntBits(r119);
        L30:
            int r121 = (r118 + r120) * 31;
            float r122 = this.mRotationZ;
            if (r122 == 0.0f) goto L34;
            r101 = Float.floatToIntBits(r122);
        L34:
            return r121 + r101;
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public Transforms(View r100) {
            this.mTranslationX = r100.getTranslationX();
            this.mTranslationY = r100.getTranslationY();
            this.mTranslationZ = ViewCompat.getTranslationZ(r100);
            this.mScaleX = r100.getScaleX();
            this.mScaleY = r100.getScaleY();
            this.mRotationX = r100.getRotationX();
            this.mRotationY = r100.getRotationY();
            this.mRotationZ = r100.getRotation();
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof Transforms) == true) goto L5;
            return false;
        L5:
            Transforms r101 = (Transforms) r100;
            if (r101.mTranslationX == this.mTranslationX) goto L8;
            return false;
        L8:
            if (r101.mTranslationY == this.mTranslationY) goto L10;
            return false;
        L10:
            if (r101.mTranslationZ == this.mTranslationZ) goto L12;
            return false;
        L12:
            if (r101.mScaleX == this.mScaleX) goto L14;
            return false;
        L14:
            if (r101.mScaleY == this.mScaleY) goto L16;
            return false;
        L16:
            if (r101.mRotationX == this.mRotationX) goto L18;
            return false;
        L18:
            if (r101.mRotationY == this.mRotationY) goto L20;
            return false;
        L20:
            if (r101.mRotationZ != this.mRotationZ) goto L30;
            return true;
        L30:
            return false;
        }

        public void restore(View r110) {
            ChangeTransform.setTransforms(r110, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mScaleX, this.mScaleY, this.mRotationX, this.mRotationY, this.mRotationZ);
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_TRANSFORMS, PROPNAME_PARENT_MATRIX};
        final Class<float[]> r100 = float[].class;
        final String r101 = "nonTranslations";
        NON_TRANSLATIONS_PROPERTY = new AnonymousClass1(r100, r101);
        final Class<PointF> r102 = PointF.class;
        final String r103 = "translations";
        TRANSLATIONS_PROPERTY = new AnonymousClass2(r102, r103);
        SUPPORTS_VIEW_REMOVAL_SUPPRESSION = true;
    }

    public ChangeTransform() {
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new Matrix();
    }

    public boolean getReparent() {
        return this.mReparent;
    }

    public boolean getReparentWithOverlay() {
        return this.mUseOverlay;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    private void captureValues(TransitionValues r100) {
        View r101 = r100.view;
        if (r101.getVisibility() != 8) goto L5;
        return;
    L5:
        r100.values.put(PROPNAME_PARENT, r101.getParent());
        r100.values.put(PROPNAME_TRANSFORMS, new Transforms(r101));
        Matrix r102 = r101.getMatrix();
        if (r102 != null) goto L8;
    L11:
        Matrix r103 = null;
    L12:
        r100.values.put(PROPNAME_MATRIX, r103);
        if (this.mReparent == false) goto L16;
        Matrix r104 = new Matrix();
        ViewGroup r105 = (ViewGroup) r101.getParent();
        ViewUtils.transformMatrixToGlobal(r105, r104);
        r104.preTranslate(-r105.getScrollX(), -r105.getScrollY());
        r100.values.put(PROPNAME_PARENT_MATRIX, r104);
        r100.values.put(PROPNAME_INTERMEDIATE_MATRIX, r101.getTag(R.id.transition_transform));
        r100.values.put(PROPNAME_INTERMEDIATE_PARENT_MATRIX, r101.getTag(R.id.parent_matrix));
        return;
    L16:
        return;
    L8:
        if (r102.isIdentity() == true) goto L11;
        r103 = new Matrix(r102);
        goto L12
    }

    public static void setIdentityTransforms(View r100) {
        setTransforms(r100, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r100) {
        captureValues(r100);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r100) {
        captureValues(r100);
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION == true) goto L6;
        ((ViewGroup) r100.view.getParent()).startViewTransition(r100.view);
        return;
    }

    public void setReparent(boolean r100) {
        this.mReparent = r100;
    }

    public void setReparentWithOverlay(boolean r100) {
        this.mUseOverlay = r100;
    }

    public ChangeTransform(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new Matrix();
        TypedArray r102 = r100.obtainStyledAttributes(r101, Styleable.CHANGE_TRANSFORM);
        XmlPullParser r103 = (XmlPullParser) r101;
        this.mUseOverlay = TypedArrayUtils.getNamedBoolean(r102, r103, "reparentWithOverlay", 1, true);
        this.mReparent = TypedArrayUtils.getNamedBoolean(r102, r103, "reparent", 0, true);
        r102.recycle();
    }

    private boolean parentsMatch(ViewGroup r100, ViewGroup r101) {
        boolean r102 = true;
        if (isValidTarget(r100) == true) goto L5;
    L12:
        if (r100 == r101) goto L16;
    L14:
        r102 = false;
    L16:
        return r102;
    L5:
        if (isValidTarget(r101) == false) goto L12;
        TransitionValues r103 = getMatchedTransitionValues(r100, true);
        if (r103 != null) goto L10;
        return false;
    L10:
        if (r101 != r103.view) goto L14;
        goto L14
    }

    private void setMatricesForParent(TransitionValues r100, TransitionValues r101) {
        Matrix r102 = (Matrix) r101.values.get(PROPNAME_PARENT_MATRIX);
        r101.view.setTag(R.id.parent_matrix, r102);
        Matrix r103 = this.mTempMatrix;
        r103.reset();
        r102.invert(r103);
        Matrix r104 = (Matrix) r100.values.get(PROPNAME_MATRIX);
        if (r104 != null) goto L5;
        r104 = new Matrix();
        r100.values.put(PROPNAME_MATRIX, r104);
    L5:
        r104.postConcat((Matrix) r100.values.get(PROPNAME_PARENT_MATRIX));
        r104.postConcat(r103);
    }

    private void createGhostView(ViewGroup r100, TransitionValues r101, TransitionValues r102) {
        View r103 = r102.view;
        Matrix r104 = new Matrix((Matrix) r102.values.get(PROPNAME_PARENT_MATRIX));
        ViewUtils.transformMatrixToLocal(r100, r104);
        GhostViewImpl r105 = GhostViewUtils.addGhost(r103, r100, r104);
        if (r105 != null) goto L5;
        return;
    L5:
        r105.reserveEndViewTransition((ViewGroup) r101.values.get(PROPNAME_PARENT), r101.view);
        Transition r106 = this;
    L6:
        TransitionSet r107 = r106.mParent;
        if (r107 == null) goto L9;
        r106 = r107;
        goto L6
    L9:
        r106.addListener(new GhostListener(r103, r105));
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION == false) goto L17;
        View r108 = r101.view;
        if (r108 == r102.view) goto L14;
        ViewUtils.setTransitionAlpha(r108, 0.0f);
    L14:
        ViewUtils.setTransitionAlpha(r103, 1.0f);
        return;
    }

    private ObjectAnimator createTransformAnimator(TransitionValues r110, TransitionValues r111, final boolean r112) {
        Matrix r113 = (Matrix) r110.values.get(PROPNAME_MATRIX);
        Matrix r100 = (Matrix) r111.values.get(PROPNAME_MATRIX);
        if (r113 != null) goto L5;
        r113 = MatrixUtils.IDENTITY_MATRIX;
    L5:
        if (r100 != null) goto L7;
        r100 = MatrixUtils.IDENTITY_MATRIX;
    L7:
        final Matrix r101 = r100;
        if (r113.equals(r101) == false) goto L11;
        return null;
    L11:
        final Transforms r102 = (Transforms) r111.values.get(PROPNAME_TRANSFORMS);
        final View r103 = r111.view;
        setIdentityTransforms(r103);
        float[] r104 = new float[9];
        r113.getValues(r104);
        float[] r114 = new float[9];
        r101.getValues(r114);
        final PathAnimatorMatrix r105 = new PathAnimatorMatrix(r103, r104);
        ObjectAnimator r115 = ObjectAnimator.ofPropertyValuesHolder(r105, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(NON_TRANSLATIONS_PROPERTY, new FloatArrayEvaluator(new float[9]), new float[][]{r104, r114}), PropertyValuesHolderUtils.ofPointF(TRANSLATIONS_PROPERTY, getPathMotion().getPath(r104[2], r104[5], r114[2], r114[5]))});
        AnimatorListenerAdapter r116 = new AnonymousClass3(this, r112, r101, r103, r102, r105);
        r115.addListener(r116);
        AnimatorUtils.addPauseListener(r115, r116);
        return r115;
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r100, TransitionValues r101, TransitionValues r102) {
        if (r101 == null) goto L33;
        if (r102 != null) goto L5;
        return null;
    L5:
        if (r101.values.containsKey(PROPNAME_PARENT) == true) goto L7;
        return null;
    L7:
        if (r102.values.containsKey(PROPNAME_PARENT) == false) goto L37;
        ViewGroup r103 = (ViewGroup) r101.values.get(PROPNAME_PARENT);
        ViewGroup r104 = (ViewGroup) r102.values.get(PROPNAME_PARENT);
        if (this.mReparent == true) goto L12;
    L14:
        boolean r105 = false;
    L15:
        Matrix r106 = (Matrix) r101.values.get(PROPNAME_INTERMEDIATE_MATRIX);
        if (r106 == null) goto L18;
        r101.values.put(PROPNAME_MATRIX, r106);
    L18:
        Matrix r107 = (Matrix) r101.values.get(PROPNAME_INTERMEDIATE_PARENT_MATRIX);
        if (r107 == null) goto L21;
        r101.values.put(PROPNAME_PARENT_MATRIX, r107);
    L21:
        if (r105 == false) goto L23;
        setMatricesForParent(r101, r102);
    L23:
        ObjectAnimator r108 = createTransformAnimator(r101, r102, r105);
        if (r105 == false) goto L30;
        if (r108 == null) goto L30;
        if (this.mUseOverlay == false) goto L30;
        createGhostView(r100, r101, r102);
    L32:
        return r108;
    L30:
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION == true) goto L32;
        r103.endViewTransition(r101.view);
        goto L32
    L12:
        if (parentsMatch(r103, r104) == true) goto L14;
        r105 = true;
        goto L15
    L37:
        return null;
    L33:
        return null;
    }

    public static void setTransforms(View r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, float r108) {
        r100.setTranslationX(r101);
        r100.setTranslationY(r102);
        ViewCompat.setTranslationZ(r100, r103);
        r100.setScaleX(r104);
        r100.setScaleY(r105);
        r100.setRotationX(r106);
        r100.setRotationY(r107);
        r100.setRotation(r108);
    }
}
