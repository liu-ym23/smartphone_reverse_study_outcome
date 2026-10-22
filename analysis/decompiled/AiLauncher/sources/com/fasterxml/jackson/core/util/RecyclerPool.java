package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.RecyclerPool.WithPool;
import java.io.Serializable;
import java.util.Deque;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public interface RecyclerPool<P extends WithPool<P>> extends Serializable {

    public static abstract class BoundedPoolBase<P extends WithPool<P>> extends StatefulImplBase<P> {
        public static final int DEFAULT_CAPACITY = 100;
        private static final long serialVersionUID = 1;
        private final transient int capacity;
        private final transient ArrayBlockingQueue<P> pool;

        public BoundedPoolBase(int i10) {
            super(i10);
            i10 = i10 <= 0 ? 100 : i10;
            this.capacity = i10;
            this.pool = new ArrayBlockingQueue<>(i10);
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public P acquirePooled() {
            P pPoll = this.pool.poll();
            return pPoll == null ? createPooled() : pPoll;
        }

        public int capacity() {
            return this.capacity;
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public boolean clear() {
            this.pool.clear();
            return true;
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public int pooledCount() {
            return this.pool.size();
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public void releasePooled(P p10) {
            this.pool.offer(p10);
        }
    }

    public static abstract class ConcurrentDequePoolBase<P extends WithPool<P>> extends StatefulImplBase<P> {
        private static final long serialVersionUID = 1;
        protected final transient Deque<P> pool;

        public ConcurrentDequePoolBase(int i10) {
            super(i10);
            this.pool = new ConcurrentLinkedDeque();
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public P acquirePooled() {
            P pPollFirst = this.pool.pollFirst();
            return pPollFirst == null ? createPooled() : pPollFirst;
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public boolean clear() {
            this.pool.clear();
            return true;
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public int pooledCount() {
            return this.pool.size();
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public void releasePooled(P p10) {
            this.pool.offerLast(p10);
        }
    }

    @Deprecated
    public static abstract class LockFreePoolBase<P extends WithPool<P>> extends StatefulImplBase<P> {
        private static final long serialVersionUID = 1;
        private final transient AtomicReference<Node<P>> head;

        public static class Node<P> {
            Node<P> next;
            final P value;

            public Node(P p10) {
                this.value = p10;
            }
        }

        public LockFreePoolBase(int i10) {
            super(i10);
            this.head = new AtomicReference<>();
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public P acquirePooled() {
            Node<P> node;
            for (int i10 = 0; i10 < 3 && (node = this.head.get()) != null; i10++) {
                if (this.head.compareAndSet(node, node.next)) {
                    node.next = null;
                    return node.value;
                }
            }
            return createPooled();
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public boolean clear() {
            this.head.set(null);
            return true;
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public int pooledCount() {
            int i10 = 0;
            for (Node node = this.head.get(); node != null; node = node.next) {
                i10++;
            }
            return i10;
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public void releasePooled(P p10) {
            Node<P> node = new Node<>(p10);
            for (int i10 = 0; i10 < 3; i10++) {
                Node<P> node2 = this.head.get();
                node.next = node2;
                if (this.head.compareAndSet(node2, node)) {
                    return;
                }
            }
        }
    }

    public static abstract class NonRecyclingPoolBase<P extends WithPool<P>> implements RecyclerPool<P> {
        private static final long serialVersionUID = 1;

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public P acquireAndLinkPooled() {
            return (P) acquirePooled();
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public abstract P acquirePooled();

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public boolean clear() {
            return true;
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public int pooledCount() {
            return 0;
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public void releasePooled(P p10) {
        }
    }

    public static abstract class StatefulImplBase<P extends WithPool<P>> implements RecyclerPool<P> {
        public static final int SERIALIZATION_NON_SHARED = 1;
        public static final int SERIALIZATION_SHARED = -1;
        private static final long serialVersionUID = 1;
        protected final int _serialization;

        public StatefulImplBase(int i10) {
            this._serialization = i10;
        }

        public Optional<StatefulImplBase<P>> _resolveToShared(StatefulImplBase<P> statefulImplBase) {
            return this._serialization == -1 ? Optional.of(statefulImplBase) : Optional.empty();
        }

        public abstract P createPooled();
    }

    public static abstract class ThreadLocalPoolBase<P extends WithPool<P>> implements RecyclerPool<P> {
        private static final long serialVersionUID = 1;

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public P acquireAndLinkPooled() {
            return (P) acquirePooled();
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public abstract P acquirePooled();

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public boolean clear() {
            return false;
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public int pooledCount() {
            return -1;
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public void releasePooled(P p10) {
        }
    }

    public interface WithPool<P extends WithPool<P>> {
        void releaseToPool();

        P withPool(RecyclerPool<P> recyclerPool);
    }

    default P acquireAndLinkPooled() {
        return (P) acquirePooled().withPool(this);
    }

    P acquirePooled();

    default boolean clear() {
        return false;
    }

    default int pooledCount() {
        return -1;
    }

    void releasePooled(P p10);
}
