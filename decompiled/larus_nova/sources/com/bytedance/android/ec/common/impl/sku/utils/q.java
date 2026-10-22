package com.bytedance.android.ec.common.impl.sku.utils;

import android.util.LruCache;

/* JADX INFO: loaded from: classes43.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f43371a = null;

    public static final class a extends LruCache<String, r> {
        public a() {
            super(10);
        }
    }

    static {
        f43371a = new a();
    }
}
