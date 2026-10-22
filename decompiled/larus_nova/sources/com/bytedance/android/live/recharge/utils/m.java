package com.bytedance.android.live.recharge.utils;

import am2.x;
import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.service.PayService;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f90492a = 0;

    public m() {
    }

    static {
    }

    public static void j(com.bytedance.android.live.recharge.model.d r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        HashMap r101 = new HashMap();
        b(r101, r100, new Object[]{rw0.b.class});
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r102 = f.f90457a;
        f.d("livesdk_rd_recharge_panel_create_landscape", r101, new Class[]{IRoom.class, x.class});
    }

    public static void a(HashMap r100, com.bytedance.android.live.recharge.model.d r101) {
        qw0.a r102 = (qw0.a) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), qw0.a.class);
        if (r102 == null) goto L8;
        Iterator<T> r103 = r102.S0().entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        ((rw0.a) ((Map.Entry) r103.next()).getValue()).a(r100, r101);
        goto L6
    L10:
        return;
    }

    public static void c(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "status");
        long r102 = System.currentTimeMillis() - r100;
        HashMap r103 = new HashMap();
        r103.put("api_time_cost", String.valueOf(r102));
        r103.put("api_status", r101);
        r103.put("is_pb_enable", "0");
        f.c("livesdk_rd_diamond_api_duration", r103);
    }

    public static String d(com.bytedance.android.live.recharge.deal.f r100, com.bytedance.android.live.recharge.model.d r101) {
        Intrinsics.checkNotNullParameter(r100, "deal");
        if ((r100 instanceof com.bytedance.android.live.recharge.deal.u) == false) goto L14;
        if (r101 == null) goto L11;
        if (r101.f90016e != true) goto L11;
        if (r100.c().l() != r100.b()) goto L11;
        return "balance";
    L11:
        if (((com.bytedance.android.live.recharge.deal.u) r100).f89770h == false) goto L13;
        return "last_recharge";
    L13:
        return "default";
    L14:
        return "customized";
    }

    public static void i(int r100, long r101) {
        HashMap r102 = new HashMap();
        r102.put("status", String.valueOf(r100));
        r102.put("duration", String.valueOf(r101));
        f.c("livesdk_rd_recharge_cache_hit_status_all", r102);
    }

    public static void k(Order r100, com.bytedance.android.live.recharge.model.d r101) {
        Intrinsics.checkNotNullParameter("livesdk_recharge_fail_toast_show", "eventName");
        Intrinsics.checkNotNullParameter(r100, "order");
        Intrinsics.checkNotNullParameter(r101, "rechargeParams");
        HashMap r102 = new HashMap();
        String r103 = "";
        if ((r100.getResult() instanceof PayService.b) == false) goto L9;
        Object r104 = r100.getResult();
        if (r104 == null) goto L8;
        String r105 = String.valueOf(((PayService.b) r104).f90281a);
    L11:
        if ((r100.getResult() instanceof PayService.b) == false) goto L17;
        Object r106 = r100.getResult();
        if (r106 == null) goto L16;
        r103 = ((PayService.b) r106).f90282b;
        goto L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.platform.service.PayService.PayResult");
    L17:
        r102.put("failure_type", r105);
        r102.put("failure_msg", r103);
        if ((r100.o() instanceof com.bytedance.android.live.recharge.deal.u) == false) goto L20;
        String r107 = "official";
    L21:
        r102.put("event_module", r107);
        b(r102, r101, new Object[]{rw0.b.class});
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r108 = f.f90457a;
        f.d("livesdk_recharge_fail_toast_show", r102, new Class[]{IRoom.class, x.class});
        return;
    L20:
        r107 = "customized";
        goto L21
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.platform.service.PayService.PayResult");
    L9:
        r105 = "";
        goto L11
    }

    public static void b(HashMap r100, com.bytedance.android.live.recharge.model.d r101, Object... r102) {
        Intrinsics.checkNotNullParameter(r101, "rechargeParams");
        Intrinsics.checkNotNullParameter(r102, "filter");
        if (r100 != null) goto L5;
        return;
    L5:
        qw0.a r103 = (qw0.a) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), qw0.a.class);
        if (r103 == null) goto L13;
        int r104 = r102.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L17;
        rw0.a r106 = r103.Kc(r102[r105]);
        if (r106 == null) goto L12;
        r106.a(r100, r101);
    L12:
        r105 = r105 + 1;
        goto L8
    L17:
        return;
    }

    public static void l(String r100, boolean r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        HashMap r103 = new HashMap();
        r103.put("request_page", "client");
        if (r101 == false) goto L5;
        r103.put("stay_duration", String.valueOf(r102));
    L5:
        f.c(r100, r103);
    }

    public static void e(String r100, int r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        HashMap r104 = new HashMap();
        r104.put("type", r100);
        r104.put("status", String.valueOf(r101));
        r104.put("error_msg", r102);
        r104.put("duration", String.valueOf(r103));
        f.c("livesdk_rd_cj_component_status_all", r104);
    }

    public static void h(String r100, com.bytedance.android.live.recharge.model.d r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "rechargeParams");
        HashMap r104 = new HashMap();
        if (r102 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L11;
        r104.put("balance", r102);
    L11:
        r104.put("available_exchange_diamond", String.valueOf(r103));
        b(r104, r101, new Object[]{rw0.b.class});
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r106 = f.f90457a;
        f.d(r100, r104, new Class[]{IRoom.class, x.class});
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r105 = false;
        goto L9
    }

    public static /* synthetic */ void g(String r100, String r101, String r102, Map r103, com.bytedance.android.live.recharge.model.d r110) {
        f(r100, r101, r102, "", r103, r110);
    }

    public static void m(String r100, String r101, String r102, Map r103, com.bytedance.android.live.recharge.model.d r110) {
        Intrinsics.checkNotNullParameter("livesdk_recharge_page_pay_click", "eventName");
        Intrinsics.checkNotNullParameter(r100, "money");
        Intrinsics.checkNotNullParameter("", "payMethod");
        Intrinsics.checkNotNullParameter(r101, "eventModule");
        Intrinsics.checkNotNullParameter(r102, "moneyPaid");
        Intrinsics.checkNotNullParameter(r110, "rechargeParams");
        HashMap r104 = new HashMap();
        r104.put("event_module", r101);
        r104.put("money", r100);
        if (StringsKt.equals$default(r110.f90023l, "red_envelope", false, 2, null) == false) goto L5;
        r104.put("params_for_special", com.bytedance.android.ec.core.event.a.VALUE_PARAMS_FOR_SPECIAL);
    L5:
        StringsKt.isBlank("");
        r104.put("pay_method", "");
        Iterator r105 = r103.entrySet().iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        Map.Entry r106 = (Map.Entry) r105.next();
        r104.put(r106.getKey(), r106.getValue());
        goto L7
    L9:
        r104.put("money_paid", r102);
        a(r104, r110);
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r107 = f.f90457a;
        f.d("livesdk_recharge_page_pay_click", r104, new Class[]{IRoom.class, x.class});
        com.bytedance.android.live.recharge.trace.g r108 = com.bytedance.android.live.recharge.trace.f.f90392a;
        com.bytedance.android.live.recharge.trace.f.a(RechargeTraceStep.STEP_PAY_CLICK, r104);
    }

    public static /* synthetic */ void p(com.bytedance.android.live.revenue.core.a r100, String r101, String r110, Integer r111, com.bytedance.android.live.recharge.model.d r112) {
        o(r100, r101, "", r110, "", r111, null, r112);
    }

    public static void f(String r100, String r101, String r102, String r103, Map r104, com.bytedance.android.live.recharge.model.d r105) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "money");
        Intrinsics.checkNotNullParameter(r102, "eventModule");
        Intrinsics.checkNotNullParameter(r103, "moneyPaid");
        Intrinsics.checkNotNullParameter(r105, "rechargeParams");
        HashMap r106 = new HashMap();
        r106.put("event_module", r102);
        r106.put("money", r101);
        r106.put("money_paid", r103);
        String r107 = r105.f90023l;
        if (r107 != null) goto L5;
    L7:
        if (r104 == null) goto L10;
        r106.putAll(r104);
    L10:
        if (Intrinsics.areEqual(r100, "livesdk_recharge_show") == false) goto L12;
        RechargeCurrentCacheData r108 = ((IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class)).getCurrentRechargeCacheDataObject();
        r108.setLivesdkRechargeShow(r108.getLivesdkRechargeShow() + 1);
        r108.setChargeSceneCode(r105.f90019h);
        r108.setChargeReasonCode(r105.f90013b);
        r108.setRequestPageCode(r105.f90014c);
        r106.put("live_realtime_feature", GsonProtectorUtils.toJson(new Gson(), r108));
    L12:
        a(r106, r105);
        n.c(r106);
        n.b(r106);
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r109 = f.f90457a;
        f.d(r100, r106, new Class[]{IRoom.class, x.class});
        return;
    L5:
        if (r107.equals("red_envelope") != true) goto L7;
        r106.put("params_for_special", com.bytedance.android.ec.core.event.a.VALUE_PARAMS_FOR_SPECIAL);
        goto L7
    }

    public static void o(com.bytedance.android.live.revenue.core.a r100, String r101, String r102, String r103, String r104, Integer r105, Long r106, com.bytedance.android.live.recharge.model.d r110) {
        Intrinsics.checkNotNullParameter(r100, "revenueInstance");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "money");
        Intrinsics.checkNotNullParameter(r103, "eventModule");
        Intrinsics.checkNotNullParameter(r104, "moneyPaid");
        Intrinsics.checkNotNullParameter(r110, "rechargeParams");
        HashMap r107 = new HashMap();
        r107.put("event_module", r103);
        r107.put("money", r102);
        r107.put("money_paid", r104);
        if (r105 != null) goto L6;
    L8:
        String r108 = "normal";
    L9:
        r107.put(ShareConstants.KEY_PANEL_TYPE, r108);
        if (r105 == null) goto L12;
        r107.put("is_first_recharge", String.valueOf(r105.intValue()));
    L12:
        if (r106 == null) goto L14;
        r107.put("given_scores", String.valueOf(r106.longValue()));
    L14:
        a(r107, r110);
        n01.a r109 = (n01.a) com.bytedance.android.live.revenue.core.util.f.c(r100, n01.a.class);
        if (r109 == null) goto L20;
        es2.a r111 = r109.E0();
        if (r111 == null) goto L21;
        r111.sendLog(r101, r107);
        return;
    L21:
        return;
    L20:
        return;
    L6:
        if (r105.intValue() != 1) goto L8;
        r108 = "first_recharge";
        goto L9
    }

    public static void n(String r100, String r101, String r102, String r103, long r104, long r105, long r106, int r110, String r111, String r112, String r113, int r114) {
        if ((r114 & 1024) == 0) goto L5;
        r113 = "";
    L5:
        Intrinsics.checkNotNullParameter(r100, "callerSource");
        Intrinsics.checkNotNullParameter(r101, "requestPage");
        Intrinsics.checkNotNullParameter(r102, "enterFrom");
        Intrinsics.checkNotNullParameter(r103, "chargeReason");
        Intrinsics.checkNotNullParameter(r111, "promotionSource");
        Intrinsics.checkNotNullParameter(r112, "urlPath");
        Intrinsics.checkNotNullParameter(r113, "extraString");
        Map r107 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("request_page", r101), TuplesKt.to("enter_from", r102), TuplesKt.to("charge_reason", r103), TuplesKt.to("money_diff", String.valueOf(r104)), TuplesKt.to(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, String.valueOf(r105)), TuplesKt.to("gift_money", String.valueOf(r106)), TuplesKt.to("business_scene", String.valueOf(r110)), TuplesKt.to(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, r111), TuplesKt.to("caller_url_path", r112), TuplesKt.to("caller_source", r100), TuplesKt.to("extra_string", r113)});
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r108 = f.f90457a;
        f.d("livesdk_recharge_show_from_jsb", r107, new Class[]{IRoom.class, x.class});
    }
}
