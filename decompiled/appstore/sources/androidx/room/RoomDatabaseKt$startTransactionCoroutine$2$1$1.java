package androidx.room;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1", f = "RoomDatabaseExt.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
final class RoomDatabaseKt$startTransactionCoroutine$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CancellableContinuation<Object> $continuation;
    final /* synthetic */ RoomDatabase $this_startTransactionCoroutine;
    final /* synthetic */ Function2<CoroutineScope, Continuation<Object>, Object> $transactionBlock;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public RoomDatabaseKt$startTransactionCoroutine$2$1$1(RoomDatabase r10, CancellableContinuation<Object> r11, Function2<? super CoroutineScope, ? super Continuation<Object>, ? extends Object> r12, Continuation<? super RoomDatabaseKt$startTransactionCoroutine$2$1$1> r13) {
        this.$this_startTransactionCoroutine = r10;
        this.$continuation = r11;
        this.$transactionBlock = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        RoomDatabaseKt$startTransactionCoroutine$2$1$1 r12 = new RoomDatabaseKt$startTransactionCoroutine$2$1$1(this.$this_startTransactionCoroutine, this.$continuation, this.$transactionBlock, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        Continuation r13 = (Continuation) this.L$0;
        kotlin.c.b(r10);
    L12:
        r13.resumeWith(Result.m35constructorimpl(r10));
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        CoroutineContext.Element r14 = ((CoroutineScope) this.L$0).getCoroutineContext().get(ContinuationInterceptor.Key);
        kotlin.jvm.internal.q.d(r14);
        RoomDatabase r15 = this.$this_startTransactionCoroutine;
        CoroutineContext r16 = o0.a(r15, (ContinuationInterceptor) r14);
        CancellableContinuation<Object> r17 = this.$continuation;
        Result.a r18 = Result.Companion;
        Function2<CoroutineScope, Continuation<Object>, Object> r19 = this.$transactionBlock;
        this.L$0 = r17;
        this.label = 1;
        r10 = kotlinx.coroutines.h.g(r16, r19, this);
        if (r10 != r11) goto L11;
        return r11;
    L11:
        r13 = r17;
        goto L12
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((RoomDatabaseKt$startTransactionCoroutine$2$1$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
