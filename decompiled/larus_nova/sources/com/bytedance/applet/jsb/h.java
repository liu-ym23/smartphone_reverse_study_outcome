package com.bytedance.applet.jsb;

import com.google.gson.Gson;
import com.larus.platform.api.l1;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f192057a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f192058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Gson f192059c = null;

    public h() {
    }

    static {
        f192057a = new h();
        f192058b = 2;
        f192059c = new Gson();
    }

    public final String toString() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L26
        Pair[] r102 = new Pair[4];     // Catch: Throwable -> L26
        r102[0] = TuplesKt.to("inSubscribeEvent", Boolean.FALSE);     // Catch: Throwable -> L26
        f192057a.getClass();     // Catch: Throwable -> L26
        l1 r103 = com.larus.platform.service.b.a();     // Catch: Throwable -> L26
        if (r103 != null) goto L6;
    L8:
        boolean r104 = false;
    L10:
        if (r104 == false) goto L12;
        int r105 = f192058b;     // Catch: Throwable -> L26
    L13:
        r102[1] = TuplesKt.to("statusCode", Integer.valueOf(r105));     // Catch: Throwable -> L26
        r102[2] = TuplesKt.to("resultCode", 0);     // Catch: Throwable -> L26
        Object r106 = Result.m9449constructorimpl(f192059c.toJson(null).toString());     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r106) == false) goto L21;
        r106 = null;
    L21:
        String r107 = (String) r106;     // Catch: Throwable -> L26
        if (r107 != null) goto L24;
        r107 = "";
    L24:
        r102[3] = TuplesKt.to("navInfo", r107);     // Catch: Throwable -> L26
        Object r108 = Result.m9449constructorimpl(f192059c.toJson(MapsKt.mapOf(r102)).toString());     // Catch: Throwable -> L26
    L29:
        if (Result.m9455isFailureimpl(r108) == true) goto L32;
        r100 = r108;
    L32:
        String r109 = (String) r100;
        if (r109 != null) goto L36;
        return "";
    L36:
        return r109;
    L16:
        th = move-exception;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L26
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L26
        goto L19
    L12:
        f192058b = 2;     // Catch: Throwable -> L26
        r105 = 2;
        goto L13
    L6:
        if (r103.a() != true) goto L8;
        r104 = true;
    L26:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    }
}
