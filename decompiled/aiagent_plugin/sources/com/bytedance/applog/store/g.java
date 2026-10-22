package com.bytedance.applog.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.applog.log.l;
import com.bytedance.applog.monitor.v3.MonitorV3Helper;
import com.bytedance.applog.monitor.v3.j;
import com.bytedance.applog.util.p;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Pack.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends a {
    private static final SimpleDateFormat ab = null;
    long A;
    f B;
    JSONArray C;
    i D;
    JSONArray E;
    long F;
    public int G;
    public String H;
    private JSONArray I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private JSONObject f5996J;
    private JSONArray K;
    private String L;
    private String M;
    private String N;
    private com.bytedance.applog.priority.b O;
    private String P;
    private String Q;
    private String R;
    private String S;
    private JSONObject T;
    private int U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private int Z;
    private int aa;
    public byte[] u;
    int v;
    public int w;
    JSONArray x;
    long y;
    JSONArray z;

    @Override // com.bytedance.applog.store.a
    String h() {
        return "pack";
    }

    static {
        ab = com.bytedance.applog.util.d.a();
    }

    public g() {
        this.aa = 0;
    }

    public static g a(String r1, JSONObject r2, long r3, JSONObject r5) {
        g r0 = new g();
        r0.a(r3);
        r0.a(r1);
        r0.e(r2);
        r0.d(r5);
        return r0;
    }

    public static g a(String r3, JSONObject r4, JSONArray r5, int r6) {
        g r0 = new g();
        r0.a(0);
        r0.a(r3);
        r0.e(r4);
        r0.b(r6);
        r0.a(r5);
        return r0;
    }

    public static g a(com.bytedance.applog.c r15, List<a> r16, JSONObject r17, com.bytedance.applog.priority.b r18) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        g r13 = new g();
        JSONArray[] r8 = {null, new JSONArray(), null};     // Catch: Throwable -> L9
        long[] r9 = new long[3];     // Catch: Throwable -> L9
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L9
    L5:
        if (r2.hasNext() == false) goto L7;
        r8[1].put(((a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.aiagent.plugin")).k());     // Catch: Throwable -> L9
        goto L5
    L7:
        r13.a(r15.b(), r17, null, null, null, r8, r9, null, r18, 8);     // Catch: Throwable -> L9
        r13.r();     // Catch: Throwable -> L9
        a(r15.b(), r0);     // Catch: Throwable -> L9
    L11:
        return r13;
    L9:
        th = move-exception;
        r15.Z().a(4, "pack real time failed", th, new Object[0]);
        goto L11
    }

    public void a(String r3, JSONObject r4, f r5, i r6, JSONArray r7, JSONArray[] r8, long[] r9, JSONArray r10, com.bytedance.applog.priority.b r11, int r12) {
        a(0);
        this.f5996J = r4;
        this.B = r5;
        this.D = r6;
        this.C = r7;
        int r13 = 0;
        this.x = r8[0];
        this.y = r9[0];
        int r14 = 1;
        this.z = r8[1];
        this.A = r9[1];
        this.E = r8[2];
        this.F = r9[2];
        this.K = r10;
        this.O = r11;
        if (r11 == null) goto L5;
        this.o = r11.a();
    L6:
        this.aa = r12;
        this.m = r3;
        this.N = null;
        this.G = 0;
        this.H = null;
        this.L = null;
        this.M = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.v = 0;
        this.u = null;
        if (this.B == null) goto L9;
        int r15 = 1;
    L10:
        this.U = r15;
        if (this.D != null) goto L14;
        r14 = 0;
    L14:
        this.V = r14;
        JSONArray r16 = this.x;
        if (r16 == null) goto L17;
        int r17 = r16.length();
    L18:
        this.W = r17;
        JSONArray r18 = this.z;
        if (r18 == null) goto L21;
        int r19 = r18.length();
    L22:
        this.X = r19;
        JSONArray r20 = this.E;
        if (r20 == null) goto L25;
        int r21 = r20.length();
    L26:
        this.Y = r21;
        JSONArray r22 = this.K;
        if (r22 == null) goto L29;
        r13 = r22.length();
    L29:
        this.Z = r13;
        return;
    L25:
        r21 = 0;
        goto L26
    L21:
        r19 = 0;
        goto L22
    L17:
        r17 = 0;
        goto L18
    L9:
        r15 = 0;
        goto L10
    L5:
        this.o = -1;
        goto L6
    }

    @Override // com.bytedance.applog.store.a
    public List<String> e() {
        return Arrays.asList(new String[]{"_id", "integer primary key autoincrement", "local_time_ms", WsChannelMultiProcessSharedProvider.INT_TYPE, "_data", "blob", "session_id", "varchar", "_fail", WsChannelMultiProcessSharedProvider.INT_TYPE, "event_count", "varchar", "key", "varchar", "iv", "varchar", "data_json", "text", "_app_id", "varchar", "encode_type", WsChannelMultiProcessSharedProvider.INT_TYPE, "encode_headers", "varchar", "priority", WsChannelMultiProcessSharedProvider.INT_TYPE, "forward", WsChannelMultiProcessSharedProvider.INT_TYPE, "e_ids", "varchar", "isolate_key", "varchar", "isolate_key_value", "varchar", "_launch_count", WsChannelMultiProcessSharedProvider.INT_TYPE, "_terminate_count", WsChannelMultiProcessSharedProvider.INT_TYPE, "_event_v1_count", WsChannelMultiProcessSharedProvider.INT_TYPE, "_event_v3_count", WsChannelMultiProcessSharedProvider.INT_TYPE, "_event_misc_count", WsChannelMultiProcessSharedProvider.INT_TYPE, "_impression_count", WsChannelMultiProcessSharedProvider.INT_TYPE, "sentry_stained_ids", "varchar"});
    }

    @Override // com.bytedance.applog.store.a
    public int a(Cursor r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.aiagent.plugin");
        this.f5991a = r4.getLong(0);
        this.f5992b = r4.getLong(1);
        this.u = r4.getBlob(2);
        this.f5994d = r4.getString(3);
        this.v = r4.getInt(4);
        r4.getString(5);
        this.L = r4.getString(6);
        this.M = r4.getString(7);
        this.N = r4.getString(8);
        this.m = r4.getString(9);
        this.G = r4.getInt(10);
        this.H = r4.getString(11);
        this.o = r4.getInt(12);
        this.p = r4.getInt(13);
        this.P = r4.getString(14);
        this.R = r4.getString(15);
        this.S = r4.getString(16);
        this.U = r4.getInt(17);
        this.V = r4.getInt(18);
        this.W = r4.getInt(19);
        this.X = r4.getInt(20);
        this.Y = r4.getInt(21);
        this.Z = r4.getInt(22);
        this.Q = r4.getString(23);
        this.f5996J = null;
        this.B = null;
        this.D = null;
        this.C = null;
        this.x = null;
        this.z = null;
        this.E = null;
        this.K = null;
        return 24;
    }

    @Override // com.bytedance.applog.store.a
    public void a(ContentValues r4) {
        r4.put("local_time_ms", Long.valueOf(this.f5992b));     // Catch: Throwable -> L4
        r4.put("_data", r());     // Catch: Throwable -> L4
        r4.put("session_id", this.f5994d);     // Catch: Throwable -> L4
        r4.put("key", this.L);     // Catch: Throwable -> L4
        r4.put("iv", this.M);     // Catch: Throwable -> L4
        r4.put("encode_type", Integer.valueOf(this.G));     // Catch: Throwable -> L4
        r4.put("encode_headers", this.H);     // Catch: Throwable -> L4
        r4.put("data_json", this.N);     // Catch: Throwable -> L4
        r4.put("_app_id", this.m);     // Catch: Throwable -> L4
        r4.put("priority", Integer.valueOf(this.o));     // Catch: Throwable -> L4
        r4.put("forward", Integer.valueOf(this.p));     // Catch: Throwable -> L4
        r4.put("e_ids", this.P);     // Catch: Throwable -> L4
        r4.put("isolate_key", this.R);     // Catch: Throwable -> L4
        r4.put("isolate_key_value", this.S);     // Catch: Throwable -> L4
        r4.put("_launch_count", Integer.valueOf(this.U));     // Catch: Throwable -> L4
        r4.put("_terminate_count", Integer.valueOf(this.V));     // Catch: Throwable -> L4
        r4.put("_event_v1_count", Integer.valueOf(this.W));     // Catch: Throwable -> L4
        r4.put("_event_v3_count", Integer.valueOf(this.X));     // Catch: Throwable -> L4
        r4.put("_event_misc_count", Integer.valueOf(this.Y));     // Catch: Throwable -> L4
        r4.put("_impression_count", Integer.valueOf(this.Z));     // Catch: Throwable -> L4
        r4.put("sentry_stained_ids", this.Q);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        q().a(5, "write pack to db failed", th, new Object[0]);
    }

    public byte[] r() {
        return c(k().toString());
    L4:
        com.bytedance.applog.c r0 = com.bytedance.applog.b.b(this.m);
        if (r0 == null) goto L7;
        r0.N().increaseStats(j.H);
    L7:
        x();
        return null;
    }

    public byte[] c(String r10) {
        this.u = null;
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L26:
        this.H = p.a(r0);
        return this.u;
    L5:
        if (com.bytedance.applog.b.a(this.m) == false) goto L26;
        com.bytedance.applog.c r1 = com.bytedance.applog.b.b(this.m);
        if (r1 == null) goto L26;
        byte[] r11 = r10.getBytes("UTF-8");     // Catch: Throwable -> L24
        this.u = r11;     // Catch: Throwable -> L24
        if (r11 == null) goto L26;
        if (r11.length <= 0) goto L26;
        if (r1.L() == null) goto L21;
        com.bytedance.applog.e r12 = r1.L().a(this.u);     // Catch: Throwable -> L17
        this.u = r12.a();     // Catch: Throwable -> L17
        this.G = r12.b();     // Catch: Throwable -> L17
        r0.putAll(r12.c());     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        q().a(4, this.t, "log compress toBytes failed", th, new Object[0]);     // Catch: Throwable -> L24
        r1.N().increaseStats(j.M);     // Catch: Throwable -> L24
    L21:
        if (r1.k() == false) goto L26;
        this.u = r1.V().a().b(this.u);     // Catch: Throwable -> L24
        r0.remove(DownloadHelper.CONTENT_ENCODING);     // Catch: Throwable -> L24
        r0.put(DownloadHelper.CONTENT_TYPE, "application/octet-stream;tt-data=a");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        q().a(4, this.t, "toBytes failed", th, new Object[0]);
        r1.N().increaseStats(j.f5823J);
        goto L26
    }

    @Override // com.bytedance.applog.store.a
    public void a(JSONObject r4) {
        q().d(4, this.t, "write ipc not implemented", new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.applog.k.a] */
    /* JADX WARN: Type inference failed for: r14v12, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v5, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r7v39, types: [java.lang.Object, org.json.JSONObject] */
    @Override // com.bytedance.applog.store.a
    public JSONObject f() {
        JSONObject r0 = this.T;
        String r2 = "iv";
        if (r0 == null) goto L6;
        this.L = r0.optString("key");
        this.M = this.T.optString("iv");
        return this.T;
    L6:
        HashSet r1 = new HashSet();
        ArrayList r4 = new ArrayList();
        com.bytedance.applog.c r5 = com.bytedance.applog.b.b(this.m);
        ?? r6 = new JSONObject();
        r6.put("magic_tag", "ss_app_log");
        r6.put("header", this.f5996J);
        if (r5 != null) goto L9;
    L11:
        r6.put("_gen_time", System.currentTimeMillis());
        f r7 = this.B;
        if (r7 == null) goto L14;
        int r10 = 1;
    L15:
        this.U = r10;
        if (r7 != null) goto L18;
    L24:
        i r8 = this.D;
        if (r8 == null) goto L27;
        int r12 = 1;
    L28:
        this.V = r12;
        if (r8 != null) goto L31;
        String r20 = "iv";
    L52:
        JSONArray r3 = this.I;
        if (r3 != null) goto L55;
    L64:
        JSONArray r9 = this.x;
        if (r9 == null) goto L67;
        int r11 = r9.length();
    L68:
        this.W = r11;
        String r13 = "event";
        String r14 = "event_stained";
        String r15 = "event_id";
        if (r11 <= 0) goto L82;
        JSONArray r16 = new JSONArray();
        int r17 = 0;
        ?? r18 = r6;
    L72:
        if (r17 >= this.x.length()) goto L81;
        JSONObject r19 = this.x.getJSONObject(r17);
        com.bytedance.applog.c r110 = r5;
        ?? r21 = r18;
        long r111 = r19.optLong(r15, 0);
        if (r111 <= 0) goto L77;
        r1.add(Long.valueOf(r111));
    L77:
        if (r19.optInt(r14, 0) <= 0) goto L80;
        r4.add(new com.bytedance.applog.monitor.v3.h(r19.optString("tag", ""), String.valueOf(r19.optLong("monitor_id", 0)), r19.optLong("local_time_ms", 0), com.bytedance.applog.monitor.v3.i.f5807b));
    L80:
        r16.put(r19);
        r17 = r17 + 1;
        r14 = r14;
        r5 = r110;
        r18 = r21;
        r15 = r15;
        goto L72
    L81:
        com.bytedance.applog.c r112 = r5;
        ?? r22 = r18;
        String r23 = r14;
        String r30 = r15;
        r22.put("event", r16);
        ?? r24 = r22;
    L83:
        JSONArray r25 = this.z;
        if (r25 == null) goto L86;
        int r26 = r25.length();
    L87:
        this.X = r26;
        if (r26 <= 0) goto L101;
        JSONArray r27 = new JSONArray();
        int r113 = 0;
    L91:
        if (r113 >= this.z.length()) goto L100;
        JSONObject r114 = this.z.getJSONObject(r113);
        com.bytedance.applog.c r28 = r112;
        String r115 = r30;
        long r116 = r114.optLong(r115, 0);
        if (r116 <= 0) goto L96;
        r1.add(Long.valueOf(r116));
    L96:
        if (r114.optInt(r23, 0) <= 0) goto L99;
        r4.add(new com.bytedance.applog.monitor.v3.h(r114.optString(r13, ""), String.valueOf(r114.optLong("monitor_id", 0)), r114.optLong("local_time_ms", 0), com.bytedance.applog.monitor.v3.i.f5806a));
    L99:
        r27.put(r114);
        r113 = r113 + 1;
        r13 = r13;
        r112 = r28;
        r23 = r23;
        r30 = r115;
        goto L91
    L100:
        com.bytedance.applog.c r29 = r112;
        String r117 = r30;
        String r31 = r23;
        r24.put("event_v3", r27);
    L102:
        JSONArray r32 = this.E;
        if (r32 == null) goto L105;
        int r33 = r32.length();
    L106:
        this.Y = r33;
        if (r33 <= 0) goto L120;
        JSONArray r34 = new JSONArray();
        int r35 = 0;
    L110:
        if (r35 >= this.E.length()) goto L119;
        JSONObject r36 = this.E.getJSONObject(r35);
        long r118 = r36.optLong(r117, 0);
        if (r118 <= 0) goto L114;
        r1.add(Long.valueOf(r118));
    L114:
        String r119 = r31;
        if (r36.optInt(r119, 0) <= 0) goto L118;
        r4.add(new com.bytedance.applog.monitor.v3.h(r36.optString("log_type", ""), String.valueOf(r36.optLong("monitor_id", 0)), r36.optLong("local_time_ms", 0), com.bytedance.applog.monitor.v3.i.f5808c));
    L118:
        r34.put(r36);
        r35 = r35 + 1;
        r117 = r117;
        r31 = r119;
        goto L110
    L119:
        r24.put("log_data", r34);
    L120:
        JSONArray r37 = this.K;
        if (r37 == null) goto L123;
        int r38 = r37.length();
    L124:
        this.Z = r38;
        if (r38 <= 0) goto L127;
        r24.put("item_impression", this.K);
    L127:
        this.P = a(r1);
        this.Q = a(r4);
        if (r29 == null) goto L180;
        r29.V().a(r24, true);
        JSONObject r39 = new JSONObject();
        r39.put("request_from", this.aa);
        if (r29.aj() <= 0) goto L182;
        JSONObject r40 = new JSONObject();
        r40.put("capability", r29.aj());
        com.bytedance.applog.e.f r41 = r29.D();
        if (r41 != null) goto L134;
    L139:
        r39.put("event_sampling", r40);
        goto L182
    L134:
        if (r41.b() == null) goto L139;
        if (r29.aj() != r41.b().b()) goto L138;
        r40.put("version", r41.b().a());
    L138:
        r40.put("config_ids", r41.b().c());
    L182:
        JSONObject r42 = r29.I();     // Catch: Throwable -> L144
        if (r42 == null) goto L184;
        r39.put("expected_batch_interval", r42);     // Catch: Throwable -> L144
    L184:
        JSONObject r43 = r29.J();     // Catch: Throwable -> L150
        if (r43 == null) goto L153;
        r39.put("log_back", r43);     // Catch: Throwable -> L150
    L153:
        if (r29.A() == false) goto L159;
        JSONObject r44 = new JSONObject();
        r44.put("enable", 1);
        if (r29.ai() == null) goto L157;
        r44.put("version", r29.ai().b());
    L157:
        r44.put("value", this.o);
        r39.put("applog_priority", r44);
    L159:
        if (r29.ag() == false) goto L168;
        JSONObject r45 = new JSONObject();     // Catch: Throwable -> L165
        r45.put("enable", 1);     // Catch: Throwable -> L165
        if (r29.ah() == null) goto L163;
        r45.put("version", r29.ah().a());     // Catch: Throwable -> L165
    L163:
        r39.put("applog_forward", r45);     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        r29.Z().a("build forward to pack failed", th, new Object[0]);
    L168:
        if (r29.N().isStageForAllEvents() == false) goto L170;
        int r46 = 1;
    L172:
        if (r29.N().isDebugMode() == false) goto L174;
        r46 = r46 | 2;
    L174:
        if (r46 <= 0) goto L177;
        r39.put("sentry_stained", r46);
    L177:
        if (r29.ar() == null) goto L179;
        r29.ar().a(r39);
    L179:
        r24.put("options", r39);
        goto L180
    L170:
        r46 = 0;
    L150:
        th = move-exception;
        r29.Z().a("build logback to pack failed", th, new Object[0]);
    L144:
        th = move-exception;
        r29.Z().a("build expected batch interval to pack failed", th, new Object[0]);
    L180:
        this.L = r24.optString("key");
        this.M = r24.optString(r20);
        q().c(4, "pack -> ts:{}, launch:{}, terminate:{}, v1:{}, v3:{}, misc:{}, impression:{}", new Object[]{Long.valueOf(this.f5992b), this.B, this.D, Integer.valueOf(this.W), Integer.valueOf(this.X), Integer.valueOf(this.Y), Integer.valueOf(this.Z)});
        return r24;
    L123:
        r38 = 0;
        goto L124
    L105:
        r33 = 0;
        goto L106
    L101:
        r29 = r112;
        r117 = r30;
        r31 = r23;
        goto L102
    L86:
        r26 = 0;
        goto L87
    L82:
        r112 = r5;
        r24 = r6;
        r23 = "event_stained";
        r30 = "event_id";
        goto L83
    L67:
        r11 = 0;
        goto L68
    L55:
        if (r3.length() <= 0) goto L64;
        JSONArray r47 = r6.optJSONArray("terminate");
        if (r47 != null) goto L59;
        r47 = new JSONArray();
    L59:
        int r48 = 0;
    L61:
        if (r48 >= this.I.length()) goto L63;
        r47.put(this.I.get(r48));
        r48 = r48 + 1;
        goto L61
    L63:
        this.V += this.I.length();
        r6.put("terminate", r47);
        goto L64
    L31:
        if (r8.q <= 0) goto L34;
        r1.add(Long.valueOf(this.D.q));
    L34:
        if (this.D.s <= 0) goto L36;
        r4.add(new com.bytedance.applog.monitor.v3.h("terminate", String.valueOf(this.D.r), this.D.f5992b, com.bytedance.applog.monitor.v3.i.f5810e));
    L36:
        ?? r49 = this.D.k();
        ?? r120 = new JSONObject();
        r120.put("terminate", r49);
        this.N = r120.toString();
        JSONArray r121 = this.C;
        if (r121 == null) goto L39;
        int r122 = r121.length();
    L40:
        JSONArray r123 = new JSONArray();
        int r124 = 0;
    L41:
        if (r124 >= r122) goto L43;
        JSONArray r125 = new JSONArray();
        JSONObject r50 = new JSONObject(new JSONObject(this.C.optString(r124)).optString("params"));
        r125.put(0, r50.optString("page_key", ""));
        r125.put(1, (r50.optInt("duration", 0) + 999) / 1000);
        r123.put(r125);
        r124 = r124 + 1;
        r2 = r2;
        goto L41
    L43:
        r20 = r2;
        if (r122 <= 0) goto L46;
        r49.put("activites", r123);
    L46:
        if (r5 != null) goto L48;
    L50:
        ?? r51 = new JSONArray();
        r51.put(r49);
        r6.put("terminate", r51);
        goto L52
    L48:
        if (r5.C() <= 0) goto L50;
        r49.put("launch_from", r5.C());
        r5.a(0);
        goto L50
    L39:
        r122 = 0;
        goto L40
    L27:
        r12 = 0;
        goto L28
    L18:
        if (r7.q <= 0) goto L21;
        r1.add(Long.valueOf(this.B.q));
    L21:
        if (this.B.s <= 0) goto L23;
        r4.add(new com.bytedance.applog.monitor.v3.h("launch", String.valueOf(this.B.r), this.B.f5992b, com.bytedance.applog.monitor.v3.i.f5809d));
    L23:
        JSONArray r52 = new JSONArray();
        r52.put(this.B.k());
        r6.put("launch", r52);
        goto L24
    L14:
        r10 = 0;
        goto L15
    L9:
        if (r5.V().f5671a == null) goto L11;
        r6.put("time_sync", r5.V().f5671a);
        goto L11
    }

    @Override // com.bytedance.applog.store.a
    public a b(JSONObject r4) {
        q().d(4, this.t, "read ipc not implemented", new Object[0]);
        return null;
    }

    @Override // com.bytedance.applog.store.a
    public String m() {
        return String.valueOf(this.f5991a);
    }

    public String[] s() {
        return new String[]{this.L, this.M};
    }

    public Set<Long> t() {
        return d(this.P);
    }

    public List<com.bytedance.applog.monitor.v3.h> u() {
        return e(this.Q);
    }

    private Set<Long> d(String r11) {
        HashSet r0 = new HashSet();
        if (TextUtils.isEmpty(r11) == false) goto L16;
        return r0;
    L16:
        int r3 = r11.indexOf(":");     // Catch: Throwable -> L13
        if (r3 >= 0) goto L9;
        r0.add(Long.valueOf(Long.parseLong(r11)));     // Catch: Throwable -> L13
    L15:
        return r0;
    L9:
        long r4 = Long.parseLong(r11.substring(0, r3));     // Catch: Throwable -> L13
        r0.add(Long.valueOf(r4));     // Catch: Throwable -> L13
        String[] r5 = r11.substring(r3 + 1).split(",");     // Catch: Throwable -> L13
        int r6 = r5.length;     // Catch: Throwable -> L13
        int r7 = 0;
    L10:
        if (r7 >= r6) goto L15;
        r4 = r4 + Long.parseLong(r5[r7]);     // Catch: Throwable -> L13
        r0.add(Long.valueOf(r4));     // Catch: Throwable -> L13
        r7 = r7 + 1;
    L13:
        th = move-exception;
        q().f("Cannot parse set ids:{}!", new Object[]{r11, th});
        goto L15
    }

    private String a(Set<Long> r7) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
        if (r6.isEmpty() == true) goto L15;
        Long[] r8 = (Long[]) ZeusTransformUtils.preCheckCast(r6.toArray(new Long[0]), Long[].class, "com.obric.aiagent.plugin");
        Arrays.sort(r8);
        StringBuilder r0 = new StringBuilder();
        r0.append(r8[0]);
        if (r8.length <= 1) goto L14;
        r0.append(":");
        int r9 = 1;
    L8:
        if (r9 >= r8.length) goto L14;
        r0.append(r8[r9].longValue() - r8[r9 - 1].longValue());
        if (r9 == (r8.length - 1)) goto L12;
        r0.append(",");
    L12:
        r9 = r9 + 1;
    L14:
        return r0.toString();
    L15:
        return "";
    }

    private String a(List<com.bytedance.applog.monitor.v3.h> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        JSONArray r5 = new JSONArray();
        if (r3.isEmpty() == true) goto L9;
        Iterator r6 = r3.iterator();
    L6:
        if (r6.hasNext() == false) goto L9;
        r5.put(((com.bytedance.applog.monitor.v3.h) ZeusTransformUtils.preCheckCast(r6.next(), com.bytedance.applog.monitor.v3.h.class, "com.obric.aiagent.plugin")).a());
    L9:
        return r5.toString();
    }

    private List<com.bytedance.applog.monitor.v3.h> e(String r7) {
        ArrayList r0 = new ArrayList();
        if (TextUtils.isEmpty(r7) == false) goto L14;
        return r0;
    L14:
        JSONArray r2 = new JSONArray(r7);     // Catch: Throwable -> L11
        int r3 = 0;
    L8:
        if (r3 >= r2.length()) goto L13;
        r0.add(new com.bytedance.applog.monitor.v3.h(r2.optJSONObject(r3)));     // Catch: Throwable -> L11
        r3 = r3 + 1;
    L13:
        return r0;
    L11:
        th = move-exception;
        q().f("Cannot parse stage events:{}!", new Object[]{r7, th});
        goto L13
    }

    public void a(MonitorV3Helper r3, boolean r4) {
        if (this.U <= 0) goto L9;
        if (r4 == false) goto L6;
        j r0 = j.h;
    L7:
        r3.increaseStats(r0, this.U);
        goto L9
    L6:
        r0 = j.i;
    L9:
        if (this.V <= 0) goto L14;
        if (r4 == false) goto L12;
        j r1 = j.j;
    L13:
        r3.increaseStats(r1, this.V);
        goto L14
    L12:
        r1 = j.k;
    L14:
        int r2 = (this.W + this.X) + this.Y;
        if (r2 <= 0) goto L21;
        if (r4 == false) goto L18;
        j r5 = j.f;
    L19:
        r3.increaseStats(r5, r2);
        return;
    L18:
        r5 = j.g;
        goto L19
    }

    public boolean a(com.bytedance.applog.engine.e r8) {
        if (TextUtils.isEmpty(this.N) == false) goto L5;
        return false;
    L5:
        JSONObject r0 = null;
        r0 = new JSONObject(this.N);     // Catch: JSONException -> L29
    L8:
        if (r0 != null) goto L10;
    L28:
        return false;
    L10:
        if (r0.isNull("terminate") == true) goto L28;
        JSONObject r7 = r0.optJSONObject("terminate");
        if (r7 != null) goto L15;
        return false;
    L15:
        SimpleDateFormat r1 = ab;
        String r2 = r1.format(new Date(System.currentTimeMillis()));
        if (r2.equals(r1.format(Long.valueOf(r8.h()))) == false) goto L18;
        return false;
    L18:
        long r3 = r7.optLong("local_time_ms", -1);
        if (r3 < 0) goto L28;
        if (r1.format(new Date(r3)).startsWith(r2) == true) goto L28;
        if (r2.equals(r1.format(new Date(r7.optLong("stop_timestamp") * 1000))) == false) goto L26;
        return false;
    L26:
        return true;
    }

    public boolean v() {
        if (this.U <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean w() {
        if (this.V <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void x() {
        com.bytedance.applog.c r0 = com.bytedance.applog.b.b(this.m);
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.U <= 0) goto L9;
        r0.N().increaseStats(j.A, this.U);
    L9:
        if (this.V <= 0) goto L11;
        r0.N().increaseStats(j.B, this.V);
    L11:
        int r1 = (this.W + this.X) + this.Y;
        if (r1 <= 0) goto L15;
        r0.N().increaseStats(j.z, r1);
        return;
    }

    public com.bytedance.applog.i.a y() {
        if (p.a(this.R) == false) goto L12;
        return com.bytedance.applog.i.a.a(this.R);
    L6:
        th = move-exception;
        q().f("Cannot parse isolate key:{}!", new Object[]{this.R, th});
        return null;
    L12:
        return null;
    }

    public String z() {
        return this.S;
    }

    public Collection<g> a(com.bytedance.applog.i.a r10) {
        HashMap r1 = new HashMap();
        int r3 = 0;
    L4:
        if (com.bytedance.applog.util.j.a(this.x) == true) goto L11;
        if (r3 >= this.x.length()) goto L11;
        JSONObject r4 = this.x.optJSONObject(r3);
        String r5 = com.bytedance.applog.i.b.a(r10, r4, "");
        if (r1.containsKey(r5) == true) goto L10;
        r1.put(r5, a(r10, r5));
    L10:
        ((g) ZeusTransformUtils.preCheckCast(r1.get(r5), g.class, "com.obric.aiagent.plugin")).x.put(r4);
        r3 = r3 + 1;
    L11:
        int r6 = 0;
    L13:
        if (com.bytedance.applog.util.j.a(this.z) == true) goto L20;
        if (r6 >= this.z.length()) goto L20;
        JSONObject r7 = this.z.optJSONObject(r6);
        String r8 = com.bytedance.applog.i.b.a(r10, r7, "");
        if (r1.containsKey(r8) == true) goto L19;
        r1.put(r8, a(r10, r8));
    L19:
        ((g) ZeusTransformUtils.preCheckCast(r1.get(r8), g.class, "com.obric.aiagent.plugin")).z.put(r7);
        r6 = r6 + 1;
    L20:
        int r9 = 0;
    L22:
        if (com.bytedance.applog.util.j.a(this.E) == true) goto L29;
        if (r9 >= this.E.length()) goto L29;
        JSONObject r11 = this.E.optJSONObject(r9);
        String r12 = com.bytedance.applog.i.b.a(r10, r11, "");
        if (r1.containsKey(r12) == true) goto L28;
        r1.put(r12, a(r10, r12));
    L28:
        ((g) ZeusTransformUtils.preCheckCast(r1.get(r12), g.class, "com.obric.aiagent.plugin")).E.put(r11);
        r9 = r9 + 1;
    L29:
        f r13 = this.B;
        if (r13 == null) goto L36;
        String r14 = com.bytedance.applog.i.b.a(r10, r13, "");
        if (r1.containsKey(r14) == true) goto L34;
        r1.put(r14, a(r10, r14));
    L34:
        ((g) ZeusTransformUtils.preCheckCast(r1.get(r14), g.class, "com.obric.aiagent.plugin")).B = this.B;
    L36:
        if (this.D == null) goto L46;
        if (r1.isEmpty() == false) goto L40;
        String r15 = com.bytedance.applog.i.b.a(r10, this.D, "");
        r1.put(r15, a(r10, r15));
    L40:
        Iterator r16 = r1.keySet().iterator();
        if (r16.hasNext() == false) goto L46;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.aiagent.plugin");
        ((g) ZeusTransformUtils.preCheckCast(r1.get(r17), g.class, "com.obric.aiagent.plugin")).D = this.D;
        if (com.bytedance.applog.util.j.a(this.C) == true) goto L46;
        ((g) ZeusTransformUtils.preCheckCast(r1.get(r17), g.class, "com.obric.aiagent.plugin")).C = this.C;
    L46:
        if (r1.isEmpty() == false) goto L49;
        return null;
    L49:
        if (r1.size() != 1) goto L53;
        this.R = r10.a();
        this.S = ((String[]) ZeusTransformUtils.preCheckCast(r1.keySet().toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"))[0];
        return null;
    L53:
        return r1.values();
    }

    private g a(com.bytedance.applog.i.a r16, String r17) {
        g r12 = new g();
        String r2 = this.m;
        JSONObject r3 = this.f5996J;
        JSONArray r4 = null;
        if (com.bytedance.applog.util.j.a(this.C) == false) goto L5;
        JSONArray r6 = null;
    L6:
        JSONArray[] r7 = new JSONArray[3];
        if (com.bytedance.applog.util.j.a(this.x) == false) goto L9;
        JSONArray r5 = null;
    L10:
        r7[0] = r5;
        if (com.bytedance.applog.util.j.a(this.z) == false) goto L13;
        JSONArray r8 = null;
    L14:
        r7[1] = r8;
        if (com.bytedance.applog.util.j.a(this.E) == true) goto L18;
        r4 = new JSONArray();
    L18:
        r7[2] = r4;
        r12.a(r2, r3, null, null, r6, r7, new long[]{this.y, this.A, this.F}, this.K, this.O, this.aa);
        r12.f5994d = this.f5994d;
        r12.R = r16.a();
        r12.S = r17;
        return r12;
    L13:
        r8 = new JSONArray();
        goto L14
    L9:
        r5 = new JSONArray();
        goto L10
    L5:
        r6 = new JSONArray();
        goto L6
    }

    public List<g> c(long r20) {
        ArrayList r1 = new ArrayList();
        if (k().toString().length() >= r20) goto L6;
        r1.add(this);
        return r1;
    L6:
        JSONObject r2 = this.f5996J;
        if (r2 == null) goto L9;
        long r5 = r2.toString().length();
    L10:
        g r3 = new g();
        r3.a(this.m, this.f5996J, this.B, this.D, this.C, new JSONArray[]{null, null, null}, new long[]{this.y, this.A, this.F}, this.K, this.O, this.aa);
        r3.f5994d = this.f5994d;
        r3.R = this.R;
        r3.S = this.S;
        r1.add(r3);
        long r4 = r20 - r5;
        f r6 = this.B;
        if (r6 == null) goto L13;
        long r7 = r4 - ((long) r6.k().toString().length());
    L14:
        i r8 = this.D;
        if (r8 == null) goto L17;
        r7 = r7 - ((long) r8.k().toString().length());
    L17:
        JSONArray r9 = this.K;
        if (r9 == null) goto L20;
        r7 = r7 - ((long) r9.toString().length());
    L20:
        int r10 = 0;
    L22:
        if (com.bytedance.applog.util.j.a(this.x) == true) goto L36;
        if (r10 >= this.x.length()) goto L36;
        JSONObject r11 = this.x.optJSONObject(r10);
        if (r11 == null) goto L35;
        long r12 = r11.toString().length();
        r7 = r7 - r12;
        if (r7 > 0) goto L31;
        r3 = C();
        r1.add(r3);
        JSONArray r13 = new JSONArray();
        r3.x = r13;
        r13.put(r11);
        r7 = r4 - r12;
        goto L35
    L31:
        if (r3.x != null) goto L33;
        r3.x = new JSONArray();
    L33:
        r3.x.put(r11);
    L35:
        r10 = r10 + 1;
    L36:
        int r14 = 0;
    L38:
        if (com.bytedance.applog.util.j.a(this.z) == true) goto L52;
        if (r14 >= this.z.length()) goto L52;
        JSONObject r15 = this.z.optJSONObject(r14);
        if (r15 == null) goto L51;
        long r16 = r15.toString().length();
        r7 = r7 - r16;
        if (r7 > 0) goto L47;
        r3 = C();
        r1.add(r3);
        JSONArray r17 = new JSONArray();
        r3.z = r17;
        r17.put(r15);
        r7 = r4 - r16;
        goto L51
    L47:
        if (r3.z != null) goto L49;
        r3.z = new JSONArray();
    L49:
        r3.z.put(r15);
    L51:
        r14 = r14 + 1;
    L52:
        int r18 = 0;
    L54:
        if (com.bytedance.applog.util.j.a(this.E) == true) goto L68;
        if (r18 >= this.E.length()) goto L68;
        JSONObject r19 = this.E.optJSONObject(r18);
        if (r19 == null) goto L67;
        long r21 = r19.toString().length();
        r7 = r7 - r21;
        if (r7 > 0) goto L63;
        r3 = C();
        r1.add(r3);
        JSONArray r22 = new JSONArray();
        r3.E = r22;
        r22.put(r19);
        r7 = r4 - r21;
        goto L67
    L63:
        if (r3.E != null) goto L65;
        r3.E = new JSONArray();
    L65:
        r3.E.put(r19);
    L67:
        r18 = r18 + 1;
    L68:
        return r1;
    L13:
        r7 = r4;
        goto L14
    L9:
        r5 = 0;
        goto L10
    }

    @Override // com.bytedance.applog.store.a
    public String toString() {
        return "pack:{id=" + this.f5991a + ", ts=" + this.f5992b + ", sid:" + this.f5994d + ", e3_cnt:" + this.X + ", e1_cnt:" + this.W + ", l_cnt:" + this.U + ", t_cnt:" + this.V + ", ipr_cnt:" + this.Z + ", isolate:" + this.R + "->" + this.S + "}";
    }

    public boolean A() {
        if (this.B == null) goto L5;
    L19:
        return false;
    L5:
        if (this.D != null) goto L19;
        if (this.K != null) goto L19;
        if (this.y > 0) goto L19;
        if (this.A > 0) goto L19;
        if (this.F > 0) goto L19;
        if (this.I != null) goto L19;
        if (this.T != null) goto L19;
        return true;
    }

    private g C() {
        g r11 = new g();
        r11.a(this.m, this.f5996J, null, null, null, new JSONArray[]{new JSONArray(), null, null}, new long[]{this.y, this.A, this.F}, null, this.O, this.aa);
        r11.f5994d = this.f5994d;
        r11.R = this.R;
        r11.S = this.S;
        return r11;
    }

    private void d(JSONObject r1) {
        this.T = r1;
    }

    private void e(JSONObject r1) {
        this.f5996J = r1;
    }

    private void b(int r1) {
        this.aa = r1;
    }

    private void a(JSONArray r1) {
        this.I = r1;
    }

    public int B() {
        return (this.W + this.X) + this.Y;
    }

    private static void a(final String r7, List<a> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (l.a() == false) goto L5;
        return;
    L5:
        if (r9 != null) goto L7;
        return;
    L7:
        if (r9.isEmpty() == true) goto L27;
        final JSONArray r0 = new JSONArray();
        Iterator r10 = r9.iterator();
    L11:
        if (r10.hasNext() == false) goto L17;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r10.next(), a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        if (r2.q <= 0) goto L11;
        r0.put(r2.q);
        goto L11
    L17:
        l.a("event_realtime_eid", new AnonymousClass1(r7, r0));
        return;
    }
}
