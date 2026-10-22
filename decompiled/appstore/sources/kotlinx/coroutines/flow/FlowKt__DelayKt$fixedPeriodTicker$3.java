package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3", f = "Delay.kt", i = {0, 1, 2}, l = {313, 315, 316}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
public final class FlowKt__DelayKt$fixedPeriodTicker$3 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ long $initialDelayMillis;
    private /* synthetic */ Object L$0;
    int label;

    public FlowKt__DelayKt$fixedPeriodTicker$3(long r10, long r11, Continuation<? super FlowKt__DelayKt$fixedPeriodTicker$3> r12) {
        this.$initialDelayMillis = r10;
        this.$delayMillis = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        FlowKt__DelayKt$fixedPeriodTicker$3 r12 = new FlowKt__DelayKt$fixedPeriodTicker$3(this.$initialDelayMillis, this.$delayMillis, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ProducerScope<? super Unit> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005a -> B:15:0x003f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L12;
        if (r12 == 1) goto L11;
        if (r12 == 2) goto L10;
        if (r12 == 3) goto L11;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ProducerScope r13 = (ProducerScope) this.L$0;
        kotlin.c.b(r10);
    L18:
        long r14 = this.$delayMillis;
        this.L$0 = r13;
        this.label = 3;
        if (DelayKt.b(r14, this) == r11) goto L20;
    L15:
        SendChannel r15 = r13.getChannel();
        Unit r16 = Unit.f21064a;
        this.L$0 = r13;
        this.label = 2;
        if (r15.send(r16, this) != r11) goto L18;
        return r11;
    L20:
        return r11;
    L11:
        r13 = (ProducerScope) this.L$0;
        kotlin.c.b(r10);
        goto L15
    L12:
        kotlin.c.b(r10);
        r13 = (ProducerScope) this.L$0;
        long r17 = this.$initialDelayMillis;
        this.L$0 = r13;
        this.label = 1;
        if (DelayKt.b(r17, this) != r11) goto L15;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<? super Unit> r10, @Nullable Continuation<? super Unit> r11) {
        return ((FlowKt__DelayKt$fixedPeriodTicker$3) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
