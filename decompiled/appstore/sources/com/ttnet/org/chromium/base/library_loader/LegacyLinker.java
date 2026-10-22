package com.ttnet.org.chromium.base.library_loader;

/* JADX INFO: loaded from: classes4.dex */
class LegacyLinker extends Linker {
    static {
    }

    private static native boolean nativeAddZipArchivePath(String r10);

    private static native boolean nativeCreateSharedRelro(String r10, long r11, Linker.LibInfo r12);

    private static native boolean nativeLoadLibrary(String r10, long r11, Linker.LibInfo r12);

    private static native boolean nativeUseSharedRelro(String r10, Linker.LibInfo r11);
}
