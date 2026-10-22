package com.bytedance.android.ec.common.impl.sku.monitor;

import com.byted.cast.common.source.ISendResultListener;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuInfoResponseDTO;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.api.LogPbData;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class SkuApiMonitor {
    public SkuApiMonitor() {
    }

    public static void a(final SkuViewModel r110, SkuInfoResponseDTO r111, Throwable r112) {
        Intrinsics.checkNotNullParameter(r110, "viewModel");
        Function2<String, Pair<? extends String, ? extends String>[], Unit> r100 = new SkuApiMonitor$monitorApiRequestError$1(r110);
        if (r111 == null) goto L16;
        if (r112 != null) goto L16;
        if (r111.getStatusCode() == 0) goto L33;
        Pair<? extends String, ? extends String>[] r113 = new Pair[5];     // Catch: Throwable -> L29
        r113[0] = new Pair("api_path", "/live/promotion/common_skus/");     // Catch: Throwable -> L29
        r113[1] = new Pair("error_type", "1");     // Catch: Throwable -> L29
        LogPbData r101 = r111.getLogPb();     // Catch: Throwable -> L29
        if (r101 == null) goto L14;
        String r102 = r101.getImprId();     // Catch: Throwable -> L29
        if (r102 == null) goto L14;
    L15:
        r113[2] = new Pair("log_id", r102);     // Catch: Throwable -> L29
        r113[3] = new Pair("status_code", String.valueOf(r111.getStatusCode()));     // Catch: Throwable -> L29
        r113[4] = new Pair(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, r111.getStatusMsg());     // Catch: Throwable -> L29
        r100.invoke("api_request_error_event", r113);     // Catch: Throwable -> L29
        dm.a.a("live_api_request_error").w(r113.toString(), null);     // Catch: Throwable -> L29
        return;
    L14:
        r102 = "";
        goto L15
    L33:
        return;
    L16:
        Pair<? extends String, ? extends String>[] r114 = new Pair[3];     // Catch: Throwable -> L29
        r114[0] = new Pair("api_path", "/live/promotion/common_skus/");     // Catch: Throwable -> L29
        r114[1] = new Pair("error_type", "0");     // Catch: Throwable -> L29
        String r103 = ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_RESPONSE_IS_NULL;
        if (r112 == null) goto L20;
        String r104 = r112.getMessage();     // Catch: Throwable -> L29
    L21:
        r114[2] = new Pair(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, r104);     // Catch: Throwable -> L29
        r100.invoke("api_request_error_event", r114);     // Catch: Throwable -> L29
        dm.a.b r115 = dm.a.a("live_api_request_error");     // Catch: Throwable -> L29
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L29
        r105.append(r114);     // Catch: Throwable -> L29
        r105.append(" Throwable: ");     // Catch: Throwable -> L29
        if (r112 == null) goto L27;
        String r116 = r112.toString();     // Catch: Throwable -> L29
        if (r116 == null) goto L27;
        r103 = r116;
    L27:
        r105.append(r103);     // Catch: Throwable -> L29
        r115.w(r105.toString(), null);     // Catch: Throwable -> L29
        return;
    L20:
        r104 = ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_RESPONSE_IS_NULL;
    L29:
        th = move-exception;
        ECExceptionMonitor.f(th, "api request error monitor has an exception");
    }
}
