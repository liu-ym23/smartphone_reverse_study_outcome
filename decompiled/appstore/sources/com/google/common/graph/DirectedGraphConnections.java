package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
final class DirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    private static final Object PRED = null;
    private final Map<N, Object> adjacentNodeValues;
    private int predecessorCount;
    private int successorCount;

    public static final class PredAndSucc {
        private final Object successorValue;

        public PredAndSucc(Object r10) {
            this.successorValue = r10;
        }

        public static /* synthetic */ Object access$500(PredAndSucc r10) {
            return r10.successorValue;
        }
    }

    static {
        PRED = new Object();
    }

    private DirectedGraphConnections(Map<N, Object> r10, int r11, int r12) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(r10);
        this.predecessorCount = Graphs.checkNonNegative(r11);
        this.successorCount = Graphs.checkNonNegative(r12);
        if (r11 <= r10.size()) goto L5;
    L7:
        boolean r13 = false;
    L8:
        Preconditions.checkState(r13);
        return;
    L5:
        if (r12 > r10.size()) goto L7;
        r13 = true;
        goto L8
    }

    public static /* synthetic */ Map access$000(DirectedGraphConnections r10) {
        return r10.adjacentNodeValues;
    }

    public static /* synthetic */ boolean access$100(Object r10) {
        return isPredecessor(r10);
    }

    public static /* synthetic */ int access$200(DirectedGraphConnections r10) {
        return r10.predecessorCount;
    }

    public static /* synthetic */ boolean access$300(Object r10) {
        return isSuccessor(r10);
    }

    public static /* synthetic */ int access$400(DirectedGraphConnections r10) {
        return r10.successorCount;
    }

    private static boolean isPredecessor(@NullableDecl Object r10) {
        if (r10 != PRED) goto L5;
    L8:
        return true;
    L5:
        if ((r10 instanceof PredAndSucc) == true) goto L8;
        return false;
    }

    private static boolean isSuccessor(@NullableDecl Object r10) {
        if (r10 == PRED) goto L6;
        if (r10 == null) goto L6;
        return true;
    L6:
        return false;
    }

    public static <N, V> DirectedGraphConnections<N, V> of() {
        return new DirectedGraphConnections(new HashMap(4, 1.0f), 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N, V> DirectedGraphConnections<N, V> ofImmutable(Set<N> r10, Map<N, V> r11) {
        HashMap r12 = new HashMap();
        r12.putAll(r11);
        Iterator<N> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        N r14 = r13.next();
        Object r15 = r12.put(r14, PRED);
        if (r15 == null) goto L4;
        r12.put(r14, new PredAndSucc(r15));
        goto L4
    L9:
        return new DirectedGraphConnections(ImmutableMap.copyOf(r12), r10.size(), r11.size());
    }

    @Override // com.google.common.graph.GraphConnections
    public void addPredecessor(N r10, V r11) {
        Map<N, Object> r12 = this.adjacentNodeValues;
        Object r13 = PRED;
        Object r14 = r12.put(r10, r13);
        if (r14 != null) goto L6;
        int r15 = this.predecessorCount + 1;
        this.predecessorCount = r15;
        Graphs.checkPositive(r15);
        return;
    L6:
        if ((r14 instanceof PredAndSucc) == false) goto L8;
        this.adjacentNodeValues.put(r10, r14);
        return;
    L8:
        if (r14 == r13) goto L13;
        this.adjacentNodeValues.put(r10, new PredAndSucc(r14));
        int r16 = this.predecessorCount + 1;
        this.predecessorCount = r16;
        Graphs.checkPositive(r16);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.GraphConnections
    public V addSuccessor(N r10, V r11) {
        V r12 = (V) this.adjacentNodeValues.put(r10, r11);
        if (r12 != 0) goto L7;
        int r13 = this.successorCount + 1;
        this.successorCount = r13;
        Graphs.checkPositive(r13);
        return null;
    L7:
        if ((r12 instanceof PredAndSucc) == false) goto L11;
        this.adjacentNodeValues.put(r10, new PredAndSucc(r11));
        return (V) PredAndSucc.access$500((PredAndSucc) r12);
    L11:
        if (r12 != PRED) goto L14;
        this.adjacentNodeValues.put(r10, new PredAndSucc(r11));
        int r14 = this.successorCount + 1;
        this.successorCount = r14;
        Graphs.checkPositive(r14);
        return null;
    L14:
        return r12;
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> predecessors() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.graph.GraphConnections
    public void removePredecessor(N r10) {
        Object r11 = this.adjacentNodeValues.get(r10);
        if (r11 != PRED) goto L6;
        this.adjacentNodeValues.remove(r10);
        int r12 = this.predecessorCount - 1;
        this.predecessorCount = r12;
        Graphs.checkNonNegative(r12);
        return;
    L6:
        if ((r11 instanceof PredAndSucc) == false) goto L10;
        this.adjacentNodeValues.put(r10, PredAndSucc.access$500((PredAndSucc) r11));
        int r13 = this.predecessorCount - 1;
        this.predecessorCount = r13;
        Graphs.checkNonNegative(r13);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.GraphConnections
    public V removeSuccessor(Object r10) {
        V r11 = (V) this.adjacentNodeValues.get(r10);
        if (r11 == 0) goto L13;
        Object r12 = PRED;
        if (r11 != r12) goto L8;
        return null;
    L8:
        if ((r11 instanceof PredAndSucc) == false) goto L11;
        this.adjacentNodeValues.put(r10, r12);
        int r13 = this.successorCount - 1;
        this.successorCount = r13;
        Graphs.checkNonNegative(r13);
        return (V) PredAndSucc.access$500((PredAndSucc) r11);
    L11:
        this.adjacentNodeValues.remove(r10);
        int r14 = this.successorCount - 1;
        this.successorCount = r14;
        Graphs.checkNonNegative(r14);
        return r11;
    L13:
        return null;
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> successors() {
        return new AnonymousClass2(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.GraphConnections
    public V value(N r10) {
        V r11 = (V) this.adjacentNodeValues.get(r10);
        if (r11 != PRED) goto L7;
        return null;
    L7:
        if ((r11 instanceof PredAndSucc) == true) goto L9;
        return r11;
    L9:
        return (V) PredAndSucc.access$500((PredAndSucc) r11);
    }
}
