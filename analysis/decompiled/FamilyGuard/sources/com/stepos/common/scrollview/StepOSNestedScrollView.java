package com.stepos.common.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.core.widget.NestedScrollView;
import e5.c;

/* loaded from: classes.dex */
public class StepOSNestedScrollView extends NestedScrollView {

    /* renamed from: G, reason: collision with root package name */
    private final c f13765G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f13766H;

    public interface a extends e5.a {
    }

    public StepOSNestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a0(a aVar) {
        this.f13765G.q(aVar);
    }

    public boolean b0() {
        return this.f13765G.Q();
    }

    public c getSpringAnimationHelper() {
        return this.f13765G;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (!this.f13765G.Y(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        ViewParent parent = getParent();
        if (parent != null && this.f13766H) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    public void setBottomOverScrollEnable(boolean z5) {
        this.f13765G.b0(z5);
    }

    public void setOverScrollEnable(boolean z5) {
        this.f13765G.g0(z5);
    }

    public void setShouldRequestDisallowInterceptTouchEventWhenOverScroll(boolean z5) {
        this.f13766H = z5;
    }

    public void setTopOverScrollEnable(boolean z5) {
        this.f13765G.j0(z5);
    }

    @Override // androidx.core.widget.NestedScrollView
    public void v(int i5) {
        super.v(i5);
        this.f13765G.C(0, i5);
    }

    public StepOSNestedScrollView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f13766H = false;
        this.f13765G = new c(context, this, null, 1);
        setOverScrollMode(2);
    }
}
