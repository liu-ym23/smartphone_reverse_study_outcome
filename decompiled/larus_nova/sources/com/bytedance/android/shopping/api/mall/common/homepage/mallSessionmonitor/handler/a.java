package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler;

import cl.d;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.ec.local.api.ErrorType;
import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.ECHandlerType;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Function6<String, String, String, Double, String, Map<String, ? extends Object>, Unit>> f170361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Set<String>> f170362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f170363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f170364d;

    @Override // com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c
    public abstract String a(String r100, Map<String, ? extends Object> r101);

    public abstract Function6<String, String, String, Double, String, Map<String, ? extends Object>, Unit> c();

    public abstract ECHandlerType d();

    public abstract Map<String, Object> e();

    public a() {
        this.f170361a = new ConcurrentHashMap();
        this.f170362b = new ConcurrentHashMap();
        this.f170363c = "ec_mall_session_stage_duplicate_report";
        this.f170364d = "trigger_source";
    }

    @Override // com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c
    public final void b(String r110, String r111, double r112, String r113, Map<String, ? extends Object> r114) {
        Intrinsics.checkNotNullParameter(r110, "stageName");
        Intrinsics.checkNotNullParameter(r111, "scheme");
        Intrinsics.checkNotNullParameter(r113, "triggerSource");
        boolean r100 = false;
        if (r110.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        String r115 = a(r111, r114);
        if (r115 != null) goto L11;
        return;
    L11:
        if (r115.length() <= 0) goto L13;
        r100 = true;
    L13:
        Object r102 = null;
        if (r100 == true) goto L17;
        r115 = null;
    L17:
        if (r115 == null) goto L58;
        ConcurrentHashMap r103 = (ConcurrentHashMap) this.f170362b;
        Object r116 = r103.get(r115);
        if (r116 != null) goto L22;
        r116 = new LinkedHashSet();
        r103.put(r115, r116);
    L22:
        Set r117 = (Set) r116;
        ECHandlerType r104 = d();
        if (r104 == null) goto L33;
        Intrinsics.checkNotNullParameter(r117, "stageList");
        Intrinsics.checkNotNullParameter(r111, "scheme");
        Intrinsics.checkNotNullParameter(r115, "sessionId");
        Intrinsics.checkNotNullParameter(r110, "stageName");
        Intrinsics.checkNotNullParameter(r113, "triggerSource");
        Intrinsics.checkNotNullParameter(r104, "handlerType");
        if (r117.contains(r110) == false) goto L32;
        String r105 = r104.getType();
        if (HybridAppInfoService.f47545p.isLocalTest() == false) goto L31;
        d.f24079a.getClass();
        d r106 = d.a.b();
        if (r106 == null) goto L31;
        r106.o("埋点重复上报", "当前" + r105 + " 链路存在埋点重复上报问题，重复上报的stageName为" + r110 + "，当前触发来源为 " + r113 + "，请检查是否存在多处重复调用逻辑，详情请联系 yangzilong.0217@bytedance.com", ErrorType.NOTIFY);
    L31:
        String r107 = r104.getType();
        String r108 = this.f170363c;
        JSONObject r109 = new JSONObject();
        r109.putOpt("scheme", r111);
        r109.putOpt("session_id", r115);
        r109.putOpt("stage", r110);
        r109.putOpt(this.f170364d, r113);
        r109.putOpt("handler_type", r107);
        Unit r118 = Unit.INSTANCE;
        AppLogNewUtils.onEventV3(r108, r109);
        goto L33
    L32:
        r117.add(r110);
    L33:
        Map<String, Object> r119 = e();
        if (r119 == null) goto L36;
        Object r120 = r119.get(r110);
    L38:
        if ((r120 instanceof String) == false) goto L41;
        r102 = r120;
    L41:
        String r121 = (String) r102;
        if (r121 != null) goto L44;
        String r122 = r110;
    L46:
        if (((ConcurrentHashMap) this.f170361a).containsKey(r122) == false) goto L50;
        Function6 r123 = (Function6) ((ConcurrentHashMap) this.f170361a).get(r122);
        if (r123 == null) goto L55;
        r123.invoke(r122, r111, r115, Double.valueOf(r112), r113, r114);
        return;
    L55:
        return;
    L50:
        Function6<String, String, String, Double, String, Map<String, ? extends Object>, Unit> r124 = c();
        if (r124 == null) goto L57;
        r124.invoke(r122, r111, r115, Double.valueOf(r112), r113, r114);
        return;
    L57:
        return;
    L44:
        r122 = r121;
        goto L46
    L36:
        r120 = null;
        goto L38
    L58:
        return;
    L5:
        r101 = false;
        goto L6
    }
}
