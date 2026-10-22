package com.bytedance.ai.applet.domain;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/bytedance/ai/applet/domain/AppletDomainPolicy;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.domain.AppletDomainPolicyManager$fetchPolicyOnce$newDeferred$1", f = "AppletDomainPolicyManager.kt", i = {}, l = {260}, m = "invokeSuspend", n = {}, s = {})
public final class AppletDomainPolicyManager$fetchPolicyOnce$newDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends a>>, Object> {
    final /* synthetic */ String $appKey;
    final /* synthetic */ String $source;
    int label;

    public AppletDomainPolicyManager$fetchPolicyOnce$newDeferred$1(String r100, String r101, Continuation<? super AppletDomainPolicyManager$fetchPolicyOnce$newDeferred$1> r102) {
        this.$appKey = r100;
        this.$source = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AppletDomainPolicyManager$fetchPolicyOnce$newDeferred$1(this.$appKey, this.$source, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Result<? extends a>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Result<a>> r101) {
        return ((AppletDomainPolicyManager$fetchPolicyOnce$newDeferred$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        AppletDomainPolicyManager r104 = AppletDomainPolicyManager.f34590a;
        String r105 = this.$appKey;
        String r106 = this.$source;
        this.label = 1;
        r103 = AppletDomainPolicyManager.a(r104, r105, r106, this);
        if (r103 != r101) goto L12;
        return r101;
    }
}
