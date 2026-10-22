package l6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.connectionclass.ConnectionClassManager;
import com.bytedance.frameworks.baselib.network.connectionclass.ConnectionQuality;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowApiHttpException;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3Builder;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.tnc.TNCManager;
import com.bytedance.ttnet.utils.RequestTicketUtil;
import com.bytedanceos.common.ad.param.AdReportParam;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements NetworkParams.ApiRequestInterceptor, WeakHandler.IHandler, RequestEncryptUtils.IEncryptConfig, HttpClient.IHttpClientConfig, SsCronetHttpClient.ICronetHttpDnsConfig, SsCronetHttpClient.ICronetBootFailureChecker, ConnectionClassManager.ConnectionClassStateChangeListener, NetworkParams.ConnectionQualitySamplerHook, SsCronetHttpClient.ITncInfoGet, NetworkParams.CdnConnectionQualitySamplerHook, NetworkParams.CookieShareInterceptor {
    public static a I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static String f21835J = null;
    public static int K = -1;
    public static int L = -1;
    public static boolean M = false;
    public static boolean N = false;
    public static ArrayList O;
    public static boolean P;
    public static boolean Q;
    public static boolean R;
    public static boolean S;
    public List A;
    public volatile int B;
    public String C;
    public JSONObject D;
    public String E;
    public AtomicInteger F;
    public List G;
    public final WeakHandler H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicLong f21837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AtomicBoolean f21838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f21839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f21840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f21841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f21842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f21844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile int f21845j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f21846k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f21847l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f21848m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f21849n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f21850o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f21851p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f21852q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f21853r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f21854s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f21855t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f21856u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f21857v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f21858w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f21859x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List f21860y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f21861z;

    /* JADX INFO: renamed from: l6.a$a, reason: collision with other inner class name */
    public class C0302a extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f21862e;

        public C0302a(a r10, String r11) {
            this.f21862e = r10;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            this.f21862e.r();
        }
    }

    public class b extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ TNCManager.TNCUpdateSource f21863e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f21864f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ a f21865g;

        public b(a r10, String r11, TNCManager.TNCUpdateSource r12, boolean r13) {
            this.f21865g = r10;
            this.f21863e = r12;
            this.f21864f = r13;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            this.f21865g.w(this.f21863e, this.f21864f);
        }
    }

    public class c extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Map f21866e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f21867f;

        public c(a r10, String r11, Map r12) {
            this.f21867f = r10;
            this.f21866e = r12;
            super(r11);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            TTNetInit.getTTNetDepend().saveMapToProvider(a.a(this.f21867f), this.f21866e);
            Intent r10 = new Intent("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG");
            if (TextUtils.isEmpty(a.b()) == true) goto L5;
            r10.setPackage(a.b());
        L5:
            a.a(this.f21867f).sendBroadcast(r10);
        }
    }

    public static final class d extends BroadcastReceiver {

        /* JADX INFO: renamed from: l6.a$d$a, reason: collision with other inner class name */
        public class C0303a extends w3.c {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ d f21868e;

            public C0303a(d r10, String r11) {
                this.f21868e = r10;
                super(r11);
            }

            @Override // w3.c, java.lang.Runnable
            public void run() {
                f.c().a();
            }
        }

        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            if ("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG".equals(r11.getAction()) == false) goto L8;
            new C0303a(this, "SyncMainProcessConfig").a();
            return;
        }
    }

    static {
        ArrayList r10 = new ArrayList();
        O = r10;
        P = false;
        r10.add("MI PAD 2");
        O.add("YT3-X90L");
        O.add("YT3-X90F");
        O.add("GT-810");
        Q = false;
        R = false;
        S = false;
    }

    public a(Context r10, boolean r11) {
        this.f21837b = new AtomicLong(0);
        this.f21838c = new AtomicBoolean(false);
        this.f21839d = new Object();
        this.f21841f = false;
        this.f21842g = "";
        this.f21843h = 0;
        this.f21844i = 0;
        this.f21845j = -1;
        this.f21846k = 0;
        this.f21847l = 0;
        this.f21848m = 0;
        this.f21849n = 1;
        this.f21850o = 1;
        this.f21851p = 0;
        this.f21852q = 0;
        this.f21853r = 1;
        this.f21854s = 1;
        this.f21855t = 1;
        this.f21856u = 1;
        this.f21857v = 1;
        this.f21858w = 1;
        this.f21859x = "";
        this.f21860y = new CopyOnWriteArrayList();
        this.f21861z = 0;
        this.A = new CopyOnWriteArrayList();
        this.C = "";
        this.F = new AtomicInteger(10800);
        this.G = new CopyOnWriteArrayList();
        this.H = new WeakHandler(Looper.getMainLooper(), this);
        this.f21840e = r10;
        this.f21836a = r11;
    }

    public static /* synthetic */ Context a(a r10) {
        return r10.f21840e;
    }

    public static /* synthetic */ String b() {
        return f21835J;
    }

    public static a f(Context r10) {
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (I != null) goto L25;
        boolean r11 = com.bytedance.frameworks.baselib.network.http.util.f.e(r10);     // Catch: Throwable -> L9
        I = new a(r10.getApplicationContext(), r11);     // Catch: Throwable -> L9
        if (O.contains(Build.MODEL) == false) goto L11;
        P = true;     // Catch: Throwable -> L9
    L11:
        f21835J = r10.getPackageName();     // Catch: Throwable -> L9
        if (r11 == false) goto L16;
        RequestEncryptUtils.e(I);     // Catch: Throwable -> L9
        SsCronetHttpClient.W(I);     // Catch: Throwable -> L9
        SsCronetHttpClient.U(I);     // Catch: Throwable -> L9
        SsCronetHttpClient.X(I);     // Catch: Throwable -> L9
        HttpClient.e(I);     // Catch: Throwable -> L9
        ConnectionClassManager.c().f(I);     // Catch: Throwable -> L9
        NetworkParams.z(I);     // Catch: Throwable -> L9
        NetworkParams.x(I);     // Catch: Throwable -> L9
        if (NetworkParams.i() != null) goto L24;
        NetworkParams.B(I);     // Catch: Throwable -> L9
    L24:
        NetworkParams.w(I);     // Catch: Throwable -> L9
        l6.c.a(r10);     // Catch: Throwable -> L9
        goto L25
    L16:
        IntentFilter r12 = new IntentFilter();     // Catch: Throwable -> L9
        r12.addAction("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG");     // Catch: Throwable -> L9
        r10.registerReceiver(new d(), r12);     // Catch: Throwable -> L19
    L21:
        f r13 = f.c();     // Catch: Throwable -> L9
        RequestEncryptUtils.e(r13);     // Catch: Throwable -> L9
        SsCronetHttpClient.W(r13);     // Catch: Throwable -> L9
        SsCronetHttpClient.U(r13);     // Catch: Throwable -> L9
        HttpClient.e(r13);     // Catch: Throwable -> L9
        if (NetworkParams.i() != null) goto L24;
        NetworkParams.B(r13);     // Catch: Throwable -> L9
        goto L24
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L9
    L25:
        a r14 = I;     // Catch: Throwable -> L9
        monitor-exit(a.class);     // Catch: Throwable -> L9
        return r14;
    }

    public static boolean k() {
        String r10 = Build.SUPPORTED_ABIS[0];     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return false;
    L7:
        if ("x86".equalsIgnoreCase(r10) == true) goto L15;
        if ("x86_64".equalsIgnoreCase(r10) == true) goto L15;
    L22:
        return false;
    L15:
        if (n6.a.e() == false) goto L18;
        Logger.d("AppConfig", "x86 support");     // Catch: Throwable -> L11
        return false;
    L18:
        Logger.w("AppConfig", "Cronet unsupported CPU arch: " + r10);     // Catch: Throwable -> L11
        com.bytedance.frameworks.baselib.network.http.ok3.impl.i.Q(2);     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L22
    }

    public boolean c(TNCManager.TNCUpdateSource r10, boolean r11) {
        Logger.d("TNCManager", "doRefresh: updating state " + this.f21838c.get());
        if (this.f21838c.compareAndSet(false, true) == true) goto L6;
        Logger.d("TNCManager", "doRefresh, already running");
        return false;
    L6:
        new b(this, "AppConfigThread", r10, r11).a();
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.CdnConnectionQualitySamplerHook
    public boolean cdnShouldSampling(String r10) {
        if (com.bytedance.common.utility.e.b(r10) == false) goto L6;
        return false;
    L6:
        if (this.f21856u > 0) goto L21;
        return false;
    L21:
        URI r11 = com.bytedance.frameworks.baselib.network.http.util.g.b(r10);     // Catch: Throwable -> L18
        if (r11 != null) goto L11;
        return false;
    L11:
        String r12 = r11.getHost();     // Catch: Throwable -> L18
        if (com.bytedance.common.utility.e.b(r12) == false) goto L14;
        return false;
    L14:
        if (r12.endsWith(k6.a.a()) == false) goto L20;
        return true;
    L20:
        return false;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public String[] d() {
        String[] r10 = TTNetInit.getTTNetDepend().getConfigServers();
        if (r10 == null) goto L7;
        if (r10.length <= 0) goto L7;
        return r10;
    L7:
        return new String[0];
    }

    public String e() {
        return this.f21859x;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiRequestInterceptor
    public String filterUrl(String r10, o4.a r11) {
        if (com.bytedance.common.utility.e.b(r10) == false) goto L15;
        return r10;
    L15:
    L8:
        th = move-exception;
        th.printStackTrace();
    L13:
        return r10;
    L6:
        if (this.f21836a == false) goto L10;
        s();     // Catch: Throwable -> L8
    L14:
        goto L13
    L10:
        r();     // Catch: Throwable -> L8
        goto L14
    }

    public List g() {
        return this.G;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient.ITncInfoGet
    public JSONObject getABTest() {
        return this.D;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.CookieShareInterceptor
    public List getShareCookie(CookieManager r10, r4.a r11, URI r12) {
        if (r12 == null) goto L36;
        if (r10 != null) goto L37;
        if (r11 == null) goto L36;
    L37:
        String r13 = r12.getHost();     // Catch: Exception -> L9
    L11:
        if (com.bytedance.common.utility.e.b(r13) == true) goto L36;
        if (com.bytedance.ttnet.utils.c.a(r13, this.f21860y) == false) goto L36;
        if (com.bytedance.common.utility.e.b(TTNetInit.getTTNetDepend().getShareCookieMainDomain()) == false) goto L18;
        return null;
    L18:
        ArrayList r14 = new ArrayList();
        if (r10 == null) goto L25;
        String r15 = r10.getCookie(r12.getScheme() + "://" + TTNetInit.getTTNetDepend().getShareCookieMainDomain());
        if (com.bytedance.common.utility.e.b(r15) == true) goto L25;
        r14.add(r15);
        return r14;
    L25:
        if (com.bytedance.common.utility.c.a(r14) == false) goto L41;
        if (r11 == null) goto L42;
        Map r16 = r11.get(URI.create(r12.getScheme() + "://" + TTNetInit.getTTNetDepend().getShareCookieMainDomain()), new LinkedHashMap());     // Catch: Throwable -> L33
        if (r16 != null) goto L30;
        return r14;
    L30:
        if (r16.isEmpty() == true) goto L44;
        return (List) r16.get("Cookie");
    L44:
        return r14;
    L33:
        th = move-exception;
        th.printStackTrace();
        return r14;
    L42:
        return r14;
    L41:
        return r14;
    L9:
        r13 = null;
    L36:
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.CookieShareInterceptor
    public List getShareCookieHostList(String r10) {
        if (com.bytedance.ttnet.utils.c.a(r10, this.f21860y) == true) goto L5;
        return null;
    L5:
        return this.f21860y;
    }

    public String h() {
        return this.E;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        switch(r10.what) {
            case 101: goto L17;
            case 102: goto L14;
            case 103: goto L10;
            case 104: goto L6;
            default: goto L25;
        };
    L17:
        this.f21837b.set(System.currentTimeMillis());
        if (Logger.debug() == false) goto L20;
        Logger.d("TNCManager", "doRefresh, succ");
    L20:
        this.f21838c.set(false);
        return;
    L25:
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("TNCManager", "did is empty, delay request tnc");
    L8:
        t(TNCManager.TNCUpdateSource.TTSERVER);
        return;
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.d("TNCManager", "do tnc polling");
    L12:
        t(TNCManager.TNCUpdateSource.TTPOLL);
        return;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d("TNCManager", "doRefresh, error");
    L16:
        this.f21838c.set(false);
    }

    public void i(String r10) {
        if (com.bytedance.common.utility.e.b(r10) == false) goto L20;
        return;
    L20:
        boolean r11 = j(r10, TNCManager.TNCUpdateSource.TTCRONET, System.currentTimeMillis());     // Catch: Exception -> L7
    L9:
        if (r11 == false) goto L11;
        int r12 = 101;
    L18:
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L14
        r13.put("from", "cronet");     // Catch: Throwable -> L14
        TTNetInit.getTTNetDepend().onAppConfigUpdated(this.f21840e, r13);     // Catch: Throwable -> L14
    L16:
        this.H.sendEmptyMessage(r12);
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    L11:
        r12 = 102;
    L7:
        e = move-exception;
        e.printStackTrace();
        r11 = false;
        goto L9
    }

    @Override // com.bytedance.ttnet.HttpClient.IHttpClientConfig
    public boolean isChromiumOpen() {
        if (N == false) goto L7;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.i.Q(0);
        return false;
    L7:
        if (P == false) goto L11;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.i.Q(8);
        return false;
    L11:
        if (k() == false) goto L14;
        return false;
    L14:
        if (M == true) goto L20;
        if (this.f21845j <= 5) goto L20;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.i.Q(3);
        Logger.e("AppConfig", "After five consecutive crashes of cronet, you must reinstall app to enable cronet, or wait until several hours");
        return false;
    L20:
        if (TTNetInit.getTTNetDepend().isCronetPluginInstalled() == true) goto L23;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.i.Q(6);
        return false;
    L23:
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient.ICronetBootFailureChecker
    public boolean isCronetBootFailureExpected() {
        if (Logger.debug() == false) goto L5;
        Logger.d("AppConfig", "isCronetBootFailureExpected...");
    L5:
        SharedPreferences r10 = this.f21840e.getSharedPreferences("ss_app_config", 0);
        if (this.f21845j >= 0) goto L8;
        this.f21845j = r10.getInt("chromium_boot_failures", 0);
    L8:
        this.f21846k = r10.getLong("chromium_boot_failures_timestamp", 0);
        if (this.f21845j <= 5) goto L14;
        if ((System.currentTimeMillis() - this.f21846k) <= TimeUnit.HOURS.toMillis(1)) goto L14;
        this.f21845j = 5;
    L14:
        if (isChromiumOpen() == false) goto L20;
        SharedPreferences.Editor r11 = r10.edit();
        r11.putInt("chromium_boot_failures", this.f21845j + 1);
        r11.putLong("chromium_boot_failures_timestamp", System.currentTimeMillis());
        if (Logger.debug() == false) goto L18;
        Logger.d("AppConfig", "KEY_CHROMIUM_BOOT_FAILURES inc...");
    L18:
        SharedPrefsEditorCompat.a(r11);
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("chromium_boot_failures", Integer.valueOf(this.f21845j + 1));
        TTNetInit.getTTNetDepend().saveMapToProvider(this.f21840e, r12);
        return true;
    L20:
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient.ICronetHttpDnsConfig
    public boolean isCronetHttpDnsOpen() {
        if (Q == false) goto L6;
        return false;
    L6:
        if (this.f21847l <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiRequestInterceptor
    public boolean isOkHttp3Open() {
        if (Logger.debug() == false) goto L6;
        return true;
    L6:
        if (this.f21844i > 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiRequestInterceptor
    public boolean isOkHttpOpen() {
        if (this.f21843h <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.frameworks.core.encrypt.RequestEncryptUtils.IEncryptConfig
    public boolean isSsQueriesHeaderOpen() {
        if (R == false) goto L6;
        return false;
    L6:
        if (this.f21852q <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.frameworks.core.encrypt.RequestEncryptUtils.IEncryptConfig
    public boolean isSsQueriesOpen() {
        if (R == false) goto L6;
        return true;
    L6:
        if (this.f21851p > 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.frameworks.core.encrypt.RequestEncryptUtils.IEncryptConfig
    public boolean isSsQueriesPlaintextOpen() {
        if (R == false) goto L6;
        return true;
    L6:
        if (this.f21853r > 0) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean j(Object r32, TNCManager.TNCUpdateSource r33, long r34) {
        JSONObject r10 = new JSONObject();
        if ((r32 instanceof String) == false) goto L10;
        String r11 = (String) r32;
        if (com.bytedance.common.utility.e.b(r11) == false) goto L8;
        m(r10, "empty response.");
        return false;
    L8:
        JSONObject r12 = new JSONObject(r11);
    L13:
        if (r12 != null) goto L16;
        m(r10, "object is null.");
        return false;
    L16:
        this.E = r12.optString("summary");
        JSONObject r13 = r12.getJSONObject("data");
        h.b(this.f21840e).f(r13);
        K = r13.optInt("use_http_dns", -1);
        L = r13.optInt("collect_recent_page_info_enable", -1);
        int r14 = r13.optInt("ok_http_open", 0);
        int r15 = r13.optInt("ok_http3_open", 0);
        int r16 = r13.optInt("cronet_version", 0);
        int r17 = r13.optInt("http_dns_enabled", 0);
        int r18 = r13.optInt("detect_open", 0);
        int r19 = r13.optInt("detect_native_page", 1);
        int r110 = r13.optInt("collect_recent_page_info_enable", 1);
        int r111 = r13.optInt("add_ss_queries_open", 0);
        int r112 = r13.optInt("add_ss_queries_header_open", 0);
        int r20 = r13.optInt("add_ss_queries_plaintext_open", 1);
        int r21 = r13.optInt("add_device_fingerprint_open", 1);
        int r22 = r13.optInt("image_ttnet_enabled", 1);
        int r23 = r13.optInt("sample_band_width_enabled", 1);
        int r24 = r13.optInt("cdn_sample_band_width_enabled", 1);
        int r25 = r13.optInt("dynamic_adjust_threadpool_size_open", 1);
        int r26 = r13.optInt("http_show_hijack", 1);
        int r27 = r13.optInt("http_verify_sign", 1);
        int r28 = r13.optInt("tnc_update_interval", -1);
        if (r28 <= 0) goto L19;
        this.F.set(r28);
    L19:
        JSONArray r29 = r13.optJSONArray("send_tnc_host_arrays");
        if (r29 == null) goto L29;
        this.G.clear();
        int r113 = 0;
    L23:
        if (r113 >= r29.length()) goto L29;
        if (TextUtils.isEmpty(r29.optString(r113)) == true) goto L28;
        this.G.add(r29.optString(r113));
    L28:
        r113 = r113 + 1;
        r13 = r13;
    L29:
        JSONObject r210 = r13;
        monitor-enter(this);
        this.f21843h = r14;     // Catch: Throwable -> L129
        this.f21844i = r15;     // Catch: Throwable -> L129
        this.f21861z = r16;     // Catch: Throwable -> L129
        this.f21847l = r17;     // Catch: Throwable -> L129
        this.f21848m = r18;     // Catch: Throwable -> L129
        this.f21849n = r19;     // Catch: Throwable -> L129
        this.f21850o = r110;     // Catch: Throwable -> L129
        this.f21851p = r111;     // Catch: Throwable -> L129
        this.f21852q = r112;     // Catch: Throwable -> L129
        this.f21853r = r20;     // Catch: Throwable -> L129
        this.f21857v = r21;     // Catch: Throwable -> L129
        this.f21858w = r25;     // Catch: Throwable -> L129
        this.f21854s = r22;     // Catch: Throwable -> L129
        this.f21855t = r23;     // Catch: Throwable -> L129
        this.f21856u = r24;     // Catch: Throwable -> L129
        monitor-exit(this);     // Catch: Throwable -> L129
        if (r25 <= 0) goto L36;
        boolean r30 = true;
    L37:
        n4.b.c(r30);
        if (r210.optInt("enable_req_ticket", 1) <= 0) goto L40;
        boolean r31 = true;
    L41:
        RequestTicketUtil.e(r31);
        com.bytedance.ttnet.utils.a.C0104a r35 = com.bytedance.ttnet.utils.a.e(r210);
        if (this.f21851p <= 0) goto L44;
    L45:
        r6.b.d(true);
    L46:
        v4.c.e(r210);
        SsCronetHttpClient.G(r210);
        String r36 = r210.optString(WsConstants.KEY_FRONTIER_URLS, "");
        String r37 = r210.optString("share_cookie_host_list", "");
        TTNetInit.getTTNetDepend().onShareCookieConfigUpdated(r37);
        String r38 = r210.optString("api_http_host_list", "");
        String r39 = r210.optString("concurrent_request_config", "");
        com.bytedance.frameworks.baselib.network.http.cronet.impl.b.d().i(r39);
        String r40 = r210.optString("add_common_params", "");
        p4.b.b().a();
        String r41 = r210.optString("L0_params", "");
        y4.d.e().j(r41);
        int r42 = r210.optInt("query_filter_enabled", Integer.MIN_VALUE);
        String r43 = r210.optString("query_filter_actions");
        if (r42 == Integer.MIN_VALUE) goto L53;
        y4.d r44 = y4.d.e();
        if (r42 <= 0) goto L51;
        boolean r45 = true;
    L52:
        r44.c(r45);
        y4.d.e().f(r43);
        goto L53
    L51:
        r45 = false;
    L53:
        int r46 = r210.optInt("disable_store_region_v2", 0);
        StoreRegionManager r47 = StoreRegionManager.m();
        if (r46 <= 0) goto L56;
        boolean r48 = true;
    L57:
        r47.f(r48);
        this.B = r210.optInt("disable_encrypt_switch", 0);
        this.f21859x = r210.optString("cronet_so_path", "");
        if (this.B != 2) goto L60;
        int r49 = 0;
        SharedPreferences.Editor r50 = this.f21840e.getSharedPreferences("app_log_encrypt_switch_count", 0).edit();
        r50.putInt("app_log_encrypt_faild_count", 0);
        SharedPrefsEditorCompat.a(r50);
    L61:
        int r51 = r210.optInt("disable_framed_transport", r49);
        if (r51 > 0) goto L132;
    L67:
        monitor-enter(this);
        SharedPreferences r52 = this.f21840e.getSharedPreferences("ss_app_config", 0);     // Catch: Throwable -> L71
        String r53 = r52.getString("share_cookie_host_list", "");     // Catch: Throwable -> L71
        SharedPreferences.Editor r54 = r52.edit();     // Catch: Throwable -> L71
        r54.putString("ttnet_response_verify", r35.f8204b);     // Catch: Throwable -> L71
        r54.putInt("ttnet_response_verify_enabled", r35.f8203a);     // Catch: Throwable -> L71
        v4.c.d(r54);     // Catch: Throwable -> L71
        SsCronetHttpClient.F(r54);     // Catch: Throwable -> L71
        r54.putInt("ok_http_open", r14);     // Catch: Throwable -> L71
        r54.putInt("ok_http3_open", r15);     // Catch: Throwable -> L71
        r54.putInt("cronet_version", r16);     // Catch: Throwable -> L71
        r54.putInt("http_dns_enabled", r17);     // Catch: Throwable -> L71
        r54.putInt("detect_open", r18);     // Catch: Throwable -> L71
        r54.putInt("detect_native_page", r19);     // Catch: Throwable -> L71
        r54.putInt("collect_recent_page_info_enable", r110);     // Catch: Throwable -> L71
        r54.putInt("add_ss_queries_open", r111);     // Catch: Throwable -> L71
        r54.putInt("add_ss_queries_header_open", r112);     // Catch: Throwable -> L71
        r54.putInt("add_ss_queries_plaintext_open", r20);     // Catch: Throwable -> L71
        r54.putInt("add_device_fingerprint_open", r21);     // Catch: Throwable -> L71
        r54.putInt("dynamic_adjust_threadpool_size_open", r25);     // Catch: Throwable -> L71
        r54.putInt("image_ttnet_enabled", r22);     // Catch: Throwable -> L71
        r54.putInt("use_http_dns", K);     // Catch: Throwable -> L71
        r54.putInt("use_http_dns_refetch_on_expire", L);     // Catch: Throwable -> L71
        r54.putInt("http_show_hijack", r26);     // Catch: Throwable -> L71
        r54.putInt("http_verify_sign", r27);     // Catch: Throwable -> L71
        r54.putString(WsConstants.KEY_FRONTIER_URLS, r36);     // Catch: Throwable -> L71
        r54.putString("cronet_so_path", this.f21859x);     // Catch: Throwable -> L71
        r54.putString("share_cookie_host_list", r37);     // Catch: Throwable -> L71
        r10.put("oldShareCookieHosts", r53);     // Catch: Throwable -> L71
        r10.put("newShareCookieHosts", r37);     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r37) == true) goto L73;
        this.f21860y.clear();     // Catch: Throwable -> L71
        com.bytedance.ttnet.utils.c.c(r37, this.f21860y);     // Catch: Throwable -> L71
    L73:
        String r55 = TTNetInit.getTTNetDepend().getShareCookieMainDomain();     // Catch: Throwable -> L71
        if (com.bytedance.common.utility.e.b(r55) == false) goto L76;
    L78:
        r54.putString("api_http_host_list", r38);     // Catch: Throwable -> L71
        r54.putString("concurrent_request_config", r39);     // Catch: Throwable -> L71
        r54.putString("add_common_params", r40);     // Catch: Throwable -> L71
        r54.putString("query_filter_actions", r43);     // Catch: Throwable -> L71
        r54.putString("L0_params", r41);     // Catch: Throwable -> L71
        r54.putInt("query_filter_enabled", r42);     // Catch: Throwable -> L71
        String[] r56 = r38.split(",");     // Catch: Throwable -> L71
        int r57 = r56.length;     // Catch: Throwable -> L71
        int r114 = 0;
    L79:
        if (r114 >= r57) goto L87;
        int r115 = r57;
        String r58 = r56[r114];     // Catch: Throwable -> L71
        if (com.bytedance.common.utility.e.b(r58) == true) goto L85;
        String[] r310 = r56;
        if (com.bytedance.ttnet.utils.c.a(r58, this.A) == true) goto L86;
        String r59 = r58.trim();     // Catch: Throwable -> L71
        this.A.add(r59);     // Catch: Throwable -> L71
    L86:
        r114 = r114 + 1;     // Catch: Throwable -> L71
        r56 = r310;
        r57 = r115;
        goto L79
    L85:
        r310 = r56;
        goto L86
    L87:
        r54.putInt("android_log_encrypt_switch", this.B);     // Catch: Throwable -> L71
        r54.putInt("image_ttnet_enabled", this.f21854s);     // Catch: Throwable -> L71
        r54.putInt("sample_band_width_enabled", this.f21855t);     // Catch: Throwable -> L71
        r54.putInt("cdn_sample_band_width_enabled", this.f21856u);     // Catch: Throwable -> L71
        r54.putInt("disable_framed_transport", r51);     // Catch: Throwable -> L71
        r54.putInt("tnc_update_interval", this.F.get());     // Catch: Throwable -> L71
        StringBuilder r60 = new StringBuilder();     // Catch: Throwable -> L71
        int r116 = 0;
    L89:
        if (r116 >= this.G.size()) goto L94;
        r60.append((String) this.G.get(r116));     // Catch: Throwable -> L71
        if (r116 == this.G.size()) goto L93;
        r60.append(',');     // Catch: Throwable -> L71
    L93:
        r116 = r116 + 1;     // Catch: Throwable -> L71
        goto L89
    L94:
        String r61 = r60.toString();     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r61) == true) goto L98;
        r54.putString("send_tnc_host_arrays", r61);     // Catch: Throwable -> L71
    L98:
        if (TextUtils.isEmpty(this.E) == true) goto L100;
        r54.putString("tnc_summary", this.E);     // Catch: Throwable -> L71
    L100:
        SharedPrefsEditorCompat.a(r54);     // Catch: Throwable -> L71
        LinkedHashMap r62 = new LinkedHashMap();     // Catch: Throwable -> L106
        if (com.bytedance.common.utility.e.b(r36) == false) goto L104;
    L108:
        r62.put("http_dns_enabled", Integer.valueOf(r17));     // Catch: Throwable -> L106
        r62.put("add_ss_queries_open", Integer.valueOf(r111));     // Catch: Throwable -> L106
        r62.put("add_ss_queries_header_open", Integer.valueOf(r112));     // Catch: Throwable -> L106
        r62.put("add_ss_queries_plaintext_open", Integer.valueOf(r20));     // Catch: Throwable -> L106
        r62.put("share_cookie_host_list", r37);     // Catch: Throwable -> L106
        r62.put("disable_framed_transport", Integer.valueOf(r51));     // Catch: Throwable -> L106
        r62.put("query_filter_actions", r43);     // Catch: Throwable -> L106
        r62.put("L0_params", r41);     // Catch: Throwable -> L106
        r62.put("query_filter_enabled", Integer.valueOf(r42));     // Catch: Throwable -> L106
        TTNetInit.getTTNetDepend().saveMapToProvider(this.f21840e, r62);     // Catch: Throwable -> L106
        Intent r63 = new Intent("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG");     // Catch: Throwable -> L106
        if (TextUtils.isEmpty(f21835J) == true) goto L111;
        r63.setPackage(f21835J);     // Catch: Throwable -> L106
    L111:
        this.f21840e.sendBroadcast(r63);     // Catch: Throwable -> L106
    L114:
        monitor-exit(this);     // Catch: Throwable -> L71
        if (com.bytedance.common.utility.e.b(r37) == true) goto L119;
        e.c().d(r53, r37);
    L119:
        if (l6.c.b() == null) goto L121;
        JSONObject r64 = r210;
        l6.c.b().e(r64);
    L123:
        if (TNCManager.h().j() == null) goto L125;
        JSONObject r65 = r64;
        TNCManager.h().j().d(r65, r33, this.C, "", r34);
    L125:
        m(r10, "return true");
        return true;
    L121:
        r64 = r210;
        goto L123
    L104:
        if (r36.equals(this.f21842g) == true) goto L108;
        this.f21842g = r36;     // Catch: Throwable -> L106
        r62.put(WsConstants.KEY_FRONTIER_URLS, r36);     // Catch: Throwable -> L106
    L106:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L71
        goto L114
    L76:
        if (com.bytedance.ttnet.utils.c.a(r55, this.f21860y) == true) goto L78;
        this.f21860y.add(r55);     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        throw th;
    L132:
        OkHttp3Builder.c(r51);     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        th.printStackTrace();
        goto L67
    L60:
        r49 = 0;
        goto L61
    L56:
        r48 = false;
        goto L57
    L44:
        if (this.f21852q <= 0) goto L46;
    L40:
        r31 = false;
        goto L41
    L36:
        r30 = false;
    L129:
        th = move-exception;
        throw th;
    L10:
        if ((r32 instanceof JSONObject) == false) goto L12;
        r12 = (JSONObject) r32;
        goto L13
    L12:
        r12 = null;
        goto L13
    }

    public final boolean l() {
        if (d() != null) goto L5;
    L26:
        return true;
    L5:
        if (d().length < 1) goto L26;
        String r10 = d()[0];
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return true;
    L10:
        String r11 = "https://" + r10 + "/get_domains/v5/";
        String r12 = NetworkParams.a(r11, true);
        if (r11.equals(r12) == false) goto L13;
        return true;
    L13:
        LinkedHashMap r13 = new LinkedHashMap();
        com.bytedance.frameworks.baselib.network.http.util.i.k(r12, r13);     // Catch: Exception -> L27
        if (r13.containsKey("device_id") == true) goto L17;
        return true;
    L17:
        List r14 = (List) r13.get("device_id");     // Catch: Exception -> L27
        if (r14 != null) goto L20;
        return true;
    L20:
        Iterator r15 = r14.iterator();     // Catch: Exception -> L27
    L22:
        if (r15.hasNext() == false) goto L26;
        if (((String) r15.next()).equals(AdReportParam.ClickPosType.SKIP) == true) goto L22;
        return false;
    }

    public final void m(JSONObject r10, String r11) {
        if (r10 != null) goto L8;
        return;
    L8:
        r10.put("return", r11);     // Catch: JSONException -> L7
        r10.put("CurrentShareCookieHostList", this.f21860y.toString());     // Catch: JSONException -> L7
    L5:
        TTNetInit.getTTNetDepend().mobOnEvent(TTNetInit.getTTNetDepend().getContext(), "handleResponse", "shareCookieHostList", r10);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiRequestInterceptor
    public void monitorApiHttp(String r10, String r11, boolean r12) {
        if (this.A.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r13 = this.A.iterator();
    L7:
        if (r13.hasNext() == false) goto L29;
        String r14 = (String) r13.next();
        if (com.bytedance.common.utility.e.b(r14) == true) goto L7;
        if (r10.endsWith(r14) == false) goto L7;
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L20
        r15.put("url", r10 + r11);     // Catch: Throwable -> L20
        r15.put("replace", r12);     // Catch: Throwable -> L20
        TTNetInit.monitorLogSend("api_http", r15);     // Catch: Throwable -> L20
    L14:
        if (TTNetInit.apiHttpInterceptEnabled() == false) goto L19;
        if (r12 == false) goto L18;
        return;
    L18:
        throw new NotAllowApiHttpException("Api http request is not allowed to be executed");
    L19:
        return;
    }

    public void n() {
        SharedPreferences r10 = this.f21840e.getSharedPreferences("ss_app_config", 0);     // Catch: Throwable -> L6
        SharedPreferences.Editor r11 = r10.edit();     // Catch: Throwable -> L6
        r11.putInt("chromium_boot_failures", 0);     // Catch: Throwable -> L6
        if (Logger.debug() == false) goto L8;
        Logger.d("AppConfig", "KEY_CHROMIUM_BOOT_FAILURES set 0");     // Catch: Throwable -> L6
    L8:
        SharedPrefsEditorCompat.a(r11);     // Catch: Throwable -> L6
        this.f21845j = r10.getInt("chromium_boot_failures", 0);     // Catch: Throwable -> L6
        LinkedHashMap r12 = new LinkedHashMap();     // Catch: Throwable -> L6
        r12.put("chromium_boot_failures", Integer.valueOf(this.f21845j));     // Catch: Throwable -> L6
        TTNetInit.getTTNetDepend().saveMapToProvider(this.f21840e, r12);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public List o(String r10) {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.connectionclass.ConnectionClassManager.ConnectionClassStateChangeListener
    public void onBandwidthStateChange(ConnectionQuality r10) {
        if (Logger.debug() == false) goto L7;
        if (r10 == null) goto L8;
        Logger.d("AppConfig", "onBandwidthStateChange bandwidthState = " + r10);
        return;
    L8:
        return;
    }

    public void p(String r10) {
        this.D = BaseHttpRequestInfo.b(r10);
    }

    public void q(String r10) {
        this.C = r10;
    }

    public synchronized void r() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if ((System.currentTimeMillis() - this.f21837b.get()) <= (((long) this.F.get()) * 1000)) goto L17;
        this.f21837b.set(System.currentTimeMillis());     // Catch: Throwable -> L12
        int r10 = TTNetInit.getTTNetDepend().getProviderInt(this.f21840e, "disable_framed_transport", 0);     // Catch: Throwable -> L12 Exception -> L21
        if (r10 <= 0) goto L15;
        OkHttp3Builder.c(r10);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L12 Exception -> L21
    L15:
        if (TNCManager.h().j() == null) goto L17;
        TNCManager.h().j().g(this.f21837b.get());     // Catch: Throwable -> L12 Exception -> L21
    L17:
        monitor-exit(this);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiRequestInterceptor
    public List resolveInetAddresses(String r10) {
        if (com.bytedance.common.utility.e.b(r10) == false) goto L5;
        return null;
    L5:
        if (this.f21836a == true) goto L8;
        return null;
    L8:
        return o(r10);
    }

    public void s() {
        Object r10 = this.f21839d;
        monitor-enter(r10);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f21841f == false) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L10:
        boolean r11 = true;
        this.f21841f = true;     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        h.b(this.f21840e).h();
        SharedPreferences r12 = this.f21840e.getSharedPreferences("ss_app_config", 0);
        this.f21843h = r12.getInt("ok_http_open", 0);
        this.f21844i = r12.getInt("ok_http3_open", 0);
        this.f21861z = r12.getInt("cronet_version", 0);
        this.f21847l = r12.getInt("http_dns_enabled", 0);
        this.f21848m = r12.getInt("detect_open", 0);
        this.f21849n = r12.getInt("detect_native_page", 1);
        this.f21850o = r12.getInt("collect_recent_page_info_enable", 1);
        this.f21851p = r12.getInt("add_ss_queries_open", 0);
        this.f21852q = r12.getInt("add_ss_queries_header_open", 0);
        this.f21853r = r12.getInt("add_ss_queries_plaintext_open", 1);
        this.f21857v = r12.getInt("add_device_fingerprint_open", 1);
        this.f21858w = r12.getInt("dynamic_adjust_threadpool_size_open", 1);
        if (this.f21845j >= 0) goto L16;
        this.f21845j = r12.getInt("chromium_boot_failures", 0);
    L16:
        if (this.f21858w <= 0) goto L18;
        boolean r13 = true;
    L19:
        n4.b.c(r13);
        this.f21854s = r12.getInt("image_ttnet_enabled", 1);
        this.f21855t = r12.getInt("sample_band_width_enabled", 1);
        this.f21856u = r12.getInt("cdn_sample_band_width_enabled", 1);
        K = r12.getInt("use_http_dns", -1);
        L = r12.getInt("use_http_dns_refetch_on_expire", -1);
        v4.c.c(r12);
        SsCronetHttpClient.E(r12);
        com.bytedance.ttnet.utils.a.d(r12);
        if (this.f21851p <= 0) goto L22;
    L23:
        r6.b.d(true);
    L24:
        this.f21842g = r12.getString(WsConstants.KEY_FRONTIER_URLS, "");
        this.f21859x = r12.getString("cronet_so_path", "");
        String r14 = r12.getString("api_http_host_list", "");
        if (com.bytedance.common.utility.e.b(r14) == true) goto L32;
        String[] r15 = r14.split(",");
        int r16 = r15.length;
        int r17 = 0;
    L27:
        if (r17 >= r16) goto L32;
        String r18 = r15[r17];
        if (com.bytedance.common.utility.e.b(r18) == true) goto L31;
        this.A.add(r18.trim());
    L31:
        r17 = r17 + 1;
    L32:
        com.bytedance.frameworks.baselib.network.http.cronet.impl.b.d().i(r12.getString("concurrent_request_config", ""));
        r12.getString("add_common_params", "");
        p4.b.b().a();
        y4.d.e().j(r12.getString("L0_params", ""));
        int r19 = r12.getInt("query_filter_enabled", Integer.MIN_VALUE);
        String r20 = r12.getString("query_filter_actions", "");
        if (r19 == Integer.MIN_VALUE) goto L39;
        y4.d r21 = y4.d.e();
        if (r19 > 0) goto L38;
        r11 = false;
    L38:
        r21.c(r11);
        y4.d.e().f(r20);
    L39:
        String r22 = r12.getString("share_cookie_host_list", "");
        com.bytedance.ttnet.utils.c.c(r22, this.f21860y);
        String r23 = TTNetInit.getTTNetDepend().getShareCookieMainDomain();
        if (com.bytedance.common.utility.e.b(r23) == false) goto L42;
    L44:
        this.F.set(r12.getInt("tnc_update_interval", 10800));
        String r24 = r12.getString("send_tnc_host_arrays", "");
        if (TextUtils.isEmpty(r24) == true) goto L47;
        String[] r25 = r24.split(",");
        this.G.clear();
        this.G.addAll(Arrays.asList(r25));
    L47:
        this.E = r12.getString("tnc_summary", "");
        if (TNCManager.h().j() == null) goto L50;
        TNCManager.h().j().f(this.f21837b.get());
    L50:
        int r26 = r12.getInt("disable_framed_transport", 0);
        if (r26 <= 0) goto L57;
        OkHttp3Builder.c(r26);     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        th.printStackTrace();
    L57:
        if (this.f21836a == false) goto L77;
        LinkedHashMap r27 = new LinkedHashMap();     // Catch: Throwable -> L61
        if (com.bytedance.common.utility.e.b(this.f21842g) == true) goto L63;
        r27.put(WsConstants.KEY_FRONTIER_URLS, this.f21842g);     // Catch: Throwable -> L61
    L63:
        r27.put("http_dns_enabled", Integer.valueOf(this.f21847l));     // Catch: Throwable -> L61
        r27.put("add_ss_queries_open", Integer.valueOf(this.f21851p));     // Catch: Throwable -> L61
        r27.put("add_ss_queries_header_open", Integer.valueOf(this.f21852q));     // Catch: Throwable -> L61
        r27.put("add_ss_queries_plaintext_open", Integer.valueOf(this.f21853r));     // Catch: Throwable -> L61
        r27.put("chromium_boot_failures", Integer.valueOf(this.f21845j));     // Catch: Throwable -> L61
        r27.put("share_cookie_host_list", r22);     // Catch: Throwable -> L61
        r27.put("disable_framed_transport", Integer.valueOf(r26));     // Catch: Throwable -> L61
        new c(this, "SaveMapToProvider-Thread", r27).a();     // Catch: Throwable -> L61
        return;
    L61:
        th = move-exception;
        th.printStackTrace();
        return;
    L77:
        return;
    L42:
        if (com.bytedance.ttnet.utils.c.a(r23, this.f21860y) == true) goto L44;
        this.f21860y.add(r23);
        goto L44
    L22:
        if (this.f21852q <= 0) goto L24;
    L18:
        r13 = false;
        goto L19
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ConnectionQualitySamplerHook
    public boolean shouldSampling(String r10) {
        if (com.bytedance.common.utility.e.b(r10) == false) goto L6;
        return false;
    L6:
        if (this.f21855t > 0) goto L21;
        return false;
    L21:
        URI r11 = com.bytedance.frameworks.baselib.network.http.util.g.b(r10);     // Catch: Throwable -> L18
        if (r11 != null) goto L11;
        return false;
    L11:
        String r12 = r11.getHost();     // Catch: Throwable -> L18
        if (com.bytedance.common.utility.e.b(r12) == false) goto L14;
        return false;
    L14:
        if (r12.endsWith(k6.a.b()) == false) goto L20;
        return true;
    L20:
        return false;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public void t(TNCManager.TNCUpdateSource r10) {
        u(r10, false);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiRequestInterceptor
    public String tryDnsMapping(String r10, String[] r11) {
        return r10;
    }

    public void u(TNCManager.TNCUpdateSource r10, boolean r11) {
        v(r10, r11);
    }

    public final void v(TNCManager.TNCUpdateSource r10, boolean r11) {
        if (this.f21836a == false) goto L6;
        c(r10, r11);
        return;
    L6:
        if (this.f21837b.get() > 0) goto L13;
        new C0302a(this, "LoadDomainConfig4Other-Thread").a();     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    public void w(TNCManager.TNCUpdateSource r10, boolean r11) {
        if (Logger.debug() == false) goto L6;
        Logger.d("TNCManager", "doRefresh, actual request");
    L6:
        if (NetworkUtils.l(this.f21840e) == true) goto L8;
        return;
    L8:
        s();
        if (isChromiumOpen() == false) goto L12;
        this.f21838c.set(false);
        return;
    L12:
        if (r11 == true) goto L14;
    L17:
        int r12 = 101;
        if (TNCManager.h().e(this.f21840e, true, r10, this.E) == true) goto L24;
        Logger.d("AppConfig", "tnc reqeust through okhttp failed, fallback to HttpUrlConnection");
        if (TNCManager.h().e(this.f21840e, false, TNCManager.TNCUpdateSource.PORTRETRY, this.E) == true) goto L24;
        r12 = 102;
    L24:
        this.H.sendEmptyMessage(r12);
        this.H.removeMessages(103);
        this.H.sendEmptyMessageDelayed(103, ((long) this.F.get()) * 1000);
        return;
    L14:
        if (l() == false) goto L17;
        Logger.d("TNCManager", "did is empty, delay 5s send tnc again");
        this.H.sendEmptyMessageDelayed(104, PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);
        this.f21838c.set(false);
    }
}
