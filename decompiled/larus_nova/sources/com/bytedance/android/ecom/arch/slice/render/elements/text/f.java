package com.bytedance.android.ecom.arch.slice.render.elements.text;

import android.text.Layout;
import android.util.LruCache;
import java.util.HashMap;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, f> f50535c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f50536d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f50537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LruCache<g, Layout> f50538b;

    public static final class a {
        public a() {
        }
    }

    static {
        f50536d = new a();
        f50535c = new HashMap();
    }

    public f() {
        this.f50537a = 50;
        this.f50538b = new LruCache(this.f50537a);
    }
}
