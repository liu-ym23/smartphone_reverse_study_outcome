package com.bytedance.android.live.browser.utils;

import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes45.dex */
public final class f {
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

    public static boolean b(Window r100) {
        View r101 = a(r100);
        if (r101 != null) goto L6;
        return false;
    L6:
        if ((r101.getSystemUiVisibility() & 8192) != 8192) goto L9;
        return true;
    L9:
        return false;
    }
}
