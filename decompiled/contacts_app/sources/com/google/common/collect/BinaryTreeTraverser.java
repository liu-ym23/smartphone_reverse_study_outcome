package com.google.common.collect;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BinaryTreeTraverser<T> extends TreeTraverser<T> {

    private final class InOrderIterator extends AbstractIterator<T> {
        private final BitSet hasExpandedLeft;
        private final Deque<T> stack;
        final /* synthetic */ BinaryTreeTraverser this$0;

        InOrderIterator(BinaryTreeTraverser r2, T r3) {
            this.this$0 = r2;
            ArrayDeque r4 = new ArrayDeque();
            this.stack = r4;
            this.hasExpandedLeft = new BitSet();
            r4.addLast(r3);
        }

        @Override // com.google.common.collect.AbstractIterator
        protected T computeNext() {
        L3:
            if (this.stack.isEmpty() == true) goto L10;
            T r0 = this.stack.getLast();
            if (this.hasExpandedLeft.get(this.stack.size() - 1) == true) goto L6;
            this.hasExpandedLeft.set(this.stack.size() - 1);
            BinaryTreeTraverser.access$000(this.stack, this.this$0.leftChild(r0));
            goto L3
        L6:
            this.stack.removeLast();
            this.hasExpandedLeft.clear(this.stack.size());
            BinaryTreeTraverser.access$000(this.stack, this.this$0.rightChild(r0));
            return r0;
        L10:
            return endOfData();
        }
    }

    private final class PostOrderIterator extends UnmodifiableIterator<T> {
        private final BitSet hasExpanded;
        private final Deque<T> stack;
        final /* synthetic */ BinaryTreeTraverser this$0;

        PostOrderIterator(BinaryTreeTraverser r1, T r2) {
            this.this$0 = r1;
            ArrayDeque r3 = new ArrayDeque();
            this.stack = r3;
            r3.addLast(r2);
            this.hasExpanded = new BitSet();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
        L2:
            T r0 = this.stack.getLast();
            if (this.hasExpanded.get(this.stack.size() - 1) == true) goto L4;
            this.hasExpanded.set(this.stack.size() - 1);
            BinaryTreeTraverser.access$000(this.stack, this.this$0.rightChild(r0));
            BinaryTreeTraverser.access$000(this.stack, this.this$0.leftChild(r0));
            goto L2
        L4:
            this.stack.removeLast();
            this.hasExpanded.clear(this.stack.size());
            return r0;
        }
    }

    private final class PreOrderIterator extends UnmodifiableIterator<T> implements PeekingIterator<T> {
        private final Deque<T> stack;
        final /* synthetic */ BinaryTreeTraverser this$0;

        PreOrderIterator(BinaryTreeTraverser r1, T r2) {
            this.this$0 = r1;
            ArrayDeque r3 = new ArrayDeque();
            this.stack = r3;
            r3.addLast(r2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        @Override // java.util.Iterator, com.google.common.collect.PeekingIterator
        public T next() {
            T r0 = this.stack.removeLast();
            BinaryTreeTraverser.access$000(this.stack, this.this$0.rightChild(r0));
            BinaryTreeTraverser.access$000(this.stack, this.this$0.leftChild(r0));
            return r0;
        }

        @Override // com.google.common.collect.PeekingIterator
        public T peek() {
            return this.stack.getLast();
        }
    }

    public abstract Optional<T> leftChild(T r1);

    public abstract Optional<T> rightChild(T r1);

    public BinaryTreeTraverser() {
    }

    static /* synthetic */ void access$000(Deque r0, Optional r1) {
        pushIfPresent(r0, r1);
    }

    @Override // com.google.common.collect.TreeTraverser
    public final Iterable<T> children(final T r2) {
        Preconditions.checkNotNull(r2);
        return new AnonymousClass1(this, r2);
    }

    @Override // com.google.common.collect.TreeTraverser
    UnmodifiableIterator<T> preOrderIterator(T r2) {
        return new PreOrderIterator(this, r2);
    }

    @Override // com.google.common.collect.TreeTraverser
    UnmodifiableIterator<T> postOrderIterator(T r2) {
        return new PostOrderIterator(this, r2);
    }

    public final FluentIterable<T> inOrderTraversal(final T r2) {
        Preconditions.checkNotNull(r2);
        return new AnonymousClass2(this, r2);
    }

    private static <T> void pushIfPresent(Deque<T> r1, Optional<T> r2) {
        if (r2.isPresent() == false) goto L6;
        r1.addLast(r2.get());
        return;
    }
}
