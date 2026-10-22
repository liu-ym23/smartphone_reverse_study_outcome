package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class ValueGraphBuilder<N, V> extends AbstractGraphBuilder<N> {
    private ValueGraphBuilder(boolean r10) {
        super(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N1 extends N, V1 extends V> ValueGraphBuilder<N1, V1> cast() {
        return this;
    }

    public static ValueGraphBuilder<Object, Object> directed() {
        return new ValueGraphBuilder(true);
    }

    public static <N, V> ValueGraphBuilder<N, V> from(ValueGraph<N, V> r10) {
        return (ValueGraphBuilder<N, V>) new ValueGraphBuilder(r10.isDirected()).allowsSelfLoops(r10.allowsSelfLoops()).nodeOrder(r10.nodeOrder());
    }

    public static ValueGraphBuilder<Object, Object> undirected() {
        return new ValueGraphBuilder(false);
    }

    public ValueGraphBuilder<N, V> allowsSelfLoops(boolean r10) {
        this.allowsSelfLoops = r10;
        return this;
    }

    public <N1 extends N, V1 extends V> MutableValueGraph<N1, V1> build() {
        return new ConfigurableMutableValueGraph(this);
    }

    public ValueGraphBuilder<N, V> expectedNodeCount(int r10) {
        this.expectedNodeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(r10)));
        return this;
    }

    public <N1 extends N, V1 extends V> ImmutableValueGraph.Builder<N1, V1> immutable() {
        return new ImmutableValueGraph.Builder(cast());
    }

    public <N1 extends N> ValueGraphBuilder<N1, V> nodeOrder(ElementOrder<N1> r10) {
        ValueGraphBuilder<N1, V> r11 = (ValueGraphBuilder<N1, V>) cast();
        r11.nodeOrder = (ElementOrder) Preconditions.checkNotNull(r10);
        return r11;
    }
}
