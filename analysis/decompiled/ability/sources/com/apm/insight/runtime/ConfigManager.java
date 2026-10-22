package com.apm.insight.runtime;

import D2.b;
import Y.a;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.apm.insight.ICommonParams;
import com.apm.insight.c;
import com.apm.insight.g;
import com.stepos.statsrpk.d;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import s2.C1912a;
import z2.C2154a;
import z2.j;
import z2.l;

/* loaded from: classes2.dex */
public class ConfigManager {
    private static final String ALOG_UPLOAD_URL = "https://apmplus.volces.com/monitor/collect/c/cloudcontrol/file";
    public static final String ALOG_URL_SUFFIX = "/monitor/collect/c/cloudcontrol/file";
    private static final String ASAN_REPORT_URL = "https://apmplus.volces.com/monitor/collect/c/native_bin_crash";
    public static final long BLOCK_MONITOR_INTERVAL = 1000;
    private static final long BLOCK_MONITOR_MIN_INTERVAL = 10;
    private static final String CONFIG_URL = "https://apmplus.volces.com/settings/get";
    public static final String CONFIG_URL_SUFFIX = "/settings/get";
    private static final String CORE_DUMP_URL = "https://apmplus.volces.com/monitor/collect/c/core_dump_collect";
    private static final String CRASH_PORTRAIT_URL = "https://apmplus.volces.com/monitor/collect/c/crash_portrait";
    private static final String EXCEPTION_URL = "https://apmplus.volces.com/monitor/collect/c/exception";
    public static final String EXCEPTION_URL_SUFFIX = "/monitor/collect/c/exception";
    private static final String FILE_UPLOAD_URL = "https://apmplus.volces.com/monitor/collect/c/logcollect";
    public static final String FILE_UPLOAD_URL_SUFFIX = "/monitor/collect/c/logcollect";
    private static final String JAVA_CRASH_URL = "https://apmplus.volces.com/monitor/collect/c/crash";
    public static final String JAVA_URL_SUFFIX = "/monitor/collect/c/crash";
    private static final long LAUNCH_CRASH_INTERVAL = 8000;
    private static final String LAUNCH_CRASH_URL = "https://apmplus.volces.com/monitor/collect/c/exception/dump_collection";
    public static final String LAUNCH_URL_SUFFIX = "/monitor/collect/c/exception/dump_collection";
    public static final String LOG_TYPE_ALL_STACK = "npth_enable_all_thread_stack";
    private static final String NATIVE_CRASH_URL = "https://apmplus.volces.com/monitor/collect/c/native_bin_crash";
    private static final String NATIVE_MEM_URL = "https://apmplus.volces.com/monitor/collect/c/rapheal_file_collect";
    public static final String NATIVE_URL_SUFFIX = "/monitor/collect/c/native_bin_crash";
    public static final String PORTRAIT_UPLOAD_URL_SUFFIX = "/monitor/collect/c/crash_portrait";
    private ThreadPoolExecutor mThreadPoolExecutor;
    private boolean reportErrorEnable = true;
    private String mNativeMemUrl = NATIVE_MEM_URL;
    private String mCoreDumpUrl = CORE_DUMP_URL;
    private String mJavaCrashUploadUrl = JAVA_CRASH_URL;
    private String mLaunchCrashUploadUrl = LAUNCH_CRASH_URL;
    private String mExceptionUploadUrl = EXCEPTION_URL;
    private String mConfigUrl = CONFIG_URL;
    private String mNativeCrashUploadUrl = "https://apmplus.volces.com/monitor/collect/c/native_bin_crash";
    private String mAlogUploadUrl = ALOG_UPLOAD_URL;
    private String mAsanReportUploadUrl = "https://apmplus.volces.com/monitor/collect/c/native_bin_crash";
    private String mFileUploadUrl = FILE_UPLOAD_URL;
    private String mCrashPortraitUploadUrl = CRASH_PORTRAIT_URL;
    private long mLaunchCrashInterval = 8000;
    private c mEncryptImpl = new C1912a();
    private int mLogcatDumpCount = 512;
    private int mLogcatLevel = 1;
    private boolean mNativeCrashMiniDump = true;
    private boolean mEnsureEnable = true;
    private boolean mEnsureWithLogcat = false;
    private long mBlockMonitorInterval = 1000;
    private boolean mBlockMonitorEnable = false;
    private boolean mIsDebugMode = false;
    private boolean mEnableApmPlusLog = false;
    private boolean mRegisterJavaCrash = false;
    private boolean mJavaCrashEnable = true;
    private boolean mNativeCrashEnable = true;
    private boolean mANREnable = true;

    public static void setDefaultCommonParams(ICommonParams iCommonParams, Context context) {
        g.f = new A5.c(context, iCommonParams, (A5.c) null);
    }

    public static void updateDid(String str) {
        l.i().a(new a(str, 3));
    }

    public String getAlogUploadUrl() {
        return this.mAlogUploadUrl;
    }

    public String getAsanReportUploadUrl() {
        return this.mAsanReportUploadUrl;
    }

    public long getBlockInterval() {
        return this.mBlockMonitorInterval;
    }

    public String getConfigUrl() {
        return this.mConfigUrl;
    }

    public String getCoreDumpUrl() {
        return this.mCoreDumpUrl;
    }

