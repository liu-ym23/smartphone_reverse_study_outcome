package com.android.server.am;

import com.android.server.ServiceThread;

/* JADX INFO: loaded from: classes.dex */
public interface IZswCachedAppOptimizer {
    void beginCompact(ServiceThread r1, CachedAppOptimizer.CompactProfile r2, int r3, String r4, long[] r5, ProcessRecord r6);

    void endCompact(ServiceThread r1, int r2);

    void freezeAppAsyncInternalLSP4CpuFreezer(ProcessRecord r1, boolean r2);

    void freezeProcess4CpuFreezer(ProcessRecord r1);

    int getRssThrottleCompactionType(CachedAppOptimizer.CompactProfile r1, int r2, String r3, long[] r4, ProcessRecord r5);

    boolean getUidFreezeState4CpuFreezer(int r1);

    Object getUnfreezeSyncLock();

    boolean isSkipCompact(CachedAppOptimizer.CompactProfile r1, int r2, String r3, long[] r4, ProcessRecord r5);

    void setUidFreezeState4CpuFreezer(int r1, boolean r2);

    boolean shouldSkipCompact();

    void unfreezeAppLSP4CpuFreezer(ProcessRecord r1, int r2);

    void updateUseFreezer(String r1);
}
