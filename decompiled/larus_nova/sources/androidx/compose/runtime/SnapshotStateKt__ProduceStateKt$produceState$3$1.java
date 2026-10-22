package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$3$1", f = "ProduceState.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {})
public final class SnapshotStateKt__ProduceStateKt$produceState$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<ProduceStateScope<T>, Continuation<? super Unit>, Object> $producer;
    final /* synthetic */ MutableState<T> $result;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateKt__ProduceStateKt$produceState$3$1(Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r100, MutableState<T> r101, Continuation<? super SnapshotStateKt__ProduceStateKt$produceState$3$1> r102) {
        this.$producer = r100;
        this.$result = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        SnapshotStateKt__ProduceStateKt$produceState$3$1 r102 = new SnapshotStateKt__ProduceStateKt$produceState$3$1(this.$producer, this.$result, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SnapshotStateKt__ProduceStateKt$produceState$3$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$3$1 for r5v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r5.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        kotlin.ResultKt.throwOnFailure(r6);
    L11:
        kotlin.Unit r6 = kotlin.Unit.INSTANCE;
        return r6;
    L6:
        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r6;
    L8:
        kotlin.ResultKt.throwOnFailure(r6);
        java.lang.Object r6 = r5.L$0;
        kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6;
        kotlin.jvm.functions.Function2<androidx.compose.runtime.ProduceStateScope<T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r5.$producer;
        androidx.compose.runtime.MutableState<T> r4 = r5.$result;
        kotlin.coroutines.CoroutineContext r6 = r6.getCoroutineContext();
        androidx.compose.runtime.ProduceStateScopeImpl r3 = new androidx.compose.runtime.ProduceStateScopeImpl(r4, r6);
        r5.label = 1;
        androidx.compose.runtime.ProduceStateScopeImpl r3 = r3;
        java.lang.Object r5 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r5;
        java.lang.Object r6 = r1.invoke(r3, r5);
        if (r6 != r0) goto L11;
        return r0;
    }
}
