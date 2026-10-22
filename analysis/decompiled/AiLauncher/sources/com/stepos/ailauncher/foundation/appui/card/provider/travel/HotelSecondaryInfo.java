package com.stepos.ailauncher.foundation.appui.card.provider.travel;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001d\u0010\u000fR\u001f\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b!\u0010\u000f¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/k;", "", "", "rating", "ratingDesc", "", "reviewCount", "favoritesCount", Const.JSON_KEY_ADDRESS, "", "tags", "distanceText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "getRatingDesc", "Ljava/lang/Integer;", "getReviewCount", "()Ljava/lang/Integer;", "getFavoritesCount", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "getTags", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.travel.k, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class HotelSecondaryInfo {
    private final String address;
    private final String distanceText;
    private final Integer favoritesCount;
    private final String rating;
    private final String ratingDesc;
    private final Integer reviewCount;
    private final List<String> tags;

    public HotelSecondaryInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: b, reason: from getter */
    public final String getDistanceText() {
        return this.distanceText;
    }

    /* renamed from: c, reason: from getter */
    public final String getRating() {
        return this.rating;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HotelSecondaryInfo)) {
            return false;
        }
        HotelSecondaryInfo hotelSecondaryInfo = (HotelSecondaryInfo) other;
        return kotlin.jvm.internal.p.d(this.rating, hotelSecondaryInfo.rating) && kotlin.jvm.internal.p.d(this.ratingDesc, hotelSecondaryInfo.ratingDesc) && kotlin.jvm.internal.p.d(this.reviewCount, hotelSecondaryInfo.reviewCount) && kotlin.jvm.internal.p.d(this.favoritesCount, hotelSecondaryInfo.favoritesCount) && kotlin.jvm.internal.p.d(this.address, hotelSecondaryInfo.address) && kotlin.jvm.internal.p.d(this.tags, hotelSecondaryInfo.tags) && kotlin.jvm.internal.p.d(this.distanceText, hotelSecondaryInfo.distanceText);
    }

    public int hashCode() {
        String str = this.rating;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.ratingDesc;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.reviewCount;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.favoritesCount;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.address;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<String> list = this.tags;
        int iHashCode6 = (iHashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.distanceText;
        return iHashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "HotelSecondaryInfo(rating=" + this.rating + ", ratingDesc=" + this.ratingDesc + ", reviewCount=" + this.reviewCount + ", favoritesCount=" + this.favoritesCount + ", address=" + this.address + ", tags=" + this.tags + ", distanceText=" + this.distanceText + ")";
    }

    public HotelSecondaryInfo(String str, String str2, Integer num, Integer num2, String str3, List<String> list, String str4) {
        this.rating = str;
        this.ratingDesc = str2;
        this.reviewCount = num;
        this.favoritesCount = num2;
        this.address = str3;
        this.tags = list;
        this.distanceText = str4;
    }

    public /* synthetic */ HotelSecondaryInfo(String str, String str2, Integer num, Integer num2, String str3, List list, String str4, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : num2, (i10 & 16) != 0 ? null : str3, (i10 & 32) != 0 ? null : list, (i10 & 64) != 0 ? null : str4);
    }
}
