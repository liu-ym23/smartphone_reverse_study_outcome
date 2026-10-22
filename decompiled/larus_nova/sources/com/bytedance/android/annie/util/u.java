package com.bytedance.android.annie.util;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes43.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f40077a;

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

    public static int b(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = f40077a;
        if (r101 == 0) goto L8;
        return r101;
    L8:
        Resources r102 = r100.getResources();
        int r103 = r102.getDimensionPixelSize(r102.getIdentifier("status_bar_height", "dimen", "android"));
        f40077a = r103;
        return r103;
    }
}
