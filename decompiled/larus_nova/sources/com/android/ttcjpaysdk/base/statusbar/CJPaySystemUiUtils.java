package com.android.ttcjpaysdk.base.statusbar;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes28.dex */
public final class CJPaySystemUiUtils {
    public CJPaySystemUiUtils() {
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_base_statusbar_CJPaySystemUiUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void appendSystemUiFlags(Activity r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        appendWindowSystemUiFlags(r100.getWindow(), r101);
    }

    public static void appendWindowSystemUiFlags(Window r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        View r102 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_statusbar_CJPaySystemUiUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100);
        if (r102 != null) goto L7;
        return;
    L7:
        int r103 = r102.getSystemUiVisibility();
        if ((r103 & r101) != r101) goto L10;
        return;
    L10:
        r102.setSystemUiVisibility(r101 | r103);
    }

    public static void clearSystemUiFlags(Activity r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        clearWindowSystemUiFlags(r100.getWindow(), r101);
    }

    public static void clearWindowSystemUiFlags(Window r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        View r102 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_statusbar_CJPaySystemUiUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100);
        if (r102 != null) goto L7;
        return;
    L7:
        int r103 = r102.getSystemUiVisibility();
        if ((r103 & r101) != 0) goto L10;
        return;
    L10:
        r102.setSystemUiVisibility((~r101) & r103);
    }
}
