package kotlinx.coroutines.flow;

import com.bytedance.apm.constant.CommonKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lkotlinx/coroutines/channels/f;", CommonKey.KEY_VALUE, "", "<anonymous>", "(Lkotlinx/coroutines/channels/f;)Z"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", i = {0}, l = {394}, m = "invokeSuspend", n = {"$this$onSuccess_u2dWpGqRn0$iv"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,405:1\n514#2,6:406\n548#2,5:412\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1$1$1\n*L\n393#1:406,6\n395#1:412,5\n*E\n"})
public final class FlowKt__DelayKt$timeoutInternal$1$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.f, Continuation<? super Boolean>, Object> {
    final /* synthetic */ FlowCollector<Object> $downStream;
    /* synthetic */ Object L$0;
    int label;

    public FlowKt__DelayKt$timeoutInternal$1$1$1(FlowCollector<Object> r10, Continuation<? super FlowKt__DelayKt$timeoutInternal$1$1$1> r11) {
        this.$downStream = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        FlowKt__DelayKt$timeoutInternal$1$1$1 r12 = new FlowKt__DelayKt$timeoutInternal$1$1$1(this.$downStream, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(kotlinx.coroutines.channels.f r10, Continuation<? super Boolean> r11) {
        return m56invokeWpGqRn0(r10.l(), r11);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m56invokeWpGqRn0(@NotNull Object r10, @Nullable Continuation<? super Boolean> r11) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$1) create(kotlinx.coroutines.channels.f.b(r10), r11)).invokeSuspend(Unit.f21064a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        Object r13 = this.L$0;
        kotlin.c.b(r10);
    L14:
        Object r14 = r13;
    L16:
        if ((r14 instanceof kotlinx.coroutines.channels.f.a) == false) goto L20;
        kotlinx.coroutines.channels.f.e(r14);
        return tf.a.a(false);
    L20:
        return tf.a.a(true);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        r14 = ((kotlinx.coroutines.channels.f) this.L$0).l();
        FlowCollector<Object> r15 = this.$downStream;
        if ((r14 instanceof kotlinx.coroutines.channels.f.c) == true) goto L16;
        this.L$0 = r14;
        this.label = 1;
        if (r15.emit(r14, this) != r11) goto L13;
        return r11;
    L13:
        r13 = r14;
        goto L14
    }
}
