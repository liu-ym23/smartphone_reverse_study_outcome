package com.bytedance.android.alog;

import com.ss.android.agilelogger.ALog;

/* JADX INFO: loaded from: classes.dex */
class NativeCallback {
    public NativeCallback() {
    }

    public static void onNativeDeleteLog(String r100, long r101, int r102) {
        ALog.notifyLogFileDelete(r100, r101, r102);     // Catch: Throwable -> L4
        return;
    }
}
