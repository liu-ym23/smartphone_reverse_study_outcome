package com.obric.oui.bouncelayout;

import android.util.Log;
import android.view.View;
import com.obric.aiagent.apm.impl.BuildConfig;
import d.h.b.o;
import d.x;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: BounceDebugLogger.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private static final String TAG = "OUIBounce";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f34149a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f34150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile d.h.a.b<? super c, x> f34151c;

    static {
        f34149a = new d();
    }

    private d() {
    }

    public static final boolean a() {
        return f34150b;
    }

    public static final void a(View r11, String r12, String r13) {
        o.e(r11, "view");
        o.e(r12, "operation");
        o.e(r13, "message");
        if (f34150b == true) goto L5;
        return;
    L5:
        String r2 = r11.getClass().getSimpleName();
        o.c(r2, "view.javaClass.simpleName");
        c r0 = new c(r2, r12, r11.getScrollX(), r11.getScrollY(), r13, 0, 32, null);
        a(TAG, r0.a());
        d.h.a.b<? super c, x> r14 = f34151c;
        if (r14 == null) goto L10;
        r14.invoke(r0);
        return;
    }

    public static final void a(View r11, String r12, float r13, float r14, String r15) {
        o.e(r11, "view");
        o.e(r12, "operation");
        o.e(r15, "message");
        if (f34150b == true) goto L5;
        return;
    L5:
        String r2 = r11.getClass().getSimpleName();
        o.c(r2, "view.javaClass.simpleName");
        c r0 = new c(r2, r12, r13, r14, r15, 0, 32, null);
        a(TAG, r0.a());
        d.h.a.b<? super c, x> r16 = f34151c;
        if (r16 == null) goto L10;
        r16.invoke(r0);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
