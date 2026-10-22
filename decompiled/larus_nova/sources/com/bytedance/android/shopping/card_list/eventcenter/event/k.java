package com.bytedance.android.shopping.card_list.eventcenter.event;

import android.view.View;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.larus.nova.R;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k extends com.bytedance.kmp.ec.yata.event.common.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CardListObjectContainer f171624a;

    public k(CardListObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        this.f171624a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.b
    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        View r101 = this.f171624a.d(R.id.card_list_sort_panel);
        Map<String, Object> r102 = r100.q();
        if (r102 == null) goto L5;
        Object r103 = r102.get("state");
    L7:
        if (Intrinsics.areEqual(r103, "open") == false) goto L10;
        if (r101 == null) goto L12;
        r101.setVisibility(0);
    L12:
        int r104 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, MapsKt.mapOf(TuplesKt.to("state", r103)), null, 5);
    L10:
        if (r101 == null) goto L12;
        r101.setVisibility(8);
        goto L12
    L5:
        r103 = null;
        goto L7
    }
}
