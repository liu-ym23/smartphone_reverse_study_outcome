package net.sourceforge.jeval.operator;

import net.sourceforge.jeval.EvaluationException;

/* loaded from: classes2.dex */
public abstract class AbstractOperator implements Operator {
    private int precedence;
    private String symbol;
    private boolean unary;

    public AbstractOperator(String str, int i4) {
        this.unary = false;
        this.symbol = str;
        this.precedence = i4;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof AbstractOperator) {
            return this.symbol.equals(((AbstractOperator) obj).getSymbol());
        }
        throw new IllegalStateException("Invalid operator object.");
    }

    @Override // net.sourceforge.jeval.operator.Operator
    public double evaluate(double d4) {
        return 0.0d;
    }

    @Override // net.sourceforge.jeval.operator.Operator
    public int getLength() {
        return this.symbol.length();
    }

    @Override // net.sourceforge.jeval.operator.Operator
    public int getPrecedence() {
        return this.precedence;
    }

    @Override // net.sourceforge.jeval.operator.Operator
    public String getSymbol() {
        return this.symbol;
    }

    @Override // net.sourceforge.jeval.operator.Operator
    public boolean isUnary() {
        return this.unary;
    }

    public String toString() {
        return getSymbol();
    }

    @Override // net.sourceforge.jeval.operator.Operator
    public double evaluate(double d4, double d5) {
        return 0.0d;
    }

    @Override // net.sourceforge.jeval.operator.Operator
    public String evaluate(String str, String str2) throws EvaluationException {
        throw new EvaluationException("Invalid operation for a string.");
    }

    public AbstractOperator(String str, int i4, boolean z4) {
        this.symbol = str;
        this.precedence = i4;
        this.unary = z4;
    }
}
