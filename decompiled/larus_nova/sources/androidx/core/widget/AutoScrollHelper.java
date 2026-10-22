package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {
    private static final int DEFAULT_ACTIVATION_DELAY = 0;
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = Float.MAX_VALUE;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    private static final float DEFAULT_RELATIVE_VELOCITY = 1.0f;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    private static final int HORIZONTAL = 0;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    boolean mAnimating;
    private final Interpolator mEdgeInterpolator;
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    private float[] mMaximumEdges;
    private float[] mMaximumVelocity;
    private float[] mMinimumVelocity;
    boolean mNeedsCancel;
    boolean mNeedsReset;
    private float[] mRelativeEdges;
    private float[] mRelativeVelocity;
    private Runnable mRunnable;
    final ClampedScroller mScroller;
    final View mTarget;

    public static class ClampedScroller {
        private long mDeltaTime;
        private int mDeltaX;
        private int mDeltaY;
        private int mEffectiveRampDown;
        private int mRampDownDuration;
        private int mRampUpDuration;
        private long mStartTime;
        private long mStopTime;
        private float mStopValue;
        private float mTargetVelocityX;
        private float mTargetVelocityY;

        private float interpolateValue(float r100) {
            return (((-4.0f) * r100) * r100) + (r100 * 4.0f);
        }

        public void computeScrollDelta() {
            if (this.mDeltaTime == 0) goto L7;
            long r100 = AnimationUtils.currentAnimationTimeMillis();
            float r101 = interpolateValue(getValueAt(r100));
            long r102 = r100 - this.mDeltaTime;
            this.mDeltaTime = r100;
            float r103 = r102 * r101;
            this.mDeltaX = (int) (this.mTargetVelocityX * r103);
            this.mDeltaY = (int) (r103 * this.mTargetVelocityY);
            return;
        L7:
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int getHorizontalDirection() {
            float r100 = this.mTargetVelocityX;
            return (int) (r100 / Math.abs(r100));
        }

        public int getVerticalDirection() {
            float r100 = this.mTargetVelocityY;
            return (int) (r100 / Math.abs(r100));
        }

        public boolean isFinished() {
            if (this.mStopTime > 0) goto L5;
        L7:
            return false;
        L5:
            if (AnimationUtils.currentAnimationTimeMillis() <= (this.mStopTime + ((long) this.mEffectiveRampDown))) goto L7;
            return true;
        }

        public ClampedScroller() {
            this.mStartTime = Long.MIN_VALUE;
            this.mStopTime = -1;
            this.mDeltaTime = 0;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
        }

        public void requestStop() {
            long r100 = AnimationUtils.currentAnimationTimeMillis();
            this.mEffectiveRampDown = AutoScrollHelper.constrain((int) (r100 - this.mStartTime), 0, this.mRampDownDuration);
            this.mStopValue = getValueAt(r100);
            this.mStopTime = r100;
        }

        public void start() {
            long r100 = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = r100;
            this.mStopTime = -1;
            this.mDeltaTime = r100;
            this.mStopValue = 0.5f;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
        }

        public int getDeltaX() {
            return this.mDeltaX;
        }

        public int getDeltaY() {
            return this.mDeltaY;
        }

        private float getValueAt(long r110) {
            long r100 = this.mStartTime;
            if (r110 >= r100) goto L5;
            return 0.0f;
        L5:
            long r101 = this.mStopTime;
            if (r101 < 0) goto L13;
            if (r110 < r101) goto L13;
            float r102 = this.mStopValue;
            return (1.0f - r102) + (r102 * AutoScrollHelper.constrain((r110 - r101) / this.mEffectiveRampDown, 0.0f, 1.0f));
        L13:
            return AutoScrollHelper.constrain((r110 - r100) / this.mRampUpDuration, 0.0f, 1.0f) * 0.5f;
        }

        public void setRampDownDuration(int r100) {
            this.mRampDownDuration = r100;
        }

        public void setRampUpDuration(int r100) {
            this.mRampUpDuration = r100;
        }

        public void setTargetVelocity(float r100, float r101) {
            this.mTargetVelocityX = r100;
            this.mTargetVelocityY = r101;
        }
    }

    public class ScrollAnimationRunnable implements Runnable {
        final /* synthetic */ AutoScrollHelper this$0;

        @Override // java.lang.Runnable
        public void run() {
            androidx_core_widget_AutoScrollHelper$ScrollAnimationRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_core_widget_AutoScrollHelper$ScrollAnimationRunnable__run$___twin___() {
            AutoScrollHelper r100 = this.this$0;
            if (r100.mAnimating == true) goto L6;
            return;
        L6:
            if (r100.mNeedsReset == false) goto L8;
            r100.mNeedsReset = false;
            r100.mScroller.start();
        L8:
            ClampedScroller r101 = this.this$0.mScroller;
            if (r101.isFinished() == false) goto L11;
        L18:
            this.this$0.mAnimating = false;
            return;
        L11:
            if (this.this$0.shouldAnimate() == false) goto L18;
            AutoScrollHelper r102 = this.this$0;
            if (r102.mNeedsCancel == false) goto L16;
            r102.mNeedsCancel = false;
            r102.cancelTargetTouch();
        L16:
            r101.computeScrollDelta();
            int r103 = r101.getDeltaX();
            int r104 = r101.getDeltaY();
            this.this$0.scrollTargetBy(r103, r104);
            ViewCompat.postOnAnimation(this.this$0.mTarget, this);
        }

        public ScrollAnimationRunnable(AutoScrollHelper r100) {
            this.this$0 = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_core_widget_AutoScrollHelper$ScrollAnimationRunnable_com_larus_apm_impl_protector_RunnableLancet_run(ScrollAnimationRunnable r100) {
            r100.androidx_core_widget_AutoScrollHelper$ScrollAnimationRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static float constrain(float r100, float r101, float r102) {
        if (r100 <= r102) goto L6;
        return r102;
    L6:
        if (r100 >= r101) goto L8;
        return r101;
    L8:
        return r100;
    }

    public static int constrain(int r100, int r101, int r102) {
        if (r100 <= r102) goto L4;
        return r102;
    L4:
        if (r100 >= r101) goto L6;
        return r101;
    L6:
        return r100;
    }

    public abstract boolean canTargetScrollHorizontally(int r100);

    public abstract boolean canTargetScrollVertically(int r100);

    public abstract void scrollTargetBy(int r100, int r101);

    private void requestStop() {
        if (this.mNeedsReset == false) goto L5;
        this.mAnimating = false;
        return;
    L5:
        this.mScroller.requestStop();
    }

    private void startAnimating() {
        if (this.mRunnable != null) goto L5;
        this.mRunnable = new ScrollAnimationRunnable(this);
    L5:
        this.mAnimating = true;
        this.mNeedsReset = true;
        if (this.mAlreadyDelayed == true) goto L10;
        int r100 = this.mActivationDelay;
        if (r100 <= 0) goto L10;
        ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, r100);
    L11:
        this.mAlreadyDelayed = true;
        return;
    L10:
        this.mRunnable.run();
        goto L11
    }

    public boolean shouldAnimate() {
        ClampedScroller r100 = this.mScroller;
        int r101 = r100.getVerticalDirection();
        int r102 = r100.getHorizontalDirection();
        if (r101 != 0) goto L5;
    L6:
        if (r102 != 0) goto L8;
    L10:
        return false;
    L8:
        if (canTargetScrollHorizontally(r102) == false) goto L10;
    L9:
        return true;
    L5:
        if (canTargetScrollVertically(r101) == true) goto L9;
        goto L6
    }

    static {
        DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    }

    public void cancelTargetTouch() {
        long r100 = SystemClock.uptimeMillis();
        MotionEvent r101 = MotionEvent.obtain(r100, r100, 3, 0.0f, 0.0f, 0);
        this.mTarget.onTouchEvent(r101);
        r101.recycle();
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isExclusive() {
        return this.mExclusive;
    }

    public AutoScrollHelper(View r100) {
        this.mScroller = new ClampedScroller();
        this.mEdgeInterpolator = new AccelerateInterpolator();
        this.mRelativeEdges = new float[]{0.0f, 0.0f};
        this.mMaximumEdges = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.mRelativeVelocity = new float[]{0.0f, 0.0f};
        this.mMinimumVelocity = new float[]{0.0f, 0.0f};
        this.mMaximumVelocity = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.mTarget = r100;
        float r101 = INVOKEVIRTUAL_androidx_core_widget_AutoScrollHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).density;
        float r102 = (int) ((1575.0f * r101) + 0.5f);
        setMaximumVelocity(r102, r102);
        float r103 = (int) ((r101 * 315.0f) + 0.5f);
        setMinimumVelocity(r103, r103);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(DEFAULT_ACTIVATION_DELAY);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_core_widget_AutoScrollHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public AutoScrollHelper setActivationDelay(int r100) {
        this.mActivationDelay = r100;
        return this;
    }

    public AutoScrollHelper setEdgeType(int r100) {
        this.mEdgeType = r100;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean r100) {
        if (this.mEnabled == false) goto L6;
        if (r100 == true) goto L6;
        requestStop();
    L6:
        this.mEnabled = r100;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean r100) {
        this.mExclusive = r100;
        return this;
    }

    public AutoScrollHelper setRampDownDuration(int r100) {
        this.mScroller.setRampDownDuration(r100);
        return this;
    }

    public AutoScrollHelper setRampUpDuration(int r100) {
        this.mScroller.setRampUpDuration(r100);
        return this;
    }

    private float constrainEdgeValue(float r100, float r101) {
        if (r101 != 0.0f) goto L5;
        return 0.0f;
    L5:
        int r102 = this.mEdgeType;
        if (r102 == 0) goto L16;
        if (r102 == 1) goto L16;
        if (r102 == 2) goto L12;
    L25:
        return 0.0f;
    L12:
        if (r100 >= 0.0f) goto L25;
        return r100 / (-r101);
    L16:
        if (r100 >= r101) goto L25;
        if (r100 < 0.0f) goto L22;
        return 1.0f - (r100 / r101);
    L22:
        if (this.mAnimating == false) goto L25;
        if (r102 != 1) goto L25;
        return 1.0f;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r100, MotionEvent r101) {
        if (this.mEnabled == true) goto L5;
        return false;
    L5:
        int r102 = r101.getActionMasked();
        if (r102 == 0) goto L14;
        if (r102 != 1) goto L9;
    L13:
        requestStop();
    L21:
        if (this.mExclusive == true) goto L23;
        return false;
    L23:
        if (this.mAnimating == false) goto L27;
        return true;
    L27:
        return false;
    L9:
        if (r102 != 2) goto L11;
    L15:
        this.mScroller.setTargetVelocity(computeTargetVelocity(0, r101.getX(), r100.getWidth(), this.mTarget.getWidth()), computeTargetVelocity(1, r101.getY(), r100.getHeight(), this.mTarget.getHeight()));
        if (this.mAnimating == true) goto L21;
        if (shouldAnimate() == false) goto L21;
        startAnimating();
        goto L21
    L11:
        if (r102 == 3) goto L13;
    L14:
        this.mNeedsCancel = true;
        this.mAlreadyDelayed = false;
        goto L15
    }

    public AutoScrollHelper setMaximumEdges(float r100, float r101) {
        float[] r102 = this.mMaximumEdges;
        r102[0] = r100;
        r102[1] = r101;
        return this;
    }

    public AutoScrollHelper setMaximumVelocity(float r100, float r101) {
        float[] r102 = this.mMaximumVelocity;
        r102[0] = r100 / 1000.0f;
        r102[1] = r101 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setMinimumVelocity(float r100, float r101) {
        float[] r102 = this.mMinimumVelocity;
        r102[0] = r100 / 1000.0f;
        r102[1] = r101 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setRelativeEdges(float r100, float r101) {
        float[] r102 = this.mRelativeEdges;
        r102[0] = r100;
        r102[1] = r101;
        return this;
    }

    public AutoScrollHelper setRelativeVelocity(float r100, float r101) {
        float[] r102 = this.mRelativeVelocity;
        r102[0] = r100 / 1000.0f;
        r102[1] = r101 / 1000.0f;
        return this;
    }

    private float computeTargetVelocity(int r100, float r101, float r102, float r103) {
        float r104 = getEdgeValue(this.mRelativeEdges[r100], r102, this.mMaximumEdges[r100], r101);
        if (r104 != 0.0f) goto L5;
        return 0.0f;
    L5:
        float r105 = this.mRelativeVelocity[r100];
        float r106 = this.mMinimumVelocity[r100];
        float r107 = this.mMaximumVelocity[r100];
        float r108 = r105 * r103;
        if (r104 <= 0.0f) goto L10;
        return constrain(r104 * r108, r106, r107);
    L10:
        return -constrain((-r104) * r108, r106, r107);
    }

    private float getEdgeValue(float r100, float r101, float r102, float r103) {
        float r104 = constrain(r100 * r101, 0.0f, r102);
        float r105 = constrainEdgeValue(r103, r104);
        float r106 = constrainEdgeValue(r101 - r103, r104) - r105;
        if (r106 >= 0.0f) goto L6;
        float r107 = -this.mEdgeInterpolator.getInterpolation(-r106);
    L9:
        return constrain(r107, -1.0f, 1.0f);
    L6:
        if (r106 <= 0.0f) goto L10;
        r107 = this.mEdgeInterpolator.getInterpolation(r106);
        goto L9
    L10:
        return 0.0f;
    }
}
