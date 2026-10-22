package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.h1;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0}, l = {126}, m = "invokeSuspend", n = {"second"}, s = {"L$0"})
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $flow;
    final /* synthetic */ Flow<Object> $flow2;
    final /* synthetic */ FlowCollector<Object> $this_unsafeFlow;
    final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $cnt;
        final /* synthetic */ Flow<Object> $flow;
        final /* synthetic */ CoroutineContext $scopeContext;
        final /* synthetic */ ReceiveChannel<Object> $second;
        final /* synthetic */ FlowCollector<Object> $this_unsafeFlow;
        final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1 implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CoroutineContext f21531a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f21532b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ReceiveChannel f21533c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ FlowCollector f21534d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Function3 f21535e;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {}, l = {129, 132, 132}, m = "invokeSuspend", n = {}, s = {})
            @SourceDebugExtension({"SMAP\nCombine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,143:1\n501#2,5:144\n18#3:149\n*S KotlinDebug\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$1$1\n*L\n129#1:144,5\n132#1:149\n*E\n"})
            public static final class C02971 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
                final /* synthetic */ ReceiveChannel<Object> $second;
                final /* synthetic */ FlowCollector<Object> $this_unsafeFlow;
                final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
                final /* synthetic */ Object $value;
                Object L$0;
                int label;

                /* JADX WARN: Multi-variable type inference failed */
                public C02971(ReceiveChannel<? extends Object> r10, FlowCollector<Object> r11, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r12, Object r13, Continuation<? super C02971> r14) {
                    this.$second = r10;
                    this.$this_unsafeFlow = r11;
                    this.$transform = r12;
                    this.$value = r13;
                    super(2, r14);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                    return new C02971(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, r11);
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: invoke */
                public /* bridge */ /* synthetic */ Object mo0invoke(Unit r10, Continuation<? super Unit> r11) {
                    return invoke2(r10, r11);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object r10) {
                    Object r11 = kotlin.coroutines.intrinsics.a.d();
                    int r12 = this.label;
                    if (r12 == 0) goto L12;
                    if (r12 == 1) goto L11;
                    if (r12 == 2) goto L10;
                    if (r12 != 3) goto L9;
                    kotlin.c.b(r10);
                L31:
                    return Unit.f21064a;
                L9:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L10:
                    FlowCollector<Object> r13 = (FlowCollector) this.L$0;
                    kotlin.c.b(r10);
                L27:
                    this.L$0 = null;
                    this.label = 3;
                    if (r13.emit(r10, this) != r11) goto L31;
                    return r11;
                L11:
                    kotlin.c.b(r10);
                    Object r14 = ((kotlinx.coroutines.channels.f) r10).l();
                L15:
                    r13 = this.$this_unsafeFlow;
                    if ((r14 instanceof kotlinx.coroutines.channels.f.c) == false) goto L21;
                    Throwable r15 = kotlinx.coroutines.channels.f.e(r14);
                    if (r15 == null) goto L20;
                    throw r15;
                L20:
                    throw new AbortFlowException(r13);
                L21:
                    Function3<Object, Object, Continuation<Object>, Object> r16 = this.$transform;
                    Object r17 = this.$value;
                    if (r14 != m.f21551a) goto L24;
                    r14 = null;
                L24:
                    this.L$0 = r13;
                    this.label = 2;
                    r10 = r16.invoke(r17, r14, this);
                    if (r10 != r11) goto L27;
                    return r11;
                L12:
                    kotlin.c.b(r10);
                    ReceiveChannel<Object> r18 = this.$second;
                    this.label = 1;
                    r14 = r18.mo51receiveCatchingJP2dKIU(this);
                    if (r14 != r11) goto L15;
                    return r11;
                }

                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(@NotNull Unit r10, @Nullable Continuation<? super Unit> r11) {
                    return ((C02971) create(r10, r11)).invokeSuspend(Unit.f21064a);
                }
            }

            public AnonymousClass1(CoroutineContext r10, Object r11, ReceiveChannel r12, FlowCollector r13, Function3 r14) {
                this.f21531a = r10;
                this.f21532b = r11;
                this.f21533c = r12;
                this.f21534d = r13;
                this.f21535e = r14;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r13, Continuation r14) {
                if ((r14 instanceof CombineKt$zipImpl$1$1$2$1$emit$1) == false) goto L7;
                CombineKt$zipImpl$1$1$2$1$emit$1 r10 = (CombineKt$zipImpl$1$1$2$1$emit$1) r14;
                int r11 = r10.label;
                if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
                r10.label = r11 - Integer.MIN_VALUE;
            L8:
                Object r15 = r10.result;
                Object r12 = kotlin.coroutines.intrinsics.a.d();
                int r16 = r10.label;
                if (r16 == 0) goto L14;
                if (r16 != 1) goto L13;
                kotlin.c.b(r15);
            L18:
                return Unit.f21064a;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                kotlin.c.b(r15);
                CoroutineContext r17 = this.f21531a;
                Unit r18 = Unit.f21064a;
                Object r19 = this.f21532b;
                C02971 r110 = new C02971(this.f21533c, this.f21534d, this.f21535e, r13, null);
                r10.label = 1;
                if (d.c(r17, r18, r19, r110, r10) != r12) goto L18;
                return r12;
            L7:
                r10 = new CombineKt$zipImpl$1$1$2$1$emit$1(this, r14);
                goto L8
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Flow<Object> r10, CoroutineContext r11, Object r12, ReceiveChannel<? extends Object> r13, FlowCollector<Object> r14, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r15, Continuation<? super AnonymousClass2> r16) {
            this.$flow = r10;
            this.$scopeContext = r11;
            this.$cnt = r12;
            this.$second = r13;
            this.$this_unsafeFlow = r14;
            this.$transform = r15;
            super(2, r16);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass2(this.$flow, this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Unit r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            kotlin.c.b(r10);
        L12:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            Flow<Object> r13 = this.$flow;
            AnonymousClass1 r14 = new AnonymousClass1(this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform);
            this.label = 1;
            if (r13.collect(r14, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull Unit r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1(FlowCollector<Object> r10, Flow<Object> r11, Flow<Object> r12, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r13, Continuation<? super CombineKt$zipImpl$1$1> r14) {
        this.$this_unsafeFlow = r10;
        this.$flow2 = r11;
        this.$flow = r12;
        this.$transform = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        CombineKt$zipImpl$1$1 r12 = new CombineKt$zipImpl$1$1(this.$this_unsafeFlow, this.$flow2, this.$flow, this.$transform, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r20) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        ?? r11 = this.label;
        if (r11 == 0) goto L14;
        if (r11 != 1) goto L13;
        ReceiveChannel r12 = (ReceiveChannel) this.L$0;
        kotlin.c.b(r20);     // Catch: Throwable -> L8 AbortFlowException -> L10
        r11 = r12;
    L36:
    L21:
        ReceiveChannel.DefaultImpls.a(r11, null, 1, null);
        return Unit.f21064a;
    L10:
        e = e;
    L30:
        j.a(e, this.$this_unsafeFlow);     // Catch: Throwable -> L8
        r11 = r12;
        goto L36
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r20);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        ReceiveChannel r14 = ProduceKt.d(r13, null, 0, new CombineKt$zipImpl$1$1$second$1(this.$flow2, null), 3, null);
        final CompletableJob r15 = h1.b(null, 1, null);
        kotlin.jvm.internal.q.e(r14, "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
        final FlowCollector<Object> r16 = this.$this_unsafeFlow;
        ((SendChannel) r14).invokeOnClose(new AnonymousClass1(r15, r16));
        CoroutineContext r17 = r13.getCoroutineContext();     // Catch: Throwable -> L26 AbortFlowException -> L28
        Object r18 = ThreadContextKt.b(r17);     // Catch: Throwable -> L26 AbortFlowException -> L28
        CoroutineContext r19 = r13.getCoroutineContext().plus(r15);     // Catch: Throwable -> L26 AbortFlowException -> L28
        Unit r21 = Unit.f21064a;     // Catch: Throwable -> L26 AbortFlowException -> L28
        AnonymousClass2 r22 = new AnonymousClass2(this.$flow, r17, r18, r14, this.$this_unsafeFlow, this.$transform, null);     // Catch: Throwable -> L26 AbortFlowException -> L28
        this.L$0 = r14;     // Catch: Throwable -> L26 AbortFlowException -> L28
        this.label = 1;     // Catch: Throwable -> L26 AbortFlowException -> L28
        ReceiveChannel r110 = r14;
        if (d.d(r19, r21, null, r22, this, 4, null) != r10) goto L20;
        return r10;
    L20:
        r11 = r110;
        goto L21
    L24:
        e = e;
    L25:
        r12 = r110;
    L22:
        th = th;
    L23:
        r11 = r110;
    L34:
        ReceiveChannel.DefaultImpls.a(r11, null, 1, null);
        throw th;
    L28:
        e = e;
        r110 = r14;
    L26:
        th = th;
        r110 = r14;
    L8:
        th = th;
        goto L34
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((CombineKt$zipImpl$1$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
