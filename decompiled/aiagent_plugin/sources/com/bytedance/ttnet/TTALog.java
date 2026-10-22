package com.bytedance.ttnet;

import android.content.Context;
import android.util.Log;
import com.bytedance.frameworks.baselib.network.http.cronet.b.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class TTALog {
    private static final String TAG = "TTNET_ALog";
    private static volatile long sALogFuncAddr;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public TTALog() {
    }

    public static void init() {
        ensureALogInitialized();
    }

    public static long getALogFuncAddr() {
        return sALogFuncAddr;
    }

    private static void ensureALogInitialized() {
        sALogFuncAddr = com.ss.android.agilelogger.a.e();
        INVOKESTATIC_com_bytedance_ttnet_TTALog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "ALog function address is " + sALogFuncAddr);
        if (sALogFuncAddr != 0) goto L6;
        com.ss.android.agilelogger.a.a($$Lambda$TTALog$VuU2YSPkKkOq6JW9li3Qg1L_A.INSTANCE);
        return;
    }

    static /* synthetic */ void lambda$ensureALogInitialized$0(long r4) {
        if (sALogFuncAddr == 0) goto L7;
        INVOKESTATIC_com_bytedance_ttnet_TTALog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "ALog function address has initialized.");
        return;
    L7:
        if (r4 != 0) goto L10;
        INVOKESTATIC_com_bytedance_ttnet_TTALog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Cannot get ALog function address in init callback.");
        return;
    L10:
        sALogFuncAddr = r4;
        INVOKESTATIC_com_bytedance_ttnet_TTALog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "ALog function address is " + sALogFuncAddr + " from callback.");
        i r5 = getCronetHttpClient();     // Catch: Exception -> L15
        if (r5 == null) goto L20;
        r5.a(sALogFuncAddr);     // Catch: Exception -> L15
        return;
    L20:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    private static i getCronetHttpClient() {
        if (c.b() == true) goto L5;
        return null;
    L5:
        return i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_ttnet_TTALog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_ttnet_TTALog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
