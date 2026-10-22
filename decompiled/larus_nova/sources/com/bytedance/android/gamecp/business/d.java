package com.bytedance.android.gamecp.business;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f52292a = null;

    static {
        f52292a = new d();
    }

    public d() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        r100.performClick();
        return false;
    }
}
