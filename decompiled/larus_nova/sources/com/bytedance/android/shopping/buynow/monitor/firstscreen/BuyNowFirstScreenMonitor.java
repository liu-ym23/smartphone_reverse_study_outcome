package com.bytedance.android.shopping.buynow.monitor.firstscreen;

import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowFirstScreenNode;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.utils.i;
import com.bytedance.ttnet.http.HttpRequestInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nl.c;
import sc3.b;

/* JADX INFO: loaded from: classes13.dex */
public final class BuyNowFirstScreenMonitor {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f170997l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f170998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f170999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f171000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f171001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f171002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f171003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HttpRequestInfo f171004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f171005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f171006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f171007j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f171008k;

    public static final class a {
    }

    static {
    }

    public final String d() {
        return (String) this.f170999b.getValue();
    }

    public static /* synthetic */ void b(BuyNowFirstScreenMonitor r100, BuyNowFirstScreenNode r101) {
        r100.a(r101, System.currentTimeMillis());
    }

    public final void a(BuyNowFirstScreenNode r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "node");
        c(r100.getValue(), r101);
    }

    public final void c(final String r100, final long r101) {
        if (this.f171002e == false) goto L7;
        Lazy r102 = BuyNowLog.f171168a;
        BuyNowLog.a(this.f170998a, "addNode node:" + r100 + "  已经完成首屏埋点 直接返回");
        return;
    L7:
        if (this.f171001d == false) goto L11;
        Lazy r103 = BuyNowLog.f171168a;
        BuyNowLog.a(this.f170998a, "addNode node:" + r100 + "  首屏接口错误或者链路错误 丢弃此次埋点");
        return;
    L11:
        if (this.f171000c.containsKey(r100) == false) goto L14;
        Lazy r104 = BuyNowLog.f171168a;
        BuyNowLog.a(this.f170998a, "addNode node:" + r100 + "  重复节点 丢弃此次埋点");
        this.f171001d = true;
        return;
    L14:
        this.f171000c.put(r100, Long.valueOf(r101));
        if (Intrinsics.areEqual(r100, BuyNowFirstScreenNode.END.getValue()) == false) goto L17;
        this.f171002e = true;
        b2.b(new BuyNowFirstScreenMonitor$addNodeInner$1(this));
        return;
    L17:
        BuyNowFirstScreenNode r105 = BuyNowFirstScreenNode.STANDARD_RENDER_END;
        if (CollectionsKt.listOf(new String[]{BuyNowFirstScreenNode.INITIAL.getValue(), BuyNowFirstScreenNode.REQUEST_START.getValue(), BuyNowFirstScreenNode.REQUEST_END.getValue(), BuyNowFirstScreenNode.STANDARD_RENDER_START.getValue(), r105.getValue()}).contains(r100) == false) goto L26;
        if (Intrinsics.areEqual(r100, r105.getValue()) == false) goto L22;
        i.a r106 = i.f171212a;
        i.a(new BuyNowFirstScreenMonitor$addNodeInner$2(this, r100, r101));
        return;
    L22:
        d r107 = com.bytedance.android.ec.monitor.duration.i.f47987a.get(d());
        if (r107 == null) goto L34;
        r107.d(r100, r101);
        return;
    L34:
        return;
    L26:
        if (Intrinsics.areEqual(r100, BuyNowFirstScreenNode.RENDER_END.getValue()) == false) goto L28;
        i.a r108 = i.f171212a;
        i.a(new BuyNowFirstScreenMonitor$addNodeInner$3(this, r100, r101));
        return;
    L28:
        d r109 = com.bytedance.android.ec.monitor.duration.i.f47987a.get(d());
        if (r109 == null) goto L37;
        r109.b(r100, Long.valueOf(r101));
        return;
    }

    public BuyNowFirstScreenMonitor(String r100, c r101, b r102) {
        Intrinsics.checkNotNullParameter("ies_ecommerce_fe_custom_log", "business");
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        Intrinsics.checkNotNullParameter(r101, "schemaQuery");
        this.f171006i = "ies_ecommerce_fe_custom_log";
        this.f171007j = r101;
        this.f171008k = r102;
        this.f170998a = "BuyNowCommonFirstScreenMonitor_ies_ecommerce_fe_custom_log";
        this.f170999b = LazyKt.lazy(new BuyNowFirstScreenMonitor$durationMonitorKey$2(this));
        this.f171000c = new ConcurrentHashMap();
        this.f171005h = new LinkedHashMap();
    }
}
