package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import android.net.Uri;
import com.bytedance.android.ec.core.anchorv3.PdpMessageOpt;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.jvm.internal.Intrinsics;
import vg3.y;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f180953a;

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a
    public final ImageRequest b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return null;
    }

    public a(b r100) {
        this.f180953a = r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a
    public final void c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.k r101 = (com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.k) this.f180953a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "controller");
        if (PdpMessageOpt.b() == false) goto L8;
        y r102 = (y) r101.f182190c.getService(y.class);
        if (r102 == null) goto L9;
        r102.z1(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a
    public final boolean a(Uri r100, SlcImageFetchManager r101, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r110, Object r111, SlcImageFetchManager.a r112) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "imageManager");
        Intrinsics.checkNotNullParameter(r110, "imageFetchCancelTag");
        Intrinsics.checkNotNullParameter(r112, "callback");
        return com.bytedance.android.ec.core.imagex.m.f44689a.a(r100, r101, r110, r111, r112);
    }
}
