package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001a\u0010\rR\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/g;", "", "", "actionType", "label", "replyText", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "webLink", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/h;", "detail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/h;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "e", Const.INTENT_KEY_PKGNAME, "f", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/h;", "c", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/h;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.g, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class DidiAction {

    @SerializedName("actionType")
    private final String actionType;

    @SerializedName(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK)
    private final String appLink;

    @SerializedName("detail")
    private final DidiActionDetail detail;

    @SerializedName("label")
    private final String label;

    @SerializedName("replyText")
    private final String replyText;

    @SerializedName("webLink")
    private final String webLink;

    public DidiAction() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getActionType() {
        return this.actionType;
    }

    /* renamed from: b, reason: from getter */
    public final String getAppLink() {
        return this.appLink;
    }

    /* renamed from: c, reason: from getter */
    public final DidiActionDetail getDetail() {
        return this.detail;
    }

    /* renamed from: d, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: e, reason: from getter */
    public final String getReplyText() {
        return this.replyText;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DidiAction)) {
            return false;
        }
        DidiAction didiAction = (DidiAction) other;
        return kotlin.jvm.internal.p.d(this.actionType, didiAction.actionType) && kotlin.jvm.internal.p.d(this.label, didiAction.label) && kotlin.jvm.internal.p.d(this.replyText, didiAction.replyText) && kotlin.jvm.internal.p.d(this.appLink, didiAction.appLink) && kotlin.jvm.internal.p.d(this.webLink, didiAction.webLink) && kotlin.jvm.internal.p.d(this.detail, didiAction.detail);
    }

    /* renamed from: f, reason: from getter */
    public final String getWebLink() {
        return this.webLink;
    }

    public int hashCode() {
        String str = this.actionType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.label;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.replyText;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.appLink;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.webLink;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        DidiActionDetail didiActionDetail = this.detail;
        return iHashCode5 + (didiActionDetail != null ? didiActionDetail.hashCode() : 0);
    }

    public String toString() {
        return "DidiAction(actionType=" + this.actionType + ", label=" + this.label + ", replyText=" + this.replyText + ", appLink=" + this.appLink + ", webLink=" + this.webLink + ", detail=" + this.detail + ")";
    }

    public DidiAction(String str, String str2, String str3, String str4, String str5, DidiActionDetail didiActionDetail) {
        this.actionType = str;
        this.label = str2;
        this.replyText = str3;
        this.appLink = str4;
        this.webLink = str5;
        this.detail = didiActionDetail;
    }

    public /* synthetic */ DidiAction(String str, String str2, String str3, String str4, String str5, DidiActionDetail didiActionDetail, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : didiActionDetail);
    }
}
