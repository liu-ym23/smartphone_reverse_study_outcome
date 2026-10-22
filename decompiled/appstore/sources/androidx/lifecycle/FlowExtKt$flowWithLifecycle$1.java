package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", i = {0}, l = {91}, m = "invokeSuspend", n = {"$this$callbackFlow"}, s = {"L$0"})
final class FlowExtKt$flowWithLifecycle$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ Flow<Object> $this_flowWithLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProducerScope<Object> $$this$callbackFlow;
        final /* synthetic */ Flow<Object> $this_flowWithLifecycle;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1$a */
        public static final class a implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ProducerScope f3425a;

            public a(ProducerScope r10) {
                this.f3425a = r10;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r10, Continuation r11) {
                Object r12 = this.f3425a.send(r10, r11);
                if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
                return r12;
            L6:
                return Unit.f21064a;
            }
        }

        public AnonymousClass1(Flow<Object> r10, ProducerScope<Object> r11, Continuation<? super AnonymousClass1> r12) {
            this.$this_flowWithLifecycle = r10;
            this.$$this$callbackFlow = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass1(this.$this_flowWithLifecycle, this.$$this$callbackFlow, r11);
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
            Flow<Object> r13 = this.$this_flowWithLifecycle;
            a r14 = new a(this.$$this$callbackFlow);
            this.label = 1;
            if (r13.collect(r14, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public FlowExtKt$flowWithLifecycle$1(Lifecycle r10, Lifecycle.State r11, Flow<Object> r12, Continuation<? super FlowExtKt$flowWithLifecycle$1> r13) {
        this.$lifecycle = r10;
        this.$minActiveState = r11;
        this.$this_flowWithLifecycle = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        FlowExtKt$flowWithLifecycle$1 r12 = new FlowExtKt$flowWithLifecycle$1(this.$lifecycle, this.$minActiveState, this.$this_flowWithLifecycle, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ProducerScope<Object> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ProducerScope r13 = (ProducerScope) this.L$0;
        kotlin.c.b(r10);
    L12:
        SendChannel.a.a(r13, null, 1, null);
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        ProducerScope r14 = (ProducerScope) this.L$0;
        Lifecycle r15 = this.$lifecycle;
        Lifecycle.State r16 = this.$minActiveState;
        AnonymousClass1 r17 = new AnonymousClass1(this.$this_flowWithLifecycle, r14, null);
        this.L$0 = r14;
        this.label = 1;
        if (RepeatOnLifecycleKt.a(r15, r16, r17, this) != r11) goto L11;
        return r11;
    L11:
        r13 = r14;
        goto L12
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<Object> r10, @Nullable Continuation<? super Unit> r11) {
        return ((FlowExtKt$flowWithLifecycle$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
