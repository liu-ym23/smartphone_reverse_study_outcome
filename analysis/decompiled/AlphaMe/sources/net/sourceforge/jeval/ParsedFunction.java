package net.sourceforge.jeval;

import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.operator.Operator;

/* loaded from: classes2.dex */
public class ParsedFunction {
    private final String arguments;
    private final Function function;
    private final Operator unaryOperator;

    public ParsedFunction(Function function, String str, Operator operator) {
        this.function = function;
        this.arguments = str;
        this.unaryOperator = operator;
    }

    public String getArguments() {
        return this.arguments;
    }

    public Function getFunction() {
        return this.function;
    }

    public Operator getUnaryOperator() {
        return this.unaryOperator;
    }
}
