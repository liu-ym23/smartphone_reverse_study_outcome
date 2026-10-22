package com.bytedance.android.anniex.container.util;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f40627a = 0;

    static {
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

    public static void b(Activity r100, String r101) {
        if (r100 == null) goto L6;
        Window r102 = r100.getWindow();
        r102.clearFlags(67108864);
        a(r102).setSystemUiVisibility(1280);
        r102.addFlags(Integer.MIN_VALUE);
        r102.setStatusBarColor(0);
    L6:
        if (Intrinsics.areEqual("light", r101) == false) goto L9;
        g.f(r100);
        return;
    L9:
        if (Intrinsics.areEqual("dark", r101) == false) goto L13;
        g.g(r100);
        return;
    }
}
