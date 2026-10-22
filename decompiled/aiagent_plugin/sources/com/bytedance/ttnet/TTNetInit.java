package com.bytedance.ttnet;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.LifeCycleMonitor;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.b.i;
import com.bytedance.frameworks.baselib.network.http.cronet.b.k;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.b.m;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.r;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.retrofit2.ae;
import com.bytedance.retrofit2.af;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UnknownFormatConversionException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTNetInit {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String DOMAIN_BOE_HTTPS_KEY = "boe_https";
    public static final String DOMAIN_BOE_KEY = "boe";
    public static final String DOMAIN_HTTPDNS_KEY = "httpdns";

    @Deprecated
    public static final String DOMAIN_NETLOG_KEY = "netlog";
    private static final String ENCRYPT_RETRY_HEADER = "x-ttnet-retry-encrypt";
    public static final String ENCRYPT_RETRY_VERIFY_HEADER = "x-tt-e-ignore-status-code-verify";
    private static final int INIT_TIMEOUT_VALUE = 5;
    private static final String OKHTTP_DISPATCH_FAILED = "okhttp dispatch failed.";
    private static final String RETURN_WRONG_FORMAT = "Conversion = 'ttUrlDispatch returns wrong format'";
    private static final String TAG = "TTNetInit";
    private static final String TTNET_CRONET_NOT_INITIALIZED = "cronet not init.";
    private static volatile a env;
    private static volatile boolean sApiHttpInterceptEnabled;
    private static volatile int sAppSecurityLevel;
    private static volatile String sClientIPString;
    public static ICronetAppProvider sCronetProvider;
    public static Map<String, String> sGetDomainRegionMap;
    private static d sITTNetDepend;
    private static volatile CountDownLatch sLatchInitCompleted;
    public static LifeCycleMonitor sLifeCycleMonitor;
    private static volatile boolean sListenAppStateIndependently;
    private static volatile long sMaxHttpDiskCacheSize;
    private static volatile boolean sNotifiedColdStartFinsish;
    private static volatile List<String> sPublicIPv4List;
    private static volatile List<String> sPublicIPv6List;
    public static JSONObject sSlaSamplingSettingObject;
    private static volatile boolean sStateDelayNewStrategyEnabled;
    private static e sSystemApiSandbox;
    private static g sTTNetThreadConfigInfoManager;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11229a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f11230b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ a[] f11231c = null;

        static {
            a r0 = new a("DEBUG", 0);
            f11229a = r0;
            a r1 = new a("RELEASE", 1);
            f11230b = r1;
            f11231c = new a[]{r0, r1};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f11231c.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    public interface b {
        void a(String r1, List<com.bytedance.retrofit2.b.b> r2, Map<String, List<String>> r3);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.d(r0, r1);
    }

    @Deprecated
    public static void doCommand(Context r1, String r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public static void enableCookieLogReport(boolean r0) {
    }

    @Deprecated
    public static void setALogFuncAddr(long r0) {
    }

    @Deprecated
    public static void setCookieHandler(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public static void setDelayTime(int r0) {
    }

    @Deprecated
    public static void setEnableURLDispatcher(boolean r0) {
    }

    @Deprecated
    public static void setFirstRequestWaitTime(long r0) {
    }

    public static void setHttpDnsForTesting(boolean r0, boolean r1, boolean r2) {
    }

    @Deprecated
    public static void setMainThreadInitCookieEnabled(boolean r0) {
    }

    @Deprecated
    private static void tryInitCookieManager(Context r0, boolean r1, boolean r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r0, Context.class, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public static boolean urlDispatchEnabled() {
        return true;
    }

    public TTNetInit() {
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    static /* synthetic */ boolean access$100() {
        return sStateDelayNewStrategyEnabled;
    }

    static /* synthetic */ void access$200(Context r2, boolean r3, boolean r4) {
        initCookie((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    static /* synthetic */ void access$300() {
        setCookieInitCompleted();
    }

    static {
        sLatchInitCompleted = new CountDownLatch(1);
        sApiHttpInterceptEnabled = false;
        sListenAppStateIndependently = false;
        sStateDelayNewStrategyEnabled = false;
        sMaxHttpDiskCacheSize = 67108864;
        sAppSecurityLevel = 0;
        sLifeCycleMonitor = new LifeCycleMonitor();
        TTALog.init();
        env = a.f11230b;
        sNotifiedColdStartFinsish = false;
        sClientIPString = "";
    }

    public static a getEnv() {
        return env;
    }

    public static void setEnv(a r0) {
        env = r0;
    }

    public static void setListenAppStateIndependently(boolean r0) {
        sListenAppStateIndependently = r0;
    }

    public static boolean getListenAppStateIndependently() {
        return sListenAppStateIndependently;
    }

    public static void setMaxHttpDiskCacheSize(long r2) {
        if (r2 <= 0) goto L6;
        sMaxHttpDiskCacheSize = r2;
        return;
    }

    public static long getMaxHttpDiskCacheSize() {
        return sMaxHttpDiskCacheSize;
    }

    public static void setAppSecurityLevel(int r0) {
        sAppSecurityLevel = r0;
    }

    public static int getAppSecurityLevel() {
        return sAppSecurityLevel;
    }

    public static void setTTNetDepend(d r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        sITTNetDepend = r8;
        Map<String, String> r0 = getTTNetDepend().h();
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r0.get(DOMAIN_HTTPDNS_KEY), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        sITTNetDepend = null;
        throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
    L13:
        if (ZeusTransformUtils.instanceOf(sITTNetDepend, com.bytedance.ttnet.a.class) == false) goto L18;
        if (((com.bytedance.ttnet.a) ZeusTransformUtils.preCheckCast(sITTNetDepend, com.bytedance.ttnet.a.class, "com.obric.aiagent.plugin")).f() == true) goto L18;
        setAppSecurityLevel(sAppSecurityLevel | 1);
    L18:
        if (ZeusTransformUtils.instanceOf(sITTNetDepend, com.bytedance.retrofit2.b.class) == false) goto L20;
        af.f9430a = (com.bytedance.retrofit2.b) ZeusTransformUtils.preCheckCast(sITTNetDepend, com.bytedance.retrofit2.b.class, "com.obric.aiagent.plugin");
    L20:
        com.bytedance.ttnet.d.b.b();
        com.bytedance.frameworks.baselib.network.http.i.c.b((String) ZeusTransformUtils.preCheckCast(r0.get(DOMAIN_BOE_KEY), String.class, "com.obric.aiagent.plugin"));
        com.bytedance.frameworks.baselib.network.http.i.c.c((String) ZeusTransformUtils.preCheckCast(r0.get(DOMAIN_BOE_HTTPS_KEY), String.class, "com.obric.aiagent.plugin"));
        com.bytedance.ttnet.f.a.f().a(r8);
        return;
    L5:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r0.get(DOMAIN_BOE_KEY), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L7;
    L9:
        r2 = false;
        goto L11
    L7:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r0.get(DOMAIN_BOE_HTTPS_KEY), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L9;
        goto L9
    }

    public static void setTTNetThreadConfigInfoManager(g r0) {
        sTTNetThreadConfigInfoManager = r0;
    }

    public static List<com.bytedance.frameworks.baselib.network.http.cronet.d> getThreadConfigInfoList() {
        g r0 = sTTNetThreadConfigInfoManager;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public static com.bytedance.frameworks.baselib.network.http.cronet.d.a getThreadConfigCallbackImpl() {
        g r0 = sTTNetThreadConfigInfoManager;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    public static d getTTNetDepend() {
        d r0 = sITTNetDepend;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("sITTNetDepend is null");
    }

    public static void setCronetDepend(ICronetAppProvider r2) {
        ICronetAppProvider r3 = (ICronetAppProvider) ZeusTransformUtils.wrapperContextForParams(r2, ICronetAppProvider.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        sCronetProvider = r3;
        com.bytedance.ttnet.tnc.c.a(r3);
        com.bytedance.ttnet.f.a.f().a(r3);
        i.a(r3);
        r.a(com.bytedance.ttnet.f.a.f());
        return;
    L7:
        throw new IllegalArgumentException("cronetDepend is null");
    }

    public static ICronetAppProvider getCronetProvider() {
        return sCronetProvider;
    }

    public static void setSystemApiSandbox(e r2) {
        sSystemApiSandbox = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
    }

    public static e getSystemApiSandbox() {
        return sSystemApiSandbox;
    }

    public static void setGetDomainRegionMap(Map<String, String> r2) {
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        sGetDomainRegionMap = r3;
        return;
    L7:
        throw new IllegalArgumentException("getDomainRegionMap is null");
    }

    public static String getGetDomainConfigByRegion(String r2) {
        Map<String, String> r0 = sGetDomainRegionMap;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return null;
    L7:
        if (sCronetProvider != null) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r2) == false) goto L12;
        return null;
    L12:
        return (String) ZeusTransformUtils.preCheckCast(sGetDomainRegionMap.get(r2.toLowerCase()), String.class, "com.obric.aiagent.plugin");
    }

    public static void setSlaSamplingSetting(Context r2, JSONObject r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
    L8:
        e = move-exception;
        e.printStackTrace();
        sSlaSamplingSettingObject = r3;
        return;
    L4:
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "setSlaSamplingSetting");     // Catch: Exception -> L8
    L6:
        i.a(r4).a(r3);     // Catch: Exception -> L8
    }

    public static JSONObject getSlaSamplingSetting() {
        return sSlaSamplingSettingObject;
    }

    public static void setStateDelayNewStrategyEnabled(boolean r0) {
        sStateDelayNewStrategyEnabled = r0;
    }

    public static boolean getStateDelayNewStrategyEnabled() {
        return sStateDelayNewStrategyEnabled;
    }

    public static void getInitCompletedLatch() {
        sLatchInitCompleted.await(5, TimeUnit.SECONDS);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
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

    public static void tryInitTTNet(Context r2, Application r3, com.bytedance.frameworks.baselib.network.http.g.d<com.bytedance.ttnet.d.b> r4, com.bytedance.frameworks.baselib.network.http.g.l<com.bytedance.ttnet.d.b> r5, com.bytedance.frameworks.baselib.network.http.g.h r6, boolean r7, boolean... r8) {
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Application r10 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        com.bytedance.frameworks.baselib.network.http.g.d r11 = (com.bytedance.frameworks.baselib.network.http.g.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.frameworks.baselib.network.http.g.d.class, "com.obric.aiagent.plugin");
        com.bytedance.frameworks.baselib.network.http.g.l r12 = (com.bytedance.frameworks.baselib.network.http.g.l) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.frameworks.baselib.network.http.g.l.class, "com.obric.aiagent.plugin");
        com.bytedance.frameworks.baselib.network.http.g.h r13 = (com.bytedance.frameworks.baselib.network.http.g.h) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.frameworks.baselib.network.http.g.h.class, "com.obric.aiagent.plugin");
        com.bytedance.frameworks.baselib.network.c.c().f7999e = System.currentTimeMillis();
        com.bytedance.frameworks.baselib.network.c.c().f = System.nanoTime();
        if (r9 == null) goto L41;
        com.bytedance.ttnet.a.g.a();
        com.bytedance.ttnet.c.a.a(r9);
        ae.a(Logger.getLogLevel());
        com.bytedance.frameworks.baselib.network.http.g.a(r11);
        com.bytedance.ttnet.d.b.b();
        com.bytedance.frameworks.baselib.network.http.cronet.a.a(new AnonymousClass1());     // Catch: Throwable -> L7
    L9:
        KevaBuilder.getInstance().setContext(r9);
        if (r8 != null) goto L12;
    L14:
        boolean r14 = false;
    L15:
        boolean r15 = com.bytedance.frameworks.baselib.network.http.i.h.b(r9);
        if (r15 == false) goto L18;
        final String r0 = "NetWork-AsyncInit";
        new AnonymousClass2(r0, r9).a();
    L25:
        f.a();
        com.bytedance.ttnet.tnc.c.c().a(r9, r15);
        l.a().a(r9);
        com.bytedance.ttnet.a.a.a(r9);
        com.bytedance.frameworks.baselib.network.c.c().a(r9);
        com.bytedance.frameworks.baselib.network.http.g.a(r12);
        countDownInitCompletedLatch();
        if (r15 == true) goto L29;
        com.bytedance.frameworks.baselib.network.c.c().f7997c = false;
        com.bytedance.frameworks.baselib.network.c.c().i = System.nanoTime();
        return;
    L29:
        com.bytedance.frameworks.baselib.network.http.g.a(r13);
        if (com.bytedance.ttnet.utils.c.a() != null) goto L32;
        com.bytedance.ttnet.utils.c.a(new AnonymousClass4(r9));
    L32:
        sLifeCycleMonitor.addListener(com.bytedance.frameworks.baselib.network.e.e.e());
        if (r10 == null) goto L36;
        r10.registerActivityLifecycleCallbacks(sLifeCycleMonitor);
    L36:
        if (c.b() == true) goto L38;
        INVOKESTATIC_com_bytedance_ttnet_TTNetInit_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("TTNetInit", "cronet disable");
        notifyColdStartFinish();
    L38:
        com.bytedance.frameworks.baselib.network.c.c().i = System.nanoTime();
        return;
    L18:
        if (r14 == false) goto L20;
    L23:
        final boolean r16 = true;
    L24:
        final String r1 = "NetWork-AsyncInit-other";
        new AnonymousClass3(r1, r9, r16).a();
        goto L25
    L20:
        if (com.bytedance.frameworks.baselib.network.http.i.h.a(r9) == true) goto L23;
        r16 = false;
        goto L24
    L12:
        if (r8.length <= 0) goto L14;
        r14 = r8[0];
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    L41:
        throw new IllegalArgumentException("tryInitTTNet context is null");
    }

    public static void setMonitorProcessHookV2(com.bytedance.frameworks.baselib.network.http.g.m<com.bytedance.ttnet.d.b> r2) {
        com.bytedance.frameworks.baselib.network.http.g.a((com.bytedance.frameworks.baselib.network.http.g.m) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.frameworks.baselib.network.http.g.m.class, "com.obric.aiagent.plugin"));
    }

    public static void notifyColdStartFinish() {
        if (sITTNetDepend != null) goto L5;
        return;
    L5:
        if (sNotifiedColdStartFinsish == true) goto L9;
        sNotifiedColdStartFinsish = true;
        sITTNetDepend.e();
        return;
    }

    public static void onClientIPChanged(String r0) {
        if (r0 == null) goto L5;
        sClientIPString = r0;
        return;
    }

    public static String getClientIpString() {
        return sClientIPString;
    }

    public static void onPublicIPsChanged(List<String> r2, List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        sPublicIPv4List = r4;
        sPublicIPv6List = r5;
    }

    public static void setRetryEncryptedRequestEnabled(b r2) {
        final b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        com.bytedance.frameworks.baselib.network.http.g.a(ENCRYPT_RETRY_VERIFY_HEADER, new AnonymousClass5(r3));
    }

    public static List<String> getPublicIPv4List() {
        return sPublicIPv4List;
    }

    public static List<String> getPublicIPv6List() {
        return sPublicIPv6List;
    }

    public static void trySetDefaultUserAgent(String r0) {
        com.bytedance.frameworks.baselib.network.http.g.b(r0);
    }

    @Deprecated
    public static void useCustomizedCookieStoreName() {
        com.bytedance.frameworks.baselib.network.http.b.g.b();
    }

    public static void triggerGetDomain(Context r2, boolean r3) {
        i.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).b(r3);
    }

    public static void trigerGetDomain(Context r2) {
        triggerGetDomain((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), false);
    }

    public static void runInBackGround(Context r2, boolean r3) {
        i.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).c(r3);
    }

    public static void addClientOpaqueData(Context r10, String[] r11, byte[] r12, byte[] r13, long r14, long r16) {
        i.a((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin")).a(r11, r12, r13, r14, r16, false);
    }

    public static void addClientOpaqueData(Context r9, String[] r10, byte[] r11, byte[] r12) {
        i.a((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin")).a(r10, r11, r12, 0, 0, false);
    }

    public static void clearClientOpaqueData(Context r2) {
        i.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).d(false);
    }

    public static void removeClientOpaqueData(Context r2, String r3) {
        i.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).a(r3, false);
    }

    public static void addClientOpaqueDataV1(Context r10, String[] r11, byte[] r12, byte[] r13, long r14, long r16) {
        i.a((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin")).a(r11, r12, r13, r14, r16, true);
    }

    public static void addClientOpaqueDataV1(Context r9, String[] r10, byte[] r11, byte[] r12) {
        i.a((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin")).a(r10, r11, r12, 0, 0, true);
    }

    public static void clearClientOpaqueDataV1(Context r2) {
        i.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).d(true);
    }

    public static void removeClientOpaqueDataV1(Context r2, String r3) {
        i.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).a(r3, true);
    }

    public static void setProxy(String r3) {
        if (com.bytedance.frameworks.baselib.network.c.a() == false) goto L5;
        i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).c(r3);
        return;
    L5:
        r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r.c(r3);
    }

    @Deprecated
    public static List<InetAddress> dnsLookup(String r5) {
        if (com.bytedance.frameworks.baselib.network.c.a() == false) goto L24;
        com.bytedance.ttnet.e.c r0 = TTDnsResolve(r5, 0);
        if (r0.f11428a != 0) goto L22;
        if (r0.f11431d == null) goto L22;
        if (r0.f11431d.isEmpty() == true) goto L22;
        ArrayList r1 = new ArrayList();
        Iterator<String> r2 = r0.f11431d.iterator();
    L12:
        if (r2.hasNext() == false) goto L17;
        byte[] r3 = InetAddress.getByName((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin")).getAddress();
        if (r3 == null) goto L12;
        r1.add(InetAddress.getByAddress(r5, r3));
        goto L12
    L17:
        if (r1.isEmpty() == true) goto L20;
        return r1;
    L20:
        throw new UnknownHostException(r5);
    L22:
        throw new UnknownHostException(r5);
    L24:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    public static com.bytedance.frameworks.baselib.network.http.cronet.b.g getNetworkQuality() {
        return i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).e();
    }

    public static com.bytedance.frameworks.baselib.network.http.cronet.b.h getPacketLossRateMetrics(int r3) {
        return i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).d(r3);
    }

    public static Map<String, com.bytedance.frameworks.baselib.network.http.cronet.b.g> getGroupRttEstimates() {
        return i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).f();
    }

    public static void preInitCronetKernel() {
        int r0 = -1;
    L7:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(th, IllegalArgumentException.class) == false) goto L11;
        r0 = 3;
    L11:
        String r2 = com.bytedance.ttnet.utils.e.a(th);
        if (r2.length() <= 1024) goto L14;
        r2 = r2.substring(0, 1024);
    L14:
        feedBackCronetInitFailedLog(r0, r2);
        com.bytedance.ttnet.tnc.c.c().f();
        throw th;
    L4:
        if (getCronetHttpClient(com.bytedance.frameworks.baselib.network.c.a.f8002c) != null) goto L18;
        r0 = r.e();     // Catch: Throwable -> L7
        feedBackCronetInitFailedLog(r0, "");     // Catch: Throwable -> L7
        return;
    }

    private static void feedBackCronetInitFailedLog(int r2, String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("fallback", r2);     // Catch: JSONException -> L13
        r0.put("exception", r3);     // Catch: JSONException -> L13
        r0.put("model", Build.MODEL);     // Catch: JSONException -> L13
        String r4 = "";
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        r4 = Build.CPU_ABI;     // Catch: JSONException -> L13
    L11:
        r0.put("abis", r4);     // Catch: JSONException -> L13
        getTTNetDepend().a("cronet_failed", r0);     // Catch: JSONException -> L13
        return;
    L6:
        String[] r5 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L13
        if (r5 == null) goto L11;
        if (r5.length <= 0) goto L11;
        r4 = Arrays.asList(r5).toString();     // Catch: JSONException -> L13
    }

    public static void forceInitCronetKernel() {
        if (com.bytedance.frameworks.baselib.network.c.c().f7996b != com.bytedance.frameworks.baselib.network.c.a.f8000a) goto L5;
        com.bytedance.frameworks.baselib.network.c r0 = com.bytedance.frameworks.baselib.network.c.c();
        r0.f7996b = com.bytedance.frameworks.baselib.network.c.a.f8003d;
    L5:
        i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(false, false, false, com.bytedance.ttnet.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).b(), true, sCronetProvider);
    }

    @Deprecated
    public static void setHostResolverRulesForTesting(String r1) {
        i r0 = getCronetHttpClient(com.bytedance.frameworks.baselib.network.c.a.f8004e);
        if (r0 == null) goto L6;
        r0.d(r1);
        return;
    }

    public static boolean tryStartTTNetDetect(String[] r4, int r5, int r6) {
        if (r4 != null) goto L5;
    L16:
        return false;
    L5:
        if (r4.length <= 0) goto L16;
        if (r5 <= 0) goto L16;
        if (r5 > 180) goto L16;
        if (r6 < 0) goto L16;
        i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(r4, r5, r6);     // Catch: Throwable -> L14
        return true;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    }

    public static com.bytedance.ttnet.e.c TTDnsResolve(String r1, int r2) {
        return TTDnsResolve(r1, r2, null);
    }

    public static com.bytedance.ttnet.e.c TTDnsResolve(String r2, int r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (com.bytedance.frameworks.baselib.network.c.a() == false) goto L7;
        return com.bytedance.ttnet.e.a.a().a(r2, r3, r5);
    L7:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    public static void getMappingRequestState(String r3) {
        i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).b(r3);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static void setBypassOfflineCheck(boolean r0) {
        i.a(r0);
    }

    @Deprecated
    public static long getALogFuncAddr() {
        return TTALog.getALogFuncAddr();
    }

    public static void enableApiHttpIntercept(boolean r0) {
        sApiHttpInterceptEnabled = r0;
    }

    public static boolean apiHttpInterceptEnabled() {
        return sApiHttpInterceptEnabled;
    }

    public static void monitorLogSend(String r1, JSONObject r2) {
        d r0 = sITTNetDepend;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    private static i getCronetHttpClient(com.bytedance.frameworks.baselib.network.c.a r9) {
        if (com.bytedance.frameworks.baselib.network.c.c().f7996b != com.bytedance.frameworks.baselib.network.c.a.f8000a) goto L6;
        com.bytedance.frameworks.baselib.network.c.c().f7996b = r9;
    L6:
        if (c.b() == false) goto L9;
        i r10 = i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r10.a(false, true, false, com.bytedance.ttnet.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).b(), false, sCronetProvider);
        sSlaSamplingSettingObject = null;
        return r10;
    L9:
        return null;
    }

    public static void enableTTBizHttpDns(boolean r8, String r9, String r10, String r11, boolean r12, String r13) {
        if (r8 == true) goto L4;
    L17:
        i r1 = getCronetHttpClient(com.bytedance.frameworks.baselib.network.c.a.f);     // Catch: Throwable -> L14
        if (r1 == null) goto L21;
        r1.a(r8, r9, r10, r11, r12, r13);     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (TextUtils.isEmpty(r9) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r11) == false) goto L17;
    }

    public static int getEffectiveConnectionType() {
        return i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).d();
    L5:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public static k ttUrlDispatch(String r2) {
        return ttUrlDispatchInternal(r2, -1, true);
    }

    private static k ttUrlDispatchInternal(String r7, int r8, boolean r9) {
        if (com.bytedance.ttnet.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).g() == true) goto L11;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.b.e r10 = l.a().a(new m(r7, null, null));
        if (r10 == null) goto L9;
        return new k(r7, r10.f8444a, String.valueOf(l.a().c()), l.a().f(), k.a.f8245a, "");
    L9:
        throw new IllegalArgumentException(OKHTTP_DISPATCH_FAILED);
    L11:
        if (com.bytedance.frameworks.baselib.network.c.a() == false) goto L17;
        new URL(r7).toURI();     // Catch: Exception -> L14
        return i.a(r7, r8, r9);
    L14:
        e = move-exception;
        throw e;
    L17:
        throw new IllegalStateException(TTNET_CRONET_NOT_INITIALIZED);
    }

    public static k ttUrlDispatchV2(String r1, int r2) {
        return ttUrlDispatchV2(r1, r2, true);
    }

    public static k ttUrlDispatchV2(String r1, int r2, boolean r3) {
        new URL(r1).toURI();     // Catch: Exception -> L51
        return ttUrlDispatchInternal(r1, r2, r3);
    L5:
        e = move-exception;
        String r4 = e.getMessage();
        if (ZeusTransformUtils.instanceOf(e, IllegalArgumentException.class) == false) goto L13;
        if (OKHTTP_DISPATCH_FAILED.equals(r4) == false) goto L13;
        return new k(r1, k.a.g, e);
    L13:
        if (ZeusTransformUtils.instanceOf(e, IllegalStateException.class) == false) goto L19;
        if (TTNET_CRONET_NOT_INITIALIZED.equals(r4) == false) goto L19;
        return new k(r1, k.a.f8247c, e);
    L19:
        if (ZeusTransformUtils.instanceOf(e, UnsupportedOperationException.class) == false) goto L25;
        if ("CronetEngine has not been initialized.".equals(r4) == false) goto L25;
        return new k(r1, k.a.f8247c, e);
    L25:
        if (ZeusTransformUtils.instanceOf(e, IllegalStateException.class) == false) goto L31;
        if ("Engine is shut down.".equals(r4) == false) goto L31;
        return new k(r1, k.a.f8247c, e);
    L31:
        if (ZeusTransformUtils.instanceOf(e, UnknownFormatConversionException.class) == false) goto L37;
        if (RETURN_WRONG_FORMAT.equals(r4) == false) goto L37;
        return new k(r1, k.a.f, e);
    L37:
        if (ZeusTransformUtils.instanceOf(e, URISyntaxException.class) == true) goto L50;
        if (ZeusTransformUtils.instanceOf(e, MalformedURLException.class) == true) goto L50;
        if (ZeusTransformUtils.instanceOf(e, SocketTimeoutException.class) == false) goto L48;
        if ("ttnet".equals(r4) == false) goto L48;
        return new k(r1, k.a.f8248d, e);
    L48:
        return new k(r1, k.a.h, e);
    L50:
        return new k(r1, k.a.f8249e, e);
    L51:
        e = move-exception;
        return new k(r1, k.a.f8246b, e);
    }

    public static void preconnectUrl(String r1) {
        preconnectUrl(r1, null);
    }

    public static void preconnectUrl(String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (com.bytedance.frameworks.baselib.network.c.a() == false) goto L9;
        new URL(r3).toURI();     // Catch: Exception -> L6
        i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(r3, r5);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        throw e;
    L9:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    public static void setProcessFlag(int r0) {
        com.bytedance.frameworks.baselib.network.http.i.h.a(r0);
    }

    public static void setZstdFuncAddr(long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32) {
        i r1 = getCronetHttpClient(com.bytedance.frameworks.baselib.network.c.a.g);
        if (r1 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d("TTNet_ZSTD", " createDCtxAddr:" + r18 + " decompressStreamAddr:" + r20 + " freeDctxAddr:" + r22 + " isErrorAddr:" + r24 + " createDDictAddr:" + r26 + " dctxRefDDictAddr:" + r28 + " freeDDictAddr:" + r30 + " dctxResetAddr:" + r32);
    L8:
        r1.a(r18, r20, r22, r24, r26, r28, r30, r32);
    }

    private static void initCookie(Context r2, boolean r3, boolean r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.frameworks.baselib.network.http.b.a.a(r5, r3, r4, new AnonymousClass6(r5));
    }

    private static void setCookieInitCompleted() {
        i r0 = getCronetHttpClient(com.bytedance.frameworks.baselib.network.c.a.h);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.g();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void clearTNCFileBeforeStart(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L13;
        File r0 = new File(r4.getFilesDir(), "server.json");     // Catch: Throwable -> L14
        if (r0.exists() == false) goto L7;
        r0.delete();     // Catch: Throwable -> L14
    L7:
        File r1 = new File(r4.getFilesDir(), "tt_net_config.config");     // Catch: Throwable -> L14
        if (r1.exists() == false) goto L10;
        r1.delete();     // Catch: Throwable -> L14
    L10:
        clearSharedPreferencesFile(r4, com.bytedance.ttnet.a.a.q());
        clearSharedPreferencesFile(r4, "ttnet_tnc_config");
        clearSharedPreferencesFile(r4, com.bytedance.frameworks.baselib.network.http.h.b.g());
        return;
    L13:
        throw new IllegalArgumentException("context is null");
    }

    private static void clearSharedPreferencesFile(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L10;
        r4.getSharedPreferences(r3, 0).edit().clear().apply();
        return;
    }

    public static void OnAppActiviyResume() {
        com.bytedance.retrofit2.a.a();
    }

    public static void OnAppActivitySuspend() {
        com.bytedance.retrofit2.a.b();
    }

    public static void enableSsCallUseOkioReadForNoneStream(boolean r0) {
        com.bytedance.frameworks.baselib.network.http.d.a.d(r0);
    }

    public static void enableSsCallUseZeroCopyReadForNoneStream(boolean r5, int r6) {
        com.bytedance.frameworks.baselib.network.http.cronet.b.a.b(r5);
        if (r5 == false) goto L8;
        if (r6 <= 0) goto L9;
        final long r1 = ((long) r6) * 1000;
        com.bytedance.frameworks.baselib.network.a.b.a(com.bytedance.frameworks.baselib.network.a.c.f7963a).a(new AnonymousClass7(r1, r1));
        return;
    L9:
        return;
    }

    public static void enableProceedWithoutHook(boolean r0) {
        com.bytedance.retrofit2.d.c.a(r0);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_ttnet_TTNetInit_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
