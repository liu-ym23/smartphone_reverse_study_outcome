package com.bytedance.android.livesdk.end;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yu1.c;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b*\u0010+J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003JL\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/end/EndingPageGuideCardInfo;", "Lyu1/c;", "", "component1", "()Ljava/lang/Long;", "Lcom/bytedance/android/livesdk/end/EcomWindowRankGuideCardData;", "component2", "Lcom/bytedance/android/livesdk/end/EndingPageShopCardInfo;", "component3", "Lcom/bytedance/android/livesdk/end/SafeCardInfo;", "component4", "Lcom/bytedance/android/livesdk/end/VipLiveEndData;", "component5", "cardType", "windowRankData", "shopCardInfo", "safeCardInfo", "vipLiveEndData", "copy", "(Ljava/lang/Long;Lcom/bytedance/android/livesdk/end/EcomWindowRankGuideCardData;Lcom/bytedance/android/livesdk/end/EndingPageShopCardInfo;Lcom/bytedance/android/livesdk/end/SafeCardInfo;Lcom/bytedance/android/livesdk/end/VipLiveEndData;)Lcom/bytedance/android/livesdk/end/EndingPageGuideCardInfo;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/Long;", "getCardType", "Lcom/bytedance/android/livesdk/end/EcomWindowRankGuideCardData;", "getWindowRankData", "()Lcom/bytedance/android/livesdk/end/EcomWindowRankGuideCardData;", "Lcom/bytedance/android/livesdk/end/EndingPageShopCardInfo;", "getShopCardInfo", "()Lcom/bytedance/android/livesdk/end/EndingPageShopCardInfo;", "Lcom/bytedance/android/livesdk/end/SafeCardInfo;", "getSafeCardInfo", "()Lcom/bytedance/android/livesdk/end/SafeCardInfo;", "Lcom/bytedance/android/livesdk/end/VipLiveEndData;", "getVipLiveEndData", "()Lcom/bytedance/android/livesdk/end/VipLiveEndData;", "<init>", "(Ljava/lang/Long;Lcom/bytedance/android/livesdk/end/EcomWindowRankGuideCardData;Lcom/bytedance/android/livesdk/end/EndingPageShopCardInfo;Lcom/bytedance/android/livesdk/end/SafeCardInfo;Lcom/bytedance/android/livesdk/end/VipLiveEndData;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EndingPageGuideCardInfo extends c {

    @SerializedName(a.KEY_CARD_TYPE)
    private final Long cardType;

    @SerializedName("safe_card_info")
    private final SafeCardInfo safeCardInfo;

    @SerializedName("shop_card_info")
    private final EndingPageShopCardInfo shopCardInfo;

    @SerializedName("subscribe_card_info")
    private final VipLiveEndData vipLiveEndData;

    @SerializedName("ecom_window_rank_data")
    private final EcomWindowRankGuideCardData windowRankData;

    public EndingPageGuideCardInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ EndingPageGuideCardInfo copy$default(EndingPageGuideCardInfo r100, Long r101, EcomWindowRankGuideCardData r102, EndingPageShopCardInfo r103, SafeCardInfo r104, VipLiveEndData r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.cardType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.windowRankData;
    L8:
        EcomWindowRankGuideCardData r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.shopCardInfo;
    L11:
        EndingPageShopCardInfo r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.safeCardInfo;
    L14:
        SafeCardInfo r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.vipLiveEndData;
    L17:
        Long r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Long component1() {
        return this.cardType;
    }

    public final EcomWindowRankGuideCardData component2() {
        return this.windowRankData;
    }

    public final EndingPageShopCardInfo component3() {
        return this.shopCardInfo;
    }

    public final SafeCardInfo component4() {
        return this.safeCardInfo;
    }

    public final VipLiveEndData component5() {
        return this.vipLiveEndData;
    }

    public final EndingPageGuideCardInfo copy(Long r100, EcomWindowRankGuideCardData r101, EndingPageShopCardInfo r110, SafeCardInfo r111, VipLiveEndData r112) {
        return new EndingPageGuideCardInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EndingPageGuideCardInfo) == false) goto L16;
        EndingPageGuideCardInfo r101 = (EndingPageGuideCardInfo) r100;
        if (Intrinsics.areEqual(this.cardType, r101.cardType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.windowRankData, r101.windowRankData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shopCardInfo, r101.shopCardInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.safeCardInfo, r101.safeCardInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.vipLiveEndData, r101.vipLiveEndData) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        Long r100 = this.cardType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        EcomWindowRankGuideCardData r104 = this.windowRankData;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        EndingPageShopCardInfo r107 = this.shopCardInfo;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        SafeCardInfo r110 = this.safeCardInfo;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        VipLiveEndData r113 = this.vipLiveEndData;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "EndingPageGuideCardInfo(cardType=" + this.cardType + ", windowRankData=" + this.windowRankData + ", shopCardInfo=" + this.shopCardInfo + ", safeCardInfo=" + this.safeCardInfo + ", vipLiveEndData=" + this.vipLiveEndData + ")";
    }

    public final Long getCardType() {
        return this.cardType;
    }

    public final SafeCardInfo getSafeCardInfo() {
        return this.safeCardInfo;
    }

    public final EndingPageShopCardInfo getShopCardInfo() {
        return this.shopCardInfo;
    }

    public final VipLiveEndData getVipLiveEndData() {
        return this.vipLiveEndData;
    }

    public final EcomWindowRankGuideCardData getWindowRankData() {
        return this.windowRankData;
    }

    public EndingPageGuideCardInfo(Long r100, EcomWindowRankGuideCardData r101, EndingPageShopCardInfo r102, SafeCardInfo r103, VipLiveEndData r104) {
        this.cardType = r100;
        this.windowRankData = r101;
        this.shopCardInfo = r102;
        this.safeCardInfo = r103;
        this.vipLiveEndData = r104;
    }

    public /* synthetic */ EndingPageGuideCardInfo(Long r100, EcomWindowRankGuideCardData r101, EndingPageShopCardInfo r102, SafeCardInfo r103, VipLiveEndData r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = 0L;
    L5:
        VipLiveEndData r106 = null;
        if ((r105 & 2) == 0) goto L8;
        EcomWindowRankGuideCardData r111 = null;
    L10:
        if ((r105 & 4) == 0) goto L12;
        EndingPageShopCardInfo r107 = null;
    L14:
        if ((r105 & 8) == 0) goto L16;
        SafeCardInfo r108 = null;
    L18:
        if ((r105 & 16) != 0) goto L21;
        r106 = r104;
    L21:
        this(r100, r111, r107, r108, r106);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
