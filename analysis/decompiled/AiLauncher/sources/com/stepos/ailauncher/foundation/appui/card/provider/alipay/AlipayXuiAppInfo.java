package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001a\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001b\u0010\rR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u001c\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/m;", "", "", "storeName", "appName", "iconUrl", "sizeText", "extraText", "installState", "appId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "f", "c", "e", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.m, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class AlipayXuiAppInfo {

    @SerializedName("appId")
    private final String appId;

    @SerializedName("appName")
    private final String appName;

    @SerializedName("extraText")
    private final String extraText;

    @SerializedName("iconUrl")
    private final String iconUrl;

    @SerializedName("installState")
    private final String installState;

    @SerializedName("sizeText")
    private final String sizeText;

    @SerializedName("storeName")
    private final String storeName;

    public AlipayXuiAppInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: b, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: c, reason: from getter */
    public final String getExtraText() {
        return this.extraText;
    }

    /* renamed from: d, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: e, reason: from getter */
    public final String getInstallState() {
        return this.installState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlipayXuiAppInfo)) {
            return false;
        }
        AlipayXuiAppInfo alipayXuiAppInfo = (AlipayXuiAppInfo) other;
        return kotlin.jvm.internal.p.d(this.storeName, alipayXuiAppInfo.storeName) && kotlin.jvm.internal.p.d(this.appName, alipayXuiAppInfo.appName) && kotlin.jvm.internal.p.d(this.iconUrl, alipayXuiAppInfo.iconUrl) && kotlin.jvm.internal.p.d(this.sizeText, alipayXuiAppInfo.sizeText) && kotlin.jvm.internal.p.d(this.extraText, alipayXuiAppInfo.extraText) && kotlin.jvm.internal.p.d(this.installState, alipayXuiAppInfo.installState) && kotlin.jvm.internal.p.d(this.appId, alipayXuiAppInfo.appId);
    }

    /* renamed from: f, reason: from getter */
    public final String getSizeText() {
        return this.sizeText;
    }

    /* renamed from: g, reason: from getter */
    public final String getStoreName() {
        return this.storeName;
    }

    public int hashCode() {
        String str = this.storeName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.appName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.iconUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sizeText;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.extraText;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.installState;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.appId;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "AlipayXuiAppInfo(storeName=" + this.storeName + ", appName=" + this.appName + ", iconUrl=" + this.iconUrl + ", sizeText=" + this.sizeText + ", extraText=" + this.extraText + ", installState=" + this.installState + ", appId=" + this.appId + ")";
    }

    public AlipayXuiAppInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.storeName = str;
        this.appName = str2;
        this.iconUrl = str3;
        this.sizeText = str4;
        this.extraText = str5;
        this.installState = str6;
        this.appId = str7;
    }

    public /* synthetic */ AlipayXuiAppInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : str7);
    }
}
