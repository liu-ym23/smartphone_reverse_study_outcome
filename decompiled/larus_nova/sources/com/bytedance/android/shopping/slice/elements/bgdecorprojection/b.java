package com.bytedance.android.shopping.slice.elements.bgdecorprojection;

import android.graphics.Bitmap;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final long a(Bitmap r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        if ((!r100.isRecycled()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L21;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        Object r102 = Result.m9449constructorimpl(Long.valueOf(r100.getAllocationByteCount()));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r102) == false) goto L17;
        r102 = 0L;
    L17:
        return ((Number) r102).longValue();
    L11:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L21:
        return 0;
    }

    public static final void b(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((!r100.isRecycled()) == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L11;
        r100.recycle();
        return;
    }
}
