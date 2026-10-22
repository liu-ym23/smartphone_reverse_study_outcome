package com.bytedance.android.shopping.card_list.router;

import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.android.shopping.card_list.monitor.cache.CacheMonitor;
import com.bytedance.android.shopping.card_list.monitor.error.CardListErrorMonitorType;
import com.bytedance.android.shopping.card_list.monitor.firstScreen.CardListFirstScreenPoint;
import com.bytedance.android.shopping.card_list.monitor.firstScreen.CardListYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.card_list.monitor.fps.CardListYataFpsMonitor;
import com.bytedance.android.shopping.card_list.monitor.success_rate.CardListSuccessRateMonitor;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.utils.CardListExtentionsKt;
import com.bytedance.services.apm.api.EnsureManager;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class CardListKitStarter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f171729i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f171730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f171731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f171732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f171733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f171734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CardListYataMonitorManager f171735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f171736g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Object> f171737h;

    public static final class a {
        @JvmStatic
        public static CardListKitStarter a(String r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "sessionId");
            Intrinsics.checkNotNullParameter(r101, "pageConfig");
            Object r102 = r101.get("biz_type");
            if (Intrinsics.areEqual(r102, Integer.valueOf(LauncherBizType.CART.ordinal())) == false) goto L6;
            return new e(r100, r101);
        L6:
            if (Intrinsics.areEqual(r102, Integer.valueOf(LauncherBizType.COLLECT.ordinal())) == false) goto L9;
            return new f(r100, r101);
        L9:
            return new CardListKitStarter(r100, r101);
        }
    }

    static {
    }

    public CardPassThroughData b(HashMap<String, String> r110) {
        Intrinsics.checkNotNullParameter(r110, "schemaMap");
        String r100 = r110.get("ecom_scene_id");
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r101 = this.f171736g;
        String r102 = this.f171734e;
        return new CardPassThroughData(null, null, r101, r110, r102, r100, null, 67, null);
    }

    public CardListKitStarter(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "pageConfig");
        this.f171736g = r100;
        this.f171737h = r101;
        this.f171731b = LazyKt.lazy(new CardListKitStarter$useDialogFragmentOpen$2(this));
        this.f171732c = LazyKt.lazy(new CardListKitStarter$queryDataInStarter$2(this));
        this.f171733d = LazyKt.lazy(new CardListKitStarter$cardLauncher$2(this));
    }

    public final void c(String r110, String r111) {
        JSONObject r100 = new JSONObject();
        r100.put("page_name", CardListExtentionsKt.f(this.f171737h, "page_name", ""));
        r100.put("session_id", this.f171736g);
        r100.put("previous_page", r110);
        r100.put("biz_type", CardListExtentionsKt.d(this.f171737h, "biz_type", 0));
        r100.put("page_type", r111);
        Map<String, CardListYataMonitorManager> r112 = CardListYataMonitorManager.f171668k;
        Intrinsics.checkNotNullParameter(r100, "config");
        CardListYataMonitorManager r113 = new CardListYataMonitorManager(r100);
        String r101 = UUID.randomUUID().toString();
        CardListYataMonitorManager.f171668k.put(r101, r113);
        Intrinsics.checkNotNullParameter(r101, "monitorId");
        JSONObject r102 = new JSONObject();
        r102.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r102.put("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
        r102.put("page_name", (String) r113.f171669a.getValue());
        r102.put("previous_page", (String) r113.f171670b.getValue());
        r102.put("session_id", (String) r113.f171671c.getValue());
        r102.put("biz_type", r100.optInt("biz_type"));
        r102.put("page_type", r100.optString("page_type"));
        CardListYataFirstScreenDurationMonitor r114 = new CardListYataFirstScreenDurationMonitor(r101, x0.a(r102));
        r113.f171672d = r114;
        CardListYataFirstScreenDurationMonitor.b(r114, CardListFirstScreenPoint.START);
        Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r115 = com.bytedance.android.shopping.card_list.monitor.error.a.f171685b;
        JSONObject r116 = x0.a(r102);
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r116, "baseParams");
        com.bytedance.android.shopping.card_list.monitor.error.a r103 = new com.bytedance.android.shopping.card_list.monitor.error.a(r116);
        com.bytedance.android.shopping.card_list.monitor.error.a.f171685b.put(r101, r103);
        r113.f171673e = r103;
        r113.f171674f = new CardListYataFpsMonitor(r101, x0.a(r102));
        Map<String, CardListSuccessRateMonitor> r117 = CardListSuccessRateMonitor.f171707g;
        JSONObject r118 = x0.a(r102);
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r118, "baseParams");
        CardListSuccessRateMonitor r104 = new CardListSuccessRateMonitor(r118);
        CardListSuccessRateMonitor.f171707g.put(r101, r104);
        r113.f171675g = r104;
        r113.f171676h = new com.bytedance.kmp.ec.yata.common.perf.d("biz_first_enter");
        Map<String, CacheMonitor> r119 = CacheMonitor.f171680d;
        JSONObject r120 = x0.a(r102);
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r120, "baseParams");
        CacheMonitor r105 = new CacheMonitor(r120);
        CacheMonitor.f171680d.put(r101, r105);
        r113.f171677i = r105;
        this.f171734e = r101;
        this.f171735f = CardListYataMonitorManager.a.a(r101);
        if (((Boolean) this.f171732c.getValue()).booleanValue() == false) goto L9;
        CardListYataMonitorManager r121 = this.f171735f;
        if (r121 == null) goto L9;
        CardListYataFirstScreenDurationMonitor r122 = r121.f171672d;
        if (r122 == null) goto L9;
        CardListYataFirstScreenDurationMonitor.b(r122, CardListFirstScreenPoint.REQUEST_START);
    L9:
        CardListYataMonitorManager r123 = this.f171735f;
        if (r123 == null) goto L19;
        CardListSuccessRateMonitor r124 = r123.f171675g;
        if (r124 != null) goto L14;
        return;
    L14:
        if (((LauncherBizType) r124.f171712e.getValue()) != LauncherBizType.COLLECT) goto L16;
        MonitorScenes r125 = MonitorScenes.EC_PERF_PAGE_START_COLLECT;
    L17:
        Map<String, com.bytedance.android.ec.core.monitor.a> r106 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.b(r125, null, r124.a());
        return;
    L16:
        r125 = MonitorScenes.EC_PERF_PAGE_START_CART;
        goto L17
    }

    public static final void a(CardListKitStarter r100, com.bytedance.kmp.ec.yata.common.protocol.data.e r101, Throwable r102) {
        String r103 = r100.f171736g;
        com.bytedance.kmp.ec.yata.common.protocol.data.e r104 = new com.bytedance.kmp.ec.yata.common.protocol.data.e(null);
        boolean r105 = true;
        r104.d(1);
        Unit r106 = Unit.INSTANCE;
        s0.b(new d(r103, r104));
        String r107 = r102.getMessage();
        String r108 = "";
        if (r107 != null) goto L6;
        r107 = "";
    L6:
        if (r107.length() == 0) goto L9;
        r105 = false;
    L9:
        if (r105 == false) goto L21;
        EnsureManager.ensureNotReachHere(r102);
        Intrinsics.checkNotNullParameter(r102, "$this$stackTraceToString");
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L13
        StringWriter r110 = new StringWriter();     // Catch: Throwable -> L13
        PrintWriter r111 = new PrintWriter(r110);     // Catch: Throwable -> L13
        r102.printStackTrace(r111);     // Catch: Throwable -> L13
        r111.flush();     // Catch: Throwable -> L13
        Object r112 = Result.m9449constructorimpl(r110.toString());     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r112) == false) goto L18;
        r112 = null;
    L18:
        r107 = (String) r112;
        if (r107 != null) goto L21;
        r107 = "";
    L13:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L21:
        StringBuilder r114 = new StringBuilder();
        r114.append(r107);
        r114.append("; cause: ");
        Throwable r115 = r102.getCause();
        if (r115 == null) goto L24;
        String r116 = r115.getMessage();
    L25:
        r114.append(r116);
        String r117 = r114.toString();
        String r118 = com.bytedance.android.shopping.card_list.monitor.a.f171679a;
        if (r101 == null) goto L30;
        Integer r119 = r101.a();
        if (r119 == null) goto L30;
        int r120 = r119.intValue();
    L31:
        if (r101 == null) goto L34;
        String r121 = r101.b();
        if (r121 == null) goto L34;
    L35:
        if (r121 != null) goto L37;
        r121 = "";
    L37:
        com.bytedance.android.shopping.card_list.monitor.a.a(r120, r121);
        CardListYataMonitorManager r122 = r100.f171735f;
        if (r122 == null) goto L42;
        com.bytedance.android.shopping.card_list.monitor.error.a r123 = r122.f171673e;
        if (r123 == null) goto L42;
        Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r124 = com.bytedance.android.shopping.card_list.monitor.error.a.f171685b;
        r123.b(CardListErrorMonitorType.FIRST_FETCH_RESP_ERROR, "CardListKitStarter-" + r117, null);
    L42:
        CardListYataMonitorManager r125 = r100.f171735f;
        if (r125 == null) goto L54;
        CacheMonitor r126 = r125.f171677i;
        if (r126 == null) goto L55;
        String r127 = r100.f171730a;
        if (r127 == null) goto L50;
        r108 = r127;
    L50:
        CacheMonitor.b(r126, "error", r108);
        return;
    L55:
        return;
    L54:
        return;
    L34:
        r121 = r102.getMessage();
    L30:
        r120 = -1;
        goto L31
    L24:
        r116 = null;
        goto L25
    }
}
