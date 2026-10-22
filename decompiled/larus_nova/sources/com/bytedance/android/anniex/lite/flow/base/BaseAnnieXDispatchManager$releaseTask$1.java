package com.bytedance.android.anniex.lite.flow.base;

import java.util.Map;
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
import w26.g;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.base.BaseAnnieXDispatchManager$releaseTask$1", f = "BaseAnnieXDispatchManager.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
final class BaseAnnieXDispatchManager$releaseTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ b this$0;

    public BaseAnnieXDispatchManager$releaseTask$1(b r100, Continuation<? super BaseAnnieXDispatchManager$releaseTask$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BaseAnnieXDispatchManager$releaseTask$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BaseAnnieXDispatchManager$releaseTask$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L19:
        this.this$0.e();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Map<String, Map<Class<?>, Object>> r103 = x26.a.f562251a;
        g r104 = (g) x26.a.a(g.class);
        if (r104 == null) goto L15;
        w26.e r105 = (w26.e) r104.n0(w26.e.class);
        if (r105 == null) goto L15;
        Integer r106 = r105.f();
        if (r106 == null) goto L15;
        int r107 = r106.intValue();
    L16:
        this.label = 1;
        if (DelayKt.delay(r107, this) != r101) goto L19;
        return r101;
    L15:
        r107 = 10000;
        goto L16
    }
}
