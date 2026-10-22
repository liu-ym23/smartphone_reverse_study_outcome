package com.bytedance.ai.bridge.method.login;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {
    static {
    }

    public static f3.a a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        if ((r100 instanceof LoginOperationTimeoutException) == true) goto L7;
        int r101 = com.bytedance.ai.bridge.remote.b.f36081a;
        return com.bytedance.ai.bridge.remote.b.a(r100, f3.a.f475268i);
    L7:
        return f3.a.f475275p;
    }
}
