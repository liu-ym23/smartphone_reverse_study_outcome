package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes8.dex */
public class NoTouchableFrameLayout extends FrameLayout {
    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        return false;
    }

    public NoTouchableFrameLayout(Context r100) {
        super(r100);
    }

    public NoTouchableFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public NoTouchableFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
