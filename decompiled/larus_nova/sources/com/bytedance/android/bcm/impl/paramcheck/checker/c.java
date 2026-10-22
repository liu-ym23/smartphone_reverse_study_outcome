package com.bytedance.android.bcm.impl.paramcheck.checker;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    public static final a.b a(String r100, BcmCheckErrorType r101, Object r102, Object r103) {
        Map r104 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("param_name", r100), TuplesKt.to("error_type", r101.getValue())});
        if (r102 == null) goto L5;
        r104.put("expect_value", r102);
    L5:
        if (r103 == null) goto L8;
        r104.put("actual_value", r103);
    L8:
        return new a.b(r100, r101, r104);
    }
}
