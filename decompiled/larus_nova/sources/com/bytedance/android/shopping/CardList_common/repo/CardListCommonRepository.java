package com.bytedance.android.shopping.CardList_common.repo;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class CardListCommonRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f164105a = null;

    static {
        f164105a = Keva.getRepo("ecom_card_list_common_storage", 1);
    }

    public static List a(final String r100) {
        String[] r101 = f164105a.getStringArray("search_history", new String[0]);
        if (r101 == null) goto L6;
        List r102 = ArraysKt.toMutableList(r101);
        if (r102 == null) goto L6;
    L7:
        CollectionsKt.removeAll(r102, new CardListCommonRepository$storageSearchHistoryKey$$inlined$let$lambda$1(r100));
        ListProtector.add(r102, 0, r100);
        if (r102.size() <= 10) goto L11;
        ListProtector.remove(r102, CollectionsKt.getLastIndex(r102));
    L11:
        return CollectionsKt.toList(r102);
    L6:
        r102 = new ArrayList();
        goto L7
    }
}
