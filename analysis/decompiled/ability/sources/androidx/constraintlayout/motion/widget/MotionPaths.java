package androidx.constraintlayout.motion.widget;

import B7.a;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* loaded from: classes2.dex */
class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] sNames = {"position", "x", "y", "width", "height", "pathRotate"};
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    LinkedHashMap<String, ConstraintAttribute> mAttributes;
    float mHeight;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPosition;
    float mRelativeAngle;
    MotionController mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float mTime;
    float mWidth;
    float mX;
    float mY;
    int mDrawPath = 0;
    float mPathRotate = Float.NaN;
    float mProgress = Float.NaN;

    public MotionPaths() {
        int i = Key.UNSET;
        this.mPathMotionArc = i;
        this.mAnimateRelativeTo = i;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.mAttributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f, float f7) {
        return (Float.isNaN(f) || Float.isNaN(f7)) ? Float.isNaN(f) != Float.isNaN(f7) : Math.abs(f - f7) > 1.0E-6f;
    }

    private static float xRotate(float f, float f7, float f9, float f10, float f11, float f12) {
        return (((f11 - f9) * f7) - ((f12 - f10) * f)) + f9;
    }

    private static float yRotate(float f, float f7, float f9, float f10, float f11, float f12) {
        return ((f12 - f10) * f7) + ((f11 - f9) * f) + f10;
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = constraint.propertySet.mProgress;
        this.mRelativeAngle = constraint.layout.circleAngle;
        for (String str : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute != null && constraintAttribute.isContinuous()) {
                this.mAttributes.put(str, constraintAttribute);
            }
        }
    }

    public void configureRelativeTo(MotionController motionController) {
        motionController.getPos(this.mProgress);
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z10) {
        boolean zDiff = diff(this.mX, motionPaths.mX);
        boolean zDiff2 = diff(this.mY, motionPaths.mY);
        zArr[0] = zArr[0] | diff(this.mPosition, motionPaths.mPosition);
        boolean z11 = zDiff | zDiff2 | z10;
        zArr[1] = zArr[1] | z11;
        zArr[2] = z11 | zArr[2];
        zArr[3] = zArr[3] | diff(this.mWidth, motionPaths.mWidth);
        zArr[4] = diff(this.mHeight, motionPaths.mHeight) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.mPosition, this.mX, this.mY, this.mWidth, this.mHeight, this.mPathRotate};
        int i = 0;
        for (int i6 : iArr) {
            if (i6 < 6) {
                dArr[i] = fArr[r0];
                i++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.mWidth;
        float f7 = this.mHeight;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            float f9 = (float) dArr[i6];
            int i10 = iArr[i6];
            if (i10 == 3) {
                f = f9;
            } else if (i10 == 4) {
                f7 = f9;
            }
        }
        fArr[i] = f;
        fArr[i + 1] = f7;
    }

    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float fA = this.mX;
        float fCos = this.mY;
        float f = this.mWidth;
        float f7 = this.mHeight;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            float f9 = (float) dArr[i6];
            int i10 = iArr[i6];
            if (i10 == 1) {
                fA = f9;
            } else if (i10 == 2) {
                fCos = f9;
            } else if (i10 == 3) {
                f = f9;
            } else if (i10 == 4) {
                f7 = f9;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d, fArr2, new float[2]);
            float f10 = fArr2[0];
            float f11 = fArr2[1];
            double d6 = fA;
            double d10 = fCos;
            fA = (float) (a.a(d10, d6, f10) - (f / 2.0f));
            fCos = (float) ((f11 - (Math.cos(d10) * d6)) - (f7 / 2.0f));
        }
        fArr[i] = (f / 2.0f) + fA + 0.0f;
        fArr[i + 1] = (f7 / 2.0f) + fCos + 0.0f;
    }

    public void getCenterVelocity(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float fA = this.mX;
        float fCos = this.mY;
        float f = this.mWidth;
        float f7 = this.mHeight;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            float f9 = (float) dArr[i6];
            int i10 = iArr[i6];
            if (i10 == 1) {
                fA = f9;
            } else if (i10 == 2) {
                fCos = f9;
            } else if (i10 == 3) {
                f = f9;
            } else if (i10 == 4) {
                f7 = f9;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d, fArr2, new float[2]);
            float f10 = fArr2[0];
            float f11 = fArr2[1];
            double d6 = fA;
            double d10 = fCos;
            fA = (float) (a.a(d10, d6, f10) - (f / 2.0f));
            fCos = (float) ((f11 - (Math.cos(d10) * d6)) - (f7 / 2.0f));
        }
        fArr[i] = (f / 2.0f) + fA + 0.0f;
        fArr[i + 1] = (f7 / 2.0f) + fCos + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i) {
        ConstraintAttribute constraintAttribute = this.mAttributes.get(str);
        int i6 = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.numberOfInterpolatedValues() == 1) {
            dArr[i] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int iNumberOfInterpolatedValues = constraintAttribute.numberOfInterpolatedValues();
        constraintAttribute.getValuesToInterpolate(new float[iNumberOfInterpolatedValues]);
        while (i6 < iNumberOfInterpolatedValues) {
            dArr[i] = r1[i6];
            i6++;
            i++;
        }
        return iNumberOfInterpolatedValues;
    }

    public int getCustomDataCount(String str) {
        ConstraintAttribute constraintAttribute = this.mAttributes.get(str);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.numberOfInterpolatedValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.mX;
        float fCos = this.mY;
        float f7 = this.mWidth;
        float f9 = this.mHeight;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            float f10 = (float) dArr[i6];
            int i10 = iArr[i6];
            if (i10 == 1) {
                f = f10;
            } else if (i10 == 2) {
                fCos = f10;
            } else if (i10 == 3) {
                f7 = f10;
            } else if (i10 == 4) {
                f9 = f10;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float centerX = motionController.getCenterX();
            float centerY = this.mRelativeToController.getCenterY();
            double d = f;
            double d6 = fCos;
            float fA = (float) (a.a(d6, d, centerX) - (f7 / 2.0f));
            fCos = (float) ((centerY - (Math.cos(d6) * d)) - (f9 / 2.0f));
            f = fA;
        }
        float f11 = f7 + f;
        float f12 = f9 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i] = f + 0.0f;
        fArr[i + 1] = fCos + 0.0f;
        fArr[i + 2] = f11 + 0.0f;
        fArr[i + 3] = fCos + 0.0f;
        fArr[i + 4] = f11 + 0.0f;
        fArr[i + 5] = f12 + 0.0f;
        fArr[i + 6] = f + 0.0f;
        fArr[i + 7] = f12 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.mAttributes.containsKey(str);
    }

    public void initAxis(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f7 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f9 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f10 = motionPaths2.mWidth;
        float f11 = motionPaths.mWidth;
        float f12 = f10 - f11;
        float f13 = motionPaths2.mHeight;
        float f14 = motionPaths.mHeight;
        float f15 = f13 - f14;
        this.mPosition = this.mTime;
        float f16 = (f11 / 2.0f) + motionPaths.mX;
        float f17 = (f14 / 2.0f) + motionPaths.mY;
        float f18 = f;
        float f19 = (f10 / 2.0f) + motionPaths2.mX;
        float f20 = (f13 / 2.0f) + motionPaths2.mY;
        if (f16 > f19) {
            f16 = f19;
            f19 = f16;
        }
        if (f17 <= f20) {
            f17 = f20;
            f20 = f17;
        }
        float f21 = f19 - f16;
        float f22 = f17 - f20;
        float f23 = (f12 * f7) / 2.0f;
        this.mX = (int) (((f21 * f18) + r13) - f23);
        float f24 = (f15 * f9) / 2.0f;
        this.mY = (int) (((f22 * f18) + r14) - f24);
        this.mWidth = (int) (f11 + r9);
        this.mHeight = (int) (f14 + r12);
        float f25 = Float.isNaN(keyPosition.mPercentX) ? f18 : keyPosition.mPercentX;
        float f26 = Float.isNaN(keyPosition.mAltPercentY) ? 0.0f : keyPosition.mAltPercentY;
        if (!Float.isNaN(keyPosition.mPercentY)) {
            f18 = keyPosition.mPercentY;
        }
        float f27 = Float.isNaN(keyPosition.mAltPercentX) ? 0.0f : keyPosition.mAltPercentX;
        this.mMode = 0;
        this.mX = (int) (((f27 * f22) + ((f25 * f21) + motionPaths.mX)) - f23);
        this.mY = (int) (((f22 * f18) + ((f21 * f26) + motionPaths.mY)) - f24);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f7 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f9 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f10 = motionPaths2.mWidth;
        float f11 = motionPaths.mWidth;
        float f12 = f10 - f11;
        float f13 = motionPaths2.mHeight;
        float f14 = motionPaths.mHeight;
        float f15 = f13 - f14;
        this.mPosition = this.mTime;
        float f16 = motionPaths.mX;
        float f17 = motionPaths.mY;
        float f18 = f;
        float f19 = ((f10 / 2.0f) + motionPaths2.mX) - ((f11 / 2.0f) + f16);
        float f20 = ((f13 / 2.0f) + motionPaths2.mY) - ((f14 / 2.0f) + f17);
        float f21 = (f12 * f7) / 2.0f;
        this.mX = (int) (((f19 * f18) + f16) - f21);
        float f22 = (f15 * f9) / 2.0f;
        this.mY = (int) (((f20 * f18) + f17) - f22);
        this.mWidth = (int) (f11 + r9);
        this.mHeight = (int) (f14 + r12);
        float f23 = Float.isNaN(keyPosition.mPercentX) ? f18 : keyPosition.mPercentX;
        float f24 = Float.isNaN(keyPosition.mAltPercentY) ? 0.0f : keyPosition.mAltPercentY;
        if (!Float.isNaN(keyPosition.mPercentY)) {
            f18 = keyPosition.mPercentY;
        }
        float f25 = Float.isNaN(keyPosition.mAltPercentX) ? 0.0f : keyPosition.mAltPercentX;
        this.mMode = 0;
        this.mX = (int) (((f25 * f20) + ((f23 * f19) + motionPaths.mX)) - f21);
        this.mY = (int) (((f20 * f18) + ((f19 * f24) + motionPaths.mY)) - f22);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f7 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f9 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f10 = motionPaths2.mWidth - motionPaths.mWidth;
        float f11 = motionPaths2.mHeight - motionPaths.mHeight;
        this.mPosition = this.mTime;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            f = keyPosition.mPercentX;
        }
        float f12 = motionPaths.mX;
        float f13 = motionPaths.mWidth;
        float f14 = motionPaths.mY;
        float f15 = motionPaths.mHeight;
        float f16 = f;
        float f17 = ((motionPaths2.mWidth / 2.0f) + motionPaths2.mX) - ((f13 / 2.0f) + f12);
        float f18 = ((motionPaths2.mHeight / 2.0f) + motionPaths2.mY) - ((f15 / 2.0f) + f14);
        float f19 = f17 * f16;
        float f20 = (f10 * f7) / 2.0f;
        this.mX = (int) ((f12 + f19) - f20);
        float f21 = f18 * f16;
        float f22 = (f11 * f9) / 2.0f;
        this.mY = (int) ((f14 + f21) - f22);
        this.mWidth = (int) (f13 + r7);
        this.mHeight = (int) (f15 + r8);
        float f23 = Float.isNaN(keyPosition.mPercentY) ? 0.0f : keyPosition.mPercentY;
        this.mMode = 1;
        float f24 = (int) ((motionPaths.mX + f19) - f20);
        float f25 = (int) ((motionPaths.mY + f21) - f22);
        this.mX = f24 + ((-f18) * f23);
        this.mY = f25 + (f17 * f23);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initPolar(int i, int i6, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float fMin;
        float fB;
        float f = keyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = keyPosition.mDrawPath;
        this.mMode = keyPosition.mPositionType;
        float f7 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f9 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f10 = motionPaths2.mWidth;
        float f11 = motionPaths.mWidth;
        float f12 = motionPaths2.mHeight;
        float f13 = motionPaths.mHeight;
        this.mPosition = this.mTime;
        this.mWidth = (int) (((f10 - f11) * f7) + f11);
        this.mHeight = (int) (((f12 - f13) * f9) + f13);
        if (keyPosition.mPositionType != 2) {
            float f14 = Float.isNaN(keyPosition.mPercentX) ? f : keyPosition.mPercentX;
            float f15 = motionPaths2.mX;
            float f16 = motionPaths.mX;
            this.mX = a.b(f15, f16, f14, f16);
            if (!Float.isNaN(keyPosition.mPercentY)) {
                f = keyPosition.mPercentY;
            }
            float f17 = motionPaths2.mY;
            float f18 = motionPaths.mY;
            this.mY = a.b(f17, f18, f, f18);
        } else {
            if (Float.isNaN(keyPosition.mPercentX)) {
                float f19 = motionPaths2.mX;
                float f20 = motionPaths.mX;
                fMin = a.b(f19, f20, f, f20);
            } else {
                fMin = Math.min(f9, f7) * keyPosition.mPercentX;
            }
            this.mX = fMin;
            if (Float.isNaN(keyPosition.mPercentY)) {
                float f21 = motionPaths2.mY;
                float f22 = motionPaths.mY;
                fB = a.b(f21, f22, f, f22);
            } else {
                fB = keyPosition.mPercentY;
            }
            this.mY = fB;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initScreen(int i, int i6, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f7 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f9 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f10 = motionPaths2.mWidth;
        float f11 = f10 - motionPaths.mWidth;
        float f12 = motionPaths2.mHeight;
        float f13 = f12 - motionPaths.mHeight;
        this.mPosition = this.mTime;
        float f14 = motionPaths.mX;
        float f15 = motionPaths.mY;
        float f16 = (f10 / 2.0f) + motionPaths2.mX;
        float f17 = (f12 / 2.0f) + motionPaths2.mY;
        float f18 = f11 * f7;
        this.mX = (int) ((((f16 - ((r8 / 2.0f) + f14)) * f) + f14) - (f18 / 2.0f));
        float f19 = f13 * f9;
        this.mY = (int) ((((f17 - ((r11 / 2.0f) + f15)) * f) + f15) - (f19 / 2.0f));
        this.mWidth = (int) (r8 + f18);
        this.mHeight = (int) (r11 + f19);
        this.mMode = 2;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            this.mX = (int) (keyPosition.mPercentX * (i - ((int) this.mWidth)));
        }
        if (!Float.isNaN(keyPosition.mPercentY)) {
            this.mY = (int) (keyPosition.mPercentY * (i6 - ((int) this.mHeight)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void setBounds(float f, float f7, float f9, float f10) {
        this.mX = f;
        this.mY = f7;
        this.mWidth = f9;
        this.mHeight = f10;
    }

    public void setDpDt(float f, float f7, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f13 = (float) dArr[i];
            double d = dArr2[i];
            int i6 = iArr[i];
            if (i6 == 1) {
                f9 = f13;
            } else if (i6 == 2) {
                f11 = f13;
            } else if (i6 == 3) {
                f10 = f13;
            } else if (i6 == 4) {
                f12 = f13;
            }
        }
        float f14 = f9 - ((0.0f * f10) / 2.0f);
        float f15 = f11 - ((0.0f * f12) / 2.0f);
        fArr[0] = (((f10 * 1.0f) + f14) * f) + ((1.0f - f) * f14) + 0.0f;
        fArr[1] = (((f12 * 1.0f) + f15) * f7) + ((1.0f - f7) * f15) + 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setView(float f, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z10) {
        float f7;
        float f9 = this.mX;
        float f10 = this.mY;
        float f11 = this.mWidth;
        float f12 = this.mHeight;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i];
            this.mTempDelta = new double[i];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i6 = 0; i6 < iArr.length; i6++) {
            double[] dArr4 = this.mTempValue;
            int i10 = iArr[i6];
            dArr4[i10] = dArr[i6];
            this.mTempDelta[i10] = dArr2[i6];
        }
        float f13 = Float.NaN;
        int i11 = 0;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i11 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i11]) && (dArr3 == null || dArr3[i11] == 0.0d)) {
                f7 = f13;
            } else {
                double d = dArr3 != null ? dArr3[i11] : 0.0d;
                if (!Double.isNaN(this.mTempValue[i11])) {
                    d = this.mTempValue[i11] + d;
                }
                f7 = f13;
                float f18 = (float) d;
                float f19 = (float) this.mTempDelta[i11];
                if (i11 == 1) {
                    f13 = f7;
                    f9 = f18;
                    f14 = f19;
                } else if (i11 == 2) {
                    f13 = f7;
                    f10 = f18;
                    f15 = f19;
                } else if (i11 == 3) {
                    f13 = f7;
                    f11 = f18;
                    f16 = f19;
                } else if (i11 == 4) {
                    f13 = f7;
                    f12 = f18;
                    f17 = f19;
                } else if (i11 == 5) {
                    f13 = f18;
                }
                i11++;
            }
            f13 = f7;
            i11++;
        }
        float f20 = f13;
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motionController.getCenter(f, fArr, fArr2);
            float f21 = fArr[0];
            float f22 = fArr[1];
            float f23 = fArr2[0];
            float f24 = fArr2[1];
            double d6 = f9;
            double d10 = f10;
            float fA = (float) (a.a(d10, d6, f21) - (f11 / 2.0f));
            float fCos = (float) ((f22 - (Math.cos(d10) * d6)) - (f12 / 2.0f));
            double d11 = f23;
            double d12 = f14;
            double d13 = f15;
            float fCos2 = (float) ((Math.cos(d10) * d6 * d13) + a.a(d10, d12, d11));
            float fSin = (float) ((Math.sin(d10) * d6 * d13) + (f24 - (Math.cos(d10) * d12)));
            if (dArr2.length >= 2) {
                dArr2[0] = fCos2;
                dArr2[1] = fSin;
            }
            if (!Float.isNaN(f20)) {
                view.setRotation((float) (Math.toDegrees(Math.atan2(fSin, fCos2)) + f20));
            }
            f9 = fA;
            f10 = fCos;
        } else if (!Float.isNaN(f20)) {
            view.setRotation(f20 + ((float) Math.toDegrees(Math.atan2((f17 / 2.0f) + f15, (f16 / 2.0f) + f14))) + 0.0f);
        }
        if (view instanceof FloatLayout) {
            ((FloatLayout) view).layout(f9, f10, f11 + f9, f12 + f10);
            return;
        }
        float f25 = f9 + 0.5f;
        int i12 = (int) f25;
        float f26 = f10 + 0.5f;
        int i13 = (int) f26;
        int i14 = (int) (f25 + f11);
        int i15 = (int) (f26 + f12);
        int i16 = i14 - i12;
        int i17 = i15 - i13;
        if (i16 != view.getMeasuredWidth() || i17 != view.getMeasuredHeight() || z10) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i16, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(i17, BasicMeasure.EXACTLY));
        }
        view.layout(i12, i13, i14, i15);
    }

    public void setupRelative(MotionController motionController, MotionPaths motionPaths) {
        double d = (((this.mWidth / 2.0f) + this.mX) - motionPaths.mX) - (motionPaths.mWidth / 2.0f);
        double d6 = (((this.mHeight / 2.0f) + this.mY) - motionPaths.mY) - (motionPaths.mHeight / 2.0f);
        this.mRelativeToController = motionController;
        this.mX = (float) Math.hypot(d6, d);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.mY = (float) (Math.atan2(d6, d) + 1.5707963267948966d);
        } else {
            this.mY = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull MotionPaths motionPaths) {
        return Float.compare(this.mPosition, motionPaths.mPosition);
    }

    public MotionPaths(int i, int i6, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        int i10 = Key.UNSET;
        this.mPathMotionArc = i10;
        this.mAnimateRelativeTo = i10;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.mAttributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != Key.UNSET) {
            initPolar(i, i6, keyPosition, motionPaths, motionPaths2);
            return;
        }
        int i11 = keyPosition.mPositionType;
        if (i11 == 1) {
            initPath(keyPosition, motionPaths, motionPaths2);
            return;
        }
        if (i11 == 2) {
            initScreen(i, i6, keyPosition, motionPaths, motionPaths2);
        } else if (i11 != 3) {
            initCartesian(keyPosition, motionPaths, motionPaths2);
        } else {
            initAxis(keyPosition, motionPaths, motionPaths2);
        }
    }

    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f;
        float fA = this.mX;
        float fCos = this.mY;
        float f7 = this.mWidth;
        float f9 = this.mHeight;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f14 = (float) dArr[i];
            float f15 = (float) dArr2[i];
            int i6 = iArr[i];
            if (i6 == 1) {
                fA = f14;
                f10 = f15;
            } else if (i6 == 2) {
                fCos = f14;
                f12 = f15;
            } else if (i6 == 3) {
                f7 = f14;
                f11 = f15;
            } else if (i6 == 4) {
                f9 = f14;
                f13 = f15;
            }
        }
        float f16 = (f11 / 2.0f) + f10;
        float fA2 = (f13 / 2.0f) + f12;
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motionController.getCenter(d, fArr3, fArr4);
            float f17 = fArr3[0];
            float f18 = fArr3[1];
            float f19 = fArr4[0];
            float f20 = fArr4[1];
            double d6 = f17;
            f = 2.0f;
            double d10 = fA;
            double d11 = fCos;
            fA = (float) (a.a(d11, d10, d6) - (f7 / 2.0f));
            fCos = (float) ((f18 - (Math.cos(d11) * d10)) - (f9 / 2.0f));
            double d12 = f19;
            double d13 = f10;
            double d14 = f12;
            float fCos2 = (float) ((Math.cos(d11) * d14) + a.a(d11, d13, d12));
            fA2 = (float) a.a(d11, d14, f20 - (Math.cos(d11) * d13));
            f16 = fCos2;
        } else {
            f = 2.0f;
        }
        fArr[0] = (f7 / f) + fA + 0.0f;
        fArr[1] = (f9 / f) + fCos + 0.0f;
        fArr2[0] = f16;
        fArr2[1] = fA2;
    }
}
