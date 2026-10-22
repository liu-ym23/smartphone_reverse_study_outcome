package com.bytedance.android.live.incentive.exchange;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lua0/a;", "", AbsMethodDelegate.TAG_INVOKE, "(Lua0/a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class IncomeExchangeContext$succeed$1 extends Lambda implements Function1<ua0.a, Unit> {
    final /* synthetic */ long $addedDiamonds;
    final /* synthetic */ e this$0;

    public IncomeExchangeContext$succeed$1(e r100, long r101) {
        this.this$0 = r100;
        this.$addedDiamonds = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ua0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.f549233a.put("added_diamonds", Long.valueOf(this.$addedDiamonds));
        r100.f549233a.put("scene", 2);
        Map<String, Object> r101 = r100.f549233a;
        this.this$0.getClass();
        r101.put("exchange_scene", 3);
        Map<String, Object> r102 = r100.f549233a;
        this.this$0.getClass();
        r102.put("is_lack_diamond_dialog", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ua0.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
