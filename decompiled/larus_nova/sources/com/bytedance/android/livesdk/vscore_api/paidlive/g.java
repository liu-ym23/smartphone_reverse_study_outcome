package com.bytedance.android.livesdk.vscore_api.paidlive;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements IPaidLiveTraceMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f159439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static IPaidLiveTraceMonitor.CategoryGetter f159440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, String> f159441c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, String> f159442d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f159443e = null;

    public g() {
    }

    @Override // com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor
    public final void reset() {
        f159440b = null;
    }

    static {
        f159443e = new g();
        f159439a = "";
        f159441c = new LinkedHashMap();
        f159442d = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor
    public final IPaidLiveTraceMonitor.CategoryGetter getCommonCategory() {
        return f159440b;
    }

    public static String a(IPaidLiveTraceMonitor.CategoryGetter r100) {
        return "isPaidlive: " + r100.isPaidlive() + " watchPaidliveStatus: " + r100.getWatchPaidliveStatus() + " ticketId: " + r100.getTicketId() + " isVs: " + r100.isVs() + " roomId: " + r100.getRoomId() + " episodeId: " + r100.getEpisodeId() + " userId: " + r100.getUserId() + " playerScene: " + r100.getPlayerScene() + ' ';
    }

    @Override // com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor
    public final void initTrace(IPaidLiveTraceMonitor.CategoryGetter r100) {
        Intrinsics.checkNotNullParameter(r100, "categoryGetter");
        f159440b = r100;
        if (f159441c.isEmpty() == true) goto L28;
    L26:
        f159439a = new SimpleDateFormat("SSSssmmHHddMMyyyy", Locale.CHINA).format(Long.valueOf(System.currentTimeMillis())) + ((int) (new Random().nextDouble() * ((double) 1000000000)));
        return;
    L28:
        Field[] r101 = IPaidLiveTraceMonitor.SERVICE.class.getDeclaredFields();     // Catch: Exception -> L24
        int r102 = r101.length;     // Catch: Exception -> L24
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L26;
        Field r104 = r101[r103];     // Catch: Exception -> L24
        IPaidLiveTraceMonitor.SCENE r105 = (IPaidLiveTraceMonitor.SCENE) r104.getAnnotation(IPaidLiveTraceMonitor.SCENE.class);     // Catch: Exception -> L24
        Object r106 = null;
        if (r105 == null) goto L14;
        Object r107 = r104.get(IPaidLiveTraceMonitor.SERVICE.Companion);     // Catch: Exception -> L24
        if ((r107 instanceof String) == true) goto L11;
        r107 = null;
    L11:
        String r108 = (String) r107;     // Catch: Exception -> L24
        if (r108 == null) goto L14;
        f159441c.put(r108, r105.scene());     // Catch: Exception -> L24
    L14:
        IPaidLiveTraceMonitor.PRIORITY r109 = (IPaidLiveTraceMonitor.PRIORITY) r104.getAnnotation(IPaidLiveTraceMonitor.PRIORITY.class);     // Catch: Exception -> L24
        if (r109 == null) goto L23;
        Object r110 = r104.get(IPaidLiveTraceMonitor.SERVICE.Companion);     // Catch: Exception -> L24
        if ((r110 instanceof String) == false) goto L20;
        r106 = r110;
    L20:
        String r111 = (String) r106;     // Catch: Exception -> L24
        if (r111 == null) goto L23;
        f159442d.put(r111, r109.priority());     // Catch: Exception -> L24
    L23:
        r103 = r103 + 1;
    L24:
        e = move-exception;
        ALogger.e("PaidLiveTraceMonitor", e);
        goto L26
    }

    @Override // com.bytedance.android.livesdkapi.paidlive.IPaidLiveTraceMonitor
    public final void trace(@IPaidLiveTraceMonitor.SERVICE String r210, Map<String, String> r211, Map<String, String> r212, String r213, String r214) {
        Intrinsics.checkNotNullParameter(r210, "eventType");
        Intrinsics.checkNotNullParameter(r211, "categoryMap");
        Intrinsics.checkNotNullParameter(r212, "extraParam");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L82
        int r101 = com.bytedance.android.live.core.monitor.trace.e.f64997m;     // Catch: Throwable -> L82
        com.bytedance.android.live.core.monitor.trace.e.a r102 = com.bytedance.android.live.core.monitor.trace.e.b.a(r210, "paid_live_user");     // Catch: Throwable -> L82
        r102.f65012c = "webcast_server_paid_live_user";     // Catch: Throwable -> L82
        IPaidLiveTraceMonitor.CategoryGetter r103 = f159440b;     // Catch: Throwable -> L82
        String r104 = null;
        if (r103 == null) goto L6;
        String r105 = r103.getUserId();     // Catch: Throwable -> L82
    L7:
        r102.f65016g = r105;     // Catch: Throwable -> L82
        IPaidLiveTraceMonitor.CategoryGetter r106 = f159440b;     // Catch: Throwable -> L82
        if (r106 == null) goto L10;
        String r107 = r106.getRoomId();     // Catch: Throwable -> L82
    L11:
        r102.f65014e = r107;     // Catch: Throwable -> L82
        r102.b("event_source", "android");     // Catch: Throwable -> L82
        IPaidLiveTraceMonitor.CategoryGetter r108 = f159440b;     // Catch: Throwable -> L82
        if (r108 == null) goto L14;
        Long r109 = Long.valueOf(r108.getTicketId());     // Catch: Throwable -> L82
    L15:
        r102.b("ticket_id", String.valueOf(r109));     // Catch: Throwable -> L82
        r102.f65010a = f159439a;     // Catch: Throwable -> L82
        if (r213 != null) goto L21;
        IPaidLiveTraceMonitor.CategoryGetter r110 = f159440b;     // Catch: Throwable -> L82
        if (r110 == null) goto L20;
        String r111 = r110.getPlayerScene();     // Catch: Throwable -> L82
    L22:
        r102.b("paidlive_entry", r111);     // Catch: Throwable -> L82
        r102.b("paid_scene", r214);     // Catch: Throwable -> L82
        String r112 = (String) ((LinkedHashMap) f159441c).get(r210);     // Catch: Throwable -> L82
        boolean r113 = true;
        if (r112 != null) goto L25;
    L28:
        boolean r114 = true;
    L29:
        if (r114 == true) goto L31;
        r102.b("business_scene", r112);     // Catch: Throwable -> L82
    L31:
        String r115 = (String) ((LinkedHashMap) f159442d).get(r210);     // Catch: Throwable -> L82
        if (r115 != null) goto L34;
    L37:
        if (r113 == true) goto L39;
        r102.b("priority", r115);     // Catch: Throwable -> L82
    L39:
        com.bytedance.android.live.core.monitor.trace.e r116 = r102.a();     // Catch: Throwable -> L82
        JSONObject r117 = new JSONObject(r211);     // Catch: Throwable -> L82
        IPaidLiveTraceMonitor.CategoryGetter r118 = f159440b;     // Catch: Throwable -> L82
        if (r118 == null) goto L42;
        String r119 = r118.isPaidlive();     // Catch: Throwable -> L82
    L44:
        if (r117.has("is_paidlive") == true) goto L46;
        r117.put("is_paidlive", r119);     // Catch: Throwable -> L82
    L46:
        IPaidLiveTraceMonitor.CategoryGetter r120 = f159440b;     // Catch: Throwable -> L82
        if (r120 == null) goto L49;
        String r121 = r120.getWatchPaidliveStatus();     // Catch: Throwable -> L82
    L51:
        if (r117.has(ILiveRoomPlayFragmentConstant.EXTRA_WATCH_PAID_LIVE_STATUS) == true) goto L53;
        r117.put(ILiveRoomPlayFragmentConstant.EXTRA_WATCH_PAID_LIVE_STATUS, r121);     // Catch: Throwable -> L82
    L53:
        IPaidLiveTraceMonitor.CategoryGetter r122 = f159440b;     // Catch: Throwable -> L82
        if (r122 == null) goto L56;
        String r123 = r122.isVs();     // Catch: Throwable -> L82
    L58:
        if (r117.has("is_vs") == true) goto L61;
        r117.put("is_vs", r123);     // Catch: Throwable -> L82
    L61:
        if (r117.has("is_use_scope") == true) goto L63;
        r117.put("is_use_scope", "true");     // Catch: Throwable -> L82
    L63:
        JSONObject r124 = new JSONObject();     // Catch: Throwable -> L82
        IPaidLiveTraceMonitor.CategoryGetter r125 = f159440b;     // Catch: Throwable -> L82
        if (r125 == null) goto L66;
        Long r126 = Long.valueOf(r125.getTicketId());     // Catch: Throwable -> L82
    L67:
        String r127 = String.valueOf(r126);     // Catch: Throwable -> L82
        if (r124.has("ticket_id") == true) goto L71;
        r124.put("ticket_id", r127);     // Catch: Throwable -> L82
    L71:
        if (r212.isEmpty() == false) goto L73;
        JSONObject r128 = null;
    L77:
        StringBuilder r129 = new StringBuilder();     // Catch: Throwable -> L82
        r129.append("EventType: ");     // Catch: Throwable -> L82
        r129.append(r210);     // Catch: Throwable -> L82
        r129.append("\n CategoryInfo: ");     // Catch: Throwable -> L82
        IPaidLiveTraceMonitor.CategoryGetter r130 = f159440b;     // Catch: Throwable -> L82
        if (r130 == null) goto L80;
        r104 = a(r130);     // Catch: Throwable -> L82
    L80:
        r129.append(r104);     // Catch: Throwable -> L82
        r129.append(" , categoryMap:");     // Catch: Throwable -> L82
        r129.append(CollectionsKt.joinToString$default(r211.entrySet(), null, null, null, 0, null, null, 63, null));     // Catch: Throwable -> L82
        r129.append(", extra params ");     // Catch: Throwable -> L82
        r129.append(r212);     // Catch: Throwable -> L82
        ALogger.d("PaidLiveTraceMonitor", r129.toString());     // Catch: Throwable -> L82
        a60.e r131 = com.bytedance.android.live.core.monitor.trace.c.f64995a;     // Catch: Throwable -> L82
        Intrinsics.checkNotNullParameter(r116, "traceMeta");     // Catch: Throwable -> L82
        TraceMonitor.i(r116, r117, r124, r128);     // Catch: Throwable -> L82
        Object r132 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L82
    L84:
        Throwable r133 = Result.m9452exceptionOrNullimpl(r132);
        if (r133 == null) goto L91;
        ALogger.e("PaidLiveTraceMonitor", r133);
        return;
    L91:
        return;
    L73:
        r128 = new JSONObject();     // Catch: Throwable -> L82
        Iterator<Map.Entry<String, String>> r134 = r212.entrySet().iterator();     // Catch: Throwable -> L82
    L75:
        if (r134.hasNext() == false) goto L77;
        Map.Entry<String, String> r135 = r134.next();     // Catch: Throwable -> L82
        r128.put(r135.getKey(), r135.getValue());     // Catch: Throwable -> L82
        goto L75
    L66:
        r126 = null;
        goto L67
    L56:
        r123 = null;
        goto L58
    L49:
        r121 = null;
        goto L51
    L42:
        r119 = null;
        goto L44
    L34:
        if (r115.length() == 0) goto L37;
        r113 = false;
        goto L37
    L25:
        if (r112.length() == 0) goto L28;
        r114 = false;
        goto L29
    L20:
        r111 = null;
        goto L22
    L21:
        r111 = r213;
        goto L22
    L14:
        r109 = null;
        goto L15
    L10:
        r107 = null;
        goto L11
    L6:
        r105 = null;
    L82:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L84
    }
}
