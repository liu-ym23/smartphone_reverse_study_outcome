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
public final class p0 extends BaseOpenMethod<JSONObject> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Integer> f60532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f60533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f60534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Dialog f60535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final g0 f60536l;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p0 f60537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f60538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f60539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f60540d;

        public b(p0 r100, String r101, long r102, String r103) {
            this.f60537a = r100;
            this.f60538b = r101;
            this.f60539c = r102;
            this.f60540d = r103;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
            int r102 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"confirm pay"});
            OpenPlatformMonitorService r103 = (OpenPlatformMonitorService) this.f60537a.f60306d.o(OpenPlatformMonitorService.class);
            this.f60537a.getClass();
            OpenPlatformMonitorService.k(r103, "payDiamondsV3", 0);
            int r104 = x10.f.f562110a;
            x10.f.e(this.f60537a.f60306d, 2, null, 28);
            p0 r105 = this.f60537a;
            Context r106 = r105.f60533i;
            if (r106 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        L5:
            String r107 = s1.C(R.string.ttlive_open_platform_paying_diamond, new Object[]{r3.c()});
            com.bytedance.android.livesdk.widget.e1 r108 = new com.bytedance.android.livesdk.widget.e1((Activity) r106);
            r108.f161694c = r107;
            r105.f60535k = r108;
            Dialog r109 = this.f60537a.f60535k;
            if (r109 != null) goto L8;
        L12:
            p0.t(this.f60537a, this.f60538b, this.f60539c, this.f60540d);
            int r110 = com.bytedance.android.live.broadcastgame.api.interactgame.n.f59316a;
            g0 r111 = this.f60537a.f60536l;
            com.bytedance.android.live.broadcastgame.api.interactgame.n.h(r111.f60476f, String.valueOf(r111.f60475e), ((IUserService) jc1.k.n(IUserService.class)).user().n(), "confirm");
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
        public final /* synthetic */ p0 f60541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f60542b;

        public c(p0 r100, String r101) {
            this.f60541a = r100;
            this.f60542b = r101;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
            p0 r102 = this.f60541a;
            OpenApiErrorInfo r103 = OpenApiErrorInfo.PAY_CANCEL;
            p0.x(r102, r103, this.f60542b);
            int r104 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"cancel pay"});
            OpenPlatformMonitorService r105 = (OpenPlatformMonitorService) this.f60541a.f60306d.o(OpenPlatformMonitorService.class);
            this.f60541a.getClass();
            OpenPlatformMonitorService.k(r105, "payDiamondsV3", 1);
            int r106 = x10.f.f562110a;
            x10.f.e(this.f60541a.f60306d, 2, r103, 24);
            int r107 = com.bytedance.android.live.broadcastgame.api.interactgame.n.f59316a;
            g0 r108 = this.f60541a.f60536l;
            com.bytedance.android.live.broadcastgame.api.interactgame.n.h(r108.f60476f, String.valueOf(r108.f60475e), ((IUserService) jc1.k.n(IUserService.class)).user().n(), "cancel");
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "payDiamondsV3";
    }

    public static final void v(p0 r210, String r211) {
        r210.getClass();
        int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"show recharge dialog, order id: " + r211});
        Context r101 = r210.f60533i;
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
        if (r210.f60306d.f60805i == null) goto L18;
        ((IRechargeServiceExternal) jc1.k.n(IRechargeServiceExternal.class)).showRechargeDialogFragment(r103, r104, null);
        return;
    L18:
        return;
    }

    public static void y(final p0 r110, Throwable r111) {
        r110.getClass();
        UtilityKotlinExtentionsKt.s(0, false, false, new PayMethodV3$hideLoadingDialog$1(r110), 7);
        String r100 = null;
        if ((r111 instanceof CustomApiServerException) == true) goto L5;
        Throwable r101 = null;
    L6:
        CustomApiServerException r102 = (CustomApiServerException) r101;
        final int r103 = R.string.ttlive_open_platform_paid_result_fail;
        if (r102 != null) goto L26;
        f2.c(s1.C(R.string.ttlive_open_platform_paid_result_fail, new Object[]{r3.c()}), 0);
    L24:
        r110.o(r111);
        r110.f60534j = false;
        return;
    L26:
        JsonElement r104 = GsonHelper.parser().parse(r102.getExtra());     // Catch: Exception -> L22
        if (r104 == null) goto L16;
        JsonObject r105 = r104.getAsJsonObject();     // Catch: Exception -> L22
        if (r105 == null) goto L16;
        JsonElement r106 = r105.get("control_content_msg");     // Catch: Exception -> L22
        if (r106 == null) goto L16;
        String r107 = r106.getAsString();     // Catch: Exception -> L22
        if (r107 == null) goto L16;
    L17:
        JsonObject r108 = GsonHelper.parser().parse(r107).getAsJsonObject();     // Catch: Exception -> L22
        final com.bytedance.android.livesdk.wrds.interact.a.b r109 = (com.bytedance.android.livesdk.wrds.interact.a.b) GsonHelper.get().fromJson(r108, com.bytedance.android.livesdk.wrds.interact.a.b.class);     // Catch: Exception -> L22
        JsonElement r112 = r108.get(UnifyPreVerifyRiskSmsVM.KEY_TOAST_MSG);     // Catch: Exception -> L22
        if (r112 == null) goto L20;
        r100 = r112.getAsString();     // Catch: Exception -> L22
    L20:
        r109.f162524a = r100;     // Catch: Exception -> L22
        int r113 = GameDataReportHelper.f59290a;     // Catch: Exception -> L22
        g0 r114 = r110.f60536l;     // Catch: Exception -> L22
        GameDataReportHelper.g(r114.f60476f, String.valueOf(r114.f60475e), r109.a(), ((BootInfoService) r110.f60306d.o(BootInfoService.class)).e(), r110.f60306d.f60811o);     // Catch: Exception -> L22
        UtilityKotlinExtentionsKt.s(0, false, false, new PayMethodV3$payFail$$inlined$let$lambda$1(r109, r110, r103), 7);     // Catch: Exception -> L22
    L16:
        r107 = "";
    L22:
        f2.c(s1.C(R.string.ttlive_open_platform_paid_result_fail, new Object[]{r3.c()}), 0);
        goto L24
    L5:
        r101 = r111;
        goto L6
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r110, CallContext r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f60533i = this.f60306d.i();
        int r112 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"on call, params: " + r110});
        int r100 = x10.f.f562110a;
        x10.f.e(this.f60306d, 0, null, 28);
        long r101 = r110.optLong("diamonds");
        String r113 = r110.optString("tag");
        String r114 = r110.optString("orderId");
        if (this.f60534j == false) goto L6;
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethodV3", new Object[]{"pay not finished"});
        OpenPlatformMonitorService.j((OpenPlatformMonitorService) this.f60306d.o(OpenPlatformMonitorService.class), "payDiamondsV3", 1);
        PluginContext r102 = this.f60306d;
        OpenApiErrorInfo r103 = OpenApiErrorInfo.EXCEED_FREQ_LIMIT;
        x10.f.e(r102, 1, r103, 24);
        w(r103, r114, R.string.ttlive_open_platform_paid_result_fail);
        return;
    L6:
        this.f60534j = true;
        if (r101 < 1) goto L28;
        if (r113 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L28;
        if (r114 != null) goto L17;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == true) goto L28;
        OpenPlatformMonitorService.j((OpenPlatformMonitorService) this.f60306d.o(OpenPlatformMonitorService.class), "payDiamondsV3", 0);
        x10.f.e(this.f60306d, 1, null, 28);
        Context r106 = this.f60533i;
        if (r106 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L26:
        com.bytedance.android.livesdk.widget.x0.b r107 = new com.bytedance.android.livesdk.widget.x0.b(r106, 4);
        r107.f162238a.f162245d = s1.C(R.string.ttlive_open_platform_pay, new Object[]{Long.valueOf(r101), r3.c()});
        r107.i(0, R.string.ttlive_open_platform_pay_confirm, new b(this, r114, r101, r113));
        r107.k(0, true);
        r107.i(1, R.string.ttlive_text_cancel, new c(this, r114));
        r107.n();
        return;
    L17:
        if (r114.length() == 0) goto L20;
        r105 = false;
        goto L21
    L10:
        if (r113.length() == 0) goto L13;
        r104 = false;
    L28:
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"invalid params"});
        OpenPlatformMonitorService.j((OpenPlatformMonitorService) this.f60306d.o(OpenPlatformMonitorService.class), "payDiamondsV3", 1);
        PluginContext r108 = this.f60306d;
        OpenApiErrorInfo r109 = OpenApiErrorInfo.INCORRECT_PARAMS;
        x10.f.e(r108, 1, r109, 24);
        w(r109, r114, R.string.ttlive_open_platform_paid_result_fail);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r100, CallContext r101) {
        call2(r100, r101);
    }

    public p0(PluginContext r100, g0 r101, Queue<Long> r102) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        Intrinsics.checkNotNullParameter(r101, "openApi");
        super(r100, r102);
        this.f60536l = r101;
        this.f60532h = CollectionsKt.mutableListOf(new Integer[]{10011, 4014044, 10001, 4014016, 400001, 4014048, 41104, 4005238});
    }

    public static final void u(p0 r100, long r101, String r102) {
        r100.getClass();
        UtilityKotlinExtentionsKt.s(0, false, false, new PayMethodV3$hideLoadingDialog$1(r100), 7);
        f2.c(s1.C(R.string.ttlive_open_platform_paid_result_success, new Object[]{Long.valueOf(r101), r3.c()}), 0);
        JSONObject r103 = new JSONObject();
        r103.put("orderId", r102);
        r103.put("pay_status", 2);
        r103.put("payStatus", 2);
        Unit r104 = Unit.INSTANCE;
        r100.r(r103);
        r100.f60534j = false;
        OpenPlatformMonitorService r105 = (OpenPlatformMonitorService) r100.f60306d.o(OpenPlatformMonitorService.class);
        Intrinsics.checkNotNullParameter("payDiamondsV3", com.alipay.sdk.m.p.e.f25671s);
        OpenPlatformMonitorService.p(r105, "payDiamondsV3", "ttlive_open_platform_pay_success", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 48).c();
        int r106 = x10.f.f562110a;
        x10.f.e(r100.f60306d, 4, null, 28);
        DataCenter r107 = r100.f60306d.f60805i;
        if (r107 == null) goto L6;
        r107.put("key_live_game_pay_success", null);
        return;
    }

    public static /* synthetic */ void x(p0 r100, OpenApiErrorInfo r101, String r102) {
        r100.w(r101, r102, R.string.ttlive_open_platform_paid_result_fail);
    }

    public final void w(OpenApiErrorInfo r100, String r101, int r102) {
        UtilityKotlinExtentionsKt.s(0, false, false, new PayMethodV3$hideLoadingDialog$1(this), 7);
        f2.c(s1.C(r102, new Object[]{r3.c()}), 0);
        this.f60534j = false;
        JSONObject r103 = new JSONObject();
        r103.put("orderId", r101);
        Unit r104 = Unit.INSTANCE;
        BaseOpenMethod.q(this, r103, r100);
    }

    public static final void s(p0 r100, long r110, String r111, int r112) {
        r100.getClass();
        int r101 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"fetch order status, order id: ", r111, ", diamonds: ", Long.valueOf(r110), ", query times: ", Integer.valueOf(r112)});
        if (r112 > 0) goto L5;
        OpenApiErrorInfo r113 = OpenApiErrorInfo.UNKNOWN_ORDER_STATUS;
        r100.w(r113, r111, R.string.ttlive_open_platform_paid_result_unknown);
        int r114 = x10.f.f562110a;
        x10.f.d(r100.f60306d, 4, r113, null, -1);
        return;
    L5:
        Lazy r102 = LiveOpenGameClient.f60290d;
        AudienceGameNetApi r103 = (AudienceGameNetApi) LiveOpenGameClient.a.a().a(AudienceGameNetApi.class);
        g0 r104 = r100.f60536l;
        r100.j(r103.queryOrderStatus(r104.f60471a, r111, r104.f60472b).compose(new x10.c(r100.f60306d, "/webcast/openapi/business/diamond/query/")).delaySubscription(200, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new q0(r100, r110, r111, r112), new r0(r100, r111, r110, r112)));
    }

    public static final void t(p0 r110, String r111, long r112, String r210) {
        r110.getClass();
        Lazy r100 = LiveOpenGameClient.f60290d;
        AudienceGameNetApi r101 = (AudienceGameNetApi) LiveOpenGameClient.a.a().a(AudienceGameNetApi.class);
        g0 r102 = r110.f60536l;
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
        r110.j(r101.payDiamondV3(r103, r104, r111, r112, r210, r105.toString()).compose(new x10.c(r110.f60306d, "/webcast/openapi/business/order/pay/")).compose(RxUtil.rxSchedulerHelper()).subscribe(new s0(r110, r111, r112), new t0(r110, r111, r112, r210)));
        return;
    L11:
        r115 = false;
        goto L12
    L5:
        r114 = false;
        goto L6
    }
}
