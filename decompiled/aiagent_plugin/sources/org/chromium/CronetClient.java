package org.chromium;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.socialbase.downloader.setting.DownloadSettingValues;
import com.ttnet.org.chromium.base.k;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import com.ttnet.org.chromium.net.impl.CronetUrlRequest;
import com.ttnet.org.chromium.net.impl.o;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import com.ttnet.org.chromium.net.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.UnknownFormatConversionException;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class CronetClient implements ICronetClient {
    private static final String BORINGSSL_LIBRARY_NAME = "ttboringssl";
    private static final String CRYPTO_LIBRARY_NAME = "ttcrypto";
    private static final int INVALID_THREAD_PRIORITY = 20;
    private static final String KEY_CRASH_DETECT_INTERVAL_MS = "crash_detect_interval_ms";
    private static final String KEY_CRASH_LIMIT_TIMES = "crash_limit_times";
    private static final String KEY_TTNET_CRASH_TIMES = "ttnet_crash_times";
    private static final int MAX_THREAD_STACK_SIZE = 5242880;
    private static final int MIN_THREAD_STACK_SIZE = 51200;
    private static final String SP_SS_APP_CONFIG = "ss_app_config";
    public static final String TAG = "CronetClient";
    private static final String TTNET_ALOG_CLASS = "com.bytedance.ttnet.TTALog";
    private static final String TTNET_BOE_FLAG = "ttnet_boe.flag";
    private static final String TTNET_CACHE_DIR = "ttnet_storage/";
    private static final String TTNET_CONFIG_FILE = "ttnet_config.json";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static int sAppID = 0;
    private static ICronetClient.ICronetBootFailureCheckerProvider sCronetBootFailureCheckerProvider = null;
    private static volatile com.ttnet.org.chromium.net.d sCronetEngine = null;
    private static ICronetClient.ICronetThreadStackOptFailureCheckerProvider sCronetThreadStackOptFailureCheckerProvider = null;
    private static volatile int sNetworkThreadPriority = 20;
    private int mCrashDetectTimerInterval;
    private int mCrashLimitTimes;
    private int mTTNetCrashTimes;

    static {
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public String getCronetVersion() {
        return "TTNetVersion:c4385650 2026-06-11 QuicVersion:db931b8e 2026-06-08";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setHttpDnsForTesting(boolean r1, boolean r2, boolean r3) {
    }

    public CronetClient() {
        this.mCrashLimitTimes = 0;
        this.mCrashDetectTimerInterval = DownloadSettingValues.SYNC_INTERVAL_MS_FG;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetThreadStackOptFailureCheckerProvider(ICronetClient.ICronetThreadStackOptFailureCheckerProvider r2) {
        sCronetThreadStackOptFailureCheckerProvider = (ICronetClient.ICronetThreadStackOptFailureCheckerProvider) ZeusTransformUtils.wrapperContextForParams(r2, ICronetClient.ICronetThreadStackOptFailureCheckerProvider.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public HttpURLConnection openConnection(Context r13, String r14, boolean r15, String r16, com.bytedance.frameworks.baselib.network.http.b r17, ICronetAppProvider r18) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        ICronetAppProvider r11 = (ICronetAppProvider) ZeusTransformUtils.wrapperContextForParams(r18, ICronetAppProvider.class, "com.obric.aiagent.plugin");
    L8:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(th, MalformedURLException.class) == false) goto L12;
        throw th;
    L12:
        if (ZeusTransformUtils.instanceOf(th, UnsupportedOperationException.class) == false) goto L20;
        if (th.getMessage() == null) goto L20;
        if (th.getMessage().contains("Unexpected protocol") == false) goto L20;
        throw new IOException("MalformedURLException", th);
    L20:
        throw new IOException(th);
    L4:
        if (com.bytedance.frameworks.baselib.network.c.c().f7996b != com.bytedance.frameworks.baselib.network.c.a.f8000a) goto L6;
        com.bytedance.frameworks.baselib.network.c r1 = com.bytedance.frameworks.baselib.network.c.c();     // Catch: Throwable -> L8
        r1.f7996b = com.bytedance.frameworks.baselib.network.c.a.f8001b;     // Catch: Throwable -> L8
    L6:
        tryCreateCronetEngine(r4, false, false, false, r15, r16, false, r11);     // Catch: Throwable -> L8
        CronetHttpURLConnection r2 = (CronetHttpURLConnection) ZeusTransformUtils.preCheckCast(sCronetEngine.a(new URL(r14), Proxy.NO_PROXY, r17.f8135a), CronetHttpURLConnection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        r2.a(new g(r17));     // Catch: Throwable -> L8
        return r2;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetBootFailureCheckerProvider(ICronetClient.ICronetBootFailureCheckerProvider r2) {
        sCronetBootFailureCheckerProvider = (ICronetClient.ICronetBootFailureCheckerProvider) ZeusTransformUtils.wrapperContextForParams(r2, ICronetClient.ICronetBootFailureCheckerProvider.class, "com.obric.aiagent.plugin");
    }

    public static void setNetworkThreadPriority(int r0) {
        sNetworkThreadPriority = r0;
    }

    private void detectCronetColdStartCrash(Context r9, com.ttnet.org.chromium.net.h.a r10) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        SharedPreferences r11 = r6.getSharedPreferences(SP_SS_APP_CONFIG, 0);
        int r1 = r11.getInt(KEY_CRASH_LIMIT_TIMES, 0);
        this.mCrashLimitTimes = r1;
        if (r1 > 0) goto L8;
        int r12 = r11.getInt(KEY_TTNET_CRASH_TIMES, 0);
        this.mTTNetCrashTimes = r12;
        if (r12 <= 0) goto L28;
        SharedPreferences.Editor r8 = r11.edit();
        r8.putInt(KEY_TTNET_CRASH_TIMES, 0);
        r8.apply();
        return;
    L28:
        return;
    L8:
        this.mTTNetCrashTimes = r11.getInt(KEY_TTNET_CRASH_TIMES, 0);
        int r0 = r11.getInt(KEY_CRASH_DETECT_INTERVAL_MS, DownloadSettingValues.SYNC_INTERVAL_MS_FG);
        this.mCrashDetectTimerInterval = r0;
        if (r0 > 0) goto L12;
        this.mCrashDetectTimerInterval = DownloadSettingValues.SYNC_INTERVAL_MS_FG;
    L12:
        if (k.a() == false) goto L15;
        k.a(TAG, "processname is " + com.bytedance.frameworks.baselib.network.http.i.h.d(r6) + " count is " + this.mTTNetCrashTimes + " limit is " + this.mCrashLimitTimes + " interval is " + this.mCrashDetectTimerInterval);
    L15:
        if (this.mTTNetCrashTimes < this.mCrashLimitTimes) goto L21;
        if (k.a() == false) goto L19;
        k.a(TAG, "processname is " + com.bytedance.frameworks.baselib.network.http.i.h.d(r6) + "set secure mode true");
    L19:
        r10.r(true);
    L21:
        if (com.bytedance.frameworks.baselib.network.http.i.h.b(r6) == true) goto L23;
        return;
    L23:
        final SharedPreferences.Editor r7 = r11.edit();
        int r13 = this.mTTNetCrashTimes + 1;
        this.mTTNetCrashTimes = r13;
        r7.putInt(KEY_TTNET_CRASH_TIMES, r13);
        r7.commit();
        if (k.a() == false) goto L26;
        k.a(TAG, "processname is " + com.bytedance.frameworks.baselib.network.http.i.h.d(r6) + " save count " + this.mTTNetCrashTimes);
    L26:
        com.bytedance.frameworks.baselib.network.a.b r14 = com.bytedance.frameworks.baselib.network.a.b.a(com.bytedance.frameworks.baselib.network.a.c.f7963a);
        final long r2 = this.mCrashDetectTimerInterval;
        final long r4 = 0;
        r14.a(new AnonymousClass1(this, r2, r4, r6, r7));
    }

    private TTAppInfoProvider.AppInfo convertToCronetAppInfo(com.bytedance.frameworks.baselib.network.http.cronet.c r2) {
        TTAppInfoProvider.AppInfo r1 = new TTAppInfoProvider.AppInfo();
        r1.K(r2.f8250a);
        r1.t(r2.f8251b);
        r1.u(r2.f8252c);
        r1.v(r2.f8253d);
        r1.w(r2.f8254e);
        r1.x(r2.f);
        r1.y(r2.g);
        r1.E(r2.h);
        return r1;
    }

    ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> convertToCronetThreadConfigInfoList(ArrayList<com.bytedance.frameworks.baselib.network.http.cronet.d> r9, boolean r10) {
        if (r9 != null) goto L40;
    L39:
        return null;
    L40:
    L37:
        e = move-exception;
        e.printStackTrace();
        goto L39
    L5:
        if (r9.isEmpty() == true) goto L39;
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r0 = new ArrayList();     // Catch: Exception -> L37
        EnumSet r1 = EnumSet.noneOf(com.bytedance.frameworks.baselib.network.http.cronet.d.c.class);     // Catch: Exception -> L37
        Iterator<com.bytedance.frameworks.baselib.network.http.cronet.d> r11 = r9.iterator();     // Catch: Exception -> L37
    L8:
        if (r11.hasNext() == false) goto L36;
        com.bytedance.frameworks.baselib.network.http.cronet.d r2 = (com.bytedance.frameworks.baselib.network.http.cronet.d) ZeusTransformUtils.preCheckCast(r11.next(), com.bytedance.frameworks.baselib.network.http.cronet.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L37
        boolean r5 = true;
        if (r2.f8256b >= (-20)) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r10 == true) goto L18;
    L22:
        r5 = false;
    L23:
        if (r3 == true) goto L27;
        if (r5 == false) goto L8;
    L27:
        if (r1.contains(r2.f8255a) == true) goto L8;
        TTThreadConfigInfoProvider.ThreadConfigInfo r4 = new TTThreadConfigInfoProvider.ThreadConfigInfo();     // Catch: Exception -> L37
        r4.a(TTThreadConfigInfoProvider.c.values()[r2.f8255a.ordinal()]);     // Catch: Exception -> L37
        if (r3 == false) goto L32;
        r4.a(r2.f8256b);     // Catch: Exception -> L37
    L32:
        if (r5 == false) goto L34;
        r4.b(r2.f8257c);     // Catch: Exception -> L37
    L34:
        r0.add(r4);     // Catch: Exception -> L37
        r1.add(r2.f8255a);     // Catch: Exception -> L37
        goto L8
    L18:
        if (r2.f8257c < MIN_THREAD_STACK_SIZE) goto L22;
        if (r2.f8257c > MAX_THREAD_STACK_SIZE) goto L22;
    L13:
        if (r2.f8256b > 19) goto L15;
        r3 = true;
        goto L16
    L36:
        return r0;
    }

    TTThreadConfigInfoProvider.b convertToCronetThreadConfigCallback(com.bytedance.frameworks.baselib.network.http.cronet.d.a r3) {
        final com.bytedance.frameworks.baselib.network.http.cronet.d.a r4 = (com.bytedance.frameworks.baselib.network.http.cronet.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.frameworks.baselib.network.http.cronet.d.a.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass2(this, r4);
    }

    private static TTSamplingSettingProvider.TTSlaSamplingSetting convertToCronetSlaSamplingSetting(com.bytedance.frameworks.baselib.network.g.a.c r5) {
        if (r5 != null) goto L18;
        return null;
    L18:
        com.bytedance.frameworks.baselib.network.g.a.b r1 = r5.c();     // Catch: Exception -> L15
        if (r1 == null) goto L8;
        TTSamplingSettingProvider.TTSlaSamplingRule r2 = new TTSamplingSettingProvider.TTSlaSamplingRule();     // Catch: Exception -> L15
        r2.f37861a = r1.a();     // Catch: Exception -> L15
        r2.f37862b = r1.b();     // Catch: Exception -> L15
        r2.f37863c = r1.c();     // Catch: Exception -> L15
        r2.f37864d = r1.d();     // Catch: Exception -> L15
        r2.f = r1.f();     // Catch: Exception -> L15
        r2.f37865e = r1.e();     // Catch: Exception -> L15
        r2.g = r1.g();     // Catch: Exception -> L15
        r2.i = r1.i();     // Catch: Exception -> L15
        r2.h = r1.h();     // Catch: Exception -> L15
    L9:
        com.bytedance.frameworks.baselib.network.g.a.C0180a r3 = r5.d();     // Catch: Exception -> L15
        if (r3 == null) goto L12;
        TTSamplingSettingProvider.TTEventLogSamplingRule r4 = new TTSamplingSettingProvider.TTEventLogSamplingRule();     // Catch: Exception -> L15
        r4.f37860a = r3.a();     // Catch: Exception -> L15
    L13:
        TTSamplingSettingProvider.TTSlaSamplingSetting r6 = new TTSamplingSettingProvider.TTSlaSamplingSetting();     // Catch: Exception -> L15
        r6.f37866a = r5.a();     // Catch: Exception -> L15
        r6.f37867b = r5.b();     // Catch: Exception -> L15
        r6.f37868c = r2;     // Catch: Exception -> L15
        r6.f37869d = r4;     // Catch: Exception -> L15
        return r6;
    L12:
        r4 = null;
        goto L13
    L8:
        r2 = null;
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void tryCreateCronetEngine(Context r17, boolean r18, boolean r19, boolean r20, boolean r21, String r22, boolean r23, ICronetAppProvider r24) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        ICronetAppProvider r3 = (ICronetAppProvider) ZeusTransformUtils.wrapperContextForParams(r24, ICronetAppProvider.class, "com.obric.aiagent.plugin");
        if (sCronetEngine == null) goto L5;
        return;
    L5:
        monitor-enter(CronetClient.class);
    L172:
        th = move-exception;
        throw th;
    L7:
        if (sCronetEngine != null) goto L169;
        INVOKESTATIC_org_chromium_CronetClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "CronetClient tryCreateCronetEngine");     // Catch: Throwable -> L172
        com.bytedance.frameworks.baselib.network.c.c().n = System.currentTimeMillis();     // Catch: Throwable -> L172
        com.bytedance.frameworks.baselib.network.c.c().o = System.nanoTime();     // Catch: Throwable -> L172
        if (r23 == true) goto L17;
        ICronetClient.ICronetBootFailureCheckerProvider r0 = sCronetBootFailureCheckerProvider;     // Catch: Throwable -> L172
        if (r0 == null) goto L17;
        if (r0.isCronetBootFailureExpected() == true) goto L17;
        INVOKESTATIC_org_chromium_CronetClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "isCronetBootFailureExpected return false.");     // Catch: Throwable -> L172
        throw new IllegalArgumentException("isCronetBootFailureExpected return false.");     // Catch: Throwable -> L172
    L17:
        com.bytedance.frameworks.baselib.network.c.c().p = System.nanoTime();     // Catch: Throwable -> L172
        ICronetClient.ICronetThreadStackOptFailureCheckerProvider r1 = sCronetThreadStackOptFailureCheckerProvider;     // Catch: Throwable -> L172
        if (r1 != null) goto L20;
    L22:
        boolean r7 = false;
    L23:
        com.bytedance.frameworks.baselib.network.c.c().q = System.nanoTime();     // Catch: Throwable -> L172
        com.bytedance.frameworks.baselib.network.c.c().r = System.nanoTime();     // Catch: Throwable -> L172
        boolean r8 = c.a().E();     // Catch: Throwable -> L172
        if (r8 == false) goto L26;
        com.bytedance.frameworks.baselib.network.http.cronet.c r10 = r3.getAppInfoSubset();     // Catch: Throwable -> L172
    L27:
        com.bytedance.frameworks.baselib.network.c.c().s = System.nanoTime();     // Catch: Throwable -> L172
        com.bytedance.frameworks.baselib.network.c.c().t = com.bytedance.frameworks.baselib.network.c.c().s;     // Catch: Throwable -> L172
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r11 = convertToCronetThreadConfigInfoList(getThreadConfigInfoList(), r7);     // Catch: Throwable -> L172
        com.bytedance.frameworks.baselib.network.c.c().u = System.nanoTime();     // Catch: Throwable -> L172
        com.bytedance.frameworks.baselib.network.c.c().v = com.bytedance.frameworks.baselib.network.c.c().u;     // Catch: Throwable -> L172
        TTThreadConfigInfoProvider.b r12 = convertToCronetThreadConfigCallback(getThreadConfigCallbackImpl());     // Catch: Throwable -> L172
        com.bytedance.frameworks.baselib.network.c.c().w = System.nanoTime();     // Catch: Throwable -> L172
        com.bytedance.frameworks.baselib.network.c.c().x = com.bytedance.frameworks.baselib.network.c.c().w;     // Catch: Throwable -> L172
        sAppID = Integer.parseInt(r3.getAppId());     // Catch: Exception -> L176 Throwable -> L172
    L29:
        TTSamplingSettingProvider.TTSlaSamplingSetting r13 = convertToCronetSlaSamplingSetting(com.bytedance.frameworks.baselib.network.g.b.a(getSlaSamplingSetting(), sAppID));     // Catch: Throwable -> L172
        com.bytedance.frameworks.baselib.network.c.c().y = System.nanoTime();     // Catch: Throwable -> L172
        com.bytedance.frameworks.baselib.network.c.c().z = com.bytedance.frameworks.baselib.network.c.c().y;     // Catch: Throwable -> L172
        com.ttnet.org.chromium.net.h.a r14 = new com.ttnet.org.chromium.net.h.a(r2, r8).l(r18).m(r19).n(r20).o(r21).p(getListenAppStateIndependently()).k(true);     // Catch: Throwable -> L172
        if (d.a().loggerDebug() == false) goto L32;
        r14.b();     // Catch: Throwable -> L172
    L32:
        com.bytedance.frameworks.baselib.network.http.cronet.c r15 = r10;
        boolean r25 = r7;
        r14.d(Math.min(com.bytedance.frameworks.baselib.network.c.c().f, com.bytedance.frameworks.baselib.network.c.c().o));     // Catch: Throwable -> L172
        detectCronetColdStartCrash(r2, r14);     // Catch: Throwable -> L172
        String r6 = "";
        r6 = r2.getCacheDir().getPath() + "/";     // Catch: Throwable -> L43
        r14.j(r6 + TTNET_CACHE_DIR);     // Catch: Throwable -> L41
        r14.b(3, getMaxHttpDiskCacheSize());     // Catch: Throwable -> L39
        r6 = r6;
    L46:
        if (sNetworkThreadPriority >= (-20)) goto L48;
    L50:
        int r4 = getAppSecurityLevel();     // Catch: Throwable -> L172
        if (r4 <= 0) goto L54;
        r14.c(r4);     // Catch: Throwable -> L172
    L54:
        if (c.a().N() == false) goto L56;
        boolean r5 = true;
        r14.j(true);     // Catch: Throwable -> L172
    L58:
        if (c.a().L() == false) goto L61;
        r14.l(r5);     // Catch: Throwable -> L172
    L61:
        if (c.a().M() == false) goto L63;
        r14.m(r5);     // Catch: Throwable -> L172
    L63:
        x.a().a(f.e());     // Catch: Throwable -> L172
        r14.b(a.a(r2));     // Catch: Throwable -> L172
        r14.b(e.d());     // Catch: Throwable -> L172
        r14.s(com.bytedance.frameworks.baselib.network.http.i.h.b(r2));     // Catch: Throwable -> L172
        r14.o(com.bytedance.frameworks.baselib.network.http.i.h.d(r2));     // Catch: Throwable -> L172
        if (com.bytedance.frameworks.baselib.network.http.i.h.b(r2) == false) goto L66;
        r14.b(b.a());     // Catch: Throwable -> L172
        e.d().b(true);     // Catch: Throwable -> L172
    L66:
        if (r8 == false) goto L68;
        r14.b(convertToCronetAppInfo(r15));     // Catch: Throwable -> L172
    L68:
        r14.u(r8);     // Catch: Throwable -> L172
        r14.b(r3.getOptNqeDefault(), r3.getOptNqePersist());     // Catch: Throwable -> L172
        r14.d(r11);     // Catch: Throwable -> L172
        r14.b(r12);     // Catch: Throwable -> L172
        r14.t(r3.getLazyInitCronetIPC());     // Catch: Throwable -> L172
        if (TextUtils.isEmpty(r22) == true) goto L71;
        r14.i(r22 + " cronet/TTNetVersion:c4385650 2026-06-11 QuicVersion:db931b8e 2026-06-08");     // Catch: Throwable -> L172
    L71:
        String r9 = getDomainConfigByRegion();     // Catch: Throwable -> L172
        if (TextUtils.isEmpty(r9) == false) goto L75;
        r9 = c.a().G();     // Catch: Throwable -> L172
    L75:
        if (TextUtils.isEmpty(r9) == true) goto L77;
        r14.k(r9);     // Catch: Throwable -> L172
    L77:
        ArrayList<byte[]> r16 = c.a().H();     // Catch: Throwable -> L172
        if (r16 != null) goto L80;
    L82:
        Map<String[], Pair<byte[], byte[]>> r26 = c.a().I();     // Catch: Throwable -> L172
        if (r26 != null) goto L85;
    L87:
        Map<String, Pair<Integer, Integer>> r27 = c.a().O();     // Catch: Throwable -> L172
        if (r27 == null) goto L96;
        if (r27.isEmpty() == true) goto L96;
        Iterator<Map.Entry<String, Pair<Integer, Integer>>> r28 = r27.entrySet().iterator();     // Catch: Throwable -> L172
    L93:
        if (r28.hasNext() == false) goto L96;
        Map.Entry r29 = (Map.Entry) ZeusTransformUtils.preCheckCast(r28.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L172
        r14.b((String) ZeusTransformUtils.preCheckCast(r29.getKey(), String.class, "com.obric.aiagent.plugin"), ((Integer) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r29.getValue(), Pair.class, "com.obric.aiagent.plugin")).first, Integer.class, "com.obric.aiagent.plugin")).intValue(), ((Integer) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r29.getValue(), Pair.class, "com.obric.aiagent.plugin")).second, Integer.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L172
    L96:
        if (c.a().T() == false) goto L98;
        r14.b(new AnonymousClass3(this));     // Catch: Throwable -> L172
    L98:
        String r30 = c.a().U();     // Catch: Throwable -> L172
        if (TextUtils.isEmpty(r30) == true) goto L103;
        String r31 = r30.substring(r30.lastIndexOf(File.separator) + 1);     // Catch: Throwable -> L172
        String r32 = r2.getCacheDir().getAbsolutePath();     // Catch: Throwable -> L172
        if (com.bytedance.common.utility.c.a.a(r30, r32, r31) == false) goto L103;
        r14.c(r32 + File.separator + r31);     // Catch: Throwable -> L172
    L103:
        boolean r33 = c.a().P();     // Catch: Throwable -> L172
        if (r33 == false) goto L106;
        r14.q(true);     // Catch: Throwable -> L172
    L106:
        if (r33 == true) goto L118;
        String r34 = com.bytedance.frameworks.baselib.network.http.i.c.a(r2, TTNET_CONFIG_FILE);     // Catch: Throwable -> L172
        if (TextUtils.isEmpty(r34) == true) goto L118;
        JSONObject r35 = new JSONObject(r34);     // Catch: Throwable -> L116
        String r36 = r35.optString("ttnet_proxy", "");     // Catch: Throwable -> L116
        if (TextUtils.isEmpty(r36) == true) goto L112;
        r14.n(r36);     // Catch: Throwable -> L116
    L112:
        r33 = r35.optBoolean("boe_proxy_enabled", false);     // Catch: Throwable -> L116
        if (r33 == false) goto L118;
        r14.q(true);     // Catch: Throwable -> L116
    L116:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L172
    L118:
        if (r33 == true) goto L122;
        r33 = com.bytedance.frameworks.baselib.network.http.i.c.b(r2);     // Catch: Throwable -> L172
        if (r33 == false) goto L122;
        r14.q(true);     // Catch: Throwable -> L172
    L122:
        if (r33 == false) goto L129;
        String r37 = c.a().Q();     // Catch: Throwable -> L172
        if (TextUtils.isEmpty(r37) == true) goto L126;
        r14.l(r37);     // Catch: Throwable -> L172
    L126:
        String r38 = getProxyConfig(r6);     // Catch: Throwable -> L172
        if (TextUtils.isEmpty(r38) == true) goto L129;
        INVOKESTATIC_org_chromium_CronetClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "set proxy config: " + r38);     // Catch: Throwable -> L172
        r14.n(r38);     // Catch: Throwable -> L172
    L129:
        String r39 = c.a().R();     // Catch: Throwable -> L172
        if (TextUtils.isEmpty(r39) == true) goto L183;
        r14.m(r39);     // Catch: Throwable -> L172
    L183:
        long r40 = getALogFuncAddr();     // Catch: Exception -> L136 Throwable -> L172
        if (r40 == 0) goto L140;
        INVOKESTATIC_org_chromium_CronetClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "set alog address: " + r40);     // Catch: Exception -> L136 Throwable -> L172
        r14.c(r40);     // Catch: Exception -> L136 Throwable -> L172
    L140:
        if (Build.VERSION.SDK_INT < 18) goto L192;
    L145:
        if (r13 == null) goto L147;
        r14.b(r13);     // Catch: Throwable -> L172
    L147:
        ICronetClient.ICronetThreadStackOptFailureCheckerProvider r41 = sCronetThreadStackOptFailureCheckerProvider;     // Catch: Throwable -> L172
        if (r41 != null) goto L150;
        String r42 = null;
    L151:
        r14.b(r25, r42);     // Catch: Throwable -> L172
        com.bytedance.frameworks.baselib.network.c.c().A = System.nanoTime();     // Catch: Throwable -> L172
        com.bytedance.frameworks.baselib.network.c.c().B = com.bytedance.frameworks.baselib.network.c.c().A;     // Catch: Throwable -> L172
        sCronetEngine = r14.c();     // Catch: Throwable -> L172
        com.bytedance.frameworks.baselib.network.c.c().C = System.nanoTime();     // Catch: Throwable -> L172
        if (d.a().loggerDebug() == false) goto L154;
        k.a(2);     // Catch: Throwable -> L172
    L156:
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L169;
        com.ttnet.org.chromium.net.h r43 = (com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L172
        long r44 = getALogFuncAddr();     // Catch: Throwable -> L167
        if (r44 == 0) goto L161;
        INVOKESTATIC_org_chromium_CronetClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "ensure setting alog address: " + r44);     // Catch: Throwable -> L167
        r43.a(r44);     // Catch: Throwable -> L167
    L161:
        int r45 = com.bytedance.frameworks.baselib.network.http.cronet.b.a();     // Catch: Throwable -> L167
        if (r45 < 0) goto L165;
        if (r45 > 2) goto L165;
        r43.h(r45);     // Catch: Throwable -> L167
    L165:
        com.bytedance.frameworks.baselib.network.c.c().a(r2, r43.i());     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L172
        goto L169
    L154:
        k.a(4);     // Catch: Throwable -> L172
        goto L156
    L150:
        r42 = r41.getThreadStackInitReason();     // Catch: Throwable -> L172
        goto L151
    L192:
        System.loadLibrary(CRYPTO_LIBRARY_NAME);     // Catch: Throwable -> L143
        System.loadLibrary(BORINGSSL_LIBRARY_NAME);     // Catch: Throwable -> L143
    L143:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L172
    L136:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L172
        goto L140
    L85:
        if (r26.isEmpty() == true) goto L87;
        r14.b(r26);     // Catch: Throwable -> L172
        goto L87
    L80:
        if (r16.isEmpty() == true) goto L82;
        r14.c(r16);     // Catch: Throwable -> L172
        goto L82
    L56:
        r5 = true;
        goto L58
    L48:
        if (sNetworkThreadPriority > 19) goto L50;
        r14.b(sNetworkThreadPriority);     // Catch: Throwable -> L172
    L39:
        th = th;
        r6 = r6;
    L44:
        INVOKESTATIC_org_chromium_CronetClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "ExperimentalCronetEngine.Builder enable HTTP Cache failed.");     // Catch: Throwable -> L172
        th.printStackTrace();     // Catch: Throwable -> L172
        r14.b(0, 0);     // Catch: Throwable -> L172
    L41:
        th = th;
    L43:
        th = th;
        goto L44
    L26:
        r10 = null;
        goto L27
    L20:
        if (r1.isCronetThreadStackOptFailureExpected() == false) goto L22;
        r7 = true;
    L169:
        com.bytedance.retrofit2.e.f.a(new AnonymousClass4(this));     // Catch: Throwable -> L172
        com.bytedance.frameworks.baselib.network.c.c().F = System.nanoTime();     // Catch: Throwable -> L172
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L172
    }

    public static com.ttnet.org.chromium.net.d getCronetEngine() {
        Objects.requireNonNull(sCronetEngine, "Cronet engine is null.");
        return sCronetEngine;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public boolean isCronetHttpURLConnection(HttpURLConnection r1) {
        return ZeusTransformUtils.instanceOf(r1, CronetHttpURLConnection.class);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getCronetInternalErrorCode(HttpURLConnection r3) {
        if (ZeusTransformUtils.instanceOf(r3, CronetHttpURLConnection.class) == true) goto L6;
        return 0;
    L6:
        return ((CronetHttpURLConnection) ZeusTransformUtils.preCheckCast(r3, CronetHttpURLConnection.class, "com.obric.aiagent.plugin")).c();
    L11:
        return 0;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void triggerGetDomain(boolean r3) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "triggerGetDomain start");     // Catch: Throwable -> L9
    L6:
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L14;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).a(r3);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void runInBackGround(boolean r3) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "runInBackGround start");     // Catch: Throwable -> L9
    L6:
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L14;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).b(r3);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void addClientOpaqueData(String[] r9, byte[] r10, byte[] r11, long r12, long r14) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "addClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L14;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).a(r9, r10, r11, r12, r14);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void clearClientOpaqueData() {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "clearClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L14;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).c();     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void removeClientOpaqueData(String r3) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "removeClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L14;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).a(r3);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public com.bytedance.frameworks.baselib.network.http.cronet.b.k ttUrlDispatch(String r10, int r11, boolean r12) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L11;
        Map<String, String> r9 = ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).a(r10, r11, r12);
        String r4 = (String) ZeusTransformUtils.preCheckCast(r9.get("final_url"), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r4) == true) goto L9;
        new URL(r4).toURI();
        return new com.bytedance.frameworks.baselib.network.http.cronet.b.k(r10, r4, (String) ZeusTransformUtils.preCheckCast(r9.get("epoch"), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r9.get("etag"), String.class, "com.obric.aiagent.plugin"), com.bytedance.frameworks.baselib.network.http.cronet.b.k.a.f8245a, (String) ZeusTransformUtils.preCheckCast(r9.get("ttnet_origin_host"), String.class, "com.obric.aiagent.plugin"));
    L9:
        throw new UnknownFormatConversionException("ttUrlDispatch returns wrong format");
    L11:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void preconnectUrl(String r3, Map<String, String> r4) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).a(r3, 1, r2);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void tryStartNetDetect(String[] r3, int r4, int r5) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).a(r3, r4, r5);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void ttDnsResolve(String r3, int r4, String r5, Map<String, String> r6) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).a(r3, r4, r5, r2);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void getMappingRequestState(final String r3) {
        CronetUrlRequest r0 = o.b(r3);     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        r0.a(new AnonymousClass5(this, r3));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveConnectionType() {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        return ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).b();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void notifyTNCConfigUpdated(String r8, String r9, String r10, String r11, String r12, String r13) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).a(r8, r9, r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void notifyStoreRegionUpdated(String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).a(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setProxy(String r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).b(r3);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public com.bytedance.frameworks.baselib.network.http.cronet.b.g getNetworkQuality() {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        com.ttnet.org.chromium.net.h r2 = (com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin");
        com.bytedance.frameworks.baselib.network.http.cronet.b.g r0 = new com.bytedance.frameworks.baselib.network.http.cronet.b.g();
        r0.f8226a = r2.l();
        r0.f8227b = r2.k();
        r0.f8228c = r2.m();
        return r0;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public com.bytedance.frameworks.baselib.network.http.cronet.b.h getPacketLossRateMetrics(int r4) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        com.bytedance.frameworks.baselib.network.http.cronet.b.h r3 = new com.bytedance.frameworks.baselib.network.http.cronet.b.h();
        com.ttnet.org.chromium.net.h r0 = (com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin");
        r3.f8229a = r4;
        r3.f8230b = r0.a(r4);
        r3.f8231c = r0.b(r4);
        r3.f8232d = r0.c(r4);
        r3.f8233e = r0.d(r4);
        return r3;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public Map<String, com.bytedance.frameworks.baselib.network.http.cronet.b.g> getGroupRttEstimates() {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L14;
        com.ttnet.org.chromium.net.h r0 = (com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin");
        HashMap r1 = new HashMap();
        Iterator<Map.Entry<String, int[]>> r2 = r0.d().entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L12;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (((int[]) ZeusTransformUtils.preCheckCast(r3.getValue(), int[].class, "com.obric.aiagent.plugin")).length != 2) goto L11;
        com.bytedance.frameworks.baselib.network.http.cronet.b.g r4 = new com.bytedance.frameworks.baselib.network.http.cronet.b.g();
        r4.f8226a = ((int[]) ZeusTransformUtils.preCheckCast(r3.getValue(), int[].class, "com.obric.aiagent.plugin"))[0];
        r4.f8227b = ((int[]) ZeusTransformUtils.preCheckCast(r3.getValue(), int[].class, "com.obric.aiagent.plugin"))[1];
        r4.f8228c = -1;
        r1.put((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin"), r4);
        goto L6
    L11:
        throw new UnknownFormatConversionException("getGroupRttEstimates returns wrong format");
    L12:
        return r1;
    L14:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setHostResolverRules(String r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).c(r3);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setAlogFuncAddr(long r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).a(r3);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setZstdFuncAddr(long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).a(r19, r21, r23, r25, r27, r29, r31, r33);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void startThrottle(String[] r3, int r4, long r5) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).a(r3, r4, r5);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void stopThrottle(String[] r3, int r4) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).a(r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setBestHostWithRouteSelectionName(String r3, String r4) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).a(r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCookieInitCompleted() {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).j();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getNetworkQualityLevel() {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        return ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).e();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveHttpRttMs() {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        return ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).f();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveTransportRttMs() {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        return ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).g();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveRxThroughputKbps() {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        return ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).h();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void reportNetDiagnosisUserLog(String r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).d(r3);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void enableTTBizHttpDns(boolean r8, String r9, String r10, String r11, boolean r12, String r13) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).a(r8, r9, r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void bindBigCore(com.bytedance.frameworks.baselib.network.http.cronet.d.c r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).e(r3.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void bindLittleCore(com.bytedance.frameworks.baselib.network.http.cronet.d.c r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).f(r3.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void resetCoreBind(com.bytedance.frameworks.baselib.network.http.cronet.d.c r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).g(r3.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setSlaSamplingSetting(JSONObject r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L13;
        if (sAppID > 0) goto L7;
        sAppID = Integer.parseInt(c.a().e());
    L7:
        TTSamplingSettingProvider.TTSlaSamplingSetting r2 = convertToCronetSlaSamplingSetting(com.bytedance.frameworks.baselib.network.g.b.a(r3, sAppID));
        if (r2 != null) goto L10;
        return;
    L10:
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).a(r2);
        return;
    L13:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setAppStartUpState(int r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, com.ttnet.org.chromium.net.h.class) == false) goto L7;
        ((com.ttnet.org.chromium.net.h) ZeusTransformUtils.preCheckCast(sCronetEngine, com.ttnet.org.chromium.net.h.class, "com.obric.aiagent.plugin")).h(r3);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    private static long getALogFuncAddr() {
        return ((Long) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(ZeusTransformUtils.forName(TTNET_ALOG_CLASS, "com.obric.aiagent.plugin").newInstance()).call("getALogFuncAddr").a(), Long.class, "com.obric.aiagent.plugin")).longValue();
    }

    private static boolean getListenAppStateIndependently() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.aiagent.plugin").newInstance()).call("getListenAppStateIndependently").a(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        return false;
    }

    private static String getDomainConfigByRegion() {
        String r1 = c.a().z();
        String r2 = c.a().y();
        String r3 = c.a().x();
        if (TextUtils.isEmpty(r1) == false) goto L10;
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r1 = r2;
        goto L10
    L8:
        r1 = r3;
    L10:
        if (TextUtils.isEmpty(r1) == false) goto L15;
        return null;
    L15:
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.aiagent.plugin").newInstance()).call("getGetDomainConfigByRegion", new Class[]{String.class}, new Object[]{r1}).a(), String.class, "com.obric.aiagent.plugin");
    L14:
        return null;
    }

    private static long getMaxHttpDiskCacheSize() {
        return ((Long) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.aiagent.plugin").newInstance()).call("getMaxHttpDiskCacheSize").a(), Long.class, "com.obric.aiagent.plugin")).longValue();
    L5:
        return 67108864;
    }

    private static JSONObject getSlaSamplingSetting() {
        return (JSONObject) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.aiagent.plugin").newInstance()).call("getSlaSamplingSetting").a(), JSONObject.class, "com.obric.aiagent.plugin");
    L5:
        return null;
    }

    private static int getAppSecurityLevel() {
        return ((Integer) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.aiagent.plugin").newInstance()).call("getAppSecurityLevel").a(), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L5:
        return 0;
    }

    private static ArrayList<com.bytedance.frameworks.baselib.network.http.cronet.d> getThreadConfigInfoList() {
        return (ArrayList) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.aiagent.plugin").newInstance()).call("getThreadConfigInfoList").a(), ArrayList.class, "com.obric.aiagent.plugin");
    L5:
        return null;
    }

    private static com.bytedance.frameworks.baselib.network.http.cronet.d.a getThreadConfigCallbackImpl() {
        return (com.bytedance.frameworks.baselib.network.http.cronet.d.a) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.aiagent.plugin").newInstance()).call("getThreadConfigCallbackImpl").a(), com.bytedance.frameworks.baselib.network.http.cronet.d.a.class, "com.obric.aiagent.plugin");
    L5:
        return null;
    }

    private String getProxyConfig(String r5) {
        String r0 = "";
        if (TextUtils.isEmpty(r5) == true) goto L34;
        BufferedReader r4 = null;
        File r1 = new File(r5 + TTNET_CONFIG_FILE);     // Catch: Throwable -> L21
        if (r1.exists() == false) goto L16;
        BufferedReader r6 = new BufferedReader(new FileReader(r1));     // Catch: Throwable -> L21
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L14
    L9:
        String r2 = r6.readLine();     // Catch: Throwable -> L14
        if (r2 == null) goto L12;
        r7.append(r2);     // Catch: Throwable -> L14
        goto L9
    L12:
        r0 = new JSONObject(r7.toString()).optString("ttnet_proxy", "");     // Catch: Throwable -> L14
        r4 = r6;
    L14:
        Throwable th = th;
    L42:
        th.printStackTrace();     // Catch: Throwable -> L27
        if (r6 == null) goto L34;
        r6.close();     // Catch: IOException -> L19
    L35:
    L27:
        th = move-exception;
        if (r6 != null) goto L40;
    L33:
        throw th;
    L40:
        r6.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (r4 == null) goto L34;
        r4.close();     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L21:
        th = move-exception;
        r6 = null;
        th = th;
    L34:
        return r0;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_org_chromium_CronetClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_org_chromium_CronetClient_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
