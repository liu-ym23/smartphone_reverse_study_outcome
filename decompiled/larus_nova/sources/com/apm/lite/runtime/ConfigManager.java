package com.apm.lite.runtime;

import android.content.Context;
import android.text.TextUtils;
import com.apm.lite.ICommonParams;
import com.apm.lite.e;
import com.apm.lite.k.h;
import com.apm.lite.k.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import r1.d;
import r1.f;
import r1.j;
import r1.m;
import r1.o;
import r1.p;

/* JADX INFO: loaded from: classes39.dex */
public class ConfigManager {
    private static final String ALOG_UPLOAD_URL = "https://apmplus.volces.com/monitor/collect/c/cloudcontrol/file";
    public static final String ALOG_URL_SUFFIX = "/monitor/collect/c/cloudcontrol/file";
    public static final long BLOCK_MONITOR_INTERVAL = 1000;
    private static final long BLOCK_MONITOR_MIN_INTERVAL = 10;
    private static final String CONFIG_URL = "https://apmplus.volces.com/settings/get";
    public static final String CONFIG_URL_SUFFIX = "/settings/get";
    private static final String EXCEPTION_URL = "https://apmplus.volces.com/monitor/collect/c/exception";
    public static final String EXCEPTION_URL_SUFFIX = "/monitor/collect/c/exception";
    private static final String FILE_UPLOAD_URL = "https://apmplus.volces.com/monitor/collect/c/logcollect";
    public static final String FILE_UPLOAD_URL_SUFFIX = "/monitor/collect/c/logcollect";
    private static final String JAVA_CRASH_URL = "https://apmplus.volces.com/monitor/collect/c/crash";
    public static final String JAVA_URL_SUFFIX = "/monitor/collect/c/crash";
    private static final long LAUNCH_CRASH_INTERVAL = 8000;
    private static final String LAUNCH_CRASH_URL = "https://apmplus.volces.com/monitor/collect/c/exception/dump_collection";
    public static final String LAUNCH_URL_SUFFIX = "/monitor/collect/c/exception/dump_collection";
    private static final String NATIVE_CRASH_URL = "https://apmplus.volces.com/monitor/collect/c/native_bin_crash";
    public static final String NATIVE_URL_SUFFIX = "/monitor/collect/c/native_bin_crash";
    private static final String PAGEVIEW_URL = "https://apmplus.volces.com/monitor/collect/c/session";
    public static final String PAGEVIEW_URL_SUFFIX = "/monitor/collect/c/session";
    private boolean mANREnable;
    private String mAlogUploadUrl;
    private String mConfigUrl;
    private boolean mEnsureEnable;
    private String mExceptionUploadUrl;
    private String mFileUploadUrl;
    private boolean mIsDebugMode;
    private boolean mJavaCrashEnable;
    private String mJavaCrashUploadUrl;
    private long mLaunchCrashInterval;
    private String mLaunchCrashUploadUrl;
    private int mLogcatDumpCount;
    private int mLogcatLevel;
    private boolean mNativeCrashEnable;
    private boolean mNativeCrashMiniDump;
    private String mNativeCrashUploadUrl;
    private String mPageViewUrl;
    private boolean mRegisterJavaCrash;
    private boolean mSigQuitEnable;
    private ThreadPoolExecutor mThreadPoolExecutor;
    private boolean reportErrorEnable;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f30019a;

