package com.bytedance.apm6.consumer.slardar.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: UploadLogManager.java */
/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f5161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f5162b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<f> f5163c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f.a f5164d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f.c f5165e = null;
    private static final f.b f = null;

    static {
        f5161a = new AtomicInteger(0);
        f5162b = Arrays.asList(new String[]{"tracing"});
        f.a r0 = new f.a();
        f5164d = r0;
        f.c r1 = new f.c();
        f5165e = r1;
        f.b r2 = new f.b();
        f = r2;
        ArrayList r3 = new ArrayList();
        f5163c = r3;
        r3.add(r0);
        r3.add(r1);
        r3.add(r2);
    }

    public static List<f> a() {
        return f5163c;
    }

    public static Map<f, byte[]> a(List<com.bytedance.apm6.consumer.slardar.c.a> r23, int r24) {
        String r1 = "_debug_self";
        String r3 = "com.obric.aiagent.plugin";
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        HashMap r4 = new HashMap();     // Catch: Throwable -> L77
        long r5 = r2.size();     // Catch: Throwable -> L77
        Iterator r6 = r2.iterator();     // Catch: Throwable -> L77
        long r7 = 0;
        long r9 = 0;
    L5:
        if (r6.hasNext() == false) goto L10;
        com.bytedance.apm6.consumer.slardar.c.a r11 = (com.bytedance.apm6.consumer.slardar.c.a) ZeusTransformUtils.preCheckCast(r6.next(), com.bytedance.apm6.consumer.slardar.c.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L77
        long r12 = r11.a();     // Catch: Throwable -> L77
        List r14 = (List) ZeusTransformUtils.preCheckCast(r4.get(Long.valueOf(r12)), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L77
        if (r14 != null) goto L9;
        r14 = new ArrayList();     // Catch: Throwable -> L77
        r4.put(Long.valueOf(r12), r14);     // Catch: Throwable -> L77
    L9:
        r7 = r7 + ((long) r11.c());     // Catch: Throwable -> L77
        r9 = r9 + ((long) r11.b());     // Catch: Throwable -> L77
        r14.addAll(r11.d());     // Catch: Throwable -> L77
        goto L5
    L10:
        a(r4);     // Catch: Throwable -> L77
        File r8 = a.a().b();     // Catch: Throwable -> L77
        if (r8 == null) goto L15;
        String[] r10 = r8.list();     // Catch: Throwable -> L77
        if (r10 == null) goto L15;
        int r13 = r10.length;     // Catch: Throwable -> L77
    L16:
        HashMap r15 = new HashMap();     // Catch: Throwable -> L77
        ArrayList r16 = new ArrayList();     // Catch: Throwable -> L77
        Iterator r17 = r4.keySet().iterator();     // Catch: Throwable -> L77
    L18:
        if (r17.hasNext() == false) goto L69;
        Long r18 = (Long) ZeusTransformUtils.preCheckCast(r17.next(), Long.class, r3);     // Catch: Throwable -> L77
        r4 = r4;
        List r19 = (List) ZeusTransformUtils.preCheckCast(r4.get(r18), List.class, r3);     // Catch: Throwable -> L77
        if (r19 == null) goto L18;
        Iterator r110 = r17;
        int r111 = 0;
    L24:
        if (r111 >= r19.size()) goto L68;
        List r112 = r19;
        int r113 = r111;
        JSONObject r114 = new JSONObject(new String(((com.bytedance.apm6.consumer.slardar.c.b) ZeusTransformUtils.preCheckCast(r19.get(r111), com.bytedance.apm6.consumer.slardar.c.b.class, r3)).a()));     // Catch: Exception -> L83 Throwable -> L77
        if (com.bytedance.apm6.consumer.slardar.d.a.a.a().a(r114, com.bytedance.apm6.foundation.context.a.g()) == false) goto L32;
        f r20 = a(r114);     // Catch: Throwable -> L77
        if (ZeusTransformUtils.instanceOf(r20, f.b.class) == true) goto L94;
        r1 = r1;
        Long r22 = r18;
        String r115 = r3;
        f r21 = r20;
    L59:
        Map r25 = (Map) ZeusTransformUtils.preCheckCast(r15.get(r21), Map.class, r115);     // Catch: Throwable -> L77
        if (r25 != null) goto L62;
        r25 = new HashMap();     // Catch: Throwable -> L77
        r15.put(r21, r25);     // Catch: Throwable -> L77
    L62:
        r18 = r22;
        if (r25.containsKey(r18) == true) goto L65;
        r25.put(r18, new JSONArray());     // Catch: Throwable -> L77
    L65:
        ((JSONArray) ZeusTransformUtils.preCheckCast(r25.get(r18), JSONArray.class, r115)).put(r114);     // Catch: Throwable -> L77
    L67:
        r111 = r113 + 1;     // Catch: Throwable -> L77
        r3 = r115;
        r19 = r112;
        r18 = r18;
        r1 = r1;
        goto L24
    L94:
        JSONObject r116 = r114.optJSONObject(r1);     // Catch: Exception -> L51 Throwable -> L77
        if (r116 != null) goto L41;
        r116 = new JSONObject();     // Catch: Exception -> L51 Throwable -> L77
        r114.put(r1, r116);     // Catch: Exception -> L51 Throwable -> L77
    L41:
        r1 = r1;
        r22 = r18;
        r116.put("debug_sender_number", f5161a.getAndIncrement());     // Catch: Exception -> L50 Throwable -> L77
        r115 = r3;
        f r26 = r20;
        r116.put("debug_sender_sid", com.bytedance.apm6.foundation.context.a.c());     // Catch: Exception -> L81 Throwable -> L77
        r116.put("debug_total_bytes", r7);     // Catch: Exception -> L81 Throwable -> L77
        r116.put("debug_total_count", r9);     // Catch: Exception -> L81 Throwable -> L77
        r116.put("debug_merge_file_count", r5);     // Catch: Exception -> L81 Throwable -> L77
        r116.put("debug_second_file_count", r13);     // Catch: Exception -> L81 Throwable -> L77
        r116.put("debug_left_file_count", r24);     // Catch: Exception -> L80 Throwable -> L77
    L55:
        if (r114.has("seq_no") == false) goto L57;
        r16.add(String.valueOf(r114.get("seq_no")));     // Catch: Throwable -> L77
    L57:
        r21 = r26;
    L50:
        r115 = r3;
        r26 = r20;
    L52:
        r26 = r20;
        r22 = r18;
        r115 = r3;
    L51:
        r1 = r1;
        goto L52
    L32:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L35;
        com.bytedance.apm6.util.c.b.a("APM-Downgrade", r114.toString());     // Catch: Throwable -> L77
    L35:
        r115 = r3;
    L66:
        r113 = r111;
        goto L35
    L68:
        r3 = r3;
        r17 = r110;
        goto L18
    L69:
        String r117 = r3;
        HashMap r0 = new HashMap();     // Catch: Throwable -> L77
        Iterator r27 = r15.keySet().iterator();     // Catch: Throwable -> L77
    L71:
        if (r27.hasNext() == false) goto L74;
        f r28 = (f) ZeusTransformUtils.preCheckCast(r27.next(), f.class, r117);     // Catch: Throwable -> L77
        r0.put(r28, r28.a((HashMap) ZeusTransformUtils.preCheckCast(r15.get(r28), HashMap.class, r117)));     // Catch: Throwable -> L77
        goto L71
    L74:
        if (com.bytedance.apm.h.a.c() == null) goto L76;
        com.bytedance.apm.h.a.c().b(com.bytedance.apm6.consumer.slardar.a.f5054a, "seqNoList:" + r16.toString());     // Catch: Throwable -> L77
    L76:
        return r0;
    L15:
        r13 = 0;
    L77:
        th = move-exception;
        com.bytedance.apm6.util.c.b.b(com.bytedance.apm6.consumer.slardar.a.f5054a, "LogSender serialize failed.", th);
        return null;
    }

    private static void a(Map<Long, List<com.bytedance.apm6.consumer.slardar.c.b>> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L12;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "sendLog: input sendList merged into " + r12.size() + " group(s)");
        Iterator r0 = r12.keySet().iterator();
        int r3 = 0;
    L6:
        if (r0.hasNext() == false) goto L15;
        Long r4 = (Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.preCheckCast(r12.get(r4), List.class, "com.obric.aiagent.plugin");
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "----------------");
        int r9 = r3 + 1;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "group " + r3 + " header:" + com.bytedance.apm6.consumer.slardar.b.b.a().a(String.valueOf(r4)));
        int r6 = 0;
    L9:
        if (r6 >= r5.size()) goto L11;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "  log[" + r6 + "]=" + ((com.bytedance.apm6.consumer.slardar.c.b) ZeusTransformUtils.preCheckCast(r5.get(r6), com.bytedance.apm6.consumer.slardar.c.b.class, "com.obric.aiagent.plugin")).toString());
        r6 = r6 + 1;
        goto L9
    L11:
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "----------------");
        r3 = r9;
        goto L6
    L15:
        return;
    }

    private static f a(JSONObject r1) {
        String r2 = r1.optString("log_type");
        if (com.bytedance.apm6.consumer.slardar.a.f5055b.contains(r2) == false) goto L7;
        return f5164d;
    L7:
        if (f5162b.contains(r2) == false) goto L11;
        return f5165e;
    L11:
        return f;
    }
}
