package androidx.compose.animation.core;

import C7.r;
import H7.f;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.runtime.Stable;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.b0;
import m9.c0;
import w9.InterfaceC2108a;

@Stable
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ>\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010JR\u0010\u0014\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\t2\u0006\u0010\u0012\u001a\u00028\u00002\b\b\u0002\u0010\u000b\u001a\u00020\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015R(\u0010\u0018\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0016j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Landroidx/compose/animation/core/MutatorMutex;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/animation/core/MutatorMutex$Mutator;", "mutator", "LC7/r;", "tryMutateOrCancel", "(Landroidx/compose/animation/core/MutatorMutex$Mutator;)V", "R", "Landroidx/compose/animation/core/MutatePriority;", "priority", "Lkotlin/Function1;", "LH7/c;", "block", "mutate", "(Landroidx/compose/animation/core/MutatePriority;LS7/k;LH7/c;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "receiver", "Lkotlin/Function2;", "mutateWith", "(Ljava/lang/Object;Landroidx/compose/animation/core/MutatePriority;LS7/n;LH7/c;)Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/animation/core/AtomicReference;", "currentMutator", "Ljava/util/concurrent/atomic/AtomicReference;", "Lw9/a;", "mutex", "Lw9/a;", "Mutator", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutatorMutex {
    public static final int $stable = 0;
    private final AtomicReference<Mutator> currentMutator = new AtomicReference<>(null);
    private final InterfaceC2108a mutex = new kotlinx.coroutines.sync.a();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/animation/core/MutatorMutex$Mutator;", "", "Landroidx/compose/animation/core/MutatePriority;", "priority", "Lm9/c0;", "job", AppAgent.CONSTRUCT, "(Landroidx/compose/animation/core/MutatePriority;Lm9/c0;)V", "other", "", "canInterrupt", "(Landroidx/compose/animation/core/MutatorMutex$Mutator;)Z", "LC7/r;", "cancel", "()V", "Landroidx/compose/animation/core/MutatePriority;", "getPriority", "()Landroidx/compose/animation/core/MutatePriority;", "Lm9/c0;", "getJob", "()Lm9/c0;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Mutator {
        private final c0 job;
        private final MutatePriority priority;

        public Mutator(MutatePriority mutatePriority, c0 c0Var) {
            this.priority = mutatePriority;
            this.job = c0Var;
        }

        public final boolean canInterrupt(Mutator other) {
            return this.priority.compareTo(other.priority) >= 0;
        }

        public final void cancel() {
            this.job.cancel(new MutationInterruptedException());
        }

        public final c0 getJob() {
            return this.job;
        }

        public final MutatePriority getPriority() {
            return this.priority;
        }
    }

    @c(c = "androidx.compose.animation.core.MutatorMutex$mutate$2", f = "InternalMutatorMutex.kt", l = {184, 132}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"R", "Lm9/z;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.animation.core.MutatorMutex$mutate$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ k $block;
        final /* synthetic */ MutatePriority $priority;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ MutatorMutex this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, k kVar, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$priority = mutatePriority;
            this.this$0 = mutatorMutex;
            this.$block = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$priority, this.this$0, this.$block, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [int, w9.a] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutator mutator;
            InterfaceC2108a interfaceC2108a;
            MutatorMutex mutatorMutex;
            k kVar;
            Throwable th;
            Mutator mutator2;
            MutatorMutex mutatorMutex2;
            InterfaceC2108a interfaceC2108a2;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            ?? r1 = this.label;
            try {
                try {
                    if (r1 == 0) {
                        b.b(obj);
                        InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
                        MutatePriority mutatePriority = this.$priority;
                        f fVar = interfaceC1733z.getCoroutineContext().get(b0.f5325a);
                        kotlin.jvm.internal.k.c(fVar);
                        mutator = new Mutator(mutatePriority, (c0) fVar);
                        this.this$0.tryMutateOrCancel(mutator);
                        interfaceC2108a = this.this$0.mutex;
                        k kVar2 = this.$block;
                        mutatorMutex = this.this$0;
                        this.L$0 = mutator;
                        this.L$1 = interfaceC2108a;
                        this.L$2 = kVar2;
                        this.L$3 = mutatorMutex;
                        this.label = 1;
                        if (interfaceC2108a.lock(null, this) != coroutineSingletons) {
                            kVar = kVar2;
                        }
                        return coroutineSingletons;
                    }
                    if (r1 != 1) {
                        if (r1 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutatorMutex2 = (MutatorMutex) this.L$2;
                        interfaceC2108a2 = (InterfaceC2108a) this.L$1;
                        mutator2 = (Mutator) this.L$0;
                        try {
                            b.b(obj);
                            mutatorMutex2.currentMutator.compareAndSet(mutator2, null);
                            interfaceC2108a2.unlock(null);
                            return obj;
                        } catch (Throwable th2) {
                            th = th2;
                            mutatorMutex2.currentMutator.compareAndSet(mutator2, null);
                            throw th;
                        }
                    }
                    MutatorMutex mutatorMutex3 = (MutatorMutex) this.L$3;
                    kVar = (k) this.L$2;
                    InterfaceC2108a interfaceC2108a3 = (InterfaceC2108a) this.L$1;
                    Mutator mutator3 = (Mutator) this.L$0;
                    b.b(obj);
                    mutatorMutex = mutatorMutex3;
                    mutator = mutator3;
                    interfaceC2108a = interfaceC2108a3;
                    this.L$0 = mutator;
                    this.L$1 = interfaceC2108a;
                    this.L$2 = mutatorMutex;
                    this.L$3 = null;
                    this.label = 2;
                    Object objInvoke = kVar.invoke(this);
                    if (objInvoke != coroutineSingletons) {
                        InterfaceC2108a interfaceC2108a4 = interfaceC2108a;
                        obj = objInvoke;
                        mutator2 = mutator;
                        interfaceC2108a2 = interfaceC2108a4;
                        mutatorMutex2 = mutatorMutex;
                        mutatorMutex2.currentMutator.compareAndSet(mutator2, null);
                        interfaceC2108a2.unlock(null);
                        return obj;
                    }
                    return coroutineSingletons;
                } catch (Throwable th3) {
                    th = th3;
                    mutator2 = mutator;
                    mutatorMutex2 = mutatorMutex;
                    mutatorMutex2.currentMutator.compareAndSet(mutator2, null);
                    throw th;
                }
            } catch (Throwable th4) {
                r1.unlock(null);
                throw th4;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super R> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "androidx.compose.animation.core.MutatorMutex$mutateWith$2", f = "InternalMutatorMutex.kt", l = {184, 171}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lm9/z;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.animation.core.MutatorMutex$mutateWith$2, reason: invalid class name and case insensitive filesystem */
    public static final class C03592 extends SuspendLambda implements n {
        final /* synthetic */ n $block;
        final /* synthetic */ MutatePriority $priority;
        final /* synthetic */ T $receiver;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ MutatorMutex this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03592(MutatePriority mutatePriority, MutatorMutex mutatorMutex, n nVar, T t9, H7.c<? super C03592> cVar) {
            super(2, cVar);
            this.$priority = mutatePriority;
            this.this$0 = mutatorMutex;
            this.$block = nVar;
            this.$receiver = t9;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C03592 c03592 = new C03592(this.$priority, this.this$0, this.$block, this.$receiver, cVar);
            c03592.L$0 = obj;
            return c03592;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [int, w9.a] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutator mutator;
            InterfaceC2108a interfaceC2108a;
            n nVar;
            MutatorMutex mutatorMutex;
            Object obj2;
            Throwable th;
            Mutator mutator2;
            MutatorMutex mutatorMutex2;
            InterfaceC2108a interfaceC2108a2;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            ?? r1 = this.label;
            try {
                try {
                    if (r1 == 0) {
                        b.b(obj);
                        InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
                        MutatePriority mutatePriority = this.$priority;
                        f fVar = interfaceC1733z.getCoroutineContext().get(b0.f5325a);
                        kotlin.jvm.internal.k.c(fVar);
                        mutator = new Mutator(mutatePriority, (c0) fVar);
                        this.this$0.tryMutateOrCancel(mutator);
                        interfaceC2108a = this.this$0.mutex;
                        nVar = this.$block;
                        Object obj3 = this.$receiver;
                        mutatorMutex = this.this$0;
                        this.L$0 = mutator;
                        this.L$1 = interfaceC2108a;
                        this.L$2 = nVar;
                        this.L$3 = obj3;
                        this.L$4 = mutatorMutex;
                        this.label = 1;
                        if (interfaceC2108a.lock(null, this) != coroutineSingletons) {
                            obj2 = obj3;
                        }
                        return coroutineSingletons;
                    }
                    if (r1 != 1) {
                        if (r1 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutatorMutex2 = (MutatorMutex) this.L$2;
                        interfaceC2108a2 = (InterfaceC2108a) this.L$1;
                        mutator2 = (Mutator) this.L$0;
                        try {
                            b.b(obj);
                            mutatorMutex2.currentMutator.compareAndSet(mutator2, null);
                            interfaceC2108a2.unlock(null);
                            return obj;
                        } catch (Throwable th2) {
                            th = th2;
                            mutatorMutex2.currentMutator.compareAndSet(mutator2, null);
                            throw th;
                        }
                    }
                    MutatorMutex mutatorMutex3 = (MutatorMutex) this.L$4;
                    obj2 = this.L$3;
                    nVar = (n) this.L$2;
                    InterfaceC2108a interfaceC2108a3 = (InterfaceC2108a) this.L$1;
                    Mutator mutator3 = (Mutator) this.L$0;
                    b.b(obj);
                    mutatorMutex = mutatorMutex3;
                    mutator = mutator3;
                    interfaceC2108a = interfaceC2108a3;
                    this.L$0 = mutator;
                    this.L$1 = interfaceC2108a;
                    this.L$2 = mutatorMutex;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.label = 2;
                    Object objInvoke = nVar.invoke(obj2, this);
                    if (objInvoke != coroutineSingletons) {
                        InterfaceC2108a interfaceC2108a4 = interfaceC2108a;
                        obj = objInvoke;
                        mutator2 = mutator;
                        interfaceC2108a2 = interfaceC2108a4;
                        mutatorMutex2 = mutatorMutex;
                        mutatorMutex2.currentMutator.compareAndSet(mutator2, null);
                        interfaceC2108a2.unlock(null);
                        return obj;
                    }
                    return coroutineSingletons;
                } catch (Throwable th3) {
                    th = th3;
                    mutator2 = mutator;
                    mutatorMutex2 = mutatorMutex;
                    mutatorMutex2.currentMutator.compareAndSet(mutator2, null);
                    throw th;
                }
            } catch (Throwable th4) {
                r1.unlock(null);
                throw th4;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super R> cVar) {
            return ((C03592) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public static /* synthetic */ Object mutate$default(MutatorMutex mutatorMutex, MutatePriority mutatePriority, k kVar, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return mutatorMutex.mutate(mutatePriority, kVar, cVar);
    }

    public static /* synthetic */ Object mutateWith$default(MutatorMutex mutatorMutex, Object obj, MutatePriority mutatePriority, n nVar, H7.c cVar, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return mutatorMutex.mutateWith(obj, mutatePriority, nVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryMutateOrCancel(Mutator mutator) {
        Mutator mutator2;
        do {
            mutator2 = this.currentMutator.get();
            if (mutator2 != null && !mutator.canInterrupt(mutator2)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!this.currentMutator.compareAndSet(mutator2, mutator));
        if (mutator2 != null) {
            mutator2.cancel();
        }
    }

    public final <R> Object mutate(MutatePriority mutatePriority, k kVar, H7.c<? super R> cVar) {
        return AbstractC1683A.f(new AnonymousClass2(mutatePriority, this, kVar, null), cVar);
    }

    public final <T, R> Object mutateWith(T t9, MutatePriority mutatePriority, n nVar, H7.c<? super R> cVar) {
        return AbstractC1683A.f(new C03592(mutatePriority, this, nVar, t9, null), cVar);
    }
}
