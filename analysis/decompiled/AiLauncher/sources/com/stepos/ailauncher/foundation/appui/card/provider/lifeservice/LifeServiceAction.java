package com.stepos.ailauncher.foundation.appui.card.provider.lifeservice;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/a;", "", "", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "webLink", "Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/b;", "detail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/b;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "c", "Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/b;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/b;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.lifeservice.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class LifeServiceAction {
    private final String appLink;
    private final LifeServiceActionDetail detail;
    private final String webLink;

    public LifeServiceAction() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAppLink() {
        return this.appLink;
    }

    /* renamed from: b, reason: from getter */
    public final LifeServiceActionDetail getDetail() {
        return this.detail;
    }

    /* renamed from: c, reason: from getter */
    public final String getWebLink() {
        return this.webLink;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LifeServiceAction)) {
            return false;
        }
        LifeServiceAction lifeServiceAction = (LifeServiceAction) other;
        return p.d(this.appLink, lifeServiceAction.appLink) && p.d(this.webLink, lifeServiceAction.webLink) && p.d(this.detail, lifeServiceAction.detail);
    }

    public int hashCode() {
        String str = this.appLink;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.webLink;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        LifeServiceActionDetail lifeServiceActionDetail = this.detail;
        return iHashCode2 + (lifeServiceActionDetail != null ? lifeServiceActionDetail.hashCode() : 0);
    }

    public String toString() {
        return "LifeServiceAction(appLink=" + this.appLink + ", webLink=" + this.webLink + ", detail=" + this.detail + ")";
    }

    public LifeServiceAction(String str, String str2, LifeServiceActionDetail lifeServiceActionDetail) {
        this.appLink = str;
        this.webLink = str2;
        this.detail = lifeServiceActionDetail;
    }

    public /* synthetic */ LifeServiceAction(String str, String str2, LifeServiceActionDetail lifeServiceActionDetail, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : lifeServiceActionDetail);
    }
}