        public a(String r100) {
            this.f30019a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p r100 = e.d();     // Catch: Throwable -> L6
            String r101 = this.f30019a;     // Catch: Throwable -> L6
            r100.f535587a = r101;     // Catch: Throwable -> L6
            o r102 = o.b();     // Catch: Throwable -> L6
            r102.getClass();     // Catch: Throwable -> L6
            h.h(r102.f535579b, r101, false);     // Catch: Throwable -> L11
        L4:
            p1.b.a();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L10;
            return;
        L10:
            throw th;
        }
    }

    public class b extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30020c;

        public b(String r100) {
            this.f30020c = r100;
        }

        @Override // r1.f
        public final Object a(String r100) {
            if (r100.equals("md5") == false) goto L7;
            return this.f30020c;
        L7:
            return super.a(r100);
        }
    }

    public ConfigManager() {
        this.reportErrorEnable = true;
        this.mJavaCrashUploadUrl = JAVA_CRASH_URL;
        this.mLaunchCrashUploadUrl = LAUNCH_CRASH_URL;
        this.mExceptionUploadUrl = EXCEPTION_URL;
        this.mPageViewUrl = PAGEVIEW_URL;
        this.mConfigUrl = CONFIG_URL;
        this.mNativeCrashUploadUrl = NATIVE_CRASH_URL;
        this.mAlogUploadUrl = ALOG_UPLOAD_URL;
        this.mFileUploadUrl = FILE_UPLOAD_URL;
        this.mLaunchCrashInterval = 8000;
        this.mLogcatDumpCount = 512;
        this.mLogcatLevel = 1;
        this.mNativeCrashMiniDump = true;
        this.mEnsureEnable = true;
        this.mIsDebugMode = false;
        this.mRegisterJavaCrash = false;
        this.mJavaCrashEnable = true;
        this.mNativeCrashEnable = true;
        this.mANREnable = true;
        this.mSigQuitEnable = true;
    }

    public static void updateDid(String r100) {
        m.a().a(new a(r100));
    }

    public String getAlogUploadUrl() {
        return this.mAlogUploadUrl;
    }

    public String getConfigUrl() {
        return this.mConfigUrl;
    }

    public String getExceptionUploadUrl() {
        return this.mExceptionUploadUrl;
    }

    public String getFileUploadUrl() {
        return this.mFileUploadUrl;
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

    public String getPageViewUrl() {
        return this.mPageViewUrl;
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return this.mThreadPoolExecutor;
    }

    public boolean isAnrEnable() {
        return this.mANREnable;
    }

    public boolean isDebugMode() {
        return this.mIsDebugMode;
    }

    public boolean isEnsureEnable() {
        return this.mEnsureEnable;
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

    public boolean isSigQuitEnable() {
        return this.mSigQuitEnable;
    }

    public void setAlogUploadUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.mAlogUploadUrl = r100;
    }

    public void setAnrEnable(boolean r100) {
        this.mANREnable = r100;
    }

    public void setConfigUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.mConfigUrl = r100;
    }

    public void setDebugMode(boolean r100) {
        this.mIsDebugMode = r100;
    }

    public void setEnsureEnable(boolean r100) {
        this.mEnsureEnable = r100;
    }

    public void setFileUploadUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.mFileUploadUrl = r100;
    }

    public void setJavaCrashEnable(boolean r100) {
        this.mJavaCrashEnable = r100;
    }

    public void setJavaCrashUploadUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.mJavaCrashUploadUrl = r100;
    }

    public void setLaunchCrashUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.mExceptionUploadUrl = r100;
        int r101 = r100.indexOf("//");
        if (r101 != (-1)) goto L8;
        String r102 = r100.substring(0, r100.indexOf(HTTP.URL_DEFAULT) + 1) + "monitor/collect/c/exception/dump_collection";
    L9:
        this.mLaunchCrashUploadUrl = r102;
        return;
    L8:
        r102 = r100.substring(0, r100.indexOf(HTTP.URL_DEFAULT, r101 + 2) + 1) + "monitor/collect/c/exception/dump_collection";
        goto L9
    }

    public void setLogcatDumpCount(int r100) {
        if (r100 <= 0) goto L5;
        this.mLogcatDumpCount = r100;
        return;
    }

    public void setLogcatLevel(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 > 4) goto L8;
        this.mLogcatLevel = r100;
        return;
    }

    public void setNativeCrashEnable(boolean r100) {
        this.mNativeCrashEnable = r100;
    }

    public void setNativeCrashUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.mNativeCrashUploadUrl = r100;
    }

    public void setPageViewUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.mPageViewUrl = r100;
    }

    public void setRegisterJavaCrashEnable(boolean r100) {
        this.mRegisterJavaCrash = r100;
    }

    public void setReportErrorEnable(boolean r100) {
        this.reportErrorEnable = r100;
    }

    public void setSigQuitEnable(boolean r100) {
        this.mSigQuitEnable = r100;
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor r100) {
        this.mThreadPoolExecutor = r100;
    }

    public Set<String> getFilterThreadSet() {
        return i.f30001a;
    }

    public boolean isCrashIgnored(String r100) {
        b r101 = new b(r100);     // Catch: Throwable -> L12
        if (j.a(r101) == false) goto L7;
        return true;
    L7:
        if (com.apm.lite.k.o.b(e.f29909a) == false) goto L10;
        return j.a(r101);
    L10:
        return false;
    L15:
        return false;
    }

    public void setCurrentProcessName(String r100) {
        com.apm.lite.k.a.f29987a = r100;
    }

    public static void setDefaultCommonParams(ICommonParams r100, Context r101) {
        e.f29912d = new d(r101, r100);
    }
}
