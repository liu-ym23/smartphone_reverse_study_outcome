package com.obric.autoaction.view;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.OvershootInterpolator;
import com.obric.oui.layout.OUIConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.k;
import d.l.n;
import d.x;

/* JADX INFO: compiled from: DraggableFloatingLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DraggableFloatingLayout extends OUIConstraintLayout {
    private static final a Companion = null;

    @Deprecated
    public static final long DEFAULT_RIGHT_REVEAL_AUTO_RETRACT_DELAY_MS = 6000;
    private int bottomDockMarginPx;
    private int bottomSnapRightExclusionPx;
    private int bottomSnapZonePx;
    private float dX;
    private float dY;
    private b dock;
    private float downRawX;
    private float downRawY;
    private boolean isDragEnabled;
    private boolean isDragging;
    private d.h.a.a<x> onDockStateChanged;
    private d.h.a.a<x> onDragEndListener;
    private d.h.a.a<x> onDragStartListener;
    private d.h.a.a<x> onRightRevealAutoRetract;
    private boolean pointerDragging;
    private Integer rightDockTopPx;
    private int rightDockVisibleWidthPx;
    private long rightRevealAutoRetractDelayMs;
    private final Runnable rightRevealAutoRetractRunnable;
    private int rightSlideOutMarginPx;
    private boolean shouldResumeRightRevealAutoRetract;
    private int sideClampMarginPx;
    private int topClampMinPx;
    private final int touchSlop;

    /* JADX INFO: compiled from: DraggableFloatingLayout.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: DraggableFloatingLayout.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f26076a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f26077b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f26078c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ b[] f26079d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f26080e = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f26076a, f26077b, f26078c};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f26076a = new b("Bottom", 0);
            f26077b = new b("RightPeek", 1);
            f26078c = new b("RightReveal", 2);
            b[] r0 = a();
            f26079d = r0;
            f26080e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f26079d.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: DraggableFloatingLayout.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26081a = null;

        static {
            int[] r0 = new int[b.values().length];
            r0[b.f26076a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[b.f26077b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[b.f26078c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f26081a = r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public DraggableFloatingLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public DraggableFloatingLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void lambda$8OWEfkW6je3hGd5asgYYqUb55ug(DraggableFloatingLayout r0) {
        rightRevealAutoRetractRunnable$lambda$0(r0);
    }

    public /* synthetic */ DraggableFloatingLayout(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public DraggableFloatingLayout(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        super(r13, r4, r12, null, 8, null);
        this.isDragEnabled = true;
        float r14 = 20;
        this.bottomDockMarginPx = d.i.a.a(TypedValue.applyDimension(1, r14, Resources.getSystem().getDisplayMetrics()));
        this.rightDockVisibleWidthPx = d.i.a.a(TypedValue.applyDimension(1, 41, Resources.getSystem().getDisplayMetrics()));
        this.rightSlideOutMarginPx = d.i.a.a(TypedValue.applyDimension(1, 13, Resources.getSystem().getDisplayMetrics()));
        this.rightRevealAutoRetractDelayMs = DEFAULT_RIGHT_REVEAL_AUTO_RETRACT_DELAY_MS;
        this.topClampMinPx = d.i.a.a(TypedValue.applyDimension(1, 62, Resources.getSystem().getDisplayMetrics()));
        this.sideClampMarginPx = d.i.a.a(TypedValue.applyDimension(1, r14, Resources.getSystem().getDisplayMetrics()));
        this.bottomSnapZonePx = d.i.a.a(TypedValue.applyDimension(1, 74, Resources.getSystem().getDisplayMetrics()));
        this.bottomSnapRightExclusionPx = d.i.a.a(TypedValue.applyDimension(1, 118, Resources.getSystem().getDisplayMetrics()));
        this.dock = b.f26076a;
        this.touchSlop = ViewConfiguration.get(r13).getScaledTouchSlop();
        this.rightRevealAutoRetractRunnable = new $$Lambda$DraggableFloatingLayout$8OWEfkW6je3hGd5asgYYqUb55ug(this);
    }

    public final boolean isDragEnabled() {
        return this.isDragEnabled;
    }

    public final void setDragEnabled(boolean r1) {
        this.isDragEnabled = r1;
        if (r1 == true) goto L6;
        resetDragState();
        return;
    }

    public final boolean isDragging() {
        return this.isDragging;
    }

    public final int getBottomDockMarginPx() {
        return this.bottomDockMarginPx;
    }

    public final void setBottomDockMarginPx(int r1) {
        this.bottomDockMarginPx = r1;
    }

    public final int getRightDockVisibleWidthPx() {
        return this.rightDockVisibleWidthPx;
    }

    public final void setRightDockVisibleWidthPx(int r1) {
        this.rightDockVisibleWidthPx = r1;
    }

    public final int getRightSlideOutMarginPx() {
        return this.rightSlideOutMarginPx;
    }

    public final void setRightSlideOutMarginPx(int r1) {
        this.rightSlideOutMarginPx = r1;
    }

    public final long getRightRevealAutoRetractDelayMs() {
        return this.rightRevealAutoRetractDelayMs;
    }

    public final void setRightRevealAutoRetractDelayMs(long r1) {
        this.rightRevealAutoRetractDelayMs = r1;
    }

    public final int getTopClampMinPx() {
        return this.topClampMinPx;
    }

    public final void setTopClampMinPx(int r1) {
        this.topClampMinPx = r1;
    }

    public final int getSideClampMarginPx() {
        return this.sideClampMarginPx;
    }

    public final void setSideClampMarginPx(int r1) {
        this.sideClampMarginPx = r1;
    }

    public final int getBottomSnapZonePx() {
        return this.bottomSnapZonePx;
    }

    public final void setBottomSnapZonePx(int r1) {
        this.bottomSnapZonePx = r1;
    }

    public final int getBottomSnapRightExclusionPx() {
        return this.bottomSnapRightExclusionPx;
    }

    public final void setBottomSnapRightExclusionPx(int r1) {
        this.bottomSnapRightExclusionPx = r1;
    }

    public final d.h.a.a<x> getOnDragStartListener() {
        return this.onDragStartListener;
    }

    public final void setOnDragStartListener(d.h.a.a<x> r3) {
        this.onDragStartListener = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public final d.h.a.a<x> getOnDragEndListener() {
        return this.onDragEndListener;
    }

    public final void setOnDragEndListener(d.h.a.a<x> r3) {
        this.onDragEndListener = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public final d.h.a.a<x> getOnDockStateChanged() {
        return this.onDockStateChanged;
    }

    public final void setOnDockStateChanged(d.h.a.a<x> r3) {
        this.onDockStateChanged = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public final d.h.a.a<x> getOnRightRevealAutoRetract() {
        return this.onRightRevealAutoRetract;
    }

    public final void setOnRightRevealAutoRetract(d.h.a.a<x> r3) {
        this.onRightRevealAutoRetract = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    private static final void rightRevealAutoRetractRunnable$lambda$0(DraggableFloatingLayout r2) {
        if (r2.dock == b.f26078c) goto L5;
        return;
    L5:
        if (r2.isDragging == true) goto L12;
        d.h.a.a<x> r0 = r2.onRightRevealAutoRetract;
        if (r0 == null) goto L9;
        r0.invoke();
        return;
    L9:
        dockRightPeek$default(r2, null, 1, null);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.isDragging == true) goto L6;
        applyCurrentDockPosition();
        return;
    }

    private final void applyCurrentDockPosition() {
        if (getWidth() != 0) goto L5;
        return;
    L5:
        if (getHeight() != 0) goto L7;
        return;
    L7:
        if (parentWidth() != 0) goto L9;
        return;
    L9:
        if (parentHeight() == 0) goto L35;
        int r0 = c.f26081a[this.dock.ordinal()];
        if (r0 != 1) goto L14;
        int r1 = resolveBottomLeft();
        int r2 = resolveBottomTop();
    L30:
        setTranslationX(r1 - getLeft());
        setTranslationY(r2 - getTop());
        return;
    L14:
        if (r0 != 2) goto L16;
        r1 = resolveRightPeekLeft();
        Integer r3 = this.rightDockTopPx;
        if (r3 == null) goto L27;
        int r4 = r3.intValue();
    L28:
        r2 = resolveRightTop(r4);
        this.rightDockTopPx = Integer.valueOf(r2);
        goto L30
    L27:
        r4 = d.i.a.a(visualTop());
        goto L28
    L16:
        if (r0 != 3) goto L23;
        r1 = resolveRightSlideOutLeft();
        Integer r5 = this.rightDockTopPx;
        if (r5 == null) goto L20;
        int r6 = r5.intValue();
    L21:
        r2 = resolveRightTop(r6);
        this.rightDockTopPx = Integer.valueOf(r2);
        goto L30
    L20:
        r6 = d.i.a.a(visualTop());
        goto L21
    L23:
        throw new k();
    }

    public final b currentDock() {
        return this.dock;
    }

    public final boolean isRightDockPeek() {
        if (this.dock != b.f26077b) goto L5;
        return true;
    L5:
        return false;
    }

    public final void syncDockState(b r2) {
        o.e(r2, "dock");
        this.dock = r2;
    }

    public final void dockBottom() {
        cancelRightRevealAutoRetract();
        this.dock = b.f26076a;
        notifyDockStateChanged();
        applyCurrentDockPosition();
    }

    public static /* synthetic */ void dockRightPeek$default(DraggableFloatingLayout r0, Integer r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.dockRightPeek(r1);
    }

    public final void dockRightPeek(Integer r2) {
        cancelRightRevealAutoRetract();
        this.dock = b.f26077b;
        if (r2 == null) goto L5;
        this.rightDockTopPx = r2;
    L5:
        notifyDockStateChanged();
        applyCurrentDockPosition();
    }

    public final boolean revealRightDock() {
        if (this.dock != b.f26077b) goto L5;
    L8:
        cancelRightRevealAutoRetract();
        this.dock = b.f26078c;
        notifyDockStateChanged();
        scheduleRightRevealAutoRetractIfNeeded();
        applyCurrentDockPosition();
        return true;
    L5:
        if (this.dock == b.f26078c) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r4) {
        o.e(r4, "ev");
        if (this.isDragEnabled == false) goto L5;
        int r0 = r4.getActionMasked();
        if (r0 != 0) goto L9;
        beginPointerSession(r4);
        return false;
    L9:
        if (r0 != 1) goto L11;
    L21:
        endPointerSession();
    L23:
        return super.onInterceptTouchEvent(r4);
    L11:
        if (r0 == 2) goto L16;
        if (r0 == 3) goto L21;
    L16:
        if (this.pointerDragging == true) goto L23;
        if (isPastTouchSlop(r4) == false) goto L23;
        beginDragging();
        return true;
    L5:
        return super.onInterceptTouchEvent(r4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        o.e(r4, "event");
        if (this.isDragEnabled == false) goto L5;
        int r0 = r4.getActionMasked();
        if (r0 == 0) goto L36;
        if (r0 == 1) goto L31;
        if (r0 == 2) goto L20;
        if (r0 != 3) goto L29;
        if (this.pointerDragging == false) goto L17;
        snapFromCurrentPosition();
    L17:
        endPointerSession();
        return true;
    L29:
        return super.onTouchEvent(r4);
    L20:
        if (this.pointerDragging == true) goto L25;
        if (isPastTouchSlop(r4) == false) goto L25;
        beginDragging();
    L25:
        if (this.pointerDragging == false) goto L29;
        setTranslationX((r4.getRawX() + this.dX) - getLeft());
        setTranslationY((r4.getRawY() + this.dY) - getTop());
        return true;
    L31:
        if (this.pointerDragging == false) goto L33;
        snapFromCurrentPosition();
    L34:
        endPointerSession();
        return true;
    L33:
        performClick();
        goto L34
    L36:
        beginPointerSession(r4);
        return true;
    L5:
        return super.onTouchEvent(r4);
    }

    @Override // android.view.View
    public boolean performClick() {
        revealRightDock();
        super.performClick();
        return true;
    }

    private final void beginPointerSession(MotionEvent r3) {
        resetDragState();
        if (this.dock != b.f26078c) goto L5;
        boolean r0 = true;
    L6:
        this.shouldResumeRightRevealAutoRetract = r0;
        if (r0 == false) goto L9;
        cancelRightRevealAutoRetract();
    L9:
        this.downRawX = r3.getRawX();
        this.downRawY = r3.getRawY();
        this.dX = visualLeft() - r3.getRawX();
        this.dY = visualTop() - r3.getRawY();
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void beginDragging() {
        this.pointerDragging = true;
        this.isDragging = true;
        this.shouldResumeRightRevealAutoRetract = false;
        if (this.dock != b.f26078c) goto L5;
        this.dock = b.f26077b;
    L5:
        cancelRightRevealAutoRetract();
        d.h.a.a<x> r0 = this.onDragStartListener;
        if (r0 == null) goto L8;
        r0.invoke();
    L8:
        notifyDockStateChanged();
    }

    private final void resetDragState() {
        this.pointerDragging = false;
        this.isDragging = false;
        d.h.a.a<x> r1 = this.onDragEndListener;
        if (r1 == null) goto L6;
        r1.invoke();
        return;
    }

    private final void endPointerSession() {
        if (this.shouldResumeRightRevealAutoRetract == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        resetDragState();
        this.shouldResumeRightRevealAutoRetract = false;
        if (r0 == false) goto L14;
        scheduleRightRevealAutoRetractIfNeeded();
        return;
    L14:
        return;
    L5:
        if (this.pointerDragging == true) goto L9;
        if (this.dock != b.f26078c) goto L9;
        r0 = true;
        goto L10
    }

    private final boolean isPastTouchSlop(MotionEvent r5) {
        if (((float) Math.hypot(r5.getRawX() - this.downRawX, r5.getRawY() - this.downRawY)) <= this.touchSlop) goto L5;
        return true;
    L5:
        return false;
    }

    private final void snapFromCurrentPosition() {
        float r0 = visualLeft() + (getWidth() / 2.0f);
        float r1 = visualTop() + (getHeight() / 2.0f);
        int r2 = parentWidth();
        int r3 = parentHeight();
        TransitionSet r4 = new TransitionSet();
        r4.addTransition((Transition) ZeusTransformUtils.preCheckCast(new ChangeBounds(), Transition.class, "com.obric.aiagent.plugin"));
        r4.addTransition((Transition) ZeusTransformUtils.preCheckCast(new ChangeTransform(), Transition.class, "com.obric.aiagent.plugin"));
        r4.setDuration(300);
        r4.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new OvershootInterpolator(1.0f), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        ViewParent r5 = getParent();
        o.a(r5, "null cannot be cast to non-null type android.view.ViewGroup");
        TransitionManager.beginDelayedTransition((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin"), (Transition) ZeusTransformUtils.preCheckCast(r4, Transition.class, "com.obric.aiagent.plugin"));
        float r6 = r3 - this.bottomSnapZonePx;
        boolean r7 = true;
        if (r1 < r6) goto L5;
        boolean r8 = true;
    L7:
        if (r0 >= (r2 - this.bottomSnapRightExclusionPx)) goto L10;
        r7 = false;
    L10:
        if (r8 == false) goto L13;
        if (r7 == true) goto L13;
        dockBottom();
        return;
    L13:
        dockRightPeek(Integer.valueOf(d.i.a.a(visualTop())));
        return;
    L5:
        r8 = false;
        goto L7
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        cancelRightRevealAutoRetract();
        super.onDetachedFromWindow();
    }

    private final int resolveBottomLeft() {
        return n.c(d.i.a.a((parentWidth() - getWidth()) / 2.0f), 0);
    }

    private final int resolveBottomTop() {
        return n.c((parentHeight() - getHeight()) - this.bottomDockMarginPx, this.topClampMinPx);
    }

    private final int resolveRightPeekLeft() {
        return parentWidth() - this.rightDockVisibleWidthPx;
    }

    private final int resolveRightSlideOutLeft() {
        return (parentWidth() - getWidth()) - this.rightSlideOutMarginPx;
    }

    private final int resolveRightTop(int r3) {
        int r0 = n.c((parentHeight() - getHeight()) - this.sideClampMarginPx, this.topClampMinPx);
        return n.a(r3, this.topClampMinPx, r0);
    }

    private final float visualLeft() {
        return getLeft() + getTranslationX();
    }

    private final float visualTop() {
        return getTop() + getTranslationY();
    }

    private final int parentWidth() {
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L5;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L9;
        return r1.getWidth();
    L9:
        return ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels;
    L5:
        r1 = null;
        goto L6
    }

    private final int parentHeight() {
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L5;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L9;
        return r1.getHeight();
    L9:
        return ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().heightPixels;
    L5:
        r1 = null;
        goto L6
    }

    private final void scheduleRightRevealAutoRetractIfNeeded() {
        if (this.rightRevealAutoRetractDelayMs > 0) goto L5;
        return;
    L5:
        if (this.dock != b.f26078c) goto L10;
        cancelRightRevealAutoRetract();
        postDelayed(this.rightRevealAutoRetractRunnable, this.rightRevealAutoRetractDelayMs);
        return;
    }

    private final void cancelRightRevealAutoRetract() {
        removeCallbacks(this.rightRevealAutoRetractRunnable);
    }

    private final void notifyDockStateChanged() {
        d.h.a.a<x> r0 = this.onDockStateChanged;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }
}