    public String getCrashPortraitUploadUrl() {
        return this.mCrashPortraitUploadUrl;
    }

    @NonNull
    public c getEncryptImpl() {
        return this.mEncryptImpl;
    }

    public String getExceptionUploadUrl() {
        return this.mExceptionUploadUrl;
    }

    public String getFileUploadUrl() {
        return this.mFileUploadUrl;
    }

    public Set<String> getFilterThreadSet() {
        return y2.c.f6890a;
    }

    public String getJavaCrashUploadUrl() {
        return this.mJavaCrashUploadUrl;
    }

    public long getLaunchCrashInterval() {
        return this.mLaunchCrashInterval;
    }

    public String getLaunchCrashUploadUrl() {
        return this.mLaunchCrashUploadUrl;
    }

    public int getLogcatDumpCount() {
        return this.mLogcatDumpCount;
    }

    public int getLogcatLevel() {
        return this.mLogcatLevel;
    }

    public String getNativeCrashUploadUrl() {
        return this.mNativeCrashUploadUrl;
    }

    public String getNativeMemUrl() {
        return this.mNativeMemUrl;
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return this.mThreadPoolExecutor;
    }

    public boolean isAnrEnable() {
        return this.mANREnable;
    }

    public boolean isApmExists() {
        return false;
    }

    public boolean isApmPLusLogEnable() {
        return this.mEnableApmPlusLog;
    }

    public boolean isBlockMonitorEnable() {
        return this.mBlockMonitorEnable;
    }

    public boolean isCrashIgnored(String str) {
        try {
            C2154a c2154a = new C2154a(str);
            if (j.d(c2154a)) {
                return true;
            }
            if (b.f(g.f2160a)) {
                return j.d(c2154a);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isDebugMode() {
        return this.mIsDebugMode;
    }

    public boolean isEnsureEnable() {
        return this.mEnsureEnable;
    }

    public boolean isEnsureWithLogcat() {
        return this.mEnsureWithLogcat;
    }

    public boolean isJavaCrashEnable() {
        return this.mJavaCrashEnable;
    }

    public boolean isNativeCrashEnable() {
        return this.mNativeCrashEnable;
    }

    public boolean isNativeCrashMiniDump() {
        return this.mNativeCrashMiniDump;
    }

    public boolean isRegisterJavaCrashEnable() {
        return this.mRegisterJavaCrash;
    }

    public boolean isReportErrorEnable() {
        return this.reportErrorEnable;
    }

    public void setAlogUploadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mAlogUploadUrl = str;
    }

    public void setAnrEnable(boolean z10) {
        this.mANREnable = z10;
    }

    public void setApmPLusLogEnable(boolean z10) {
        this.mEnableApmPlusLog = z10;
    }

    public void setBlockMonitorEnable(boolean z10) {
        this.mBlockMonitorEnable = z10;
    }

    public void setBlockMonitorInterval(long j5) {
        this.mBlockMonitorInterval = j5;
    }

    public void setConfigUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mConfigUrl = str;
    }

    public void setCrashPortraitUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mCrashPortraitUploadUrl = str;
    }

    public void setCurrentProcessName(String str) {
        d.b = str;
    }

    public void setDebugMode(boolean z10) {
        this.mIsDebugMode = z10;
    }

    public void setEncryptImpl(c cVar) {
        if (cVar != null) {
            this.mEncryptImpl = cVar;
        }
    }

    public void setEnsureEnable(boolean z10) {
        this.mEnsureEnable = z10;
    }

    public void setEnsureWithLogcat(boolean z10) {
        this.mEnsureWithLogcat = z10;
    }

    public void setFileUploadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mCrashPortraitUploadUrl = str;
    }

    public void setJavaCrashEnable(boolean z10) {
        this.mJavaCrashEnable = z10;
    }

    public void setJavaCrashUploadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mJavaCrashUploadUrl = str;
    }

    public void setLaunchCrashInterval(long j5) {
        if (j5 > 0) {
            this.mLaunchCrashInterval = j5;
        }
    }

    public void setLaunchCrashUrl(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mExceptionUploadUrl = str;
        int iIndexOf = str.indexOf("//");
        if (iIndexOf == -1) {
            str2 = str.substring(0, str.indexOf("/") + 1) + "monitor/collect/c/exception/dump_collection";
        } else {
            str2 = str.substring(0, str.indexOf("/", iIndexOf + 2) + 1) + "monitor/collect/c/exception/dump_collection";
        }
        this.mLaunchCrashUploadUrl = str2;
    }

    public void setLaunchCrashUrl2(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mLaunchCrashUploadUrl = str;
    }

    public void setLogcatDumpCount(int i) {
        if (i > 0) {
            this.mLogcatDumpCount = i;
        }
    }

    public void setLogcatLevel(int i) {
        if (i < 0 || i > 4) {
            return;
        }
        this.mLogcatLevel = i;
    }

    public void setNativeCrashEnable(boolean z10) {
        this.mNativeCrashEnable = z10;
    }

    public void setNativeCrashUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mNativeCrashUploadUrl = str;
    }

    public void setRegisterJavaCrashEnable(boolean z10) {
        this.mRegisterJavaCrash = z10;
    }

    public void setReportErrorEnable(boolean z10) {
        this.reportErrorEnable = z10;
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.mThreadPoolExecutor = threadPoolExecutor;
    }
}
