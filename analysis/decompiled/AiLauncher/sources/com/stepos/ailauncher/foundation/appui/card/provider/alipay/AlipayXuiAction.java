package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0018\u0010\fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/k;", "", "", "actionType", "label", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "webLink", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/l;", "detail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/l;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getActionType", "c", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/l;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/l;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.k, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class AlipayXuiAction {

    @SerializedName("actionType")
    private final String actionType;

    @SerializedName(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK)
    private final String appLink;

    @SerializedName("detail")
    private final AlipayXuiActionDetail detail;

    @SerializedName("label")
    private final String label;

    @SerializedName("webLink")
    private final String webLink;

    public AlipayXuiAction() {
        this(null, null, null, null, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAppLink() {
        return this.appLink;
    }

    /* renamed from: b, reason: from getter */
    public final AlipayXuiActionDetail getDetail() {
        return this.detail;
    }

    /* renamed from: c, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: d, reason: from getter */
    public final String getWebLink() {
        return this.webLink;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlipayXuiAction)) {
            return false;
        }
        AlipayXuiAction alipayXuiAction = (AlipayXuiAction) other;
        return kotlin.jvm.internal.p.d(this.actionType, alipayXuiAction.actionType) && kotlin.jvm.internal.p.d(this.label, alipayXuiAction.label) && kotlin.jvm.internal.p.d(this.appLink, alipayXuiAction.appLink) && kotlin.jvm.internal.p.d(this.webLink, alipayXuiAction.webLink) && kotlin.jvm.internal.p.d(this.detail, alipayXuiAction.detail);
    }

    public int hashCode() {
        String str = this.actionType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.label;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.appLink;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.webLink;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        AlipayXuiActionDetail alipayXuiActionDetail = this.detail;
        return iHashCode4 + (alipayXuiActionDetail != null ? alipayXuiActionDetail.hashCode() : 0);
    }

    public String toString() {
        return "AlipayXuiAction(actionType=" + this.actionType + ", label=" + this.label + ", appLink=" + this.appLink + ", webLink=" + this.webLink + ", detail=" + this.detail + ")";
    }

    public AlipayXuiAction(String str, String str2, String str3, String str4, AlipayXuiActionDetail alipayXuiActionDetail) {
        this.actionType = str;
        this.label = str2;
        this.appLink = str3;
        this.webLink = str4;
        this.detail = alipayXuiActionDetail;
    }

    public /* synthetic */ AlipayXuiAction(String str, String str2, String str3, String str4, AlipayXuiActionDetail alipayXuiActionDetail, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : alipayXuiActionDetail);
    }
}
