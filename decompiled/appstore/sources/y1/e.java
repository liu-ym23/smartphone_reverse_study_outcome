package y1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.listener.ITrafficCallback;
import com.bytedance.apm.util.i;
import com.bytedance.apm.util.w;
import com.bytedance.apm6.util.cache.LimitedQueue;
import com.bytedanceos.common.ad.common.AdConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends v1.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f26009v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f26010w = "bg_never_front";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static ITrafficCallback f26011x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static LimitedQueue f26012y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static LimitedQueue f26013z;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f26014g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f26015h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f26016i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f26017j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f26018k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f26019l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f26020m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f26021n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f26022o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f26023p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f26024q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f26025r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f26026s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public f f26027t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public JSONObject f26028u;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f26029a = null;

        static {
            f26029a = new e(null);
        }

        public static /* synthetic */ e a() {
            return f26029a;
        }
    }

    static {
        f26012y = new LimitedQueue(20);
        f26013z = new LimitedQueue(20);
    }

    public /* synthetic */ e(d r10) {
        this();
    }

    public static e n() {
        return a.a();
    }

    public static void p(ITrafficCallback r10) {
        f26011x = r10;
    }

    @Override // v1.a
    public void b(JSONObject r10) {
        super.b(r10);
        if (r10.optInt(SlardarSettingsConsts.PERF_TRAFFIC_CAUSE_ANALYSIS_ENABLE, 0) != 1) goto L5;
        y1.a.j().u();
        this.f26014g = r10.optInt(SlardarSettingsConsts.PERF_TRAFFIC_EXCEPTION_THRESHOLD_10_MINUTES_MB, 500) * 1000000;
        this.f26016i = r10.optInt(SlardarSettingsConsts.PERF_TRAFFIC_EXCEPTION_THRESHOLD_10_MINUTES_BG_MB, 500) * 1000000;
        this.f26025r = r10.optInt(SlardarSettingsConsts.PERF_TRAFFIC_EXCEPTION_HIGH_FREQ_THRESHOLD, 200);
        y1.a.j().s((r10.optDouble(SlardarSettingsConsts.PERF_TRAFFIC_EXCEPTION_LARGE_USAGE_THRESHOLD_MB, 10.0d) * 1000.0d) * 1000.0d);
        y1.a.j().o(r10.optDouble(SlardarSettingsConsts.PERF_TRAFFIC_ALOG_RECORD_THRESHOLD_KB, 100.0d));
    L5:
        this.f26015h = r10.optLong(SlardarSettingsConsts.PERF_TRAFFIC_RECORD_USAGE_THRESHOLD_KB, 1) * 1024;
        boolean r11 = b2.b.c(this.f24971e);
    L7:
        if (f26012y.a() == true) goto L27;
        m2.c r12 = (m2.c) f26012y.b();
        String r13 = (String) f26013z.b();
        if (r11 == false) goto L11;
    L16:
        k2.a.monitorLegacyEvent(r12);
    L18:
        if (w0.c.B() == false) goto L7;
        StringBuilder r14 = new StringBuilder();
        r14.append("isSample:key:");
        if (r11 == false) goto L22;
    L25:
        boolean r15 = true;
    L26:
        r14.append(r15);
        s1.c.b("Traffic", new String[]{r14.toString()});
        goto L7
    L22:
        if (r10.optInt(r13, 0) == 1) goto L25;
        r15 = false;
        goto L26
    L11:
        if (r10.optInt(r13, 0) == 1) goto L16;
        if (w0.c.B() == false) goto L18;
        o1.a.b(r12.getLogType(), r12.a(), false);
        goto L18
    L27:
        this.f26028u = r10;
    }

    @Override // v1.a
    public boolean e() {
        return true;
    }

    @Override // v1.a
    public void g() {
        SharedPreferences r10 = w0.c.g().getSharedPreferences("traffic_monitor_info", 0);
        long r11 = r10.getLong("init", -1);
        long r13 = r10.getLong("init_ts", 0);
        if (r11 <= (-1)) goto L22;
        long r12 = r10.getLong("usage", 0);
        long r14 = r10.getLong("usage_ts", 0);
        long r15 = r12 - r11;
        if (r15 > 0) goto L29;
    L21:
        e r16 = this;
        String r17 = "usage";
    L23:
        r16.f26023p = r16.f26027t.h();
        SharedPreferences.Editor r18 = r10.edit();
        r18.putLong("init", r16.f26023p);
        r18.putLong("init_ts", System.currentTimeMillis());
        r18.putLong(r17, 0);
        r18.apply();
        return;
    L29:
        JSONObject r19 = new JSONObject();     // Catch: JSONException -> L26
        r19.put("total_usage", r15);     // Catch: JSONException -> L26
        JSONObject r110 = new JSONObject();     // Catch: JSONException -> L26
        r110.put("total_usage_duration", ((r14 - r13) / 1000) / 60);     // Catch: JSONException -> L26
        JSONObject r20 = new JSONObject();     // Catch: JSONException -> L26
        r20.put("init_ts", r13);     // Catch: JSONException -> L26
        r20.put("usage_ts", r14);     // Catch: JSONException -> L26
        r20.put("biz_usage", r10.getLong("biz_usage", 0));     // Catch: JSONException -> L26
        r20.put("init", r11);     // Catch: JSONException -> L26
        r17 = "usage";
        r20.put(r17, r12);     // Catch: JSONException -> L11
        String r21 = r10.getString("biz_json", "");     // Catch: JSONException -> L11
        if (r21 == "") goto L12;
        JSONObject r22 = new JSONObject();     // Catch: JSONException -> L11
        r22.put(r17, new JSONArray(r21));     // Catch: JSONException -> L11
        r20.put("detail", r22);     // Catch: JSONException -> L11
    L12:
        m1.e r23 = new m1.e();     // Catch: JSONException -> L11
        r16 = this;
        r23.f(r16.f24971e).d(r19).c(r110).b(r20);     // Catch: JSONException -> L25
        s1.a.b("APM-Traffic-Detail ", "Init");     // Catch: JSONException -> L25
        if (s1.a.e() == false) goto L17;
        s1.a.b("APM-Traffic-Detail ", i.c(r23.packLog()).toString());     // Catch: JSONException -> L25
    L17:
        r16.j(r23);     // Catch: JSONException -> L25
        ITrafficCallback r24 = f26011x;     // Catch: JSONException -> L25
        if (r24 == null) goto L23;
        r24.onResult(r15);     // Catch: JSONException -> L25
    L11:
        r16 = this;
        goto L23
    L22:
        r16 = this;
        r17 = "usage";
        goto L23
    }

    @Override // v1.a
    public void h() {
        super.h();
        if (d() == true) goto L5;
        f26010w = "bg_ever_front";
    L5:
        long r10 = System.currentTimeMillis();
        long r11 = this.f26027t.h();
        long r12 = this.f26027t.f();
        long r13 = this.f26027t.g();
        long r14 = this.f26027t.i();
        String r16 = "APM-Traffic-Detail ";
        long r15 = this.f26027t.j();
        if (this.f26017j != (-1)) goto L9;
        this.f26017j = r11;
        this.f26018k = r12;
        this.f26019l = r13;
        this.f26020m = r14;
        this.f26021n = r15;
        this.f26022o = r10;
        return;
    L9:
        JSONArray r17 = new JSONArray();
        long r18 = r11 - this.f26017j;
        long r19 = r12 - this.f26018k;
        long r20 = r13 - this.f26019l;
        long r21 = r14 - this.f26020m;
        long r110 = r15 - this.f26021n;
        long r111 = this.f26014g;
        if (r111 > 0) goto L12;
    L14:
        long r112 = this.f26016i;
        if (r112 > 0) goto L17;
    L22:
        w r22 = y1.a.j().k();
        if (r22 == null) goto L28;
        if (r22.c() <= 0) goto L28;
        r17.put("large_request");
    L28:
        if (b.d().e() <= this.f26025r) goto L30;
        r17.put("high_feq_request");
    L30:
        this.f26017j = r11;
        this.f26021n = r15;
        this.f26020m = r14;
        this.f26018k = r12;
        this.f26019l = r13;
        JSONArray r23 = new JSONArray();
        b2.b.c(this.f24971e);
        o(y1.a.j().g(), "usage_10_minutes", r23);
        o(y1.a.j().i(), "wifi_front", r23);
        o(y1.a.j().h(), "wifi_back", r23);
        o(y1.a.j().f(), "mobile_front", r23);
        String r32 = "usage_ts";
        o(y1.a.j().e(), "mobile_back", r23);
        JSONObject r24 = new JSONObject();
        if (r23.length() > 0) goto L111;
    L107:
        JSONObject r25 = new JSONObject();     // Catch: JSONException -> L36
        r25.put("usage_10_minutes", r18);     // Catch: JSONException -> L36
        r25.put("mobile_back", r19);     // Catch: JSONException -> L36
        r25.put("mobile_front", r20);     // Catch: JSONException -> L36
        r25.put("wifi_back", r21);     // Catch: JSONException -> L36
        r25.put("wifi_front", r110);     // Catch: JSONException -> L36
        ITrafficCallback r26 = f26011x;     // Catch: JSONException -> L36
        if (r26 == null) goto L37;
        r26.onResult(r18, r21, r110, r19, r20);     // Catch: JSONException -> L36
    L37:
        JSONObject r27 = new JSONObject();     // Catch: JSONException -> L36
        m1.e r28 = new m1.e();     // Catch: JSONException -> L36
        JSONObject r29 = new JSONObject();     // Catch: JSONException -> L36
        String r30 = "detail";
        r29.put(r30, r24);     // Catch: JSONException -> L36
        String r113 = "biz_usage";
        r29.put(r113, y1.a.j().d());     // Catch: JSONException -> L103
        r29.put("init_ts", this.f26022o);     // Catch: JSONException -> L103
        String r31 = r32;
        r29.put(r31, r10);     // Catch: JSONException -> L46
        r28.f(this.f24971e).c(r27).d(r25).b(r29);     // Catch: JSONException -> L46
        if (s1.a.e() == false) goto L47;
        String r33 = r16;
        s1.a.b(r33, i.c(r28.packLog()).toString());     // Catch: JSONException -> L102
    L48:
        j(r28);     // Catch: JSONException -> L102
        this.f26022o = r10;     // Catch: JSONException -> L102
        if (r17.length() <= 0) goto L84;
        JSONObject r34 = new JSONObject();     // Catch: JSONException -> L102
        r34.put("exception", true);     // Catch: JSONException -> L102
        r34.put("exception_type", r17);     // Catch: JSONException -> L102
        Map r35 = b.d().c();     // Catch: JSONException -> L102
        if (r35 == null) goto L66;
        Iterator r36 = r35.entrySet().iterator();     // Catch: JSONException -> L102
        JSONArray r114 = new JSONArray();     // Catch: JSONException -> L102
    L54:
        if (r36.hasNext() == false) goto L62;
        Map.Entry r115 = (Map.Entry) r36.next();     // Catch: JSONException -> L102
        String r37 = r31;
        String r116 = r33;
        Iterator r117 = r36;
        String r118 = r30;
        if (((g) r115.getValue()).f26035d <= this.f26025r) goto L61;
        JSONObject r38 = new JSONObject();     // Catch: JSONException -> L103
        r38.put("path", ((g) r115.getValue()).f26032a);     // Catch: JSONException -> L103
        r38.put("freq", ((g) r115.getValue()).f26035d);     // Catch: JSONException -> L103
        r38.put("biz", ((g) r115.getValue()).f26033b);     // Catch: JSONException -> L103
        r114.put(r38);     // Catch: JSONException -> L103
    L61:
        r36 = r117;
        r33 = r116;
        r30 = r118;
        r31 = r37;
        goto L54
    L62:
        String r119 = r30;
        r32 = r31;
        r16 = r33;
        if (s1.a.e() == false) goto L65;
        s1.a.b("TrafficHighTreq", r114.toString());     // Catch: JSONException -> L103
    L65:
        r24.put("high_freq", r114);     // Catch: JSONException -> L103
    L67:
        if (r22 == null) goto L79;
        List r39 = r22.d();     // Catch: JSONException -> L103
        if (r39 == null) goto L79;
        if (r39.size() <= 0) goto L79;
        JSONArray r40 = new JSONArray();     // Catch: JSONException -> L103
        Iterator r41 = r39.iterator();     // Catch: JSONException -> L103
    L74:
        if (r41.hasNext() == false) goto L76;
        g r42 = (g) r41.next();     // Catch: JSONException -> L103
        JSONObject r43 = new JSONObject();     // Catch: JSONException -> L103
        r43.put("path", r42.f26032a);     // Catch: JSONException -> L103
        r43.put("usage", r42.f26034c);     // Catch: JSONException -> L103
        r43.put("biz", r42.f26033b);     // Catch: JSONException -> L103
        r40.put(r43);     // Catch: JSONException -> L103
        goto L74
    L76:
        r24.put("large_usage", r40);     // Catch: JSONException -> L103
        if (s1.a.e() == false) goto L79;
        s1.a.b("TrafficTopK", r40.toString());     // Catch: JSONException -> L103
    L79:
        r34.put(r113, y1.a.j().d());     // Catch: JSONException -> L103
        if (s1.a.e() == false) goto L82;
        s1.a.b("TrafficException", r34.toString());     // Catch: JSONException -> L103
    L82:
        r34.put(r119, r24);     // Catch: JSONException -> L103
        m1.e r44 = new m1.e();     // Catch: JSONException -> L103
        r44.f(this.f24971e).c(r27).d(r25).b(r34);     // Catch: JSONException -> L103
        j(r44);     // Catch: JSONException -> L103
        goto L85
    L66:
        r119 = r30;
        r32 = r31;
        r16 = r33;
    L84:
        r32 = r31;
        r16 = r33;
        goto L85
    L47:
        r33 = r16;
    L46:
        r32 = r31;
    L85:
        SharedPreferences.Editor r45 = w0.c.g().getSharedPreferences("traffic_monitor_info", 0).edit();
        r45.putLong("usage", r11);
        long r46 = this.f26026s + y1.a.j().d();
        this.f26026s = r46;
        r45.putLong(r113, r46);
        r45.putLong(r32, System.currentTimeMillis());
        Map r47 = y1.a.j().l();
        if (r47 != null) goto L88;
    L96:
        r45.apply();
        if (w0.c.B() == false) goto L99;
        String r48 = r16;
        Log.d(r48, "traffic since app boot: " + (r11 - this.f26023p));
        Log.d(r48, "traffic stats from biz (include ttnet/ok/httpurl plus trafficStats): " + y1.a.j().d());
    L99:
        y1.a.j().c();
        b.d().b();
        return;
    L88:
        if (r47.size() <= 0) goto L96;
        JSONArray r49 = new JSONArray();
        Iterator r50 = r47.entrySet().iterator();
    L91:
        if (r50.hasNext() == false) goto L95;
        JSONObject r51 = ((y1.a.c) ((Map.Entry) r50.next()).getValue()).b();
        r51.put("traffic_category", "total_usage");     // Catch: Exception -> L104
    L94:
        r49.put(r51);
        goto L91
    L95:
        r45.putString("biz_json", r49.toString());
    L36:
        r113 = "biz_usage";
        goto L85
    L111:
        r24.put("usage", r23);     // Catch: Exception -> L101
        goto L107
    L17:
        if ((r19 + r21) <= r112) goto L22;
        if (TextUtils.equals(f26010w, "bg_never_front") == false) goto L21;
        r17.put("never_front_usage_abnormal");
        goto L22
    L21:
        r17.put("bg_usage_abnormal");
        goto L22
    L12:
        if (r18 <= r111) goto L14;
        r17.put("total_usage_abnormal");
        goto L22
    }

    @Override // v1.a
    public long m() {
        return AdConstant.SPLASH_AD_INTERVAL;
    }

    public final JSONArray o(Map r10, String r11, JSONArray r12) {
        if (r10 != null) goto L5;
    L17:
        return null;
    L5:
        if (r10.size() == 0) goto L17;
        Iterator r13 = r10.entrySet().iterator();     // Catch: Exception -> L18
    L9:
        if (r13.hasNext() == false) goto L16;
        JSONObject r14 = ((y1.a.c) ((Map.Entry) r13.next()).getValue()).c(this.f26015h);     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r11) == true) goto L14;
        r14.put("traffic_category", r11);     // Catch: Exception -> L18
    L14:
        r12.put(r14);     // Catch: Exception -> L18
        goto L9
    L16:
        return r12;
    }

    @Override // v1.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r10) {
        super.onBackground(r10);
        this.f26027t.k(true);
    }

    @Override // v1.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r10) {
        super.onFront(r10);
        f26010w = "bg_ever_front";
        this.f26027t.k(false);
    }

    public e() {
        this.f26014g = 500000000;
        this.f26015h = 0;
        this.f26016i = 1;
        this.f26017j = -1;
        this.f26018k = 0;
        this.f26019l = 0;
        this.f26020m = 0;
        this.f26021n = 0;
        this.f26023p = 0;
        this.f26024q = f26009v;
        this.f24971e = "traffic";
        f r10 = f.e();
        this.f26027t = r10;
        r10.k(d());
    }
}
