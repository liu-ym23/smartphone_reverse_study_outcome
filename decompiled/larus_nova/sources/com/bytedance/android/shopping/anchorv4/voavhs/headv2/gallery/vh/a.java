package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetector f169441a;

    public a(GestureDetector r100) {
        this.f169441a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        this.f169441a.onTouchEvent(r101);
        return true;
    }
}
