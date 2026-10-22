package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0080\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b!\u0010 R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\"\u0010\u000f¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/p;", "", "", "title", "subTitle", "iconUrl", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/m;", "app", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/k;", "action", "secondaryAction", "installState", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/m;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/k;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/k;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "getSubTitle", "c", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/m;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/m;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/k;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/k;", "e", Const.INTENT_KEY_UMID, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.p, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class AlipayXuiBusinessData {

    @SerializedName("action")
    private final AlipayXuiAction action;

    @SerializedName("app")
    private final AlipayXuiAppInfo app;

    @SerializedName("iconUrl")
    private final String iconUrl;

    @SerializedName("installState")
    private final String installState;

    @SerializedName("secondaryAction")
    private final AlipayXuiAction secondaryAction;

    @SerializedName("subTitle")
    private final String subTitle;

    @SerializedName("title")
    private final String title;

    public AlipayXuiBusinessData() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final AlipayXuiAction getAction() {
        return this.action;
    }

    /* renamed from: b, reason: from getter */
    public final AlipayXuiAppInfo getApp() {
        return this.app;
    }

    /* renamed from: c, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: d, reason: from getter */
    public final String getInstallState() {
        return this.installState;
    }

    /* renamed from: e, reason: from getter */
    public final AlipayXuiAction getSecondaryAction() {
        return this.secondaryAction;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlipayXuiBusinessData)) {
            return false;
        }
        AlipayXuiBusinessData alipayXuiBusinessData = (AlipayXuiBusinessData) other;
        return kotlin.jvm.internal.p.d(this.title, alipayXuiBusinessData.title) && kotlin.jvm.internal.p.d(this.subTitle, alipayXuiBusinessData.subTitle) && kotlin.jvm.internal.p.d(this.iconUrl, alipayXuiBusinessData.iconUrl) && kotlin.jvm.internal.p.d(this.app, alipayXuiBusinessData.app) && kotlin.jvm.internal.p.d(this.action, alipayXuiBusinessData.action) && kotlin.jvm.internal.p.d(this.secondaryAction, alipayXuiBusinessData.secondaryAction) && kotlin.jvm.internal.p.d(this.installState, alipayXuiBusinessData.installState);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subTitle;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.iconUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        AlipayXuiAppInfo alipayXuiAppInfo = this.app;
        int iHashCode4 = (iHashCode3 + (alipayXuiAppInfo == null ? 0 : alipayXuiAppInfo.hashCode())) * 31;
        AlipayXuiAction alipayXuiAction = this.action;
        int iHashCode5 = (iHashCode4 + (alipayXuiAction == null ? 0 : alipayXuiAction.hashCode())) * 31;
        AlipayXuiAction alipayXuiAction2 = this.secondaryAction;
        int iHashCode6 = (iHashCode5 + (alipayXuiAction2 == null ? 0 : alipayXuiAction2.hashCode())) * 31;
        String str4 = this.installState;
        return iHashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "AlipayXuiBusinessData(title=" + this.title + ", subTitle=" + this.subTitle + ", iconUrl=" + this.iconUrl + ", app=" + this.app + ", action=" + this.action + ", secondaryAction=" + this.secondaryAction + ", installState=" + this.installState + ")";
    }

    public AlipayXuiBusinessData(String str, String str2, String str3, AlipayXuiAppInfo alipayXuiAppInfo, AlipayXuiAction alipayXuiAction, AlipayXuiAction alipayXuiAction2, String str4) {
        this.title = str;
        this.subTitle = str2;
        this.iconUrl = str3;
        this.app = alipayXuiAppInfo;
        this.action = alipayXuiAction;
        this.secondaryAction = alipayXuiAction2;
        this.installState = str4;
    }

    public /* synthetic */ AlipayXuiBusinessData(String str, String str2, String str3, AlipayXuiAppInfo alipayXuiAppInfo, AlipayXuiAction alipayXuiAction, AlipayXuiAction alipayXuiAction2, String str4, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : alipayXuiAppInfo, (i10 & 16) != 0 ? null : alipayXuiAction, (i10 & 32) != 0 ? null : alipayXuiAction2, (i10 & 64) != 0 ? null : str4);
    }
}
