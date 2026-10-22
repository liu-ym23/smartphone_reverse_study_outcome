package com.bytedance.android.ec.sdk;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.sdk.initalizer.ECSdkInitializer;
import com.bytedance.android.ec.sdk.plugin.PluginLoader;
import com.bytedance.android.ec.sdk.plugin.e;
import com.bytedance.android.ec.sdk.plugin.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECSdk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f48106a = 0;

    public static boolean c() {
        boolean r100 = ECSdkInitializer.f48141a;
        boolean r101 = a.f48107a;
        if (e.a() == false) goto L13;
        if (ECSdkInitializer.f48141a == false) goto L14;
        int r102 = f.f48154a;
        PluginLoader.f48148e.getClass();
        if (((PluginLoader) PluginLoader.f48147d.getValue()).f48149a != 2) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L15;
        return true;
    L15:
        return false;
    L9:
        r103 = false;
        goto L10
    L14:
        return false;
    L13:
        return ECSdkInitializer.f48141a;
    }

    static {
    }

    public static Object a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (c() == false) goto L7;
        return ECServiceManager.c(r100);
    L7:
        if (ECServiceManager.d(r100) == true) goto L9;
        ECSdkInitializer.b(null, null);
        if (c() == true) goto L13;
        return null;
    L13:
        return ECServiceManager.c(r100);
    L9:
        return ECServiceManager.c(r100);
    }

    public static void b(final Class r100, final Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "res");
        if (c() == false) goto L7;
        r101.invoke(ECServiceManager.c(r100));
        return;
    L7:
        if (ECServiceManager.d(r100) == false) goto L10;
        r101.invoke(ECServiceManager.c(r100));
        return;
    L10:
        boolean r102 = ECSdkInitializer.f48141a;
        ECSdkInitializer.b(null, new ECSdk$getService$1(r101, r100));
    }
}
