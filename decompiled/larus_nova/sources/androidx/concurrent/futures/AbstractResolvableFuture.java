package androidx.concurrent.futures;

import com.byted.cast.common.TeaEventTrack;
import com.google.common.util.concurrent.ListenableFuture;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractResolvableFuture<V> implements ListenableFuture<V> {
    static final AtomicHelper ATOMIC_HELPER = null;
    static final boolean GENERATE_CANCELLATION_CAUSES = false;
    private static final Object NULL = null;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log = null;
    volatile Listener listeners;
    volatile Object value;
    volatile Waiter waiters;

    /* JADX INFO: renamed from: androidx.concurrent.futures.AbstractResolvableFuture$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        public abstract boolean casListeners(AbstractResolvableFuture<?> r100, Listener r101, Listener r102);

        public abstract boolean casValue(AbstractResolvableFuture<?> r100, Object r101, Object r102);

        public abstract boolean casWaiters(AbstractResolvableFuture<?> r100, Waiter r101, Waiter r102);

        public abstract void putNext(Waiter r100, Waiter r101);

        public abstract void putThread(Waiter r100, Thread r101);

        public /* synthetic */ AtomicHelper(AnonymousClass1 r100) {
            this();
        }
    }

    public static final class Cancellation {
        static final Cancellation CAUSELESS_CANCELLED = null;
        static final Cancellation CAUSELESS_INTERRUPTED = null;
        final Throwable cause;
        final boolean wasInterrupted;

        static {
            if (AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES == false) goto L5;
            CAUSELESS_CANCELLED = null;
            CAUSELESS_INTERRUPTED = null;
            return;
        L5:
            CAUSELESS_CANCELLED = new Cancellation(false, null);
            CAUSELESS_INTERRUPTED = new Cancellation(true, null);
        }

        public Cancellation(boolean r100, Throwable r101) {
            this.wasInterrupted = r100;
            this.cause = r101;
        }
    }

    public static final class Failure {
        static final Failure FALLBACK_INSTANCE = null;
        final Throwable exception;

        static {
            final String r100 = "Failure occurred while trying to finish a future.";
            FALLBACK_INSTANCE = new Failure(new AnonymousClass1(r100));
        }

        public Failure(Throwable r100) {
            this.exception = (Throwable) AbstractResolvableFuture.checkNotNull(r100);
        }
    }

    public static final class Listener {
        static final Listener TOMBSTONE = null;
        final Executor executor;
        Listener next;
        final Runnable task;

        static {
            TOMBSTONE = new Listener(null, null);
        }

        public Listener(Runnable r100, Executor r101) {
            this.task = r100;
            this.executor = r101;
        }
    }

    public static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> listenersUpdater;
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> waitersUpdater;

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public void putNext(Waiter r100, Waiter r101) {
            this.waiterNextUpdater.lazySet(r100, r101);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public void putThread(Waiter r100, Thread r101) {
            this.waiterThreadUpdater.lazySet(r100, r101);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casListeners(AbstractResolvableFuture<?> r100, Listener r101, Listener r102) {
            AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> r103 = this.listenersUpdater;
        L4:
            if (r103.compareAndSet(r100, r101, r102) == true) goto L5;
            if (r103.get(r100) == r101) goto L4;
            return false;
        L5:
            return true;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casValue(AbstractResolvableFuture<?> r100, Object r101, Object r102) {
            AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> r103 = this.valueUpdater;
        L4:
            if (r103.compareAndSet(r100, r101, r102) == true) goto L5;
            if (r103.get(r100) == r101) goto L4;
            return false;
        L5:
            return true;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casWaiters(AbstractResolvableFuture<?> r100, Waiter r101, Waiter r102) {
            AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> r103 = this.waitersUpdater;
        L4:
            if (r103.compareAndSet(r100, r101, r102) == true) goto L5;
            if (r103.get(r100) == r101) goto L4;
            return false;
        L5:
            return true;
        }

        public SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> r100, AtomicReferenceFieldUpdater<Waiter, Waiter> r101, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> r102, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> r103, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> r104) {
            super(null);
            this.waiterThreadUpdater = r100;
            this.waiterNextUpdater = r101;
            this.waitersUpdater = r102;
            this.listenersUpdater = r103;
            this.valueUpdater = r104;
        }
    }

    public static final class SetFuture<V> implements Runnable {
        final ListenableFuture<? extends V> future;
        final AbstractResolvableFuture<V> owner;

        @Override // java.lang.Runnable
        public void run() {
            androidx_concurrent_futures_AbstractResolvableFuture$SetFuture_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_concurrent_futures_AbstractResolvableFuture$SetFuture__run$___twin___() {
            if (this.owner.value == this) goto L5;
            return;
        L5:
            Object r100 = AbstractResolvableFuture.getFutureValue(this.future);
            if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(this.owner, this, r100) == false) goto L9;
            AbstractResolvableFuture.complete(this.owner);
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_concurrent_futures_AbstractResolvableFuture$SetFuture_com_larus_apm_impl_protector_RunnableLancet_run(SetFuture r100) {
            r100.androidx_concurrent_futures_AbstractResolvableFuture$SetFuture__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public SetFuture(AbstractResolvableFuture<V> r100, ListenableFuture<? extends V> r101) {
            this.owner = r100;
            this.future = r101;
        }
    }

    public static final class SynchronizedHelper extends AtomicHelper {
        public SynchronizedHelper() {
            super(null);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public void putNext(Waiter r100, Waiter r101) {
            r100.next = r101;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public void putThread(Waiter r100, Thread r101) {
            r100.thread = r101;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casListeners(AbstractResolvableFuture<?> r100, Listener r101, Listener r102) {
            monitor-enter(r100);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (r100.listeners != r101) goto L9;
            r100.listeners = r102;     // Catch: Throwable -> L12
            monitor-exit(r100);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L12
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casValue(AbstractResolvableFuture<?> r100, Object r101, Object r102) {
            monitor-enter(r100);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (r100.value != r101) goto L9;
            r100.value = r102;     // Catch: Throwable -> L12
            monitor-exit(r100);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L12
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casWaiters(AbstractResolvableFuture<?> r100, Waiter r101, Waiter r102) {
            monitor-enter(r100);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (r100.waiters != r101) goto L9;
            r100.waiters = r102;     // Catch: Throwable -> L12
            monitor-exit(r100);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L12
            return false;
        }
    }

    public static final class Waiter {
        static final Waiter TOMBSTONE = null;
        volatile Waiter next;
        volatile Thread thread;

        static {
            TOMBSTONE = new Waiter(false);
        }

        public void unpark() {
            Thread r100 = this.thread;
            if (r100 == null) goto L6;
            this.thread = null;
            LockSupport.unpark(ThreadMethodProxy.getAttachThread(r100));
            return;
        }

        public Waiter() {
            AbstractResolvableFuture.ATOMIC_HELPER.putThread(this, ThreadMethodProxy.currentThread());
        }

        public Waiter(boolean r100) {
        }

        public void setNext(Waiter r100) {
            AbstractResolvableFuture.ATOMIC_HELPER.putNext(this, r100);
        }
    }

    public void afterDone() {
    }

    public void interruptTask() {
    }

    static {
        GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        log = Logger.getLogger(AbstractResolvableFuture.class.getName());
        AtomicHelper r100 = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, TeaEventTrack.ACTION_DRAMA_NEXT), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "value"));     // Catch: Throwable -> L5
        Throwable r101 = null;
    L7:
        ATOMIC_HELPER = r100;
        if (r101 == null) goto L10;
        log.log(Level.SEVERE, "SafeAtomicHelper is broken!", r101);
    L10:
        NULL = new Object();
        return;
    L5:
        th = move-exception;
        r101 = th;
        r100 = new SynchronizedHelper();
        goto L7
    }

    private void releaseWaiters() {
    L2:
        Waiter r100 = this.waiters;
        if (ATOMIC_HELPER.casWaiters(this, r100, Waiter.TOMBSTONE) == false) goto L2;
    L4:
        if (r100 == null) goto L6;
        r100.unpark();
        r100 = r100.next;
        goto L4
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object r100 = this.value;
        if (r100 == null) goto L5;
        boolean r101 = true;
    L7:
        return (!(r100 instanceof SetFuture)) & r101;
    L5:
        r101 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String pendingToString() {
        Object r100 = this.value;
        if ((r100 instanceof SetFuture) == false) goto L7;
        return "setFuture=[" + userObjectToString(((SetFuture) r100).future) + "]";
    L7:
        if ((this instanceof ScheduledFuture) == true) goto L9;
        return null;
    L9:
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(super.toString());
        r100.append("[status=");
        if (isCancelled() == false) goto L6;
        r100.append("CANCELLED");
    L20:
        r100.append("]");
        return r100.toString();
    L6:
        if (isDone() == false) goto L22;
        addDoneString(r100);
        goto L20
    L22:
        String r101 = pendingToString();     // Catch: RuntimeException -> L10
    L12:
        if (r101 == null) goto L17;
        if (r101.isEmpty() == true) goto L17;
        r100.append("PENDING, info=[");
        r100.append(r101);
        r100.append("]");
    L17:
        if (isDone() == false) goto L19;
        addDoneString(r100);
        goto L20
    L19:
        r100.append("PENDING");
    L10:
        e = move-exception;
        r101 = "Exception thrown from implementation: " + e.getClass();
        goto L12
    }

    public final boolean wasInterrupted() {
        Object r100 = this.value;
        if ((r100 instanceof Cancellation) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Cancellation) r100).wasInterrupted == false) goto L7;
        return true;
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        if (Thread.interrupted() == true) goto L34;
        Object r100 = this.value;
        if (r100 == null) goto L7;
        boolean r101 = true;
    L9:
        if ((r101 & (!(r100 instanceof SetFuture))) == true) goto L11;
        Waiter r102 = this.waiters;
        if (r102 == Waiter.TOMBSTONE) goto L32;
        Waiter r103 = new Waiter();
    L15:
        r103.setNext(r102);
        if (ATOMIC_HELPER.casWaiters(this, r102, r103) == true) goto L17;
        r102 = this.waiters;
        if (r102 != Waiter.TOMBSTONE) goto L15;
    L17:
        LockSupport.park(this);
        if (Thread.interrupted() == true) goto L27;
        Object r104 = this.value;
        if (r104 == null) goto L22;
        boolean r105 = true;
    L24:
        if ((r105 & (!(r104 instanceof SetFuture))) == false) goto L17;
        return getDoneValue(r104);
    L22:
        r105 = false;
        goto L24
    L27:
        removeWaiter(r103);
        throw new InterruptedException();
    L32:
        return getDoneValue(this.value);
    L11:
        return getDoneValue(r100);
    L7:
        r101 = false;
        goto L9
    L34:
        throw new InterruptedException();
    }

    public AbstractResolvableFuture() {
    }

    private void addDoneString(StringBuilder r100) {
        Object r101 = getUninterruptibly(this);     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
        r100.append("SUCCESS, result=[");     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
        r100.append(userObjectToString(r101));     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
        r100.append("]");     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
    L15:
        return;
    L7:
        r100.append("CANCELLED");
        return;
    L5:
        e = move-exception;
        r100.append("UNKNOWN, cause=[");
        r100.append(e.getClass());
        r100.append(" thrown from get()]");
        return;
    L8:
        e = move-exception;
        r100.append("FAILURE, cause=[");
        r100.append(e.getCause());
        r100.append("]");
    }

    public static <T> T checkNotNull(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw null;
    }

    private Listener clearListeners(Listener r100) {
    L2:
        Listener r101 = this.listeners;
        if (ATOMIC_HELPER.casListeners(this, r101, Listener.TOMBSTONE) == false) goto L2;
        Listener r102 = r100;
        Listener r103 = r101;
    L5:
        if (r103 == null) goto L7;
        Listener r104 = r103.next;
        r103.next = r102;
        r102 = r103;
        r103 = r104;
        goto L5
    L7:
        return r102;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void complete(AbstractResolvableFuture<V> r100) {
        Listener r101 = null;
    L3:
        r100.releaseWaiters();
        r100.afterDone();
        Listener r102 = r100.clearListeners(r101);
    L4:
        if (r102 == null) goto L14;
        r101 = r102.next;
        Runnable r103 = r102.task;
        if ((r103 instanceof SetFuture) == false) goto L12;
        SetFuture r104 = (SetFuture) r103;
        r100 = r104.owner;
        if (r100.value != r104) goto L13;
        Object r105 = getFutureValue(r104.future);
        if (ATOMIC_HELPER.casValue(r100, r104, r105) == true) goto L3;
    L13:
        r102 = r101;
        goto L4
    L12:
        executeListener(r103, r102.executor);
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V getDoneValue(Object r100) throws ExecutionException {
        if ((r100 instanceof Cancellation) == true) goto L13;
        if ((r100 instanceof Failure) == true) goto L11;
        if (r100 != NULL) goto L14;
        return null;
    L14:
        return r100;
    L11:
        throw new ExecutionException(((Failure) r100).exception);
    L13:
        throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation) r100).cause);
    }

    public static Object getFutureValue(ListenableFuture<?> r100) {
        if ((r100 instanceof AbstractResolvableFuture) == false) goto L13;
        Object r101 = ((AbstractResolvableFuture) r100).value;
        if ((r101 instanceof Cancellation) == false) goto L35;
        Cancellation r102 = (Cancellation) r101;
        if (r102.wasInterrupted == true) goto L9;
        return r101;
    L9:
        if (r102.cause == null) goto L12;
        return new Cancellation(false, r102.cause);
    L12:
        return Cancellation.CAUSELESS_CANCELLED;
    L35:
        return r101;
    L13:
        boolean r103 = r100.isCancelled();
        if (((!GENERATE_CANCELLATION_CAUSES) & r103) == true) goto L16;
        Object r104 = getUninterruptibly(r100);     // Catch: Throwable -> L21 CancellationException -> L24 ExecutionException -> L30
        if (r104 != null) goto L38;
        return NULL;
    L38:
        return r104;
    L24:
        e = move-exception;
        if (r103 == true) goto L29;
        return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + r100, e));
    L29:
        return new Cancellation(false, e);
    L30:
        e = move-exception;
        return new Failure(e.getCause());
    L21:
        th = move-exception;
        return new Failure(th);
    L16:
        return Cancellation.CAUSELESS_CANCELLED;
    }

    public static <V> V getUninterruptibly(Future<V> r100) throws ExecutionException {
        boolean r101 = false;
    L12:
        V r102 = r100.get();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r101 == false) goto L6;
        ThreadMethodProxy.currentThread().interrupt();
    L6:
        return r102;
    L11:
        r101 = true;
    L7:
        th = move-exception;
        if (r101 == false) goto L10;
        ThreadMethodProxy.currentThread().interrupt();
    L10:
        throw th;
    }

    private void removeWaiter(Waiter r100) {
        r100.thread = null;
    L3:
        Waiter r101 = this.waiters;
        if (r101 == Waiter.TOMBSTONE) goto L5;
        Waiter r102 = null;
    L7:
        if (r101 == null) goto L19;
        Waiter r103 = r101.next;
        if (r101.thread == null) goto L11;
        r102 = r101;
    L18:
        r101 = r103;
        goto L7
    L11:
        if (r102 == null) goto L16;
        r102.next = r103;
        if (r102.thread != null) goto L18;
    L16:
        if (ATOMIC_HELPER.casWaiters(this, r101, r103) == true) goto L18;
    L19:
        return;
    }

    private String userObjectToString(Object r100) {
        if (r100 != this) goto L6;
        return "this future";
    L6:
        return String.valueOf(r100);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r100) {
        Object r101 = this.value;
        if (r101 != null) goto L5;
        boolean r102 = true;
    L7:
        if ((r102 | (r101 instanceof SetFuture)) == true) goto L9;
        return false;
    L9:
        if (GENERATE_CANCELLATION_CAUSES == false) goto L11;
        Cancellation r103 = new Cancellation(r100, new CancellationException("Future.cancel() was called."));
    L14:
        boolean r104 = false;
        AbstractResolvableFuture<V> r105 = this;
    L16:
        if (ATOMIC_HELPER.casValue(r105, r101, r103) == true) goto L17;
        r101 = r105.value;
        if ((r101 instanceof SetFuture) == true) goto L16;
        return r104;
    L17:
        if (r100 == false) goto L19;
        r105.interruptTask();
    L19:
        complete(r105);
        if ((r101 instanceof SetFuture) == false) goto L47;
        ListenableFuture<? extends V> r106 = ((SetFuture) r101).future;
        if ((r106 instanceof AbstractResolvableFuture) == false) goto L30;
        r105 = (AbstractResolvableFuture) r106;
        r101 = r105.value;
        if (r101 != null) goto L26;
        boolean r107 = true;
    L28:
        if ((r107 | (r101 instanceof SetFuture)) == false) goto L48;
        r104 = true;
        goto L16
    L48:
        return true;
    L26:
        r107 = false;
        goto L28
    L30:
        r106.cancel(r100);
        return true;
    L47:
        return true;
    L11:
        if (r100 == false) goto L13;
        r103 = Cancellation.CAUSELESS_INTERRUPTED;
        goto L14
    L13:
        r103 = Cancellation.CAUSELESS_CANCELLED;
        goto L14
    L5:
        r102 = false;
        goto L7
    }

    public final void maybePropagateCancellationTo(Future<?> r100) {
        if (r100 == null) goto L4;
        boolean r101 = true;
    L6:
        if ((r101 & isCancelled()) == false) goto L9;
        r100.cancel(wasInterrupted());
        return;
    L9:
        return;
    L4:
        r101 = false;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean set(V r100) {
        if (r100 != null) goto L5;
        r100 = (V) NULL;
    L5:
        if (ATOMIC_HELPER.casValue(this, null, r100) == false) goto L8;
        complete(this);
        return true;
    L8:
        return false;
    }

    public boolean setException(Throwable r100) {
        Failure r101 = new Failure((Throwable) checkNotNull(r100));
        if (ATOMIC_HELPER.casValue(this, null, r101) == false) goto L6;
        complete(this);
        return true;
    L6:
        return false;
    }

    public boolean setFuture(ListenableFuture<? extends V> r100) {
        checkNotNull(r100);
        Object r101 = this.value;
        if (r101 != null) goto L23;
        if (r100.isDone() == false) goto L11;
        Object r102 = getFutureValue(r100);
        if (ATOMIC_HELPER.casValue(this, null, r102) == false) goto L10;
        complete(this);
        return true;
    L10:
        return false;
    L11:
        SetFuture r103 = new SetFuture(this, r100);
        if (ATOMIC_HELPER.casValue(this, null, r103) == true) goto L26;
        r101 = this.value;
        goto L23
    L26:
        r100.addListener(r103, DirectExecutor.INSTANCE);     // Catch: Throwable -> L15
    L20:
        return true;
    L15:
        th = move-exception;
        Failure r104 = new Failure(th);     // Catch: Throwable -> L18
    L19:
        ATOMIC_HELPER.casValue(this, r103, r104);
    L18:
        r104 = Failure.FALLBACK_INSTANCE;
    L23:
        if ((r101 instanceof Cancellation) == false) goto L25;
        r100.cancel(((Cancellation) r101).wasInterrupted);
    L25:
        return false;
    }

    private static CancellationException cancellationExceptionWithCause(String r100, Throwable r101) {
        CancellationException r102 = new CancellationException(r100);
        r102.initCause(r101);
        return r102;
    }

    private static void executeListener(Runnable r100, Executor r101) {
        r101.execute(r100);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        log.log(Level.SEVERE, "RuntimeException while executing runnable " + r100 + " with executor " + r101, e);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable r100, Executor r101) {
        checkNotNull(r100);
        checkNotNull(r101);
        Listener r102 = this.listeners;
        if (r102 == Listener.TOMBSTONE) goto L10;
        Listener r103 = new Listener(r100, r101);
    L5:
        r103.next = r102;
        if (ATOMIC_HELPER.casListeners(this, r102, r103) == true) goto L7;
        r102 = this.listeners;
        if (r102 != Listener.TOMBSTONE) goto L5;
    L7:
        return;
    L10:
        executeListener(r100, r101);
    }

    @Override // java.util.concurrent.Future
    public final V get(long r210, TimeUnit r211) throws InterruptedException, TimeoutException, ExecutionException {
        long r100 = r211.toNanos(r210);
        if (Thread.interrupted() == true) goto L81;
        Object r101 = this.value;
        if (r101 == null) goto L7;
        boolean r102 = true;
    L9:
        if ((r102 & (!(r101 instanceof SetFuture))) == false) goto L13;
        return getDoneValue(r101);
    L13:
        if (r100 <= 0) goto L15;
        long r110 = System.nanoTime() + r100;
    L17:
        if (r100 < 1000) goto L43;
        Waiter r103 = this.waiters;
        if (r103 == Waiter.TOMBSTONE) goto L41;
        Waiter r111 = new Waiter();
    L21:
        r111.setNext(r103);
        if (ATOMIC_HELPER.casWaiters(this, r103, r111) == true) goto L23;
        r103 = this.waiters;
        if (r103 != Waiter.TOMBSTONE) goto L21;
    L23:
        LockSupport.parkNanos(this, r100);
        if (Thread.interrupted() == true) goto L36;
        Object r104 = this.value;
        if (r104 == null) goto L28;
        boolean r105 = true;
    L30:
        if ((r105 & (!(r104 instanceof SetFuture))) == true) goto L32;
        r100 = r110 - System.nanoTime();
        if (r100 >= 1000) goto L23;
        removeWaiter(r111);
        goto L43
    L32:
        return getDoneValue(r104);
    L28:
        r105 = false;
        goto L30
    L36:
        removeWaiter(r111);
        throw new InterruptedException();
    L41:
        return getDoneValue(this.value);
    L43:
        if (r100 <= 0) goto L57;
        Object r106 = this.value;
        if (r106 == null) goto L47;
        boolean r107 = true;
    L49:
        if ((r107 & (!(r106 instanceof SetFuture))) == true) goto L51;
        if (Thread.interrupted() == true) goto L56;
        r100 = r110 - System.nanoTime();
        goto L43
    L56:
        throw new InterruptedException();
    L51:
        return getDoneValue(r106);
    L47:
        r107 = false;
        goto L49
    L57:
        String r108 = toString();
        String r109 = r211.toString();
        Locale r112 = Locale.ROOT;
        String r113 = r109.toLowerCase(r112);
        String r114 = "Waited " + r210 + " " + r211.toString().toLowerCase(r112);
        if ((r100 + 1000) >= 0) goto L75;
        String r115 = r114 + " (plus ";
        long r116 = -r100;
        long r117 = r211.convert(r116, TimeUnit.NANOSECONDS);
        long r118 = r116 - r211.toNanos(r117);
        if (r117 != 0) goto L62;
    L65:
        boolean r119 = true;
    L66:
        if (r117 <= 0) goto L71;
        String r120 = r115 + r117 + " " + r113;
        if (r119 == false) goto L70;
        r120 = r120 + ",";
    L70:
        r115 = r120 + " ";
    L71:
        if (r119 == false) goto L73;
        r115 = r115 + r118 + " nanoseconds ";
    L73:
        r114 = r115 + "delay)";
        goto L75
    L62:
        if (r118 > 1000) goto L65;
        r119 = false;
    L75:
        if (isDone() == false) goto L79;
        throw new TimeoutException(r114 + " but future completed as timeout expired");
    L79:
        throw new TimeoutException(r114 + " for " + r108);
    L15:
        r110 = 0;
        goto L17
    L7:
        r102 = false;
        goto L9
    L81:
        throw new InterruptedException();
    }
}
