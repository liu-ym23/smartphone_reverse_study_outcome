package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import com.bytedance.android.livesdk.livecommerce.model.ProductInfo;
import kotlin.jvm.internal.Intrinsics;
import si2.e0;

/* JADX INFO: loaded from: classes10.dex */
public final class RelatedCardMessageController implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.room.utils.g f152556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f152557b;

    public RelatedCardMessageController(b r100) {
        Intrinsics.checkNotNullParameter(r100, "relatedController");
        this.f152557b = r100;
        this.f152556a = new com.bytedance.android.livesdk.livecommerce.room.utils.g();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.c
    public final void a(final e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        int r101 = r100.actionType;
        if (r101 != 1) goto L5;
        this.f152556a.c(String.valueOf(r100.promotionId), 0, true, new RelatedCardMessageController$refreshPromotion$1(this, r100));
        return;
    L5:
        if (r101 != 2) goto L14;
        ProductInfo r102 = r100.productInfo;
        if (r102 == null) goto L12;
        this.f152557b.c(String.valueOf(r100.promotionId), r102);
        return;
    L12:
        return;
    }
}
