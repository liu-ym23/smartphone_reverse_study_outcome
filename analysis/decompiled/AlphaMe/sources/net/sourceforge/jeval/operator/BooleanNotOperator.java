package net.sourceforge.jeval.operator;

/* loaded from: classes2.dex */
public class BooleanNotOperator extends AbstractOperator {
    public BooleanNotOperator() {
        super("!", 0, true);
    }

    @Override // net.sourceforge.jeval.operator.AbstractOperator, net.sourceforge.jeval.operator.Operator
    public double evaluate(double d4) {
        return d4 == 1.0d ? 0.0d : 1.0d;
    }
}
