package com.bytedance.android.livesdk.interactivity.barrage.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes9.dex */
public class InterceptConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f133927a;

    public InterceptConstraintLayout(Context r100) {
        super(r100);
        this.f133927a = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return this.f133927a;
    }

    public void setmIsIntercept(boolean r100) {
        this.f133927a = r100;
    }

    public InterceptConstraintLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f133927a = false;
    }

    public InterceptConstraintLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f133927a = false;
    }
}
