package com.google.common.util.concurrent;

import com.bytedance.apm.constant.CommonKey;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.j2objc.annotations.ReflectionSupport;
import java.security.AccessController;
import java.security.PrivilegedActionException;
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
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
@ReflectionSupport(ReflectionSupport.Level.FULL)
@GwtCompatible(emulated = true)
public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {
    private static final AtomicHelper ATOMIC_HELPER = null;
    private static final boolean GENERATE_CANCELLATION_CAUSES = false;
    private static final Object NULL = null;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log = null;

    @NullableDecl
    private volatile Listener listeners;

    @NullableDecl
    private volatile Object value;

    @NullableDecl
    private volatile Waiter waiters;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractFuture$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        public abstract boolean casListeners(AbstractFuture<?> r10, Listener r11, Listener r12);

        public abstract boolean casValue(AbstractFuture<?> r10, Object r11, Object r12);

        public abstract boolean casWaiters(AbstractFuture<?> r10, Waiter r11, Waiter r12);

        public abstract void putNext(Waiter r10, Waiter r11);

        public abstract void putThread(Waiter r10, Thread r11);

        public /* synthetic */ AtomicHelper(AnonymousClass1 r10) {
            this();
        }
    }

    public static final class Cancellation {
        static final Cancellation CAUSELESS_CANCELLED = null;
        static final Cancellation CAUSELESS_INTERRUPTED = null;

        @NullableDecl
        final Throwable cause;
        final boolean wasInterrupted;

        static {
            if (AbstractFuture.access$300() == false) goto L5;
            CAUSELESS_CANCELLED = null;
            CAUSELESS_INTERRUPTED = null;
            return;
        L5:
            CAUSELESS_CANCELLED = new Cancellation(false, null);
            CAUSELESS_INTERRUPTED = new Cancellation(true, null);
        }

        public Cancellation(boolean r10, @NullableDecl Throwable r11) {
            this.wasInterrupted = r10;
            this.cause = r11;
        }
    }

    public static final class Failure {
        static final Failure FALLBACK_INSTANCE = null;
        final Throwable exception;

        static {
            final String r10 = "Failure occurred while trying to finish a future.";
            FALLBACK_INSTANCE = new Failure(new AnonymousClass1(r10));
        }

        public Failure(Throwable r10) {
            this.exception = (Throwable) Preconditions.checkNotNull(r10);
        }
    }

    public static final class Listener {
        static final Listener TOMBSTONE = null;
        final Executor executor;

        @NullableDecl
        Listener next;
        final Runnable task;

        static {
            TOMBSTONE = new Listener(null, null);
        }

        public Listener(Runnable r10, Executor r11) {
            this.task = r10;
            this.executor = r11;
        }
    }

    public static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater<AbstractFuture, Listener> listenersUpdater;
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> waitersUpdater;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> r10, AtomicReferenceFieldUpdater<Waiter, Waiter> r11, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> r12, AtomicReferenceFieldUpdater<AbstractFuture, Listener> r13, AtomicReferenceFieldUpdater<AbstractFuture, Object> r14) {
            super(null);
            this.waiterThreadUpdater = r10;
            this.waiterNextUpdater = r11;
            this.waitersUpdater = r12;
            this.listenersUpdater = r13;
            this.valueUpdater = r14;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casListeners(AbstractFuture<?> r10, Listener r11, Listener r12) {
            return androidx.concurrent.futures.a.a(this.listenersUpdater, r10, r11, r12);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casValue(AbstractFuture<?> r10, Object r11, Object r12) {
            return androidx.concurrent.futures.a.a(this.valueUpdater, r10, r11, r12);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casWaiters(AbstractFuture<?> r10, Waiter r11, Waiter r12) {
            return androidx.concurrent.futures.a.a(this.waitersUpdater, r10, r11, r12);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putNext(Waiter r10, Waiter r11) {
            this.waiterNextUpdater.lazySet(r10, r11);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putThread(Waiter r10, Thread r11) {
            this.waiterThreadUpdater.lazySet(r10, r11);
        }
    }

    public static final class SetFuture<V> implements Runnable {
        final ListenableFuture<? extends V> future;
        final AbstractFuture<V> owner;

        public SetFuture(AbstractFuture<V> r10, ListenableFuture<? extends V> r11) {
            this.owner = r10;
            this.future = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbstractFuture.access$400(this.owner) == this) goto L5;
            return;
        L5:
            Object r10 = AbstractFuture.access$500(this.future);
            if (AbstractFuture.access$200().casValue(this.owner, this, r10) == false) goto L9;
            AbstractFuture.access$600(this.owner);
            return;
        }
    }

    public static final class SynchronizedHelper extends AtomicHelper {
        private SynchronizedHelper() {
            super(null);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casListeners(AbstractFuture<?> r10, Listener r11, Listener r12) {
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (AbstractFuture.access$900(r10) != r11) goto L11;
            AbstractFuture.access$902(r10, r12);     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return true;
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return false;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casValue(AbstractFuture<?> r10, Object r11, Object r12) {
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (AbstractFuture.access$400(r10) != r11) goto L11;
            AbstractFuture.access$402(r10, r12);     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return true;
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return false;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casWaiters(AbstractFuture<?> r10, Waiter r11, Waiter r12) {
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (AbstractFuture.access$800(r10) != r11) goto L11;
            AbstractFuture.access$802(r10, r12);     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return true;
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return false;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putNext(Waiter r10, Waiter r11) {
            r10.next = r11;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putThread(Waiter r10, Thread r11) {
            r10.thread = r11;
        }

        public /* synthetic */ SynchronizedHelper(AnonymousClass1 r10) {
            this();
        }
    }

    public interface Trusted<V> extends ListenableFuture<V> {
    }

    public static abstract class TrustedFuture<V> extends AbstractFuture<V> implements Trusted<V> {
        public TrustedFuture() {
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public final void addListener(Runnable r10, Executor r11) {
            super.addListener(r10, r11);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final boolean cancel(boolean r10) {
            return super.cancel(r10);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get(long r10, TimeUnit r11) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(r10, r11);
        }
    }

    public static final class UnsafeAtomicHelper extends AtomicHelper {
        static final long LISTENERS_OFFSET = 0;
        static final Unsafe UNSAFE = null;
        static final long VALUE_OFFSET = 0;
        static final long WAITERS_OFFSET = 0;
        static final long WAITER_NEXT_OFFSET = 0;
        static final long WAITER_THREAD_OFFSET = 0;

        static {
            Unsafe r10 = Unsafe.getUnsafe();     // Catch: SecurityException -> L5
        L16:
            WAITERS_OFFSET = r10.objectFieldOffset(AbstractFuture.class.getDeclaredField("waiters"));     // Catch: Exception -> L8
            LISTENERS_OFFSET = r10.objectFieldOffset(AbstractFuture.class.getDeclaredField("listeners"));     // Catch: Exception -> L8
            VALUE_OFFSET = r10.objectFieldOffset(AbstractFuture.class.getDeclaredField(CommonKey.KEY_VALUE));     // Catch: Exception -> L8
            WAITER_THREAD_OFFSET = r10.objectFieldOffset(Waiter.class.getDeclaredField("thread"));     // Catch: Exception -> L8
            WAITER_NEXT_OFFSET = r10.objectFieldOffset(Waiter.class.getDeclaredField("next"));     // Catch: Exception -> L8
            UNSAFE = r10;     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            Throwables.throwIfUnchecked(e);
            throw new RuntimeException(e);
        L5:
            r10 = (Unsafe) AccessController.doPrivileged(new AnonymousClass1());     // Catch: PrivilegedActionException -> L11
        L11:
            e = move-exception;
            throw new RuntimeException("Could not initialize intrinsics", e.getCause());
        }

        private UnsafeAtomicHelper() {
            super(null);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casListeners(AbstractFuture<?> r10, Listener r11, Listener r12) {
            return a.a(UNSAFE, r10, LISTENERS_OFFSET, r11, r12);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casValue(AbstractFuture<?> r10, Object r11, Object r12) {
            return a.a(UNSAFE, r10, VALUE_OFFSET, r11, r12);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean casWaiters(AbstractFuture<?> r10, Waiter r11, Waiter r12) {
            return a.a(UNSAFE, r10, WAITERS_OFFSET, r11, r12);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putNext(Waiter r10, Waiter r11) {
            UNSAFE.putObject(r10, WAITER_NEXT_OFFSET, r11);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void putThread(Waiter r10, Thread r11) {
            UNSAFE.putObject(r10, WAITER_THREAD_OFFSET, r11);
        }

        public /* synthetic */ UnsafeAtomicHelper(AnonymousClass1 r10) {
            this();
        }
    }

    public static final class Waiter {
        static final Waiter TOMBSTONE = null;

        @NullableDecl
        volatile Waiter next;

        @NullableDecl
        volatile Thread thread;

        static {
            TOMBSTONE = new Waiter(false);
        }

        public Waiter(boolean r10) {
        }

        public void setNext(Waiter r10) {
            AbstractFuture.access$200().putNext(this, r10);
        }

        public void unpark() {
            Thread r10 = this.thread;
            if (r10 == null) goto L6;
            this.thread = null;
            LockSupport.unpark(r10);
            return;
        }

        public Waiter() {
            AbstractFuture.access$200().putThread(this, Thread.currentThread());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.common.util.concurrent.AbstractFuture$1] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    static {
        GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        log = Logger.getLogger(AbstractFuture.class.getName());
        ?? r10 = 0;
        r10 = 0;
        AtomicHelper r11 = new UnsafeAtomicHelper(r10);     // Catch: Throwable -> L5
        th = null;
    L10:
        ATOMIC_HELPER = r11;
        if (r10 == 0) goto L13;
        ?? r12 = log;
        Level r13 = Level.SEVERE;
        r12.log(r13, "UnsafeAtomicHelper is broken!", th);
        r12.log(r13, "SafeAtomicHelper is broken!", r10);
    L13:
        NULL = new Object();
        return;
    L5:
        th = th;
        r11 = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, CommonKey.KEY_VALUE));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r11 = new SynchronizedHelper(r10);
        r10 = th;
        goto L10
    }

    public AbstractFuture() {
    }

    public static /* synthetic */ AtomicHelper access$200() {
        return ATOMIC_HELPER;
    }

    public static /* synthetic */ boolean access$300() {
        return GENERATE_CANCELLATION_CAUSES;
    }

    public static /* synthetic */ Object access$400(AbstractFuture r10) {
        return r10.value;
    }

    public static /* synthetic */ Object access$402(AbstractFuture r10, Object r11) {
        r10.value = r11;
        return r11;
    }

    public static /* synthetic */ Object access$500(ListenableFuture r10) {
        return getFutureValue(r10);
    }

    public static /* synthetic */ void access$600(AbstractFuture r10) {
        complete(r10);
    }

    public static /* synthetic */ Waiter access$800(AbstractFuture r10) {
        return r10.waiters;
    }

    public static /* synthetic */ Waiter access$802(AbstractFuture r10, Waiter r11) {
        r10.waiters = r11;
        return r11;
    }

    public static /* synthetic */ Listener access$900(AbstractFuture r10) {
        return r10.listeners;
    }

    public static /* synthetic */ Listener access$902(AbstractFuture r10, Listener r11) {
        r10.listeners = r11;
        return r11;
    }

    private void addDoneString(StringBuilder r10) {
        Object r11 = getUninterruptibly(this);     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
        r10.append("SUCCESS, result=[");     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
        r10.append(userObjectToString(r11));     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
        r10.append("]");     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
    L17:
        return;
    L10:
        r10.append("CANCELLED");
        return;
    L5:
        e = move-exception;
        r10.append("UNKNOWN, cause=[");
        r10.append(e.getClass());
        r10.append(" thrown from get()]");
        return;
    L7:
        e = move-exception;
        r10.append("FAILURE, cause=[");
        r10.append(e.getCause());
        r10.append("]");
    }

    private static CancellationException cancellationExceptionWithCause(@NullableDecl String r10, @NullableDecl Throwable r11) {
        CancellationException r12 = new CancellationException(r10);
        r12.initCause(r11);
        return r12;
    }

    private Listener clearListeners(Listener r10) {
    L2:
        Listener r11 = this.listeners;
        if (ATOMIC_HELPER.casListeners(this, r11, Listener.TOMBSTONE) == false) goto L2;
    L4:
        Listener r12 = r10;
        r10 = r11;
        if (r10 == null) goto L7;
        r11 = r10.next;
        r10.next = r12;
        goto L4
    L7:
        return r12;
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
    private static void complete(AbstractFuture<V> r10) {
        Listener r11 = null;
    L3:
        r10.releaseWaiters();
        r10.afterDone();
        Listener r12 = r10.clearListeners(r11);
    L4:
        if (r12 == null) goto L14;
        r11 = r12.next;
        Runnable r13 = r12.task;
        if ((r13 instanceof SetFuture) == false) goto L12;
        SetFuture r14 = (SetFuture) r13;
        r10 = r14.owner;
        if (((AbstractFuture) r10).value != r14) goto L13;
        Object r15 = getFutureValue(r14.future);
        if (ATOMIC_HELPER.casValue(r10, r14, r15) == true) goto L3;
    L13:
        r12 = r11;
        goto L4
    L12:
        executeListener(r13, r12.executor);
        goto L13
    }

    private static void executeListener(Runnable r10, Executor r11) {
        r11.execute(r10);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        log.log(Level.SEVERE, "RuntimeException while executing runnable " + r10 + " with executor " + r11, e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V getDoneValue(Object r10) throws ExecutionException {
        if ((r10 instanceof Cancellation) == true) goto L14;
        if ((r10 instanceof Failure) == true) goto L12;
        if (r10 != NULL) goto L10;
        return null;
    L10:
        return r10;
    L12:
        throw new ExecutionException(((Failure) r10).exception);
    L14:
        throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation) r10).cause);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Object getFutureValue(ListenableFuture<?> r10) {
        if ((r10 instanceof Trusted) == false) goto L14;
        Object r11 = ((AbstractFuture) r10).value;
        if ((r11 instanceof Cancellation) == false) goto L49;
        Cancellation r12 = (Cancellation) r11;
        if (r12.wasInterrupted == true) goto L9;
        return r11;
    L9:
        if (r12.cause == null) goto L12;
        return new Cancellation(false, r12.cause);
    L12:
        return Cancellation.CAUSELESS_CANCELLED;
    L49:
        return r11;
    L14:
        if ((r10 instanceof InternalFutureFailureAccess) == false) goto L19;
        Throwable r13 = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) r10);
        if (r13 == null) goto L19;
        return new Failure(r13);
    L19:
        boolean r14 = r10.isCancelled();
        if (((!GENERATE_CANCELLATION_CAUSES) & r14) == true) goto L22;
        Object r15 = getUninterruptibly(r10);     // Catch: Throwable -> L27 CancellationException -> L29 ExecutionException -> L31
        if (r14 == true) goto L26;
        if (r15 == null) goto L35;
        return r15;
    L35:
        return NULL;
    L26:
        return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + r10));
    L29:
        e = move-exception;
        if (r14 == true) goto L42;
        return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + r10, e));
    L42:
        return new Cancellation(false, e);
    L31:
        e = move-exception;
        if (r14 == false) goto L47;
        return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + r10, e));
    L47:
        return new Failure(e.getCause());
    L27:
        th = move-exception;
        return new Failure(th);
    L22:
        return Cancellation.CAUSELESS_CANCELLED;
    }

    private static <V> V getUninterruptibly(Future<V> r10) throws ExecutionException {
        boolean r11 = false;
    L12:
        V r12 = r10.get();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r11 == false) goto L6;
        Thread.currentThread().interrupt();
    L6:
        return r12;
    L11:
        r11 = true;
    L7:
        th = move-exception;
        if (r11 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    private void releaseWaiters() {
    L2:
        Waiter r10 = this.waiters;
        if (ATOMIC_HELPER.casWaiters(this, r10, Waiter.TOMBSTONE) == false) goto L2;
    L4:
        if (r10 == null) goto L6;
        r10.unpark();
        r10 = r10.next;
        goto L4
    }

    private void removeWaiter(Waiter r10) {
        r10.thread = null;
    L3:
        Waiter r11 = this.waiters;
        if (r11 == Waiter.TOMBSTONE) goto L5;
        Waiter r12 = null;
    L7:
        if (r11 == null) goto L19;
        Waiter r13 = r11.next;
        if (r11.thread == null) goto L11;
        r12 = r11;
    L18:
        r11 = r13;
        goto L7
    L11:
        if (r12 == null) goto L16;
        r12.next = r13;
        if (r12.thread != null) goto L18;
    L16:
        if (ATOMIC_HELPER.casWaiters(this, r11, r13) == true) goto L18;
    L19:
        return;
    }

    private String userObjectToString(Object r10) {
        if (r10 != this) goto L6;
        return "this future";
    L6:
        return String.valueOf(r10);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable r10, Executor r11) {
        Preconditions.checkNotNull(r10, "Runnable was null.");
        Preconditions.checkNotNull(r11, "Executor was null.");
        if (isDone() == true) goto L12;
        Listener r12 = this.listeners;
        if (r12 == Listener.TOMBSTONE) goto L12;
        Listener r13 = new Listener(r10, r11);
    L7:
        r13.next = r12;
        if (ATOMIC_HELPER.casListeners(this, r12, r13) == true) goto L9;
        r12 = this.listeners;
        if (r12 != Listener.TOMBSTONE) goto L7;
    L9:
        return;
    L12:
        executeListener(r10, r11);
    }

    @Beta
    @ForOverride
    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public boolean cancel(boolean r10) {
        Object r11 = this.value;
        if (r11 != null) goto L5;
        boolean r12 = true;
    L7:
        if ((r12 | (r11 instanceof SetFuture)) == false) goto L35;
        if (GENERATE_CANCELLATION_CAUSES == false) goto L11;
        Cancellation r13 = new Cancellation(r10, new CancellationException("Future.cancel() was called."));
    L14:
        boolean r14 = false;
    L16:
        if (ATOMIC_HELPER.casValue(this, r11, r13) == true) goto L17;
        r11 = this.value;
        if ((r11 instanceof SetFuture) == true) goto L16;
        return r14;
    L17:
        if (r10 == false) goto L19;
        this.interruptTask();
    L19:
        complete(this);
        if ((r11 instanceof SetFuture) == false) goto L47;
        ListenableFuture<? extends V> r15 = ((SetFuture) r11).future;
        if ((r15 instanceof Trusted) == false) goto L30;
        AbstractFuture<V> this = (AbstractFuture) r15;
        r11 = this.value;
        if (r11 != null) goto L26;
        boolean r16 = true;
    L28:
        if ((r16 | (r11 instanceof SetFuture)) == false) goto L48;
        r14 = true;
        goto L16
    L48:
        return true;
    L26:
        r16 = false;
        goto L28
    L30:
        r15.cancel(r10);
        return true;
    L47:
        return true;
    L11:
        if (r10 == false) goto L13;
        r13 = Cancellation.CAUSELESS_INTERRUPTED;
        goto L14
    L13:
        r13 = Cancellation.CAUSELESS_CANCELLED;
        goto L14
    L35:
        return false;
    L5:
        r12 = false;
        goto L7
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public V get(long r20, TimeUnit r22) throws InterruptedException, TimeoutException, ExecutionException {
        long r10 = r22.toNanos(r20);
        if (Thread.interrupted() == true) goto L81;
        Object r11 = this.value;
        if (r11 == null) goto L7;
        boolean r12 = true;
    L9:
        if ((r12 & (!(r11 instanceof SetFuture))) == false) goto L13;
        return getDoneValue(r11);
    L13:
        if (r10 <= 0) goto L15;
        long r13 = System.nanoTime() + r10;
    L17:
        if (r10 < 1000) goto L43;
        Waiter r14 = this.waiters;
        if (r14 == Waiter.TOMBSTONE) goto L41;
        Waiter r15 = new Waiter();
    L21:
        r15.setNext(r14);
        if (ATOMIC_HELPER.casWaiters(this, r14, r15) == true) goto L23;
        r14 = this.waiters;
        if (r14 != Waiter.TOMBSTONE) goto L21;
    L23:
        LockSupport.parkNanos(this, r10);
        if (Thread.interrupted() == true) goto L36;
        Object r16 = this.value;
        if (r16 == null) goto L28;
        boolean r17 = true;
    L30:
        if ((r17 & (!(r16 instanceof SetFuture))) == true) goto L32;
        r10 = r13 - System.nanoTime();
        if (r10 >= 1000) goto L23;
        removeWaiter(r15);
        goto L43
    L32:
        return getDoneValue(r16);
    L28:
        r17 = false;
        goto L30
    L36:
        removeWaiter(r15);
        throw new InterruptedException();
    L41:
        return getDoneValue(this.value);
    L43:
        if (r10 <= 0) goto L57;
        Object r18 = this.value;
        if (r18 == null) goto L47;
        boolean r19 = true;
    L49:
        if ((r19 & (!(r18 instanceof SetFuture))) == true) goto L51;
        if (Thread.interrupted() == true) goto L56;
        r10 = r13 - System.nanoTime();
        goto L43
    L56:
        throw new InterruptedException();
    L51:
        return getDoneValue(r18);
    L47:
        r19 = false;
        goto L49
    L57:
        String r21 = toString();
        String r23 = r22.toString();
        Locale r110 = Locale.ROOT;
        String r24 = r23.toLowerCase(r110);
        String r25 = "Waited " + r20 + " " + r22.toString().toLowerCase(r110);
        if ((r10 + 1000) >= 0) goto L75;
        String r26 = r25 + " (plus ";
        long r27 = -r10;
        long r111 = r22.convert(r27, TimeUnit.NANOSECONDS);
        long r28 = r27 - r22.toNanos(r111);
        if (r111 != 0) goto L62;
    L65:
        boolean r112 = true;
    L66:
        if (r111 <= 0) goto L71;
        String r29 = r26 + r111 + " " + r24;
        if (r112 == false) goto L70;
        r29 = r29 + ",";
    L70:
        r26 = r29 + " ";
    L71:
        if (r112 == false) goto L73;
        r26 = r26 + r28 + " nanoseconds ";
    L73:
        r25 = r26 + "delay)";
        goto L75
    L62:
        if (r28 > 1000) goto L65;
        r112 = false;
    L75:
        if (isDone() == false) goto L79;
        throw new TimeoutException(r25 + " but future completed as timeout expired");
    L79:
        throw new TimeoutException(r25 + " for " + r21);
    L15:
        r13 = 0;
        goto L17
    L7:
        r12 = false;
        goto L9
    L81:
        throw new InterruptedException();
    }

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object r10 = this.value;
        if (r10 == null) goto L5;
        boolean r11 = true;
    L7:
        return (!(r10 instanceof SetFuture)) & r11;
    L5:
        r11 = false;
        goto L7
    }

    public final void maybePropagateCancellationTo(@NullableDecl Future<?> r10) {
        if (r10 == null) goto L4;
        boolean r11 = true;
    L6:
        if ((r11 & isCancelled()) == false) goto L9;
        r10.cancel(wasInterrupted());
        return;
    L9:
        return;
    L4:
        r11 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NullableDecl
    public String pendingToString() {
        Object r10 = this.value;
        if ((r10 instanceof SetFuture) == false) goto L7;
        return "setFuture=[" + userObjectToString(((SetFuture) r10).future) + "]";
    L7:
        if ((this instanceof ScheduledFuture) == true) goto L9;
        return null;
    L9:
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
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
    @CanIgnoreReturnValue
    public boolean set(@NullableDecl V r10) {
        if (r10 != null) goto L5;
        r10 = (V) NULL;
    L5:
        if (ATOMIC_HELPER.casValue(this, null, r10) == false) goto L8;
        complete(this);
        return true;
    L8:
        return false;
    }

    @CanIgnoreReturnValue
    public boolean setException(Throwable r10) {
        Failure r11 = new Failure((Throwable) Preconditions.checkNotNull(r10));
        if (ATOMIC_HELPER.casValue(this, null, r11) == false) goto L6;
        complete(this);
        return true;
    L6:
        return false;
    }

    @CanIgnoreReturnValue
    public boolean setFuture(ListenableFuture<? extends V> r10) {
        Preconditions.checkNotNull(r10);
        Object r11 = this.value;
        if (r11 != null) goto L23;
        if (r10.isDone() == false) goto L11;
        Object r12 = getFutureValue(r10);
        if (ATOMIC_HELPER.casValue(this, null, r12) == false) goto L10;
        complete(this);
        return true;
    L10:
        return false;
    L11:
        SetFuture r13 = new SetFuture(this, r10);
        if (ATOMIC_HELPER.casValue(this, null, r13) == true) goto L26;
        r11 = this.value;
        goto L23
    L26:
        r10.addListener(r13, DirectExecutor.INSTANCE);     // Catch: Throwable -> L15
    L20:
        return true;
    L15:
        th = move-exception;
        Failure r14 = new Failure(th);     // Catch: Throwable -> L18
    L19:
        ATOMIC_HELPER.casValue(this, r13, r14);
    L18:
        r14 = Failure.FALLBACK_INSTANCE;
    L23:
        if ((r11 instanceof Cancellation) == false) goto L25;
        r10.cancel(((Cancellation) r11).wasInterrupted);
    L25:
        return false;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(super.toString());
        r10.append("[status=");
        if (isCancelled() == false) goto L6;
        r10.append("CANCELLED");
    L20:
        r10.append("]");
        return r10.toString();
    L6:
        if (isDone() == false) goto L22;
        addDoneString(r10);
        goto L20
    L22:
        String r11 = pendingToString();     // Catch: RuntimeException -> L10
    L12:
        if (r11 == null) goto L17;
        if (r11.isEmpty() == true) goto L17;
        r10.append("PENDING, info=[");
        r10.append(r11);
        r10.append("]");
    L17:
        if (isDone() == false) goto L19;
        addDoneString(r10);
        goto L20
    L19:
        r10.append("PENDING");
    L10:
        e = move-exception;
        r11 = "Exception thrown from implementation: " + e.getClass();
        goto L12
    }

    @Override // com.google.common.util.concurrent.internal.InternalFutureFailureAccess
    @NullableDecl
    public final Throwable tryInternalFastPathGetFailure() {
        if ((this instanceof Trusted) == false) goto L8;
        Object r10 = this.value;
        if ((r10 instanceof Failure) == true) goto L7;
        return null;
    L7:
        return ((Failure) r10).exception;
    L8:
        return null;
    }

    public final boolean wasInterrupted() {
        Object r10 = this.value;
        if ((r10 instanceof Cancellation) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Cancellation) r10).wasInterrupted == false) goto L7;
        return true;
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public V get() throws InterruptedException, ExecutionException {
        if (Thread.interrupted() == true) goto L34;
        Object r10 = this.value;
        if (r10 == null) goto L7;
        boolean r11 = true;
    L9:
        if ((r11 & (!(r10 instanceof SetFuture))) == true) goto L11;
        Waiter r12 = this.waiters;
        if (r12 == Waiter.TOMBSTONE) goto L32;
        Waiter r13 = new Waiter();
    L15:
        r13.setNext(r12);
        if (ATOMIC_HELPER.casWaiters(this, r12, r13) == true) goto L17;
        r12 = this.waiters;
        if (r12 != Waiter.TOMBSTONE) goto L15;
    L17:
        LockSupport.park(this);
        if (Thread.interrupted() == true) goto L27;
        Object r14 = this.value;
        if (r14 == null) goto L22;
        boolean r15 = true;
    L24:
        if ((r15 & (!(r14 instanceof SetFuture))) == false) goto L17;
        return getDoneValue(r14);
    L22:
        r15 = false;
        goto L24
    L27:
        removeWaiter(r13);
        throw new InterruptedException();
    L32:
        return getDoneValue(this.value);
    L11:
        return getDoneValue(r10);
    L7:
        r11 = false;
        goto L9
    L34:
        throw new InterruptedException();
    }
}
