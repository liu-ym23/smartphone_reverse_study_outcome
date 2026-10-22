package com.android.ttcjpaysdk.integrated.counter.outerpay;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class IntegratedOuterPayRooter$rooterMap$4 extends FunctionReferenceImpl implements Function0<Unit> {
    public IntegratedOuterPayRooter$rooterMap$4(Object r100) {
        super(0, r100, IntegratedOuterPayRooter.class, "gotoIntegratedCounterPay", "gotoIntegratedCounterPay()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IntegratedOuterPayRooter.access$gotoIntegratedCounterPay((IntegratedOuterPayRooter) this.receiver);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
