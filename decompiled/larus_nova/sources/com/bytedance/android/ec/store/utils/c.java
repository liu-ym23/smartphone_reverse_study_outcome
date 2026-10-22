package com.bytedance.android.ec.store.utils;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<List<String>> f48664a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<String> f48665b;

    static {
        f48664a = new ArrayList();
        f48665b = new ArrayList();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        if (f48665b.size() >= 50) goto L6;
        f48665b.add(r100);
        return;
    }
}
