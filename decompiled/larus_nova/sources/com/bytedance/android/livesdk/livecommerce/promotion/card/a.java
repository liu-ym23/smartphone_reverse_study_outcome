package com.bytedance.android.livesdk.livecommerce.promotion.card;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f150034a = null;

    public a() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.d
    public final Pair<String[], Long> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "promotionId");
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.d
    public final void b(String r100, String[] r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "promotionId");
        Intrinsics.checkNotNullParameter(r101, "selectedSkuIdList");
    }

    static {
        f150034a = new a();
    }
}
