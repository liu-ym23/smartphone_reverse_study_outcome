package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"onFetchSuccess", "", "rewardEffects", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LiveStickerDataManager$fetchRewardEffectList$1 extends Lambda implements Function1<List<? extends Effect>, Unit> {
    final /* synthetic */ com.bytedance.android.live.effect.api.k.e $listener;

    public LiveStickerDataManager$fetchRewardEffectList$1(com.bytedance.android.live.effect.api.k.e r100) {
        this.$listener = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends Effect> r100) {
        Intrinsics.checkNotNullParameter(r100, "rewardEffects");
        com.bytedance.android.live.effect.api.k.e r101 = this.$listener;
        if (r101 == null) goto L6;
        r101.onFetchSuccess(r100);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Effect> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
