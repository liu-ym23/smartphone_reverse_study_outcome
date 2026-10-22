package com.bytedance.android.live.profit.profitCheck;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ProfitCheckServiceImpl$scheduleNextClearTask$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public ProfitCheckServiceImpl$scheduleNextClearTask$1(ProfitCheckServiceImpl r100) {
        super(0, r100, ProfitCheckServiceImpl.class, "startCycleClearTask", "startCycleClearTask()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ProfitCheckServiceImpl r100 = (ProfitCheckServiceImpl) this.receiver;
        int r101 = ProfitCheckServiceImpl.f88458h;
        r100.getClass();
        ProfitCheckServiceImpl$startCycleClearTask$1 r102 = new ProfitCheckServiceImpl$startCycleClearTask$1(r100);
        r100.f88461c.onNext(r102);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
