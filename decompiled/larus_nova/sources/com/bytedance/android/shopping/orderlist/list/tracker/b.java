package com.bytedance.android.shopping.orderlist.list.tracker;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.orderlist.list.starter.OrderListParams;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements com.bytedance.android.shopping.orderlist.common.monitor.error.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventActionImpl f180382a;

    @Override // com.bytedance.android.shopping.orderlist.common.monitor.error.a
    public final void a() {
    }

    @Override // com.bytedance.android.shopping.orderlist.common.monitor.error.a
    public final Map<String, Object> c() {
        return new LinkedHashMap();
    }

    public b(com.bytedance.android.shopping.orderlist.list.viewmodel.a r100) {
        Intrinsics.checkNotNullParameter(r100, "orderStaticState");
        EventActionImpl r101 = new EventActionImpl();
        this.f180382a = r101;
        Pair[] r102 = new Pair[11];
        r102[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r102[1] = TuplesKt.to("page_name", "order_list_page");
        r102[2] = TuplesKt.to("btm", "a1.b6871.c0.d0");
        r102[3] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r102[4] = TuplesKt.to("spma", "a1.b6871.c0.d0");
        r102[5] = TuplesKt.to("font_scale", ECAppInfoService.f48114e.getCurrentFontScale());
        r102[6] = TuplesKt.to("session_id", r100.f180387b);
        OrderListParams r103 = r100.f180392g;
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getEnterFrom();
    L6:
        r102[7] = TuplesKt.to("enter_from", r105);
        OrderListParams r106 = r100.f180392g;
        if (r106 == null) goto L9;
        r104 = r106.getPreviousPage();
    L9:
        r102[8] = TuplesKt.to("previous_page", r104);
        r102[9] = TuplesKt.to("btm", r100.f180401p);
        r102[10] = TuplesKt.to("spma", r100.f180401p);
        r101.appendEventParams(MapsKt.mapOf(r102));
        r101.appendEventParams(r100.a());
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.orderlist.common.monitor.error.b
    public final void b(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        EventActionImpl r102 = this.f180382a;
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(r101);
        Unit r104 = Unit.INSTANCE;
        r102.doEventAction(r100, null, r103);
    }
}
