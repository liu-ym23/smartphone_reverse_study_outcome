package net.sourceforge.jeval.operator;

import net.sourceforge.jeval.EvaluationConstants;

/* loaded from: classes2.dex */
public class GreaterThanOperator extends AbstractOperator {
    public GreaterThanOperator() {
        super(">", 4);
    }

    @Override // net.sourceforge.jeval.operator.AbstractOperator, net.sourceforge.jeval.operator.Operator
    public double evaluate(double d4, double d5) {
        return d4 > d5 ? 1.0d : 0.0d;
    }

    @Override // net.sourceforge.jeval.operator.AbstractOperator, net.sourceforge.jeval.operator.Operator
    public String evaluate(String str, String str2) {
        return str.compareTo(str2) > 0 ? EvaluationConstants.BOOLEAN_STRING_TRUE : EvaluationConstants.BOOLEAN_STRING_FALSE;
    }
}
