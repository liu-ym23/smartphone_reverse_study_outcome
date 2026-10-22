package com.bytedance.android.ec.core.imagex;

import android.net.Uri;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class p implements com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a {
    public p() {
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a
    public final ImageRequest b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return null;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a
    public final void c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
    }

    public abstract boolean d(Uri r100, SlcImageFetchManager r101, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r102, Object r103, SlcImageFetchManager.a r104, Function1 r105);

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a
    public final boolean a(Uri r100, SlcImageFetchManager r110, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r111, Object r112, SlcImageFetchManager.a r113) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r110, "imageManager");
        Intrinsics.checkNotNullParameter(r111, "imageFetchCancelTag");
        Intrinsics.checkNotNullParameter(r113, "callback");
        return d(r100, r110, r111, r112, r113, null);
    }
}
