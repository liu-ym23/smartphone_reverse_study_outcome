package com.stepos.common.scrollview;

import Xa.e;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes3.dex */
public class StepOSNestedScrollView extends NestedScrollView {

    /* renamed from: a, reason: collision with root package name */
    public final e f3620a;
    public boolean b;

    public StepOSNestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.b = false;
        this.f3620a = new e(context, this, null, 1);
        setOverScrollMode(2);
    }

    @Override // androidx.core.widget.NestedScrollView
    public final void fling(int i) {
        super.fling(i);
        this.f3620a.f(0, i);
    }

    public e getSpringAnimationHelper() {
        return this.f3620a;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (!this.f3620a.n(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        ViewParent parent = getParent();
        if (parent != null && this.b) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    public void setBottomOverScrollEnable(boolean z10) {
        this.f3620a.l = z10;
    }

    public void setOverScrollEnable(boolean z10) {
        this.f3620a.f1547j = z10;
    }

    public void setShouldRequestDisallowInterceptTouchEventWhenOverScroll(boolean z10) {
        this.b = z10;
    }

    public void setTopOverScrollEnable(boolean z10) {
        this.f3620a.k = z10;
    }
}
