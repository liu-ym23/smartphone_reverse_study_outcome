package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: compiled from: Transform.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class FlowKt__TransformKt$runningReduce$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef<Object> $accumulator;
    final /* synthetic */ Function3<T, T, Continuation<? super T>, Object> $operation;
    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__TransformKt$runningReduce$1$1(Ref.ObjectRef<Object> r1, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> r2, FlowCollector<? super T> r3) {
        this.$accumulator = r1;
        this.$operation = r2;
        this.$this_unsafeFlow = r3;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof FlowKt__TransformKt$runningReduce$1$1$emit$1) == false) goto L7;
        FlowKt__TransformKt$runningReduce$1$1$emit$1 r0 = (FlowKt__TransformKt$runningReduce$1$1$emit$1) r9;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r10);
    L28:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Ref.ObjectRef<Object> r7 = (Ref.ObjectRef) r0.L$1;
        FlowKt__TransformKt$runningReduce$1$1<T> r11 = (FlowKt__TransformKt$runningReduce$1$1) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L23:
        Object r6 = r10;
        Ref.ObjectRef<Object> r12 = r7;
        FlowKt__TransformKt$runningReduce$1$1<T> this = r11;
        r8 = (T) r6;
    L24:
        r12.element = r8;
        FlowCollector<T> r13 = this.$this_unsafeFlow;
        T r14 = this.$accumulator.element;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        if (r13.emit(r14, r0) != r1) goto L28;
        return r1;
    L16:
        ResultKt.throwOnFailure(r10);
        r12 = this.$accumulator;
        if (r12.element == NullSurrogateKt.NULL) goto L24;
        Function3<T, T, Continuation<? super T>, Object> r3 = this.$operation;
        T r5 = this.$accumulator.element;
        r0.L$0 = this;
        r0.L$1 = r12;
        r0.label = 1;
        Object r15 = r3.invoke(r5, r8, r0);
        if (r15 != r1) goto L22;
        return r1;
    L22:
        r11 = this;
        r7 = r12;
        r10 = r15;
    L7:
        r0 = new FlowKt__TransformKt$runningReduce$1$1$emit$1(this, r9);
        goto L8
    }
}
