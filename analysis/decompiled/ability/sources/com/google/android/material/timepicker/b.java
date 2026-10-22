package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* loaded from: classes3.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f2711a;

    public b(ClockFaceView clockFaceView) {
        this.f2711a = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f2711a;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.d.d) - clockFaceView.l;
        if (height != clockFaceView.b) {
            clockFaceView.b = height;
            clockFaceView.a();
            ClockHandView clockHandView = clockFaceView.d;
            clockHandView.l = clockFaceView.b;
            clockHandView.invalidate();
        }
        return true;
    }
}
