package com.bytedance.android.shopping.store.tabkit.cache;

import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class c {
    public static final String a(String r100) {
        Object r101 = null;
        if (StringsKt.isBlank(r100) == true) goto L17;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl(UriProtector.parse(r100).buildUpon().clearQuery().toString());     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r103) == true) goto L14;
        r101 = r103;
    L14:
        return (String) r101;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L17:
        return null;
    }
}
