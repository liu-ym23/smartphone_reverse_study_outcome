package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.core.utils.statusbar.StatusBarInfoType;
import com.bytedance.android.livehostapi.IMiddleHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.i3;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes45.dex */
public class StatusBarUtil {
    public static boolean JUMP_FROM_LIVE_PLAY_ACTIVITY;
    public static boolean STATUS_BAR_ADAPT_ENABLE;
    private static int desiredTopSpaceHeight;
    public static int portraitStatusBarHeight;

    static {
        STATUS_BAR_ADAPT_ENABLE = j40.r.f497289a.getValue().booleanValue();
        JUMP_FROM_LIVE_PLAY_ACTIVITY = false;
        portraitStatusBarHeight = 0;
    }

    public static boolean isStatusBarAdaptCombineJudge() {
        if (STATUS_BAR_ADAPT_ENABLE == true) goto L5;
    L9:
        return false;
    L5:
        if (JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L9;
        if (isStatusBarTransparent() == false) goto L9;
        return true;
    }

    public static boolean isStatusBarTransparent() {
        if (i3.f132640a.getValue().booleanValue() == false) goto L13;
        IMiddleHostService r100 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r100 != null) goto L7;
        return false;
    L7:
        IMiddleWareHostContext r101 = r100.appContext();
        if (r101 != null) goto L11;
        return false;
    L11:
        return r101.isTransparentStatusBar();
    L13:
        if (desiredTopSpaceHeight != 0) goto L16;
        return true;
    L16:
        return false;
    }

    private StatusBarUtil() {
    }

    public static int getDesiredTopSpaceHeight() {
        return desiredTopSpaceHeight;
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_live_core_utils_StatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static int getStatusBarColor(Activity r100) {
        return r100.getResources().getColor(R.color.transparent);
    }

    public static int getStatusBarHeight(Context r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r102 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r102 <= 0) goto L8;
        r101 = r100.getResources().getDimensionPixelSize(r102);
    L8:
        com.bytedance.android.live.core.utils.statusbar.a.f66401b.a();
        com.bytedance.android.live.core.utils.statusbar.a.a(r101, StatusBarInfoType.STATUSBAR_HEIGHT);
        return r101;
    }

    public static void hideStatusBar(Activity r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(r100, false, false) == false) goto L7;
        return;
    L7:
        hideStatusBarInternel(r100);
        com.bytedance.android.live.core.utils.statusbar.a.f66401b.a();
        com.bytedance.android.live.core.utils.statusbar.a.a(0, StatusBarInfoType.HIDE_STATUSBAR);
    }

    public static void hideStatusBarInternel(Activity r100) {
        r100.getWindow().setFlags(1024, 1024);
        setStatusBarColor(r100);
    }

    public static void hideStatusBarOnLollipop(Activity r100) {
        hideStatusBar(r100);
    }

    public static void setDesiredTopSpaceHeight(int r100) {
        desiredTopSpaceHeight = r100;
        com.bytedance.android.live.core.utils.statusbar.a.f66401b.a();
        com.bytedance.android.live.core.utils.statusbar.a.a(desiredTopSpaceHeight, StatusBarInfoType.STE_STATUSBAR_HEIGHT);
    }

    public static void setStatusBarColor(Activity r100) {
        r100.getWindow().setStatusBarColor(getStatusBarColor(r100));
    }
}
