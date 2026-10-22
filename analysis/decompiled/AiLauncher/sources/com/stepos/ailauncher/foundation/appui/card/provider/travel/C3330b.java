package com.stepos.ailauncher.foundation.appui.card.provider.travel;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/b;", "LN5/n;", "", "cardId", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/g;", DidiCardProvider.KEY_ITEMS, "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.travel.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3330b extends N5.n {
    private final String cardId;
    private final List<HotelItem> items;

    /* JADX WARN: Multi-variable type inference failed */
    public C3330b() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // N5.n
    /* renamed from: a, reason: from getter */
    public String getCardId() {
        return this.cardId;
    }

    public final List<HotelItem> b() {
        return this.items;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3330b(String cardId, List<HotelItem> items) {
        super(cardId);
        kotlin.jvm.internal.p.i(cardId, "cardId");
        kotlin.jvm.internal.p.i(items, "items");
        this.cardId = cardId;
        this.items = items;
    }

    public /* synthetic */ C3330b(String str, List list, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? C1173v.m() : list);
    }
}
