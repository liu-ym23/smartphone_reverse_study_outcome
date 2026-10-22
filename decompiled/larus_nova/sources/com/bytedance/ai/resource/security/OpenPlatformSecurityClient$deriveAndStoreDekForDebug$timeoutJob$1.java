package com.bytedance.ai.resource.security;

import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.security.OpenPlatformSecurityClient$deriveAndStoreDekForDebug$timeoutJob$1", f = "OpenPlatformSecurityClient.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
final class OpenPlatformSecurityClient$deriveAndStoreDekForDebug$timeoutJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $packageName;
    final /* synthetic */ j.a $requestContext;
    final /* synthetic */ long $versionCode;
    int label;

    public OpenPlatformSecurityClient$deriveAndStoreDekForDebug$timeoutJob$1(j.a r100, String r101, long r102, Continuation<? super OpenPlatformSecurityClient$deriveAndStoreDekForDebug$timeoutJob$1> r103) {
        this.$requestContext = r100;
        this.$packageName = r101;
        this.$versionCode = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OpenPlatformSecurityClient$deriveAndStoreDekForDebug$timeoutJob$1(this.$requestContext, this.$packageName, this.$versionCode, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((OpenPlatformSecurityClient$deriveAndStoreDekForDebug$timeoutJob$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        com.bytedance.ai.utils.g.f37637a.e("AIPackageManager", "waiting debug dek timeout");
        j.b r103 = j.f37537b.remove(this.$requestContext.f37539a);
        if (r103 == null) goto L15;
        r103.f37548e.invoke(new TimeoutException("debug DEK decrypt timeout. package=" + this.$packageName + " version=" + this.$versionCode));
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        this.label = 1;
        if (DelayKt.delay(30000, this) != r101) goto L11;
        return r101;
    }
}
