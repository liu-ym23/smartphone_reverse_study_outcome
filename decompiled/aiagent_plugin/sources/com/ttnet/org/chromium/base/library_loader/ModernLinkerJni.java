package com.ttnet.org.chromium.base.library_loader;

/* JADX INFO: loaded from: classes4.dex */
class ModernLinkerJni {
    private static final String TAG = "ModernLinkerJni";

    private static native int nativeGetRelroSharingResult();

    private static native boolean nativeLoadLibrary(String r0, Linker.LibInfo r1, boolean r2);

    private static native boolean nativeUseRelros(long r0, Linker.LibInfo r2);

    ModernLinkerJni() {
    }

    public static void reportDlopenExtTime(long r0) {
        a.a(r0);
    }

    public static void reportIteratePhdrTime(long r0) {
        a.b(r0);
    }
}
