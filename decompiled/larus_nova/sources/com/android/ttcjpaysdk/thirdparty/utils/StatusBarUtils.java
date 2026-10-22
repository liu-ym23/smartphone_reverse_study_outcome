package com.android.ttcjpaysdk.thirdparty.utils;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes39.dex */
public class StatusBarUtils {
    public StatusBarUtils() {
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_thirdparty_utils_StatusBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void initStatusBar(int r100, Activity r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        Window r102 = r101.getWindow();
        r102.addFlags(Integer.MIN_VALUE);
        INVOKEVIRTUAL_com_android_ttcjpaysdk_thirdparty_utils_StatusBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r102).setSystemUiVisibility(9728);
    }
}
