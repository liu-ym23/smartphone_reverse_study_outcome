package org.apache.commons.math.linear;

/* JADX INFO: loaded from: classes3.dex */
public interface RealMatrixPreservingVisitor {
    double end();

    void start(int r1, int r2, int r3, int r4, int r5, int r6);

    void visit(int r1, int r2, double r3) throws MatrixVisitorException;
}
