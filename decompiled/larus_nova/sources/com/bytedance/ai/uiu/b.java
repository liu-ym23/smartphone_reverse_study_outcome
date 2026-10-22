package com.bytedance.ai.uiu;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b {
    public static final String a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "jsonString");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r110, "\\", "\\\\", false, 4, null), "\"", "\\\"", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null), "\t", "\\t", false, 4, null);
    }
}
