package com.bytedance.android.shopping.feed.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f176011a;

    public c(FrameLayout r100) {
        this.f176011a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101.getAction() != 0) goto L6;
        this.f176011a.removeAllViews();
        this.f176011a.setVisibility(8);
    L6:
        dm.a.a("lgz_log_debug").a("gestureContainer touch");
        return false;
    }
}
