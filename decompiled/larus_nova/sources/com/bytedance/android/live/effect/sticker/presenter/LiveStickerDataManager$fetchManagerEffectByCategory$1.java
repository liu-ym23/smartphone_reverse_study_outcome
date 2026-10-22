package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"onFetchSuccess", "", "effectList", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "cacheType", "Lcom/bytedance/android/live/effect/base/EffectDataFetchCacheType;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LiveStickerDataManager$fetchManagerEffectByCategory$1 extends Lambda implements Function2<List<? extends Effect>, EffectDataFetchCacheType, Unit> {
    final /* synthetic */ com.bytedance.android.live.effect.api.k.b $listener;

    public LiveStickerDataManager$fetchManagerEffectByCategory$1(com.bytedance.android.live.effect.api.k.b r100) {
        this.$listener = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends Effect> r100, EffectDataFetchCacheType r101) {
        Intrinsics.checkNotNullParameter(r100, "effectList");
        Intrinsics.checkNotNullParameter(r101, "cacheType");
        com.bytedance.android.live.effect.api.k.b r102 = this.$listener;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Effect> r100, EffectDataFetchCacheType r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
