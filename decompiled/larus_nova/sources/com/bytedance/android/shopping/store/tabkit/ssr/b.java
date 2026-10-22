package com.bytedance.android.shopping.store.tabkit.ssr;

import com.bytedance.android.shopping.store.tabkit.ssr.interfaces.SSRFetchCallbackDelegate;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f186847b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SSRFetchCallbackDelegate f186848a;

    public static final class a {
    }

    static {
    }

    public final void b(int r100, String r101, Integer r102) {
        throw null;
    }

    public final void c(String r100, Long r101) {
        throw null;
    }

    public static final void a(b r100, byte[] r101, boolean r102) {
        monitor-enter(r100);
        if (r102 == true) goto L5;
        if (r101 != null) goto L12;
    L10:
        monitor-exit(r100);
        return;
    L12:
        r100.getClass();     // Catch: Throwable -> L14
        throw null;     // Catch: Throwable -> L14
    L5:
        if (r101 != null) goto L7;
        r100.b(304, "empty template byte data", null);     // Catch: Throwable -> L14
        goto L10
    L7:
        r100.getClass();     // Catch: Throwable -> L14
        throw null;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }
}
