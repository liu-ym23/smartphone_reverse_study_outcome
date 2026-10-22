package com.bytedance.security.zenmobile.utils;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.apm.impl.a;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class LogUtils {
    private static final boolean LOG_DEBUG = false;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static void d(String r0, String r1) {
    }

    public static void d(String r0, String r1, Throwable r2) {
    }

    public LogUtils() {
    }

    public static void i(String r0, String r1, Throwable r2) {
        INVOKESTATIC_com_bytedance_security_zenmobile_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(r0, r1);
    }

    public static void e(String r0, String r1, Throwable r2) {
        INVOKESTATIC_com_bytedance_security_zenmobile_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r0, r1);
    }

    public static void i(String r0, String r1) {
        INVOKESTATIC_com_bytedance_security_zenmobile_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(r0, r1);
    }

    public static void w(String r0, String r1) {
        INVOKESTATIC_com_bytedance_security_zenmobile_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(r0, r1);
    }

    public static void e(String r0, String r1) {
        INVOKESTATIC_com_bytedance_security_zenmobile_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_security_zenmobile_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_security_zenmobile_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_security_zenmobile_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
