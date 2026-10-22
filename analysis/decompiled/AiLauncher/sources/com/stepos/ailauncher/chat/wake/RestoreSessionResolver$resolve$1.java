package com.stepos.ailauncher.chat.wake;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.chat.wake.RestoreSessionResolver", f = "RestoreSessionResolver.kt", l = {46}, m = "resolve", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RestoreSessionResolver$resolve$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RestoreSessionResolver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestoreSessionResolver$resolve$1(RestoreSessionResolver restoreSessionResolver, InterfaceC4014c<? super RestoreSessionResolver$resolve$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = restoreSessionResolver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
