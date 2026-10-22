package com.bytedance.android.shopping.orderlist.list.tracker;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.buynow.data.model.BuyNowUrlType;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.o;
import com.bytedance.android.shopping.orderlist.list.starter.OrderListParams;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.tencent.open.SocialConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderListTracker implements com.bytedance.android.shopping.orderlist.common.monitor.error.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventActionImpl f180375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f180376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f180377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f180378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OrderListViewModel f180379e;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/tracker/OrderListTracker$ChangeTabType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SLIDE", "CLICK", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ChangeTabType extends Enum<ChangeTabType> {
        public static final ChangeTabType CLICK = null;
        public static final ChangeTabType SLIDE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChangeTabType[] f180380a = null;
        private final String value;

        static {
            ChangeTabType r100 = new ChangeTabType("SLIDE", 0, "slide");
            SLIDE = r100;
            ChangeTabType r101 = new ChangeTabType("CLICK", 1, "click");
            CLICK = r101;
            f180380a = new ChangeTabType[]{r100, r101};
        }

        public static ChangeTabType valueOf(String r100) {
            return (ChangeTabType) r27.a.a(ChangeTabType.class, r100);
        }

        public static ChangeTabType[] values() {
            return (ChangeTabType[]) f180380a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public ChangeTabType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.orderlist.common.monitor.error.a
    public final void a() {
        b("ecom_page_screenshot", MapsKt.emptyMap());
    }

    @Override // com.bytedance.android.shopping.orderlist.common.monitor.error.a
    public final Map<String, Object> c() {
        Map<String, Object> r100 = MapsKt.toMutableMap(this.f180375a.c());
        r100.putAll(d());
        return r100;
    }

    public final Map<String, Object> d() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.putAll(this.f180379e.getStaticState().a());
        r100.put("log_id", this.f180379e.getStaticState().f180390e);
        return r100;
    }

    public final void e() {
        if (this.f180376b == false) goto L5;
        return;
    L5:
        this.f180376b = true;
        OrderListParams r100 = this.f180379e.getStaticState().f180392g;
        if (r100 == null) goto L8;
        Map<String, String> r101 = r100.getSchemaParamsMap();
    L9:
        if (r101 == null) goto L15;
        String r102 = r101.get("log_pv");
        if (r102 == null) goto L15;
        JSONObject r103 = z1.g(o.a(r102));
        if (r103 == null) goto L15;
        Map<String, String> r104 = z1.j(r103);
    L16:
        b("page_view", r104);
        return;
    L15:
        r104 = MapsKt.emptyMap();
        goto L16
    L8:
        r101 = null;
        goto L9
    }

    public OrderListTracker(OrderListViewModel r110) {
        Intrinsics.checkNotNullParameter(r110, "viewModel");
        this.f180379e = r110;
        EventActionImpl r100 = new EventActionImpl();
        this.f180375a = r100;
        r100.appendEventParams(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI), TuplesKt.to("page_name", "order_list_page"), TuplesKt.to("btm", "a1.b6871.c0.d0"), TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android"), TuplesKt.to("spma", "a1.b6871.c0.d0"), TuplesKt.to("font_scale", ECAppInfoService.f48114e.getCurrentFontScale()), TuplesKt.to("gecko_channel_version", String.valueOf(wh.a.a("ecommerce_order_list_component")))}));
        this.f180378d = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI), TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android"), TuplesKt.to("page", BuyNowUrlType.ORDER_LIST), TuplesKt.to("received_count", 0), TuplesKt.to("is_failover", 0)});
    }

    public final void f(Map<String, j> r110) {
        Intrinsics.checkNotNullParameter(r110, "selfRegisterJsSubscriber");
        if (r110.isEmpty() == false) goto L5;
        return;
    L5:
        final Map<String, ? extends Object> r111 = MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "BRIDGE_ERROR"), TuplesKt.to(SocialConstants.PARAM_APP_DESC, "jsb_unregister"), TuplesKt.to("detail", CollectionsKt.joinToString$default(r110.keySet(), ",", null, null, 0, null, null, 62, null))});
        Lazy r100 = OrderCommonLog.f179948a;
        OrderCommonLog.c("OrderListTracker", new OrderListTracker$reportJsbUnRegister$1(this, r111));
        b("ies_ecommerce_fe_custom_log", r111);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.monitor.error.b
    public final void b(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        EventActionImpl r102 = this.f180375a;
        PageFinder r103 = this.f180379e.getBtmPageFinder();
        LinkedHashMap r104 = new LinkedHashMap();
        r104.putAll(d());
        r104.putAll(r101);
        Unit r105 = Unit.INSTANCE;
        r102.doEventAction(r100, r103, r104);
    }

    public final void g(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f180378d.put(r100, r101);
    }
}
