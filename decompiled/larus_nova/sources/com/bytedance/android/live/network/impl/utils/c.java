package com.bytedance.android.live.network.impl.utils;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f83926a = 0;

    static {
    }

    public static int a(Throwable r100) {
        boolean r101 = r100 instanceof ApiServerException;
        int r102 = 0;
        if (r101 == false) goto L6;
        int r103 = ((ApiServerException) r100).getErrorCode();
    L12:
        if (r101 == false) goto L15;
        String r104 = ((ApiServerException) r100).getErrorMsg();
    L21:
        if (r103 != 0) goto L35;
        if (r104 == null) goto L32;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L26
        int r106 = StringsKt.lastIndexOf$default(r104, "InternalErrorCode=", 0, false, 6, null);     // Catch: Throwable -> L26
        r102 = CastIntegerProtector.parseInt(r104.substring(r106 + 18, StringsKt.indexOf$default(r104, ',', r106, false, 4, null)));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Object r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r108) == false) goto L30;
        r108 = 0;
    L30:
        r102 = ((Number) r108).intValue();
    L32:
        return r102;
    L35:
        return r103;
    L15:
        if ((r100 instanceof NetworkErrorException) == false) goto L18;
        r104 = r100.getMessage();
        goto L21
    L18:
        if ((r100 instanceof Exception) == false) goto L20;
        r104 = r100.getMessage();
        goto L21
    L20:
        r104 = null;
        goto L21
    L6:
        if ((r100 instanceof NetworkErrorException) == false) goto L9;
        r103 = ((NetworkErrorException) r100).statusCode;
        goto L12
    L9:
        if ((r100 instanceof ApiException) == false) goto L11;
        r103 = ((ApiException) r100).getErrorCode();
        goto L12
    L11:
        r103 = 0;
        goto L12
    }
}
