package com.bytedance.android.live.profit.profitCheck;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ProfitCheckServiceImpl$startCycleClearTask$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ProfitCheckServiceImpl this$0;

    public ProfitCheckServiceImpl$startCycleClearTask$1(ProfitCheckServiceImpl r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        CollectionsKt.removeAll(this.this$0.f88459a, AnonymousClass1.INSTANCE);
        ProfitCheckServiceImpl r100 = this.this$0;
        r100.f88460b.removeCallbacksAndMessages(null);
        r100.f88460b.postDelayed(new b(new ProfitCheckServiceImpl$scheduleNextClearTask$1(r100)), 360000);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
