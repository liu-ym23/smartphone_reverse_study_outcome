package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class Graphs {

    public static final enum NodeVisitState extends Enum<NodeVisitState> {
        private static final /* synthetic */ NodeVisitState[] $VALUES = null;
        public static final NodeVisitState COMPLETE = null;
        public static final NodeVisitState PENDING = null;

        static {
            NodeVisitState r10 = new NodeVisitState("PENDING", 0);
            PENDING = r10;
            NodeVisitState r11 = new NodeVisitState("COMPLETE", 1);
            COMPLETE = r11;
            $VALUES = new NodeVisitState[]{r10, r11};
        }

        private NodeVisitState(String r10, int r11) {
            super(r10, r11);
        }

        public static NodeVisitState valueOf(String r10) {
            return (NodeVisitState) Enum.valueOf(NodeVisitState.class, r10);
        }

        public static NodeVisitState[] values() {
            return (NodeVisitState[]) $VALUES.clone();
        }
    }

    public static class TransposedGraph<N> extends ForwardingGraph<N> {
        private final Graph<N> graph;

        public TransposedGraph(Graph<N> r10) {
            this.graph = r10;
        }

        public static /* synthetic */ Graph access$000(TransposedGraph r10) {
            return r10.graph;
        }

        @Override // com.google.common.graph.ForwardingGraph
        public /* bridge */ /* synthetic */ BaseGraph delegate() {
            return delegate();
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(N r10, N r11) {
            return delegate().hasEdgeConnecting(r11, r10);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N r10) {
            return delegate().outDegree(r10);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N r10) {
            return delegate().inDegree(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ Iterable predecessors(Object r10) {
            return predecessors(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ Iterable successors(Object r10) {
            return successors(r10);
        }

        @Override // com.google.common.graph.ForwardingGraph
        public Graph<N> delegate() {
            return this.graph;
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(EndpointPair<N> r10) {
            return delegate().hasEdgeConnecting(Graphs.transpose(r10));
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N r10) {
            return delegate().successors(r10);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N r10) {
            return delegate().predecessors(r10);
        }
    }

    public static class TransposedNetwork<N, E> extends ForwardingNetwork<N, E> {
        private final Network<N, E> network;

        public TransposedNetwork(Network<N, E> r10) {
            this.network = r10;
        }

        public static /* synthetic */ Network access$200(TransposedNetwork r10) {
            return r10.network;
        }

        @Override // com.google.common.graph.ForwardingNetwork
        public Network<N, E> delegate() {
            return this.network;
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public E edgeConnectingOrNull(N r10, N r11) {
            return delegate().edgeConnectingOrNull(r11, r10);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> edgesConnecting(N r10, N r11) {
            return delegate().edgesConnecting(r11, r10);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(N r10, N r11) {
            return delegate().hasEdgeConnecting(r11, r10);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int inDegree(N r10) {
            return delegate().outDegree(r10);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set<E> inEdges(N r10) {
            return delegate().outEdges(r10);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public EndpointPair<N> incidentNodes(E r10) {
            EndpointPair<N> r11 = delegate().incidentNodes(r10);
            return EndpointPair.of(this.network, r11.nodeV(), r11.nodeU());
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int outDegree(N r10) {
            return delegate().inDegree(r10);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set<E> outEdges(N r10) {
            return delegate().inEdges(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ Iterable predecessors(Object r10) {
            return predecessors(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ Iterable successors(Object r10) {
            return successors(r10);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public E edgeConnectingOrNull(EndpointPair<N> r10) {
            return delegate().edgeConnectingOrNull(Graphs.transpose(r10));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> edgesConnecting(EndpointPair<N> r10) {
            return delegate().edgesConnecting(Graphs.transpose(r10));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(EndpointPair<N> r10) {
            return delegate().hasEdgeConnecting(Graphs.transpose(r10));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N r10) {
            return delegate().successors(r10);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N r10) {
            return delegate().predecessors(r10);
        }
    }

    public static class TransposedValueGraph<N, V> extends ForwardingValueGraph<N, V> {
        private final ValueGraph<N, V> graph;

        public TransposedValueGraph(ValueGraph<N, V> r10) {
            this.graph = r10;
        }

        public static /* synthetic */ ValueGraph access$100(TransposedValueGraph r10) {
            return r10.graph;
        }

        @Override // com.google.common.graph.ForwardingValueGraph
        public ValueGraph<N, V> delegate() {
            return this.graph;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        @NullableDecl
        public V edgeValueOrDefault(N r10, N r11, @NullableDecl V r12) {
            return delegate().edgeValueOrDefault(r11, r10, r12);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(N r10, N r11) {
            return delegate().hasEdgeConnecting(r11, r10);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N r10) {
            return delegate().outDegree(r10);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N r10) {
            return delegate().inDegree(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ Iterable predecessors(Object r10) {
            return predecessors(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ Iterable successors(Object r10) {
            return successors(r10);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        @NullableDecl
        public V edgeValueOrDefault(EndpointPair<N> r10, @NullableDecl V r11) {
            return delegate().edgeValueOrDefault(Graphs.transpose(r10), r11);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(EndpointPair<N> r10) {
            return delegate().hasEdgeConnecting(Graphs.transpose(r10));
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N r10) {
            return delegate().successors(r10);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N r10) {
            return delegate().predecessors(r10);
        }
    }

    private Graphs() {
    }

    private static boolean canTraverseWithoutReusingEdge(Graph<?> r10, Object r11, @NullableDecl Object r12) {
        if (r10.isDirected() == false) goto L5;
        return true;
    L5:
        if (Objects.equal(r12, r11) == false) goto L11;
        return false;
    L11:
        return true;
    }

    @CanIgnoreReturnValue
    public static int checkNonNegative(int r10) {
        if (r10 < 0) goto L4;
        boolean r11 = true;
    L5:
        Preconditions.checkArgument(r11, "Not true that %s is non-negative.", r10);
        return r10;
    L4:
        r11 = false;
        goto L5
    }

    @CanIgnoreReturnValue
    public static int checkPositive(int r10) {
        if (r10 <= 0) goto L4;
        boolean r11 = true;
    L5:
        Preconditions.checkArgument(r11, "Not true that %s is positive.", r10);
        return r10;
    L4:
        r11 = false;
        goto L5
    }

    public static <N> MutableGraph<N> copyOf(Graph<N> r10) {
        MutableGraph<N> r11 = (MutableGraph<N>) GraphBuilder.from(r10).expectedNodeCount(r10.nodes().size()).build();
        Iterator<N> r12 = r10.nodes().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.addNode(r12.next());
        goto L4
    L6:
        Iterator<EndpointPair<N>> r13 = r10.edges().iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        EndpointPair<N> r14 = r13.next();
        r11.putEdge(r14.nodeU(), r14.nodeV());
        goto L8
    L10:
        return r11;
    }

    public static <N> boolean hasCycle(Graph<N> r10) {
        int r11 = r10.edges().size();
        if (r11 != 0) goto L6;
        return false;
    L6:
        if (r10.isDirected() == false) goto L8;
    L10:
        HashMap r12 = Maps.newHashMapWithExpectedSize(r10.nodes().size());
        Iterator<N> r13 = r10.nodes().iterator();
    L12:
        if (r13.hasNext() == false) goto L16;
        if (subgraphHasCycle(r10, r12, r13.next(), null) == false) goto L12;
        return true;
    L16:
        return false;
    L8:
        if (r11 < r10.nodes().size()) goto L10;
        return true;
    }

    public static <N> MutableGraph<N> inducedSubgraph(Graph<N> r10, Iterable<? extends N> r11) {
        if ((r11 instanceof Collection) == false) goto L5;
        ConfigurableMutableGraph r12 = (MutableGraph<N>) GraphBuilder.from(r10).expectedNodeCount(((Collection) r11).size()).build();
    L6:
        Iterator<? extends N> r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        ConfigurableMutableGraph r14 = r12;
        r14.addNode(r13.next());
        goto L8
    L10:
        Iterator<N> r15 = r12.nodes().iterator();
    L12:
        if (r15.hasNext() == false) goto L19;
        N r16 = r15.next();
        Iterator<N> r17 = r10.successors(r16).iterator();
    L15:
        if (r17.hasNext() == false) goto L12;
        N r18 = r17.next();
        if (r12.nodes().contains(r18) == false) goto L15;
        r12.putEdge(r16, r18);
        goto L15
    L19:
        return r12;
    L5:
        r12 = (MutableGraph<N>) GraphBuilder.from(r10).build();
        goto L6
    }

    public static <N> Set<N> reachableNodes(Graph<N> r10, N r11) {
        Preconditions.checkArgument(r10.nodes().contains(r11), "Node %s is not an element of this graph.", r11);
        return ImmutableSet.copyOf(Traverser.forGraph(r10).breadthFirst(r11));
    }

    private static <N> boolean subgraphHasCycle(Graph<N> r10, Map<Object, NodeVisitState> r11, N r12, @NullableDecl N r13) {
        NodeVisitState r14 = r11.get(r12);
        if (r14 != NodeVisitState.COMPLETE) goto L5;
        return false;
    L5:
        NodeVisitState r15 = NodeVisitState.PENDING;
        if (r14 != r15) goto L8;
        return true;
    L8:
        r11.put(r12, r15);
        Iterator<N> r16 = r10.successors(r12).iterator();
    L10:
        if (r16.hasNext() == false) goto L16;
        N r17 = r16.next();
        if (canTraverseWithoutReusingEdge(r10, r17, r13) == false) goto L10;
        if (subgraphHasCycle(r10, r11, r17, r12) == false) goto L10;
        return true;
    L16:
        r11.put(r12, NodeVisitState.COMPLETE);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> Graph<N> transitiveClosure(Graph<N> r10) {
        ConfigurableMutableGraph r11 = GraphBuilder.from(r10).allowsSelfLoops(true).build();
        if (r10.isDirected() == false) goto L11;
        Iterator<N> r12 = r10.nodes().iterator();
    L6:
        if (r12.hasNext() == false) goto L24;
        N r13 = r12.next();
        Iterator r14 = reachableNodes(r10, r13).iterator();
    L9:
        if (r14.hasNext() == false) goto L6;
        r11.putEdge(r13, r14.next());
    L24:
        return r11;
    L11:
        HashSet r15 = new HashSet();
        Iterator<N> r16 = r10.nodes().iterator();
    L13:
        if (r16.hasNext() == false) goto L24;
        N r17 = r16.next();
        if (r15.contains(r17) == true) goto L13;
        Set r18 = reachableNodes(r10, r17);
        r15.addAll(r18);
        Iterator r19 = r18.iterator();
        int r20 = 1;
    L18:
        if (r19.hasNext() == false) goto L13;
        Object r21 = r19.next();
        int r22 = r20 + 1;
        Iterator r23 = Iterables.limit(r18, r20).iterator();
    L21:
        if (r23.hasNext() == false) goto L23;
        r11.putEdge(r21, r23.next());
        goto L21
    L23:
        r20 = r22;
        goto L18
    }

    public static <N> Graph<N> transpose(Graph<N> r10) {
        if (r10.isDirected() == true) goto L6;
        return r10;
    L6:
        if ((r10 instanceof TransposedGraph) == false) goto L10;
        return TransposedGraph.access$000((TransposedGraph) r10);
    L10:
        return new TransposedGraph(r10);
    }

    @CanIgnoreReturnValue
    public static long checkNonNegative(long r10) {
        if (r10 < 0) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "Not true that %s is non-negative.", r10);
        return r10;
    L5:
        r11 = false;
        goto L6
    }

    @CanIgnoreReturnValue
    public static long checkPositive(long r10) {
        if (r10 <= 0) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "Not true that %s is positive.", r10);
        return r10;
    L5:
        r11 = false;
        goto L6
    }

    public static <N, V> ValueGraph<N, V> transpose(ValueGraph<N, V> r10) {
        if (r10.isDirected() == true) goto L6;
        return r10;
    L6:
        if ((r10 instanceof TransposedValueGraph) == false) goto L10;
        return TransposedValueGraph.access$100((TransposedValueGraph) r10);
    L10:
        return new TransposedValueGraph(r10);
    }

    public static <N, V> MutableValueGraph<N, V> copyOf(ValueGraph<N, V> r10) {
        MutableValueGraph<N, V> r11 = (MutableValueGraph<N, V>) ValueGraphBuilder.from(r10).expectedNodeCount(r10.nodes().size()).build();
        Iterator<N> r12 = r10.nodes().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.addNode(r12.next());
        goto L4
    L6:
        Iterator<EndpointPair<N>> r13 = r10.edges().iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        EndpointPair<N> r14 = r13.next();
        r11.putEdgeValue(r14.nodeU(), r14.nodeV(), r10.edgeValueOrDefault(r14.nodeU(), r14.nodeV(), null));
        goto L8
    L10:
        return r11;
    }

    public static boolean hasCycle(Network<?, ?> r10) {
        if (r10.isDirected() == true) goto L11;
        if (r10.allowsParallelEdges() == false) goto L11;
        if (r10.edges().size() <= r10.asGraph().edges().size()) goto L11;
        return true;
    L11:
        return hasCycle(r10.asGraph());
    }

    public static <N, E> Network<N, E> transpose(Network<N, E> r10) {
        if (r10.isDirected() == true) goto L6;
        return r10;
    L6:
        if ((r10 instanceof TransposedNetwork) == false) goto L10;
        return TransposedNetwork.access$200((TransposedNetwork) r10);
    L10:
        return new TransposedNetwork(r10);
    }

    public static <N, V> MutableValueGraph<N, V> inducedSubgraph(ValueGraph<N, V> r10, Iterable<? extends N> r11) {
        if ((r11 instanceof Collection) == false) goto L5;
        ConfigurableMutableValueGraph r12 = (MutableValueGraph<N, V>) ValueGraphBuilder.from(r10).expectedNodeCount(((Collection) r11).size()).build();
    L6:
        Iterator<? extends N> r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        ConfigurableMutableValueGraph r14 = r12;
        r14.addNode(r13.next());
        goto L8
    L10:
        Iterator<N> r15 = r12.nodes().iterator();
    L12:
        if (r15.hasNext() == false) goto L19;
        N r16 = r15.next();
        Iterator<N> r17 = r10.successors(r16).iterator();
    L15:
        if (r17.hasNext() == false) goto L12;
        N r18 = r17.next();
        if (r12.nodes().contains(r18) == false) goto L15;
        ConfigurableMutableValueGraph r19 = r12;
        r19.putEdgeValue(r16, r18, r10.edgeValueOrDefault(r16, r18, null));
        goto L15
    L19:
        return r12;
    L5:
        r12 = (MutableValueGraph<N, V>) ValueGraphBuilder.from(r10).build();
        goto L6
    }

    public static <N, E> MutableNetwork<N, E> copyOf(Network<N, E> r10) {
        MutableNetwork<N, E> r11 = (MutableNetwork<N, E>) NetworkBuilder.from(r10).expectedNodeCount(r10.nodes().size()).expectedEdgeCount(r10.edges().size()).build();
        Iterator<N> r12 = r10.nodes().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.addNode(r12.next());
        goto L4
    L6:
        Iterator<E> r13 = r10.edges().iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        E r14 = r13.next();
        EndpointPair<N> r15 = r10.incidentNodes(r14);
        r11.addEdge(r15.nodeU(), r15.nodeV(), r14);
        goto L8
    L10:
        return r11;
    }

    public static <N> EndpointPair<N> transpose(EndpointPair<N> r10) {
        if (r10.isOrdered() == true) goto L5;
        return r10;
    L5:
        return EndpointPair.ordered(r10.target(), r10.source());
    }

    public static <N, E> MutableNetwork<N, E> inducedSubgraph(Network<N, E> r10, Iterable<? extends N> r11) {
        if ((r11 instanceof Collection) == false) goto L5;
        ConfigurableMutableNetwork r12 = (MutableNetwork<N, E>) NetworkBuilder.from(r10).expectedNodeCount(((Collection) r11).size()).build();
    L6:
        Iterator<? extends N> r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        ConfigurableMutableNetwork r14 = r12;
        r14.addNode(r13.next());
        goto L8
    L10:
        Iterator<E> r15 = r12.nodes().iterator();
    L12:
        if (r15.hasNext() == false) goto L19;
        E r16 = r15.next();
        Iterator<E> r17 = r10.outEdges(r16).iterator();
    L15:
        if (r17.hasNext() == false) goto L12;
        E r18 = r17.next();
        N r19 = r10.incidentNodes(r18).adjacentNode(r16);
        if (r12.nodes().contains(r19) == false) goto L15;
        r12.addEdge(r16, r19, r18);
        goto L15
    L19:
        return r12;
    L5:
        r12 = (MutableNetwork<N, E>) NetworkBuilder.from(r10).build();
        goto L6
    }
}
