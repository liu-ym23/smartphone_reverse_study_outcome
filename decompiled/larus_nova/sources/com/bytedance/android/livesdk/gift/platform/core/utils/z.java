package com.bytedance.android.livesdk.gift.platform.core.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class z {
    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return r100.concat("_all");
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return r100.concat("_error");
    }
}
