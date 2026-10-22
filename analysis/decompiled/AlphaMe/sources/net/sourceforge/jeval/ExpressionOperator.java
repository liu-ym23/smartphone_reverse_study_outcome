package net.sourceforge.jeval;

import net.sourceforge.jeval.operator.Operator;

/* loaded from: classes2.dex */
public class ExpressionOperator {
    private Operator operator;
    private Operator unaryOperator;

    public ExpressionOperator(Operator operator, Operator operator2) {
        this.operator = operator;
        this.unaryOperator = operator2;
    }

    public Operator getOperator() {
        return this.operator;
    }

    public Operator getUnaryOperator() {
        return this.unaryOperator;
    }
}
