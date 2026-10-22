package com.bytedance.android.livesdk.interactivity.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes9.dex */
public class InterceptLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f136306a;

    public InterceptLinearLayout(Context r100) {
        super(r100);
        this.f136306a = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return this.f136306a;
    }

    public void setIsIntercept(boolean r100) {
        this.f136306a = r100;
    }

    public InterceptLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f136306a = false;
    }

    public InterceptLinearLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f136306a = false;
    }
}
