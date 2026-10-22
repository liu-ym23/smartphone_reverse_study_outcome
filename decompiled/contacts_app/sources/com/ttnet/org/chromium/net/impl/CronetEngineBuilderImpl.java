package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.librarian.LibrarianImpl;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ICronetEngineBuilder;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.TTMonitorProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CronetEngineBuilderImpl extends ICronetEngineBuilder {
    private static final Pattern INVALID_PKP_HOST_NAME = null;
    private static final int INVALID_THREAD_PRIORITY = 20;
    private static final String JAVA_CRONET_IMPL_CLASS = "com.ttnet.org.chromium.net.impl.JavaCronetEngine";
    private static final String NATIVE_CRONET_IMPL_CLASS = "com.ttnet.org.chromium.net.impl.CronetUrlRequestContext";
    private static String TAG;
    private long mALogFuncAddr;
    private TTAppInfoProvider mAppInfoProvider;
    private TTAppInfoProvider.AppInfo mAppInfoSubset;
    private TTMonitorProvider mAppMonitorProvider;
    private int mAppSecurityLevel;
    private final Context mApplicationContext;
    private String mBoeJson;
    private boolean mBoeProxyEnabled;
    private boolean mBrotiEnabled;
    private TTThreadConfigInfoProvider.Callback mCallback;
    private Map<String[], Pair<byte[], byte[]>> mClientOpaqueData;
    private String mCronetSoPath;
    private boolean mDisableCache;
    private TTEventListener mEventListener;
    private String mExperimentalOptions;
    private String mGetDomainDefaultJSON;
    private boolean mHttp2Enabled;
    private long mHttpCacheMaxSize;
    private HttpCacheMode mHttpCacheMode;
    private boolean mHttpDnsEnabled;
    private boolean mIsMainProcess;
    private boolean mLazyInitIPC;
    private boolean mListenAppStateIndependently;
    protected long mMockCertVerifier;
    private boolean mNetworkQualityEstimatorEnabled;
    private ArrayList<byte[]> mOpaqueData;
    private boolean mOptInit;
    private boolean mOptNqeDefault;
    private boolean mOptNqePersist;
    private boolean mOptStack;
    private final List<Pkp> mPkps;
    private String mProcessName;
    private String mProxyConfig;
    private boolean mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
    private boolean mQuicEnabled;
    private final List<QuicHint> mQuicHints;
    private TTSamplingSettingProvider.TTSlaSamplingSetting mSlaSamplingSetting;
    private String mStoragePath;
    private String mStoreIdcRuleJson;
    private long mTTNetInitStart;
    private ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> mThreadConfigInfoList;
    private int mThreadPriority;
    private String mThreadStackInitReason;
    private boolean mTncSecureModeEnabled;
    private String mUserAgent;
    private boolean mVerboseLogEnabled;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode = null;

        static {
            int[] r0 = new int[HttpCacheMode.values().length];
            $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode = r0;
            r0[HttpCacheMode.DISABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode[HttpCacheMode.DISK_NO_HTTP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode[HttpCacheMode.DISK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode[HttpCacheMode.MEMORY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static final enum HttpCacheMode extends Enum<HttpCacheMode> {
        private static final /* synthetic */ HttpCacheMode[] $VALUES = null;
        public static final HttpCacheMode DISABLED = null;
        public static final HttpCacheMode DISK = null;
        public static final HttpCacheMode DISK_NO_HTTP = null;
        public static final HttpCacheMode MEMORY = null;
        private final boolean mContentCacheEnabled;
        private final int mType;

        public static HttpCacheMode valueOf(String r1) {
            return (HttpCacheMode) Enum.valueOf(HttpCacheMode.class, r1);
        }

        public static HttpCacheMode[] values() {
            return (HttpCacheMode[]) $VALUES.clone();
        }

        static {
            HttpCacheMode r0 = new HttpCacheMode("DISABLED", 0, 0, false);
            DISABLED = r0;
            HttpCacheMode r1 = new HttpCacheMode("DISK", 1, 1, true);
            DISK = r1;
            HttpCacheMode r3 = new HttpCacheMode("DISK_NO_HTTP", 2, 1, false);
            DISK_NO_HTTP = r3;
            HttpCacheMode r5 = new HttpCacheMode("MEMORY", 3, 2, true);
            MEMORY = r5;
            $VALUES = new HttpCacheMode[]{r0, r1, r3, r5};
        }

        private HttpCacheMode(String r1, int r2, int r3, boolean r4) {
            super(r1, r2);
            this.mContentCacheEnabled = r4;
            this.mType = r3;
        }

        int getType() {
            return this.mType;
        }

        boolean isContentCacheEnabled() {
            return this.mContentCacheEnabled;
        }

        int toPublicBuilderCacheMode() {
            int r2 = AnonymousClass1.$SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode[ordinal()];
            if (r2 == 1) goto L14;
            int r1 = 2;
            if (r2 == 2) goto L13;
            r1 = 3;
            if (r2 == 3) goto L13;
            if (r2 != 4) goto L12;
            return 1;
        L12:
            throw new IllegalArgumentException("Unknown internal builder cache mode");
        L13:
            return r1;
        L14:
            return 0;
        }

        static HttpCacheMode fromPublicBuilderCacheMode(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 != 3) goto L12;
            return DISK;
        L12:
            throw new IllegalArgumentException("Unknown public builder cache mode");
        L14:
            return DISK_NO_HTTP;
        L16:
            return MEMORY;
        L18:
            return DISABLED;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpCacheSetting {
    }

    public static class Pkp {
        final Date mExpirationDate;
        final byte[][] mHashes;
        final String mHost;
        final boolean mIncludeSubdomains;

        Pkp(String r1, byte[][] r2, boolean r3, Date r4) {
            this.mHost = r1;
            this.mHashes = r2;
            this.mIncludeSubdomains = r3;
            this.mExpirationDate = r4;
        }
    }

    public static class QuicHint {
        final int mAlternatePort;
        final String mHost;
        final int mPort;

        QuicHint(String r1, int r2, int r3) {
            this.mHost = r1;
            this.mPort = r2;
            this.mAlternatePort = r3;
        }
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableSdch(boolean r1) {
        return this;
    }

    VersionSafeCallbacks.LibraryLoader libraryLoader() {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setLibraryLoader(CronetEngine.Builder.LibraryLoader r1) {
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder addPublicKeyPins(String r1, Set r2, boolean r3, Date r4) {
        return addPublicKeyPins(r1, r2, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder addQuicHint(String r1, int r2, int r3) {
        return addQuicHint(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableBoeProxy(boolean r1) {
        return enableBoeProxy(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableBrotli(boolean r1) {
        return enableBrotli(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttp2(boolean r1) {
        return enableHttp2(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttpCache(int r1, long r2) {
        return enableHttpCache(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttpDns(boolean r1) {
        return enableHttpDns(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableNetworkQualityEstimator(boolean r1) {
        return enableNetworkQualityEstimator(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r1) {
        return enablePublicKeyPinningBypassForLocalTrustAnchors(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableQuic(boolean r1) {
        return enableQuic(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableSdch(boolean r1) {
        return enableSdch(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableTncSecureMode(boolean r1) {
        return enableTncSecureMode(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableVerboseLog() {
        return enableVerboseLog();
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder listenAppStateIndependently(boolean r1) {
        return listenAppStateIndependently(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setALogFuncAddr(long r1) {
        return setALogFuncAddr(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppInfoProvider(TTAppInfoProvider r1) {
        return setAppInfoProvider(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppMonitorProvider(TTMonitorProvider r1) {
        return setAppMonitorProvider(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppSecurityLevel(int r1) {
        return setAppSecurityLevel(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setBypassBOEJSON(String r1) {
        return setBypassBOEJSON(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setClientOpaqueData(Map r1) {
        return setClientOpaqueData(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setEventListener(TTEventListener r1) {
        return setEventListener(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setExperimentalOptions(String r1) {
        return setExperimentalOptions(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setGetDomainDefaultJSON(String r1) {
        return setGetDomainDefaultJSON(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setIsMainProcess(boolean r1) {
        return setIsMainProcess(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setLazyInitIPC(boolean r1) {
        return setLazyInitIPC(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader r1) {
        return setLibraryLoader(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOpaqueData(ArrayList r1) {
        return setOpaqueData(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOptInit(boolean r1) {
        return setOptInit(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOptNqeInit(boolean r1, boolean r2) {
        return setOptNqeInit(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setProcessName(String r1) {
        return setProcessName(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setProxyConfig(String r1) {
        return setProxyConfig(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r1) {
        return setSlaSamplingSetting(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStackInfo(boolean r1, String r2) {
        return setStackInfo(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStoragePath(String r1) {
        return setStoragePath(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStoreIdcRuleJSON(String r1) {
        return setStoreIdcRuleJSON(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r1) {
        return setTTAppInfoColdStartSubset(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setTTNetInitStart(long r1) {
        return setTTNetInitStart(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r1) {
        return setThreadConfigCallbackImpl(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadConfigInfoList(ArrayList r1) {
        return setThreadConfigInfoList(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadPriority(int r1) {
        return setThreadPriority(r1);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setUserAgent(String r1) {
        return setUserAgent(r1);
    }

    static {
        INVALID_PKP_HOST_NAME = Pattern.compile("^[0-9\\.]*$");
    }

    public CronetEngineBuilderImpl(Context r4, boolean r5) {
        this.mQuicHints = new LinkedList();
        this.mPkps = new LinkedList();
        this.mThreadPriority = 20;
        this.mApplicationContext = r4.getApplicationContext();
        enableQuic(true);
        enableHttp2(true);
        enableBrotli(false);
        enableHttpCache(0, 0);
        enableNetworkQualityEstimator(false);
        enablePublicKeyPinningBypassForLocalTrustAnchors(true);
        enableHttpDns(false);
        listenAppStateIndependently(false);
        if (r5 == true) goto L5;
        TAG = "CronetEngineBuilderImpl";
        return;
    L5:
        TAG = "CronetEngineBuilderImpl";
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public String getDefaultUserAgent() {
        return UserAgent.from(this.mApplicationContext);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setUserAgent(String r1) {
        this.mUserAgent = r1;
        return this;
    }

    String getUserAgent() {
        return this.mUserAgent;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setStoragePath(String r3) {
        File r0 = new File(r3);
        if (r0.exists() == true) goto L10;
        if (r0.mkdirs() == true) goto L10;
        throw new IllegalArgumentException("create Storage path failed");
    L10:
        if (r0.isDirectory() == false) goto L14;
        this.mStoragePath = r3;
        return this;
    L14:
        throw new IllegalArgumentException("Storage path must be set to existing directory");
    }

    String storagePath() {
        return this.mStoragePath;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableQuic(boolean r1) {
        this.mQuicEnabled = r1;
        return this;
    }

    boolean quicEnabled() {
        return this.mQuicEnabled;
    }

    String getDefaultQuicUserAgentId() {
        if (this.mQuicEnabled == true) goto L7;
        return "";
    L7:
        return UserAgent.getQuicUserAgentIdFrom(this.mApplicationContext);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttp2(boolean r1) {
        this.mHttp2Enabled = r1;
        return this;
    }

    boolean http2Enabled() {
        return this.mHttp2Enabled;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableBrotli(boolean r1) {
        this.mBrotiEnabled = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttpDns(boolean r1) {
        this.mHttpDnsEnabled = r1;
        return this;
    }

    boolean httpDnsEnabled() {
        return this.mHttpDnsEnabled;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl listenAppStateIndependently(boolean r1) {
        this.mListenAppStateIndependently = r1;
        return this;
    }

    boolean getListenAppStateIndependently() {
        return this.mListenAppStateIndependently;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableVerboseLog() {
        this.mVerboseLogEnabled = true;
        return this;
    }

    boolean verboseLogEnabled() {
        return this.mVerboseLogEnabled;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setAppInfoProvider(TTAppInfoProvider r1) {
        this.mAppInfoProvider = r1;
        return this;
    }

    TTAppInfoProvider getAppInfoProvider() {
        return this.mAppInfoProvider;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setAppMonitorProvider(TTMonitorProvider r1) {
        this.mAppMonitorProvider = r1;
        return this;
    }

    TTMonitorProvider getAppMonitorProvider() {
        return this.mAppMonitorProvider;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setEventListener(TTEventListener r1) {
        this.mEventListener = r1;
        return this;
    }

    TTEventListener getEventListener() {
        return this.mEventListener;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setGetDomainDefaultJSON(String r1) {
        this.mGetDomainDefaultJSON = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setOpaqueData(ArrayList<byte[]> r1) {
        this.mOpaqueData = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r1) {
        this.mClientOpaqueData = r1;
        return this;
    }

    String getGetDomainDefaultJSON() {
        return this.mGetDomainDefaultJSON;
    }

    ArrayList<byte[]> getOpaqueData() {
        return this.mOpaqueData;
    }

    Map<String[], Pair<byte[], byte[]>> getClientOpaqueData() {
        return this.mClientOpaqueData;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setBypassBOEJSON(String r1) {
        this.mBoeJson = r1;
        return this;
    }

    String getBypassBOEJSON() {
        return this.mBoeJson;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setStoreIdcRuleJSON(String r1) {
        this.mStoreIdcRuleJson = r1;
        return this;
    }

    String getStoreIdcRuleJSON() {
        return this.mStoreIdcRuleJson;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setProxyConfig(String r1) {
        this.mProxyConfig = r1;
        return this;
    }

    String getProxyConfig() {
        return this.mProxyConfig;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setCronetSoPath(String r1) {
        this.mCronetSoPath = r1;
        return this;
    }

    public String getCronetSoPath() {
        return this.mCronetSoPath;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableBoeProxy(boolean r1) {
        this.mBoeProxyEnabled = r1;
        return this;
    }

    boolean boeProxyEnabled() {
        return this.mBoeProxyEnabled;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableTncSecureMode(boolean r1) {
        this.mTncSecureModeEnabled = r1;
        return this;
    }

    boolean tncSecureModeEnabled() {
        return this.mTncSecureModeEnabled;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setALogFuncAddr(long r1) {
        this.mALogFuncAddr = r1;
        return this;
    }

    long aLogFuncAddr() {
        return this.mALogFuncAddr;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setAppSecurityLevel(int r1) {
        this.mAppSecurityLevel = r1;
        return this;
    }

    int getAppSecurityLevel() {
        return this.mAppSecurityLevel;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setIsMainProcess(boolean r1) {
        this.mIsMainProcess = r1;
        return this;
    }

    boolean isMainProcess() {
        return this.mIsMainProcess;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setLazyInitIPC(boolean r1) {
        this.mLazyInitIPC = r1;
        return this;
    }

    boolean lazyInitIPC() {
        return this.mLazyInitIPC;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setProcessName(String r1) {
        this.mProcessName = r1;
        return this;
    }

    String processName() {
        return this.mProcessName;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r1) {
        this.mAppInfoSubset = r1;
        return this;
    }

    TTAppInfoProvider.AppInfo TTAppInfoSubset() {
        return this.mAppInfoSubset;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setOptInit(boolean r1) {
        this.mOptInit = r1;
        return this;
    }

    boolean optInit() {
        return this.mOptInit;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setOptNqeInit(boolean r1, boolean r2) {
        this.mOptNqeDefault = r1;
        this.mOptNqePersist = r2;
        return this;
    }

    boolean optNqeDefault() {
        return this.mOptNqeDefault;
    }

    boolean optNqePersist() {
        return this.mOptNqePersist;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setTTNetInitStart(long r1) {
        this.mTTNetInitStart = r1;
        return this;
    }

    long ttnetInitStart() {
        return this.mTTNetInitStart;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setThreadConfigInfoList(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r1) {
        this.mThreadConfigInfoList = r1;
        return this;
    }

    ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> threadConfigInfoList() {
        return this.mThreadConfigInfoList;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r1) {
        this.mCallback = r1;
        return this;
    }

    TTThreadConfigInfoProvider.Callback threadConfigCallbackImpl() {
        return this.mCallback;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r1) {
        this.mSlaSamplingSetting = r1;
        return this;
    }

    TTSamplingSettingProvider.TTSlaSamplingSetting samplingSetting() {
        return this.mSlaSamplingSetting;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setStackInfo(boolean r1, String r2) {
        this.mOptStack = r1;
        this.mThreadStackInitReason = r2;
        return this;
    }

    boolean optStack() {
        return this.mOptStack;
    }

    String threadStackInitReason() {
        return this.mThreadStackInitReason;
    }

    boolean brotliEnabled() {
        return this.mBrotiEnabled;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttpCache(int r3, long r4) {
        HttpCacheMode r5 = HttpCacheMode.fromPublicBuilderCacheMode(r3);
        if (r5.getType() == 1) goto L5;
    L9:
        this.mHttpCacheMode = r5;
        this.mHttpCacheMaxSize = r4;
        return this;
    L5:
        if (storagePath() != null) goto L9;
        throw new IllegalArgumentException("Storage path must be set");
    }

    boolean cacheDisabled() {
        return !this.mHttpCacheMode.isContentCacheEnabled();
    }

    long httpCacheMaxSize() {
        return this.mHttpCacheMaxSize;
    }

    int httpCacheMode() {
        return this.mHttpCacheMode.getType();
    }

    int publicBuilderHttpCacheMode() {
        return this.mHttpCacheMode.toPublicBuilderCacheMode();
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl addQuicHint(String r3, int r4, int r5) {
        if (r3.contains(LibrarianImpl.Constants.SEPARATOR) == true) goto L7;
        this.mQuicHints.add(new QuicHint(r3, r4, r5));
        return this;
    L7:
        throw new IllegalArgumentException("Illegal QUIC Hint Host: " + r3);
    }

    List<QuicHint> quicHints() {
        return this.mQuicHints;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl addPublicKeyPins(String r5, Set<byte[]> r6, boolean r7, Date r8) {
        if (r5 == null) goto L22;
        if (r6 == null) goto L20;
        if (r8 == null) goto L18;
        String r9 = validateHostNameForPinningAndConvert(r5);
        HashMap r0 = new HashMap();
        Iterator<byte[]> r10 = r6.iterator();
    L7:
        if (r10.hasNext() == false) goto L15;
        byte[] r1 = r10.next();
        if (r1 == null) goto L14;
        if (r1.length != 32) goto L14;
        r0.put(Base64.encodeToString(r1, 0), r1);
    L14:
        throw new IllegalArgumentException("Public key pin is invalid");
    L15:
        this.mPkps.add(new Pkp(r9, (byte[][]) r0.values().toArray(new byte[r0.size()][]), r7, r8));
        return this;
    L18:
        throw new NullPointerException("The pin expiration date cannot be null");
    L20:
        throw new NullPointerException("The set of SHA256 pins cannot be null");
    L22:
        throw new NullPointerException("The hostname cannot be null");
    }

    List<Pkp> publicKeyPins() {
        return this.mPkps;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r1) {
        this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled = r1;
        return this;
    }

    boolean publicKeyPinningBypassForLocalTrustAnchorsEnabled() {
        return this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
    }

    private static String validateHostNameForPinningAndConvert(String r3) throws IllegalArgumentException {
        boolean r0 = INVALID_PKP_HOST_NAME.matcher(r3).matches();     // Catch: IllegalArgumentException -> L4
    L6:
        if (r0 == true) goto L17;
        if (r3.length() > 255) goto L15;
        return IDN.toASCII(r3, 2);
    L13:
        throw new IllegalArgumentException("Hostname " + r3 + " is illegal. The name of the host does not comply with RFC 1122 and RFC 1123.");
    L15:
        throw new IllegalArgumentException("Hostname " + r3 + " is too long. The name of the host does not comply with RFC 1122 and RFC 1123.");
    L17:
        throw new IllegalArgumentException("Hostname " + r3 + " is illegal. A hostname should not consist of digits and/or dots only.");
    L4:
        r0 = false;
        goto L6
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setExperimentalOptions(String r1) {
        this.mExperimentalOptions = r1;
        return this;
    }

    public String experimentalOptions() {
        return this.mExperimentalOptions;
    }

    public CronetEngineBuilderImpl setMockCertVerifierForTesting(long r1) {
        this.mMockCertVerifier = r1;
        return this;
    }

    long mockCertVerifier() {
        return this.mMockCertVerifier;
    }

    boolean networkQualityEstimatorEnabled() {
        return this.mNetworkQualityEstimatorEnabled;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableNetworkQualityEstimator(boolean r1) {
        this.mNetworkQualityEstimatorEnabled = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setThreadPriority(int r2) {
        if (r2 > 19) goto L9;
        if (r2 < (-20)) goto L9;
        this.mThreadPriority = r2;
        return this;
    L9:
        throw new IllegalArgumentException("Thread priority invalid");
    }

    int threadPriority(int r2) {
        int r1 = this.mThreadPriority;
        if (r1 != 20) goto L6;
        return r2;
    L6:
        return r1;
    }

    Context getContext() {
        return this.mApplicationContext;
    }
}
