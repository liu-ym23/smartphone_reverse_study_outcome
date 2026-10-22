package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes17.dex */
public class KeyTrigger extends Key {
    public static final int KEY_TYPE = 5;
    static final String NAME = "KeyTrigger";
    private static final String TAG = "KeyTrigger";
    RectF mCollisionRect;
    private String mCross;
    private int mCurveFit;
    private Method mFireCross;
    private boolean mFireCrossReset;
    private float mFireLastPos;
    private Method mFireNegativeCross;
    private boolean mFireNegativeReset;
    private Method mFirePositiveCross;
    private boolean mFirePositiveReset;
    private float mFireThreshold;
    private String mNegativeCross;
    private String mPositiveCross;
    private boolean mPostLayout;
    RectF mTargetRect;
    private int mTriggerCollisionId;
    private View mTriggerCollisionView;
    private int mTriggerID;
    private int mTriggerReceiver;
    float mTriggerSlack;

    public static class Loader {
        private static final int COLLISION = 9;
        private static final int CROSS = 4;
        private static final int FRAME_POS = 8;
        private static final int NEGATIVE_CROSS = 1;
        private static final int POSITIVE_CROSS = 2;
        private static final int POST_LAYOUT = 10;
        private static final int TARGET_ID = 7;
        private static final int TRIGGER_ID = 6;
        private static final int TRIGGER_RECEIVER = 11;
        private static final int TRIGGER_SLACK = 5;
        private static SparseIntArray mAttrMap;

        private Loader() {
        }

        static {
            SparseIntArray r100 = new SparseIntArray();
            mAttrMap = r100;
            r100.append(0, 8);
            mAttrMap.append(4, 4);
            mAttrMap.append(5, 1);
            mAttrMap.append(6, 2);
            mAttrMap.append(1, 7);
            mAttrMap.append(7, 6);
            mAttrMap.append(9, 5);
            mAttrMap.append(3, 9);
            mAttrMap.append(2, 10);
            mAttrMap.append(8, 11);
        }

