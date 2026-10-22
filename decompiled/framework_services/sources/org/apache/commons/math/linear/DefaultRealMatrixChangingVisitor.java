package org.apache.commons.math.linear;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultRealMatrixChangingVisitor implements RealMatrixChangingVisitor {
    public DefaultRealMatrixChangingVisitor() {
    }

    @Override // org.apache.commons.math.linear.RealMatrixChangingVisitor
    public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {
    }

    @Override // org.apache.commons.math.linear.RealMatrixChangingVisitor
    public double visit(int row, int column, double value) throws MatrixVisitorException {
        return value;
    }

    @Override // org.apache.commons.math.linear.RealMatrixChangingVisitor
    public double end() {
        return 0.0d;
    }
}
