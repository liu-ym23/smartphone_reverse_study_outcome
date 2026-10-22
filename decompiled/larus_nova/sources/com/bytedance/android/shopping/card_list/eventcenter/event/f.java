package com.bytedance.android.shopping.card_list.eventcenter.event;

import com.bytedance.android.shopping.CardList_common.repo.CardListCommonRepository;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements com.bytedance.kmp.ec.yata.event.common.j {
    public f() {
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.j
    public final Map<String, Object> a(List<? extends com.bytedance.kmp.ec.yata.store.node.c> r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeList");
        Intrinsics.checkNotNullParameter(r101, "params");
        Object r102 = r101.get("current_word");
        if ((r102 instanceof String) == true) goto L5;
        r102 = null;
    L5:
        String r103 = (String) r102;
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        return MapsKt.mapOf(TuplesKt.to("new_history_words", CardListCommonRepository.a(r103)));
    }
}
