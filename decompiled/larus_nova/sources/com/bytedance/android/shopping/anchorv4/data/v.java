package com.bytedance.android.shopping.anchorv4.data;

import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionProductDetailResponse;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes12.dex */
public final class v<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4Repository f166484a;

    public v(AnchorV4Repository r100) {
        this.f166484a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        PromotionProductDetailResponse r101 = (PromotionProductDetailResponse) r100;
        Iterator<T> r102 = this.f166484a.g().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((i) r102.next()).onGetDetail(r101);
        goto L4
    }
}
