package com.bytedance.android.livesdk.chatroom.replay.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingParent2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ReplayGestureDetectLayout extends FrameLayout implements NestedScrollingParent2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<View.OnTouchListener> f110289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<View.OnTouchListener> f110290b;

    public interface a {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
    }

    public void setSlideAction(a r100) {
    }

    public ReplayGestureDetectLayout(Context r100) {
        super(r100);
        this.f110289a = new ArrayList();
        this.f110290b = new ArrayList();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        int r101 = this.f110289a.size() - 1;
    L3:
        if (r101 < 0) goto L6;
        ((View.OnTouchListener) ListProtector.get(this.f110289a, r101)).onTouch(this, r100);
        r101 = r101 - 1;
        goto L3
    L6:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = this.f110290b.size() - 1;
    L3:
        if (r101 < 0) goto L5;
        ((View.OnTouchListener) ListProtector.get(this.f110290b, r101)).onTouch(this, r100);
        r101 = r101 - 1;
        goto L3
    L5:
        return true;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
    }

    public ReplayGestureDetectLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f110289a = new ArrayList();
        this.f110290b = new ArrayList();
        ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public ReplayGestureDetectLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f110289a = new ArrayList();
        this.f110290b = new ArrayList();
        ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        return super.onNestedPreFling(r100, r101, r102);
    L4:
        toString();
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        return super.onNestedFling(r100, r101, r102, r103);
    L4:
        toString();
        return false;
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        super.setPadding(r100, r101, r102, r103);
        new Exception();
    }

    @Override // android.view.View
    public final void setPaddingRelative(int r100, int r101, int r102, int r103) {
        super.setPaddingRelative(r100, r101, r102, r103);
        new Exception();
    }
}
