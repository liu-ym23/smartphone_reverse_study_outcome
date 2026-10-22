package com.bytedance.android.ec.window.base.utils;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<List<String>> f49727a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<String> f49728b;

    static {
        f49727a = new ArrayList();
        f49728b = new ArrayList();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        if (f49728b.size() >= 50) goto L6;
        f49728b.add(r100);
        return;
    }
}
