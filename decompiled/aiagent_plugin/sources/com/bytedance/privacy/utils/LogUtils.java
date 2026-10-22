package com.bytedance.privacy.utils;

import android.util.Log;
import com.bytedance.privacy.bridge.ILogBridge;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.apm.impl.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class LogUtils {
    private static final boolean LOG_DEBUG = false;
    private static ILogBridge mLogBridge;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$003(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public LogUtils() {
    }

    static {
        LOG_DEBUG = PrivacyConfig.isDebug();
    }

    public static void init(ILogBridge r2) {
        mLogBridge = (ILogBridge) ZeusTransformUtils.wrapperContextForParams(r2, ILogBridge.class, "com.obric.aiagent.plugin");
    }

    public static void d(String r0, String r1, Throwable r2) {
        if (LOG_DEBUG == false) goto L8;
        INVOKESTATIC_com_bytedance_privacy_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(r0, r1);
        ILogBridge r3 = mLogBridge;
        if (r3 == null) goto L9;
        r3.i(r0, r1);
        return;
    L9:
        return;
    }

    public static void i(String r0, String r1, Throwable r2) {
        INVOKESTATIC_com_bytedance_privacy_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(r0, r1);
        ILogBridge r3 = mLogBridge;
        if (r3 == null) goto L6;
        r3.i(r0, r1);
        return;
    }

    public static void e(String r0, String r1, Throwable r2) {
        INVOKESTATIC_com_bytedance_privacy_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r0, r1, r2);
        ILogBridge r3 = mLogBridge;
        if (r3 == null) goto L6;
        r3.e(r0, r1);
        return;
    }

    public static void d(String r1, String r2) {
        if (LOG_DEBUG == false) goto L8;
        INVOKESTATIC_com_bytedance_privacy_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(r1, r2);
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L9;
        r0.i(r1, r2);
        return;
    L9:
        return;
    }

    public static void i(String r1, String r2) {
        INVOKESTATIC_com_bytedance_privacy_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(r1, r2);
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L6;
        r0.i(r1, r2);
        return;
    }

    public static void w(String r1, String r2) {
        INVOKESTATIC_com_bytedance_privacy_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(r1, r2);
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L6;
        r0.w(r1, r2);
        return;
    }

    public static void e(String r1, String r2) {
        INVOKESTATIC_com_bytedance_privacy_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r1, r2);
        ILogBridge r0 = mLogBridge;
        if (r0 == null) goto L6;
        r0.e(r1, r2);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_privacy_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_privacy_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_privacy_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_privacy_utils_LogUtils_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
