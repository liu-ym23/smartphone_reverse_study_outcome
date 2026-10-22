package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.RecyclerPool.WithPool;
import java.io.Serializable;
import java.util.Deque;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public interface RecyclerPool<P extends WithPool<P>> extends Serializable {

    public static abstract class BoundedPoolBase<P extends WithPool<P>> extends StatefulImplBase<P> {
        public static final int DEFAULT_CAPACITY = 100;
        private static final long serialVersionUID = 1;
        private final transient int capacity;
        private final transient ArrayBlockingQueue<P> pool;

        public BoundedPoolBase(int i) {
            super(i);
            i = i <= 0 ? 100 : i;
            this.capacity = i;
            this.pool = new ArrayBlockingQueue<>(i);
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
        public void releasePooled(P p) {
            this.pool.offer(p);
        }
    }

    public static abstract class ConcurrentDequePoolBase<P extends WithPool<P>> extends StatefulImplBase<P> {
        private static final long serialVersionUID = 1;
        protected final transient Deque<P> pool;

        public ConcurrentDequePoolBase(int i) {
            super(i);
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
        public void releasePooled(P p) {
            this.pool.offerLast(p);
        }
    }

    @Deprecated
    public static abstract class LockFreePoolBase<P extends WithPool<P>> extends StatefulImplBase<P> {
        private static final long serialVersionUID = 1;
        private final transient AtomicReference<Node<P>> head;

        public static class Node<P> {
            Node<P> next;
            final P value;

            public Node(P p) {
                this.value = p;
            }
        }

        public LockFreePoolBase(int i) {
            super(i);
            this.head = new AtomicReference<>();
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public P acquirePooled() {
            Node<P> node;
            for (int i = 0; i < 3 && (node = this.head.get()) != null; i++) {
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
            int i = 0;
            for (Node node = this.head.get(); node != null; node = node.next) {
                i++;
            }
            return i;
        }

        @Override // com.fasterxml.jackson.core.util.RecyclerPool
        public void releasePooled(P p) {
            Node<P> node = new Node<>(p);
            for (int i = 0; i < 3; i++) {
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
        public void releasePooled(P p) {
        }
    }

    public static abstract class StatefulImplBase<P extends WithPool<P>> implements RecyclerPool<P> {
        public static final int SERIALIZATION_NON_SHARED = 1;
        public static final int SERIALIZATION_SHARED = -1;
        private static final long serialVersionUID = 1;
        protected final int _serialization;

        public StatefulImplBase(int i) {
            this._serialization = i;
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
        public void releasePooled(P p) {
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

    void releasePooled(P p);
}
