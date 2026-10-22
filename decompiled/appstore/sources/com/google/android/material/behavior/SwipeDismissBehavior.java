package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.b;
import com.obric.capabilitykit.common.UiType;

/* JADX INFO: loaded from: classes3.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    float alphaEndSwipeDistance;
    float alphaStartSwipeDistance;
    private final b.c dragCallback;
    float dragDismissThreshold;
    private boolean interceptingEvents;
    OnDismissListener listener;
    private float sensitivity;
    private boolean sensitivitySet;
    int swipeDirection;
    b viewDragHelper;

    public interface OnDismissListener {
        void onDismiss(View r10);

        void onDragStateChanged(int r10);
    }

    public class SettleRunnable implements Runnable {
        private final boolean dismiss;
        final /* synthetic */ SwipeDismissBehavior this$0;
        private final View view;

        public SettleRunnable(SwipeDismissBehavior r10, View r11, boolean r12) {
            this.this$0 = r10;
            this.view = r11;
            this.dismiss = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            b r10 = this.this$0.viewDragHelper;
            if (r10 == null) goto L8;
            if (r10.n(true) == false) goto L8;
            ViewCompat.h0(this.view, this);
            return;
        L8:
            if (this.dismiss == false) goto L14;
            OnDismissListener r11 = this.this$0.listener;
            if (r11 == null) goto L15;
            r11.onDismiss(this.view);
            return;
        L15:
            return;
        }
    }

    public SwipeDismissBehavior() {
        this.sensitivity = DEFAULT_ALPHA_START_DISTANCE;
        this.swipeDirection = 2;
        this.dragDismissThreshold = 0.5f;
        this.alphaStartSwipeDistance = DEFAULT_ALPHA_START_DISTANCE;
        this.alphaEndSwipeDistance = 0.5f;
        this.dragCallback = new AnonymousClass1(this);
    }

    public static float clamp(float r10, float r11, float r12) {
        return Math.min(Math.max(r10, r11), r12);
    }

    private void ensureViewDragHelper(ViewGroup r10) {
        if (this.viewDragHelper == null) goto L5;
        return;
    L5:
        if (this.sensitivitySet == false) goto L7;
        b r11 = b.o(r10, this.sensitivity, this.dragCallback);
    L8:
        this.viewDragHelper = r11;
        return;
    L7:
        r11 = b.p(r10, this.dragCallback);
        goto L8
    }

    public static float fraction(float r10, float r11, float r12) {
        return (r12 - r10) / (r11 - r10);
    }

    private void updateAccessibilityActions(View r10) {
        ViewCompat.j0(r10, UiType.FLAG_APP_CHOOSER_CARD);
        if (canSwipeDismissView(r10) == false) goto L6;
        ViewCompat.l0(r10, AccessibilityNodeInfoCompat.a.f2758y, null, new AnonymousClass2(this));
        return;
    }

    public boolean canSwipeDismissView(@NonNull View r10) {
        return true;
    }

    public int getDragState() {
        b r10 = this.viewDragHelper;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.C();
    }

    @Nullable
    @VisibleForTesting
    public OnDismissListener getListener() {
        return this.listener;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull MotionEvent r12) {
        boolean r13 = this.interceptingEvents;
        int r14 = r12.getActionMasked();
        if (r14 != 0) goto L5;
        r13 = r10.isPointInChildBounds(r11, (int) r12.getX(), (int) r12.getY());
        this.interceptingEvents = r13;
    L11:
        if (r13 == false) goto L14;
        ensureViewDragHelper(r10);
        return this.viewDragHelper.P(r12);
    L14:
        return false;
    L5:
        if (r14 != 1) goto L7;
    L9:
        this.interceptingEvents = false;
        goto L11
    L7:
        if (r14 == 3) goto L9;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout r10, @NonNull V r11, int r12) {
        boolean r13 = super.onLayoutChild(r10, r11, r12);
        if (ViewCompat.y(r11) != 0) goto L5;
        ViewCompat.A0(r11, 1);
        updateAccessibilityActions(r11);
    L5:
        return r13;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r10, V r11, MotionEvent r12) {
        b r13 = this.viewDragHelper;
        if (r13 == null) goto L6;
        r13.processTouchEvent(r12);
        return true;
    L6:
        return false;
    }

    public void setDragDismissDistance(float r10) {
        this.dragDismissThreshold = clamp(DEFAULT_ALPHA_START_DISTANCE, r10, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float r10) {
        this.alphaEndSwipeDistance = clamp(DEFAULT_ALPHA_START_DISTANCE, r10, 1.0f);
    }

    public void setListener(@Nullable OnDismissListener r10) {
        this.listener = r10;
    }

    public void setSensitivity(float r10) {
        this.sensitivity = r10;
        this.sensitivitySet = true;
    }

    public void setStartAlphaSwipeDistance(float r10) {
        this.alphaStartSwipeDistance = clamp(DEFAULT_ALPHA_START_DISTANCE, r10, 1.0f);
    }

    public void setSwipeDirection(int r10) {
        this.swipeDirection = r10;
    }

    public static int clamp(int r10, int r11, int r12) {
        return Math.min(Math.max(r10, r11), r12);
    }
}
