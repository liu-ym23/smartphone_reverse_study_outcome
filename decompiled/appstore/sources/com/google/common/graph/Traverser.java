package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public abstract class Traverser<N> {

    /* JADX INFO: renamed from: com.google.common.graph.Traverser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class GraphTraverser<N> extends Traverser<N> {
        private final SuccessorsFunction<N> graph;

        public final class BreadthFirstIterator extends UnmodifiableIterator<N> {
            private final Queue<N> queue;
            final /* synthetic */ GraphTraverser this$0;
            private final Set<N> visited;

            public BreadthFirstIterator(GraphTraverser r10, Iterable<? extends N> r11) {
                this.this$0 = r10;
                this.queue = new ArrayDeque();
                this.visited = new HashSet();
                Iterator<? extends N> r12 = r11.iterator();
            L4:
                if (r12.hasNext() == false) goto L8;
                N r13 = r12.next();
                if (this.visited.add(r13) == false) goto L4;
                this.queue.add(r13);
                goto L4
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.queue.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                N r10 = this.queue.remove();
                Iterator<? extends N> r11 = GraphTraverser.access$100(this.this$0).successors(r10).iterator();
            L4:
                if (r11.hasNext() == false) goto L8;
                N r12 = r11.next();
                if (this.visited.add(r12) == false) goto L4;
                this.queue.add(r12);
                goto L4
            L8:
                return r10;
            }
        }

        public final class DepthFirstIterator extends AbstractIterator<N> {
            private final Order order;
            private final Deque<GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors> stack;
            final /* synthetic */ GraphTraverser this$0;
            private final Set<N> visited;

            public final class NodeAndSuccessors {

                @NullableDecl
                final N node;
                final Iterator<? extends N> successorIterator;
                final /* synthetic */ DepthFirstIterator this$1;

                public NodeAndSuccessors(@NullableDecl DepthFirstIterator r10, N r11, Iterable<? extends N> r12) {
                    this.this$1 = r10;
                    this.node = r11;
                    this.successorIterator = r12.iterator();
                }
            }

            public DepthFirstIterator(GraphTraverser r10, Iterable<? extends N> r11, Order r12) {
                this.this$0 = r10;
                ArrayDeque r13 = new ArrayDeque();
                this.stack = r13;
                this.visited = new HashSet();
                r13.push(new NodeAndSuccessors(this, null, r11));
                this.order = r12;
            }

            @Override // com.google.common.collect.AbstractIterator
            public N computeNext() {
            L3:
                if (this.stack.isEmpty() == true) goto L5;
                GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors r10 = this.stack.getFirst();
                boolean r11 = this.visited.add(r10.node);
                boolean r12 = r10.successorIterator.hasNext();
                if (r11 == true) goto L9;
            L10:
                if (r12 == false) goto L12;
            L14:
                boolean r13 = false;
            L15:
                if (r12 == true) goto L17;
                this.stack.pop();
            L20:
                if (r13 == false) goto L3;
                N r14 = r10.node;
                if (r14 == null) goto L3;
                return r14;
            L17:
                N r15 = r10.successorIterator.next();
                if (this.visited.contains(r15) == true) goto L20;
                this.stack.push(withSuccessors(r15));
                goto L20
            L12:
                if (this.order != Order.POSTORDER) goto L14;
            L13:
                r13 = true;
                goto L15
            L9:
                if (this.order == Order.PREORDER) goto L13;
            L5:
                return (N) endOfData();
            }

            public GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors withSuccessors(N r10) {
                return new NodeAndSuccessors(this, r10, GraphTraverser.access$100(this.this$0).successors(r10));
            }
        }

        public GraphTraverser(SuccessorsFunction<N> r10) {
            super(null);
            this.graph = (SuccessorsFunction) Preconditions.checkNotNull(r10);
        }

        public static /* synthetic */ SuccessorsFunction access$100(GraphTraverser r10) {
            return r10.graph;
        }

        private void checkThatNodeIsInGraph(N r10) {
            this.graph.successors(r10);
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(N r10) {
            Preconditions.checkNotNull(r10);
            return breadthFirst(ImmutableSet.of(r10));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(N r10) {
            Preconditions.checkNotNull(r10);
            return depthFirstPostOrder(ImmutableSet.of(r10));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(N r10) {
            Preconditions.checkNotNull(r10);
            return depthFirstPreOrder(ImmutableSet.of(r10));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(final Iterable<? extends N> r10) {
            Preconditions.checkNotNull(r10);
            if (Iterables.isEmpty(r10) == true) goto L5;
            Iterator<? extends N> r11 = r10.iterator();
        L8:
            if (r11.hasNext() == false) goto L11;
            checkThatNodeIsInGraph(r11.next());
            goto L8
        L11:
            return new AnonymousClass1(this, r10);
        L5:
            return ImmutableSet.of();
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(final Iterable<? extends N> r10) {
            Preconditions.checkNotNull(r10);
            if (Iterables.isEmpty(r10) == true) goto L5;
            Iterator<? extends N> r11 = r10.iterator();
        L8:
            if (r11.hasNext() == false) goto L11;
            checkThatNodeIsInGraph(r11.next());
            goto L8
        L11:
            return new AnonymousClass3(this, r10);
        L5:
            return ImmutableSet.of();
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(final Iterable<? extends N> r10) {
            Preconditions.checkNotNull(r10);
            if (Iterables.isEmpty(r10) == true) goto L5;
            Iterator<? extends N> r11 = r10.iterator();
        L8:
            if (r11.hasNext() == false) goto L11;
            checkThatNodeIsInGraph(r11.next());
            goto L8
        L11:
            return new AnonymousClass2(this, r10);
        L5:
            return ImmutableSet.of();
        }
    }

    public static final enum Order extends Enum<Order> {
        private static final /* synthetic */ Order[] $VALUES = null;
        public static final Order POSTORDER = null;
        public static final Order PREORDER = null;

        static {
            Order r10 = new Order("PREORDER", 0);
            PREORDER = r10;
            Order r11 = new Order("POSTORDER", 1);
            POSTORDER = r11;
            $VALUES = new Order[]{r10, r11};
        }

        private Order(String r10, int r11) {
            super(r10, r11);
        }

        public static Order valueOf(String r10) {
            return (Order) Enum.valueOf(Order.class, r10);
        }

        public static Order[] values() {
            return (Order[]) $VALUES.clone();
        }
    }

    public static final class TreeTraverser<N> extends Traverser<N> {
        private final SuccessorsFunction<N> tree;

        public final class BreadthFirstIterator extends UnmodifiableIterator<N> {
            private final Queue<N> queue;
            final /* synthetic */ TreeTraverser this$0;

            public BreadthFirstIterator(TreeTraverser r10, Iterable<? extends N> r11) {
                this.this$0 = r10;
                this.queue = new ArrayDeque();
                Iterator<? extends N> r12 = r11.iterator();
            L4:
                if (r12.hasNext() == false) goto L6;
                N r13 = r12.next();
                this.queue.add(r13);
                goto L4
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.queue.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                N r10 = this.queue.remove();
                Iterables.addAll(this.queue, TreeTraverser.access$200(this.this$0).successors(r10));
                return r10;
            }
        }

        public final class DepthFirstPostOrderIterator extends AbstractIterator<N> {
            private final ArrayDeque<TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren> stack;
            final /* synthetic */ TreeTraverser this$0;

            public final class NodeAndChildren {
                final Iterator<? extends N> childIterator;

                @NullableDecl
                final N node;
                final /* synthetic */ DepthFirstPostOrderIterator this$1;

                public NodeAndChildren(@NullableDecl DepthFirstPostOrderIterator r10, N r11, Iterable<? extends N> r12) {
                    this.this$1 = r10;
                    this.node = r11;
                    this.childIterator = r12.iterator();
                }
            }

            public DepthFirstPostOrderIterator(TreeTraverser r10, Iterable<? extends N> r11) {
                this.this$0 = r10;
                ArrayDeque<TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren> r12 = new ArrayDeque();
                this.stack = r12;
                r12.addLast(new NodeAndChildren(this, null, r11));
            }

            @Override // com.google.common.collect.AbstractIterator
            public N computeNext() {
            L3:
                if (this.stack.isEmpty() == true) goto L11;
                TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren r10 = this.stack.getLast();
                if (r10.childIterator.hasNext() == true) goto L6;
                this.stack.removeLast();
                N r11 = r10.node;
                if (r11 == null) goto L3;
                return r11;
            L6:
                N r12 = r10.childIterator.next();
                this.stack.addLast(withChildren(r12));
                goto L3
            L11:
                return (N) endOfData();
            }

            public TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren withChildren(N r10) {
                return new NodeAndChildren(this, r10, TreeTraverser.access$200(this.this$0).successors(r10));
            }
        }

        public final class DepthFirstPreOrderIterator extends UnmodifiableIterator<N> {
            private final Deque<Iterator<? extends N>> stack;
            final /* synthetic */ TreeTraverser this$0;

            public DepthFirstPreOrderIterator(TreeTraverser r10, Iterable<? extends N> r11) {
                this.this$0 = r10;
                ArrayDeque r12 = new ArrayDeque();
                this.stack = r12;
                r12.addLast(r11.iterator());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.stack.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                Iterator<? extends N> r10 = this.stack.getLast();
                N r11 = (N) Preconditions.checkNotNull(r10.next());
                if (r10.hasNext() == true) goto L5;
                this.stack.removeLast();
            L5:
                Iterator<? extends N> r12 = TreeTraverser.access$200(this.this$0).successors(r11).iterator();
                if (r12.hasNext() == false) goto L8;
                this.stack.addLast(r12);
            L8:
                return r11;
            }
        }

        public TreeTraverser(SuccessorsFunction<N> r10) {
            super(null);
            this.tree = (SuccessorsFunction) Preconditions.checkNotNull(r10);
        }

        public static /* synthetic */ SuccessorsFunction access$200(TreeTraverser r10) {
            return r10.tree;
        }

        private void checkThatNodeIsInTree(N r10) {
            this.tree.successors(r10);
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(N r10) {
            Preconditions.checkNotNull(r10);
            return breadthFirst(ImmutableSet.of(r10));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(N r10) {
            Preconditions.checkNotNull(r10);
            return depthFirstPostOrder(ImmutableSet.of(r10));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(N r10) {
            Preconditions.checkNotNull(r10);
            return depthFirstPreOrder(ImmutableSet.of(r10));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(final Iterable<? extends N> r10) {
            Preconditions.checkNotNull(r10);
            if (Iterables.isEmpty(r10) == true) goto L5;
            Iterator<? extends N> r11 = r10.iterator();
        L8:
            if (r11.hasNext() == false) goto L11;
            checkThatNodeIsInTree(r11.next());
            goto L8
        L11:
            return new AnonymousClass1(this, r10);
        L5:
            return ImmutableSet.of();
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(final Iterable<? extends N> r10) {
            Preconditions.checkNotNull(r10);
            if (Iterables.isEmpty(r10) == true) goto L5;
            Iterator<? extends N> r11 = r10.iterator();
        L8:
            if (r11.hasNext() == false) goto L11;
            checkThatNodeIsInTree(r11.next());
            goto L8
        L11:
            return new AnonymousClass3(this, r10);
        L5:
            return ImmutableSet.of();
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(final Iterable<? extends N> r10) {
            Preconditions.checkNotNull(r10);
            if (Iterables.isEmpty(r10) == true) goto L5;
            Iterator<? extends N> r11 = r10.iterator();
        L8:
            if (r11.hasNext() == false) goto L11;
            checkThatNodeIsInTree(r11.next());
            goto L8
        L11:
            return new AnonymousClass2(this, r10);
        L5:
            return ImmutableSet.of();
        }
    }

    public /* synthetic */ Traverser(AnonymousClass1 r10) {
        this();
    }

    public static <N> Traverser<N> forGraph(SuccessorsFunction<N> r10) {
        Preconditions.checkNotNull(r10);
        return new GraphTraverser(r10);
    }

    public static <N> Traverser<N> forTree(SuccessorsFunction<N> r10) {
        Preconditions.checkNotNull(r10);
        if ((r10 instanceof BaseGraph) == false) goto L6;
        Preconditions.checkArgument(((BaseGraph) r10).isDirected(), "Undirected graphs can never be trees.");
    L6:
        if ((r10 instanceof Network) == false) goto L9;
        Preconditions.checkArgument(((Network) r10).isDirected(), "Undirected networks can never be trees.");
    L9:
        return new TreeTraverser(r10);
    }

    public abstract Iterable<N> breadthFirst(Iterable<? extends N> r10);

    public abstract Iterable<N> breadthFirst(N r10);

    public abstract Iterable<N> depthFirstPostOrder(Iterable<? extends N> r10);

    public abstract Iterable<N> depthFirstPostOrder(N r10);

    public abstract Iterable<N> depthFirstPreOrder(Iterable<? extends N> r10);

    public abstract Iterable<N> depthFirstPreOrder(N r10);

    private Traverser() {
    }
}
