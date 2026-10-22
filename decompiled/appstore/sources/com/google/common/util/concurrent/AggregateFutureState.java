package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@ReflectionSupport(ReflectionSupport.Level.FULL)
@GwtCompatible(emulated = true)
abstract class AggregateFutureState {
    private static final AtomicHelper ATOMIC_HELPER = null;
    private static final Logger log = null;
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AggregateFutureState$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        public abstract void compareAndSetSeenExceptions(AggregateFutureState r10, Set<Throwable> r11, Set<Throwable> r12);

        public abstract int decrementAndGetRemainingCount(AggregateFutureState r10);

        public /* synthetic */ AtomicHelper(AnonymousClass1 r10) {
            this();
        }
    }

    public static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicIntegerFieldUpdater<AggregateFutureState> remainingCountUpdater;
        final AtomicReferenceFieldUpdater<AggregateFutureState, Set<Throwable>> seenExceptionsUpdater;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater r10, AtomicIntegerFieldUpdater r11) {
            super(null);
            this.seenExceptionsUpdater = r10;
            this.remainingCountUpdater = r11;
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public void compareAndSetSeenExceptions(AggregateFutureState r10, Set<Throwable> r11, Set<Throwable> r12) {
            androidx.concurrent.futures.a.a(this.seenExceptionsUpdater, r10, r11, r12);
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public int decrementAndGetRemainingCount(AggregateFutureState r10) {
            return this.remainingCountUpdater.decrementAndGet(r10);
        }
    }

    public static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super(null);
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public void compareAndSetSeenExceptions(AggregateFutureState r10, Set<Throwable> r11, Set<Throwable> r12) {
            monitor-enter(r10);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (AggregateFutureState.access$200(r10) != r11) goto L8;
            AggregateFutureState.access$202(r10, r12);     // Catch: Throwable -> L6
        L8:
            monitor-exit(r10);     // Catch: Throwable -> L6
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public int decrementAndGetRemainingCount(AggregateFutureState r10) {
            monitor-enter(r10);
            AggregateFutureState.access$310(r10);     // Catch: Throwable -> L6
            int r11 = AggregateFutureState.access$300(r10);     // Catch: Throwable -> L6
            monitor-exit(r10);     // Catch: Throwable -> L6
            return r11;
        L6:
            th = move-exception;
            throw th;
        }

        public /* synthetic */ SynchronizedAtomicHelper(AnonymousClass1 r10) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        log = Logger.getLogger(AggregateFutureState.class.getName());
        Throwable r10 = null;
        Object[] r11 = 0;
        AtomicHelper r12 = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining"));     // Catch: Throwable -> L5
    L7:
        ATOMIC_HELPER = r12;
        if (r10 == null) goto L13;
        log.log(Level.SEVERE, "SafeAtomicHelper is broken!", r10);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        r12 = new SynchronizedAtomicHelper(r11 == true ? 1 : 0);
        r10 = th;
        goto L7
    }

    public AggregateFutureState(int r10) {
        this.seenExceptions = null;
        this.remaining = r10;
    }

    public static /* synthetic */ Set access$200(AggregateFutureState r10) {
        return r10.seenExceptions;
    }

    public static /* synthetic */ Set access$202(AggregateFutureState r10, Set r11) {
        r10.seenExceptions = r11;
        return r11;
    }

    public static /* synthetic */ int access$300(AggregateFutureState r10) {
        return r10.remaining;
    }

    public static /* synthetic */ int access$310(AggregateFutureState r10) {
        int r11 = r10.remaining;
        r10.remaining = r11 - 1;
        return r11;
    }

    public abstract void addInitialException(Set<Throwable> r10);

    public final int decrementRemainingAndGet() {
        return ATOMIC_HELPER.decrementAndGetRemainingCount(this);
    }

    public final Set<Throwable> getOrInitSeenExceptions() {
        Set<Throwable> r10 = this.seenExceptions;
        if (r10 != null) goto L6;
        Set<Throwable> r11 = Sets.newConcurrentHashSet();
        addInitialException(r11);
        ATOMIC_HELPER.compareAndSetSeenExceptions(this, null, r11);
        return this.seenExceptions;
    L6:
        return r10;
    }
}
