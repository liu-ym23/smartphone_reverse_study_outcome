package com.bytedance.android.live.schema.helper;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class h {
    static {
    }

    @JvmStatic
    public static final Map<String, String> a(Uri r100) {
        HashMap r101 = new HashMap();
        if (r100 == null) goto L20;
        String r102 = r100.getEncodedQuery();
        if (r102 == null) goto L20;
        Iterator r103 = StringsKt.split$default(r102, new String[]{"&"}, false, 0, 6, null).iterator();
    L8:
        if (r103.hasNext() == false) goto L20;
        List r104 = StringsKt.split$default((String) r103.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, null);
        StringBuilder r105 = new StringBuilder();
        if (r104.size() <= 1) goto L16;
        String r106 = (String) ListProtector.get(r104, 0);
        r105.append((String) ListProtector.get(r104, 1));
        int r107 = 2;
        if (r104.size() <= 2) goto L18;
        int r108 = r104.size();
    L14:
        if (r107 >= r108) goto L18;
        r105.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r105.append((String) ListProtector.get(r104, r107));
        r107 = r107 + 1;
    L18:
        if (TextUtils.isEmpty(r106) == true) goto L8;
        r101.put(r106, Uri.decode(r105.toString()));
        goto L8
    L16:
        r106 = "";
    L20:
        return r101;
    }

    @JvmStatic
    public static final Uri b(Uri r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        String r103 = UriProtector.getQueryParameter(r100, r101);
        if (r103 != null) goto L6;
        return r100.buildUpon().appendQueryParameter(r101, r102).build();
    L6:
        if (Intrinsics.areEqual(r103, r102) == true) goto L24;
        Set<String> r104 = UriProtector.getQueryParameterNames(r100);
        Uri.Builder r105 = r100.buildUpon().clearQuery();
        Iterator<T> r106 = r104.iterator();
    L10:
        if (r106.hasNext() == false) goto L16;
        String r107 = (String) r106.next();
        if (Intrinsics.areEqual(r107, r101) == true) goto L13;
        r105.appendQueryParameter(r107, UriProtector.getQueryParameter(r100, r107));
        goto L10
    L13:
        r105.appendQueryParameter(r107, r102);
        goto L10
    L16:
        return r105.build();
    L24:
        return r100;
    }
}
