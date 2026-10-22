package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements com.bytedance.android.ecom.arch.slice.slices.b<List<? extends com.bytedance.android.ecom.arch.slice.g>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f181781a;

    @Override // com.bytedance.android.ecom.arch.slice.slices.b
    public final List<? extends com.bytedance.android.ecom.arch.slice.g> provide() {
        ProductDetailInfoAdapter r100 = this.f181781a.f181713a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L6:
        return r100.E2();
    }

    public j(d r100) {
        this.f181781a = r100;
    }
}
