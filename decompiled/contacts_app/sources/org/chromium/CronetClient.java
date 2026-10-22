package org.chromium;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.common.utility.io.FileUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskManager;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.cronet.ConstantsDefined;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.TTAppStateManager;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetAppInfoSubset;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.NetworkQuality;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.PacketLossMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.frameworks.baselib.network.sampling.SamplingSettingProvider;
import com.bytedance.frameworks.baselib.network.sampling.SlaSamplingSettingCreator;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.ttnet.org.chromium.base.Logger;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTAppSecurityManager;
import com.ttnet.org.chromium.net.TTNetVersion;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import com.ttnet.org.chromium.net.impl.CronetUrlRequest;
import com.ttnet.org.chromium.net.impl.CronetUrlRequestMapping;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UnknownFormatConversionException;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class CronetClient implements ICronetClient {
    private static final String BORINGSSL_LIBRARY_NAME = "ttboringssl";
    private static final String CRYPTO_LIBRARY_NAME = "ttcrypto";
    private static final int INVALID_THREAD_PRIORITY = 20;
    private static final String KEY_CRASH_DETECT_INTERVAL_MS = "crash_detect_interval_ms";
    private static final String KEY_CRASH_LIMIT_TIMES = "crash_limit_times";
    private static final String KEY_REQUEST_LOG = "request_log";
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
    private static volatile CronetEngine sCronetEngine = null;
    private static ICronetClient.ICronetThreadStackOptFailureCheckerProvider sCronetThreadStackOptFailureCheckerProvider = null;
    private static volatile int sNetworkThreadPriority = 20;
    private static volatile RequestFinishedInfo.Listener sRequestFinishedInfoListener;
    private int mCrashDetectTimerInterval;
    private int mCrashLimitTimes;
    private int mTTNetCrashTimes;

    static {
    }

    private static long getCostTime(long r3, long r5) {
        if (r5 != (-1)) goto L5;
    L11:
        return -1;
    L5:
        if (r3 == (-1)) goto L11;
        if (r5 > r3) goto L11;
        return r3 - r5;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public String getCronetVersion() {
        return TTNetVersion.VERSION;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setHttpDnsForTesting(boolean r1, boolean r2, boolean r3) throws Exception {
    }

    public CronetClient() {
        this.mCrashLimitTimes = 0;
        this.mCrashDetectTimerInterval = 5000;
    }

    static /* synthetic */ long access$000(long r0, long r2) {
        return getCostTime(r0, r2);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetThreadStackOptFailureCheckerProvider(ICronetClient.ICronetThreadStackOptFailureCheckerProvider r1) {
        sCronetThreadStackOptFailureCheckerProvider = r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public HttpURLConnection openConnection(Context r13, String r14, boolean r15, String r16, boolean r17, Executor r18, ICronetAppProvider r19) throws IOException {
    L7:
        th = move-exception;
        if ((th instanceof MalformedURLException) == false) goto L11;
        throw th;
    L11:
        if ((th instanceof UnsupportedOperationException) == false) goto L19;
        if (th.getMessage() == null) goto L19;
        if (th.getMessage().contains("Unexpected protocol") == false) goto L19;
        throw new IOException("MalformedURLException", th);
    L19:
        throw new IOException(th);
    L3:
        if (TTNetInitMetrics.inst().mode != TTNetInitMetrics.CronetInitMode.NONE) goto L5;
        TTNetInitMetrics r0 = TTNetInitMetrics.inst();     // Catch: Throwable -> L7
        r0.mode = TTNetInitMetrics.CronetInitMode.LAZY_INIT;     // Catch: Throwable -> L7
    L5:
        tryCreateCronetEngine(r13, false, false, false, r15, r16, r18, false, r19);     // Catch: Throwable -> L7
        return (HttpURLConnection) sCronetEngine.openConnection(new URL(r14), Proxy.NO_PROXY, r17);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetBootFailureCheckerProvider(ICronetClient.ICronetBootFailureCheckerProvider r1) {
        sCronetBootFailureCheckerProvider = r1;
    }

    public static void setNetworkThreadPriority(int r0) {
        sNetworkThreadPriority = r0;
    }

    private void detectCronetColdStartCrash(final Context r11, ExperimentalCronetEngine.Builder r12) {
        SharedPreferences r0 = r11.getSharedPreferences(SP_SS_APP_CONFIG, 0);
        int r3 = r0.getInt(KEY_CRASH_LIMIT_TIMES, 0);
        this.mCrashLimitTimes = r3;
        if (r3 > 0) goto L8;
        int r4 = r0.getInt(KEY_TTNET_CRASH_TIMES, 0);
        this.mTTNetCrashTimes = r4;
        if (r4 <= 0) goto L28;
        SharedPreferences.Editor r1 = r0.edit();
        r1.putInt(KEY_TTNET_CRASH_TIMES, 0);
        r1.apply();
        return;
    L28:
        return;
    L8:
        this.mTTNetCrashTimes = r0.getInt(KEY_TTNET_CRASH_TIMES, 0);
        int r2 = r0.getInt(KEY_CRASH_DETECT_INTERVAL_MS, 5000);
        this.mCrashDetectTimerInterval = r2;
        if (r2 > 0) goto L12;
        this.mCrashDetectTimerInterval = 5000;
    L12:
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "processname is " + ProcessUtils.getCurProcessName(r11) + " count is " + this.mTTNetCrashTimes + " limit is " + this.mCrashLimitTimes + " interval is " + this.mCrashDetectTimerInterval);
    L15:
        if (this.mTTNetCrashTimes < this.mCrashLimitTimes) goto L21;
        if (Logger.debug() == false) goto L19;
        Logger.d(TAG, "processname is " + ProcessUtils.getCurProcessName(r11) + "set secure mode true");
    L19:
        r12.enableTncSecureMode(true);
    L21:
        if (ProcessUtils.isMainProcessByProcessFlag(r11) == true) goto L23;
        return;
    L23:
        final SharedPreferences.Editor r7 = r0.edit();
        int r5 = this.mTTNetCrashTimes + 1;
        this.mTTNetCrashTimes = r5;
        r7.putInt(KEY_TTNET_CRASH_TIMES, r5);
        r7.commit();
        if (Logger.debug() == false) goto L26;
        Logger.d(TAG, "processname is " + ProcessUtils.getCurProcessName(r11) + " save count " + this.mTTNetCrashTimes);
    L26:
        NetworkAsyncTaskManager r8 = NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK);
        final long r6 = this.mCrashDetectTimerInterval;
        final long r9 = 0;
        r8.postTask(new AnonymousClass1(this, r6, r9, r11, r7));
    }

    private TTAppInfoProvider.AppInfo convertToCronetAppInfo(TTNetAppInfoSubset r2) {
        TTAppInfoProvider.AppInfo r1 = new TTAppInfoProvider.AppInfo();
        r1.setAbSdkVersion(r2.mAbSdkVersion);
        r1.setHostFirst(r2.mHostFirst);
        r1.setHostSecond(r2.mHostSecond);
        r1.setHostThird(r2.mHostThird);
        r1.setDomainHttpDns(r2.mDomainHttpDns);
        r1.setDomainBoe(r2.mDomainBoe);
        r1.setDomainBoeHttps(r2.mDomainBoeHttps);
        r1.setInitRegion(r2.mInitRegion);
        return r1;
    }

    ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> convertToCronetThreadConfigInfoList(ArrayList<TTNetThreadConfig> r9, boolean r10) {
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
        EnumSet r1 = EnumSet.noneOf(TTNetThreadConfig.ThreadType.class);     // Catch: Exception -> L37
        Iterator<TTNetThreadConfig> r11 = r9.iterator();     // Catch: Exception -> L37
    L8:
        if (r11.hasNext() == false) goto L36;
        TTNetThreadConfig r2 = r11.next();     // Catch: Exception -> L37
        boolean r5 = true;
        if (r2.mThreadPriority >= (-20)) goto L13;
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
        if (r1.contains(r2.mThreadType) == true) goto L8;
        TTThreadConfigInfoProvider.ThreadConfigInfo r4 = new TTThreadConfigInfoProvider.ThreadConfigInfo();     // Catch: Exception -> L37
        r4.setThreadType(TTThreadConfigInfoProvider.ThreadType.values()[r2.mThreadType.ordinal()]);     // Catch: Exception -> L37
        if (r3 == false) goto L32;
        r4.setThreadPriority(r2.mThreadPriority);     // Catch: Exception -> L37
    L32:
        if (r5 == false) goto L34;
        r4.setThreadStackSize(r2.mThreadStackSize);     // Catch: Exception -> L37
    L34:
        r0.add(r4);     // Catch: Exception -> L37
        r1.add(r2.mThreadType);     // Catch: Exception -> L37
        goto L8
    L18:
        if (r2.mThreadStackSize < MIN_THREAD_STACK_SIZE) goto L22;
        if (r2.mThreadStackSize > MAX_THREAD_STACK_SIZE) goto L22;
    L13:
        if (r2.mThreadPriority > 19) goto L15;
        r3 = true;
        goto L16
    L36:
        return r0;
    }

    TTThreadConfigInfoProvider.Callback convertToCronetThreadConfigCallback(final TTNetThreadConfig.Callback r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass2(this, r2);
    }

    private static TTSamplingSettingProvider.TTSlaSamplingSetting convertToCronetSlaSamplingSetting(SamplingSettingProvider.SlaSamplingSetting r5) {
        if (r5 != null) goto L18;
        return null;
    L18:
        SamplingSettingProvider.SlaSamplingRule r1 = r5.getSlaSamplingRule();     // Catch: Exception -> L15
        if (r1 == null) goto L8;
        TTSamplingSettingProvider.TTSlaSamplingRule r2 = new TTSamplingSettingProvider.TTSlaSamplingRule();     // Catch: Exception -> L15
        r2.mEnableBaseApiAll = r1.getEnableBaseApiAll();     // Catch: Exception -> L15
        r2.mEnableApiAllUpload = r1.getEnableApiAllUpload();     // Catch: Exception -> L15
        r2.mUrlRegexBlackList = r1.getUrlRegexBlackList();     // Catch: Exception -> L15
        r2.mPathEqualWhiteList = r1.getPathEqualWhiteList();     // Catch: Exception -> L15
        r2.mPathPrefixWhiteList = r1.getPathPrefixWhiteList();     // Catch: Exception -> L15
        r2.mPathContainWhiteList = r1.getPathContainWhiteList();     // Catch: Exception -> L15
        r2.mPathRegexWhiteList = r1.getPathRegexWhiteList();     // Catch: Exception -> L15
        r2.mHostPatternWhiteList = r1.getHostPatternWhiteList();     // Catch: Exception -> L15
        r2.mUrlRegexWhiteList = r1.getUrlRegexWhiteList();     // Catch: Exception -> L15
    L9:
        SamplingSettingProvider.SlaEventLogSamplingRule r3 = r5.getSlaEventLogSamplingRule();     // Catch: Exception -> L15
        if (r3 == null) goto L12;
        TTSamplingSettingProvider.TTEventLogSamplingRule r4 = new TTSamplingSettingProvider.TTEventLogSamplingRule();     // Catch: Exception -> L15
        r4.mEventLogTypeWhiteList = r3.getEventLogTypeWhiteList();     // Catch: Exception -> L15
    L13:
        TTSamplingSettingProvider.TTSlaSamplingSetting r6 = new TTSamplingSettingProvider.TTSlaSamplingSetting();     // Catch: Exception -> L15
        r6.mHostAid = r5.getHostAid();     // Catch: Exception -> L15
        r6.mSdkAid = r5.getSdkAid();     // Catch: Exception -> L15
        r6.mSlaSamplingRule = r2;     // Catch: Exception -> L15
        r6.mEventLogSamplingRule = r4;     // Catch: Exception -> L15
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
    public void tryCreateCronetEngine(Context r18, boolean r19, boolean r20, boolean r21, boolean r22, String r23, Executor r24, boolean r25, ICronetAppProvider r26) {
        if (sCronetEngine == null) goto L5;
        return;
    L5:
        monitor-enter(CronetClient.class);
    L168:
        th = move-exception;
        throw th;
    L7:
        if (sCronetEngine != null) goto L163;
        Log.w(TAG, "CronetClient tryCreateCronetEngine");     // Catch: Throwable -> L168
        TTNetInitMetrics.inst().createEngineStartTime = System.currentTimeMillis();     // Catch: Throwable -> L168
        TTNetInitMetrics.inst().createEngineStart = System.nanoTime();     // Catch: Throwable -> L168
        if (r25 == true) goto L17;
        ICronetClient.ICronetBootFailureCheckerProvider r0 = sCronetBootFailureCheckerProvider;     // Catch: Throwable -> L168
        if (r0 == null) goto L17;
        if (r0.isCronetBootFailureExpected() == true) goto L17;
        Log.w(TAG, "isCronetBootFailureExpected return false.");     // Catch: Throwable -> L168
        throw new IllegalArgumentException("isCronetBootFailureExpected return false.");     // Catch: Throwable -> L168
    L17:
        TTNetInitMetrics.inst().getStackOptConfigStart = System.nanoTime();     // Catch: Throwable -> L168
        ICronetClient.ICronetThreadStackOptFailureCheckerProvider r1 = sCronetThreadStackOptFailureCheckerProvider;     // Catch: Throwable -> L168
        if (r1 != null) goto L20;
    L22:
        boolean r7 = false;
    L23:
        TTNetInitMetrics.inst().getStackOptConfigEnd = System.nanoTime();     // Catch: Throwable -> L168
        TTNetInitMetrics.inst().constructAppInfoSubsetStart = System.nanoTime();     // Catch: Throwable -> L168
        boolean r8 = CronetAppProviderManager.inst().getOptInit();     // Catch: Throwable -> L168
        if (r8 == false) goto L26;
        TTNetAppInfoSubset r10 = r26.getAppInfoSubset();     // Catch: Throwable -> L168
    L27:
        TTNetInitMetrics.inst().constructAppInfoSubsetEnd = System.nanoTime();     // Catch: Throwable -> L168
        TTNetInitMetrics.inst().constructThreadConfigListStart = TTNetInitMetrics.inst().constructAppInfoSubsetEnd;     // Catch: Throwable -> L168
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r11 = convertToCronetThreadConfigInfoList(getThreadConfigInfoList(), r7);     // Catch: Throwable -> L168
        TTNetInitMetrics.inst().constructThreadConfigListEnd = System.nanoTime();     // Catch: Throwable -> L168
        TTNetInitMetrics.inst().constructThreadConfigCallbackStart = TTNetInitMetrics.inst().constructThreadConfigListEnd;     // Catch: Throwable -> L168
        TTThreadConfigInfoProvider.Callback r12 = convertToCronetThreadConfigCallback(getThreadConfigCallbackImpl());     // Catch: Throwable -> L168
        TTNetInitMetrics.inst().constructThreadConfigCallbackEnd = System.nanoTime();     // Catch: Throwable -> L168
        TTNetInitMetrics.inst().constructSlaSamplingSettingStart = TTNetInitMetrics.inst().constructThreadConfigCallbackEnd;     // Catch: Throwable -> L168
        sAppID = Integer.parseInt(r26.getAppId());     // Catch: Exception -> L172 Throwable -> L168
    L29:
        TTSamplingSettingProvider.TTSlaSamplingSetting r13 = convertToCronetSlaSamplingSetting(SlaSamplingSettingCreator.create(getSlaSamplingSetting(), sAppID));     // Catch: Throwable -> L168
        TTNetInitMetrics.inst().constructSlaSamplingSettingEnd = System.nanoTime();     // Catch: Throwable -> L168
        TTNetInitMetrics.inst().buildContextConfigStart = TTNetInitMetrics.inst().constructSlaSamplingSettingEnd;     // Catch: Throwable -> L168
        ExperimentalCronetEngine.Builder r14 = new ExperimentalCronetEngine.Builder(r18, r8).enableQuic(r19).enableHttp2(r20).enableSdch(r21).enableHttpDns(r22).listenAppStateIndependently(getListenAppStateIndependently()).enableNetworkQualityEstimator(true);     // Catch: Throwable -> L168
        if (CronetDependManager.inst().loggerDebug() == false) goto L32;
        r14.enableVerboseLog();     // Catch: Throwable -> L168
    L32:
        TTNetAppInfoSubset r15 = r10;
        boolean r16 = r7;
        r14.setTTNetInitStart(Math.min(TTNetInitMetrics.inst().initTTNetStart, TTNetInitMetrics.inst().createEngineStart));     // Catch: Throwable -> L168
        detectCronetColdStartCrash(r18, r14);     // Catch: Throwable -> L168
        String r6 = "";
        r6 = r18.getCacheDir().getPath() + LibrarianImpl.Constants.SEPARATOR;     // Catch: Throwable -> L43
        r14.setStoragePath(r6 + TTNET_CACHE_DIR);     // Catch: Throwable -> L41
        r14.enableHttpCache(3, getMaxHttpDiskCacheSize());     // Catch: Throwable -> L39
        r6 = r6;
    L46:
        if (sNetworkThreadPriority >= (-20)) goto L48;
    L50:
        int r2 = getAppSecurityLevel();     // Catch: Throwable -> L168
        if (r2 <= 0) goto L54;
        r14.setAppSecurityLevel(r2);     // Catch: Throwable -> L168
    L54:
        if (CronetAppProviderManager.inst().isEnableBrotli() == false) goto L56;
        boolean r5 = true;
        r14.enableBrotli(true);     // Catch: Throwable -> L168
    L58:
        if (CronetAppProviderManager.inst().isEnableQuic() == false) goto L61;
        r14.enableQuic(r5);     // Catch: Throwable -> L168
    L61:
        if (CronetAppProviderManager.inst().isEnableHttp2() == false) goto L63;
        r14.enableHttp2(r5);     // Catch: Throwable -> L168
    L63:
        TTAppSecurityManager.getInstance().setSystemApiSandbox(CronetSystemApiSandbox.inst());     // Catch: Throwable -> L168
        r14.setAppInfoProvider(CronetAppInfoProvider.inst(r18));     // Catch: Throwable -> L168
        r14.setEventListener(CronetEventListener.inst());     // Catch: Throwable -> L168
        r14.setIsMainProcess(ProcessUtils.isMainProcessByProcessFlag(r18));     // Catch: Throwable -> L168
        r14.setProcessName(ProcessUtils.getCurProcessName(r18));     // Catch: Throwable -> L168
        if (ProcessUtils.isMainProcessByProcessFlag(r18) == false) goto L66;
        r14.setAppMonitorProvider(CronetAppMonitorProvider.inst());     // Catch: Throwable -> L168
        CronetEventListener.inst().setIsMainProcess(true);     // Catch: Throwable -> L168
    L66:
        if (r8 == false) goto L68;
        r14.setTTAppInfoColdStartSubset(convertToCronetAppInfo(r15));     // Catch: Throwable -> L168
    L68:
        r14.setOptInit(r8);     // Catch: Throwable -> L168
        r14.setOptNqeInit(r26.getOptNqeDefault(), r26.getOptNqePersist());     // Catch: Throwable -> L168
        r14.setThreadConfigInfoList(r11);     // Catch: Throwable -> L168
        r14.setThreadConfigCallbackImpl(r12);     // Catch: Throwable -> L168
        r14.setLazyInitIPC(r26.getLazyInitCronetIPC());     // Catch: Throwable -> L168
        if (TextUtils.isEmpty(r23) == true) goto L71;
        r14.setUserAgent(r23 + " cronet/TTNetVersion:012c1a21 2025-06-16 QuicVersion:af615fde 2025-06-13");     // Catch: Throwable -> L168
    L71:
        String r3 = getDomainConfigByRegion();     // Catch: Throwable -> L168
        if (TextUtils.isEmpty(r3) == false) goto L75;
        r3 = CronetAppProviderManager.inst().getGetDomainDefaultJSON();     // Catch: Throwable -> L168
    L75:
        if (TextUtils.isEmpty(r3) == true) goto L77;
        r14.setGetDomainDefaultJSON(r3);     // Catch: Throwable -> L168
    L77:
        ArrayList<byte[]> r4 = CronetAppProviderManager.inst().getOpaqueData();     // Catch: Throwable -> L168
        if (r4 != null) goto L80;
    L82:
        Map<String[], Pair<byte[], byte[]>> r9 = CronetAppProviderManager.inst().getClientOpaqueData();     // Catch: Throwable -> L168
        if (r9 != null) goto L85;
    L87:
        Map<String, Pair<Integer, Integer>> r17 = CronetAppProviderManager.inst().getQuicHint();     // Catch: Throwable -> L168
        if (r17 == null) goto L96;
        if (r17.isEmpty() == true) goto L96;
        Iterator<Map.Entry<String, Pair<Integer, Integer>>> r27 = r17.entrySet().iterator();     // Catch: Throwable -> L168
    L93:
        if (r27.hasNext() == false) goto L96;
        Map.Entry<String, Pair<Integer, Integer>> r28 = r27.next();     // Catch: Throwable -> L168
        r14.addQuicHint(r28.getKey(), ((Integer) r28.getValue().first).intValue(), ((Integer) r28.getValue().second).intValue());     // Catch: Throwable -> L168
    L96:
        if (CronetAppProviderManager.inst().needCustomLoadLibrary() == false) goto L98;
        r14.setLibraryLoader(new AnonymousClass3(this));     // Catch: Throwable -> L168
    L98:
        String r29 = CronetAppProviderManager.inst().getCronetSoPath();     // Catch: Throwable -> L168
        if (TextUtils.isEmpty(r29) == true) goto L103;
        String r30 = r29.substring(r29.lastIndexOf(File.separator) + 1);     // Catch: Throwable -> L168
        String r31 = r18.getCacheDir().getAbsolutePath();     // Catch: Throwable -> L168
        if (FileUtils.copyFile(r29, r31, r30) == false) goto L103;
        r14.setCronetSoPath(r31 + File.separator + r30);     // Catch: Throwable -> L168
    L103:
        boolean r32 = CronetAppProviderManager.inst().isBOEProxyEnabled();     // Catch: Throwable -> L168
        if (r32 == false) goto L106;
        r14.enableBoeProxy(true);     // Catch: Throwable -> L168
    L106:
        if (r32 == true) goto L118;
        String r33 = BoeUtils.getConfigFromAssets(r18, TTNET_CONFIG_FILE);     // Catch: Throwable -> L168
        if (TextUtils.isEmpty(r33) == true) goto L118;
        JSONObject r34 = new JSONObject(r33);     // Catch: Throwable -> L116
        String r35 = r34.optString("ttnet_proxy", "");     // Catch: Throwable -> L116
        if (TextUtils.isEmpty(r35) == true) goto L112;
        r14.setProxyConfig(r35);     // Catch: Throwable -> L116
    L112:
        r32 = r34.optBoolean("boe_proxy_enabled", false);     // Catch: Throwable -> L116
        if (r32 == false) goto L118;
        r14.enableBoeProxy(true);     // Catch: Throwable -> L116
    L116:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L168
    L118:
        if (r32 == true) goto L122;
        r32 = BoeUtils.isBoeProxyEnabledByBoeFlag(r18);     // Catch: Throwable -> L168
        if (r32 == false) goto L122;
        r14.enableBoeProxy(true);     // Catch: Throwable -> L168
    L122:
        if (r32 == false) goto L129;
        String r36 = CronetAppProviderManager.inst().getBypassBOEJSON();     // Catch: Throwable -> L168
        if (TextUtils.isEmpty(r36) == true) goto L126;
        r14.setBypassBOEJSON(r36);     // Catch: Throwable -> L168
    L126:
        String r37 = getProxyConfig(r6);     // Catch: Throwable -> L168
        if (TextUtils.isEmpty(r37) == true) goto L129;
        Log.e(TAG, "set proxy config: " + r37);     // Catch: Throwable -> L168
        r14.setProxyConfig(r37);     // Catch: Throwable -> L168
    L129:
        String r38 = CronetAppProviderManager.inst().getStoreIdcRuleJSON();     // Catch: Throwable -> L168
        if (TextUtils.isEmpty(r38) == true) goto L175;
        r14.setStoreIdcRuleJSON(r38);     // Catch: Throwable -> L168
    L175:
        long r39 = getALogFuncAddr();     // Catch: Exception -> L136 Throwable -> L168
        if (r39 == 0) goto L138;
        Log.e(TAG, "set alog address: " + r39);     // Catch: Exception -> L136 Throwable -> L168
        r14.setALogFuncAddr(r39);     // Catch: Exception -> L136 Throwable -> L168
    L138:
        if (r13 == null) goto L140;
        r14.setSlaSamplingSetting(r13);     // Catch: Throwable -> L168
    L140:
        ICronetClient.ICronetThreadStackOptFailureCheckerProvider r40 = sCronetThreadStackOptFailureCheckerProvider;     // Catch: Throwable -> L168
        if (r40 != null) goto L143;
        String r41 = null;
    L144:
        r14.setStackInfo(r16, r41);     // Catch: Throwable -> L168
        TTNetInitMetrics.inst().buildContextConfigEnd = System.nanoTime();     // Catch: Throwable -> L168
        TTNetInitMetrics.inst().buildBuilderStart = TTNetInitMetrics.inst().buildContextConfigEnd;     // Catch: Throwable -> L168
        sCronetEngine = r14.build();     // Catch: Throwable -> L168
        TTNetInitMetrics.inst().buildBuilderEnd = System.nanoTime();     // Catch: Throwable -> L168
        if (CronetDependManager.inst().loggerDebug() == false) goto L147;
        Logger.setLogLevel(2);     // Catch: Throwable -> L168
    L149:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L163;
        ExperimentalCronetEngine r42 = (ExperimentalCronetEngine) sCronetEngine;     // Catch: Throwable -> L168
        long r43 = getALogFuncAddr();     // Catch: Throwable -> L160
        if (r43 == 0) goto L154;
        Log.e(TAG, "ensure setting alog address: " + r43);     // Catch: Throwable -> L160
        r42.setAlogFuncAddr(r43);     // Catch: Throwable -> L160
    L154:
        int r44 = TTAppStateManager.getAppStartUpState();     // Catch: Throwable -> L160
        if (r44 < 0) goto L158;
        if (r44 > 2) goto L158;
        r42.setAppStartUpState(r44);     // Catch: Throwable -> L160
    L158:
        TTNetInitMetrics.inst().initMSSdk(r18, r42.getOpaqueFuncAddress());     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L168
        goto L163
    L147:
        Logger.setLogLevel(4);     // Catch: Throwable -> L168
        goto L149
    L143:
        r41 = r40.getThreadStackInitReason();     // Catch: Throwable -> L168
    L136:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L168
        goto L138
    L85:
        if (r9.isEmpty() == true) goto L87;
        r14.setClientOpaqueData(r9);     // Catch: Throwable -> L168
        goto L87
    L80:
        if (r4.isEmpty() == true) goto L82;
        r14.setOpaqueData(r4);     // Catch: Throwable -> L168
        goto L82
    L56:
        r5 = true;
        goto L58
    L48:
        if (sNetworkThreadPriority > 19) goto L50;
        r14.setThreadPriority(sNetworkThreadPriority);     // Catch: Throwable -> L168
    L39:
        th = th;
        r6 = r6;
    L44:
        Log.w(TAG, "ExperimentalCronetEngine.Builder enable HTTP Cache failed.");     // Catch: Throwable -> L168
        th.printStackTrace();     // Catch: Throwable -> L168
        r14.enableHttpCache(0, 0);     // Catch: Throwable -> L168
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
    L163:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L165;
        ExperimentalCronetEngine r45 = (ExperimentalCronetEngine) sCronetEngine;     // Catch: Throwable -> L168
        tryCreateRequestFinishedInfoListener(r24);     // Catch: Throwable -> L168
        r45.addRequestFinishedListener(sRequestFinishedInfoListener);     // Catch: Throwable -> L168
    L165:
        TTRequestCompressManager.setCompressDataCallback(new AnonymousClass4(this));     // Catch: Throwable -> L168
        TTNetInitMetrics.inst().createEngineEnd = System.nanoTime();     // Catch: Throwable -> L168
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L168
    }

    public static CronetEngine getCronetEngine() {
        if (sCronetEngine == null) goto L7;
        return sCronetEngine;
    L7:
        throw new NullPointerException("Cronet engine is null.");
    }

    private void tryCreateRequestFinishedInfoListener(final Executor r3) {
        if (sRequestFinishedInfoListener == null) goto L5;
        return;
    L5:
        monitor-enter(CronetClient.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (sRequestFinishedInfoListener == null) goto L10;
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L13
        return;
    L10:
        sRequestFinishedInfoListener = new AnonymousClass5(this, r3);     // Catch: Throwable -> L13
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L13
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public boolean isCronetHttpURLConnection(HttpURLConnection r1) {
        return r1 instanceof CronetHttpURLConnection;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public Map<String, Object> getRequestMetricsMap(HttpURLConnection r7) {
        LinkedHashMap r0 = null;
        if (r7 != null) goto L6;
        return null;
    L6:
        if (isCronetHttpURLConnection(r7) == true) goto L22;
        return null;
    L22:
        CronetHttpURLConnection r8 = (CronetHttpURLConnection) r7;     // Catch: Throwable -> L17
        RequestFinishedInfo r6 = r8.getRequestFinishedInfo();     // Catch: Throwable -> L17
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L17
        if (r6 != null) goto L20;
    L13:
        r1.put("request_log", r8.getRequestLog());     // Catch: Throwable -> L15
        return r1;
    L15:
        th = th;
        r0 = r1;
    L18:
        th.printStackTrace();
        return r0;
    L20:
        if (r6.getMetrics() == null) goto L13;
        RequestFinishedInfo.Metrics r9 = r6.getMetrics();     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_REMOTE_IP, r9.getPeerAddr() + SimContactsConstants.ANR_SEP + r9.getPeerPort());     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_DNS_TIME, Long.valueOf(getCostTime(getTime(r9.getDnsEnd()), getTime(r9.getDnsStart()))));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_CONNECT_TIME, Long.valueOf(getCostTime(getTime(r9.getConnectEnd()), getTime(r9.getConnectStart()))));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_SSL_TIME, Long.valueOf(getCostTime(getTime(r9.getSslEnd()), getTime(r9.getSslStart()))));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_SEND_TIME, Long.valueOf(getCostTime(getTime(r9.getSendingEnd()), getTime(r9.getSendingStart()))));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_PUSH_TIME, Long.valueOf(getCostTime(getTime(r9.getPushEnd()), getTime(r9.getPushStart()))));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_RECEIVE_TIME, Long.valueOf(getCostTime(getTime(r9.getRequestEnd()), getTime(r9.getResponseStart()))));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_SOCKET_REUSED, Boolean.valueOf(r9.getSocketReused()));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_TTFB, Long.valueOf(getValue(r9.getTtfbMs())));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_TOTAL_TIME, Long.valueOf(getValue(r9.getTotalTimeMs())));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_SEND_BYTE_COUNT, Long.valueOf(getValue(r9.getSentByteCount())));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_RECEIVED_BYTE_COUNT, Long.valueOf(getValue(r9.getReceivedByteCount())));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_RETRY_ATTEMPTS, Long.valueOf(getValue(r9.getRetryAttempts())));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_REQUEST_HEADERS, r9.getRequestHeaders());     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_RESPONSE_HEADERS, r9.getResponseHeaders());     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_REQUEST_START, Long.valueOf(getTime(r9.getRequestStart())));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_POST_TASK_START, Long.valueOf(getTime(r9.getPostTaskStartMs())));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_WAIT_CONTEXT, Long.valueOf(getCostTime(getTime(r9.getRequestStart()), getTime(r9.getPostTaskStartMs()))));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_UPPER_ADD_COOKIE_US, r9.getAddCookieCostUs());     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_UPPER_SAVE_COOKIE_US, r9.getSaveCookieCostUs());     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_REQ_COOKIE_SOURCE_TYPE, r9.getRequestCookieSource());     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_PRE_SAMPLING_REPORTABLE, Boolean.valueOf(r9.getPreSamplingReportable()));     // Catch: Throwable -> L15
        r1.put(ICronetClient.KEY_BYPASS_API_REPORT, Boolean.valueOf(r9.getBypassApiReport()));     // Catch: Throwable -> L15
    L17:
        th = th;
        goto L18
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getCronetInternalErrorCode(HttpURLConnection r2) {
        if ((r2 instanceof CronetHttpURLConnection) == true) goto L6;
        return 0;
    L6:
        return ((CronetHttpURLConnection) r2).getCronetInternalErrorCode();
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
        if (CronetDependManager.inst().loggerDebug() == false) goto L6;
        CronetDependManager.inst().loggerD(TAG, "triggerGetDomain start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).triggerGetDomain(r3);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void runInBackGround(boolean r3) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (CronetDependManager.inst().loggerDebug() == false) goto L6;
        CronetDependManager.inst().loggerD(TAG, "runInBackGround start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).runInBackGround(r3);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void addClientOpaqueData(String[] r9, byte[] r10, byte[] r11, long r12, long r14) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (CronetDependManager.inst().loggerDebug() == false) goto L6;
        CronetDependManager.inst().loggerD(TAG, "addClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).addClientOpaqueData(r9, r10, r11, r12, r14);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void clearClientOpaqueData() {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (CronetDependManager.inst().loggerDebug() == false) goto L6;
        CronetDependManager.inst().loggerD(TAG, "clearClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).clearClientOpaqueData();     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void removeClientOpaqueData(String r3) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (CronetDependManager.inst().loggerDebug() == false) goto L6;
        CronetDependManager.inst().loggerD(TAG, "removeClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).removeClientOpaqueData(r3);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public TTDispatchResult ttUrlDispatch(String r8, int r9, boolean r10) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L11;
        Map<String, String> r7 = ((ExperimentalCronetEngine) sCronetEngine).ttUrlDispatch(r8, r9, r10);
        String r2 = r7.get(URLDispatch.KEY_FINAL_URL);
        if (TextUtils.isEmpty(r2) == true) goto L9;
        new URL(r2).toURI();
        return new TTDispatchResult(r8, r2, r7.get(URLDispatch.KEY_EPOCH), r7.get(URLDispatch.KEY_ETAG), TTDispatchResult.DispatchState.SUCCESS, r7.get(URLDispatch.KEY_TTNET_ORIGIN_HOST));
    L9:
        throw new UnknownFormatConversionException("ttUrlDispatch returns wrong format");
    L11:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void preconnectUrl(String r2, Map<String, String> r3) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).preconnectUrl(r2, 1, r3);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void tryStartNetDetect(String[] r1, int r2, int r3) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).tryStartNetDetect(r1, r2, r3);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void ttDnsResolve(String r1, int r2, String r3, Map<String, String> r4) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).ttDnsResolve(r1, r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void getMappingRequestState(final String r3) {
        CronetUrlRequest r0 = CronetUrlRequestMapping.GetRequest(r3);     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        r0.getStatus(new AnonymousClass6(this, r3));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveConnectionType() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveConnectionType();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void notifyTNCConfigUpdated(String r8, String r9, String r10, String r11, String r12, String r13) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).notifyTNCConfigUpdated(r8, r9, r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void notifyStoreRegionUpdated(String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).updateStoreRegionFromServer(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setProxy(String r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setProxy(r1);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public NetworkQuality getNetworkQuality() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ExperimentalCronetEngine r2 = (ExperimentalCronetEngine) sCronetEngine;
        NetworkQuality r0 = new NetworkQuality();
        r0.transportRttMs = r2.getTransportRttMs();
        r0.httpRttMs = r2.getHttpRttMs();
        r0.downstreamThroughputKbps = r2.getDownstreamThroughputKbps();
        return r0;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public PacketLossMetrics getPacketLossRateMetrics(int r4) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        PacketLossMetrics r3 = new PacketLossMetrics();
        ExperimentalCronetEngine r0 = (ExperimentalCronetEngine) sCronetEngine;
        r3.protocol = r4;
        r3.upstreamLossRate = r0.getUpstreamPacketLossRate(r4);
        r3.upstreamLossRateVariance = r0.getUpstreamPacketLossRateVariance(r4);
        r3.downstreamLossRate = r0.getDownstreamPacketLossRate(r4);
        r3.downstreamLossRateVariance = r0.getDownstreamPacketLossRateVariance(r4);
        return r3;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public Map<String, NetworkQuality> getGroupRttEstimates() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ExperimentalCronetEngine r5 = (ExperimentalCronetEngine) sCronetEngine;
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<String, int[]>> r6 = r5.getGroupRttEstimates().entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L12;
        Map.Entry<String, int[]> r1 = r6.next();
        if (r1.getValue().length != 2) goto L11;
        NetworkQuality r2 = new NetworkQuality();
        r2.transportRttMs = r1.getValue()[0];
        r2.httpRttMs = r1.getValue()[1];
        r2.downstreamThroughputKbps = -1;
        r0.put(r1.getKey(), r2);
        goto L6
    L11:
        throw new UnknownFormatConversionException("getGroupRttEstimates returns wrong format");
    L12:
        return r0;
    L14:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setHostResolverRules(String r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setHostResolverRules(r1);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setAlogFuncAddr(long r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setAlogFuncAddr(r1);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setZstdFuncAddr(long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setZstdFuncAddr(r19, r21, r23, r25, r27, r29, r31, r33);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void startThrottle(String[] r1, int r2, long r3) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).startThrottle(r1, r2, r3);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void stopThrottle(String[] r1, int r2) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).stopThrottle(r1, r2);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setBestHostWithRouteSelectionName(String r1, String r2) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setRouteSelectionBestHost(r1, r2);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCookieInitCompleted() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setCookieInitCompleted();
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public boolean notifySwitchToMultiNetwork(boolean r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).notifySwitchToMultiNetwork(r1);
        return true;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void triggerSwitchingToCellular() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).triggerWiFiToCellularByThirdParty();
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getNetworkQualityLevel() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getNetworkQualityLevel();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveHttpRttMs() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveHttpRtt();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveTransportRttMs() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveTransportRtt();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveRxThroughputKbps() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveRxThroughput();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void reportNetDiagnosisUserLog(String r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).reportNetDiagnosisUserLog(r1);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void enableTTBizHttpDns(boolean r8, String r9, String r10, String r11, boolean r12, String r13) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).enableTTBizHttpDns(r8, r9, r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void bindBigCore(TTNetThreadConfig.ThreadType r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).bindBigCore(r1.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void bindLittleCore(TTNetThreadConfig.ThreadType r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).bindLittleCore(r1.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void resetCoreBind(TTNetThreadConfig.ThreadType r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).resetCoreBind(r1.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setSlaSamplingSetting(JSONObject r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L10;
        TTSamplingSettingProvider.TTSlaSamplingSetting r0 = convertToCronetSlaSamplingSetting(SlaSamplingSettingCreator.create(r1, sAppID));
        if (r0 != null) goto L7;
        return;
    L7:
        ((ExperimentalCronetEngine) sCronetEngine).addSamplingSetting(r0);
        return;
    L10:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    private static long getTime(Date r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.getTime();
    }

    private static long getValue(Long r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.longValue();
    }

    public static void setAppStartUpState(int r1) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setAppStartUpState(r1);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    private static long getALogFuncAddr() throws Exception {
        return ((Long) Reflect.on(Class.forName(TTNET_ALOG_CLASS).newInstance()).call("getALogFuncAddr").get()).longValue();
    }

    private static boolean getListenAppStateIndependently() {
        return ((Boolean) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getListenAppStateIndependently").get()).booleanValue();
    L4:
        return false;
    }

    private static String getDomainConfigByRegion() {
        String r0 = CronetAppProviderManager.inst().getCarrierRegion();
        String r1 = CronetAppProviderManager.inst().getSysRegion();
        String r2 = CronetAppProviderManager.inst().getRegion();
        if (TextUtils.isEmpty(r0) == false) goto L10;
        if (TextUtils.isEmpty(r1) == true) goto L8;
        r0 = r1;
        goto L10
    L8:
        r0 = r2;
    L10:
        if (TextUtils.isEmpty(r0) == false) goto L15;
        return null;
    L15:
        return (String) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getGetDomainConfigByRegion", new Class[]{String.class}, new Object[]{r0}).get();
    L14:
        return null;
    }

    private static long getMaxHttpDiskCacheSize() {
        return ((Long) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getMaxHttpDiskCacheSize").get()).longValue();
    L4:
        return 67108864;
    }

    private static JSONObject getSlaSamplingSetting() {
        return (JSONObject) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getSlaSamplingSetting").get();
    L4:
        return null;
    }

    private static int getAppSecurityLevel() {
        return ((Integer) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getAppSecurityLevel").get()).intValue();
    L4:
        return 0;
    }

    private static ArrayList<TTNetThreadConfig> getThreadConfigInfoList() {
        return (ArrayList) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getThreadConfigInfoList").get();
    L4:
        return null;
    }

    private static TTNetThreadConfig.Callback getThreadConfigCallbackImpl() {
        return (TTNetThreadConfig.Callback) Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getThreadConfigCallbackImpl").get();
    L4:
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
}
