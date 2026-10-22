package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.model.h1;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class PagingGiftListModelKt {
    public static final k a(k r100, final Function1<? super h1, Boolean> r110, final Function1<? super Long, ? extends h1> r111) {
        Intrinsics.checkNotNullParameter(r100, "$this$toFilterModel");
        Intrinsics.checkNotNullParameter(r110, "filter");
        Intrinsics.checkNotNullParameter(r111, "transform");
        return new k(r100.f130616a, SequencesKt.toMutableList(SequencesKt.filter(CollectionsKt.asSequence(r100.f130617b), new PagingGiftListModelKt$toFilterModel$2(r111, r110))), r100.f130618c, r100.f130619d, SequencesKt.toList(SequencesKt.filter(CollectionsKt.asSequence(r100.f130620e), new PagingGiftListModelKt$toFilterModel$3(r111, r110))));
    }
}
