package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"E", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/f;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/f;"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt$trySendBlocking$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f>, Object> {
    final /* synthetic */ Object $element;
    final /* synthetic */ SendChannel<Object> $this_trySendBlocking;
    private /* synthetic */ Object L$0;
    int label;

    public ChannelsKt__ChannelsKt$trySendBlocking$2(SendChannel<Object> r10, Object r11, Continuation<? super ChannelsKt__ChannelsKt$trySendBlocking$2> r12) {
        this.$this_trySendBlocking = r10;
        this.$element = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 r12 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.$this_trySendBlocking, this.$element, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super f> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L11;
        if (r12 != 1) goto L10;
        kotlin.c.b(r10);     // Catch: Throwable -> L7
    L15:
        Object r13 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L7
    L19:
        if (Result.m42isSuccessimpl(r13) == false) goto L21;
        Object r14 = f.f21360b.c(Unit.f21064a);
    L23:
        return f.b(r14);
    L21:
        r14 = f.f21360b.a(Result.m38exceptionOrNullimpl(r13));
        goto L23
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        kotlin.c.b(r10);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        SendChannel<Object> r16 = this.$this_trySendBlocking;
        Object r17 = this.$element;
        Result.a r18 = Result.Companion;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r16.send(r17, this) != r11) goto L15;
        return r11;
    L7:
        th = move-exception;
        Result.a r19 = Result.Companion;
        r13 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L19
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super f> r11) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
