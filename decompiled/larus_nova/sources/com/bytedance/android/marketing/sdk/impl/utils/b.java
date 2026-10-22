package com.bytedance.android.marketing.sdk.impl.utils;

import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ji.a f162814a = null;

    static {
        int r100 = ECSdk.f48106a;
        IECHostService r101 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r101 == null) goto L5;
        ji.a r102 = r101.getIECHostALogService();
    L6:
        f162814a = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static void a(String r100) {
        ji.a r101 = f162814a;
        if (r101 == null) goto L6;
        r101.log(4, "ECMarketing", r100);
        return;
    }

    public static void b(String r100) {
        ji.a r101 = f162814a;
        if (r101 == null) goto L6;
        r101.log(4, "ECMarketing", r100);
        return;
    }

    public static void d(String r100) {
        b("[CROSS][JSB]".concat(r100));
    }

    public static void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorMessage");
        a("loadError");
        a("errorMessage ==>  ".concat(r100));
    }

    public static void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "megaId");
        Intrinsics.checkNotNullParameter(r101, "action");
        b("[CROSS][ROUTER]".concat(r101));
        b("megaId ==> " + r100);
    }

    public static void j(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        b("[CROSS][EVENT]");
        b("eventName ==>  ".concat(r100));
        if (r101 == null) goto L6;
        b("params ==>  " + r101);
        return;
    }

    public static void f(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_RIT);
        Intrinsics.checkNotNullParameter(r102, "component");
        b("[LYNXLIFECYCLE][LOADVIEW]");
        b("schema ==>  " + r100);
        b("rit ==>  " + r101);
        b("component ==>  " + r102);
    }

    public static void h(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_RIT);
        Intrinsics.checkNotNullParameter(r102, "component");
        b("loadLynxViewSuccess");
        b("schema ==>  " + r100);
        b("rit ==>  " + r101);
        b("component ==>  " + r102);
    }

    public static void c(String r100, String r101, String r102, long r103) {
        if (r100 != null) goto L5;
        r100 = " ";
    L5:
        b("rit ==> ".concat(r100));
        if (r101 != null) goto L8;
        r101 = " ";
    L8:
        b("compname ==> ".concat(r101));
        if (r102 != null) goto L11;
        r102 = " ";
    L11:
        b("pageid ==> ".concat(r102));
        b("timestamp ==> " + r103);
    }

    public static void g(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_RIT);
        Intrinsics.checkNotNullParameter(r102, "component");
        Intrinsics.checkNotNullParameter(r103, "message");
        a("[LYNXLIFECYCLE][LOADFAILURE]");
        a("schema ==>  " + r100);
        a("rit ==>  " + r101);
        a("component ==>  " + r102);
        a("message ==>  " + r103);
    }
}
