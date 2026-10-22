package com.android.server.am;

import android.os.DebugSmtEx;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public interface IMemoryReclaimer {
    public static final int ACTIION_RECLAIM_ALL = 4;
    public static final int ACTIION_RECLAIM_ANON = 3;
    public static final int ACTIION_RECLAIM_FILE = 2;

    public interface IReclaimCallback {
        void onSuccuss(int r1);
    }

    default boolean commitToReclaim(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void registerCallback(IReclaimCallback callback, boolean reg) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void reclaimImpl(int reclaim, int[] pids) throws Exception {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isPcMode() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void compactAppFull(ProcessRecord app) {
        Slog.e("SYS_DEFAULT_LOG", getClass().getName() + "|" + Thread.currentThread().getStackTrace()[1].getMethodName() + "|SYS_DEFAULT_FUN_CONTENT");
    }

    default void compactAppSome(ProcessRecord app) {
        Slog.e("SYS_DEFAULT_LOG", getClass().getName() + "|" + Thread.currentThread().getStackTrace()[1].getMethodName() + "|SYS_DEFAULT_FUN_CONTENT");
    }

    default boolean isAllowedPush(int pid) {
        Slog.e("SYS_DEFAULT_LOG", getClass().getName() + "|" + Thread.currentThread().getStackTrace()[1].getMethodName() + "|SYS_DEFAULT_FUN_CONTENT");
        return false;
    }

    default boolean useArdCompactor() {
        Slog.e("SYS_DEFAULT_LOG", getClass().getName() + "|" + Thread.currentThread().getStackTrace()[1].getMethodName() + "|SYS_DEFAULT_FUN_CONTENT");
        return false;
    }
}
