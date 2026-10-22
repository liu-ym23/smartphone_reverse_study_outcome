package net.sourceforge.jeval.operator;

/* loaded from: classes2.dex */
public class BooleanOrOperator extends AbstractOperator {
    public BooleanOrOperator() {
        super("||", 1);
    }

    @Override // net.sourceforge.jeval.operator.AbstractOperator, net.sourceforge.jeval.operator.Operator
    public double evaluate(double d4, double d5) {
        return (d4 == 1.0d || d5 == 1.0d) ? 1.0d : 0.0d;
    }
}
