package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\b\u0080\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001a\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001b\u0010\u000eR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/x;", "", "", "typeId", "name", "subTitle", "priceText", "originPriceText", "imageUrl", "", "selected", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", Const.INTENT_KEY_PKGNAME, "getSubTitle", Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_APIKEY, "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.x, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class DidiCarType {

    @SerializedName("imageUrl")
    private final String imageUrl;

    @SerializedName("name")
    private final String name;

    @SerializedName("originPriceText")
    private final String originPriceText;

    @SerializedName("priceText")
    private final String priceText;

    @SerializedName("selected")
    private final Boolean selected;

    @SerializedName("subTitle")
    private final String subTitle;

    @SerializedName("typeId")
    private final String typeId;

    public DidiCarType() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: c, reason: from getter */
    public final String getOriginPriceText() {
        return this.originPriceText;
    }

    /* renamed from: d, reason: from getter */
    public final String getPriceText() {
        return this.priceText;
    }

    /* renamed from: e, reason: from getter */
    public final Boolean getSelected() {
        return this.selected;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DidiCarType)) {
            return false;
        }
        DidiCarType didiCarType = (DidiCarType) other;
        return kotlin.jvm.internal.p.d(this.typeId, didiCarType.typeId) && kotlin.jvm.internal.p.d(this.name, didiCarType.name) && kotlin.jvm.internal.p.d(this.subTitle, didiCarType.subTitle) && kotlin.jvm.internal.p.d(this.priceText, didiCarType.priceText) && kotlin.jvm.internal.p.d(this.originPriceText, didiCarType.originPriceText) && kotlin.jvm.internal.p.d(this.imageUrl, didiCarType.imageUrl) && kotlin.jvm.internal.p.d(this.selected, didiCarType.selected);
    }

    /* renamed from: f, reason: from getter */
    public final String getTypeId() {
        return this.typeId;
    }

    public int hashCode() {
        String str = this.typeId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subTitle;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.priceText;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.originPriceText;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.imageUrl;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool = this.selected;
        return iHashCode6 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "DidiCarType(typeId=" + this.typeId + ", name=" + this.name + ", subTitle=" + this.subTitle + ", priceText=" + this.priceText + ", originPriceText=" + this.originPriceText + ", imageUrl=" + this.imageUrl + ", selected=" + this.selected + ")";
    }

    public DidiCarType(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool) {
        this.typeId = str;
        this.name = str2;
        this.subTitle = str3;
        this.priceText = str4;
        this.originPriceText = str5;
        this.imageUrl = str6;
        this.selected = bool;
    }

    public /* synthetic */ DidiCarType(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : bool);
    }
}
