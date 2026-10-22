package com.bytedance.android.annie.scheme.helper;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class b {
    public static String a(Uri r100, String r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        return UriProtector.getQueryParameter(r100, r101);
    L8:
        th = move-exception;
        int r102 = x8.a.f562881a;
        x8.a.c("ParsingUriParamHelper", th, true);
        return null;
    L15:
        return null;
    }

    public static String b(Map<String, String> r100, String r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        return (String) ((HashMap) r100).get(r101);
    L8:
        th = move-exception;
        x8.a.c("ParsingUriParamHelper", th, true);
        return null;
    L15:
        return null;
    }
}
