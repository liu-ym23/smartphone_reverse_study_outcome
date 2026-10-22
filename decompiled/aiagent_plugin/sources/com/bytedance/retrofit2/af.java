package com.bytedance.retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RetrofitMetrics.java */
/* JADX INFO: loaded from: classes.dex */
public class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.bytedance.retrofit2.b f9430a = null;
    private static HandlerThread aI = null;
    private static volatile Handler aJ = null;
    private static b aM = null;
    private static volatile boolean aN = false;
    private static volatile boolean aO = false;
    private static volatile com.bytedance.retrofit2.c aP;
    public boolean A;
    public long B;
    public long C;
    public long D;
    public long E;
    public long F;

    @Deprecated
    public long G;

    @Deprecated
    public long H;

    @Deprecated
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    @Deprecated
    public long f9431J;

    @Deprecated
    public long K;

    @Deprecated
    public long L;

    @Deprecated
    public long M;

    @Deprecated
    public transient Throwable N;

    @Deprecated
    public Map<String, Long> O;

    @Deprecated
    public Map<String, Long> P;

    @Deprecated
    public long Q;

    @Deprecated
    public long R;

    @Deprecated
    public long S;

    @Deprecated
    public long T;

    @Deprecated
    public long U;

    @Deprecated
    public long V;

    @Deprecated
    public long W;

    @Deprecated
    public long X;

    @Deprecated
    public long Y;

    @Deprecated
    public long Z;

    @Deprecated
    public JSONObject aA;

    @Deprecated
    public int aB;

    @Deprecated
    public List<c> aC;

    @Deprecated
    public List<c> aD;
    public ad aE;
    public v aF;
    private a aG;
    private boolean aH;
    private boolean aK;
    private boolean aL;

    @Deprecated
    public long aa;

    @Deprecated
    public long ab;

    @Deprecated
    public long ac;

    @Deprecated
    public long ad;

    @Deprecated
    public Map<String, Long> ae;
    public String af;
    public JSONArray ag;
    public String ah;
    public boolean ai;

    @Deprecated
    public long aj;

    @Deprecated
    public long ak;

    @Deprecated
    public long al;
    public int am;
    public int an;
    public String ao;
    public String ap;
    public JSONObject aq;
    public int ar;

    @Deprecated
    public long as;

    @Deprecated
    public long at;

    @Deprecated
    public long au;

    @Deprecated
    public long av;

    @Deprecated
    public long aw;

    @Deprecated
    public long ax;

    @Deprecated
    public int ay;
    public Map<String, Object> az;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public URL f9432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient WeakReference<u> f9434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9435e;
    public int f;
    public int g;
    public String h;
    public int i;
    public String j;
    public JSONObject k;
    public String l;
    public boolean m;

    @Deprecated
    public long n;

    @Deprecated
    public long o;

    @Deprecated
    public long p;

    @Deprecated
    public long q;

    @Deprecated
    public long r;

    @Deprecated
    public long s;

    @Deprecated
    public long t;

    @Deprecated
    public long u;

    @Deprecated
    public long v;

    @Deprecated
    public long w;

    @Deprecated
    public long x;
    public int y;
    public String z;

    /* JADX INFO: compiled from: RetrofitMetrics.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9442a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f9443b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f9444c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f9445d = null;
        private static final /* synthetic */ a[] f = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f9446e;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("ENCRYPT_NONE", 0, 0);
            f9442a = r0;
            a r1 = new a("ENCRYPT_QUERY", 1, 1);
            f9443b = r1;
            a r3 = new a("ENCRYPT_BODY", 2, 2);
            f9444c = r3;
            a r5 = new a("ENCRYPT_BOTH_QUERY_AND_BODY", 3, 3);
            f9445d = r5;
            f = new a[]{r0, r1, r3, r5};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f9446e = r3;
        }

        public int a() {
            return this.f9446e;
        }
    }

    /* JADX INFO: compiled from: RetrofitMetrics.java */
    public interface b {
        void a(String r1, Object r2);

        void a(String r1, Object r2, Throwable r3);

        boolean b();
    }

    /* JADX INFO: compiled from: RetrofitMetrics.java */
    @Deprecated
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f9448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f9449c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f9450d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ af f9451e;

        public c(af r1, String r2, long r3) {
            this.f9451e = r1;
            this.f9450d = null;
            this.f9447a = r2;
            this.f9448b = r3;
            this.f9449c = r3;
        }
    }

    static {
    }

    static /* synthetic */ void a(af r0, Object r1, Throwable r2) {
        r0.a(r1, r2);
    }

    public void a(a r1) {
        this.aG = r1;
    }

    public af(u r8) {
        u r9 = (u) ZeusTransformUtils.wrapperContextForParams(r8, u.class, "com.obric.aiagent.plugin");
        this.f9432b = null;
        this.f9434d = null;
        this.f9435e = -1;
        this.f = -1;
        this.aG = a.f9442a;
        this.g = -1;
        this.h = "";
        this.i = -1;
        this.j = "";
        this.l = "";
        this.m = false;
        this.y = -1;
        this.z = null;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.N = null;
        this.O = new ConcurrentHashMap();
        this.P = new ConcurrentHashMap();
        this.Q = -1;
        this.R = -1;
        this.S = -1;
        this.T = -1;
        this.U = -1;
        this.V = -1;
        this.W = -1;
        this.X = -1;
        this.Y = -1;
        this.Z = -1;
        this.aa = -1;
        this.ab = -1;
        this.ac = -1;
        this.ad = -1;
        this.ae = new HashMap();
        this.af = "";
        this.ah = "";
        this.ai = true;
        this.am = -999;
        this.an = -1;
        this.ao = "";
        this.ap = "";
        this.as = -1;
        this.at = -1;
        this.au = -1;
        this.av = -1;
        this.aw = -1;
        this.ax = -1;
        this.ay = -1;
        this.az = new HashMap();
        this.aA = null;
        this.aB = 0;
        this.aC = new ArrayList();
        this.aD = new ArrayList();
        this.aE = new ad();
        this.aF = new v();
        this.aH = false;
        this.aK = false;
        this.aL = false;
        this.f9434d = new WeakReference(r9);
    }

    public af() {
        this.f9432b = null;
        this.f9434d = null;
        this.f9435e = -1;
        this.f = -1;
        this.aG = a.f9442a;
        this.g = -1;
        this.h = "";
        this.i = -1;
        this.j = "";
        this.l = "";
        this.m = false;
        this.y = -1;
        this.z = null;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.N = null;
        this.O = new ConcurrentHashMap();
        this.P = new ConcurrentHashMap();
        this.Q = -1;
        this.R = -1;
        this.S = -1;
        this.T = -1;
        this.U = -1;
        this.V = -1;
        this.W = -1;
        this.X = -1;
        this.Y = -1;
        this.Z = -1;
        this.aa = -1;
        this.ab = -1;
        this.ac = -1;
        this.ad = -1;
        this.ae = new HashMap();
        this.af = "";
        this.ah = "";
        this.ai = true;
        this.am = -999;
        this.an = -1;
        this.ao = "";
        this.ap = "";
        this.as = -1;
        this.at = -1;
        this.au = -1;
        this.av = -1;
        this.aw = -1;
        this.ax = -1;
        this.ay = -1;
        this.az = new HashMap();
        this.aA = null;
        this.aB = 0;
        this.aC = new ArrayList();
        this.aD = new ArrayList();
        this.aE = new ad();
        this.aF = new v();
        this.aH = false;
        this.aK = false;
        this.aL = false;
        new af(null);
    }

    public af a() {
        af r0 = new af();
        r0.v = this.v;
        r0.n = this.o;
        r0.t = this.t;
        r0.u = this.u;
        r0.f9433c = this.f9433c;
        ad.b r1 = r0.aE.f;
        r1.f9418e = this.aE.f.f9418e;
        ad.b r2 = r0.aE.f;
        r2.f = this.aE.f.f;
        ad.b r3 = r0.aE.f;
        r3.g = this.aE.f.g;
        ad.c r4 = r0.aE.h;
        r4.f9419a = this.aE.h.f9419a;
        ad.c r5 = r0.aE.h;
        r5.f9420b = this.aE.h.f9420b;
        return r0;
    }

    @Deprecated
    public String b() {
        JSONObject r0 = new JSONObject();
    L39:
        e = move-exception;
        e.printStackTrace();
    L42:
        return r0.toString();
    L4:
        if (this.g == (-1)) goto L6;
        r0.put("model", aI());     // Catch: JSONException -> L39
    L6:
        JSONObject r1 = this.k;     // Catch: JSONException -> L39
        if (r1 == null) goto L9;
        r0.put("concurrentRequest", r1);     // Catch: JSONException -> L39
    L9:
        r0.put("concurrent", this.m);     // Catch: JSONException -> L39
        r0.put("base", aJ());     // Catch: JSONException -> L39
        r0.put("callback", aK());     // Catch: JSONException -> L39
        r0.put("interceptor", aL());     // Catch: JSONException -> L39
        r0.put("ttnetVersion", this.af);     // Catch: JSONException -> L39
        JSONArray r2 = this.ag;     // Catch: JSONException -> L39
        if (r2 != null) goto L12;
    L14:
        JSONObject r3 = this.aq;     // Catch: JSONException -> L39
        if (r3 == null) goto L17;
        r0.put("compress", r3);     // Catch: JSONException -> L39
    L17:
        int r4 = this.ar;     // Catch: JSONException -> L39
        if (r4 <= 0) goto L20;
        r0.put("postBufferSize", r4);     // Catch: JSONException -> L39
    L20:
        int r5 = this.aB;     // Catch: JSONException -> L39
        if (r5 <= 0) goto L24;
        r0.put("blockingQueueSize", r5);     // Catch: JSONException -> L39
    L24:
        if (this.aF.i.f9626e <= 0) goto L26;
        r0.put("apiStreamReadCount", this.aF.i.f9626e);     // Catch: JSONException -> L39
    L26:
        r0.put("stateDelayed", this.A);     // Catch: JSONException -> L39
        r0.put("stateDelayTime", this.B);     // Catch: JSONException -> L39
        r0.put("syncCount", this.C);     // Catch: JSONException -> L39
        r0.put("asyncCount", this.D);     // Catch: JSONException -> L39
        r0.put("delayState", this.y);     // Catch: JSONException -> L39
        r0.put("random", this.F);     // Catch: JSONException -> L39
        if (TextUtils.isEmpty(this.z) == true) goto L30;
        r0.put("stateName", this.z);     // Catch: JSONException -> L39
    L30:
        if (this.Y < 0) goto L32;
        r0.put("cli_key", true);     // Catch: JSONException -> L39
    L32:
        int r6 = this.f9435e;     // Catch: JSONException -> L39
        if (r6 < 0) goto L35;
        r0.put("cp_cnt", r6);     // Catch: JSONException -> L39
    L35:
        int r7 = this.f;     // Catch: JSONException -> L39
        if (r7 < 0) goto L42;
        r0.put("read_type", r7);     // Catch: JSONException -> L39
        goto L42
    L12:
        if (r2.length() <= 0) goto L14;
        r0.put("actionInfo", this.ag);     // Catch: JSONException -> L39
        goto L14
    }

    private JSONObject aI() {
        JSONObject r3 = new JSONObject();
        r3.put("model", Build.MODEL);     // Catch: JSONException -> L13
        String r0 = "";
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        r0 = Build.CPU_ABI;     // Catch: JSONException -> L13
    L11:
        r3.put("abis", r0);     // Catch: JSONException -> L13
    L15:
        return r3;
    L6:
        String[] r1 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L13
        if (r1 == null) goto L11;
        if (r1.length <= 0) goto L11;
        r0 = Arrays.asList(r1).toString();     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    @Deprecated
    private JSONObject aJ() {
        JSONObject r8 = new JSONObject();
        r8.put("fallback", this.g);     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(this.h) == true) goto L6;
        r8.put("fallbackMessage", this.h);     // Catch: JSONException -> L23
    L6:
        r8.put("reqFallback", this.i);     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(this.j) == true) goto L9;
        r8.put("reqFallbackMsg", this.j);     // Catch: JSONException -> L23
    L9:
        r8.put("createRetrofitTime", this.n);     // Catch: JSONException -> L23
        r8.put("appRequestStartTime", this.o);     // Catch: JSONException -> L23
        r8.put("beforeAllInterceptTime", this.p);     // Catch: JSONException -> L23
        r8.put("callServerInterceptTime", this.q);     // Catch: JSONException -> L23
        r8.put("callExecuteStartTime", this.r);     // Catch: JSONException -> L23
        r8.put("reportTime", this.s);     // Catch: JSONException -> L23
        if (this.aG == a.f9442a) goto L13;
        r8.put("encrypt", this.aG.a());     // Catch: JSONException -> L23
    L13:
        if (TextUtils.isEmpty(this.l) == true) goto L15;
        r8.put("transactionId", this.l);     // Catch: JSONException -> L23
    L15:
        long r0 = this.aw;     // Catch: JSONException -> L23
        if (r0 < 0) goto L18;
        r8.put("upper_add_cookie_us", r0);     // Catch: JSONException -> L23
    L18:
        long r1 = this.ax;     // Catch: JSONException -> L23
        if (r1 < 0) goto L21;
        r8.put("upper_save_cookie_us", r1);     // Catch: JSONException -> L23
    L21:
        r8.put("request_cookie_source", this.ay);     // Catch: JSONException -> L23
    L25:
        boolean r7 = a(r8, "loadServiceMethod", this.t, this.u, true);
        long r3 = this.w;
        if (r3 <= 0) goto L28;
        boolean r2 = a(r8, "enqueueWait", r3, this.G, r7);
    L29:
        boolean r9 = r2;
        a(r8, "biz_start_after_cronet_start", this.aE.f.f9416c / 1000, this.aE.f.k / 1000, true);
        a(r8, "biz_start_before_cronet_end", this.aE.f.m / 1000, this.aE.f.f9417d / 1000, true);
        boolean r10 = a(r8, "executeCall", this.f9431J, this.K, r9);
        boolean r11 = a(r8, "requestParse", this.H, this.I, r10);
        a(r8, "responseParse", this.L, this.M, r11);
        return r8;
    L28:
        r2 = a(r8, "executeWait", this.x, this.G, r7);
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    }

    @Deprecated
    private JSONObject aK() {
        JSONObject r0 = new JSONObject();
        r0.put("filterUrl", this.Q);     // Catch: JSONException -> L8
        r0.put("addCommonParam", this.R);     // Catch: JSONException -> L8
        r0.put("requestVerify", this.S);     // Catch: JSONException -> L8
        r0.put("encryptRequest", this.U);     // Catch: JSONException -> L8
        r0.put("genReqTicket", this.V);     // Catch: JSONException -> L8
        r0.put("checkReqTicket", this.W);     // Catch: JSONException -> L8
        r0.put("preCdnVerify", this.X);     // Catch: JSONException -> L8
        r0.put("postCdnVerify", this.aa);     // Catch: JSONException -> L8
        r0.put("addClientKey", this.Y);     // Catch: JSONException -> L8
        r0.put("updateClientKey", this.Z);     // Catch: JSONException -> L8
        r0.put("commandListener", this.ab);     // Catch: JSONException -> L8
        r0.put("filterDupQuery", this.T);     // Catch: JSONException -> L8
        r0.put("queryFilter", this.ac);     // Catch: JSONException -> L8
        long r1 = this.ad;     // Catch: JSONException -> L8
        if (r1 < 0) goto L6;
        r0.put("bodyEncrypt", r1);     // Catch: JSONException -> L8
    L6:
        r0.put("setSpeed", this.as);     // Catch: JSONException -> L8
        r0.put("tryInit", this.at);     // Catch: JSONException -> L8
        r0.put("openConn", this.au);     // Catch: JSONException -> L8
        r0.put("prepareReq", this.av);     // Catch: JSONException -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    @Deprecated
    private JSONObject aL() {
        JSONObject r0 = new JSONObject();
    L19:
        e = move-exception;
        e.printStackTrace();
    L21:
        return r0;
    L5:
        if (this.O.isEmpty() == true) goto L12;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L19
        Iterator<Map.Entry<String, Long>> r3 = this.O.entrySet().iterator();     // Catch: JSONException -> L19
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L19
        r1.put((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin"), r4.getValue());     // Catch: JSONException -> L19
        goto L8
    L10:
        r0.put(Ext.KEY_REQUEST, r1);     // Catch: JSONException -> L19
    L12:
        if (this.P.isEmpty() == true) goto L21;
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L19
        Iterator<Map.Entry<String, Long>> r7 = this.P.entrySet().iterator();     // Catch: JSONException -> L19
    L15:
        if (r7.hasNext() == false) goto L17;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L19
        r2.put((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin"), r5.getValue());     // Catch: JSONException -> L19
        goto L15
    L17:
        r0.put("response", r2);     // Catch: JSONException -> L19
        goto L21
    }

    private boolean a(JSONObject r1, String r2, long r3, long r5, boolean r7) {
        if (r7 == true) goto L5;
    L10:
        r1.put(r2, -1);     // Catch: JSONException -> L12
        return false;
    L5:
        if (r3 > r5) goto L10;
        r1.put(r2, r5 - r3);     // Catch: JSONException -> L12
        return true;
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Deprecated
    public void a(com.bytedance.retrofit2.d.b r5) {
        String r6 = ((com.bytedance.retrofit2.d.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.d.b.class, "com.obric.aiagent.plugin")).getClass().getName();
        if (TextUtils.isEmpty(r6) == true) goto L6;
        String r7 = r6.substring(r6.lastIndexOf(46) + 1);
        this.aC.add(new c(this, r7, SystemClock.uptimeMillis()));
        return;
    }

    @Deprecated
    public void c() {
        if (this.aC.size() > 0) goto L5;
        return;
    L5:
        List<c> r2 = this.aC;
        ((c) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), c.class, "com.obric.aiagent.plugin")).f9449c = SystemClock.uptimeMillis();
    }

    @Deprecated
    public void b(com.bytedance.retrofit2.d.b r5) {
        String r6 = ((com.bytedance.retrofit2.d.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.d.b.class, "com.obric.aiagent.plugin")).getClass().getName();
        if (TextUtils.isEmpty(r6) == true) goto L6;
        String r7 = r6.substring(r6.lastIndexOf(46) + 1);
        this.aD.add(new c(this, r7, SystemClock.uptimeMillis()));
        return;
    }

    @Deprecated
    public void a(Exception r6) {
        if (this.aD.size() > 0) goto L5;
        return;
    L5:
        List<c> r0 = this.aD;
        ((c) ZeusTransformUtils.preCheckCast(r0.get(r0.size() - 1), c.class, "com.obric.aiagent.plugin")).f9449c = SystemClock.uptimeMillis();
        if (r6 == null) goto L9;
        List<c> r5 = this.aD;
        ((c) ZeusTransformUtils.preCheckCast(r5.get(r5.size() - 1), c.class, "com.obric.aiagent.plugin")).f9450d = r6.getClass().getSimpleName();
        return;
    }

    public void a(boolean r4) {
        ad.b r0 = this.aE.f;
        long r1 = System.currentTimeMillis();
        r0.f9418e = r1;
        this.n = r1;
        ad.b r2 = this.aE.f;
        r2.f = System.nanoTime();
        long r3 = am.a(this.aE.f.f);
        this.v = r3;
        if (r4 == false) goto L6;
        this.u = r3;
        this.t = r3;
        return;
    }

    public void d() {
        ad.b r2 = this.aE.f;
        r2.g = System.nanoTime();
    }

    public void b(boolean r7) {
        ad.b r0 = this.aE.f;
        long r1 = System.currentTimeMillis();
        r0.l = r1;
        this.o = r1;
        this.aE.f.k = System.nanoTime();
        if (r7 == false) goto L5;
        this.w = am.a(this.aE.f.k);
    L6:
        this.aE.j.f = com.bytedance.retrofit2.a.c();
        this.aE.g.f9409a = this.aE.f.k - this.aE.f.g;
        if (this.aE.f.i != (-1)) goto L9;
        return;
    L9:
        if (this.aE.f.i < this.aE.f.k) goto L11;
        return;
    L11:
        if (this.aE.h.f9421c == (-1)) goto L16;
        this.aE.g.f9409a -= this.aE.h.f9421c;
        return;
    L16:
        return;
    L5:
        this.x = am.a(this.aE.f.k);
        goto L6
    }

    public void e() {
        long r0 = System.nanoTime();
        this.aE.f.j = r0;
        this.aE.h.f9422d = r0 - this.aE.f.k;
        if (this.aE.f.h > this.aE.f.k) goto L5;
        return;
    L5:
        if (this.aE.h.f9421c == (-1)) goto L9;
        this.aE.h.f9422d -= this.aE.h.f9421c;
        return;
    }

    public void f() {
        ad.b r0 = this.aE.f;
        r0.m = System.nanoTime();
        this.al = am.a(this.aE.f.m);
    }

    public void g() {
        ad.b r0 = this.aE.f;
        r0.p = System.nanoTime();
        this.f9431J = am.a(this.aE.f.p);
        this.r = p(this.aE.f.p);
    }

    public void h() {
        ad.b r0 = this.aE.f;
        r0.q = System.nanoTime();
        this.K = am.a(this.aE.f.q);
    }

    public void i() {
        ad.b r0 = this.aE.f;
        r0.u = System.currentTimeMillis();
        ad.b r3 = this.aE.f;
        r3.t = System.nanoTime();
    }

    private boolean aM() {
        if (this.aE.f.v == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void j() {
        ad.b r0 = this.aE.f;
        r0.v = System.nanoTime();
        ad.b r1 = this.aE.f;
        r1.w = System.currentTimeMillis();
        WeakReference<u> r2 = this.f9434d;
        if (r2 == null) goto L6;
        ((u) ZeusTransformUtils.preCheckCast(r2.get(), u.class, "com.obric.aiagent.plugin")).a(this.aE.f.w);
        return;
    }

    public void k() {
        ad.b r0 = this.aE.f;
        r0.x = System.nanoTime();
        this.s = p(this.aE.f.x);
    }

    public void l() {
        this.aE.g.a();
    }

    public void m() {
        ad.a r0 = this.aE.g;
        r0.f9410b = this.aE.g.b();
    }

    public void n() {
        this.aE.g.a();
    }

    public void o() {
        ad.a r0 = this.aE.g;
        r0.f9411c = this.aE.g.b();
        this.Q = am.a(this.aE.g.f9411c);
    }

    public void p() {
        this.aE.g.a();
    }

    public void q() {
        ad.a r0 = this.aE.g;
        r0.f9412d = this.aE.g.b();
    }

    public void r() {
        this.aE.g.a();
    }

    public void s() {
        ad.a r0 = this.aE.g;
        r0.f9413e = this.aE.g.b();
        this.R = am.a(this.aE.g.f9413e);
    }

    public void t() {
        this.aE.g.a();
    }

    public void u() {
        ad.a r0 = this.aE.g;
        r0.f = this.aE.g.b();
        this.U = am.a(this.aE.g.f);
    }

    public void v() {
        this.aE.g.a();
    }

    public void w() {
        ad.a r0 = this.aE.g;
        r0.g = this.aE.g.b();
        this.S = am.a(this.aE.g.g);
    }

    public void x() {
        this.aE.g.a();
    }

    public void y() {
        ad.a r0 = this.aE.g;
        r0.h = this.aE.g.b();
        this.ab = am.a(this.aE.g.h);
    }

    public void z() {
        this.aE.g.a();
    }

    public void A() {
        ad.a r0 = this.aE.g;
        r0.i = this.aE.g.b();
        this.W = am.a(this.aE.g.i);
    }

    public void B() {
        this.aE.g.a();
    }

    public void C() {
        ad.a r0 = this.aE.g;
        r0.j = this.aE.g.b();
        this.aa = am.a(this.aE.g.j);
    }

    public void D() {
        this.aE.g.a();
        this.aj = SystemClock.uptimeMillis();
    }

    public void E() {
        ad.a r0 = this.aE.g;
        r0.m = this.aE.g.b();
        this.ak = SystemClock.uptimeMillis();
    }

    public void F() {
        this.aE.h.a();
        this.t = SystemClock.uptimeMillis();
    }

    public void G() {
        ad.c r0 = this.aE.h;
        r0.f9419a = this.aE.h.b();
    }

    public void H() {
        this.aE.h.a();
        this.u = SystemClock.uptimeMillis();
    }

    public void I() {
        ad.c r0 = this.aE.h;
        r0.f9420b = this.aE.h.b();
    }

    public void J() {
        this.aE.h.a();
        ad.b r0 = this.aE.f;
        r0.h = System.nanoTime();
        this.H = am.a(this.aE.f.h);
    }

    public void K() {
        ad.c r0 = this.aE.h;
        r0.f9421c = this.aE.h.b();
        ad.b r1 = this.aE.f;
        r1.i = System.nanoTime();
        this.I = am.a(this.aE.f.i);
    }

    public void L() {
        this.aE.h.a();
    }

    public void M() {
        ad.c r0 = this.aE.h;
        r0.f9423e = this.aE.h.b();
        this.T = am.a(this.aE.h.f9423e);
    }

    public void N() {
        this.aE.h.a();
    }

    public void O() {
        ad.c r0 = this.aE.h;
        r0.f = this.aE.h.b();
        this.V = am.a(this.aE.h.f);
    }

    public void P() {
        this.aE.h.a();
    }

    public void Q() {
        ad.c r0 = this.aE.h;
        r0.g = this.aE.h.b();
        this.X = am.a(this.aE.h.g);
    }

    public void R() {
        this.aE.h.a();
    }

    public void S() {
        ad.c r0 = this.aE.h;
        r0.h = this.aE.h.b();
        this.Y = am.a(this.aE.h.h);
    }

    public void T() {
        this.aE.h.a();
        this.L = SystemClock.uptimeMillis();
    }

    public void U() {
        ad.c r0 = this.aE.h;
        r0.i = this.aE.h.b();
        this.M = SystemClock.uptimeMillis();
    }

    public void V() {
        this.aE.h.a();
    }

    public void W() {
        ad.c r0 = this.aE.h;
        r0.j = this.aE.h.b();
        this.Z = am.a(this.aE.h.j);
    }

    public void c(com.bytedance.retrofit2.d.b r12) {
        com.bytedance.retrofit2.d.b r13 = (com.bytedance.retrofit2.d.b) ZeusTransformUtils.wrapperContextForParams(r12, com.bytedance.retrofit2.d.b.class, "com.obric.aiagent.plugin");
        String r0 = r13.getClass().getName();
        if (TextUtils.isEmpty(r0) == true) goto L18;
        long r1 = System.nanoTime();
        r.a r3 = this.aE.i.a();
        if (r3 != null) goto L7;
        this.aE.f.n = r1;
        this.G = am.a(r1);
        this.p = p(r1);
    L16:
        this.aE.i.a(new r.a(r0.substring(r0.lastIndexOf(46) + 1), ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.f.b.class), r1));
        return;
    L7:
        if (r3.f9585d != (-1)) goto L10;
        r3.f9585d = r1;
    L10:
        if (r3.f9583b == true) goto L16;
        if (this.aE.g.k != (-1)) goto L14;
        this.aE.g.k = 0;
    L14:
        this.aE.g.k += r3.f9585d - r3.f9584c;
        goto L16
    }

    public void X() {
        long r0 = System.nanoTime();
        this.aE.f.o = r0;
        r.a r3 = this.aE.i.a();
        if (r3 == null) goto L6;
        r3.f9585d = r0;
        return;
    }

    public void Y() {
        long r0 = System.nanoTime();
        this.aE.f.r = r0;
        r.a r3 = this.aE.i.a();
        if (r3 == null) goto L6;
        r3.f9586e = r0;
        return;
    }

    public void a(Throwable r11) {
        long r0 = System.nanoTime();
        r.a r2 = this.aE.i.b();
        if (r2 != null) goto L5;
    L24:
        r.a r3 = this.aE.i.a();
        if (r3 != null) goto L27;
        this.aE.f.s = r0;
        return;
    L27:
        if (r11 != null) goto L31;
        r3.f9586e = r0;
        return;
    L31:
        return;
    L5:
        if (r2.f9585d != (-1)) goto L10;
        r2.f9585d = r0;
        if (r11 == null) goto L15;
        r2.g = r11.getClass().getSimpleName();
    L15:
        if (r2.f9583b == true) goto L24;
        if (r2.f9586e == (-1)) goto L24;
        if (r2.f == (-1)) goto L24;
        if (this.aE.g.l != (-1)) goto L23;
        this.aE.g.l = 0;
    L23:
        this.aE.g.l += r2.f - r2.f9586e;
        goto L24
    L10:
        if (r2.f9586e == (-1)) goto L15;
        r2.f = r0;
        if (r11 == null) goto L15;
        r2.g = r11.getClass().getSimpleName();
        goto L15
    }

    public void b(Throwable r2) {
        this.aE.j.f9426c = r2;
        this.N = r2;
    }

    public void a(int r2) {
        this.aE.j.f9427d = r2;
        this.aB = r2;
    }

    public void a(long r3) {
        this.aE.j.g = r3;
        WeakReference<u> r2 = this.f9434d;
        if (r2 == null) goto L6;
        ((u) ZeusTransformUtils.preCheckCast(r2.get(), u.class, "com.obric.aiagent.plugin")).j(r3);
        return;
    }

    public void Z() {
        this.aE.j.f9425b++;
        this.q = SystemClock.uptimeMillis();
    }

    public void a(JSONObject r1) {
        this.aF.i.h = r1;
    }

    public void aa() {
        v.b r2 = this.aF.f9601e;
        r2.f9607a = System.nanoTime();
    }

    public void ab() {
        v.b r2 = this.aF.f9601e;
        r2.f9608b = System.nanoTime();
    }

    public void ac() {
        this.aF.f.a();
    }

    public void ad() {
        v.a r0 = this.aF.f;
        r0.f9602a = this.aF.f.b();
        this.ad = am.a(this.aF.f.f9602a);
    }

    public void ae() {
        this.aF.f.a();
    }

    public void af() {
        this.aF.f.f9603b = this.aF.f.b();
        if (this.at != (-1)) goto L5;
        this.at = 0;
    L5:
        this.at += am.a(this.aF.f.f9603b);
    }

    public void ag() {
        this.aF.f.a();
    }

    public void ah() {
        this.aF.f.f9604c = this.aF.f.b();
        if (this.at != (-1)) goto L5;
        this.at = 0;
    L5:
        this.at += am.a(this.aF.f.f9604c);
    }

    public void ai() {
        this.aF.f.a();
    }

    public void aj() {
        v.a r0 = this.aF.f;
        r0.f9605d = this.aF.f.b();
        WeakReference<u> r1 = this.f9434d;
        if (r1 == null) goto L6;
        ((u) ZeusTransformUtils.preCheckCast(r1.get(), u.class, "com.obric.aiagent.plugin")).k(am.a(this.aF.f.f9605d));
        return;
    }

    public void ak() {
        this.aF.f.a();
    }

    public void al() {
        v.a r0 = this.aF.f;
        r0.f9606e = this.aF.f.b();
        WeakReference<u> r1 = this.f9434d;
        if (r1 == null) goto L6;
        ((u) ZeusTransformUtils.preCheckCast(r1.get(), u.class, "com.obric.aiagent.plugin")).l(am.a(this.aF.f.f9606e));
        return;
    }

    public void am() {
        this.aF.f.a();
    }

    public void an() {
        if (this.aF.f.f != (-1)) goto L5;
        this.aF.f.f = 0;
    L5:
        this.aF.f.f += this.aF.f.b();
    }

    public void ao() {
        this.aF.f.a();
    }

    public void ap() {
        v.a r0 = this.aF.f;
        r0.j = this.aF.f.b();
    }

    public void aq() {
        this.aF.f.a();
    }

    public void ar() {
        v.a r0 = this.aF.f;
        r0.g = this.aF.f.b();
    }

    public void as() {
        this.aH = true;
        if (this.aF.i.f9626e != (-1)) goto L5;
        this.aF.i.f9626e = 0;
    L5:
        this.aF.i.f9626e++;
        if (this.aF.f9601e.g != (-1)) goto L9;
        this.aF.f9601e.g = System.nanoTime();
    L9:
        if (this.aF.i.f == false) goto L12;
        return;
    L12:
        if (this.aF.f.h != (-1)) goto L19;
        if (this.aE.f.t == (-1)) goto L19;
        if (this.aF.f9601e.g <= this.aE.f.t) goto L19;
        this.aF.f.h = this.aF.f9601e.g - this.aE.f.t;
    L19:
        if (this.aF.f9601e.h != (-1)) goto L21;
    L24:
        this.aF.g.a();
        return;
    L21:
        if (this.aF.f.i != (-1)) goto L23;
        this.aF.f.i = 0;
    L23:
        this.aF.f.i += System.nanoTime() - this.aF.f9601e.h;
        goto L24
    }

    public void at() {
        this.aH = false;
        this.aF.f9601e.h = System.nanoTime();
        if (this.aF.i.f == false) goto L6;
        return;
    L6:
        if (this.aF.g.i != (-1)) goto L8;
        this.aF.g.i = 0;
    L8:
        this.aF.g.i += this.aF.g.b();
        if (aM() == false) goto L12;
        aN();
        return;
    }

    public void au() {
        this.aF.g.a();
    }

    public void av() {
        v.c r0 = this.aF.g;
        r0.f9612a = this.aF.g.b();
        this.ac = am.a(this.aF.g.f9612a);
    }

    public long aw() {
        return System.nanoTime();
    }

    public void b(long r4) {
        v.c r0 = this.aF.g;
        r0.f9613b = System.nanoTime() - r4;
        this.au = am.a(this.aF.g.f9613b);
    }

    public long ax() {
        return System.nanoTime();
    }

    public void c(long r4) {
        v.c r0 = this.aF.g;
        r0.f9614c = System.nanoTime() - r4;
        this.av = am.a(this.aF.g.f9614c);
    }

    public long ay() {
        long r0 = System.nanoTime();
        this.aF.f9601e.f9609c = r0;
        return r0;
    }

    public void d(long r4) {
        long r0 = System.nanoTime();
        this.aF.f9601e.f9610d = r0;
        long r1 = r0 - r4;
        this.aF.g.f9616e = r1;
    }

    public void az() {
        v.b r0 = this.aF.f9601e;
        r0.f9611e = System.nanoTime();
        this.aF.g.a();
    }

    public void aA() {
        v.b r0 = this.aF.f9601e;
        r0.f = System.nanoTime();
        v.c r1 = this.aF.g;
        r1.g = this.aF.g.b();
    }

    public void aB() {
        this.aF.g.a();
    }

    public void aC() {
        v.c r0 = this.aF.g;
        r0.h = this.aF.g.b();
    }

    @Deprecated
    public void e(long r3) {
        v.c r2 = this.aF.g;
        r2.f = System.nanoTime() - r3;
    }

    public void f(long r3) {
        this.aF.h.f9617a = r3;
        WeakReference<u> r2 = this.f9434d;
        if (r2 == null) goto L6;
        ((u) ZeusTransformUtils.preCheckCast(r2.get(), u.class, "com.obric.aiagent.plugin")).b(r3);
        return;
    }

    public void g(long r3) {
        this.aF.h.f9618b = r3;
        WeakReference<u> r2 = this.f9434d;
        if (r2 == null) goto L6;
        ((u) ZeusTransformUtils.preCheckCast(r2.get(), u.class, "com.obric.aiagent.plugin")).c(r3);
        return;
    }

    public void h(long r3) {
        this.aF.h.f9619c = r3;
        WeakReference<u> r2 = this.f9434d;
        if (r2 == null) goto L6;
        ((u) ZeusTransformUtils.preCheckCast(r2.get(), u.class, "com.obric.aiagent.plugin")).d(r3);
        return;
    }

    public void i(long r3) {
        this.aF.h.f9620d = r3;
        WeakReference<u> r2 = this.f9434d;
        if (r2 == null) goto L6;
        ((u) ZeusTransformUtils.preCheckCast(r2.get(), u.class, "com.obric.aiagent.plugin")).e(r3);
        return;
    }

    public void j(long r3) {
        this.aF.h.f9621e = r3;
        WeakReference<u> r2 = this.f9434d;
        if (r2 == null) goto L6;
        ((u) ZeusTransformUtils.preCheckCast(r2.get(), u.class, "com.obric.aiagent.plugin")).f(r3);
        return;
    }

    public void k(long r3) {
        this.aF.h.f = r3;
        WeakReference<u> r2 = this.f9434d;
        if (r2 == null) goto L6;
        ((u) ZeusTransformUtils.preCheckCast(r2.get(), u.class, "com.obric.aiagent.plugin")).g(r3);
        return;
    }

    public void l(long r3) {
        this.aF.h.g = r3;
        WeakReference<u> r2 = this.f9434d;
        if (r2 == null) goto L6;
        ((u) ZeusTransformUtils.preCheckCast(r2.get(), u.class, "com.obric.aiagent.plugin")).h(r3);
        return;
    }

    public void m(long r3) {
        this.aF.h.h = r3;
        WeakReference<u> r2 = this.f9434d;
        if (r2 == null) goto L6;
        ((u) ZeusTransformUtils.preCheckCast(r2.get(), u.class, "com.obric.aiagent.plugin")).i(r3);
        return;
    }

    public void n(long r2) {
        this.aF.h.i = r2;
        this.aw = r2;
    }

    public void o(long r2) {
        this.aF.h.j = r2;
        this.ax = r2;
    }

    public void a(long r2, long r4, long r6, long r8, long r10) {
        this.aF.f9601e.g = r4;
        this.aF.f9601e.h = r6;
        this.aF.i.f9626e = r2;
        if (this.aF.i.f == false) goto L5;
        return;
    L5:
        if (this.aF.f.h == (-1)) goto L7;
    L11:
        this.aF.f.i = r10;
        this.aF.g.i = r8;
        return;
    L7:
        if (this.aE.f.t == (-1)) goto L11;
        if (this.aF.f9601e.g <= this.aE.f.t) goto L11;
        v.a r3 = this.aF.f;
        r3.h = this.aF.f9601e.g - this.aE.f.t;
        goto L11
    }

    public void aD() {
        this.aF.i.f = true;
    }

    public void b(int r2) {
        this.aF.i.f9623b = r2;
        this.ay = r2;
    }

    public void a(String r1) {
        this.aF.i.f9624c = r1;
    }

    public void b(JSONObject r2) {
        this.aF.i.f9625d = r2;
        this.aA = r2;
    }

    public void b(String r3) {
        this.aF.j = r3;
        WeakReference<u> r2 = this.f9434d;
        if (r2 == null) goto L6;
        ((u) ZeusTransformUtils.preCheckCast(r2.get(), u.class, "com.obric.aiagent.plugin")).a(r3);
        return;
    }

    public void a(Object r1) {
        this.aF.i.g = r1;
    }

    public long p(long r8) {
        return am.a(this.aE.f.f9418e, this.aE.f.f, r8);
    }

    public void aE() {
        this.aK = true;
        aN();
    }

    public void aF() {
        this.aL = true;
        aN();
    }

    public static void a(b r2) {
        aM = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
    }

    public static void c(boolean r0) {
        aN = r0;
    }

    public static void d(boolean r0) {
        aO = r0;
    }

    public static void a(com.bytedance.retrofit2.c r2) {
        aP = (com.bytedance.retrofit2.c) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.retrofit2.c.class, "com.obric.aiagent.plugin");
    }

    public static void c(int r0) {
        ad.a(r0);
        v.a(r0);
    }

    private void aN() {
        if (this.aL == true) goto L5;
        return;
    L5:
        if (this.aK == false) goto L48;
        j();
        if (this.aH == false) goto L10;
        return;
    L10:
        a(com.bytedance.retrofit2.a.c());
        if (aM == null) goto L44;
        WeakReference<u> r0 = this.f9434d;
        if (r0 != null) goto L15;
        return;
    L15:
        if (r0.get() == null) goto L49;
        final u r1 = this.f9434d.get();
        if (this.aE.j.f9428e == null) goto L20;
        final Throwable r2 = (Throwable) ZeusTransformUtils.preCheckCast(this.aE.j.f9428e.get(), Throwable.class, "com.obric.aiagent.plugin");
    L22:
        if (aO == false) goto L25;
        a(r1, r2);
        return;
    L25:
        if (aP == null) goto L28;
        aP.a(new AnonymousClass1(this, r1, r2), 100);
        return;
    L28:
        if (aJ == null) goto L30;
    L39:
        aJ.postDelayed(new AnonymousClass2(this, r1, r2), 100);
        return;
    L30:
        monitor-enter(af.class);
    L36:
        th = move-exception;
        throw th;
    L32:
        if (aJ != null) goto L34;
        HandlerThread r5 = new HandlerThread("TTNet-Log-Report");     // Catch: Throwable -> L36
        aI = r5;     // Catch: Throwable -> L36
        r5.start();     // Catch: Throwable -> L36
        aJ = new Handler(aI.getLooper());     // Catch: Throwable -> L36
    L34:
        monitor-exit(af.class);     // Catch: Throwable -> L36
        goto L39
    L20:
        r2 = null;
        goto L22
    L49:
        return;
    L44:
        return;
    }

    private void a(Object r3, Throwable r4) {
        URL r0 = this.f9432b;
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r4 != null) goto L9;
        aM.a(r1, r3);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.retrofit2.f.c.class) == false) goto L17;
        com.bytedance.retrofit2.f.c r2 = (com.bytedance.retrofit2.f.c) ZeusTransformUtils.preCheckCast(r4, com.bytedance.retrofit2.f.c.class, "com.obric.aiagent.plugin");
        if (r2.f9545a == false) goto L14;
        aM.a(r1, r3);
    L14:
        if (r2.f9546b == false) goto L24;
        aM.a(r1, r3, r4);
        return;
    L24:
        return;
    L17:
        if (this.aE.j.f9424a == false) goto L20;
        b(r4);
        aM.a(r1, r3);
        return;
    L20:
        if (aM.b() == false) goto L27;
        aM.a(r1, r3, r4);
        return;
    L27:
        return;
    L5:
        r1 = "";
        goto L6
    }

    public void c(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        WeakReference<u> r0 = this.f9434d;
        if (r0 == null) goto L8;
        ((u) ZeusTransformUtils.preCheckCast(r0.get(), u.class, "com.obric.aiagent.plugin")).a(r4);
    L8:
        if (aN == false) goto L11;
        d(r4);
        return;
    }

    private void d(JSONObject r4) {
        JSONObject r0 = new JSONObject();
        r0.put("retrofit", this.aE.b());
        r0.put("networklib", this.aF.a());
        r4.put("ttnet", r0);
    }

    public af aG() {
        af r0 = new af();
        a(r0);
        return r0;
    }

    public void a(af r8) {
        if (r8 != null) goto L79;
        return;
    L79:
        if (this.f9432b == null) goto L7;
        r8.f9432b = new URL(this.f9432b.toString());     // Catch: Exception -> L68
    L7:
        r8.f9433c = this.f9433c;
        r8.f9435e = this.f9435e;
        r8.f = this.f;
        r8.aG = this.aG;
        r8.g = this.g;
        r8.h = this.h;
        r8.i = this.i;
        r8.j = this.j;
        JSONObject r0 = null;
        if (this.k == null) goto L11;
        JSONObject r1 = new JSONObject(this.k.toString());     // Catch: JSONException -> L69
    L12:
        r8.k = r1;     // Catch: JSONException -> L69
        goto L13
    L11:
        r1 = null;
    L13:
        r8.l = this.l;
        r8.m = this.m;
        r8.n = this.n;
        r8.o = this.o;
        r8.p = this.p;
        r8.q = this.q;
        r8.r = this.r;
        r8.s = this.s;
        r8.t = this.t;
        r8.u = this.u;
        r8.v = this.v;
        r8.w = this.w;
        r8.x = this.x;
        r8.y = this.y;
        r8.z = this.z;
        r8.A = this.A;
        r8.B = this.B;
        r8.C = this.C;
        r8.D = this.D;
        r8.E = this.E;
        r8.F = this.F;
        r8.G = this.G;
        r8.H = this.H;
        r8.I = this.I;
        r8.f9431J = this.f9431J;
        r8.K = this.K;
        r8.L = this.L;
        r8.M = this.M;
        if (this.N == null) goto L17;
        Throwable r2 = new Throwable(this.N.getMessage());
        r2.setStackTrace(this.N.getStackTrace());
        r8.N = r2;
    L17:
        if (this.O == null) goto L23;
        r8.O = new ConcurrentHashMap();
        Iterator<Map.Entry<String, Long>> r3 = this.O.entrySet().iterator();
    L20:
        if (r3.hasNext() == false) goto L23;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r8.O.put((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin"), (Long) ZeusTransformUtils.preCheckCast(r4.getValue(), Long.class, "com.obric.aiagent.plugin"));
    L23:
        if (this.P == null) goto L28;
        r8.P = new ConcurrentHashMap();
        Iterator<Map.Entry<String, Long>> r5 = this.P.entrySet().iterator();
    L26:
        if (r5.hasNext() == false) goto L28;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r8.P.put((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.aiagent.plugin"), (Long) ZeusTransformUtils.preCheckCast(r6.getValue(), Long.class, "com.obric.aiagent.plugin"));
    L28:
        r8.Q = this.Q;
        r8.R = this.R;
        r8.S = this.S;
        r8.T = this.T;
        r8.U = this.U;
        r8.V = this.V;
        r8.W = this.W;
        r8.X = this.X;
        r8.Y = this.Y;
        r8.Z = this.Z;
        r8.aa = this.aa;
        r8.ab = this.ab;
        r8.ac = this.ac;
        r8.ad = this.ad;
        if (this.ae == null) goto L34;
        r8.ae = new ConcurrentHashMap();
        Iterator<Map.Entry<String, Long>> r7 = this.ae.entrySet().iterator();
    L32:
        if (r7.hasNext() == false) goto L34;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r8.ae.put((String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.aiagent.plugin"), (Long) ZeusTransformUtils.preCheckCast(r9.getValue(), Long.class, "com.obric.aiagent.plugin"));
    L34:
        r8.af = this.af;
        if (this.ag == null) goto L38;
        r8.ag = new JSONArray(this.ag.toString());     // Catch: JSONException -> L70
    L38:
        r8.ah = this.ah;
        r8.ai = this.ai;
        r8.aj = this.aj;
        r8.ak = this.ak;
        r8.al = this.al;
        r8.am = this.am;
        r8.an = this.an;
        r8.ao = this.ao;
        r8.ap = this.ap;
        if (this.aq == null) goto L42;
        JSONObject r10 = new JSONObject(this.aq.toString());     // Catch: JSONException -> L71
    L43:
        r8.aq = r10;     // Catch: JSONException -> L71
        goto L44
    L42:
        r10 = null;
    L44:
        r8.ar = this.ar;
        r8.as = this.as;
        r8.at = this.at;
        r8.au = this.au;
        r8.av = this.av;
        r8.aw = this.aw;
        r8.ax = this.ax;
        r8.ay = this.ay;
        if (this.az == null) goto L73;
        r8.az = new HashMap();
        Iterator<Map.Entry<String, Object>> r11 = this.az.entrySet().iterator();
    L48:
        if (r11.hasNext() == false) goto L73;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r8.az.put((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.aiagent.plugin"), r12.getValue());
    L73:
        if (this.aA == null) goto L53;
        r0 = new JSONObject(this.aA.toString());     // Catch: JSONException -> L72
    L53:
        r8.aA = r0;     // Catch: JSONException -> L72
    L54:
        r8.aB = this.aB;
        List<c> r13 = this.aC;
        if (r13 == null) goto L60;
        Iterator<c> r14 = r13.iterator();
    L58:
        if (r14.hasNext() == false) goto L60;
        c r15 = (c) ZeusTransformUtils.preCheckCast(r14.next(), c.class, "com.obric.aiagent.plugin");
        c r16 = new c(this, r15.f9447a, r15.f9448b);
        r16.f9449c = r15.f9449c;
        r16.f9450d = r15.f9450d;
        r8.aC.add(r16);
    L60:
        List<c> r17 = this.aD;
        if (r17 == null) goto L66;
        Iterator<c> r18 = r17.iterator();
    L64:
        if (r18.hasNext() == false) goto L66;
        c r19 = (c) ZeusTransformUtils.preCheckCast(r18.next(), c.class, "com.obric.aiagent.plugin");
        c r20 = new c(this, r19.f9447a, r19.f9448b);
        r20.f9449c = r19.f9449c;
        r20.f9450d = r19.f9450d;
        r8.aD.add(r20);
    L66:
        r8.aK = this.aK;
        r8.aL = this.aL;
        r8.f9434d = this.f9434d;
        r8.aE = this.aE.c();
        r8.aF = this.aF.b();
    }

    public void aH() {
        this.aF = new v();
    }

    public void d(int r3) {
        if (this.am != (-999)) goto L6;
        this.am = r3;
        return;
    }
}
