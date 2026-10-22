package com.google.common.graph;

/* JADX INFO: loaded from: classes3.dex */
final class ConfigurableMutableGraph<N> extends ForwardingGraph<N> implements MutableGraph<N> {
    private final MutableValueGraph<N, GraphConstants.Presence> backingValueGraph;

    public ConfigurableMutableGraph(AbstractGraphBuilder<? super N> r10) {
        this.backingValueGraph = new ConfigurableMutableValueGraph(r10);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean addNode(N r10) {
        return this.backingValueGraph.addNode(r10);
    }

    @Override // com.google.common.graph.ForwardingGraph
    public BaseGraph<N> delegate() {
        return this.backingValueGraph;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(N r10, N r11) {
        if (this.backingValueGraph.putEdgeValue(r10, r11, GraphConstants.Presence.EDGE_EXISTS) != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(N r10, N r11) {
        if (this.backingValueGraph.removeEdge(r10, r11) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeNode(N r10) {
        return this.backingValueGraph.removeNode(r10);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(EndpointPair<N> r10) {
        validateEndpoints(r10);
        return putEdge(r10.nodeU(), r10.nodeV());
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(EndpointPair<N> r10) {
        validateEndpoints(r10);
        return removeEdge(r10.nodeU(), r10.nodeV());
    }
}
