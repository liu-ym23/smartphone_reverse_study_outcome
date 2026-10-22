package com.obric.olog;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.obric.android.agilelogger.b;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class OLog extends PluginContentProvider {
    private static Context sContext = null;
    private static long sCurrentTime = 0;
    private static volatile boolean sIsInited = false;
    private static volatile int sLogLevel = 3;
    private static long sLogNumInHour = 0;
    private static volatile boolean sOutputToLogd = false;
    private static volatile boolean sReport = false;
    private static volatile boolean sSaveToDisk = true;

    static {
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.v(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$003(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$004(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$005(String r0, String r1, Throwable r2) {
        return Log.v(r0, r1, r2);
    }

    public static /* synthetic */ int access$006(String r0, String r1, Throwable r2) {
        return Log.d(r0, r1, r2);
    }

    public static /* synthetic */ int access$007(String r0, String r1, Throwable r2) {
        return Log.i(r0, r1, r2);
    }

    public static /* synthetic */ int access$008(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    public static /* synthetic */ int access$009(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static /* synthetic */ int access$010(String r0, Throwable r1) {
        return Log.w(r0, r1);
    }

    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    public String getType(Uri r1) {
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }

    public OLog() {
    }

    public boolean onCreate() {
        sContext = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        sCurrentTime = System.currentTimeMillis();
        sLogNumInHour = 0;
        return true;
    }

    private static boolean initAlog(a r4) {
        return com.obric.android.agilelogger.a.a(new b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).c(true).b(false).a(false).c(r4.b()).a(r4.d()).b(r4.e()).a(r4.f()).a());
    }

    private static boolean checkLevel(int r1) {
        if (r1 < sLogLevel) goto L5;
        return true;
    L5:
        return false;
    }

    public static void init(a r5) {
        sReport = r5.a();
        sSaveToDisk = r5.c();
        sLogLevel = r5.b();
        sContext = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        UserManager r0 = (UserManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("user"), UserManager.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L42;
    L7:
        SharedPreferences r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).createDeviceProtectedStorageContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences("olog_config", 0);     // Catch: IllegalStateException -> L9
    L41:
    L12:
        if (r1 != null) goto L19;
        if (sSaveToDisk == false) goto L16;
        initAlog(r5);
    L16:
        sIsInited = true;
        return;
    L19:
        if (r1.contains("report") == false) goto L22;
        sReport = r1.getBoolean("report", false);
    L22:
        if (r1.contains("save_to_disk") == false) goto L25;
        sSaveToDisk = r1.getBoolean("save_to_disk", true);
    L25:
        if (r1.contains("output_to_logd") == false) goto L28;
        sOutputToLogd = r1.getBoolean("output_to_logd", false);
    L28:
        if (r1.contains("log_level") == false) goto L31;
        sLogLevel = r1.getInt("log_level", 3);
        r5.a(sLogLevel);
    L31:
        if (r1.contains("max_dir_size") == false) goto L34;
        r5.b(r1.getInt("max_dir_size", r5.e()));
    L34:
        if (r1.contains("log_expired_days") == false) goto L37;
        r5.c(r1.getInt("log_expired_days", r5.f()));
    L37:
        if (sSaveToDisk == false) goto L39;
        initAlog(r5);
    L39:
        sIsInited = true;
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        r1 = null;
        goto L12
    L42:
        if (r0.isUserUnlocked() == false) goto L7;
        r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences("olog_config", 0);     // Catch: IllegalStateException -> L9
        goto L41
    }

    private static void initInternal() {
        init(new a.C0919a(sContext).a());
    }

    private static void logout(int r1, String r2, String r3) {
        if (r1 > 2) goto L6;
        INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(r2, r3);
        return;
    L6:
        if (r1 != 3) goto L9;
        INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(r2, r3);
        return;
    L9:
        if (r1 != 4) goto L12;
        INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(r2, r3);
        return;
    L12:
        if (r1 != 5) goto L14;
        INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(r2, r3);
        return;
    L14:
        INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r2, r3);
    }

    private static void logout(int r1, String r2, String r3, Throwable r4) {
        if (r1 > 2) goto L6;
        INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(r2, r3, r4);
        return;
    L6:
        if (r1 != 3) goto L9;
        INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(r2, r3, r4);
        return;
    L9:
        if (r1 != 4) goto L12;
        INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(r2, r3, r4);
        return;
    L12:
        if (r1 != 5) goto L14;
        INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(r2, r3, r4);
        return;
    L14:
        INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r2, r3, r4);
    }

    private static void Alogout(int r1, String r2, String r3) {
        if (r1 > 2) goto L6;
        com.obric.android.agilelogger.a.a(r2, r3);
        return;
    L6:
        if (r1 != 3) goto L9;
        com.obric.android.agilelogger.a.b(r2, r3);
        return;
    L9:
        if (r1 != 4) goto L12;
        com.obric.android.agilelogger.a.c(r2, r3);
        return;
    L12:
        if (r1 != 5) goto L14;
        com.obric.android.agilelogger.a.d(r2, r3);
        return;
    L14:
        com.obric.android.agilelogger.a.e(r2, r3);
    }

    public static void StatisticFunc() {
        sLogNumInHour++;
        INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("obric_log_statistic", "Alogout dada: " + (System.currentTimeMillis() - sCurrentTime));
        if ((System.currentTimeMillis() - sCurrentTime) < 60000) goto L6;
        INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("obric_log_statistic", "Alogout in a minutes: " + sLogNumInHour);
        reportMetricEvent(sLogNumInHour);
        sCurrentTime = System.currentTimeMillis();
        sLogNumInHour = 0;
        return;
    }

    public static void setOutputToLogd(boolean r3) {
        sOutputToLogd = r3;
        SharedPreferences r4 = sContext.getSharedPreferences("olog_config", 0);
        if (r4.contains("output_to_logd") == false) goto L6;
        sOutputToLogd = r4.getBoolean("output_to_logd", false);
        return;
    }

    public static void v(String r2, String r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(2) == false) goto L11;
        logout(2, r2, r3);
    L11:
        if (sSaveToDisk == false) goto L14;
        Alogout(2, r2, r3);
        return;
    }

    public static void v(String r2, String r3, Throwable r4) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(2) == false) goto L11;
        logout(2, r2, r3, r4);
    L11:
        if (sSaveToDisk == false) goto L14;
        Alogout(2, r2, r3);
        return;
    }

    public static void d(String r2, String r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(3) == false) goto L11;
        logout(3, r2, r3);
    L11:
        if (sSaveToDisk == false) goto L14;
        Alogout(3, r2, r3);
        return;
    }

    public static void d(String r2, String r3, Throwable r4) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(3) == false) goto L11;
        logout(3, r2, r3, r4);
    L11:
        if (sSaveToDisk == false) goto L14;
        Alogout(3, r2, r3);
        return;
    }

    public static void i(String r2, String r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(4) == false) goto L11;
        logout(4, r2, r3);
    L11:
        if (sSaveToDisk == false) goto L14;
        Alogout(4, r2, r3);
        return;
    }

    public static void i(String r2, String r3, Throwable r4) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(4) == false) goto L11;
        logout(4, r2, r3, r4);
    L11:
        if (sSaveToDisk == false) goto L14;
        Alogout(4, r2, r3);
        return;
    }

    public static void w(String r2, String r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(5) == false) goto L11;
        logout(5, r2, r3);
    L11:
        if (sSaveToDisk == false) goto L14;
        Alogout(5, r2, r3);
        return;
    }

    public static void w(String r1, String r2, Throwable r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(5) == false) goto L11;
        INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(r1, r2, r3);
    L11:
        if (sSaveToDisk == false) goto L14;
        com.obric.android.agilelogger.a.a(r1, r2, r3);
        return;
    }

    public static void w(String r1, Throwable r2) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(5) == false) goto L11;
        INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(r1, r2);
    L11:
        if (sSaveToDisk == false) goto L14;
        com.obric.android.agilelogger.a.a(r1, r2);
        return;
    }

    public static void e(String r1, String r2) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(6) == false) goto L11;
        INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r1, r2);
    L11:
        if (sSaveToDisk == false) goto L14;
        com.obric.android.agilelogger.a.e(r1, r2);
        return;
    }

    public static void e(String r1, String r2, Throwable r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(6) == false) goto L11;
        INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r1, r2, r3);
    L11:
        if (sSaveToDisk == false) goto L14;
        com.obric.android.agilelogger.a.b(r1, r2, r3);
        return;
    }

    public static void header(int r1, String r2, String r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(r1) == false) goto L11;
        logout(r1, r2, com.obric.android.agilelogger.b.b.a(com.obric.android.agilelogger.b.b.a.f, r3));
    L11:
        if (sSaveToDisk == false) goto L14;
        com.obric.android.agilelogger.a.a(r1, r2, r3);
        return;
    }

    public static void bundle(int r1, String r2, Bundle r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(r1) == false) goto L11;
        logout(r1, r2, com.obric.android.agilelogger.b.b.a(com.obric.android.agilelogger.b.b.a.f22392c, r3));
    L11:
        if (sSaveToDisk == false) goto L14;
        com.obric.android.agilelogger.a.a(r1, r2, r3);
        return;
    }

    public static void intent(int r1, String r2, Intent r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(r1) == false) goto L11;
        logout(r1, r2, com.obric.android.agilelogger.b.b.a(com.obric.android.agilelogger.b.b.a.f22393d, r3));
    L11:
        if (sSaveToDisk == false) goto L14;
        com.obric.android.agilelogger.a.a(r1, r2, r3);
        return;
    }

    public static void thread(int r1, String r2, Thread r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(r1) == false) goto L11;
        logout(r1, r2, com.obric.android.agilelogger.b.b.a(com.obric.android.agilelogger.b.b.a.h, r3));
    L11:
        if (sSaveToDisk == false) goto L14;
        com.obric.android.agilelogger.a.a(r1, r2, r3);
        return;
    }

    public static void json(int r1, String r2, String r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(r1) == false) goto L11;
        logout(r1, r2, com.obric.android.agilelogger.b.b.a(com.obric.android.agilelogger.b.b.a.f22391b, r3));
    L11:
        if (sSaveToDisk == false) goto L14;
        com.obric.android.agilelogger.a.b(r1, r2, r3);
        return;
    }

    public static void throwable(int r1, String r2, Throwable r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(r1) == false) goto L11;
        logout(r1, r2, com.obric.android.agilelogger.b.b.a(com.obric.android.agilelogger.b.b.a.f22394e, r3));
    L11:
        if (sSaveToDisk == false) goto L14;
        com.obric.android.agilelogger.a.a(r1, r2, r3);
        return;
    }

    public static void stacktrace(int r1, String r2, StackTraceElement[] r3) {
        if (sIsInited == true) goto L6;
        initInternal();
    L6:
        if (sOutputToLogd == false) goto L11;
        if (checkLevel(r1) == false) goto L11;
        logout(r1, r2, com.obric.android.agilelogger.b.b.a(com.obric.android.agilelogger.b.b.a.g, r3));
    L11:
        if (sSaveToDisk == false) goto L14;
        com.obric.android.agilelogger.a.a(r1, r2, r3);
        return;
    }

    private static void reportMetricEvent(long r7) {
        if (sContext != null) goto L5;
        return;
    L5:
        JSONObject r3 = new JSONObject();
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L9
        r4.put("packageName", sContext.getPackageName());     // Catch: Exception -> L9
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L9
        r5.put("mainLogNumLines", r7);     // Catch: Exception -> L9
        r3.put("category", r4);     // Catch: Exception -> L9
        r3.put("metrics", r5);     // Catch: Exception -> L9
        r3.put("client_timestamp", System.currentTimeMillis());     // Catch: Exception -> L9
        r3.put("log_type", "flexible");     // Catch: Exception -> L9
        r3.put("event_name", "appLogFileLines");     // Catch: Exception -> L9
    L7:
        Intent r8 = new Intent("com.slardaros.metricevent.action");
        r8.putExtra(MonitorConstants.CODE, 0);
        r8.putExtra("event_name", "appLogFileLines");
        r8.putExtra("json_string", r3.toString());
        sContext.sendBroadcast(r8, "com.slardaros.METRIC_EVENT_PERMISSION");
    }

    public static void syncFlush() {
        if (sSaveToDisk == false) goto L6;
        com.obric.android.agilelogger.a.b();
        return;
    }

    public static Context getsContext() {
        return sContext;
    }

    static boolean isInited() {
        return sIsInited;
    }

    static void setReport(boolean r0) {
        sReport = r0;
    }

    static void setLogLevel(int r0) {
        sLogLevel = r0;
        com.obric.android.agilelogger.a.a(r0);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2, r3);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2, r3);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2, r3);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, Throwable r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_olog_OLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
