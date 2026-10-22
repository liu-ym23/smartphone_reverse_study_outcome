package androidx.compose.material3.internal;

import C7.r;
import H7.f;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.foundation.MutatePriority;
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
import v7.o;
import w9.InterfaceC2108a;

@Stable
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ>\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010JR\u0010\u0014\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\t2\u0006\u0010\u0012\u001a\u00028\u00002\b\b\u0002\u0010\u000b\u001a\u00020\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0018\u001a\u00020\u00172\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\u0004\b\u0018\u0010\u0019R(\u0010\u001c\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001aj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/compose/material3/internal/InternalMutatorMutex;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/material3/internal/InternalMutatorMutex$Mutator;", "mutator", "LC7/r;", "tryMutateOrCancel", "(Landroidx/compose/material3/internal/InternalMutatorMutex$Mutator;)V", "R", "Landroidx/compose/foundation/MutatePriority;", "priority", "Lkotlin/Function1;", "LH7/c;", "block", "mutate", "(Landroidx/compose/foundation/MutatePriority;LS7/k;LH7/c;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "receiver", "Lkotlin/Function2;", "mutateWith", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;LS7/n;LH7/c;)Ljava/lang/Object;", "Lkotlin/Function0;", "", "tryMutate", "(LS7/a;)Z", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/material3/internal/InternalAtomicReference;", "currentMutator", "Ljava/util/concurrent/atomic/AtomicReference;", "Lw9/a;", "mutex", "Lw9/a;", "Mutator", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InternalMutatorMutex {
    public static final int $stable = 0;
    private final AtomicReference<Mutator> currentMutator = new AtomicReference<>(null);
    private final InterfaceC2108a mutex = new kotlinx.coroutines.sync.a();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/internal/InternalMutatorMutex$Mutator;", "", "Landroidx/compose/foundation/MutatePriority;", "priority", "Lm9/c0;", "job", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/MutatePriority;Lm9/c0;)V", "other", "", "canInterrupt", "(Landroidx/compose/material3/internal/InternalMutatorMutex$Mutator;)Z", "LC7/r;", "cancel", "()V", "Landroidx/compose/foundation/MutatePriority;", "getPriority", "()Landroidx/compose/foundation/MutatePriority;", "Lm9/c0;", "getJob", "()Lm9/c0;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
            this.job.cancel(null);
        }

        public final c0 getJob() {
            return this.job;
        }

        public final MutatePriority getPriority() {
            return this.priority;
        }
    }

    @c(c = "androidx.compose.material3.internal.InternalMutatorMutex$mutate$2", f = "InternalMutatorMutex.kt", l = {180, o.META_DATA_FIELD_NUMBER}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"R", "Lm9/z;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.internal.InternalMutatorMutex$mutate$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ k $block;
        final /* synthetic */ MutatePriority $priority;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ InternalMutatorMutex this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MutatePriority mutatePriority, InternalMutatorMutex internalMutatorMutex, k kVar, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$priority = mutatePriority;
            this.this$0 = internalMutatorMutex;
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
            InternalMutatorMutex internalMutatorMutex;
            k kVar;
            Throwable th;
            Mutator mutator2;
            InternalMutatorMutex internalMutatorMutex2;
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
                        internalMutatorMutex = this.this$0;
                        this.L$0 = mutator;
                        this.L$1 = interfaceC2108a;
                        this.L$2 = kVar2;
                        this.L$3 = internalMutatorMutex;
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
                        internalMutatorMutex2 = (InternalMutatorMutex) this.L$2;
                        interfaceC2108a2 = (InterfaceC2108a) this.L$1;
                        mutator2 = (Mutator) this.L$0;
                        try {
                            b.b(obj);
                            internalMutatorMutex2.currentMutator.compareAndSet(mutator2, null);
                            interfaceC2108a2.unlock(null);
                            return obj;
                        } catch (Throwable th2) {
                            th = th2;
                            internalMutatorMutex2.currentMutator.compareAndSet(mutator2, null);
                            throw th;
                        }
                    }
                    InternalMutatorMutex internalMutatorMutex3 = (InternalMutatorMutex) this.L$3;
                    kVar = (k) this.L$2;
                    InterfaceC2108a interfaceC2108a3 = (InterfaceC2108a) this.L$1;
                    Mutator mutator3 = (Mutator) this.L$0;
                    b.b(obj);
                    internalMutatorMutex = internalMutatorMutex3;
                    mutator = mutator3;
                    interfaceC2108a = interfaceC2108a3;
                    this.L$0 = mutator;
                    this.L$1 = interfaceC2108a;
                    this.L$2 = internalMutatorMutex;
                    this.L$3 = null;
                    this.label = 2;
                    Object objInvoke = kVar.invoke(this);
                    if (objInvoke != coroutineSingletons) {
                        InterfaceC2108a interfaceC2108a4 = interfaceC2108a;
                        obj = objInvoke;
                        mutator2 = mutator;
                        interfaceC2108a2 = interfaceC2108a4;
                        internalMutatorMutex2 = internalMutatorMutex;
                        internalMutatorMutex2.currentMutator.compareAndSet(mutator2, null);
                        interfaceC2108a2.unlock(null);
                        return obj;
                    }
                    return coroutineSingletons;
                } catch (Throwable th3) {
                    th = th3;
                    mutator2 = mutator;
                    internalMutatorMutex2 = internalMutatorMutex;
                    internalMutatorMutex2.currentMutator.compareAndSet(mutator2, null);
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

    @c(c = "androidx.compose.material3.internal.InternalMutatorMutex$mutateWith$2", f = "InternalMutatorMutex.kt", l = {180, 142}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lm9/z;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.internal.InternalMutatorMutex$mutateWith$2, reason: invalid class name and case insensitive filesystem */
    public static final class C06782 extends SuspendLambda implements n {
        final /* synthetic */ n $block;
        final /* synthetic */ MutatePriority $priority;
        final /* synthetic */ T $receiver;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ InternalMutatorMutex this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06782(MutatePriority mutatePriority, InternalMutatorMutex internalMutatorMutex, n nVar, T t9, H7.c<? super C06782> cVar) {
            super(2, cVar);
            this.$priority = mutatePriority;
            this.this$0 = internalMutatorMutex;
            this.$block = nVar;
            this.$receiver = t9;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C06782 c06782 = new C06782(this.$priority, this.this$0, this.$block, this.$receiver, cVar);
            c06782.L$0 = obj;
            return c06782;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [int, w9.a] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutator mutator;
            InterfaceC2108a interfaceC2108a;
            n nVar;
            InternalMutatorMutex internalMutatorMutex;
            Object obj2;
            Throwable th;
            Mutator mutator2;
            InternalMutatorMutex internalMutatorMutex2;
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
                        internalMutatorMutex = this.this$0;
                        this.L$0 = mutator;
                        this.L$1 = interfaceC2108a;
                        this.L$2 = nVar;
                        this.L$3 = obj3;
                        this.L$4 = internalMutatorMutex;
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
                        internalMutatorMutex2 = (InternalMutatorMutex) this.L$2;
                        interfaceC2108a2 = (InterfaceC2108a) this.L$1;
                        mutator2 = (Mutator) this.L$0;
                        try {
                            b.b(obj);
                            internalMutatorMutex2.currentMutator.compareAndSet(mutator2, null);
                            interfaceC2108a2.unlock(null);
                            return obj;
                        } catch (Throwable th2) {
                            th = th2;
                            internalMutatorMutex2.currentMutator.compareAndSet(mutator2, null);
                            throw th;
                        }
                    }
                    InternalMutatorMutex internalMutatorMutex3 = (InternalMutatorMutex) this.L$4;
                    obj2 = this.L$3;
                    nVar = (n) this.L$2;
                    InterfaceC2108a interfaceC2108a3 = (InterfaceC2108a) this.L$1;
                    Mutator mutator3 = (Mutator) this.L$0;
                    b.b(obj);
                    internalMutatorMutex = internalMutatorMutex3;
                    mutator = mutator3;
                    interfaceC2108a = interfaceC2108a3;
                    this.L$0 = mutator;
                    this.L$1 = interfaceC2108a;
                    this.L$2 = internalMutatorMutex;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.label = 2;
                    Object objInvoke = nVar.invoke(obj2, this);
                    if (objInvoke != coroutineSingletons) {
                        InterfaceC2108a interfaceC2108a4 = interfaceC2108a;
                        obj = objInvoke;
                        mutator2 = mutator;
                        interfaceC2108a2 = interfaceC2108a4;
                        internalMutatorMutex2 = internalMutatorMutex;
                        internalMutatorMutex2.currentMutator.compareAndSet(mutator2, null);
                        interfaceC2108a2.unlock(null);
                        return obj;
                    }
                    return coroutineSingletons;
                } catch (Throwable th3) {
                    th = th3;
                    mutator2 = mutator;
                    internalMutatorMutex2 = internalMutatorMutex;
                    internalMutatorMutex2.currentMutator.compareAndSet(mutator2, null);
                    throw th;
                }
            } catch (Throwable th4) {
                r1.unlock(null);
                throw th4;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super R> cVar) {
            return ((C06782) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public static /* synthetic */ Object mutate$default(InternalMutatorMutex internalMutatorMutex, MutatePriority mutatePriority, k kVar, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return internalMutatorMutex.mutate(mutatePriority, kVar, cVar);
    }

    public static /* synthetic */ Object mutateWith$default(InternalMutatorMutex internalMutatorMutex, Object obj, MutatePriority mutatePriority, n nVar, H7.c cVar, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return internalMutatorMutex.mutateWith(obj, mutatePriority, nVar, cVar);
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
        return AbstractC1683A.f(new C06782(mutatePriority, this, nVar, t9, null), cVar);
    }

    public final boolean tryMutate(S7.a block) {
        boolean zTryLock = this.mutex.tryLock(null);
        if (!zTryLock) {
            return zTryLock;
        }
        try {
            block.invoke();
            return zTryLock;
        } finally {
            this.mutex.unlock(null);
        }
    }
}
