package com.bytedance.android.live.revenue.common;

import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes47.dex */
public final class l {
    public static final String a(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$formatWithUsLocale");
        Intrinsics.checkNotNullParameter(r101, "args");
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L5
        Locale r103 = Locale.US;     // Catch: Throwable -> L5
        Object[] r104 = Arrays.copyOf(r101, r101.length);     // Catch: Throwable -> L5
        return String.format(r103, r100, Arrays.copyOf(r104, r104.length));
    L5:
        return "";
    }
}
