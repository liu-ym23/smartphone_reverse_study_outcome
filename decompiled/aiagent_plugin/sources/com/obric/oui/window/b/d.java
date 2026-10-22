package com.obric.oui.window.b;

import android.view.DisplayCutout;
import d.h.b.o;

/* JADX INFO: compiled from: WindowSizeCalculator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f36873a = null;

    static {
        f36873a = new d();
    }

    private d() {
    }

    public final int a(DisplayCutout r1) {
        o.e(r1, "displayCutout");
        return r1.getSafeInsetLeft();
    }

    public final int b(DisplayCutout r1) {
        o.e(r1, "displayCutout");
        return r1.getSafeInsetTop();
    }

    public final int c(DisplayCutout r1) {
        o.e(r1, "displayCutout");
        return r1.getSafeInsetRight();
    }

    public final int d(DisplayCutout r1) {
        o.e(r1, "displayCutout");
        return r1.getSafeInsetBottom();
    }
}
