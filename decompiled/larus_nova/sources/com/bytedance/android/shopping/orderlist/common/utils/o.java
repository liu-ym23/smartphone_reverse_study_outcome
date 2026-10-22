package com.bytedance.android.shopping.orderlist.common.utils;

import java.net.URLDecoder;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class o {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$safeDecode");
        if (StringsKt.isBlank(r100) == true) goto L19;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(URLDecoder.decode(r100, Charsets.UTF_8.name()));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r102) == false) goto L12;
        r102 = null;
    L12:
        String r103 = (String) r102;
        if (r103 != null) goto L18;
        return "";
    L18:
        return r103;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L19:
        return r100;
    }
}