        public static void read(KeyTrigger r100, TypedArray r101, Context r102) {
            int r103 = r101.getIndexCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L27;
            int r105 = r101.getIndex(r104);
            switch(mAttrMap.get(r105)) {
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L25;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L20;
                case 7: goto L12;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L25;
            };
        L7:
            KeyTrigger.access$702(r100, r101.getResourceId(r105, KeyTrigger.access$700(r100)));
            goto L25
        L8:
            KeyTrigger.access$602(r100, r101.getBoolean(r105, KeyTrigger.access$600(r100)));
        L26:
            r104 = r104 + 1;
            goto L3
        L9:
            KeyTrigger.access$502(r100, r101.getResourceId(r105, KeyTrigger.access$500(r100)));
            goto L26
        L10:
            int r106 = r101.getInteger(r105, r100.mFramePosition);
            r100.mFramePosition = r106;
            KeyTrigger.access$002(r100, (r106 + 0.5f) / 100.0f);
            goto L26
        L20:
            KeyTrigger.access$402(r100, r101.getResourceId(r105, KeyTrigger.access$400(r100)));
            goto L26
        L21:
            r100.mTriggerSlack = r101.getFloat(r105, r100.mTriggerSlack);
            goto L26
        L22:
            KeyTrigger.access$302(r100, r101.getString(r105));
            goto L26
        L23:
            KeyTrigger.access$202(r100, r101.getString(r105));
            goto L26
        L24:
            KeyTrigger.access$102(r100, r101.getString(r105));
        L25:
            Integer.toHexString(r105);
            mAttrMap.get(r105);
            goto L26
        L12:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L17;
            int r107 = r101.getResourceId(r105, r100.mTargetId);
            r100.mTargetId = r107;
            if (r107 != (-1)) goto L26;
            r100.mTargetString = r101.getString(r105);
            goto L26
        L17:
            if (r101.peekValue(r105).type != 3) goto L19;
            r100.mTargetString = r101.getString(r105);
            goto L26
        L19:
            r100.mTargetId = r101.getResourceId(r105, r100.mTargetId);
            goto L26
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> r100) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> r100) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String r100, Object r101) {
    }

    public KeyTrigger() {
        this.mCurveFit = -1;
        this.mCross = null;
        int r100 = Key.UNSET;
        this.mTriggerReceiver = r100;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = r100;
        this.mTriggerCollisionId = r100;
        this.mTriggerCollisionView = null;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.mCollisionRect = new RectF();
        this.mTargetRect = new RectF();
        this.mType = 5;
        this.mCustomConstraints = new HashMap();
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    public static /* synthetic */ int access$400(KeyTrigger r100) {
        return r100.mTriggerID;
    }

    public static /* synthetic */ int access$500(KeyTrigger r100) {
        return r100.mTriggerCollisionId;
    }

    public static /* synthetic */ boolean access$600(KeyTrigger r100) {
        return r100.mPostLayout;
    }

    public static /* synthetic */ int access$700(KeyTrigger r100) {
        return r100.mTriggerReceiver;
    }

    public static /* synthetic */ float access$002(KeyTrigger r100, float r101) {
        r100.mFireThreshold = r101;
        return r101;
    }

    public static /* synthetic */ String access$102(KeyTrigger r100, String r101) {
        r100.mNegativeCross = r101;
        return r101;
    }

    public static /* synthetic */ String access$202(KeyTrigger r100, String r101) {
        r100.mPositiveCross = r101;
        return r101;
    }

    public static /* synthetic */ String access$302(KeyTrigger r100, String r101) {
        r100.mCross = r101;
        return r101;
    }

    public static /* synthetic */ int access$402(KeyTrigger r100, int r101) {
        r100.mTriggerID = r101;
        return r101;
    }

    public static /* synthetic */ int access$502(KeyTrigger r100, int r101) {
        r100.mTriggerCollisionId = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$602(KeyTrigger r100, boolean r101) {
        r100.mPostLayout = r101;
        return r101;
    }

    public static /* synthetic */ int access$702(KeyTrigger r100, int r101) {
        r100.mTriggerReceiver = r101;
        return r101;
    }

    public void conditionallyFire(float r100, View r110) {
        boolean r101 = true;
        if (this.mTriggerCollisionId == Key.UNSET) goto L28;
        if (this.mTriggerCollisionView != null) goto L7;
        this.mTriggerCollisionView = ((ViewGroup) r110.getParent()).findViewById(this.mTriggerCollisionId);
    L7:
        setUpRect(this.mCollisionRect, this.mTriggerCollisionView, this.mPostLayout);
        setUpRect(this.mTargetRect, r110, this.mPostLayout);
        if (this.mCollisionRect.intersect(this.mTargetRect) == false) goto L19;
        if (this.mFireCrossReset == false) goto L12;
        this.mFireCrossReset = false;
        boolean r102 = true;
    L14:
        if (this.mFirePositiveReset == false) goto L16;
        this.mFirePositiveReset = false;
        boolean r103 = true;
    L17:
        this.mFireNegativeReset = true;
        r101 = r103;
        boolean r104 = false;
    L61:
        this.mFireLastPos = r100;
        if (r104 == true) goto L65;
        if (r102 == true) goto L65;
        if (r101 == true) goto L65;
    L67:
        if (this.mTriggerReceiver == Key.UNSET) goto L70;
        r110 = ((MotionLayout) r110.getParent()).findViewById(this.mTriggerReceiver);
    L70:
        if (r104 == true) goto L72;
    L81:
        if (r101 == true) goto L83;
    L92:
        if (r102 == true) goto L94;
        return;
    L94:
        if (this.mCross != null) goto L96;
        return;
    L96:
        if (this.mFireCross != null) goto L114;
        this.mFireCross = r110.getClass().getMethod(this.mCross, new Class[0]);     // Catch: NoSuchMethodException -> L99
    L99:
        r110.getClass();
        Debug.getName(r110);
    L114:
        this.mFireCross.invoke(r110, new Object[0]);     // Catch: Exception -> L102
        return;
    L102:
        r110.getClass();
        Debug.getName(r110);
        return;
    L83:
        if (this.mPositiveCross == null) goto L92;
        if (this.mFirePositiveCross == null) goto L112;
    L104:
        this.mFirePositiveCross.invoke(r110, new Object[0]);     // Catch: Exception -> L91
    L91:
        r110.getClass();
        Debug.getName(r110);
        goto L92
    L112:
        this.mFirePositiveCross = r110.getClass().getMethod(this.mPositiveCross, new Class[0]);     // Catch: NoSuchMethodException -> L88
    L88:
        r110.getClass();
        Debug.getName(r110);
        goto L104
    L72:
        if (this.mNegativeCross == null) goto L81;
        if (this.mFireNegativeCross == null) goto L108;
    L106:
        this.mFireNegativeCross.invoke(r110, new Object[0]);     // Catch: Exception -> L80
    L80:
        r110.getClass();
        Debug.getName(r110);
        goto L81
    L108:
        this.mFireNegativeCross = r110.getClass().getMethod(this.mNegativeCross, new Class[0]);     // Catch: NoSuchMethodException -> L77
    L77:
        r110.getClass();
        Debug.getName(r110);
    L65:
        ((MotionLayout) r110.getParent()).fireTrigger(this.mTriggerID, r101, r100);
        goto L67
    L16:
        r103 = false;
        goto L17
    L12:
        r102 = false;
        goto L14
    L19:
        if (this.mFireCrossReset == true) goto L21;
        this.mFireCrossReset = true;
        r102 = true;
    L23:
        if (this.mFireNegativeReset == false) goto L25;
        this.mFireNegativeReset = false;
        r104 = true;
    L26:
        this.mFirePositiveReset = true;
    L60:
        r101 = false;
        goto L61
    L25:
        r104 = false;
        goto L26
    L21:
        r102 = false;
        goto L23
    L28:
        if (this.mFireCrossReset == false) goto L33;
        float r105 = this.mFireThreshold;
        if (((r100 - r105) * (this.mFireLastPos - r105)) >= 0.0f) goto L35;
        this.mFireCrossReset = false;
        r102 = true;
    L37:
        if (this.mFireNegativeReset == false) goto L44;
        float r106 = this.mFireThreshold;
        float r107 = r100 - r106;
        if (((this.mFireLastPos - r106) * r107) < 0.0f) goto L41;
    L46:
        boolean r108 = false;
    L48:
        if (this.mFirePositiveReset == false) goto L57;
        float r109 = this.mFireThreshold;
        float r111 = r100 - r109;
        if (((this.mFireLastPos - r109) * r111) < 0.0f) goto L52;
    L54:
        r101 = false;
    L55:
        r104 = r108;
        goto L61
    L52:
        if (r111 <= 0.0f) goto L54;
        this.mFirePositiveReset = false;
        goto L55
    L57:
        if (Math.abs(r100 - this.mFireThreshold) <= this.mTriggerSlack) goto L59;
        this.mFirePositiveReset = true;
    L59:
        r104 = r108;
        goto L60
    L41:
        if (r107 >= 0.0f) goto L46;
        this.mFireNegativeReset = false;
        r108 = true;
        goto L48
    L44:
        if (Math.abs(r100 - this.mFireThreshold) <= this.mTriggerSlack) goto L46;
        this.mFireNegativeReset = true;
    L35:
        r102 = false;
        goto L37
    L33:
        if (Math.abs(r100 - this.mFireThreshold) <= this.mTriggerSlack) goto L35;
        this.mFireCrossReset = true;
        goto L35
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context r100, AttributeSet r101) {
        Loader.read(this, r100.obtainStyledAttributes(r101, new int[]{R.attr.framePosition, R.attr.motionTarget, R.attr.motion_postLayoutCollision, R.attr.motion_triggerOnCollision, R.attr.onCross, R.attr.onNegativeCross, R.attr.onPositiveCross, R.attr.triggerId, R.attr.triggerReceiver, R.attr.triggerSlack, R.attr.viewTransitionOnCross, R.attr.viewTransitionOnNegativeCross, R.attr.viewTransitionOnPositiveCross}), r100);
    }

    private void setUpRect(RectF r100, View r101, boolean r102) {
        r100.top = r101.getTop();
        r100.bottom = r101.getBottom();
        r100.left = r101.getLeft();
        r100.right = r101.getRight();
        if (r102 == false) goto L6;
        r101.getMatrix().mapRect(r100);
        return;
    }
}
