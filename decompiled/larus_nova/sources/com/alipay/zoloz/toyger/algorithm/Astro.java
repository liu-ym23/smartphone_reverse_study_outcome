package com.alipay.zoloz.toyger.algorithm;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public class Astro {
    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native void sub_message_channel_ack(byte[] r100, long r101);

    public static native void sub_message_channel_get(byte[] r100, long r101);

    public static native boolean sub_message_channel_init();

    public static native void sub_message_channel_notification(byte[] r100, long r101);

    public static native void sub_message_channel_post(byte[] r100, long r101);

    static {
        INVOKESTATIC_com_alipay_zoloz_toyger_algorithm_Astro_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("toyger");
    }

    public Astro() {
    }

    @JvmStatic
    public static void INVOKESTATIC_com_alipay_zoloz_toyger_algorithm_Astro_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
