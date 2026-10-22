package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.apm.constant.CommonKey;
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

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicInteger f6742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f6743b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List f6744c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final UploadLogInfo.a f6745d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final UploadLogInfo.c f6746e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final UploadLogInfo.b f6747f = null;

    static {
        f6742a = new AtomicInteger(0);
        f6743b = Arrays.asList(new String[]{"tracing"});
        UploadLogInfo.a r10 = new UploadLogInfo.a();
        f6745d = r10;
        UploadLogInfo.c r11 = new UploadLogInfo.c();
        f6746e = r11;
        UploadLogInfo.b r12 = new UploadLogInfo.b();
        f6747f = r12;
        ArrayList r13 = new ArrayList();
        f6744c = r13;
        r13.add(r10);
        r13.add(r11);
        r13.add(r12);
    }

    public static void a(Map r10) {
        if (r3.a.c() == false) goto L12;
        s3.a.a(n2.a.f22354a, "sendLog: input sendList merged into " + r10.size() + " group(s)");
        Iterator r11 = r10.keySet().iterator();
        int r12 = 0;
    L6:
        if (r11.hasNext() == false) goto L15;
        Long r13 = (Long) r11.next();
        List r14 = (List) r10.get(r13);
        s3.a.a(n2.a.f22354a, "----------------");
        p2.a r15 = p2.b.f().e(String.valueOf(r13));
        String r16 = n2.a.f22354a;
        StringBuilder r17 = new StringBuilder();
        r17.append("group ");
        int r18 = r12 + 1;
        r17.append(r12);
        r17.append(" header:");
        r17.append(r15);
        s3.a.a(r16, r17.toString());
        int r19 = 0;
    L9:
        if (r19 >= r14.size()) goto L11;
        s3.a.a(n2.a.f22354a, "  log[" + r19 + "]=" + ((q2.b) r14.get(r19)).toString());
        r19 = r19 + 1;
        goto L9
    L11:
        s3.a.a(n2.a.f22354a, "----------------");
        r12 = r18;
        goto L6
    L15:
        return;
    }

    public static UploadLogInfo b(JSONObject r10) {
        String r11 = r10.optString("log_type");
        if (n2.a.f22355b.contains(r11) == false) goto L7;
        return f6745d;
    L7:
        if (f6743b.contains(r11) == false) goto L11;
        return f6746e;
    L11:
        return f6747f;
    }

    public static List c() {
        return f6744c;
    }

    public static Map d(List r22, int r23) {
        String r10 = "_debug_self";
        HashMap r11 = new HashMap();     // Catch: Throwable -> L9
        long r12 = r22.size();     // Catch: Throwable -> L9
        Iterator r13 = r22.iterator();     // Catch: Throwable -> L9
        long r14 = 0;
        long r15 = 0;
    L5:
        if (r13.hasNext() == false) goto L12;
        q2.a r16 = (q2.a) r13.next();     // Catch: Throwable -> L9
        long r17 = r16.e();     // Catch: Throwable -> L9
        List r18 = (List) r11.get(Long.valueOf(r17));     // Catch: Throwable -> L9
        if (r18 != null) goto L11;
        r18 = new ArrayList();     // Catch: Throwable -> L9
        r11.put(Long.valueOf(r17), r18);     // Catch: Throwable -> L9
    L11:
        r14 = r14 + ((long) r16.f());     // Catch: Throwable -> L9
        r15 = r15 + ((long) r16.g());     // Catch: Throwable -> L9
        r18.addAll(r16.c());     // Catch: Throwable -> L9
        goto L5
    L12:
        a(r11);     // Catch: Throwable -> L9
        File r19 = a.f().e();     // Catch: Throwable -> L9
        if (r19 == null) goto L17;
        String[] r20 = r19.list();     // Catch: Throwable -> L9
        if (r20 == null) goto L17;
        int r21 = r20.length;     // Catch: Throwable -> L9
    L18:
        HashMap r110 = new HashMap();     // Catch: Throwable -> L9
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L9
        Iterator r112 = r11.keySet().iterator();     // Catch: Throwable -> L9
    L20:
        if (r112.hasNext() == false) goto L72;
        Long r113 = (Long) r112.next();     // Catch: Throwable -> L9
        List r114 = (List) r11.get(r113);     // Catch: Throwable -> L9
        if (r114 == null) goto L20;
        HashMap r115 = r11;
        int r116 = 0;
    L26:
        if (r116 >= r114.size()) goto L71;
        Iterator r117 = r112;
        List r118 = r114;
        JSONObject r119 = new JSONObject(new String(((q2.b) r114.get(r116)).a()));     // Catch: Throwable -> L9 Exception -> L85
        if (com.bytedance.apm6.consumer.slardar.send.downgrade.a.a().d(r119, d3.a.h()) == false) goto L35;
        UploadLogInfo r24 = b(r119);     // Catch: Throwable -> L9
        if ((r24 instanceof UploadLogInfo.b) == true) goto L98;
        r10 = r10;
        r116 = r116;
        r110 = r110;
    L62:
        Map r120 = (Map) r110.get(r24);     // Catch: Throwable -> L9
        if (r120 != null) goto L66;
        r120 = new HashMap();     // Catch: Throwable -> L9
        r110.put(r24, r120);     // Catch: Throwable -> L9
    L66:
        if (r120.containsKey(r113) == true) goto L68;
        r120.put(r113, new JSONArray());     // Catch: Throwable -> L9
    L68:
        ((JSONArray) r120.get(r113)).put(r119);     // Catch: Throwable -> L9
        goto L70
    L98:
        JSONObject r121 = r119.optJSONObject(r10);     // Catch: Throwable -> L9 Exception -> L45
        if (r121 != null) goto L44;
        r121 = new JSONObject();     // Catch: Throwable -> L9 Exception -> L45
        r119.put(r10, r121);     // Catch: Throwable -> L9 Exception -> L45
    L44:
        r10 = r10;
        r116 = r116;
        r121.put("debug_sender_number", f6742a.getAndIncrement());     // Catch: Throwable -> L9 Exception -> L56
        HashMap r25 = r110;
        r121.put("debug_sender_sid", d3.a.u());     // Catch: Throwable -> L9 Exception -> L83
        r121.put("debug_total_bytes", r14);     // Catch: Throwable -> L9 Exception -> L83
        r121.put("debug_total_count", r15);     // Catch: Throwable -> L9 Exception -> L83
        r121.put("debug_merge_file_count", r12);     // Catch: Throwable -> L9 Exception -> L83
        r121.put("debug_second_file_count", r21);     // Catch: Throwable -> L9 Exception -> L83
        r121.put("debug_left_file_count", r23);     // Catch: Throwable -> L9 Exception -> L82
    L58:
        if (r119.has(CommonKey.KEY_SEQ_NO) == false) goto L60;
        r111.add(String.valueOf(r119.get(CommonKey.KEY_SEQ_NO)));     // Catch: Throwable -> L9
    L60:
        r110 = r25;
    L56:
        r25 = r110;
    L46:
        r116 = r116;
        r25 = r110;
    L45:
        r10 = r10;
        goto L46
    L35:
        if (r3.a.c() == false) goto L70;
        s3.a.a("APM-Downgrade", r119.toString());     // Catch: Throwable -> L9
    L70:
        r110 = r110;
        r116 = r116 + 1;     // Catch: Throwable -> L9
        r112 = r117;
        r114 = r118;
        r10 = r10;
    L69:
        r118 = r114;
        goto L70
    L71:
        r11 = r115;
        goto L20
    L72:
        HashMap r26 = r110;
        HashMap r27 = new HashMap();     // Catch: Throwable -> L9
        Iterator r28 = r26.keySet().iterator();     // Catch: Throwable -> L9
    L74:
        if (r28.hasNext() == false) goto L77;
        UploadLogInfo r29 = (UploadLogInfo) r28.next();     // Catch: Throwable -> L9
        r27.put(r29, r29.serialize((HashMap) r26.get(r29)));     // Catch: Throwable -> L9
        goto L74
    L77:
        if (s1.a.c() == null) goto L79;
        s1.a.c().d(n2.a.f22354a, "seqNoList:" + r111.toString());     // Catch: Throwable -> L9
    L79:
        return r27;
    L17:
        r21 = 0;
    L9:
        th = move-exception;
        s3.a.c(n2.a.f22354a, "LogSender serialize failed.", th);
        return null;
    }
}
