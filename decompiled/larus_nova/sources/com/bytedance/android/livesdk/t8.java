package com.bytedance.android.livesdk;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes7.dex */
public final class t8 {
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
        com.bytedance.android.live.core.utils.statusbar.a.C1098a r101 = com.bytedance.android.live.core.utils.statusbar.a.f66401b;
        r101.a();
        r100.addFlags(Integer.MIN_VALUE);
        r100.clearFlags(67108864);
        r100.setStatusBarColor(0);
        View r102 = a(r100);
        int r103 = r102.getSystemUiVisibility();
        r101.a();
        r101.a();
        r102.setSystemUiVisibility(r103 | 1280);
        return;
    }

    public static void d(Window r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        c(r100, a(r100), 514);
    }

    public static void e(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Window r101 = r100.getWindow();
        if (r101 != null) goto L7;
        return;
    L7:
        View r102 = a(r101);
        if (r102 != null) goto L10;
        return;
    L10:
        if (r101.getAttributes() != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L17;
        r101.clearFlags(1024);
    L17:
        int r104 = r102.getSystemUiVisibility();
        com.bytedance.android.live.core.utils.statusbar.a.C1098a r105 = com.bytedance.android.live.core.utils.statusbar.a.f66401b;
        r105.a();
        r105.a();
        if (r104 == 1280) goto L22;
        r102.setSystemUiVisibility(1280);
        return;
    L22:
        return;
    L12:
        if ((r101.getAttributes().flags & 1024) != 1024) goto L14;
        r103 = true;
        goto L15
    }

    public static void c(Window r100, View r101, int r102) {
        if (r100 == null) goto L18;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.getAttributes() != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L12;
        r100.clearFlags(1024);
    L12:
        int r104 = r101.getSystemUiVisibility();
        com.bytedance.android.live.core.utils.statusbar.a.f66401b.a();
        int r105 = 5124;
        if (r102 == 0) goto L15;
        r105 = 5124 | r102;
    L15:
        if (r104 == r105) goto L20;
        r101.setSystemUiVisibility(r105);
        return;
    L20:
        return;
    L7:
        if ((r100.getAttributes().flags & 1024) != 1024) goto L9;
        r103 = true;
        goto L10
    }
}
