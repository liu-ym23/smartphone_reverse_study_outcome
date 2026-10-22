package com.bytedance.android.livesdk.chatroom.progressbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes7.dex */
public class ForceInterceptConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f107693a;

    public ForceInterceptConstraintLayout(Context r100) {
        super(r100);
        this.f107693a = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f107693a == false) goto L7;
        return true;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    public void setIntercept(boolean r100) {
        this.f107693a = r100;
    }

    public ForceInterceptConstraintLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f107693a = false;
    }

    public ForceInterceptConstraintLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f107693a = false;
    }
}
