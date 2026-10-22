package com.bytedance.android.shopping.store.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class n {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dropRenderCacheParams");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L14
        Uri r102 = UriProtector.parse(r100);     // Catch: Throwable -> L14
        Uri.Builder r103 = r102.buildUpon().clearQuery();     // Catch: Throwable -> L14
        Set<String> r104 = UriProtector.getQueryParameterNames(r102);     // Catch: Throwable -> L14
        if (r104 == null) goto L12;
        Iterator<T> r105 = r104.iterator();     // Catch: Throwable -> L14
    L7:
        if (r105.hasNext() == false) goto L12;
        String r106 = (String) r105.next();     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(r106, "inject_config_channel") == true) goto L7;
        r103.appendQueryParameter(r106, UriProtector.getQueryParameter(r102, r106));     // Catch: Throwable -> L14
    L12:
        return r103.build().toString();
    L14:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return r100;
    }

    public static final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getWithoutQuery");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(UriProtector.parse(r100).buildUpon().clearQuery().build().toString());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        String r103 = (String) r102;
        if (r103 == null) goto L13;
        return r103;
    L13:
        return StringsKt.substringBefore$default(r100, '?', null, 2, null);
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final Uri c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$safeParse");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(UriProtector.parse(r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = null;
    L11:
        return (Uri) r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
