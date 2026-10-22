package com.stepos.ailauncher.network.model;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/network/model/RecommendCards;", "", "cards", "", "Lcom/stepos/ailauncher/network/model/RecommendCard;", "<init>", "(Ljava/util/List;)V", "getCards", "()Ljava/util/List;", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RecommendCards {

    @SerializedName("cards")
    private final List<RecommendCard> cards;

    /* JADX WARN: Multi-variable type inference failed */
    public RecommendCards() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecommendCards copy$default(RecommendCards recommendCards, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = recommendCards.cards;
        }
        return recommendCards.copy(list);
    }

    public final List<RecommendCard> component1() {
        return this.cards;
    }

    public final RecommendCards copy(List<RecommendCard> cards) {
        return new RecommendCards(cards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RecommendCards) && p.d(this.cards, ((RecommendCards) other).cards);
    }

    public final List<RecommendCard> getCards() {
        return this.cards;
    }

    public int hashCode() {
        List<RecommendCard> list = this.cards;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "RecommendCards(cards=" + this.cards + ")";
    }

    public RecommendCards(List<RecommendCard> list) {
        this.cards = list;
    }

    public /* synthetic */ RecommendCards(List list, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : list);
    }
}
