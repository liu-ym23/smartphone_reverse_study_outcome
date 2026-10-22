package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.core.tetris.componentx.schedule.AsyncTaskManager$startAsync$1", f = "AsyncTaskManager.kt", i = {}, l = {55, 58}, m = "invokeSuspend", n = {}, s = {})
final class AsyncTaskManager$startAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $task;
    final /* synthetic */ String $taskName;
    int label;
    final /* synthetic */ AsyncTaskManager this$0;

    public AsyncTaskManager$startAsync$1(AsyncTaskManager r100, String r101, Function1 r102, Continuation r103) {
        this.this$0 = r100;
        this.$taskName = r101;
        this.$task = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new AsyncTaskManager$startAsync$1(this.this$0, this.$taskName, this.$task, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AsyncTaskManager$startAsync$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L14;
        if (r102 == 1) goto L10;
        if (r102 != 2) goto L9;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L12
    L21:
        Map<String, AtomicReference<AsyncTaskManager.a>> r103 = this.this$0.f65533c;     // Catch: Exception -> L12
        LinkedHashMap r104 = (LinkedHashMap) r103;     // Catch: Exception -> L12
        Object r105 = r104.get(this.$taskName);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L12
        ((AtomicReference) r105).set(AsyncTaskManager.a.C1076a.f65537a);     // Catch: Exception -> L12
        Map<String, CountDownLatch> r106 = this.this$0.f65534d;     // Catch: Exception -> L12
        LinkedHashMap r107 = (LinkedHashMap) r106;     // Catch: Exception -> L12
        Object r108 = r107.get(this.$taskName);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r108);     // Catch: Exception -> L12
        ((CountDownLatch) r108).countDown();     // Catch: Exception -> L12
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L12
    L18:
        Function1 r109 = this.$task;     // Catch: Exception -> L12
        this.label = 2;     // Catch: Exception -> L12
        if (r109.invoke(this) != r101) goto L21;
        return r101;
    L14:
        ResultKt.throwOnFailure(r100);
        Map<String, AtomicReference<AsyncTaskManager.a>> r110 = this.this$0.f65533c;     // Catch: Exception -> L12
        LinkedHashMap r111 = (LinkedHashMap) r110;     // Catch: Exception -> L12
        Object r112 = r111.get(this.$taskName);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r112);     // Catch: Exception -> L12
        ((AtomicReference) r112).set(AsyncTaskManager.a.d.f65540a);     // Catch: Exception -> L12
        Map<String, CountDownLatch> r113 = this.this$0.f65535e;     // Catch: Exception -> L12
        LinkedHashMap r114 = (LinkedHashMap) r113;     // Catch: Exception -> L12
        Object r115 = r114.get(this.$taskName);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r115);     // Catch: Exception -> L12
        ((CountDownLatch) r115).countDown();     // Catch: Exception -> L12
        AsyncTaskManager r116 = this.this$0;     // Catch: Exception -> L12
        String r117 = this.$taskName;     // Catch: Exception -> L12
        this.label = 1;     // Catch: Exception -> L12
        if (r116.a(r117, this) != r101) goto L18;
        return r101;
    L12:
        e = move-exception;
        Map<String, AtomicReference<AsyncTaskManager.a>> r118 = this.this$0.f65533c;
        LinkedHashMap r119 = (LinkedHashMap) r118;
        Object r120 = r119.get(this.$taskName);
        Intrinsics.checkNotNull(r120);
        ((AtomicReference) r120).set(new AsyncTaskManager.a.b(e));
        Map<String, CountDownLatch> r121 = this.this$0.f65534d;
        LinkedHashMap r122 = (LinkedHashMap) r121;
        Object r123 = r122.get(this.$taskName);
        Intrinsics.checkNotNull(r123);
        ((CountDownLatch) r123).countDown();
        Map<String, CountDownLatch> r124 = this.this$0.f65535e;
        LinkedHashMap r125 = (LinkedHashMap) r124;
        Object r126 = r125.get(this.$taskName);
        Intrinsics.checkNotNull(r126);
        ((CountDownLatch) r126).countDown();
        throw e;
    }
}
