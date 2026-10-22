package com.obric.aikernel.core.log;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.apm.impl.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: AIKLog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AIKLog implements ILog {
    public static final AIKLog INSTANCE = null;
    private static final boolean NEED_PREFIX = true;
    private static final String TAG_PREFIX = "AIK_Client_";
    private static ILog logInst;

    static {
        INSTANCE = new AIKLog();
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.v(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$003(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$004(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    public static /* synthetic */ int access$005(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$006(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public boolean isDebug() {
        return true;
    }

    private AIKLog() {
    }

    public final void registerLog(ILog r2) {
        ILog r1 = (ILog) ZeusTransformUtils.wrapperContextForParams(r2, ILog.class, "com.obric.aiagent.plugin");
        o.e(r1, "inst");
        logInst = r1;
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void d(String r2, String r3) {
        o.e(r2, "tag");
        o.e(r3, "msg");
        ILog r0 = logInst;
        String r1 = logTag(r2);
        if (r0 == null) goto L5;
        r0.d(r1, r3);
        return;
    L5:
        INVOKESTATIC_com_obric_aikernel_core_log_AIKLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(r1, r3);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void v(String r2, String r3) {
        o.e(r2, "tag");
        o.e(r3, "msg");
        ILog r0 = logInst;
        String r1 = logTag(r2);
        if (r0 == null) goto L5;
        r0.v(r1, r3);
        return;
    L5:
        INVOKESTATIC_com_obric_aikernel_core_log_AIKLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(r1, r3);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void i(String r2, String r3) {
        o.e(r2, "tag");
        o.e(r3, "msg");
        ILog r0 = logInst;
        String r1 = logTag(r2);
        if (r0 == null) goto L5;
        r0.i(r1, r3);
        return;
    L5:
        INVOKESTATIC_com_obric_aikernel_core_log_AIKLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(r1, r3);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void w(String r2, String r3) {
        o.e(r2, "tag");
        o.e(r3, "msg");
        ILog r0 = logInst;
        String r1 = logTag(r2);
        if (r0 == null) goto L5;
        r0.w(r1, r3);
        return;
    L5:
        INVOKESTATIC_com_obric_aikernel_core_log_AIKLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(r1, r3);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void w(String r2, String r3, Throwable r4) {
        o.e(r2, "tag");
        o.e(r3, "msg");
        o.e(r4, "t");
        ILog r0 = logInst;
        String r1 = logTag(r2);
        if (r0 == null) goto L5;
        r0.w(r1, r3, r4);
        return;
    L5:
        INVOKESTATIC_com_obric_aikernel_core_log_AIKLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(r1, r3, r4);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void e(String r2, String r3) {
        o.e(r2, "tag");
        o.e(r3, "msg");
        ILog r0 = logInst;
        String r1 = logTag(r2);
        if (r0 == null) goto L5;
        r0.e(r1, r3);
        return;
    L5:
        INVOKESTATIC_com_obric_aikernel_core_log_AIKLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r1, r3);
    }

    @Override // com.obric.aikernel.core.log.ILog
    public void e(String r2, String r3, Throwable r4) {
        o.e(r2, "tag");
        o.e(r3, "msg");
        o.e(r4, "t");
        ILog r0 = logInst;
        String r1 = logTag(r2);
        if (r0 == null) goto L5;
        r0.e(r1, r3, r4);
        return;
    L5:
        INVOKESTATIC_com_obric_aikernel_core_log_AIKLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r1, r3, r4);
    }

    private final String logTag(String r2) {
        return TAG_PREFIX + r2;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aikernel_core_log_AIKLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aikernel_core_log_AIKLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aikernel_core_log_AIKLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aikernel_core_log_AIKLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aikernel_core_log_AIKLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aikernel_core_log_AIKLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aikernel_core_log_AIKLog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
