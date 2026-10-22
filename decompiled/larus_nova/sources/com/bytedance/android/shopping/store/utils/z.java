package com.bytedance.android.shopping.store.utils;

import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class z {
    public static final String c(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.toString();
    }

    public static final Pair<String, String>[] b(Object r100, Object r101) {
        return new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, c(r100)), TuplesKt.to("sec_shop_id", c(r101))};
    }

    public static final Pair<String, String>[] a(Object r100, Object r101, Object r102, Object r110, Object r111, Object r112, Object r113, Object r114, boolean r115, Object r116, Object r117, Pair<String, String>... r118) {
        Intrinsics.checkNotNullParameter(r118, "extraParams");
        String r103 = c(r100);
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        dm.a.a("StoreEventParamsCommonHelper").b("author_id is empty when building store common event params", null);
    L11:
        Pair[] r105 = new Pair[13];
        r105[0] = TuplesKt.to("author_id", r103);
        r105[1] = TuplesKt.to("enter_from", c(r101));
        r105[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, c(r102));
        r105[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, c(r110));
        r105[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, c(r111));
        r105[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, c(r112));
        r105[6] = TuplesKt.to("page_name", c(r113));
        r105[7] = TuplesKt.to("source_page", c(r113));
        r105[8] = TuplesKt.to("follow_status", c(r114));
        if (r115 == false) goto L14;
        String r106 = "1";
    L15:
        r105[9] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_ENTER_PREVIEW, r106);
        r105[10] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TEMP_ID, c(r116));
        r105[11] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, c("shop"));
        r105[12] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, c(r117));
        List r107 = CollectionsKt.mutableListOf(r105);
        CollectionsKt.addAll(r107, r118);
        Object[] r108 = r107.toArray(new Pair[0]);
        if (r108 == null) goto L20;
        return (Pair[]) r108;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L14:
        r106 = "0";
        goto L15
    L5:
        if (StringsKt.isBlank(r103) == true) goto L8;
        r104 = false;
        goto L9
    }
}
