package com.stepos.ailauncher.chat.view;

import com.stepos.ailauncher.chat.input.controller.InputMotionController;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class BaseInputView$syncRowStateForContent$1 extends FunctionReferenceImpl implements InterfaceC5074l<InterfaceC5063a<? extends Y8.t>, Y8.t> {
    public BaseInputView$syncRowStateForContent$1(Object obj) {
        super(1, obj, InputMotionController.class, "runAtTransitionEnd", "runAtTransitionEnd(Lkotlin/jvm/functions/Function0;)V", 0);
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Y8.t invoke(InterfaceC5063a<? extends Y8.t> interfaceC5063a) {
        l(interfaceC5063a);
        return Y8.t.f7040a;
    }

    public final void l(InterfaceC5063a<Y8.t> p02) {
        kotlin.jvm.internal.p.i(p02, "p0");
        ((InputMotionController) this.receiver).s(p02);
    }
}
