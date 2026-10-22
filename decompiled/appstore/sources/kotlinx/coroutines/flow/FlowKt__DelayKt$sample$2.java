package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectImplementation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {413}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3"})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,405:1\n55#2,8:406\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n*L\n284#1:406,8\n*E\n"})
final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $periodMillis;
    final /* synthetic */ Flow<Object> $this_sample;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public FlowKt__DelayKt$sample$2(long r10, Flow<Object> r11, Continuation<? super FlowKt__DelayKt$sample$2> r12) {
        this.$periodMillis = r10;
        this.$this_sample = r11;
        super(3, r12);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r10, FlowCollector<Object> r11, Continuation<? super Unit> r12) {
        return invoke2(r10, r11, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r14) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ReceiveChannel r12 = (ReceiveChannel) this.L$3;
        Ref$ObjectRef r13 = (Ref$ObjectRef) this.L$2;
        ReceiveChannel r15 = (ReceiveChannel) this.L$1;
        FlowCollector r16 = (FlowCollector) this.L$0;
        kotlin.c.b(r14);
    L10:
        if (r13.element == kotlinx.coroutines.flow.internal.m.f21553c) goto L15;
        SelectImplementation r17 = new SelectImplementation(getContext());
        r17.invoke(r15.getOnReceiveCatching(), new FlowKt__DelayKt$sample$2$1$1(r13, r12, null));
        r17.invoke(r12.getOnReceive(), new FlowKt__DelayKt$sample$2$1$2(r13, r16, null));
        this.L$0 = r16;
        this.L$1 = r15;
        this.L$2 = r13;
        this.L$3 = r12;
        this.label = 1;
        if (r17.j(this) != r10) goto L10;
        return r10;
    L15:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r14);
        CoroutineScope r18 = (CoroutineScope) this.L$0;
        FlowCollector r19 = (FlowCollector) this.L$1;
        ReceiveChannel r110 = ProduceKt.d(r18, null, -1, new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, null), 1, null);
        Ref$ObjectRef r111 = new Ref$ObjectRef();
        ReceiveChannel r112 = c.z(r18, this.$periodMillis, 0, 2, null);
        r16 = r19;
        r15 = r110;
        r13 = r111;
        r12 = r112;
        goto L10
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @NotNull FlowCollector<Object> r11, @Nullable Continuation<? super Unit> r12) {
        FlowKt__DelayKt$sample$2 r13 = new FlowKt__DelayKt$sample$2(this.$periodMillis, this.$this_sample, r12);
        r13.L$0 = r10;
        r13.L$1 = r11;
        return r13.invokeSuspend(Unit.f21064a);
    }
}
