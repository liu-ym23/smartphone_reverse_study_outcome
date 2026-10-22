package com.stepos.common.picker;

import android.view.ViewTreeObserver;

/* loaded from: classes3.dex */
public final class p implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WheelPicker f3597a;

    public p(WheelPicker wheelPicker) {
        this.f3597a = wheelPicker;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        WheelPicker wheelPicker = this.f3597a;
        wheelPicker.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        wheelPicker.addOnScrollListener(wheelPicker.y);
        wheelPicker.b();
    }
}
