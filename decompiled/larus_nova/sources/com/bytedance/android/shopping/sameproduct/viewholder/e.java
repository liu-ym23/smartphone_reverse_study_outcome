package com.bytedance.android.shopping.sameproduct.viewholder;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e extends com.bytedance.android.ec.core.widget.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ SingleSimilarProductCardVH f182441g;

    public e(SingleSimilarProductCardVH r100) {
        this.f182441g = r100;
        super(null, "bind_product_flow_card", 1);
    }

    @Override // com.bytedance.android.ec.core.widget.d
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        SingleSimilarProductCardVH r101 = this.f182441g;
        r101.f182429o.invoke(Integer.valueOf(r101.getAdapterPosition() - 1), r100);
    }
}
