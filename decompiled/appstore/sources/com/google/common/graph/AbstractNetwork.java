package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public abstract class AbstractNetwork<N, E> implements Network<N, E> {

    /* JADX INFO: renamed from: com.google.common.graph.AbstractNetwork$1, reason: invalid class name */
    public class AnonymousClass1 extends AbstractGraph<N> {
        final /* synthetic */ AbstractNetwork this$0;

        public AnonymousClass1(AbstractNetwork r10) {
            this.this$0 = r10;
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set<N> adjacentNodes(N r10) {
            return this.this$0.adjacentNodes(r10);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean allowsSelfLoops() {
            return this.this$0.allowsSelfLoops();
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public Set<EndpointPair<N>> edges() {
            if (this.this$0.allowsParallelEdges() == false) goto L7;
            return super.edges();
        L7:
            return new C01571(this);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean isDirected() {
            return this.this$0.isDirected();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public ElementOrder<N> nodeOrder() {
            return this.this$0.nodeOrder();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set<N> nodes() {
            return this.this$0.nodes();
        }

        @Override // com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ Iterable predecessors(Object r10) {
            return predecessors(r10);
        }

        @Override // com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ Iterable successors(Object r10) {
            return successors(r10);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N r10) {
            return this.this$0.predecessors(r10);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N r10) {
            return this.this$0.successors(r10);
        }
    }

    public AbstractNetwork() {
    }

    private Predicate<E> connectedPredicate(final N r10, final N r11) {
        return new AnonymousClass2(this, r10, r11);
    }

    private static <N, E> Map<E, EndpointPair<N>> edgeIncidentNodesMap(final Network<N, E> r10) {
        Function<E, EndpointPair<N>> r11 = new AnonymousClass3(r10);
        return Maps.asMap(r10.edges(), r11);
    }

    @Override // com.google.common.graph.Network
    public Set<E> adjacentEdges(E r10) {
        EndpointPair<N> r11 = incidentNodes(r10);
        return Sets.difference(Sets.union(incidentEdges(r11.nodeU()), incidentEdges(r11.nodeV())), ImmutableSet.of(r10));
    }

    @Override // com.google.common.graph.Network
    public Graph<N> asGraph() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.graph.Network
    public int degree(N r10) {
        if (isDirected() == false) goto L7;
        return IntMath.saturatedAdd(inEdges(r10).size(), outEdges(r10).size());
    L7:
        return IntMath.saturatedAdd(incidentEdges(r10).size(), edgesConnecting(r10, r10).size());
    }

    @Override // com.google.common.graph.Network
    @NullableDecl
    public E edgeConnectingOrNull(N r10, N r11) {
        Set<E> r12 = edgesConnecting(r10, r11);
        int r13 = r12.size();
        if (r13 != 0) goto L5;
        return null;
    L5:
        if (r13 != 1) goto L9;
        return r12.iterator().next();
    L9:
        throw new IllegalArgumentException(String.format("Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.", new Object[]{r10, r11}));
    }

    @Override // com.google.common.graph.Network
    public Set<E> edgesConnecting(N r10, N r11) {
        Set<E> r12 = outEdges(r10);
        Set<E> r13 = inEdges(r11);
        if (r12.size() > r13.size()) goto L6;
        return Collections.unmodifiableSet(Sets.filter(r12, connectedPredicate(r10, r11)));
    L6:
        return Collections.unmodifiableSet(Sets.filter(r13, connectedPredicate(r11, r10)));
    }

    @Override // com.google.common.graph.Network
    public final boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Network) == true) goto L8;
        return false;
    L8:
        Network r11 = (Network) r10;
        if (isDirected() != r11.isDirected()) goto L16;
        if (nodes().equals(r11.nodes()) == false) goto L16;
        if (edgeIncidentNodesMap(this).equals(edgeIncidentNodesMap(r11)) == false) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // com.google.common.graph.Network
    public boolean hasEdgeConnecting(N r10, N r11) {
        return !edgesConnecting(r10, r11).isEmpty();
    }

    @Override // com.google.common.graph.Network
    public final int hashCode() {
        return edgeIncidentNodesMap(this).hashCode();
    }

    @Override // com.google.common.graph.Network
    public int inDegree(N r10) {
        if (isDirected() == false) goto L6;
        return inEdges(r10).size();
    L6:
        return degree(r10);
    }

    public final boolean isOrderingCompatible(EndpointPair<?> r10) {
        if (r10.isOrdered() == false) goto L5;
    L8:
        return true;
    L5:
        if (isDirected() == false) goto L8;
        return false;
    }

    @Override // com.google.common.graph.Network
    public int outDegree(N r10) {
        if (isDirected() == false) goto L6;
        return outEdges(r10).size();
    L6:
        return degree(r10);
    }

    public String toString() {
        return "isDirected: " + isDirected() + ", allowsParallelEdges: " + allowsParallelEdges() + ", allowsSelfLoops: " + allowsSelfLoops() + ", nodes: " + nodes() + ", edges: " + edgeIncidentNodesMap(this);
    }

    public final void validateEndpoints(EndpointPair<?> r10) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkArgument(isOrderingCompatible(r10), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }

    @Override // com.google.common.graph.Network
    public boolean hasEdgeConnecting(EndpointPair<N> r10) {
        Preconditions.checkNotNull(r10);
        if (isOrderingCompatible(r10) == true) goto L7;
        return false;
    L7:
        return !edgesConnecting(r10.nodeU(), r10.nodeV()).isEmpty();
    }

    @Override // com.google.common.graph.Network
    @NullableDecl
    public E edgeConnectingOrNull(EndpointPair<N> r10) {
        validateEndpoints(r10);
        return edgeConnectingOrNull(r10.nodeU(), r10.nodeV());
    }

    @Override // com.google.common.graph.Network
    public Set<E> edgesConnecting(EndpointPair<N> r10) {
        validateEndpoints(r10);
        return edgesConnecting(r10.nodeU(), r10.nodeV());
    }
}
