package com.stepos.ailauncher.foundation.appui.card.provider.didi.api;

import La.D;
import La.H;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"authorizationState", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthorizationState;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;", "getAuthorizationState", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthorizationState;", "authorized", "", "getAuthorized", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;)Z", "STATUS_ACTIVE", "", "foundation_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DidiAuthStatusApiKt {
    private static final String STATUS_ACTIVE = "ACTIVE";

    public static final DidiAuthorizationState getAuthorizationState(DidiAuthStatusDto didiAuthStatusDto) {
        String string;
        p.i(didiAuthStatusDto, "<this>");
        String status = didiAuthStatusDto.getStatus();
        String str = null;
        if (status != null && (string = H.D1(status).toString()) != null && string.length() > 0) {
            str = string;
        }
        if (D.L(str, STATUS_ACTIVE, true) && p.d(didiAuthStatusDto.getRideEnable(), Boolean.TRUE)) {
            return DidiAuthorizationState.AUTHORIZED;
        }
        if ((str == null || D.L(str, STATUS_ACTIVE, true)) && !p.d(didiAuthStatusDto.getRideEnable(), Boolean.FALSE)) {
            return DidiAuthorizationState.INDETERMINATE;
        }
        return DidiAuthorizationState.NOT_AUTHORIZED;
    }

    public static final boolean getAuthorized(DidiAuthStatusDto didiAuthStatusDto) {
        p.i(didiAuthStatusDto, "<this>");
        return getAuthorizationState(didiAuthStatusDto) == DidiAuthorizationState.AUTHORIZED;
    }
}
