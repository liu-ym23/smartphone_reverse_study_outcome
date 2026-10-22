package com.bytedance.ai.applet.moa;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f34870a = null;

    static {
        f34870a = new p();
    }

    public p() {
    }

    public static Object a(u2.f r100, Class r101) {
        String r102 = r100.e();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L24;
        return null;
    L24:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L14
        Object r105 = Result.m9449constructorimpl(com.bytedance.ai.applet.base.gson.e.a(r102, r101));     // Catch: Throwable -> L14
    L16:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L20;
        com.bytedance.ai.utils.g.f37637a.e("MoaGrantingStepFactory", "Failed to parse " + r100.b() + " relatedData", r106);
    L20:
        if (Result.m9455isFailureimpl(r105) == false) goto L23;
        return null;
    L23:
        return r105;
    L14:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r103 = false;
        goto L10
    }
}
