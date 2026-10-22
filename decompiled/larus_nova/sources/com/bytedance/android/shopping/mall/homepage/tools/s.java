package com.bytedance.android.shopping.mall.homepage.tools;

import android.util.LruCache;

/* JADX INFO: loaded from: classes13.dex */
public final class s<K> extends LruCache<K, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f178541a = null;

    static {
        f178541a = new Object();
    }

    public s(int r100) {
        super(r100);
    }

    public final void a(K r100) {
        put(r100, f178541a);
    }
}
