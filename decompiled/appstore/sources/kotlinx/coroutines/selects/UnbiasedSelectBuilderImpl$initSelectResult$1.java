package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl$initSelectResult$1", f = "SelectOld.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
final class UnbiasedSelectBuilderImpl$initSelectResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ g this$0;

    public UnbiasedSelectBuilderImpl$initSelectResult$1(g r10, Continuation<? super UnbiasedSelectBuilderImpl$initSelectResult$1> r11) {
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new UnbiasedSelectBuilderImpl$initSelectResult$1(null, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L12;
        if (r11 != 1) goto L11;
        kotlin.c.b(r10);     // Catch: Throwable -> L8
        f.a(g.v(null), r10);
        return Unit.f21064a;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        kotlin.c.b(r10);
        this.label = 1;     // Catch: Throwable -> L8
        throw null;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        f.b(g.v(null), th);
        return Unit.f21064a;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((UnbiasedSelectBuilderImpl$initSelectResult$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
