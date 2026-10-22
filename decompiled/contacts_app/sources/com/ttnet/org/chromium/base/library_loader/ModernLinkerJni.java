package com.ttnet.org.chromium.base.library_loader;

/* JADX INFO: loaded from: classes4.dex */
class ModernLinkerJni implements ModernLinker.Natives {
    private static final String TAG = "ModernLinkerJni";

    private static native int nativeGetRelroSharingResult();

    private static native boolean nativeLoadLibrary(String r0, Linker.LibInfo r1, boolean r2);

    private static native boolean nativeUseRelros(long r0, Linker.LibInfo r2);

    ModernLinkerJni() {
    }

    @Override // com.ttnet.org.chromium.base.library_loader.ModernLinker.Natives
    public boolean loadLibrary(String r1, Linker.LibInfo r2, boolean r3) {
        return nativeLoadLibrary(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.ModernLinker.Natives
    public boolean useRelros(long r1, Linker.LibInfo r3) {
        return nativeUseRelros(r1, r3);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.ModernLinker.Natives
    public int getRelroSharingResult() {
        return nativeGetRelroSharingResult();
    }

    public static void reportDlopenExtTime(long r0) {
        ModernLinker.reportDlopenExtTime(r0);
    }

    public static void reportIteratePhdrTime(long r0) {
        ModernLinker.reportIteratePhdrTime(r0);
    }
}
