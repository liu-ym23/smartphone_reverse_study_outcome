package com.bytedance.android.live.effect.view;

import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.sticker.PermeateStickerStrategyManager;
import com.bytedance.android.livesdkapi.depend.model.PermeateEffectType;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/effect/sticker/PermeateStickerStrategyManager;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class EffectLivePreviewActivityProxy$permeateStickerStrategyManager$2 extends Lambda implements Function0<PermeateStickerStrategyManager> {
    final /* synthetic */ EffectLivePreviewActivityProxy this$0;

    public EffectLivePreviewActivityProxy$permeateStickerStrategyManager$2(EffectLivePreviewActivityProxy r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PermeateStickerStrategyManager invoke() {
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_PERMEATE_STICKER_STRATEGY_UPGRADE.getValue().booleanValue() == false) goto L5;
        CollectionsKt.listOf(new PermeateEffectType[]{PermeateEffectType.Config, PermeateEffectType.Campaign, PermeateEffectType.Interact, PermeateEffectType.Recommend});
    L6:
        EffectLivePreviewActivityProxy r100 = this.this$0;
        int r101 = EffectLivePreviewActivityProxy.f68885b;
        r100.getClass();
        throw null;
    L5:
        CollectionsKt.listOf(new PermeateEffectType[]{PermeateEffectType.Campaign, PermeateEffectType.Recommend});
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ PermeateStickerStrategyManager invoke() {
        return invoke();
    }
}
