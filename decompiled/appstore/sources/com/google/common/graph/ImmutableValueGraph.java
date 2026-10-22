package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Immutable(containerOf = {"N", "V"})
@Beta
public final class ImmutableValueGraph<N, V> extends ConfigurableValueGraph<N, V> {

    public static class Builder<N, V> {
        private final MutableValueGraph<N, V> mutableValueGraph;

        public Builder(ValueGraphBuilder<N, V> r10) {
            this.mutableValueGraph = (MutableValueGraph<N, V>) r10.build();
        }

        @CanIgnoreReturnValue
        public Builder<N, V> addNode(N r10) {
            this.mutableValueGraph.addNode(r10);
            return this;
        }

        public ImmutableValueGraph<N, V> build() {
            return ImmutableValueGraph.copyOf(this.mutableValueGraph);
        }

        @CanIgnoreReturnValue
        public Builder<N, V> putEdgeValue(N r10, N r11, V r12) {
            this.mutableValueGraph.putEdgeValue(r10, r11, r12);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N, V> putEdgeValue(EndpointPair<N> r10, V r11) {
            this.mutableValueGraph.putEdgeValue(r10, r11);
            return this;
        }
    }

    private ImmutableValueGraph(ValueGraph<N, V> r10) {
        super(ValueGraphBuilder.from(r10), getNodeConnections(r10), r10.edges().size());
    }

    private static <N, V> GraphConnections<N, V> connectionsOf(final ValueGraph<N, V> r10, final N r11) {
        Function<N, V> r12 = new AnonymousClass1(r10, r11);
        if (r10.isDirected() == false) goto L6;
        return DirectedGraphConnections.ofImmutable(r10.predecessors(r11), Maps.asMap(r10.successors(r11), r12));
    L6:
        return UndirectedGraphConnections.ofImmutable(Maps.asMap(r10.adjacentNodes(r11), r12));
    }

    public static <N, V> ImmutableValueGraph<N, V> copyOf(ValueGraph<N, V> r10) {
        if ((r10 instanceof ImmutableValueGraph) == false) goto L6;
        return (ImmutableValueGraph) r10;
    L6:
        return new ImmutableValueGraph(r10);
    }

    private static <N, V> ImmutableMap<N, GraphConnections<N, V>> getNodeConnections(ValueGraph<N, V> r10) {
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
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object r10) {
        return super.adjacentNodes(r10);
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.ValueGraph
    public /* bridge */ /* synthetic */ Graph asGraph() {
        return asGraph();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.ValueGraph
    @NullableDecl
    public /* bridge */ /* synthetic */ Object edgeValueOrDefault(EndpointPair r10, @NullableDecl Object r11) {
        return super.edgeValueOrDefault(r10, r11);
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair r10) {
        return super.hasEdgeConnecting(r10);
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Set predecessors(Object r10) {
        return super.predecessors(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Set successors(Object r10) {
        return super.successors(r10);
    }

    @Deprecated
    public static <N, V> ImmutableValueGraph<N, V> copyOf(ImmutableValueGraph<N, V> r10) {
        return (ImmutableValueGraph) Preconditions.checkNotNull(r10);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.ValueGraph
    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.ValueGraph
    @NullableDecl
    public /* bridge */ /* synthetic */ Object edgeValueOrDefault(Object r10, Object r11, @NullableDecl Object r12) {
        return super.edgeValueOrDefault(r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object r10, Object r11) {
        return super.hasEdgeConnecting(r10, r11);
    }
}
