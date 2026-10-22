package com.obric.cae.libs.utils;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class LogUtil {
    public LogUtil() {
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.v(r0, r1);
    }

    public static /* synthetic */ int access$003(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static /* synthetic */ int access$004(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$005(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    public static /* synthetic */ int access$006(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ boolean access$007(String r0, int r1) {
        return Log.isLoggable(r0, r1);
    }

    public static void d(String r2, String r3) {
        INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("CaeLib", "[" + r2 + "] " + r3);
    }

    public static void e(String r2, String r3, Throwable r4) {
        INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("CaeLib", "[" + r2 + "] " + r3, r4);
    }

    public static void i(String r2, String r3) {
        INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("CaeLib", "[" + r2 + "] " + r3);
    }

    public static boolean isLoggable(int r1) {
        return INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable("CaeLib", r1);
    }

    public static void v(String r2, String r3) {
        INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v("CaeLib", "[" + r2 + "] " + r3);
    }

    public static void w(String r2, String r3, Throwable r4) {
        INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("CaeLib", "[" + r2 + "] " + r3, r4);
    }

    public static void d(String r1) {
        INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("CaeLib", r1);
    }

    public static void e(String r1, Throwable r2) {
        INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("CaeLib", r1, r2);
    }

    public static void i(String r1) {
        INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("CaeLib", r1);
    }

    public static void v(String r1) {
        INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v("CaeLib", r1);
    }

    public static void w(String r1, Throwable r2) {
        INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("CaeLib", r1, r2);
    }

    public static void e(String r2, String r3) {
        INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("CaeLib", "[" + r2 + "] " + r3);
    }

    public static void w(String r2, String r3) {
        INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("CaeLib", "[" + r2 + "] " + r3);
    }

    public static void e(String r1) {
        INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("CaeLib", r1);
    }

    public static void w(String r1) {
        INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("CaeLib", r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_utils_LogUtil_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
