package org.chromium;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.io.FileUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.TTAppStateManager;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetInitMetrics;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.ttnet.TTALog;
import com.bytedance.ttnet.TTNetInit;
import com.ttnet.org.chromium.base.k;
import com.ttnet.org.chromium.net.impl.CronetUrlRequest;
import com.ttnet.org.chromium.net.impl.g;
import com.ttnet.org.chromium.net.t;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class CronetClient implements ICronetClient {
    private static final String BORINGSSL_LIBRARY_NAME = "ttboringssl";
    private static final String CRYPTO_LIBRARY_NAME = "ttcrypto";
    private static final int INVALID_THREAD_PRIORITY = 20;
    private static final String KEY_REQUEST_LOG = "request_log";
    public static final String TAG = "CronetClient";
    private static final String TTNET_ALOG_CLASS = "com.bytedance.ttnet.TTALog";
    private static final String TTNET_BOE_FLAG = "ttnet_boe.flag";
    private static final String TTNET_CACHE_DIR = "ttnet_storage/";
    private static final String TTNET_CONFIG_FILE = "ttnet_config.json";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static ICronetClient.ICronetBootFailureChecker sCronetBootFailureChecker = null;
    private static volatile com.ttnet.org.chromium.net.c sCronetEngine = null;
    private static volatile int sNetworkThreadPriority = 20;
    private static volatile t.a sRequestFinishedInfoListener;

    static {
    }

    public CronetClient() {
    }

    public static /* synthetic */ long access$000(CronetClient r10, long r11, long r12) {
        return r10.getCostTime(r11, r12);
    }

    public static void addClientOpaqueData(Context r10, String[] r11, byte[] r12, byte[] r13) {
    L8:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (f.f(r10) == true) goto L6;
        return;
    L6:
        if (d.a().loggerDebug() == false) goto L11;
        d.a().loggerD(TAG, "addClientOpaqueData start");     // Catch: Throwable -> L8
    L11:
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L18;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).f(r11, r12, r13);     // Catch: Throwable -> L8
        return;
    }

    public static void clearClientOpaqueData(Context r10) {
    L8:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (f.f(r10) == true) goto L6;
        return;
    L6:
        if (d.a().loggerDebug() == false) goto L11;
        d.a().loggerD(TAG, "clearClientOpaqueData start");     // Catch: Throwable -> L8
    L11:
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L18;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).h();     // Catch: Throwable -> L8
        return;
    }

    public static List<InetAddress> dnsLookup(String r10) throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        return ((com.ttnet.org.chromium.net.f) sCronetEngine).i(r10);
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void enableTTBizHttpDns(boolean r10, String r11, String r12, String r13, boolean r14, String r15) throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).j(r10, r11, r12, r13, r14, r15);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    private static long getALogFuncAddr() throws Exception {
        return ((Long) Reflect.on(TTALog.class.newInstance()).call("getALogFuncAddr").get()).longValue();
    }

    private long getCostTime(long r10, long r11) {
        if (r11 != (-1)) goto L5;
    L11:
        return -1;
    L5:
        if (r10 == (-1)) goto L11;
        if (r11 > r10) goto L11;
        return r10 - r11;
    }

    public static com.ttnet.org.chromium.net.c getCronetEngine() {
        if (sCronetEngine == null) goto L7;
        return sCronetEngine;
    L7:
        throw new NullPointerException("Cronet engine is null.");
    }

    private static String getDomainConfigByRegion() {
        String r10 = c.N().f();
        String r11 = c.N().E();
        String r12 = c.N().y();
        if (TextUtils.isEmpty(r10) == false) goto L10;
        if (TextUtils.isEmpty(r11) == true) goto L8;
        r10 = r11;
        goto L10
    L8:
        r10 = r12;
    L10:
        if (TextUtils.isEmpty(r10) == false) goto L15;
        return null;
    L15:
        String r13 = TTNetInit.DOMAIN_HTTPDNS_KEY;     // Catch: Exception -> L14
        return (String) Reflect.on(TTNetInit.class.newInstance()).call("getGetDomainConfigByRegion", new Class[]{String.class}, new Object[]{r10}).get();
    L14:
        return null;
    }

    public static int getEffectiveConnectionType() throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        return ((com.ttnet.org.chromium.net.f) sCronetEngine).n();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static int getEffectiveHttpRttMs() throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        return ((com.ttnet.org.chromium.net.f) sCronetEngine).o();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static int getEffectiveRxThroughputKbps() throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        return ((com.ttnet.org.chromium.net.f) sCronetEngine).p();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static int getEffectiveTransportRttMs() throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        return ((com.ttnet.org.chromium.net.f) sCronetEngine).q();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static Map<String, int[]> getGroupRTTEstimates() throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        return ((com.ttnet.org.chromium.net.f) sCronetEngine).r();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    private static boolean getListenAppStateIndependently() {
        String r10 = TTNetInit.DOMAIN_HTTPDNS_KEY;     // Catch: Exception -> L4
        return ((Boolean) Reflect.on(TTNetInit.class.newInstance()).call("getListenAppStateIndependently").get()).booleanValue();
    L4:
        return false;
    }

    public static void getMappingRequestState(final String r10) {
        CronetUrlRequest r11 = g.b(r10);     // Catch: Throwable -> L6
        if (r11 == null) goto L11;
        r11.L(new AnonymousClass2(r10));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public static int[] getNetworkQuality() throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        com.ttnet.org.chromium.net.f r10 = (com.ttnet.org.chromium.net.f) sCronetEngine;
        return new int[]{r10.v(), r10.s(), r10.m()};
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static int getNetworkQualityLevel() throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        return ((com.ttnet.org.chromium.net.f) sCronetEngine).t();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static q4.d getPacketLossRateMetrics(int r10) throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        q4.d r11 = new q4.d();
        com.ttnet.org.chromium.net.f r12 = (com.ttnet.org.chromium.net.f) sCronetEngine;
        r11.f23533a = r10;
        r11.f23534b = r12.w(r10);
        r11.f23535c = r12.x(r10);
        r11.f23536d = r12.k(r10);
        r11.f23537e = r12.l(r10);
        return r11;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    private String getProxyConfig(String r10) {
        String r11 = "";
        if (TextUtils.isEmpty(r10) == true) goto L34;
        BufferedReader r12 = null;
        File r13 = new File(r10 + TTNET_CONFIG_FILE);     // Catch: Throwable -> L16
        if (r13.exists() == false) goto L18;
        BufferedReader r14 = new BufferedReader(new FileReader(r13));     // Catch: Throwable -> L16
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L12
    L9:
        String r16 = r14.readLine();     // Catch: Throwable -> L12
        if (r16 == null) goto L14;
        r15.append(r16);     // Catch: Throwable -> L12
        goto L9
    L14:
        r11 = new JSONObject(r15.toString()).optString("ttnet_proxy", "");     // Catch: Throwable -> L12
        r12 = r14;
    L12:
        Throwable th = th;
    L39:
        th.printStackTrace();     // Catch: Throwable -> L27
        if (r14 == null) goto L34;
        r14.close();     // Catch: IOException -> L21
    L43:
    L27:
        th = move-exception;
        if (r14 != null) goto L37;
    L33:
        throw th;
    L37:
        r14.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L18:
        if (r12 == null) goto L34;
        r12.close();     // Catch: IOException -> L21
    L16:
        th = move-exception;
        r14 = null;
        th = th;
    L21:
        e = move-exception;
        e.printStackTrace();
    L34:
        return r11;
    }

    private long getTime(Date r10) {
        if (r10 != null) goto L6;
        return -1;
    L6:
        return r10.getTime();
    }

    private long getValue(Long r10) {
        if (r10 != null) goto L6;
        return -1;
    L6:
        return r10.longValue();
    }

    public static void notifyStoreRegionUpdated(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17) throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).M(r10, r11, r12, r13, r14, r15, r16, r17);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static boolean notifySwitchToMultiNetwork(boolean r10) throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).y(r10);
        return true;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void notifyTNCConfigUpdated(String r10, String r11, String r12, String r13, String r14, String r15) throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).z(r10, r11, r12, r13, r14, r15);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void preconnectUrl(String r10) throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).A(r10, 1);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void removeClientOpaqueData(Context r10, String r11) {
    L8:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (f.f(r10) == true) goto L6;
        return;
    L6:
        if (d.a().loggerDebug() == false) goto L11;
        d.a().loggerD(TAG, "removeClientOpaqueData start");     // Catch: Throwable -> L8
    L11:
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L18;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).B(r11);     // Catch: Throwable -> L8
        return;
    }

    public static void reportNetDiagnosisUserLog(String r10) throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).C(r10);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void setAlogFuncAddr(long r10) throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).D(r10);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void setAppStartUpState(int r10) throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).E(r10);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void setHostResolverRules(String r10) throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).F(r10);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void setHttpDnsForTesting(boolean r10, boolean r11, boolean r12) throws Exception {
    }

    public static void setNetworkThreadPriority(int r10) {
        sNetworkThreadPriority = r10;
    }

    public static void setProxy(String r10) throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).G(r10);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void triggerGetDomain(Context r10, boolean r11) {
    L8:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (f.f(r10) == true) goto L6;
        return;
    L6:
        if (d.a().loggerDebug() == false) goto L11;
        d.a().loggerD(TAG, "triggerGetDomain start");     // Catch: Throwable -> L8
    L11:
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L18;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).I(r11);     // Catch: Throwable -> L8
        return;
    }

    public static void triggerSwitchingToCellular() throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).H();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    private void tryCreateCronetEngine(Context r10, boolean r11, boolean r12, boolean r13, boolean r14, String r15, Executor r16, boolean r17) {
        if (sCronetEngine == null) goto L5;
        return;
    L5:
        monitor-enter(CronetClient.class);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (sCronetEngine != null) goto L134;
        if (r17 == true) goto L18;
        ICronetClient.ICronetBootFailureChecker r18 = sCronetBootFailureChecker;     // Catch: Throwable -> L16
        if (r18 == null) goto L18;
        if (r18.isCronetBootFailureExpected() == true) goto L18;
        Log.w(TAG, "isCronetBootFailureExpected return false.");     // Catch: Throwable -> L16
        throw new IllegalArgumentException("isCronetBootFailureExpected return false.");     // Catch: Throwable -> L16
    L18:
        Log.w(TAG, "CronetClient tryCreateCronetEngine");     // Catch: Throwable -> L16
        TTNetInitMetrics.c().f7217i = System.currentTimeMillis();     // Catch: Throwable -> L16
        com.ttnet.org.chromium.net.f.a r19 = new com.ttnet.org.chromium.net.f.a(r10).H(r11).D(r12).I(r13).F(r14).K(getListenAppStateIndependently()).E(0, 0).G(true);     // Catch: Throwable -> L16
        if (d.a().loggerDebug() == false) goto L22;
        r19.J();     // Catch: Throwable -> L16
    L22:
        if (sNetworkThreadPriority < (-20)) goto L27;
        if (sNetworkThreadPriority > 19) goto L27;
        r19.X(sNetworkThreadPriority);     // Catch: Throwable -> L16
    L27:
        if (c.N().P() == false) goto L30;
        r19.e(true);     // Catch: Throwable -> L16
    L30:
        if (c.N().R() == false) goto L33;
        r19.H(true);     // Catch: Throwable -> L16
    L33:
        if (c.N().Q() == false) goto L35;
        r19.D(true);     // Catch: Throwable -> L16
    L35:
        r19.M(a.c(r10));     // Catch: Throwable -> L16
        r19.Q(e.r());     // Catch: Throwable -> L16
        if (f.f(r10) == false) goto L39;
        r19.N(b.c());     // Catch: Throwable -> L16
        e.r().t(true);     // Catch: Throwable -> L16
    L39:
        if (TextUtils.isEmpty(r15) == true) goto L41;
        r19.Y(r15 + " cronet/TTNetVersion:b58f3ed1 2022-10-24 QuicVersion:b314d107 2021-11-24");     // Catch: Throwable -> L16
    L41:
        String r110 = getDomainConfigByRegion();     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r110) == false) goto L45;
        r110 = c.N().o();     // Catch: Throwable -> L16
    L45:
        if (TextUtils.isEmpty(r110) == true) goto L47;
        r19.R(r110);     // Catch: Throwable -> L16
    L47:
        ArrayList r111 = c.N().v();     // Catch: Throwable -> L16
        if (r111 != null) goto L50;
    L52:
        Map r112 = c.N().h();     // Catch: Throwable -> L16
        if (r112 != null) goto L55;
    L57:
        Map r113 = c.N().x();     // Catch: Throwable -> L16
        if (r113 != null) goto L60;
    L65:
        String r114 = "";
        r114 = r10.getCacheDir().getPath() + LibrarianImpl.Constants.SEPARATOR;     // Catch: Throwable -> L68
        r19.V(r114 + TTNET_CACHE_DIR);     // Catch: Throwable -> L68
    L71:
        if (c.N().S() == false) goto L73;
        r19.S(new AnonymousClass1(this));     // Catch: Throwable -> L16
    L73:
        String r20 = c.N().i();     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r20) == true) goto L78;
        String r21 = File.separator;     // Catch: Throwable -> L16
        String r22 = r20.substring(r20.lastIndexOf(r21) + 1);     // Catch: Throwable -> L16
        String r23 = r10.getCacheDir().getAbsolutePath();     // Catch: Throwable -> L16
        if (FileUtils.a(r20, r23, r22) == false) goto L78;
        r19.r(r23 + r21 + r22);     // Catch: Throwable -> L16
    L78:
        boolean r24 = c.N().O();     // Catch: Throwable -> L16
        if (r24 == false) goto L81;
        r19.C(true);     // Catch: Throwable -> L16
    L81:
        if (r24 == true) goto L94;
        String r25 = com.bytedance.frameworks.baselib.network.http.util.a.c(r10, TTNET_CONFIG_FILE);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r25) == true) goto L94;
        JSONObject r26 = new JSONObject(r25);     // Catch: Throwable -> L87
        String r27 = r26.optString("ttnet_proxy", "");     // Catch: Throwable -> L87
        if (TextUtils.isEmpty(r27) == true) goto L89;
        r19.U(r27);     // Catch: Throwable -> L87
    L89:
        r24 = r26.optBoolean("boe_proxy_enabled", false);     // Catch: Throwable -> L87
        if (r24 == false) goto L94;
        r19.C(true);     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
    L94:
        if (r24 == true) goto L98;
        r24 = com.bytedance.frameworks.baselib.network.http.util.a.e(r10);     // Catch: Throwable -> L16
        if (r24 == false) goto L98;
        r19.C(true);     // Catch: Throwable -> L16
    L98:
        if (r24 == false) goto L105;
        String r28 = c.N().e();     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r28) == true) goto L102;
        r19.O(r28);     // Catch: Throwable -> L16
    L102:
        String r29 = getProxyConfig(r114);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r29) == true) goto L105;
        Log.e(TAG, "set proxy config: " + r29);     // Catch: Throwable -> L16
        r19.U(r29);     // Catch: Throwable -> L16
    L105:
        String r30 = c.N().C();     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r30) == true) goto L142;
        r19.W(r30);     // Catch: Throwable -> L16
    L142:
        long r31 = getALogFuncAddr();     // Catch: Throwable -> L16 Exception -> L112
        if (r31 == 0) goto L114;
        Log.e(TAG, "set alog address: " + r31);     // Catch: Throwable -> L16 Exception -> L112
        r19.L(r31);     // Catch: Throwable -> L16 Exception -> L112
    L114:
        long r32 = SystemClock.uptimeMillis();     // Catch: Throwable -> L16
        sCronetEngine = r19.B();     // Catch: Throwable -> L16
        TTNetInitMetrics.c().f7227s = SystemClock.uptimeMillis() - r32;     // Catch: Throwable -> L16
        if (d.a().loggerDebug() == false) goto L117;
        k.c(2);     // Catch: Throwable -> L16
    L119:
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L134;
        com.ttnet.org.chromium.net.f r33 = (com.ttnet.org.chromium.net.f) sCronetEngine;     // Catch: Throwable -> L16
        long r34 = getALogFuncAddr();     // Catch: Throwable -> L124
        if (r34 == 0) goto L126;
        Log.e(TAG, "ensure setting alog address: " + r34);     // Catch: Throwable -> L124
        r33.D(r34);     // Catch: Throwable -> L124
    L126:
        int r35 = TTAppStateManager.b();     // Catch: Throwable -> L124
        if (r35 < 0) goto L130;
        if (r35 > 2) goto L130;
        r33.E(r35);     // Catch: Throwable -> L124
    L130:
        TTNetInitMetrics.c().a(r10, r33.u());     // Catch: Throwable -> L124
    L124:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
        goto L134
    L117:
        k.c(4);     // Catch: Throwable -> L16
    L112:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
    L68:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
        goto L71
    L60:
        if (r113.isEmpty() == true) goto L65;
        Iterator r115 = r113.entrySet().iterator();     // Catch: Throwable -> L16
    L63:
        if (r115.hasNext() == false) goto L65;
        Map.Entry r36 = (Map.Entry) r115.next();     // Catch: Throwable -> L16
        r19.A((String) r36.getKey(), ((Integer) ((Pair) r36.getValue()).first).intValue(), ((Integer) ((Pair) r36.getValue()).second).intValue());     // Catch: Throwable -> L16
        goto L63
    L55:
        if (r112.isEmpty() == true) goto L57;
        r19.P(r112);     // Catch: Throwable -> L16
        goto L57
    L50:
        if (r111.isEmpty() == true) goto L52;
        r19.T(r111);     // Catch: Throwable -> L16
    L134:
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L136;
        com.ttnet.org.chromium.net.f r37 = (com.ttnet.org.chromium.net.f) sCronetEngine;     // Catch: Throwable -> L16
        tryCreateRequestFinishedInfoListener(r16);     // Catch: Throwable -> L16
        r37.g(sRequestFinishedInfoListener);     // Catch: Throwable -> L16
    L136:
        TTNetInitMetrics.c().f7218j = System.currentTimeMillis();     // Catch: Throwable -> L16
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L16
    }

    private void tryCreateRequestFinishedInfoListener(final Executor r10) {
        if (sRequestFinishedInfoListener == null) goto L5;
        return;
    L5:
        monitor-enter(CronetClient.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sRequestFinishedInfoListener != null) goto L11;
        sRequestFinishedInfoListener = new AnonymousClass3(this, r10);     // Catch: Throwable -> L9
    L11:
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L9
    }

    public static void tryStartNetDetect(String[] r10, int r11, int r12) throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).J(r10, r11, r12);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void ttDnsResolve(String r10, int r11, String r12) throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        ((com.ttnet.org.chromium.net.f) sCronetEngine).K(r10, r11, r12);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static String[] ttUrlDispatch(String r10) throws Exception {
        if ((sCronetEngine instanceof com.ttnet.org.chromium.net.f) == false) goto L7;
        Map r11 = ((com.ttnet.org.chromium.net.f) sCronetEngine).L(r10);
        return new String[]{(String) r11.get("final_url"), (String) r11.get("epoch"), (String) r11.get("etag")};
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getCronetInternalErrorCode(HttpURLConnection r10) {
        if ((r10 instanceof CronetHttpURLConnection) == true) goto L6;
        return 0;
    L6:
        return ((CronetHttpURLConnection) r10).E();
    L11:
        return 0;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public String getCronetVersion() {
        return "TTNetVersion:b58f3ed1 2022-10-24 QuicVersion:b314d107 2021-11-24";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void getRequestMetrics(HttpURLConnection r10, Map<String, Object> r11) {
        if (r10 == null) goto L21;
        if (r11 != null) goto L6;
        return;
    L6:
        if ((r10 instanceof CronetHttpURLConnection) == true) goto L19;
        return;
    L19:
        CronetHttpURLConnection r12 = (CronetHttpURLConnection) r10;     // Catch: Throwable -> L13
        t r13 = r12.I();     // Catch: Throwable -> L13
        if (r13 != null) goto L11;
    L15:
        r11.put(KEY_REQUEST_LOG, r12.J());     // Catch: Throwable -> L13
        return;
    L11:
        if (r13.c() == null) goto L15;
        t.b r14 = r13.c();     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_REMOTE_IP, r14.e() + ":" + r14.f());     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_DNS_TIME, Long.valueOf(getCostTime(getTime(r14.c()), getTime(r14.d()))));     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_CONNECT_TIME, Long.valueOf(getCostTime(getTime(r14.a()), getTime(r14.b()))));     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_SSL_TIME, Long.valueOf(getCostTime(getTime(r14.u()), getTime(r14.v()))));     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_SEND_TIME, Long.valueOf(getCostTime(getTime(r14.q()), getTime(r14.r()))));     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_PUSH_TIME, Long.valueOf(getCostTime(getTime(r14.h()), getTime(r14.i()))));     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_RECEIVE_TIME, Long.valueOf(getCostTime(getTime(r14.k()), getTime(r14.o()))));     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_SOCKET_REUSED, Boolean.valueOf(r14.t()));     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_TTFB, Long.valueOf(getValue(r14.x())));     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_TOTAL_TIME, Long.valueOf(getValue(r14.w())));     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_SEND_BYTE_COUNT, Long.valueOf(getValue(r14.s())));     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_RECEIVED_BYTE_COUNT, Long.valueOf(getValue(r14.j())));     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_RETRY_ATTEMPTS, Long.valueOf(getValue(r14.p())));     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_REQUEST_HEADERS, r14.l());     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_RESPONSE_HEADERS, r14.n());     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_REQUEST_START, Long.valueOf(getTime(r14.m())));     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_POST_TASK_START, Long.valueOf(getTime(r14.g())));     // Catch: Throwable -> L13
        r11.put(ICronetClient.KEY_WAIT_CONTEXT, Long.valueOf(getCostTime(getTime(r14.m()), getTime(r14.g()))));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public boolean isCronetHttpURLConnection(HttpURLConnection r10) {
        return r10 instanceof CronetHttpURLConnection;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public HttpURLConnection openConnection(Context r10, String r11, boolean r12, String r13, Executor r14) throws IOException {
        tryCreateCronetEngine(r10, false, false, false, r12, r13, r14, false);     // Catch: Throwable -> L5
        return (HttpURLConnection) sCronetEngine.e(new URL(r11));
    L5:
        th = move-exception;
        if ((th instanceof MalformedURLException) == false) goto L9;
        throw th;
    L9:
        if ((th instanceof UnsupportedOperationException) == false) goto L17;
        if (th.getMessage() == null) goto L17;
        if (th.getMessage().contains("Unexpected protocol") == false) goto L17;
        throw new IOException("MalformedURLException", th);
    L17:
        throw new IOException(th);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetBootFailureChecker(ICronetClient.ICronetBootFailureChecker r10) {
        sCronetBootFailureChecker = r10;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetEngine(Context r10, boolean r11, boolean r12, boolean r13, boolean r14, String r15, Executor r16, boolean r17) {
        tryCreateCronetEngine(r10, r11, r12, r13, r14, r15, r16, r17);
    }
}
