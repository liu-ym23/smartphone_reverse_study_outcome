package com.bytedance.android.live.soloktv.util;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.soloktv.view.FakeViewRoot;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static FakeViewRoot f101602a;

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

    public static FakeViewRoot b(FragmentActivity r100) {
        View r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        FakeViewRoot r102 = new FakeViewRoot(jc1.a.b(), null);
        r102.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r102.setFocusable(false);
        r102.setClickable(false);
        View r103 = a(r100.getWindow());
        if ((r103 instanceof ViewGroup) == false) goto L9;
        r101 = r103;
    L9:
        ViewGroup r104 = (ViewGroup) r101;
        if (r104 == null) goto L12;
        r104.addView(r102);
    L12:
        r102.setBindActivity(r100);
        f101602a = r102;
        return r102;
    }
}
