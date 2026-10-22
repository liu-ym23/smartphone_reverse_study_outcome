package net.sourceforge.jeval;

import net.sourceforge.jeval.operator.Operator;

/* loaded from: classes2.dex */
public class ExpressionOperand {
    private Operator unaryOperator;
    private String value;

    public ExpressionOperand(String str, Operator operator) {
        this.value = str;
        this.unaryOperator = operator;
    }

    public Operator getUnaryOperator() {
        return this.unaryOperator;
    }

    public String getValue() {
        return this.value;
    }
}
