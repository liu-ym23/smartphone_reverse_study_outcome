package com.bytedance.android.livesdk.interactivity.interactive;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes9.dex */
public class BannerFrameLayout extends FrameLayout {
    public BannerFrameLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        requestDisallowInterceptTouchEvent(true);
        super.dispatchTouchEvent(r100);
        return true;
    }

    public BannerFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public BannerFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
