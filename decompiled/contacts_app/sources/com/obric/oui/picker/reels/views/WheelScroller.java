package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.OverScroller;
import com.android.contacts.common.list.DefaultContactListAdapter;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.obric.common.oui.R;
import com.obric.oui.common.style.OUISoundEffectHelper;
import com.obric.oui.haptic.VibratorSmt;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WheelScroller.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 42\u00020\u0001:\u00014B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020\bJ\u0012\u0010#\u001a\u00020\u001d2\b\b\u0002\u0010$\u001a\u00020\bH\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002J\u000e\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003J\u001a\u0010*\u001a\u00020\u001d2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010 \u001a\u00020!H\u0002J\u0006\u0010+\u001a\u00020\u001dJ\u0016\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\nJ8\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00065"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelScroller;", "Landroid/widget/OverScroller;", "context", "Landroid/content/Context;", "mWheelView", "Lcom/obric/oui/picker/reels/views/WheelView;", "(Landroid/content/Context;Lcom/obric/oui/picker/reels/views/WheelView;)V", "currentIndex", "", "isDragging", "", "isScrolling", "itemIndex", "getItemIndex", "()I", "itemOffset", "getItemOffset", "lastTouchY", "", "mScrollOffset", "mVelocityTracker", "Landroid/view/VelocityTracker;", "onWheelChangedListener", "Lcom/obric/oui/picker/reels/views/OnWheelChangedListener;", "getOnWheelChangedListener", "()Lcom/obric/oui/picker/reels/views/OnWheelChangedListener;", "setOnWheelChangedListener", "(Lcom/obric/oui/picker/reels/views/OnWheelChangedListener;)V", WheelScroller.WHEEL_SCROLL_SCENE_COMPUTE_SCROLL, "", "doScroll", RealFpsTracer.SCROLL_DISTANCE, "scene", "", "getCurrentIndex", "justify", "duration", "notifyWheelChangedListener", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onViewAttachedToWindow", "performVibrateEffect", WheelScroller.WHEEL_SCROLL_SCENE_RESET, WheelScroller.WHEEL_SCROLL_SCENE_SET_CURRENT_INDEX, "index", "animated", "startScrollInternal", "startX", "startY", "dx", "dy", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WheelScroller extends OverScroller {
    public static final Companion Companion = null;
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
    private OnWheelChangedListener onWheelChangedListener;

    /* JADX INFO: compiled from: WheelScroller.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelScroller$Companion;", "", "()V", "JUSTIFY_DURATION", "", "OVER_OFFSET_PROP", "TAG", "", "WHEEL_SCROLL_SCENE_COMPUTE_SCROLL", "WHEEL_SCROLL_SCENE_RESET", "WHEEL_SCROLL_SCENE_SET_CURRENT_INDEX", "WHEEL_SCROLL_SCENE_TOUCH_EVENT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WheelScroller(Context r2, WheelView r3) {
        Intrinsics.checkNotNullParameter(r3, "mWheelView");
        super(r2, new LinearInterpolator());
        this.mWheelView = r3;
        ScrollerExt.INSTANCE.init();
        this.currentIndex = -1;
    }

    public final OnWheelChangedListener getOnWheelChangedListener() {
        return this.onWheelChangedListener;
    }

    public final void setOnWheelChangedListener(OnWheelChangedListener r1) {
        this.onWheelChangedListener = r1;
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

    private final void notifyWheelChangedListener(String r4) {
        int r0 = this.currentIndex;
        int r1 = getCurrentIndex();
        if (r0 == r1) goto L9;
        this.currentIndex = r1;
        performVibrateEffect(this.mWheelView.getContext(), r4);
        OnWheelChangedListener r3 = this.onWheelChangedListener;
        if (r3 == null) goto L10;
        r3.onChanged(r0, r1);
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
        OnWheelChangedListener r11 = this.onWheelChangedListener;
        if (r11 == null) goto L16;
        r11.onStopped(getCurrentIndex());
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
        OnWheelChangedListener r12 = this.onWheelChangedListener;
        if (r12 == null) goto L18;
        r12.onStopped(getCurrentIndex());
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
        OnWheelChangedListener r2 = this.onWheelChangedListener;
        if (r2 == null) goto L9;
        r2.onStopped(this.currentIndex);
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
        L.d(TAG, "startScrollInternal, startX: " + r3 + ", startY: " + r4 + ", dx: " + r5 + ", dy: " + r6 + ", duration: " + r7 + ", scene: " + r8);
        startScroll(r3, r4, r5, r6, r7);
    }

    public final boolean onTouchEvent(MotionEvent r28) {
        Intrinsics.checkNotNullParameter(r28, "event");
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
        ScrollerExt.INSTANCE.snapFlingVertically(this, this.mWheelView.getItemHeightPx(), this.mScrollOffset, ((int) (-r9)) / 2, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
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
        ScrollerExt.INSTANCE.snapFlingVertically(this, this.mWheelView.getItemHeightPx(), this.mScrollOffset, ((int) (-r9)) / 2, 0, r17, r18);
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

    private final void performVibrateEffect(Context r3, String r4) {
        L.d(TAG, "performVibrateEffect, scene: [" + r4 + DefaultContactListAdapter.SNIPPET_END_MATCH);
        if (Intrinsics.areEqual(r4, WHEEL_SCROLL_SCENE_COMPUTE_SCROLL) == false) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L9;
        VibratorSmt.INSTANCE.performHapticFeedbackAOSP(this.mWheelView, 26);
        OUISoundEffectHelper.INSTANCE.play(r3, R.raw.reel_picker);
        return;
    L9:
        return;
    L5:
        r5 = Intrinsics.areEqual(r4, WHEEL_SCROLL_SCENE_TOUCH_EVENT);
        goto L6
    }

    public final void onViewAttachedToWindow(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        OUISoundEffectHelper.INSTANCE.load(r4, new int[]{R.raw.reel_picker});
    }
}
