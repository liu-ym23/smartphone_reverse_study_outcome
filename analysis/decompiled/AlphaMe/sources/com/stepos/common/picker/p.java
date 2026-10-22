package com.stepos.common.picker;

import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class p implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WheelPicker f11390a;

    public p(WheelPicker wheelPicker) {
        this.f11390a = wheelPicker;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        WheelPicker wheelPicker = this.f11390a;
        wheelPicker.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        wheelPicker.addOnScrollListener(wheelPicker.f11367y);
        wheelPicker.b();
    }
}
