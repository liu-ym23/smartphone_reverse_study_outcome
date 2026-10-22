package com.bytedance.android.live.browser.webview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes45.dex */
public class PullDownCloseIndicatorContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ForceInterceptConstraintLayout f64419a;

    public PullDownCloseIndicatorContainer(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (this.f64419a != null) goto L8;
        if ((getParent() instanceof ForceInterceptConstraintLayout) == false) goto L8;
        this.f64419a = (ForceInterceptConstraintLayout) getParent();
    L8:
        if (r101 == 0) goto L20;
        if (r101 != 1) goto L11;
    L16:
        ForceInterceptConstraintLayout r102 = this.f64419a;
        if (r102 == null) goto L19;
        r102.setForceInterceptTouchEvent(false);
    L19:
        return true;
    L11:
        if (r101 == 2) goto L20;
        if (r101 == 3) goto L16;
        return super.onTouchEvent(r100);
    L20:
        ForceInterceptConstraintLayout r103 = this.f64419a;
        if (r103 == null) goto L23;
        r103.setForceInterceptTouchEvent(true);
    L23:
        return true;
    }

    public PullDownCloseIndicatorContainer(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public PullDownCloseIndicatorContainer(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
