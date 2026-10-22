package com.bytedance.android.ec.core.utils;

import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class UIUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f45548a = null;

    public UIUtils() {
    }

    public static Handler c() {
        return (Handler) f45548a.getValue();
    }

    static {
        f45548a = LazyKt.lazy(UIUtils$uiHandler$2.INSTANCE);
    }

    public static boolean d() {
        return Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));
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

    public static void e(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (d() == false) goto L5;
        r100.run();
        return;
    L5:
        c().post(r100);
    }

    public static void b(Window r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        return;
    L6:
        if (((((((double) Color.red(r101)) * 0.299d) + (((double) Color.green(r101)) * 0.587d)) + (((double) Color.blue(r101)) * 0.114d)) / ((double) 255)) <= 0.5d) goto L8;
        a(r100).setSystemUiVisibility(a(r100).getSystemUiVisibility() | 16);
        return;
    L8:
        a(r100).setSystemUiVisibility(a(r100).getSystemUiVisibility() & (-17));
    }

    public static void f(ViewGroup r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setClipChildren");
        int r102 = 12;
    L3:
        int r103 = r102 - 1;
        if (r102 <= 0) goto L21;
        r100.setClipChildren(false);
        ViewParent r104 = r100.getParent();
        if ((r104 instanceof ViewGroup) == true) goto L8;
        r104 = null;
    L8:
        r100 = (ViewGroup) r104;
        if (r100 == null) goto L22;
        if (r101 == null) goto L14;
        if (((Boolean) r101.invoke(r100)).booleanValue() == false) goto L14;
        r100.setClipChildren(false);
        return;
    L14:
        r102 = r103;
        goto L3
    L22:
        return;
    }

    public static void g(Window r100, String r101) {
        if (r100 != null) goto L11;
        return;
    L11:
        Integer r102 = s.b(r101);     // Catch: Exception -> L8
        if (r102 == null) goto L13;
        int r103 = r102.intValue();     // Catch: Exception -> L8
        r100.setNavigationBarColor(r103);     // Catch: Exception -> L8
        b(r100, r103);     // Catch: Exception -> L8
        return;
    L13:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
