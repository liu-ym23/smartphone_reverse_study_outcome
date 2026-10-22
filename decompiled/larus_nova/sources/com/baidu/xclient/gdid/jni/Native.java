package com.baidu.xclient.gdid.jni;

import com.alipay.sdk.m.u.i;
import com.baidu.xclient.gdid.j.f;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public class Native {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f33642a = "";

    static {
        INVOKESTATIC_com_baidu_xclient_gdid_jni_Native_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("tiny_magic");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        f33642a = f.b(th).replaceAll("\t", i.f25853b).replaceAll("\n", i.f25853b);
        throw th;
    }

    public Native() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public String a() {
        return f33642a;
    }

    public native byte[] ac(byte[] r100, byte[] r101);

    public native byte[] acn(byte[] r100, byte[] r101);

    public native byte[] dc(byte[] r100, byte[] r101);

    public native byte[] dcn(byte[] r100, byte[] r101);

    public native Object jnictl(int r100, Object r101, Object r102, Object r103);

    @JvmStatic
    public static void INVOKESTATIC_com_baidu_xclient_gdid_jni_Native_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
