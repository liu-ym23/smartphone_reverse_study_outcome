package com.apm.insight;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.runtime.ConfigManager;
import e2.C1404a;
import e2.C1406c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import o2.RunnableC1757b;
import v2.RunnableC2056a;
import z2.i;
import z2.k;
import z2.l;

/* loaded from: classes2.dex */
public class MonitorCrash {
    private static final String TAG = "MonitorCrash";
    private static volatile boolean sAppMonitorCrashInit = false;
    static String sDefaultApplogUrl;
    private volatile boolean isAppLogInit;
    volatile C1406c mApmApplogConfig;
    Config mConfig;
    private Context mContext;
    AttachUserData mCustomData;
    AttachUserData mCustomLongData;
    private boolean mIsApp;
    HeaderParams mParams;
    private AtomicBoolean mStarted;
    Map<String, String> mTagMap;

    public static class Config {

        /* renamed from: a, reason: collision with root package name */
        public String f2147a;
        public String b;
        public String c;
        public String e;
        public String[] f;
        public String[] g;
        public AttachUserData h;
        public String i;

        /* renamed from: j, reason: collision with root package name */
        public String f2148j;
        public String k;
        public C1406c l;
        public String n;
        public IDynamicParams o;
        public long d = -1;
        public boolean m = false;
        public Map p = null;

        /* renamed from: q, reason: collision with root package name */
        public boolean f2149q = true;

        /* renamed from: r, reason: collision with root package name */
        public boolean f2150r = false;

        /* renamed from: s, reason: collision with root package name */
        public boolean f2151s = true;

        /* renamed from: t, reason: collision with root package name */
        public boolean f2152t = true;

        public static class Builder {

            /* renamed from: a, reason: collision with root package name */
            public Config f2153a;

            public Builder autoStart(boolean z10) {
                this.f2153a.f2152t = z10;
                return this;
            }

            public Config build() {
                return this.f2153a;
            }

            public Builder channel(@NonNull String str) {
                this.f2153a.c = str;
                return this;
            }

            public Builder crashProtect(boolean z10) {
                g.f2163r = z10;
                return this;
            }

            public Builder customData(@NonNull AttachUserData attachUserData) {
                this.f2153a.h = attachUserData;
                return this;
            }

            public Builder customFile(CrashInfoCallback crashInfoCallback) {
                CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) k.f.f;
                if (!copyOnWriteArrayList.contains(crashInfoCallback)) {
                    copyOnWriteArrayList.add(crashInfoCallback);
                }
                return this;
            }

            public Builder debugMode(boolean z10) {
                Npth.getConfigManager().setDebugMode(z10);
                return this;
            }

            public Builder dynamicParams(@NonNull IDynamicParams iDynamicParams) {
                this.f2153a.o = iDynamicParams;
                return this;
            }

            public Builder enableApmPlusLog(boolean z10) {
                Npth.getConfigManager().setApmPLusLogEnable(z10);
                return this;
            }

            public Builder enableOptimizer(boolean z10) {
                g.f2168x = z10;
                return this;
            }

            public Builder exitType(ExitType exitType) {
                g.f2162q = exitType.type;
                return this;
            }

            public Builder networkClient(f2.a aVar) {
                if (aVar != null) {
                    g.p = aVar;
                    C1404a.f4333j = aVar;
                }
                this.f2153a.f2149q = false;
                return this;
            }

            public Builder pageViewTags(Map<String, String> map) {
                this.f2153a.p = map;
                return this;
            }

            public Builder token(@NonNull String str) {
                this.f2153a.b = str;
                return this;
            }

            public Builder traceDump(boolean z10) {
                g.f2164s = z10;
                return this;
            }

            public Builder url(@NonNull String str) {
                Config config = this.f2153a;
                config.n = str;
                config.f2149q = false;
                return this;
            }

            public Builder versionCode(long j5) {
                this.f2153a.d = j5;
                return this;
            }

            public Builder versionName(@NonNull String str) {
                this.f2153a.e = str;
                return this;
            }
        }

        public interface IDynamicParams {
            String getDid();

            String getUserId();
        }

        public static class SdkBuilder {

            /* renamed from: a, reason: collision with root package name */
            public Config f2154a;

            public SdkBuilder acceptWithActivity(boolean z10) {
                this.f2154a.m = z10;
                return this;
            }

            public SdkBuilder autoStart(boolean z10) {
                this.f2154a.f2152t = z10;
                return this;
            }

            public Config build() {
                return this.f2154a;
            }

            public SdkBuilder channel(@NonNull String str) {
                this.f2154a.c = str;
                return this;
            }

