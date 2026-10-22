package com.bytedance.ai.applet.login;

import com.bytedance.ai.bridge.remote.UserAuthService;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.login.LoginProcessor$checkPrivacy$request$1", f = "LoginProcessor.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAYER_READ_STATE}, m = "invokeSuspend", n = {}, s = {})
final class LoginProcessor$checkPrivacy$request$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ String $versionTag;
    int label;

    public LoginProcessor$checkPrivacy$request$1(String r100, String r101, Continuation<? super LoginProcessor$checkPrivacy$request$1> r102) {
        this.$appletId = r100;
        this.$versionTag = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new LoginProcessor$checkPrivacy$request$1(this.$appletId, this.$versionTag, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Boolean> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Boolean> r100) {
        return ((LoginProcessor$checkPrivacy$request$1) create(r100)).invokeSuspend(Unit.INSTANCE);
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
        if (Result.m9455isFailureimpl(r103) == false) goto L14;
        Object r104 = null;
    L15:
        Boolean r105 = (Boolean) r104;
        if (r105 != null) goto L18;
        Throwable r106 = Result.m9452exceptionOrNullimpl(r103);
        if (r106 == null) goto L22;
        throw r106;
    L22:
        throw new Exception("check result is null, but no error message");
    L18:
        return Boxing.boxBoolean(r105.booleanValue());
    L14:
        r104 = r103;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        UserAuthService r107 = UserAuthService.f36075a;
        String r108 = this.$appletId;
        String r109 = this.$versionTag;
        this.label = 1;
        r103 = r107.d(r108, r109, this);
        if (r103 != r101) goto L12;
        return r101;
    }
}
