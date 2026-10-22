package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECPromotionInterationData f151008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f151009b;

    public final String toString() {
        return "[data=" + this.f151008a + ", rotationCount=" + this.f151009b + ']';
    }

    public a(ECPromotionInterationData r100) {
        Intrinsics.checkNotNullParameter(r100, "interactionData");
        this.f151008a = r100;
        this.f151009b = 0;
    }
}
