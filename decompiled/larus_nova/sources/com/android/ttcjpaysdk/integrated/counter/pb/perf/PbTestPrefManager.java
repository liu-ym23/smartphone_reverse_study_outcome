package com.android.ttcjpaysdk.integrated.counter.pb.perf;

import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010\u0012\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/pb/perf/PbTestPrefManager;", "", "()V", "INTEGRATED_TAG", "", "appId", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "merchantId", "getMerchantId", "setMerchantId", "addIntegratedUnifyPerfTimeInfo", "", "cjContext", "Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;", "key", "reportPerfInfo", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PbTestPrefManager {
    public static final PbTestPrefManager INSTANCE = null;
    private static final String INTEGRATED_TAG = null;
    private static String appId;
    private static String merchantId;

    private PbTestPrefManager() {
    }

    static {
        INSTANCE = new PbTestPrefManager();
        INTEGRATED_TAG = "integratedUnifyPerfTimeInfo";
        merchantId = "";
        appId = "";
    }

    public final String getAppId() {
        return appId;
    }

    public final String getMerchantId() {
        return merchantId;
    }

    public final void reportPerfInfo(CJContext r110) {
        if (r110 == null) goto L26;
        Map<String, Map<String, Object>> r100 = r110.f202267m;
        if (r100 == null) goto L27;
        Map r101 = (Map) ((LinkedHashMap) r100).get(INTEGRATED_TAG);
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.containsKey("function_call_time") == true) goto L10;
        return;
    L10:
        if (r101.containsKey("page_fcp_time") == false) goto L30;
        r101.put("isPb", String.valueOf(r110.f202268n));
        r101.put("isPbDowngradeJson", String.valueOf(r110.f202269o));
        Object r102 = r101.get("function_call_time");
        Long r103 = null;
        if ((r102 instanceof Long) == false) goto L14;
        Long r104 = (Long) r102;
    L15:
        long r105 = 0;
        if (r104 == null) goto L18;
        long r106 = r104.longValue();
    L19:
        Object r107 = r101.get("page_fcp_time");
        if ((r107 instanceof Long) == false) goto L22;
        r103 = (Long) r107;
    L22:
        if (r103 == null) goto L24;
        r105 = r103.longValue();
    L24:
        r101.put("unify_counter_fcp", Long.valueOf(r105 - r106));
        r101.put("ttpay_start_time", Long.valueOf(r110.f202259e));
        r101.put("merchant_id", merchantId);
        r101.put("app_id", appId);
        CJReporter.h(CJReporter.f202294a, r110, "wallet_rd_unify_counter_perf", r101, null, 56);
        return;
    L18:
        r106 = 0;
        goto L19
    L14:
        r104 = null;
        goto L15
    L30:
        return;
    L27:
        return;
    }

    public final void setAppId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        appId = r100;
    }

    public final void setMerchantId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        merchantId = r100;
    }

    public final void addIntegratedUnifyPerfTimeInfo(CJContext r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L11;
        Map<String, Map<String, Object>> r102 = r100.f202267m;
        if (r102 == null) goto L12;
        String r103 = INTEGRATED_TAG;
        Object r104 = ((LinkedHashMap) r102).get(r103);
        if (r104 != null) goto L9;
        r104 = new LinkedHashMap();
        r102.put(r103, (Map<String, Object>) r104);
    L9:
        ((Map) r104).put(r101, Long.valueOf(System.currentTimeMillis()));
        return;
    L12:
        return;
    }
}
