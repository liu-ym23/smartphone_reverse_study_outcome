package com.bytedance.android.shopping.buynow.monitor.order;

import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowOrderNode;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f171014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f171015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f171016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f171017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f171018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<BuyNowOrderNode, Long> f171019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f171020g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f171021h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f171022i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<BuyNowOrderNode> f171023j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f171024k;

    public final String b() {
        return (String) this.f171016c.getValue();
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter("ies_ecommerce_fe_custom_log", "business");
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        this.f171024k = "ies_ecommerce_fe_custom_log";
        this.f171014a = "BuyNowOrderMonitor_ies_ecommerce_fe_custom_log";
        this.f171015b = "a1.b7411.c5642.d1959";
        this.f171016c = LazyKt.lazy(new BuyNowOrderMonitor$durationMonitorKey$2(this));
        this.f171017d = LazyKt.lazy(new BuyNowOrderMonitor$orderPerfCommonParams$2(this));
        this.f171018e = new LinkedHashMap();
        this.f171019f = new ConcurrentHashMap();
        this.f171023j = CollectionsKt.listOf(new BuyNowOrderNode[]{BuyNowOrderNode.INITIAL, BuyNowOrderNode.REQUEST_START, BuyNowOrderNode.REQUEST_END, BuyNowOrderNode.STANDARD_RENDER_START, BuyNowOrderNode.STANDARD_RENDER_END});
    }

    public final void a(final BuyNowOrderNode r100, final long r101) {
        Intrinsics.checkNotNullParameter(r100, "node");
        if (this.f171022i == false) goto L6;
        return;
    L6:
        if (this.f171021h == false) goto L9;
        return;
    L9:
        if (this.f171019f.contains(r100) == false) goto L11;
        this.f171021h = true;
        return;
    L11:
        this.f171019f.put(r100, Long.valueOf(r101));
        if (r100 != BuyNowOrderNode.END) goto L65;
        Lazy r102 = BuyNowLog.f171168a;
        BuyNowLog.a(this.f171014a, "add node: " + r100.getValue() + " 查单完成，上报埋点");
        JSONObject r103 = this.f171020g;
        if (r103 != null) goto L16;
    L36:
        Iterator<Map.Entry<String, String>> r104 = sa3.a.f541161a.entrySet().iterator();
    L38:
        if (r104.hasNext() == false) goto L42;
        Map.Entry<String, String> r105 = r104.next();
        String r106 = r105.getValue();
        d r107 = i.f47987a.get(b());
        if (r107 == null) goto L38;
        r107.b(r105.getKey(), r106);
        goto L38
    L42:
        Map<String, Object> r108 = this.f171018e;
        if (r108 == null) goto L52;
        Iterator r109 = ((LinkedHashMap) r108).entrySet().iterator();
    L46:
        if (r109.hasNext() == false) goto L52;
        Map.Entry r110 = (Map.Entry) r109.next();
        Object r111 = r110.getValue();
        if (r111 == null) goto L46;
        d r112 = i.f47987a.get(b());
        if (r112 == null) goto L46;
        r112.b((String) r110.getKey(), r111);
    L52:
        Iterator r113 = ((Map) this.f171017d.getValue()).entrySet().iterator();
    L54:
        if (r113.hasNext() == false) goto L60;
        Map.Entry r114 = (Map.Entry) r113.next();
        Object r115 = r114.getValue();
        if (r115 == null) goto L54;
        d r116 = i.f47987a.get(b());
        if (r116 == null) goto L54;
        r116.b((String) r114.getKey(), r115.toString());
        goto L54
    L60:
        d r117 = i.f47987a.get(b());
        if (r117 == null) goto L63;
        r117.report();
    L63:
        this.f171022i = true;
        return;
    L16:
        if (r103.length() == 0) goto L36;
        JSONObject r118 = this.f171020g;
        if (r118 == null) goto L36;
        Iterator<String> r119 = r118.keys();
        if (r119 == null) goto L36;
    L22:
        if (r119.hasNext() == false) goto L36;
        String r120 = r119.next();
        JSONObject r121 = this.f171020g;
        if (r121 == null) goto L22;
        Long r122 = Long.valueOf(r121.optLong(r120, 0));
        if (r122.longValue() <= 0) goto L28;
        boolean r123 = true;
    L29:
        if (r123 == true) goto L32;
        r122 = null;
    L32:
        if (r122 == null) goto L22;
        long r124 = r122.longValue();
        d r125 = i.f47987a.get(b());
        if (r125 == null) goto L22;
        r125.b(r120, Long.valueOf(r124));
        goto L22
    L28:
        r123 = false;
        goto L29
    L65:
        if (this.f171023j.contains(r100) == true) goto L67;
        d r126 = i.f47987a.get(b());
        if (r126 == null) goto L109;
        r126.b(r100.getValue(), Long.valueOf(r101));
        return;
    L109:
        return;
    L67:
        if (r100 != BuyNowOrderNode.STANDARD_RENDER_END) goto L69;
        com.bytedance.android.shopping.buynow.utils.i.a r127 = com.bytedance.android.shopping.buynow.utils.i.f171212a;
        com.bytedance.android.shopping.buynow.utils.i.a(new BuyNowOrderMonitor$addNodeInner$2(this, r100, r101));
        return;
    L69:
        d r128 = i.f47987a.get(b());
        if (r128 == null) goto L107;
        r128.d(r100.getValue(), r101);
        return;
    }

    public final void c(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (((Map) this.f171017d.getValue()).containsKey(r100) == true) goto L5;
        return;
    L5:
        ((Map) this.f171017d.getValue()).put(r100, r101);
    }
}
