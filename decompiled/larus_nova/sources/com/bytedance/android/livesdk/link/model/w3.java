package com.bytedance.android.livesdk.link.model;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class w3 {
    public static final String a(v3 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toParams");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(l97.a.f508113a.toJson(r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        String r103 = (String) r102;
        if (r103 != null) goto L16;
        return "";
    L16:
        return r103;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
