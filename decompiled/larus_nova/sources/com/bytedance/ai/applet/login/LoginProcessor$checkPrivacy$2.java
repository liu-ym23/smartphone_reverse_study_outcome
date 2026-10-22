package com.bytedance.ai.applet.login;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.login.LoginProcessor$checkPrivacy$2", f = "LoginProcessor.kt", i = {}, l = {765}, m = "invokeSuspend", n = {}, s = {})
final class LoginProcessor$checkPrivacy$2 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function1<Continuation<? super Boolean>, Object> $request;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public LoginProcessor$checkPrivacy$2(Function1<? super Continuation<? super Boolean>, ? extends Object> r100, Continuation<? super LoginProcessor$checkPrivacy$2> r101) {
        this.$request = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new LoginProcessor$checkPrivacy$2(this.$request, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Boolean> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Boolean> r100) {
        return ((LoginProcessor$checkPrivacy$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Function1<Continuation<? super Boolean>, Object> r103 = this.$request;
        this.label = 1;
        r100 = r103.invoke(this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
