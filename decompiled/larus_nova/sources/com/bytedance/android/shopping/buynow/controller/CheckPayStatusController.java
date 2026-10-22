package com.bytedance.android.shopping.buynow.controller;

import android.content.Context;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.ObservableRetryWhenCompat;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.android.shopping.buynow.data.model.BuyNowShape;
import com.bytedance.android.shopping.buynow.data.model.BuyNowUrlType;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import com.bytedance.android.shopping.buynow.data.model.GoodsType;
import com.bytedance.android.shopping.buynow.data.model.PayShowType;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowOrderNode;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.utils.l0;
import com.bytedance.android.shopping.yata.business.function.common.TTPay;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class CheckPayStatusController {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f170803j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ma3.o f170804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, ? extends Object> f170805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f170806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f170807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f170808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BuyNowFragment f170809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ia3.b f170810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.ec.core.async.b f170811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final pa3.a f170812i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/buynow/controller/CheckPayStatusController$QueryPayStatusException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "logId", "", "(Ljava/lang/String;)V", "getLogId", "()Ljava/lang/String;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class QueryPayStatusException extends RuntimeException {
        private final String logId;

        public final String getLogId() {
            return this.logId;
        }

        public QueryPayStatusException(String r100) {
            this.logId = r100;
        }
    }

    public static final class a {
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CheckPayStatusController f170813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f170814b;

        public b(CheckPayStatusController r100, String r101) {
            this.f170813a = r100;
            this.f170814b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            CheckPayStatusController r100 = this.f170813a;
            f.b(r100.f170808e, this.f170814b, r100.f170809f);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CheckPayStatusController f170815a;

        public c(CheckPayStatusController r100) {
            this.f170815a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            com.bytedance.android.shopping.buynow.monitor.error.a.b(this.f170815a.f170809f.W90().getTracker(), "runtime_error", "error closing buy_now page");
        }
    }

    static {
    }

    public final void d() {
        ECLiveHybridUtil.f("orderSubmitCompleted", new JSONObject());
        ma3.o r100 = this.f170804a;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.e();
    L7:
        if (r102 != null) goto L10;
    L15:
        BtmSDK r103 = BtmSDK.INSTANCE;
        if (this.f170809f.W90().getStaticState().b() == false) goto L18;
        String r104 = "a1.b25587.c5642.d1959";
    L19:
        r103.willJumpToNextPage(new BtmItemBuilder(r104, null, 2, null).withPageFinder(this.f170809f.W90().getStaticState().f171230d).setTargetPagesBtm(CollectionsKt.listOf(new String[]{"a1.b2298.c0.d0", "a1.b4943.c0.d0", "a1.b31.c0.d0", "a1.b32.c0.d0", "a1.b6871.c0.d0"})).build());
        ma3.o r105 = this.f170804a;
        if (r105 == null) goto L22;
        String r106 = r105.b();
    L23:
        com.bytedance.android.ec.core.hybrid.utils.r.a(r106, this.f170809f.requireActivity());
        com.bytedance.android.shopping.buynow.tracker.a r107 = this.f170809f.W90().getTracker();
        ma3.o r108 = this.f170804a;
        if (r108 == null) goto L26;
        r101 = r108.b();
    L26:
        r107.getClass();
        r107.b("trade_checkpoint", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", CheckPointType.GOTO_PAGE), TuplesKt.to("target_schema", r101)}));
        return;
    L22:
        r106 = null;
        goto L23
    L18:
        r104 = "a1.b7411.c5642.d1959";
        goto L19
    L10:
        if (r102.hashCode() != (-1594640105)) goto L15;
        if (r102.equals(BuyNowUrlType.XTAB_MALL_HOMEPAGE) == false) goto L15;
        JSONObject r109 = new JSONObject();
        r109.put("feedTabPause", true);
        r109.put("shouldPauseWithoutAnimation", true);
        Unit r110 = Unit.INSTANCE;
        ECLiveHybridUtil.f("closeInnerHalfPanel", r109);
        JSONObject r111 = new JSONObject();
        r111.put("feedTabPause", true);
        r111.put("unPlay", true);
        ECLiveHybridUtil.f("closePDPHalfPanel", r111);
        goto L15
    L5:
        r102 = null;
        goto L7
    }

    public final boolean e() {
        nl.c r100 = this.f170809f.W90().getStaticState().f171227a;
        if (r100 == null) goto L5;
        String r101 = r100.getQueryParam("enter_from");
    L7:
        return Intrinsics.areEqual(r101, "confirm_order");
    L5:
        r101 = null;
        goto L7
    }

    public final void c(String r100) {
        com.bytedance.android.ec.core.async.a.a(Completable.timer(400, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new b(this, r100), new c(this)), this.f170811h);
    }

    public static final void a(final CheckPayStatusController r210, boolean r211, int r212) {
        ma3.o r100 = r210.f170804a;
        Object r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.e();
    L7:
        if (Intrinsics.areEqual(r102, "continue_pay_panel") == false) goto L9;
        r210.d();
        return;
    L9:
        int r103 = com.bytedance.android.shopping.buynow.utils.d.f171207a;
        Object r104 = com.bytedance.android.shopping.buynow.utils.d.a(r210.f170809f.W90().getStaticState().f171227a, "create_order_type");
        Object r105 = com.bytedance.android.shopping.buynow.utils.d.a(r210.f170809f.W90().getStaticState().f171227a, "enable_close_event");
        boolean r106 = true;
        if (Intrinsics.areEqual(r104, PayShowType.ONLY_METHOD.getType()) == true) goto L12;
    L14:
        boolean r107 = false;
    L15:
        pa3.a r108 = r210.f170812i;
        if (r108 == null) goto L20;
        com.bytedance.android.shopping.buynow.monitor.order.a r109 = r108.f528358b;
        if (r109 == null) goto L20;
        Map<String, Object> r110 = r210.f170809f.W90().getTracker().f171174d.c();
        BuyNowFragment r111 = r210.f170809f;
        Intrinsics.checkNotNullParameter(r110, "commonEventParams");
        Intrinsics.checkNotNullParameter(r111, WidgetService.PARAM_FRAGMENT);
        r109.f171018e.putAll(r110);
        BtmSDK r112 = BtmSDK.INSTANCE;
        int r113 = com.bytedance.android.shopping.buynow.utils.c.f171206a;
        r109.f171018e.putAll(r112.createReportParams(com.bytedance.android.shopping.buynow.utils.c.a(r111.W90().getStaticState().f171233g), PageFinder.via(r111)));
    L20:
        pa3.a r114 = r210.f170812i;
        if (r114 == null) goto L25;
        com.bytedance.android.shopping.buynow.monitor.order.a r115 = r114.f528358b;
        if (r115 == null) goto L25;
        r115.c("result", Integer.valueOf(r211 ? 1 : 0));
    L25:
        pa3.a r116 = r210.f170812i;
        if (r116 == null) goto L30;
        com.bytedance.android.shopping.buynow.monitor.order.a r117 = r116.f528358b;
        if (r117 == null) goto L30;
        r117.a(BuyNowOrderNode.STANDARD_RENDER_END, System.currentTimeMillis());
    L30:
        pa3.a r118 = r210.f170812i;
        if (r118 == null) goto L35;
        com.bytedance.android.shopping.buynow.monitor.order.a r119 = r118.f528358b;
        if (r119 == null) goto L35;
        r119.a(BuyNowOrderNode.ORDER_CHECK_END, System.currentTimeMillis());
    L35:
        pa3.a r120 = r210.f170812i;
        if (r120 == null) goto L40;
        com.bytedance.android.shopping.buynow.monitor.order.a r121 = r120.f528358b;
        if (r121 == null) goto L40;
        r121.a(BuyNowOrderNode.END, System.currentTimeMillis());
    L40:
        TTCJPayUtils.Companion r122 = TTCJPayUtils.Companion;
        r122.getInstance().externalBizReport("request_end", "ecommerce_pay_desk", System.currentTimeMillis(), "电商查单", null);
        r122.getInstance().externalBizReport("pay_end", "ecommerce_pay_desk", System.currentTimeMillis(), "", null);
        String r123 = "";
        String r124 = "pay_success";
        if (r210.f170809f.W90().getStaticState().b() == false) goto L162;
        if (r210.e() == false) goto L54;
        r210.d();
        if (r211 == false) goto L47;
        String r125 = "pay_success";
    L48:
        r210.c(r125);
        JSONObject r126 = new JSONObject();
        nl.c r127 = r210.f170809f.W90().getStaticState().f171227a;
        if (r127 == null) goto L51;
        String r128 = r127.getQueryParam("pre_session_id");
    L52:
        KtSafeMethodExtensionKt.safePut(r126, "pre_session_id", r128);
        Unit r129 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.continue.check.jump", r126);
        goto L54
    L51:
        r128 = null;
        goto L52
    L47:
        r125 = BuyNowCloseMethod.PAY_FAIL;
    L54:
        if (r211 == false) goto L75;
        nl.c r130 = r210.f170809f.W90().getStaticState().f171227a;
        if (r130 == null) goto L58;
        String r131 = r130.getQueryParam("enable_close_event");
    L59:
        boolean r132 = Intrinsics.areEqual(r131, "1");
        nl.c r133 = r210.f170809f.W90().getStaticState().f171227a;
        if (r133 == null) goto L62;
        String r134 = r133.getQueryParam("is_from_yata");
    L64:
        if (Intrinsics.areEqual(r134, "1") == false) goto L71;
        JSONObject r135 = new JSONObject();
        r135.put("type", "yata_event");
        r135.put("name", "continue_to_pay_popup");
        r135.put(ReportCardMonitorPlugin.EVENT_NAME, "continuePaySuccess");
        nl.c r136 = r210.f170809f.W90().getStaticState().f171227a;
        if (r136 == null) goto L69;
        String r137 = r136.getQueryParam("yata_session_id");
        if (r137 == null) goto L69;
    L70:
        r135.put("yata_session_id", r137);
    L72:
        ECLiveHybridUtil.f("continue_pay_success", r135);
        if (r132 == false) goto L162;
        r210.c(BuyNowCloseMethod.PAY_FAIL);
        return;
    L69:
        r137 = "";
        goto L70
    L71:
        r135 = new JSONObject();
        r135.put("data", r132);
        goto L72
    L62:
        r134 = null;
        goto L64
    L58:
        r131 = null;
        goto L59
    L75:
        r210.f170807d = 0;
        String r138 = r210.f170809f.W90().getFailMsg();
        r210.f170809f.W90().getTracker().i(r211);
        JSONObject r139 = new JSONObject();
        TuplesKt.to("data", r138);
        Unit r140 = Unit.INSTANCE;
        ECLiveHybridUtil.f("continue_pay_fail", r139);
        if (r212 != 116) goto L78;
        boolean r141 = true;
    L79:
        nl.c r142 = r210.f170809f.W90().getStaticState().f171227a;
        if (r142 == null) goto L84;
        String r143 = r142.getQueryParam(com.bytedance.android.ec.core.event.a.KEY_GOODS_TYPE);
        if (r143 == null) goto L84;
        Integer r144 = StringsKt.toIntOrNull(r143);
    L85:
        int r145 = GoodsType.TAILGOOD.getType();
        if (r144 != null) goto L89;
    L91:
        boolean r146 = false;
    L92:
        if (r141 == false) goto L94;
        r210.c(BuyNowCloseMethod.PAY_FAIL);
        return;
    L94:
        if (r146 == false) goto L96;
        r210.d();
        return;
    L96:
        if (r210.f170809f.W90().getNeedToast() == false) goto L102;
        if (r212 == 118) goto L102;
        int r147 = com.bytedance.android.shopping.buynow.utils.m.f171221a;
        if (r138 != null) goto L101;
        r138 = com.bytedance.android.shopping.extensions.j.c(R.string.buynow_pay_errors);
    L101:
        com.bytedance.android.shopping.buynow.utils.m.b(r138);
    L102:
        if (r212 != 118) goto L104;
        r210.c(BuyNowCloseMethod.PAY_FAIL);
        return;
    L104:
        AndroidYaTaInstance r148 = r210.f170809f.W90().getYataInstance();
        if (r148 == null) goto L107;
        Object r149 = r148.i("submit_bar");
    L109:
        if ((r149 instanceof Map) == true) goto L111;
        r149 = null;
    L111:
        Map r150 = (Map) r149;
        if (r150 == null) goto L114;
        Object r151 = r150.get("target_component_name");
    L116:
        if ((r151 instanceof String) == true) goto L118;
        r151 = null;
    L118:
        String r152 = (String) r151;
        if (r150 == null) goto L121;
        Object r153 = r150.get("target_yata_key");
    L123:
        if ((r153 instanceof String) == true) goto L125;
        r153 = null;
    L125:
        String r154 = (String) r153;
        if (r150 == null) goto L128;
        Object r155 = r150.get("refresh_events");
    L130:
        if ((r155 instanceof String) == false) goto L133;
        r101 = r155;
    L133:
        String r156 = (String) r101;
        r210.f170809f.W90().setSubmitStatusFlag(true);
        if (r150 != null) goto L136;
    L139:
        boolean r157 = true;
    L140:
        if (r157 == true) goto L242;
        if (r152 != null) goto L143;
    L146:
        boolean r158 = true;
    L147:
        if (r158 == true) goto L243;
        if (r154 != null) goto L150;
    L153:
        if (r106 == true) goto L244;
        com.bytedance.kmp.ec.yata.store.node.c r159 = com.bytedance.android.shopping.buynow.utils.h.a(r210.f170809f.W90().getYataInstance(), r152, r154);
        if (r159 != null) goto L157;
        com.bytedance.android.shopping.buynow.monitor.error.a.b(r210.f170809f.W90().getTracker(), "yata_error", "submitBar t is null");
        return;
    L157:
        AndroidYaTaInstance r160 = r210.f170809f.W90().getYataInstance();
        if (r160 == null) goto L246;
        r160.k().d(com.bytedance.kmp.ec.yata.event.common.e.f251660a.a(r160, null, r159.getKey(), r156, null, "handlePayResult"));
        return;
    L246:
        return;
    L244:
        return;
    L150:
        if (r154.length() == 0) goto L153;
        r106 = false;
        goto L153
    L243:
        return;
    L143:
        if (r152.length() == 0) goto L146;
        r158 = false;
        goto L147
    L242:
        return;
    L136:
        if (r150.isEmpty() == true) goto L139;
        r157 = false;
        goto L140
    L128:
        r155 = null;
        goto L130
    L121:
        r153 = null;
        goto L123
    L114:
        r151 = null;
        goto L116
    L107:
        r149 = null;
        goto L109
    L89:
        if (r144.intValue() != r145) goto L91;
        r146 = true;
    L84:
        r144 = null;
        goto L85
    L78:
        r141 = false;
    L162:
        if (r107 == false) goto L171;
        if (r211 == false) goto L165;
        com.bytedance.android.shopping.buynow.utils.m.a(R.string.buynow_pay_success);
    L165:
        JSONObject r161 = new JSONObject();
        if (r211 == false) goto L168;
        String r162 = "success";
    L169:
        TuplesKt.to("status", r162);
        Unit r163 = Unit.INSTANCE;
        ECLiveHybridUtil.f("submit_orders_pay_result", r161);
    L232:
        r210.f170809f.W90().getTracker().i(r211);
        if (r211 == true) goto L236;
        r124 = BuyNowCloseMethod.PAY_FAIL;
    L236:
        r210.c(r124);
        return;
    L168:
        r162 = "failure";
        goto L169
    L171:
        if (com.bytedance.android.shopping.extensions.k.r(String.valueOf(com.bytedance.android.shopping.buynow.utils.d.a(r210.f170809f.W90().getStaticState().f171227a, "shape")), 0) != BuyNowShape.REFUEL.getShape()) goto L173;
        boolean r164 = true;
    L175:
        if (Intrinsics.areEqual(String.valueOf(r104), PayShowType.AUCTION.getType()) == true) goto L180;
        if (r211 == true) goto L179;
        if (r164 == true) goto L180;
    L179:
        boolean r165 = false;
    L181:
        if (r211 == false) goto L230;
        if (r165 == false) goto L184;
        com.bytedance.android.shopping.buynow.utils.m.a(R.string.buynow_pay_success);
        goto L232
    L184:
        if (com.bytedance.android.shopping.extensions.k.r(String.valueOf(com.bytedance.android.shopping.buynow.utils.d.a(r210.f170809f.W90().getStaticState().f171227a, "shape")), 0) != BuyNowShape.ZERO_BUY.getShape()) goto L186;
        boolean r166 = true;
    L187:
        if (r166 == false) goto L189;
        com.bytedance.android.shopping.buynow.utils.m.a(R.string.buynow_receive_success);
    L189:
        Map<String, ? extends Object> r167 = r210.f170805b;
        if (r167 == null) goto L192;
        Object r168 = r167.get("pay_params");
    L194:
        if ((r168 instanceof Map) == true) goto L196;
        r168 = null;
    L196:
        Map r169 = (Map) r168;
        if (r169 == null) goto L199;
        Object r170 = r169.get("sdk_info");
    L201:
        if ((r170 instanceof Map) == true) goto L203;
        r170 = null;
    L203:
        Map r171 = (Map) r170;
        if (r171 == null) goto L206;
        Object r172 = r171.get("guide_info");
    L208:
        if ((r172 instanceof Map) == true) goto L210;
        r172 = null;
    L210:
        Map r173 = (Map) r172;
        if (r173 == null) goto L213;
        Object r174 = r173.get("guide_url");
    L215:
        if ((r174 instanceof String) == false) goto L218;
        r101 = r174;
    L218:
        String r175 = (String) r101;
        if (r175 == null) goto L223;
        r123 = r175;
    L223:
        if (r123.length() == 0) goto L226;
        r106 = false;
    L226:
        if (r106 == false) goto L228;
        r210.d();
        goto L232
    L228:
        int r176 = TTPay.f187579a;
        Context r177 = r210.f170809f.requireContext();
        JSONObject r178 = new JSONObject();
        r178.put("sdk_info", new JSONObject().put("schema", r123));
        r178.put("service", 98);
        Unit r179 = Unit.INSTANCE;
        TTPay.a(r177, r178, new CheckPayStatusController$invokeGuidePage$2(r210));
        goto L232
    L213:
        r174 = null;
        goto L215
    L206:
        r172 = null;
        goto L208
    L199:
        r170 = null;
        goto L201
    L192:
        r168 = null;
        goto L194
    L186:
        r166 = false;
        goto L187
    L230:
        if (r165 == true) goto L232;
        r210.d();
    L180:
        r165 = true;
        goto L181
    L173:
        r164 = false;
        goto L175
    L12:
        if (com.bytedance.android.shopping.extensions.k.r(String.valueOf(r105), 0) != 1) goto L14;
        r107 = true;
        goto L15
    L5:
        r102 = null;
        goto L7
    }

    public final void f(int r100, ma3.o r101, boolean r102) {
        this.f170804a = r101;
        if (r100 != 116) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r101 == null) goto L16;
        if (r103 == true) goto L11;
    L14:
        String r104 = r101.b();
    L15:
        r101.f(r104);
        goto L16
    L11:
        if (e() == true) goto L14;
        if (r102 == true) goto L14;
        r104 = r101.b() + "&show_pay_form=1";
    L16:
        String r105 = null;
        if (r101 != null) goto L19;
    L27:
        ma3.o r106 = this.f170804a;
        if (r106 == null) goto L30;
        String r107 = r106.e();
    L32:
        if (Intrinsics.areEqual(r107, "continue_pay_panel") == false) goto L40;
        ma3.o r108 = this.f170804a;
        if (r108 == null) goto L41;
        String r109 = r108.b();
        if (r109 == null) goto L38;
        r105 = l0.a(r109, "pre_session_id", this.f170809f.W90().getContinuePayPreSessionId());
    L38:
        r108.f(r105);
        return;
    L41:
        return;
    L40:
        return;
    L30:
        r107 = null;
        goto L32
    L19:
        if (r101.d() == null) goto L27;
        BtmSDK r110 = BtmSDK.INSTANCE;
        String r111 = r101.d();
        PageFinder r112 = PageFinder.via(this.f170809f);
        BcmParams.a r113 = BcmParams.Companion;
        String r114 = r101.c();
        r113.getClass();
        String r115 = r110.createJumpSourceBtmToken(r111, r112, BcmParams.a.a(r114));
        ma3.o r116 = this.f170804a;
        if (r116 == null) goto L27;
        String r117 = r116.b();
        if (r117 == null) goto L25;
        String r118 = l0.a(r117, PhotoEnterModel.SOURCE_BTM_TOKEN, r115);
    L26:
        r116.f(r118);
        goto L27
    L25:
        r118 = null;
        goto L26
    L5:
        if (r100 == 118) goto L7;
        r103 = true;
        goto L8
    }

    public final void b(com.bytedance.android.shopping.buynow.eventcenter.handle.b r110, int r111, String r112, Map<String, ? extends Object> r113) {
        Intrinsics.checkNotNullParameter(r110, "checkPayStatusParamsWrapper");
        Intrinsics.checkNotNullParameter(r112, "checkStatus");
        boolean r100 = true;
        this.f170809f.W90().setHasCheck(true);
        this.f170805b = r113;
        this.f170809f.W90().updateCheckStatus(CheckStatus.CHECKING);
        boolean r114 = false;
        if (Intrinsics.areEqual(this.f170809f.W90().isNoPwdCombined(), Boolean.TRUE) == false) goto L5;
        BuyNowLog.d("selfPayAndCheck", "isNoPwdCombined is true, toggleLoading flag == false");
        int r115 = BuyNowOrderLoadingController.f170802a;
        BuyNowOrderLoadingController.a(this.f170809f.W90().isNoPwdCombined(), false, this.f170809f.W90().getSdkInfo(), this.f170810g, this.f170808e);
    L5:
        ia3.b r116 = this.f170810g;
        if (r116 == null) goto L8;
        r116.b(new ia3.c(false, false));
    L8:
        pa3.a r117 = this.f170812i;
        if (r117 == null) goto L13;
        com.bytedance.android.shopping.buynow.monitor.order.a r118 = r117.f528358b;
        if (r118 == null) goto L13;
        r118.a(BuyNowOrderNode.ORDER_CHECK_START, System.currentTimeMillis());
    L13:
        TTCJPayUtils.Companion.getInstance().externalBizReport("request_start", "ecommerce_pay_desk", System.currentTimeMillis(), "电商查单", null);
        Map<?, ?> r119 = r110.f170941a;
        Long r101 = null;
        if (r119 == null) goto L16;
        Object r120 = r119.get("api_path");
    L18:
        if ((r120 instanceof String) == true) goto L20;
        r120 = null;
    L20:
        String r121 = (String) r120;
        Map<?, ?> r102 = r110.f170941a;
        if (r102 == null) goto L23;
        Object r103 = r102.get("params");
    L25:
        if ((r103 instanceof Map) == true) goto L27;
        r103 = null;
    L27:
        Map r104 = (Map) r103;
        if (r104 == null) goto L30;
        Map r105 = MapsKt.toMutableMap(r104);
    L31:
        int r106 = r110.f170942b;
        if (r111 != 0) goto L37;
        List<Integer> r107 = r110.f170943c;
        if (r107 == null) goto L36;
        r106 = r107.size();
    L36:
        int r108 = r106 - 1;
    L38:
        if (r121 == null) goto L67;
        if (r105 == null) goto L67;
        if (r111 != 118) goto L44;
        int r109 = 1;
    L45:
        r105.put("ttpay_result", Integer.valueOf(r109));
        List<Integer> r122 = r110.f170943c;
        if (r122 != null) goto L48;
    L56:
        List<Integer> r123 = CollectionsKt.emptyList();
    L57:
        TimeUnit r124 = TimeUnit.MILLISECONDS;
        ha3.b r125 = new ha3.b(r108, r123, r124);
        nl.c r126 = this.f170809f.W90().getStaticState().f171227a;
        if (r126 == null) goto L60;
        String r127 = r126.getQueryParam("enter_from_live_saas");
    L61:
        boolean r128 = Intrinsics.areEqual(String.valueOf(r127), "1");
        BuyNowLog.d("selfPayAndCheck", "check pay status api request starts");
        List<Integer> r129 = r110.f170943c;
        if (r129 == null) goto L66;
        Integer r130 = (Integer) CollectionsKt.first(r129);
        if (r130 == null) goto L66;
        r101 = Long.valueOf(r130.intValue());
    L66:
        Completable r131 = Completable.timer(com.bytedance.android.shopping.extensions.k.h(r101), r124);
        na3.g r132 = na3.g.f518461a;
        Observable r133 = bg4.b.b(r131.andThen(na3.g.a(r121, r105, com.bytedance.android.shopping.buynow.utils.e.a(), com.bytedance.android.shopping.buynow.utils.e.b(r128)))).doOnNext(new g(this, r111, r121));
        Intrinsics.checkNotNullParameter(r133, "$this$retryWhenCompat");
        Intrinsics.checkNotNullParameter(r125, "handler");
        ObjectHelper.requireNonNull(r125, "handler is null");
        com.bytedance.android.ec.core.async.a.a(RxJavaPlugins.onAssembly(new ObservableRetryWhenCompat(r133, r125)).doOnError(new h(this, r111)).subscribe(i.f170839a, j.f170840a), this.f170811h);
        return;
    L60:
        r127 = null;
        goto L61
    L48:
        if (r122.size() <= 1) goto L50;
        r114 = true;
    L50:
        if (r114 == true) goto L53;
        r122 = null;
    L53:
        if (r122 == null) goto L56;
        r123 = r122.subList(1, r122.size());
        if (r123 != null) goto L57;
    L44:
        r109 = 0;
    L67:
        BuyNowLog.d("selfPayAndCheck", "api_path or params are both null");
        com.bytedance.android.shopping.buynow.tracker.a r134 = this.f170809f.W90().getTracker();
        StringBuilder r135 = new StringBuilder("url == null is ");
        if (r121 != null) goto L70;
    L73:
        boolean r136 = true;
    L74:
        r135.append(r136);
        r135.append(", params == null is ");
        if (r105 != null) goto L77;
    L80:
        r135.append(r100);
        com.bytedance.android.shopping.buynow.monitor.error.a.b(r134, "blank_params", r135.toString());
        return;
    L77:
        if (r105.isEmpty() == true) goto L80;
        r100 = false;
        goto L80
    L70:
        if (r121.length() == 0) goto L73;
        r136 = false;
        goto L74
    L37:
        r108 = 0;
        goto L38
    L30:
        r105 = null;
        goto L31
    L23:
        r103 = null;
        goto L25
    L16:
        r120 = null;
        goto L18
    }

    public CheckPayStatusController(Context r100, BuyNowFragment r101, ia3.b r102, BuyNowFragment r103, pa3.a r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "buyNowFragment");
        Intrinsics.checkNotNullParameter(r103, "disposableScope");
        this.f170808e = r100;
        this.f170809f = r101;
        this.f170810g = r102;
        this.f170811h = r103;
        this.f170812i = r104;
    }
}
