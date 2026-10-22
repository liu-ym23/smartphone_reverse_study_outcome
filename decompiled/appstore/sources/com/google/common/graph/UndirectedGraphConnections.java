package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class UndirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    private final Map<N, V> adjacentNodeValues;

    private UndirectedGraphConnections(Map<N, V> r10) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(r10);
    }

    public static <N, V> UndirectedGraphConnections<N, V> of() {
        return new UndirectedGraphConnections(new HashMap(2, 1.0f));
    }

    public static <N, V> UndirectedGraphConnections<N, V> ofImmutable(Map<N, V> r10) {
        return new UndirectedGraphConnections(ImmutableMap.copyOf(r10));
    }

    @Override // com.google.common.graph.GraphConnections
    public void addPredecessor(N r10, V r11) {
        addSuccessor(r10, r11);
    }

    @Override // com.google.common.graph.GraphConnections
    public V addSuccessor(N r10, V r11) {
        return this.adjacentNodeValues.put(r10, r11);
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> predecessors() {
        return adjacentNodes();
    }

    @Override // com.google.common.graph.GraphConnections
    public void removePredecessor(N r10) {
        removeSuccessor(r10);
    }

    @Override // com.google.common.graph.GraphConnections
    public V removeSuccessor(N r10) {
        return this.adjacentNodeValues.remove(r10);
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> successors() {
        return adjacentNodes();
    }

    @Override // com.google.common.graph.GraphConnections
    public V value(N r10) {
        return this.adjacentNodeValues.get(r10);
    }
}
