package com.bytedanceos.appstore.download.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedanceos.appstore.utils.a;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.j;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenMoniterReceiver extends BroadcastReceiver {
    public ScreenMoniterReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        BaseApplication.u("ScreenMoniterReceiver", false);
        if (TextUtils.equals("android.intent.action.SCREEN_OFF", r11.getAction()) == false) goto L6;
        j.n("ScreenMoniterReceiver:" + r11);
        a.a();
        BaseApplication.c().v(false);
    L8:
        BaseApplication.u("ScreenMoniterReceiver", true);
        return;
    L6:
        if (TextUtils.equals("android.intent.action.SCREEN_ON", r11.getAction()) == false) goto L8;
        BaseApplication.c().v(true);
        goto L8
    }
}