            public SdkBuilder customData(@NonNull AttachUserData attachUserData) {
                this.f2154a.h = attachUserData;
                return this;
            }

            public SdkBuilder customPageView(boolean z10) {
                this.f2154a.f2150r = z10;
                return this;
            }

            public SdkBuilder debugMode(boolean z10) {
                Npth.getConfigManager().setDebugMode(z10);
                return this;
            }

            public SdkBuilder disablePageView() {
                this.f2154a.f2151s = false;
                return this;
            }

            public SdkBuilder disableSelfMonitor() {
                this.f2154a.f2149q = false;
                return this;
            }

            public SdkBuilder dynamicParams(@NonNull IDynamicParams iDynamicParams) {
                this.f2154a.o = iDynamicParams;
                return this;
            }

            public SdkBuilder enableAnrMonitor(boolean z10) {
                Npth.getConfigManager().setAnrEnable(z10);
                return this;
            }

            public SdkBuilder enableJavaCrash(boolean z10) {
                Npth.getConfigManager().setJavaCrashEnable(z10);
                return this;
            }

            public SdkBuilder enableNativeCrash(boolean z10) {
                Npth.getConfigManager().setNativeCrashEnable(z10);
                return this;
            }

            public SdkBuilder enableRegisterJavaCrash(boolean z10) {
                Npth.getConfigManager().setRegisterJavaCrashEnable(z10);
                return this;
            }

            public SdkBuilder keyWords(String... strArr) {
                this.f2154a.f = strArr;
                return this;
            }

            public SdkBuilder pageViewTags(Map<String, String> map) {
                this.f2154a.p = map;
                return this;
            }

            public SdkBuilder soList(String... strArr) {
                this.f2154a.g = strArr;
                return this;
            }

            public SdkBuilder token(@NonNull String str) {
                this.f2154a.b = str;
                return this;
            }

            public SdkBuilder url(@NonNull String str) {
                this.f2154a.n = str;
                return disableSelfMonitor();
            }

            public SdkBuilder versionCode(long j5) {
                this.f2154a.d = j5;
                return this;
            }

            public SdkBuilder versionName(@NonNull String str) {
                this.f2154a.e = str;
                return this;
            }
        }

        public static Builder app(@NonNull String str) {
            Builder builder = new Builder();
            Config config = new Config();
            builder.f2153a = config;
            config.f2147a = str;
            return builder;
        }

        public static SdkBuilder sdk(@NonNull String str) {
            SdkBuilder sdkBuilder = new SdkBuilder();
            Config config = new Config();
            sdkBuilder.f2154a = config;
            config.f2147a = str;
            return sdkBuilder;
        }

        public String getDeviceId() {
            IDynamicParams iDynamicParams = this.o;
            String did = iDynamicParams == null ? "" : iDynamicParams.getDid();
            return TextUtils.isEmpty(did) ? this.i : did;
        }

        public String getSSID() {
            return this.k;
        }

        public String getUID() {
            IDynamicParams iDynamicParams = this.o;
            return iDynamicParams == null ? this.f2148j : iDynamicParams.getUserId();
        }

        public Config setChannel(String str) {
            this.c = str;
            C1406c c1406c = this.l;
            if (c1406c != null) {
                c1406c.c = str;
            }
            RunnableC2056a.a();
            return this;
        }

        @Deprecated
        public Config setDeviceId(String str) {
            return setDeviceId(str, true);
        }

        public Config setPackageName(String str) {
            return setPackageName(str);
        }

        @Deprecated
        public Config setSSID(String str) {
            this.k = str;
            RunnableC2056a.a();
            return this;
        }

        public Config setSoList(String[] strArr) {
            this.g = strArr;
            RunnableC2056a.a();
            return this;
        }

        @Deprecated
        public Config setUID(String str) {
            this.f2148j = str;
            RunnableC2056a.a();
            return this;
        }

        @Deprecated
        public Config setDeviceId(String str, boolean z10) {
            this.i = str;
            C1406c c1406c = this.l;
            if (c1406c != null) {
                c1406c.l = str;
            }
            if (z10) {
                RunnableC2056a.a();
            }
            return this;
        }

