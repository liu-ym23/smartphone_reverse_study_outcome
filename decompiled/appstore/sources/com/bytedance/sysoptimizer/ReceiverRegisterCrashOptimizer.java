package com.bytedance.sysoptimizer;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ReceiverRegisterCrashOptimizer {
    private static Application sApplication;

    public ReceiverRegisterCrashOptimizer() {
    }

    public static void fix(Application r10) {
        sApplication = r10;
    }

    public static boolean fixedOpen() {
        if (sApplication == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static Intent registerReceiver(BroadcastReceiver r10, IntentFilter r11) {
        Application r12 = sApplication;
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.getBaseContext().registerReceiver(r10, r11);
    }

    @RequiresApi(api = 26)
    public static Intent registerReceiver(BroadcastReceiver r10, IntentFilter r11, int r12) {
        Application r13 = sApplication;
        if (r13 != null) goto L7;
        return null;
    L7:
        return r13.getBaseContext().registerReceiver(r10, r11, r12);
    }

    public static Intent registerReceiver(BroadcastReceiver r10, IntentFilter r11, String r12, Handler r13) {
        Application r14 = sApplication;
        if (r14 != null) goto L7;
        return null;
    L7:
        return r14.getBaseContext().registerReceiver(r10, r11, r12, r13);
    }

    @RequiresApi(api = 26)
    public static Intent registerReceiver(BroadcastReceiver r10, IntentFilter r11, String r12, Handler r13, int r14) {
        Application r15 = sApplication;
        if (r15 != null) goto L7;
        return null;
    L7:
        return r15.getBaseContext().registerReceiver(r10, r11, r12, r13, r14);
    }
}
