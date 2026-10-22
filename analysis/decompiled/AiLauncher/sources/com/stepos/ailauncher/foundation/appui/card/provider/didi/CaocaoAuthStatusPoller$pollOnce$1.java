package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller", f = "CaocaoAuthStatusPoller.kt", l = {131}, m = "pollOnce", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CaocaoAuthStatusPoller$pollOnce$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CaocaoAuthStatusPoller this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaocaoAuthStatusPoller$pollOnce$1(CaocaoAuthStatusPoller caocaoAuthStatusPoller, InterfaceC4014c<? super CaocaoAuthStatusPoller$pollOnce$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = caocaoAuthStatusPoller;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(null, this);
    }
}
