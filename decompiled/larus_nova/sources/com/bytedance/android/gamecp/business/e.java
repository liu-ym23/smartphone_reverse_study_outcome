package com.bytedance.android.gamecp.business;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f53157a = null;

    static {
        f53157a = new e();
    }

    public e() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        r100.performClick();
        return false;
    }
}
