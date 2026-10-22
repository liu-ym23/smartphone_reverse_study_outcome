package com.apm.lite.k;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public final class t {
    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("apmlitea", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> apmlitea");
        com.bytedance.librarian.a.c("apmlitea");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> apmlitea");
    }
}
