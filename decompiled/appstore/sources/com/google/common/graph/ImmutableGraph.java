package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@Immutable(containerOf = {"N"})
@Beta
public class ImmutableGraph<N> extends ForwardingGraph<N> {
    private final BaseGraph<N> backingGraph;

    public static class Builder<N> {
        private final MutableGraph<N> mutableGraph;

        public Builder(GraphBuilder<N> r10) {
            this.mutableGraph = (MutableGraph<N>) r10.build();
        }

        @CanIgnoreReturnValue
        public Builder<N> addNode(N r10) {
            this.mutableGraph.addNode(r10);
            return this;
        }

        public ImmutableGraph<N> build() {
            return ImmutableGraph.copyOf(this.mutableGraph);
        }

        @CanIgnoreReturnValue
        public Builder<N> putEdge(N r10, N r11) {
            this.mutableGraph.putEdge(r10, r11);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N> putEdge(EndpointPair<N> r10) {
            this.mutableGraph.putEdge(r10);
            return this;
        }
    }

    public ImmutableGraph(BaseGraph<N> r10) {
        this.backingGraph = r10;
    }

    private static <N> GraphConnections<N, GraphConstants.Presence> connectionsOf(Graph<N> r10, N r11) {
        Function r12 = Functions.constant(GraphConstants.Presence.EDGE_EXISTS);
        if (r10.isDirected() == false) goto L6;
        return DirectedGraphConnections.ofImmutable(r10.predecessors(r11), Maps.asMap(r10.successors(r11), r12));
    L6:
        return UndirectedGraphConnections.ofImmutable(Maps.asMap(r10.adjacentNodes(r11), r12));
    }

    public static <N> ImmutableGraph<N> copyOf(Graph<N> r10) {
        if ((r10 instanceof ImmutableGraph) == false) goto L6;
        return (ImmutableGraph) r10;
    L6:
        return new ImmutableGraph(new ConfigurableValueGraph(GraphBuilder.from(r10), getNodeConnections(r10), r10.edges().size()));
    }

    private static <N> ImmutableMap<N, GraphConnections<N, GraphConstants.Presence>> getNodeConnections(Graph<N> r10) {
        ImmutableMap.Builder r11 = ImmutableMap.builder();
        Iterator<N> r12 = r10.nodes().iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        N r13 = r12.next();
        r11.put(r13, connectionsOf(r10, r13));
        goto L4
    L7:
        return r11.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object r10) {
        return super.adjacentNodes(r10);
    }

    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int degree(Object r10) {
        return super.degree(r10);
    }

    @Override // com.google.common.graph.ForwardingGraph
    public BaseGraph<N> delegate() {
        return this.backingGraph;
    }

    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair r10) {
        return super.hasEdgeConnecting(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int inDegree(Object r10) {
        return super.inDegree(r10);
    }

    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int outDegree(Object r10) {
        return super.outDegree(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Set predecessors(Object r10) {
        return super.predecessors(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Set successors(Object r10) {
        return super.successors(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object r10, Object r11) {
        return super.hasEdgeConnecting(r10, r11);
    }

    @Deprecated
    public static <N> ImmutableGraph<N> copyOf(ImmutableGraph<N> r10) {
        return (ImmutableGraph) Preconditions.checkNotNull(r10);
    }
}
