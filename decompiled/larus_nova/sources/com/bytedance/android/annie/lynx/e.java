package com.bytedance.android.annie.lynx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d8.b f39484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f39485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f39486c;

    static {
        f39486c = "";
    }

    public static d8.b a() {
        d8.b r100 = f39484a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("lynxConfig");
        return null;
    }
}
