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
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.Ok3TncBridge;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionBridge;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.h;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.keva.KevaImpl;
import com.bytedance.retrofit2.Call;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.capabilitykit.common.Ext;
import f6.f;
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
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;
import p6.c;

/* JADX INFO: loaded from: classes.dex */
public class TNCManager implements Ok3TncBridge {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static TNCManager f8155y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static String f8156z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f8158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f8159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TNCUpdateSource f8160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f8161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f8162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f8163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f8164h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f8165i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f8166j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8167k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f8168l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.ttnet.tnc.a f8169m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile int f8170n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile long f8171o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile long f8172p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f8173q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public HashMap f8174r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public HashMap f8175s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f8176t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public HashMap f8177u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public HashMap f8178v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f8179w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Handler f8180x;

    public static final enum TNCUpdateSource extends Enum<TNCUpdateSource> {
        private static final /* synthetic */ TNCUpdateSource[] $VALUES = null;
        public static final TNCUpdateSource PORTRETRY = null;
        public static final TNCUpdateSource TTCACHE = null;
        public static final TNCUpdateSource TTCRONET = null;
        public static final TNCUpdateSource TTERROR = null;
        public static final TNCUpdateSource TTHardCode = null;
        public static final TNCUpdateSource TTPOLL = null;
        public static final TNCUpdateSource TTREGION = null;
        public static final TNCUpdateSource TTRESUME = null;
        public static final TNCUpdateSource TTSERVER = null;
        public static final TNCUpdateSource TTTNC = null;
        public final int mValue;

        static {
            TNCUpdateSource r10 = new TNCUpdateSource("TTRESUME", 0, -2);
            TTRESUME = r10;
            TNCUpdateSource r11 = new TNCUpdateSource("TTHardCode", 1, -1);
            TTHardCode = r11;
            TNCUpdateSource r12 = new TNCUpdateSource("TTCACHE", 2, 0);
            TTCACHE = r12;
            TNCUpdateSource r13 = new TNCUpdateSource("TTSERVER", 3, 1);
            TTSERVER = r13;
            TNCUpdateSource r14 = new TNCUpdateSource("TTERROR", 4, 2);
            TTERROR = r14;
            TNCUpdateSource r15 = new TNCUpdateSource("TTPOLL", 5, 3);
            TTPOLL = r15;
            TNCUpdateSource r16 = new TNCUpdateSource("TTTNC", 6, 4);
            TTTNC = r16;
            TNCUpdateSource r17 = new TNCUpdateSource("PORTRETRY", 7, 7);
            PORTRETRY = r17;
            TNCUpdateSource r18 = new TNCUpdateSource("TTREGION", 8, 10);
            TTREGION = r18;
            TNCUpdateSource r19 = new TNCUpdateSource("TTCRONET", 9, 20);
            TTCRONET = r19;
            $VALUES = new TNCUpdateSource[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
        }

        private TNCUpdateSource(String r10, int r11, int r12) {
            super(r10, r11);
            this.mValue = r12;
        }

        public static TNCUpdateSource valueOf(String r10) {
            return (TNCUpdateSource) Enum.valueOf(TNCUpdateSource.class, r10);
        }

        public static TNCUpdateSource[] values() {
            return (TNCUpdateSource[]) $VALUES.clone();
        }
    }

    public static class a implements StoreRegionBridge {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ICronetAppProvider f8181a;

