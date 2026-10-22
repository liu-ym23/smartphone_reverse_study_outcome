package com.bytedance.android.shopping.mall.homepage.jsb;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class m extends qf3.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f178206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f178207e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f178206d;
    }

    public m(qf3.d r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        super(r100);
        this.f178207e = r101;
        this.f178206d = "ec.mall.showTaskBanner";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r110, IBDXBridgeContext r111, Map<String, ? extends Object> r112, Map<String, Object> r113) {
        Intrinsics.checkNotNullParameter(r110, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r111, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r113, "result");
        Object r114 = r112.get("taskBannerData");
        View r100 = null;
        if ((r114 instanceof Map) == true) goto L5;
        r114 = null;
    L5:
        Map r115 = (Map) r114;
        if (r115 != null) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == true) goto L14;
        JSONObject r102 = new JSONObject(r115);
        String r103 = r102.optString(AiProactiveTaskViewModel.PARAM_TASK_TYPE);
        JSONObject r104 = r102.optJSONObject("task_request_params");
        if (r104 == null) goto L45;
        if (r103 != null) goto L19;
    L22:
        boolean r105 = true;
    L23:
        if (r105 == true) goto L45;
        JSONObject r106 = r102.optJSONObject("log_extra");
        Pair[] r107 = new Pair[8];
        r107[0] = TuplesKt.to(AiProactiveTaskViewModel.PARAM_TASK_TYPE, r103);
        r107[1] = TuplesKt.to("task_request_params", r104);
        r107[2] = TuplesKt.to("task_enter_from", r102.optString("task_enter_from"));
        r107[3] = TuplesKt.to("extra", r102.optJSONObject("extra"));
        r107[4] = TuplesKt.to("frame", r102.optJSONObject("frame"));
        r107[5] = TuplesKt.to("log_extra", r106);
        if (r106 == null) goto L28;
        String r116 = r106.optString("page_name");
    L29:
        r107[6] = TuplesKt.to("page_name", r116);
        if (r106 == null) goto L32;
        String r117 = r106.optString("source_page");
    L33:
        r107[7] = TuplesKt.to("source_page", r117);
        MapsKt.mapOf(r107);
        IHybridHostService r118 = com.bytedance.android.ec.hybrid.a.h();
        if (r118 == null) goto L42;
        yj.f r119 = r118.getHybridECSdkService();
        if (r119 == null) goto L42;
        Context r120 = r110.f532722a;
        View r121 = this.f178207e;
        if ((r121 instanceof FrameLayout) == false) goto L41;
        r100 = r121;
    L41:
        FrameLayout r108 = (FrameLayout) r100;
        r119.d();
    L42:
        r113.put("containerID", "");
        return qf3.e.f(this);
    L32:
        r117 = null;
        goto L33
    L28:
        r116 = null;
        goto L29
    L19:
        if (r103.length() == 0) goto L22;
        r105 = false;
    L45:
        return qf3.e.c("task_request_params is null or task_type is null or empty");
    L14:
        return qf3.e.c("taskBannerData is null or empty");
    L8:
        if (r115.isEmpty() == true) goto L11;
        r101 = false;
        goto L12
    }
}
