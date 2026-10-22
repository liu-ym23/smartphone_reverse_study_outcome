package com.stepos.ailauncher.foundation.appui.card.provider.didi.api;

import Z8.Y;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lyc/v;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiOrderResultDto;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0;", "toTaxiOutcome", "(Lyc/v;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/f0;", "", "", "DIDI_FATAL_ERROR_CODES", "Ljava/util/Set;", "foundation_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DidiOrderApiKt {
    private static final Set<String> DIDI_FATAL_ERROR_CODES = Y.j("NOT_AUTHORIZED", "RIDE_NOT_ENABLED", "NO_ACTIVE_ORDER");

    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.stepos.ailauncher.foundation.appui.card.provider.didi.f0 toTaxiOutcome(yc.v<com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiOrderResultDto> r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.p.i(r3, r0)
            boolean r0 = r3.f()
            if (r0 != 0) goto L43
            int r3 = r3.b()
            r0 = 400(0x190, float:5.6E-43)
            java.lang.String r1 = "http_"
            if (r3 == r0) goto L2e
            r0 = 405(0x195, float:5.68E-43)
            if (r3 == r0) goto L2e
            com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$b r0 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r3)
            java.lang.String r3 = r2.toString()
            r0.<init>(r3)
            return r0
        L2e:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$c r0 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r3)
            java.lang.String r3 = r2.toString()
            r0.<init>(r3)
            return r0
        L43:
            java.lang.Object r3 = r3.a()
            com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiOrderResultDto r3 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiOrderResultDto) r3
            if (r3 != 0) goto L53
            com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$b r3 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$b
            java.lang.String r0 = "empty_body"
            r3.<init>(r0)
            return r3
        L53:
            java.lang.Boolean r0 = r3.getOk()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)
            r1 = 0
            if (r0 != 0) goto L8c
            com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiOrderErrorDto r3 = r3.getError()
            if (r3 == 0) goto L75
            java.lang.String r3 = r3.getCode()
            if (r3 == 0) goto L75
            boolean r0 = La.H.x0(r3)
            if (r0 != 0) goto L73
            r1 = r3
        L73:
            if (r1 != 0) goto L78
        L75:
            java.lang.String r1 = "unknown_error"
        L78:
            java.util.Set<java.lang.String> r3 = com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiOrderApiKt.DIDI_FATAL_ERROR_CODES
            boolean r3 = r3.contains(r1)
            if (r3 == 0) goto L86
            com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$c r3 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$c
            r3.<init>(r1)
            return r3
        L86:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$b r3 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$b
            r3.<init>(r1)
            return r3
        L8c:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiOrderPayloadDto r3 = r3.getResult()
            if (r3 == 0) goto L9f
            com.google.gson.JsonObject r3 = r3.getStructuredContent()
            if (r3 != 0) goto L99
            goto L9f
        L99:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$a r0 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$a
            r0.<init>(r3, r1, r1, r1)
            return r0
        L9f:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$b r3 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.f0$b
            java.lang.String r0 = "no_structured_content"
            r3.<init>(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiOrderApiKt.toTaxiOutcome(yc.v):com.stepos.ailauncher.foundation.appui.card.provider.didi.f0");
    }
}
