package com.bytedance.android.live.effect.view;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class EffectLiveBroadcastActivityProxy$initEffect$3 extends Lambda implements Function0<Unit> {
    public static final EffectLiveBroadcastActivityProxy$initEffect$3 INSTANCE = null;

    static {
        INSTANCE = new EffectLiveBroadcastActivityProxy$initEffect$3();
    }

    public EffectLiveBroadcastActivityProxy$initEffect$3() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        List<String> r100 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r().c(d0.f66753c);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
