package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class GraphBuilder<N> extends AbstractGraphBuilder<N> {
    private GraphBuilder(boolean r10) {
        super(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N1 extends N> GraphBuilder<N1> cast() {
        return this;
    }

    public static GraphBuilder<Object> directed() {
        return new GraphBuilder(true);
    }

    public static <N> GraphBuilder<N> from(Graph<N> r10) {
        return (GraphBuilder<N>) new GraphBuilder(r10.isDirected()).allowsSelfLoops(r10.allowsSelfLoops()).nodeOrder(r10.nodeOrder());
    }

    public static GraphBuilder<Object> undirected() {
        return new GraphBuilder(false);
    }

    public GraphBuilder<N> allowsSelfLoops(boolean r10) {
        this.allowsSelfLoops = r10;
        return this;
    }

    public <N1 extends N> MutableGraph<N1> build() {
        return new ConfigurableMutableGraph(this);
    }

    public GraphBuilder<N> expectedNodeCount(int r10) {
        this.expectedNodeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(r10)));
        return this;
    }

    public <N1 extends N> ImmutableGraph.Builder<N1> immutable() {
        return new ImmutableGraph.Builder(cast());
    }

    public <N1 extends N> GraphBuilder<N1> nodeOrder(ElementOrder<N1> r10) {
        GraphBuilder<N1> r11 = cast();
        r11.nodeOrder = (ElementOrder) Preconditions.checkNotNull(r10);
        return r11;
    }
}
