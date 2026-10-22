package androidx.compose.foundation;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0002J<\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0086@¢\u0006\u0002\u0010\u0015JU\u0010\u0016\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u000f2\u0006\u0010\u0018\u001a\u0002H\u00172\b\b\u0002\u0010\u0010\u001a\u00020\u00112'\u0010\u0012\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019¢\u0006\u0002\b\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u001eH\u0086\bJ\b\u0010\u001f\u001a\u00020\u001dH\u0001J\b\u0010 \u001a\u00020\fH\u0001R$\u0010\u0004\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/compose/foundation/MutatorMutex;", "", "<init>", "()V", "currentMutator", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/foundation/MutatorMutex$Mutator;", "Landroidx/compose/foundation/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "tryMutateOrCancel", "", "mutator", "mutate", "R", "priority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mutateWith", ExifInterface.GPS_DIRECTION_TRUE, SocialConstants.PARAM_RECEIVER, "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryMutate", "", "Lkotlin/Function0;", "tryLock", "unlock", "Mutator", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutatorMutex {
    public static final int $stable = 0;
    private final AtomicReference<Mutator> currentMutator;
    private final kotlinx.coroutines.sync.a mutex;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000J\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/MutatorMutex$Mutator;", "", "priority", "Landroidx/compose/foundation/MutatePriority;", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Landroidx/compose/foundation/MutatePriority;Lkotlinx/coroutines/Job;)V", "getPriority", "()Landroidx/compose/foundation/MutatePriority;", "getJob", "()Lkotlinx/coroutines/Job;", "canInterrupt", "", "other", "cancel", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Mutator {

        /* JADX INFO: renamed from: job, reason: collision with root package name */
        private final Job f5723job;
        private final MutatePriority priority;

        public final void cancel() {
            this.f5723job.cancel(new MutationInterruptedException());
        }

        public final Job getJob() {
            return this.f5723job;
        }

        public final MutatePriority getPriority() {
            return this.priority;
        }

        public final boolean canInterrupt(Mutator r100) {
            if (this.priority.compareTo(r100.priority) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public Mutator(MutatePriority r100, Job r101) {
            this.priority = r100;
            this.f5723job = r101;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.foundation.MutatorMutex$mutate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.MutatorMutex$mutate$2", f = "MutatorMutex.kt", i = {0, 0, 1, 1}, l = {211, 127}, m = "invokeSuspend", n = {"mutator", "$this$withLock_u24default$iv", "mutator", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class AnonymousClass2<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
        final /* synthetic */ MutatePriority $priority;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ MutatorMutex this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(MutatePriority r100, MutatorMutex r101, Function1<? super Continuation<? super R>, ? extends Object> r102, Continuation<? super AnonymousClass2> r103) {
            this.$priority = r100;
            this.this$0 = r101;
            this.$block = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass2 r102 = new AnonymousClass2(this.$priority, this.this$0, this.$block, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Object r101) {
            return invoke(r100, (Continuation) r101);
        }

        public final Object invoke(CoroutineScope r100, Continuation<? super R> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.sync.a] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r102 = this.label;
            if (r102 == 0) goto L14;
            if (r102 == 1) goto L13;
            if (r102 != 2) goto L12;
            MutatorMutex r103 = (MutatorMutex) this.L$2;
            kotlinx.coroutines.sync.a r104 = (kotlinx.coroutines.sync.a) this.L$1;
            Mutator r105 = (Mutator) this.L$0;
            ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L9
        L22:
            AtomicReference r106 = MutatorMutex.access$getCurrentMutator$p(r103);     // Catch: Throwable -> L39
        L24:
            if (r106.compareAndSet(r105, null) == true) goto L28;
            if (r106.get() == r105) goto L24;
        L28:
            r104.unlock(null);
            return r100;
        L9:
            Throwable th10 = th;
        L32:
            AtomicReference r107 = MutatorMutex.access$getCurrentMutator$p(r103);     // Catch: Throwable -> L39
        L34:
            if (r107.compareAndSet(r105, null) == true) goto L38;
            if (r107.get() == r105) goto L34;
        L38:
            throw th10;     // Catch: Throwable -> L39
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            MutatorMutex r108 = (MutatorMutex) this.L$3;
            Function1<Continuation<? super R>, Object> r109 = (Function1) this.L$2;
            kotlinx.coroutines.sync.a r110 = (kotlinx.coroutines.sync.a) this.L$1;
            Mutator r111 = (Mutator) this.L$0;
            ResultKt.throwOnFailure(r100);
            kotlinx.coroutines.sync.a r112 = r110;
        L45:
            this.L$0 = r111;     // Catch: Throwable -> L30
            this.L$1 = r112;     // Catch: Throwable -> L30
            this.L$2 = r108;     // Catch: Throwable -> L30
            this.L$3 = null;     // Catch: Throwable -> L30
            this.label = 2;     // Catch: Throwable -> L30
            Object r113 = r109.invoke(this);     // Catch: Throwable -> L30
            if (r113 != r101) goto L21;
            return r101;
        L21:
            r103 = r108;
            r104 = r112;
            r100 = r113;
            r105 = r111;
        L30:
            th = move-exception;
            r105 = r111;
            th10 = th;
            r103 = r108;
            goto L32
        L14:
            ResultKt.throwOnFailure(r100);
            CoroutineScope r114 = (CoroutineScope) this.L$0;
            MutatePriority r115 = this.$priority;
            CoroutineContext.Element r116 = r114.getCoroutineContext().get(Job.Key);
            Intrinsics.checkNotNull(r116);
            Mutator r117 = new Mutator(r115, (Job) r116);
            MutatorMutex.access$tryMutateOrCancel(this.this$0, r117);
            r112 = MutatorMutex.access$getMutex$p(this.this$0);
            Function1<Continuation<? super R>, Object> r118 = this.$block;
            MutatorMutex r119 = this.this$0;
            this.L$0 = r117;
            this.L$1 = r112;
            this.L$2 = r118;
            this.L$3 = r119;
            this.label = 1;
            if (r112.a(null, this) != r101) goto L17;
            return r101;
        L17:
            r109 = r118;
            r111 = r117;
            r108 = r119;
        L39:
            th = move-exception;
            r102.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.foundation.MutatorMutex$mutateWith$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.MutatorMutex$mutateWith$2", f = "MutatorMutex.kt", i = {0, 0, 1, 1}, l = {211, 167}, m = "invokeSuspend", n = {"mutator", "$this$withLock_u24default$iv", "mutator", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C85612<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function2<T, Continuation<? super R>, Object> $block;
        final /* synthetic */ MutatePriority $priority;
        final /* synthetic */ T $receiver;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ MutatorMutex this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C85612(MutatePriority r100, MutatorMutex r101, Function2<? super T, ? super Continuation<? super R>, ? extends Object> r102, T r103, Continuation<? super C85612> r104) {
            this.$priority = r100;
            this.this$0 = r101;
            this.$block = r102;
            this.$receiver = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C85612 r102 = new C85612(this.$priority, this.this$0, this.$block, this.$receiver, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Object r101) {
            return invoke(r100, (Continuation) r101);
        }

        public final Object invoke(CoroutineScope r100, Continuation<? super R> r101) {
            return ((C85612) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.sync.a] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r101 = this.label;
            if (r101 == 0) goto L14;
            if (r101 == 1) goto L13;
            if (r101 != 2) goto L12;
            MutatorMutex r102 = (MutatorMutex) this.L$2;
            kotlinx.coroutines.sync.a r103 = (kotlinx.coroutines.sync.a) this.L$1;
            Mutator r104 = (Mutator) this.L$0;
            ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L9
        L22:
            AtomicReference r105 = MutatorMutex.access$getCurrentMutator$p(r102);     // Catch: Throwable -> L39
        L24:
            if (r105.compareAndSet(r104, null) == true) goto L28;
            if (r105.get() == r104) goto L24;
        L28:
            r103.unlock(null);
            return r110;
        L9:
            Throwable th10 = th;
        L32:
            AtomicReference r106 = MutatorMutex.access$getCurrentMutator$p(r102);     // Catch: Throwable -> L39
        L34:
            if (r106.compareAndSet(r104, null) == true) goto L38;
            if (r106.get() == r104) goto L34;
        L38:
            throw th10;     // Catch: Throwable -> L39
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            MutatorMutex r107 = (MutatorMutex) this.L$4;
            Object r108 = this.L$3;
            Function2 r109 = (Function2) this.L$2;
            kotlinx.coroutines.sync.a r111 = (kotlinx.coroutines.sync.a) this.L$1;
            Mutator r112 = (Mutator) this.L$0;
            ResultKt.throwOnFailure(r110);
            kotlinx.coroutines.sync.a r113 = r111;
        L44:
            this.L$0 = r112;     // Catch: Throwable -> L30
            this.L$1 = r113;     // Catch: Throwable -> L30
            this.L$2 = r107;     // Catch: Throwable -> L30
            this.L$3 = null;     // Catch: Throwable -> L30
            this.L$4 = null;     // Catch: Throwable -> L30
            this.label = 2;     // Catch: Throwable -> L30
            Object r114 = r109.invoke(r108, this);     // Catch: Throwable -> L30
            if (r114 != r100) goto L21;
            return r100;
        L21:
            r102 = r107;
            r103 = r113;
            r110 = r114;
            r104 = r112;
        L30:
            th = move-exception;
            r104 = r112;
            th10 = th;
            r102 = r107;
            goto L32
        L14:
            ResultKt.throwOnFailure(r110);
            CoroutineScope r115 = (CoroutineScope) this.L$0;
            MutatePriority r116 = this.$priority;
            CoroutineContext.Element r117 = r115.getCoroutineContext().get(Job.Key);
            Intrinsics.checkNotNull(r117);
            Mutator r118 = new Mutator(r116, (Job) r117);
            MutatorMutex.access$tryMutateOrCancel(this.this$0, r118);
            r113 = MutatorMutex.access$getMutex$p(this.this$0);
            r109 = this.$block;
            Object r119 = this.$receiver;
            MutatorMutex r120 = this.this$0;
            this.L$0 = r118;
            this.L$1 = r113;
            this.L$2 = r109;
            this.L$3 = r119;
            this.L$4 = r120;
            this.label = 1;
            if (r113.a(null, this) != r100) goto L17;
            return r100;
        L17:
            r108 = r119;
            r112 = r118;
            r107 = r120;
        L39:
            th = move-exception;
            r101.unlock(null);
            throw th;
        }
    }

    public final boolean tryLock() {
        return this.mutex.b(null);
    }

    public final void unlock() {
        this.mutex.unlock(null);
    }

    public MutatorMutex() {
        this.currentMutator = new AtomicReference(null);
        this.mutex = kotlinx.coroutines.sync.b.a();
    }

    public static final /* synthetic */ AtomicReference access$getCurrentMutator$p(MutatorMutex r100) {
        return r100.currentMutator;
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a access$getMutex$p(MutatorMutex r100) {
        return r100.mutex;
    }

    private final void tryMutateOrCancel(Mutator r100) {
    L2:
        Mutator r101 = this.currentMutator.get();
        if (r101 != null) goto L5;
    L9:
        AtomicReference<Mutator> r102 = this.currentMutator;
    L11:
        if (r102.compareAndSet(r101, r100) == true) goto L12;
        if (r102.get() == r101) goto L11;
        boolean r103 = false;
    L16:
        if (r103 == false) goto L2;
        if (r101 == null) goto L28;
        r101.cancel();
        return;
    L28:
        return;
    L12:
        r103 = true;
        goto L16
    L5:
        if (r100.canInterrupt(r101) == true) goto L9;
        throw new CancellationException("Current mutation had a higher priority");
    }

    public final boolean tryMutate(Function0<Unit> r100) {
        boolean r101 = tryLock();
        if (r101 == true) goto L11;
    L10:
        return r101;
    L11:
        r100.invoke();     // Catch: Throwable -> L7
        InlineMarker.finallyStart(1);
        unlock();
        InlineMarker.finallyEnd(1);
    L7:
        th = move-exception;
        InlineMarker.finallyStart(1);
        unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final /* synthetic */ void access$tryMutateOrCancel(MutatorMutex r100, Mutator r101) {
        r100.tryMutateOrCancel(r101);
    }

    public final <R> Object mutate(MutatePriority r100, Function1<? super Continuation<? super R>, ? extends Object> r101, Continuation<? super R> r102) {
        return CoroutineScopeKt.coroutineScope(new AnonymousClass2(r100, this, r101, null), r102);
    }

    public final <T, R> Object mutateWith(T r100, MutatePriority r101, Function2<? super T, ? super Continuation<? super R>, ? extends Object> r110, Continuation<? super R> r111) {
        return CoroutineScopeKt.coroutineScope(new C85612(r101, this, r110, r100, null), r111);
    }

    public static /* synthetic */ Object mutate$default(MutatorMutex r100, MutatePriority r101, Function1 r102, Continuation r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = MutatePriority.Default;
    L6:
        return r100.mutate(r101, r102, r103);
    }

    public static /* synthetic */ Object mutateWith$default(MutatorMutex r100, Object r101, MutatePriority r102, Function2 r103, Continuation r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = MutatePriority.Default;
    L6:
        return r100.mutateWith(r101, r102, r103, r104);
    }
}
