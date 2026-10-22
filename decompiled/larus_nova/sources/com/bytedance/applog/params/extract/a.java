package com.bytedance.applog.params.extract;

import android.util.LruCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends LruCache<String, ParamsExtractDao.a> {
    public a() {
        super(128);
    }

    @Override // android.util.LruCache
    public final int sizeOf(String r100, ParamsExtractDao.a r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        return 1;
    }
}
