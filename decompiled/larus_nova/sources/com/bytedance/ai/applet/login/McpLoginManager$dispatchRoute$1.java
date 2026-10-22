package com.bytedance.ai.applet.login;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.login.McpLoginManager$dispatchRoute$1", f = "McpLoginManager.kt", i = {}, l = {461, 472}, m = "invokeSuspend", n = {}, s = {})
final class McpLoginManager$dispatchRoute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ b $loginContext;
    int label;

    public McpLoginManager$dispatchRoute$1(b r100, String r101, Continuation<? super McpLoginManager$dispatchRoute$1> r102) {
        this.$loginContext = r100;
        this.$appletId = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new McpLoginManager$dispatchRoute$1(this.$loginContext, this.$appletId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((McpLoginManager$dispatchRoute$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        this.$loginContext.getClass();     // Catch: Exception -> L23
        throw null;     // Catch: Exception -> L23
    L5:
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L23
        if (((Boolean) r100).booleanValue() == false) goto L18;
        p.a(p.f34781a, this.$appletId, o.c.f34779a);     // Catch: Exception -> L23
    L26:
        return Unit.INSTANCE;
    L18:
        p.a(p.f34781a, this.$appletId, o.d.f34780a);     // Catch: Exception -> L23
        goto L26
    L7:
        if (r101 != 2) goto L14;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L23
        if (((Boolean) r100).booleanValue() == false) goto L11;
        com.bytedance.ai.utils.g.f37637a.e("McpLoginManager", "Logic Error: loginType is 0, but user has already agreed to privacy.");     // Catch: Exception -> L23
        p.a(p.f34781a, this.$appletId, new o.b(FinishReason.SUCCESS));     // Catch: Exception -> L23
        goto L26
    L11:
        p.a(p.f34781a, this.$appletId, o.d.f34780a);     // Catch: Exception -> L23
        goto L26
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L23:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("McpLoginManager", "Error during dispatchRoute checkPrivacy", e);
        p.f34781a.getClass();
        goto L26
    }
}
