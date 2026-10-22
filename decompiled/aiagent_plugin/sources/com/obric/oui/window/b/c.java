package com.obric.oui.window.b;

import android.graphics.Point;
import android.view.Display;
import d.h.b.o;

/* JADX INFO: compiled from: WindowSizeCalculator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f36872a = null;

    static {
        f36872a = new c();
    }

    private c() {
    }

    public final void a(Display r1, Point r2) {
        o.e(r1, "display");
        o.e(r2, "point");
        r1.getRealSize(r2);
    }
}
