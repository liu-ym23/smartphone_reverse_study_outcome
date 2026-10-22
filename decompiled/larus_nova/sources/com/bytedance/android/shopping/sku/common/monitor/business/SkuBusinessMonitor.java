package com.bytedance.android.shopping.sku.common.monitor.business;

import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuBusinessMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f182735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f182736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f182737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f182738d;

    public static final class a {
    }

    static {
    }

    public SkuBusinessMonitor(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "baseParams");
        this.f182738d = r100;
        this.f182737c = System.currentTimeMillis();
    }

    public final void a(boolean r100, com.bytedance.kmp.ec.yata.common.biz.callback.a r101) {
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f182735a = 0;
        this.f182736b = r100;
        this.f182737c = System.currentTimeMillis();
        JSONObject r102 = new JSONObject();
        r102.put("show_loading", r100 ? 1 : 0);
        r102.put("trigger", r101.f251371b);
        r102.put("operator_type", r101.f251372c);
        Unit r103 = Unit.INSTANCE;
        b("loading_start", r102);
    }

    public final void b(String r100, JSONObject r101) {
        final JSONObject r102 = x0.a(this.f182738d);
        r102.put("type", r100);
        r102.put("extra", r101);
        g.f48122a.logV3("sku_business_monitor", r102);
        Lazy r103 = SkuCommonLog.f182771a;
        SkuCommonLog.a("SkuYataBusiness", new SkuBusinessMonitor$reportBusiness$1(r102));
    }
}
