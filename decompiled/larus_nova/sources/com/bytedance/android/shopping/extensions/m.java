package com.bytedance.android.shopping.extensions;

import android.os.Build;
import android.view.View;
import android.view.Window;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.shopping.anchorv3.utils.b0;
import com.bytedance.common.utility.DeviceUtils;
import com.gyf.barlibrary.FlymeOSStatusBarFontUtils;
import com.gyf.barlibrary.OSUtils;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m {
    public static final void a(Window r100, boolean r101) {
        int r102 = b0.f165303a;
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        if (Build.VERSION.SDK_INT < 23) goto L15;
        View r103 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L9:
        int r105 = r103.getSystemUiVisibility();
        if (r101 == false) goto L12;
        int r106 = r105 | 8192;
    L13:
        r103.setSystemUiVisibility(r106);
        goto L15
    L12:
        r106 = r105 & (-8193);
    L15:
        if (OSUtils.isMIUI6Later() == false) goto L18;
        DeviceUtils.setMiuiStatusBarDarkMode(r101, r100);
    L18:
        if (OSUtils.isFlymeOS4Later() == false) goto L21;
        FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(r100, r101);
        return;
    }
}
