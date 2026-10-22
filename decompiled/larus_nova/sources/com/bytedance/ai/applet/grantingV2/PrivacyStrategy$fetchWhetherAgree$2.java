package com.bytedance.ai.applet.grantingV2;

import com.bytedance.ai.bridge.remote.UserAuthService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.grantingV2.PrivacyStrategy$fetchWhetherAgree$2", f = "PrivacyStrategy.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
public final class PrivacyStrategy$fetchWhetherAgree$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ String $versionTag;
    int label;

    public PrivacyStrategy$fetchWhetherAgree$2(String r100, String r101, Continuation<? super PrivacyStrategy$fetchWhetherAgree$2> r102) {
        this.$appletId = r100;
        this.$versionTag = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PrivacyStrategy$fetchWhetherAgree$2(this.$appletId, this.$versionTag, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((PrivacyStrategy$fetchWhetherAgree$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        throw new Exception("Privacy detail is null");
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
