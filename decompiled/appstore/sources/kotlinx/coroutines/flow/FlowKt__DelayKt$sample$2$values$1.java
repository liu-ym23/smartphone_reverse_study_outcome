package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1", f = "Delay.kt", i = {}, l = {279}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__DelayKt$sample$2$values$1 extends SuspendLambda implements Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_sample;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProducerScope f21438a;

        public AnonymousClass1(ProducerScope r10) {
            this.f21438a = r10;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r10, Continuation r11) {
            if ((r11 instanceof FlowKt__DelayKt$sample$2$values$1$1$emit$1) == false) goto L7;
            FlowKt__DelayKt$sample$2$values$1$1$emit$1 r12 = (FlowKt__DelayKt$sample$2$values$1$1$emit$1) r11;
            int r13 = r12.label;
            if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
            r12.label = r13 - Integer.MIN_VALUE;
        L8:
            Object r14 = r12.result;
            Object r15 = kotlin.coroutines.intrinsics.a.d();
            int r16 = r12.label;
            if (r16 == 0) goto L14;
            if (r16 != 1) goto L13;
            kotlin.c.b(r14);
        L21:
            return Unit.f21064a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            kotlin.c.b(r14);
            ProducerScope r17 = this.f21438a;
            if (r10 != null) goto L17;
            r10 = kotlinx.coroutines.flow.internal.m.f21551a;
        L17:
            r12.label = 1;
            if (r17.send(r10, r12) != r15) goto L21;
            return r15;
        L7:
            r12 = new FlowKt__DelayKt$sample$2$values$1$1$emit$1(this, r11);
            goto L8
        }
    }

    public FlowKt__DelayKt$sample$2$values$1(Flow<Object> r10, Continuation<? super FlowKt__DelayKt$sample$2$values$1> r11) {
        this.$this_sample = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        FlowKt__DelayKt$sample$2$values$1 r12 = new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ProducerScope<? super Object> r10, Continuation<? super Unit> r11) {
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
        ProducerScope r13 = (ProducerScope) this.L$0;
        Flow<Object> r14 = this.$this_sample;
        AnonymousClass1 r15 = new AnonymousClass1(r13);
        this.label = 1;
        if (r14.collect(r15, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<Object> r10, @Nullable Continuation<? super Unit> r11) {
        return ((FlowKt__DelayKt$sample$2$values$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
