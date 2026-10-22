package com.bytedance.ttnet;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.i;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedance.ttnet.tnc.TNCManager;
import com.bytedance.ttnet.utils.RequestTicketUtil;
import com.bytedanceos.common.networkv2.params.NetKey;
import java.net.CookieHandler;
import java.net.InetAddress;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import l6.h;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTNetInit {
    public static final String DOMAIN_BOE_HTTPS_KEY = "boe_https";
    public static final String DOMAIN_BOE_KEY = "boe";
    public static final String DOMAIN_HTTPDNS_KEY = "httpdns";
    public static final String DOMAIN_NETLOG_KEY = "netlog";
    private static final int INIT_TIMEOUT_VALUE = 5;
    private static volatile ENV env = null;
    private static volatile boolean sApiHttpInterceptEnabled = false;
    private static volatile String sClientIPString = null;
    private static volatile boolean sCookieLogReportEnabled = false;
    private static long sCookieManagerInitStartTime = 0;
    public static ICronetAppProvider sCronetProvider = null;
    private static volatile int sDelayTime = 10;
    public static Map<String, String> sGetDomainRegionMap;
    private static ITTNetDepend sITTNetDepend;
    private static volatile CountDownLatch sLatchInitCompleted;
    public static com.bytedance.frameworks.baselib.network.a sLifeCycleMonitor;
    private static volatile boolean sListenAppStateIndependently;
    private static volatile boolean sMainThreadInitCookieEnabled;
    private static volatile boolean sNotifiedColdStartFinsish;
    private static volatile List<String> sPublicIPv4List;
    private static volatile List<String> sPublicIPv6List;

    public static final enum ENV extends Enum<ENV> {
        private static final /* synthetic */ ENV[] $VALUES = null;
        public static final ENV DEBUG = null;
        public static final ENV RELEASE = null;

        static {
            ENV r10 = new ENV("DEBUG", 0);
            DEBUG = r10;
            ENV r11 = new ENV("RELEASE", 1);
            RELEASE = r11;
            $VALUES = new ENV[]{r10, r11};
        }

        private ENV(String r10, int r11) {
            super(r10, r11);
        }

        public static ENV valueOf(String r10) {
            return (ENV) Enum.valueOf(ENV.class, r10);
        }

        public static ENV[] values() {
            return (ENV[]) $VALUES.clone();
        }
    }

    public static class a extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f8116e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f8117f;

        public a(String r10, Context r11, boolean r12) {
            this.f8116e = r11;
            this.f8117f = r12;
            super(r10);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            l6.a.f(this.f8116e).s();
            l6.a.f(this.f8116e).u(TNCManager.TNCUpdateSource.TTSERVER, true);
            TTNetInit.access$000(this.f8116e, this.f8117f, true);
        }
    }

    public static class b extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f8118e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f8119f;

        public b(String r10, Context r11, boolean r12) {
            this.f8118e = r11;
            this.f8119f = r12;
            super(r10);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            l6.a.f(this.f8118e).s();
            TTNetInit.access$000(this.f8118e, this.f8119f, false);
            l6.a.f(this.f8118e).u(TNCManager.TNCUpdateSource.TTSERVER, true);
        }
    }

    public static class c implements RequestTicketUtil.IRequestTicketProcessor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8120a;

        public c(Context r10) {
            this.f8120a = r10;
        }

        @Override // com.bytedance.ttnet.utils.RequestTicketUtil.IRequestTicketProcessor
        public void checkReqTicket(String r10, String r11, String r12, p6.b r13) {
        }

        @Override // com.bytedance.ttnet.utils.RequestTicketUtil.IRequestTicketProcessor
        public void sendSetCookieEvent(String r10, String r11, int r12, boolean r13, JSONObject r14) {
            JSONObject r15 = new JSONObject();     // Catch: Throwable -> L4
            r15.put("url", r11);     // Catch: Throwable -> L4
            r15.put(CommonKey.KEY_VALUE, r12);     // Catch: Throwable -> L4
            r15.put("ext_value", r13 ? 1 : 0);     // Catch: Throwable -> L4
            r15.put("extraObject", r14);     // Catch: Throwable -> L4
            TTNetInit.getTTNetDepend().mobOnEvent(this.f8120a, "set_cookie", r10, r15);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public static class d implements Application.ActivityLifecycleCallbacks {
        public d() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r10, Bundle r11) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r10) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r10) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r10) {
            TTNetInit.onActivityResume(r10);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r10) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r10) {
        }
    }

    public static class e implements SSCookieHandler.ICookieEventHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8121a;

        public e(Context r10) {
            this.f8121a = r10;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler.ICookieEventHandler
        public void onEvent(String r10, String r11, JSONObject r12) {
            if (TTNetInit.cookieLogReportEnabled() == false) goto L6;
            TTNetInit.getTTNetDepend().mobOnEvent(this.f8121a, r10, r11, r12);
            return;
        }
    }

    public static class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f8123b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f8124c;

        public f(Context r10, boolean r11, boolean r12) {
            this.f8122a = r10;
            this.f8123b = r11;
            this.f8124c = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTNetInit.access$000(this.f8122a, this.f8123b, this.f8124c);
        }
    }

    public static class g extends w3.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Activity f8125e;

        public g(String r10, Activity r11) {
            this.f8125e = r11;
            super(r10);
        }

        @Override // w3.c, java.lang.Runnable
        public void run() {
            l6.a.f(this.f8125e).s();
        }
    }

    static {
        sLatchInitCompleted = new CountDownLatch(1);
        sApiHttpInterceptEnabled = false;
        sCookieLogReportEnabled = false;
        sListenAppStateIndependently = false;
        sMainThreadInitCookieEnabled = true;
        sLifeCycleMonitor = new com.bytedance.frameworks.baselib.network.a();
        TTALog.init();
        env = ENV.RELEASE;
        sNotifiedColdStartFinsish = false;
        sClientIPString = "";
        sCookieManagerInitStartTime = 0;
    }

    public TTNetInit() {
    }

    private static void CookieInitFailedReport(Context r10, String r11) {
        JSONObject r12 = new JSONObject();
        r12.put("init", "failed");     // Catch: JSONException -> L5
        r12.put("exception", r11);     // Catch: JSONException -> L5
    L7:
        getTTNetDepend().mobOnEvent(r10, "TTNET-COOKIE", "init", r12);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static q6.c TTDnsResolve(String r10, int r11) throws Exception {
        return q6.a.c().b(r10, r11);
    }

    public static /* synthetic */ void access$000(Context r10, boolean r11, boolean r12) {
        tryInitCookieManager(r10, r11, r12);
    }

    public static void addClientOpaqueData(Context r10, String[] r11, byte[] r12, byte[] r13) {
        SsCronetHttpClient.y(r10).b(r11, r12, r13);
    }

    public static boolean apiHttpInterceptEnabled() {
        return sApiHttpInterceptEnabled;
    }

    public static void clearClientOpaqueData(Context r10) {
        SsCronetHttpClient.y(r10).e();
    }

    public static boolean cookieLogReportEnabled() {
        return sCookieLogReportEnabled;
    }

    private static void countDownInitCompletedLatch() {
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (sLatchInitCompleted.getCount() <= 0) goto L11;
        sLatchInitCompleted.countDown();     // Catch: Exception -> L6
        return;
    }

    @Deprecated
    public static List<InetAddress> dnsLookup(String r10) throws Exception {
        return SsCronetHttpClient.y(getTTNetDepend().getContext()).i(r10);
    }

    @Deprecated
    public static void doCommand(Context r10, String r11) {
    }

    public static void enableApiHttpIntercept(boolean r10) {
        sApiHttpInterceptEnabled = r10;
    }

    public static void enableCookieLogReport(boolean r10) {
        sCookieLogReportEnabled = r10;
    }

    public static void enableTTBizHttpDns(boolean r10, String r11, String r12, String r13, boolean r14, String r15) {
        if (r10 == true) goto L4;
    L17:
        SsCronetHttpClient r16 = getCronetHttpClient();     // Catch: Throwable -> L14
        if (r16 == null) goto L21;
        r16.j(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r12) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r13) == false) goto L17;
    }

    private static void feedBackCronetInitFailedLog(int r10, String r11) {
        JSONObject r12 = new JSONObject();
        r12.put("fallback", r10);     // Catch: JSONException -> L10
        r12.put("exception", r11);     // Catch: JSONException -> L10
        r12.put(NetKey.MODEL, Build.MODEL);     // Catch: JSONException -> L10
        String r13 = "";
        String[] r14 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L10
        if (r14 != null) goto L6;
    L8:
        r12.put("abis", r13);     // Catch: JSONException -> L10
        getTTNetDepend().monitorLogSend("cronet_failed", r12);     // Catch: JSONException -> L10
        return;
    L6:
        if (r14.length <= 0) goto L8;
        r13 = Arrays.asList(r14).toString();     // Catch: JSONException -> L10
    }

    public static void forceInitCronetKernel() throws Exception {
        TTNetInitMetrics r10 = TTNetInitMetrics.c();
        r10.f7209a = TTNetInitMetrics.CronetInitMode.FORCE_INIT;
        SsCronetHttpClient.y(getTTNetDepend().getContext()).V(false, false, false, l6.a.f(getTTNetDepend().getContext()).isCronetHttpDnsOpen(), true);
    }

    @Deprecated
    public static long getALogFuncAddr() {
        return TTALog.getALogFuncAddr();
    }

    public static String getClientIpString() {
        return sClientIPString;
    }

    private static SsCronetHttpClient getCronetHttpClient() throws Exception {
        if (HttpClient.c() == false) goto L6;
        SsCronetHttpClient r10 = SsCronetHttpClient.y(getTTNetDepend().getContext());
        r10.V(false, true, false, l6.a.f(getTTNetDepend().getContext()).isCronetHttpDnsOpen(), false);
        return r10;
    L6:
        return null;
    }

    public static ICronetAppProvider getCronetProvider() {
        return sCronetProvider;
    }

    public static int getEffectiveConnectionType() {
        return SsCronetHttpClient.y(getTTNetDepend().getContext()).o();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public static ENV getEnv() {
        return env;
    }

    public static String getGetDomainConfigByRegion(String r10) {
        Map<String, String> r11 = sGetDomainRegionMap;
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.isEmpty() == false) goto L7;
        return null;
    L7:
        if (sCronetProvider != null) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r10) == false) goto L12;
        return null;
    L12:
        return sGetDomainRegionMap.get(r10.toLowerCase());
    }

    public static Map<String, q4.c> getGroupRttEstimates() throws Exception {
        return SsCronetHttpClient.y(getTTNetDepend().getContext()).p();
    }

    public static void getInitCompletedLatch() {
        sLatchInitCompleted.await(5, TimeUnit.SECONDS);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean getListenAppStateIndependently() {
        return sListenAppStateIndependently;
    }

    public static void getMappingRequestState(String r10) {
        SsCronetHttpClient.y(getTTNetDepend().getContext()).s(r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public static q4.c getNetworkQuality() throws Exception {
        return SsCronetHttpClient.y(getTTNetDepend().getContext()).t();
    }

    public static q4.d getPacketLossRateMetrics(int r10) throws Exception {
        return SsCronetHttpClient.y(getTTNetDepend().getContext()).u(r10);
    }

    public static List<String> getPublicIPv4List() {
        return sPublicIPv4List;
    }

    public static List<String> getPublicIPv6List() {
        return sPublicIPv6List;
    }

    public static ITTNetDepend getTTNetDepend() {
        ITTNetDepend r10 = sITTNetDepend;
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException("sITTNetDepend is null");
    }

    private static void injectOkhttp3HttpDnsDepend() {
        i.G(sITTNetDepend.getAppId(), sITTNetDepend.getTTNetServiceDomainMap().get("httpdns"), null, null);
    }

    public static boolean isPrivateApiAccessEnabled() {
        return getTTNetDepend().isPrivateApiAccessEnabled();
    }

    public static void monitorLogSend(String r10, JSONObject r11) {
        ITTNetDepend r12 = sITTNetDepend;
        if (r12 == null) goto L6;
        r12.monitorLogSend(r10, r11);
        return;
    }

    public static void notifyColdStartFinish() {
        if (sITTNetDepend != null) goto L5;
        return;
    L5:
        if (sNotifiedColdStartFinsish == true) goto L9;
        sNotifiedColdStartFinsish = true;
        sITTNetDepend.onColdStartFinish();
        return;
    }

    public static void onActivityResume(Activity r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        new g("Network-AsyncResume", r10).a();
    }

    public static void onClientIPChanged(String r10) {
        if (r10 == null) goto L5;
        sClientIPString = r10;
        return;
    }

    public static void onPublicIPsChanged(List<String> r10, List<String> r11) {
        sPublicIPv4List = r10;
        sPublicIPv6List = r11;
    }

    public static void preInitCronetKernel() throws Exception {
        TTNetInitMetrics r10 = TTNetInitMetrics.c();
        r10.f7209a = TTNetInitMetrics.CronetInitMode.PRE_INIT;
        int r11 = -1;
    L7:
        th = move-exception;
        if ((th instanceof IllegalArgumentException) == false) goto L13;
        r11 = 3;
    L13:
        String r12 = com.bytedance.ttnet.utils.c.b(th);
        if (r12.length() <= 1024) goto L16;
        r12 = r12.substring(0, 1024);
    L16:
        feedBackCronetInitFailedLog(r11, r12);
        throw th;
    L4:
        if (getCronetHttpClient() != null) goto L9;
        r11 = i.B();     // Catch: Throwable -> L7
        feedBackCronetInitFailedLog(r11, "");     // Catch: Throwable -> L7
        return;
    }

    public static void preconnectUrl(String r10) throws Exception {
        new URL(r10).toURI();
        SsCronetHttpClient.y(getTTNetDepend().getContext()).I(r10);
    }

    public static void removeClientOpaqueData(Context r10, String r11) {
        SsCronetHttpClient.y(r10).Q(r11);
    }

    @Deprecated
    public static void setALogFuncAddr(long r10) throws Exception {
    }

    public static void setBypassOfflineCheck(boolean r10) {
        SsCronetHttpClient.T(r10);
    }

    public static void setCookieHandler(Context r10) {
        CookieHandler r11 = CookieHandler.getDefault();     // Catch: Throwable -> L8
        if (r11 == null) goto L11;
        if ((r11 instanceof SSCookieHandler) == false) goto L11;
        NetworkParams.A(true);     // Catch: Throwable -> L8
        return;
    L11:
        if (sCookieManagerInitStartTime > 0) goto L23;
        NetworkParams.A(true);     // Catch: Throwable -> L8
        return;
    L23:
        CookieManager r12 = CookieManager.getInstance();     // Catch: Throwable -> L16
    L15:
        CookieManager r13 = r12;
        CookieHandler.setDefault(new SSCookieHandler(r10, sDelayTime, r13, getTTNetDepend().getCookieFlushPathList(), new e(r10)));     // Catch: Throwable -> L8
        NetworkParams.A(true);     // Catch: Throwable -> L8
        return;
    L16:
        th = move-exception;
        sDelayTime = 0;     // Catch: Throwable -> L8
        CookieInitFailedReport(r10, th.getMessage());     // Catch: Throwable -> L8
        r12 = null;
    L8:
        th = move-exception;
        CookieInitFailedReport(r10, th.getMessage());
        th.printStackTrace();
    }

    public static void setCronetDepend(ICronetAppProvider r10) {
        if (r10 == null) goto L6;
        sCronetProvider = r10;
        TNCManager.n(r10);
        return;
    L6:
        throw new IllegalArgumentException("cronetDepend is null");
    }

    public static void setDelayTime(int r10) {
        sDelayTime = r10;
    }

    @Deprecated
    public static void setEnableURLDispatcher(boolean r10) throws Exception {
    }

    public static void setEnv(ENV r10) {
        env = r10;
    }

    public static void setFirstRequestWaitTime(long r10) {
    }

    public static void setGetDomainRegionMap(Map<String, String> r10) {
        if (r10 == null) goto L6;
        sGetDomainRegionMap = r10;
        return;
    L6:
        throw new IllegalArgumentException("getDomainRegionMap is null");
    }

    public static void setHostResolverRulesForTesting(String r10) throws Exception {
        SsCronetHttpClient r11 = getCronetHttpClient();
        if (r11 == null) goto L6;
        r11.Y(r10);
        return;
    }

    public static void setHttpDnsForTesting(boolean r10, boolean r11, boolean r12) throws Exception {
    }

    public static void setListenAppStateIndependently(boolean r10) {
        sListenAppStateIndependently = r10;
    }

    public static void setMainThreadInitCookieEnabled(boolean r10) {
        sMainThreadInitCookieEnabled = r10;
    }

    public static void setProcessFlag(int r10) {
        com.bytedance.frameworks.baselib.network.http.util.f.h(r10);
    }

    public static void setProxy(String r10) throws Exception {
        SsCronetHttpClient.y(getTTNetDepend().getContext()).Z(r10);
    }

    public static void setTTNetDepend(ITTNetDepend r10) {
        sITTNetDepend = r10;
        Map<String, String> r11 = getTTNetDepend().getTTNetServiceDomainMap();
        if (TextUtils.isEmpty(r11.get("httpdns")) == false) goto L5;
    L12:
        sITTNetDepend = null;
        throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
    L5:
        if (TextUtils.isEmpty(r11.get(DOMAIN_NETLOG_KEY)) == true) goto L12;
        if (TextUtils.isEmpty(r11.get(DOMAIN_BOE_KEY)) == true) goto L9;
    L10:
        com.bytedance.frameworks.baselib.network.http.util.a.j(r11.get(DOMAIN_BOE_KEY));
        com.bytedance.frameworks.baselib.network.http.util.a.i(r11.get(DOMAIN_BOE_HTTPS_KEY));
        injectOkhttp3HttpDnsDepend();
        return;
    L9:
        if (TextUtils.isEmpty(r11.get(DOMAIN_BOE_HTTPS_KEY)) == true) goto L12;
        goto L10
    }

    public static void trigerGetDomain(Context r10) {
        triggerGetDomain(r10, false);
    }

    public static void triggerGetDomain(Context r10, boolean r11) {
        SsCronetHttpClient.y(r10).b0(r11);
    }

    private static void tryInitCookieManager(Context r10, boolean r11, boolean r12) {
        sCookieManagerInitStartTime = System.currentTimeMillis();     // Catch: Throwable -> L7
        if (r11 == false) goto L9;
        CookieSyncManager.createInstance(r10);     // Catch: Throwable -> L7
        CookieManager r13 = CookieManager.getInstance();     // Catch: Throwable -> L7
        r13.setAcceptCookie(true);     // Catch: Throwable -> L7
        setCookieHandler(r10);     // Catch: Throwable -> L7
        if (Logger.debug() == false) goto L31;
        Logger.d("Process", " CookieManager = " + r13.toString() + " pid = " + Process.myPid());     // Catch: Throwable -> L7
    L31:
    L27:
        ClientKeyManager.j().b(r12);
        return;
    L9:
        NetworkParams.A(true);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        if (com.bytedance.frameworks.baselib.network.http.util.f.e(r10) == false) goto L27;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) goto L27;
        if (sMainThreadInitCookieEnabled == false) goto L18;
        new Handler(Looper.getMainLooper()).post(new f(r10, r11, r12));
    L18:
        JSONObject r14 = new JSONObject();
        r14.put("error", th.getMessage());     // Catch: JSONException -> L21
    L23:
        ITTNetDepend r15 = sITTNetDepend;
        if (r15 == null) goto L26;
        r15.monitorLogSend("async_init_cookie_manager_fail", r14);
    L26:
        CookieInitFailedReport(r10, th.getMessage());
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }

    public static void tryInitTTNet(Context r10, Application r11, NetworkParams.ApiProcessHook<p6.b> r12, NetworkParams.MonitorProcessHook<p6.b> r13, NetworkParams.CommandListener r14, boolean r15, boolean... r16) {
        TTNetInitMetrics.c().f7212d = System.currentTimeMillis();
        if (r10 == null) goto L38;
        l6.d.a();
        n6.a.b(r10);
        f6.e.b(Logger.getLogLevel());
        NetworkParams.v(r12);
        p6.b.d();
        KevaBuilder.getInstance().setContext(r10);
        if (r16 != null) goto L7;
    L9:
        boolean r17 = false;
    L10:
        boolean r18 = com.bytedance.frameworks.baselib.network.http.util.f.e(r10);
        h.b(r10);
        if (r18 == false) goto L13;
        new a("NetWork-AsyncInit", r10, r15).a();
    L13:
        TNCManager.h().o(r10, r18);
        com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().s(r10);
        l6.a.f(r10);
        TTNetInitMetrics.c().b(r10);
        if (com.bytedance.frameworks.baselib.network.http.util.f.f(r10) == true) goto L17;
        if (r18 == true) goto L18;
        if (r17 == true) goto L17;
    L18:
        if (r18 == false) goto L20;
    L21:
        NetworkParams.D(r13);
    L22:
        countDownInitCompletedLatch();
        if (r18 == true) goto L26;
        TTNetInitMetrics.c().f7210b = false;
        TTNetInitMetrics.c().f7213e = System.currentTimeMillis();
        return;
    L26:
        NetworkParams.y(r14);
        if (RequestTicketUtil.c() != null) goto L29;
        RequestTicketUtil.f(new c(r10));
    L29:
        sLifeCycleMonitor.c(y4.e.f());
        if (r11 == null) goto L33;
        r11.registerActivityLifecycleCallbacks(sLifeCycleMonitor);
        r11.registerActivityLifecycleCallbacks(new d());
    L33:
        if (HttpClient.c() == true) goto L35;
        Log.d("TTNetInit", "cronet disable");
        notifyColdStartFinish();
    L35:
        TTNetInitMetrics.c().f7213e = System.currentTimeMillis();
        return;
    L20:
        if (com.bytedance.frameworks.baselib.network.http.util.f.g(r10) == false) goto L22;
    L17:
        new b("NetWork-AsyncInit-other", r10, r15).a();
        goto L18
    L7:
        if (r16.length <= 0) goto L9;
        r17 = r16[0];
        goto L10
    L38:
        throw new IllegalArgumentException("tryInitTTNet context is null");
    }

    public static void trySetDefaultUserAgent(String r10) {
        NetworkParams.C(r10);
    }

    public static boolean tryStartTTNetDetect(String[] r10, int r11, int r12) {
        if (r10 != null) goto L5;
    L16:
        return false;
    L5:
        if (r10.length <= 0) goto L16;
        if (r11 <= 0) goto L16;
        if (r11 > 180) goto L16;
        if (r12 < 0) goto L16;
        SsCronetHttpClient.y(getTTNetDepend().getContext()).e0(r10, r11, r12);     // Catch: Throwable -> L14
        return true;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    }

    public static q4.g ttUrlDispatch(String r10) throws Exception {
        new URL(r10).toURI();
        return SsCronetHttpClient.y(getTTNetDepend().getContext()).g0(r10);
    }

    @Deprecated
    public static boolean urlDispatchEnabled() {
        return true;
    }

    public static void useCustomizedCookieStoreName() {
        r4.d.l();
    }
}
