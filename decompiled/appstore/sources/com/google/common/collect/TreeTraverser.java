package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
@Deprecated
public abstract class TreeTraverser<T> {

    public final class BreadthFirstIterator extends UnmodifiableIterator<T> implements PeekingIterator<T> {
        private final Queue<T> queue;
        final /* synthetic */ TreeTraverser this$0;

        public BreadthFirstIterator(TreeTraverser r10, T r11) {
            this.this$0 = r10;
            ArrayDeque r12 = new ArrayDeque();
            this.queue = r12;
            r12.add(r11);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        @Override // java.util.Iterator, com.google.common.collect.PeekingIterator
        public T next() {
            T r10 = this.queue.remove();
            Iterables.addAll(this.queue, this.this$0.children(r10));
            return r10;
        }

        @Override // com.google.common.collect.PeekingIterator
        public T peek() {
            return this.queue.element();
        }
    }

    public final class PostOrderIterator extends AbstractIterator<T> {
        private final ArrayDeque<PostOrderNode<T>> stack;
        final /* synthetic */ TreeTraverser this$0;

        public PostOrderIterator(TreeTraverser r10, T r11) {
            this.this$0 = r10;
            ArrayDeque<PostOrderNode<T>> r12 = new ArrayDeque();
            this.stack = r12;
            r12.addLast(expand(r11));
        }

        private PostOrderNode<T> expand(T r10) {
            return new PostOrderNode(r10, this.this$0.children(r10).iterator());
        }

        @Override // com.google.common.collect.AbstractIterator
        public T computeNext() {
        L3:
            if (this.stack.isEmpty() == true) goto L10;
            PostOrderNode<T> r10 = this.stack.getLast();
            if (r10.childIterator.hasNext() == false) goto L7;
            T r11 = r10.childIterator.next();
            this.stack.addLast(expand(r11));
            goto L3
        L7:
            this.stack.removeLast();
            return r10.root;
        L10:
            return endOfData();
        }
    }

    public static final class PostOrderNode<T> {
        final Iterator<T> childIterator;
        final T root;

        public PostOrderNode(T r10, Iterator<T> r11) {
            this.root = (T) Preconditions.checkNotNull(r10);
            this.childIterator = (Iterator) Preconditions.checkNotNull(r11);
        }
    }

    public final class PreOrderIterator extends UnmodifiableIterator<T> {
        private final Deque<Iterator<T>> stack;
        final /* synthetic */ TreeTraverser this$0;

        public PreOrderIterator(TreeTraverser r10, T r11) {
            this.this$0 = r10;
            ArrayDeque r12 = new ArrayDeque();
            this.stack = r12;
            r12.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(r11)));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.stack.isEmpty();
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
        @Override // java.util.Iterator
        public T next() {
            Iterator<T> r10 = this.stack.getLast();
            T r11 = (T) Preconditions.checkNotNull(r10.next());
            if (r10.hasNext() == true) goto L5;
            this.stack.removeLast();
        L5:
            Iterator<T> r12 = this.this$0.children(r11).iterator();
            if (r12.hasNext() == false) goto L8;
            this.stack.addLast(r12);
        L8:
            return r11;
        }
    }

    public TreeTraverser() {
    }

    @Deprecated
    public static <T> TreeTraverser<T> using(final Function<T, ? extends Iterable<T>> r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass1(r10);
    }

    @Deprecated
    public final FluentIterable<T> breadthFirstTraversal(final T r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass4(this, r10);
    }

    public abstract Iterable<T> children(T r10);

    public UnmodifiableIterator<T> postOrderIterator(T r10) {
        return new PostOrderIterator(this, r10);
    }

    @Deprecated
    public final FluentIterable<T> postOrderTraversal(final T r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass3(this, r10);
    }

    public UnmodifiableIterator<T> preOrderIterator(T r10) {
        return new PreOrderIterator(this, r10);
    }

    @Deprecated
    public final FluentIterable<T> preOrderTraversal(final T r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass2(this, r10);
    }
}
