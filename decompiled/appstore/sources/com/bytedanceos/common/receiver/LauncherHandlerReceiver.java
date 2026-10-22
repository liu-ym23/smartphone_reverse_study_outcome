package com.bytedanceos.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.j;

/* JADX INFO: loaded from: classes2.dex */
public class LauncherHandlerReceiver extends BroadcastReceiver {
    public LauncherHandlerReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        j.e("Intent:" + r11);
        BaseApplication.u("LauncherHandlerReceiver", false);
        if (TextUtils.equals(r11.getAction(), "com.bytedanceos.launcher.ready") == false) goto L5;
        BaseApplication.c().b().P();
    L5:
        BaseApplication.u("LauncherHandlerReceiver", true);
    }
}
