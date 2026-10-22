package com.android.server;

import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public class ApplicationFreezerHelperSmt {
    private static ApplicationFreezerInternalSmt sInstance;

    public ApplicationFreezerHelperSmt() {
    }

    public static boolean registerFrozenCallbackByPidOnce(int pid, int uid, ApplicationFreezerInternalSmt.IFrozenCallback b) {
        if (sInstance != null) goto L6;
        sInstance = (ApplicationFreezerInternalSmt) LocalServices.getService(ApplicationFreezerInternalSmt.class);
    L6:
        if (sInstance != null) goto L8;
        return false;
    L8:
        return sInstance.registerFrozenCallbackByPidOnce(pid, uid, b);
    }

    public static boolean registerFrozenCallback(ApplicationFreezerInternalSmt.IFrozenCallback b, boolean register) {
        if (sInstance != null) goto L6;
        sInstance = (ApplicationFreezerInternalSmt) LocalServices.getService(ApplicationFreezerInternalSmt.class);
    L6:
        if (sInstance != null) goto L8;
        Slog.i("AFHS", "clf-BR registerFrozenCallback failed. b=" + b + ", register=" + register);
        return false;
    L8:
        return sInstance.registerFrozenCallback(b, register);
    }

    public static boolean unregisterFrozenCallbackByPidOnce(int pid, int uid, ApplicationFreezerInternalSmt.IFrozenCallback b) {
        if (sInstance != null) goto L7;
        return false;
    L7:
        return sInstance.unregisterFrozenCallbackByPidOnce(pid, uid, b);
    }
}
