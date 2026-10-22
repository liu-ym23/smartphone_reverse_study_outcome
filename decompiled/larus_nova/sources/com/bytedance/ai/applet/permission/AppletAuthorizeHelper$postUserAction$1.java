package com.bytedance.ai.applet.permission;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.permission.AppletAuthorizeHelper", f = "AppletAuthorizeHelper.kt", i = {0, 0}, l = {358}, m = "postUserAction", n = {"scopeName", "userAction"}, s = {"L$0", "L$1"})
final class AppletAuthorizeHelper$postUserAction$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletAuthorizeHelper this$0;

    public AppletAuthorizeHelper$postUserAction$1(AppletAuthorizeHelper r100, Continuation<? super AppletAuthorizeHelper$postUserAction$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return AppletAuthorizeHelper.b(this.this$0, null, null, this);
    }
}
