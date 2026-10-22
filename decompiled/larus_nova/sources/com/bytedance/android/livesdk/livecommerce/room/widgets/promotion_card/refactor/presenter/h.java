package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import com.bytedance.android.ec.core.widget.price.PriceView;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h extends InfoItemAnim<Long> {
    public h(Query r100, Query r101) {
        super(r100, r101, 0.8f);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.InfoItemAnim
    public final void a(Long r100, Query r101) {
        Long r102 = r100;
        Intrinsics.checkNotNullParameter(r101, "query");
        if (r102 == null) goto L6;
        final long r103 = r102.longValue();
        ((PriceView) r101.f()).C(new AuctionCardPresenter$updateBidInfo$1$onBindView$1$1(r103));
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.InfoItemAnim
    public final boolean b(Long r100, Long r101) {
        return !Intrinsics.areEqual(r100, r101);
    }
}
