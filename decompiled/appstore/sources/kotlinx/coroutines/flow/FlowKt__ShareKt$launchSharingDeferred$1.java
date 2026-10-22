package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred<StateFlow<Object>> $result;
    final /* synthetic */ Flow<Object> $upstream;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f21471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CoroutineScope f21472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CompletableDeferred f21473c;

        public a(Ref$ObjectRef r10, CoroutineScope r11, CompletableDeferred r12) {
            this.f21471a = r10;
            this.f21472b = r11;
            this.f21473c = r12;
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [T, kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow] */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r10, Continuation r11) {
            MutableStateFlow r12 = (MutableStateFlow) this.f21471a.element;
            if (r12 == null) goto L5;
            r12.setValue(r10);
            Unit r13 = Unit.f21064a;
        L6:
            if (r13 != null) goto L9;
            CoroutineScope r14 = this.f21472b;
            Ref$ObjectRef r15 = this.f21471a;
            CompletableDeferred r16 = this.f21473c;
            ?? r17 = f1.a(r10);
            r16.complete(new z0(r17, kotlinx.coroutines.h1.j(r14.getCoroutineContext())));
            r15.element = r17;
        L9:
            return Unit.f21064a;
        L5:
            r13 = null;
            goto L6
        }
    }

    public FlowKt__ShareKt$launchSharingDeferred$1(Flow<Object> r10, CompletableDeferred<StateFlow<Object>> r11, Continuation<? super FlowKt__ShareKt$launchSharingDeferred$1> r12) {
        this.$upstream = r10;
        this.$result = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        FlowKt__ShareKt$launchSharingDeferred$1 r12 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, this.$result, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object, kotlin.Unit] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L11;
        if (r12 != 1) goto L10;
        kotlin.c.b(r10);     // Catch: Throwable -> L7
    L15:
        FlowKt__ShareKt$launchSharingDeferred$1 this = Unit.f21064a;
        return this;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        kotlin.c.b(r10);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        Ref$ObjectRef r14 = new Ref$ObjectRef();     // Catch: Throwable -> L7
        Flow<Object> r15 = this.$upstream;     // Catch: Throwable -> L7
        a r16 = new a(r14, r13, this.$result);     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r15.collect(r16, this) != r11) goto L15;
        return r11;
    L7:
        th = move-exception;
        this.$result.completeExceptionally(th);
        throw th;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
