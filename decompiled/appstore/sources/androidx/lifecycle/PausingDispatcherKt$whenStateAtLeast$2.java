package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", i = {0}, l = {203}, m = "invokeSuspend", n = {"controller"}, s = {"L$0"})
public final class PausingDispatcherKt$whenStateAtLeast$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<Object>, Object> $block;
    final /* synthetic */ Lifecycle.State $minState;
    final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public PausingDispatcherKt$whenStateAtLeast$2(Lifecycle r10, Lifecycle.State r11, Function2<? super CoroutineScope, ? super Continuation<Object>, ? extends Object> r12, Continuation<? super PausingDispatcherKt$whenStateAtLeast$2> r13) {
        this.$this_whenStateAtLeast = r10;
        this.$minState = r11;
        this.$block = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        PausingDispatcherKt$whenStateAtLeast$2 r12 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<Object> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L12;
        if (r12 != 1) goto L11;
        m r13 = (m) this.L$0;
        kotlin.c.b(r10);     // Catch: Throwable -> L8
    L19:
        r13.b();
        return r10;
    L8:
        th = th;
    L23:
        r13.b();
        throw th;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        kotlin.c.b(r10);
        Job r14 = (Job) ((CoroutineScope) this.L$0).getCoroutineContext().get(Job.Key);
        if (r14 == null) goto L26;
        w r15 = new w();
        m r16 = new m(this.$this_whenStateAtLeast, this.$minState, r15.f3578c, r14);
        Function2<CoroutineScope, Continuation<Object>, Object> r17 = this.$block;     // Catch: Throwable -> L21
        this.L$0 = r16;     // Catch: Throwable -> L21
        this.label = 1;     // Catch: Throwable -> L21
        r10 = kotlinx.coroutines.h.g(r15, r17, this);     // Catch: Throwable -> L21
        if (r10 != r11) goto L18;
        return r11;
    L18:
        r13 = r16;
    L21:
        th = th;
        r13 = r16;
        goto L23
    L26:
        throw new IllegalStateException("when[State] methods should have a parent job");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<Object> r11) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
