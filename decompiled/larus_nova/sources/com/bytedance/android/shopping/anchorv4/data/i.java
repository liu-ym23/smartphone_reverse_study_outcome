package com.bytedance.android.shopping.anchorv4.data;

import com.bytedance.android.shopping.anchorv3.guessulike.model.GuessULikeResponseDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionProductDetailResponse;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionRecommendResponse;
import com.bytedance.android.shopping.anchorv3.repository.dto.SearchSuggestWordResponse;
import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;

/* JADX INFO: loaded from: classes12.dex */
public interface i {
    void onGetDetail(PromotionProductDetailResponse r100);

    void onGetExtraChunkPack(PackResponseDTO r100);

    void onGetFindSameGoods(com.bytedance.android.shopping.anchorv4.dto.business.d r100);

    void onGetGUL(GuessULikeResponseDTO r100);

    void onGetGULError();

    void onGetPack(PackResponseDTO r100, boolean r101);

    void onGetPackClientError();

    void onGetSearchWords(SearchSuggestWordResponse r100);

    void onGetShopRecommends(PromotionRecommendResponse r100);
}
