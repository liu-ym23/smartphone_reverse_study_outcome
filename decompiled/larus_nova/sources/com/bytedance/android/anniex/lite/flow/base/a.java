package com.bytedance.android.anniex.lite.flow.base;

import android.util.LruCache;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import w26.g;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40919a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, b> f40920b = null;

    public a() {
    }

    static {
        f40919a = new a();
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        g r101 = (g) x26.a.a(g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Integer r103 = r102.d();
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L10:
        f40920b = new LruCache(r104);
        return;
    L9:
        r104 = 5;
        goto L10
    }

    public final synchronized b a(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "sessionId");     // Catch: Throwable -> L6
        b r101 = f40920b.get(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }
}
