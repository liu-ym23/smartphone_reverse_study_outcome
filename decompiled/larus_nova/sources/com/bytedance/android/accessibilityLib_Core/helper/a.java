package com.bytedance.android.accessibilityLib_Core.helper;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f38277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f38278b;

    static {
        f38278b = 1;
    }

    public static Context a() {
        Context r100 = f38277a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
    L5:
        return r100;
    }
}
