package com.bytedance.android.shopping.store.restore;

import android.util.LruCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<n, m> f185789a;

    public e() {
        this.f185789a = new LruCache(1);
    }

    @Override // com.bytedance.android.shopping.store.restore.d
    public final void b(m r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        LruCache<n, m> r101 = this.f185789a;
        monitor-enter(r101);
        m r102 = this.f185789a.put(r100.f185817a, r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.shopping.store.restore.d
    public final m a(n r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        LruCache<n, m> r102 = this.f185789a;
        monitor-enter(r102);
        m r103 = this.f185789a.remove(r100);     // Catch: Throwable -> L16
        monitor-exit(r102);
        if (r103 != null) goto L9;
        return null;
    L9:
        long r104 = r103.f185819c;
        if (r104 > 0) goto L13;
        return r103;
    L13:
        if ((r101 - r103.f185818b) > r104) goto L15;
        return r103;
    L15:
        return null;
    L16:
        th = move-exception;
        throw th;
    }
}
