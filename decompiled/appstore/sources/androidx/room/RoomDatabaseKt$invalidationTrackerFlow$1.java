package androidx.room;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1", f = "RoomDatabaseExt.kt", i = {}, l = {235}, m = "invokeSuspend", n = {}, s = {})
final class RoomDatabaseKt$invalidationTrackerFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super Set<? extends String>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $emitInitialState;
    final /* synthetic */ String[] $tables;
    final /* synthetic */ RoomDatabase $this_invalidationTrackerFlow;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a extends m.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f4498b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ProducerScope f4499c;

        public a(String[] r10, AtomicBoolean r11, ProducerScope r12) {
            this.f4498b = r11;
            this.f4499c = r12;
            super(r10);
        }

        @Override // androidx.room.m.c
        public void c(Set r10) {
            if (this.f4498b.get() == false) goto L5;
            return;
        L5:
            this.f4499c.mo53trySendJP2dKIU(r10);
        }
    }

    public RoomDatabaseKt$invalidationTrackerFlow$1(boolean r10, RoomDatabase r11, String[] r12, Continuation<? super RoomDatabaseKt$invalidationTrackerFlow$1> r13) {
        this.$emitInitialState = r10;
        this.$this_invalidationTrackerFlow = r11;
        this.$tables = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        RoomDatabaseKt$invalidationTrackerFlow$1 r12 = new RoomDatabaseKt$invalidationTrackerFlow$1(this.$emitInitialState, this.$this_invalidationTrackerFlow, this.$tables, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(ProducerScope<? super Set<? extends String>> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r13) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        kotlin.c.b(r13);
    L17:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r13);
        ProducerScope r14 = (ProducerScope) this.L$0;
        AtomicBoolean r12 = new AtomicBoolean(this.$emitInitialState);
        a r15 = new a(this.$tables, r12, r14);
        w0 r16 = (w0) r14.getCoroutineContext().get(w0.f4708c);
        if (r16 == null) goto L12;
        ContinuationInterceptor r17 = r16.b();
        if (r17 == null) goto L12;
    L13:
        RoomDatabaseKt$invalidationTrackerFlow$1$job$1 r18 = new RoomDatabaseKt$invalidationTrackerFlow$1$job$1(this.$this_invalidationTrackerFlow, r15, this.$emitInitialState, r14, this.$tables, r12, null);
        final Job r19 = kotlinx.coroutines.h.d(r14, r17, null, r18, 2, null);
        Function0<Unit> r20 = new AnonymousClass1(r19);
        this.label = 1;
        if (ProduceKt.a(r14, r20, this) != r10) goto L17;
        return r10;
    L12:
        r17 = g.a(this.$this_invalidationTrackerFlow);
        goto L13
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<? super Set<String>> r10, @Nullable Continuation<? super Unit> r11) {
        return ((RoomDatabaseKt$invalidationTrackerFlow$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
