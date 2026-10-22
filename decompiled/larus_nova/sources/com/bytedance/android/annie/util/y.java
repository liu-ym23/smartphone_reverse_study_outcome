package com.bytedance.android.annie.util;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class y {
    static {
    }

    public static Map a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Uri r101 = UriProtector.parse(r100);
        LinkedHashMap r102 = new LinkedHashMap();
        if (r101.isHierarchical() == false) goto L16;
        Iterator<T> r103 = UriProtector.getQueryParameterNames(r101).iterator();
    L6:
        if (r103.hasNext() == false) goto L16;
        String r104 = (String) r103.next();
        if (r104.length() <= 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L6;
        String r106 = UriProtector.getQueryParameter(r101, r104);
        if (r106 != null) goto L15;
        r106 = "";
    L15:
        r102.put(r104, r106);
        goto L6
    L10:
        r105 = false;
    L16:
        return r102;
    }

    @JvmStatic
    public static final Uri b(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter("url", "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        String r102 = UriProtector.getQueryParameter(r100, "url");
        if (r102 != null) goto L6;
        return r100.buildUpon().appendQueryParameter("url", r101).build();
    L6:
        if (Intrinsics.areEqual(r102, r101) == true) goto L24;
        Set<String> r103 = UriProtector.getQueryParameterNames(r100);
        Uri.Builder r104 = r100.buildUpon().clearQuery();
        Iterator<T> r105 = r103.iterator();
    L10:
        if (r105.hasNext() == false) goto L16;
        String r106 = (String) r105.next();
        if (Intrinsics.areEqual(r106, "url") == true) goto L13;
        r104.appendQueryParameter(r106, UriProtector.getQueryParameter(r100, r106));
        goto L10
    L13:
        r104.appendQueryParameter(r106, r101);
        goto L10
    L16:
        return r104.build();
    L24:
        return r100;
    }
}
