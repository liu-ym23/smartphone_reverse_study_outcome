package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ Flow $this_onCompletion$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 1, 2}, l = {115, 122, 129}, m = "collect", n = {"this", "$this$onCompletion_u24lambda_u242", "e", "sc"}, s = {"L$0", "L$1", "L$0", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 this$0;

        public AnonymousClass1(FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.collect(null, this);
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L24;
        if (r2 == 1) goto L21;
        if (r2 == 2) goto L20;
        if (r2 != 3) goto L19;
        SafeCollector r8 = (SafeCollector) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L16
    L33:
        r8.releaseIntercepted();
        return Unit.INSTANCE;
    L16:
        th = th;
    L37:
        r8.releaseIntercepted();
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        Throwable r12 = (Throwable) r0.L$0;
        ResultKt.throwOnFailure(r11);
        throw r12;
    L21:
        r9 = (FlowCollector) r0.L$1;
        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> this = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L39
    L28:
        SafeCollector r13 = new SafeCollector(r9, r0.getContext());
        Function3 r14 = this.$action$inlined;     // Catch: Throwable -> L35
        r0.L$0 = r13;     // Catch: Throwable -> L35
        r0.L$1 = null;     // Catch: Throwable -> L35
        r0.label = 3;     // Catch: Throwable -> L35
        InlineMarker.mark(6);     // Catch: Throwable -> L35
        Object r15 = r14.invoke(r13, null, r0);     // Catch: Throwable -> L35
        InlineMarker.mark(7);     // Catch: Throwable -> L35
        if (r15 != r1) goto L32;
        return r1;
    L32:
        r8 = r13;
    L35:
        th = th;
        r8 = r13;
        goto L37
    L24:
        ResultKt.throwOnFailure(r11);
        Flow r16 = this.$this_onCompletion$inlined;     // Catch: Throwable -> L39
        r0.L$0 = this;     // Catch: Throwable -> L39
        r0.L$1 = r9;     // Catch: Throwable -> L39
        r0.label = 1;     // Catch: Throwable -> L39
        if (r16.collect(r9, r0) != r1) goto L28;
        return r1;
    L39:
        th = move-exception;
        ThrowingCollector r17 = new ThrowingCollector(th);
        Function3 r18 = this.$action$inlined;
        r0.L$0 = th;
        r0.L$1 = null;
        r0.label = 2;
        if (FlowKt__EmittersKt.access$invokeSafely$FlowKt__EmittersKt(r17, r18, th, r0) != r1) goto L50;
        return r1;
    L50:
        throw th;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow r1, Function3 r2) {
        this.$this_onCompletion$inlined = r1;
        this.$action$inlined = r2;
    }
}
