package com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import ouc.d0;
import ouc.g0;
import ouc.i;
import ouc.k;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¨\u0006\b"}, d2 = {"cjStringPrimitive", "Lkotlinx/serialization/json/JsonPrimitive;", "value", "", "cjJsonObjectOrEmpty", "Lkotlinx/serialization/json/JsonObject;", "", "Lkotlinx/serialization/json/JsonElement;", "cj_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CancelRetainModelsKt {
    public static final d0 cjJsonObjectOrEmpty(Map<String, ? extends i> r100) {
        if (r100 != null) goto L6;
        r100 = MapsKt.emptyMap();
    L6:
        return new d0(r100);
    }

    public static final g0 cjStringPrimitive(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        return k.c(r100);
    }
}
