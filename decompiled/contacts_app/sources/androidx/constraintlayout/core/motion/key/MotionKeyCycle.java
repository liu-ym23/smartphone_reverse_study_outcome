package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import com.android.contacts.common.SimContactsConstants;
import com.google.common.base.Ascii;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MotionKeyCycle extends MotionKey {
    public static final int KEY_TYPE = 4;
    static final String NAME = "KeyCycle";
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    private static final String TAG = "KeyCycle";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_SHAPE = "waveShape";
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
    private float mWavePhase;
    private int mWaveShape;

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> r1) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return null;
    }

    public MotionKeyCycle() {
        this.mTransitionEasing = null;
        this.mCurveFit = 0;
        this.mWaveShape = -1;
        this.mCustomWaveShape = null;
        this.mWavePeriod = Float.NaN;
        this.mWaveOffset = 0.0f;
        this.mWavePhase = 0.0f;
        this.mProgress = Float.NaN;
        this.mAlpha = Float.NaN;
        this.mElevation = Float.NaN;
        this.mRotation = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mType = 4;
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

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r3, int r4) {
        if (r3 != 401) goto L5;
        this.mCurveFit = r4;
        return true;
    L5:
        if (r3 != 421) goto L7;
        this.mWaveShape = r4;
        return true;
    L7:
        if (setValue(r3, r4) == false) goto L10;
        return true;
    L10:
        return super.setValue(r3, r4);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r3, String r4) {
        if (r3 != 420) goto L5;
        this.mTransitionEasing = r4;
        return true;
    L5:
        if (r3 != 422) goto L7;
        this.mCustomWaveShape = r4;
        return true;
    L7:
        return super.setValue(r3, r4);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, float r3) {
        if (r2 != 315) goto L5;
        this.mProgress = r3;
        return true;
    L5:
        if (r2 != 403) goto L7;
        this.mAlpha = r3;
        return true;
    L7:
        if (r2 == 416) goto L24;
        switch(r2) {
            case 304: goto L23;
            case 305: goto L22;
            case 306: goto L21;
            case 307: goto L20;
            case 308: goto L19;
            case 309: goto L18;
            case 310: goto L17;
            case 311: goto L16;
            case 312: goto L15;
            default: goto L9;
        };
    L9:
        switch(r2) {
            case 423: goto L14;
            case 424: goto L13;
            case 425: goto L12;
            default: goto L11;
        };
    L12:
        this.mWavePhase = r3;
        return true;
    L13:
        this.mWaveOffset = r3;
        return true;
    L14:
        this.mWavePeriod = r3;
        return true;
    L11:
        return super.setValue(r2, r3);
    L15:
        this.mScaleY = r3;
        return true;
    L16:
        this.mScaleX = r3;
        return true;
    L17:
        this.mRotation = r3;
        return true;
    L18:
        this.mRotationY = r3;
        return true;
    L19:
        this.mRotationX = r3;
        return true;
    L20:
        this.mElevation = r3;
        return true;
    L21:
        this.mTranslationZ = r3;
        return true;
    L22:
        this.mTranslationY = r3;
        return true;
    L23:
        this.mTranslationX = r3;
        return true;
    L24:
        this.mTransitionPathRotate = r3;
        return true;
    }

    public float getValue(String r3) {
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -1249320806: goto L58;
            case -1249320805: goto L54;
            case -1249320804: goto L50;
            case -1225497657: goto L46;
            case -1225497656: goto L42;
            case -1225497655: goto L38;
            case -1019779949: goto L34;
            case -1001078227: goto L30;
            case -908189618: goto L26;
            case -908189617: goto L22;
            case -4379043: goto L18;
            case 92909918: goto L14;
            case 106629499: goto L10;
            case 803192288: goto L6;
            default: goto L61;
        };
    L61:
        switch(r1) {
            case 0: goto L91;
            case 1: goto L89;
            case 2: goto L87;
            case 3: goto L85;
            case 4: goto L83;
            case 5: goto L81;
            case 6: goto L79;
            case 7: goto L77;
            case 8: goto L75;
            case 9: goto L73;
            case 10: goto L71;
            case 11: goto L69;
            case 12: goto L67;
            case 13: goto L65;
            default: goto L62;
        };
    L62:
        return Float.NaN;
    L65:
        return this.mTransitionPathRotate;
    L67:
        return this.mWavePhase;
    L69:
        return this.mAlpha;
    L71:
        return this.mElevation;
    L73:
        return this.mScaleY;
    L75:
        return this.mScaleX;
    L77:
        return this.mProgress;
    L79:
        return this.mWaveOffset;
    L81:
        return this.mTranslationZ;
    L83:
        return this.mTranslationY;
    L85:
        return this.mTranslationX;
    L87:
        return this.mRotation;
    L89:
        return this.mRotationY;
    L91:
        return this.mRotationX;
    L6:
        if (r3.equals("pathRotate") == false) goto L61;
        r1 = Ascii.CR;
        goto L61
    L10:
        if (r3.equals("phase") == false) goto L61;
        r1 = Ascii.FF;
        goto L61
    L14:
        if (r3.equals("alpha") == false) goto L61;
        r1 = Ascii.VT;
        goto L61
    L18:
        if (r3.equals("elevation") == false) goto L61;
        r1 = 10;
        goto L61
    L22:
        if (r3.equals("scaleY") == false) goto L61;
        r1 = 9;
        goto L61
    L26:
        if (r3.equals("scaleX") == false) goto L61;
        r1 = 8;
        goto L61
    L30:
        if (r3.equals("progress") == false) goto L61;
        r1 = 7;
        goto L61
    L34:
        if (r3.equals("offset") == false) goto L61;
        r1 = 6;
        goto L61
    L38:
        if (r3.equals("translationZ") == false) goto L61;
        r1 = 5;
        goto L61
    L42:
        if (r3.equals("translationY") == false) goto L61;
        r1 = 4;
        goto L61
    L46:
        if (r3.equals("translationX") == false) goto L61;
        r1 = 3;
        goto L61
    L50:
        if (r3.equals("rotationZ") == false) goto L61;
        r1 = 2;
        goto L61
    L54:
        if (r3.equals("rotationY") == false) goto L61;
        r1 = 1;
        goto L61
    L58:
        if (r3.equals("rotationX") == false) goto L61;
        r1 = 0;
        goto L61
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r2) {
        r2.hashCode();
        switch(r2.hashCode()) {
            case -1581616630: goto L86;
            case -1310311125: goto L82;
            case -1249320806: goto L78;
            case -1249320805: goto L74;
            case -1249320804: goto L70;
            case -1225497657: goto L66;
            case -1225497656: goto L62;
            case -1225497655: goto L58;
            case -1019779949: goto L54;
            case -1001078227: goto L50;
            case -991726143: goto L46;
            case -987906986: goto L42;
            case -987906985: goto L38;
            case -908189618: goto L34;
            case -908189617: goto L30;
            case 92909918: goto L26;
            case 106629499: goto L22;
            case 579057826: goto L18;
            case 803192288: goto L14;
            case 1532805160: goto L10;
            case 1941332754: goto L6;
            default: goto L4;
        };
    L4:
        byte r1 = -1;
    L89:
        switch(r1) {
            case 0: goto L131;
            case 1: goto L129;
            case 2: goto L127;
            case 3: goto L125;
            case 4: goto L123;
            case 5: goto L121;
            case 6: goto L119;
            case 7: goto L117;
            case 8: goto L115;
            case 9: goto L113;
            case 10: goto L111;
            case 11: goto L109;
            case 12: goto L107;
            case 13: goto L105;
            case 14: goto L103;
            case 15: goto L101;
            case 16: goto L99;
            case 17: goto L97;
            case 18: goto L95;
            case 19: goto L93;
            case 20: goto L91;
            default: goto L90;
        };
    L90:
        return -1;
    L91:
        return 402;
    L93:
        return 421;
    L95:
        return 416;
    L97:
        return 401;
    L99:
        return 425;
    L101:
        return 403;
    L103:
        return 312;
    L105:
        return 311;
    L107:
        return 314;
    L109:
        return 313;
    L111:
        return 423;
    L113:
        return 315;
    L115:
        return 424;
    L117:
        return 306;
    L119:
        return 305;
    L121:
        return 304;
    L123:
        return 310;
    L125:
        return 309;
    L127:
        return 308;
    L129:
        return 420;
    L131:
        return 422;
    L6:
        if (r2.equals("visibility") == false) goto L133;
        r1 = Ascii.DC4;
        goto L89
    L133:
        r1 = -1;
        goto L89
    L10:
        if (r2.equals("waveShape") == false) goto L134;
        r1 = 19;
        goto L89
    L134:
        r1 = -1;
        goto L89
    L14:
        if (r2.equals("pathRotate") == false) goto L135;
        r1 = Ascii.DC2;
        goto L89
    L135:
        r1 = -1;
        goto L89
    L18:
        if (r2.equals("curveFit") == false) goto L136;
        r1 = 17;
        goto L89
    L136:
        r1 = -1;
        goto L89
    L22:
        if (r2.equals("phase") == false) goto L137;
        r1 = Ascii.DLE;
        goto L89
    L137:
        r1 = -1;
        goto L89
    L26:
        if (r2.equals("alpha") == false) goto L138;
        r1 = Ascii.SI;
        goto L89
    L138:
        r1 = -1;
        goto L89
    L30:
        if (r2.equals("scaleY") == false) goto L139;
        r1 = Ascii.SO;
        goto L89
    L139:
        r1 = -1;
        goto L89
    L34:
        if (r2.equals("scaleX") == false) goto L140;
        r1 = Ascii.CR;
        goto L89
    L140:
        r1 = -1;
        goto L89
    L38:
        if (r2.equals("pivotY") == false) goto L141;
        r1 = Ascii.FF;
        goto L89
    L141:
        r1 = -1;
        goto L89
    L42:
        if (r2.equals("pivotX") == false) goto L142;
        r1 = Ascii.VT;
        goto L89
    L142:
        r1 = -1;
        goto L89
    L46:
        if (r2.equals("period") == false) goto L143;
        r1 = 10;
        goto L89
    L143:
        r1 = -1;
        goto L89
    L50:
        if (r2.equals("progress") == false) goto L144;
        r1 = 9;
        goto L89
    L144:
        r1 = -1;
        goto L89
    L54:
        if (r2.equals("offset") == false) goto L145;
        r1 = 8;
        goto L89
    L145:
        r1 = -1;
        goto L89
    L58:
        if (r2.equals("translationZ") == false) goto L146;
        r1 = 7;
        goto L89
    L146:
        r1 = -1;
        goto L89
    L62:
        if (r2.equals("translationY") == false) goto L147;
        r1 = 6;
        goto L89
    L147:
        r1 = -1;
        goto L89
    L66:
        if (r2.equals("translationX") == false) goto L148;
        r1 = 5;
        goto L89
    L148:
        r1 = -1;
        goto L89
    L70:
        if (r2.equals("rotationZ") == false) goto L149;
        r1 = 4;
        goto L89
    L149:
        r1 = -1;
        goto L89
    L74:
        if (r2.equals("rotationY") == false) goto L150;
        r1 = 3;
        goto L89
    L150:
        r1 = -1;
        goto L89
    L78:
        if (r2.equals("rotationX") == false) goto L151;
        r1 = 2;
        goto L89
    L151:
        r1 = -1;
        goto L89
    L82:
        if (r2.equals("easing") == false) goto L152;
        r1 = 1;
        goto L89
    L152:
        r1 = -1;
        goto L89
    L86:
        if (r2.equals("customWave") == false) goto L153;
        r1 = 0;
        goto L89
    L153:
        r1 = -1;
        goto L89
    }

    public void addCycleValues(HashMap<String, KeyCycleOscillator> r25) {
        Iterator<String> r2 = r25.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L23;
        String r3 = r2.next();
        if (r3.startsWith("CUSTOM") == true) goto L7;
        float r23 = getValue(r3);
        if (Float.isNaN(r23) == true) goto L4;
        KeyCycleOscillator r15 = r25.get(r3);
        if (r15 == null) goto L4;
        r15.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, -1, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, r23);
        goto L4
    L7:
        String r4 = r3.substring(7);
        CustomVariable r14 = this.mCustom.get(r4);
        if (r14 == null) goto L4;
        if (r14.getType() != 901) goto L4;
        KeyCycleOscillator r5 = r25.get(r3);
        if (r5 == null) goto L4;
        r5.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, -1, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, r14.getValueToInterpolate(), r14);
        goto L4
    }

    public void dump() {
        System.out.println("MotionKeyCycle{mWaveShape=" + this.mWaveShape + ", mWavePeriod=" + this.mWavePeriod + ", mWaveOffset=" + this.mWaveOffset + ", mWavePhase=" + this.mWavePhase + ", mRotation=" + this.mRotation + '}');
    }

    public void printAttributes() {
        HashSet<String> r0 = new HashSet();
        getAttributeNames(r0);
        Utils.log(" ------------- " + this.mFramePosition + " -------------");
        Utils.log("MotionKeyCycle{Shape=" + this.mWaveShape + ", Period=" + this.mWavePeriod + ", Offset=" + this.mWaveOffset + ", Phase=" + this.mWavePhase + '}');
        int r1 = 0;
        String[] r2 = (String[]) r0.toArray(new String[0]);
    L4:
        if (r1 >= r2.length) goto L6;
        TypedValues.AttributesType.getId(r2[r1]);
        Utils.log(r2[r1] + SimContactsConstants.ANR_SEP + getValue(r2[r1]));
        r1 = r1 + 1;
        goto L4
    }
}
