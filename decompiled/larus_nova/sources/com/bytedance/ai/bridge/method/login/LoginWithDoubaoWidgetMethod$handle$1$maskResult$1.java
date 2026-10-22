package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.bridge.remote.UserAuthService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.login.LoginWithDoubaoWidgetMethod$handle$1$maskResult$1", f = "LoginWithDoubaoWidgetMethod.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
public final class LoginWithDoubaoWidgetMethod$handle$1$maskResult$1 extends SuspendLambda implements Function1<Continuation<? super Result<? extends String>>, Object> {
    final /* synthetic */ String $versionTag;
    int label;

    public LoginWithDoubaoWidgetMethod$handle$1$maskResult$1(String r100, Continuation<? super LoginWithDoubaoWidgetMethod$handle$1$maskResult$1> r101) {
        this.$versionTag = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new LoginWithDoubaoWidgetMethod$handle$1$maskResult$1(this.$versionTag, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Result<? extends String>> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Result<String>> r100) {
        return ((LoginWithDoubaoWidgetMethod$handle$1$maskResult$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
        Object r103 = ((Result) r100).m9458unboximpl();
    L12:
        return Result.m9448boximpl(r103);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        UserAuthService r104 = UserAuthService.f36075a;
        String r105 = this.$versionTag;
        this.label = 1;
        r103 = r104.n(r105, this);
        if (r103 != r101) goto L12;
        return r101;
    }
}
