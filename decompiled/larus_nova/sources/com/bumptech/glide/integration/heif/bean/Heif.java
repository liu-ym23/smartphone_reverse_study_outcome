package com.bumptech.glide.integration.heif.bean;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public class Heif {
    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native boolean isHeif(byte[] r100, int r101);

    private static native void nativeInit();

    public static native int[] parseSimpleMeta(byte[] r100, int r101);

    public static native HeifData toRgba(byte[] r100, int r101, boolean r102, int r103, int r104, int r105, int r106, int r107);

    static {
        INVOKESTATIC_com_bumptech_glide_integration_heif_bean_Heif_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("glide_ttheif_dec");
        INVOKESTATIC_com_bumptech_glide_integration_heif_bean_Heif_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("glide_heif");
        nativeInit();
    }

    private Heif() {
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bumptech_glide_integration_heif_bean_Heif_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
