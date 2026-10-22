package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class OrientationAwareRecyclerView extends RecyclerView {
    private float initialX;
    private float initialY;
    private float lastX;
    private float lastY;
    private int orientation;
    private boolean scrolling;
    private int touchSlop;

    public OrientationAwareRecyclerView(@NonNull Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ boolean access$002(OrientationAwareRecyclerView r10, boolean r11) {
        r10.scrolling = r11;
        return r11;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        if (r10 == null) goto L31;
        if (this.orientation != 0) goto L31;
        if (this.touchSlop >= 0) goto L8;
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    L8:
        int r11 = r10.getActionMasked();
        if (r11 != 0) goto L11;
        this.initialX = r10.getRawX();
        this.initialY = r10.getRawY();
        if (getParent() == null) goto L31;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L31
    L11:
        if (r11 != 2) goto L31;
        float r12 = Math.abs(r10.getRawX() - this.initialX);
        float r13 = Math.abs(r10.getRawY() - this.initialY);
        if (r13 <= r12) goto L21;
        if (r13 <= this.touchSlop) goto L21;
        if (getParent() == null) goto L31;
        getParent().requestDisallowInterceptTouchEvent(false);
    L21:
        if (r12 <= (r13 * 1.5f)) goto L31;
        if (r12 <= this.touchSlop) goto L31;
        if (getParent() == null) goto L31;
        getParent().requestDisallowInterceptTouchEvent(true);
    L31:
        return super.dispatchTouchEvent(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (r11 != 0) goto L5;
        this.lastX = r10.getX();
        this.lastY = r10.getY();
        if (this.scrolling == false) goto L22;
        MotionEvent r12 = MotionEvent.obtain(r10);
        r12.setAction(1);
        return super.onInterceptTouchEvent(r12);
    L22:
        return super.onInterceptTouchEvent(r10);
    L5:
        if (r11 != 2) goto L22;
        float r13 = r10.getX();
        float r14 = r10.getY();
        float r15 = Math.abs(r13 - this.lastX);
        float r16 = Math.abs(r14 - this.lastY);
        if (this.orientation != 0) goto L13;
        if (r15 > (r16 * 1.5f)) goto L22;
        return false;
    L13:
        if (r16 > r15) goto L22;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(@Nullable RecyclerView.LayoutManager r10) {
        super.setLayoutManager(r10);
        if ((r10 instanceof LinearLayoutManager) == false) goto L6;
        this.orientation = ((LinearLayoutManager) r10).getOrientation();
        return;
    }

    public OrientationAwareRecyclerView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public OrientationAwareRecyclerView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.lastX = 0.0f;
        this.lastY = 0.0f;
        this.orientation = 1;
        this.scrolling = false;
        this.initialX = 0.0f;
        this.initialY = 0.0f;
        this.touchSlop = -1;
        addOnScrollListener(new AnonymousClass1(this));
    }
}
