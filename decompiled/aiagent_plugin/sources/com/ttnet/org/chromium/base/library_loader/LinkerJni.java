package com.ttnet.org.chromium.base.library_loader;

/* JADX INFO: loaded from: classes4.dex */
class LinkerJni {
    private static native void nativeFindMemoryRegionAtRandomAddress(Linker.LibInfo r0, boolean r1);

    private static native boolean nativeFindRegionReservedByWebViewZygote(Linker.LibInfo r0);

    private static native void nativeReserveMemoryForLibrary(Linker.LibInfo r0);

    LinkerJni() {
    }
}
