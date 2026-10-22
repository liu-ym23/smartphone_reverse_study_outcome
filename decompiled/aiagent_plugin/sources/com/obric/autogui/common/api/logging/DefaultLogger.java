package com.obric.autogui.common.api.logging;

import android.util.Log;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.a.b;
import d.h.b.o;
import d.x;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: Loog.kt */
/* JADX INFO: loaded from: classes3.dex */
final class DefaultLogger implements ILogger {
    public static final DefaultLogger INSTANCE = null;

    static {
        INSTANCE = new DefaultLogger();
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static /* synthetic */ int access$003(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$004(String r0, String r1) {
        return Log.v(r0, r1);
    }

    public static /* synthetic */ int access$005(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$006(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    public static /* synthetic */ int access$007(String r0, Throwable r1) {
        return Log.w(r0, r1);
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public String getDirPath() {
        return "";
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public boolean isDebug() {
        return false;
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void uploadAllLog(String r2, b<? super Boolean, x> r3) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r2, DBHelper.BATTERY_COL_SCENE);
    }

    private DefaultLogger() {
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void dp(String r3, a<String> r4) {
        ILogger.DefaultImpls.dp(this, r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void dp(String r3, a<String> r4, a<String> r5) {
        ILogger.DefaultImpls.dp(this, r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void ep(String r3, a<String> r4, a<String> r5) {
        ILogger.DefaultImpls.ep(this, r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void ep(String r3, a<String> r4, a<String> r5, Throwable r6) {
        ILogger.DefaultImpls.ep(this, r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void ip(String r3, a<String> r4, a<String> r5) {
        ILogger.DefaultImpls.ip(this, r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void wp(String r3, a<String> r4, a<String> r5) {
        ILogger.DefaultImpls.wp(this, r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void d(String r1, String r2) {
        o.e(r1, "tag");
        INVOKESTATIC_com_obric_autogui_common_api_logging_DefaultLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(r1, String.valueOf(r2));
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void e(String r1, String r2) {
        o.e(r1, "tag");
        INVOKESTATIC_com_obric_autogui_common_api_logging_DefaultLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r1, String.valueOf(r2));
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void e(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        INVOKESTATIC_com_obric_autogui_common_api_logging_DefaultLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r1, String.valueOf(r2), r3);
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void i(String r1, String r2) {
        o.e(r1, "tag");
        INVOKESTATIC_com_obric_autogui_common_api_logging_DefaultLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(r1, String.valueOf(r2));
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void v(String r1, String r2) {
        o.e(r1, "tag");
        INVOKESTATIC_com_obric_autogui_common_api_logging_DefaultLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(r1, String.valueOf(r2));
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void w(String r1, String r2) {
        o.e(r1, "tag");
        INVOKESTATIC_com_obric_autogui_common_api_logging_DefaultLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(r1, String.valueOf(r2));
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void w(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        INVOKESTATIC_com_obric_autogui_common_api_logging_DefaultLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(r1, String.valueOf(r2), r3);
    }

    @Override // com.obric.autogui.common.api.logging.ILogger
    public void w(String r1, Throwable r2) {
        o.e(r1, "tag");
        INVOKESTATIC_com_obric_autogui_common_api_logging_DefaultLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_autogui_common_api_logging_DefaultLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_autogui_common_api_logging_DefaultLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_autogui_common_api_logging_DefaultLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_autogui_common_api_logging_DefaultLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_autogui_common_api_logging_DefaultLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, Throwable r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_autogui_common_api_logging_DefaultLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_autogui_common_api_logging_DefaultLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_autogui_common_api_logging_DefaultLogger_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
