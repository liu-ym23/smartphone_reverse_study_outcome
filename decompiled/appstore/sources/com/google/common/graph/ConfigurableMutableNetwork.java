package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: loaded from: classes3.dex */
final class ConfigurableMutableNetwork<N, E> extends ConfigurableNetwork<N, E> implements MutableNetwork<N, E> {
    public ConfigurableMutableNetwork(NetworkBuilder<? super N, ? super E> r10) {
        super(r10);
    }

    @CanIgnoreReturnValue
    private NetworkConnections<N, E> addNodeInternal(N r10) {
        NetworkConnections<N, E> r11 = newConnections();
        if (this.nodeConnections.put(r10, r11) != null) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkState(r12);
        return r11;
    L5:
        r12 = false;
        goto L6
    }

    private NetworkConnections<N, E> newConnections() {
        if (isDirected() == false) goto L9;
        if (allowsParallelEdges() == false) goto L14;
        return DirectedMultiNetworkConnections.of();
    L14:
        return DirectedNetworkConnections.of();
    L9:
        if (allowsParallelEdges() == false) goto L12;
        return UndirectedMultiNetworkConnections.of();
    L12:
        return UndirectedNetworkConnections.of();
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean addEdge(N r10, N r11, E r12) {
        Preconditions.checkNotNull(r10, "nodeU");
        Preconditions.checkNotNull(r11, "nodeV");
        Preconditions.checkNotNull(r12, "edge");
        boolean r13 = false;
        if (containsEdge(r12) == false) goto L6;
        EndpointPair<N> r14 = incidentNodes(r12);
        EndpointPair r15 = EndpointPair.of(this, r10, r11);
        Preconditions.checkArgument(r14.equals(r15), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", r12, r14, r15);
        return false;
    L6:
        NetworkConnections<N, E> r16 = this.nodeConnections.get(r10);
        if (allowsParallelEdges() == true) goto L13;
        if (r16 != null) goto L10;
    L11:
        r13 = true;
    L12:
        Preconditions.checkArgument(r13, "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", r10, r11);
        goto L13
    L10:
        if (r16.successors().contains(r11) == true) goto L12;
    L13:
        boolean r17 = r10.equals(r11);
        if (allowsSelfLoops() == true) goto L16;
        Preconditions.checkArgument(!r17, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", r10);
    L16:
        if (r16 != null) goto L18;
        r16 = addNodeInternal(r10);
    L18:
        r16.addOutEdge(r12, r11);
        NetworkConnections<N, E> r18 = this.nodeConnections.get(r11);
        if (r18 != null) goto L21;
        r18 = addNodeInternal(r11);
    L21:
        r18.addInEdge(r12, r10, r17);
        this.edgeToReferenceNode.put(r12, r10);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean addNode(N r10) {
        Preconditions.checkNotNull(r10, "node");
        if (containsNode(r10) == false) goto L6;
        return false;
    L6:
        addNodeInternal(r10);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean removeEdge(E r10) {
        Preconditions.checkNotNull(r10, "edge");
        N r11 = this.edgeToReferenceNode.get(r10);
        boolean r12 = false;
        if (r11 != null) goto L5;
        return false;
    L5:
        NetworkConnections<N, E> r13 = this.nodeConnections.get(r11);
        N r14 = r13.adjacentNode(r10);
        NetworkConnections<N, E> r15 = this.nodeConnections.get(r14);
        r13.removeOutEdge(r10);
        if (allowsSelfLoops() == true) goto L8;
    L10:
        r15.removeInEdge(r10, r12);
        this.edgeToReferenceNode.remove(r10);
        return true;
    L8:
        if (r11.equals(r14) == false) goto L10;
        r12 = true;
        goto L10
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean removeNode(N r10) {
        Preconditions.checkNotNull(r10, "node");
        NetworkConnections<N, E> r11 = this.nodeConnections.get(r10);
        if (r11 != null) goto L6;
        return false;
    L6:
        UnmodifiableIterator<E> r12 = ImmutableList.copyOf(r11.incidentEdges()).iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        removeEdge(r12.next());
        goto L8
    L10:
        this.nodeConnections.remove(r10);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean addEdge(EndpointPair<N> r10, E r11) {
        validateEndpoints(r10);
        return addEdge(r10.nodeU(), r10.nodeV(), r11);
    }
}
