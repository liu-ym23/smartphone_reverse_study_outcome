package com.bytedance.android.ec.window.base.utils;

import androidx.collection.LruCache;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, Long> f49723a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f49724b = null;

    public d() {
    }

    static {
        f49724b = new d();
        f49723a = new LruCache(100);
    }
}
