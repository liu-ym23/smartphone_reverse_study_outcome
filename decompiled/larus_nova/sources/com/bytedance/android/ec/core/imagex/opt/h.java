package com.bytedance.android.ec.core.imagex.opt;

import android.util.SparseArray;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h extends SettableProducerContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<CacheKey> f44857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageRequest[] f44858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<CacheKey, CloseableStaticBitmap> f44859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f44860d;

    public h(ImageRequest[] r110, String r111, f r112, Object r113, Function1 r114, Function0 r115) {
        Intrinsics.checkNotNullParameter(r114, "getReuseImage");
        Intrinsics.checkNotNullParameter(r115, "onBuildImageRequest");
        if (r110 == null) goto L5;
        ImageRequest r100 = (ImageRequest) ArraysKt.firstOrNull(r110);
    L6:
        super(r100, r111, r112, r113, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE, false, false, Priority.IMMEDIATE);
        this.f44858b = r110;
        this.f44859c = r114;
        this.f44860d = r115;
        if (r110 == null) goto L9;
        int r101 = r110.length;
    L10:
        this.f44857a = new SparseArray(r101);
        return;
    L9:
        r101 = 3;
        goto L10
    L5:
        r100 = null;
        goto L6
    }
}
