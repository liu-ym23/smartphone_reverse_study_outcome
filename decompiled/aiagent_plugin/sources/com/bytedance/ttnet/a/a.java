package com.bytedance.ttnet.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.i.l;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.r;
import com.bytedance.ttnet.TTNetInit;
import com.ss.android.socialbase.downloader.setting.DownloadSettingValues;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements WeakHandler.IHandler, com.bytedance.frameworks.baselib.network.connectionclass.a.b, com.bytedance.frameworks.baselib.network.http.cronet.b.i.a, com.bytedance.frameworks.baselib.network.http.cronet.b.i.b, com.bytedance.frameworks.baselib.network.http.cronet.b.i.d, com.bytedance.frameworks.baselib.network.http.g.e, com.bytedance.frameworks.baselib.network.http.g.InterfaceC0188g, com.bytedance.frameworks.baselib.network.http.g.i, com.bytedance.frameworks.baselib.network.http.g.j, com.bytedance.frameworks.core.encrypt.a.InterfaceC0193a, com.bytedance.ttnet.c.b {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static int f11246J = -1;
    private static int K = -1;
    private static ArrayList<String> R = null;
    private static boolean S = false;
    private static boolean T = false;
    private static boolean U = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static boolean f11247b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static boolean f11248c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static boolean f11249d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static boolean f11250e = false;
    private static a f = null;
    private static String h = null;
    private static String n = "";
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private String F;
    private List<String> G;
    private int H;
    private List<String> I;
    private volatile int L;
    private String M;
    private JSONObject N;
    private String O;
    private final AtomicInteger P;
    private final List<String> Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final WeakHandler f11251a;
    private final boolean g;
    private AtomicLong i;
    private AtomicBoolean j;
    private final Object k;
    private final Context l;
    private volatile boolean m;
    private int o;
    private int p;
    private volatile int q;
    private long r;
    private AtomicBoolean s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: renamed from: com.bytedance.ttnet.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppConfig.java */
    static final class C0256a extends PluginBroadcastReceiver {
        C0256a() {
        }

        public void onReceive(Context r3, Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L5;
            return;
        L5:
            if ("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG".equals(r4.getAction()) == false) goto L9;
            final String r6 = "SyncMainProcessConfig";
            new AnonymousClass1(this, r6).a();
            return;
        }
    }

    public static String q() {
        return "ss_app_config";
    }

    public void handleConfigUpdate(String r1) {
    }

    static /* synthetic */ Context a(a r0) {
        return r0.l;
    }

    static /* synthetic */ String r() {
        return h;
    }

    public static a a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        monitor-enter(a.class);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (f != null) goto L23;
        boolean r1 = com.bytedance.frameworks.baselib.network.http.i.h.b(r7);     // Catch: Throwable -> L26
        f = new a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r1);     // Catch: Throwable -> L26
        if (R.contains(Build.MODEL) == false) goto L9;
        f11250e = true;     // Catch: Throwable -> L26
    L9:
        h = r7.getPackageName();     // Catch: Throwable -> L26
        if (r1 == false) goto L14;
        com.bytedance.frameworks.core.encrypt.a.a(f);     // Catch: Throwable -> L26
        com.bytedance.frameworks.baselib.network.http.cronet.b.i.a(f);     // Catch: Throwable -> L26
        com.bytedance.frameworks.baselib.network.http.cronet.b.i.a(f);     // Catch: Throwable -> L26
        com.bytedance.frameworks.baselib.network.http.cronet.b.i.a(f);     // Catch: Throwable -> L26
        com.bytedance.ttnet.c.a(f);     // Catch: Throwable -> L26
        com.bytedance.frameworks.baselib.network.connectionclass.a.a().a(f);     // Catch: Throwable -> L26
        com.bytedance.frameworks.baselib.network.http.g.a(f);     // Catch: Throwable -> L26
        com.bytedance.frameworks.baselib.network.http.g.a(f);     // Catch: Throwable -> L26
        if (com.bytedance.frameworks.baselib.network.http.g.f() != null) goto L22;
        com.bytedance.frameworks.baselib.network.http.g.a(f);     // Catch: Throwable -> L26
    L22:
        com.bytedance.frameworks.baselib.network.c r2 = com.bytedance.frameworks.baselib.network.c.c();     // Catch: Throwable -> L26
        r2.l = System.nanoTime();     // Catch: Throwable -> L26
        com.bytedance.frameworks.baselib.network.http.cronet.b.i.a(f.a(r7));     // Catch: Throwable -> L26
        com.bytedance.frameworks.baselib.network.c r3 = com.bytedance.frameworks.baselib.network.c.c();     // Catch: Throwable -> L26
        r3.m = System.nanoTime();     // Catch: Throwable -> L26
        com.bytedance.frameworks.baselib.network.http.g.a(f);     // Catch: Throwable -> L26
        d.a(r7);     // Catch: Throwable -> L26
        goto L23
    L14:
        IntentFilter r4 = new IntentFilter();     // Catch: Throwable -> L26
        r4.addAction("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG");     // Catch: Throwable -> L26
        com.bytedance.ttnet.utils.e.a(r7, new C0256a(), r4);     // Catch: Throwable -> L17
    L19:
        i r5 = i.c();     // Catch: Throwable -> L26
        com.bytedance.frameworks.core.encrypt.a.a(r5);     // Catch: Throwable -> L26
        com.bytedance.frameworks.baselib.network.http.cronet.b.i.a(r5);     // Catch: Throwable -> L26
        com.bytedance.frameworks.baselib.network.http.cronet.b.i.a(r5);     // Catch: Throwable -> L26
        com.bytedance.ttnet.c.a(r5);     // Catch: Throwable -> L26
        if (com.bytedance.frameworks.baselib.network.http.g.f() != null) goto L22;
        com.bytedance.frameworks.baselib.network.http.g.a(r5);     // Catch: Throwable -> L26
        goto L22
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
    L23:
        a r8 = f;     // Catch: Throwable -> L26
        monitor-exit(a.class);     // Catch: Throwable -> L26
        return r8;
    }

    private a(Context r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        this.i = new AtomicLong(0);
        this.j = new AtomicBoolean(false);
        this.k = new Object();
        this.m = false;
        this.o = 0;
        this.p = 0;
        this.q = -1;
        this.r = 0;
        this.s = new AtomicBoolean(false);
        this.t = 0;
        this.u = 0;
        this.v = 1;
        this.w = 1;
        this.x = 0;
        this.y = 0;
        this.z = 1;
        this.A = 1;
        this.B = 1;
        this.C = 1;
        this.D = 1;
        this.E = 1;
        this.F = "";
        this.G = new CopyOnWriteArrayList();
        this.H = 0;
        this.I = new CopyOnWriteArrayList();
        this.M = "";
        this.P = new AtomicInteger(10800);
        this.Q = new CopyOnWriteArrayList();
        this.f11251a = new WeakHandler(Looper.getMainLooper(), this);
        this.l = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        this.g = r7;
    }

    public void a(com.bytedance.ttnet.tnc.c.b r2) {
        a(r2, false);
    }

    public void a(com.bytedance.ttnet.tnc.c.b r1, boolean r2) {
        d(r1, r2);
    }

    private void d(com.bytedance.ttnet.tnc.c.b r3, boolean r4) {
        if (this.g == false) goto L6;
        b(r3, r4);
        return;
    L6:
        if (this.i.get() > 0) goto L13;
        final String r5 = "LoadDomainConfig4Other-Thread";
        new AnonymousClass1(this, r5).a();     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    synchronized void h() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if ((System.currentTimeMillis() - this.i.get()) <= (((long) this.P.get()) * 1000)) goto L15;
        this.i.set(System.currentTimeMillis());     // Catch: Throwable -> L17
        int r0 = TTNetInit.getTTNetDepend().a(this.l, "disable_framed_transport", 0);     // Catch: Exception -> L20 Throwable -> L17
        if (r0 <= 0) goto L13;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.i.a(r0);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L20 Throwable -> L17
    L13:
        if (com.bytedance.ttnet.tnc.c.c().e() == null) goto L15;
        com.bytedance.ttnet.tnc.c.c().e().b(this.i.get());     // Catch: Exception -> L20 Throwable -> L17
    L15:
        monitor-exit(this);
    }

    public boolean b(final com.bytedance.ttnet.tnc.c.b r5, final boolean r6) {
        if (Logger.debug() == false) goto L6;
        Logger.d("TNCManager", "doRefresh: updating state " + this.j.get());
    L6:
        if (this.j.compareAndSet(false, true) == false) goto L8;
    L13:
        final String r1 = "AppConfigThread";
        new AnonymousClass2(this, r1, r5, r6).a();
        return true;
    L8:
        if (r5 == com.bytedance.ttnet.tnc.c.b.k) goto L13;
        if (Logger.debug() == false) goto L12;
        Logger.d("TNCManager", "doRefresh, already running " + r5);
    L12:
        return false;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r5) {
        switch(r5.what) {
            case 101: goto L17;
            case 102: goto L14;
            case 103: goto L10;
            case 104: goto L6;
            default: goto L25;
        };
    L17:
        this.i.set(System.currentTimeMillis());
        if (Logger.debug() == false) goto L20;
        Logger.d("TNCManager", "doRefresh, succ");
    L20:
        this.j.set(false);
        return;
    L25:
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("TNCManager", "did is empty, delay request tnc");
    L8:
        a(com.bytedance.ttnet.tnc.c.b.f11520d);
        return;
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.d("TNCManager", "do tnc polling");
    L12:
        a(com.bytedance.ttnet.tnc.c.b.f);
        return;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d("TNCManager", "doRefresh, error");
    L16:
        this.j.set(false);
    }

    public void i() {
        Object r0 = this.k;
        monitor-enter(r0);
    L73:
        th = move-exception;
        throw th;
    L5:
        if (this.m == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L73
        return;
    L8:
        boolean r1 = true;
        this.m = true;     // Catch: Throwable -> L73
        monitor-exit(r0);     // Catch: Throwable -> L73
        SharedPreferences r2 = this.l.getSharedPreferences("ss_app_config", 0);
        this.o = r2.getInt("ok_http_open", 0);
        this.p = r2.getInt("ok_http3_open", 0);
        this.H = r2.getInt("cronet_version", 0);
        this.t = r2.getInt("http_dns_enabled", 0);
        this.u = r2.getInt("detect_open", 0);
        this.v = r2.getInt("detect_native_page", 1);
        this.w = r2.getInt("collect_recent_page_info_enable", 1);
        this.x = r2.getInt("add_ss_queries_open", 0);
        this.y = r2.getInt("add_ss_queries_header_open", 0);
        this.z = r2.getInt("add_ss_queries_plaintext_open", 1);
        this.D = r2.getInt("add_device_fingerprint_open", 1);
        this.E = r2.getInt("dynamic_adjust_threadpool_size_open", 1);
        if (this.q >= 0) goto L14;
        this.q = r2.getInt("chromium_boot_failures", 0);
    L14:
        if (this.E <= 0) goto L16;
        boolean r3 = true;
    L17:
        com.bytedance.frameworks.baselib.network.c.f.a(r3);
        this.A = r2.getInt("image_ttnet_enabled", 1);
        this.B = r2.getInt("sample_band_width_enabled", 1);
        this.C = r2.getInt("cdn_sample_band_width_enabled", 1);
        f11246J = r2.getInt("use_http_dns", -1);
        K = r2.getInt("use_http_dns_refetch_on_expire", -1);
        com.bytedance.frameworks.baselib.network.http.f.f.a(r2);
        com.bytedance.frameworks.baselib.network.http.cronet.b.i.a(null, r2);
        com.bytedance.ttnet.utils.a.a(r2);
        if (this.x <= 0) goto L20;
    L21:
        com.bytedance.ttnet.h.c.a(true);
    L22:
        n = r2.getString(WsConstants.KEY_FRONTIER_URLS, "");
        this.F = r2.getString("cronet_so_path", "");
        String r4 = r2.getString("api_http_host_list", "");
        if (com.bytedance.common.utility.j.a(r4) == true) goto L30;
        String[] r5 = r4.split(",");
        int r6 = r5.length;
        int r7 = 0;
    L25:
        if (r7 >= r6) goto L30;
        String r8 = r5[r7];
        if (com.bytedance.common.utility.j.a(r8) == true) goto L29;
        this.I.add(r8.trim());
    L29:
        r7 = r7 + 1;
    L30:
        com.bytedance.frameworks.baselib.network.http.cronet.b.f.a().a(r2.getString("concurrent_request_config", ""));
        String r9 = r2.getString("add_common_params", "");
        com.bytedance.frameworks.baselib.network.http.a.a r10 = com.bytedance.frameworks.baselib.network.http.a.b.a().b();
        if (r10 == null) goto L33;
        r10.a(r9);
    L33:
        com.bytedance.frameworks.baselib.network.e.d.a().b(r2.getString("L0_params", ""));
        int r11 = r2.getInt("query_filter_enabled", Integer.MIN_VALUE);
        String r12 = r2.getString("query_filter_actions", "");
        if (r11 == Integer.MIN_VALUE) goto L40;
        com.bytedance.frameworks.baselib.network.e.d r13 = com.bytedance.frameworks.baselib.network.e.d.a();
        if (r11 <= 0) goto L38;
        boolean r14 = true;
    L39:
        r13.a(r14);
        com.bytedance.frameworks.baselib.network.e.d.a().a(r12);
        goto L40
    L38:
        r14 = false;
    L40:
        String r15 = r2.getString("share_cookie_host_list", "");
        com.bytedance.ttnet.utils.e.b(r15, this.G);
        u();
        if (r2.getInt("private_protocol_enabled", 1) < 1) goto L43;
        boolean r16 = true;
    L44:
        com.bytedance.frameworks.baselib.network.http.g.e(r16);
        int r17 = r2.getInt("destroy_delta_millis", 100);
        if (r17 < 0) goto L48;
        com.bytedance.frameworks.baselib.network.http.g.a(r17);
    L48:
        if (r2.getInt("disable_rotating_host_path_retry", -1) >= 1) goto L51;
        r1 = false;
    L51:
        com.bytedance.frameworks.baselib.network.http.g.d(r1);
        this.P.set(r2.getInt("tnc_update_interval", 10800));
        String r18 = r2.getString("send_tnc_host_arrays", "");
        if (TextUtils.isEmpty(r18) == true) goto L54;
        String[] r19 = r18.split(",");
        this.Q.clear();
        this.Q.addAll(Arrays.asList(r19));
    L54:
        this.O = r2.getString("tnc_summary", "");
        if (com.bytedance.ttnet.tnc.c.c().e() == null) goto L57;
        com.bytedance.ttnet.tnc.c.c().e().a(this.i.get());
    L57:
        int r20 = r2.getInt("disable_framed_transport", 0);
        if (r20 <= 0) goto L64;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.i.a(r20);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        th.printStackTrace();
    L64:
        if (this.g == false) goto L84;
        final LinkedHashMap r21 = new LinkedHashMap();     // Catch: Throwable -> L70
        if (com.bytedance.common.utility.j.a(n) == true) goto L68;
        r21.put(WsConstants.KEY_FRONTIER_URLS, n);     // Catch: Throwable -> L70
    L68:
        r21.put("http_dns_enabled", Integer.valueOf(this.t));     // Catch: Throwable -> L70
        r21.put("add_ss_queries_open", Integer.valueOf(this.x));     // Catch: Throwable -> L70
        r21.put("add_ss_queries_header_open", Integer.valueOf(this.y));     // Catch: Throwable -> L70
        r21.put("add_ss_queries_plaintext_open", Integer.valueOf(this.z));     // Catch: Throwable -> L70
        r21.put("chromium_boot_failures", Integer.valueOf(this.q));     // Catch: Throwable -> L70
        r21.put("share_cookie_host_list", r15);     // Catch: Throwable -> L70
        r21.put("disable_framed_transport", Integer.valueOf(r20));     // Catch: Throwable -> L70
        final String r22 = "SaveMapToProvider-Thread";
        new AnonymousClass3(this, r22, r21).a();     // Catch: Throwable -> L70
        return;
    L70:
        th = move-exception;
        th.printStackTrace();
        return;
    L84:
        return;
    L43:
        r16 = false;
        goto L44
    L20:
        if (this.y <= 0) goto L22;
    L16:
        r3 = false;
        goto L17
    }

    @Override // com.bytedance.frameworks.baselib.network.http.g.i
    public boolean a(String r3) {
        if (com.bytedance.common.utility.j.a(r3) == false) goto L6;
        return false;
    L6:
        if (this.B > 0) goto L21;
        return false;
    L21:
        URI r2 = com.bytedance.frameworks.baselib.network.http.i.j.a(r3);     // Catch: Throwable -> L18
        if (r2 != null) goto L11;
        return false;
    L11:
        String r4 = r2.getHost();     // Catch: Throwable -> L18
        if (com.bytedance.common.utility.j.a(r4) == false) goto L14;
        return false;
    L14:
        if (r4.endsWith(com.bytedance.ttnet.b.a()) == false) goto L20;
        return true;
    L20:
        return false;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    @Override // com.bytedance.frameworks.baselib.network.http.g.e
    @Deprecated
    public String a(String r1, com.bytedance.frameworks.baselib.network.http.c r2) {
        if (com.bytedance.common.utility.j.a(r1) == false) goto L14;
        return r1;
    L14:
    L10:
        th = move-exception;
        th.printStackTrace();
    L12:
        return r1;
    L6:
        if (this.g == false) goto L8;
        i();     // Catch: Throwable -> L10
    L13:
        goto L12
    L8:
        h();     // Catch: Throwable -> L10
        goto L13
    }

    @Override // com.bytedance.frameworks.baselib.network.http.g.e
    public void a(String r4, String r5, boolean r6) {
        if (this.I.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<String> r3 = this.I.iterator();
    L7:
        if (r3.hasNext() == false) goto L29;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        if (com.bytedance.common.utility.j.a(r0) == true) goto L7;
        if (r4.endsWith(r0) == false) goto L7;
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L20
        r7.put("url", r4 + r5);     // Catch: Throwable -> L20
        r7.put("replace", r6);     // Catch: Throwable -> L20
        TTNetInit.monitorLogSend("api_http", r7);     // Catch: Throwable -> L20
    L14:
        if (TTNetInit.apiHttpInterceptEnabled() == false) goto L19;
        if (r6 == false) goto L18;
        return;
    L18:
        throw new com.bytedance.frameworks.baselib.network.http.c.g("Api http request is not allowed to be executed");
    L19:
        return;
    }

    static {
        ArrayList<String> r0 = new ArrayList();
        R = r0;
        f11250e = false;
        r0.add("MI PAD 2");
        R.add("YT3-X90L");
        R.add("YT3-X90F");
        R.add("GT-810");
        S = false;
        T = false;
        U = false;
    }

    public void j() {
        SharedPreferences r0 = this.l.getSharedPreferences("ss_app_config", 0);
        if (this.q >= 0) goto L6;
        this.q = r0.getInt("chromium_boot_failures", 0);
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("AppConfig", "mChromiumBootFailures is " + this.q);
    L8:
        this.r = r0.getLong("chromium_boot_failures_timestamp", 0);
        if (this.q > 5) goto L11;
        return;
    L11:
        if ((System.currentTimeMillis() - this.r) <= TimeUnit.HOURS.toMillis(1)) goto L15;
        this.q = 5;
        return;
    }

    @Override // com.bytedance.ttnet.c.b
    public boolean g() {
        if (f11248c == false) goto L8;
        if (this.s.compareAndSet(false, true) == false) goto L8;
        j();
    L8:
        if (f11249d == false) goto L12;
        r.a(0);
        return false;
    L12:
        if (f11250e == false) goto L16;
        r.a(8);
        return false;
    L16:
        if (k() == false) goto L19;
        return false;
    L19:
        if (f11247b == true) goto L25;
        if (this.q <= 5) goto L25;
        r.a(3);
        Logger.e("AppConfig", "After five consecutive crashes of cronet, you must reinstall app to enable cronet, or wait until several hours");
        return false;
    L25:
        if (TTNetInit.getTTNetDepend().a() == true) goto L28;
        r.a(6);
        return false;
    L28:
        return true;
    }

    private static boolean s() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        String[] r0 = Build.SUPPORTED_ABIS;
        int r4 = r0.length;
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L15;
        if (r0[r5].contains("arm") == true) goto L13;
        r5 = r5 + 1;
    L13:
        boolean r1 = true;
    L17:
        if (r1 == false) goto L22;
        if (r.e() != 2) goto L27;
        r.a(-1);
    L27:
        if (Logger.debug() == false) goto L30;
        Logger.d("AppConfig", "use isCronetUnsupportedABIv2, result is " + (!r1));
    L30:
        return !r1;
    L22:
        if (com.bytedance.ttnet.c.a.a() == false) goto L25;
        Logger.d("AppConfig", "x86 support");
        return false;
    L25:
        r.a(2);
    L15:
        r1 = false;
        goto L17
    L5:
        if (Build.CPU_ABI.contains("arm") == true) goto L13;
        if (Build.CPU_ABI2.contains("arm") == false) goto L15;
        goto L15
    }

    public static boolean k() {
        if (c.c() == false) goto L29;
        return s();
    L29:
    L26:
        th = move-exception;
        th.printStackTrace();
    L28:
        return false;
    L8:
        if (Build.VERSION.SDK_INT >= 21) goto L10;
        String r1 = Build.CPU_ABI;     // Catch: Throwable -> L26
    L12:
        if (TextUtils.isEmpty(r1) == false) goto L15;
        return false;
    L15:
        if ("x86".equalsIgnoreCase(r1) == true) goto L20;
        if ("x86_64".equalsIgnoreCase(r1) == false) goto L28;
    L20:
        if (com.bytedance.ttnet.c.a.a() == false) goto L23;
        Logger.d("AppConfig", "x86 support");     // Catch: Throwable -> L26
        return false;
    L23:
        Logger.w("AppConfig", "Cronet unsupported CPU arch: " + r1);     // Catch: Throwable -> L26
        r.a(2);     // Catch: Throwable -> L26
        return true;
    L10:
        r1 = Build.SUPPORTED_ABIS[0];     // Catch: Throwable -> L26
        goto L12
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.b.i.b
    public boolean b() {
        if (S == false) goto L6;
        return false;
    L6:
        if (this.t <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.b.i.a
    public boolean a() {
        if (Logger.debug() == false) goto L5;
        Logger.d("AppConfig", "isCronetBootFailureExpected...");
    L5:
        boolean r3 = false;
        SharedPreferences r0 = this.l.getSharedPreferences("ss_app_config", 0);
        if (f11248c == true) goto L16;
        if (this.q >= 0) goto L10;
        this.q = r0.getInt("chromium_boot_failures", 0);
    L10:
        this.r = r0.getLong("chromium_boot_failures_timestamp", 0);
        if (this.q <= 5) goto L16;
        if ((System.currentTimeMillis() - this.r) <= TimeUnit.HOURS.toMillis(1)) goto L16;
        this.q = 5;
    L16:
        if (g() == false) goto L24;
        SharedPreferences.Editor r1 = r0.edit();
        r3 = true;
        r1.putInt("chromium_boot_failures", this.q + 1);
        r1.putLong("chromium_boot_failures_timestamp", System.currentTimeMillis());
        if (Logger.debug() == false) goto L20;
        Logger.d("AppConfig", "KEY_CHROMIUM_BOOT_FAILURES inc...");
    L20:
        com.bytedance.common.utility.persistent.a.a(r1);
        final LinkedHashMap r2 = new LinkedHashMap();
        r2.put("chromium_boot_failures", Integer.valueOf(this.q + 1));
        if (TTNetInit.getCronetProvider().getOptInit() == false) goto L23;
        final String r4 = "SaveMapToProvider-Thread";
        new AnonymousClass4(this, r4, r2).a();
        goto L24
    L23:
        TTNetInit.getTTNetDepend().a(this.l, r2);
    L24:
        return r3;
    }

    @Override // com.bytedance.frameworks.core.encrypt.a.InterfaceC0193a
    public boolean d() {
        if (T == false) goto L6;
        return true;
    L6:
        if (this.x > 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.frameworks.core.encrypt.a.InterfaceC0193a
    public boolean e() {
        if (T == false) goto L6;
        return false;
    L6:
        if (this.y <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.frameworks.core.encrypt.a.InterfaceC0193a
    public boolean f() {
        if (T == false) goto L6;
        return true;
    L6:
        if (this.z > 0) goto L10;
        return false;
    L10:
        return true;
    }

    void c(com.bytedance.ttnet.tnc.c.b r6, boolean r7) {
        if (Logger.debug() == false) goto L6;
        Logger.d("TNCManager", "doRefresh, actual request");
    L6:
        if (com.bytedance.common.utility.i.b(this.l) == true) goto L8;
        return;
    L8:
        i();
        if (g() == true) goto L11;
    L14:
        if (r7 == true) goto L16;
    L22:
        int r8 = 102;
        if (com.bytedance.ttnet.tnc.c.c().a(this.l, true, r6, this.O) == false) goto L25;
    L24:
        r8 = 101;
    L28:
        this.f11251a.sendEmptyMessage(r8);
        this.f11251a.removeMessages(103);
        this.f11251a.sendEmptyMessageDelayed(103, ((long) this.P.get()) * 1000);
        return;
    L25:
        Logger.d("AppConfig", "tnc reqeust through okhttp failed, fallback to HttpUrlConnection");
        if (com.bytedance.ttnet.tnc.c.c().a(this.l, false, com.bytedance.ttnet.tnc.c.b.h, this.O) == false) goto L28;
    L16:
        if (t() == false) goto L22;
        if (Logger.debug() == false) goto L20;
        Logger.d("TNCManager", "did is empty, delay 5s send tnc again");
    L20:
        this.f11251a.sendEmptyMessageDelayed(104, 5000);
        this.j.set(false);
        return;
    L11:
        if (r6 == com.bytedance.ttnet.tnc.c.b.k) goto L14;
        this.j.set(false);
    }

    private boolean t() {
        if (l() != null) goto L5;
    L26:
        return true;
    L5:
        if (l().length < 1) goto L26;
        String r6 = l()[0];
        if (TextUtils.isEmpty(r6) == false) goto L10;
        return true;
    L10:
        String r7 = "https://" + r6 + "/get_domains/v5/";
        String r4 = com.bytedance.frameworks.baselib.network.http.g.a(r7, true, null);
        if (r7.equals(r4) == false) goto L13;
        return true;
    L13:
        LinkedHashMap r8 = new LinkedHashMap();
        l.b(r4, r8);     // Catch: Exception -> L27
        if (r8.containsKey("device_id") == true) goto L17;
        return true;
    L17:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r8.get("device_id"), List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L27
        if (r9 != null) goto L20;
        return true;
    L20:
        Iterator r10 = r9.iterator();     // Catch: Exception -> L27
    L22:
        if (r10.hasNext() == false) goto L26;
        if (((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin")).equals("0") == true) goto L22;
        return false;
    }

    public String[] l() {
        String[] r1 = TTNetInit.getTTNetDepend().b();
        if (r1 == null) goto L7;
        if (r1.length <= 0) goto L7;
        return r1;
    L7:
        return new String[0];
    }

    public void a(String r8, Object r9) {
        if (e.a(r9) == true) goto L22;
        return;
    L22:
        boolean r10 = a(r9, com.bytedance.ttnet.tnc.c.b.j, System.currentTimeMillis(), false);     // Catch: Exception -> L7
    L9:
        int r0 = 102;
        if (r10 == false) goto L20;
        r0 = 101;
    L20:
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L14
        r11.put("from", "cronet");     // Catch: Throwable -> L14
        TTNetInit.getTTNetDepend().a(this.l, r11);     // Catch: Throwable -> L14
    L24:
        handleConfigUpdate(r8);     // Catch: Throwable -> L19
    L17:
        this.f11251a.sendEmptyMessage(r0);
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        r10 = false;
        goto L9
    }

    public void m() {
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (Logger.debug() == false) goto L7;
        Logger.d("AppConfig", "KEY_CHROMIUM_BOOT_FAILURES set 0");     // Catch: Throwable -> L11
    L7:
        if (this.q != 0) goto L9;
        return;
    L9:
        this.q = 0;     // Catch: Throwable -> L11
        SharedPreferences.Editor r2 = this.l.getSharedPreferences("ss_app_config", 0).edit();     // Catch: Throwable -> L11
        r2.putInt("chromium_boot_failures", 0);     // Catch: Throwable -> L11
        com.bytedance.common.utility.persistent.a.a(r2);     // Catch: Throwable -> L11
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L11
        r3.put("chromium_boot_failures", 0);     // Catch: Throwable -> L11
        TTNetInit.getTTNetDepend().a(this.l, r3);     // Catch: Throwable -> L11
    }

    private void a(JSONObject r3, String r4) {
        if (r3 != null) goto L8;
        return;
    L8:
        r3.put("return", r4);     // Catch: JSONException -> L7
        r3.put("CurrentShareCookieHostList", this.G.toString());     // Catch: JSONException -> L7
    L5:
        TTNetInit.getTTNetDepend().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "handleResponse", "shareCookieHostList", r3);
    }

    public boolean a(Object r41, com.bytedance.ttnet.tnc.c.b r42, long r43, boolean r45) {
        JSONObject r9 = new JSONObject();
        if (ZeusTransformUtils.instanceOf(r41, String.class) == false) goto L10;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r41, String.class, "com.obric.aiagent.plugin");
        if (com.bytedance.common.utility.j.a(r0) == false) goto L8;
        a(r9, "empty response.");
        return false;
    L8:
        JSONObject r5 = new JSONObject(r0);
    L16:
        if (r5 != null) goto L19;
        a(r9, "object is null.");
        return false;
    L19:
        this.O = r5.optString("summary");
        JSONObject r11 = r5.getJSONObject("data");
        f11246J = r11.optInt("use_http_dns", -1);
        K = r11.optInt("collect_recent_page_info_enable", -1);
        int r6 = r11.optInt("ok_http_open", 0);
        int r7 = r11.optInt("ok_http3_open", 0);
        int r8 = r11.optInt("cronet_version", 0);
        int r10 = r11.optInt("http_dns_enabled", 0);
        int r12 = r11.optInt("detect_open", 0);
        int r13 = r11.optInt("detect_native_page", 1);
        int r14 = r11.optInt("collect_recent_page_info_enable", 1);
        int r2 = r11.optInt("add_ss_queries_open", 0);
        int r15 = r11.optInt("add_ss_queries_header_open", 0);
        int r4 = r11.optInt("add_ss_queries_plaintext_open", 1);
        int r16 = r11.optInt("add_device_fingerprint_open", 1);
        int r3 = r11.optInt("image_ttnet_enabled", 1);
        int r1 = r11.optInt("sample_band_width_enabled", 1);
        int r17 = r11.optInt("cdn_sample_band_width_enabled", 1);
        int r18 = r11.optInt("dynamic_adjust_threadpool_size_open", 1);
        int r19 = r11.optInt("http_show_hijack", 1);
        int r20 = r11.optInt("http_verify_sign", 1);
        int r21 = r11.optInt("tnc_update_interval", -1);
        if (r21 <= 0) goto L22;
        this.P.set(r21);
    L22:
        int r22 = r11.optInt("private_protocol_enabled", 1);
        if (r22 < 1) goto L25;
        boolean r23 = true;
    L26:
        com.bytedance.frameworks.baselib.network.http.g.e(r23);
        int r110 = r11.optInt("destroy_delta_millis", 100);
        if (r110 < 0) goto L29;
        com.bytedance.frameworks.baselib.network.http.g.a(r110);
    L29:
        int r111 = r11.optInt("disable_rotating_host_path_retry", -1);
        if (r111 < 1) goto L32;
        boolean r24 = true;
    L33:
        com.bytedance.frameworks.baselib.network.http.g.d(r24);
        JSONArray r25 = r11.optJSONArray("send_tnc_host_arrays");
        if (r25 == null) goto L44;
        this.Q.clear();
        int r26 = 0;
    L37:
        if (r26 >= r25.length()) goto L43;
        if (TextUtils.isEmpty(r25.optString(r26)) == true) goto L42;
        this.Q.add(r25.optString(r26));
    L42:
        r26 = r26 + 1;
        r16 = r16;
        goto L37
    L43:
        int r29 = r16;
    L45:
        int r27 = r11.optInt("crash_limit_times", 0);
        int r28 = r11.optInt("crash_detect_interval_ms", DownloadSettingValues.SYNC_INTERVAL_MS_FG);
        monitor-enter(this);
        this.o = r6;     // Catch: Throwable -> L151
        this.p = r7;     // Catch: Throwable -> L151
        this.H = r8;     // Catch: Throwable -> L151
        this.t = r10;     // Catch: Throwable -> L151
        this.u = r12;     // Catch: Throwable -> L151
        this.v = r13;     // Catch: Throwable -> L151
        this.w = r14;     // Catch: Throwable -> L151
        this.x = r2;     // Catch: Throwable -> L151
        this.y = r15;     // Catch: Throwable -> L151
        this.z = r4;     // Catch: Throwable -> L151
        int r112 = r29;
        this.D = r112;     // Catch: Throwable -> L151
        this.E = r18;     // Catch: Throwable -> L151
        this.A = r3;     // Catch: Throwable -> L151
        this.B = r1;     // Catch: Throwable -> L151
        this.C = r17;     // Catch: Throwable -> L151
        monitor-exit(this);     // Catch: Throwable -> L151
        if (r18 <= 0) goto L51;
        boolean r30 = true;
    L52:
        com.bytedance.frameworks.baselib.network.c.f.a(r30);
        if (r11.optInt("enable_req_ticket", 1) <= 0) goto L55;
        boolean r31 = true;
    L56:
        com.bytedance.ttnet.utils.c.a(r31);
        com.bytedance.ttnet.utils.a.C0260a r32 = com.bytedance.ttnet.utils.a.a(r11);
        if (this.x <= 0) goto L59;
    L60:
        com.bytedance.ttnet.h.c.a(true);
    L61:
        com.bytedance.frameworks.baselib.network.http.f.f.a(r11);
        com.bytedance.frameworks.baselib.network.http.cronet.b.i.a(r11, null);
        String r33 = r11.optString(WsConstants.KEY_FRONTIER_URLS, "");
        String r34 = r11.optString("share_cookie_host_list", "");
        TTNetInit.getTTNetDepend().a(r34);
        String r35 = r11.optString("api_http_host_list", "");
        String r36 = r11.optString("concurrent_request_config", "");
        com.bytedance.frameworks.baselib.network.http.cronet.b.f.a().a(r36);
        String r37 = r11.optString("add_common_params", "");
        com.bytedance.frameworks.baselib.network.http.a.a r38 = com.bytedance.frameworks.baselib.network.http.a.b.a().b();
        if (r38 == null) goto L64;
        r38.a(r37);
    L64:
        String r39 = r11.optString("L0_params", "");
        com.bytedance.frameworks.baselib.network.e.d.a().b(r39);
        int r113 = r11.optInt("query_filter_enabled", Integer.MIN_VALUE);
        String r40 = e.a(r41, r11, new String[]{"data", "query_filter_actions"});
        if (r113 == Integer.MIN_VALUE) goto L71;
        com.bytedance.frameworks.baselib.network.e.d r44 = com.bytedance.frameworks.baselib.network.e.d.a();
        if (r113 <= 0) goto L69;
        boolean r46 = true;
    L70:
        r44.a(r46);
        com.bytedance.frameworks.baselib.network.e.d.a().a(r40);
        goto L71
    L69:
        r46 = false;
    L71:
        this.L = r11.optInt("disable_encrypt_switch", 0);
        this.F = r11.optString("cronet_so_path", "");
        if (this.L != 2) goto L74;
        int r114 = 0;
        SharedPreferences.Editor r47 = this.l.getSharedPreferences("app_log_encrypt_switch_count", 0).edit();
        r47.putInt("app_log_encrypt_faild_count", 0);
        com.bytedance.common.utility.persistent.a.a(r47);
    L75:
        int r48 = r11.optInt("disable_framed_transport", r114);
        if (r48 > 0) goto L160;
    L81:
        int r49 = r11.optInt("pp_force_use_shared_stream", r114);
        if (r49 < 1) goto L84;
        boolean r210 = true;
    L85:
        com.bytedance.frameworks.baselib.network.http.g.f(r210);
        monitor-enter(this);
        SharedPreferences r115 = this.l.getSharedPreferences("ss_app_config", 0);     // Catch: Throwable -> L148
        String r50 = r115.getString("share_cookie_host_list", "");     // Catch: Throwable -> L148
        SharedPreferences.Editor r116 = r115.edit();     // Catch: Throwable -> L148
        r116.putString("ttnet_response_verify", r32.f11528b);     // Catch: Throwable -> L148
        r116.putInt("ttnet_response_verify_enabled", r32.f11527a);     // Catch: Throwable -> L148
        com.bytedance.frameworks.baselib.network.http.f.f.a(r116);     // Catch: Throwable -> L148
        com.bytedance.frameworks.baselib.network.http.cronet.b.i.a(r116);     // Catch: Throwable -> L148
        r116.putInt("ok_http_open", r6);     // Catch: Throwable -> L148
        r116.putInt("ok_http3_open", r7);     // Catch: Throwable -> L148
        r116.putInt("cronet_version", r8);     // Catch: Throwable -> L148
        r116.putInt("http_dns_enabled", r10);     // Catch: Throwable -> L148
        r116.putInt("detect_open", r12);     // Catch: Throwable -> L148
        r116.putInt("detect_native_page", r13);     // Catch: Throwable -> L148
        r116.putInt("collect_recent_page_info_enable", r14);     // Catch: Throwable -> L148
        r116.putInt("add_ss_queries_open", r2);     // Catch: Throwable -> L148
        r116.putInt("add_ss_queries_header_open", r15);     // Catch: Throwable -> L148
        r116.putInt("add_ss_queries_plaintext_open", r4);     // Catch: Throwable -> L148
        r116.putInt("add_device_fingerprint_open", r112);     // Catch: Throwable -> L148
        r116.putInt("dynamic_adjust_threadpool_size_open", r18);     // Catch: Throwable -> L148
        r116.putInt("image_ttnet_enabled", r3);     // Catch: Throwable -> L148
        r116.putInt("use_http_dns", f11246J);     // Catch: Throwable -> L148
        r116.putInt("use_http_dns_refetch_on_expire", K);     // Catch: Throwable -> L148
        r116.putInt("http_show_hijack", r19);     // Catch: Throwable -> L148
        r116.putInt("http_verify_sign", r20);     // Catch: Throwable -> L148
        r116.putInt("crash_limit_times", r27);     // Catch: Throwable -> L148
        r116.putInt("crash_detect_interval_ms", r28);     // Catch: Throwable -> L148
        r116.putString(WsConstants.KEY_FRONTIER_URLS, r33);     // Catch: Throwable -> L148
        r116.putString("cronet_so_path", this.F);     // Catch: Throwable -> L148
        r116.putString("share_cookie_host_list", r34);     // Catch: Throwable -> L148
        r9.put("oldShareCookieHosts", r50);     // Catch: Throwable -> L148
        r9.put("newShareCookieHosts", r34);     // Catch: Throwable -> L148
        if (TextUtils.isEmpty(r34) == true) goto L90;
        this.G.clear();     // Catch: Throwable -> L148
        com.bytedance.ttnet.utils.e.b(r34, this.G);     // Catch: Throwable -> L148
    L90:
        u();     // Catch: Throwable -> L148
        r116.putString("api_http_host_list", r35);     // Catch: Throwable -> L148
        r116.putString("concurrent_request_config", r36);     // Catch: Throwable -> L148
        r116.putString("add_common_params", r37);     // Catch: Throwable -> L148
        r116.putString("query_filter_actions", r40);     // Catch: Throwable -> L148
        r116.putString("L0_params", r39);     // Catch: Throwable -> L148
        int r117 = r113;
        r116.putInt("query_filter_enabled", r117);     // Catch: Throwable -> L148
        String[] r51 = r35.split(",");     // Catch: Throwable -> L148
        int r118 = r51.length;     // Catch: Throwable -> L148
        int r119 = 0;
    L91:
        if (r119 >= r118) goto L99;
        int r120 = r118;
        String r121 = r51[r119];     // Catch: Throwable -> L148
        if (com.bytedance.common.utility.j.a(r121) == true) goto L97;
        String[] r122 = r51;
        if (com.bytedance.ttnet.utils.e.a(r121, this.I) == true) goto L98;
        this.I.add(r121.trim());     // Catch: Throwable -> L148
    L98:
        r119 = r119 + 1;     // Catch: Throwable -> L148
        r118 = r120;
        r51 = r122;
        goto L91
    L97:
        r122 = r51;
        goto L98
    L99:
        r116.putInt("android_log_encrypt_switch", this.L);     // Catch: Throwable -> L148
        r116.putInt("image_ttnet_enabled", this.A);     // Catch: Throwable -> L148
        r116.putInt("sample_band_width_enabled", this.B);     // Catch: Throwable -> L148
        r116.putInt("cdn_sample_band_width_enabled", this.C);     // Catch: Throwable -> L148
        r116.putInt("disable_framed_transport", r48);     // Catch: Throwable -> L148
        r116.putInt("tnc_update_interval", this.P.get());     // Catch: Throwable -> L148
        int r123 = r22;
        r116.putInt("private_protocol_enabled", r123);     // Catch: Throwable -> L148
        r116.putInt("destroy_delta_millis", r110);     // Catch: Throwable -> L148
        r116.putInt("disable_rotating_host_path_retry", r111);     // Catch: Throwable -> L148
        r116.putInt("pp_force_use_shared_stream", r49);     // Catch: Throwable -> L148
        StringBuilder r52 = new StringBuilder();     // Catch: Throwable -> L148
        int r53 = 0;
    L101:
        if (r53 >= this.Q.size()) goto L106;
        int r124 = r123;
        int r310 = r117;
        r52.append((String) ZeusTransformUtils.preCheckCast(this.Q.get(r53), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L148
        if (r53 == this.Q.size()) goto L105;
        r52.append(',');     // Catch: Throwable -> L148
    L105:
        r53 = r53 + 1;     // Catch: Throwable -> L148
        r123 = r124;
        r117 = r310;
        goto L101
    L106:
        int r311 = r117;
        int r125 = r123;
        String r54 = r52.toString();     // Catch: Throwable -> L148
        if (TextUtils.isEmpty(r54) == true) goto L110;
        r116.putString("send_tnc_host_arrays", r54);     // Catch: Throwable -> L148
    L110:
        if (TextUtils.isEmpty(this.O) == true) goto L112;
        r116.putString("tnc_summary", this.O);     // Catch: Throwable -> L148
    L112:
        com.bytedance.common.utility.persistent.a.a(r116);     // Catch: Throwable -> L148
        LinkedHashMap r55 = new LinkedHashMap();     // Catch: Throwable -> L123
        if (com.bytedance.common.utility.j.a(r33) == false) goto L116;
    L118:
        r55.put("http_dns_enabled", Integer.valueOf(r10));     // Catch: Throwable -> L123
        r55.put("add_ss_queries_open", Integer.valueOf(r2));     // Catch: Throwable -> L123
        r55.put("add_ss_queries_header_open", Integer.valueOf(r15));     // Catch: Throwable -> L123
        r55.put("add_ss_queries_plaintext_open", Integer.valueOf(r4));     // Catch: Throwable -> L123
        r55.put("share_cookie_host_list", r34);     // Catch: Throwable -> L123
        r55.put("disable_framed_transport", Integer.valueOf(r48));     // Catch: Throwable -> L123
        r55.put("query_filter_actions", r40);     // Catch: Throwable -> L123
        r55.put("L0_params", r39);     // Catch: Throwable -> L123
        r55.put("query_filter_enabled", Integer.valueOf(r311));     // Catch: Throwable -> L123
        r55.put("private_protocol_enabled", Integer.valueOf(r125));     // Catch: Throwable -> L123
        r55.put("disable_rotating_host_path_retry", Integer.valueOf(r111));     // Catch: Throwable -> L123
        r55.put("pp_force_use_shared_stream", Integer.valueOf(r49));     // Catch: Throwable -> L123
        TTNetInit.getTTNetDepend().a(this.l, r55);     // Catch: Throwable -> L123
        Intent r56 = new Intent("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG");     // Catch: Throwable -> L123
        if (TextUtils.isEmpty(h) == true) goto L121;
        r56.setPackage(h);     // Catch: Throwable -> L123
    L121:
        this.l.sendBroadcast(r56);     // Catch: Throwable -> L123
    L125:
        monitor-exit(this);     // Catch: Throwable -> L148
        if (com.bytedance.common.utility.j.a(r34) == true) goto L130;
        h.a().a(r50, r34);
    L130:
        if (d.a() == null) goto L132;
        JSONObject r57 = r11;
        d.a().a(r57);
    L134:
        if (com.bytedance.ttnet.tnc.c.c().e() != null) goto L136;
        boolean r58 = true;
    L146:
        a(r9, "return true");
        return r58;
    L136:
        if (e.b() == true) goto L138;
    L142:
        JSONObject r126 = r57;
        r58 = true;
        com.bytedance.ttnet.tnc.c.c().e().a(r126, r42, this.M, "", r43);
    L143:
        if (r45 == false) goto L146;
        com.bytedance.frameworks.baselib.network.http.h.b.a().b();
        goto L146
    L138:
        if (ZeusTransformUtils.instanceOf(r41, e.b.class) == false) goto L142;
        if (c.b() == false) goto L142;
        com.bytedance.ttnet.tnc.c.c().e().a(r41, r42, this.M, "", r43);
        r58 = true;
        goto L143
    L132:
        r57 = r11;
        goto L134
    L116:
        if (r33.equals(n) == true) goto L118;
        n = r33;     // Catch: Throwable -> L123
        r55.put(WsConstants.KEY_FRONTIER_URLS, r33);     // Catch: Throwable -> L123
    L123:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L148
    L148:
        th = move-exception;
        throw th;
    L84:
        r210 = false;
        goto L85
    L160:
        com.bytedance.frameworks.baselib.network.http.ok3.impl.i.a(r48);     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        th.printStackTrace();
        goto L81
    L74:
        r114 = 0;
        goto L75
    L59:
        if (this.y <= 0) goto L61;
    L55:
        r31 = false;
        goto L56
    L51:
        r30 = false;
    L151:
        th = move-exception;
        throw th;
    L44:
        r29 = r16;
        goto L45
    L32:
        r24 = false;
        goto L33
    L25:
        r23 = false;
        goto L26
    L10:
        if (ZeusTransformUtils.instanceOf(r41, JSONObject.class) == false) goto L13;
        r5 = (JSONObject) ZeusTransformUtils.preCheckCast(r41, JSONObject.class, "com.obric.aiagent.plugin");
        goto L16
    L13:
        if (ZeusTransformUtils.instanceOf(r41, e.b.class) == false) goto L15;
        r5 = ((e.b) ZeusTransformUtils.preCheckCast(r41, e.b.class, "com.obric.aiagent.plugin")).b();
        goto L16
    L15:
        r5 = null;
        goto L16
    }

    public String n() {
        return this.F;
    }

    @Override // com.bytedance.frameworks.baselib.network.connectionclass.a.b
    public void a(com.bytedance.frameworks.baselib.network.connectionclass.b r2) {
        if (Logger.debug() == false) goto L7;
        if (r2 == null) goto L8;
        Logger.d("AppConfig", "onBandwidthStateChange bandwidthState = " + r2);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.g.j
    public List<String> a(CookieManager r5, com.bytedance.frameworks.baselib.network.http.d.b r6, URI r7) {
        if (r7 == null) goto L34;
        if (r5 != null) goto L7;
        if (r6 == null) goto L34;
    L7:
        String r1 = TTNetInit.getTTNetDepend().d();
        if (com.bytedance.common.utility.j.a(r1) == false) goto L35;
        return null;
    L35:
        String r2 = r7.getHost();     // Catch: Exception -> L12
    L14:
        if (com.bytedance.common.utility.j.a(r2) == true) goto L34;
        if (com.bytedance.ttnet.utils.e.a(r2, this.G) == false) goto L34;
        ArrayList r4 = new ArrayList();
        if (r5 == null) goto L25;
        String r8 = r5.getCookie(r7.getScheme() + "://" + r1);
        if (com.bytedance.common.utility.j.a(r8) == true) goto L25;
        r4.add(r8);
        return r4;
    L25:
        if (com.bytedance.common.utility.f.a(r4) == false) goto L33;
        if (r6 == null) goto L33;
        String r9 = r6.a(URI.create(r7.getScheme() + "://" + r1));     // Catch: Throwable -> L31
        if (com.bytedance.common.utility.j.a(r9) == true) goto L33;
        r4.add(r9);     // Catch: Throwable -> L31
        r4.add("x-tt-cookie-backup-source=1");     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.printStackTrace();
    L33:
        return r4;
    L12:
        r2 = null;
    L34:
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.g.j
    public List<String> b(String r2) {
        if (com.bytedance.ttnet.utils.e.a(r2, this.G) == true) goto L5;
        return null;
    L5:
        return this.G;
    }

    public void c(String r1) {
        this.M = r1;
    }

    public void d(String r2) {
        this.N = com.bytedance.frameworks.baselib.network.http.b.b(r2);
        com.bytedance.ttnet.tnc.c.c().e().a(r2);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.b.i.d
    public JSONObject c() {
        return this.N;
    }

    public List<String> o() {
        return this.Q;
    }

    public String p() {
        return this.O;
    }

    private void u() {
        String r0 = TTNetInit.getTTNetDepend().d();
        if (com.bytedance.common.utility.j.a(r0) == false) goto L5;
        return;
    L5:
        if (com.bytedance.ttnet.utils.e.a(r0, this.G) == true) goto L9;
        this.G.add(r0);
        return;
    }
}
