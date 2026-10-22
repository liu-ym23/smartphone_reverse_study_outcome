package com.bytedance.android.shopping.orderlist.list.widget.gul;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderListGULComponent implements jg3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f180412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f180413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f180414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f180415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OrderListFragment f180416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f180417f;

    @Override // jg3.a
    public final void release() {
        Lazy r100 = OrderCommonLog.f179948a;
        OrderCommonLog.c("OrderListGULComponent", AnonymousClass1.INSTANCE);
        l r101 = this.f180412a;
        if (r101 == null) goto L6;
        r101.release();
        return;
    }

    @Override // jg3.a
    public final void a(Function0<Unit> r110) {
        ig3.a r100 = this.f180416e.K;
        l r101 = null;
        if (r100 == null) goto L5;
        OrderCommonBusinessMonitor r102 = r100.f489721c;
    L6:
        if (r102 == null) goto L8;
        r102.f179888c = System.currentTimeMillis();
        r102.c("load_gul_start", null);
    L8:
        this.f180413b = r110;
        if (this.f180412a != null) goto L14;
        final long r103 = System.currentTimeMillis();
        ViewGroup r104 = this.f180417f;
        Context r105 = this.f180415d;
        ECLiveHybridUtil.HybridType r111 = ECLiveHybridUtil.HybridType.LYNX;
        String r106 = (String) this.f180414c.getValue();
        JSONObject r107 = new JSONObject();
        r107.put("module_param", new JSONObject());
        r107.put("mob_data", new JSONObject());
        Unit r108 = Unit.INSTANCE;
        l r109 = ECLiveHybridUtil.b(r105, r106, com.bytedance.android.shopping.hybrid.a.b(r107), r104, new c(this), r111, null, false, null, null, false, MediaPlayer.MEDIA_PLAYER_OPTION_TAKE_SCREEN_SHOT_SYNC);
        if (r109 == null) goto L13;
        r109.registerMethod("x.publishEvent", new b(this));
        r101 = r109;
    L13:
        this.f180412a = r101;
        final long r112 = System.currentTimeMillis();
        Lazy r113 = OrderCommonLog.f179948a;
        OrderCommonLog.c("OrderListGULComponent", new OrderListGULComponent$initOrReload$1(r112, r103));
        return;
    L14:
        final long r114 = System.currentTimeMillis();
        l r115 = this.f180412a;
        if (r115 == null) goto L17;
        r115.loadUrl((String) this.f180414c.getValue());
    L17:
        final long r116 = System.currentTimeMillis();
        Lazy r117 = OrderCommonLog.f179948a;
        OrderCommonLog.c("OrderListGULComponent", new OrderListGULComponent$initOrReload$2(r116, r114));
        return;
    L5:
        r102 = null;
        goto L6
    }

    public OrderListGULComponent(Context r100, OrderListFragment r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        this.f180415d = r100;
        this.f180416e = r101;
        this.f180417f = r102;
        this.f180414c = LazyKt.lazy(new OrderListGULComponent$gulUrl$2(this));
    }
}
