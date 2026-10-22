package com.ttnet.org.chromium.base.library_loader;

/* JADX INFO: loaded from: classes4.dex */
class ModernLinker extends Linker {
    static {
    }

    private static native boolean nativeLoadLibraryCreateRelros(String r10, long r11, Linker.LibInfo r12);

    private static native boolean nativeLoadLibraryNoRelros(String r10);

    private static native boolean nativeLoadLibraryUseRelros(String r10, long r11, int r12);
}
