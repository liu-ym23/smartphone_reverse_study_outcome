package com.bytedance.android.shopping.store.slicecard;

import android.net.Uri;
import com.bytedance.android.ec.core.imagex.m;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g implements com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a {
    public g() {
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a
    public final void c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a
    public final ImageRequest b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r100, "uri");
        ConcurrentHashMap<String, ImageRequest[]> r101 = c.f186329a;
        String r102 = r100.toString();
        Intrinsics.checkNotNullParameter(r102, "key");
        ImageRequest[] r103 = c.f186329a.get(r102);
        if (r103 != null) goto L7;
        return null;
    L7:
        return (ImageRequest) ArraysKt.firstOrNull(r103);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a
    public final boolean a(Uri r100, SlcImageFetchManager r110, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r111, Object r112, SlcImageFetchManager.a r113) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r110, "imageManager");
        Intrinsics.checkNotNullParameter(r111, "imageFetchCancelTag");
        Intrinsics.checkNotNullParameter(r113, "callback");
        return m.f44689a.d(r100, r110, r111, r112, r113, new ShopSlcImageLoaderHook$fetchImage$1(this));
    }
}
