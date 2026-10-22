package com.ttnet.org.chromium.base.library_loader;

/* JADX INFO: loaded from: classes4.dex */
class LegacyLinker extends Linker {
    private static final String TAG = "LegacyLinker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37714a = true;

    static {
    }

    private static native boolean nativeAddZipArchivePath(String r0);

    private static native boolean nativeCreateSharedRelro(String r0, long r1, Linker.LibInfo r3);

    private static native boolean nativeLoadLibrary(String r0, long r1, Linker.LibInfo r3);

    private static native boolean nativeUseSharedRelro(String r0, Linker.LibInfo r1);

    LegacyLinker() {
    }
}
