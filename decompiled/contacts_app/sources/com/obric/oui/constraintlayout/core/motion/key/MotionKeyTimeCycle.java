package com.obric.oui.constraintlayout.core.motion.key;

import com.google.common.base.Ascii;
import com.obric.oui.constraintlayout.core.motion.CustomVariable;
import com.obric.oui.constraintlayout.core.motion.utils.SplineSet;
import com.obric.oui.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import com.obric.oui.constraintlayout.core.motion.utils.TypedValues;
import com.obric.oui.constraintlayout.core.motion.utils.Utils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class MotionKeyTimeCycle extends MotionKey {
    public static final int KEY_TYPE = 3;
    static final String NAME = "KeyTimeCycle";
    private static final String TAG = "KeyTimeCycle";
    private float mAlpha;
    private int mCurveFit;
    private String mCustomWaveShape;
    private float mElevation;
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
    private float mWaveOffset;
    private float mWavePeriod;
    private int mWaveShape;

    @Override // com.obric.oui.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> r1) {
    }

    public MotionKeyTimeCycle() {
        this.mCurveFit = -1;
        this.mAlpha = Float.NaN;
        this.mElevation = Float.NaN;
        this.mRotation = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mProgress = Float.NaN;
        this.mWaveShape = 0;
        this.mCustomWaveShape = null;
        this.mWavePeriod = Float.NaN;
        this.mWaveOffset = 0.0f;
        this.mType = 3;
        this.mCustom = new HashMap();
    }

    @Override // com.obric.oui.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo441clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.obric.oui.constraintlayout.core.motion.key.MotionKey
    public /* bridge */ /* synthetic */ MotionKey copy(MotionKey r1) {
        return copy(r1);
    }

    public void addTimeValues(HashMap<String, TimeCycleSplineSet> r11) {
        Iterator<String> r0 = r11.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L101;
        String r1 = r0.next();
        TimeCycleSplineSet r3 = r11.get(r1);
        if (r3 == null) goto L4;
        byte r4 = 7;
        if (r1.startsWith("CUSTOM") == true) goto L10;
        r1.hashCode();
        switch(r1.hashCode()) {
            case -1249320806: goto L60;
            case -1249320805: goto L56;
            case -1249320804: goto L52;
            case -1225497657: goto L48;
            case -1225497656: goto L44;
            case -1225497655: goto L40;
            case -1001078227: goto L36;
            case -908189618: goto L33;
            case -908189617: goto L29;
            case -4379043: goto L25;
            case 92909918: goto L21;
            case 803192288: goto L17;
            default: goto L15;
        };
    L15:
        r4 = -1;
    L63:
        switch(r4) {
            case 0: goto L99;
            case 1: goto L96;
            case 2: goto L93;
            case 3: goto L90;
            case 4: goto L87;
            case 5: goto L84;
            case 6: goto L81;
            case 7: goto L78;
            case 8: goto L75;
            case 9: goto L72;
            case 10: goto L69;
            case 11: goto L66;
            default: goto L64;
        };
    L66:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTransitionPathRotate, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L69:
        if (Float.isNaN(this.mAlpha) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mAlpha, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L72:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L75:
        if (Float.isNaN(this.mScaleY) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mScaleY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L78:
        if (Float.isNaN(this.mScaleX) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mScaleX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L81:
        if (Float.isNaN(this.mProgress) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mProgress, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L84:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L87:
        if (Float.isNaN(this.mTranslationY) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTranslationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L90:
        if (Float.isNaN(this.mTranslationX) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTranslationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L93:
        if (Float.isNaN(this.mRotation) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mRotation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L96:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mRotationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L99:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mRotationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L64:
        Utils.loge("KeyTimeCycles", "UNKNOWN addValues \"" + r1 + "\"");
        goto L4
    L17:
        if (r1.equals("pathRotate") == false) goto L161;
        r4 = Ascii.VT;
        goto L63
    L161:
        r4 = -1;
        goto L63
    L21:
        if (r1.equals("alpha") == false) goto L162;
        r4 = 10;
        goto L63
    L162:
        r4 = -1;
        goto L63
    L25:
        if (r1.equals("elevation") == false) goto L163;
        r4 = 9;
        goto L63
    L163:
        r4 = -1;
        goto L63
    L29:
        if (r1.equals("scaleY") == false) goto L164;
        r4 = 8;
        goto L63
    L164:
        r4 = -1;
        goto L63
    L33:
        if (r1.equals("scaleX") == true) goto L63;
        r4 = -1;
        goto L63
    L36:
        if (r1.equals("progress") == false) goto L166;
        r4 = 6;
        goto L63
    L166:
        r4 = -1;
        goto L63
    L40:
        if (r1.equals("translationZ") == false) goto L167;
        r4 = 5;
        goto L63
    L167:
        r4 = -1;
        goto L63
    L44:
        if (r1.equals("translationY") == false) goto L168;
        r4 = 4;
        goto L63
    L168:
        r4 = -1;
        goto L63
    L48:
        if (r1.equals("translationX") == false) goto L169;
        r4 = 3;
        goto L63
    L169:
        r4 = -1;
        goto L63
    L52:
        if (r1.equals("rotationZ") == false) goto L170;
        r4 = 2;
        goto L63
    L170:
        r4 = -1;
        goto L63
    L56:
        if (r1.equals("rotationY") == false) goto L171;
        r4 = 1;
        goto L63
    L171:
        r4 = -1;
        goto L63
    L60:
        if (r1.equals("rotationX") == false) goto L172;
        r4 = 0;
        goto L63
    L172:
        r4 = -1;
        goto L63
    L10:
        CustomVariable r6 = this.mCustom.get(r1.substring(7));
        if (r6 == null) goto L4;
        ((TimeCycleSplineSet.CustomVarSet) r3).setPoint(this.mFramePosition, r6, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.core.motion.key.MotionKey, com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, int r3) {
        if (r2 != 100) goto L5;
        this.mFramePosition = r3;
        return true;
    L5:
        if (r2 != 421) goto L7;
        this.mWaveShape = r3;
        return true;
    L7:
        return super.setValue(r2, r3);
    }

    @Override // com.obric.oui.constraintlayout.core.motion.key.MotionKey, com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, float r3) {
        if (r2 != 315) goto L5;
        this.mProgress = toFloat(Float.valueOf(r3));
        return true;
    L5:
        if (r2 != 401) goto L7;
        this.mCurveFit = toInt(Float.valueOf(r3));
        return true;
    L7:
        if (r2 != 403) goto L9;
        this.mAlpha = r3;
        return true;
    L9:
        if (r2 != 416) goto L11;
        this.mTransitionPathRotate = toFloat(Float.valueOf(r3));
        return true;
    L11:
        if (r2 != 423) goto L13;
        this.mWavePeriod = toFloat(Float.valueOf(r3));
        return true;
    L13:
        if (r2 == 424) goto L26;
        switch(r2) {
            case 304: goto L25;
            case 305: goto L24;
            case 306: goto L23;
            case 307: goto L22;
            case 308: goto L21;
            case 309: goto L20;
            case 310: goto L19;
            case 311: goto L18;
            case 312: goto L17;
            default: goto L16;
        };
    L17:
        this.mScaleY = toFloat(Float.valueOf(r3));
        return true;
    L18:
        this.mScaleX = toFloat(Float.valueOf(r3));
        return true;
    L19:
        this.mRotation = toFloat(Float.valueOf(r3));
        return true;
    L20:
        this.mRotationY = toFloat(Float.valueOf(r3));
        return true;
    L21:
        this.mRotationX = toFloat(Float.valueOf(r3));
        return true;
    L22:
        this.mElevation = toFloat(Float.valueOf(r3));
        return true;
    L23:
        this.mTranslationZ = toFloat(Float.valueOf(r3));
        return true;
    L24:
        this.mTranslationY = toFloat(Float.valueOf(r3));
        return true;
    L25:
        this.mTranslationX = toFloat(Float.valueOf(r3));
        return true;
    L16:
        return super.setValue(r2, r3);
    L26:
        this.mWaveOffset = toFloat(Float.valueOf(r3));
        return true;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.key.MotionKey, com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, String r3) {
        if (r2 != 420) goto L5;
        this.mTransitionEasing = r3;
        return true;
    L5:
        if (r2 != 421) goto L7;
        this.mWaveShape = 7;
        this.mCustomWaveShape = r3;
        return true;
    L7:
        return super.setValue(r2, r3);
    }

    @Override // com.obric.oui.constraintlayout.core.motion.key.MotionKey, com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, boolean r2) {
        return super.setValue(r1, r2);
    }

    @Override // com.obric.oui.constraintlayout.core.motion.key.MotionKey
    public MotionKeyTimeCycle copy(MotionKey r2) {
        super.copy(r2);
        MotionKeyTimeCycle r3 = (MotionKeyTimeCycle) r2;
        this.mTransitionEasing = r3.mTransitionEasing;
        this.mCurveFit = r3.mCurveFit;
        this.mWaveShape = r3.mWaveShape;
        this.mWavePeriod = r3.mWavePeriod;
        this.mWaveOffset = r3.mWaveOffset;
        this.mProgress = r3.mProgress;
        this.mAlpha = r3.mAlpha;
        this.mElevation = r3.mElevation;
        this.mRotation = r3.mRotation;
        this.mTransitionPathRotate = r3.mTransitionPathRotate;
        this.mRotationX = r3.mRotationX;
        this.mRotationY = r3.mRotationY;
        this.mScaleX = r3.mScaleX;
        this.mScaleY = r3.mScaleY;
        this.mTranslationX = r3.mTranslationX;
        this.mTranslationY = r3.mTranslationY;
        this.mTranslationZ = r3.mTranslationZ;
        return this;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.key.MotionKey
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
        if (Float.isNaN(this.mScaleX) == true) goto L21;
        r4.add("scaleX");
    L21:
        if (Float.isNaN(this.mScaleY) == true) goto L24;
        r4.add("scaleY");
    L24:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L27;
        r4.add("pathRotate");
    L27:
        if (Float.isNaN(this.mTranslationX) == true) goto L30;
        r4.add("translationX");
    L30:
        if (Float.isNaN(this.mTranslationY) == true) goto L33;
        r4.add("translationY");
    L33:
        if (Float.isNaN(this.mTranslationZ) == true) goto L36;
        r4.add("translationZ");
    L36:
        if (this.mCustom.size() <= 0) goto L41;
        Iterator<String> r3 = this.mCustom.keySet().iterator();
    L39:
        if (r3.hasNext() == false) goto L43;
        r4.add("CUSTOM," + r3.next());
        goto L39
    L43:
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return new MotionKeyTimeCycle().copy(this);
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r1) {
        return TypedValues.CycleType.getId(r1);
    }
}
