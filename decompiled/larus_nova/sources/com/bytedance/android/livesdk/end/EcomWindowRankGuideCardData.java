package com.bytedance.android.livesdk.end;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yu1.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J?\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/end/EcomWindowRankGuideCardData;", "Lyu1/a;", "", "component1", "", "Lcom/bytedance/android/livesdk/end/EcomWindowRankItem;", "component2", "component3", "component4", "cardText", "rankItems", "jumpTipText", "cardJumpUrl", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getCardText", "()Ljava/lang/String;", "Ljava/util/List;", "getRankItems", "()Ljava/util/List;", "getJumpTipText", "getCardJumpUrl", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EcomWindowRankGuideCardData extends a {

    @SerializedName("card_jump_url")
    private final String cardJumpUrl;

    @SerializedName("card_text")
    private final String cardText;

    @SerializedName("jump_tip_text")
    private final String jumpTipText;

    @SerializedName("rank_items")
    private final List<EcomWindowRankItem> rankItems;

    public EcomWindowRankGuideCardData() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EcomWindowRankGuideCardData copy$default(EcomWindowRankGuideCardData r100, String r101, List r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.cardText;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.rankItems;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.jumpTipText;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.cardJumpUrl;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.cardText;
    }

    public final List<EcomWindowRankItem> component2() {
        return this.rankItems;
    }

    public final String component3() {
        return this.jumpTipText;
    }

    public final String component4() {
        return this.cardJumpUrl;
    }

    public final EcomWindowRankGuideCardData copy(String r100, List<EcomWindowRankItem> r101, String r102, String r103) {
        return new EcomWindowRankGuideCardData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EcomWindowRankGuideCardData) == false) goto L14;
        EcomWindowRankGuideCardData r101 = (EcomWindowRankGuideCardData) r100;
        if (Intrinsics.areEqual(this.cardText, r101.cardText) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.rankItems, r101.rankItems) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.jumpTipText, r101.jumpTipText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cardJumpUrl, r101.cardJumpUrl) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.cardText;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<EcomWindowRankItem> r104 = this.rankItems;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.jumpTipText;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.cardJumpUrl;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "EcomWindowRankGuideCardData(cardText=" + this.cardText + ", rankItems=" + this.rankItems + ", jumpTipText=" + this.jumpTipText + ", cardJumpUrl=" + this.cardJumpUrl + ")";
    }

    public final String getCardJumpUrl() {
        return this.cardJumpUrl;
    }

    public final String getCardText() {
        return this.cardText;
    }

    public final String getJumpTipText() {
        return this.jumpTipText;
    }

    public final List<EcomWindowRankItem> getRankItems() {
        return this.rankItems;
    }

    public EcomWindowRankGuideCardData(String r100, List<EcomWindowRankItem> r101, String r102, String r103) {
        this.cardText = r100;
        this.rankItems = r101;
        this.jumpTipText = r102;
        this.cardJumpUrl = r103;
    }

    public /* synthetic */ EcomWindowRankGuideCardData(String r100, List r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
