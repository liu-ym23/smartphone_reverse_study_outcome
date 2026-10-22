package com.ss.android.socialbase.downloader.logger;

import android.text.TextUtils;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.apm.impl.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class Logger {
    public static final boolean DEBUG = false;
    private static final String DOWNLOAD_TAG_PREFIX = "MNetDownloader-";
    private static final String KEY_GLOBAL_REPORT = "GlobalReport";
    private static final String KEY_TASK_REPORT = "TaskReport";
    private static final String TAG = "DownloaderLogger";
    private static final String TAG_GLOBAL_FORMAT = "[MNetDownloader|Global|%s]";
    private static final String TAG_TASK_FORMAT = "[MNetDownloader|%d|%s]";
    private static Object mAlogLock = null;
    private static Set mAlogTaskSceneList = null;
    private static boolean mEnableALogWritter = false;
    private static boolean mEnableGlobalReport = false;
    private static int mLevel = 6;
    private static ILogReport mLogReport;
    private static Set mTaskReportSceneList;
    private static ILogWritter sLogWritter;

    private static class AlogHandler extends ILogWritter {
        private Method mLogEMethd;

        AlogHandler() {
            this.mLogEMethd = ZeusTransformUtils.forName("com.ss.android.agilelogger.ALog", "com.obric.aiagent.plugin").getMethod("e", new Class[]{String.class, String.class});     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // com.ss.android.socialbase.downloader.logger.Logger.ILogWritter
        public void logD(String r1, String r2) {
            logE(r1, r2);
        }

        @Override // com.ss.android.socialbase.downloader.logger.Logger.ILogWritter
        public void logE(String r4, String r5) {
            Method r3 = this.mLogEMethd;     // Catch: Throwable -> L6
            if (r3 == null) goto L11;
            r3.invoke(null, new Object[]{r4, r5});     // Catch: Throwable -> L6
            return;
        L11:
            return;
        L6:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public static abstract class ILogReport {
        public void monitorEvent(String r1, String r2) {
        }

        public ILogReport() {
        }
    }

    public static abstract class ILogWritter {
        public void logD(String r1, String r2) {
        }

        public void logE(String r1, String r2) {
        }

        public void logE(String r1, String r2, Throwable r3) {
        }

        public void logI(String r1, String r2) {
        }

        public void logI(String r1, String r2, Throwable r3) {
        }

        public void logK(String r1, String r2) {
        }

        public void logV(String r1, String r2) {
        }

        public void logW(String r1, String r2) {
        }

        public void logW(String r1, String r2, Throwable r3) {
        }

        public ILogWritter() {
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.v(r0, r1);
    }

    public static /* synthetic */ int access$003(String r0, String r1, Throwable r2) {
        return Log.v(r0, r1, r2);
    }

    public static /* synthetic */ int access$004(String r0, String r1, Throwable r2) {
        return Log.d(r0, r1, r2);
    }

    public static /* synthetic */ int access$005(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$006(String r0, String r1, Throwable r2) {
        return Log.i(r0, r1, r2);
    }

    public static /* synthetic */ int access$007(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$008(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    public static /* synthetic */ int access$009(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    private static boolean isLoggerParamsValid(String r0, String r1, String r2) {
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        if (r2 == null) goto L6;
        return true;
    L6:
        return false;
    }

    public Logger() {
    }

    static {
        mAlogLock = new Object();
        mTaskReportSceneList = new CopyOnWriteArraySet();
        mAlogTaskSceneList = new CopyOnWriteArraySet();
    }

    public static void setLogLevel(int r2) {
        Object r0 = mAlogLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (mEnableALogWritter == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        mLevel = r2;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public static int getLogLevel() {
        return mLevel;
    }

    public static boolean debug() {
        if (mLevel > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean alog() {
        if (mLevel > 4) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean debugScene(DownloadInfo r0) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return debugScene(r0.getMonitorScene());
    }

    public static boolean debugScene(String r3) {
        if (mAlogTaskSceneList.isEmpty() == true) goto L13;
        if (mAlogTaskSceneList.contains(r3) == false) goto L13;
        if (mLevel > 4) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (mLevel > 3) goto L16;
        return true;
    L16:
        return false;
    }

    public static void globalDebug(String r2, String r3, String r4) {
        if (isLoggerParamsValid(r2, r3, r4) == true) goto L6;
        return;
    L6:
        if (alog() == false) goto L10;
        globalAlog(r2, r3, r4);
        return;
    L10:
        if (mLevel <= 3) goto L12;
        return;
    L12:
        String r5 = String.format(TAG_GLOBAL_FORMAT, new Object[]{r2});
        String r6 = r3 + "|" + r4;
        ILogWritter r7 = sLogWritter;
        if (r7 == null) goto L15;
        r7.logD(r5, r6);
        return;
    L15:
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(r5, r6);
    }

    public static void globalError(String r2, String r3, String r4) {
        if (isLoggerParamsValid(r2, r3, r4) == true) goto L5;
        return;
    L5:
        globalReport(r2, r3, r4);
        if (alog() == false) goto L10;
        globalAlog(r2, r3, r4);
        return;
    L10:
        if (mLevel <= 6) goto L12;
        return;
    L12:
        String r5 = String.format(TAG_GLOBAL_FORMAT, new Object[]{r2});
        String r6 = r3 + "|" + r4;
        ILogWritter r7 = sLogWritter;
        if (r7 == null) goto L15;
        r7.logE(r5, r6);
        return;
    L15:
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r5, r6);
    }

    private static void globalAlog(String r2, String r3, String r4) {
        if (isLoggerParamsValid(r2, r3, r4) == true) goto L5;
        return;
    L5:
        if (mLevel > 4) goto L14;
        String r5 = String.format(TAG_GLOBAL_FORMAT, new Object[]{r2});
        String r6 = r3 + "|" + r4;
        ILogWritter r7 = sLogWritter;
        if (r7 == null) goto L10;
        r7.logE(r5, r6);
        return;
    L10:
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r5, r6);
        return;
    }

    private static void globalReport(String r2, String r3, String r4) {
        if (mEnableGlobalReport == true) goto L5;
        return;
    L5:
        if (isLoggerParamsValid(r2, r3, r4) == false) goto L13;
        ILogReport r0 = mLogReport;
        if (r0 == null) goto L12;
        r0.monitorEvent(KEY_GLOBAL_REPORT, r2 + "|" + r3 + "|" + r4);
        return;
    L12:
        return;
    }

    public static void taskDebug(String r6, DownloadInfo r7, String r8, String r9) {
        taskDebug(r6, r7.getId(), r7.getMonitorScene(), r8, r9, false);
    }

    public static void taskDebug(String r6, DownloadInfo r7, String r8, String r9, boolean r10) {
        taskDebug(r6, r7.getId(), r7.getMonitorScene(), r8, r9, r10);
    }

    public static void taskDebug(String r6, int r7, String r8, String r9) {
        taskDebug(r6, r7, null, r8, r9, false);
    }

    public static void taskDebug(String r1, int r2, String r3, String r4, String r5, boolean r6) {
        if (isLoggerParamsValid(r1, r4, r5) == true) goto L5;
        return;
    L5:
        if (r6 == false) goto L8;
        taskReport(r1, r2, r3, r4, r5);
    L8:
        if (alog() == false) goto L14;
        if (TextUtils.isEmpty(r3) == true) goto L14;
        taskAlog(r1, r2, r4, r5);
        return;
    L14:
        if (mLevel <= 3) goto L16;
        return;
    L16:
        String r7 = String.format(TAG_TASK_FORMAT, new Object[]{Integer.valueOf(r2), r1});
        String r8 = r4 + "|" + r5;
        ILogWritter r9 = sLogWritter;
        if (r9 == null) goto L19;
        r9.logD(r7, r8);
        return;
    L19:
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(r7, r8);
    }

    public static void taskError(String r3, int r4, String r5, String r6) {
        if (isLoggerParamsValid(r3, r5, r6) == true) goto L5;
        return;
    L5:
        globalReport(r3, r5, r4 + "|" + r6);
        if (alog() == false) goto L10;
        taskAlog(r3, r4, r5, r6);
        return;
    L10:
        if (mLevel <= 6) goto L12;
        return;
    L12:
        String r7 = String.format(TAG_TASK_FORMAT, new Object[]{Integer.valueOf(r4), r3});
        String r8 = r5 + "|" + r6;
        ILogWritter r9 = sLogWritter;
        if (r9 == null) goto L15;
        r9.logE(r7, r8);
        return;
    L15:
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r7, r8);
    }

    private static void taskAlog(String r2, int r3, String r4, String r5) {
        if (isLoggerParamsValid(r2, r4, r5) == true) goto L5;
        return;
    L5:
        String r6 = String.format(TAG_TASK_FORMAT, new Object[]{Integer.valueOf(r3), r2});
        String r7 = r4 + "|" + r5;
        ILogWritter r8 = sLogWritter;
        if (r8 == null) goto L8;
        r8.logE(r6, r7);
        return;
    L8:
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r6, r7);
    }

    private static void taskReport(String r2, int r3, String r4, String r5, String r6) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        if (mTaskReportSceneList.isEmpty() == false) goto L7;
        return;
    L7:
        if (mTaskReportSceneList.contains(r4) == true) goto L9;
        return;
    L9:
        if (isLoggerParamsValid(r2, r5, r6) == false) goto L19;
        ILogReport r0 = mLogReport;
        if (r0 == null) goto L18;
        r0.monitorEvent(KEY_TASK_REPORT, r2 + "|" + r3 + "|" + r4 + "|" + r5 + "|" + r6);
        return;
    L18:
        return;
    }

    public static void v(String r1) {
        v(TAG, r1);
    }

    public static void v(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 2) goto L7;
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(r2, r3);
    L7:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L11;
        r0.logV(downloaderTag(r2), r3);
        return;
    }

    public static void v(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 2) goto L8;
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(r2, r3, r4);
    L8:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L12;
        r0.logV(downloaderTag(r2), r3 + r4);
        return;
    }

    public static void d(String r1) {
        d(TAG, r1);
    }

    public static String downloaderTag(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return TAG;
    L5:
        return DOWNLOAD_TAG_PREFIX + r2;
    }

    public static void d(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 3) goto L7;
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(downloaderTag(r2), r3);
    L7:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L11;
        r0.logD(downloaderTag(r2), r3);
        return;
    }

    public static void d(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 3) goto L8;
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(downloaderTag(r2), r3, r4);
    L8:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L12;
        r0.logD(downloaderTag(r2), r3 + r4);
        return;
    }

    public static void i(String r1) {
        i(TAG, r1);
    }

    public static void i(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 4) goto L7;
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(downloaderTag(r2), r3);
    L7:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L11;
        r0.logI(downloaderTag(r2), r3);
        return;
    }

    public static void i(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 4) goto L8;
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(downloaderTag(r2), r3, r4);
    L8:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L12;
        r0.logI(downloaderTag(r2), r3, r4);
        return;
    }

    public static void w(String r1) {
        w(TAG, r1);
    }

    public static void w(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 5) goto L7;
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(downloaderTag(r2), r3);
    L7:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L11;
        r0.logW(downloaderTag(r2), r3);
        return;
    }

    public static void w(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 5) goto L8;
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(downloaderTag(r2), r3, r4);
    L8:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L12;
        r0.logW(downloaderTag(r2), r3, r4);
        return;
    }

    public static void e(String r1) {
        e(TAG, r1);
    }

    public static void e(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 6) goto L7;
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(downloaderTag(r2), r3);
    L7:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L11;
        r0.logE(downloaderTag(r2), r3);
        return;
    }

    public static void e(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 6) goto L8;
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(downloaderTag(r2), r3, r4);
    L8:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L12;
        r0.logE(downloaderTag(r2), r3, r4);
        return;
    }

    public static void k(String r1) {
        k(TAG, r1);
    }

    public static void k(String r2, String r3) {
        if (mLevel > 3) goto L5;
        INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(downloaderTag(r2), r3);
    L5:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L9;
        r0.logK(downloaderTag(r2), r3);
        return;
    }

    public static void st(String r5, int r6) {
    L4:
        e = move-exception;
        StackTraceElement[] r0 = e.getStackTrace();
        StringBuilder r1 = new StringBuilder();
        int r3 = 1;
    L7:
        if (r3 >= Math.min(r6, r0.length)) goto L11;
        if (r3 <= 1) goto L10;
        r1.append("\n");
    L10:
        r1.append(getSimpleClassName(r0[r3].getClassName()));
        r1.append(".");
        r1.append(r0[r3].getMethodName());
        r3 = r3 + 1;
        goto L7
    L11:
        v(downloaderTag(r5), r1.toString());
        return;
    L3:
        throw new Exception();     // Catch: Exception -> L4
    }

    private static String getSimpleClassName(String r1) {
        int r0 = r1.lastIndexOf(46);
        if (r0 >= 0) goto L6;
        return r1;
    L6:
        return r1.substring(r0 + 1);
    }

    public static void throwException(Throwable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.printStackTrace();
        if (debug() == true) goto L8;
        return;
    L8:
        throw new RuntimeException("Error! Now in debug, we alert to you to correct it !", r2);
    }

    public static void alertErrorInfo(String r1) {
        if (debug() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(r1);
    }

    public static void registerLogHandler(ILogWritter r2) {
        Object r0 = mAlogLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (mEnableALogWritter == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        sLogWritter = r2;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public static void registerLogReport(ILogReport r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        mLogReport = r0;
    }

    public static void setLogReportParams(int r2, boolean r3, List<String> r4, List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        Object r0 = mAlogLock;
        monitor-enter(r0);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (mEnableALogWritter == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L25
        return;
    L8:
        mEnableALogWritter = true;     // Catch: Throwable -> L25
        mLevel = r2;     // Catch: Throwable -> L25
        sLogWritter = new AlogHandler();     // Catch: Throwable -> L25
        mEnableGlobalReport = r3;     // Catch: Throwable -> L25
        if (r6 != null) goto L11;
    L16:
        if (r7 != null) goto L18;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L25
        return;
    L18:
        if (r7.isEmpty() == true) goto L23;
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L25
    L21:
        if (r8.hasNext() == false) goto L23;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        mAlogTaskSceneList.add(r9);     // Catch: Throwable -> L25
        goto L21
    L11:
        if (r6.isEmpty() == true) goto L16;
        Iterator r10 = r6.iterator();     // Catch: Throwable -> L25
    L14:
        if (r10.hasNext() == false) goto L16;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        mTaskReportSceneList.add(r11);     // Catch: Throwable -> L25
        goto L14
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2, Throwable r3) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2, Throwable r3) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2, Throwable r3) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
