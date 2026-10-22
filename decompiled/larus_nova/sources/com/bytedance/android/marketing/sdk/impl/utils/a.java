package com.bytedance.android.marketing.sdk.impl.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {
    public static final Uri a(Uri r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendOrReplaceParameter");
        if (r102 == null) goto L25;
        Uri.Builder r103 = r100.buildUpon();
        r103.clearQuery();
        Iterator<String> r104 = UriProtector.getQueryParameterNames(r100).iterator();
        boolean r105 = false;
    L7:
        if (r104.hasNext() == false) goto L15;
        String r106 = r104.next();
        if ((!Intrinsics.areEqual(r106, r101)) == true) goto L10;
        r103.appendQueryParameter(r106, r102);
        r105 = true;
        goto L7
    L10:
        Iterator<String> r107 = UriProtector.getQueryParameters(r100, r106).iterator();
    L12:
        if (r107.hasNext() == false) goto L7;
        r103.appendQueryParameter(r106, r107.next());
        goto L12
    L15:
        if (r105 == true) goto L18;
        r103.appendQueryParameter(r101, r102);
    L18:
        return r103.build();
    L25:
        return r100;
    }

    public static final String b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendOrReplaceParameter");
        return a(UriProtector.parse(r100), r101, r102).toString();
    L8:
        return r100;
    }

    public static final Uri c(Uri r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$replaceParameter");
        if (r102 == null) goto L26;
        Uri.Builder r103 = r100.buildUpon();
        r103.clearQuery();
        Iterator<String> r104 = UriProtector.getQueryParameterNames(r100).iterator();
    L7:
        if (r104.hasNext() == false) goto L19;
        String r105 = r104.next();
        if ((!Intrinsics.areEqual(r105, r101)) == true) goto L10;
        Iterator<String> r106 = UriProtector.getQueryParameters(r100, r105).iterator();
    L16:
        if (r106.hasNext() == false) goto L7;
        String r107 = r106.next();
        r103.appendQueryParameter(r105, r102);
        goto L16
    L10:
        Iterator<String> r108 = UriProtector.getQueryParameters(r100, r105).iterator();
    L12:
        if (r108.hasNext() == false) goto L7;
        r103.appendQueryParameter(r105, r108.next());
        goto L12
    L19:
        return r103.build();
    L26:
        return r100;
    }

    public static final String d(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$replaceParameter");
        return c(UriProtector.parse(r100), r101, r102).toString();
    L8:
        return r100;
    }
}
