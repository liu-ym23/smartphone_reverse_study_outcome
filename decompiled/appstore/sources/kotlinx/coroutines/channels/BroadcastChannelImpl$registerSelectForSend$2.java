package kotlinx.coroutines.channels;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2", f = "BroadcastChannel.kt", i = {}, l = {291}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$registerSelectForSend$2\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,414:1\n15#2:415\n1#3:416\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$registerSelectForSend$2\n*L\n304#1:415\n*E\n"})
final class BroadcastChannelImpl$registerSelectForSend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $element;
    final /* synthetic */ SelectInstance<?> $select;
    int label;
    final /* synthetic */ c this$0;

    public BroadcastChannelImpl$registerSelectForSend$2(c r10, Object r11, SelectInstance<?> r12, Continuation<? super BroadcastChannelImpl$registerSelectForSend$2> r13) {
        this.$element = r11;
        this.$select = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new BroadcastChannelImpl$registerSelectForSend$2(null, this.$element, this.$select, r11);
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
        if (r11 == 0) goto L19;
        if (r11 != 1) goto L18;
        kotlin.c.b(r10);     // Catch: Throwable -> L22
        ReentrantLock r12 = c.Q0(null);
        SelectInstance<?> r13 = this.$select;
        r12.lock();
        HashMap r14 = c.R0(null);     // Catch: Throwable -> L11
        Unit r15 = Unit.f21064a;     // Catch: Throwable -> L11
        r14.put(r13, r15);     // Catch: Throwable -> L11
        q.e(r13, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");     // Catch: Throwable -> L11
        SelectImplementation r16 = (SelectImplementation) r13;     // Catch: Throwable -> L11
        if (((SelectImplementation) r13).s(null, r15) == TrySelectDetailedResult.REREGISTER) goto L13;
        c.R0(null).remove(r13);     // Catch: Throwable -> L11
    L13:
        r12.unlock();
        return r15;
    L11:
        th = move-exception;
        r12.unlock();
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlin.c.b(r10);
        this.label = 1;     // Catch: Throwable -> L22
        throw null;     // Catch: Throwable -> L22
    L22:
        throw null;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((BroadcastChannelImpl$registerSelectForSend$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
