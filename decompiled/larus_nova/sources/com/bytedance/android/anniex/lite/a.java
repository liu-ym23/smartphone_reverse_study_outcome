package com.bytedance.android.anniex.lite;

import android.util.LruCache;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40792a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, com.bytedance.android.anniex.base.lifecycle.a> f40793b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LruCache<String, Map<String, Object>> f40794c = null;

    public a() {
    }

    static {
        f40792a = new a();
        f40793b = new LruCache(2);
        f40794c = new LruCache(2);
    }

    public final synchronized void a(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "sessionId");     // Catch: Throwable -> L6
        f40793b.remove(r100);     // Catch: Throwable -> L6
        f40794c.remove(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
