package com.google.common.util.concurrent;

import com.bytedance.librarian.LibrarianImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@CanIgnoreReturnValue
@Beta
@GwtIncompatible
public class CycleDetectingLockFactory {
    private static final ThreadLocal<ArrayList<LockGraphNode>> acquiredLocks = null;
    private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, LockGraphNode>> lockGraphNodesPerType = null;
    private static final Logger logger = null;
    final Policy policy;

    public interface CycleDetectingLock {
        LockGraphNode getLockGraphNode();

        boolean isAcquiredByCurrentThread();
    }

    public final class CycleDetectingReentrantLock extends ReentrantLock implements CycleDetectingLock {
        private final LockGraphNode lockGraphNode;
        final /* synthetic */ CycleDetectingLockFactory this$0;

        public /* synthetic */ CycleDetectingReentrantLock(CycleDetectingLockFactory r10, LockGraphNode r11, boolean r12, AnonymousClass1 r13) {
            this(r10, r11, r12);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public LockGraphNode getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public boolean isAcquiredByCurrentThread() {
            return isHeldByCurrentThread();
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.access$600(this.this$0, this);
            super.lock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this);
            super.lockInterruptibly();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.access$600(this.this$0, this);
            boolean r10 = super.tryLock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this);
            return r10;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void unlock() {
            super.unlock();     // Catch: Throwable -> L5
            CycleDetectingLockFactory.access$700(this);
            return;
        L5:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this);
            throw th;
        }