        public a(ICronetAppProvider r10) {
            this.f8181a = r10;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionBridge
        public void onStoreIdcChanged(String r10, String r11, String r12) {
            m6.b.a().c(r10, r11, r12);
        }

        @Override // com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionBridge
        public void sendFeedbackLog(String r10, String r11) {
            this.f8181a.sendAppMonitorEvent(r10, r11);
        }

        @Override // com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionBridge
        public void updateTncConfig(JSONObject r10, String r11, String r12, boolean r13) {
            TNCManager.h().k(r10, r11, r12, r13);
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TNCManager f8182a;

        public b(TNCManager r10, Looper r11) {
            this.f8182a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            if (r10.what == 10000) goto L6;
            return;
        L6:
            if (r10.arg1 != 0) goto L8;
            boolean r11 = false;
        L9:
            TNCManager r12 = this.f8182a;
            TNCManager.b(r12, r11, TNCManager.a(r12, r10.arg2));
            return;
        L8:
            r11 = true;
            goto L9
        }
    }

    public TNCManager() {
        this.f8157a = 0;
        this.f8158b = 0;
        this.f8159c = 0;
        this.f8160d = TNCUpdateSource.TTCACHE;
        this.f8161e = 0;
        this.f8162f = false;
        this.f8163g = false;
        this.f8167k = false;
        this.f8170n = 0;
        this.f8171o = 0;
        this.f8172p = 0;
        this.f8173q = 0;
        this.f8174r = new HashMap();
        this.f8175s = new HashMap();
        this.f8176t = 0;
        this.f8177u = new HashMap();
        this.f8178v = new HashMap();
        this.f8179w = true;
        this.f8180x = new b(this, Looper.getMainLooper());
    }

    public static /* synthetic */ TNCUpdateSource a(TNCManager r10, int r11) {
        return r10.u(r11);
    }

    public static /* synthetic */ void b(TNCManager r10, boolean r11, TNCUpdateSource r12) {
        r10.d(r11, r12);
    }

    public static void c(h r10) {
        TTNetInit.getTTNetDepend();
    }

    public static String g() {
        return f8156z;
    }

    public static synchronized TNCManager h() {
        monitor-enter(TNCManager.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f8155y != null) goto L9;
        f8155y = new TNCManager();     // Catch: Throwable -> L7
    L9:
        TNCManager r10 = f8155y;     // Catch: Throwable -> L7
        monitor-exit(TNCManager.class);
        return r10;
    }

    public static void n(ICronetAppProvider r10) {
        String r11 = r10.getCarrierRegion();
        String r12 = r10.getSysRegion();
        String r13 = r10.getRegion();
        if (TextUtils.isEmpty(r11) == true) goto L6;
    L9:
        StoreRegionManager.m().l(r11, r10.getStoreIdcRuleJSON(), TTNetInit.getTTNetDepend().getContext(), new a(r10));
        if (TextUtils.isEmpty(r11) == true) goto L13;
        f8156z = TTNetInit.getGetDomainConfigByRegion(r11);
    L13:
        if (TextUtils.isEmpty(f8156z) == false) goto L15;
        f8156z = r10.getGetDomainDefaultJSON();
    L15:
        Logger.d("TNCManager", "region: " + r11 + " json: " + f8156z);
        return;
    L6:
        if (TextUtils.isEmpty(r12) == true) goto L8;
        r11 = r12;
        goto L9
    L8:
        r11 = r13;
        goto L9
    }

    public final void d(boolean r10, TNCUpdateSource r11) {
        s6.a r12 = i();
        if (r12 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("TNCManager", "doUpdateRemote, " + r10);
    L8:
        long r13 = SystemClock.elapsedRealtime();
        if (r10 == false) goto L11;
    L16:
        this.f8157a = r13;
        if (r11 != TNCUpdateSource.TTTNC) goto L19;
        this.f8158b = System.currentTimeMillis();
    L19:
        l6.a.f(this.f8168l).c(r11, false);
        return;
    L11:
        if ((this.f8157a + (((long) r12.f24517j) * 1000)) <= r13) goto L16;
        if (Logger.debug() == false) goto L21;
        Logger.d("TNCManager", "doUpdateRemote, time limit");
        return;
    }

    public boolean e(Context r24, boolean r25, TNCUpdateSource r26, String r27) {
        Logger.d("TNCManager", "getdomain internal, use retrofit okhttp: " + r25 + ", tnc source: " + r26);
        ArrayList r10 = new ArrayList();
        if (l6.a.f(r24).g() != null) goto L5;
    L12:
        r10.addAll(Arrays.asList(l6.a.f(r24).d()));
    L13:
        this.f8160d = r26;
        this.f8166j = System.currentTimeMillis();
        Iterator r13 = r10.iterator();
    L15:
        if (r13.hasNext() == false) goto L67;
        h r11 = new h("https://" + ((String) r13.next()) + "/get_domains/v5/");
        r11.b("abi", Build.SUPPORTED_ABIS[0]);     // Catch: Throwable -> L19
        r11.a("tnc_src", r26.mValue);     // Catch: Throwable -> L19
        r11.b("okhttp_version", "4.1.79.42-pico");     // Catch: Throwable -> L19
        r11.b("ttnet_version", "4.1.79.42-pico");     // Catch: Throwable -> L19
        c(r11);     // Catch: Throwable -> L19
    L21:
        HashMap r12 = new HashMap();
        StoreRegionManager.m().c(r12);
        if (TextUtils.isEmpty(r27) == true) goto L26;
        r12.put("x-tt-tnc-summary", r27);
    L26:
        if (r25 == false) goto L27;
        r11.a("aid", TTNetInit.getTTNetDepend().getAppId());
        r11.b("device_platform", "android");
        if (TTNetInit.getCronetProvider() == null) goto L37;
        r11.b("version_code", TTNetInit.getCronetProvider().getVersionCode());
        r11.b("channel", TTNetInit.getCronetProvider().getChannel());
    L37:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r12.entrySet().iterator();
    L39:
        if (r15.hasNext() == false) goto L45;
        Map.Entry r16 = (Map.Entry) r15.next();
        if (TextUtils.isEmpty((CharSequence) r16.getKey()) == true) goto L39;
        if (TextUtils.isEmpty((CharSequence) r16.getValue()) == true) goto L39;
        r14.add(new g6.a((String) r16.getKey(), (String) r16.getValue()));
        goto L39
    L45:
        String r17 = r11.toString();
        LinkedHashMap r18 = new LinkedHashMap();
        Pair r19 = i.j(r17, r18);     // Catch: IOException -> L65
        String r20 = (String) r19.first;     // Catch: IOException -> L65
        String r110 = (String) r19.second;     // Catch: IOException -> L65
        INetworkApi r111 = (INetworkApi) RetrofitUtils.f(r20, INetworkApi.class);
        if (r111 == null) goto L15;
        Call<String> r112 = r111.doGet(true, -1, r110, r18, r14, null);
        f r21 = r112.execute();     // Catch: Throwable -> L56
        List r22 = r21.d();     // Catch: Throwable -> L56
        String r23 = (String) r21.a();     // Catch: Throwable -> L56
        String r28 = RetrofitUtils.g(r22, "x-ss-etag");     // Catch: Throwable -> L56
        String r29 = RetrofitUtils.g(r22, "x-tt-tnc-abtest");     // Catch: Throwable -> L56
        String r30 = RetrofitUtils.g(r22, "x-tt-tnc-control");     // Catch: Throwable -> L56
        this.f8164h = RetrofitUtils.g(r22, "x-tt-tnc-config");     // Catch: Throwable -> L56
        this.f8165i = RetrofitUtils.g(r22, "x-ss-canary");     // Catch: Throwable -> L56
        if (h().m(r24, r26, r23, r30, r28, r29) == true) goto L54;
    L53:
        r112.cancel();
        goto L15
    L54:
        r112.cancel();
        return true;
    L56:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L60
        if (r112 == null) goto L15;
    L60:
        th = move-exception;
        if (r112 == null) goto L105;
        r112.cancel();
        throw th;
    L105:
        throw th;
    L65:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L27:
        p6.a r31 = new p6.a();
        r31.f23334b = r11.toString();
        r31.f23338f = true;
        long r32 = System.currentTimeMillis();
        String r33 = c.a(r31.f23334b, r12, null, r31);     // Catch: Throwable -> L32
        r31.f23335c = System.currentTimeMillis() - r32;     // Catch: Throwable -> L32
        this.f8165i = r31.f23344l;     // Catch: Throwable -> L32
        this.f8164h = r31.f23343k;     // Catch: Throwable -> L32
        if (h().m(r24, r26, r33, r31.f23342j, r31.f23340h, r31.f23341i) == false) goto L15;
        return true;
    L32:
        th = move-exception;
        th.printStackTrace();
    L19:
        th = move-exception;
        th.printStackTrace();
        goto L21
    L67:
        return false;
    L5:
        if (l6.a.f(r24).g().size() == 0) goto L12;
        r10.addAll(l6.a.f(r24).g());
        String[] r34 = l6.a.f(r24).d();
        int r35 = r34.length;
        int r36 = 0;
    L7:
        if (r36 >= r35) goto L13;
        String r37 = r34[r36];
        if (r10.contains(r37) == true) goto L11;
        r10.add(r37);
    L11:
        r36 = r36 + 1;
        goto L7
    }

    public final String f(Exception r10) {
        StringWriter r11 = new StringWriter();
        r10.printStackTrace(new PrintWriter(r11));
        return r11.toString().toLowerCase();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.Ok3TncBridge
    public JSONObject getTNCInfo() {
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L6
        r11.put(ServerElements.UPDATE_TIME, this.f8161e);     // Catch: JSONException -> L6
        r11.put("source", this.f8160d.mValue);     // Catch: JSONException -> L6
        r11.put("cold_start", this.f8162f ? 1 : 0);     // Catch: JSONException -> L6
        r11.put("config_updated", this.f8163g ? 1 : 0);     // Catch: JSONException -> L6
        if (TextUtils.isEmpty(this.f8164h) == true) goto L9;
        r11.put("config", this.f8164h);     // Catch: JSONException -> L6
    L9:
        if (TextUtils.isEmpty(this.f8165i) == true) goto L11;
        r11.put("canary", this.f8165i);     // Catch: JSONException -> L6
    L11:
        r11.put("local_probe_version", this.f8172p);     // Catch: JSONException -> L6
        String r12 = l6.a.f(this.f8168l).h();     // Catch: JSONException -> L6
        if (TextUtils.isEmpty(r12) == true) goto L14;
        r11.put("rules", r12);     // Catch: JSONException -> L6
    L14:
        com.bytedance.ttnet.tnc.a r13 = this.f8169m;     // Catch: JSONException -> L6
        if (r13 != null) goto L17;
    L21:
        r10.put("data", r11);     // Catch: JSONException -> L6
        JSONObject r14 = new JSONObject();     // Catch: JSONException -> L6
        r14.put("version", this.f8171o);     // Catch: JSONException -> L6
        r14.put("cmd", this.f8170n);     // Catch: JSONException -> L6
        r14.put(ICronetClient.KEY_SEND_TIME, this.f8158b);     // Catch: JSONException -> L6
        r14.put("get_time", this.f8159c);     // Catch: JSONException -> L6
        r10.put("probe", r14);     // Catch: JSONException -> L6
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L6
        r15.put("probe_version", this.f8172p);     // Catch: JSONException -> L6
        r15.put("source", this.f8160d.mValue);     // Catch: JSONException -> L6
        r15.put("start_time", this.f8166j);     // Catch: JSONException -> L6
        r10.put(Ext.KEY_REQUEST, r15);     // Catch: JSONException -> L6
    L24:
        return r10;
    L17:
        if (TextUtils.isEmpty(r13.a()) == true) goto L21;
        if (TextUtils.isEmpty(this.f8169m.b()) == true) goto L21;
        r11.put(CommonKey.KEY_REGION, this.f8169m.a());     // Catch: JSONException -> L6
        r11.put("region_source", this.f8169m.b());     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public s6.a i() {
        com.bytedance.ttnet.tnc.a r10 = this.f8169m;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.c();
    }

    public com.bytedance.ttnet.tnc.a j() {
        return this.f8169m;
    }

    public void k(JSONObject r11, String r12, String r13, boolean r14) {
        Logger.d("TNCManager", "data: " + r11 + " etag: " + r12 + " tncAttr: " + r13 + " needUpdateTnc: " + r14);
        if (r11 == null) goto L7;
        com.bytedance.ttnet.tnc.a r10 = this.f8169m;
        if (r10 == null) goto L7;
        r10.i("");
        boolean r15 = this.f8169m.d(r11, TNCUpdateSource.TTSERVER, r12, r13, System.currentTimeMillis());
    L8:
        if (r14 == false) goto L12;
        if (r15 == true) goto L13;
        Logger.d("TNCManager", "doUpdateRemote tnc");
        d(true, TNCUpdateSource.TTREGION);
        return;
    L13:
        return;
    L12:
        return;
    L7:
        r15 = false;
        goto L8
    }

    public final void l(Response r13, String r14) {
        if (r13 != null) goto L5;
        return;
    L5:
        if (this.f8179w == true) goto L7;
        return;
    L7:
        String r15 = r13.g("tt-idc-switch", null);
        if (TextUtils.isEmpty(r15) == true) goto L10;
        String[] r16 = r15.split("@");
        if (r16 == null) goto L50;
        if (r16.length != 2) goto L50;
        long r10 = 0;
        int r11 = Integer.parseInt(r16[0]);     // Catch: Throwable -> L24
        long r12 = Long.parseLong(r16[1]);     // Catch: Throwable -> L22
    L31:
        if (Logger.debug() == false) goto L34;
        Logger.d("TNCManager", "handleTncProbe, local: " + this.f8170n + "@" + this.f8171o + " svr: " + r11 + "@" + r12 + " " + r14);
    L34:
        if (r12 > this.f8171o) goto L36;
        return;
    L36:
        this.f8170n = r11;
        this.f8171o = r12;
        this.f8159c = System.currentTimeMillis();
        this.f8168l.getSharedPreferences("ttnet_tnc_config", 0).edit().putInt("tnc_probe_cmd", r11).putLong("tnc_probe_version", r12).apply();
        if (this.f8170n != 10000) goto L58;
        s6.a r17 = i();
        if (r17 != null) goto L41;
        return;
    L41:
        Random r18 = new Random(System.currentTimeMillis());
        int r19 = r17.f24518k;
        if (r19 <= 0) goto L45;
        r10 = ((long) r18.nextInt(r19)) * 1000;
    L45:
        if (Logger.debug() == false) goto L47;
        Logger.d("TNCManager", "handleTncProbe, updateConfig delay: " + r10 + " " + r14);
    L47:
        t(true, r10, TNCUpdateSource.TTTNC);
        return;
    L58:
        return;
    L22:
        th = th;
    L26:
        th.printStackTrace();
        if (Logger.debug() == false) goto L29;
        Logger.d("TNCManager", "handleTncProbe, probeProto except, " + r14);
    L29:
        r12 = 0;
    L24:
        th = th;
        r11 = 0;
    L50:
        if (Logger.debug() == false) goto L59;
        Logger.d("TNCManager", "handleTncProbe, probeProto err, " + r14);
        return;
    L59:
        return;
    L10:
        if (Logger.debug() == false) goto L57;
        Logger.d("TNCManager", "handleTncProbe, no probeProto, " + r14);
        return;
    }

    public final boolean m(Context r10, TNCUpdateSource r11, String r12, String r13, String r14, String r15) {
        Logger.d("TNCManager", "okhttp tnc response success, etag is " + r14 + ", tnc control " + r13);     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r14) == true) goto L6;
        l6.a.f(r10).q(r14);     // Catch: Exception -> L23
    L6:
        h().f8169m.i(r15);     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r13) == true) goto L12;
        if (r13.equals("1") == false) goto L12;
        return true;
    L12:
        if (TextUtils.isEmpty(r12) == false) goto L14;
        return false;
    L14:
        JSONObject r16 = new JSONObject(r12);     // Catch: Exception -> L23
        ClientKeyManager.j().c(r12);     // Catch: Exception -> L23
        boolean r17 = l6.a.f(r10).j(r16, r11, System.currentTimeMillis());     // Catch: Exception -> L23
        if (r17 == false) goto L22;
        this.f8161e = System.currentTimeMillis();     // Catch: Exception -> L23
        if (this.f8162f == true) goto L19;
        this.f8162f = true;     // Catch: Exception -> L23
    L19:
        this.f8163g = true;     // Catch: Exception -> L23
        if (r11 != TNCUpdateSource.TTTNC) goto L22;
        this.f8172p = this.f8171o;     // Catch: Exception -> L23
    L22:
        return r17;
    L23:
        return false;
    }

