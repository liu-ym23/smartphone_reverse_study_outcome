package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0080\b\u0018\u00002\u00020\u0001BÓ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u001cR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b&\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b'\u0010\u001cR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b(\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b,\u0010\u001cR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b-\u0010\u001cR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b.\u0010\u001cR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b/\u0010\u001cR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b0\u0010\u001cR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010)\u001a\u0004\b1\u0010+R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010)\u001a\u0004\b2\u0010+R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b3\u0010\u001cR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u00104\u001a\u0004\b5\u00106R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u00107\u001a\u0004\b8\u00109R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010:\u001a\u0004\b;\u0010<R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010=\u001a\u0004\b>\u0010?¨\u0006@"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/P;", "", "", "title", "orderId", "carModel", "carPlate", "", "distanceKm", "eta", "pickUp", "dropoff", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "account", "prepayAmount", "actualPay", "productName", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/S;", "primaryInfo", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/O;", "media", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/g;", "action", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/Z;", "secondaryInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/S;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/O;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/g;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/Z;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "q", "k", "e", "f", "Ljava/lang/Double;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/Double;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "l", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "m", "c", "o", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/S;", "n", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/S;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/O;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/O;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/g;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/g;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/Z;", "p", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/Z;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.P, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class DidiOrderItem {

    @SerializedName("account")
    private final String account;

    @SerializedName("action")
    private final DidiAction action;

    @SerializedName("actualPay")
    private final Double actualPay;

    @SerializedName(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK)
    private final String appLink;

    @SerializedName("carModel")
    private final String carModel;

    @SerializedName("carPlate")
    private final String carPlate;

    @SerializedName("distanceKm")
    private final Double distanceKm;

    @SerializedName(alternate = {"dropOff"}, value = "dropoff")
    private final String dropoff;

    @SerializedName("eta")
    private final String eta;

    @SerializedName("media")
    private final DidiMediaInfo media;

    @SerializedName("orderId")
    private final String orderId;

    @SerializedName(alternate = {"pickup"}, value = "pickUp")
    private final String pickUp;

    @SerializedName("prepayAmount")
    private final Double prepayAmount;

    @SerializedName("primaryInfo")
    private final DidiPrimaryInfo primaryInfo;

    @SerializedName("productName")
    private final String productName;

    @SerializedName("secondaryInfo")
    private final DidiSecondaryInfo secondaryInfo;

    @SerializedName("title")
    private final String title;

    public DidiOrderItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAccount() {
        return this.account;
    }

    /* renamed from: b, reason: from getter */
    public final DidiAction getAction() {
        return this.action;
    }

    /* renamed from: c, reason: from getter */
    public final Double getActualPay() {
        return this.actualPay;
    }

    /* renamed from: d, reason: from getter */
    public final String getAppLink() {
        return this.appLink;
    }

    /* renamed from: e, reason: from getter */
    public final String getCarModel() {
        return this.carModel;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DidiOrderItem)) {
            return false;
        }
        DidiOrderItem didiOrderItem = (DidiOrderItem) other;
        return kotlin.jvm.internal.p.d(this.title, didiOrderItem.title) && kotlin.jvm.internal.p.d(this.orderId, didiOrderItem.orderId) && kotlin.jvm.internal.p.d(this.carModel, didiOrderItem.carModel) && kotlin.jvm.internal.p.d(this.carPlate, didiOrderItem.carPlate) && kotlin.jvm.internal.p.d(this.distanceKm, didiOrderItem.distanceKm) && kotlin.jvm.internal.p.d(this.eta, didiOrderItem.eta) && kotlin.jvm.internal.p.d(this.pickUp, didiOrderItem.pickUp) && kotlin.jvm.internal.p.d(this.dropoff, didiOrderItem.dropoff) && kotlin.jvm.internal.p.d(this.appLink, didiOrderItem.appLink) && kotlin.jvm.internal.p.d(this.account, didiOrderItem.account) && kotlin.jvm.internal.p.d(this.prepayAmount, didiOrderItem.prepayAmount) && kotlin.jvm.internal.p.d(this.actualPay, didiOrderItem.actualPay) && kotlin.jvm.internal.p.d(this.productName, didiOrderItem.productName) && kotlin.jvm.internal.p.d(this.primaryInfo, didiOrderItem.primaryInfo) && kotlin.jvm.internal.p.d(this.media, didiOrderItem.media) && kotlin.jvm.internal.p.d(this.action, didiOrderItem.action) && kotlin.jvm.internal.p.d(this.secondaryInfo, didiOrderItem.secondaryInfo);
    }

    /* renamed from: f, reason: from getter */
    public final String getCarPlate() {
        return this.carPlate;
    }

    /* renamed from: g, reason: from getter */
    public final Double getDistanceKm() {
        return this.distanceKm;
    }

    /* renamed from: h, reason: from getter */
    public final String getDropoff() {
        return this.dropoff;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.orderId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.carModel;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.carPlate;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Double d10 = this.distanceKm;
        int iHashCode5 = (iHashCode4 + (d10 == null ? 0 : d10.hashCode())) * 31;
        String str5 = this.eta;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.pickUp;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.dropoff;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.appLink;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.account;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Double d11 = this.prepayAmount;
        int iHashCode11 = (iHashCode10 + (d11 == null ? 0 : d11.hashCode())) * 31;
        Double d12 = this.actualPay;
        int iHashCode12 = (iHashCode11 + (d12 == null ? 0 : d12.hashCode())) * 31;
        String str10 = this.productName;
        int iHashCode13 = (iHashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        DidiPrimaryInfo didiPrimaryInfo = this.primaryInfo;
        int iHashCode14 = (iHashCode13 + (didiPrimaryInfo == null ? 0 : didiPrimaryInfo.hashCode())) * 31;
        DidiMediaInfo didiMediaInfo = this.media;
        int iHashCode15 = (iHashCode14 + (didiMediaInfo == null ? 0 : didiMediaInfo.hashCode())) * 31;
        DidiAction didiAction = this.action;
        int iHashCode16 = (iHashCode15 + (didiAction == null ? 0 : didiAction.hashCode())) * 31;
        DidiSecondaryInfo didiSecondaryInfo = this.secondaryInfo;
        return iHashCode16 + (didiSecondaryInfo != null ? didiSecondaryInfo.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getEta() {
        return this.eta;
    }

    /* renamed from: j, reason: from getter */
    public final DidiMediaInfo getMedia() {
        return this.media;
    }

    /* renamed from: k, reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: l, reason: from getter */
    public final String getPickUp() {
        return this.pickUp;
    }

    /* renamed from: m, reason: from getter */
    public final Double getPrepayAmount() {
        return this.prepayAmount;
    }

    /* renamed from: n, reason: from getter */
    public final DidiPrimaryInfo getPrimaryInfo() {
        return this.primaryInfo;
    }

    /* renamed from: o, reason: from getter */
    public final String getProductName() {
        return this.productName;
    }

    /* renamed from: p, reason: from getter */
    public final DidiSecondaryInfo getSecondaryInfo() {
        return this.secondaryInfo;
    }

    /* renamed from: q, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public String toString() {
        return "DidiOrderItem(title=" + this.title + ", orderId=" + this.orderId + ", carModel=" + this.carModel + ", carPlate=" + this.carPlate + ", distanceKm=" + this.distanceKm + ", eta=" + this.eta + ", pickUp=" + this.pickUp + ", dropoff=" + this.dropoff + ", appLink=" + this.appLink + ", account=" + this.account + ", prepayAmount=" + this.prepayAmount + ", actualPay=" + this.actualPay + ", productName=" + this.productName + ", primaryInfo=" + this.primaryInfo + ", media=" + this.media + ", action=" + this.action + ", secondaryInfo=" + this.secondaryInfo + ")";
    }

    public DidiOrderItem(String str, String str2, String str3, String str4, Double d10, String str5, String str6, String str7, String str8, String str9, Double d11, Double d12, String str10, DidiPrimaryInfo didiPrimaryInfo, DidiMediaInfo didiMediaInfo, DidiAction didiAction, DidiSecondaryInfo didiSecondaryInfo) {
        this.title = str;
        this.orderId = str2;
        this.carModel = str3;
        this.carPlate = str4;
        this.distanceKm = d10;
        this.eta = str5;
        this.pickUp = str6;
        this.dropoff = str7;
        this.appLink = str8;
        this.account = str9;
        this.prepayAmount = d11;
        this.actualPay = d12;
        this.productName = str10;
        this.primaryInfo = didiPrimaryInfo;
        this.media = didiMediaInfo;
        this.action = didiAction;
        this.secondaryInfo = didiSecondaryInfo;
    }

    public /* synthetic */ DidiOrderItem(String str, String str2, String str3, String str4, Double d10, String str5, String str6, String str7, String str8, String str9, Double d11, Double d12, String str10, DidiPrimaryInfo didiPrimaryInfo, DidiMediaInfo didiMediaInfo, DidiAction didiAction, DidiSecondaryInfo didiSecondaryInfo, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : d10, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : str6, (i10 & 128) != 0 ? null : str7, (i10 & 256) != 0 ? null : str8, (i10 & 512) != 0 ? null : str9, (i10 & 1024) != 0 ? null : d11, (i10 & 2048) != 0 ? null : d12, (i10 & 4096) != 0 ? null : str10, (i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? null : didiPrimaryInfo, (i10 & 16384) != 0 ? null : didiMediaInfo, (i10 & 32768) != 0 ? null : didiAction, (i10 & 65536) != 0 ? null : didiSecondaryInfo);
    }
}
