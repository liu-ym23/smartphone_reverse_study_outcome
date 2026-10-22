package com.bytedance.android.live.recharge.exchange.behavior;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/live/recharge/exchange/behavior/ToolbarTreasureBoxBehavior$onClick$1$1$1", "com/bytedance/android/live/recharge/exchange/behavior/ToolbarTreasureBoxBehavior$$special$$inlined$on$lambda$1"}, k = 3, mv = {1, 5, 1})
final class ToolbarTreasureBoxBehavior$onClick$$inlined$call$lambda$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ View $view$inlined;
    final /* synthetic */ a this$0;

    public ToolbarTreasureBoxBehavior$onClick$$inlined$call$lambda$1(a r100, View r101) {
        this.$view$inlined = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.$view$inlined.getContext();
        int r101 = a.f89792b;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
