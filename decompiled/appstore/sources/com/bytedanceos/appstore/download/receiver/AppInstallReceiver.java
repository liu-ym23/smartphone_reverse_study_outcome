package com.bytedanceos.appstore.download.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedanceos.appstore.download.service.AppInstallDispatchService;
import com.bytedanceos.common.toolbox.j;

/* JADX INFO: loaded from: classes2.dex */
public class AppInstallReceiver extends BroadcastReceiver {
    public AppInstallReceiver() {
    }

    public static void a(Context r10, Intent r11) {
        j.n("AppInstallReceiver startAppInstallDispatchService Intent:" + r11);
        Intent r12 = new Intent(r10, AppInstallDispatchService.class);
        r12.putExtra("android.intent.extra.INTENT", r11);
        r10.startService(r12);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        j.n("AppInstallReceiver Receiver Intent:" + r11);
        if (r11 != null) goto L6;
        j.e("intent is null.");
        return;
    L6:
        Intent r12 = new Intent(r10, AppInstallDispatchService.class);
        r12.putExtra("android.intent.extra.INTENT", r11);
        r10.startService(r12);
    }
}
