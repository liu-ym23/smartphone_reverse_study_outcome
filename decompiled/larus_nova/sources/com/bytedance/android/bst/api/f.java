package com.bytedance.android.bst.api;

import android.view.View;
import com.bytedance.android.bst.api.ab.EmptyBstAbPageControlService;
import com.bytedance.android.bst.api.ab.IBstAbPageControl;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.btm.api.inner.ALogger;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f41924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f41925b = null;

    public f() {
    }

    static {
        f41925b = new f();
    }

    @Deprecated(message = "已废弃，请勿使用", replaceWith = @ReplaceWith(expression = "无可替代接口", imports = {}))
    @JvmStatic
    public static final IBstAbPageControl e() {
        IBstAbPageControl r100 = (IBstAbPageControl) yc.b.a(IBstAbPageControl.class);
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new EmptyBstAbPageControlService();
    }

    public static final synchronized uc.c g() {
        monitor-enter(f.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f41924a == true) goto L7;
        ExtKt.b("BstSDK", "use normal inject");     // Catch: Throwable -> L13
        com.bytedance.android.bst.api.claymore.a.a();     // Catch: Throwable -> L13
        f41924a = true;     // Catch: Throwable -> L13
    L7:
        uc.c r100 = (uc.c) yc.b.a(uc.c.class);     // Catch: Throwable -> L13
        if (r100 != null) goto L11;
        r100 = uc.a.f549420b;     // Catch: Throwable -> L13
    L11:
        monitor-exit(f.class);
        return r100;
    }

    public static void a(d r100) {
        g().g(r100);
    }

    @Deprecated(message = "已废弃，请勿使用", replaceWith = @ReplaceWith(expression = "autoShowTrack", imports = {}))
    @JvmStatic
    public static final void b(b r100) {
        if (r100.f41899a != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    L5:
        g().bindView();
    }

    public static void c(d r100) {
        g().e(r100);
    }

    @JvmStatic
    public static final String f(String r100) {
        g().h();
        return null;
    }

    @JvmStatic
    public static final void d(View r100, Object r101) {
        if (ExtKt.getActivity(r100) != null) goto L6;
        BstSDK$createLynxInjectRawData$1 r102 = BstSDK$createLynxInjectRawData$1.INSTANCE;
        ALogger r103 = ALogger.f41996d;
        r103.getClass();
        r103.o("BTMSDK_BST_".concat("BstSDK"), false, r102, null);
        return;
    L6:
        g().f();
    }
}
