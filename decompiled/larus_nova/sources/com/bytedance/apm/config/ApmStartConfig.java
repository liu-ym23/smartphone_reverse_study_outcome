package com.bytedance.apm.config;

import android.text.TextUtils;
import com.bytedance.apm.impl.DefaultTTNetImpl;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.services.apm.api.IHttpService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ApmStartConfig {
    public final os3.a A;
    public final ExecutorService B;
    public final ff7.d C;
    public final String D;
    public final os3.g E;
    public final ff7.h F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f190388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f190389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f190390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f190391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f190392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f190393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f190394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f190395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f190396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f190397j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f190398k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f190399l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f190400m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f190401n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f190402o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f190403p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f190404q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f190405r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f190406s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final JSONObject f190407t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final gs3.b f190408u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final gs3.d f190409v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final IHttpService f190410w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Set<ff7.i> f190411x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f190412y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final os3.b f190413z;

    public static final class Builder {
        String alogFilesDir;
        ps3.a apmAlogInstance;
        os3.a apmLogListener;
        os3.b apmStartListener;
        boolean batteryDetect;
        boolean batteryLocalRecord;
        boolean blockDetect;
        boolean blockDetectOnlySampled;
        os3.c blockListener;
        long blockThresholdMs;
        long delayNetRequestSeconds;
        gs3.b dynamicParams;
        boolean enableMultiProcessRequestSetting;
        boolean enableTrafficDetect;
        ff7.d encryptor;
        List<String> exceptionLogReportUrls;
        boolean exceptionTrafficDetect;
        ExecutorService executor;
        boolean forceUpdateSlardarSetting;
        IHttpService httpService;
        boolean ignoreInvalidStack;
        os3.d memoryReachTopListener;
        sr3.a monitorableInterceptor;
        boolean netMonitorWithDisconnected;
        List<String> normalLogReportUrls;
        os3.e nptTimeService;
        JSONObject paramsHeader;
        ff7.h provider;
        gs3.d queryParams;
        boolean seriousBlockDetect;
        List<String> slardarConfigUrls;
        os3.f storageCheckListener;
        boolean temperatureDetect;
        boolean temperatureLocalRecord;
        List<String> traceReportUrls;
        os3.g trafficCallback;
        cu3.b unSampleListener;
        Set<ff7.i> widgets;
        boolean withWebViewTrafficDetect;

        public class a implements ff7.d {
            public a() {
            }

            @Override // ff7.d
            public final byte[] a(byte[] r100) {
                return EncryptorUtil.b(r100, r100.length);
            }
        }

        public Builder memoryReachTop(os3.d r100) {
            return this;
        }

        public Builder setAlogInstance(ps3.a r100) {
            return this;
        }

        public Builder setBlockListener(os3.c r100) {
            return this;
        }

        public Builder setMonitorInterceptor(sr3.a r100) {
            return this;
        }

        public Builder setNptTimeService(os3.e r100) {
            return this;
        }

        public Builder setStorageCheckListener(os3.f r100) {
            return this;
        }

        public Builder setUnSampleListener(cu3.b r100) {
            return this;
        }

        public ApmStartConfig build() {
            if (TextUtils.isEmpty(this.paramsHeader.optString("aid")) == true) goto L23;
            if (this.dynamicParams == null) goto L21;
            if (TextUtils.isEmpty(this.paramsHeader.optString("app_version")) == true) goto L10;
        L10:
            if (TextUtils.isEmpty(this.paramsHeader.optString("update_version_code")) == true) goto L13;
        L13:
            if (TextUtils.isEmpty(this.paramsHeader.optString("device_id")) == true) goto L16;
        L16:
            if (TextUtils.isEmpty(this.paramsHeader.optString("release_build")) == true) goto L19;
        L19:
            return new ApmStartConfig(this);
        L21:
            throw new NullPointerException("dynamicParams must not be null");
        L23:
            throw new IllegalArgumentException("aid must not be empty");
        }

        public Builder() {
            this.blockDetectOnlySampled = false;
            this.enableTrafficDetect = true;
            this.slardarConfigUrls = fs3.a.f478654a;
            this.normalLogReportUrls = fs3.a.f478655b;
            this.exceptionLogReportUrls = fs3.a.f478657d;
            this.traceReportUrls = fs3.a.f478656c;
            this.paramsHeader = new JSONObject();
            this.widgets = new HashSet();
            this.delayNetRequestSeconds = 0;
            this.blockThresholdMs = 2500;
            this.encryptor = new a();
            this.blockDetect = false;
            this.temperatureDetect = false;
            this.exceptionTrafficDetect = false;
        }

        public Builder(ApmStartConfig r100) {
            this.blockDetectOnlySampled = false;
            this.enableTrafficDetect = true;
            this.slardarConfigUrls = r100.f190388a;
            this.normalLogReportUrls = r100.f190389b;
            this.exceptionLogReportUrls = r100.f190390c;
            this.traceReportUrls = r100.f190391d;
            this.blockDetect = r100.f190395h;
            this.ignoreInvalidStack = r100.f190398k;
            this.blockDetectOnlySampled = r100.f190396i;
            this.seriousBlockDetect = r100.f190397j;
            this.blockThresholdMs = r100.f190399l;
            this.temperatureDetect = r100.f190400m;
            this.withWebViewTrafficDetect = r100.f190394g;
            this.batteryDetect = r100.f190401n;
            this.batteryLocalRecord = r100.f190402o;
            this.paramsHeader = r100.f190407t;
            this.dynamicParams = r100.f190408u;
            this.widgets = r100.f190411x;
            this.httpService = r100.f190410w;
            this.apmLogListener = r100.A;
            this.encryptor = r100.C;
            this.netMonitorWithDisconnected = r100.f190406s;
            this.queryParams = r100.f190409v;
        }

        public Builder aid(int r100) {
            return param("aid", r100);
        }

        public Builder apmLogListener(os3.a r100) {
            this.apmLogListener = r100;
            return this;
        }

        public Builder apmStartListener(os3.b r100) {
            this.apmStartListener = r100;
            return this;
        }

        public Builder appVersion(String r100) {
            return param("app_version", r100);
        }

        public Builder batteryDetect(boolean r100) {
            if (r100 == false) goto L4;
            boolean r101 = true;
        L5:
            this.batteryDetect = r101;
            return this;
        L4:
            r101 = false;
            goto L5
        }

        public Builder batteryLocalRecord(boolean r100) {
            if (r100 == false) goto L4;
            boolean r101 = true;
        L5:
            this.batteryLocalRecord = r101;
            return this;
        L4:
            r101 = false;
            goto L5
        }

        public Builder blockDetect(boolean r100) {
            if (r100 == false) goto L4;
            boolean r101 = true;
        L5:
            this.blockDetect = r101;
            return this;
        L4:
            r101 = false;
            goto L5
        }

        public Builder blockDetectOnlySampled(boolean r100) {
            this.blockDetectOnlySampled = r100;
            return this;
        }

        public Builder blockThresholdMs(long r100) {
            this.blockThresholdMs = r100;
            return this;
        }

        public Builder channel(String r100) {
            return param("channel", r100);
        }

        public Builder configFetchUrl(List<String> r100) {
            this.slardarConfigUrls = r100;
            return this;
        }

        public Builder defaultReportUrls(List<String> r100) {
            this.normalLogReportUrls = r100;
            return this;
        }

        public Builder delayReport(long r100) {
            this.delayNetRequestSeconds = Math.min(r100, 30);
            return this;
        }

        public Builder deviceId(String r100) {
            return param("device_id", r100);
        }

        public Builder dynamicParams(gs3.b r100) {
            this.dynamicParams = r100;
            return this;
        }

        public Builder enableMultiProcessRequestSetting(boolean r100) {
            this.enableMultiProcessRequestSetting = r100;
            return this;
        }

        public Builder enableNetMonitorWithDisconnected(boolean r100) {
            this.netMonitorWithDisconnected = r100;
            return this;
        }

        public Builder enableTrafficDetect(boolean r100) {
            this.enableTrafficDetect = r100;
            return this;
        }

        public Builder exceptionLogDefaultReportUrls(List<String> r100) {
            this.exceptionLogReportUrls = r100;
            return this;
        }

        public Builder exceptionTrafficDetect(boolean r100) {
            this.exceptionTrafficDetect = r100;
            return this;
        }

        public Builder forceUpdateSlardarSetting(boolean r100) {
            this.forceUpdateSlardarSetting = r100;
            return this;
        }

        public Builder ignoreInvalidStack(boolean r100) {
            this.ignoreInvalidStack = r100;
            return this;
        }

        public Builder injectExecutor(ExecutorService r100) {
            this.executor = r100;
            return this;
        }

        public Builder params(JSONObject r100) {
            com.bytedance.apm.util.j.b(this.paramsHeader, r100);     // Catch: JSONException -> L4
        L3:
            return this;
        }

        public Builder queryParams(gs3.d r100) {
            this.queryParams = r100;
            return this;
        }

        public Builder releaseBuild(String r100) {
            return param("release_build", r100);
        }

        public Builder requestTagHeaderProvider(ff7.h r100) {
            this.provider = r100;
            return this;
        }

        public Builder seriousBlockDetect(boolean r100) {
            if (r100 == false) goto L4;
            boolean r101 = true;
        L5:
            this.seriousBlockDetect = r101;
            return this;
        L4:
            r101 = false;
            goto L5
        }

        public Builder setAlogFilesDir(String r100) {
            this.alogFilesDir = r100;
            return this;
        }

        public Builder setDiskMBThresholdToday(int r100) {
            param("max_size_mb_today", r100);
            return this;
        }

        public Builder setEncrypt(ff7.d r100) {
            this.encryptor = r100;
            return this;
        }

        public Builder setTrafficCallback(os3.g r100) {
            this.trafficCallback = r100;
            return this;
        }

        public Builder temperatureDetect(boolean r100) {
            this.temperatureDetect = r100;
            return this;
        }

        public Builder temperatureLocalRecord(boolean r100) {
            if (r100 == false) goto L4;
            boolean r101 = true;
        L5:
            this.temperatureLocalRecord = r101;
            return this;
        L4:
            r101 = false;
            goto L5
        }

        public Builder traceReportUrl(List<String> r100) {
            this.traceReportUrls = r100;
            return this;
        }

        public Builder updateVersionCode(String r100) {
            return param("update_version_code", r100);
        }

        public Builder useDefaultTTNetImpl(boolean r100) {
            if (r100 == false) goto L4;
            this.httpService = new DefaultTTNetImpl();
        L4:
            return this;
        }

        public Builder useHttpService(IHttpService r100) {
            this.httpService = r100;
            return this;
        }

        public Builder webViewTrafficDetect(boolean r100) {
            this.withWebViewTrafficDetect = r100;
            return this;
        }

        public Builder widget(ff7.i r100) {
            if (r100 != null) goto L4;
        L9:
            return this;
        L4:
            if (com.bytedance.apm.d.k() == false) goto L6;
        L8:
            this.widgets.add(r100);
            goto L9
        L6:
            if (r100.isOnlyMainProcess() == false) goto L8;
            return this;
        }

        public Builder param(String r100, int r101) {
            this.paramsHeader.put(r100, r101);     // Catch: JSONException -> L4
        L3:
            return this;
        }

        public Builder param(String r100, long r101) {
            this.paramsHeader.put(r100, r101);     // Catch: JSONException -> L4
        L3:
            return this;
        }

        public Builder param(String r100, String r101) {
            this.paramsHeader.put(r100, r101);     // Catch: JSONException -> L4
        L3:
            return this;
        }
    }

    public final String toString() {
        return "ApmStartConfig{mSlardarConfigUrls=" + this.f190388a + ", mDefaultLogReportUrls=" + this.f190389b + ", mExceptionLogReportUrls=" + this.f190390c + ", mTraceReportUrls=" + this.f190391d + ", mMemoryReachTopListener=null, mWithExceptionTrafficDetect=" + this.f190392e + ", mEnableTrafficDetect=" + this.f190393f + ", mWithWebViewTrafficDetect=" + this.f190394g + ", mWithBlockDetect=" + this.f190395h + ", mEnableBlockOnlySampled=" + this.f190396i + ", mWithSeriousBlockDetect=" + this.f190397j + ", mBlockThresholdMs=" + this.f190399l + ", mWithTemperatureDetect=" + this.f190400m + ", mWithBatteryDetect=" + this.f190401n + ", mEnableBatteryLocalRecord=" + this.f190402o + ", mEnableTemperatureLocalRecord=" + this.f190403p + ", mForceUpdateSlardarSetting=" + this.f190404q + ", mEnableMultiProcessRequestSetting=" + this.f190405r + ", mNetMonitorWithDisconnected=" + this.f190406s + ", mHeader=" + this.f190407t + ", mDynamicParams=" + this.f190408u + ", mQueryParams=" + this.f190409v + ", mHttpService=" + this.f190410w + ", mWidgets=" + this.f190411x + ", mDelayNetRequestSeconds=" + this.f190412y + ", mApmStartListener=" + this.f190413z + ", mApmLogListener=" + this.A + ", mStorageCheckListener=null, mExecutor=" + this.B + ", mEncryptor=" + this.C + ", mAlogFilesDir='" + this.D + "', mCallback=" + this.E + ", mNtpTimeService=null}";
    }

    public ApmStartConfig(Builder r100) {
        this.f190407t = r100.paramsHeader;
        this.f190404q = r100.forceUpdateSlardarSetting;
        this.f190405r = r100.enableMultiProcessRequestSetting;
        this.f190408u = r100.dynamicParams;
        this.f190388a = r100.slardarConfigUrls;
        this.f190410w = r100.httpService;
        this.f190393f = r100.enableTrafficDetect;
        this.f190392e = r100.exceptionTrafficDetect;
        this.f190395h = r100.blockDetect;
        this.f190396i = r100.blockDetectOnlySampled;
        this.f190397j = r100.seriousBlockDetect;
        this.f190398k = r100.ignoreInvalidStack;
        this.f190399l = r100.blockThresholdMs;
        this.f190401n = r100.batteryDetect;
        this.f190402o = r100.batteryLocalRecord;
        this.f190403p = r100.temperatureLocalRecord;
        this.f190411x = r100.widgets;
        this.f190389b = r100.normalLogReportUrls;
        this.f190390c = r100.exceptionLogReportUrls;
        this.f190391d = r100.traceReportUrls;
        this.f190412y = r100.delayNetRequestSeconds;
        this.f190400m = r100.temperatureDetect;
        this.f190394g = r100.withWebViewTrafficDetect;
        this.A = r100.apmLogListener;
        this.f190413z = r100.apmStartListener;
        this.B = r100.executor;
        this.C = r100.encryptor;
        this.f190406s = r100.netMonitorWithDisconnected;
        this.D = r100.alogFilesDir;
        this.E = r100.trafficCallback;
        this.f190409v = r100.queryParams;
        this.F = r100.provider;
    }
}
