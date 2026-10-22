package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.optimize.statistics.FrescoMonitorConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f190755a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f190756b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<h> f190757c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h.a f190758d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h.c f190759e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h.b f190760f = null;

    static {
        f190755a = new AtomicInteger(0);
        f190756b = Arrays.asList(new String[]{UploadTypeInf.TRACING});
        h.a r100 = new h.a();
        f190758d = r100;
        h.c r101 = new h.c();
        f190759e = r101;
        h.b r102 = new h.b();
        f190760f = r102;
        ArrayList r103 = new ArrayList();
        f190757c = r103;
        r103.add(r100);
        r103.add(r101);
        r103.add(r102);
    }

    public static void a(Map<Long, List<pt3.b>> r100) {
        if (xu3.a.a() == false) goto L12;
        List<String> r101 = mt3.a.f515607a;
        StringBuilder r102 = new StringBuilder("sendLog: input sendList merged into ");
        HashMap r103 = (HashMap) r100;
        r102.append(r103.size());
        r102.append(" group(s)");
        av3.b.a("APM-Slardar", r102.toString());
        Iterator r104 = r103.keySet().iterator();
        int r105 = 0;
    L6:
        if (r104.hasNext() == false) goto L15;
        Long r106 = (Long) r104.next();
        List r107 = (List) r103.get(r106);
        List<String> r108 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "----------------");
        ot3.a r109 = ot3.b.b().a(String.valueOf(r106));
        StringBuilder r110 = new StringBuilder("group ");
        int r111 = r105 + 1;
        r110.append(r105);
        r110.append(" header:");
        r110.append(r109);
        av3.b.a("APM-Slardar", r110.toString());
        int r112 = 0;
    L9:
        if (r112 >= r107.size()) goto L11;
        List<String> r113 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "  log[" + r112 + "]=" + ((pt3.b) ListProtector.get(r107, r112)).toString());
        r112 = r112 + 1;
        goto L9
    L11:
        List<String> r114 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "----------------");
        r105 = r111;
        goto L6
    L15:
        return;
    }

    public static Map<h, byte[]> b(List<pt3.a> r210, int r211) {
        String r100 = "_debug_self";
        HashMap r101 = new HashMap();     // Catch: Throwable -> L82
        ArrayList r102 = (ArrayList) r210;     // Catch: Throwable -> L82
        long r103 = r102.size();     // Catch: Throwable -> L82
        Iterator r104 = r102.iterator();     // Catch: Throwable -> L82
        long r105 = 0;
        long r106 = 0;
    L5:
        if (r104.hasNext() == false) goto L10;
        pt3.a r110 = (pt3.a) r104.next();     // Catch: Throwable -> L82
        long r111 = r110.f530633a;     // Catch: Throwable -> L82
        List r112 = (List) r101.get(Long.valueOf(r111));     // Catch: Throwable -> L82
        if (r112 != null) goto L9;
        r112 = new ArrayList();     // Catch: Throwable -> L82
        r101.put(Long.valueOf(r111), r112);     // Catch: Throwable -> L82
    L9:
        r105 = r105 + ((long) r110.f530635c);     // Catch: Throwable -> L82
        r106 = r106 + ((long) r110.f530634b);     // Catch: Throwable -> L82
        r112.addAll(r110.f530637e);     // Catch: Throwable -> L82
        goto L5
    L10:
        a(r101);     // Catch: Throwable -> L82
        c r107 = c.a.f190708a;     // Catch: Throwable -> L82
        r107.c();     // Catch: Throwable -> L82
        PolarisFileWrapper r108 = r107.f190703c;     // Catch: Throwable -> L82
        if (r108 == null) goto L15;
        String[] r109 = r108.list();     // Catch: Throwable -> L82
        if (r109 == null) goto L15;
        int r113 = r109.length;     // Catch: Throwable -> L82
    L16:
        HashMap r114 = new HashMap();     // Catch: Throwable -> L82
        ArrayList r115 = new ArrayList();     // Catch: Throwable -> L82
        Iterator r116 = r101.keySet().iterator();     // Catch: Throwable -> L82
    L18:
        if (r116.hasNext() == false) goto L76;
        Long r117 = (Long) r116.next();     // Catch: Throwable -> L82
        List r118 = (List) r101.get(r117);     // Catch: Throwable -> L82
        if (r118 == null) goto L18;
        HashMap r119 = r101;
        int r120 = 0;
    L24:
        if (r120 >= r118.size()) goto L75;
        Iterator r121 = r116;
        List r122 = r118;
        JSONObject r123 = new JSONObject(new String(((pt3.b) ListProtector.get(r118, r120)).f530638a));     // Catch: Exception -> L88 Throwable -> L82
        if (com.bytedance.apm6.consumer.slardar.send.downgrade.a.C2766a.f190733a.c(r123, du3.a.b()) == false) goto L33;
        String r124 = r123.optString(FrescoMonitorConst.LOG_TYPE);     // Catch: Throwable -> L82
        if (mt3.a.f515607a.contains(r124) == false) goto L39;
        Object r125 = f190758d;     // Catch: Throwable -> L82
    L43:
        if ((r125 instanceof h.b) == true) goto L103;
        r100 = r100;
        r120 = r120;
        HashMap r212 = r114;
    L64:
        r114 = r212;
        Map r126 = (Map) r114.get(r125);     // Catch: Throwable -> L82
        if (r126 != null) goto L68;
        r126 = new HashMap();     // Catch: Throwable -> L82
        r114.put(r125, r126);     // Catch: Throwable -> L82
    L68:
        if (r126.containsKey(r117) == true) goto L70;
        r126.put(r117, new JSONArray());     // Catch: Throwable -> L82
    L70:
        ((JSONArray) r126.get(r117)).put(r123);     // Catch: Throwable -> L82
        goto L74
    L103:
        JSONObject r127 = r123.optJSONObject(r100);     // Catch: Exception -> L57 Throwable -> L82
        if (r127 != null) goto L47;
        r127 = new JSONObject();     // Catch: Exception -> L57 Throwable -> L82
        r123.put(r100, r127);     // Catch: Exception -> L57 Throwable -> L82
    L47:
        r100 = r100;
        r120 = r120;
        r127.put("debug_sender_number", f190755a.getAndIncrement());     // Catch: Exception -> L56 Throwable -> L82
        r212 = r114;
        r127.put("debug_sender_sid", du3.a.k());     // Catch: Exception -> L86 Throwable -> L82
        r127.put("debug_total_bytes", r105);     // Catch: Exception -> L86 Throwable -> L82
        r127.put("debug_total_count", r106);     // Catch: Exception -> L86 Throwable -> L82
        r127.put("debug_merge_file_count", r103);     // Catch: Exception -> L86 Throwable -> L82
        r127.put("debug_second_file_count", r113);     // Catch: Exception -> L86 Throwable -> L82
        r127.put("debug_left_file_count", r211);     // Catch: Exception -> L85 Throwable -> L82
    L61:
        if (r123.has("seq_no") == false) goto L64;
        r115.add(String.valueOf(r123.get("seq_no")));     // Catch: Throwable -> L82
    L56:
        r212 = r114;
    L58:
        r120 = r120;
        r212 = r114;
    L57:
        r100 = r100;
        goto L58
    L39:
        if (f190756b.contains(r124) == false) goto L41;
        r125 = f190759e;     // Catch: Throwable -> L82
        goto L43
    L41:
        r125 = f190760f;     // Catch: Throwable -> L82
        goto L43
    L33:
        if (xu3.a.a() == false) goto L74;
        av3.b.a("APM-Downgrade", r123.toString());     // Catch: Throwable -> L82
    L74:
        r114 = r114;
        r120 = r120 + 1;     // Catch: Throwable -> L82
        r116 = r121;
        r118 = r122;
        r100 = r100;
    L73:
        r122 = r118;
        goto L74
    L75:
        r101 = r119;
        goto L18
    L76:
        HashMap r128 = r114;
        HashMap r129 = new HashMap();     // Catch: Throwable -> L82
        Iterator r130 = r128.keySet().iterator();     // Catch: Throwable -> L82
    L77:
        if (r130.hasNext() == false) goto L81;
        h r131 = (h) r130.next();     // Catch: Throwable -> L82
        r129.put(r131, r131.a((HashMap) r128.get(r131)));     // Catch: Throwable -> L82
        goto L77
    L81:
        return r129;
    L15:
        r113 = 0;
    L82:
        th = move-exception;
        List<String> r132 = mt3.a.f515607a;
        av3.b.c("APM-Slardar", "LogSender serialize failed.", th);
        return null;
    }
}
