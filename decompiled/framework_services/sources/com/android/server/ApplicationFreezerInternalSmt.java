package com.android.server;

import com.android.server.am.ProcessRecord;

/* JADX INFO: loaded from: classes.dex */
public interface ApplicationFreezerInternalSmt {

    public interface IFrozenCallback {
        default void onAppFreeze(int pid, int uid) {
        }

        default void onAppUnfreeze(int pid, int uid) {
        }

        default void onAppFreeze(ProcessRecord proc) {
        }

        default void onAppUnfreeze(ProcessRecord proc) {
        }
    }

    boolean registerFrozenCallback(IFrozenCallback r1, boolean r2);

    boolean registerFrozenCallbackByPidOnce(int r1, int r2, IFrozenCallback r3);

    boolean unregisterFrozenCallbackByPidOnce(int r1, int r2, IFrozenCallback r3);
}
