package kotlin.sequences;

import com.bytedanceos.common.ui.widget.SearchChipsView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.y;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlin/sequences/g;", "", "<anonymous>", "(Lkotlin/sequences/g;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {SearchChipsView.BLUE}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
final class SequencesKt__SequencesKt$shuffled$1 extends RestrictedSuspendLambda implements Function2<g, Continuation<? super Unit>, Object> {
    final /* synthetic */ Random $random;
    final /* synthetic */ Sequence<Object> $this_shuffled;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public SequencesKt__SequencesKt$shuffled$1(Sequence<Object> r10, Random r11, Continuation<? super SequencesKt__SequencesKt$shuffled$1> r12) {
        this.$this_shuffled = r10;
        this.$random = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        SequencesKt__SequencesKt$shuffled$1 r12 = new SequencesKt__SequencesKt$shuffled$1(this.$this_shuffled, this.$random, r11);
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
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        List r13 = (List) this.L$1;
        g r14 = (g) this.L$0;
        kotlin.c.b(r10);
    L10:
        if (r13.isEmpty() == true) goto L18;
        int r15 = this.$random.nextInt(r13.size());
        Object r16 = y.D(r13);
        if (r15 >= r13.size()) goto L14;
        r16 = r13.set(r15, r16);
    L14:
        this.L$0 = r14;
        this.L$1 = r13;
        this.label = 1;
        if (r14.a(r16, this) != r11) goto L10;
        return r11;
    L18:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        g r17 = (g) this.L$0;
        r13 = SequencesKt___SequencesKt.x(this.$this_shuffled);
        r14 = r17;
        goto L10
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull g r10, @Nullable Continuation<? super Unit> r11) {
        return ((SequencesKt__SequencesKt$shuffled$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
