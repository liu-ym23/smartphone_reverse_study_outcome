package org.apache.commons.math.linear;

import org.apache.commons.math.FieldElement;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultFieldMatrixPreservingVisitor<T extends FieldElement<T>> implements FieldMatrixPreservingVisitor<T> {
    private final T zero;

    public DefaultFieldMatrixPreservingVisitor(T zero) {
        this.zero = zero;
    }

    @Override // org.apache.commons.math.linear.FieldMatrixPreservingVisitor
    public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {
    }

    @Override // org.apache.commons.math.linear.FieldMatrixPreservingVisitor
    public void visit(int row, int column, T value) throws MatrixVisitorException {
    }

    @Override // org.apache.commons.math.linear.FieldMatrixPreservingVisitor
    public T end() {
        return this.zero;
    }
}
