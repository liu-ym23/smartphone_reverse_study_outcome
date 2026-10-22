package com.bytedance.android.livesdk.utils;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f159156a = null;

    static {
        f159156a = new HashMap();
    }

    @JvmStatic
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter("", "defaultValue");
        HashMap r101 = (HashMap) f159156a;
        if (r101.containsKey(r100) == true) goto L5;
        return "";
    L5:
        return (String) r101.get(r100);
    }
}
