package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Immutable(containerOf = {"N"})
@Beta
public abstract class EndpointPair<N> implements Iterable<N> {
    private final N nodeU;
    private final N nodeV;

    /* JADX INFO: renamed from: com.google.common.graph.EndpointPair$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Ordered<N> extends EndpointPair<N> {
        public /* synthetic */ Ordered(Object r10, Object r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@NullableDecl Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof EndpointPair) == true) goto L8;
            return false;
        L8:
            EndpointPair r11 = (EndpointPair) r10;
            if (isOrdered() == r11.isOrdered()) goto L12;
            return false;
        L12:
            if (source().equals(r11.source()) == false) goto L17;
            if (target().equals(r11.target()) == false) goto L17;
            return true;
        L17:
            return false;
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return Objects.hashCode(new Object[]{source(), target()});
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return true;
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            return nodeU();
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            return nodeV();
        }

        public String toString() {
            return "<" + source() + " -> " + target() + ">";
        }

        private Ordered(N r10, N r11) {
            super(r10, r11, null);
        }
    }

    public static final class Unordered<N> extends EndpointPair<N> {
        public /* synthetic */ Unordered(Object r10, Object r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@NullableDecl Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof EndpointPair) == true) goto L8;
            return false;
        L8:
            EndpointPair r11 = (EndpointPair) r10;
            if (isOrdered() == r11.isOrdered()) goto L12;
            return false;
        L12:
            if (nodeU().equals(r11.nodeU()) == false) goto L16;
            return nodeV().equals(r11.nodeV());
        L16:
            if (nodeU().equals(r11.nodeV()) == false) goto L21;
            if (nodeV().equals(r11.nodeU()) == false) goto L21;
            return true;
        L21:
            return false;
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return nodeU().hashCode() + nodeV().hashCode();
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return false;
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public String toString() {
            return "[" + nodeU() + ", " + nodeV() + "]";
        }

        private Unordered(N r10, N r11) {
            super(r10, r11, null);
        }
    }

    public /* synthetic */ EndpointPair(Object r10, Object r11, AnonymousClass1 r12) {
        this(r10, r11);
    }

    public static <N> EndpointPair<N> of(Graph<?> r10, N r11, N r12) {
        if (r10.isDirected() == false) goto L6;
        return ordered(r11, r12);
    L6:
        return unordered(r11, r12);
    }

    public static <N> EndpointPair<N> ordered(N r10, N r11) {
        return new Ordered(r10, r11, null);
    }

    public static <N> EndpointPair<N> unordered(N r10, N r11) {
        return new Unordered(r11, r10, null);
    }

    public final N adjacentNode(Object r10) {
        if (r10.equals(this.nodeU) == false) goto L7;
        return this.nodeV;
    L7:
        if (r10.equals(this.nodeV) == false) goto L11;
        return this.nodeU;
    L11:
        throw new IllegalArgumentException("EndpointPair " + this + " does not contain node " + r10);
    }

    public abstract boolean equals(@NullableDecl Object r10);

    public abstract int hashCode();

    public abstract boolean isOrdered();

    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final N nodeU() {
        return this.nodeU;
    }

    public final N nodeV() {
        return this.nodeV;
    }

    public abstract N source();

    public abstract N target();

    private EndpointPair(N r10, N r11) {
        this.nodeU = (N) Preconditions.checkNotNull(r10);
        this.nodeV = (N) Preconditions.checkNotNull(r11);
    }

    public static <N> EndpointPair<N> of(Network<?, ?> r10, N r11, N r12) {
        if (r10.isDirected() == false) goto L6;
        return ordered(r11, r12);
    L6:
        return unordered(r11, r12);
    }

    @Override // java.lang.Iterable
    public final UnmodifiableIterator<N> iterator() {
        return Iterators.forArray(new Object[]{this.nodeU, this.nodeV});
    }
}
