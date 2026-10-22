package com.bytedance.android.latch.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
public /* synthetic */ class BaseLatchProcess$lynxModuleCreation$1$1$params$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public BaseLatchProcess$lynxModuleCreation$1$1$params$1(Object r100) {
        super(0, r100, BaseLatchProcess.class, "onJsbCall", "onJsbCall()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((BaseLatchProcess) this.receiver).f58233o.set(true);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
