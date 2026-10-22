package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f1419a;

    public b(ClockFaceView clockFaceView) {
        this.f1419a = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f1419a;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.f1401w.d) - clockFaceView.E;
        if (height != clockFaceView.f1423u) {
            clockFaceView.f1423u = height;
            clockFaceView.m();
            ClockHandView clockHandView = clockFaceView.f1401w;
            clockHandView.f1414m = clockFaceView.f1423u;
            clockHandView.invalidate();
        }
        return true;
    }
}
