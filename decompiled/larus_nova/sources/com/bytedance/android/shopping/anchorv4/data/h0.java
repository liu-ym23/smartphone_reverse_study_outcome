package com.bytedance.android.shopping.anchorv4.data;

import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionRecommendResponse;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes12.dex */
public final class h0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4Repository f166442a;

    public h0(AnchorV4Repository r100) {
        this.f166442a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        PromotionRecommendResponse r101 = (PromotionRecommendResponse) r100;
        Iterator<T> r102 = this.f166442a.g().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((i) r102.next()).onGetShopRecommends(r101);
        goto L4
    }
}
