package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.core.utils.screen.DigHoleScreenCheckerManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class DigHoleScreenUtil {
    private DigHoleScreenUtil() {
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_live_core_utils_DigHoleScreenUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static boolean isAllScreenForAndroidP(Context r100) {
        if ((r100 instanceof Activity) == true) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT >= 28) goto L8;
        return false;
    L8:
        View r101 = INVOKEVIRTUAL_com_bytedance_android_live_core_utils_DigHoleScreenUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(((Activity) r100).getWindow());
        Object r102 = r101.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(r101, new Object[0]);     // Catch: Exception -> L15
        Object r103 = r102.getClass().getDeclaredMethod("getDisplayCutout", new Class[0]).invoke(r102, new Object[0]);     // Catch: Exception -> L15
        List r104 = (List) r103.getClass().getMethod("getBoundingRects", new Class[0]).invoke(r103, new Object[0]);     // Catch: Exception -> L15
        if (r104 == null) goto L20;
        if (r104.size() <= 0) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    L15:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean isCutOut(Context r100) {
        Resources r101 = r100.getResources();     // Catch: Exception -> L12
        int r102 = r101.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");     // Catch: Exception -> L12
        if (r102 <= 0) goto L6;
        String r103 = r101.getString(r102);     // Catch: Exception -> L12
    L7:
        if (r103 == null) goto L15;
        if (TextUtils.isEmpty(r103) == true) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L6:
        r103 = null;
    L17:
        return false;
    }

    public static boolean isDigHole(Context r100) {
        if (isAllScreenForAndroidP(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if (new DigHoleScreenCheckerManager(r100).f66392a == true) goto L10;
        if (isCutOut(r100) == true) goto L10;
        return false;
    }

    public static boolean isNeedStatusBarAdapt(Context r100, boolean r101, boolean r102) {
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L13;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L13;
        if (r101 == false) goto L11;
        if (r102 == true) goto L11;
        return true;
    L11:
        return isDigHole(r100);
    L13:
        return isDigHole(r100);
    }
}
