package com.bytedance.android.shopping.extensions;

import android.graphics.Color;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    public static final int a(String r100, int r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(r100)));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r103) == false) goto L9;
        r103 = null;
    L9:
        Integer r104 = (Integer) r103;
        if (r104 != null) goto L12;
        return r101;
    L12:
        return r104.intValue();
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
