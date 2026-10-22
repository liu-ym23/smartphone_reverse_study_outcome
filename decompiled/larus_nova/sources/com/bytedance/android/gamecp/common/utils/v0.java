package com.bytedance.android.gamecp.common.utils;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes44.dex */
public final class v0 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetector f57323a;

    public v0(GestureDetector r100) {
        this.f57323a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if ((r100 instanceof RecyclerView) == true) goto L7;
        return false;
    L7:
        return this.f57323a.onTouchEvent(r101);
    }
}
