package net.sourceforge.jeval;

import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionResult;
import net.sourceforge.jeval.operator.Operator;

/* loaded from: classes2.dex */
public class ExpressionTree {
    private Evaluator evaluator;
    private Object leftOperand;
    private Operator operator;
    private Object rightOperand;
    private Operator unaryOperator;

    public ExpressionTree(Evaluator evaluator, Object obj, Object obj2, Operator operator, Operator operator2) {
        this.evaluator = evaluator;
        this.leftOperand = obj;
        this.rightOperand = obj2;
        this.operator = operator;
        this.unaryOperator = operator2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String evaluate(boolean z4) throws EvaluationException {
        String strEvaluate;
        Double d4;
        String strEvaluate2;
        String string;
        Double d5;
        Double d6;
        Object obj = this.leftOperand;
        Double d7 = null;
        if (obj instanceof ExpressionTree) {
            strEvaluate = ((ExpressionTree) obj).evaluate(z4);
            try {
                d4 = new Double(strEvaluate);
                strEvaluate = null;
            } catch (NumberFormatException unused) {
            }
        } else if (obj instanceof ExpressionOperand) {
            ExpressionOperand expressionOperand = (ExpressionOperand) obj;
            String strReplaceVariables = this.evaluator.replaceVariables(expressionOperand.getValue());
            if (!this.evaluator.isExpressionString(strReplaceVariables)) {
                try {
                    Double d8 = new Double(strReplaceVariables);
                    if (expressionOperand.getUnaryOperator() != null) {
                        d4 = new Double(expressionOperand.getUnaryOperator().evaluate(d8.doubleValue()));
                        strEvaluate = null;
                    } else {
                        strEvaluate = null;
                        d4 = d8;
                    }
                } catch (NumberFormatException e4) {
                    throw new EvaluationException("Expression is invalid.", e4);
                }
            } else {
                if (expressionOperand.getUnaryOperator() != null) {
                    throw new EvaluationException("Invalid operand for unary operator.");
                }
                strEvaluate = strReplaceVariables;
                d4 = null;
            }
        } else if (obj instanceof ParsedFunction) {
            ParsedFunction parsedFunction = (ParsedFunction) obj;
            Function function = parsedFunction.getFunction();
            String strReplaceVariables2 = this.evaluator.replaceVariables(parsedFunction.getArguments());
            if (this.evaluator.getProcessNestedFunctions()) {
                strReplaceVariables2 = this.evaluator.processNestedFunctions(strReplaceVariables2);
            }
            try {
                FunctionResult functionResultExecute = function.execute(this.evaluator, strReplaceVariables2);
                String result = functionResultExecute.getResult();
                if (functionResultExecute.getType() == 0) {
                    Double d9 = new Double(result);
                    if (parsedFunction.getUnaryOperator() != null) {
                        d9 = new Double(parsedFunction.getUnaryOperator().evaluate(d9.doubleValue()));
                    }
                    result = d9.toString();
                } else if (functionResultExecute.getType() == 1) {
                    if (z4) {
                        result = this.evaluator.getQuoteCharacter() + result + this.evaluator.getQuoteCharacter();
                    }
                    if (parsedFunction.getUnaryOperator() != null) {
                        throw new EvaluationException("Invalid operand for unary operator.");
                    }
                }
                if (this.evaluator.isExpressionString(result)) {
                    d4 = null;
                    strEvaluate = result;
                } else {
                    try {
                        d4 = new Double(result);
                        strEvaluate = null;
                    } catch (NumberFormatException e5) {
                        throw new EvaluationException("Expression is invalid.", e5);
                    }
                }
            } catch (FunctionException e6) {
                throw new EvaluationException(e6.getMessage(), e6);
            }
        } else {
            if (obj != null) {
                throw new EvaluationException("Expression is invalid.");
            }
            strEvaluate = null;
            d4 = null;
        }
        Object obj2 = this.rightOperand;
        if (obj2 instanceof ExpressionTree) {
            strEvaluate2 = ((ExpressionTree) obj2).evaluate(z4);
            try {
                d6 = new Double(strEvaluate2);
                strEvaluate2 = d7;
                d7 = d6;
            } catch (NumberFormatException unused2) {
            }
        } else if (obj2 instanceof ExpressionOperand) {
            ExpressionOperand expressionOperand2 = (ExpressionOperand) obj2;
            String strReplaceVariables3 = this.evaluator.replaceVariables(((ExpressionOperand) obj2).getValue());
            if (!this.evaluator.isExpressionString(strReplaceVariables3)) {
                try {
                    Double d10 = new Double(strReplaceVariables3);
                    d6 = expressionOperand2.getUnaryOperator() != null ? new Double(expressionOperand2.getUnaryOperator().evaluate(d10.doubleValue())) : d10;
                } catch (NumberFormatException e7) {
                    throw new EvaluationException("Expression is invalid.", e7);
                }
            } else {
                if (expressionOperand2.getUnaryOperator() != null) {
                    throw new EvaluationException("Invalid operand for unary operator.");
                }
                d7 = strReplaceVariables3;
                d6 = null;
            }
            strEvaluate2 = d7;
            d7 = d6;
        } else if (obj2 instanceof ParsedFunction) {
            ParsedFunction parsedFunction2 = (ParsedFunction) obj2;
            Function function2 = parsedFunction2.getFunction();
            String strReplaceVariables4 = this.evaluator.replaceVariables(parsedFunction2.getArguments());
            if (this.evaluator.getProcessNestedFunctions()) {
                strReplaceVariables4 = this.evaluator.processNestedFunctions(strReplaceVariables4);
            }
            try {
                FunctionResult functionResultExecute2 = function2.execute(this.evaluator, strReplaceVariables4);
                String result2 = functionResultExecute2.getResult();
                if (functionResultExecute2.getType() == 0) {
                    Double d11 = new Double(result2);
                    if (parsedFunction2.getUnaryOperator() != null) {
                        d11 = new Double(parsedFunction2.getUnaryOperator().evaluate(d11.doubleValue()));
                    }
                    string = d11.toString();
                } else {
                    string = result2;
                    String str = result2;
                    if (functionResultExecute2.getType() == 1) {
                        if (z4) {
                            str = this.evaluator.getQuoteCharacter() + result2 + this.evaluator.getQuoteCharacter();
                        }
                        if (parsedFunction2.getUnaryOperator() != null) {
                            throw new EvaluationException("Invalid operand for unary operator.");
                        }
                        string = str;
                    }
                }
                if (this.evaluator.isExpressionString(string)) {
                    d5 = null;
                    d7 = string;
                } else {
                    try {
                        d5 = new Double(string);
                    } catch (NumberFormatException e8) {
                        throw new EvaluationException("Expression is invalid.", e8);
                    }
                }
                Double d12 = d7;
                d7 = d5;
                strEvaluate2 = d12;
            } catch (FunctionException e9) {
                throw new EvaluationException(e9.getMessage(), e9);
            }
        } else {
            if (obj2 != null) {
                throw new EvaluationException("Expression is invalid.");
            }
            strEvaluate2 = 0;
        }
        if (d4 != null && d7 != null) {
            double dEvaluate = this.operator.evaluate(d4.doubleValue(), d7.doubleValue());
            if (getUnaryOperator() != null) {
                dEvaluate = getUnaryOperator().evaluate(dEvaluate);
            }
            return new Double(dEvaluate).toString();
        }
        if (strEvaluate != null && strEvaluate2 != 0) {
            return this.operator.evaluate(strEvaluate, strEvaluate2);
        }
        if (d4 == null || d7 != null) {
            throw new EvaluationException("Expression is invalid.");
        }
        Operator operator = this.unaryOperator;
        if (operator != null) {
            return new Double(operator.evaluate(d4.doubleValue())).toString();
        }
        throw new EvaluationException("Expression is invalid.");
    }

    public Object getLeftOperand() {
        return this.leftOperand;
    }

    public Operator getOperator() {
        return this.operator;
    }

    public Object getRightOperand() {
        return this.rightOperand;
    }

    public Operator getUnaryOperator() {
        return this.unaryOperator;
    }
}
