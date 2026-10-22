package com.bytedance.android.ui.ec.widget.photodraweeview.transition;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.ui.ec.widget.photodraweeview.DragActionHelper;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.TransformGestureDetector;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019*\u0001\u0012\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005B%\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020JH\u0016J\n\u0010W\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010X\u001a\u00020UH\u0016J\b\u0010Y\u001a\u00020UH\u0002J\u0010\u0010Z\u001a\u00020'2\u0006\u0010[\u001a\u00020\\H\u0016J\b\u0010]\u001a\u00020\u001fH\u0002J\u0006\u0010^\u001a\u00020'J\u0010\u0010_\u001a\u00020U2\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010`\u001a\u00020U2\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010a\u001a\u00020U2\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0018\u0010b\u001a\u00020U2\u0006\u0010c\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020\u000bH\u0014J\u0010\u0010e\u001a\u00020'2\u0006\u0010f\u001a\u00020\\H\u0016J\u0010\u0010g\u001a\u00020U2\u0006\u0010V\u001a\u00020JH\u0016J\u0010\u0010h\u001a\u00020U2\u0006\u0010i\u001a\u00020'H\u0016J\u0010\u0010j\u001a\u00020U2\u0006\u0010k\u001a\u00020\u001fH\u0002J\u000e\u0010l\u001a\u00020U2\u0006\u0010m\u001a\u00020\u0004J\u000e\u0010n\u001a\u00020U2\u0006\u0010;\u001a\u00020\u001fJ\u0018\u0010o\u001a\u00020U2\u0006\u0010p\u001a\u00020\u001f2\u0006\u0010q\u001a\u00020\u0017H\u0002J\b\u0010r\u001a\u00020UH\u0002J\u0012\u0010s\u001a\u00020U*\u00020\u001f2\u0006\u0010t\u001a\u00020PR\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010!X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020'X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020'X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001a\u0010.\u001a\u00020'X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R&\u00102\u001a\u0002012\u0006\u00100\u001a\u0002018V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010)\"\u0004\b9\u0010+R\u000e\u0010:\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010;\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010C\u001a\u00020B2\u0006\u00100\u001a\u00020B8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001e\u0010H\u001a\u0012\u0012\u0004\u0012\u00020J0Ij\b\u0012\u0004\u0012\u00020J`KX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020SX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/GestureListener;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/TransformGestureDetector;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionView;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/ITransitionParams;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alphaAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "animator", "animatorListener", "com/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionLayout$animatorListener$1", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionLayout$animatorListener$1;", "animatorUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "childView", "Landroid/view/View;", "childViewLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "detector", "dismissAlphaAnimatorUpdateListener", "dragActionHelper", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/DragActionHelper;", "endWorkingRect", "Landroid/graphics/Rect;", "getExitRect", "Lkotlin/Function0;", "getGetExitRect", "()Lkotlin/jvm/functions/Function0;", "setGetExitRect", "(Lkotlin/jvm/functions/Function0;)V", "isChildViewRequestDisallowInterceptTouchEvent", "", "isDragReturnAnimationEnabled", "()Z", "setDragReturnAnimationEnabled", "(Z)V", "isDragTransitionEnabled", "setDragTransitionEnabled", "isSingleTagDismissEnabled", "setSingleTagDismissEnabled", "value", "", "maxDragTransitionFactor", "getMaxDragTransitionFactor", "()F", "setMaxDragTransitionFactor", "(F)V", "optEnterTransition", "getOptEnterTransition", "setOptEnterTransition", "savedScaleFactor", "startRect", "getStartRect", "()Landroid/graphics/Rect;", "setStartRect", "(Landroid/graphics/Rect;)V", "tempLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "", "transitionAnimationDuration", "getTransitionAnimationDuration", "()J", "setTransitionAnimationDuration", "(J)V", "transitionListeners", "Ljava/util/LinkedHashSet;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "Lkotlin/collections/LinkedHashSet;", "transitionState", "transitionViewDelegate", "workingRect", "workingRectF", "Landroid/graphics/RectF;", "workingStartRect", "workingTransform", "Landroid/graphics/Matrix;", "addTransitionListener", "", "listener", "checkAndGetChildView", "dismissAnimated", "dismissAnimatedInternal", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getExitRectInner", "isEnableDismissTransition", "onGestureBegin", "onGestureEnd", "onGestureUpdate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "removeTransitionListener", "requestDisallowInterceptTouchEvent", "disallowIntercept", "setChildExitSize", "exitRect", "setDelegateDragTransitionView", "transitionView", "startEnterTransition", "transformView", SVGRenderEngine.RECT, "view", "useTempLayoutParams", "set", "rectF", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransitionLayout extends FrameLayout implements GestureListener<TransformGestureDetector>, TransitionView, ITransitionParams {
    private final ValueAnimator alphaAnimator;
    private final ValueAnimator animator;
    private final TransitionLayout$animatorListener$1 animatorListener;
    private final ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
    private View childView;
    private ViewGroup.LayoutParams childViewLayoutParams;
    private final TransformGestureDetector detector;
    private final ValueAnimator.AnimatorUpdateListener dismissAlphaAnimatorUpdateListener;
    private final DragActionHelper dragActionHelper;
    private Rect endWorkingRect;
    private Function0<Rect> getExitRect;
    private boolean isChildViewRequestDisallowInterceptTouchEvent;
    private boolean isDragReturnAnimationEnabled;
    private boolean isDragTransitionEnabled;
    private boolean isSingleTagDismissEnabled;
    private float maxDragTransitionFactor;
    private boolean optEnterTransition;
    private float savedScaleFactor;
    private Rect startRect;
    private final FrameLayout.LayoutParams tempLayoutParams;
    private long transitionAnimationDuration;
    private final LinkedHashSet<TransitionListener> transitionListeners;
    private int transitionState;
    private TransitionView transitionViewDelegate;
    private final Rect workingRect;
    private final RectF workingRectF;
    private Rect workingStartRect;
    private final Matrix workingTransform;

    public TransitionLayout(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public TransitionLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    @Override // android.view.View, com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionView
    public boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return true;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionView
    public void dismissAnimated() {
        TransitionView r100 = this.transitionViewDelegate;
        if (r100 == null) goto L6;
        if (r100 == null) goto L8;
        r100.dismissAnimated();
        return;
    L8:
        return;
    L6:
        useTempLayoutParams();
        dismissAnimatedInternal();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public float getMaxDragTransitionFactor() {
        return this.dragActionHelper.getMaxDragTransitionFactor();
    }

    public final boolean isEnableDismissTransition() {
        if (this.transitionViewDelegate == null) goto L5;
    L8:
        return true;
    L5:
        if (getExitRectInner().isEmpty() == false) goto L8;
        return false;
    }

    private final View checkAndGetChildView() {
        if (getChildCount() >= 2) goto L10;
        if (this.childView != null) goto L8;
        this.childView = getChildAt(0);
    L8:
        return this.childView;
    L10:
        throw new IllegalStateException("only allow one child view");
    }

    private final void dismissAnimatedInternal() {
        Rect r100 = getExitRectInner();
        View r101 = checkAndGetChildView();
        if (r101 == null) goto L5;
        this.workingStartRect.set(0, 0, r101.getMeasuredWidth(), r101.getMeasuredHeight());
    L5:
        this.endWorkingRect.set(r100);
        this.transitionState = 2;
        setChildExitSize(r100);
        this.animator.start();
        if (r100.isEmpty() == false) goto L8;
    L9:
        this.alphaAnimator.start();
        return;
    L8:
        if (this.workingStartRect.isEmpty() == true) goto L9;
    }

    private final Rect getExitRectInner() {
        Function0<Rect> r100 = getGetExitRect();
        if (r100 == null) goto L12;
        Rect r101 = r100.invoke();
        if (r101 == null) goto L12;
        if ((!r101.isEmpty()) == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L12;
        return r101;
    L12:
        return getStartRect();
    }

    private final void useTempLayoutParams() {
        View r100 = checkAndGetChildView();
        if (r100 == null) goto L6;
        this.childViewLayoutParams = r100.getLayoutParams();
        r100.setLayoutParams(this.tempLayoutParams);
        return;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public Function0<Rect> getGetExitRect() {
        return this.getExitRect;
    }

    public final boolean getOptEnterTransition() {
        return this.optEnterTransition;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public Rect getStartRect() {
        return this.startRect;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public long getTransitionAnimationDuration() {
        return this.transitionAnimationDuration;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public boolean isDragReturnAnimationEnabled() {
        return this.isDragReturnAnimationEnabled;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public boolean isDragTransitionEnabled() {
        return this.isDragTransitionEnabled;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public boolean isSingleTagDismissEnabled() {
        return this.isSingleTagDismissEnabled;
    }

    public static final /* synthetic */ View access$checkAndGetChildView(TransitionLayout r100) {
        return r100.checkAndGetChildView();
    }

    public static final /* synthetic */ ValueAnimator access$getAnimator$p(TransitionLayout r100) {
        return r100.animator;
    }

    public static final /* synthetic */ ViewGroup.LayoutParams access$getChildViewLayoutParams$p(TransitionLayout r100) {
        return r100.childViewLayoutParams;
    }

    public static final /* synthetic */ Rect access$getEndWorkingRect$p(TransitionLayout r100) {
        return r100.endWorkingRect;
    }

    public static final /* synthetic */ LinkedHashSet access$getTransitionListeners$p(TransitionLayout r100) {
        return r100.transitionListeners;
    }

    public static final /* synthetic */ int access$getTransitionState$p(TransitionLayout r100) {
        return r100.transitionState;
    }

    public static final /* synthetic */ Rect access$getWorkingRect$p(TransitionLayout r100) {
        return r100.workingRect;
    }

    public static final /* synthetic */ Rect access$getWorkingStartRect$p(TransitionLayout r100) {
        return r100.workingStartRect;
    }

    public static final /* synthetic */ void access$useTempLayoutParams(TransitionLayout r100) {
        r100.useTempLayoutParams();
    }

    private final void setChildExitSize(Rect r100) {
        if (r100.isEmpty() == true) goto L11;
        ViewGroup.LayoutParams r101 = this.childViewLayoutParams;
        if (r101 == null) goto L7;
        r101.height = r100.height();
    L7:
        ViewGroup.LayoutParams r102 = this.childViewLayoutParams;
        if (r102 == null) goto L12;
        r102.width = r100.width();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionView
    public void addTransitionListener(TransitionListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.transitionListeners.add(r100);
        TransitionView r101 = this.transitionViewDelegate;
        if (r101 == null) goto L7;
        if (r101 == null) goto L8;
        r101.addTransitionListener(r100);
        return;
    L8:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        boolean r101 = false;
        if (this.animator.isRunning() == false) goto L6;
        return false;
    L6:
        if (r100.getAction() != 0) goto L9;
        this.isChildViewRequestDisallowInterceptTouchEvent = false;
    L9:
        if (this.transitionViewDelegate != null) goto L19;
        if (this.isChildViewRequestDisallowInterceptTouchEvent == true) goto L19;
        this.detector.onTouchEvent(r100);
        ViewParent r102 = getParent();
        if (r102 == null) goto L19;
        if (this.transitionState != 3) goto L17;
        r101 = true;
    L17:
        r102.requestDisallowInterceptTouchEvent(r101);
    L19:
        return super.dispatchTouchEvent(r100);
    }

    /* JADX INFO: renamed from: onGestureBegin, reason: avoid collision after fix types in other method */
    public void onGestureBegin2(TransformGestureDetector r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        this.transitionState = -1;
    }

    /* JADX INFO: renamed from: onGestureEnd, reason: avoid collision after fix types in other method */
    public void onGestureEnd2(TransformGestureDetector r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        this.savedScaleFactor = this.dragActionHelper.getScaleFactorWhenDragState();
        if (this.transitionState != 3) goto L32;
        Iterator<T> r101 = this.transitionListeners.iterator();
    L6:
        if (r101.hasNext() == false) goto L9;
        ((TransitionListener) r101.next()).onTransitionEnd(this.transitionState);
        goto L6
    L9:
        if (this.dragActionHelper.isDragOutSatisfied() == false) goto L29;
        this.workingStartRect.set(this.workingRect);
        Function0<Rect> r102 = getGetExitRect();
        if (r102 == null) goto L19;
        Rect r103 = r102.invoke();
        if (r103 == null) goto L19;
        if ((true ^ r103.isEmpty()) == true) goto L18;
        r103 = null;
    L18:
        if (r103 == null) goto L19;
    L21:
        if (r103.isEmpty() == false) goto L23;
    L25:
        this.workingTransform.reset();
        this.workingTransform.postScale(0.1f, 0.1f, this.workingRect.centerX(), this.workingRect.centerY());
        this.workingRectF.set(this.endWorkingRect);
        this.workingTransform.mapRect(this.workingRectF);
        set(this.workingRect, this.workingRectF);
        this.endWorkingRect.set(this.workingRect);
    L26:
        this.transitionState = 2;
        this.animator.start();
        if (r103.isEmpty() == false) goto L33;
        this.alphaAnimator.start();
        return;
    L33:
        return;
    L23:
        if (isDragReturnAnimationEnabled() == false) goto L25;
        this.endWorkingRect.set(r103);
        setChildExitSize(r103);
    L19:
        r103 = getStartRect();
        goto L21
    L29:
        this.workingStartRect.set(this.workingRect);
        this.transitionState = 1;
        this.animator.start();
        return;
    }

    /* JADX INFO: renamed from: onGestureUpdate, reason: avoid collision after fix types in other method */
    public void onGestureUpdate2(TransformGestureDetector r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        if (this.detector.getGestureIntent() != 4) goto L14;
        if (this.transitionState == 3) goto L14;
        if (isDragTransitionEnabled() == false) goto L14;
        this.transitionState = 3;
        Iterator<T> r101 = this.transitionListeners.iterator();
    L10:
        if (r101.hasNext() == false) goto L12;
        ((TransitionListener) r101.next()).onTransitionBegin(this.transitionState);
        goto L10
    L12:
        useTempLayoutParams();
    L14:
        if (this.transitionState != 3) goto L22;
        this.workingTransform.reset();
        this.workingTransform.postTranslate(this.detector.getTranslationX(), this.detector.getTranslationY());
        this.workingTransform.postScale(this.dragActionHelper.getScaleFactorWhenDragState(), this.dragActionHelper.getScaleFactorWhenDragState(), this.workingRect.centerX(), this.workingRect.centerY());
        this.workingRectF.set(this.endWorkingRect);
        this.workingTransform.mapRect(this.workingRectF);
        set(this.workingRect, this.workingRectF);
        View r102 = checkAndGetChildView();
        if (r102 == null) goto L18;
        transformView(this.workingRect, r102);
    L18:
        Iterator<T> r103 = this.transitionListeners.iterator();
    L20:
        if (r103.hasNext() == false) goto L25;
        ((TransitionListener) r103.next()).onTransitionChanged(this.transitionState, this.dragActionHelper.getDragFactor());
        goto L20
    L25:
        return;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionView
    public void removeTransitionListener(TransitionListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.transitionListeners.remove(r100);
        TransitionView r101 = this.transitionViewDelegate;
        if (r101 == null) goto L7;
        if (r101 == null) goto L8;
        r101.removeTransitionListener(r100);
        return;
    L8:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r100) {
        super.requestDisallowInterceptTouchEvent(r100);
        this.isChildViewRequestDisallowInterceptTouchEvent = r100;
    }

    public final void setDelegateDragTransitionView(TransitionView r100) {
        Intrinsics.checkNotNullParameter(r100, "transitionView");
        this.transitionViewDelegate = r100;
        Iterator<T> r101 = this.transitionListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        TransitionListener r102 = (TransitionListener) r101.next();
        TransitionView r103 = this.transitionViewDelegate;
        if (r103 == null) goto L4;
        r103.addTransitionListener(r102);
        goto L4
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setDragReturnAnimationEnabled(boolean r100) {
        this.isDragReturnAnimationEnabled = r100;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setDragTransitionEnabled(boolean r100) {
        this.isDragTransitionEnabled = r100;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setGetExitRect(Function0<Rect> r100) {
        this.getExitRect = r100;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setMaxDragTransitionFactor(float r100) {
        this.maxDragTransitionFactor = r100;
        this.dragActionHelper.setMaxDragTransitionFactor(r100);
    }

    public final void setOptEnterTransition(boolean r100) {
        this.optEnterTransition = r100;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setSingleTagDismissEnabled(boolean r100) {
        this.isSingleTagDismissEnabled = r100;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setStartRect(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.startRect.set(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setTransitionAnimationDuration(long r100) {
        this.transitionAnimationDuration = r100;
        this.animator.setDuration(r100);
        this.alphaAnimator.setDuration(r100);
    }

    public final void startEnterTransition(final Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "startRect");
        if (this.animator.isRunning() == false) goto L5;
        return;
    L5:
        post(new AnonymousClass1(this, r100));
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureBegin(TransformGestureDetector r100) {
        onGestureBegin2(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureEnd(TransformGestureDetector r100) {
        onGestureEnd2(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureUpdate(TransformGestureDetector r100) {
        onGestureUpdate2(r100);
    }

    public static final /* synthetic */ void access$setChildViewLayoutParams$p(TransitionLayout r100, ViewGroup.LayoutParams r101) {
        r100.childViewLayoutParams = r101;
    }

    public static final /* synthetic */ void access$setEndWorkingRect$p(TransitionLayout r100, Rect r101) {
        r100.endWorkingRect = r101;
    }

    public static final /* synthetic */ void access$setTransitionState$p(TransitionLayout r100, int r101) {
        r100.transitionState = r101;
    }

    public static final /* synthetic */ void access$setWorkingStartRect$p(TransitionLayout r100, Rect r101) {
        r100.workingStartRect = r101;
    }

    private final void transformView(Rect r100, View r101) {
        r101.setX(r100.left);
        r101.setY(r100.top);
        r101.getLayoutParams().width = r100.width();
        r101.getLayoutParams().height = r100.height();
        r101.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        View r102 = checkAndGetChildView();
        if (r102 != null) goto L7;
        super.onMeasure(r100, r101);
        return;
    L7:
        if (this.optEnterTransition == false) goto L16;
        int r103 = this.transitionState;
        if (r103 == (-1)) goto L12;
        if (r103 != 0) goto L16;
    L12:
        if (getStartRect().isEmpty() == true) goto L16;
        if (this.childViewLayoutParams != null) goto L16;
        useTempLayoutParams();
        transformView(getStartRect(), r102);
    L16:
        super.onMeasure(r100, r101);
        if (this.optEnterTransition == false) goto L30;
        int r104 = this.transitionState;
        if (r104 == (-1)) goto L22;
        if (r104 == 0) goto L22;
        return;
    L22:
        if (this.endWorkingRect.isEmpty() == false) goto L34;
        Object r105 = r102.getParent();
        if ((r105 instanceof View) == true) goto L26;
        r105 = null;
    L26:
        View r106 = (View) r105;
        if (r106 == null) goto L35;
        this.endWorkingRect.set(0, 0, r106.getMeasuredWidth(), r106.getMeasuredHeight());
        return;
    L35:
        return;
    L34:
        return;
    L30:
        if (this.transitionState != (-1)) goto L37;
        this.endWorkingRect.set(0, 0, r102.getMeasuredWidth(), r102.getMeasuredHeight());
        return;
    }

    public final void set(Rect r100, RectF r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$set");
        Intrinsics.checkNotNullParameter(r101, "rectF");
        r100.left = (int) r101.left;
        r100.top = (int) r101.top;
        r100.right = (int) r101.right;
        r100.bottom = (int) r101.bottom;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.animation.Animator$AnimatorListener, com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionLayout$animatorListener$1] */
    public TransitionLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.workingStartRect = new Rect();
        this.endWorkingRect = new Rect();
        this.workingRect = new Rect();
        this.workingRectF = new RectF();
        this.workingTransform = new Matrix();
        this.tempLayoutParams = new FrameLayout.LayoutParams(0, 0);
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.animator = r103;
        TransformGestureDetector r104 = new TransformGestureDetector();
        this.detector = r104;
        this.transitionState = -1;
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.alphaAnimator = r105;
        this.transitionListeners = new LinkedHashSet();
        ValueAnimator.AnimatorUpdateListener r106 = new TransitionLayout$dismissAlphaAnimatorUpdateListener$1(this);
        this.dismissAlphaAnimatorUpdateListener = r106;
        this.dragActionHelper = new DragActionHelper(r100, r104);
        this.savedScaleFactor = 1.0f;
        this.transitionAnimationDuration = 300;
        this.isDragTransitionEnabled = true;
        this.maxDragTransitionFactor = 0.4f;
        this.isSingleTagDismissEnabled = true;
        this.startRect = new Rect();
        ValueAnimator.AnimatorUpdateListener r107 = new TransitionLayout$animatorUpdateListener$1(this);
        this.animatorUpdateListener = r107;
        ?? r108 = new TransitionLayout$animatorListener$1(this);
        this.animatorListener = r108;
        r104.ignoreInitGestureIntent(2);
        r103.addUpdateListener(r107);
        r103.addListener(r108);
        r103.setDuration(getTransitionAnimationDuration());
        r105.setDuration(getTransitionAnimationDuration());
        r105.addUpdateListener(r106);
        r104.addListener(this);
    }

    public static final /* synthetic */ void access$transformView(TransitionLayout r100, Rect r101, View r102) {
        r100.transformView(r101, r102);
    }

    public /* synthetic */ TransitionLayout(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
