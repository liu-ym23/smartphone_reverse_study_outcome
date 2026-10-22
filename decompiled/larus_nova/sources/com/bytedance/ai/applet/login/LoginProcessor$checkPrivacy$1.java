package com.bytedance.ai.applet.login;

import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.login.LoginProcessor", f = "LoginProcessor.kt", i = {0, 1}, l = {764, 766}, m = "checkPrivacy", n = {IFlowAppIntentIDL.PARAM_APPLET_ID, IFlowAppIntentIDL.PARAM_APPLET_ID}, s = {"L$0", "L$0"})
final class LoginProcessor$checkPrivacy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginProcessor this$0;

    public LoginProcessor$checkPrivacy$1(LoginProcessor r100, Continuation<? super LoginProcessor$checkPrivacy$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return LoginProcessor.a(this.this$0, null, this);
    }
}
