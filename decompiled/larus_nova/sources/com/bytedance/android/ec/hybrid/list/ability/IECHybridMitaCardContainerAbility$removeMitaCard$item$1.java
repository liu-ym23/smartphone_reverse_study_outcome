package com.bytedance.android.ec.hybrid.list.ability;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/i;", "it", "Lkotlin/sequences/Sequence;", "Lcom/bytedance/android/ec/hybrid/list/entity/ECHybridListItemVO;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/ec/hybrid/list/entity/i;)Lkotlin/sequences/Sequence;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class IECHybridMitaCardContainerAbility$removeMitaCard$item$1 extends Lambda implements Function1<com.bytedance.android.ec.hybrid.list.entity.i, Sequence<? extends ECHybridListItemVO>> {
    public static final IECHybridMitaCardContainerAbility$removeMitaCard$item$1 INSTANCE = null;

    static {
        INSTANCE = new IECHybridMitaCardContainerAbility$removeMitaCard$item$1();
    }

    public IECHybridMitaCardContainerAbility$removeMitaCard$item$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Sequence<ECHybridListItemVO> invoke2(com.bytedance.android.ec.hybrid.list.entity.i r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Iterable r101 = r100.f47115i;
        if (r101 != null) goto L6;
        r101 = CollectionsKt.emptyList();
    L6:
        return CollectionsKt.asSequence(r101);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Sequence<? extends ECHybridListItemVO> invoke(com.bytedance.android.ec.hybrid.list.entity.i r100) {
        return invoke2(r100);
    }
}
