package com.bytedance.android.common.sonic;

import com.bytedance.librarian.a;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class SonicJsonParser {
    public SonicJsonParser() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native boolean isNeonSupported();

    public static native Object[] processTokens(String r100, boolean r101);

    static {
        INVOKESTATIC_com_bytedance_android_common_sonic_SonicJsonParser_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("sonicjson");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_android_common_sonic_SonicJsonParser_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static <T> T parseJson(String r100, Class<T> r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        kd.a r102 = new kd.a(r100);
        return (T) GsonProtectorUtils.fromJson(new Gson(), r102, r101);
    }

    public static <T> T parseJson(Gson r100, String r101, Class<T> r102) {
        if (r101 != null) goto L6;
        return null;
    L6:
        return (T) GsonProtectorUtils.fromJson(r100, new kd.a(r101), r102);
    }
}
