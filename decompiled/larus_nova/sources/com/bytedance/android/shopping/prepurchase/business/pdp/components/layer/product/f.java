package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.slices.SlcBaseViewHolder;
import com.bytedance.android.shopping.prepurchase.arch.exposure.ExposureEngine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f181730a;

    public f(d r100) {
        this.f181730a = r100;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.h
    public final void a(RecyclerView.ViewHolder r100, com.bytedance.android.ecom.arch.slice.adapter.b r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r101 instanceof com.bytedance.android.ecom.arch.slice.g) == true) goto L5;
        return;
    L5:
        if ((r100 instanceof SlcBaseViewHolder) == false) goto L21;
        d r102 = this.f181730a;
        SlcBaseViewHolder r103 = (SlcBaseViewHolder) r100;
        r102.getClass();
        String r104 = ((com.bytedance.android.ecom.arch.slice.g) r101).getSliceId();
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        if (r104.length() != 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L22;
        vg3.m r106 = (vg3.m) r102.f181727o.getService(vg3.m.class);
        if (r106 == null) goto L23;
        ExposureEngine r107 = r106.x0();
        if (r107 == null) goto L24;
        ExposureEngine.a(r107, r103.itemView, r104);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L12:
        r105 = false;
        goto L13
    }
}
