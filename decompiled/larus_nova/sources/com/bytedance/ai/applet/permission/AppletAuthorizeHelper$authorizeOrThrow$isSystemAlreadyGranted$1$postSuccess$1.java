package com.bytedance.ai.applet.permission;

import com.bytedance.ai.applet.granting.GrantingAction;
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
@DebugMetadata(c = "com.bytedance.ai.applet.permission.AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$postSuccess$1", f = "AppletAuthorizeHelper.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
public final class AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$postSuccess$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $scopeName;
    final /* synthetic */ GrantingAction $userAction;
    int label;
    final /* synthetic */ AppletAuthorizeHelper this$0;

    public AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$postSuccess$1(AppletAuthorizeHelper r100, String r101, GrantingAction r102, Continuation<? super AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$postSuccess$1> r103) {
        this.this$0 = r100;
        this.$scopeName = r101;
        this.$userAction = r102;
        super(1, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$postSuccess$1(this.this$0, this.$scopeName, this.$userAction, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Boolean> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Boolean> r100) {
        return ((AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$postSuccess$1) create(r100)).invokeSuspend(Unit.INSTANCE);
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
        AppletAuthorizeHelper r103 = this.this$0;
        String r104 = this.$scopeName;
        GrantingAction r105 = this.$userAction;
        this.label = 1;
        r100 = AppletAuthorizeHelper.b(r103, r104, r105, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
