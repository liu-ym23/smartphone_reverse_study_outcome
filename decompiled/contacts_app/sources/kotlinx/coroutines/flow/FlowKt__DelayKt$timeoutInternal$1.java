package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectImplementation;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Delay.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "downStream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1", f = "Delay.kt", i = {0, 0}, l = {424}, m = "invokeSuspend", n = {"downStream", "values"}, s = {"L$0", "L$1"})
final class FlowKt__DelayKt$timeoutInternal$1<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T> $this_timeoutInternal;
    final /* synthetic */ long $timeout;
    long J$0;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$timeoutInternal$1(long r1, Flow<? extends T> r3, Continuation<? super FlowKt__DelayKt$timeoutInternal$1> r4) {
        this.$timeout = r1;
        this.$this_timeoutInternal = r3;
        super(3, r4);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Object r2, Continuation<? super Unit> r3) {
        return invoke(r1, (FlowCollector) r2, r3);
    }

    public final Object invoke(CoroutineScope r4, FlowCollector<? super T> r5, Continuation<? super Unit> r6) {
        FlowKt__DelayKt$timeoutInternal$1 r0 = new FlowKt__DelayKt$timeoutInternal$1(this.$timeout, this.$this_timeoutInternal, r6);
        r0.L$0 = r4;
        r0.L$1 = r5;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x007b -> B:14:0x007e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r4 = this.J$0;
        ReceiveChannel r2 = (ReceiveChannel) this.L$1;
        FlowCollector r6 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r11);
    L15:
        if (((Boolean) r11).booleanValue() == false) goto L17;
    L11:
        SelectImplementation r12 = new SelectImplementation(getContext());
        SelectImplementation r7 = r12;
        r7.invoke(r2.getOnReceiveCatching(), new FlowKt__DelayKt$timeoutInternal$1$1$1(r6, null));
        OnTimeoutKt.m2388onTimeout8Mi8wO0(r7, r4, new FlowKt__DelayKt$timeoutInternal$1$1$2(r4, null));
        this.L$0 = r6;
        this.L$1 = r2;
        this.J$0 = r4;
        this.label = 1;
        r11 = r12.doSelect(this);
        if (r11 != r0) goto L15;
        return r0;
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        FlowCollector r3 = (FlowCollector) this.L$1;
        if (Duration.m2143compareToLRDsOJo(this.$timeout, Duration.Companion.m2247getZEROUwyO8pc()) <= 0) goto L19;
        ReceiveChannel r14 = FlowKt.produceIn(FlowKt.buffer$default(this.$this_timeoutInternal, 0, null, 2, null), r13);
        r4 = this.$timeout;
        r6 = r3;
        r2 = r14;
        goto L11
    L19:
        throw new TimeoutCancellationException("Timed out immediately");
    }
}
