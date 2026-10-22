package com.bytedance.android.anniex.container.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontMode;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Integer f40580c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window f40581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f40582b;

    public static final class a {
    }

    static {
    }

    public final void d() {
        Window r100 = this.f40581a;
        View r101 = a(r100);
        r101.setSystemUiVisibility(r101.getSystemUiVisibility() & (-5));
        r100.clearFlags(1024);
        Window r102 = this.f40581a;
        int r103 = Build.VERSION.SDK_INT;
        r102.clearFlags(67108864);
        r102.addFlags(Integer.MIN_VALUE);
        r102.setStatusBarColor(0);
        View r104 = a(r102);
        r104.setSystemUiVisibility((1024 | r104.getSystemUiVisibility()) | 256);
        if (r103 < 28) goto L6;
        WindowManager.LayoutParams r105 = r102.getAttributes();
        r105.layoutInDisplayCutoutMode = 1;
        r102.setAttributes(r105);
        return;
    }

    public j(Window r100) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        this.f40581a = r100;
    }

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

    public static int b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r101 = f40580c;
        if (r101 != null) goto L13;
        Resources r102 = r100.getResources();
        int r103 = r102.getIdentifier("status_bar_height", "dimen", "android");
        if (r103 <= 0) goto L8;
        f40580c = Integer.valueOf(r102.getDimensionPixelSize(r103));
    L8:
        Integer r104 = f40580c;
        if (r104 != null) goto L14;
        return 0;
    L14:
        return r104.intValue();
    L13:
        return r101.intValue();
    }

    public final void c(StatusFontMode r100) {
        Intrinsics.checkNotNullParameter(r100, "fontMode");
        Window r101 = this.f40581a;
        if (r100 != StatusFontMode.DARK) goto L5;
        boolean r102 = true;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L17;
        WindowInsetsControllerCompat r103 = WindowCompat.getInsetsController(r101, a(r101));
        if (r103 == null) goto L11;
        r103.setAppearanceLightStatusBars(r102);
        return;
    L11:
        View r104 = a(r101);
        int r105 = r104.getSystemUiVisibility();
        if (r102 == false) goto L14;
        int r106 = r105 | 8192;
    L15:
        r104.setSystemUiVisibility(r106);
        return;
    L14:
        r106 = r105 & (-8193);
        goto L15
    L17:
        return;
    L5:
        r102 = false;
        goto L7
    }

    public final void e(boolean r100) {
        FrameLayout r101 = this.f40582b;
        if (r101 == null) goto L10;
        if (r100 == false) goto L7;
        int r102 = 8;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 0;
        goto L8
    }

    public final void f(boolean r100) {
        if (r100 == false) goto L5;
        Window r101 = this.f40581a;
        View r102 = a(r101);
        r102.setSystemUiVisibility(r102.getSystemUiVisibility() & (-5));
        r101.clearFlags(1024);
        return;
    L5:
        Window r103 = this.f40581a;
        View r104 = a(r103);
        r104.setSystemUiVisibility(r104.getSystemUiVisibility() | 4);
        r103.addFlags(1024);
    }
}
