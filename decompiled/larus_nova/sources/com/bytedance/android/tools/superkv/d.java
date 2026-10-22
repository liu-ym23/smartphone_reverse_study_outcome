package com.bytedance.android.tools.superkv;

import android.util.LruCache;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements e, f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f187616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f187617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LruCache<String, Object> f187618c;

    public class a implements f {
        @Override // com.bytedance.android.tools.superkv.f
        public final void a() {
        }

        @Override // com.bytedance.android.tools.superkv.f
        public final int b(List r100) {
            return 1;
        }

        @Override // com.bytedance.android.tools.superkv.f
        public final int c(String r100, String r101) {
            return 1;
        }

        @Override // com.bytedance.android.tools.superkv.f
        public final bm3.b get(String r100) {
            return null;
        }

        @Override // com.bytedance.android.tools.superkv.f
        public final void release() {
        }

        @Override // com.bytedance.android.tools.superkv.f
        public final void remove(String r100) {
        }

        public a() {
        }
    }

    @Override // com.bytedance.android.tools.superkv.e
    public final List b() {
        if (this.f187616a == false) goto L5;
        this.f187617b.a();
    L5:
        Object r100 = this.f187618c.get("__prefetch_cache_key_array");
        if (r100 != null) goto L8;
        bm3.b r101 = c("__prefetch_cache_key_array", 10);
        if (r101 != null) goto L14;
        return null;
    L14:
        return r101.f19584k;
    L8:
        return (List) r100;
    }

    public d() {
        this.f187616a = false;
        this.f187618c = new LruCache(Integer.MAX_VALUE);
        this.f187617b = new a();
    }

    @Override // com.bytedance.android.tools.superkv.e
    public final void a(Collection r100) {
        this.f187617b.b(new ArrayList(r100));
        this.f187618c.put("__prefetch_cache_key_array", r100);
    }

    @Override // com.bytedance.android.tools.superkv.e
    public final String getString(String r100) {
        if (this.f187616a == false) goto L5;
        this.f187617b.a();
    L5:
        Object r101 = this.f187618c.get(r100);
        if (r101 != null) goto L8;
        bm3.b r102 = c(r100, 8);
        if (r102 != null) goto L14;
        return null;
    L14:
        return r102.f19582i;
    L8:
        return (String) r101;
    }

    @Override // com.bytedance.android.tools.superkv.e
    public final void remove(String r100) {
        this.f187617b.remove(r100);
        this.f187618c.remove(r100);
    }

    public d(String r100, int r101) throws IOException {
        this.f187616a = false;
        this.f187618c = new LruCache(r101);
        this.f187617b = new g(r100, this);
    }

    public final bm3.b c(String r100, int r101) {
        bm3.b r102 = this.f187617b.get(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        if (r102.f19576c != r101) goto L10;
        return r102;
    L10:
        throw new IllegalStateException("Wrong type with key: " + r100 + ", expected: " + bm3.b.b(Integer.valueOf(r101)) + ", found: " + bm3.b.b(Integer.valueOf(r102.f19576c)));
    }

    @Override // com.bytedance.android.tools.superkv.e
    public final void putString(String r100, String r101) {
        this.f187617b.c(r100, r101);
        this.f187618c.put(r100, r101);
    }
}
