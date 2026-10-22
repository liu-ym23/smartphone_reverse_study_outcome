package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function4 $predicate$inlined;
    final /* synthetic */ Flow $this_retryWhen$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", f = "Errors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {118, 120}, m = "collect", n = {"this", "$this$retryWhen_u24lambda_u242", "attempt", "shallRetry", "this", "$this$retryWhen_u24lambda_u242", "cause", "attempt"}, s = {"L$0", "L$1", "J$0", "I$0", "L$0", "L$1", "L$2", "J$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 this$0;

        public AnonymousClass1(FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 r1, Continuation r2) {
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

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x007f -> B:31:0x00b1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a0 -> B:27:0x00a3). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r14;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        long r12 = r0.J$0;
        Throwable r3 = (Throwable) r0.L$2;
        FlowCollector<? super T> r5 = (FlowCollector) r0.L$1;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> r6 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L28:
        if (((Boolean) r15).booleanValue() == false) goto L30;
        r12 = r12 + 1;
        int r4 = 1;
    L31:
        long r9 = r12;
        r13 = r5;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> this = r6;
        long r7 = r9;
        if (r4 == 0) goto L34;
    L17:
        Flow r16 = this.$this_retryWhen$inlined;
        r0.L$0 = this;
        r0.L$1 = r13;
        r0.L$2 = null;
        r0.J$0 = r7;
        r4 = 0;
        r0.I$0 = 0;
        r0.label = 1;
        r15 = FlowKt.catchImpl(r16, r13, r0);
        if (r15 != r1) goto L20;
        return r1;
    L20:
        long r10 = r7;
        r6 = this;
        r5 = r13;
        r12 = r10;
    L21:
        Throwable r17 = (Throwable) r15;
        if (r17 == null) goto L31;
        Function4 r8 = r6.$predicate$inlined;
        Long r11 = Boxing.boxLong(r12);
        r0.L$0 = r6;
        r0.L$1 = r5;
        r0.L$2 = r17;
        r0.J$0 = r12;
        r0.label = 2;
        InlineMarker.mark(6);
        Object r18 = r8.invoke(r5, r17, r11, r0);
        InlineMarker.mark(7);
        if (r18 != r1) goto L26;
        return r1;
    L26:
        r3 = r17;
        r15 = r18;
        goto L28
    L34:
        return Unit.INSTANCE;
    L30:
        throw r3;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r19 = r0.I$0;
        long r20 = r0.J$0;
        FlowCollector<? super T> r110 = (FlowCollector) r0.L$1;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> r21 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) r0.L$0;
        ResultKt.throwOnFailure(r15);
        r4 = r19;
        r5 = r110;
        r6 = r21;
        r12 = r20;
        goto L21
    L16:
        ResultKt.throwOnFailure(r15);
        r7 = 0;
    L7:
        r0 = new AnonymousClass1(this, r14);
        goto L8
    }

    public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(Flow r1, Function4 r2) {
        this.$this_retryWhen$inlined = r1;
        this.$predicate$inlined = r2;
    }
}
