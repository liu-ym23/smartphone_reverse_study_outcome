package com.android.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class TransparentFrameLayout extends FrameLayout {
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r1) {
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r1) {
        return false;
    }

    public TransparentFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
