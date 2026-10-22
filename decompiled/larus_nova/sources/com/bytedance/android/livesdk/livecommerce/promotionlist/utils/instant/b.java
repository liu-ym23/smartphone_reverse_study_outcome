package com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant;

import android.util.LruCache;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<String, Map<String, Long>> f151257a;

    public static final class a {
    }

    static {
    }

    public b() {
        this.f151257a = new LruCache(10);
    }

    public final Long a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter("operation_start_time", "event");
        Map<String, Long> r101 = this.f151257a.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get("operation_start_time");
    }
}
