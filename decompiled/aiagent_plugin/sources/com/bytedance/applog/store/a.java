package com.bytedance.applog.store;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.applog.log.m;
import com.bytedance.applog.monitor.v3.j;
import com.bytedance.applog.util.p;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseData.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Cloneable {
    private static final SimpleDateFormat u = null;
    private static final com.bytedance.applog.util.a<HashMap<String, a>> v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f5991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f5995e;
    public long f;
    public String g;
    public String h;
    public int i;
    public int j;
    public int k;
    public int l;
    protected String m;
    String n;
    int o;

    @Deprecated
    int p;
    public long q;
    public long r;
    public int s;
    protected List<String> t;

    public abstract JSONObject f();

    abstract String h();

    public String n() {
        return null;
    }

    public /* synthetic */ Object clone() {
        return l();
    }

    static {
        u = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        v = new AnonymousClass1();
    }

    public a() {
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.o = -1;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        a(0);
        a();
        this.t = Collections.singletonList(h());
    }

    public void a() {
        long r0 = com.bytedance.applog.monitor.v3.f.a();
        this.q = r0;
        this.r = r0;
    }

    public String b() {
        return this.m;
    }

    public void a(String r1) {
        this.m = r1;
    }

    public void a(long r3) {
        if (r3 != 0) goto L5;
        r3 = System.currentTimeMillis();
    L5:
        this.f5992b = r3;
    }

    public static HashMap<String, a> c() {
        HashMap<String, a> r0 = new HashMap();
        a(r0, new h());
        a(r0, new f());
        a(r0, new i());
        a(r0, new g());
        a[] r1 = d();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        a(r0, r1[r3]);
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    public static a[] d() {
        return new a[]{new b(), new d(null, null, false, null), new c(null, "", new JSONObject())};
    }

    private static void a(HashMap<String, a> r1, a r2) {
        r1.put(r2.h(), r2);
    }

    public List<String> e() {
        return Arrays.asList(new String[]{"_id", "integer primary key autoincrement", "local_time_ms", WsChannelMultiProcessSharedProvider.INT_TYPE, "tea_event_index", WsChannelMultiProcessSharedProvider.INT_TYPE, "nt", WsChannelMultiProcessSharedProvider.INT_TYPE, "user_id", WsChannelMultiProcessSharedProvider.INT_TYPE, "uid", WsChannelMultiProcessSharedProvider.INT_TYPE, "session_id", "varchar", "user_unique_id", "varchar", "ab_sdk_version", "varchar", "user_type", WsChannelMultiProcessSharedProvider.INT_TYPE, "user_is_login", WsChannelMultiProcessSharedProvider.INT_TYPE, "user_is_auth", WsChannelMultiProcessSharedProvider.INT_TYPE, "_app_id", "varchar", "priority", WsChannelMultiProcessSharedProvider.INT_TYPE, "forward", WsChannelMultiProcessSharedProvider.INT_TYPE, "_local_event_id", "varchar", "monitor_id", WsChannelMultiProcessSharedProvider.INT_TYPE, "event_stained", WsChannelMultiProcessSharedProvider.INT_TYPE});
    }

    public int a(Cursor r4) {
        Cursor r5 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.aiagent.plugin");
        this.f5991a = r5.getLong(0);
        this.f5992b = r5.getLong(1);
        this.f5993c = r5.getLong(2);
        this.i = r5.getInt(3);
        this.f5995e = r5.getLong(4);
        this.f = r5.getLong(5);
        this.f5994d = r5.getString(6);
        this.g = r5.getString(7);
        this.h = r5.getString(8);
        this.j = r5.getInt(9);
        this.k = r5.getInt(10);
        this.l = r5.getInt(11);
        this.m = r5.getString(12);
        this.o = r5.getInt(13);
        this.p = r5.getInt(14);
        String r0 = r5.getString(15);
        if (p.a(r0) == true) goto L8;
    L5:
        this.r = r5.getLong(16);
        this.s = r5.getInt(17);
        return 18;
    L8:
        this.q = Long.parseLong(r0);     // Catch: Throwable -> L7
        goto L5
    }

    public void a(ContentValues r3) {
        r3.put("local_time_ms", Long.valueOf(this.f5992b));
        r3.put("tea_event_index", Long.valueOf(this.f5993c));
        r3.put("nt", Integer.valueOf(this.i));
        r3.put("user_id", Long.valueOf(this.f5995e));
        r3.put("uid", Long.valueOf(this.f));
        r3.put("session_id", this.f5994d);
        r3.put("user_unique_id", this.g);
        r3.put("ab_sdk_version", this.h);
        r3.put("user_type", Integer.valueOf(this.j));
        r3.put("user_is_login", Integer.valueOf(this.k));
        r3.put("user_is_auth", Integer.valueOf(this.l));
        r3.put("_app_id", this.m);
        r3.put("priority", Integer.valueOf(this.o));
        r3.put("forward", Integer.valueOf(this.p));
        r3.put("_local_event_id", String.valueOf(this.q));
        r3.put("monitor_id", Long.valueOf(this.r));
        r3.put("event_stained", Integer.valueOf(this.s));
    }

    public static String b(long r2) {
        return u.format(new Date(r2));
    }

    public void a(JSONObject r4) {
        r4.put("local_time_ms", this.f5992b);
        r4.put("_app_id", this.m);
        r4.put("priority", this.o);
        r4.put("forward", this.p);
        r4.put("_local_event_id", this.q);
        r4.put("monitor_id", this.r);
    }

    public a b(JSONObject r6) {
        this.f5992b = r6.optLong("local_time_ms", 0);
        this.f5991a = 0;
        this.f5993c = 0;
        this.i = 0;
        this.f5995e = 0;
        this.f = 0;
        this.f5994d = null;
        this.g = null;
        this.h = null;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = r6.optString("_app_id");
        this.o = r6.optInt("priority", -1);
        this.p = r6.optInt("forward");
        this.q = r6.optLong("_local_event_id", 0);
        this.r = r6.optLong("monitor_id", 0);
        return this;
    }

    final ContentValues b(ContentValues r1) {
        if (r1 != null) goto L4;
        r1 = new ContentValues();
    L5:
        a(r1);
        return r1;
    L4:
        r1.clear();
        goto L5
    }

    final String g() {
        List<String> r0 = e();
        if (r0 == null) goto L9;
        StringBuilder r1 = new StringBuilder(128);
        r1.append("create table if not exists ").append(h()).append("(");
        int r6 = 0;
    L6:
        if (r6 >= r0.size()) goto L8;
        r1.append((String) ZeusTransformUtils.preCheckCast(r0.get(r6), String.class, "com.obric.aiagent.plugin")).append(" ").append((String) ZeusTransformUtils.preCheckCast(r0.get(r6 + 1), String.class, "com.obric.aiagent.plugin")).append(",");
        r6 = r6 + 2;
        goto L6
    L8:
        r1.delete(r1.length() - 1, r1.length());
        r1.append(")");
        return r1.toString();
    L9:
        return null;
    }

    public long i() {
        String r0 = m();
        long r2 = 0;
        if (p.a(r0) == false) goto L5;
        r2 = 0 + ((long) r0.length());
    L5:
        String r4 = n();
        if (p.a(r4) == true) goto L8;
        return r2;
    L8:
        return r2 + ((long) r4.length());
    }

    public final JSONObject j() {
        JSONObject r0 = new JSONObject();
        r0.put("k_cls", h());     // Catch: Throwable -> L5
        a(r0);     // Catch: Throwable -> L5
    L7:
        return r0;
    L5:
        th = move-exception;
        q().a(4, this.t, "toIpcJson failed", th, new Object[0]);
        goto L7
    }

    public final JSONObject k() {
        JSONObject r0 = new JSONObject();
        this.n = b(this.f5992b);     // Catch: Throwable -> L5
        return f();
    L5:
        th = move-exception;
        com.bytedance.applog.c r1 = com.bytedance.applog.b.b(this.m);
        if (r1 == null) goto L12;
        r1.N().increaseStats(j.f5823J);
        if (ZeusTransformUtils.instanceOf(th, JSONException.class) == false) goto L11;
        r1.N().increaseStats(j.P);
    L11:
        r1.N().sendError(h() + " to pack json failed", th);
    L12:
        q().a(4, this.t, "toPackJson failed", th, new Object[0]);
        return r0;
    }

    public static a b(String r7) {
        JSONObject r4 = new JSONObject(r7);     // Catch: Throwable -> L9
        a r8 = (a) ZeusTransformUtils.preCheckCast(((HashMap) ZeusTransformUtils.preCheckCast(v.c(new Object[0]), HashMap.class, "com.obric.aiagent.plugin")).get(r4.optString("k_cls", "")), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r8 != null) goto L8;
        m.a().d(4, "from ipc class not recognized", new Object[0]);     // Catch: Throwable -> L9
        return null;
    L8:
        return r8.l().b(r4);
    L9:
        th = move-exception;
        m.a().a(4, "from ipc failed", th, new Object[0]);
        return null;
    }

    public a l() {
        a r0 = (a) ZeusTransformUtils.preCheckCast(super.clone(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L4
        r0.a();     // Catch: Throwable -> L4
        return r0;
    L4:
        th = move-exception;
        q().a(4, this.t, "Clone data failed", th, new Object[0]);
        return null;
    }

    public String toString() {
        String r0 = h();
        if (getClass().getSimpleName().equalsIgnoreCase(r0) == true) goto L5;
        r0 = r0 + ", " + getClass().getSimpleName();
    L5:
        String r1 = this.f5994d;
        String r3 = "-";
        if (r1 == null) goto L12;
        int r4 = r1.indexOf("-");
        if (r4 < 0) goto L10;
        r1 = r1.substring(0, r4);
    L10:
        r3 = r1;
    L12:
        return "{" + r0 + ", " + m() + ", " + r3 + ", " + this.f5992b + ", id=" + this.q + "}";
    }

    public String m() {
        return "sid:" + this.f5994d;
    }

    public final void c(JSONObject r7) {
        com.bytedance.applog.c r0 = com.bytedance.applog.b.b(this.m);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L11;
    L12:
        r7.put("user_id", this.f5995e);
    L13:
        if (r1 == false) goto L15;
    L16:
        r7.put("uid", this.f);
    L17:
        if (r1 == false) goto L19;
    L20:
        r7.put("user_type", this.j);
    L21:
        if (r1 == false) goto L23;
    L24:
        r7.put("user_is_login", this.k);
    L25:
        if (r1 == false) goto L27;
    L28:
        r7.put("user_is_auth", this.l);
        return;
    L27:
        if (this.l > 0) goto L28;
        return;
    L23:
        if (this.k <= 0) goto L25;
    L19:
        if (this.j <= 0) goto L21;
    L15:
        if (this.f <= 0) goto L17;
    L11:
        if (this.f5995e <= 0) goto L13;
    L5:
        if (r0.v() == false) goto L7;
        r1 = true;
        goto L9
    }

    public void a(int r1) {
        this.o = r1;
    }

    public int o() {
        return this.o;
    }

    public long p() {
        return this.f5991a;
    }

    public com.bytedance.applog.log.f q() {
        com.bytedance.applog.log.f r0 = com.bytedance.applog.log.b.b(this.m);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return m.a();
    }
}
