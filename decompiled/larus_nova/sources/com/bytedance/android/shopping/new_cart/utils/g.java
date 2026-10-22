package com.bytedance.android.shopping.new_cart.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g {
    public static final String a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$stackTraceToString");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        StringWriter r102 = new StringWriter();     // Catch: Throwable -> L5
        PrintWriter r103 = new PrintWriter(r102);     // Catch: Throwable -> L5
        r100.printStackTrace(r103);     // Catch: Throwable -> L5
        r103.flush();     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(r102.toString());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r104) == false) goto L10;
        r104 = null;
    L10:
        String r105 = (String) r104;
        if (r105 != null) goto L16;
        return "";
    L16:
        return r105;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
