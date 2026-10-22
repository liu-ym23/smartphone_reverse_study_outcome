package kotlin.sequences;

import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"S", "T", "Lkotlin/sequences/g;", "", "<anonymous>", "(Lkotlin/sequences/g;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {2395, 2399}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", SlideCard.KEY_INDEX}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
final class SequencesKt___SequencesKt$runningReduceIndexed$1 extends RestrictedSuspendLambda implements Function2<g, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Integer, Object, Object, Object> $operation;
    final /* synthetic */ Sequence<Object> $this_runningReduceIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$runningReduceIndexed$1(Sequence<Object> r10, Function3<? super Integer, Object, Object, Object> r11, Continuation<? super SequencesKt___SequencesKt$runningReduceIndexed$1> r12) {
        this.$this_runningReduceIndexed = r10;
        this.$operation = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        SequencesKt___SequencesKt$runningReduceIndexed$1 r12 = new SequencesKt___SequencesKt$runningReduceIndexed$1(this.$this_runningReduceIndexed, this.$operation, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(g r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        int r13 = 1;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        int r14 = this.I$0;
        Object r15 = this.L$2;
        Iterator<Object> r16 = (Iterator) this.L$1;
        g r17 = (g) this.L$0;
        kotlin.c.b(r10);
        r13 = r14;
        Object r18 = r15;
    L16:
        if (r16.hasNext() == false) goto L25;
        Function3<Integer, Object, Object, Object> r19 = this.$operation;
        int r20 = r13 + 1;
        if (r13 >= 0) goto L20;
        t.q();
    L20:
        Object r21 = r19.invoke(tf.a.c(r13), r18, r16.next());
        this.L$0 = r17;
        this.L$1 = r16;
        this.L$2 = r21;
        this.I$0 = r20;
        this.label = 2;
        if (r17.a(r21, this) == r11) goto L22;
        r18 = r21;
        r13 = r20;
        goto L16
    L22:
        return r11;
    L25:
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r18 = this.L$2;
        r16 = (Iterator) this.L$1;
        r17 = (g) this.L$0;
        kotlin.c.b(r10);
        goto L16
    L10:
        kotlin.c.b(r10);
        r17 = (g) this.L$0;
        r16 = this.$this_runningReduceIndexed.iterator();
        if (r16.hasNext() == false) goto L25;
        r18 = r16.next();
        this.L$0 = r17;
        this.L$1 = r16;
        this.L$2 = r18;
        this.label = 1;
        if (r17.a(r18, this) != r11) goto L16;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull g r10, @Nullable Continuation<? super Unit> r11) {
        return ((SequencesKt___SequencesKt$runningReduceIndexed$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
