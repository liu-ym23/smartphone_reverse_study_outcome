package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.content.res.Resources;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes10.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153115a = 0;

    static {
    }

    public static String a(Context r100, int r101) {
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        if (r100 == null) goto L8;
        Resources r104 = th.a.f(r100);     // Catch: Throwable -> L11
        if (r104 == null) goto L8;
        String r105 = r104.getString(r101);     // Catch: Throwable -> L11
    L9:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L11
    L14:
        if (Result.m9452exceptionOrNullimpl(r106) == null) goto L17;
        dm.a.a("ECLiveResourceUtils").i("safeGetResourceText error!!!");
    L17:
        if (Result.m9455isFailureimpl(r106) == true) goto L21;
        r102 = r106;
    L21:
        return (String) r102;
    L8:
        r105 = null;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
