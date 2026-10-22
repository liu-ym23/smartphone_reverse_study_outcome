package com.bytedance.android.shopping.orderlist.list.starter;

import android.content.Context;
import android.net.Uri;
import c53.b;
import c53.d;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.opt.ab.c;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.FirstScreenPoint;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.OrderCommonFirstScreenMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderAppletPageScene;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.list.container.OrderListRequestType;
import com.bytedance.android.shopping.orderlist.list.network.OrderListRequestViewModel;
import com.bytedance.android.shopping.orderlist.list.tab.OrderListFirstScreenTabResolver;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderListStarter implements d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f180352i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f180353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ig3.a f180354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OrderListRequestViewModel f180355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OrderListParams f180356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.shopping.orderlist.list.tab.a f180357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f180358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f180359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b f180360h;

    public static final class a {
    }

    static {
    }

    @Override // c53.d
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f180360h.add(r100);
        return r100;
    }

    @Override // c53.d
    public final void doClear() {
        this.f180360h.doClear();
    }

    @Override // c53.d
    public final void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f180360h.remove(r100);
    }

    public final void b() {
        Lazy r100 = OrderCommonLog.f179948a;
        OrderCommonLog.a("OrderListStarter", new OrderListStarter$release$1(this));
        doClear();
    }

    public OrderListStarter(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        this.f180360h = new b();
        this.f180359g = r100;
        this.f180353a = "YATA-OrderListStarter-" + r100;
    }

    public final void a(OrderAppletPageScene r210) {
        OrderListParams r100 = this.f180356d;
        if (r100 != null) goto L5;
        return;
    L5:
        com.bytedance.android.shopping.orderlist.list.tab.a r101 = this.f180357e;
        if (r101 != null) goto L9;
        r101 = new com.bytedance.android.shopping.orderlist.list.tab.a();
    L9:
        if (c.h() == false) goto L13;
        if (r101.f180367b != 0) goto L13;
    L16:
        boolean r102 = true;
    L18:
        Lazy r103 = OrderCommonLog.f179948a;
        OrderCommonLog.a("OrderListStarter", OrderListStarter$loadOrderListData$1.INSTANCE);
        ig3.a r104 = this.f180354b;
        if (r104 == null) goto L23;
        OrderCommonFirstScreenMonitor r105 = r104.f489719a;
        if (r105 == null) goto L23;
        r105.a(FirstScreenPoint.REQUEST_START);
    L23:
        ig3.a r106 = this.f180354b;
        if (r106 == null) goto L28;
        OrderCommonFirstScreenMonitor r107 = r106.f489719a;
        if (r107 == null) goto L28;
        r107.a(FirstScreenPoint.QUERY_NET_START);
    L28:
        ig3.a r108 = this.f180354b;
        if (r108 == null) goto L33;
        OrderCommonFirstScreenMonitor r109 = r108.f489719a;
        if (r109 == null) goto L33;
        r109.a(FirstScreenPoint.FETCH_START);
    L33:
        int r110 = this.f180358f + 1;
        this.f180358f = r110;
        com.bytedance.android.shopping.orderlist.list.tracker.b r111 = new com.bytedance.android.shopping.orderlist.list.tracker.b(new com.bytedance.android.shopping.orderlist.list.viewmodel.a(this.f180359g, r100, r101.f180368c, r101.f180366a, Integer.valueOf(r101.f180367b), "a1.b6871.c0.d0", 67072445));
        OrderListRequestViewModel r112 = this.f180355c;
        if (r112 == null) goto L37;
        r112.b(new com.bytedance.android.shopping.orderlist.list.network.b(OrderListRequestType.FIRST_REQUEST, r110, true, true, false, false, r210, r111, 416), r102);
        return;
    L37:
        return;
    L13:
        if (c.i() == true) goto L15;
    L17:
        r102 = false;
        goto L18
    L15:
        if (ArraysKt.contains(CollectionsKt.toIntArray(ECSettingKeys.K()), 0) == false) goto L17;
        goto L16
    }

    @Override // c53.d
    public final Disposable ignore(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f180360h.getClass();
        Intrinsics.checkNotNullParameter(r100, "disposable");
        return r100;
    }

    public final void c(Uri r100, Context r101) {
        ig3.a r102 = this.f180354b;
        if (r102 == null) goto L7;
        OrderCommonFirstScreenMonitor r103 = r102.f489719a;
        if (r103 == null) goto L7;
        r103.e(MonitorScenes.EC_PERF_PAGE_START_ORDER_LIST);
    L7:
        ig3.a r104 = this.f180354b;
        if (r104 == null) goto L12;
        OrderCommonFirstScreenMonitor r105 = r104.f489719a;
        if (r105 == null) goto L12;
        r105.a(FirstScreenPoint.INITIAL);
    L12:
        ig3.a r106 = this.f180354b;
        if (r106 == null) goto L17;
        OrderCommonFirstScreenMonitor r107 = r106.f489719a;
        if (r107 == null) goto L17;
        r107.a(FirstScreenPoint.C_PAGE_INIT);
    L17:
        Map<String, ig3.a> r108 = ig3.a.f489718h;
        String r109 = this.f180359g;
        MonitorScenes r110 = MonitorScenes.FPS_SCENE_ORDER_LIST;
        if (r100 != null) goto L20;
        r100 = Uri.EMPTY;
    L20:
        this.f180354b = ig3.a.C6262a.b(r109, "yata_order_list", r110, r100);
        Map<String, OrderListRequestViewModel> r111 = OrderListRequestViewModel.f180203z;
        String r112 = this.f180359g;
        Intrinsics.checkNotNullParameter(r112, "sessionId");
        OrderListRequestViewModel r113 = new OrderListRequestViewModel(r112);
        OrderListRequestViewModel.f180203z.put(r112, r113);
        this.f180355c = r113;
        nj.d r114 = com.bytedance.android.ec.sdk.helper.d.f48119b.getPadSplitService();
        Context r115 = null;
        if (r114 == null) goto L23;
        r114.l();
        final Boolean r116 = Boolean.FALSE;
    L24:
        if (r114 == null) goto L26;
        r114.a();
        final Boolean r117 = Boolean.FALSE;
    L27:
        Boolean r118 = Boolean.TRUE;
        if (Intrinsics.areEqual(r116, r118) == true) goto L30;
    L32:
        boolean r119 = false;
    L33:
        Lazy r120 = OrderCommonLog.f179948a;
        OrderCommonLog.c("zhedieping", new OrderListStarter$reloadStarter$1(r116, r117));
        ig3.a r121 = this.f180354b;
        if (r121 == null) goto L38;
        OrderCommonFirstScreenMonitor r122 = r121.f489719a;
        if (r122 == null) goto L38;
        r122.e(MonitorScenes.EC_PERF_PAGE_START_ORDER_LIST);
    L38:
        ig3.a r123 = this.f180354b;
        if (r123 == null) goto L43;
        OrderCommonFirstScreenMonitor r124 = r123.f489719a;
        if (r124 == null) goto L43;
        r124.a(FirstScreenPoint.INITIAL);
    L43:
        ig3.a r125 = this.f180354b;
        if (r125 == null) goto L48;
        OrderCommonFirstScreenMonitor r126 = r125.f489719a;
        if (r126 == null) goto L48;
        r126.a(FirstScreenPoint.C_PAGE_INIT);
    L48:
        ig3.a r127 = this.f180354b;
        if (r127 == null) goto L53;
        OrderCommonFirstScreenMonitor r128 = r127.f489719a;
        if (r128 == null) goto L53;
        r128.a(FirstScreenPoint.PARSE_SCHEMA_START);
    L53:
        int r129 = OrderListFirstScreenTabResolver.f180364a;
        if (r101 == null) goto L56;
        r115 = r101.getApplicationContext();
    L56:
        this.f180357e = OrderListFirstScreenTabResolver.a(r115, this.f180356d, true);
        ig3.a r130 = this.f180354b;
        if (r130 == null) goto L61;
        OrderCommonFirstScreenMonitor r131 = r130.f489719a;
        if (r131 == null) goto L61;
        r131.a(FirstScreenPoint.PARSE_SCHEMA_END);
    L61:
        OrderListRequestViewModel r132 = this.f180355c;
        if (r132 == null) goto L64;
        r132.f(this.f180356d, r119, this.f180357e);
    L64:
        ig3.a r133 = this.f180354b;
        if (r133 == null) goto L69;
        OrderCommonFirstScreenMonitor r134 = r133.f489719a;
        if (r134 == null) goto L69;
        r134.a(FirstScreenPoint.CONTAINER_INIT_START);
    L69:
        ig3.a r135 = this.f180354b;
        if (r135 == null) goto L74;
        OrderCommonFirstScreenMonitor r136 = r135.f489719a;
        if (r136 == null) goto L74;
        r136.a(FirstScreenPoint.T_CONTAINER_INIT);
    L74:
        a(OrderAppletPageScene.GO_TO_LANDING);
        return;
    L30:
        if (Intrinsics.areEqual(r117, r118) == false) goto L32;
        r119 = true;
        goto L33
    L26:
        r117 = null;
        goto L27
    L23:
        r116 = null;
        goto L24
    }
}
