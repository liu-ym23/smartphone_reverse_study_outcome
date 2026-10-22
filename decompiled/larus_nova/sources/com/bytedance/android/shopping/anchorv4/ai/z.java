package com.bytedance.android.shopping.anchorv4.ai;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;

/* JADX INFO: loaded from: classes12.dex */
public final class z implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f165702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0 f165703b;

    public z(a0 r100) {
        this.f165702a = "ecom.pdp.add_cart";
        this.f165703b = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.f
    public final void dispose() {
        ECLiveHybridUtil.p(this.f165702a, this.f165703b);
    }
}
