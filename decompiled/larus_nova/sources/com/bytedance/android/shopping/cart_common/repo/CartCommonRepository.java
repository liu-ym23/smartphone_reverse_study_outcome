package com.bytedance.android.shopping.cart_common.repo;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class CartCommonRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f172093a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f172094b = null;

    static {
        f172093a = Keva.getRepo("ecom_cart_search_storage", 1);
        f172094b = Keva.getRepo("ecom_cart_common_storage", 1);
    }

    public static List a(final String r100) {
        String[] r101 = f172093a.getStringArray("search_history", new String[0]);
        if (r101 == null) goto L6;
        List r102 = ArraysKt.toMutableList(r101);
        if (r102 == null) goto L6;
    L7:
        CollectionsKt.removeAll(r102, new CartCommonRepository$storgeSearchHistoryKey$$inlined$let$lambda$1(r100));
        ListProtector.add(r102, 0, r100);
        if (r102.size() <= 10) goto L11;
        CollectionsKt.removeLastOrNull(r102);
    L11:
        return CollectionsKt.toList(r102);
    L6:
        r102 = new ArrayList();
        goto L7
    }
}
