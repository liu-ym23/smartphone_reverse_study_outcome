package com.baidu.mapsdkplatform.comapi.util;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public class c {
    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    @JvmStatic
    public static void INVOKESTATIC_com_baidu_mapsdkplatform_comapi_util_c_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static void a(String r100) {
        INVOKESTATIC_com_baidu_mapsdkplatform_comapi_util_c_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);
    }
}
