package com.bytedance.android.btm.api.view;

import android.view.View;
import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;

/* JADX INFO: loaded from: classes43.dex */
public final class BtmViewUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f42074a = "BtmViewUtils_show";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f42075b = "BtmViewUtils_hide";

    public BtmViewUtils() {
    }

    static {
        f42074a = "BtmViewUtils_show";
        f42075b = "BtmViewUtils_hide";
    }

    public static void a(View r100) {
        final String r101 = r100.getClass().getName();
        ALogger.m(ALogger.f41996d, f42075b, new BtmViewUtils$hide$1(r101));
        BtmSDK r102 = BtmSDK.INSTANCE;
        BtmPageLifecycle.a.a(r102.getPageLifecycle(), r100, null, 6);
        r102.getPageLifecycle().c(r100, BtmPageLifecycle.State.PAUSED);
    }

    public static void c(View r100) {
        final String r101 = r100.getClass().getName();
        ALogger.m(ALogger.f41996d, f42074a, new BtmViewUtils$show$1(r101));
        BtmSDK r102 = BtmSDK.INSTANCE;
        r102.getPageLifecycle().g(r100, null, null);
        r102.getPageLifecycle().c(r100, BtmPageLifecycle.State.RESUMED);
    }

    public static void b(View r100, final boolean r101) {
        final String r102 = r100.getClass().getName();
        ALogger.m(ALogger.f41996d, f42075b, new BtmViewUtils$hide$2(r102, r101));
        BtmSDK r103 = BtmSDK.INSTANCE;
        BtmPageLifecycle.a.a(r103.getPageLifecycle(), r100, Boolean.valueOf(r101), 4);
        r103.getPageLifecycle().c(r100, BtmPageLifecycle.State.PAUSED);
    }
}
