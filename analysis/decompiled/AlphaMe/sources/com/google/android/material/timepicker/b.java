package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.view.ViewTreeObserver;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f11162a;

    public b(ClockFaceView clockFaceView) {
        this.f11162a = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ClockFaceView clockFaceView = this.f11162a;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.f11136v.f11145d) - clockFaceView.f11129D;
        if (height != clockFaceView.f11167t) {
            clockFaceView.f11167t = height;
            clockFaceView.h();
            int i4 = clockFaceView.f11167t;
            ClockHandView clockHandView = clockFaceView.f11136v;
            clockHandView.f11153l = i4;
            clockHandView.invalidate();
        }
        return true;
    }
}
