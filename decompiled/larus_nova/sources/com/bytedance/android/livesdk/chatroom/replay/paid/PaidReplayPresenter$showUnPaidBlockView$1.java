package com.bytedance.android.livesdk.chatroom.replay.paid;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PaidReplayPresenter$showUnPaidBlockView$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public PaidReplayPresenter$showUnPaidBlockView$1(PaidReplayPresenter r100) {
        super(0, r100, PaidReplayPresenter.class, "onBlockShow", "onBlockShow()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        PaidReplayPresenter r100 = (PaidReplayPresenter) this.receiver;
        int r101 = PaidReplayPresenter.f109299u;
        a r102 = r100.f();
        if (r102 == null) goto L6;
        r102.a(r100.f109306g);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
