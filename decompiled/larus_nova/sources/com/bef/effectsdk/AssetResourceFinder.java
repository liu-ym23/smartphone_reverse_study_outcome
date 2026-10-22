package com.bef.effectsdk;

import android.content.res.AssetManager;

/* JADX INFO: loaded from: classes39.dex */
public final class AssetResourceFinder implements ResourceFinder {
    private final AssetManager mAssetManager;
    private final String mDir;

    private static native long nativeCreateAssetResourceFinder(long r100, AssetManager r101, String r102);

    private static native void nativeReleaseAssetResourceFinder(long r100);

    @Override // com.bef.effectsdk.ResourceFinder
    public synchronized long createNativeResourceFinder(long r100) {
        monitor-enter(this);
        long r101 = nativeCreateAssetResourceFinder(r100, this.mAssetManager, this.mDir);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bef.effectsdk.ResourceFinder
    public synchronized void release(long r100) {
        monitor-enter(this);
        nativeReleaseAssetResourceFinder(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public AssetResourceFinder(AssetManager r100, String r101) {
        this.mAssetManager = r100;
        this.mDir = r101;
    }
}
