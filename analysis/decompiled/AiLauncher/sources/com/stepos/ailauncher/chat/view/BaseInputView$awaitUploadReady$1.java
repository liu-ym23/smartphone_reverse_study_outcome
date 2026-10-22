package com.stepos.ailauncher.chat.view;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.BaseInputView", f = "BaseInputView.kt", l = {8111}, m = "awaitUploadReady", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BaseInputView$awaitUploadReady$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseInputView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseInputView$awaitUploadReady$1(BaseInputView baseInputView, InterfaceC4014c<? super BaseInputView$awaitUploadReady$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = baseInputView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.U4(0L, this);
    }
}
