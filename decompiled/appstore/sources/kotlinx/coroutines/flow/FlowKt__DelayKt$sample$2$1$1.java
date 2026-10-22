package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lkotlinx/coroutines/channels/f;", "", "result", "", "<anonymous>", "(Lkotlinx/coroutines/channels/f;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,405:1\n514#2,6:406\n530#2,4:412\n534#2:417\n1#3:416\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1\n*L\n287#1:406,6\n288#1:412,4\n288#1:417\n*E\n"})
public final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.f, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    final /* synthetic */ ReceiveChannel<Unit> $ticker;
    /* synthetic */ Object L$0;
    int label;

    public FlowKt__DelayKt$sample$2$1$1(Ref$ObjectRef<Object> r10, ReceiveChannel<Unit> r11, Continuation<? super FlowKt__DelayKt$sample$2$1$1> r12) {
        this.$lastValue = r10;
        this.$ticker = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        FlowKt__DelayKt$sample$2$1$1 r12 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.$ticker, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(kotlinx.coroutines.channels.f r10, Continuation<? super Unit> r11) {
        return m55invokeWpGqRn0(r10.l(), r11);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m55invokeWpGqRn0(@NotNull Object r10, @Nullable Continuation<? super Unit> r11) {
        return ((FlowKt__DelayKt$sample$2$1$1) create(kotlinx.coroutines.channels.f.b(r10), r11)).invokeSuspend(Unit.f21064a);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [T, kotlinx.coroutines.internal.b0] */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) goto L16;
        kotlin.c.b(r10);
        ?? r11 = ((kotlinx.coroutines.channels.f) this.L$0).l();
        Ref$ObjectRef<Object> r12 = this.$lastValue;
        boolean r13 = r11 instanceof kotlinx.coroutines.channels.f.c;
        if (r13 == true) goto L7;
        r12.element = r11;
    L7:
        ReceiveChannel<Unit> r14 = this.$ticker;
        if (r13 == false) goto L14;
        Throwable r15 = kotlinx.coroutines.channels.f.e(r11);
        if (r15 != null) goto L12;
        r14.cancel(new ChildCancelledException());
        r12.element = kotlinx.coroutines.flow.internal.m.f21553c;
        goto L14
    L12:
        throw r15;
    L14:
        return Unit.f21064a;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
