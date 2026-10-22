package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectImplementation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downStream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1", f = "Delay.kt", i = {0, 0}, l = {414}, m = "invokeSuspend", n = {"downStream", "values"}, s = {"L$0", "L$1"})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1\n+ 2 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n+ 3 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,405:1\n31#2:406\n32#2:415\n55#3,8:407\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1\n*L\n391#1:406\n391#1:415\n391#1:407,8\n*E\n"})
final class FlowKt__DelayKt$timeoutInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_timeoutInternal;
    final /* synthetic */ long $timeout;
    long J$0;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public FlowKt__DelayKt$timeoutInternal$1(long r10, Flow<Object> r11, Continuation<? super FlowKt__DelayKt$timeoutInternal$1> r12) {
        this.$timeout = r10;
        this.$this_timeoutInternal = r11;
        super(3, r12);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r10, FlowCollector<Object> r11, Continuation<? super Unit> r12) {
        return invoke2(r10, r11, r12);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0074 -> B:14:0x0077). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        long r13 = this.J$0;
        ReceiveChannel r14 = (ReceiveChannel) this.L$1;
        FlowCollector r15 = (FlowCollector) this.L$0;
        kotlin.c.b(r10);
    L15:
        if (((Boolean) r10).booleanValue() == false) goto L17;
    L11:
        SelectImplementation r16 = new SelectImplementation(getContext());
        r16.invoke(r14.getOnReceiveCatching(), new FlowKt__DelayKt$timeoutInternal$1$1$1(r15, null));
        kotlinx.coroutines.selects.a.b(r16, r13, new FlowKt__DelayKt$timeoutInternal$1$1$2(r13, null));
        this.L$0 = r15;
        this.L$1 = r14;
        this.J$0 = r13;
        this.label = 1;
        r10 = r16.j(this);
        if (r10 != r11) goto L15;
        return r11;
    L17:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        CoroutineScope r17 = (CoroutineScope) this.L$0;
        FlowCollector r18 = (FlowCollector) this.L$1;
        if (kotlin.time.b.c(this.$timeout, kotlin.time.b.f21273a.a()) <= 0) goto L19;
        ReceiveChannel r19 = c.M(c.d(this.$this_timeoutInternal, 0, null, 2, null), r17);
        r13 = this.$timeout;
        r15 = r18;
        r14 = r19;
        goto L11
    L19:
        throw new TimeoutCancellationException("Timed out immediately");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @NotNull FlowCollector<Object> r11, @Nullable Continuation<? super Unit> r12) {
        FlowKt__DelayKt$timeoutInternal$1 r13 = new FlowKt__DelayKt$timeoutInternal$1(this.$timeout, this.$this_timeoutInternal, r12);
        r13.L$0 = r10;
        r13.L$1 = r11;
        return r13.invokeSuspend(Unit.f21064a);
    }
}