        private CycleDetectingReentrantLock(CycleDetectingLockFactory r10, LockGraphNode r11, boolean r12) {
            this.this$0 = r10;
            super(r12);
            this.lockGraphNode = (LockGraphNode) Preconditions.checkNotNull(r11);
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long r10, TimeUnit r11) throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this);
            boolean r12 = super.tryLock(r10, r11);     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this);
            return r12;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this);
            throw th;
        }
    }

    public class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {

        @Weak
        final CycleDetectingReentrantReadWriteLock readWriteLock;
        final /* synthetic */ CycleDetectingLockFactory this$0;

        public CycleDetectingReentrantReadLock(CycleDetectingLockFactory r10, CycleDetectingReentrantReadWriteLock r11) {
            this.this$0 = r10;
            super(r11);
            this.readWriteLock = r11;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            super.lock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            super.lockInterruptibly();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            boolean r10 = super.tryLock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return r10;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void unlock() {
            super.unlock();     // Catch: Throwable -> L5
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L5:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long r10, TimeUnit r11) throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            boolean r12 = super.tryLock(r10, r11);     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return r12;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }
    }

    public final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements CycleDetectingLock {
        private final LockGraphNode lockGraphNode;
        private final CycleDetectingReentrantReadLock readLock;
        final /* synthetic */ CycleDetectingLockFactory this$0;
        private final CycleDetectingReentrantWriteLock writeLock;

        public /* synthetic */ CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory r10, LockGraphNode r11, boolean r12, AnonymousClass1 r13) {
            this(r10, r11, r12);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public LockGraphNode getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.CycleDetectingLock
        public boolean isAcquiredByCurrentThread() {
            if (isWriteLockedByCurrentThread() == false) goto L5;
        L8:
            return true;
        L5:
            if (getReadHoldCount() > 0) goto L8;
            return false;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public /* bridge */ /* synthetic */ Lock readLock() {
            return readLock();
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public /* bridge */ /* synthetic */ Lock writeLock() {
            return writeLock();
        }

        private CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory r10, LockGraphNode r11, boolean r12) {
            this.this$0 = r10;
            super(r12);
            this.readLock = new CycleDetectingReentrantReadLock(r10, this);
            this.writeLock = new CycleDetectingReentrantWriteLock(r10, this);
            this.lockGraphNode = (LockGraphNode) Preconditions.checkNotNull(r11);
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.ReadLock readLock() {
            return this.readLock;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.WriteLock writeLock() {
            return this.writeLock;
        }
    }

    public class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {

        @Weak
        final CycleDetectingReentrantReadWriteLock readWriteLock;
        final /* synthetic */ CycleDetectingLockFactory this$0;

        public CycleDetectingReentrantWriteLock(CycleDetectingLockFactory r10, CycleDetectingReentrantReadWriteLock r11) {
            this.this$0 = r10;
            super(r11);
            this.readWriteLock = r11;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            super.lock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            super.lockInterruptibly();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            boolean r10 = super.tryLock();     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return r10;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void unlock() {
            super.unlock();     // Catch: Throwable -> L5
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return;
        L5:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long r10, TimeUnit r11) throws InterruptedException {
            CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
            boolean r12 = super.tryLock(r10, r11);     // Catch: Throwable -> L6
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            return r12;
        L6:
            th = move-exception;
            CycleDetectingLockFactory.access$700(this.readWriteLock);
            throw th;
        }
    }

    public static class ExampleStackTrace extends IllegalStateException {
        static final StackTraceElement[] EMPTY_STACK_TRACE = null;
        static final ImmutableSet<String> EXCLUDED_CLASS_NAMES = null;

        static {
            EMPTY_STACK_TRACE = new StackTraceElement[0];
            EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), LockGraphNode.class.getName());
        }

        public ExampleStackTrace(LockGraphNode r10, LockGraphNode r11) {
            super(r10.getLockName() + " -> " + r11.getLockName());
            StackTraceElement[] r12 = getStackTrace();
            int r13 = r12.length;
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L16;
            if (WithExplicitOrdering.class.getName().equals(r12[r14].getClassName()) == true) goto L6;
            if (EXCLUDED_CLASS_NAMES.contains(r12[r14].getClassName()) == false) goto L9;
            r14 = r14 + 1;
            goto L3
        L9:
            setStackTrace((StackTraceElement[]) Arrays.copyOfRange(r12, r14, r13));
            return;
        L6:
            setStackTrace(EMPTY_STACK_TRACE);
            return;
        }
    }

    public static class LockGraphNode {
        final Map<LockGraphNode, ExampleStackTrace> allowedPriorLocks;
        final Map<LockGraphNode, PotentialDeadlockException> disallowedPriorLocks;
        final String lockName;

        public LockGraphNode(String r10) {
            this.allowedPriorLocks = new MapMaker().weakKeys().makeMap();
            this.disallowedPriorLocks = new MapMaker().weakKeys().makeMap();
            this.lockName = (String) Preconditions.checkNotNull(r10);
        }

        @NullableDecl
        private ExampleStackTrace findPathTo(LockGraphNode r10, Set<LockGraphNode> r11) {
            if (r11.add(this) == true) goto L5;
            return null;
        L5:
            ExampleStackTrace r12 = this.allowedPriorLocks.get(r10);
            if (r12 == null) goto L8;
            return r12;
        L8:
            Iterator<Map.Entry<LockGraphNode, ExampleStackTrace>> r13 = this.allowedPriorLocks.entrySet().iterator();
        L10:
            if (r13.hasNext() == false) goto L15;
            Map.Entry<LockGraphNode, ExampleStackTrace> r14 = r13.next();
            LockGraphNode r15 = r14.getKey();
            ExampleStackTrace r16 = r15.findPathTo(r10, r11);
            if (r16 == null) goto L10;
            ExampleStackTrace r17 = new ExampleStackTrace(r15, this);
            r17.setStackTrace(r14.getValue().getStackTrace());
            r17.initCause(r16);
            return r17;
        L15:
            return null;
        }

        public void checkAcquiredLock(Policy r10, LockGraphNode r11) {
            if (this == r11) goto L4;
            boolean r12 = true;
        L5:
            Preconditions.checkState(r12, "Attempted to acquire multiple locks with the same rank %s", r11.getLockName());
            if (this.allowedPriorLocks.containsKey(r11) == false) goto L8;
            return;
        L8:
            PotentialDeadlockException r13 = this.disallowedPriorLocks.get(r11);
            AnonymousClass1 r14 = null;
            if (r13 == null) goto L12;
            r10.handlePotentialDeadlock(new PotentialDeadlockException(r11, this, r13.getConflictingStackTrace(), r14));
            return;
        L12:
            ExampleStackTrace r15 = r11.findPathTo(this, Sets.newIdentityHashSet());
            if (r15 != null) goto L15;
            this.allowedPriorLocks.put(r11, new ExampleStackTrace(r11, this));
            return;
        L15:
            PotentialDeadlockException r16 = new PotentialDeadlockException(r11, this, r15, r14);
            this.disallowedPriorLocks.put(r11, r16);
            r10.handlePotentialDeadlock(r16);
            return;
        L4:
            r12 = false;
            goto L5
        }

        public void checkAcquiredLocks(Policy r10, List<LockGraphNode> r11) {
            int r12 = r11.size();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            checkAcquiredLock(r10, r11.get(r13));
            r13 = r13 + 1;
            goto L3
        }

        public String getLockName() {
            return this.lockName;
        }
    }

    @Beta
    public static abstract enum Policies extends Enum<Policies> implements Policy {
        private static final /* synthetic */ Policies[] $VALUES = null;
        public static final Policies DISABLED = null;
        public static final Policies THROW = null;
        public static final Policies WARN = null;

        static {
            final String r10 = "THROW";
            final int r11 = 0;
            Policies r12 = new AnonymousClass1(r10, r11);
            THROW = r12;
            final String r13 = "WARN";
            final int r14 = 1;
            Policies r15 = new AnonymousClass2(r13, r14);
            WARN = r15;
            final String r16 = "DISABLED";
            final int r17 = 2;
            Policies r18 = new AnonymousClass3(r16, r17);
            DISABLED = r18;
            $VALUES = new Policies[]{r12, r15, r18};
        }

        private Policies(String r10, int r11) {
            super(r10, r11);
        }

        public static Policies valueOf(String r10) {
            return (Policies) Enum.valueOf(Policies.class, r10);
        }

        public static Policies[] values() {
            return (Policies[]) $VALUES.clone();
        }

        public /* synthetic */ Policies(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    @Beta
    public interface Policy {
        void handlePotentialDeadlock(PotentialDeadlockException r10);
    }

    @Beta
    public static final class PotentialDeadlockException extends ExampleStackTrace {
        private final ExampleStackTrace conflictingStackTrace;

        public /* synthetic */ PotentialDeadlockException(LockGraphNode r10, LockGraphNode r11, ExampleStackTrace r12, AnonymousClass1 r13) {
            this(r10, r11, r12);
        }

        public ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuilder r10 = new StringBuilder(super.getMessage());
            Throwable r11 = this.conflictingStackTrace;
        L3:
            if (r11 == null) goto L6;
            r10.append(", ");
            r10.append(r11.getMessage());
            r11 = r11.getCause();
            goto L3
        L6:
            return r10.toString();
        }

        private PotentialDeadlockException(LockGraphNode r10, LockGraphNode r11, ExampleStackTrace r12) {
            super(r10, r11);
            this.conflictingStackTrace = r12;
            initCause(r12);
        }
    }

    @Beta
    public static final class WithExplicitOrdering<E extends Enum<E>> extends CycleDetectingLockFactory {
        private final Map<E, LockGraphNode> lockGraphNodes;

        @VisibleForTesting
        public WithExplicitOrdering(Policy r10, Map<E, LockGraphNode> r11) {
            super(r10, null);
            this.lockGraphNodes = r11;
        }

        public ReentrantLock newReentrantLock(E r10) {
            return newReentrantLock(r10, false);
        }

        public ReentrantReadWriteLock newReentrantReadWriteLock(E r10) {
            return newReentrantReadWriteLock(r10, false);
        }

        public ReentrantLock newReentrantLock(E r10, boolean r11) {
            if (this.policy != Policies.DISABLED) goto L6;
            return new ReentrantLock(r11);
        L6:
            return new CycleDetectingReentrantLock(this, this.lockGraphNodes.get(r10), r11, null);
        }

        public ReentrantReadWriteLock newReentrantReadWriteLock(E r10, boolean r11) {
            if (this.policy != Policies.DISABLED) goto L6;
            return new ReentrantReadWriteLock(r11);
        L6:
            return new CycleDetectingReentrantReadWriteLock(this, this.lockGraphNodes.get(r10), r11, null);
        }
    }

    static {
        lockGraphNodesPerType = new MapMaker().weakKeys().makeMap();
        logger = Logger.getLogger(CycleDetectingLockFactory.class.getName());
        acquiredLocks = new AnonymousClass1();
    }

    public /* synthetic */ CycleDetectingLockFactory(Policy r10, AnonymousClass1 r11) {
        this(r10);
    }

    private void aboutToAcquire(CycleDetectingLock r10) {
        if (r10.isAcquiredByCurrentThread() == true) goto L6;
        ArrayList<LockGraphNode> r11 = acquiredLocks.get();
        LockGraphNode r12 = r10.getLockGraphNode();
        r12.checkAcquiredLocks(this.policy, r11);
        r11.add(r12);
        return;
    }

    public static /* synthetic */ Logger access$100() {
        return logger;
    }

    public static /* synthetic */ void access$600(CycleDetectingLockFactory r10, CycleDetectingLock r11) {
        r10.aboutToAcquire(r11);
    }

    public static /* synthetic */ void access$700(CycleDetectingLock r10) {
        lockStateChanged(r10);
    }

    @VisibleForTesting
    public static <E extends Enum<E>> Map<E, LockGraphNode> createNodes(Class<E> r10) {
        EnumMap r11 = Maps.newEnumMap(r10);
        E[] r12 = r10.getEnumConstants();
        int r13 = r12.length;
        ArrayList r14 = Lists.newArrayListWithCapacity(r13);
        int r15 = r12.length;
        int r16 = 0;
        int r17 = 0;
    L3:
        if (r17 >= r15) goto L5;
        E r18 = r12[r17];
        LockGraphNode r19 = new LockGraphNode(getLockName(r18));
        r14.add(r19);
        r11.put(r18, r19);
        r17 = r17 + 1;
        goto L3
    L5:
        int r20 = 1;
    L6:
        if (r20 >= r13) goto L9;
        ((LockGraphNode) r14.get(r20)).checkAcquiredLocks(Policies.THROW, r14.subList(0, r20));
        r20 = r20 + 1;
    L9:
        if (r16 >= (r13 - 1)) goto L12;
        r16 = r16 + 1;
        ((LockGraphNode) r14.get(r16)).checkAcquiredLocks(Policies.DISABLED, r14.subList(r16, r13));
        goto L9
    L12:
        return Collections.unmodifiableMap(r11);
    }

    private static String getLockName(Enum<?> r10) {
        return r10.getDeclaringClass().getSimpleName() + LibrarianImpl.Constants.DOT + r10.name();
    }

    private static Map<? extends Enum, LockGraphNode> getOrCreateNodes(Class<? extends Enum> r10) {
        ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, LockGraphNode>> r11 = lockGraphNodesPerType;
        Map<? extends Enum, LockGraphNode> r12 = r11.get(r10);
        if (r12 == null) goto L5;
        return r12;
    L5:
        Map<? extends Enum, LockGraphNode> r13 = createNodes(r10);
        return (Map) MoreObjects.firstNonNull(r11.putIfAbsent(r10, r13), r13);
    }

    private static void lockStateChanged(CycleDetectingLock r10) {
        if (r10.isAcquiredByCurrentThread() == true) goto L10;
        ArrayList<LockGraphNode> r11 = acquiredLocks.get();
        LockGraphNode r12 = r10.getLockGraphNode();
        int r13 = r11.size() - 1;
    L5:
        if (r13 < 0) goto L14;
        if (r11.get(r13) == r12) goto L8;
        r13 = r13 - 1;
        goto L5
    L8:
        r11.remove(r13);
        return;
    L14:
        return;
    }

    public static CycleDetectingLockFactory newInstance(Policy r10) {
        return new CycleDetectingLockFactory(r10);
    }

    public static <E extends Enum<E>> WithExplicitOrdering<E> newInstanceWithExplicitOrdering(Class<E> r10, Policy r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return new WithExplicitOrdering(r11, getOrCreateNodes(r10));
    }

    public ReentrantLock newReentrantLock(String r10) {
        return newReentrantLock(r10, false);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String r10) {
        return newReentrantReadWriteLock(r10, false);
    }

    private CycleDetectingLockFactory(Policy r10) {
        this.policy = (Policy) Preconditions.checkNotNull(r10);
    }

    public ReentrantLock newReentrantLock(String r10, boolean r11) {
        if (this.policy != Policies.DISABLED) goto L6;
        return new ReentrantLock(r11);
    L6:
        return new CycleDetectingReentrantLock(this, new LockGraphNode(r10), r11, null);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String r10, boolean r11) {
        if (this.policy != Policies.DISABLED) goto L6;
        return new ReentrantReadWriteLock(r11);
    L6:
        return new CycleDetectingReentrantReadWriteLock(this, new LockGraphNode(r10), r11, null);
    }
}
