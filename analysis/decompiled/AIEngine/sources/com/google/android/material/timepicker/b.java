package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f5382a;

    public b(ClockFaceView clockFaceView) {
        this.f5382a = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f5382a;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.f5348w.f5361n) - clockFaceView.E;
        if (height != clockFaceView.f5389u) {
            clockFaceView.f5389u = height;
            clockFaceView.m();
            ClockHandView clockHandView = clockFaceView.f5348w;
            clockHandView.f5369w = clockFaceView.f5389u;
            clockHandView.invalidate();
        }
        return true;
    }
}
