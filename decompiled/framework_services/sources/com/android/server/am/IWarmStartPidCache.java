package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IWarmStartPidCache {

    public static final class Entry {
        public final String packageName;
        public final int pid;
        public final int renderThreadTid;
        public final int svpType;

        public Entry(String packageName, int pid, int svpType, int renderThreadTid) {
            this.packageName = packageName;
            this.pid = pid;
            this.svpType = svpType;
            this.renderThreadTid = renderThreadTid;
        }
    }

    default Entry findCachedEntry(int uid, String processName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default void update(int uid, String processName, String packageName, int pid, int consistantSvp, int renderThreadTid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void removeIfPidMatches(int uid, String processName, int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
