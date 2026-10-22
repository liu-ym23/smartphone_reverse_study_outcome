package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector<Object> $collector;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlowTransformLatest this$0;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1, reason: invalid class name */
    public static final class AnonymousClass1 implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f21524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CoroutineScope f21525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChannelFlowTransformLatest f21526c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FlowCollector f21527d;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ FlowCollector<Object> $collector;
            final /* synthetic */ Object $value;
            int label;
            final /* synthetic */ ChannelFlowTransformLatest this$0;

            public AnonymousClass2(ChannelFlowTransformLatest r10, FlowCollector<Object> r11, Object r12, Continuation<? super AnonymousClass2> r13) {
                this.this$0 = r10;
                this.$collector = r11;
                this.$value = r12;
                super(2, r13);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                return new AnonymousClass2(this.this$0, this.$collector, this.$value, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
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
                Function3 r13 = ChannelFlowTransformLatest.m(this.this$0);
                FlowCollector<Object> r14 = this.$collector;
                Object r15 = this.$value;
                this.label = 1;
                if (r13.invoke(r14, r15, this) != r11) goto L12;
                return r11;
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }
        }

        public AnonymousClass1(Ref$ObjectRef r10, CoroutineScope r11, ChannelFlowTransformLatest r12, FlowCollector r13) {
            this.f21524a = r10;
            this.f21525b = r11;
            this.f21526c = r12;
            this.f21527d = r13;
        }

        /* JADX WARN: Type inference failed for: r6v3, types: [T, kotlinx.coroutines.Job] */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r10, Continuation r11) {
            if ((r11 instanceof ChannelFlowTransformLatest$flowCollect$3$1$emit$1) == false) goto L7;
            ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r12 = (ChannelFlowTransformLatest$flowCollect$3$1$emit$1) r11;
            int r13 = r12.label;
            if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
            r12.label = r13 - Integer.MIN_VALUE;
        L8:
            Object r14 = r12.result;
            Object r15 = kotlin.coroutines.intrinsics.a.d();
            int r16 = r12.label;
            if (r16 == 0) goto L14;
            if (r16 != 1) goto L13;
            Job r17 = (Job) r12.L$2;
            r10 = r12.L$1;
            AnonymousClass1 this = (AnonymousClass1) r12.L$0;
            kotlin.c.b(r14);
        L19:
            Ref$ObjectRef r18 = this.f21524a;
            r18.element = kotlinx.coroutines.h.d(this.f21525b, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(this.f21526c, this.f21527d, r10, null), 1, null);
            return Unit.f21064a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            kotlin.c.b(r14);
            Job r19 = (Job) this.f21524a.element;
            if (r19 == null) goto L19;
            r19.cancel(new ChildCancelledException());
            r12.L$0 = this;
            r12.L$1 = r10;
            r12.L$2 = r19;
            r12.label = 1;
            if (r19.join(r12) != r15) goto L19;
            return r15;
        L7:
            r12 = new ChannelFlowTransformLatest$flowCollect$3$1$emit$1(this, r11);
            goto L8
        }
    }

    public ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest r10, FlowCollector<Object> r11, Continuation<? super ChannelFlowTransformLatest$flowCollect$3> r12) {
        this.this$0 = r10;
        this.$collector = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        ChannelFlowTransformLatest$flowCollect$3 r12 = new ChannelFlowTransformLatest$flowCollect$3(this.this$0, this.$collector, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
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
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        Ref$ObjectRef r14 = new Ref$ObjectRef();
        ChannelFlowTransformLatest r15 = this.this$0;
        Flow r16 = r15.f21522d;
        AnonymousClass1 r17 = new AnonymousClass1(r14, r13, r15, this.$collector);
        this.label = 1;
        if (r16.collect(r17, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((ChannelFlowTransformLatest$flowCollect$3) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
