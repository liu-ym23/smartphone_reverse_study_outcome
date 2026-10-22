package com.bytedance.android.shopping.extensions;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class i {
    public static String a(Long r100) {
        Intrinsics.checkNotNullParameter("", "default");
        if (r100 == null) goto L25;
        r100.longValue();
        if (r100.longValue() <= 0) goto L27;
        String r101 = String.valueOf(r100.longValue() / ((double) 100));
        if (StringsKt.contains$default(r101, '.', false, 2, null) == false) goto L28;
    L10:
        Character r102 = StringsKt.lastOrNull(r101);
        if (r102 == null) goto L16;
        if (r102.charValue() != '0') goto L16;
        r101 = StringsKt.removeRange(r101, r101.length() - 1, r101.length()).toString();
    L16:
        Character r103 = StringsKt.lastOrNull(r101);
        if (r103 != null) goto L20;
        return r101;
    L20:
        if (r103.charValue() == '.') goto L22;
        return r101;
    L22:
        return StringsKt.removeRange(r101, r101.length() - 1, r101.length()).toString();
    L28:
        return r101;
    L27:
        return "";
    L25:
        return "";
    }
}
