package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function2 $action$inlined;
    final /* synthetic */ Flow $this_onEmpty$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 0, 1}, l = {115, 123}, m = "collect", n = {"this", "$this$onEmpty_u24lambda_u243", "isEmpty", "collector"}, s = {"L$0", "L$1", "L$2", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 this$0;

        public AnonymousClass1(FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 r1, Continuation r2) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1, kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1<T>] */
    /* JADX WARN: Type inference failed for: r6v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v7, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r8;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L19;
        if (r2 != 2) goto L18;
        boolean r6 = (FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1<T>) ((SafeCollector) r0.L$0);
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L15
        FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1<T> this = r6;
    L30:
        ((SafeCollector) this).releaseIntercepted();
    L34:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Ref.BooleanRef r10 = (Ref.BooleanRef) r0.L$2;
        r7 = (FlowCollector) r0.L$1;
        FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 r3 = (FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1) r0.L$0;
        ResultKt.throwOnFailure(r9);
        ?? r4 = r3;
    L25:
        if (r10.element == false) goto L34;
        SafeCollector r11 = new SafeCollector(r7, r0.getContext());
        Function2 r12 = r4.$action$inlined;     // Catch: Throwable -> L15
        r0.L$0 = r11;     // Catch: Throwable -> L15
        r0.L$1 = null;     // Catch: Throwable -> L15
        r0.L$2 = null;     // Catch: Throwable -> L15
        r0.label = 2;     // Catch: Throwable -> L15
        InlineMarker.mark(6);     // Catch: Throwable -> L15
        Object r13 = r12.invoke(r11, r0);     // Catch: Throwable -> L15
        InlineMarker.mark(7);     // Catch: Throwable -> L15
        this = r11;
        if (r13 != r1) goto L30;
        return r1;
    L20:
        ResultKt.throwOnFailure(r9);
        Ref.BooleanRef r14 = new Ref.BooleanRef();
        r14.element = true;
        Flow r5 = this.$this_onEmpty$inlined;
        FlowKt__EmittersKt$onEmpty$1$1 r15 = new FlowKt__EmittersKt$onEmpty$1$1(r14, r7);
        r0.L$0 = this;
        r0.L$1 = r7;
        r0.L$2 = r14;
        r0.label = 1;
        if (r5.collect(r15, r0) != r1) goto L23;
        return r1;
    L23:
        r4 = this;
        r10 = r14;
    L15:
        th = move-exception;
        this.releaseIntercepted();
        throw th;
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }

    public FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(Flow r1, Function2 r2) {
        this.$this_onEmpty$inlined = r1;
        this.$action$inlined = r2;
    }
}
