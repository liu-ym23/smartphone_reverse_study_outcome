package com.bytedance.android.shopping.orderlist.common.freq;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final List<FreqStrategy> a(List<? extends Map<String, ? extends Object>> r110) {
        ArrayList r100 = new ArrayList();
        Iterator<T> r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L29;
        Map r101 = (Map) r111.next();
        Long r102 = StringsKt.toLongOrNull(String.valueOf(r101.get("freezing_period")));
        Long r103 = StringsKt.toLongOrNull(String.valueOf(r101.get("lookback_period")));
        String r104 = String.valueOf(r101.get("target_status"));
        Intrinsics.checkNotNullParameter(r104, "$this$toFreqStatus");
        FreqStatus.Companion.getClass();
        Intrinsics.checkNotNullParameter(r104, "value");
        FreqStatus[] r105 = FreqStatus.values();
        int r106 = r105.length;
        int r107 = 0;
    L6:
        if (r107 >= r106) goto L11;
        FreqStatus r108 = r105[r107];
        if (Intrinsics.areEqual(r108.getStatus(), r104) == true) goto L12;
        r107 = r107 + 1;
    L12:
        Map r109 = (Map) u0.b(String.valueOf(r101.get(SlcCommonAction.KEY_ACTIONS)), Map.class);
        FreqActionType r112 = new FreqActionType(null, null, null, 7, null);
        if (r109 == null) goto L28;
        Set r113 = r109.keySet();
        if (r113 == null) goto L28;
        Iterator r114 = r113.iterator();
    L18:
        if (r114.hasNext() == false) goto L28;
        Object r115 = r114.next();
        if (Intrinsics.areEqual(r115, "view") == true) goto L21;
        if (Intrinsics.areEqual(r115, "click") == true) goto L24;
        if (Intrinsics.areEqual(r115, "close") == false) goto L18;
        String r116 = String.valueOf(r109.get(r115));
        Intrinsics.checkNotNullParameter(r116, "$this$toFreqParam");
        r112.setClose((FreqParam) u0.b(r116, FreqParam.class));
        goto L18
    L24:
        String r117 = String.valueOf(r109.get(r115));
        Intrinsics.checkNotNullParameter(r117, "$this$toFreqParam");
        r112.setClick((FreqParam) u0.b(r117, FreqParam.class));
        goto L18
    L21:
        String r118 = String.valueOf(r109.get(r115));
        Intrinsics.checkNotNullParameter(r118, "$this$toFreqParam");
        r112.setView((FreqParam) u0.b(r118, FreqParam.class));
    L28:
        r100.add(new FreqStrategy(r112, r108, r102, r103));
        goto L4
    L11:
        r108 = null;
        goto L12
    L29:
        return r100;
    }
}
