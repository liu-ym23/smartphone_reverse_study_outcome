package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.OverScroller;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: WheelScroller.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class WheelScroller extends OverScroller {
    public static final a Companion = null;
    public static final int JUSTIFY_DURATION = 200;
    public static final int OVER_OFFSET_PROP = 0;
    private static final String TAG = "WheelScroller";
    private static final String WHEEL_SCROLL_SCENE_COMPUTE_SCROLL = "computeScroll";
    private static final String WHEEL_SCROLL_SCENE_RESET = "reset";
    private static final String WHEEL_SCROLL_SCENE_SET_CURRENT_INDEX = "setCurrentIndex";
    private static final String WHEEL_SCROLL_SCENE_TOUCH_EVENT = "touchEvent";
    private int currentIndex;
    private boolean isDragging;
    private boolean isScrolling;
    private float lastTouchY;
    private int mScrollOffset;
    private VelocityTracker mVelocityTracker;
    private final WheelView mWheelView;
    private com.obric.oui.picker.reels.views.a onWheelChangedListener;

    /* JADX INFO: compiled from: WheelScroller.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public WheelScroller(Context r4, WheelView r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "mWheelView");
        super(r6, (Interpolator) ZeusTransformUtils.preCheckCast(new LinearInterpolator(), Interpolator.class, "com.obric.aiagent.plugin"));
        this.mWheelView = r5;
        b.f35960a.a();
        this.currentIndex = -1;
    }

    public final com.obric.oui.picker.reels.views.a getOnWheelChangedListener() {
        return this.onWheelChangedListener;
    }

    public final void setOnWheelChangedListener(com.obric.oui.picker.reels.views.a r3) {
        this.onWheelChangedListener = (com.obric.oui.picker.reels.views.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.picker.reels.views.a.class, "com.obric.aiagent.plugin");
    }

    public final void computeScroll() {
        if (this.isScrolling == false) goto L9;
        this.isScrolling = computeScrollOffset();
        doScroll(getCurrY() - this.mScrollOffset, WHEEL_SCROLL_SCENE_COMPUTE_SCROLL);
        if (this.isScrolling == false) goto L7;
        this.mWheelView.postInvalidate();
        return;
    L7:
        justify$default(this, 0, 1, null);
        return;
    }

    private final void doScroll(int r4, String r5) {
        this.mScrollOffset += r4;
        if (this.mWheelView.isCyclic() == true) goto L10;
        int r6 = (this.mWheelView.getItemSize() - 1) * this.mWheelView.getItemHeightPx();
        int r0 = this.mWheelView.getItemHeightPx() * 0;
        int r1 = this.mScrollOffset;
        int r2 = -r0;
        if (r1 >= r2) goto L7;
        this.mScrollOffset = r2;
        goto L10
    L7:
        int r7 = r6 + r0;
        if (r1 <= r7) goto L10;
        this.mScrollOffset = r7;
    L10:
        notifyWheelChangedListener(r5);
    }

    private final void notifyWheelChangedListener(String r6) {
        int r0 = this.currentIndex;
        int r1 = getCurrentIndex();
        if (r0 == r1) goto L9;
        this.currentIndex = r1;
        performVibrateEffect((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mWheelView.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6);
        com.obric.oui.picker.reels.views.a r5 = this.onWheelChangedListener;
        if (r5 == null) goto L10;
        r5.a(r0, r1);
        return;
    L10:
        return;
    }

    public final int getCurrentIndex() {
        int r0 = this.mWheelView.getItemHeightPx();
        int r1 = this.mWheelView.getItemSize();
        if (r1 != 0) goto L6;
        return -1;
    L6:
        int r2 = this.mScrollOffset;
        if (r2 >= 0) goto L9;
        int r3 = (r2 - (r0 / 2)) / r0;
    L10:
        int r4 = r3 % r1;
        if (this.mWheelView.isCyclic() == true) goto L14;
        if (r3 < r1) goto L14;
        r4 = r1 - 1;
    L14:
        if (r4 < 0) goto L16;
        return r4;
    L16:
        return r4 + r1;
    L9:
        r3 = (r2 + (r0 / 2)) / r0;
        goto L10
    }

    public final void setCurrentIndex(int r8, boolean r9) {
        int r10 = r8 * this.mWheelView.getItemHeightPx();
        int r2 = this.mScrollOffset;
        int r4 = r10 - r2;
        if (r4 != 0) goto L9;
        com.obric.oui.picker.reels.views.a r11 = this.onWheelChangedListener;
        if (r11 == null) goto L16;
        r11.a(getCurrentIndex());
        return;
    L16:
        return;
    L9:
        if (r9 == false) goto L11;
        this.isScrolling = true;
        startScrollInternal(0, r2, 0, r4, 200, WHEEL_SCROLL_SCENE_SET_CURRENT_INDEX);
        this.mWheelView.invalidate();
        return;
    L11:
        doScroll(r4, WHEEL_SCROLL_SCENE_SET_CURRENT_INDEX);
        this.mWheelView.invalidate();
        com.obric.oui.picker.reels.views.a r12 = this.onWheelChangedListener;
        if (r12 == null) goto L18;
        r12.a(getCurrentIndex());
        return;
    }

    public final int getItemIndex() {
        if (this.mWheelView.getItemHeightPx() != 0) goto L6;
        return 0;
    L6:
        return this.mScrollOffset / this.mWheelView.getItemHeightPx();
    }

    public final int getItemOffset() {
        if (this.mWheelView.getItemHeightPx() != 0) goto L6;
        return 0;
    L6:
        return this.mScrollOffset % this.mWheelView.getItemHeightPx();
    }

    public final void reset() {
        this.isScrolling = false;
        this.mScrollOffset = 0;
        this.currentIndex = -1;
        notifyWheelChangedListener(WHEEL_SCROLL_SCENE_RESET);
        forceFinished(true);
    }

    static /* synthetic */ void justify$default(WheelScroller r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 200;
    L5:
        r0.justify(r1);
    }

    private final void justify(int r12) {
        int r0 = this.mWheelView.getItemHeightPx();
        int r1 = this.mScrollOffset % r0;
        if (r1 != 0) goto L9;
        com.obric.oui.picker.reels.views.a r2 = this.onWheelChangedListener;
        if (r2 == null) goto L9;
        r2.a(this.currentIndex);
    L9:
        if (r1 <= 0) goto L14;
        if (r1 >= (r0 / 2)) goto L14;
        this.isScrolling = true;
        startScrollInternal(0, this.mScrollOffset, 0, -r1, r12, "justify");
        this.mWheelView.invalidate();
        return;
    L14:
        if (r1 < (r0 / 2)) goto L16;
        this.isScrolling = true;
        startScrollInternal(0, this.mScrollOffset, 0, r0 - r1, r12, "justify");
        this.mWheelView.invalidate();
        return;
    L16:
        if (r1 < 0) goto L18;
    L20:
        int r3 = -r0;
        if (r1 > (r3 / 2)) goto L27;
        this.isScrolling = true;
        startScrollInternal(0, this.mScrollOffset, 0, r3 - r1, r12, "justify");
        this.mWheelView.invalidate();
        return;
    L27:
        return;
    L18:
        if (r1 <= ((-r0) / 2)) goto L20;
        this.isScrolling = true;
        startScrollInternal(0, this.mScrollOffset, 0, -r1, r12, "justify");
        this.mWheelView.invalidate();
    }

    private final void startScrollInternal(int r3, int r4, int r5, int r6, int r7, String r8) {
        com.obric.oui.d.a.b.b(TAG, "startScrollInternal, startX: " + r3 + ", startY: " + r4 + ", dx: " + r5 + ", dy: " + r6 + ", duration: " + r7 + ", scene: " + r8);
        startScroll(r3, r4, r5, r6, r7);
    }

    public final boolean onTouchEvent(MotionEvent r28) {
        o.e(r28, "event");
        if (this.mVelocityTracker != null) goto L5;
        this.mVelocityTracker = VelocityTracker.obtain();
    L5:
        VelocityTracker r1 = this.mVelocityTracker;
        if (r1 == null) goto L9;
        r1.addMovement(r28);
    L9:
        int r2 = r28.getAction();
        if (r2 != 0) goto L12;
        ViewParent r3 = this.mWheelView.getParent();
        if (r3 == null) goto L65;
        r3.requestDisallowInterceptTouchEvent(true);
    L65:
        this.lastTouchY = r28.getY();
        forceFinished(true);
        this.isDragging = false;
        this.isScrolling = false;
    L66:
        return true;
    L12:
        if (r2 == 1) goto L32;
        if (r2 != 2) goto L15;
        float r0 = r28.getY();
        int r4 = (int) (r0 - this.lastTouchY);
        if (r4 == 0) goto L31;
        this.isDragging = true;
        doScroll(-r4, WHEEL_SCROLL_SCENE_TOUCH_EVENT);
        this.mWheelView.invalidate();
    L31:
        this.lastTouchY = r0;
        goto L66
    L15:
        if (r2 != 3) goto L66;
        if (this.isDragging == false) goto L20;
        justify$default(this, 0, 1, null);
    L20:
        VelocityTracker r5 = this.mVelocityTracker;
        if (r5 == null) goto L24;
        r5.recycle();
    L24:
        this.mVelocityTracker = null;
        this.isDragging = false;
        ViewParent r6 = this.mWheelView.getParent();
        if (r6 == null) goto L66;
        r6.requestDisallowInterceptTouchEvent(false);
        goto L66
    L32:
        VelocityTracker r7 = this.mVelocityTracker;
        if (r7 == null) goto L36;
        r7.computeCurrentVelocity(1000);
    L36:
        VelocityTracker r8 = this.mVelocityTracker;
        if (r8 != null) goto L39;
        float r9 = 0.0f;
    L41:
        if (Math.abs(r9) <= 0.0f) goto L48;
        int r17 = (this.mWheelView.getItemSize() - 1) * this.mWheelView.getItemHeightPx();
        int r18 = this.mWheelView.getItemHeightPx() * 0;
        this.isScrolling = true;
        if (this.mWheelView.isCyclic() == false) goto L45;
        b.f35960a.a((OverScroller) ZeusTransformUtils.preCheckCast(this, OverScroller.class, "com.obric.aiagent.plugin"), this.mWheelView.getItemHeightPx(), this.mScrollOffset, ((int) (-r9)) / 2, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    L46:
        this.mWheelView.invalidate();
    L53:
        VelocityTracker r10 = this.mVelocityTracker;
        if (r10 == null) goto L57;
        r10.recycle();
    L57:
        this.mVelocityTracker = null;
        ViewParent r11 = this.mWheelView.getParent();
        if (r11 == null) goto L66;
        r11.requestDisallowInterceptTouchEvent(false);
        goto L66
    L45:
        b.f35960a.a((OverScroller) ZeusTransformUtils.preCheckCast(this, OverScroller.class, "com.obric.aiagent.plugin"), this.mWheelView.getItemHeightPx(), this.mScrollOffset, ((int) (-r9)) / 2, 0, r17, r18);
        goto L46
    L48:
        if (this.isDragging == true) goto L52;
        float r12 = r28.getY() - (this.mWheelView.getHeight() / 2.0f);
        if (Math.abs(r12) <= 1.0f) goto L53;
        this.isScrolling = true;
        startScrollInternal(0, this.mScrollOffset, 0, (int) r12, 200, "ACTION_UP");
        this.mWheelView.invalidate();
        goto L53
    L52:
        justify$default(this, 0, 1, null);
        goto L53
    L39:
        r9 = r8.getYVelocity();
        goto L41
    }

    private final void performVibrateEffect(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        com.obric.oui.d.a.b.b(TAG, "performVibrateEffect, scene: [" + r5 + ']');
        if (o.a(r5, WHEEL_SCROLL_SCENE_COMPUTE_SCROLL) == false) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L11;
        com.obric.oui.b.a.f34003a.a((View) ZeusTransformUtils.preCheckCast(this.mWheelView, View.class, "com.obric.aiagent.plugin"), 26);
        if (Build.VERSION.SDK_INT < 24) goto L12;
        com.obric.oui.common.style.h.f34529a.a(r6, ZeusTransformUtils.mapRes(R.raw.reel_picker, "raw", "reel_picker"));
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r7 = o.a(r5, WHEEL_SCROLL_SCENE_TOUCH_EVENT);
        goto L6
    }

    public final void onViewAttachedToWindow(Context r6) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        if (Build.VERSION.SDK_INT < 24) goto L6;
        com.obric.oui.common.style.h.f34529a.a(r5, new int[]{ZeusTransformUtils.mapRes(R.raw.reel_picker, "raw", "reel_picker")});
        return;
    }
}
