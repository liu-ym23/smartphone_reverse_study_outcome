package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/android/ec/hybrid/list/entity/ECHybridListItemVO;", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/shopping/mall/feed/ECMallFeed$AbilityInjector$getAbilities$12$mitaCardEngineClassToInstance$1$getItemData$1"}, k = 3, mv = {1, 4, 3})
final class ECMallFeed$AbilityInjector$getAbilities$$inlined$apply$lambda$1$1 extends Lambda implements Function1<ECHybridListItemVO, Boolean> {
    final /* synthetic */ qj.c $cardInfo;

    public ECMallFeed$AbilityInjector$getAbilities$$inlined$apply$lambda$1$1(qj.c r100) {
        this.$cardInfo = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(ECHybridListItemVO r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return Intrinsics.areEqual(r100.f(), this.$cardInfo.f533275b);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ECHybridListItemVO r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
