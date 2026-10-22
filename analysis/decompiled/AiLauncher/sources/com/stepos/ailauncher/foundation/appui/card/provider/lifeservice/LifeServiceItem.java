package com.stepos.ailauncher.foundation.appui.card.provider.lifeservice;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/g;", "", "", "itemId", "Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/a;", "action", "Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/i;", "primaryInfo", "Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/h;", "media", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/a;Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/i;Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/h;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getItemId", "Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/a;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/a;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/i;", "c", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/i;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/h;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/lifeservice/h;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.lifeservice.g, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class LifeServiceItem {
    private final LifeServiceAction action;
    private final String itemId;

    @SerializedName("media")
    private final LifeServiceMedia media;

    @SerializedName("primaryInfo")
    private final LifeServicePrimaryInfo primaryInfo;

    public LifeServiceItem() {
        this(null, null, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final LifeServiceAction getAction() {
        return this.action;
    }

    /* renamed from: b, reason: from getter */
    public final LifeServiceMedia getMedia() {
        return this.media;
    }

    /* renamed from: c, reason: from getter */
    public final LifeServicePrimaryInfo getPrimaryInfo() {
        return this.primaryInfo;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LifeServiceItem)) {
            return false;
        }
        LifeServiceItem lifeServiceItem = (LifeServiceItem) other;
        return p.d(this.itemId, lifeServiceItem.itemId) && p.d(this.action, lifeServiceItem.action) && p.d(this.primaryInfo, lifeServiceItem.primaryInfo) && p.d(this.media, lifeServiceItem.media);
    }

    public int hashCode() {
        String str = this.itemId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        LifeServiceAction lifeServiceAction = this.action;
        int iHashCode2 = (iHashCode + (lifeServiceAction == null ? 0 : lifeServiceAction.hashCode())) * 31;
        LifeServicePrimaryInfo lifeServicePrimaryInfo = this.primaryInfo;
        int iHashCode3 = (iHashCode2 + (lifeServicePrimaryInfo == null ? 0 : lifeServicePrimaryInfo.hashCode())) * 31;
        LifeServiceMedia lifeServiceMedia = this.media;
        return iHashCode3 + (lifeServiceMedia != null ? lifeServiceMedia.hashCode() : 0);
    }

    public String toString() {
        return "LifeServiceItem(itemId=" + this.itemId + ", action=" + this.action + ", primaryInfo=" + this.primaryInfo + ", media=" + this.media + ")";
    }

    public LifeServiceItem(String str, LifeServiceAction lifeServiceAction, LifeServicePrimaryInfo lifeServicePrimaryInfo, LifeServiceMedia lifeServiceMedia) {
        this.itemId = str;
        this.action = lifeServiceAction;
        this.primaryInfo = lifeServicePrimaryInfo;
        this.media = lifeServiceMedia;
    }

    public /* synthetic */ LifeServiceItem(String str, LifeServiceAction lifeServiceAction, LifeServicePrimaryInfo lifeServicePrimaryInfo, LifeServiceMedia lifeServiceMedia, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : lifeServiceAction, (i10 & 4) != 0 ? null : lifeServicePrimaryInfo, (i10 & 8) != 0 ? null : lifeServiceMedia);
    }
}
