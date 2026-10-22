package net.sourceforge.jeval.operator;

/* loaded from: classes2.dex */
public class MultiplicationOperator extends AbstractOperator {
    public MultiplicationOperator() {
        super("*", 6);
    }

    @Override // net.sourceforge.jeval.operator.AbstractOperator, net.sourceforge.jeval.operator.Operator
    public double evaluate(double d4, double d5) {
        return new Double(d4 * d5).doubleValue();
    }
}
