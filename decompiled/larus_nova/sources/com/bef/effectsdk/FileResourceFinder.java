package com.bef.effectsdk;

/* JADX INFO: loaded from: classes39.dex */
public final class FileResourceFinder implements ResourceFinder {
    private final String mDir;

    private static native long nativeCreateFileResourceFinder(long r100, String r101);

    @Override // com.bef.effectsdk.ResourceFinder
    public void release(long r100) {
    }

    public FileResourceFinder(String r100) {
        this.mDir = r100;
    }

    @Override // com.bef.effectsdk.ResourceFinder
    public long createNativeResourceFinder(long r100) {
        return nativeCreateFileResourceFinder(r100, this.mDir);
    }
}
