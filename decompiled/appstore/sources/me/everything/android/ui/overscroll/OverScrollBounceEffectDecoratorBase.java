package me.everything.android.ui.overscroll;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import me.everything.android.ui.overscroll.adapters.IOverScrollDecoratorAdapter;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OverScrollBounceEffectDecoratorBase implements IOverScrollDecor, View.OnTouchListener {
    public static final float DEFAULT_DECELERATE_FACTOR = -2.0f;
    public static final float DEFAULT_TOUCH_DRAG_MOVE_RATIO_BCK = 1.0f;
    public static final float DEFAULT_TOUCH_DRAG_MOVE_RATIO_FWD = 3.0f;
    protected static final int MAX_BOUNCE_BACK_DURATION_MS = 800;
    protected static final int MIN_BOUNCE_BACK_DURATION_MS = 200;
    public static final String TAG = "OverScrollDecor";
    protected final BounceBackState mBounceBackState;
    protected IDecoratorState mCurrentState;
    protected final IdleState mIdleState;
    protected final OverScrollingState mOverScrollingState;
    protected final OverScrollStartAttributes mStartAttr;
    protected IOverScrollStateListener mStateListener;
    protected IOverScrollUpdateListener mUpdateListener;
    protected float mVelocity;
    protected final IOverScrollDecoratorAdapter mViewAdapter;

    public static abstract class AnimationAttributes {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Property f22277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f22278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f22279c;

        public AnimationAttributes() {
        }

        public abstract void a(View r10);
    }

    public class BounceBackState implements IDecoratorState, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Interpolator f22280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f22281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f22282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AnimationAttributes f22283d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ OverScrollBounceEffectDecoratorBase f22284e;

        public BounceBackState(OverScrollBounceEffectDecoratorBase r10, float r11) {
            this.f22284e = r10;
            this.f22280a = new DecelerateInterpolator();
            this.f22281b = r11;
            this.f22282c = r11 * 2.0f;
            this.f22283d = r10.createAnimationAttributes();
        }

        public Animator a() {
            View r10 = this.f22284e.mViewAdapter.getView();
            this.f22283d.a(r10);
            OverScrollBounceEffectDecoratorBase r11 = this.f22284e;
            float r12 = r11.mVelocity;
            float r13 = 0.0f;
            if (r12 == 0.0f) goto L20;
            if (r12 >= 0.0f) goto L9;
            if (r11.mStartAttr.f22292c == true) goto L20;
        L9:
            if (r12 > 0.0f) goto L11;
        L13:
            float r14 = (-r12) / this.f22281b;
            if (r14 < 0.0f) goto L17;
            r13 = r14;
        L17:
            float r15 = this.f22283d.f22278b + (((-r12) * r12) / this.f22282c);
            ObjectAnimator r16 = c(r10, (int) r13, r15);
            ObjectAnimator r17 = b(r15);
            AnimatorSet r18 = new AnimatorSet();
            r18.playSequentially(new Animator[]{r16, r17});
            return r18;
        L11:
            if (r11.mStartAttr.f22292c == true) goto L13;
        L20:
            return b(this.f22283d.f22278b);
        }

        public ObjectAnimator b(float r10) {
            View r11 = this.f22284e.mViewAdapter.getView();
            float r12 = Math.abs(r10);
            AnimationAttributes r13 = this.f22283d;
            float r14 = (r12 / r13.f22279c) * 800.0f;
            ObjectAnimator r15 = ObjectAnimator.ofFloat(r11, r13.f22277a, new float[]{this.f22284e.mStartAttr.f22291b});
            r15.setDuration(Math.max((int) r14, 200));
            r15.setInterpolator(this.f22280a);
            r15.addUpdateListener(this);
            return r15;
        }

        public ObjectAnimator c(View r10, int r11, float r12) {
            ObjectAnimator r13 = ObjectAnimator.ofFloat(r10, this.f22283d.f22277a, new float[]{r12});
            r13.setDuration(r11);
            r13.setInterpolator(this.f22280a);
            r13.addUpdateListener(this);
            return r13;
        }

        @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase.IDecoratorState
        public int getStateId() {
            return 3;
        }

        @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase.IDecoratorState
        public void handleEntryTransition(IDecoratorState r10) {
            OverScrollBounceEffectDecoratorBase r11 = this.f22284e;
            r11.mStateListener.onOverScrollStateChange(r11, r10.getStateId(), getStateId());
            Animator r12 = a();
            r12.addListener(this);
            r12.start();
        }

        @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase.IDecoratorState
        public boolean handleMoveTouchEvent(MotionEvent r10) {
            return true;
        }

        @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase.IDecoratorState
        public boolean handleUpOrCancelTouchEvent(MotionEvent r10) {
            return true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            OverScrollBounceEffectDecoratorBase r11 = this.f22284e;
            r11.issueStateTransition(r11.mIdleState);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            OverScrollBounceEffectDecoratorBase r11 = this.f22284e;
            r11.mUpdateListener.onOverScrollUpdate(r11, 3, ((Float) r10.getAnimatedValue()).floatValue());
        }
    }

    public interface IDecoratorState {
        int getStateId();

        void handleEntryTransition(IDecoratorState r10);

        boolean handleMoveTouchEvent(MotionEvent r10);

        boolean handleUpOrCancelTouchEvent(MotionEvent r10);
    }

    public class IdleState implements IDecoratorState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MotionAttributes f22285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OverScrollBounceEffectDecoratorBase f22286b;

        public IdleState(OverScrollBounceEffectDecoratorBase r10) {
            this.f22286b = r10;
            this.f22285a = r10.createMotionAttributes();
        }

        @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase.IDecoratorState
        public int getStateId() {
            return 0;
        }

        @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase.IDecoratorState
        public void handleEntryTransition(IDecoratorState r10) {
            OverScrollBounceEffectDecoratorBase r11 = this.f22286b;
            r11.mStateListener.onOverScrollStateChange(r11, r10.getStateId(), getStateId());
        }

        @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase.IDecoratorState
        public boolean handleMoveTouchEvent(MotionEvent r10) {
            View r11 = this.f22286b.mViewAdapter.getView();
            if (this.f22285a.a(r11, r10) == true) goto L6;
            return false;
        L6:
            if (this.f22286b.mViewAdapter.isInAbsoluteStart() == false) goto L10;
            if (this.f22285a.f22289c == false) goto L10;
        L13:
            OverScrollStartAttributes r12 = this.f22286b.mStartAttr;
            r12.f22290a = r10.getPointerId(0);
            OverScrollBounceEffectDecoratorBase r13 = this.f22286b;
            OverScrollStartAttributes r14 = r13.mStartAttr;
            MotionAttributes r15 = this.f22285a;
            r14.f22291b = r15.f22287a;
            r14.f22292c = r15.f22289c;
            r13.issueStateTransition(r13.mOverScrollingState);
            return this.f22286b.mOverScrollingState.handleMoveTouchEvent(r10);
        L10:
            if (this.f22286b.mViewAdapter.isInAbsoluteEnd() == true) goto L12;
        L15:
            return false;
        L12:
            if (this.f22285a.f22289c == true) goto L15;
            goto L13
        }

        @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase.IDecoratorState
        public boolean handleUpOrCancelTouchEvent(MotionEvent r10) {
            return false;
        }
    }

    public static abstract class MotionAttributes {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f22287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f22288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f22289c;

        public MotionAttributes() {
        }

        public abstract boolean a(View r10, MotionEvent r11);
    }

    public static class OverScrollStartAttributes {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f22291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f22292c;

        public OverScrollStartAttributes() {
        }
    }

    public class OverScrollingState implements IDecoratorState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f22293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f22294b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MotionAttributes f22295c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f22296d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ OverScrollBounceEffectDecoratorBase f22297e;

        public OverScrollingState(OverScrollBounceEffectDecoratorBase r10, float r11, float r12) {
            this.f22297e = r10;
            this.f22295c = r10.createMotionAttributes();
            this.f22293a = r11;
            this.f22294b = r12;
        }

        @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase.IDecoratorState
        public int getStateId() {
            return this.f22296d;
        }

        @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase.IDecoratorState
        public void handleEntryTransition(IDecoratorState r10) {
            OverScrollBounceEffectDecoratorBase r11 = this.f22297e;
            if (r11.mStartAttr.f22292c == false) goto L5;
            int r12 = 1;
        L6:
            this.f22296d = r12;
            r11.mStateListener.onOverScrollStateChange(r11, r10.getStateId(), getStateId());
            return;
        L5:
            r12 = 2;
            goto L6
        }

        @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase.IDecoratorState
        public boolean handleMoveTouchEvent(MotionEvent r11) {
            if (this.f22297e.mStartAttr.f22290a == r11.getPointerId(0)) goto L6;
            OverScrollBounceEffectDecoratorBase r10 = this.f22297e;
            r10.issueStateTransition(r10.mBounceBackState);
            return true;
        L6:
            View r12 = this.f22297e.mViewAdapter.getView();
            if (this.f22295c.a(r12, r11) == true) goto L9;
            return true;
        L9:
            MotionAttributes r13 = this.f22295c;
            float r14 = r13.f22288b;
            boolean r15 = r13.f22289c;
            OverScrollBounceEffectDecoratorBase r16 = this.f22297e;
            OverScrollStartAttributes r17 = r16.mStartAttr;
            boolean r18 = r17.f22292c;
            if (r15 != r18) goto L12;
            float r19 = this.f22293a;
        L13:
            float r20 = r14 / r19;
            float r21 = r13.f22287a + r20;
            if (r18 == false) goto L18;
            if (r15 == true) goto L18;
            if (r21 > r17.f22291b) goto L18;
        L22:
            r16.translateViewAndEvent(r12, r17.f22291b, r11);
            OverScrollBounceEffectDecoratorBase r110 = this.f22297e;
            r110.mUpdateListener.onOverScrollUpdate(r110, this.f22296d, 0.0f);
            OverScrollBounceEffectDecoratorBase r111 = this.f22297e;
            r111.issueStateTransition(r111.mIdleState);
            return true;
        L18:
            if (r18 == true) goto L25;
            if (r15 == false) goto L25;
            if (r21 >= r17.f22291b) goto L22;
        L25:
            if (r12.getParent() == null) goto L27;
            r12.getParent().requestDisallowInterceptTouchEvent(true);
        L27:
            long r22 = r11.getEventTime() - r11.getHistoricalEventTime(0);
            if (r22 <= 0) goto L30;
            this.f22297e.mVelocity = r20 / r22;
        L30:
            this.f22297e.translateView(r12, r21);
            OverScrollBounceEffectDecoratorBase r112 = this.f22297e;
            r112.mUpdateListener.onOverScrollUpdate(r112, this.f22296d, r21);
            return true;
        L12:
            r19 = this.f22294b;
            goto L13
        }

        @Override // me.everything.android.ui.overscroll.OverScrollBounceEffectDecoratorBase.IDecoratorState
        public boolean handleUpOrCancelTouchEvent(MotionEvent r10) {
            OverScrollBounceEffectDecoratorBase r11 = this.f22297e;
            r11.issueStateTransition(r11.mBounceBackState);
            return false;
        }
    }

    public OverScrollBounceEffectDecoratorBase(IOverScrollDecoratorAdapter r10, float r11, float r12, float r13) {
        this.mStartAttr = new OverScrollStartAttributes();
        this.mStateListener = new ListenerStubs.a();
        this.mUpdateListener = new ListenerStubs.b();
        this.mViewAdapter = r10;
        this.mBounceBackState = new BounceBackState(this, r11);
        this.mOverScrollingState = new OverScrollingState(this, r12, r13);
        IdleState r14 = new IdleState(this);
        this.mIdleState = r14;
        this.mCurrentState = r14;
        attach();
    }

    public void attach() {
        getView().setOnTouchListener(this);
        getView().setOverScrollMode(2);
    }

    public abstract AnimationAttributes createAnimationAttributes();

    public abstract MotionAttributes createMotionAttributes();

    @Override // me.everything.android.ui.overscroll.IOverScrollDecor
    public void detach() {
        if (this.mCurrentState == this.mIdleState) goto L5;
        Log.w(TAG, "Decorator detached while over-scroll is in effect. You might want to add a precondition of that getCurrentState()==STATE_IDLE, first.");
    L5:
        getView().setOnTouchListener(null);
        getView().setOverScrollMode(0);
    }

    @Override // me.everything.android.ui.overscroll.IOverScrollDecor
    public int getCurrentState() {
        return this.mCurrentState.getStateId();
    }

    @Override // me.everything.android.ui.overscroll.IOverScrollDecor
    public View getView() {
        return this.mViewAdapter.getView();
    }

    public void issueStateTransition(IDecoratorState r10) {
        IDecoratorState r11 = this.mCurrentState;
        this.mCurrentState = r10;
        r10.handleEntryTransition(r11);
    }

    public boolean onTouch(View r10, MotionEvent r11) {
        int r12 = r11.getAction();
        if (r12 == 1) goto L13;
        if (r12 == 2) goto L11;
        if (r12 == 3) goto L13;
        return false;
    L11:
        return this.mCurrentState.handleMoveTouchEvent(r11);
    L13:
        return this.mCurrentState.handleUpOrCancelTouchEvent(r11);
    }

    @Override // me.everything.android.ui.overscroll.IOverScrollDecor
    public void setOverScrollStateListener(IOverScrollStateListener r10) {
        if (r10 != null) goto L5;
        r10 = new ListenerStubs.a();
    L5:
        this.mStateListener = r10;
    }

    @Override // me.everything.android.ui.overscroll.IOverScrollDecor
    public void setOverScrollUpdateListener(IOverScrollUpdateListener r10) {
        if (r10 != null) goto L5;
        r10 = new ListenerStubs.b();
    L5:
        this.mUpdateListener = r10;
    }

    public abstract void translateView(View r10, float r11);

    public abstract void translateViewAndEvent(View r10, float r11, MotionEvent r12);
}
