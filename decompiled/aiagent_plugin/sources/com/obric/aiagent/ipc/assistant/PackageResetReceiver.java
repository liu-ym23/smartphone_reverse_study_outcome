package com.obric.aiagent.ipc.assistant;

import android.content.Context;
import android.content.Intent;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PackageResetReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PackageResetReceiver extends PluginBroadcastReceiver {
    public PackageResetReceiver() {
    }

    public void onReceive(Context r2, Intent r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        String r4 = r3.getAction();
    L6:
        if (r4 == null) goto L22;
        int r5 = r4.hashCode();
        if (r5 == 267468725) goto L17;
        if (r5 == 525384130) goto L13;
        return;
    L13:
        if (r4.equals("android.intent.action.PACKAGE_REMOVED") == false) goto L26;
        boolean r6 = r3.getBooleanExtra("android.intent.extra.DATA_REMOVED", false);
    L19:
        if (r6 == false) goto L24;
        com.obric.aiagent.ipc.notifier.a.f18639a.c(r3);
        return;
    L24:
        return;
    L26:
        return;
    L17:
        if (r4.equals("android.intent.action.PACKAGE_DATA_CLEARED") == false) goto L23;
        r6 = true;
        goto L19
    L23:
        return;
    L22:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
