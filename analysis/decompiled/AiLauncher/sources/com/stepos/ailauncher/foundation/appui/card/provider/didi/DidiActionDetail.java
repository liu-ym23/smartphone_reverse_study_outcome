package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/h;", "", "", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "webLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.h, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class DidiActionDetail {

    @SerializedName(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK)
    private final String appLink;

    @SerializedName("webLink")
    private final String webLink;

    /* JADX WARN: Multi-variable type inference failed */
    public DidiActionDetail() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final String getAppLink() {
        return this.appLink;
    }

    /* renamed from: b, reason: from getter */
    public final String getWebLink() {
        return this.webLink;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DidiActionDetail)) {
            return false;
        }
        DidiActionDetail didiActionDetail = (DidiActionDetail) other;
        return kotlin.jvm.internal.p.d(this.appLink, didiActionDetail.appLink) && kotlin.jvm.internal.p.d(this.webLink, didiActionDetail.webLink);
    }

    public int hashCode() {
        String str = this.appLink;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.webLink;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DidiActionDetail(appLink=" + this.appLink + ", webLink=" + this.webLink + ")";
    }

    public DidiActionDetail(String str, String str2) {
        this.appLink = str;
        this.webLink = str2;
    }

    public /* synthetic */ DidiActionDetail(String str, String str2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2);
    }
}
