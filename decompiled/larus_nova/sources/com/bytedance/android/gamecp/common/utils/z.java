package com.bytedance.android.gamecp.common.utils;

import android.util.LruCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, String> f57329a = null;

    public z() {
    }

    static {
        f57329a = new LruCache(20);
    }

    public static void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "sourceFrom");
        StringBuilder r103 = new StringBuilder("setCurGameIdPkgCache() gameId: ");
        r103.append(r100);
        r103.append(", pkgName: ");
        r103.append(r101);
        r103.append(" sourceFrom ");
        r103.append(r102);
        r103.append(" cacheSize: ");
        LruCache<String, String> r104 = f57329a;
        r103.append(r104.size());
        yr.c.a("IncrementPkgUtils", r103.toString());
        if (UtilsKt.c(r100) == true) goto L5;
        return;
    L5:
        if (UtilsKt.c(r101) == false) goto L9;
        r104.put(r100, r101);
        return;
    }
}
