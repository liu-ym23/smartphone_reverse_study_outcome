package com.bytedance.android.live.v3;

import com.bytedance.android.live.impl.strategy.Strategy;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/impl/strategy/Strategy;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class StrategyManagerV3$init$1 extends FunctionReferenceImpl implements Function1<Strategy, Unit> {
    public StrategyManagerV3$init$1(StrategyManagerV3 r100) {
        super(1, r100, StrategyManagerV3.class, "initSource", "initSource(Lcom/bytedance/android/live/impl/strategy/Strategy;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Strategy r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        StrategyManagerV3 r101 = (StrategyManagerV3) this.receiver;
        Strategy r102 = StrategyManagerV3.f102561a;
        r101.h(r100, false);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Strategy r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
