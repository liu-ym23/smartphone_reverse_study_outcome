package net.sourceforge.jeval.operator;

/* loaded from: classes2.dex */
public class SubtractionOperator extends AbstractOperator {
    public SubtractionOperator() {
        super("-", 5, true);
    }

    @Override // net.sourceforge.jeval.operator.AbstractOperator, net.sourceforge.jeval.operator.Operator
    public double evaluate(double d4) {
        return -d4;
    }

    @Override // net.sourceforge.jeval.operator.AbstractOperator, net.sourceforge.jeval.operator.Operator
    public double evaluate(double d4, double d5) {
        return new Double(d4 - d5).doubleValue();
    }
}
