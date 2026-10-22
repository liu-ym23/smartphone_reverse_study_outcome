package com.bytedance.android.ec.core.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class x0 {
    public static final JSONObject a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$copy");
        JSONObject r101 = new JSONObject();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, r100.get(r103));
        goto L4
    L6:
        return r101;
    }

    public static final JSONObject c(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toJSONObject");
        JSONObject r101 = new JSONObject();
        Iterator<T> r102 = UriProtector.getQueryParameterNames(r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = (String) r102.next();
        r101.put(r103, UriProtector.getQueryParameter(r100, r103));
        goto L4
    L6:
        return r101;
    }

    public static final void b(JSONObject r100, JSONObject r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$mergeJson");
        if (r101 == null) goto L19;
        Iterator<String> r103 = r101.keys();
    L6:
        if (r103.hasNext() == false) goto L27;
        String r104 = r103.next();
        if (r100.has(r104) == false) goto L18;
        String r105 = JSONObjectProtectorUtils.getString(r100, r104);
        if (r105 != null) goto L12;
    L15:
        boolean r106 = true;
    L16:
        if (r106 == true) goto L18;
        if (r102 == false) goto L6;
    L12:
        if (StringsKt.isBlank(r105) == true) goto L15;
        r106 = false;
    L18:
        r100.putOpt(r104, r101.get(r104));
        goto L6
    L27:
        return;
    }
}
