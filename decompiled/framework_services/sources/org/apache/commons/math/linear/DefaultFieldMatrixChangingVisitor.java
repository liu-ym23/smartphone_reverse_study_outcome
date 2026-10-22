package org.apache.commons.math.linear;

import org.apache.commons.math.FieldElement;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultFieldMatrixChangingVisitor<T extends FieldElement<T>> implements FieldMatrixChangingVisitor<T> {
    private final T zero;

    public DefaultFieldMatrixChangingVisitor(T zero) {
        this.zero = zero;
    }

    @Override // org.apache.commons.math.linear.FieldMatrixChangingVisitor
    public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {
    }

    @Override // org.apache.commons.math.linear.FieldMatrixChangingVisitor
    public T visit(int row, int column, T value) throws MatrixVisitorException {
        return value;
    }

    @Override // org.apache.commons.math.linear.FieldMatrixChangingVisitor
    public T end() {
        return this.zero;
    }
}
