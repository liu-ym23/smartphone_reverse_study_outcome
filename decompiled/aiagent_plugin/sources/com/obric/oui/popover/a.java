package com.obric.oui.popover;

import android.view.View;
import d.h.b.o;

/* JADX INFO: compiled from: LongClickUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35994a = null;

    static {
        f35994a = new a();
    }

    public static /* synthetic */ boolean lambda$MgQstxqEXQjMJLcGTwrEMo1W4Ys(d r0, View r1) {
        return a(r0, r1);
    }

    private a() {
    }

    public final void a(View r1, final d r2) {
        o.e(r1, "<this>");
        o.e(r2, "longClickListenerEx");
        r1.setOnTouchListener(r2.b());
        r1.setOnLongClickListener(new $$Lambda$a$MgQstxqEXQjMJLcGTwrEMo1W4Ys(r2));
    }

    private static final boolean a(d r1, View r2) {
        o.e(r1, "$longClickListenerEx");
        o.c(r2, "it");
        return r1.a(r2, r1.a());
    }
}
