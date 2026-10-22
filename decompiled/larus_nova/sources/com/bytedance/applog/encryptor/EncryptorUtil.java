package com.bytedance.applog.encryptor;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public class EncryptorUtil {
    public EncryptorUtil() {
    }

    private static native byte[] ttEncrypt(byte[] r100, int r101);

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("EncryptorP", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> EncryptorP");
        a.c("EncryptorP");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> EncryptorP");
    }

    static {
        a();     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
