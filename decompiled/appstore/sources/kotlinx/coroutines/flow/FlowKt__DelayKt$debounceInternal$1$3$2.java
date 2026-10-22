package kotlinx.coroutines.flow;

import com.bytedance.apm.constant.CommonKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lkotlinx/coroutines/channels/f;", "", CommonKey.KEY_VALUE, "", "<anonymous>", "(Lkotlinx/coroutines/channels/f;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {0}, l = {242}, m = "invokeSuspend", n = {"$this$onFailure_u2dWpGqRn0$iv"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,405:1\n514#2,6:406\n530#2,4:412\n534#2:418\n1#3:416\n18#4:417\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2\n*L\n238#1:406,6\n239#1:412,4\n239#1:418\n242#1:417\n*E\n"})
public final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.f, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector<Object> $downstream;
    final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public FlowKt__DelayKt$debounceInternal$1$3$2(Ref$ObjectRef<Object> r10, FlowCollector<Object> r11, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$2> r12) {
        this.$lastValue = r10;
        this.$downstream = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        FlowKt__DelayKt$debounceInternal$1$3$2 r12 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(kotlinx.coroutines.channels.f r10, Continuation<? super Unit> r11) {
        return m54invokeWpGqRn0(r10.l(), r11);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m54invokeWpGqRn0(@NotNull Object r10, @Nullable Continuation<? super Unit> r11) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(kotlinx.coroutines.channels.f.b(r10), r11)).invokeSuspend(Unit.f21064a);
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [T, kotlinx.coroutines.internal.b0] */
    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        Ref$ObjectRef<Object> r13 = (Ref$ObjectRef) this.L$1;
        kotlin.c.b(r10);
    L24:
        Ref$ObjectRef<Object> r14 = r13;
    L25:
        r14.element = kotlinx.coroutines.flow.internal.m.f21553c;
    L28:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        ?? r15 = ((kotlinx.coroutines.channels.f) this.L$0).l();
        r14 = this.$lastValue;
        boolean r16 = r15 instanceof kotlinx.coroutines.channels.f.c;
        if (r16 == true) goto L11;
        r14.element = r15;
    L11:
        FlowCollector<Object> r17 = this.$downstream;
        if (r16 == false) goto L28;
        Throwable r18 = kotlinx.coroutines.channels.f.e(r15);
        if (r18 != null) goto L26;
        Object r19 = r14.element;
        if (r19 == null) goto L25;
        if (r19 != kotlinx.coroutines.flow.internal.m.f21551a) goto L20;
        r19 = null;
    L20:
        this.L$0 = r15;
        this.L$1 = r14;
        this.label = 1;
        if (r17.emit(r19, this) != r11) goto L23;
        return r11;
    L23:
        r13 = r14;
        goto L24
    L26:
        throw r18;
    }
}
