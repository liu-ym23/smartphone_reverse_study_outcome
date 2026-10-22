package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.contacts.common.SimContactsConstants;
import com.google.common.base.Ascii;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MotionKeyAttributes extends MotionKey {
    private static final boolean DEBUG = false;
    public static final int KEY_TYPE = 1;
    static final String NAME = "KeyAttribute";
    private static final String TAG = "KeyAttributes";
    private float mAlpha;
    private int mCurveFit;
    private float mElevation;
    private float mPivotX;
    private float mPivotY;
    private float mProgress;
    private float mRotation;
    private float mRotationX;
    private float mRotationY;
    private float mScaleX;
    private float mScaleY;
    private String mTransitionEasing;
    private float mTransitionPathRotate;
    private float mTranslationX;
    private float mTranslationY;
    private float mTranslationZ;
    private int mVisibility;

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return null;
    }

    public MotionKeyAttributes() {
        this.mCurveFit = -1;
        this.mVisibility = 0;
        this.mAlpha = Float.NaN;
        this.mElevation = Float.NaN;
        this.mRotation = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mProgress = Float.NaN;
        this.mType = 1;
        this.mCustom = new HashMap();
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> r4) {
        if (Float.isNaN(this.mAlpha) == true) goto L6;
        r4.add("alpha");
    L6:
        if (Float.isNaN(this.mElevation) == true) goto L9;
        r4.add("elevation");
    L9:
        if (Float.isNaN(this.mRotation) == true) goto L12;
        r4.add("rotationZ");
    L12:
        if (Float.isNaN(this.mRotationX) == true) goto L15;
        r4.add("rotationX");
    L15:
        if (Float.isNaN(this.mRotationY) == true) goto L18;
        r4.add("rotationY");
    L18:
        if (Float.isNaN(this.mPivotX) == true) goto L21;
        r4.add("pivotX");
    L21:
        if (Float.isNaN(this.mPivotY) == true) goto L24;
        r4.add("pivotY");
    L24:
        if (Float.isNaN(this.mTranslationX) == true) goto L27;
        r4.add("translationX");
    L27:
        if (Float.isNaN(this.mTranslationY) == true) goto L30;
        r4.add("translationY");
    L30:
        if (Float.isNaN(this.mTranslationZ) == true) goto L33;
        r4.add("translationZ");
    L33:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L36;
        r4.add("pathRotate");
    L36:
        if (Float.isNaN(this.mScaleX) == true) goto L39;
        r4.add("scaleX");
    L39:
        if (Float.isNaN(this.mScaleY) == true) goto L42;
        r4.add("scaleY");
    L42:
        if (Float.isNaN(this.mProgress) == true) goto L45;
        r4.add("progress");
    L45:
        if (this.mCustom.size() <= 0) goto L50;
        Iterator<String> r3 = this.mCustom.keySet().iterator();
    L48:
        if (r3.hasNext() == false) goto L52;
        r4.add("CUSTOM," + r3.next());
        goto L48
    L52:
        return;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> r7) {
        Iterator<String> r0 = r7.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L115;
        String r1 = r0.next();
        SplineSet r2 = r7.get(r1);
        if (r2 == null) goto L4;
        byte r4 = 7;
        if (r1.startsWith("CUSTOM") == true) goto L10;
        r1.hashCode();
        switch(r1.hashCode()) {
            case -1249320806: goto L68;
            case -1249320805: goto L64;
            case -1249320804: goto L60;
            case -1225497657: goto L56;
            case -1225497656: goto L52;
            case -1225497655: goto L48;
            case -1001078227: goto L44;
            case -987906986: goto L41;
            case -987906985: goto L37;
            case -908189618: goto L33;
            case -908189617: goto L29;
            case -4379043: goto L25;
            case 92909918: goto L21;
            case 803192288: goto L17;
            default: goto L15;
        };
    L15:
        r4 = -1;
    L71:
        switch(r4) {
            case 0: goto L113;
            case 1: goto L110;
            case 2: goto L107;
            case 3: goto L104;
            case 4: goto L101;
            case 5: goto L98;
            case 6: goto L95;
            case 7: goto L92;
            case 8: goto L89;
            case 9: goto L86;
            case 10: goto L83;
            case 11: goto L80;
            case 12: goto L77;
            case 13: goto L74;
            default: goto L72;
        };
    L74:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mTransitionPathRotate);
        goto L4
    L77:
        if (Float.isNaN(this.mAlpha) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mAlpha);
        goto L4
    L80:
        if (Float.isNaN(this.mElevation) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mElevation);
        goto L4
    L83:
        if (Float.isNaN(this.mScaleY) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mScaleY);
        goto L4
    L86:
        if (Float.isNaN(this.mScaleX) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mScaleX);
        goto L4
    L89:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mPivotY);
        goto L4
    L92:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mPivotX);
        goto L4
    L95:
        if (Float.isNaN(this.mProgress) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mProgress);
        goto L4
    L98:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mTranslationZ);
        goto L4
    L101:
        if (Float.isNaN(this.mTranslationY) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mTranslationY);
        goto L4
    L104:
        if (Float.isNaN(this.mTranslationX) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mTranslationX);
        goto L4
    L107:
        if (Float.isNaN(this.mRotation) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mRotation);
        goto L4
    L110:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mRotationY);
        goto L4
    L113:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r2.setPoint(this.mFramePosition, this.mRotationX);
        goto L4
    L72:
        System.err.println("not supported by KeyAttributes " + r1);
        goto L4
    L17:
        if (r1.equals("pathRotate") == false) goto L183;
        r4 = Ascii.CR;
        goto L71
    L183:
        r4 = -1;
        goto L71
    L21:
        if (r1.equals("alpha") == false) goto L184;
        r4 = Ascii.FF;
        goto L71
    L184:
        r4 = -1;
        goto L71
    L25:
        if (r1.equals("elevation") == false) goto L185;
        r4 = Ascii.VT;
        goto L71
    L185:
        r4 = -1;
        goto L71
    L29:
        if (r1.equals("scaleY") == false) goto L186;
        r4 = 10;
        goto L71
    L186:
        r4 = -1;
        goto L71
    L33:
        if (r1.equals("scaleX") == false) goto L187;
        r4 = 9;
        goto L71
    L187:
        r4 = -1;
        goto L71
    L37:
        if (r1.equals("pivotY") == false) goto L188;
        r4 = 8;
        goto L71
    L188:
        r4 = -1;
        goto L71
    L41:
        if (r1.equals("pivotX") == true) goto L71;
        r4 = -1;
        goto L71
    L44:
        if (r1.equals("progress") == false) goto L190;
        r4 = 6;
        goto L71
    L190:
        r4 = -1;
        goto L71
    L48:
        if (r1.equals("translationZ") == false) goto L191;
        r4 = 5;
        goto L71
    L191:
        r4 = -1;
        goto L71
    L52:
        if (r1.equals("translationY") == false) goto L192;
        r4 = 4;
        goto L71
    L192:
        r4 = -1;
        goto L71
    L56:
        if (r1.equals("translationX") == false) goto L193;
        r4 = 3;
        goto L71
    L193:
        r4 = -1;
        goto L71
    L60:
        if (r1.equals("rotationZ") == false) goto L194;
        r4 = 2;
        goto L71
    L194:
        r4 = -1;
        goto L71
    L64:
        if (r1.equals("rotationY") == false) goto L195;
        r4 = 1;
        goto L71
    L195:
        r4 = -1;
        goto L71
    L68:
        if (r1.equals("rotationX") == false) goto L196;
        r4 = 0;
        goto L71
    L196:
        r4 = -1;
        goto L71
    L10:
        CustomVariable r3 = this.mCustom.get(r1.substring(7));
        if (r3 == null) goto L4;
        ((SplineSet.CustomSpline) r2).setPoint(this.mFramePosition, r3);
        goto L4
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, int r3) {
        if (r2 != 100) goto L5;
        this.mFramePosition = r3;
        return true;
    L5:
        if (r2 != 301) goto L7;
        this.mCurveFit = r3;
        return true;
    L7:
        if (r2 != 302) goto L9;
        this.mVisibility = r3;
        return true;
    L9:
        if (setValue(r2, r3) == false) goto L11;
        return true;
    L11:
        return super.setValue(r2, r3);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, float r3) {
        if (r2 == 100) goto L21;
        switch(r2) {
            case 303: goto L20;
            case 304: goto L19;
            case 305: goto L18;
            case 306: goto L17;
            case 307: goto L16;
            case 308: goto L15;
            case 309: goto L14;
            case 310: goto L13;
            case 311: goto L12;
            case 312: goto L11;
            case 313: goto L10;
            case 314: goto L9;
            case 315: goto L8;
            case 316: goto L7;
            default: goto L6;
        };
    L7:
        this.mTransitionPathRotate = r3;
        return true;
    L8:
        this.mProgress = r3;
        return true;
    L9:
        this.mPivotY = r3;
        return true;
    L10:
        this.mPivotX = r3;
        return true;
    L11:
        this.mScaleY = r3;
        return true;
    L12:
        this.mScaleX = r3;
        return true;
    L13:
        this.mRotation = r3;
        return true;
    L14:
        this.mRotationY = r3;
        return true;
    L15:
        this.mRotationX = r3;
        return true;
    L16:
        this.mElevation = r3;
        return true;
    L17:
        this.mTranslationZ = r3;
        return true;
    L18:
        this.mTranslationY = r3;
        return true;
    L19:
        this.mTranslationX = r3;
        return true;
    L20:
        this.mAlpha = r3;
        return true;
    L6:
        return super.setValue(r2, r3);
    L21:
        this.mTransitionPathRotate = r3;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void setInterpolation(HashMap<String, Integer> r5) {
        if (Float.isNaN(this.mAlpha) == true) goto L6;
        r5.put("alpha", Integer.valueOf(this.mCurveFit));
    L6:
        if (Float.isNaN(this.mElevation) == true) goto L9;
        r5.put("elevation", Integer.valueOf(this.mCurveFit));
    L9:
        if (Float.isNaN(this.mRotation) == true) goto L12;
        r5.put("rotationZ", Integer.valueOf(this.mCurveFit));
    L12:
        if (Float.isNaN(this.mRotationX) == true) goto L15;
        r5.put("rotationX", Integer.valueOf(this.mCurveFit));
    L15:
        if (Float.isNaN(this.mRotationY) == true) goto L18;
        r5.put("rotationY", Integer.valueOf(this.mCurveFit));
    L18:
        if (Float.isNaN(this.mPivotX) == true) goto L21;
        r5.put("pivotX", Integer.valueOf(this.mCurveFit));
    L21:
        if (Float.isNaN(this.mPivotY) == true) goto L24;
        r5.put("pivotY", Integer.valueOf(this.mCurveFit));
    L24:
        if (Float.isNaN(this.mTranslationX) == true) goto L27;
        r5.put("translationX", Integer.valueOf(this.mCurveFit));
    L27:
        if (Float.isNaN(this.mTranslationY) == true) goto L30;
        r5.put("translationY", Integer.valueOf(this.mCurveFit));
    L30:
        if (Float.isNaN(this.mTranslationZ) == true) goto L33;
        r5.put("translationZ", Integer.valueOf(this.mCurveFit));
    L33:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L36;
        r5.put("pathRotate", Integer.valueOf(this.mCurveFit));
    L36:
        if (Float.isNaN(this.mScaleX) == true) goto L39;
        r5.put("scaleX", Integer.valueOf(this.mCurveFit));
    L39:
        if (Float.isNaN(this.mScaleY) == true) goto L42;
        r5.put("scaleY", Integer.valueOf(this.mCurveFit));
    L42:
        if (Float.isNaN(this.mProgress) == true) goto L45;
        r5.put("progress", Integer.valueOf(this.mCurveFit));
    L45:
        if (this.mCustom.size() <= 0) goto L50;
        Iterator<String> r0 = this.mCustom.keySet().iterator();
    L48:
        if (r0.hasNext() == false) goto L52;
        r5.put("CUSTOM," + r0.next(), Integer.valueOf(this.mCurveFit));
        goto L48
    L52:
        return;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, String r3) {
        if (r2 != 101) goto L5;
        this.mTargetString = r3;
        return true;
    L5:
        if (r2 != 317) goto L7;
        this.mTransitionEasing = r3;
        return true;
    L7:
        return super.setValue(r2, r3);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r1) {
        return TypedValues.AttributesType.getId(r1);
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    public void printAttributes() {
        HashSet<String> r0 = new HashSet();
        getAttributeNames(r0);
        System.out.println(" ------------- " + this.mFramePosition + " -------------");
        int r1 = 0;
        String[] r2 = (String[]) r0.toArray(new String[0]);
    L4:
        if (r1 >= r2.length) goto L6;
        System.out.println(r2[r1] + SimContactsConstants.ANR_SEP + getFloatValue(TypedValues.AttributesType.getId(r2[r1])));
        r1 = r1 + 1;
        goto L4
    }

    private float getFloatValue(int r2) {
        if (r2 == 100) goto L36;
        switch(r2) {
            case 303: goto L34;
            case 304: goto L32;
            case 305: goto L30;
            case 306: goto L28;
            case 307: goto L26;
            case 308: goto L24;
            case 309: goto L22;
            case 310: goto L20;
            case 311: goto L18;
            case 312: goto L16;
            case 313: goto L14;
            case 314: goto L12;
            case 315: goto L10;
            case 316: goto L8;
            default: goto L5;
        };
    L5:
        return Float.NaN;
    L8:
        return this.mTransitionPathRotate;
    L10:
        return this.mProgress;
    L12:
        return this.mPivotY;
    L14:
        return this.mPivotX;
    L16:
        return this.mScaleY;
    L18:
        return this.mScaleX;
    L20:
        return this.mRotation;
    L22:
        return this.mRotationY;
    L24:
        return this.mRotationX;
    L26:
        return this.mElevation;
    L28:
        return this.mTranslationZ;
    L30:
        return this.mTranslationY;
    L32:
        return this.mTranslationX;
    L34:
        return this.mAlpha;
    L36:
        return this.mFramePosition;
    }
}
