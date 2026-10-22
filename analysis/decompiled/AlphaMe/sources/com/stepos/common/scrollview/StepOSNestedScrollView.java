package com.stepos.common.scrollview;

import N3.d;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes.dex */
public class StepOSNestedScrollView extends NestedScrollView {

    /* renamed from: F, reason: collision with root package name */
    public final d f11431F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f11432G;

    public StepOSNestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f11432G = false;
        this.f11431F = new d(context, this, null, 1);
        setOverScrollMode(2);
    }

    @Override // androidx.core.widget.NestedScrollView
    public final void f(int i4) {
        super.f(i4);
        this.f11431F.f(0, i4);
    }

    public d getSpringAnimationHelper() {
        return this.f11431F;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (!this.f11431F.n(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        ViewParent parent = getParent();
        if (parent != null && this.f11432G) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    public void setBottomOverScrollEnable(boolean z4) {
        this.f11431F.f1508l = z4;
    }

    public void setOverScrollEnable(boolean z4) {
        this.f11431F.f1506j = z4;
    }

    public void setShouldRequestDisallowInterceptTouchEventWhenOverScroll(boolean z4) {
        this.f11432G = z4;
    }

    public void setTopOverScrollEnable(boolean z4) {
        this.f11431F.f1507k = z4;
    }
}
