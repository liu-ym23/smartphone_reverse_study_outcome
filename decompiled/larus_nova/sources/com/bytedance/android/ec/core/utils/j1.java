package com.bytedance.android.ec.core.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class j1 {
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

    public static final Set<String> b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getQueryParameterNamesSafely");
        if (r100.isHierarchical() == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        return null;
    L8:
        return UriProtector.getQueryParameterNames(r100);
    }

    public static final String c(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getQueryParameterSafely");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100.isHierarchical() == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        return null;
    L8:
        return UriProtector.getQueryParameter(r100, r101);
    }

    public static final Uri d(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$removeQueryParameterSafely");
        Intrinsics.checkNotNullParameter(r101, "queryParameterName");
        if (r100.isHierarchical() == true) goto L5;
        return r100;
    L5:
        Uri.Builder r102 = r100.buildUpon().clearQuery();
        Iterator<String> r103 = UriProtector.getQueryParameterNames(r100).iterator();
    L7:
        if (r103.hasNext() == false) goto L15;
        String r104 = r103.next();
        if ((!Intrinsics.areEqual(r104, r101)) == false) goto L7;
        Iterator<String> r105 = UriProtector.getQueryParameters(r100, r104).iterator();
    L12:
        if (r105.hasNext() == false) goto L7;
        r102.appendQueryParameter(r104, r105.next());
        goto L12
    L15:
        return r102.build();
    }
}
