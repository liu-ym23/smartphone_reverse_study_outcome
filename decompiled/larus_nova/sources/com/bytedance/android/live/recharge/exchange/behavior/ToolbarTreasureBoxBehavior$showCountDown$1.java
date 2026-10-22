package com.bytedance.android.live.recharge.exchange.behavior;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class ToolbarTreasureBoxBehavior$showCountDown$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $leftTime;
    final /* synthetic */ int $totalTime;
    final /* synthetic */ a this$0;

    public ToolbarTreasureBoxBehavior$showCountDown$1(a r100, int r101, int r102) {
        this.$leftTime = r101;
        this.$totalTime = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$leftTime > 0) goto L5;
    L9:
        int r100 = a.f89792b;
        throw null;
    L5:
        if (this.$totalTime <= 0) goto L9;
        int r101 = a.f89792b;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
