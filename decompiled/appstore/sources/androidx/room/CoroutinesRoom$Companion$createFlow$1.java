package androidx.room;

import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\r\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/jvm/JvmSuppressWildcards;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
public final class CoroutinesRoom$Companion$createFlow$1 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Callable<Object> $callable;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ String[] $tableNames;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowCollector<Object> $$this$flow;
        final /* synthetic */ Callable<Object> $callable;
        final /* synthetic */ RoomDatabase $db;
        final /* synthetic */ boolean $inTransaction;
        final /* synthetic */ String[] $tableNames;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", f = "CoroutinesRoom.kt", i = {}, l = {128, 130}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Callable<Object> $callable;
            final /* synthetic */ RoomDatabase $db;
            final /* synthetic */ a $observer;
            final /* synthetic */ Channel<Unit> $observerChannel;
            final /* synthetic */ Channel<Object> $resultChannel;
            Object L$0;
            int label;

            public C00441(RoomDatabase r10, a r11, Channel r12, Callable r13, Channel r14, Continuation r15) {
                this.$db = r10;
                this.$observer = r11;
                this.$observerChannel = r12;
                this.$callable = r13;
                this.$resultChannel = r14;
                super(2, r15);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                return new C00441(this.$db, this.$observer, this.$observerChannel, this.$callable, this.$resultChannel, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
                return invoke2(r10, r11);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0066 -> B:8:0x0015). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r10) {
                Object r11 = kotlin.coroutines.intrinsics.a.d();
                int r12 = this.label;
                if (r12 == 0) goto L16;
                if (r12 == 1) goto L13;
                if (r12 != 2) goto L12;
                ChannelIterator<Unit> r13 = (ChannelIterator) this.L$0;
                kotlin.c.b(r10);     // Catch: Throwable -> L9
            L8:
                ChannelIterator<Unit> r14 = r13;
            L18:
                this.L$0 = r14;     // Catch: Throwable -> L9
                this.label = 1;     // Catch: Throwable -> L9
                Object r15 = r14.hasNext(this);     // Catch: Throwable -> L9
                if (r15 != r11) goto L21;
                return r11;
            L21:
                r13 = r14;
                r10 = r15;
            L23:
                if (((Boolean) r10).booleanValue() == false) goto L27;
                r13.next();     // Catch: Throwable -> L9
                Object r16 = this.$callable.call();     // Catch: Throwable -> L9
                Channel<Object> r17 = this.$resultChannel;     // Catch: Throwable -> L9
                this.L$0 = r13;     // Catch: Throwable -> L9
                this.label = 2;     // Catch: Throwable -> L9
                if (r17.send(r16, this) != r11) goto L8;
                return r11;
            L27:
                this.$db.m().p(this.$observer);
                return Unit.f21064a;
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L13:
                r13 = (ChannelIterator) this.L$0;
                kotlin.c.b(r10);     // Catch: Throwable -> L9
                goto L23
            L16:
                kotlin.c.b(r10);
                this.$db.m().c(this.$observer);
                r14 = this.$observerChannel.iterator();     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                this.$db.m().p(this.$observer);
                throw th;
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((C00441) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }
        }

        /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$a */
        public static final class a extends m.c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Channel f4447b;

            public a(String[] r10, Channel r11) {
                this.f4447b = r11;
                super(r10);
            }

            @Override // androidx.room.m.c
            public void c(Set r10) {
                this.f4447b.mo53trySendJP2dKIU(Unit.f21064a);
            }
        }

        public AnonymousClass1(boolean r10, RoomDatabase r11, FlowCollector<Object> r12, String[] r13, Callable<Object> r14, Continuation<? super AnonymousClass1> r15) {
            this.$inTransaction = r10;
            this.$db = r11;
            this.$$this$flow = r12;
            this.$tableNames = r13;
            this.$callable = r14;
            super(2, r15);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.$inTransaction, this.$db, this.$$this$flow, this.$tableNames, this.$callable, r11);
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
        public final Object invokeSuspend(@NotNull Object r14) {
            Object r10 = kotlin.coroutines.intrinsics.a.d();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            kotlin.c.b(r14);
        L20:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r14);
            CoroutineScope r12 = (CoroutineScope) this.L$0;
            Channel r13 = kotlinx.coroutines.channels.e.b(-1, null, null, 6, null);
            a r15 = new a(this.$tableNames, r13);
            r13.mo53trySendJP2dKIU(Unit.f21064a);
            w0 r16 = (w0) r12.getCoroutineContext().get(w0.f4708c);
            if (r16 == null) goto L13;
            ContinuationInterceptor r17 = r16.b();
            if (r17 == null) goto L13;
        L16:
            Channel r18 = kotlinx.coroutines.channels.e.b(0, null, null, 7, null);
            ContinuationInterceptor r19 = r17;
            kotlinx.coroutines.h.d(r12, r19, null, new C00441(this.$db, r15, r13, this.$callable, r18, null), 2, null);
            FlowCollector<Object> r110 = this.$$this$flow;
            this.label = 1;
            if (kotlinx.coroutines.flow.c.q(r110, r18, this) != r10) goto L20;
            return r10;
        L13:
            if (this.$inTransaction == false) goto L15;
            r17 = g.b(this.$db);
            goto L16
        L15:
            r17 = g.a(this.$db);
            goto L16
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public CoroutinesRoom$Companion$createFlow$1(boolean r10, RoomDatabase r11, String[] r12, Callable<Object> r13, Continuation<? super CoroutinesRoom$Companion$createFlow$1> r14) {
        this.$inTransaction = r10;
        this.$db = r11;
        this.$tableNames = r12;
        this.$callable = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        CoroutinesRoom$Companion$createFlow$1 r12 = new CoroutinesRoom$Companion$createFlow$1(this.$inTransaction, this.$db, this.$tableNames, this.$callable, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(FlowCollector<Object> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r11) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        kotlin.c.b(r11);
    L12:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r11);
        FlowCollector r13 = (FlowCollector) this.L$0;
        AnonymousClass1 r14 = new AnonymousClass1(this.$inTransaction, this.$db, r13, this.$tableNames, this.$callable, null);
        this.label = 1;
        if (kotlinx.coroutines.d0.e(r14, this) != r10) goto L12;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull FlowCollector<Object> r10, @Nullable Continuation<? super Unit> r11) {
        return ((CoroutinesRoom$Companion$createFlow$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
