package com.bytedance.ai.applet.moa;

import com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/applet/douyinAuth/DouyinGeneralAuthStatusResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaExternalLoginGrantingStep$checkFirstPartyLogin$status$1", f = "MoaExternalLoginGrantingStep.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
public final class MoaExternalLoginGrantingStep$checkFirstPartyLogin$status$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.bytedance.ai.applet.douyinAuth.e>, Object> {
    final /* synthetic */ String $clientKey;
    final /* synthetic */ String $scopes;
    int label;

    public MoaExternalLoginGrantingStep$checkFirstPartyLogin$status$1(String r100, String r101, Continuation<? super MoaExternalLoginGrantingStep$checkFirstPartyLogin$status$1> r102) {
        this.$clientKey = r100;
        this.$scopes = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MoaExternalLoginGrantingStep$checkFirstPartyLogin$status$1(this.$clientKey, this.$scopes, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super com.bytedance.ai.applet.douyinAuth.e> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super com.bytedance.ai.applet.douyinAuth.e> r101) {
        return ((MoaExternalLoginGrantingStep$checkFirstPartyLogin$status$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        DouyinGeneralAuthHelper r103 = DouyinGeneralAuthHelper.f34616a;
        String r104 = this.$clientKey;
        String r105 = this.$scopes;
        this.label = 1;
        r103.getClass();
        r100 = DouyinGeneralAuthHelper.a(r104, r105, "chat", this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
