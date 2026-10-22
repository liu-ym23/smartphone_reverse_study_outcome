package com.bytedance.android.ec.store.repository.vo;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class m {
    public static final Map<String, Object> a(l r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$dataCxt");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.putAll(r100.U);
        if (r101 == null) goto L5;
        r102.putAll(r101);
    L5:
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(r100.R);
        r103.putAll(r100.S);
        r103.putAll(r100.T);
        r103.put("slice_item_states", r102);
        Unit r104 = Unit.INSTANCE;
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("data", r103)});
    }
}
