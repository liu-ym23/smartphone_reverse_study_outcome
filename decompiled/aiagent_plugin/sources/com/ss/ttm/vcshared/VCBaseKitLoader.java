package com.ss.ttm.vcshared;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class VCBaseKitLoader {
    private VCBaseKitLoader() {
    }

    @Deprecated
    public static synchronized boolean loadLibrary() {
        monitor-enter(VCBaseKitLoader.class);
        boolean r1 = com.ss.vcbkit.VCBaseKitLoader.loadLibrary();     // Catch: Throwable -> L7
        monitor-exit(VCBaseKitLoader.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
