package com.bytedance.android.gamecp.common.utils;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e1 {
    public static final String a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toJson");
        return GsonProtectorUtils.toJson(new Gson(), r100);
    }
}
