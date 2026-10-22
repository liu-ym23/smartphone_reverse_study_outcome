package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@Immutable(containerOf = {"N", "E"})
@Beta
public final class ImmutableNetwork<N, E> extends ConfigurableNetwork<N, E> {

    public static class Builder<N, E> {
        private final MutableNetwork<N, E> mutableNetwork;

        public Builder(NetworkBuilder<N, E> r10) {
            this.mutableNetwork = (MutableNetwork<N, E>) r10.build();
        }

        @CanIgnoreReturnValue
        public Builder<N, E> addEdge(N r10, N r11, E r12) {
            this.mutableNetwork.addEdge(r10, r11, r12);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N, E> addNode(N r10) {
            this.mutableNetwork.addNode(r10);
            return this;
        }

        public ImmutableNetwork<N, E> build() {
            return ImmutableNetwork.copyOf(this.mutableNetwork);
        }

        @CanIgnoreReturnValue
        public Builder<N, E> addEdge(EndpointPair<N> r10, E r11) {
            this.mutableNetwork.addEdge(r10, r11);
            return this;
        }
    }

    private ImmutableNetwork(Network<N, E> r10) {
        super(NetworkBuilder.from(r10), getNodeConnections(r10), getEdgeToReferenceNode(r10));
    }

    private static <N, E> Function<E, N> adjacentNodeFn(final Network<N, E> r10, final N r11) {
        return new AnonymousClass3(r10, r11);
    }

    private static <N, E> NetworkConnections<N, E> connectionsOf(Network<N, E> r10, N r11) {
        if (r10.isDirected() == false) goto L9;
        Map r12 = Maps.asMap(r10.inEdges(r11), sourceNodeFn(r10));
        Map r13 = Maps.asMap(r10.outEdges(r11), targetNodeFn(r10));
        int r14 = r10.edgesConnecting(r11, r11).size();
        if (r10.allowsParallelEdges() == false) goto L8;
        return DirectedMultiNetworkConnections.ofImmutable(r12, r13, r14);
    L8:
        return DirectedNetworkConnections.ofImmutable(r12, r13, r14);
    L9:
        Map r15 = Maps.asMap(r10.incidentEdges(r11), adjacentNodeFn(r10, r11));
        if (r10.allowsParallelEdges() == false) goto L13;
        return UndirectedMultiNetworkConnections.ofImmutable(r15);
    L13:
        return UndirectedNetworkConnections.ofImmutable(r15);
    }

    public static <N, E> ImmutableNetwork<N, E> copyOf(Network<N, E> r10) {
        if ((r10 instanceof ImmutableNetwork) == false) goto L6;
        return (ImmutableNetwork) r10;
    L6:
        return new ImmutableNetwork(r10);
    }

    private static <N, E> Map<E, N> getEdgeToReferenceNode(Network<N, E> r10) {
        ImmutableMap.Builder r11 = ImmutableMap.builder();
        Iterator<E> r12 = r10.edges().iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        E r13 = r12.next();
        r11.put(r13, r10.incidentNodes(r13).nodeU());
        goto L4
    L7:
        return r11.build();
    }

    private static <N, E> Map<N, NetworkConnections<N, E>> getNodeConnections(Network<N, E> r10) {
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

    private static <N, E> Function<E, N> sourceNodeFn(final Network<N, E> r10) {
        return new AnonymousClass1(r10);
    }

    private static <N, E> Function<E, N> targetNodeFn(final Network<N, E> r10) {
        return new AnonymousClass2(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object r10) {
        return super.adjacentNodes(r10);
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean allowsParallelEdges() {
        return super.allowsParallelEdges();
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Graph asGraph() {
        return asGraph();
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ ElementOrder edgeOrder() {
        return super.edgeOrder();
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set edgesConnecting(Object r10, Object r11) {
        return super.edgesConnecting(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set inEdges(Object r10) {
        return super.inEdges(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set incidentEdges(Object r10) {
        return super.incidentEdges(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ EndpointPair incidentNodes(Object r10) {
        return super.incidentNodes(r10);
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set outEdges(Object r10) {
        return super.outEdges(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Set predecessors(Object r10) {
        return super.predecessors(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Set successors(Object r10) {
        return super.successors(r10);
    }

    @Deprecated
    public static <N, E> ImmutableNetwork<N, E> copyOf(ImmutableNetwork<N, E> r10) {
        return (ImmutableNetwork) Preconditions.checkNotNull(r10);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph(super.asGraph());
    }
}
