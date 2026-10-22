package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$LongRef;
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
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {221, 416}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,405:1\n18#2:406\n18#2:408\n1#3:407\n55#4,8:409\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n*L\n218#1:406\n221#1:408\n228#1:409,8\n*E\n"})
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_debounceInternal;
    final /* synthetic */ Function1<Object, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public FlowKt__DelayKt$debounceInternal$1(Function1<Object, Long> r10, Flow<Object> r11, Continuation<? super FlowKt__DelayKt$debounceInternal$1> r12) {
        this.$timeoutMillisSelector = r10;
        this.$this_debounceInternal = r11;
        super(3, r12);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r10, FlowCollector<Object> r11, Continuation<? super Unit> r12) {
        return invoke2(r10, r11, r12);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00e2 -> B:7:0x001e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r15) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L11;
        if (r11 == 1) goto L10;
        if (r11 != 2) goto L9;
        Ref$ObjectRef r12 = (Ref$ObjectRef) this.L$2;
        ReceiveChannel r13 = (ReceiveChannel) this.L$1;
        FlowCollector r14 = (FlowCollector) this.L$0;
        kotlin.c.b(r15);
    L7:
        FlowCollector r16 = r14;
        ReceiveChannel r17 = r13;
        Ref$ObjectRef r18 = r12;
    L13:
        if (r18.element == kotlinx.coroutines.flow.internal.m.f21553c) goto L40;
        Ref$LongRef r19 = new Ref$LongRef();
        Object r110 = r18.element;
        if (r110 == null) goto L30;
        Function1<Object, Long> r20 = this.$timeoutMillisSelector;
        kotlinx.coroutines.internal.b0 r21 = kotlinx.coroutines.flow.internal.m.f21551a;
        if (r110 != r21) goto L19;
        r110 = null;
    L19:
        long r111 = r20.invoke(r110).longValue();
        r19.element = r111;
        if (r111 < 0) goto L32;
        if (r111 != 0) goto L30;
        Object r112 = r18.element;
        if (r112 != r21) goto L26;
        r112 = null;
    L26:
        this.L$0 = r16;
        this.L$1 = r17;
        this.L$2 = r18;
        this.L$3 = r19;
        this.label = 1;
        if (r16.emit(r112, this) != r10) goto L29;
        return r10;
    L29:
        r18.element = null;
        goto L30
    L32:
        throw new IllegalArgumentException("Debounce timeout should not be negative");
    L30:
        Ref$LongRef r113 = r19;
        r12 = r18;
        r13 = r17;
        r14 = r16;
        SelectImplementation r22 = new SelectImplementation(getContext());
        if (r12.element == 0) goto L36;
        kotlinx.coroutines.selects.a.a(r22, r113.element, new FlowKt__DelayKt$debounceInternal$1$3$1(r14, r12, null));
    L36:
        r22.invoke(r13.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(r12, r14, null));
        this.L$0 = r14;
        this.L$1 = r13;
        this.L$2 = r12;
        this.L$3 = null;
        this.label = 2;
        if (r22.j(this) != r10) goto L7;
        return r10;
    L40:
        return Unit.f21064a;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r19 = (Ref$LongRef) this.L$3;
        r18 = (Ref$ObjectRef) this.L$2;
        r17 = (ReceiveChannel) this.L$1;
        r16 = (FlowCollector) this.L$0;
        kotlin.c.b(r15);
        goto L29
    L11:
        kotlin.c.b(r15);
        CoroutineScope r23 = (CoroutineScope) this.L$0;
        FlowCollector r114 = (FlowCollector) this.L$1;
        ReceiveChannel r24 = ProduceKt.d(r23, null, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, null), 3, null);
        r18 = new Ref$ObjectRef();
        r16 = r114;
        r17 = r24;
        goto L13
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @NotNull FlowCollector<Object> r11, @Nullable Continuation<? super Unit> r12) {
        FlowKt__DelayKt$debounceInternal$1 r13 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, r12);
        r13.L$0 = r10;
        r13.L$1 = r11;
        return r13.invokeSuspend(Unit.f21064a);
    }
}
