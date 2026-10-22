package com.bytedance.keva;

import android.util.Log;
import com.obric.aiagent.apm.impl.a;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class KevaMonitor {
    public static /* synthetic */ int access$000(int r0, String r1, String r2) {
        return Log.println(r0, r1, r2);
    }

    public static /* synthetic */ int access$001(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public KevaMonitor() {
    }

    public void loadLibrary(String r1) {
        System.loadLibrary(r1);
    }

    public void onLoadRepo(String r2, int r3) {
        INVOKESTATIC_com_bytedance_keva_KevaMonitor_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_println(4, KevaConstants.TAG, "load repo: " + r2 + ", with mode: " + r3);
    }

    public void reportThrowable(int r2, String r3, String r4, Object r5, Throwable r6) {
        INVOKESTATIC_com_bytedance_keva_KevaMonitor_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(KevaConstants.TAG, "action: [" + r2 + "], repo: [" + r3 + "], key: [" + r4 + "], value: [" + r5 + "], msg: " + r6.getMessage(), r6);
    }

    public void reportWarning(int r2, String r3, String r4, Object r5, String r6) {
        INVOKESTATIC_com_bytedance_keva_KevaMonitor_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_println(5, KevaConstants.TAG, "action: [" + r2 + "], repo: [" + r3 + "], key: [" + r4 + "], value: [" + r5 + "], msg: " + r6);
    }

    public void logDebug(String r2) {
        INVOKESTATIC_com_bytedance_keva_KevaMonitor_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_println(4, KevaConstants.TAG, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_keva_KevaMonitor_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_keva_KevaMonitor_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_println(int r1, String r2, String r3) {
        if (a.a() == false) goto L10;
        if (r1 == 6) goto L10;
        return 0;
    L10:
        return Log.println(r1, r2, r3);
    }
}
