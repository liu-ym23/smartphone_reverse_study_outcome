package com.bytedance.android.live.broadcastgame.api.openplatform;

import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$versionType");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(UriProtector.getQueryParameter(UriProtector.parse(r100), "version_type"));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = null;
    L11:
        return (String) r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
