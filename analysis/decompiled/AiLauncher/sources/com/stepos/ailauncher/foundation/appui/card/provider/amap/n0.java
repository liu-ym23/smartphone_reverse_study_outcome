package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/n0;", "LN5/n;", "", "cardId", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/z;", "mapImage", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/m0;", DidiCardProvider.KEY_ITEMS, "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/z;Ljava/util/List;)V", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/z;", "getMapImage", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/z;", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class n0 extends N5.n {
    private final String cardId;
    private final List<RouteCardItem> items;
    private final C3285z mapImage;

    public n0() {
        this(null, null, null, 7, null);
    }

    @Override // N5.n
    /* renamed from: a, reason: from getter */
    public String getCardId() {
        return this.cardId;
    }

    public final List<RouteCardItem> b() {
        return this.items;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(String cardId, C3285z c3285z, List<RouteCardItem> items) {
        super(cardId);
        kotlin.jvm.internal.p.i(cardId, "cardId");
        kotlin.jvm.internal.p.i(items, "items");
        this.cardId = cardId;
        this.mapImage = c3285z;
        this.items = items;
    }

    public /* synthetic */ n0(String str, C3285z c3285z, List list, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? null : c3285z, (i10 & 4) != 0 ? C1173v.m() : list);
    }
}