    public synchronized void o(Context r10, boolean r11) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f8167k == true) goto L14;
        this.f8168l = r10;     // Catch: Throwable -> L8
        this.f8179w = r11;     // Catch: Throwable -> L8
        this.f8169m = new com.bytedance.ttnet.tnc.a(r10, r11);     // Catch: Throwable -> L8
        if (r11 == false) goto L11;
        r();     // Catch: Throwable -> L8
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d("TNCManager", "initTnc, isMainProc: " + r11 + " probeCmd: " + this.f8170n + " probeVersion: " + this.f8171o);     // Catch: Throwable -> L8
    L13:
        this.f8167k = true;     // Catch: Throwable -> L8
    L14:
        monitor-exit(this);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.Ok3TncBridge
    public synchronized void onOk3Response(Request r10, Response r11) {
        monitor-enter(this);
        if (r10 == null) goto L80;
        if (r11 == null) goto L80;
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.f8179w == true) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (NetworkUtils.l(this.f8168l) == true) goto L14;
        monitor-exit(this);
        return;
    L14:
        HttpUrl r12 = r10.k();     // Catch: Throwable -> L20
        String r13 = r12.G();     // Catch: Throwable -> L20
        String r14 = r12.m();     // Catch: Throwable -> L20
        String r15 = r12.h();     // Catch: Throwable -> L20
        int r16 = r11.d();     // Catch: Throwable -> L20
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(r13) == true) goto L23;
        if ("https".equals(r13) == true) goto L23;
        monitor-exit(this);
        return;
    L23:
        if (TextUtils.isEmpty(r14) == false) goto L27;
        monitor-exit(this);
        return;
    L27:
        if (r11.m() != null) goto L31;
        monitor-exit(this);
        return;
    L31:
        if (Logger.debug() == false) goto L33;
        Logger.d("TNCManager", "onOk3Response, url: " + r13 + "://" + r14 + "#" + r16);     // Catch: Throwable -> L20
    L33:
        s6.a r17 = i();     // Catch: Throwable -> L20
        if (r17 != null) goto L36;
    L38:
        if (r17 != null) goto L40;
    L76:
        monitor-exit(this);
        return;
    L40:
        if (r17.f24508a == false) goto L76;
        Map r18 = r17.f24510c;     // Catch: Throwable -> L20
        if (r18 != null) goto L45;
    L74:
        monitor-exit(this);
        return;
    L45:
        if (r18.size() <= 0) goto L74;
        if (r17.f24510c.containsKey(r14) == false) goto L74;
        if (Logger.debug() == false) goto L52;
        Logger.d("TNCManager", "onOk3Response, url matched: " + r13 + "://" + r14 + "#" + r16 + " " + this.f8173q + "#" + this.f8174r.size() + "#" + this.f8175s.size() + " " + this.f8176t + "#" + this.f8177u.size() + "#" + this.f8178v.size());     // Catch: Throwable -> L20
    L52:
        if (r16 > 0) goto L54;
    L72:
        monitor-exit(this);
        return;
    L54:
        if (q(r16) == false) goto L61;
        if (this.f8173q <= 0) goto L58;
    L59:
        s();     // Catch: Throwable -> L20
        goto L72
    L58:
        if (this.f8176t <= 0) goto L72;
    L61:
        if (p(r16) == true) goto L72;
        this.f8176t++;     // Catch: Throwable -> L20
        this.f8177u.put(r15, 0);     // Catch: Throwable -> L20
        this.f8178v.put(r14, 0);     // Catch: Throwable -> L20
        if (this.f8176t < r17.f24514g) goto L72;
        if (this.f8177u.size() < r17.f24515h) goto L72;
        if (this.f8178v.size() < r17.f24516i) goto L72;
        if (Logger.debug() == false) goto L71;
        Logger.d("TNCManager", "onOk3Response, url doUpdate: " + r13 + "://" + r14 + "#" + r16);     // Catch: Throwable -> L20
    L71:
        t(false, 0, TNCUpdateSource.TTERROR);     // Catch: Throwable -> L20
        s();     // Catch: Throwable -> L20
        goto L72
    L36:
        if (r17.f24509b == false) goto L38;
        l(r11, r14);     // Catch: Throwable -> L20
    L80:
        monitor-exit(this);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.Ok3TncBridge
    public synchronized void onOk3Timeout(Request r10, Exception r11) {
        monitor-enter(this);
        if (r10 == null) goto L70;
        if (r11 == null) goto L70;
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.f8179w == true) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (NetworkUtils.l(this.f8168l) == true) goto L14;
        monitor-exit(this);
        return;
    L14:
        HttpUrl r12 = r10.k();     // Catch: Throwable -> L20
        String r13 = r12.G();     // Catch: Throwable -> L20
        String r14 = r12.m();     // Catch: Throwable -> L20
        String r15 = r12.h();     // Catch: Throwable -> L20
        String r16 = f(r11);     // Catch: Throwable -> L20
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(r13) == true) goto L23;
        if ("https".equals(r13) == true) goto L23;
        monitor-exit(this);
        return;
    L23:
        if (TextUtils.isEmpty(r14) == false) goto L27;
        monitor-exit(this);
        return;
    L27:
        if (TextUtils.isEmpty(r16) == false) goto L29;
    L66:
        monitor-exit(this);
        return;
    L29:
        if (r16.contains("timeout") == false) goto L66;
        if (r16.contains("time out") == false) goto L66;
        if (r16.contains("unreachable") == true) goto L66;
        s6.a r17 = i();     // Catch: Throwable -> L20
        if (r17 != null) goto L38;
    L64:
        monitor-exit(this);
        return;
    L38:
        if (r17.f24508a == false) goto L64;
        Map r18 = r17.f24510c;     // Catch: Throwable -> L20
        if (r18 != null) goto L43;
    L62:
        monitor-exit(this);
        return;
    L43:
        if (r18.size() <= 0) goto L62;
        if (r17.f24510c.containsKey(r14) == false) goto L62;
        if (Logger.debug() == false) goto L50;
        Logger.d("TNCManager", "onOk3Timeout, url matched: " + r13 + "://" + r14 + "#" + r16 + " " + this.f8173q + "#" + this.f8174r.size() + "#" + this.f8175s.size() + " " + this.f8176t + "#" + this.f8177u.size() + "#" + this.f8178v.size());     // Catch: Throwable -> L20
    L50:
        this.f8173q++;     // Catch: Throwable -> L20
        this.f8174r.put(r15, 0);     // Catch: Throwable -> L20
        this.f8175s.put(r14, 0);     // Catch: Throwable -> L20
        if (this.f8173q >= r17.f24511d) goto L53;
    L60:
        monitor-exit(this);
        return;
    L53:
        if (this.f8174r.size() < r17.f24512e) goto L60;
        if (this.f8175s.size() < r17.f24513f) goto L60;
        if (Logger.debug() == false) goto L59;
        Logger.d("TNCManager", "onOk3Timeout, url doUpate: " + r13 + "://" + r14);     // Catch: Throwable -> L20
    L59:
        t(false, 0, TNCUpdateSource.TTERROR);     // Catch: Throwable -> L20
        s();     // Catch: Throwable -> L20
    L70:
        monitor-exit(this);
    }

    public final boolean p(int r10) {
        if (r10 >= 100) goto L5;
    L16:
        return true;
    L5:
        if (r10 >= 1000) goto L16;
        s6.a r11 = i();
        if (r11 != null) goto L10;
        return false;
    L10:
        if (TextUtils.isEmpty(r11.f24519l) == false) goto L12;
        return false;
    L12:
        if (r11.f24519l.contains("" + r10) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public final boolean q(int r10) {
        if (r10 >= 200) goto L5;
        return false;
    L5:
        if (r10 >= 400) goto L10;
        return true;
    L10:
        return false;
    }

    public final void r() {
        SharedPreferences r10 = this.f8168l.getSharedPreferences("ttnet_tnc_config", 0);
        this.f8170n = r10.getInt("tnc_probe_cmd", 0);
        this.f8171o = r10.getLong("tnc_probe_version", 0);
    }

    public final void s() {
        if (Logger.debug() == false) goto L5;
        Logger.d("TNCManager", "resetTNCControlState");
    L5:
        this.f8173q = 0;
        this.f8174r.clear();
        this.f8175s.clear();
        this.f8176t = 0;
        this.f8177u.clear();
        this.f8178v.clear();
    }

    public final void t(boolean r10, long r11, TNCUpdateSource r12) {
        if (this.f8180x.hasMessages(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) == false) goto L5;
        return;
    L5:
        Message r13 = this.f8180x.obtainMessage();
        r13.what = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        r13.arg1 = r10 ? 1 : 0;
        r13.arg2 = r12.mValue;
        if (r11 <= 0) goto L8;
        this.f8180x.sendMessageDelayed(r13, r11);
        return;
    L8:
        this.f8180x.sendMessage(r13);
    }

    public final TNCUpdateSource u(int r10) {
        if (r10 == 7) goto L30;
        if (r10 == 10) goto L28;
        if (r10 == 20) goto L26;
        switch(r10) {
            case -2: goto L24;
            case -1: goto L22;
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            default: goto L10;
        };
    L10:
        return TNCUpdateSource.TTSERVER;
    L12:
        return TNCUpdateSource.TTTNC;
    L14:
        return TNCUpdateSource.TTPOLL;
    L16:
        return TNCUpdateSource.TTERROR;
    L18:
        return TNCUpdateSource.TTSERVER;
    L20:
        return TNCUpdateSource.TTCACHE;
    L22:
        return TNCUpdateSource.TTHardCode;
    L24:
        return TNCUpdateSource.TTRESUME;
    L26:
        return TNCUpdateSource.TTCRONET;
    L28:
        return TNCUpdateSource.TTREGION;
    L30:
        return TNCUpdateSource.PORTRETRY;
    }
}
