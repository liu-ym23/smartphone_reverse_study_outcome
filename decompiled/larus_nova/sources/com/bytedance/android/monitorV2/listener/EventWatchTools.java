package com.bytedance.android.monitorV2.listener;

import android.os.Handler;
import com.byted.cast.common.api.FirewallError;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.constant.MonitorGlobalSp;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.android.monitorV2.util.l;
import com.bytedance.android.monitorV2.util.q;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class EventWatchTools implements g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f163109k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, Long>> f163110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f163111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f163112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f163113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f163114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f163115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f163116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<String> f163117h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f163118i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f163119j;

    public static final class a implements mz2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventWatchTools f163120a;

        @Override // mz2.e
        public final void a() {
            EventWatchTools r100 = this.f163120a;
            Handler r101 = r100.f163112c;
            if (r101 == null) goto L6;
            r101.post(new d(r100));
            return;
        }

        public a(EventWatchTools r100) {
            this.f163120a = r100;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.bytedance.android.monitorV2.listener.g
    public void onEventUpdated(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    public EventWatchTools() {
        this.f163110a = new ConcurrentHashMap();
        this.f163111b = System.currentTimeMillis();
        this.f163114e = new PthreadHandlerThreadV2("MonitorEventWatch");
        this.f163116g = LazyKt.lazy(EventWatchTools$settingsFilter$2.INSTANCE);
        this.f163117h = new LinkedHashSet();
        this.f163118i = "total";
        this.f163119j = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(HybridEvent.EventPhase.EVENT_CREATE.name(), "total"), TuplesKt.to(HybridEvent.EventPhase.EVENT_UPLOAD.name(), "upload"), TuplesKt.to(HybridEvent.EventPhase.SAMPLE_THROW.name(), "unsample"), TuplesKt.to(HybridEvent.TerminateType.SWITCH_OFF.name(), "switch_off"), TuplesKt.to(HybridEvent.TerminateType.PARAM_EXCEPTION.name(), "type_invalid"), TuplesKt.to(HybridEvent.TerminateType.CATCH_EXCEPTION.name(), com.bytedance.android.ec.core.event.a.KEY_EXCEPTION), TuplesKt.to(HybridEvent.TerminateType.EVENT_REPEATED.name(), SalesInfoStruct.REPEAT), TuplesKt.to(HybridEvent.TerminateType.INVALID_CASE.name(), "invalid_case"), TuplesKt.to(HybridEvent.TerminateType.BLOCK_LIST.name(), "block_list")});
        mz2.a r100 = mz2.d.f516474b;
        a r101 = new a(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "listener");
        ((ArrayList) r100.f516469b).add(r101);
    }

    public static final void a(EventWatchTools r100) {
        r100.getClass();
        nz2.b.a("EventWatchTools", "realFlush");
        Map<String, Map<String, Long>> r101 = r100.f163110a;
        if ((r101 instanceof Map) == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L8;
        MonitorGlobalSp.f("monitor_event_details", new JSONObject(r101).toString());
    L8:
        MonitorGlobalSp.e("monitor_event_flush_time", System.currentTimeMillis());
        MonitorGlobalSp.f("monitor_event_filter_id", ((CheckFilter) r100.f163116g.getValue()).f163088c);
    }

    public final Map<String, Long> b(String r100) {
        if (((ConcurrentHashMap) this.f163110a).get(r100) != null) goto L5;
        Map<String, Map<String, Long>> r101 = this.f163110a;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.put(r100, new ConcurrentHashMap());
    L5:
        Object r103 = ((ConcurrentHashMap) this.f163110a).get(r100);
        Intrinsics.checkNotNull(r103);
        return (Map) r103;
    }

    public final Map<String, String> c(String r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        List r102 = StringsKt.split$default(r100, new String[]{"@@"}, false, 0, 6, null);
        List<String> r103 = ((CheckFilter) this.f163116g.getValue()).f163087b;
        int r104 = r102.size();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L10;
        if (Intrinsics.areEqual(ListProtector.get(r102, r105), "==") == true) goto L9;
        List<String> r106 = com.bytedance.android.monitorV2.constant.a.f162994a;
        if (r103.contains(ListProtector.get(r106, r105)) == false) goto L9;
        r101.put(ListProtector.get(r106, r105), ListProtector.get(r102, r105));
    L9:
        r105 = r105 + 1;
        goto L3
    L10:
        r101.put("id", MonitorGlobalSp.d("monitor_event_filter_id", ""));
        return r101;
    }

    public final String d(HybridEvent r110) {
        JSONObject r100 = null;
        boolean r101 = false;
        if (this.f163115f == true) goto L28;
        long r102 = MonitorGlobalSp.b("monitor_event_flush_time");
        if (r102 != 0) goto L8;
    L27:
        this.f163115f = true;
        goto L28
    L8:
        if ((this.f163111b - r102) > BaseConstants.Time.DAY) goto L26;
        String r103 = MonitorGlobalSp.d("monitor_event_details", "");
        if (r103.length() <= 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L26;
        JSONObject r105 = l.r(r103);
        Iterator<String> r106 = r105.keys();     // Catch: Throwable -> L24
    L16:
        if (r106.hasNext() == false) goto L26;
        String r107 = r106.next();     // Catch: Throwable -> L24
        Map<String, String> r108 = c(r107);     // Catch: Throwable -> L24
        LinkedHashMap r109 = new LinkedHashMap();     // Catch: Throwable -> L24
        JSONObject r111 = l.i(r105, r107);     // Catch: Throwable -> L24
        Iterator<String> r112 = r111.keys();     // Catch: Throwable -> L24
    L20:
        if (r112.hasNext() == false) goto L22;
        String r113 = r112.next();     // Catch: Throwable -> L24
        r109.put(r113, Long.valueOf(l.j(r111, r113)));     // Catch: Throwable -> L24
        goto L20
    L22:
        Map<String, Map<String, String>> r114 = InternalWatcher.f162982a;     // Catch: Throwable -> L24
        InternalWatcher.a(null, "report_check_plus", r108, r109);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        goto L26
    L12:
        r104 = false;
    L26:
        MonitorGlobalSp.f("monitor_event_details", "");
    L28:
        Iterator<Map.Entry<String, ? extends List<String>>> r115 = ((CheckFilter) this.f163116g.getValue()).f163086a.entrySet().iterator();
    L30:
        if (r115.hasNext() == false) goto L34;
        if ((!r115.next().getValue().isEmpty()) == false) goto L30;
        boolean r116 = true;
    L35:
        if (r116 == true) goto L37;
        return "";
    L37:
        Pair[] r117 = new Pair[5];
        jz2.a r118 = r110.f163008h;
        if (r118 == null) goto L40;
        JSONObject r119 = r118.toJsonObject();
    L41:
        r117[0] = TuplesKt.to("containerName", l.l(r119, "container_name"));
        q.f163249a.getClass();
        Intrinsics.checkNotNullParameter(r110, "event");
        if ((r110 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L44;
        Object r120 = "custom";
    L45:
        JSONObject r121 = q.e(r110);
        if (Intrinsics.areEqual("custom", r120) == false) goto L81;
        String r122 = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r121, "bid_info"), "setting_bid");     // Catch: JSONException -> L53
    L56:
        r117[1] = TuplesKt.to("bid", r122);
        r117[2] = TuplesKt.to("eventType", r110.f163001a);
        jz2.a r123 = r110.f163008h;
        if (r123 == null) goto L59;
        r100 = r123.toJsonObject();
    L59:
        r117[3] = TuplesKt.to("containerType", l.l(r100, ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE));
        r117[4] = TuplesKt.to(com.heytap.mcssdk.constant.b.C, "10.4.0");
        Map r124 = MapsKt.mapOf(r117);
        Iterator<String> r125 = com.bytedance.android.monitorV2.constant.a.f162994a.iterator();
        String r126 = "";
    L61:
        if (r125.hasNext() == false) goto L76;
        String r127 = r125.next();
        List<String> r128 = ((CheckFilter) this.f163116g.getValue()).f163086a.get(r127);
        Intrinsics.checkNotNull(r128);
        List<String> r129 = r128;
        if (r101 == false) goto L66;
        r126 = r126 + "@@";
    L66:
        if ((!r129.isEmpty()) == true) goto L68;
    L70:
        StringBuilder r130 = new StringBuilder();
        r130.append(r126);
        if (r129.isEmpty() == false) goto L73;
        String r131 = "==";
    L74:
        r130.append(r131);
        r126 = r130.toString();
        r101 = true;
        goto L61
    L73:
        r131 = (String) r124.get(r127);
        goto L74
    L68:
        if (CollectionsKt.contains(r129, r124.get(r127)) == true) goto L70;
        return "";
    L76:
        return r126;
    L53:
        e = move-exception;
        com.bytedance.android.monitorV2.util.f.b(e);
    L55:
        r122 = "";
        goto L56
    L81:
        r122 = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r121, "nativeBase"), "bid_info"), "setting_bid");     // Catch: JSONException -> L49
    L49:
        e = move-exception;
        com.bytedance.android.monitorV2.util.f.b(e);
        goto L55
    L44:
        r120 = "";
        goto L45
    L40:
        r119 = null;
        goto L41
    L34:
        r116 = false;
        goto L35
    }

    @Override // com.bytedance.android.monitorV2.listener.g
    public void onEventCreated(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f163117h.add(r100.a().toString());
    }

    @Override // com.bytedance.android.monitorV2.listener.g
    public void onEventSampled(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        String r101 = d(r100);
        String r102 = String.valueOf(r100.f163004d.f163016a);
        String r103 = this.f163119j.get(r102);
        if (r103 != null) goto L5;
        r103 = "unknown_phase";
    L5:
        f(r100, r101, r103);
    }

    @Override // com.bytedance.android.monitorV2.listener.g
    public void onEventTerminated(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        String r101 = d(r100);
        String r102 = String.valueOf(r100.f163004d.f163017b);
        String r103 = this.f163119j.get(r102);
        if (r103 != null) goto L5;
        r103 = "unknown_phase";
    L5:
        f(r100, r101, r103);
    }

    @Override // com.bytedance.android.monitorV2.listener.g
    public void onEventUploaded(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        String r101 = d(r100);
        String r102 = String.valueOf(r100.f163004d.f163016a);
        String r103 = this.f163119j.get(r102);
        if (r103 != null) goto L5;
        r103 = "unknown_phase";
    L5:
        f(r100, r101, r103);
    }

    public final void e(String r100, String r101) {
        if (b(r100).containsKey(r101) == false) goto L5;
        Map<String, Long> r102 = b(r100);
        Long r103 = b(r100).get(r101);
        Intrinsics.checkNotNull(r103);
        r102.put(r101, Long.valueOf(r103.longValue() + 1));
    L7:
        if (this.f163112c != null) goto L10;
        ThreadMethodProxy.start(this.f163114e);
        Handler r104 = new Handler(this.f163114e.getLooper());
        this.f163112c = r104;
        r104.postDelayed(new e(this), FirewallError.FIREWALL_OK);
    L10:
        if (mz2.d.f516474b.f516470c == true) goto L12;
        return;
    L12:
        if (this.f163113d != null) goto L14;
        this.f163113d = new Handler(this.f163114e.getLooper());
    L14:
        Handler r105 = this.f163113d;
        if (r105 == null) goto L17;
        r105.removeCallbacksAndMessages(null);
    L17:
        Handler r106 = this.f163113d;
        if (r106 == null) goto L22;
        r106.postDelayed(new c(this), 2000);
        return;
    L22:
        return;
    L5:
        b(r100).put(r101, 1L);
        goto L7
    }

    public final void f(HybridEvent r100, String r101, String r102) {
        String r103 = r100.a().toString();     // Catch: Throwable -> L13
        if (r101.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L9;
        this.f163117h.remove(r103);     // Catch: Throwable -> L13
        return;
    L9:
        e(r101, r102);     // Catch: Throwable -> L13
        if (this.f163117h.contains(r103) == false) goto L17;
        e(r101, this.f163118i);     // Catch: Throwable -> L13
        this.f163117h.remove(r103);     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L5:
        r104 = false;
    L13:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
    }
}
