package com.bytedance.platform.godzilla.anr.sp;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import java.util.ConcurrentModificationException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
class QueuedWorkProxyAboveOrEqualsAndroid0$2 implements Handler.Callback {
    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    QueuedWorkProxyAboveOrEqualsAndroid0$2() {
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r2) {
        if (r2.what != 1) goto L9;
        INVOKESTATIC_com_bytedance_platform_godzilla_anr_sp_QueuedWorkProxyAboveOrEqualsAndroid0$2_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("LinkedListForWorks", "Hint the message MSG_RUN.");
        a.a();     // Catch: ConcurrentModificationException -> L7
    L7:
        e = move-exception;
        INVOKESTATIC_com_bytedance_platform_godzilla_anr_sp_QueuedWorkProxyAboveOrEqualsAndroid0$2_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("QueuedWorkProxyAboveO", e.toString());
    L9:
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_bytedance_platform_godzilla_anr_sp_QueuedWorkProxyAboveOrEqualsAndroid0$2_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
