package com.bytedance.android.gamecp.common.utils;

import android.os.Build;
import android.view.View;
import android.view.Window;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.utils.logger.FLogger;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes44.dex */
public final class j0 {
    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void b(Window r100) {
        if (r100 == null) goto L5;
        r100.addFlags(Integer.MIN_VALUE);
        r100.clearFlags(67108864);
        r100.setStatusBarColor(0);
        View r101 = a(r100);
        r101.setSystemUiVisibility(r101.getSystemUiVisibility() | 1280);
        return;
    }

    public static void c(Window r100) {
        if (r100 == null) goto L5;
        r100.addFlags(Integer.MIN_VALUE);
        r100.clearFlags(67108864);
        r100.setStatusBarColor(0);
        r100.clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        r100.setNavigationBarColor(ColorProtector.parseColor("#FF000000"));
        a(r100).setSystemUiVisibility(ISmModel.VERSION_0700);
        return;
    }

    public static void d(Window r100) {
        if (Build.VERSION.SDK_INT < 23) goto L17;
        if (r100 != null) goto L7;
        return;
    L7:
        if (a(r100) != null) goto L9;
        return;
    L9:
        View r101 = k0.a(r100);
        if (r101 == null) goto L19;
        int r102 = r101.getSystemUiVisibility();
        if ((r102 & 8192) == 0) goto L20;
        r101.setSystemUiVisibility(r102 & (-8193));
        return;
    L20:
        return;
    L19:
        return;
    }

    public static void e(Window r100) {
        if (Build.VERSION.SDK_INT < 23) goto L17;
        if (r100 != null) goto L7;
        return;
    L7:
        if (a(r100) != null) goto L9;
        return;
    L9:
        View r101 = k0.a(r100);
        if (r101 == null) goto L19;
        int r102 = r101.getSystemUiVisibility();
        if ((r102 & 9216) == 9216) goto L20;
        r101.setSystemUiVisibility(r102 | 9216);
        return;
    L20:
        return;
    L19:
        return;
    }
}
