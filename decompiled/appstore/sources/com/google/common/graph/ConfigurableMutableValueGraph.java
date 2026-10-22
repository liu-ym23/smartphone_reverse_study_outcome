package com.google.common.graph;

import com.bytedance.apm.constant.CommonKey;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class ConfigurableMutableValueGraph<N, V> extends ConfigurableValueGraph<N, V> implements MutableValueGraph<N, V> {
    public ConfigurableMutableValueGraph(AbstractGraphBuilder<? super N> r10) {
        super(r10);
    }

    @CanIgnoreReturnValue
    private GraphConnections<N, V> addNodeInternal(N r10) {
        GraphConnections<N, V> r11 = newConnections();
        if (this.nodeConnections.put(r10, r11) != null) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkState(r12);
        return r11;
    L5:
        r12 = false;
        goto L6
    }

    private GraphConnections<N, V> newConnections() {
        if (isDirected() == false) goto L6;
        return DirectedGraphConnections.of();
    L6:
        return UndirectedGraphConnections.of();
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public boolean addNode(N r10) {
        Preconditions.checkNotNull(r10, "node");
        if (containsNode(r10) == false) goto L6;
        return false;
    L6:
        addNodeInternal(r10);
        return true;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public V putEdgeValue(N r10, N r11, V r12) {
        Preconditions.checkNotNull(r10, "nodeU");
        Preconditions.checkNotNull(r11, "nodeV");
        Preconditions.checkNotNull(r12, CommonKey.KEY_VALUE);
        if (allowsSelfLoops() == true) goto L5;
        Preconditions.checkArgument(!r10.equals(r11), "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", r10);
    L5:
        GraphConnections<N, V> r13 = this.nodeConnections.get(r10);
        if (r13 != null) goto L8;
        r13 = addNodeInternal(r10);
    L8:
        V r14 = r13.addSuccessor(r11, r12);
        GraphConnections<N, V> r15 = this.nodeConnections.get(r11);
        if (r15 != null) goto L11;
        r15 = addNodeInternal(r11);
    L11:
        r15.addPredecessor(r10, r12);
        if (r14 != null) goto L14;
        long r16 = this.edgeCount + 1;
        this.edgeCount = r16;
        Graphs.checkPositive(r16);
    L14:
        return r14;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public V removeEdge(N r10, N r11) {
        Preconditions.checkNotNull(r10, "nodeU");
        Preconditions.checkNotNull(r11, "nodeV");
        GraphConnections<N, V> r12 = this.nodeConnections.get(r10);
        GraphConnections<N, V> r13 = this.nodeConnections.get(r11);
        if (r12 == null) goto L10;
        if (r13 == null) goto L12;
        V r14 = r12.removeSuccessor(r11);
        if (r14 == null) goto L9;
        r13.removePredecessor(r10);
        long r15 = this.edgeCount - 1;
        this.edgeCount = r15;
        Graphs.checkNonNegative(r15);
    L9:
        return r14;
    L12:
        return null;
    L10:
        return null;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public boolean removeNode(N r10) {
        Preconditions.checkNotNull(r10, "node");
        GraphConnections<N, V> r11 = this.nodeConnections.get(r10);
        if (r11 != null) goto L6;
        return false;
    L6:
        if (allowsSelfLoops() == true) goto L8;
    L10:
        Iterator<N> r12 = r11.successors().iterator();
    L12:
        if (r12.hasNext() == false) goto L15;
        this.nodeConnections.getWithoutCaching(r12.next()).removePredecessor(r10);
        this.edgeCount--;
        goto L12
    L15:
        if (isDirected() == false) goto L24;
        Iterator<N> r13 = r11.predecessors().iterator();
    L18:
        if (r13.hasNext() == false) goto L24;
        if (this.nodeConnections.getWithoutCaching(r13.next()).removeSuccessor(r10) == null) goto L22;
        boolean r14 = true;
    L23:
        Preconditions.checkState(r14);
        this.edgeCount--;
        goto L18
    L22:
        r14 = false;
    L24:
        this.nodeConnections.remove(r10);
        Graphs.checkNonNegative(this.edgeCount);
        return true;
    L8:
        if (r11.removeSuccessor(r10) == null) goto L10;
        r11.removePredecessor(r10);
        this.edgeCount--;
        goto L10
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public V removeEdge(EndpointPair<N> r10) {
        validateEndpoints(r10);
        return removeEdge(r10.nodeU(), r10.nodeV());
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public V putEdgeValue(EndpointPair<N> r10, V r11) {
        validateEndpoints(r10);
        return putEdgeValue(r10.nodeU(), r10.nodeV(), r11);
    }
}
