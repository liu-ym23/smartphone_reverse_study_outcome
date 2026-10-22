package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {
    public static final ViewProperty ALPHA = null;
    public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.00390625f;
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1f;
    public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002f;
    public static final ViewProperty ROTATION = null;
    public static final ViewProperty ROTATION_X = null;
    public static final ViewProperty ROTATION_Y = null;
    public static final ViewProperty SCALE_X = null;
    public static final ViewProperty SCALE_Y = null;
    public static final ViewProperty SCROLL_X = null;
    public static final ViewProperty SCROLL_Y = null;
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    public static final ViewProperty TRANSLATION_X = null;
    public static final ViewProperty TRANSLATION_Y = null;
    public static final ViewProperty TRANSLATION_Z = null;
    private static final float UNSET = Float.MAX_VALUE;
    public static final ViewProperty X = null;
    public static final ViewProperty Y = null;
    public static final ViewProperty Z = null;
    private final ArrayList<OnAnimationEndListener> mEndListeners;
    private long mLastFrameTime;
    float mMaxValue;
    float mMinValue;
    private float mMinVisibleChange;
    final FloatPropertyCompat mProperty;
    boolean mRunning;
    boolean mStartValueIsSet;
    final Object mTarget;
    private final ArrayList<OnAnimationUpdateListener> mUpdateListeners;
    float mValue;
    float mVelocity;

    public static class MassState {
        float mValue;
        float mVelocity;

        public MassState() {
        }
    }

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation r100, boolean r101, float r102, float r103);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation r100, float r101, float r102);
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        private ViewProperty(String r100) {
            super(r100);
        }

        public /* synthetic */ ViewProperty(String r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public abstract float getAcceleration(float r100, float r101);

    public abstract boolean isAtEquilibrium(float r100, float r101);

    public abstract void setValueThreshold(float r100);

    public abstract boolean updateValueAndVelocity(long r100);

    static {
        final String r100 = LiveDegradeFpsAnimator.TRANSLATION_X;
        TRANSLATION_X = new AnonymousClass1(r100);
        final String r101 = LiveDegradeFpsAnimator.TRANSLATION_Y;
        TRANSLATION_Y = new AnonymousClass2(r101);
        final String r102 = "translationZ";
        TRANSLATION_Z = new AnonymousClass3(r102);
        final String r103 = LiveDegradeFpsAnimator.SCALE_X;
        SCALE_X = new AnonymousClass4(r103);
        final String r104 = LiveDegradeFpsAnimator.SCALE_Y;
        SCALE_Y = new AnonymousClass5(r104);
        final String r105 = "rotation";
        ROTATION = new AnonymousClass6(r105);
        final String r106 = "rotationX";
        ROTATION_X = new AnonymousClass7(r106);
        final String r107 = "rotationY";
        ROTATION_Y = new AnonymousClass8(r107);
        final String r108 = "x";
        X = new AnonymousClass9(r108);
        final String r109 = "y";
        Y = new AnonymousClass10(r109);
        final String r110 = MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z;
        Z = new AnonymousClass11(r110);
        final String r111 = "alpha";
        ALPHA = new AnonymousClass12(r111);
        final String r112 = "scrollX";
        SCROLL_X = new AnonymousClass13(r112);
        final String r113 = "scrollY";
        SCROLL_Y = new AnonymousClass14(r113);
    }

    private float getPropertyValue() {
        return this.mProperty.getValue(this.mTarget);
    }

    private void startAnimationInternal() {
        if (this.mRunning == true) goto L14;
        this.mRunning = true;
        if (this.mStartValueIsSet == true) goto L7;
        this.mValue = getPropertyValue();
    L7:
        float r100 = this.mValue;
        if (r100 > this.mMaxValue) goto L13;
        if (r100 < this.mMinValue) goto L13;
        AnimationHandler.getInstance().addAnimationFrameCallback(this, 0);
        return;
    L13:
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }

    public float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    public void cancel() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        if (this.mRunning == false) goto L10;
        endAnimationInternal(true);
        return;
    L10:
        return;
    L9:
        throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
    }

    public void start() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        if (this.mRunning == true) goto L10;
        startAnimationInternal();
        return;
    L10:
        return;
    L9:
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    public boolean isRunning() {
        return this.mRunning;
    }

    public DynamicAnimation(final FloatValueHolder r100) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0;
        this.mEndListeners = new ArrayList();
        this.mUpdateListeners = new ArrayList();
        this.mTarget = null;
        final String r101 = "FloatValueHolder";
        this.mProperty = new AnonymousClass15(this, r101, r100);
        this.mMinVisibleChange = 1.0f;
    }

    private void endAnimationInternal(boolean r100) {
        int r101 = 0;
        this.mRunning = false;
        AnimationHandler.getInstance().removeCallback(this);
        this.mLastFrameTime = 0;
        this.mStartValueIsSet = false;
    L4:
        if (r101 >= this.mEndListeners.size()) goto L9;
        if (ListProtector.get(this.mEndListeners, r101) == null) goto L8;
        ((OnAnimationEndListener) ListProtector.get(this.mEndListeners, r101)).onAnimationEnd(this, r100, this.mValue, this.mVelocity);
    L8:
        r101 = r101 + 1;
        goto L4
    L9:
        removeNullEntries(this.mEndListeners);
    }

    private static <T> void removeNullEntries(ArrayList<T> r100) {
        int r101 = r100.size() - 1;
    L3:
        if (r101 < 0) goto L8;
        if (ListProtector.get(r100, r101) != null) goto L7;
        ListProtector.remove(r100, r101);
    L7:
        r101 = r101 - 1;
        goto L3
    }

    public T addEndListener(OnAnimationEndListener r100) {
        if (this.mEndListeners.contains(r100) == true) goto L5;
        this.mEndListeners.add(r100);
    L5:
        return this;
    }

    public T addUpdateListener(OnAnimationUpdateListener r100) {
        if (isRunning() == true) goto L9;
        if (this.mUpdateListeners.contains(r100) == true) goto L7;
        this.mUpdateListeners.add(r100);
    L7:
        return this;
    L9:
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback
    public boolean doAnimationFrame(long r100) {
        long r101 = this.mLastFrameTime;
        if (r101 != 0) goto L6;
        this.mLastFrameTime = r100;
        setPropertyValue(this.mValue);
        return false;
    L6:
        this.mLastFrameTime = r100;
        boolean r102 = updateValueAndVelocity(r100 - r101);
        float r103 = Math.min(this.mValue, this.mMaxValue);
        this.mValue = r103;
        float r104 = Math.max(r103, this.mMinValue);
        this.mValue = r104;
        setPropertyValue(r104);
        if (r102 == false) goto L9;
        endAnimationInternal(false);
    L9:
        return r102;
    }

    public void removeEndListener(OnAnimationEndListener r100) {
        removeEntry(this.mEndListeners, r100);
    }

    public void removeUpdateListener(OnAnimationUpdateListener r100) {
        removeEntry(this.mUpdateListeners, r100);
    }

    public T setMaxValue(float r100) {
        this.mMaxValue = r100;
        return this;
    }

    public T setMinValue(float r100) {
        this.mMinValue = r100;
        return this;
    }

    public T setMinimumVisibleChange(float r100) {
        if (r100 <= 0.0f) goto L7;
        this.mMinVisibleChange = r100;
        setValueThreshold(r100 * 0.75f);
        return this;
    L7:
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    public void setPropertyValue(float r100) {
        this.mProperty.setValue(this.mTarget, r100);
        int r101 = 0;
    L4:
        if (r101 >= this.mUpdateListeners.size()) goto L9;
        if (ListProtector.get(this.mUpdateListeners, r101) == null) goto L8;
        ((OnAnimationUpdateListener) ListProtector.get(this.mUpdateListeners, r101)).onAnimationUpdate(this, this.mValue, this.mVelocity);
    L8:
        r101 = r101 + 1;
        goto L4
    L9:
        removeNullEntries(this.mUpdateListeners);
    }

    public T setStartValue(float r100) {
        this.mValue = r100;
        this.mStartValueIsSet = true;
        return this;
    }

    public T setStartVelocity(float r100) {
        this.mVelocity = r100;
        return this;
    }

    public <K> DynamicAnimation(K r100, FloatPropertyCompat<K> r101) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0;
        this.mEndListeners = new ArrayList();
        this.mUpdateListeners = new ArrayList();
        this.mTarget = r100;
        this.mProperty = r101;
        if (r101 != ROTATION) goto L5;
    L19:
        this.mMinVisibleChange = 0.1f;
        return;
    L5:
        if (r101 == ROTATION_X) goto L19;
        if (r101 == ROTATION_Y) goto L19;
        if (r101 != ALPHA) goto L13;
        this.mMinVisibleChange = 0.00390625f;
        return;
    L13:
        if (r101 != SCALE_X) goto L15;
    L18:
        this.mMinVisibleChange = 0.00390625f;
        return;
    L15:
        if (r101 == SCALE_Y) goto L18;
        this.mMinVisibleChange = 1.0f;
    }

    private static <T> void removeEntry(ArrayList<T> r100, T r101) {
        int r102 = r100.indexOf(r101);
        if (r102 < 0) goto L6;
        ListProtector.set(r100, r102, null);
        return;
    }
}
