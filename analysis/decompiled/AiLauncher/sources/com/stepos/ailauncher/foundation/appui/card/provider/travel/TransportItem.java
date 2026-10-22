package com.stepos.ailauncher.foundation.appui.card.provider.travel;

import N5.CardAction;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0011R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/s;", "", "", "itemId", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/a;", "primaryInfo", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/v;", "secondaryInfo", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/u;", "schedule", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/t;", "price", "LN5/f;", "action", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/a;Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/v;Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/u;Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/t;LN5/f;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getItemId", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/a;", "c", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/a;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/v;", "e", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/v;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/u;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/u;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/t;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/t;", "LN5/f;", Const.INTENT_KEY_APIKEY, "()LN5/f;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.travel.s, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TransportItem {
    private final CardAction action;
    private final String itemId;
    private final TransportPrice price;
    private final CardPrimaryInfo primaryInfo;
    private final TransportSchedule schedule;
    private final TransportSecondaryInfo secondaryInfo;

    public TransportItem() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* renamed from: a, reason: from getter */
    public final CardAction getAction() {
        return this.action;
    }

    /* renamed from: b, reason: from getter */
    public final TransportPrice getPrice() {
        return this.price;
    }

    /* renamed from: c, reason: from getter */
    public final CardPrimaryInfo getPrimaryInfo() {
        return this.primaryInfo;
    }

    /* renamed from: d, reason: from getter */
    public final TransportSchedule getSchedule() {
        return this.schedule;
    }

    /* renamed from: e, reason: from getter */
    public final TransportSecondaryInfo getSecondaryInfo() {
        return this.secondaryInfo;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportItem)) {
            return false;
        }
        TransportItem transportItem = (TransportItem) other;
        return kotlin.jvm.internal.p.d(this.itemId, transportItem.itemId) && kotlin.jvm.internal.p.d(this.primaryInfo, transportItem.primaryInfo) && kotlin.jvm.internal.p.d(this.secondaryInfo, transportItem.secondaryInfo) && kotlin.jvm.internal.p.d(this.schedule, transportItem.schedule) && kotlin.jvm.internal.p.d(this.price, transportItem.price) && kotlin.jvm.internal.p.d(this.action, transportItem.action);
    }

    public int hashCode() {
        String str = this.itemId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        CardPrimaryInfo cardPrimaryInfo = this.primaryInfo;
        int iHashCode2 = (iHashCode + (cardPrimaryInfo == null ? 0 : cardPrimaryInfo.hashCode())) * 31;
        TransportSecondaryInfo transportSecondaryInfo = this.secondaryInfo;
        int iHashCode3 = (iHashCode2 + (transportSecondaryInfo == null ? 0 : transportSecondaryInfo.hashCode())) * 31;
        TransportSchedule transportSchedule = this.schedule;
        int iHashCode4 = (iHashCode3 + (transportSchedule == null ? 0 : transportSchedule.hashCode())) * 31;
        TransportPrice transportPrice = this.price;
        int iHashCode5 = (iHashCode4 + (transportPrice == null ? 0 : transportPrice.hashCode())) * 31;
        CardAction cardAction = this.action;
        return iHashCode5 + (cardAction != null ? cardAction.hashCode() : 0);
    }

    public String toString() {
        return "TransportItem(itemId=" + this.itemId + ", primaryInfo=" + this.primaryInfo + ", secondaryInfo=" + this.secondaryInfo + ", schedule=" + this.schedule + ", price=" + this.price + ", action=" + this.action + ")";
    }

    public TransportItem(String str, CardPrimaryInfo cardPrimaryInfo, TransportSecondaryInfo transportSecondaryInfo, TransportSchedule transportSchedule, TransportPrice transportPrice, CardAction cardAction) {
        this.itemId = str;
        this.primaryInfo = cardPrimaryInfo;
        this.secondaryInfo = transportSecondaryInfo;
        this.schedule = transportSchedule;
        this.price = transportPrice;
        this.action = cardAction;
    }

    public /* synthetic */ TransportItem(String str, CardPrimaryInfo cardPrimaryInfo, TransportSecondaryInfo transportSecondaryInfo, TransportSchedule transportSchedule, TransportPrice transportPrice, CardAction cardAction, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : cardPrimaryInfo, (i10 & 4) != 0 ? null : transportSecondaryInfo, (i10 & 8) != 0 ? null : transportSchedule, (i10 & 16) != 0 ? null : transportPrice, (i10 & 32) != 0 ? null : cardAction);
    }
}
