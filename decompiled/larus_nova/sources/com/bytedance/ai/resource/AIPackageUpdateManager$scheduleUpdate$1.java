package com.bytedance.ai.resource;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageUpdateManager$scheduleUpdate$1", f = "AIPackageUpdateManager.kt", i = {0, 1}, l = {44, 45}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
final class AIPackageUpdateManager$scheduleUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public AIPackageUpdateManager$scheduleUpdate$1(Continuation<? super AIPackageUpdateManager$scheduleUpdate$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        AIPackageUpdateManager$scheduleUpdate$1 r102 = new AIPackageUpdateManager$scheduleUpdate$1(r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AIPackageUpdateManager$scheduleUpdate$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005a -> B:12:0x0031). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        CoroutineScope r103 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r104 = r103;
    L11:
        AIPackageUpdateManager$scheduleUpdate$1 r105 = this;
    L13:
        if (CoroutineScopeKt.isActive(r104) == false) goto L21;
        AIPackageUpdateManager r106 = AIPackageUpdateManager.f37273a;
        r105.L$0 = r104;
        r105.label = 1;
        if (r106.a(r105) != r101) goto L17;
        return r101;
    L17:
        AIPackageUpdateManager r107 = AIPackageUpdateManager.f37273a;
        long r108 = ((Number) AIPackageUpdateManager.f37275c.getValue()).longValue();
        r105.L$0 = r104;
        r105.label = 2;
        if (DelayKt.delay(r108, r105) != r101) goto L13;
        return r101;
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r109 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r100);
        r104 = r109;
        r105 = this;
        goto L17
    L10:
        ResultKt.throwOnFailure(r100);
        r104 = (CoroutineScope) this.L$0;
        goto L11
    }
}
