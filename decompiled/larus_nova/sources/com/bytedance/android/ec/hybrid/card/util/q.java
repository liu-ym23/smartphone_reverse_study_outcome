package com.bytedance.android.ec.hybrid.card.util;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class q {
    public static final HashMap<String, String> a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getQueryMap");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L27
        HashMap r103 = new HashMap();     // Catch: Throwable -> L27
        Iterator<T> r104 = UriProtector.getQueryParameterNames(r100).iterator();     // Catch: Throwable -> L27
    L5:
        if (r104.hasNext() == false) goto L25;
        String r105 = (String) r104.next();     // Catch: Throwable -> L27
        boolean r106 = false;
        if (r105 != null) goto L9;
    L12:
        boolean r107 = true;
    L13:
        if (r107 == true) goto L5;
        String r108 = UriProtector.getQueryParameter(r100, r105);     // Catch: Throwable -> L27
        if (r108 != null) goto L17;
    L18:
        r106 = true;
    L20:
        if ((!r106) == true) goto L23;
        r108 = null;
    L23:
        if (r108 == null) goto L5;
        String r109 = (String) r103.put(r105, r108);     // Catch: Throwable -> L27
        goto L5
    L17:
        if (StringsKt.isBlank(r108) == false) goto L20;
    L9:
        if (StringsKt.isBlank(r105) == true) goto L12;
        r107 = false;
        goto L13
    L25:
        Object r110 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L27
    L30:
        if (Result.m9455isFailureimpl(r110) == true) goto L33;
        r101 = r110;
    L33:
        HashMap<String, String> r111 = (HashMap) r101;
        if (r111 == null) goto L36;
        return r111;
    L36:
        return new HashMap();
    L27:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    }

    public static final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        Uri r102 = UriProtector.parse(r100);     // Catch: Throwable -> L11
        if (r102 == null) goto L9;
        String r103 = UriProtector.getQueryParameter(r102, "surl");     // Catch: Throwable -> L11
        if (r103 == null) goto L8;
        return r103;
    L8:
        return UriProtector.getQueryParameter(r102, "url");
    L9:
        Result.m9449constructorimpl(null);     // Catch: Throwable -> L11
    L13:
        return null;
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static final String c(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$safeGetQuery");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L18
        if (UriProtector.getQueryParameterNames(r100).contains(r101) == false) goto L15;
        String r104 = UriProtector.getQueryParameter(r100, r101);     // Catch: Throwable -> L18
        boolean r105 = false;
        if (r104 != null) goto L8;
    L13:
        if (r105 == false) goto L15;
    L16:
        Object r106 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L18
    L21:
        if (Result.m9455isFailureimpl(r106) == true) goto L25;
        r102 = r106;
    L25:
        return (String) r102;
    L8:
        if (r104.length() <= 0) goto L10;
        boolean r107 = true;
    L11:
        if (r107 != true) goto L13;
        r105 = true;
        goto L13
    L10:
        r107 = false;
    L15:
        r104 = null;
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }
}
