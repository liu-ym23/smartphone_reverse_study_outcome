package androidx.room;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.RoomDatabaseKt$invalidationTrackerFlow$1$job$1", f = "RoomDatabaseExt.kt", i = {}, l = {230}, m = "invokeSuspend", n = {}, s = {})
public final class RoomDatabaseKt$invalidationTrackerFlow$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProducerScope<Set<String>> $$this$callbackFlow;
    final /* synthetic */ boolean $emitInitialState;
    final /* synthetic */ AtomicBoolean $ignoreInvalidation;
    final /* synthetic */ RoomDatabaseKt$invalidationTrackerFlow$1.a $observer;
    final /* synthetic */ String[] $tables;
    final /* synthetic */ RoomDatabase $this_invalidationTrackerFlow;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public RoomDatabaseKt$invalidationTrackerFlow$1$job$1(RoomDatabase r10, RoomDatabaseKt$invalidationTrackerFlow$1.a r11, boolean r12, ProducerScope<? super Set<String>> r13, String[] r14, AtomicBoolean r15, Continuation<? super RoomDatabaseKt$invalidationTrackerFlow$1$job$1> r16) {
        this.$this_invalidationTrackerFlow = r10;
        this.$observer = r11;
        this.$emitInitialState = r12;
        this.$$this$callbackFlow = r13;
        this.$tables = r14;
        this.$ignoreInvalidation = r15;
        super(2, r16);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new RoomDatabaseKt$invalidationTrackerFlow$1$job$1(this.$this_invalidationTrackerFlow, this.$observer, this.$emitInitialState, this.$$this$callbackFlow, this.$tables, this.$ignoreInvalidation, r11);
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
        if (r12 == 0) goto L11;
        if (r12 != 1) goto L6;
        kotlin.c.b(r10);     // Catch: Throwable -> L9
    L19:
        throw new KotlinNothingValueException();     // Catch: Throwable -> L9
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        kotlin.c.b(r10);
        this.$this_invalidationTrackerFlow.m().c(this.$observer);
        if (this.$emitInitialState == false) goto L15;
        this.$$this$callbackFlow.mo53trySendJP2dKIU(kotlin.collections.n.O(this.$tables));     // Catch: Throwable -> L9
    L15:
        this.$ignoreInvalidation.set(false);     // Catch: Throwable -> L9
        this.label = 1;     // Catch: Throwable -> L9
        if (DelayKt.a(this) != r11) goto L19;
        return r11;
    L9:
        th = move-exception;
        this.$this_invalidationTrackerFlow.m().p(this.$observer);
        throw th;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((RoomDatabaseKt$invalidationTrackerFlow$1$job$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
