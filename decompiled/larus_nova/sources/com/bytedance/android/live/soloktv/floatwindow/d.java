package com.bytedance.android.live.soloktv.floatwindow;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FrameLayout.LayoutParams f101104a = null;

    static {
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(s1.f(54), s1.f(72));
        float r101 = 16;
        r100.setMargins(s1.f(r101), s1.A() + s1.f(60), s1.f(r101), s1.f(12));
        f101104a = r100;
    }

    public static void a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        SaveProgressFloatWindowManager.a r101 = SaveProgressFloatWindowManager.f101076k;
        if (SaveProgressFloatWindowManager.b.a().f101080c == true) goto L5;
        return;
    L5:
        b r102 = SaveProgressFloatWindowManager.b.a().f101079b;
        if (r102 != null) goto L8;
        return;
    L8:
        View r103 = null;
        if (r102.getParent() == null) goto L16;
        ViewParent r104 = r102.getParent();
        if ((r104 instanceof ViewGroup) == true) goto L13;
        r104 = null;
    L13:
        ViewGroup r105 = (ViewGroup) r104;
        if (r105 == null) goto L16;
        r105.removeView(r102);
    L16:
        r102.setLayoutParams(f101104a);
        View r106 = r100.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L22;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r107 = ThreadMethodProxy.currentThread();
        if (r107 == com.larus.home.impl.utils.c.f346341a) goto L22;
        com.larus.home.impl.utils.c.a(r107, "getDecorView");
    L22:
        if ((r106 instanceof ViewGroup) == false) goto L25;
        r103 = r106;
    L25:
        ViewGroup r108 = (ViewGroup) r103;
        if (r108 == null) goto L29;
        r108.addView(r102);
        return;
    }
}
