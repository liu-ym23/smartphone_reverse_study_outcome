package com.bytedance.android.shopping.store.slicecard;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ImageRequest[]> f186329a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f186330b = null;

    public c() {
    }

    static {
        f186330b = new c();
        f186329a = new ConcurrentHashMap();
    }

    public final void update(String r100, ImageRequest[] r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        f186329a.put(r100, r101);
    }
}
