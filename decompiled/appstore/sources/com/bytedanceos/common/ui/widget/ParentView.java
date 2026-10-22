package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes2.dex */
public class ParentView extends RelativeLayout {
    private long lastClickTime;
    private GestureDetector mGestureDetector;
    private boolean mIsBusy;

    public static class XScrollDetector extends GestureDetector.SimpleOnGestureListener {
        public XScrollDetector() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent r10, MotionEvent r11, float r12, float r13) {
            if (Math.abs(r13) >= Math.abs(r12)) goto L6;
            return true;
        L6:
            return false;
        }
    }

    public ParentView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mIsBusy = false;
        this.lastClickTime = -300;
        init();
    }

    private void init() {
        this.mGestureDetector = new GestureDetector(new XScrollDetector());
    }

    public void beBusy(boolean r10) {
        this.mIsBusy = r10;
    }

    public boolean filterTouchEvent(MotionEvent r10) {
        if ((System.currentTimeMillis() - this.lastClickTime) <= 300) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        this.lastClickTime = System.currentTimeMillis();
    L8:
        if (r11 == false) goto L10;
        return false;
    L10:
        if (this.mGestureDetector.onTouchEvent(r10) == true) goto L12;
        return false;
    L12:
        return true;
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.mIsBusy == false) goto L6;
        return true;
    L6:
        if (r10.getAction() != 0) goto L11;
        if (filterTouchEvent(r10) == false) goto L11;
        return true;
    L11:
        return super.onInterceptTouchEvent(r10);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.mIsBusy == false) goto L6;
        return true;
    L6:
        if (r10.getAction() != 0) goto L11;
        if (filterTouchEvent(r10) == false) goto L11;
        return true;
    L11:
        return super.onTouchEvent(r10);
    }

    public ParentView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mIsBusy = false;
        this.lastClickTime = -300;
        init();
    }

    public ParentView(Context r10) {
        super(r10);
        this.mIsBusy = false;
        this.lastClickTime = -300;
        init();
    }
}
