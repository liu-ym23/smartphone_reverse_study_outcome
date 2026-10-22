package com.bytedance.android.live.browser.webview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes45.dex */
public class ForceInterceptConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f64418a;

    public ForceInterceptConstraintLayout(Context r100) {
        super(r100);
        this.f64418a = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f64418a == false) goto L9;
        if (r100.getAction() == 0) goto L9;
        return true;
    L9:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100.getAction() != 1) goto L5;
    L6:
        setForceInterceptTouchEvent(false);
    L8:
        return super.onTouchEvent(r100);
    L5:
        if (r100.getAction() != 3) goto L8;
        goto L6
    }

    public void setForceInterceptTouchEvent(boolean r100) {
        this.f64418a = r100;
    }

    public ForceInterceptConstraintLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f64418a = false;
    }

    public ForceInterceptConstraintLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f64418a = false;
    }
}
