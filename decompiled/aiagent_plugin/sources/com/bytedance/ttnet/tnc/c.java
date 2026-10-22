package com.bytedance.ttnet.tnc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.i;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.i.h;
import com.bytedance.frameworks.baselib.network.http.i.k;
import com.bytedance.frameworks.baselib.network.http.i.l;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.g;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.o;
import com.bytedance.keva.KevaImpl;
import com.bytedance.retrofit2.ak;
import com.bytedance.retrofit2.e;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedance.ttnet.utils.d;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.v;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TNCManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements g {
    private static final String TAG = "TNCManager";
    private static c n;
    private static String o;
    private HashMap<String, Integer> A;
    private boolean B;
    private volatile a C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f11510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    o.a f11511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f11512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile long f11513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f11514e;
    private b f;
    private volatile long g;
    private volatile boolean h;
    private volatile boolean i;
    private String j;
    private String k;
    private volatile long l;
    private AtomicBoolean m;
    private boolean p;
    private Context q;
    private com.bytedance.ttnet.tnc.b r;
    private volatile int s;
    private volatile long t;
    private volatile long u;
    private int v;
    private HashMap<String, Integer> w;
    private HashMap<String, Integer> x;
    private int y;
    private HashMap<String, Integer> z;

    /* JADX INFO: compiled from: TNCManager.java */
    public interface a {
        boolean a(String r1, String r2, List<com.bytedance.retrofit2.b.b> r3, String r4);

        boolean b(String r1, String r2, List<com.bytedance.retrofit2.b.b> r3, String r4);
    }

    /* JADX INFO: compiled from: TNCManager.java */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f11517a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f11518b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f11519c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f11520d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f11521e = null;
        public static final b f = null;
        public static final b g = null;
        public static final b h = null;
        public static final b i = null;
        public static final b j = null;
        public static final b k = null;
        private static final /* synthetic */ b[] m = null;
        public final int l;

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(m.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            b r0 = new b("TTRESUME", 0, -2);
            f11517a = r0;
            b r1 = new b("TTHardCode", 1, -1);
            f11518b = r1;
            b r3 = new b("TTCACHE", 2, 0);
            f11519c = r3;
            b r5 = new b("TTSERVER", 3, 1);
            f11520d = r5;
            b r7 = new b("TTERROR", 4, 2);
            f11521e = r7;
            b r9 = new b("TTPOLL", 5, 3);
            f = r9;
            b r11 = new b("TTTNC", 6, 4);
            g = r11;
            b r13 = new b("PORTRETRY", 7, 7);
            h = r13;
            b r15 = new b("TTREGION", 8, 10);
            i = r15;
            b r14 = new b("TTCRONET", 9, 20);
            j = r14;
            b r6 = new b("TTCRONETFAILED", 10, 30);
            k = r6;
            m = new b[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r6};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.l = r3;
        }
    }

    private boolean a(int r1) {
        if (r1 >= 200) goto L5;
        return false;
    L5:
        if (r1 >= 400) goto L10;
        return true;
    L10:
        return false;
    }

    static /* synthetic */ a a(c r0) {
        return r0.C;
    }

    static /* synthetic */ b a(c r0, int r1) {
        return r0.c(r1);
    }

    static /* synthetic */ List a(c r2, Map r3) {
        return r2.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void a(c r0, boolean r1, b r2) {
        r0.a(r1, r2);
    }

    public static void a(ICronetAppProvider r10) {
        final ICronetAppProvider r11 = (ICronetAppProvider) ZeusTransformUtils.wrapperContextForParams(r10, ICronetAppProvider.class, "com.obric.aiagent.plugin");
        String r0 = r11.getCarrierRegion();
        String r2 = r11.getSysRegion();
        String r3 = r11.getRegion();
        if (TextUtils.isEmpty(r0) == true) goto L6;
    L9:
        com.bytedance.frameworks.baselib.network.http.h.b.a().a(r0, r11.getStoreIdcRuleJSON(), r11.getAppInitialRegionInfo(), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), new AnonymousClass1(r11));
        if (TextUtils.isEmpty(r0) == true) goto L13;
        o = TTNetInit.getGetDomainConfigByRegion(r0);
    L13:
        if (TextUtils.isEmpty(o) == false) goto L16;
        o = r11.getGetDomainDefaultJSON();
    L16:
        if (Logger.debug() == false) goto L19;
        Logger.d(TAG, "region: " + r0 + " json: " + o);
        return;
    L19:
        return;
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r0 = r2;
        goto L9
    L8:
        r0 = r3;
        goto L9
    }

    static String b() {
        return o;
    }

    public static synchronized c c() {
        monitor-enter(c.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (n != null) goto L7;
        n = new c();     // Catch: Throwable -> L10
    L7:
        c r1 = n;     // Catch: Throwable -> L10
        monitor-exit(c.class);
        return r1;
    }

    private c() {
        this.f11512c = 0;
        this.f11513d = 0;
        this.f11514e = 0;
        this.f = b.f11519c;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = new AtomicBoolean(false);
        this.p = false;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = new HashMap();
        this.x = new HashMap();
        this.y = 0;
        this.z = new HashMap();
        this.A = new HashMap();
        this.B = true;
        final Looper r1 = Looper.getMainLooper();
        this.f11510a = new TNCManager$2(this, r1);
        this.C = null;
        this.f11511b = new AnonymousClass2(this);
    }

    public synchronized void a(Context r3, boolean r4) {
        monitor-enter(this);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (this.p == true) goto L12;
        this.q = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        this.B = r4;     // Catch: Throwable -> L14
        this.r = new com.bytedance.ttnet.tnc.b(r5, r4);     // Catch: Throwable -> L14
        if (r4 == false) goto L9;
        g();     // Catch: Throwable -> L14
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d(TAG, "initTnc, isMainProc: " + r4 + " probeCmd: " + this.s + " probeVersion: " + this.t);     // Catch: Throwable -> L14
    L11:
        this.p = true;     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void g() {
        SharedPreferences r0 = this.q.getSharedPreferences("ttnet_tnc_config", 0);
        this.s = r0.getInt("tnc_probe_cmd", 0);
        this.t = r0.getLong("tnc_probe_version", 0);
    }

    public com.bytedance.ttnet.tnc.a d() {
        com.bytedance.ttnet.tnc.b r0 = this.r;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a();
    }

    public com.bytedance.ttnet.tnc.b e() {
        return this.r;
    }

    public boolean a(JSONObject r12, String r13, String r14, boolean r15) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "data: " + r12 + " etag: " + r13 + " tncAttr: " + r14 + " needUpdateTnc: " + r15);
    L6:
        if (r12 == null) goto L13;
        com.bytedance.ttnet.tnc.b r2 = this.r;
        if (r2 == null) goto L10;
        r2.a("");
        boolean r16 = this.r.a(r12, b.f11520d, r13, r14, System.currentTimeMillis());
    L11:
        if (r16 == false) goto L14;
        com.bytedance.frameworks.baselib.network.http.h.b.a().b();
    L14:
        if (r15 == false) goto L18;
        if (r16 == true) goto L18;
        Logger.d(TAG, "doUpdateRemote tnc");
        a(true, b.i);
        return true;
    L18:
        return false;
    L10:
        r16 = false;
        goto L11
    L13:
        r16 = false;
        goto L14
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.g
    public synchronized void a(ab r7, ad r8) {
        monitor-enter(this);
        if (r7 == null) goto L79;
        if (r8 == null) goto L79;
    L76:
        th = move-exception;
        throw th;
    L7:
        if (this.B == true) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (i.b(this.q) == true) goto L14;
        monitor-exit(this);
        return;
    L14:
        v r9 = r7.a();     // Catch: Throwable -> L76
        String r0 = r9.a();     // Catch: Throwable -> L76
        String r1 = r9.b();     // Catch: Throwable -> L76
        String r10 = r9.i();     // Catch: Throwable -> L76
        int r2 = r8.d();     // Catch: Throwable -> L76
        if ("http".equals(r0) == true) goto L21;
        if ("https".equals(r0) == true) goto L21;
        monitor-exit(this);
        return;
    L21:
        if (TextUtils.isEmpty(r1) == false) goto L25;
        monitor-exit(this);
        return;
    L25:
        if (r8.h() != null) goto L29;
        monitor-exit(this);
        return;
    L29:
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "onOk3Response, url: " + r0 + "://" + r1 + "#" + r2);     // Catch: Throwable -> L76
    L31:
        com.bytedance.ttnet.tnc.a r3 = d();     // Catch: Throwable -> L76
        if (r3 != null) goto L34;
    L36:
        if (r3 != null) goto L38;
    L74:
        monitor-exit(this);
        return;
    L38:
        if (r3.f11500a == false) goto L74;
        if (r3.f11502c != null) goto L43;
    L72:
        monitor-exit(this);
        return;
    L43:
        if (r3.f11502c.size() <= 0) goto L72;
        if (r3.f11502c.containsKey(r1) == false) goto L72;
        if (Logger.debug() == false) goto L50;
        Logger.d(TAG, "onOk3Response, url matched: " + r0 + "://" + r1 + "#" + r2 + " " + this.v + "#" + this.w.size() + "#" + this.x.size() + " " + this.y + "#" + this.z.size() + "#" + this.A.size());     // Catch: Throwable -> L76
    L50:
        if (r2 > 0) goto L52;
    L70:
        monitor-exit(this);
        return;
    L52:
        if (a(r2) == false) goto L59;
        if (this.v <= 0) goto L56;
    L57:
        h();     // Catch: Throwable -> L76
        goto L70
    L56:
        if (this.y <= 0) goto L70;
    L59:
        if (b(r2) == true) goto L70;
        this.y++;     // Catch: Throwable -> L76
        this.z.put(r10, 0);     // Catch: Throwable -> L76
        this.A.put(r1, 0);     // Catch: Throwable -> L76
        if (this.y < r3.g) goto L70;
        if (this.z.size() < r3.h) goto L70;
        if (this.A.size() < r3.i) goto L70;
        if (Logger.debug() == false) goto L69;
        Logger.d(TAG, "onOk3Response, url doUpdate: " + r0 + "://" + r1 + "#" + r2);     // Catch: Throwable -> L76
    L69:
        a(false, 0, b.f11521e);     // Catch: Throwable -> L76
        h();     // Catch: Throwable -> L76
        goto L70
    L34:
        if (r3.f11501b == false) goto L36;
        a(r8, r1);     // Catch: Throwable -> L76
    L79:
        monitor-exit(this);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.g
    public synchronized void a(ab r7, Exception r8) {
        monitor-enter(this);
        if (r7 == null) goto L69;
        if (r8 == null) goto L69;
    L66:
        th = move-exception;
        throw th;
    L7:
        if (this.B == true) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (i.b(this.q) == true) goto L14;
        monitor-exit(this);
        return;
    L14:
        v r9 = r7.a();     // Catch: Throwable -> L66
        String r0 = r9.a();     // Catch: Throwable -> L66
        String r1 = r9.b();     // Catch: Throwable -> L66
        String r10 = r9.i();     // Catch: Throwable -> L66
        String r11 = a(r8);     // Catch: Throwable -> L66
        if ("http".equals(r0) == true) goto L21;
        if ("https".equals(r0) == true) goto L21;
        monitor-exit(this);
        return;
    L21:
        if (TextUtils.isEmpty(r1) == false) goto L25;
        monitor-exit(this);
        return;
    L25:
        if (TextUtils.isEmpty(r11) == false) goto L27;
    L64:
        monitor-exit(this);
        return;
    L27:
        if (r11.contains("timeout") == false) goto L64;
        if (r11.contains("time out") == false) goto L64;
        if (r11.contains("unreachable") == true) goto L64;
        com.bytedance.ttnet.tnc.a r2 = d();     // Catch: Throwable -> L66
        if (r2 != null) goto L36;
    L62:
        monitor-exit(this);
        return;
    L36:
        if (r2.f11500a == false) goto L62;
        if (r2.f11502c != null) goto L41;
    L60:
        monitor-exit(this);
        return;
    L41:
        if (r2.f11502c.size() <= 0) goto L60;
        if (r2.f11502c.containsKey(r1) == false) goto L60;
        if (Logger.debug() == false) goto L48;
        Logger.d(TAG, "onOk3Timeout, url matched: " + r0 + "://" + r1 + "#" + r11 + " " + this.v + "#" + this.w.size() + "#" + this.x.size() + " " + this.y + "#" + this.z.size() + "#" + this.A.size());     // Catch: Throwable -> L66
    L48:
        this.v++;     // Catch: Throwable -> L66
        this.w.put(r10, 0);     // Catch: Throwable -> L66
        this.x.put(r1, 0);     // Catch: Throwable -> L66
        if (this.v >= r2.f11503d) goto L51;
    L58:
        monitor-exit(this);
        return;
    L51:
        if (this.w.size() < r2.f11504e) goto L58;
        if (this.x.size() < r2.f) goto L58;
        if (Logger.debug() == false) goto L57;
        Logger.d(TAG, "onOk3Timeout, url doUpate: " + r0 + "://" + r1);     // Catch: Throwable -> L66
    L57:
        a(false, 0, b.f11521e);     // Catch: Throwable -> L66
        h();     // Catch: Throwable -> L66
    L69:
        monitor-exit(this);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.g
    public JSONObject a() {
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L29
        r2.put("update_time", this.g);     // Catch: JSONException -> L29
        r2.put(DBHelper.BATTERY_COL_SOURCE, this.f.l);     // Catch: JSONException -> L29
        int r5 = 1;
        if (this.h == false) goto L6;
        int r4 = 1;
    L7:
        r2.put("cold_start", r4);     // Catch: JSONException -> L29
        if (this.i == true) goto L11;
        r5 = 0;
    L11:
        r2.put("config_updated", r5);     // Catch: JSONException -> L29
        if (TextUtils.isEmpty(this.j) == true) goto L15;
        r2.put("config", this.j);     // Catch: JSONException -> L29
    L15:
        if (TextUtils.isEmpty(this.k) == true) goto L17;
        r2.put("canary", this.k);     // Catch: JSONException -> L29
    L17:
        r2.put("local_probe_version", this.u);     // Catch: JSONException -> L29
        String r3 = com.bytedance.ttnet.a.a.a(this.q).p();     // Catch: JSONException -> L29
        if (TextUtils.isEmpty(r3) == true) goto L20;
        r2.put("rules", r3);     // Catch: JSONException -> L29
    L20:
        com.bytedance.ttnet.tnc.b r6 = this.r;     // Catch: JSONException -> L29
        if (r6 != null) goto L23;
    L27:
        r1.put("data", r2);     // Catch: JSONException -> L29
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L29
        r7.put("version", this.t);     // Catch: JSONException -> L29
        r7.put("cmd", this.s);     // Catch: JSONException -> L29
        r7.put("send_time", this.f11513d);     // Catch: JSONException -> L29
        r7.put("get_time", this.f11514e);     // Catch: JSONException -> L29
        r1.put("probe", r7);     // Catch: JSONException -> L29
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L29
        r8.put("probe_version", this.u);     // Catch: JSONException -> L29
        r8.put(DBHelper.BATTERY_COL_SOURCE, this.f.l);     // Catch: JSONException -> L29
        r8.put("start_time", this.l);     // Catch: JSONException -> L29
        r1.put(Ext.KEY_REQUEST, r8);     // Catch: JSONException -> L29
    L31:
        return r1;
    L23:
        if (TextUtils.isEmpty(r6.b()) == true) goto L27;
        if (TextUtils.isEmpty(this.r.c()) == true) goto L27;
        r2.put("region", this.r.b());     // Catch: JSONException -> L29
        r2.put("region_source", this.r.c());     // Catch: JSONException -> L29
        goto L27
    L6:
        r4 = 0;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    }

    private void a(ad r13, String r14) {
        if (r13 != null) goto L5;
        return;
    L5:
        if (this.B == true) goto L7;
        return;
    L7:
        String r15 = r13.a("tt-idc-switch", null);
        if (TextUtils.isEmpty(r15) == true) goto L10;
        String[] r16 = r15.split("@");
        if (r16 == null) goto L50;
        if (r16.length != 2) goto L50;
        long r3 = 0;
        int r6 = Integer.parseInt(r16[0]);     // Catch: Throwable -> L24
        long r7 = Long.parseLong(r16[1]);     // Catch: Throwable -> L22
    L31:
        if (Logger.debug() == false) goto L34;
        Logger.d(TAG, "handleTncProbe, local: " + this.s + "@" + this.t + " svr: " + r6 + "@" + r7 + " " + r14);
    L34:
        if (r7 > this.t) goto L36;
        return;
    L36:
        this.s = r6;
        this.t = r7;
        this.f11514e = System.currentTimeMillis();
        this.q.getSharedPreferences("ttnet_tnc_config", 0).edit().putInt("tnc_probe_cmd", r6).putLong("tnc_probe_version", r7).apply();
        if (this.s != 10000) goto L58;
        com.bytedance.ttnet.tnc.a r17 = d();
        if (r17 != null) goto L41;
        return;
    L41:
        Random r0 = new Random(System.currentTimeMillis());
        if (r17.k <= 0) goto L45;
        r3 = ((long) r0.nextInt(r17.k)) * 1000;
    L45:
        if (Logger.debug() == false) goto L47;
        Logger.d(TAG, "handleTncProbe, updateConfig delay: " + r3 + " " + r14);
    L47:
        a(true, r3, b.g);
        return;
    L58:
        return;
    L22:
        th = th;
    L26:
        th.printStackTrace();
        if (Logger.debug() == false) goto L29;
        Logger.d(TAG, "handleTncProbe, probeProto except, " + r14);
    L29:
        r7 = 0;
    L24:
        th = th;
        r6 = 0;
    L50:
        if (Logger.debug() == false) goto L59;
        Logger.d(TAG, "handleTncProbe, probeProto err, " + r14);
        return;
    L59:
        return;
    L10:
        if (Logger.debug() == false) goto L57;
        Logger.d(TAG, "handleTncProbe, no probeProto, " + r14);
        return;
    }

    public void f() {
        if (d() != null) goto L5;
        return;
    L5:
        if (h.b(this.q) == true) goto L7;
        return;
    L7:
        if (this.m.compareAndSet(false, true) == false) goto L12;
        a(true, 0, b.k);
        return;
    }

    private void a(boolean r4, long r5, b r7) {
        if (this.f11510a.hasMessages(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) == false) goto L5;
        return;
    L5:
        Message r0 = this.f11510a.obtainMessage();
        r0.what = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        r0.arg1 = r4 ? 1 : 0;
        r0.arg2 = r7.l;
        if (r5 <= 0) goto L8;
        this.f11510a.sendMessageDelayed(r0, r5);
        return;
    L8:
        this.f11510a.sendMessage(r0);
    }

    private void a(boolean r10, b r11) {
        com.bytedance.ttnet.tnc.a r0 = d();
        if (r0 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "doUpdateRemote, " + r10);
    L8:
        long r3 = SystemClock.elapsedRealtime();
        if (r10 == false) goto L11;
    L16:
        this.f11512c = r3;
        if (r11 != b.g) goto L19;
        this.f11513d = System.currentTimeMillis();
    L19:
        com.bytedance.ttnet.a.a.a(this.q).b(r11, false);
        return;
    L11:
        if ((this.f11512c + (((long) r0.j) * 1000)) <= r3) goto L16;
        if (Logger.debug() == false) goto L21;
        Logger.d(TAG, "doUpdateRemote, time limit");
        return;
    }

    private void h() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "resetTNCControlState");
    L5:
        this.v = 0;
        this.w.clear();
        this.x.clear();
        this.y = 0;
        this.z.clear();
        this.A.clear();
    }

    private String a(Exception r2) {
        StringWriter r1 = new StringWriter();
        r2.printStackTrace(new PrintWriter(r1));
        return r1.toString().toLowerCase();
    }

    private boolean b(int r4) {
        if (r4 >= 100) goto L5;
    L16:
        return true;
    L5:
        if (r4 >= 1000) goto L16;
        com.bytedance.ttnet.tnc.a r3 = d();
        if (r3 != null) goto L10;
        return false;
    L10:
        if (TextUtils.isEmpty(r3.l) == false) goto L12;
        return false;
    L12:
        if (r3.l.contains("" + r4) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public boolean a(Context r26, boolean r27, b r28, String r29) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r26, Context.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "getdomain internal, use retrofit okhttp: " + r27 + ", tnc source: " + r28);
    L5:
        ArrayList r0 = new ArrayList();
        if (com.bytedance.ttnet.a.a.a(r13).o() != null) goto L8;
    L15:
        r0.addAll(Arrays.asList(com.bytedance.ttnet.a.a.a(r13).l()));
    L16:
        this.f = r28;
        this.l = System.currentTimeMillis();
        Iterator r15 = r0.iterator();
    L18:
        if (r15.hasNext() == false) goto L92;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");
        StringBuilder r3 = new StringBuilder();
        r3.append("https://").append(r1).append("/get_domains/v5/");
        k r4 = new k(r3.toString());
        if (Build.VERSION.SDK_INT >= 21) goto L23;
        String r2 = Build.CPU_ABI;     // Catch: Throwable -> L29
    L24:
        r4.a("abi", r2);     // Catch: Throwable -> L29
        r4.a("tnc_src", r28.l);     // Catch: Throwable -> L29
        r4.a("okhttp_version", "4.2.243.22-doubao");     // Catch: Throwable -> L29
        if (com.bytedance.frameworks.baselib.network.http.h.b.a().c() == false) goto L27;
        r4.a("use_store_region_cookie", "1");     // Catch: Throwable -> L29
    L27:
        a(r4);     // Catch: Throwable -> L29
    L31:
        HashMap r5 = new HashMap();
        com.bytedance.frameworks.baselib.network.http.h.b.a().a(r5);
        boolean r16 = !TextUtils.isEmpty(com.bytedance.frameworks.baselib.network.http.h.b.a().d());
        if (TextUtils.isEmpty(r29) == true) goto L36;
        r5.put("x-tt-tnc-summary", r29);
    L36:
        if (r27 == false) goto L37;
        r4.a(WsConstants.KEY_APP_ID, TTNetInit.getTTNetDepend().g());
        r4.a("device_platform", "android");
        if (TTNetInit.getCronetProvider() == null) goto L53;
        r4.a("version_code", TTNetInit.getCronetProvider().getVersionCode());
        r4.a("channel", TTNetInit.getCronetProvider().getChannel());
    L53:
        ArrayList r6 = new ArrayList();
        Iterator<Map.Entry<String, String>> r7 = r5.entrySet().iterator();
    L55:
        if (r7.hasNext() == false) goto L61;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r8.getKey(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L55;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r8.getValue(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L55;
        r6.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(r8.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r8.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L55
    L61:
        String r9 = r4.toString();
        LinkedHashMap r10 = new LinkedHashMap();
        Pair<String, String> r11 = l.a(r9, r10);     // Catch: IOException -> L90
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.first, String.class, "com.obric.aiagent.plugin");     // Catch: IOException -> L90
        String r21 = (String) ZeusTransformUtils.preCheckCast(r11.second, String.class, "com.obric.aiagent.plugin");     // Catch: IOException -> L90
        INetworkApi r18 = (INetworkApi) ZeusTransformUtils.preCheckCast(d.a(r12, INetworkApi.class), INetworkApi.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L18;
        e<String> r19 = r18.doGet(true, -1, r21, r10, r6, null);
        ak<String> r14 = r19.a();     // Catch: Throwable -> L81
        List<com.bytedance.retrofit2.b.b> r17 = r14.d();     // Catch: Throwable -> L81
        String r20 = (String) ZeusTransformUtils.preCheckCast(r14.f(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L81
        if (this.C != null) goto L70;
    L74:
        String r22 = d.a(r17, "x-ss-etag");     // Catch: Throwable -> L81
        String r23 = d.a(r17, "x-tt-tnc-abtest");     // Catch: Throwable -> L81
        String r24 = d.a(r17, "x-tt-tnc-control");     // Catch: Throwable -> L81
        this.j = d.a(r17, "x-tt-tnc-config");     // Catch: Throwable -> L81
        this.k = d.a(r17, "x-ss-canary");     // Catch: Throwable -> L81
        if (c().a(r13, r28, r20, r24, r22, r23, r16) == true) goto L78;
        if (r19 == null) goto L18;
    L77:
        r19.b();
        goto L18
    L78:
        if (r19 == null) goto L80;
        r19.b();
    L80:
        return true;
    L70:
        if (this.C.b("GET", r19.e().b(), r17, r20) == true) goto L74;
        if (r19 == null) goto L73;
        r19.b();
    L73:
        return false;
    L81:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L85
        if (r19 == null) goto L18;
    L85:
        th = move-exception;
        if (r19 == null) goto L135;
        r19.b();
        throw th;
    L135:
        throw th;
    L90:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L37:
        com.bytedance.ttnet.d.a r25 = new com.bytedance.ttnet.d.a();
        r25.f11409b = r4.toString();
        r25.f = true;
        long r30 = System.currentTimeMillis();
    L48:
        th = move-exception;
        th.printStackTrace();
        goto L18
    L39:
        if (a("GET", r25.f11409b, r5, "") == false) goto L40;
        HashMap r31 = new HashMap();     // Catch: Throwable -> L48
        String r32 = com.bytedance.ttnet.d.c.a(r25.f11409b, r5, r31, r25);     // Catch: Throwable -> L48
        if (b("GET", r25.f11409b, r31, r32) == false) goto L43;
        r25.f11410c = System.currentTimeMillis() - r30;     // Catch: Throwable -> L48
        this.k = r25.n;     // Catch: Throwable -> L48
        this.j = r25.m;     // Catch: Throwable -> L48
        if (c().a(r13, r28, r32, r25.l, r25.h, r25.i, r16) == false) goto L18;
        return true;
    L43:
        return false;
    L40:
        return false;
    L23:
        r2 = Build.SUPPORTED_ABIS[0];     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.printStackTrace();
        goto L31
    L92:
        return false;
    L8:
        if (com.bytedance.ttnet.a.a.a(r13).o().size() == 0) goto L15;
        r0.addAll(com.bytedance.ttnet.a.a.a(r13).o());
        String[] r33 = com.bytedance.ttnet.a.a.a(r13).l();
        int r34 = r33.length;
        int r35 = 0;
    L10:
        if (r35 >= r34) goto L16;
        String r36 = r33[r35];
        if (r0.contains(r36) == true) goto L14;
        r0.add(r36);
    L14:
        r35 = r35 + 1;
        goto L10
    }

    private boolean a(Context r8, b r9, String r10, String r11, String r12, String r13, boolean r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
    L26:
        return false;
    L4:
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "okhttp tnc response success, etag is " + r12 + ", tnc control " + r11);     // Catch: Exception -> L26
    L7:
        if (TextUtils.isEmpty(r12) == true) goto L9;
        com.bytedance.ttnet.a.a.a(r15).c(r12);     // Catch: Exception -> L26
    L9:
        c().r.a(r13);     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r11) == true) goto L15;
        if (r11.equals("1") == false) goto L15;
        return true;
    L15:
        if (TextUtils.isEmpty(r10) == false) goto L17;
        return false;
    L17:
        JSONObject r2 = new JSONObject(r10);     // Catch: Exception -> L26
        ClientKeyManager.a().a(r10);     // Catch: Exception -> L26
        boolean r16 = com.bytedance.ttnet.a.a.a(r15).a(r2, r9, System.currentTimeMillis(), r14);     // Catch: Exception -> L26
        if (r16 == false) goto L25;
        this.g = System.currentTimeMillis();     // Catch: Exception -> L26
        if (this.h == true) goto L22;
        this.h = true;     // Catch: Exception -> L26
    L22:
        this.i = true;     // Catch: Exception -> L26
        if (r9 != b.g) goto L25;
        this.u = this.t;     // Catch: Exception -> L26
    L25:
        return r16;
    }

    private static void a(k r5) {
        com.bytedance.ttnet.d r0 = TTNetInit.getTTNetDepend();
        if (r0 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.ttnet.a.class) == false) goto L16;
        Map<String, String> r1 = ((com.bytedance.ttnet.a) ZeusTransformUtils.preCheckCast(r0, com.bytedance.ttnet.a.class, "com.obric.aiagent.plugin")).c();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isEmpty() == true) goto L18;
        Iterator<Map.Entry<String, String>> r2 = r1.entrySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L19;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r5.a((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L12
    L19:
        return;
    L18:
        return;
    }

    private b c(int r1) {
        if (r1 == 7) goto L34;
        if (r1 == 10) goto L32;
        if (r1 == 20) goto L30;
        if (r1 == 30) goto L28;
        switch(r1) {
            case -2: goto L26;
            case -1: goto L24;
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            default: goto L12;
        };
    L12:
        return b.f11520d;
    L14:
        return b.g;
    L16:
        return b.f;
    L18:
        return b.f11521e;
    L20:
        return b.f11520d;
    L22:
        return b.f11519c;
    L24:
        return b.f11518b;
    L26:
        return b.f11517a;
    L28:
        return b.k;
    L30:
        return b.j;
    L32:
        return b.i;
    L34:
        return b.h;
    }

    public boolean a(String r3, String r4, Map<String, String> r5, String r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (this.C != null) goto L6;
        return true;
    L6:
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        List<com.bytedance.retrofit2.b.b> r8 = b(r7);
        return this.C.a(r3, r4, r8, r6);
    }

    public boolean b(String r3, String r4, Map<String, List<String>> r5, String r6) {
        Map<String, List<String>> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (this.C != null) goto L6;
        return true;
    L6:
        List<com.bytedance.retrofit2.b.b> r8 = a(r7);
        return this.C.b(r3, r4, r8, r6);
    }

    private List<com.bytedance.retrofit2.b.b> a(Map<String, List<String>> r7) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        ArrayList r8 = new ArrayList();
        Iterator r1 = r6.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        List r3 = (List) ZeusTransformUtils.preCheckCast(r6.get(r2), List.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L4;
        Iterator r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L4;
        r8.add(new com.bytedance.retrofit2.b.b(r2, (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin")));
        goto L10
    L12:
        return r8;
    }

    private List<com.bytedance.retrofit2.b.b> b(Map<String, String> r6) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        ArrayList r7 = new ArrayList();
        Iterator r1 = r5.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r5.get(r2), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r2) == true) goto L4;
        if (TextUtils.isEmpty(r3) == true) goto L4;
        r7.add(new com.bytedance.retrofit2.b.b(r2, r3));
        goto L4
    L10:
        return r7;
    }
}
