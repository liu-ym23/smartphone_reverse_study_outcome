package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.constraintlayout.motion.widget.MotionHelper;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.motion.widget.MotionScene;
import com.obric.oui.constraintlayout.widget.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class Carousel extends MotionHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "Carousel";
    public static final int TOUCH_UP_CARRY_ON = 2;
    public static final int TOUCH_UP_IMMEDIATE_STOP = 1;
    private a mAdapter;
    private int mAnimateTargetDelay;
    private int mBackwardTransition;
    private float mDampening;
    private int mEmptyViewBehavior;
    private int mFirstViewReference;
    private int mForwardTransition;
    private int mIndex;
    private boolean mInfiniteCarousel;
    int mLastStartId;
    private final ArrayList<View> mList;
    private MotionLayout mMotionLayout;
    private int mNextState;
    private int mPreviousIndex;
    private int mPreviousState;
    private int mStartIndex;
    private int mTargetIndex;
    private int mTouchUpMode;
    Runnable mUpdateRunnable;
    private float mVelocityThreshold;

    public interface a {
        int a();

        void a(int r1);

        void a(View r1, int r2);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.w(r0, r1);
    }

    static /* synthetic */ MotionLayout access$000(Carousel r0) {
        return r0.mMotionLayout;
    }

    static /* synthetic */ void access$100(Carousel r0) {
        r0.updateItems();
    }

    static /* synthetic */ int access$200(Carousel r0) {
        return r0.mIndex;
    }

    static /* synthetic */ a access$300(Carousel r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ int access$400(Carousel r0) {
        return r0.mTouchUpMode;
    }

    static /* synthetic */ float access$500(Carousel r0) {
        return r0.mVelocityThreshold;
    }

    static /* synthetic */ float access$600(Carousel r0) {
        return r0.mDampening;
    }

    static /* synthetic */ int access$700(Carousel r0) {
        return r0.mPreviousIndex;
    }

    public Carousel(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        this.mAdapter = null;
        this.mList = new ArrayList();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.mFirstViewReference = -1;
        this.mInfiniteCarousel = false;
        this.mBackwardTransition = -1;
        this.mForwardTransition = -1;
        this.mPreviousState = -1;
        this.mNextState = -1;
        this.mDampening = 0.9f;
        this.mStartIndex = 0;
        this.mEmptyViewBehavior = 4;
        this.mTouchUpMode = 1;
        this.mVelocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new AnonymousClass1(this);
    }

    public Carousel(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7);
        this.mAdapter = null;
        this.mList = new ArrayList();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.mFirstViewReference = -1;
        this.mInfiniteCarousel = false;
        this.mBackwardTransition = -1;
        this.mForwardTransition = -1;
        this.mPreviousState = -1;
        this.mNextState = -1;
        this.mDampening = 0.9f;
        this.mStartIndex = 0;
        this.mEmptyViewBehavior = 4;
        this.mTouchUpMode = 1;
        this.mVelocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new AnonymousClass1(this);
        init(r6, r7);
    }

    public Carousel(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        this.mAdapter = null;
        this.mList = new ArrayList();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.mFirstViewReference = -1;
        this.mInfiniteCarousel = false;
        this.mBackwardTransition = -1;
        this.mForwardTransition = -1;
        this.mPreviousState = -1;
        this.mNextState = -1;
        this.mDampening = 0.9f;
        this.mStartIndex = 0;
        this.mEmptyViewBehavior = 4;
        this.mTouchUpMode = 1;
        this.mVelocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new AnonymousClass1(this);
        init(r6, r7);
    }

    private void init(Context r6, AttributeSet r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L51;
        TypedArray r10 = r8.obtainStyledAttributes(r9, R.styleable.Carousel);
        int r11 = r10.getIndexCount();
        int r0 = 0;
    L5:
        if (r0 >= r11) goto L37;
        int r1 = r10.getIndex(r0);
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_firstView, "styleable", "Carousel_carousel_firstView")) goto L10;
        this.mFirstViewReference = r10.getResourceId(r1, this.mFirstViewReference);
    L36:
        r0 = r0 + 1;
        goto L5
    L10:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_backwardTransition, "styleable", "Carousel_carousel_backwardTransition")) goto L13;
        this.mBackwardTransition = r10.getResourceId(r1, this.mBackwardTransition);
        goto L36
    L13:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_forwardTransition, "styleable", "Carousel_carousel_forwardTransition")) goto L16;
        this.mForwardTransition = r10.getResourceId(r1, this.mForwardTransition);
        goto L36
    L16:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_emptyViewsBehavior, "styleable", "Carousel_carousel_emptyViewsBehavior")) goto L19;
        this.mEmptyViewBehavior = r10.getInt(r1, this.mEmptyViewBehavior);
        goto L36
    L19:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_previousState, "styleable", "Carousel_carousel_previousState")) goto L22;
        this.mPreviousState = r10.getResourceId(r1, this.mPreviousState);
        goto L36
    L22:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_nextState, "styleable", "Carousel_carousel_nextState")) goto L25;
        this.mNextState = r10.getResourceId(r1, this.mNextState);
        goto L36
    L25:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_touchUp_dampeningFactor, "styleable", "Carousel_carousel_touchUp_dampeningFactor")) goto L28;
        this.mDampening = r10.getFloat(r1, this.mDampening);
        goto L36
    L28:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_touchUpMode, "styleable", "Carousel_carousel_touchUpMode")) goto L31;
        this.mTouchUpMode = r10.getInt(r1, this.mTouchUpMode);
        goto L36
    L31:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_touchUp_velocityThreshold, "styleable", "Carousel_carousel_touchUp_velocityThreshold")) goto L34;
        this.mVelocityThreshold = r10.getFloat(r1, this.mVelocityThreshold);
        goto L36
    L34:
        if (r1 != ZeusTransformUtils.mapRes(R.styleable.Carousel_carousel_infinite, "styleable", "Carousel_carousel_infinite")) goto L36;
        this.mInfiniteCarousel = r10.getBoolean(r1, this.mInfiniteCarousel);
        goto L36
    L37:
        r10.recycle();
        return;
    }

    public void setAdapter(a r3) {
        this.mAdapter = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public void setInfinite(boolean r1) {
        this.mInfiniteCarousel = r1;
    }

    public boolean isInfinite() {
        return this.mInfiniteCarousel;
    }

    public int getCount() {
        a r0 = this.mAdapter;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.a();
    }

    public int getCurrentIndex() {
        return this.mIndex;
    }

    public void transitionToIndex(int r3, int r4) {
        this.mTargetIndex = Math.max(0, Math.min(getCount() - 1, r3));
        int r5 = Math.max(0, r4);
        this.mAnimateTargetDelay = r5;
        this.mMotionLayout.setTransitionDuration(r5);
        if (r3 >= this.mIndex) goto L5;
        this.mMotionLayout.transitionToState(this.mPreviousState, this.mAnimateTargetDelay);
        return;
    L5:
        this.mMotionLayout.transitionToState(this.mNextState, this.mAnimateTargetDelay);
    }

    public void jumpToIndex(int r2) {
        this.mIndex = Math.max(0, Math.min(getCount() - 1, r2));
        refresh();
    }

    public void refresh() {
        int r0 = this.mList.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        View r3 = (View) ZeusTransformUtils.preCheckCast(this.mList.get(r2), View.class, "com.obric.aiagent.plugin");
        if (this.mAdapter.a() != 0) goto L7;
        updateViewVisibility(r3, this.mEmptyViewBehavior);
    L8:
        r2 = r2 + 1;
        goto L3
    L7:
        updateViewVisibility(r3, 0);
        goto L8
    L9:
        this.mMotionLayout.rebuildScene();
        updateItems();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelper, com.obric.oui.constraintlayout.motion.widget.MotionLayout.f
    public void onTransitionChange(MotionLayout r1, int r2, int r3, float r4) {
        this.mLastStartId = r2;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelper, com.obric.oui.constraintlayout.motion.widget.MotionLayout.f
    public void onTransitionCompleted(MotionLayout r2, int r3) {
        int r4 = this.mIndex;
        this.mPreviousIndex = r4;
        if (r3 != this.mNextState) goto L6;
        this.mIndex = r4 + 1;
    L9:
        if (this.mInfiniteCarousel == false) goto L17;
        if (this.mIndex < this.mAdapter.a()) goto L14;
        this.mIndex = 0;
    L14:
        if (this.mIndex >= 0) goto L23;
        this.mIndex = this.mAdapter.a() - 1;
    L23:
        if (this.mPreviousIndex == this.mIndex) goto L26;
        this.mMotionLayout.post(this.mUpdateRunnable);
        return;
    L26:
        return;
    L17:
        if (this.mIndex < this.mAdapter.a()) goto L20;
        this.mIndex = this.mAdapter.a() - 1;
    L20:
        if (this.mIndex >= 0) goto L23;
        this.mIndex = 0;
        goto L23
    L6:
        if (r3 != this.mPreviousState) goto L9;
        this.mIndex = r4 - 1;
        goto L9
    }

    private void enableAllTransitions(boolean r4) {
        Iterator<MotionScene.Transition> r3 = this.mMotionLayout.getDefinedTransitions().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((MotionScene.Transition) ZeusTransformUtils.preCheckCast(r3.next(), MotionScene.Transition.class, "com.obric.aiagent.plugin")).a(r4);
        goto L4
    }

    private boolean enableTransition(int r3, boolean r4) {
        if (r3 != (-1)) goto L5;
        return false;
    L5:
        MotionLayout r2 = this.mMotionLayout;
        if (r2 != null) goto L8;
        return false;
    L8:
        MotionScene.Transition r5 = r2.getTransition(r3);
        if (r5 != null) goto L12;
        return false;
    L12:
        if (r4 != r5.f()) goto L14;
        return false;
    L14:
        r5.a(r4);
        return true;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mList.clear();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (ZeusTransformUtils.instanceOf(getParent(), MotionLayout.class) == false) goto L24;
        MotionLayout r0 = (MotionLayout) ZeusTransformUtils.preCheckCast(getParent(), MotionLayout.class, "com.obric.aiagent.plugin");
        this.mList.clear();
        int r1 = 0;
    L6:
        if (r1 >= this.mCount) goto L11;
        int r2 = this.mIds[r1];
        View r3 = r0.getViewById(r2);
        if (this.mFirstViewReference != r2) goto L10;
        this.mStartIndex = r1;
    L10:
        this.mList.add(r3);
        r1 = r1 + 1;
        goto L6
    L11:
        this.mMotionLayout = r0;
        if (this.mTouchUpMode != 2) goto L19;
        MotionScene.Transition r4 = r0.getTransition(this.mForwardTransition);
        if (r4 == null) goto L16;
        r4.d(5);
    L16:
        MotionScene.Transition r5 = this.mMotionLayout.getTransition(this.mBackwardTransition);
        if (r5 == null) goto L19;
        r5.d(5);
    L19:
        updateItems();
        return;
    }

    private boolean updateViewVisibility(View r5, int r6) {
        MotionLayout r0 = this.mMotionLayout;
        int r1 = 0;
        if (r0 != null) goto L5;
        return false;
    L5:
        int[] r2 = r0.getConstraintSetIds();
        boolean r3 = false;
    L7:
        if (r1 >= r2.length) goto L9;
        r3 = r3 | updateViewVisibility(r2[r1], r5, r6);
        r1 = r1 + 1;
        goto L7
    L9:
        return r3;
    }

    private boolean updateViewVisibility(int r2, View r3, int r4) {
        c r1 = this.mMotionLayout.getConstraintSet(r2);
        if (r1 != null) goto L5;
        return false;
    L5:
        c.a r5 = r1.f(r3.getId());
        if (r5 != null) goto L8;
        return false;
    L8:
        r5.f34959c.f34980c = 1;
        r3.setVisibility(r4);
        return true;
    }

    private void updateItems() {
        a r0 = this.mAdapter;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.mMotionLayout != null) goto L9;
        return;
    L9:
        if (r0.a() != 0) goto L11;
        return;
    L11:
        int r1 = this.mList.size();
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L46;
        View r3 = (View) ZeusTransformUtils.preCheckCast(this.mList.get(r2), View.class, "com.obric.aiagent.plugin");
        int r4 = (this.mIndex + r2) - this.mStartIndex;
        if (this.mInfiniteCarousel == true) goto L16;
        if (r4 >= 0) goto L42;
        updateViewVisibility(r3, this.mEmptyViewBehavior);
    L45:
        r2 = r2 + 1;
        goto L12
    L42:
        if (r4 < this.mAdapter.a()) goto L44;
        updateViewVisibility(r3, this.mEmptyViewBehavior);
        goto L45
    L44:
        updateViewVisibility(r3, 0);
        this.mAdapter.a(r3, r4);
        goto L45
    L16:
        if (r4 >= 0) goto L26;
        int r6 = this.mEmptyViewBehavior;
        if (r6 == 4) goto L20;
        updateViewVisibility(r3, r6);
    L22:
        if ((r4 % this.mAdapter.a()) != 0) goto L24;
        this.mAdapter.a(r3, 0);
        goto L45
    L24:
        a r5 = this.mAdapter;
        r5.a(r3, r5.a() + (r4 % this.mAdapter.a()));
        goto L45
    L20:
        updateViewVisibility(r3, 0);
        goto L22
    L26:
        if (r4 >= this.mAdapter.a()) goto L28;
        updateViewVisibility(r3, 0);
        this.mAdapter.a(r3, r4);
        goto L45
    L28:
        if (r4 != this.mAdapter.a()) goto L31;
        r4 = 0;
    L33:
        int r7 = this.mEmptyViewBehavior;
        if (r7 == 4) goto L36;
        updateViewVisibility(r3, r7);
    L37:
        this.mAdapter.a(r3, r4);
        goto L45
    L36:
        updateViewVisibility(r3, 0);
        goto L37
    L31:
        if (r4 <= this.mAdapter.a()) goto L33;
        r4 = r4 % this.mAdapter.a();
        goto L33
    L46:
        int r8 = this.mTargetIndex;
        if (r8 == (-1)) goto L52;
        if (r8 == this.mIndex) goto L52;
        this.mMotionLayout.post(new $$Lambda$Carousel$Nr2HT6i5YBB5WUWf6KslI8Bttw(this));
    L55:
        if (this.mBackwardTransition != (-1)) goto L57;
    L71:
        INVOKESTATIC_com_obric_oui_constraintlayout_helper_widget_Carousel_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "No backward or forward transitions defined for Carousel!");
        return;
    L57:
        if (this.mForwardTransition == (-1)) goto L71;
        if (this.mInfiniteCarousel == false) goto L62;
        return;
    L62:
        int r9 = this.mAdapter.a();
        if (this.mIndex != 0) goto L65;
        enableTransition(this.mBackwardTransition, false);
    L67:
        if (this.mIndex != (r9 - 1)) goto L69;
        enableTransition(this.mForwardTransition, false);
        return;
    L69:
        enableTransition(this.mForwardTransition, true);
        this.mMotionLayout.setTransition(this.mForwardTransition);
        return;
    L65:
        enableTransition(this.mBackwardTransition, true);
        this.mMotionLayout.setTransition(this.mBackwardTransition);
    L52:
        if (r8 != this.mIndex) goto L55;
        this.mTargetIndex = -1;
        goto L55
    }

    public /* synthetic */ void lambda$updateItems$0$Carousel() {
        this.mMotionLayout.setTransitionDuration(this.mAnimateTargetDelay);
        if (this.mTargetIndex >= this.mIndex) goto L5;
        this.mMotionLayout.transitionToState(this.mPreviousState, this.mAnimateTargetDelay);
        return;
    L5:
        this.mMotionLayout.transitionToState(this.mNextState, this.mAnimateTargetDelay);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_constraintlayout_helper_widget_Carousel_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
