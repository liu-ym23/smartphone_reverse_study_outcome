package com.bytedance.android.shopping.store.home.slice;

import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f {
    public static final Map<String, ShopSliceItemConfig> a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getItemConfigMap");
        LinkedHashMap r101 = new LinkedHashMap();
        Map<String, ECStoreHeaderInfoSliceConfig> r102 = r100.f184505a;
        if (r102 == null) goto L10;
        Iterator<Map.Entry<String, ECStoreHeaderInfoSliceConfig>> r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<String, ECStoreHeaderInfoSliceConfig> r104 = r103.next();
        ShopSliceItemConfig r105 = r104.getValue().getSliceItemConfig();
        if (r105 == null) goto L6;
        r101.put(r104.getKey(), r105);
    L10:
        return r101;
    }
}
