package com.bytedance.android.ec.core.utils;

import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a2 {
    public static final boolean b(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length() <= 0) goto L6;
        return true;
    }

    public static final String c(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return null;
    L11:
        return r100;
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    public static final String d(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        return r100;
    }

    public static final boolean a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "s2");
        if (StringUtils.isEmpty(r100) == true) goto L5;
    L6:
        if (r100 != null) goto L8;
    L10:
        return false;
    L8:
        if (Intrinsics.areEqual(r100, r101) == false) goto L10;
    L9:
        return true;
    L5:
        if (StringUtils.isEmpty(r101) == true) goto L9;
        goto L6
    }
}
