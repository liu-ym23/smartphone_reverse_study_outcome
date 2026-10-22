package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: SharingStarted.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0017J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Lkotlinx/coroutines/flow/SharingStarted;", "stopTimeout", "", "replayExpiration", "(JJ)V", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "equals", "", "other", "", "hashCode", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StartedWhileSubscribed implements SharingStarted {
    private final long replayExpiration;
    private final long stopTimeout;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1, reason: invalid class name */
    /* JADX INFO: compiled from: SharingStarted.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "count", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {178, 180, 182, 183, 185}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
        /* synthetic */ int I$0;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ StartedWhileSubscribed this$0;

        AnonymousClass1(StartedWhileSubscribed r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(3, r2);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super SharingCommand> r1, Integer r2, Continuation<? super Unit> r3) {
            return invoke(r1, r2.intValue(), r3);
        }

        public final Object invoke(FlowCollector<? super SharingCommand> r2, int r3, Continuation<? super Unit> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r2;
            r0.I$0 = r3;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L13;
            if (r1 == 4) goto L12;
            if (r1 == 5) goto L15;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            FlowCollector r2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r10);
        L32:
            this.L$0 = null;
            this.label = 5;
            if (r2.emit(SharingCommand.STOP_AND_RESET_REPLAY_CACHE, this) != r0) goto L36;
            return r0;
        L36:
            return Unit.INSTANCE;
        L13:
            r2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r10);
        L29:
            this.L$0 = r2;
            this.label = 4;
            if (DelayKt.delay(StartedWhileSubscribed.access$getReplayExpiration$p(this.this$0), this) != r0) goto L32;
            return r0;
        L14:
            r2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r10);
        L25:
            if (StartedWhileSubscribed.access$getReplayExpiration$p(this.this$0) <= 0) goto L32;
            this.L$0 = r2;
            this.label = 3;
            if (r2.emit(SharingCommand.STOP, this) != r0) goto L29;
            return r0;
        L15:
            ResultKt.throwOnFailure(r10);
            goto L36
        L16:
            ResultKt.throwOnFailure(r10);
            r2 = (FlowCollector) this.L$0;
            if (this.I$0 <= 0) goto L21;
            this.label = 1;
            if (r2.emit(SharingCommand.START, this) != r0) goto L36;
            return r0;
        L21:
            this.L$0 = r2;
            this.label = 2;
            if (DelayKt.delay(StartedWhileSubscribed.access$getStopTimeout$p(this.this$0), this) != r0) goto L25;
            return r0;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedWhileSubscribed$command$2, reason: invalid class name */
    /* JADX INFO: compiled from: SharingStarted.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/flow/SharingCommand;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", f = "SharingStarted.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            AnonymousClass2 r0 = new AnonymousClass2(r2);
            r0.L$0 = r1;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SharingCommand r1, Continuation<? super Boolean> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SharingCommand r1, Continuation<? super Boolean> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            if (((SharingCommand) this.L$0) == SharingCommand.START) goto L7;
            boolean r1 = true;
        L9:
            return Boxing.boxBoolean(r1);
        L7:
            r1 = false;
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public StartedWhileSubscribed(long r6, long r8) {
        this.stopTimeout = r6;
        this.replayExpiration = r8;
        boolean r2 = true;
        if (r6 < 0) goto L5;
        boolean r5 = true;
    L7:
        if (r5 == false) goto L17;
        if (r8 >= 0) goto L12;
        r2 = false;
    L12:
        if (r2 == false) goto L15;
        return;
    L15:
        throw new IllegalArgumentException(("replayExpiration(" + r8 + " ms) cannot be negative").toString());
    L17:
        throw new IllegalArgumentException(("stopTimeout(" + r6 + " ms) cannot be negative").toString());
    L5:
        r5 = false;
        goto L7
    }

    public static final /* synthetic */ long access$getReplayExpiration$p(StartedWhileSubscribed r2) {
        return r2.replayExpiration;
    }

    public static final /* synthetic */ long access$getStopTimeout$p(StartedWhileSubscribed r2) {
        return r2.stopTimeout;
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow<SharingCommand> command(StateFlow<Integer> r3) {
        return FlowKt.distinctUntilChanged(FlowKt.dropWhile(FlowKt.transformLatest(r3, new AnonymousClass1(this, null)), new AnonymousClass2(null)));
    }

    public String toString() {
        List r0 = CollectionsKt.createListBuilder(2);
        if (this.stopTimeout <= 0) goto L6;
        r0.add("stopTimeout=" + this.stopTimeout + "ms");
    L6:
        if (this.replayExpiration >= Long.MAX_VALUE) goto L9;
        r0.add("replayExpiration=" + this.replayExpiration + "ms");
    L9:
        return "SharingStarted.WhileSubscribed(" + CollectionsKt.joinToString$default(CollectionsKt.build(r0), null, null, null, 0, null, null, 63, null) + ')';
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof StartedWhileSubscribed) == false) goto L9;
        StartedWhileSubscribed r6 = (StartedWhileSubscribed) r5;
        if (this.stopTimeout != r6.stopTimeout) goto L9;
        if (this.replayExpiration != r6.replayExpiration) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        return (Long.hashCode(this.stopTimeout) * 31) + Long.hashCode(this.replayExpiration);
    }
}
