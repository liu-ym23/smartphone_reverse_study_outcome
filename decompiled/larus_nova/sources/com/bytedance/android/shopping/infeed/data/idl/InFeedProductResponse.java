package com.bytedance.android.shopping.infeed.data.idl;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import he3.a1;
import he3.u;
import he3.z0;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProduct;", "cards", "Ljava/util/List;", "getCards", "()Ljava/util/List;", "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductV2;", "cardsV2", "getCardsV2", "Lhe3/u;", "bffData", "Lhe3/u;", "getBffData", "()Lhe3/u;", "Lhe3/a1;", "page", "Lhe3/a1;", "getPage", "()Lhe3/a1;", "Lhe3/z0;", "extra", "Lhe3/z0;", "getExtra", "()Lhe3/z0;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFeedProductResponse extends CommerceBaseResponse {

    @SerializedName("bff_data")
    private final u bffData;

    @SerializedName("feed")
    private final List<InFeedProduct> cards;

    @SerializedName("cards")
    private final List<InFeedProductV2> cardsV2;

    @SerializedName("extra")
    private final z0 extra;

    @SerializedName("page")
    private final a1 page;

    public InFeedProductResponse() {
    }

    public final u getBffData() {
        return this.bffData;
    }

    public final List<InFeedProduct> getCards() {
        return this.cards;
    }

    public final List<InFeedProductV2> getCardsV2() {
        return this.cardsV2;
    }

    public final z0 getExtra() {
        return this.extra;
    }

    public final a1 getPage() {
        return this.page;
    }
}
