package com.stepos.policy.sdk.util;

import android.content.Context;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static void a(Context context, int i4, String str, LinkedHashMap linkedHashMap, String str2) {
        String string = context.getString(i4);
        Intrinsics.checkNotNullExpressionValue(string, str);
        linkedHashMap.put(str2, string);
    }
}
