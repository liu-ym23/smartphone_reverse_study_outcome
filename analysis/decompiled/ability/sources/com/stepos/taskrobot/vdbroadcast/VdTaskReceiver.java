package com.stepos.taskrobot.vdbroadcast;

import B7.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.statsrpk.service.c;
import f6.AbstractC1436a;
import j9.m;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import u6.b;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/stepos/taskrobot/vdbroadcast/VdTaskReceiver;", "Landroid/content/BroadcastReceiver;", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LC7/r;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Companion", "u6/b", "vdbroadcast_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VdTaskReceiver extends BroadcastReceiver {
    public static final b Companion = new b();
    private static final String TAG = "vdbroadcast";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        k.f(context, "context");
        k.f(intent, "intent");
        String action = intent.getAction();
        AbstractC1436a.d(TAG, "VdTaskReceiver.onReceive: action=" + action, true);
        if (!k.b(action, "com.stepos.taskrobot.vdbroadcast.action.START_TASK") && !k.b(action, "com.stepos.taskrobot.vdbroadcast.action.CANCEL_TASK")) {
            a.z("VdTaskReceiver: unknown action=", action, ", ignored", TAG, true);
            return;
        }
        String stringExtra = intent.getStringExtra("requestId");
        if (stringExtra == null || m.s0(stringExtra)) {
            c.w("VdTaskReceiver: missing requestId for action=", action, ", dropped", TAG, true);
            return;
        }
        AbstractC1436a.d(TAG, "VdTaskReceiver: forwarding to VdTaskService, requestId=".concat(stringExtra), true);
        Intent intent2 = new Intent(context, (Class<?>) VdTaskService.class);
        intent2.setAction(action);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            intent2.putExtras(extras);
        }
        try {
            context.startService(intent2);
        } catch (Throwable th) {
            AbstractC1436a.c(TAG, "VdTaskReceiver: startService failed for requestId=".concat(stringExtra), th);
        }
    }
}
