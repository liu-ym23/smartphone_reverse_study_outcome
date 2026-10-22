package com.android.ttcjpaysdk.base.auth.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class CJPayRealNameAuthFragment$setResponse$1$1$2$onTipClick$1 extends FunctionReferenceImpl implements Function2<Boolean, Boolean, Unit> {
    public CJPayRealNameAuthFragment$setResponse$1$1$2$onTipClick$1(Object r100) {
        super(2, r100, CJPayRealNameAuthFragment.class, "executeTranslateAnimation", "executeTranslateAnimation(ZZ)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, Boolean r101) {
        invoke(r100.booleanValue(), r101.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r100, boolean r101) {
        ((CJPayRealNameAuthFragment) this.receiver).executeTranslateAnimation(r100, r101);
    }
}
