package com.bytedance.apm.config;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.abs.IEnhancedInterceptor;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.ReportUrl;
import com.bytedance.apm.core.IDynamicParams;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.impl.DefaultTTNetImpl;
import com.bytedance.apm.listener.IApmLogListener;
import com.bytedance.apm.listener.IApmStartListener;
import com.bytedance.apm.listener.IBlockListener;
import com.bytedance.apm.listener.IMemoryReachTopListener;
import com.bytedance.apm.listener.INtpTimeService;
import com.bytedance.apm.listener.IStorageCheckListener;
import com.bytedance.apm.listener.ITrafficCallback;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.IApmAlog;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.Preconditions;
import com.bytedance.apm6.foundation.UnSampleListener;
import com.bytedance.apm6.monitor.MonitorableInterceptor;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IWidget;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ApmStartConfig {
    private final String mAlogFilesDir;
    private final IApmLogListener mApmLogListener;
    private final IApmStartListener mApmStartListener;
    private final IBlockListener mBlockListener;
    private final long mBlockThresholdMs;
    private final ITrafficCallback mCallback;
    private List<String> mDefaultLogReportUrls;
    private final long mDelayNetRequestSeconds;
    private final IDynamicParams mDynamicParams;
    private final boolean mEnableBatteryLocalRecord;
    private final boolean mEnableBlockOnlySampled;
    private final boolean mEnableMultiProcessRequestSetting;
    private final boolean mEnableTemperatureLocalRecord;
    private final boolean mEnableTrafficDetect;
    private final IEncrypt mEncryptor;
    private List<String> mExceptionLogReportUrls;
    private final ExecutorService mExecutor;
    private final boolean mForceUpdateSlardarSetting;
    private final JSONObject mHeader;
    private final IHttpService mHttpService;
    private final boolean mIgnoreInvalidStack;
    private final IEnhancedInterceptor mInterceptor;
    private IMemoryReachTopListener mMemoryReachTopListener;
    private final boolean mNetMonitorWithDisconnected;
    private final INtpTimeService mNtpTimeService;
    private final IQueryParams mQueryParams;
    private List<String> mSlardarConfigUrls;
    private final IStorageCheckListener mStorageCheckListener;
    private List<String> mTraceReportUrls;
    private final Set<IWidget> mWidgets;
    private final boolean mWithBatteryDetect;
    private final boolean mWithBlockDetect;
    private final boolean mWithExceptionTrafficDetect;
    private final boolean mWithSeriousBlockDetect;
    private final boolean mWithTemperatureDetect;
    private final boolean mWithWebViewTrafficDetect;

    /* JADX INFO: renamed from: com.bytedance.apm.config.ApmStartConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        String alogFilesDir;
        IApmAlog apmAlogInstance;
        IApmLogListener apmLogListener;
        IApmStartListener apmStartListener;
        boolean batteryDetect;
        boolean batteryLocalRecord;
        boolean blockDetect;
        boolean blockDetectOnlySampled;
        IBlockListener blockListener;
        long blockThresholdMs;
        long delayNetRequestSeconds;
        IDynamicParams dynamicParams;
        boolean enableMultiProcessRequestSetting;
        boolean enableTrafficDetect;
        IEncrypt encryptor;
        List<String> exceptionLogReportUrls;
        boolean exceptionTrafficDetect;
        ExecutorService executor;
        boolean forceUpdateSlardarSetting;
        IHttpService httpService;
        boolean ignoreInvalidStack;
        IMemoryReachTopListener memoryReachTopListener;
        IEnhancedInterceptor monitorableInterceptor;
        boolean netMonitorWithDisconnected;
        List<String> normalLogReportUrls;
        INtpTimeService nptTimeService;
        JSONObject paramsHeader;
        IQueryParams queryParams;
        boolean seriousBlockDetect;
        List<String> slardarConfigUrls;
        IStorageCheckListener storageCheckListener;
        boolean temperatureDetect;
        boolean temperatureLocalRecord;
        List<String> traceReportUrls;
        ITrafficCallback trafficCallback;
        UnSampleListener unSampleListener;
        Set<IWidget> widgets;
        boolean withWebViewTrafficDetect;

        Builder() {
            this.blockDetectOnlySampled = false;
            this.enableTrafficDetect = true;
            this.slardarConfigUrls = ReportUrl.FETCH_SETTING_LIST;
            this.normalLogReportUrls = ReportUrl.REPORT_URL_LIST;
            this.exceptionLogReportUrls = ReportUrl.EXCEPTION_UPLOAD_URL_LIST;
            this.traceReportUrls = ReportUrl.REPORT_TRACING_URL_LIST;
            this.paramsHeader = new JSONObject();
            this.widgets = new HashSet();
            this.delayNetRequestSeconds = 0;
            this.blockThresholdMs = 2500;
            this.encryptor = new AnonymousClass1(this);
            this.blockDetect = StartConfigParams.BLOCK_COLLECT_ENABLE_SWITCH;
            this.temperatureDetect = StartConfigParams.TEMPERATURE_COLLECT_ENABLE_SWITCH;
            this.exceptionTrafficDetect = StartConfigParams.TRAFFIC_EXCEPTION_COLLECT_ENABLE_SWITCH;
        }

        Builder(ApmStartConfig r3) {
            this.blockDetectOnlySampled = false;
            this.enableTrafficDetect = true;
            this.slardarConfigUrls = ApmStartConfig.access$000(r3);
            this.normalLogReportUrls = ApmStartConfig.access$100(r3);
            this.exceptionLogReportUrls = ApmStartConfig.access$200(r3);
            this.traceReportUrls = ApmStartConfig.access$300(r3);
            this.blockDetect = ApmStartConfig.access$400(r3);
            this.ignoreInvalidStack = ApmStartConfig.access$500(r3);
            this.blockDetectOnlySampled = ApmStartConfig.access$600(r3);
            this.seriousBlockDetect = ApmStartConfig.access$700(r3);
            this.blockThresholdMs = ApmStartConfig.access$800(r3);
            this.temperatureDetect = ApmStartConfig.access$900(r3);
            this.withWebViewTrafficDetect = ApmStartConfig.access$1000(r3);
            this.batteryDetect = ApmStartConfig.access$1100(r3);
            this.batteryLocalRecord = ApmStartConfig.access$1200(r3);
            this.paramsHeader = ApmStartConfig.access$1300(r3);
            this.dynamicParams = ApmStartConfig.access$1400(r3);
            this.widgets = ApmStartConfig.access$1500(r3);
            this.httpService = ApmStartConfig.access$1600(r3);
            this.apmLogListener = r3.getApmLogListener();
            this.memoryReachTopListener = ApmStartConfig.access$1700(r3);
            this.encryptor = ApmStartConfig.access$1800(r3);
            this.netMonitorWithDisconnected = ApmStartConfig.access$1900(r3);
            this.nptTimeService = ApmStartConfig.access$2000(r3);
            this.queryParams = ApmStartConfig.access$2100(r3);
            this.blockListener = ApmStartConfig.access$2200(r3);
            this.monitorableInterceptor = ApmStartConfig.access$2300(r3);
        }

        public Builder memoryReachTop(IMemoryReachTopListener r1) {
            this.memoryReachTopListener = r1;
            return this;
        }

        public Builder queryParams(IQueryParams r1) {
            this.queryParams = r1;
            return this;
        }

        public Builder releaseBuild(String r2) {
            return param("release_build", r2);
        }

        public Builder aid(int r2) {
            return param("aid", r2);
        }

        public Builder deviceId(String r2) {
            return param("device_id", r2);
        }

        public Builder appVersion(String r2) {
            return param("app_version", r2);
        }

        public Builder updateVersionCode(String r2) {
            return param("update_version_code", r2);
        }

        public Builder channel(String r2) {
            return param("channel", r2);
        }

        public Builder enableTrafficDetect(boolean r1) {
            this.enableTrafficDetect = r1;
            return this;
        }

        public Builder enableNetMonitorWithDisconnected(boolean r1) {
            this.netMonitorWithDisconnected = r1;
            return this;
        }

        public Builder exceptionTrafficDetect(boolean r1) {
            this.exceptionTrafficDetect = r1;
            return this;
        }

        public Builder webViewTrafficDetect(boolean r1) {
            this.withWebViewTrafficDetect = r1;
            return this;
        }

        public Builder blockDetect(boolean r1) {
            if (r1 == false) goto L4;
            boolean r2 = true;
        L5:
            this.blockDetect = r2;
            return this;
        L4:
            r2 = false;
            goto L5
        }

        public Builder blockDetectOnlySampled(boolean r1) {
            this.blockDetectOnlySampled = r1;
            return this;
        }

        public Builder blockThresholdMs(long r1) {
            this.blockThresholdMs = r1;
            return this;
        }

        public Builder seriousBlockDetect(boolean r1) {
            if (r1 == false) goto L4;
            boolean r2 = true;
        L5:
            this.seriousBlockDetect = r2;
            return this;
        L4:
            r2 = false;
            goto L5
        }

        public Builder ignoreInvalidStack(boolean r1) {
            this.ignoreInvalidStack = r1;
            return this;
        }

        public Builder forceUpdateSlardarSetting(boolean r1) {
            this.forceUpdateSlardarSetting = r1;
            return this;
        }

        public Builder enableMultiProcessRequestSetting(boolean r1) {
            this.enableMultiProcessRequestSetting = r1;
            return this;
        }

        public Builder batteryDetect(boolean r1) {
            if (r1 == false) goto L4;
            boolean r2 = true;
        L5:
            this.batteryDetect = r2;
            return this;
        L4:
            r2 = false;
            goto L5
        }

        public Builder batteryLocalRecord(boolean r1) {
            if (r1 == false) goto L4;
            boolean r2 = true;
        L5:
            this.batteryLocalRecord = r2;
            return this;
        L4:
            r2 = false;
            goto L5
        }

        public Builder temperatureLocalRecord(boolean r1) {
            if (r1 == false) goto L4;
            boolean r2 = true;
        L5:
            this.temperatureLocalRecord = r2;
            return this;
        L4:
            r2 = false;
            goto L5
        }

        public Builder temperatureDetect(boolean r1) {
            this.temperatureDetect = r1;
            return this;
        }

        public Builder injectExecutor(ExecutorService r1) {
            this.executor = r1;
            return this;
        }

        public Builder defaultReportUrls(List<String> r1) {
            this.normalLogReportUrls = r1;
            return this;
        }

        public Builder exceptionLogDefaultReportUrls(List<String> r1) {
            this.exceptionLogReportUrls = r1;
            return this;
        }

        public Builder configFetchUrl(List<String> r1) {
            this.slardarConfigUrls = r1;
            return this;
        }

        public Builder traceReportUrl(List<String> r1) {
            this.traceReportUrls = r1;
            return this;
        }

        public Builder delayReport(long r3) {
            this.delayNetRequestSeconds = Math.min(r3, 30);
            return this;
        }

        public Builder dynamicParams(IDynamicParams r1) {
            this.dynamicParams = r1;
            return this;
        }

        public Builder useDefaultTTNetImpl(boolean r1) {
            if (r1 == false) goto L4;
            this.httpService = new DefaultTTNetImpl();
        L4:
            return this;
        }

        public Builder useHttpService(IHttpService r1) {
            this.httpService = r1;
            return this;
        }

        public Builder apmStartListener(IApmStartListener r1) {
            this.apmStartListener = r1;
            return this;
        }

        public Builder apmLogListener(IApmLogListener r1) {
            this.apmLogListener = r1;
            return this;
        }

        public Builder setStorageCheckListener(IStorageCheckListener r1) {
            this.storageCheckListener = r1;
            return this;
        }

        public Builder setAlogInstance(IApmAlog r1) {
            this.apmAlogInstance = r1;
            return this;
        }

        public Builder setUnSampleListener(UnSampleListener r1) {
            this.unSampleListener = r1;
            return this;
        }

        public Builder setAlogFilesDir(String r1) {
            this.alogFilesDir = r1;
            return this;
        }

        public Builder setTrafficCallback(ITrafficCallback r1) {
            this.trafficCallback = r1;
            return this;
        }

        public Builder setBlockListener(IBlockListener r1) {
            this.blockListener = r1;
            return this;
        }

        public Builder setNptTimeService(INtpTimeService r1) {
            this.nptTimeService = r1;
            return this;
        }

        public Builder setDiskMBThresholdToday(int r2) {
            param(CommonKey.OUTSIDE_MAX_SIZE_MB_TODAY, r2);
            return this;
        }

        public Builder setEncrypt(IEncrypt r1) {
            this.encryptor = r1;
            return this;
        }

        public Builder setMonitorInterceptor(IEnhancedInterceptor r1) {
            this.monitorableInterceptor = r1;
            return this;
        }

        public Builder widget(IWidget r2) {
            if (r2 != null) goto L4;
        L9:
            return this;
        L4:
            if (ApmContext.isMainProcess() == false) goto L6;
        L8:
            this.widgets.add(r2);
            goto L9
        L6:
            if (r2.isOnlyMainProcess() == false) goto L8;
            return this;
        }

        public Builder params(JSONObject r2) {
            JsonUtils.copyJson2(this.paramsHeader, r2);     // Catch: JSONException -> L4
        L3:
            return this;
        }

        public Builder param(String r2, String r3) {
            this.paramsHeader.put(r2, r3);     // Catch: JSONException -> L4
        L3:
            return this;
        }

        public Builder param(String r2, int r3) {
            this.paramsHeader.put(r2, r3);     // Catch: JSONException -> L4
        L3:
            return this;
        }

        public Builder param(String r2, long r3) {
            this.paramsHeader.put(r2, r3);     // Catch: JSONException -> L4
        L3:
            return this;
        }

        public ApmStartConfig build() {
            Preconditions.checkNotEmpty(this.paramsHeader.optString("aid"), "aid");
            Preconditions.checkNotNull(this.dynamicParams, "dynamicParams");
            Preconditions.checkNotEmptySafely(this.paramsHeader.optString("app_version"), "app_version");
            Preconditions.checkNotEmptySafely(this.paramsHeader.optString("update_version_code"), "update_version_code");
            Preconditions.checkNotEmptySafely(this.paramsHeader.optString("device_id"), "device_id");
            Preconditions.checkNotEmptySafely(this.paramsHeader.optString("release_build"), "release_build");
            return new ApmStartConfig(this, null);
        }
    }

    /* synthetic */ ApmStartConfig(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ List access$000(ApmStartConfig r0) {
        return r0.mSlardarConfigUrls;
    }

    static /* synthetic */ List access$100(ApmStartConfig r0) {
        return r0.mDefaultLogReportUrls;
    }

    static /* synthetic */ boolean access$1000(ApmStartConfig r0) {
        return r0.mWithWebViewTrafficDetect;
    }

    static /* synthetic */ boolean access$1100(ApmStartConfig r0) {
        return r0.mWithBatteryDetect;
    }

    static /* synthetic */ boolean access$1200(ApmStartConfig r0) {
        return r0.mEnableBatteryLocalRecord;
    }

    static /* synthetic */ JSONObject access$1300(ApmStartConfig r0) {
        return r0.mHeader;
    }

    static /* synthetic */ IDynamicParams access$1400(ApmStartConfig r0) {
        return r0.mDynamicParams;
    }

    static /* synthetic */ Set access$1500(ApmStartConfig r0) {
        return r0.mWidgets;
    }

    static /* synthetic */ IHttpService access$1600(ApmStartConfig r0) {
        return r0.mHttpService;
    }

    static /* synthetic */ IMemoryReachTopListener access$1700(ApmStartConfig r0) {
        return r0.mMemoryReachTopListener;
    }

    static /* synthetic */ IEncrypt access$1800(ApmStartConfig r0) {
        return r0.mEncryptor;
    }

    static /* synthetic */ boolean access$1900(ApmStartConfig r0) {
        return r0.mNetMonitorWithDisconnected;
    }

    static /* synthetic */ List access$200(ApmStartConfig r0) {
        return r0.mExceptionLogReportUrls;
    }

    static /* synthetic */ INtpTimeService access$2000(ApmStartConfig r0) {
        return r0.mNtpTimeService;
    }

    static /* synthetic */ IQueryParams access$2100(ApmStartConfig r0) {
        return r0.mQueryParams;
    }

    static /* synthetic */ IBlockListener access$2200(ApmStartConfig r0) {
        return r0.mBlockListener;
    }

    static /* synthetic */ IEnhancedInterceptor access$2300(ApmStartConfig r0) {
        return r0.mInterceptor;
    }

    static /* synthetic */ List access$300(ApmStartConfig r0) {
        return r0.mTraceReportUrls;
    }

    static /* synthetic */ boolean access$400(ApmStartConfig r0) {
        return r0.mWithBlockDetect;
    }

    static /* synthetic */ boolean access$500(ApmStartConfig r0) {
        return r0.mIgnoreInvalidStack;
    }

    static /* synthetic */ boolean access$600(ApmStartConfig r0) {
        return r0.mEnableBlockOnlySampled;
    }

    static /* synthetic */ boolean access$700(ApmStartConfig r0) {
        return r0.mWithSeriousBlockDetect;
    }

    static /* synthetic */ long access$800(ApmStartConfig r2) {
        return r2.mBlockThresholdMs;
    }

    static /* synthetic */ boolean access$900(ApmStartConfig r0) {
        return r0.mWithTemperatureDetect;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ApmStartConfig r1) {
        return new Builder(r1);
    }

    private ApmStartConfig(Builder r3) {
        this.mHeader = r3.paramsHeader;
        this.mForceUpdateSlardarSetting = r3.forceUpdateSlardarSetting;
        this.mEnableMultiProcessRequestSetting = r3.enableMultiProcessRequestSetting;
        this.mDynamicParams = r3.dynamicParams;
        this.mSlardarConfigUrls = r3.slardarConfigUrls;
        this.mHttpService = r3.httpService;
        this.mEnableTrafficDetect = r3.enableTrafficDetect;
        this.mWithExceptionTrafficDetect = r3.exceptionTrafficDetect;
        this.mWithBlockDetect = r3.blockDetect;
        this.mEnableBlockOnlySampled = r3.blockDetectOnlySampled;
        this.mWithSeriousBlockDetect = r3.seriousBlockDetect;
        this.mIgnoreInvalidStack = r3.ignoreInvalidStack;
        this.mBlockThresholdMs = r3.blockThresholdMs;
        this.mWithBatteryDetect = r3.batteryDetect;
        this.mEnableBatteryLocalRecord = r3.batteryLocalRecord;
        this.mEnableTemperatureLocalRecord = r3.temperatureLocalRecord;
        this.mWidgets = r3.widgets;
        this.mDefaultLogReportUrls = r3.normalLogReportUrls;
        this.mExceptionLogReportUrls = r3.exceptionLogReportUrls;
        this.mTraceReportUrls = r3.traceReportUrls;
        this.mDelayNetRequestSeconds = r3.delayNetRequestSeconds;
        this.mWithTemperatureDetect = r3.temperatureDetect;
        this.mWithWebViewTrafficDetect = r3.withWebViewTrafficDetect;
        this.mApmLogListener = r3.apmLogListener;
        this.mApmStartListener = r3.apmStartListener;
        this.mStorageCheckListener = r3.storageCheckListener;
        this.mExecutor = r3.executor;
        this.mMemoryReachTopListener = r3.memoryReachTopListener;
        this.mEncryptor = r3.encryptor;
        this.mNetMonitorWithDisconnected = r3.netMonitorWithDisconnected;
        this.mAlogFilesDir = r3.alogFilesDir;
        this.mCallback = r3.trafficCallback;
        this.mNtpTimeService = r3.nptTimeService;
        this.mQueryParams = r3.queryParams;
        this.mBlockListener = r3.blockListener;
        this.mInterceptor = r3.monitorableInterceptor;
        ApmAlogHelper.setApmLogger(r3.apmAlogInstance);
        ApmAlogHelper.setUnSampleListener(r3.unSampleListener);
    }

    public INtpTimeService getNtpTimeService() {
        return this.mNtpTimeService;
    }

    public IQueryParams getQueryParams() {
        return this.mQueryParams;
    }

    public IDynamicParams getDynamicParams() {
        return this.mDynamicParams;
    }

    public IMemoryReachTopListener getMemoryReachTopListener() {
        return this.mMemoryReachTopListener;
    }

    public List<String> getSlardarConfigUrls() {
        return this.mSlardarConfigUrls;
    }

    public boolean isForceUpdateSlardarSetting() {
        return this.mForceUpdateSlardarSetting;
    }

    public boolean isEnableMultiProcessRequestSetting() {
        return this.mEnableMultiProcessRequestSetting;
    }

    public List<String> getDefaultLogReportUrls() {
        return this.mDefaultLogReportUrls;
    }

    public void setDefaultLogReportUrlsCompat(List<String> r1) {
        this.mDefaultLogReportUrls = r1;
    }

    public void setSlardarConfigUrlsCompat(List<String> r1) {
        this.mSlardarConfigUrls = r1;
    }

    public void setExceptionLogReportUrlsCompat(List<String> r1) {
        this.mExceptionLogReportUrls = r1;
    }

    public List<String> getExceptionLogReportUrls() {
        return this.mExceptionLogReportUrls;
    }

    public List<String> getTraceReportUrls() {
        return this.mTraceReportUrls;
    }

    public JSONObject getHeader() {
        return this.mHeader;
    }

    public long getDeviceId() {
        return this.mHeader.optLong("device_id");
    }

    public IHttpService getHttpService() {
        return this.mHttpService;
    }

    public Set<IWidget> getWidgets() {
        return this.mWidgets;
    }

    public boolean isWithExceptionTrafficDetect() {
        return this.mWithExceptionTrafficDetect;
    }

    public boolean isWithBlockDetect() {
        return this.mWithBlockDetect;
    }

    public boolean isEnableBlockOnlySampled() {
        return this.mEnableBlockOnlySampled;
    }

    public boolean isWithSeriousBlockDetect() {
        return this.mWithSeriousBlockDetect;
    }

    public boolean isIgnoreInvalidStack() {
        return this.mIgnoreInvalidStack;
    }

    public long getBlockThresholdMs() {
        return this.mBlockThresholdMs;
    }

    public boolean isWithTemperatureDetect() {
        return this.mWithTemperatureDetect;
    }

    public boolean isWithWebViewDetect() {
        return this.mWithWebViewTrafficDetect;
    }

    public long getDelayRequestSeconds() {
        return this.mDelayNetRequestSeconds;
    }

    public boolean isWithBatteryDetect() {
        return this.mWithBatteryDetect;
    }

    public boolean isBatteryLocalRecordEnable() {
        return this.mEnableBatteryLocalRecord;
    }

    public boolean isTemperatureLocalRecordEnable() {
        return this.mEnableTemperatureLocalRecord;
    }

    public boolean isEnableTrafficDetect() {
        return this.mEnableTrafficDetect;
    }

    public IApmStartListener getApmStartListener() {
        return this.mApmStartListener;
    }

    public IApmLogListener getApmLogListener() {
        return this.mApmLogListener;
    }

    public IStorageCheckListener getStorageCheckListener() {
        return this.mStorageCheckListener;
    }

    public ExecutorService getExecutor() {
        return this.mExecutor;
    }

    public IEncrypt getEncryptor() {
        return this.mEncryptor;
    }

    public boolean getNetMonitorWithDisconnected() {
        return this.mNetMonitorWithDisconnected;
    }

    public String getAlogFilesDir() {
        return this.mAlogFilesDir;
    }

    public ITrafficCallback getTrafficCallback() {
        return this.mCallback;
    }

    public IBlockListener getBlockListener() {
        return this.mBlockListener;
    }

    public String toString() {
        return "ApmStartConfig{mSlardarConfigUrls=" + this.mSlardarConfigUrls + ", mDefaultLogReportUrls=" + this.mDefaultLogReportUrls + ", mExceptionLogReportUrls=" + this.mExceptionLogReportUrls + ", mTraceReportUrls=" + this.mTraceReportUrls + ", mMemoryReachTopListener=" + this.mMemoryReachTopListener + ", mWithExceptionTrafficDetect=" + this.mWithExceptionTrafficDetect + ", mEnableTrafficDetect=" + this.mEnableTrafficDetect + ", mWithWebViewTrafficDetect=" + this.mWithWebViewTrafficDetect + ", mWithBlockDetect=" + this.mWithBlockDetect + ", mEnableBlockOnlySampled=" + this.mEnableBlockOnlySampled + ", mWithSeriousBlockDetect=" + this.mWithSeriousBlockDetect + ", mBlockThresholdMs=" + this.mBlockThresholdMs + ", mWithTemperatureDetect=" + this.mWithTemperatureDetect + ", mWithBatteryDetect=" + this.mWithBatteryDetect + ", mEnableBatteryLocalRecord=" + this.mEnableBatteryLocalRecord + ", mEnableTemperatureLocalRecord=" + this.mEnableTemperatureLocalRecord + ", mForceUpdateSlardarSetting=" + this.mForceUpdateSlardarSetting + ", mEnableMultiProcessRequestSetting=" + this.mEnableMultiProcessRequestSetting + ", mNetMonitorWithDisconnected=" + this.mNetMonitorWithDisconnected + ", mHeader=" + this.mHeader + ", mDynamicParams=" + this.mDynamicParams + ", mQueryParams=" + this.mQueryParams + ", mHttpService=" + this.mHttpService + ", mWidgets=" + this.mWidgets + ", mDelayNetRequestSeconds=" + this.mDelayNetRequestSeconds + ", mApmStartListener=" + this.mApmStartListener + ", mApmLogListener=" + this.mApmLogListener + ", mStorageCheckListener=" + this.mStorageCheckListener + ", mExecutor=" + this.mExecutor + ", mEncryptor=" + this.mEncryptor + ", mAlogFilesDir='" + this.mAlogFilesDir + "', mCallback=" + this.mCallback + ", mNtpTimeService=" + this.mNtpTimeService + '}';
    }

    public MonitorableInterceptor getInterceptor() {
        return this.mInterceptor;
    }
}
