package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: Zip.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", i = {}, l = {33, 33}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__ZipKt$combine$1$1<R> extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ZipKt$combine$1$1(Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r1, Continuation<? super FlowKt__ZipKt$combine$1$1> r2) {
        this.$transform = r1;
        super(3, r2);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object[] r2, Continuation<? super Unit> r3) {
        return invoke((FlowCollector) r1, r2, r3);
    }

    public final Object invoke(FlowCollector<? super R> r2, Object[] r3, Continuation<? super Unit> r4) {
        FlowKt__ZipKt$combine$1$1 r0 = new FlowKt__ZipKt$combine$1$1(this.$transform, r4);
        r0.L$0 = r2;
        r0.L$1 = r3;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1<R> for r6v4 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r6.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L7;
        kotlin.ResultKt.throwOnFailure(r7);
    L16:
        kotlin.Unit r6 = kotlin.Unit.INSTANCE;
        return r6;
    L7:
        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r6;
    L9:
        java.lang.Object r1 = r6.L$0;
        kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1;
        kotlin.ResultKt.throwOnFailure(r7);
    L13:
        kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1<R> r3 = r6;
        r6.L$0 = null;
        r6.label = 2;
        java.lang.Object r6 = r1.emit(r7, r3);
        if (r6 != r0) goto L16;
        return r0;
    L10:
        kotlin.ResultKt.throwOnFailure(r7);
        java.lang.Object r7 = r6.L$0;
        r1 = (kotlinx.coroutines.flow.FlowCollector) r7;
        java.lang.Object r7 = r6.L$1;
        java.lang.Object[] r7 = (java.lang.Object[]) r7;
        kotlin.jvm.functions.Function3<T1, T2, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r4 = r6.$transform;
        java.lang.Object r5 = r7[0];
        java.lang.Object r7 = r7[1];
        r6.L$0 = r1;
        r6.label = 1;
        T1 r5 = (T1) r5;
        T2 r7 = (T2) r7;
        java.lang.Object r6 = (kotlin.coroutines.Continuation<? super R>) r6;
        r7 = r4.invoke(r5, r7, r6);
        if (r7 != r0) goto L13;
        return r0;
    }
}
