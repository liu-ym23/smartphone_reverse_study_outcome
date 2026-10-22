package com.bytedance.android.gamecp.common.utils;

import android.content.SharedPreferences;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f1 {
    public static final float a(SharedPreferences r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$get");
        Intrinsics.checkNotNullParameter(r101, "key");
        float r102 = 0.0f;
        Float r103 = Float.valueOf(0.0f);
        if (r103 == null) goto L6;
        r102 = r103.floatValue();
    L6:
        return r100.getFloat(r101, r102);
    }

    public static final int b(SharedPreferences r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$get");
        Intrinsics.checkNotNullParameter(r101, "key");
        int r102 = 0;
        Integer r103 = 0;
        if (r103 == null) goto L6;
        r102 = r103.intValue();
    L6:
        return r100.getInt(r101, r102);
    }

    public static final long c(SharedPreferences r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$get");
        Intrinsics.checkNotNullParameter(r101, "key");
        long r102 = 0;
        Long r103 = 0L;
        if (r103 == null) goto L6;
        r102 = r103.longValue();
    L6:
        return r100.getLong(r101, r102);
    }

    public static final String d(SharedPreferences r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$get");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter("", "defaultValue");
        String r102 = r100.getString(r101, "");
        if (r102 != null) goto L6;
        return "";
    L6:
        return r102;
    }

    public static final boolean f(SharedPreferences r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$get");
        Intrinsics.checkNotNullParameter(r101, "key");
        return r100.getBoolean(r101, false);
    }

    public static final Set<String> e(SharedPreferences r100, String r101, Set<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$get");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        return r100.getStringSet(r101, r102);
    }

    public static final void g(SharedPreferences r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$set");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        SharedPreferences.Editor r103 = r100.edit();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r103.putString(r101, r102);
        r103.apply();
    }
}
