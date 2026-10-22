package com.bytedance.android.live.incentive.exchange;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/incentive/exchange/f;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/incentive/exchange/f;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class IncomeExchangeResultAdapter$2 extends FunctionReferenceImpl implements Function1<f, Unit> {
    public IncomeExchangeResultAdapter$2(g r100) {
        super(1, r100, g.class, "onResult", "onResult(Lcom/bytedance/android/live/incentive/exchange/IncomeExchangeResult;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((g) this.receiver).getClass();
        int r101 = r100.f69351b;
        boolean r102 = false;
        if (r101 != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        throw null;
    L9:
        if (r101 != 2) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L20;
        if (r101 != 1) goto L15;
        r102 = true;
    L15:
        if (r102 == false) goto L18;
        int r105 = r100.f69354e;
        new ApiServerException(r105).setErrorMsg(r100.f69355f);
        throw null;
    L18:
        new IllegalArgumentException("unknown income exchange result " + r100.f69351b);
        throw null;
    L20:
        throw null;
    L11:
        r104 = false;
        goto L12
    L5:
        r103 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(f r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
