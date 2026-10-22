package net.sourceforge.jeval.operator;

/* loaded from: classes2.dex */
public class AdditionOperator extends AbstractOperator {
    public AdditionOperator() {
        super("+", 5, true);
    }

    @Override // net.sourceforge.jeval.operator.AbstractOperator, net.sourceforge.jeval.operator.Operator
    public double evaluate(double d4) {
        return d4;
    }

    @Override // net.sourceforge.jeval.operator.AbstractOperator, net.sourceforge.jeval.operator.Operator
    public double evaluate(double d4, double d5) {
        return new Double(d4 + d5).doubleValue();
    }

    @Override // net.sourceforge.jeval.operator.AbstractOperator, net.sourceforge.jeval.operator.Operator
    public String evaluate(String str, String str2) {
        return new String(str.substring(0, str.length() - 1) + str2.substring(1, str2.length()));
    }
}
