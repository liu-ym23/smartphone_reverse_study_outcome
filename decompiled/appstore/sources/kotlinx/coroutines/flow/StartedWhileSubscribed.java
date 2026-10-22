package kotlinx.coroutines.flow;

import com.bytedanceos.common.ui.animation.AnimationConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class StartedWhileSubscribed implements SharingStarted {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f21503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f21504b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "count", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {178, AnimationConstants.DURATION_180, 182, 183, 185}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
        /* synthetic */ int I$0;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ StartedWhileSubscribed this$0;

        public AnonymousClass1(StartedWhileSubscribed r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(3, r11);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super SharingCommand> r10, Integer r11, Continuation<? super Unit> r12) {
            return invoke(r10, r11.intValue(), r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.label;
            if (r12 == 0) goto L16;
            if (r12 == 1) goto L15;
            if (r12 == 2) goto L14;
            if (r12 == 3) goto L13;
            if (r12 == 4) goto L12;
            if (r12 == 5) goto L15;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            FlowCollector r13 = (FlowCollector) this.L$0;
            kotlin.c.b(r10);
        L32:
            SharingCommand r14 = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
            this.L$0 = null;
            this.label = 5;
            if (r13.emit(r14, this) != r11) goto L36;
            return r11;
        L36:
            return Unit.f21064a;
        L13:
            r13 = (FlowCollector) this.L$0;
            kotlin.c.b(r10);
        L29:
            long r15 = StartedWhileSubscribed.a(this.this$0);
            this.L$0 = r13;
            this.label = 4;
            if (DelayKt.b(r15, this) != r11) goto L32;
            return r11;
        L14:
            r13 = (FlowCollector) this.L$0;
            kotlin.c.b(r10);
        L25:
            if (StartedWhileSubscribed.a(this.this$0) <= 0) goto L32;
            SharingCommand r16 = SharingCommand.STOP;
            this.L$0 = r13;
            this.label = 3;
            if (r13.emit(r16, this) != r11) goto L29;
            return r11;
        L15:
            kotlin.c.b(r10);
            goto L36
        L16:
            kotlin.c.b(r10);
            r13 = (FlowCollector) this.L$0;
            if (this.I$0 <= 0) goto L21;
            SharingCommand r17 = SharingCommand.START;
            this.label = 1;
            if (r13.emit(r17, this) != r11) goto L36;
            return r11;
        L21:
            long r18 = StartedWhileSubscribed.b(this.this$0);
            this.L$0 = r13;
            this.label = 2;
            if (DelayKt.b(r18, this) != r11) goto L25;
            return r11;
        }

        @Nullable
        public final Object invoke(@NotNull FlowCollector<? super SharingCommand> r10, int r11, @Nullable Continuation<? super Unit> r12) {
            AnonymousClass1 r13 = new AnonymousClass1(this.this$0, r12);
            r13.L$0 = r10;
            r13.I$0 = r11;
            return r13.invokeSuspend(Unit.f21064a);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedWhileSubscribed$command$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/flow/SharingCommand;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", f = "SharingStarted.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            AnonymousClass2 r12 = new AnonymousClass2(r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(SharingCommand r10, Continuation<? super Boolean> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            kotlin.coroutines.intrinsics.a.d();
            if (this.label != 0) goto L11;
            kotlin.c.b(r10);
            if (((SharingCommand) this.L$0) == SharingCommand.START) goto L7;
            boolean r11 = true;
        L9:
            return tf.a.a(r11);
        L7:
            r11 = false;
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull SharingCommand r10, @Nullable Continuation<? super Boolean> r11) {
            return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public StartedWhileSubscribed(long r10, long r11) {
        this.f21503a = r10;
        this.f21504b = r11;
        if (r10 < 0) goto L10;
        if (r11 < 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(("replayExpiration(" + r11 + " ms) cannot be negative").toString());
    L10:
        throw new IllegalArgumentException(("stopTimeout(" + r10 + " ms) cannot be negative").toString());
    }

    public static final /* synthetic */ long a(StartedWhileSubscribed r10) {
        return r10.f21504b;
    }

    public static final /* synthetic */ long b(StartedWhileSubscribed r10) {
        return r10.f21503a;
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow command(StateFlow r10) {
        return c.n(c.p(c.S(r10, new AnonymousClass1(this, null)), new AnonymousClass2(null)));
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof StartedWhileSubscribed) == false) goto L9;
        StartedWhileSubscribed r11 = (StartedWhileSubscribed) r10;
        if (this.f21503a != r11.f21503a) goto L9;
        if (this.f21504b != r11.f21504b) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        return (Long.hashCode(this.f21503a) * 31) + Long.hashCode(this.f21504b);
    }

    public String toString() {
        List r10 = kotlin.collections.s.d(2);
        if (this.f21503a <= 0) goto L6;
        r10.add("stopTimeout=" + this.f21503a + "ms");
    L6:
        if (this.f21504b >= Long.MAX_VALUE) goto L9;
        r10.add("replayExpiration=" + this.f21504b + "ms");
    L9:
        return "SharingStarted.WhileSubscribed(" + kotlin.collections.b0.h0(kotlin.collections.s.a(r10), null, null, null, 0, null, null, 63, null) + ')';
    }
}
