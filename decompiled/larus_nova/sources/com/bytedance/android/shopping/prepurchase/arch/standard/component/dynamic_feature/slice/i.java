package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements com.bytedance.android.ecom.arch.slice.adapter.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f180964a;

    @Override // com.bytedance.android.ecom.arch.slice.adapter.c
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    public i(com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.f r100) {
        this.f180964a = r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.adapter.c
    public final void a(RecyclerView.ViewHolder r100, com.bytedance.android.ecom.arch.slice.adapter.b r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f180964a.a(r100, r101);
    }
}
