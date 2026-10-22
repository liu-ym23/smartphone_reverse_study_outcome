package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/sequences/g;", "Ljava/lang/StackTraceElement;", "", "<anonymous>", "(Lkotlin/sequences/g;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1", f = "DebugCoroutineInfoImpl.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
final class DebugCoroutineInfoImpl$creationStackTrace$1 extends RestrictedSuspendLambda implements Function2<g, Continuation<? super Unit>, Object> {
    final /* synthetic */ f $bottom;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ b this$0;

    public DebugCoroutineInfoImpl$creationStackTrace$1(b r10, f r11, Continuation<? super DebugCoroutineInfoImpl$creationStackTrace$1> r12) {
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        DebugCoroutineInfoImpl$creationStackTrace$1 r12 = new DebugCoroutineInfoImpl$creationStackTrace$1(null, null, r11);
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
        kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 != 0) goto L5;
        kotlin.c.b(r10);
        g r12 = (g) this.L$0;
        throw null;
    L5:
        if (r11 != 1) goto L9;
        kotlin.c.b(r10);
        return Unit.f21064a;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull g r10, @Nullable Continuation<? super Unit> r11) {
        return ((DebugCoroutineInfoImpl$creationStackTrace$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
