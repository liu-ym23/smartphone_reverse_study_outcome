package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
abstract class EndpointPairIterator<N> extends AbstractIterator<EndpointPair<N>> {
    private final BaseGraph<N> graph;
    protected N node;
    private final Iterator<N> nodeIterator;
    protected Iterator<N> successorIterator;

    /* JADX INFO: renamed from: com.google.common.graph.EndpointPairIterator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Directed<N> extends EndpointPairIterator<N> {
        public /* synthetic */ Directed(BaseGraph r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.collect.AbstractIterator
        public /* bridge */ /* synthetic */ Object computeNext() {
            return computeNext();
        }

        private Directed(BaseGraph<N> r10) {
            super(r10, null);
        }

        @Override // com.google.common.collect.AbstractIterator
        public EndpointPair<N> computeNext() {
        L3:
            if (this.successorIterator.hasNext() == true) goto L5;
            if (advance() == true) goto L3;
            return endOfData();
        L5:
            return EndpointPair.ordered(this.node, this.successorIterator.next());
        }
    }

    public static final class Undirected<N> extends EndpointPairIterator<N> {
        private Set<N> visitedNodes;

        public /* synthetic */ Undirected(BaseGraph r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.collect.AbstractIterator
        public /* bridge */ /* synthetic */ Object computeNext() {
            return computeNext();
        }

        private Undirected(BaseGraph<N> r10) {
            super(r10, null);
            this.visitedNodes = Sets.newHashSetWithExpectedSize(r10.nodes().size());
        }

        @Override // com.google.common.collect.AbstractIterator
        public EndpointPair<N> computeNext() {
        L3:
            if (this.successorIterator.hasNext() == true) goto L4;
            this.visitedNodes.add(this.node);
            if (advance() == true) goto L3;
            this.visitedNodes = null;
            return endOfData();
        L4:
            N r10 = this.successorIterator.next();
            if (this.visitedNodes.contains(r10) == true) goto L3;
            return EndpointPair.unordered(this.node, r10);
        }
    }

    public /* synthetic */ EndpointPairIterator(BaseGraph r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static <N> EndpointPairIterator<N> of(BaseGraph<N> r10) {
        AnonymousClass1 r11 = null;
        if (r10.isDirected() == false) goto L6;
        return new Directed(r10, r11);
    L6:
        return new Undirected(r10, r11);
    }

    public final boolean advance() {
        Preconditions.checkState(!this.successorIterator.hasNext());
        if (this.nodeIterator.hasNext() == true) goto L6;
        return false;
    L6:
        N r10 = this.nodeIterator.next();
        this.node = r10;
        this.successorIterator = this.graph.successors(r10).iterator();
        return true;
    }

    private EndpointPairIterator(BaseGraph<N> r10) {
        this.node = null;
        this.successorIterator = ImmutableSet.of().iterator();
        this.graph = r10;
        this.nodeIterator = r10.nodes().iterator();
    }
}
