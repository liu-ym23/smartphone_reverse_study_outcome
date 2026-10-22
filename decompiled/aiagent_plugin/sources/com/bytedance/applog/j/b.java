package com.bytedance.applog.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.engine.Engine;
import com.bytedance.applog.log.l;
import com.bytedance.applog.monitor.a.e;
import com.bytedance.applog.monitor.v3.j;
import com.bytedance.applog.p;
import com.bytedance.applog.store.d;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f5654a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f5655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p f5656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SharedPreferences f5657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SharedPreferences f5658e;
    private final SharedPreferences f;
    private volatile JSONObject g;
    private final HashSet<String> h;
    private final HashSet<String> i;
    private volatile HashSet<String> j;
    private long k;
    private volatile com.bytedance.applog.priority.a l;
    private final com.bytedance.applog.m.a m;
    private final com.bytedance.applog.c n;
    private volatile com.bytedance.applog.f.a o;
    private Engine p;
    private volatile String q;
    private volatile String r;
    private volatile boolean s;
    private final Map<String, List<String>> t;
    private List<String> u;

    private boolean b(long r3) {
        if (r3 >= 10000) goto L5;
    L7:
        return false;
    L5:
        if (r3 > 300000) goto L7;
        return true;
    }

    static /* synthetic */ com.bytedance.applog.c a(b r0) {
        return r0.n;
    }

    static /* synthetic */ com.bytedance.applog.f.a b(b r0) {
        return r0.o;
    }

    static /* synthetic */ SharedPreferences c(b r0) {
        return r0.f;
    }

    static {
        f5654a = Collections.singletonList("ConfigManager");
    }

    public b(com.bytedance.applog.c r5, Context r6, p r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        this.k = 0;
        this.s = true;
        this.t = new ConcurrentHashMap();
        this.u = null;
        this.n = r5;
        Context r9 = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        this.f5655b = r9;
        this.f5656c = r7;
        this.f = r9.getSharedPreferences(r7.F(), 0);
        this.f5657d = r9.getSharedPreferences(com.bytedance.applog.b.a(r5, "header_custom"), 0);
        this.f5658e = r9.getSharedPreferences(com.bytedance.applog.b.a(r5, "last_sp_session"), 0);
        this.h = new HashSet();
        this.i = new HashSet();
        this.m = new com.bytedance.applog.m.a(r5, this, s());
        if (r5.A() == false) goto L6;
        a(com.bytedance.applog.priority.c.a(r5, this));
    L6:
        if (r5.ag() == false) goto L9;
        a(com.bytedance.applog.f.b.a(r5));
        return;
    }

    public void a(Engine r1) {
        this.p = r1;
    }

    public void a() {
        if (this.n.aq() == false) goto L11;
        String r0 = this.f.getString("header_custom_allow", null);
        if (TextUtils.isEmpty(r0) == true) goto L11;
        a(null, new JSONArray(r0));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.n.N().sendError("parse custom header control config failed", th);
    L11:
        if (this.n.ap() == false) goto L23;
        String r1 = this.f.getString("params_block", null);
        if (TextUtils.isEmpty(r1) == true) goto L24;
        b(null, new JSONObject(r1));     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        this.n.N().sendError("parse event params control config failed", th);
        return;
    L24:
        return;
    }

    public boolean b() {
        return this.f5656c.b();
    }

    public p c() {
        return this.f5656c;
    }

    public String d() {
        return this.f5658e.getString("session_last_day", "");
    }

    public void a(String r2, int r3) {
        this.f5658e.edit().putString("session_last_day", r2).putInt("session_order", r3).apply();
    }

    public int e() {
        return this.f5658e.getInt("session_order", 0);
    }

    public SharedPreferences f() {
        return this.f;
    }

    public boolean g() {
        return this.f5656c.e();
    }

    public JSONObject h() {
        return this.g;
    }

    public Context getContext() {
        return this.f5655b;
    }

    public void a(boolean r1) {
        this.s = r1;
    }

    public boolean i() {
        return this.s;
    }

    public void a(JSONObject r18) {
        boolean r4 = true;
        this.n.Z().b(f5654a, "setConfig: {}", new Object[]{r18});
        this.g = r18;
        long r2 = System.currentTimeMillis();
        SharedPreferences.Editor r5 = this.f.edit();
        long r8 = r18.optInt("session_interval", 0);
        if (r8 > 0) goto L5;
    L7:
        r5.remove("session_interval");
    L8:
        long r10 = ((long) r18.optInt("batch_event_interval", 60)) * 1000;
        if (b(r10) == false) goto L11;
        r5.putLong("batch_event_interval", r10);
    L12:
        int r9 = r18.optInt("send_launch_timely", 0);
        if (r9 > 0) goto L15;
    L17:
        r5.remove("send_launch_timely");
    L18:
        long r11 = r18.optInt("abtest_fetch_interval", 0);
        if (r11 > 20) goto L21;
    L23:
        r5.remove("abtest_fetch_interval");
    L25:
        if (r18.optBoolean("bav_ab_config", false) == false) goto L27;
        r5.putBoolean("bav_ab_config", true);
    L28:
        JSONArray r12 = r18.optJSONArray("real_time_events");
        if (r12 != null) goto L31;
    L33:
        this.j = new HashSet();
        r5.remove("real_time_events");
    L34:
        int r13 = r18.optInt("http_monitor_port", 0);
        if (r13 <= 0) goto L37;
        r5.putInt("http_monitor_port", r13);
    L37:
        r5.putLong("app_log_last_config_time", r2);
        int r3 = r18.optInt("forbid_report_phone_detail_info", -1);
        if (r3 < 0) goto L43;
        if (r3 <= 0) goto L41;
        boolean r6 = true;
    L42:
        r5.putBoolean("forbid_report_phone_detail_info", r6);
        goto L43
    L41:
        r6 = false;
    L43:
        long r7 = r18.optLong("fetch_interval", 21600) * 1000;
        if (r7 >= 1800000) goto L46;
    L47:
        r7 = 21600000;
    L48:
        r5.putLong("fetch_interval", r7);
        r5.putInt("content_encode_method", r18.optInt("content_encode_method", 0));
        r5.putLong("max_pack_size", r18.optLong("max_pack_size", 0));
        JSONObject r14 = r18.optJSONObject("log_back");
        if (r14 == null) goto L52;
        a(r5, r14);
    L52:
        if (r18.optInt("ignore_event_priority", 0) == 1) goto L55;
        r4 = false;
    L55:
        r5.putBoolean("ignore_event_priority", r4);
        if (this.n.ap() == false) goto L59;
        b(r5, r18.optJSONObject("params_block"));
    L59:
        if (this.n.aq() == false) goto L61;
        a(r5, r18.optJSONArray("header_custom_allow"));
    L61:
        r5.apply();
        if (r18.has("monitor_config") == false) goto L64;
        this.n.N().getConfigManager().a(r18.optJSONObject("monitor_config"));
    L64:
        E();
        return;
    L46:
        if (r7 <= 172800000) goto L48;
    L31:
        if (r12.length() <= 0) goto L33;
        this.j = a(r12);
        r5.putString("real_time_events", r12.toString());
        goto L34
    L27:
        r5.remove("bav_ab_config");
        goto L28
    L21:
        if (r11 > 604800) goto L23;
        r5.putLong("abtest_fetch_interval", r11 * 1000);
        goto L25
    L15:
        if (r9 > 604800) goto L17;
        r5.putInt("send_launch_timely", r9);
        goto L18
    L11:
        r5.remove("batch_event_interval");
        goto L12
    L5:
        if (r8 > 604800) goto L7;
        r5.putLong("session_interval", r8 * 1000);
        goto L8
    }

    public long j() {
        return this.f.getLong("app_log_last_config_time", 0);
    }

    public int k() {
        return this.f.getInt("content_encode_method", 0);
    }

    private void b(SharedPreferences.Editor r9, JSONObject r10) {
        SharedPreferences.Editor r11 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r9, SharedPreferences.Editor.class, "com.obric.aiagent.plugin");
        if (this.t.isEmpty() == true) goto L5;
        this.t.clear();
    L5:
        if (r10 != null) goto L7;
    L30:
        if (r11 != null) goto L32;
        return;
    L32:
        if (this.t.isEmpty() == false) goto L34;
        r11.remove("params_block");
        return;
    L34:
        r11.putString("params_block", r10.toString());
        return;
    L7:
        if (r10.length() <= 0) goto L30;
        Iterator<String> r0 = r10.keys();
    L10:
        if (r0.hasNext() == false) goto L30;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r2) == true) goto L10;
        JSONArray r3 = r10.optJSONArray(r2);
        if (r3 == null) goto L10;
        if (r3.length() == 0) goto L10;
        HashSet r4 = new HashSet();
        int r5 = 0;
    L21:
        if (r5 >= r3.length()) goto L27;
        String r6 = r3.optString(r5);
        if (TextUtils.isEmpty(r6) == true) goto L25;
        r4.add(r6);
    L25:
        r5 = r5 + 1;
        goto L21
    L27:
        if (r4.isEmpty() == true) goto L10;
        this.t.put(r2, new ArrayList(r4));
        goto L10
    }

    private void a(SharedPreferences.Editor r5, JSONArray r6) {
        SharedPreferences.Editor r7 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r5, SharedPreferences.Editor.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
    L20:
        this.u = null;
        if (r7 == null) goto L28;
        r7.remove("header_custom_allow");
        return;
    L28:
        return;
    L5:
        if (r6.length() == 0) goto L20;
        this.u = new ArrayList();
        int r1 = 0;
    L9:
        if (r1 >= r6.length()) goto L14;
        String r2 = r6.optString(r1);
        if (TextUtils.isEmpty(r2) == true) goto L13;
        this.u.add(r2);
    L13:
        r1 = r1 + 1;
        goto L9
    L14:
        Engine r4 = this.p;
        if (r4 == null) goto L17;
        r4.getDm().h();
    L17:
        if (r7 == null) goto L27;
        r7.putString("header_custom_allow", r6.toString());
        return;
    }

    private HashSet<String> a(JSONArray r5) {
        HashSet<String> r0 = new HashSet();
        if (r5 == null) goto L13;
    L5:
        int r4 = r5.length();     // Catch: Throwable -> L12
        int r1 = 0;
    L6:
        if (r1 >= r4) goto L11;
        String r2 = r5.getString(r1);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r2) == true) goto L10;
        r0.add(r2);     // Catch: Throwable -> L12
    L10:
        r1 = r1 + 1;
    L11:
        return r0;
    L13:
        r5 = new JSONArray(this.f.getString("real_time_events", "[]"));     // Catch: Throwable -> L12
        goto L5
    }

    private HashSet<String> F() {
        if (this.j != null) goto L6;
        this.j = a(null);
    L6:
        return this.j;
    }

    public String l() {
        return this.f5656c.f();
    }

    public String m() {
        String r0 = this.f5656c.g();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        r0 = u();
    L6:
        if (TextUtils.isEmpty(r0) == false) goto L16;
        Bundle r1 = this.f5655b.getPackageManager().getApplicationInfo(this.f5655b.getPackageName(), 128).metaData;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty("UMENG_CHANNEL") == true) goto L17;
        return r1.getString("UMENG_CHANNEL");
    L17:
        return r0;
    L11:
        th = move-exception;
        this.n.Z().a(f5654a, "getChannel failed", th, new Object[0]);
        return r0;
    L16:
        return r0;
    }

    public String n() {
        return this.f.getString("channel", "");
    }

    public boolean a(String r3) {
        if (this.n.aq() == true) goto L5;
        return true;
    L5:
        List<String> r0 = this.u;
        if (r0 != null) goto L8;
        return true;
    L8:
        if (r0.isEmpty() == false) goto L10;
        return true;
    L10:
        if (this.u.contains(r3) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public boolean a(String r3, String r4) {
        if (this.n.ap() == true) goto L6;
        return true;
    L6:
        if (this.t.containsKey(r3) == true) goto L8;
        return true;
    L8:
        List r2 = (List) ZeusTransformUtils.preCheckCast(this.t.get(r3), List.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L11;
    L15:
        return true;
    L11:
        if (r2.isEmpty() == true) goto L15;
        return !r2.contains(r4);
    }

    public boolean b(String r2) {
        if (this.n.ap() == true) goto L7;
        return true;
    L7:
        return this.t.containsKey(r2);
    }

    String o() {
        if (this.q != null) goto L6;
        this.q = this.f5657d.getString("ab_sdk_version", "");
    L6:
        return this.q;
    }

    void c(String r1) {
        this.r = r1;
    }

    String p() {
        if (this.r != null) goto L6;
        this.r = this.f5657d.getString("user_unique_id", "");
    L6:
        return this.r;
    }

    public boolean q() {
        if (this.f5656c.j() != 0) goto L6;
        this.f5656c.b(!com.bytedance.applog.util.p.a(this.f5655b).contains(":"));
    L6:
        if (this.f5656c.j() == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public long r() {
        return this.f.getLong("session_interval", OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS);
    }

    public long s() {
        if (b(this.k) == false) goto L7;
        return this.k;
    L7:
        return this.f.getLong("batch_event_interval", 60000);
    }

    public ArrayList<com.bytedance.applog.store.a> a(List<com.bytedance.applog.store.a> r6) {
        Iterator r7 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin")).iterator();
        ArrayList<com.bytedance.applog.store.a> r0 = null;
    L4:
        if (r7.hasNext() == false) goto L15;
        com.bytedance.applog.store.a r2 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r7.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L4;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin");
        if (r3.o() == 0) goto L11;
        if (F().contains(r3.s()) == false) goto L4;
    L11:
        r7.remove();
        if (r0 != null) goto L14;
        r0 = new ArrayList();
    L14:
        r0.add(r2);
        goto L4
    L15:
        return r0;
    }

    public boolean a(ArrayList<com.bytedance.applog.store.a> r6) {
        if (r6 != null) goto L5;
    L29:
        return true;
    L5:
        if (r6.size() == 0) goto L29;
        if (this.h.size() == 0) goto L10;
    L12:
        Iterator<com.bytedance.applog.store.a> r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L29;
        com.bytedance.applog.store.a r1 = (com.bytedance.applog.store.a) ZeusTransformUtils.preCheckCast(r7.next(), com.bytedance.applog.store.a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.store.b.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r1, d.class) == false) goto L14;
        d r2 = (d) ZeusTransformUtils.preCheckCast(r1, d.class, "com.obric.aiagent.plugin");
        if (this.i.contains(r2.s()) == false) goto L14;
        com.bytedance.applog.monitor.c.a(this.n.N(), com.bytedance.applog.monitor.v3.a.m, r1);
        r7.remove();
        this.n.N().increaseStats(j.S);
        this.n.N().increaseStats(j.n);
        com.bytedance.applog.monitor.a.b.a().a(e.f5745b, r1.m());
        goto L14
    L17:
        com.bytedance.applog.store.b r3 = (com.bytedance.applog.store.b) ZeusTransformUtils.preCheckCast(r1, com.bytedance.applog.store.b.class, "com.obric.aiagent.plugin");
        StringBuilder r4 = new StringBuilder().append(r3.v);
        if (TextUtils.isEmpty(r3.w) == true) goto L20;
        String r5 = r3.w;
    L21:
        String r8 = r4.append(r5).toString();
        if (this.h.contains(r8) == false) goto L14;
        r7.remove();
        com.bytedance.applog.monitor.c.a(this.n.N(), com.bytedance.applog.monitor.v3.a.m, r1);
        this.n.N().increaseStats(j.S);
        this.n.N().increaseStats(j.n);
        com.bytedance.applog.monitor.a.b.a().a(e.f5745b, r1.m());
        goto L14
    L20:
        r5 = "";
        goto L21
    L10:
        if (this.i.size() != 0) goto L12;
        return true;
    }

    public void a(HashSet<String> r2, HashSet<String> r3) {
        if (r2 == null) goto L4;
        this.h.addAll(r2);
    L4:
        if (r3 == null) goto L7;
        this.i.addAll(r3);
        return;
    }

    public void b(JSONObject r5) {
        this.k = r5.optLong("batch_event_interval", 0) * 1000;
        this.n.Z().b(f5654a, "parseCommonConfigFromResp mEventIntervalFromLogResp: {}", new Object[]{Long.valueOf(this.k)});
    }

    public void c(JSONObject r5) {
        this.m.a(r5, s(), null);
        com.bytedance.applog.priority.c.a(r5, this.l);
    }

    public void a(com.bytedance.applog.priority.b r1, int r2) {
        Engine r0 = this.p;
        if (r0 == null) goto L6;
        r0.tryUpdateCongestionMaxRequestFrequency(r1, r2);
        return;
    }

    public String t() {
        return this.f5656c.s();
    }

    String u() {
        return this.f5656c.t();
    }

    public long v() {
        return this.f.getLong("fetch_interval", 21600000);
    }

    public long w() {
        return this.f5658e.getLong("latest_forground_session_time", 0);
    }

    public void a(long r2) {
        this.f5658e.edit().putLong("latest_forground_session_time", r2).apply();
    }

    public com.bytedance.applog.priority.a x() {
        return this.l;
    }

    public void a(final com.bytedance.applog.priority.a r2) {
        if (C() == false) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
    L10:
        boolean r0 = true;
    L11:
        this.l = r2;
        if (r0 == false) goto L17;
        Engine r1 = this.p;
        if (r1 == null) goto L17;
        r1.tryUpdateSenders();
    L17:
        if (l.a() == true) goto L21;
        if (r2 == null) goto L22;
        l.a("priority_config", new AnonymousClass1(this, r2));
        return;
    L22:
        return;
    L21:
        return;
    L7:
        if (r2.a(this.l) == true) goto L10;
        r0 = false;
        goto L11
    }

    public com.bytedance.applog.priority.b a(int r1) {
        com.bytedance.applog.priority.a r0 = this.l;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r1);
    }

    public com.bytedance.applog.m.a y() {
        return this.m;
    }

    public long z() {
        return this.f.getLong("max_pack_size", 0);
    }

    public boolean A() {
        if (z() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void a(SharedPreferences.Editor r3, JSONObject r4) {
        SharedPreferences.Editor r5 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.Editor.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        JSONObject r0 = B();
        if (r0 == null) goto L10;
        com.bytedance.applog.util.j.a(r4, r0);
        r4 = r0;
    L10:
        if (r5 == null) goto L12;
        r5.putString("log_back", r4.toString());
        return;
    L12:
        this.f.edit().putString("log_back", r4.toString()).apply();
    }

    public JSONObject B() {
        String r0 = this.f.getString("log_back", "");
        if (TextUtils.isEmpty(r0) == false) goto L10;
        return null;
    L10:
        return new JSONObject(r0);
    L7:
        th = move-exception;
        this.n.Z().a("json parse to logback failed", th, new Object[0]);
        return null;
    }

    public boolean C() {
        return this.f.getBoolean("ignore_event_priority", false);
    }

    public void a(com.bytedance.applog.f.a r2) {
        if (r2 != null) goto L4;
    L6:
        this.o = r2;
        if (this.o == null) goto L12;
        Engine r3 = this.p;
        if (r3 == null) goto L12;
        r3.tryUpdateSenders();
    L12:
        if (this.o != null) goto L14;
        return;
    L14:
        if (l.a() == true) goto L18;
        l.a("forward_config", new AnonymousClass2(this));
        return;
    L18:
        return;
    L4:
        if (r2.equals(this.o) == false) goto L6;
    }

    public com.bytedance.applog.f.a D() {
        return this.o;
    }

    public void E() {
        if (l.a() == false) goto L5;
        return;
    L5:
        l.a("remote_settings", new AnonymousClass3(this));
    }
}
