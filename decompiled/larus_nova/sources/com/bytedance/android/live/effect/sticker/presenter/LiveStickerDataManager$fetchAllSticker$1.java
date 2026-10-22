package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"onSyncStickerSuccess", "", "response", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectChannelResponse;", "cacheType", "Lcom/bytedance/android/live/effect/base/EffectDataFetchCacheType;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class LiveStickerDataManager$fetchAllSticker$1 extends Lambda implements Function2<EffectChannelResponse, EffectDataFetchCacheType, Unit> {
    final /* synthetic */ com.bytedance.android.live.effect.api.k.i $listener;

    public LiveStickerDataManager$fetchAllSticker$1(com.bytedance.android.live.effect.api.k.i r100) {
        this.$listener = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(EffectChannelResponse r100, EffectDataFetchCacheType r101) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Intrinsics.checkNotNullParameter(r101, "cacheType");
        com.bytedance.android.live.effect.api.k.i r102 = this.$listener;
        if (r102 == null) goto L5;
        r102.a(r100);
    L5:
        com.bytedance.android.live.effect.api.k.i r103 = this.$listener;
        if ((r103 instanceof com.bytedance.android.live.effect.api.k.j) == false) goto L9;
        ((com.bytedance.android.live.effect.api.k.j) r103).c(r100, r101);
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(EffectChannelResponse r100, EffectDataFetchCacheType r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
