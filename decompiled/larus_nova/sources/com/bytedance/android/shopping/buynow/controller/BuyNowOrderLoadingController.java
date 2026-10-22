package com.bytedance.android.shopping.buynow.controller;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.yata.business.function.common.TTPay;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class BuyNowOrderLoadingController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f170802a = 0;

    static {
    }

    public static void a(Boolean r100, boolean r101, Map r102, ia3.b r103, Context r104) {
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((!Intrinsics.areEqual(r100, Boolean.TRUE)) == false) goto L11;
        if (r101 == false) goto L7;
        if (r103 == null) goto L32;
        r103.b(new ia3.c(false, false));
        return;
    L32:
        return;
    L7:
        if (r103 == null) goto L34;
        r103.c();
        return;
    L34:
        return;
    L11:
        if (r101 == false) goto L30;
        int r105 = TTPay.f187579a;     // Catch: Exception -> L18
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L18
        r106.put("service", 61);     // Catch: Exception -> L18
        r106.put("sdk_info", new JSONObject().put("loading_status", 1));     // Catch: Exception -> L18
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L18
        if (r102 == null) goto L15;
        JSONObject r108 = com.bytedance.android.ec.hybrid.list.util.k.b(r102);     // Catch: Exception -> L18
    L16:
        r106.put("ext", r107.put("sdk_show_info", r108).toString());     // Catch: Exception -> L18
        Unit r109 = Unit.INSTANCE;     // Catch: Exception -> L18
        TTPay.a(r104, r106, BuyNowOrderLoadingController$toggleLoading$2.INSTANCE);     // Catch: Exception -> L18
        return;
    L15:
        r108 = new JSONObject();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L30:
        int r110 = TTPay.f187579a;     // Catch: Exception -> L25
        JSONObject r111 = new JSONObject();     // Catch: Exception -> L25
        r111.put("service", 61);     // Catch: Exception -> L25
        r111.put("sdk_info", new JSONObject().put("loading_status", 0));     // Catch: Exception -> L25
        Unit r112 = Unit.INSTANCE;     // Catch: Exception -> L25
        TTPay.a(r104, r111, BuyNowOrderLoadingController$toggleLoading$4.INSTANCE);     // Catch: Exception -> L25
        if (r103 == null) goto L36;
        r103.c();     // Catch: Exception -> L25
        return;
    L36:
        return;
    L25:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }
}
