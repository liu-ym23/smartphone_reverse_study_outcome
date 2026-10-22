package com.bytedance.android.shopping.card_list.eventcenter.event;

import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class SelfHandleEventWhenAppearFunction extends com.bytedance.kmp.ec.yata.event.common.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f171581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CardListObjectContainer f171582b;

    public SelfHandleEventWhenAppearFunction(CardListObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        this.f171582b = r100;
        this.f171581a = LazyKt.lazy(new SelfHandleEventWhenAppearFunction$eventHandleComponent$2(this));
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.a
    public final void c(com.bytedance.kmp.ec.yata.event.core.a r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "chainNextCallback");
        if (((com.bytedance.android.shopping.card_list.components.h) this.f171581a.getValue()) != null) goto L6;
        int r102 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r101.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L6:
        com.bytedance.android.shopping.card_list.components.h.g(r100);
        throw null;
    }
}
