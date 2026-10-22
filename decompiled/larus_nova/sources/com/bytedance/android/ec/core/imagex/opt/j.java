package com.bytedance.android.ec.core.imagex.opt;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j extends SettableProducerContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CloseableStaticBitmap f44864a;

    public j(CloseableStaticBitmap r110, ImageRequest r111, String r112, RequestListener r113, Object r114) {
        Intrinsics.checkNotNullParameter(r110, "image");
        super(r111, r112, r113, r114, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE, false, false, Priority.IMMEDIATE);
        this.f44864a = r110;
    }
}
