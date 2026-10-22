package net.sourceforge.jeval.operator;

import net.sourceforge.jeval.EvaluationException;

/* loaded from: classes2.dex */
public interface Operator {
    double evaluate(double d4);

    double evaluate(double d4, double d5);

    String evaluate(String str, String str2) throws EvaluationException;

    int getLength();

    int getPrecedence();

    String getSymbol();

    boolean isUnary();
}
