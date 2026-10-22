package com.bytedance.android.live.core.utils.screen;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.alog.middleware.ALogService;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class DigHoleScreenCheckerManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, a> f66390b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, a> f66391c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f66392a;

    static {
        f66390b = new AnonymousClass1();
        f66391c = new AnonymousClass2();
    }

    public DigHoleScreenCheckerManager(Context r100) {
        boolean r101 = false;
        this.f66392a = false;
        if ((r100 instanceof Activity) == true) goto L6;
    L18:
        boolean r102 = false;
    L21:
        if (r102 == false) goto L45;
    L42:
        r101 = true;
    L43:
        this.f66392a = r101;
        return;
    L45:
        String r103 = Build.MANUFACTURER.toUpperCase().trim();     // Catch: Exception -> L39
        String r104 = Build.BRAND.toUpperCase().trim();     // Catch: Exception -> L39
        a r105 = (a) ((HashMap) f66390b).get(r103);     // Catch: Exception -> L39
        a r106 = (a) ((HashMap) f66391c).get(r104);     // Catch: Exception -> L39
        if (r105 != null) goto L25;
    L27:
        boolean r107 = false;
    L28:
        if (r106 == null) goto L33;
        if (r105 == r106) goto L33;
        if (r106.b(r100) == false) goto L33;
        boolean r108 = true;
    L34:
        if (r107 == true) goto L38;
        if (r108 == true) goto L38;
    L37:
        boolean r109 = false;
    L41:
        if (r109 == false) goto L43;
    L38:
        r109 = true;
    L33:
        r108 = false;
        goto L34
    L25:
        if (r105.b(r100) == false) goto L27;
        r107 = true;
    L39:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L18;
        View r110 = ((Activity) r100).getWindow().getDecorView();
        if (c.f346345e == false) goto L47;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r111 = ThreadMethodProxy.currentThread();
        if (r111 == c.f346341a) goto L47;
        c.a(r111, "getDecorView");
    L47:
        Object r112 = r110.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(r110, new Object[0]);     // Catch: Exception -> L19
        Object r113 = r112.getClass().getDeclaredMethod("getDisplayCutout", new Class[0]).invoke(r112, new Object[0]);     // Catch: Exception -> L19
        List r114 = (List) r113.getClass().getMethod("getBoundingRects", new Class[0]).invoke(r113, new Object[0]);     // Catch: Exception -> L19
        if (r114 == null) goto L18;
        if (r114.size() <= 0) goto L18;
        r102 = true;
    L19:
        e = move-exception;
        ALogService.dSafely("DigHoleCheck", Log.getStackTraceString(e));
        goto L18
    }
}
