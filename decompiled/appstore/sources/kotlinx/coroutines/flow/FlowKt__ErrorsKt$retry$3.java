package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "cause", "", "attempt", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__ErrorsKt$retry$3 extends SuspendLambda implements Function4<FlowCollector<Object>, Throwable, Long, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function2<Throwable, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ long $retries;
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ErrorsKt$retry$3(long r10, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> r11, Continuation<? super FlowKt__ErrorsKt$retry$3> r12) {
        this.$retries = r10;
        this.$predicate = r11;
        super(4, r12);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<Object> r10, Throwable r11, Long r12, Continuation<? super Boolean> r13) {
        return invoke(r10, r11, r12.longValue(), r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        boolean r13 = true;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        kotlin.c.b(r10);
    L14:
        if (((Boolean) r10).booleanValue() == true) goto L18;
    L16:
        r13 = false;
    L18:
        return tf.a.a(r13);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        Throwable r14 = (Throwable) this.L$0;
        if (this.J$0 >= this.$retries) goto L16;
        Function2<Throwable, Continuation<? super Boolean>, Object> r15 = this.$predicate;
        this.label = 1;
        r10 = r15.mo0invoke(r14, this);
        if (r10 != r11) goto L14;
        return r11;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<Object> r10, @NotNull Throwable r11, long r12, @Nullable Continuation<? super Boolean> r13) {
        FlowKt__ErrorsKt$retry$3 r14 = new FlowKt__ErrorsKt$retry$3(this.$retries, this.$predicate, r13);
        r14.L$0 = r11;
        r14.J$0 = r12;
        return r14.invokeSuspend(Unit.f21064a);
    }
}