        public Config setPackageName(String... strArr) {
            this.f = strArr;
            RunnableC2056a.a();
            return this;
        }
    }

    @Deprecated
    public interface HeaderParams {
        Map<String, Object> getCommonParams();
    }

    private MonitorCrash(@NonNull Context context, @NonNull Config config) {
        this.mTagMap = new ConcurrentHashMap();
        this.isAppLogInit = false;
        this.mStarted = new AtomicBoolean(false);
        this.mContext = context;
        this.mConfig = config;
        this.mCustomData = config.h;
    }

    private static void checkInit(String str) {
        if (f.b == null || f.b.mConfig == null || TextUtils.equals(f.b.mConfig.f2147a, str)) {
            return;
        }
        if (g.g.isDebugMode()) {
            throw new RuntimeException("Duplicate init App MonitorCrash with different aids.");
        }
        Log.e(TAG, "Duplicate init App MonitorCrash with different aids.");
    }

    @Nullable
    @Deprecated
    public static MonitorCrash init(Context context, String str, long j5, String str2) {
        if (!sAppMonitorCrashInit) {
            synchronized (MonitorCrash.class) {
                try {
                    if (!sAppMonitorCrashInit) {
                        k.b(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable());
                        MonitorCrash monitorCrash = new MonitorCrash((Config) null, context, str, j5, str2);
                        sAppMonitorCrashInit = true;
                        return monitorCrash;
                    }
                } finally {
                }
            }
        }
        checkInit(str);
        return f.b;
    }

    private void initAppLog(Context context, boolean z10) {
        synchronized (this) {
            try {
                if (this.mApmApplogConfig == null) {
                    Config config = this.mConfig;
                    this.mApmApplogConfig = new C1406c(config.f2147a, config.b, "empty");
                    this.mConfig.l = this.mApmApplogConfig;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        initAppLogAsync(context, z10);
    }

    private void initAppLogAsync(Context context, boolean z10) {
        l.i().b(new a(this, z10, context), 5L);
    }

    public static synchronized MonitorCrash initSDK(@NonNull Context context, @NonNull Config config) {
        try {
            if (TextUtils.isEmpty(config.b)) {
                Log.e(TAG, config.f2147a + " MonitorCrash init without token.");
            }
            MonitorCrash monitorCrash = (MonitorCrash) f.c.get(config.f2147a);
            if (monitorCrash != null) {
                Log.e(TAG, "Duplicate init MonitorCrash with same aid.");
                return monitorCrash;
            }
            MonitorCrash monitorCrash2 = new MonitorCrash(context, config);
            monitorCrash2.mIsApp = false;
            if (sDefaultApplogUrl == null && !TextUtils.isEmpty(config.n)) {
                String str = config.n;
                sDefaultApplogUrl = str;
                monitorCrash2.setReportUrl(str);
            }
            if (!config.f2149q) {
                i.b = false;
            }
            Map<? extends String, ? extends String> map = config.p;
            if (map != null) {
                monitorCrash2.mTagMap.putAll(map);
            }
            if (config.f2152t) {
                monitorCrash2.start();
            }
            return monitorCrash2;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Deprecated
    public static MonitorCrash initSDKWithConfig(Context context, Config config, String str, long j5, String str2, String str3, String[] strArr) {
        k.b(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable());
        MonitorCrash monitorCrash = new MonitorCrash(config, str, j5, str2, str3);
        monitorCrash.config().setPackageName(str3).setSoList(strArr);
        return monitorCrash;
    }

    @Nullable
    @Deprecated
    public static MonitorCrash initWithConfig(Context context, Config config, String str, long j5, String str2) {
        if (!sAppMonitorCrashInit) {
            synchronized (MonitorCrash.class) {
                try {
                    if (!sAppMonitorCrashInit) {
                        k.b(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable());
                        MonitorCrash monitorCrash = new MonitorCrash(config, context, str, j5, str2);
                        sAppMonitorCrashInit = true;
                        return monitorCrash;
                    }
                } finally {
                }
            }
        }
        checkInit(str);
        return f.b;
    }

    public static void reInitAppLog(String str) {
        MonitorCrash monitorCrash;
        boolean z10;
        try {
            if (!TextUtils.isEmpty(str) && C1404a.c(str) == null) {
                if (f.b == null || !TextUtils.equals(str, f.b.mConfig.f2147a)) {
                    monitorCrash = (MonitorCrash) f.c.get(str);
                    z10 = false;
                } else {
                    monitorCrash = f.b;
                    z10 = true;
                }
                if (monitorCrash != null && !monitorCrash.isAppLogInit) {
                    Application application = g.b;
                    if (monitorCrash.mApmApplogConfig == null) {
                        monitorCrash.initAppLog(application, z10);
                    } else {
                        monitorCrash.initAppLogAsync(application, z10);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public static void setDefaultReportUrlPrefix(String str) {
        ConfigManager configManager = g.g;
        configManager.setLaunchCrashUrl(str + ConfigManager.EXCEPTION_URL_SUFFIX);
        configManager.setLaunchCrashUrl2(str + ConfigManager.LAUNCH_URL_SUFFIX);
        configManager.setJavaCrashUploadUrl(str + ConfigManager.JAVA_URL_SUFFIX);
        configManager.setNativeCrashUrl(str + ConfigManager.NATIVE_URL_SUFFIX);
        configManager.setConfigUrl(str + ConfigManager.CONFIG_URL_SUFFIX);
        configManager.setAlogUploadUrl(str + ConfigManager.ALOG_URL_SUFFIX);
        configManager.setFileUploadUrl(str + ConfigManager.FILE_UPLOAD_URL_SUFFIX);
        configManager.setCrashPortraitUrl(str + ConfigManager.PORTRAIT_UPLOAD_URL_SUFFIX);
        sDefaultApplogUrl = str;
    }

    public MonitorCrash addTags(String str, String str2) {
        this.mTagMap.put(str, str2);
        return this;
    }

    @NonNull
    public Config config() {
        return this.mConfig;
    }

    public Map<String, String> getPvTags() {
        Config config = this.mConfig;
        if (config == null) {
            return null;
        }
        return config.p;
    }

    public Map<String, String> getTags() {
        return this.mTagMap;
    }

    public void registerCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        k.c(iCrashCallback, crashType);
    }

    public void registerOOMCallback(IOOMCallback iOOMCallback) {
        ((CopyOnWriteArrayList) k.f.e).add(iOOMCallback);
    }

    public void reportCustomErr(String str, String str2, @NonNull Throwable th) {
        reportCustomErr(str, str2, th, null);
    }

    @Deprecated
    public MonitorCrash setCustomDataCallback(AttachUserData attachUserData) {
        this.mCustomData = attachUserData;
        return this;
    }

    @Deprecated
    public MonitorCrash setReportUrl(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        int iIndexOf = str.indexOf("://");
        if (iIndexOf < 0) {
            str = "https://".concat(str);
            i = 8;
        } else {
            i = iIndexOf + 3;
        }
        int iIndexOf2 = str.indexOf("/", i);
        if (iIndexOf2 >= 0) {
            str = str.substring(0, iIndexOf2);
        }
        S0.b.N("set url " + str);
        ConfigManager configManager = g.g;
        configManager.setLaunchCrashUrl(str + ConfigManager.EXCEPTION_URL_SUFFIX);
        configManager.setJavaCrashUploadUrl(str + ConfigManager.JAVA_URL_SUFFIX);
        configManager.setNativeCrashUrl(str + ConfigManager.NATIVE_URL_SUFFIX);
        configManager.setConfigUrl(str + ConfigManager.CONFIG_URL_SUFFIX);
        configManager.setAlogUploadUrl(str + ConfigManager.ALOG_URL_SUFFIX);
        configManager.setFileUploadUrl(str + ConfigManager.FILE_UPLOAD_URL_SUFFIX);
        configManager.setFileUploadUrl(str + ConfigManager.PORTRAIT_UPLOAD_URL_SUFFIX);
        sDefaultApplogUrl = str;
        return this;
    }

    public void start() {
        Context context;
        if (!this.mStarted.compareAndSet(false, true) || this.mConfig == null || (context = this.mContext) == null) {
            return;
        }
        k.b(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable());
        if (this.mConfig.f2151s) {
            initAppLog(this.mContext, this.mIsApp);
        }
        if (this.mIsApp) {
            f.e(this.mContext, this);
            return;
        }
        new f(this);
        if (this.mConfig != null) {
            f.c.put(this.mConfig.f2147a, this);
        }
    }

    public void unregisterCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        k.d(iCrashCallback, crashType);
    }

    public void unregisterOOMCallback(IOOMCallback iOOMCallback, CrashType crashType) {
        ((CopyOnWriteArrayList) k.f.e).remove(iOOMCallback);
    }

    @Deprecated
    public MonitorCrash withOtherHeaders(@Nullable HeaderParams headerParams) {
        this.mParams = headerParams;
        return this;
    }

    private MonitorCrash(Config config, Context context, String str, long j5, String str2) {
        this.mTagMap = new ConcurrentHashMap();
        this.isAppLogInit = false;
        this.mStarted = new AtomicBoolean(false);
        config = config == null ? new Config() : config;
        this.mConfig = config;
        config.f2147a = str;
        config.d = j5;
        config.e = str2;
        f.e(context, this);
        initAppLog(context, true);
    }

    @Nullable
    public static synchronized MonitorCrash init(@NonNull Context context, @NonNull Config config) {
        try {
            if (!sAppMonitorCrashInit) {
                if (TextUtils.isEmpty(config.b)) {
                    Log.e(TAG, "MonitorCrash init without token.");
                }
                MonitorCrash monitorCrash = new MonitorCrash(context, config);
                monitorCrash.mIsApp = true;
                if (TextUtils.isEmpty(config.e) || config.d == -1) {
                    try {
                        if (config.d == -1) {
                            ConcurrentHashMap concurrentHashMap = D2.c.f374a;
                            config.d = D2.c.b(context, context.getPackageName(), 0) != null ? r3.versionCode : 0;
                        }
                        config.e = D2.c.c(context);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(config.n)) {
                    String str = config.n;
                    sDefaultApplogUrl = str;
                    monitorCrash.setReportUrl(str);
                }
                if (!config.f2149q) {
                    i.b = false;
                }
                Map<? extends String, ? extends String> map = config.p;
                if (map != null) {
                    monitorCrash.mTagMap.putAll(map);
                }
                if (config.f2152t) {
                    monitorCrash.start();
                } else {
                    f.b = monitorCrash;
                }
                sAppMonitorCrashInit = true;
            }
            checkInit(config.f2147a);
        } catch (Throwable th2) {
            throw th2;
        }
        return f.b;
    }

    @Deprecated
    public static MonitorCrash initSDKWithConfig(Context context, Config config, String str, long j5, String str2, String... strArr) {
        k.b(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable());
        MonitorCrash monitorCrash = new MonitorCrash(config, str, j5, str2, strArr);
        monitorCrash.config().setPackageName(strArr);
        return monitorCrash;
    }

    public void reportCustomErr(String str, String str2, @NonNull Throwable th, @Nullable Map<String, String> map) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "EnsureNotReachHere";
        }
        try {
            l.i().a(new B2.c(this, th, str, map, str2));
        } catch (Throwable unused) {
        }
    }

    private MonitorCrash(Config config, String str, long j5, String str2, String... strArr) {
        this.mTagMap = new ConcurrentHashMap();
        this.isAppLogInit = false;
        this.mStarted = new AtomicBoolean(false);
        config = config == null ? new Config() : config;
        this.mConfig = config;
        config.f2147a = str;
        config.d = j5;
        config.e = str2;
        config.f = strArr;
        new f(this);
        if (this.mConfig != null) {
            f.c.put(this.mConfig.f2147a, this);
        }
        initAppLog(g.f2160a, false);
    }

    @Deprecated
    public static MonitorCrash initSDKWithConfig(Context context, Config config, String str, long j5, String str2, String[] strArr, String[] strArr2) {
        k.b(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable());
        MonitorCrash monitorCrash = new MonitorCrash(config, str, j5, str2, strArr);
        monitorCrash.config().setPackageName(strArr).setSoList(strArr2);
        return monitorCrash;
    }

    public void reportCustomErr(StackTraceElement[] stackTraceElementArr, int i, @Nullable String str, String str2, @Nullable Map<String, String> map) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "EnsureNotReachHere";
        }
        try {
            l.i().a(new RunnableC1757b(stackTraceElementArr, i, str, str2, map));
        } catch (Throwable unused) {
        }
    }

    private MonitorCrash(String str, long j5, String str2, String... strArr) {
        this((Config) null, str, j5, str2, strArr);
    }

    @Deprecated
    public static MonitorCrash initSDK(Context context, String str, long j5, String str2, String str3) {
        k.b(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable());
        MonitorCrash monitorCrash = new MonitorCrash(str, j5, str2, str3);
        monitorCrash.config().setPackageName(str3);
        return monitorCrash;
    }

    @Deprecated
    public static MonitorCrash initSDK(Context context, String str, long j5, String str2, String str3, String[] strArr) {
        k.b(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable());
        MonitorCrash monitorCrash = new MonitorCrash(str, j5, str2, str3);
        monitorCrash.config().setPackageName(str3).setSoList(strArr);
        return monitorCrash;
    }

    @Deprecated
    public static MonitorCrash initSDK(Context context, String str, long j5, String str2, String... strArr) {
        k.b(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable());
        MonitorCrash monitorCrash = new MonitorCrash(str, j5, str2, strArr);
        monitorCrash.config().setPackageName(strArr);
        return monitorCrash;
    }

    @Deprecated
    public static MonitorCrash initSDK(Context context, String str, long j5, String str2, String[] strArr, String[] strArr2) {
        k.b(context, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable());
        MonitorCrash monitorCrash = new MonitorCrash(str, j5, str2, strArr);
        monitorCrash.config().setPackageName(strArr).setSoList(strArr2);
        return monitorCrash;
    }
}
