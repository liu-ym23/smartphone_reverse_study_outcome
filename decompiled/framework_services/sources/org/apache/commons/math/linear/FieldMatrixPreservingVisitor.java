package org.apache.commons.math.linear;

import org.apache.commons.math.FieldElement;

/* JADX INFO: loaded from: classes3.dex */
public interface FieldMatrixPreservingVisitor<T extends FieldElement<?>> {
    T end();

    void start(int r1, int r2, int r3, int r4, int r5, int r6);

    void visit(int r1, int r2, T r3) throws MatrixVisitorException;
}
