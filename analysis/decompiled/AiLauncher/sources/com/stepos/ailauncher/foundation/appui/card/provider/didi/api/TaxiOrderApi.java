package com.stepos.ailauncher.foundation.appui.card.provider.didi.api;

import Ac.f;
import Ac.i;
import Ac.s;
import Ac.t;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import yc.v;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J8\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/TaxiOrderApi;", "", "", "orderId", "integrationId", "userId", "Lyc/v;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/TaxiOrderDto;", DidiCardProvider.KEY_ORDER, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface TaxiOrderApi {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object order$default(TaxiOrderApi taxiOrderApi, String str, String str2, String str3, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: order");
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        return taxiOrderApi.order(str, str2, str3, interfaceC4014c);
    }

    @f("mcp/orders/{orderId}")
    Object order(@s("orderId") String str, @t("integration_id") String str2, @i("zy-user-id") String str3, InterfaceC4014c<? super v<TaxiOrderDto>> interfaceC4014c);
}
