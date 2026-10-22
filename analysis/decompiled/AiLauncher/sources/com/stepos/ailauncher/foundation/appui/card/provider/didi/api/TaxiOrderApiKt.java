package com.stepos.ailauncher.foundation.appui.card.provider.didi.api;

import com.google.gson.JsonObject;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.f0;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import yc.v;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lyc/v;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/TaxiOrderDto;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0;", "toTaxiOutcome", "(Lyc/v;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0;", "foundation_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaxiOrderApiKt {
    public static final f0 toTaxiOutcome(v<TaxiOrderDto> vVar) {
        p.i(vVar, "<this>");
        if (vVar.f()) {
            TaxiOrderDto taxiOrderDtoA = vVar.a();
            if (taxiOrderDtoA == null) {
                return new f0.Retry("empty_body");
            }
            JsonObject structuredContent = taxiOrderDtoA.getStructuredContent();
            return structuredContent == null ? new f0.Retry("no_structured_content") : new f0.Ok(structuredContent, taxiOrderDtoA.getTaskStatus(), taxiOrderDtoA.getStatus(), taxiOrderDtoA.getNextPollAt());
        }
        int iB = vVar.b();
        if (400 > iB || iB >= 500) {
            return new f0.Retry("http_" + iB);
        }
        return new f0.Stop("http_" + iB);
    }
}
