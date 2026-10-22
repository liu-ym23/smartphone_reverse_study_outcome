package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class PermeateStickerStrategyManager$composerManager$2 extends Lambda implements Function0<ILiveEffectComposerManager> {
    public static final PermeateStickerStrategyManager$composerManager$2 INSTANCE = null;

    static {
        INSTANCE = new PermeateStickerStrategyManager$composerManager$2();
    }

    public PermeateStickerStrategyManager$composerManager$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ILiveEffectComposerManager invoke() {
        List<String> r100 = LiveEffectContext.f66734h;
        return LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ILiveEffectComposerManager invoke() {
        return invoke();
    }
}
