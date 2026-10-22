package com.bytedance.android.ec.core.utils;

import com.bytedance.ttnet.TTNetInit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h0 {
    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        TTNetInit.preconnectUrl(r100);     // Catch: Exception -> L5
        dm.a.a("ECNetHelper").i("url preconnect success, url = " + r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        dm.a.a("ECNetHelper").b("url preconnect failed, exception = " + e, null);
    }
}
