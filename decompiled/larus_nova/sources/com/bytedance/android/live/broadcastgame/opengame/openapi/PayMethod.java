package com.bytedance.android.live.broadcastgame.opengame.openapi;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifyRiskSmsVM;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.broadcastgame.opengame.network.AudienceGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.IRechargeServiceExternal;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class PayMethod extends BaseOpenMethod<JSONObject> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DataCenter f60312h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Integer> f60313i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f60314j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Context f60315k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Dialog f60316l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f60317m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final g0 f60318n;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PayMethod f60319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f60320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f60321c;

        public b(PayMethod r100, long r101, String r102) {
            this.f60319a = r100;
            this.f60320b = r101;
            this.f60321c = r102;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
            int r102 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"confirm pay"});
            OpenPlatformMonitorService r103 = (OpenPlatformMonitorService) this.f60319a.f60306d.o(OpenPlatformMonitorService.class);
            this.f60319a.getClass();
            OpenPlatformMonitorService.k(r103, "payDiamonds", 0);
            int r104 = x10.f.f562110a;
            x10.f.c(this.f60319a.f60306d, 2, null, 28);
            PayMethod r105 = this.f60319a;
            Context r106 = r105.f60315k;
            if (r106 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        L5:
            String r107 = s1.C(R.string.ttlive_open_platform_paying_diamond, new Object[]{r3.c()});
            com.bytedance.android.livesdk.widget.e1 r108 = new com.bytedance.android.livesdk.widget.e1((Activity) r106);
            r108.f161694c = r107;
            r105.f60316l = r108;
            Dialog r109 = this.f60319a.f60316l;
            if (r109 != null) goto L8;
        L12:
            PayMethod r110 = this.f60319a;
            long r111 = this.f60320b;
            String r112 = this.f60321c;
            r110.getClass();
            int r113 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"create order id"});
            Lazy r114 = LiveOpenGameClient.f60290d;
            AudienceGameNetApi r115 = (AudienceGameNetApi) LiveOpenGameClient.a.a().a(AudienceGameNetApi.class);
            g0 r116 = r110.f60318n;
            r110.j(r115.createOrderId(r116.f60471a, r116.f60472b).compose(new x10.c(r110.f60306d, "/webcast/openapi/business/order/gen_id/")).subscribe(new i0(r110, r111, r112), new j0(r110)));
            int r117 = com.bytedance.android.live.broadcastgame.api.interactgame.n.f59316a;
            g0 r118 = this.f60319a.f60318n;
            com.bytedance.android.live.broadcastgame.api.interactgame.n.h(r118.f60476f, String.valueOf(r118.f60475e), ((IUserService) jc1.k.n(IUserService.class)).user().n(), "confirm");
            return;
        L8:
            if (DialogLancet.shouldBlockDialogShow(r109) == false) goto L15;
            DialogLancet.handleBlockedDialogShow(r109);
            goto L12
        L15:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
        L11:
            DialogLancet.beforeDialogShow(r109);
            r109.show();
            DialogLancet.afterDialogShow(r109);
            goto L12
        }
    }

    public static final class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PayMethod f60322a;

        public c(PayMethod r100) {
            this.f60322a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            PayMethod r102 = this.f60322a;
            OpenApiErrorInfo r103 = OpenApiErrorInfo.PAY_CANCEL;
            r102.y(r103);
            r100.dismiss();
            int r104 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"cancel pay"});
            OpenPlatformMonitorService r105 = (OpenPlatformMonitorService) this.f60322a.f60306d.o(OpenPlatformMonitorService.class);
            this.f60322a.getClass();
            OpenPlatformMonitorService.k(r105, "payDiamonds", 1);
            int r106 = x10.f.f562110a;
            x10.f.c(this.f60322a.f60306d, 2, r103, 24);
            int r107 = com.bytedance.android.live.broadcastgame.api.interactgame.n.f59316a;
            g0 r108 = this.f60322a.f60318n;
            com.bytedance.android.live.broadcastgame.api.interactgame.n.h(r108.f60476f, String.valueOf(r108.f60475e), ((IUserService) jc1.k.n(IUserService.class)).user().n(), "cancel");
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "payDiamonds";
    }

    public final void x() {
        UtilityKotlinExtentionsKt.s(0, false, false, new PayMethod$hideLoadingDialog$1(this), 7);
    }

    public static final void w(PayMethod r210) {
        r210.getClass();
        int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"show recharge dialog, order id: " + r210.f60314j});
        Context r101 = r210.f60315k;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L5:
        Activity r102 = ContextUtil.contextToActivity(r101);
        if (r102 != null) goto L8;
        return;
    L8:
        if ((r102 instanceof FragmentActivity) == true) goto L10;
        r102 = null;
    L10:
        FragmentActivity r103 = (FragmentActivity) r102;
        if (r103 == null) goto L17;
        com.bytedance.android.live.recharge.model.d r104 = new com.bytedance.android.live.recharge.model.d(true, "jsb_pay_method", null, 0, true, 0, 0, "openapi", NotificationCompat.CATEGORY_CALL, null, null, null, null, 32364);
        if (r210.f60312h == null) goto L18;
        ((IRechargeServiceExternal) jc1.k.n(IRechargeServiceExternal.class)).showRechargeDialogFragment(r103, r104, null);
        return;
    L18:
        return;
    }

    public final void y(OpenApiErrorInfo r100) {
        x();
        f2.c(s1.C(R.string.ttlive_open_platform_paid_result_fail, new Object[]{r3.c()}), 0);
        n(r100, null);
        this.f60317m = false;
    }

    public static final void u(final PayMethod r110, Throwable r111) {
        r110.x();
        String r100 = null;
        if ((r111 instanceof CustomApiServerException) == true) goto L5;
        Throwable r101 = null;
    L6:
        CustomApiServerException r102 = (CustomApiServerException) r101;
        if (r102 != null) goto L26;
        f2.c(s1.C(R.string.ttlive_open_platform_paid_result_fail, new Object[]{r3.c()}), 0);
    L24:
        r110.o(r111);
        r110.f60317m = false;
        return;
    L26:
        JsonElement r103 = GsonHelper.parser().parse(r102.getExtra());     // Catch: Exception -> L22
        if (r103 == null) goto L16;
        JsonObject r104 = r103.getAsJsonObject();     // Catch: Exception -> L22
        if (r104 == null) goto L16;
        JsonElement r105 = r104.get("control_content_msg");     // Catch: Exception -> L22
        if (r105 == null) goto L16;
        String r106 = r105.getAsString();     // Catch: Exception -> L22
        if (r106 == null) goto L16;
    L17:
        JsonObject r107 = GsonHelper.parser().parse(r106).getAsJsonObject();     // Catch: Exception -> L22
        final com.bytedance.android.livesdk.wrds.interact.a.b r108 = (com.bytedance.android.livesdk.wrds.interact.a.b) GsonHelper.get().fromJson(r107, com.bytedance.android.livesdk.wrds.interact.a.b.class);     // Catch: Exception -> L22
        JsonElement r109 = r107.get(UnifyPreVerifyRiskSmsVM.KEY_TOAST_MSG);     // Catch: Exception -> L22
        if (r109 == null) goto L20;
        r100 = r109.getAsString();     // Catch: Exception -> L22
    L20:
        r108.f162524a = r100;     // Catch: Exception -> L22
        int r112 = GameDataReportHelper.f59290a;     // Catch: Exception -> L22
        g0 r113 = r110.f60318n;     // Catch: Exception -> L22
        GameDataReportHelper.g(r113.f60476f, String.valueOf(r113.f60475e), r108.a(), ((BootInfoService) r110.f60306d.o(BootInfoService.class)).e(), r110.f60306d.f60811o);     // Catch: Exception -> L22
        UtilityKotlinExtentionsKt.s(0, false, false, new PayMethod$payFail$$inlined$let$lambda$1(r108, r110), 7);     // Catch: Exception -> L22
    L16:
        r106 = "";
    L22:
        f2.c(s1.C(R.string.ttlive_open_platform_paid_result_fail, new Object[]{r3.c()}), 0);
        goto L24
    L5:
        r101 = r111;
        goto L6
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r110, CallContext r111) {
        Intrinsics.checkNotNullParameter(r110, "json");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f60315k = this.f60306d.i();
        int r112 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"on call, params: " + r110});
        int r100 = x10.f.f562110a;
        x10.f.c(this.f60306d, 0, null, 28);
        if (this.f60317m == false) goto L6;
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethod", new Object[]{"pay not finished"});
        OpenPlatformMonitorService.j((OpenPlatformMonitorService) this.f60306d.o(OpenPlatformMonitorService.class), "payDiamonds", 1);
        PluginContext r113 = this.f60306d;
        OpenApiErrorInfo r101 = OpenApiErrorInfo.EXCEED_FREQ_LIMIT;
        x10.f.c(r113, 1, r101, 24);
        y(r101);
        return;
    L6:
        this.f60317m = true;
        long r102 = r110.optLong("diamonds");
        String r114 = r110.optString("tag");
        if (r102 < 1) goto L21;
        if (r114 != null) goto L10;
    L13:
        boolean r103 = true;
    L14:
        if (r103 == true) goto L21;
        OpenPlatformMonitorService.j((OpenPlatformMonitorService) this.f60306d.o(OpenPlatformMonitorService.class), "payDiamonds", 0);
        x10.f.c(this.f60306d, 1, null, 28);
        Context r104 = this.f60315k;
        if (r104 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L19:
        com.bytedance.android.livesdk.widget.x0.b r105 = new com.bytedance.android.livesdk.widget.x0.b(r104, 4);
        r105.f162238a.f162245d = s1.C(R.string.ttlive_open_platform_pay, new Object[]{Long.valueOf(r102), r3.c()});
        r105.i(0, R.string.ttlive_open_platform_pay_confirm, new b(this, r102, r114));
        r105.k(0, true);
        r105.i(1, R.string.ttlive_text_cancel, new c(this));
        r105.n();
        return;
    L10:
        if (r114.length() == 0) goto L13;
        r103 = false;
    L21:
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"invalid params"});
        OpenPlatformMonitorService.j((OpenPlatformMonitorService) this.f60306d.o(OpenPlatformMonitorService.class), "payDiamonds", 1);
        PluginContext r115 = this.f60306d;
        OpenApiErrorInfo r106 = OpenApiErrorInfo.INCORRECT_PARAMS;
        x10.f.c(r115, 1, r106, 24);
        y(r106);
    }

    public final void z(OpenApiErrorInfo r100, int r101) {
        x();
        f2.c(s1.C(r101, new Object[]{r3.c()}), 0);
        this.f60317m = false;
        n(r100, null);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r100, CallContext r101) {
        call2(r100, r101);
    }

    public PayMethod(PluginContext r100, g0 r101, Queue<Long> r102) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        Intrinsics.checkNotNullParameter(r101, "openApi");
        super(r100, r102);
        this.f60318n = r101;
        this.f60312h = r100.f60805i;
        this.f60313i = CollectionsKt.mutableListOf(new Integer[]{10011, 4014044, 10001, 4014016, 400001, 4014048});
        this.f60314j = "";
    }

    public static final void s(PayMethod r100, long r101, int r102) {
        r100.getClass();
        int r103 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"fetch order status, order id: ", r100.f60314j, ", diamonds: ", Long.valueOf(r101), ", query times: ", Integer.valueOf(r102)});
        if (r102 > 0) goto L5;
        OpenApiErrorInfo r104 = OpenApiErrorInfo.UNKNOWN_ORDER_STATUS;
        r100.z(r104, R.string.ttlive_open_platform_paid_result_unknown);
        int r105 = x10.f.f562110a;
        x10.f.b(r100.f60306d, 4, r104, null, -1);
        return;
    L5:
        Lazy r106 = LiveOpenGameClient.f60290d;
        AudienceGameNetApi r107 = (AudienceGameNetApi) LiveOpenGameClient.a.a().a(AudienceGameNetApi.class);
        g0 r108 = r100.f60318n;
        r100.j(r107.queryOrderStatus(r108.f60471a, r100.f60314j, r108.f60472b).compose(new x10.c(r100.f60306d, "/webcast/openapi/business/diamond/query/")).delaySubscription(200, TimeUnit.MILLISECONDS).subscribe(new k0(r100, r101, r102), new l0(r100, r101, r102)));
    }

    public static final void v(PayMethod r100, long r101, String r102) {
        r100.x();
        f2.c(s1.C(R.string.ttlive_open_platform_paid_result_success, new Object[]{Long.valueOf(r101), r3.c()}), 0);
        JSONObject r103 = new JSONObject();
        r103.put("orderId", r102);
        Unit r104 = Unit.INSTANCE;
        r100.r(r103);
        r100.f60317m = false;
        OpenPlatformMonitorService r105 = (OpenPlatformMonitorService) r100.f60306d.o(OpenPlatformMonitorService.class);
        Intrinsics.checkNotNullParameter("payDiamonds", com.alipay.sdk.m.p.e.f25671s);
        OpenPlatformMonitorService.p(r105, "payDiamonds", "ttlive_open_platform_pay_success", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 48).c();
        int r106 = x10.f.f562110a;
        x10.f.c(r100.f60306d, 4, null, 28);
        DataCenter r107 = r100.f60306d.f60805i;
        if (r107 == null) goto L6;
        r107.put("key_live_game_pay_success", null);
        return;
    }

    public static final void t(PayMethod r110, String r111, long r112, String r210) {
        r110.getClass();
        Lazy r100 = LiveOpenGameClient.f60290d;
        AudienceGameNetApi r101 = (AudienceGameNetApi) LiveOpenGameClient.a.a().a(AudienceGameNetApi.class);
        g0 r102 = r110.f60318n;
        String r103 = r102.f60471a;
        long r104 = r102.f60472b;
        JSONObject r105 = new JSONObject();
        com.bytedance.android.livesdk.log.filter.o r106 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r107 = com.bytedance.android.livesdk.log.l0.a("enter_from_merge", r106);
        String r108 = com.bytedance.android.livesdk.log.l0.a("enter_method", r106);
        String r109 = com.bytedance.android.livesdk.log.l0.a("action_type", r106);
        boolean r113 = false;
        if (r107.length() <= 0) goto L5;
        boolean r114 = true;
    L6:
        if (r114 == false) goto L9;
        r105.put("enter_from_merge", r107);
    L9:
        if (r108.length() <= 0) goto L11;
        boolean r115 = true;
    L12:
        if (r115 == false) goto L15;
        r105.put("enter_method", r108);
    L15:
        if (r109.length() <= 0) goto L17;
        r113 = true;
    L17:
        if (r113 == false) goto L20;
        r105.put("action_type", r109);
    L20:
        if (r110.f60306d.f60805i == null) goto L22;
        r105.put("live_room_type", com.bytedance.android.live.broadcastgame.api.interactgame.j.a());
    L22:
        r110.j(r101.payDiamond(r103, r104, r111, r112, r210, r105.toString()).compose(new x10.c(r110.f60306d, "/webcast/openapi/business/diamond/pay/")).compose(RxUtil.rxSchedulerHelper()).subscribe(new m0(r110, r111, r112), new n0(r110, r111, r112, r210)));
        return;
    L11:
        r115 = false;
        goto L12
    L5:
        r114 = false;
        goto L6
    }
}
