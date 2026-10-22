package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECTopSearchInfo;", "Ljava/io/Serializable;", "()V", "carouselWords", "", "Lcom/bytedance/android/shopping/store/repository/vo/SearchSuggestWord;", "getCarouselWords", "()Ljava/util/List;", BitableAnalytic.LocationClickType.WORDS, "getWords", "setWords", "(Ljava/util/List;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTopSearchInfo implements Serializable {

    @SerializedName("carousel_words")
    private final List<SearchSuggestWord> carouselWords;

    @SerializedName(BitableAnalytic.LocationClickType.WORDS)
    private List<SearchSuggestWord> words;

    public ECTopSearchInfo() {
    }

    public final List<SearchSuggestWord> getCarouselWords() {
        return this.carouselWords;
    }

    public final List<SearchSuggestWord> getWords() {
        return this.words;
    }

    public final void setWords(List<SearchSuggestWord> r100) {
        this.words = r100;
    }
}
