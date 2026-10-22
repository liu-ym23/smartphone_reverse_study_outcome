package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.android.contacts.common.SimContactsConstants;
import com.google.common.base.Ascii;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewSpline extends SplineSet {
    private static final String TAG = "ViewSpline";

    static class AlphaSet extends ViewSpline {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setAlpha(get(t));
        }
    }

    public static class CustomSet extends ViewSpline {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String attribute, SparseArray<ConstraintAttribute> attrList) {
            this.mAttributeName = attribute.split(SimContactsConstants.EMAIL_SEP)[1];
            this.mConstraintAttributeList = attrList;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setup(int curveType) {
            int r0 = this.mConstraintAttributeList.size();
            int r1 = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] r3 = new double[r0];
            this.mTempValues = new float[r1];
            double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r1});
            int r4 = 0;
        L3:
            if (r4 >= r0) goto L9;
            int r5 = this.mConstraintAttributeList.keyAt(r4);
            ConstraintAttribute r6 = this.mConstraintAttributeList.valueAt(r4);
            r3[r4] = ((double) r5) * 0.01d;
            r6.getValuesToInterpolate(this.mTempValues);
            int r7 = 0;
        L5:
            float[] r8 = this.mTempValues;
            if (r7 >= r8.length) goto L8;
            r2[r4][r7] = r8[r7];
            r7 = r7 + 1;
            goto L5
        L8:
            r4 = r4 + 1;
            goto L3
        L9:
            this.mCurveFit = CurveFit.get(curveType, r3, r2);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int position, float value) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setPoint(int position, ConstraintAttribute value) {
            this.mConstraintAttributeList.append(position, value);
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            this.mCurveFit.getPos(t, this.mTempValues);
            CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), view, this.mTempValues);
        }
    }

    static class ElevationSet extends ViewSpline {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setElevation(get(t));
        }
    }

    public static class PathRotate extends ViewSpline {
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
        }

        public PathRotate() {
        }

        public void setPathRotate(View view, float t, double dx, double dy) {
            view.setRotation(get(t) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
        }
    }

    static class PivotXset extends ViewSpline {
        PivotXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setPivotX(get(t));
        }
    }

    static class PivotYset extends ViewSpline {
        PivotYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setPivotY(get(t));
        }
    }

    static class ProgressSet extends ViewSpline {
        boolean mNoMethod;

        ProgressSet() {
            this.mNoMethod = false;
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            if ((view instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) view).setProgress(get(t));
            return;
        L6:
            if (this.mNoMethod == false) goto L20;
            return;
        L20:
            Method r4 = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            if (r4 == null) goto L25;
            r4.invoke(view, new Object[]{Float.valueOf(get(t))});     // Catch: InvocationTargetException -> L15 IllegalAccessException -> L17
        L27:
            return;
        L17:
            e = move-exception;
            Log.e(ViewSpline.TAG, "unable to setProgress", e);
            return;
        L15:
            e = move-exception;
            Log.e(ViewSpline.TAG, "unable to setProgress", e);
            return;
        L25:
            return;
        L11:
            this.mNoMethod = true;
            r4 = null;
            goto L12
        }
    }

    static class RotationSet extends ViewSpline {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setRotation(get(t));
        }
    }

    static class RotationXset extends ViewSpline {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setRotationX(get(t));
        }
    }

    static class RotationYset extends ViewSpline {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setRotationY(get(t));
        }
    }

    static class ScaleXset extends ViewSpline {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setScaleX(get(t));
        }
    }

    static class ScaleYset extends ViewSpline {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setScaleY(get(t));
        }
    }

    static class TranslationXset extends ViewSpline {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setTranslationX(get(t));
        }
    }

    static class TranslationYset extends ViewSpline {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setTranslationY(get(t));
        }
    }

    static class TranslationZset extends ViewSpline {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float t) {
            view.setTranslationZ(get(t));
        }
    }

    public abstract void setProperty(View view, float t);

    public ViewSpline() {
    }

    public static ViewSpline makeCustomSpline(String str, SparseArray<ConstraintAttribute> attrList) {
        return new CustomSet(str, attrList);
    }

    public static ViewSpline makeSpline(String str) {
        str.hashCode();
        byte r1 = -1;
        switch(str.hashCode()) {
            case -1249320806: goto L66;
            case -1249320805: goto L62;
            case -1225497657: goto L58;
            case -1225497656: goto L54;
            case -1225497655: goto L50;
            case -1001078227: goto L46;
            case -908189618: goto L42;
            case -908189617: goto L38;
            case -797520672: goto L34;
            case -760884510: goto L30;
            case -760884509: goto L26;
            case -40300674: goto L22;
            case -4379043: goto L18;
            case 37232917: goto L14;
            case 92909918: goto L10;
            case 156108012: goto L6;
            default: goto L69;
        };
    L69:
        switch(r1) {
            case 0: goto L103;
            case 1: goto L101;
            case 2: goto L99;
            case 3: goto L97;
            case 4: goto L95;
            case 5: goto L93;
            case 6: goto L91;
            case 7: goto L89;
            case 8: goto L87;
            case 9: goto L85;
            case 10: goto L83;
            case 11: goto L81;
            case 12: goto L79;
            case 13: goto L77;
            case 14: goto L75;
            case 15: goto L73;
            default: goto L70;
        };
    L70:
        return null;
    L73:
        return new AlphaSet();
    L75:
        return new AlphaSet();
    L77:
        return new PathRotate();
    L79:
        return new ElevationSet();
    L81:
        return new RotationSet();
    L83:
        return new PivotYset();
    L85:
        return new PivotXset();
    L87:
        return new AlphaSet();
    L89:
        return new ScaleYset();
    L91:
        return new ScaleXset();
    L93:
        return new ProgressSet();
    L95:
        return new TranslationZset();
    L97:
        return new TranslationYset();
    L99:
        return new TranslationXset();
    L101:
        return new RotationYset();
    L103:
        return new RotationXset();
    L6:
        if (str.equals("waveOffset") == false) goto L69;
        r1 = Ascii.SI;
        goto L69
    L10:
        if (str.equals("alpha") == false) goto L69;
        r1 = Ascii.SO;
        goto L69
    L14:
        if (str.equals("transitionPathRotate") == false) goto L69;
        r1 = Ascii.CR;
        goto L69
    L18:
        if (str.equals("elevation") == false) goto L69;
        r1 = Ascii.FF;
        goto L69
    L22:
        if (str.equals("rotation") == false) goto L69;
        r1 = Ascii.VT;
        goto L69
    L26:
        if (str.equals("transformPivotY") == false) goto L69;
        r1 = 10;
        goto L69
    L30:
        if (str.equals("transformPivotX") == false) goto L69;
        r1 = 9;
        goto L69
    L34:
        if (str.equals("waveVariesBy") == false) goto L69;
        r1 = 8;
        goto L69
    L38:
        if (str.equals("scaleY") == false) goto L69;
        r1 = 7;
        goto L69
    L42:
        if (str.equals("scaleX") == false) goto L69;
        r1 = 6;
        goto L69
    L46:
        if (str.equals("progress") == false) goto L69;
        r1 = 5;
        goto L69
    L50:
        if (str.equals("translationZ") == false) goto L69;
        r1 = 4;
        goto L69
    L54:
        if (str.equals("translationY") == false) goto L69;
        r1 = 3;
        goto L69
    L58:
        if (str.equals("translationX") == false) goto L69;
        r1 = 2;
        goto L69
    L62:
        if (str.equals("rotationY") == false) goto L69;
        r1 = 1;
        goto L69
    L66:
        if (str.equals("rotationX") == false) goto L69;
        r1 = 0;
        goto L69
    }
}
