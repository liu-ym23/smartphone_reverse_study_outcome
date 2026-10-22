package com.bytedance.ai.bridge.method.router;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class t {
    static {
    }

    public static f3.a a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        if ((r100 instanceof IllegalArgumentException) == false) goto L6;
        return f3.a.f475267h;
    L6:
        return f3.a.f475265f;
    }
}
