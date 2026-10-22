package com.amap.api.mapcore.util;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes28.dex */
abstract class x4 extends Dialog {
    public abstract void b();

    public void a() {
        Window r100 = getWindow();
        if (r100 == null) goto L9;
        r100.requestFeature(1);
        b();
        INVOKEVIRTUAL_com_amap_api_mapcore_util_x4_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams r101 = r100.getAttributes();
        if (r101 == null) goto L7;
        r101.width = -1;
        r101.height = -2;
        r101.gravity = 80;
    L7:
        r100.setAttributes(r101);
        r100.setBackgroundDrawableResource(R.color.transparent);
        return;
    }

    public x4(Context r100) {
        super(r100);
        a();
    }

    public static View INVOKEVIRTUAL_com_amap_api_mapcore_util_x4_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }
}
