package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectImplementation;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Delay.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {221, 426}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
final class FlowKt__DelayKt$debounceInternal$1<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T> $this_debounceInternal;
    final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> r1, Flow<? extends T> r2, Continuation<? super FlowKt__DelayKt$debounceInternal$1> r3) {
        this.$timeoutMillisSelector = r1;
        this.$this_debounceInternal = r2;
        super(3, r3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Object r2, Continuation<? super Unit> r3) {
        return invoke(r1, (FlowCollector) r2, r3);
    }

    public final Object invoke(CoroutineScope r3, FlowCollector<? super T> r4, Continuation<? super Unit> r5) {
        FlowKt__DelayKt$debounceInternal$1 r0 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, r5);
        r0.L$0 = r3;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x011f -> B:7:0x0021). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        Ref.ObjectRef r2 = (Ref.ObjectRef) this.L$2;
        ReceiveChannel r8 = (ReceiveChannel) this.L$1;
        FlowCollector r9 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r15);
    L7:
        FlowCollector r10 = r9;
        ReceiveChannel r11 = r8;
        Ref.ObjectRef r12 = r2;
    L13:
        if (r12.element == NullSurrogateKt.DONE) goto L56;
        Ref.LongRef r3 = new Ref.LongRef();
        if (r12.element == null) goto L33;
        Function1<T, Long> r16 = this.$timeoutMillisSelector;
        Symbol r13 = NullSurrogateKt.NULL;
        T r14 = r12.element;
        if (r14 != r13) goto L19;
        r14 = null;
    L19:
        r3.element = r16.invoke(r14).longValue();
        if (r3.element < 0) goto L22;
        boolean r17 = true;
    L23:
        if (r17 == false) goto L35;
        if (r3.element != 0) goto L33;
        Symbol r18 = NullSurrogateKt.NULL;
        T r19 = r12.element;
        if (r19 != r18) goto L29;
        r19 = null;
    L29:
        this.L$0 = r10;
        this.L$1 = r11;
        this.L$2 = r12;
        this.L$3 = r3;
        this.label = 1;
        if (r10.emit(r19, this) != r0) goto L32;
        return r0;
    L32:
        r12.element = null;
        goto L33
    L35:
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    L22:
        r17 = false;
    L33:
        Ref.LongRef r110 = r3;
        r2 = r12;
        r8 = r11;
        r9 = r10;
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L39;
    L49:
        SelectImplementation r111 = new SelectImplementation(getContext());
        SelectImplementation r112 = r111;
        if (r2.element == null) goto L52;
        OnTimeoutKt.onTimeout(r112, r110.element, new FlowKt__DelayKt$debounceInternal$1$3$1(r9, r2, null));
    L52:
        r112.invoke(r8.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(r2, r9, null));
        this.L$0 = r9;
        this.L$1 = r8;
        this.L$2 = r2;
        this.L$3 = null;
        this.label = 2;
        if (r111.doSelect(this) != r0) goto L7;
        return r0;
    L39:
        if (r2.element != null) goto L41;
    L44:
        boolean r113 = true;
    L45:
        if (r113 == true) goto L49;
        throw new AssertionError();
    L41:
        if (r110.element > 0) goto L44;
        r113 = false;
        goto L45
    L56:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r3 = (Ref.LongRef) this.L$3;
        r12 = (Ref.ObjectRef) this.L$2;
        r11 = (ReceiveChannel) this.L$1;
        r10 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r15);
        goto L32
    L11:
        ResultKt.throwOnFailure(r15);
        CoroutineScope r20 = (CoroutineScope) this.L$0;
        FlowCollector r114 = (FlowCollector) this.L$1;
        ReceiveChannel r4 = ProduceKt.produce$default(r20, null, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, null), 3, null);
        r12 = new Ref.ObjectRef();
        r10 = r114;
        r11 = r4;
        goto L13
    }
}
