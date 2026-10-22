package com.bytedance.android.live.effect.avadjust;

import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/effect/avadjust/LiveColorAdjustFragment;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LiveAVAdjustFragment$colorAdjustFragment$2 extends Lambda implements Function0<LiveColorAdjustFragment> {
    final /* synthetic */ LiveAVAdjustFragment this$0;

    public LiveAVAdjustFragment$colorAdjustFragment$2(LiveAVAdjustFragment r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final LiveColorAdjustFragment invoke() {
        LiveEffectContextFactoryDelegate$Type r100 = this.this$0.getType();
        this.this$0.getClass();
        return new LiveColorAdjustFragment(r100, null);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ LiveColorAdjustFragment invoke() {
        return invoke();
    }
}
