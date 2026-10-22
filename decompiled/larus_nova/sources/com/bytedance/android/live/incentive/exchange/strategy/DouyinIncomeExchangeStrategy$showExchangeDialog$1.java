package com.bytedance.android.live.incentive.exchange.strategy;

import com.bytedance.android.live.incentive.exchange.l;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class DouyinIncomeExchangeStrategy$showExchangeDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ l $request;
    final /* synthetic */ a this$0;

    public DouyinIncomeExchangeStrategy$showExchangeDialog$1(a r100, l r101) {
        this.this$0 = r100;
        this.$request = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean r100 = true;
        if (com.bytedance.android.live.incentive.exchange.a.a() == 1) goto L7;
        r100 = false;
    L7:
        if (r100 == false) goto L9;
        throw null;
    L9:
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
