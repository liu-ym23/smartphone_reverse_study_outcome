package com.bytedance.ai.bridge.method.login;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.login.LoginMethod", f = "LoginMethod.kt", i = {0}, l = {170, 177}, m = "fetchLoginCode-Kx4hsE0", n = {"timeout"}, s = {"L$0"})
final class LoginMethod$fetchLoginCode$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginMethod this$0;

    public LoginMethod$fetchLoginCode$1(LoginMethod r100, Continuation<? super LoginMethod$fetchLoginCode$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return LoginMethod.b(this.this$0, null, null, this);
    }
}
