package com.bytedance.android.live.incentive.exchange;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lua0/a;", "", AbsMethodDelegate.TAG_INVOKE, "(Lua0/a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class IncomeExchangeContext$fail$1 extends Lambda implements Function1<ua0.a, Unit> {
    final /* synthetic */ Throwable $throwable;

    public IncomeExchangeContext$fail$1(Throwable r100) {
        this.$throwable = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ua0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        Throwable r101 = this.$throwable;
        Intrinsics.checkNotNullParameter(r100, "$this$setThrowable");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        if ((r101 instanceof ApiServerException) == false) goto L5;
        ApiServerException r102 = (ApiServerException) r101;
        r102.getErrorCode();
        r100.getClass();
        r102.getErrorMsg();
        r100.getClass();
        return;
    L5:
        r100.getClass();
        r101.getMessage();
        r100.getClass();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ua0.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
