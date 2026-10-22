package com.obric.autoaction.view.legacy;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import com.obric.oui.layout.OUIConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.i.a;
import d.l.n;
import d.x;

/* JADX INFO: compiled from: DraggableFloatingLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DraggableFloatingLayout extends OUIConstraintLayout {
    private float dX;
    private float dY;
    private float downRawX;
    private float downRawY;
    private boolean isDragEnabled;
    private boolean isDragging;
    private boolean isSnappedRight;
    private boolean isSnapping;
    private FrameLayout.LayoutParams lastSnapLayoutParams;
    private final float margin;
    private m<? super Float, ? super Float, x> onSnapListener;
    private final int screenWidth;
    private final int touchSlop;

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

    public static final /* synthetic */ boolean access$isSnappedRight$p(DraggableFloatingLayout r0) {
        return r0.isSnappedRight;
    }

    public static final /* synthetic */ FrameLayout.LayoutParams access$makeSolidifyLayoutParams(DraggableFloatingLayout r0, boolean r1) {
        return r0.makeSolidifyLayoutParams(r1);
    }

    public DraggableFloatingLayout(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        super(r13, r4, r12, null, 8, null);
        this.isDragEnabled = true;
        this.margin = a.a(TypedValue.applyDimension(1, 20, Resources.getSystem().getDisplayMetrics()));
        this.touchSlop = ViewConfiguration.get(r13).getScaledTouchSlop();
        this.screenWidth = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels;
    }

    public final boolean isDragEnabled() {
        return this.isDragEnabled;
    }

    public final void setDragEnabled(boolean r1) {
        this.isDragEnabled = r1;
        if (r1 == true) goto L6;
        this.isDragging = false;
        return;
    }

    public final boolean isDragging() {
        return this.isDragging;
    }

    public final void setDragging(boolean r1) {
        this.isDragging = r1;
    }

    public final boolean isSnapping() {
        return this.isSnapping;
    }

    public final void setSnapping(boolean r1) {
        this.isSnapping = r1;
    }

    public final FrameLayout.LayoutParams getLastSnapLayoutParams() {
        return this.lastSnapLayoutParams;
    }

    public final void setLastSnapLayoutParams(FrameLayout.LayoutParams r1) {
        this.lastSnapLayoutParams = r1;
    }

    public final m<Float, Float, x> getOnSnapListener() {
        return this.onSnapListener;
    }

    public final void setOnSnapListener(m<? super Float, ? super Float, x> r3) {
        this.onSnapListener = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r7) {
        o.e(r7, "ev");
        if (this.isDragEnabled == false) goto L5;
        float r0 = r7.getRawX();
        float r1 = r7.getRawY();
        int r2 = r7.getAction();
        if (r2 != 0) goto L9;
        this.isDragging = false;
        this.downRawX = r0;
        this.downRawY = r1;
        this.dX = getTranslationX() - r0;
        this.dY = getTranslationY() - r1;
        animate().cancel();
        return false;
    L9:
        if (r2 != 1) goto L11;
    L21:
        this.isDragging = false;
    L23:
        return super.onInterceptTouchEvent(r7);
    L11:
        if (r2 == 2) goto L16;
        if (r2 == 3) goto L21;
    L16:
        if (this.isDragging == true) goto L23;
        if (((float) Math.hypot(r0 - this.downRawX, r1 - this.downRawY)) <= this.touchSlop) goto L23;
        this.isDragging = true;
        return true;
    L5:
        return super.onInterceptTouchEvent(r7);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r6) {
        o.e(r6, "event");
        if (this.isDragEnabled == false) goto L5;
        float r0 = r6.getRawX();
        float r1 = r6.getRawY();
        int r2 = r6.getAction();
        if (r2 == 0) goto L21;
        if (r2 == 1) goto L16;
        if (r2 != 2) goto L12;
        setTranslationX(r0 + this.dX);
        setTranslationY(r1 + this.dY);
        return true;
    L12:
        return super.onTouchEvent(r6);
    L16:
        if (this.isDragging == false) goto L18;
        snapToEdge();
    L19:
        this.isDragging = false;
        return true;
    L18:
        performClick();
        goto L19
    L21:
        this.isDragging = false;
        this.downRawX = r0;
        this.downRawY = r1;
        this.dX = getTranslationX() - r0;
        this.dY = getTranslationY() - r1;
        animate().cancel();
        return true;
    L5:
        return super.onTouchEvent(r6);
    }

    private final void snapToEdge() {
        boolean r0 = true;
        this.isSnapping = true;
        float r1 = (getLeft() + getTranslationX()) + (getWidth() / 2);
        int r2 = this.screenWidth;
        if (r1 > (r2 / 2)) goto L6;
        r0 = false;
    L6:
        this.isSnappedRight = r0;
        if (r0 == false) goto L9;
        float r3 = (r2 - getWidth()) - this.margin;
    L10:
        final float r4 = r3 - getLeft();
        ViewParent r5 = getParent();
        if (ZeusTransformUtils.instanceOf(r5, View.class) == false) goto L13;
        View r6 = (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin");
    L14:
        if (r6 == null) goto L16;
        int r7 = r6.getHeight();
    L17:
        final float r8 = n.a(n.b(getTop() + getTranslationY(), (r7 - getHeight()) - this.margin), this.margin) - getTop();
        animate().translationX(r4).translationY(r8).setDuration(300).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new OvershootInterpolator(1.0f), TimeInterpolator.class, "com.obric.aiagent.plugin")).setListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r4, r8), Animator.AnimatorListener.class, "com.obric.aiagent.plugin")).start();
        return;
    L16:
        r7 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().heightPixels;
        goto L17
    L13:
        r6 = null;
        goto L14
    L9:
        r3 = this.margin;
        goto L10
    }

    public final void cancelSnapAnimation() {
        animate().cancel();
        this.isSnapping = false;
    }

    private final FrameLayout.LayoutParams makeSolidifyLayoutParams(boolean r5) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, FrameLayout.LayoutParams.class) == false) goto L5;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L12;
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(r1);
        int r3 = (int) (getTop() + getTranslationY());
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        r2.topMargin = r3;
        r2.gravity = 48;
        if (r5 == false) goto L10;
        r2.gravity |= 8388613;
        r2.rightMargin = (int) this.margin;
        r2.leftMargin = 0;
    L11:
        return r2;
    L10:
        r2.gravity |= 8388611;
        r2.leftMargin = (int) this.margin;
        r2.rightMargin = 0;
        goto L11
    L12:
        return null;
    L5:
        r1 = null;
        goto L6
    }
}
