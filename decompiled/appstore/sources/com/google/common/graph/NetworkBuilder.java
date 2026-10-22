package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class NetworkBuilder<N, E> extends AbstractGraphBuilder<N> {
    boolean allowsParallelEdges;
    ElementOrder<? super E> edgeOrder;
    Optional<Integer> expectedEdgeCount;

    private NetworkBuilder(boolean r10) {
        super(r10);
        this.allowsParallelEdges = false;
        this.edgeOrder = ElementOrder.insertion();
        this.expectedEdgeCount = Optional.absent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N1 extends N, E1 extends E> NetworkBuilder<N1, E1> cast() {
        return this;
    }

    public static NetworkBuilder<Object, Object> directed() {
        return new NetworkBuilder(true);
    }

    public static <N, E> NetworkBuilder<N, E> from(Network<N, E> r10) {
        return new NetworkBuilder(r10.isDirected()).allowsParallelEdges(r10.allowsParallelEdges()).allowsSelfLoops(r10.allowsSelfLoops()).nodeOrder(r10.nodeOrder()).edgeOrder(r10.edgeOrder());
    }

    public static NetworkBuilder<Object, Object> undirected() {
        return new NetworkBuilder(false);
    }

    public NetworkBuilder<N, E> allowsParallelEdges(boolean r10) {
        this.allowsParallelEdges = r10;
        return this;
    }

    public NetworkBuilder<N, E> allowsSelfLoops(boolean r10) {
        this.allowsSelfLoops = r10;
        return this;
    }

    public <N1 extends N, E1 extends E> MutableNetwork<N1, E1> build() {
        return new ConfigurableMutableNetwork(this);
    }

    public <E1 extends E> NetworkBuilder<N, E1> edgeOrder(ElementOrder<E1> r10) {
        NetworkBuilder<N, E1> r11 = (NetworkBuilder<N, E1>) cast();
        r11.edgeOrder = (ElementOrder) Preconditions.checkNotNull(r10);
        return r11;
    }

    public NetworkBuilder<N, E> expectedEdgeCount(int r10) {
        this.expectedEdgeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(r10)));
        return this;
    }

    public NetworkBuilder<N, E> expectedNodeCount(int r10) {
        this.expectedNodeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(r10)));
        return this;
    }

    public <N1 extends N, E1 extends E> ImmutableNetwork.Builder<N1, E1> immutable() {
        return new ImmutableNetwork.Builder(cast());
    }

    public <N1 extends N> NetworkBuilder<N1, E> nodeOrder(ElementOrder<N1> r10) {
        NetworkBuilder<N1, E> r11 = (NetworkBuilder<N1, E>) cast();
        r11.nodeOrder = (ElementOrder) Preconditions.checkNotNull(r10);
        return r11;
    }
}
