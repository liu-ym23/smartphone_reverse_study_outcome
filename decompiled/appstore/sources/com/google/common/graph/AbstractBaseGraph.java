package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractBaseGraph<N> implements BaseGraph<N> {

    public static abstract class IncidentEdgeSet<N> extends AbstractSet<EndpointPair<N>> {
        protected final BaseGraph<N> graph;
        protected final N node;

        public static final class Directed<N> extends IncidentEdgeSet<N> {
            public /* synthetic */ Directed(BaseGraph r10, Object r11, AnonymousClass1 r12) {
                this(r10, r11);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object r10) {
                if ((r10 instanceof EndpointPair) == true) goto L5;
                return false;
            L5:
                EndpointPair r11 = (EndpointPair) r10;
                if (r11.isOrdered() == true) goto L8;
                return false;
            L8:
                Object r12 = r11.source();
                Object r13 = r11.target();
                if (this.node.equals(r12) == false) goto L13;
                if (this.graph.successors(this.node).contains(r13) == false) goto L13;
            L16:
                return true;
            L13:
                if (this.node.equals(r13) == true) goto L15;
                return false;
            L15:
                if (this.graph.predecessors(this.node).contains(r12) == true) goto L16;
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public /* bridge */ /* synthetic */ Iterator iterator() {
                return iterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return (this.graph.inDegree(this.node) + this.graph.outDegree(this.node)) - (this.graph.successors(this.node).contains(this.node) ? 1 : 0);
            }

            private Directed(BaseGraph<N> r10, N r11) {
                super(r10, r11, null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.graph.predecessors(this.node).iterator(), new AnonymousClass1(this)), Iterators.transform(Sets.difference(this.graph.successors(this.node), ImmutableSet.of(this.node)).iterator(), new AnonymousClass2(this))));
            }
        }

        public static final class Undirected<N> extends IncidentEdgeSet<N> {
            public /* synthetic */ Undirected(BaseGraph r10, Object r11, AnonymousClass1 r12) {
                this(r10, r11);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object r10) {
                if ((r10 instanceof EndpointPair) == true) goto L5;
                return false;
            L5:
                EndpointPair r11 = (EndpointPair) r10;
                if (r11.isOrdered() == false) goto L8;
                return false;
            L8:
                Set<N> r12 = this.graph.adjacentNodes(this.node);
                Object r13 = r11.nodeU();
                Object r14 = r11.nodeV();
                if (this.node.equals(r14) == false) goto L13;
                if (r12.contains(r13) == false) goto L13;
            L16:
                return true;
            L13:
                if (this.node.equals(r13) == true) goto L15;
                return false;
            L15:
                if (r12.contains(r14) == true) goto L16;
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public /* bridge */ /* synthetic */ Iterator iterator() {
                return iterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.graph.adjacentNodes(this.node).size();
            }

            private Undirected(BaseGraph<N> r10, N r11) {
                super(r10, r11, null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.unmodifiableIterator(Iterators.transform(this.graph.adjacentNodes(this.node).iterator(), new AnonymousClass1(this)));
            }
        }

        public /* synthetic */ IncidentEdgeSet(BaseGraph r10, Object r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        public static <N> IncidentEdgeSet<N> of(BaseGraph<N> r10, N r11) {
            AnonymousClass1 r12 = null;
            if (r10.isDirected() == false) goto L6;
            return new Directed(r10, r11, r12);
        L6:
            return new Undirected(r10, r11, r12);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r10) {
            throw new UnsupportedOperationException();
        }

        private IncidentEdgeSet(BaseGraph<N> r10, N r11) {
            this.graph = r10;
            this.node = r11;
        }
    }

    public AbstractBaseGraph() {
    }

    @Override // com.google.common.graph.BaseGraph
    public int degree(N r10) {
        if (isDirected() == true) goto L5;
        Set<N> r11 = adjacentNodes(r10);
        if (allowsSelfLoops() == true) goto L9;
    L11:
        int r12 = 0;
    L13:
        return IntMath.saturatedAdd(r11.size(), r12);
    L9:
        if (r11.contains(r10) == false) goto L11;
        r12 = 1;
        goto L13
    L5:
        return IntMath.saturatedAdd(predecessors(r10).size(), successors(r10).size());
    }

    public long edgeCount() {
        Iterator<N> r10 = nodes().iterator();
        long r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L7;
        r11 = r11 + ((long) degree(r10.next()));
        goto L4
    L7:
        if ((1 & r11) != 0) goto L9;
        boolean r12 = true;
    L10:
        Preconditions.checkState(r12);
        return r11 >>> 1;
    L9:
        r12 = false;
        goto L10
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> edges() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N r10, N r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        if (nodes().contains(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (successors(r10).contains(r11) == false) goto L7;
        return true;
    }

    @Override // com.google.common.graph.BaseGraph
    public int inDegree(N r10) {
        if (isDirected() == false) goto L6;
        return predecessors(r10).size();
    L6:
        return degree(r10);
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> incidentEdges(N r10) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkArgument(nodes().contains(r10), "Node %s is not an element of this graph.", r10);
        return IncidentEdgeSet.of(this, r10);
    }

    public final boolean isOrderingCompatible(EndpointPair<?> r10) {
        if (r10.isOrdered() == false) goto L5;
    L8:
        return true;
    L5:
        if (isDirected() == false) goto L8;
        return false;
    }

    @Override // com.google.common.graph.BaseGraph
    public int outDegree(N r10) {
        if (isDirected() == false) goto L6;
        return successors(r10).size();
    L6:
        return degree(r10);
    }

    public final void validateEndpoints(EndpointPair<?> r10) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkArgument(isOrderingCompatible(r10), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair<N> r10) {
        Preconditions.checkNotNull(r10);
        if (isOrderingCompatible(r10) == true) goto L5;
        return false;
    L5:
        N r11 = r10.nodeU();
        N r12 = r10.nodeV();
        if (nodes().contains(r11) == true) goto L8;
        return false;
    L8:
        if (successors(r11).contains(r12) == false) goto L12;
        return true;
    L12:
        return false;
    }
}
