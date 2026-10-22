package com.bytedance.android.shopping.orderlist.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Gson f179970a;

    public static Gson a() {
        if (f179970a != null) goto L5;
        f179970a = new GsonBuilder().serializeNulls().create();
    L5:
        Gson r100 = f179970a;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    static {
    }
}
