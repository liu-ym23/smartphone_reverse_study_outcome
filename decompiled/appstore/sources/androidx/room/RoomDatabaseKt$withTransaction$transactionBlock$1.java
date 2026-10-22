package androidx.room;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.RoomDatabaseKt$withTransaction$transactionBlock$1", f = "RoomDatabaseExt.kt", i = {0}, l = {62}, m = "invokeSuspend", n = {"transactionElement"}, s = {"L$0"})
final class RoomDatabaseKt$withTransaction$transactionBlock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
    final /* synthetic */ Function1<Continuation<Object>, Object> $block;
    final /* synthetic */ RoomDatabase $this_withTransaction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public RoomDatabaseKt$withTransaction$transactionBlock$1(RoomDatabase r10, Function1<? super Continuation<Object>, ? extends Object> r11, Continuation<? super RoomDatabaseKt$withTransaction$transactionBlock$1> r12) {
        this.$this_withTransaction = r10;
        this.$block = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        RoomDatabaseKt$withTransaction$transactionBlock$1 r12 = new RoomDatabaseKt$withTransaction$transactionBlock$1(this.$this_withTransaction, this.$block, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<Object> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L12;
        if (r12 != 1) goto L11;
        w0 r13 = (w0) this.L$0;
        kotlin.c.b(r10);     // Catch: Throwable -> L8
        w0 r14 = r13;
    L18:
        this.$this_withTransaction.D();     // Catch: Throwable -> L8
        this.$this_withTransaction.i();     // Catch: Throwable -> L22
        r14.c();
        return r10;
    L8:
        Throwable th = th;
    L26:
        this.$this_withTransaction.i();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        kotlin.c.b(r10);
        CoroutineContext.Element r15 = ((CoroutineScope) this.L$0).getCoroutineContext().get(w0.f4708c);
        kotlin.jvm.internal.q.d(r15);
        w0 r16 = (w0) r15;
        r16.a();
        this.$this_withTransaction.e();     // Catch: Throwable -> L28
        Function1<Continuation<Object>, Object> r17 = this.$block;     // Catch: Throwable -> L24
        this.L$0 = r16;     // Catch: Throwable -> L24
        this.label = 1;     // Catch: Throwable -> L24
        Object r18 = r17.invoke(this);     // Catch: Throwable -> L24
        if (r18 != r11) goto L17;
        return r11;
    L17:
        r14 = r16;
        r10 = r18;
    L24:
        th = move-exception;
        th = th;
    L28:
        th = th;
    L29:
        r16.c();
        throw th;
    L22:
        th = th;
        r16 = r11;
        goto L29
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<Object> r11) {
        return ((RoomDatabaseKt$withTransaction$transactionBlock$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
