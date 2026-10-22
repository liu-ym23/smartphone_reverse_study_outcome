package com.bytedance.android.shopping.card_list.eventcenter.event;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.CardList_common.repo.CardListCommonRepository;
import com.bytedance.keva.Keva;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l extends com.bytedance.kmp.ec.yata.event.common.b {
    public l() {
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.b
    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Map<String, Object> r101 = r100.q();
        if (r101 == null) goto L5;
        Object r102 = r101.get("key");
    L7:
        if ((r102 instanceof String) == true) goto L9;
        r102 = null;
    L9:
        String r103 = (String) r102;
        if (r101 == null) goto L12;
        Object r104 = r101.get("value");
    L14:
        if (r103 != null) goto L16;
    L19:
        boolean r105 = true;
    L20:
        if (r105 == false) goto L24;
        int r106 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "key is empty", null, null, 57);
    L24:
        if (Intrinsics.areEqual(r103, "history_words") == false) goto L41;
        Keva r107 = CardListCommonRepository.f164105a;
        if ((r104 instanceof List) == true) goto L28;
        r104 = null;
    L28:
        List r108 = (List) r104;
        if (r108 == null) goto L31;
        List r109 = CollectionsKt.toList(r108);
    L32:
        Keva r110 = CardListCommonRepository.f164105a;
        if (r109 == null) goto L39;
        Object[] r111 = r109.toArray(new String[0]);
        if (r111 == null) goto L38;
        String[] r112 = (String[]) r111;
    L40:
        r110.storeStringArray("search_history", r112);
    L42:
        int r113 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L38:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L39:
        r112 = new String[0];
        goto L40
    L31:
        r109 = null;
        goto L32
    L41:
        Keva r114 = CardListCommonRepository.f164105a;
        Intrinsics.checkNotNullParameter(r103, "key");
        CardListCommonRepository.f164105a.storeString(r103, u0.d(r104));
        goto L42
    L16:
        if (r103.length() == 0) goto L19;
        r105 = false;
        goto L20
    L12:
        r104 = null;
        goto L14
    L5:
        r102 = null;
        goto L7
    }
}
