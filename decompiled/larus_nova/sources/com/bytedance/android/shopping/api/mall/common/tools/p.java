package com.bytedance.android.shopping.api.mall.common.tools;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Gson f170457a;

    public static Gson b() {
        if (f170457a != null) goto L5;
        f170457a = new GsonBuilder().create();
    L5:
        Gson r100 = f170457a;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    static {
    }

    public static String c(Object r100) {
        return GsonProtectorUtils.toJson(b(), r100);
    }

    public static Object a(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r101, "objectClass");
        return GsonProtectorUtils.fromJson(b(), r100, r101);
    }
}
