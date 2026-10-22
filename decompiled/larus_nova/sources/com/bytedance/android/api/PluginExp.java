package com.bytedance.android.api;

import android.content.Context;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes43.dex */
public final class PluginExp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f41754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f41755b = null;

    public static boolean a() {
        return ((Boolean) f41755b.getValue()).booleanValue();
    }

    static {
        f41755b = LazyKt.lazy(PluginExp$enabled$2.INSTANCE);
    }

    public static void b(String r100) {
        a();
        if (f41754a == false) goto L6;
        return;
    L6:
        if (a() == false) goto L19;
        HybridAppInfoService r101 = HybridAppInfoService.f47545p;
        if (r101.isDebug() == false) goto L11;
    L13:
        final Context r102 = r101.getApplicationContext();
        if (r102 == null) goto L21;
        ECHybridExtensionsKt.f(new PluginExp$showABToast$1(r102));
        return;
    L21:
        return;
    L11:
        if (r101.isLocalTest() == true) goto L13;
        return;
    }
}
