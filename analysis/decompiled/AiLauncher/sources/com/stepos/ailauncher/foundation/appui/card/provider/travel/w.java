package com.stepos.ailauncher.foundation.appui.card.provider.travel;

import N5.CardAction;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/w;", "LN5/n;", "", "cardId", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/s;", "transport", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/g;", O5.c.HOTEL, "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/C;", "totalPrice", "LN5/f;", "action", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/s;Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/g;Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/C;LN5/f;)V", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/s;", "e", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/s;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/g;", "c", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/g;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/C;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/C;", "LN5/f;", Const.INTENT_KEY_PKGNAME, "()LN5/f;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class w extends N5.n {
    private final CardAction action;
    private final String cardId;
    private final HotelItem hotel;
    private final TripTotalPrice totalPrice;
    private final TransportItem transport;

    public w() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // N5.n
    /* renamed from: a, reason: from getter */
    public String getCardId() {
        return this.cardId;
    }

    /* renamed from: b, reason: from getter */
    public final CardAction getAction() {
        return this.action;
    }

    /* renamed from: c, reason: from getter */
    public final HotelItem getHotel() {
        return this.hotel;
    }

    /* renamed from: d, reason: from getter */
    public final TripTotalPrice getTotalPrice() {
        return this.totalPrice;
    }

    /* renamed from: e, reason: from getter */
    public final TransportItem getTransport() {
        return this.transport;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(String cardId, TransportItem transportItem, HotelItem hotelItem, TripTotalPrice tripTotalPrice, CardAction cardAction) {
        super(cardId);
        kotlin.jvm.internal.p.i(cardId, "cardId");
        this.cardId = cardId;
        this.transport = transportItem;
        this.hotel = hotelItem;
        this.totalPrice = tripTotalPrice;
        this.action = cardAction;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ w(java.lang.String r2, com.stepos.ailauncher.foundation.appui.card.provider.travel.TransportItem r3, com.stepos.ailauncher.foundation.appui.card.provider.travel.HotelItem r4, com.stepos.ailauncher.foundation.appui.card.provider.travel.TripTotalPrice r5, N5.CardAction r6, int r7, kotlin.jvm.internal.i r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r8 = r7 & 2
            r0 = 0
            if (r8 == 0) goto Lc
            r3 = r0
        Lc:
            r8 = r7 & 4
            if (r8 == 0) goto L11
            r4 = r0
        L11:
            r8 = r7 & 8
            if (r8 == 0) goto L16
            r5 = r0
        L16:
            r7 = r7 & 16
            if (r7 == 0) goto L21
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L27
        L21:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L27:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.travel.w.<init>(java.lang.String, com.stepos.ailauncher.foundation.appui.card.provider.travel.s, com.stepos.ailauncher.foundation.appui.card.provider.travel.g, com.stepos.ailauncher.foundation.appui.card.provider.travel.C, N5.f, int, kotlin.jvm.internal.i):void");
    }
}
