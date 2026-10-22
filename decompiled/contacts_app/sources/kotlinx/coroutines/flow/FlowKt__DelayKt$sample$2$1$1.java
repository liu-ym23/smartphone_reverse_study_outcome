package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: compiled from: Delay.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "result", "Lkotlinx/coroutines/channels/ChannelResult;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    final /* synthetic */ ReceiveChannel<Unit> $ticker;
    /* synthetic */ Object L$0;
    int label;

    FlowKt__DelayKt$sample$2$1$1(Ref.ObjectRef<Object> r1, ReceiveChannel<Unit> r2, Continuation<? super FlowKt__DelayKt$sample$2$1$1> r3) {
        this.$lastValue = r1;
        this.$ticker = r2;
        super(2, r3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FlowKt__DelayKt$sample$2$1$1 r0 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.$ticker, r4);
        r0.L$0 = r3;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ChannelResult<? extends Object> r1, Continuation<? super Unit> r2) {
        return m2359invokeWpGqRn0(r1.m2343unboximpl(), r2);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m2359invokeWpGqRn0(Object r1, Continuation<? super Unit> r2) {
        return ((FlowKt__DelayKt$sample$2$1$1) create(ChannelResult.m2331boximpl(r1), r2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8, types: [T, kotlinx.coroutines.internal.Symbol] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r3);
        ?? r4 = ((ChannelResult) this.L$0).m2343unboximpl();
        Ref.ObjectRef<Object> r0 = this.$lastValue;
        boolean r1 = r4 instanceof ChannelResult.Failed;
        if (r1 == true) goto L7;
        r0.element = r4;
    L7:
        ReceiveChannel<Unit> r2 = this.$ticker;
        Ref.ObjectRef<Object> r5 = this.$lastValue;
        if (r1 == false) goto L14;
        Throwable r6 = ChannelResult.m2335exceptionOrNullimpl(r4);
        if (r6 != null) goto L12;
        r2.cancel(new ChildCancelledException());
        r5.element = NullSurrogateKt.DONE;
        goto L14
    L12:
        throw r6;
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
