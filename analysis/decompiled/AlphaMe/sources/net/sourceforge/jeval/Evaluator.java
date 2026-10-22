package net.sourceforge.jeval;

import B0.g;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionResult;
import net.sourceforge.jeval.function.judge.JudgeFunctions;
import net.sourceforge.jeval.function.math.MathFunctions;
import net.sourceforge.jeval.function.string.StringFunctions;
import net.sourceforge.jeval.operator.AdditionOperator;
import net.sourceforge.jeval.operator.BooleanAndOperator;
import net.sourceforge.jeval.operator.BooleanNotOperator;
import net.sourceforge.jeval.operator.BooleanOrOperator;
import net.sourceforge.jeval.operator.ClosedParenthesesOperator;
import net.sourceforge.jeval.operator.DivisionOperator;
import net.sourceforge.jeval.operator.EqualOperator;
import net.sourceforge.jeval.operator.GreaterThanOperator;
import net.sourceforge.jeval.operator.GreaterThanOrEqualOperator;
import net.sourceforge.jeval.operator.LessThanOperator;
import net.sourceforge.jeval.operator.LessThanOrEqualOperator;
import net.sourceforge.jeval.operator.ModulusOperator;
import net.sourceforge.jeval.operator.MultiplicationOperator;
import net.sourceforge.jeval.operator.NotEqualOperator;
import net.sourceforge.jeval.operator.OpenParenthesesOperator;
import net.sourceforge.jeval.operator.Operator;
import net.sourceforge.jeval.operator.SubtractionOperator;

/* loaded from: classes2.dex */
public class Evaluator {
    private Operator closedParenthesesOperator;
    private Map functions;
    private boolean loadJudgeFunctions;
    private boolean loadMathFunctions;
    private boolean loadMathVariables;
    private boolean loadStringFunctions;
    private Operator openParenthesesOperator;
    private Stack operandStack;
    private Stack operatorStack;
    private List operators;
    private String previousExpression;
    private Stack previousOperandStack;
    private Stack previousOperatorStack;
    private boolean processNestedFunctions;
    private char quoteCharacter;
    private VariableResolver variableResolver;
    private Map variables;

    public Evaluator() {
        this('\'', true, true, true, true, true);
    }

    private NextOperator getNextOperator(String str, int i4, Operator operator) {
        int length = str.length();
        int i5 = 0;
        while (i4 < length) {
            if (str.charAt(i4) == this.quoteCharacter) {
                i5++;
            }
            if (i5 % 2 != 1) {
                int size = this.operators.size();
                for (int i6 = 0; i6 < size; i6++) {
                    Operator operator2 = (Operator) this.operators.get(i6);
                    if (operator == null || operator.equals(operator2)) {
                        if (operator2.getLength() == 2) {
                            int length2 = i4 + 2;
                            if (length2 > str.length()) {
                                length2 = str.length();
                            }
                            if (str.substring(i4, length2).equals(operator2.getSymbol())) {
                                return new NextOperator(operator2, i4);
                            }
                        } else if (str.charAt(i4) == operator2.getSymbol().charAt(0)) {
                            return new NextOperator(operator2, i4);
                        }
                    }
                }
            }
            i4++;
        }
        return null;
    }

    private String getResult(Stack stack, Stack stack2, boolean z4) throws EvaluationException {
        while (stack.size() > 0) {
            processTree(stack2, stack);
        }
        if (stack2.size() != 1) {
            throw new EvaluationException("Expression is invalid.");
        }
        Object objPop = stack2.pop();
        if (objPop instanceof ExpressionTree) {
            return ((ExpressionTree) objPop).evaluate(z4);
        }
        if (objPop instanceof ExpressionOperand) {
            ExpressionOperand expressionOperand = (ExpressionOperand) objPop;
            String strReplaceVariables = replaceVariables(expressionOperand.getValue());
            if (isExpressionString(strReplaceVariables)) {
                if (expressionOperand.getUnaryOperator() == null) {
                    return strReplaceVariables;
                }
                throw new EvaluationException("Invalid operand for unary operator.");
            }
            try {
                Double d4 = new Double(strReplaceVariables);
                if (expressionOperand.getUnaryOperator() != null) {
                    d4 = new Double(expressionOperand.getUnaryOperator().evaluate(d4.doubleValue()));
                }
                return d4.toString();
            } catch (Exception e4) {
                throw new EvaluationException("Expression is invalid.", e4);
            }
        }
        if (!(objPop instanceof ParsedFunction)) {
            throw new EvaluationException("Expression is invalid.");
        }
        ParsedFunction parsedFunction = (ParsedFunction) objPop;
        Function function = parsedFunction.getFunction();
        String arguments = parsedFunction.getArguments();
        if (this.processNestedFunctions) {
            arguments = processNestedFunctions(arguments);
        }
        try {
            FunctionResult functionResultExecute = function.execute(this, replaceVariables(arguments));
            String result = functionResultExecute.getResult();
            if (functionResultExecute.getType() == 0) {
                Double d5 = new Double(result);
                if (parsedFunction.getUnaryOperator() != null) {
                    d5 = new Double(parsedFunction.getUnaryOperator().evaluate(d5.doubleValue()));
                }
                return d5.toString();
            }
            if (functionResultExecute.getType() == 1) {
                if (z4) {
                    result = this.quoteCharacter + result + this.quoteCharacter;
                }
                if (parsedFunction.getUnaryOperator() != null) {
                    throw new EvaluationException("Invalid operand for unary operator.");
                }
            }
            return result;
        } catch (FunctionException e5) {
            throw new EvaluationException(e5.getMessage(), e5);
        }
    }

    private void installOperators() {
        this.operators.add(this.openParenthesesOperator);
        this.operators.add(this.closedParenthesesOperator);
        this.operators.add(new AdditionOperator());
        this.operators.add(new SubtractionOperator());
        this.operators.add(new MultiplicationOperator());
        this.operators.add(new DivisionOperator());
        this.operators.add(new EqualOperator());
        this.operators.add(new NotEqualOperator());
        this.operators.add(new LessThanOrEqualOperator());
        this.operators.add(new LessThanOperator());
        this.operators.add(new GreaterThanOrEqualOperator());
        this.operators.add(new GreaterThanOperator());
        this.operators.add(new BooleanAndOperator());
        this.operators.add(new BooleanOrOperator());
        this.operators.add(new BooleanNotOperator());
        this.operators.add(new ModulusOperator());
    }

    private void loadSystemFunctions() {
        if (this.loadMathFunctions) {
            new MathFunctions().load(this);
        }
        if (this.loadStringFunctions) {
            new StringFunctions().load(this);
        }
        if (this.loadJudgeFunctions) {
            new JudgeFunctions().load(this);
        }
    }

    private void loadSystemVariables() throws IllegalArgumentException {
        if (this.loadMathVariables) {
            putVariable(ExifInterface.LONGITUDE_EAST, new Double(2.718281828459045d).toString());
            putVariable("PI", new Double(3.141592653589793d).toString());
        }
    }

    private NextOperator processFunction(String str, int i4, Stack stack) throws EvaluationException {
        int i5 = 1;
        int index = i4;
        NextOperator nextOperator = null;
        while (i5 > 0) {
            nextOperator = getNextOperator(str, index + 1, null);
            if (nextOperator == null) {
                throw new EvaluationException("Function is not closed.");
            }
            if (nextOperator.getOperator() instanceof OpenParenthesesOperator) {
                i5++;
            } else if (nextOperator.getOperator() instanceof ClosedParenthesesOperator) {
                i5--;
            }
            index = nextOperator.getIndex();
        }
        String strSubstring = str.substring(i4 + 1, index);
        ExpressionOperand expressionOperand = (ExpressionOperand) stack.pop();
        Operator unaryOperator = expressionOperand.getUnaryOperator();
        String value = expressionOperand.getValue();
        try {
            isValidName(value);
            Function function = (Function) this.functions.get(value);
            if (function == null) {
                throw new EvaluationException(g.j("A function is not defined (index=", i4, ")."));
            }
            stack.push(new ParsedFunction(function, strSubstring, unaryOperator));
            return nextOperator;
        } catch (IllegalArgumentException e4) {
            throw new EvaluationException(g.n("Invalid function name of \"", value, "\"."), e4);
        }
    }

    private int processOperand(String str, int i4, int i5, Stack stack, Operator operator) throws EvaluationException {
        String strTrim;
        if (i5 == -1) {
            strTrim = str.substring(i4).trim();
            i5 = str.length();
        } else {
            strTrim = str.substring(i4, i5).trim();
        }
        if (strTrim.length() == 0) {
            throw new EvaluationException("Expression is invalid.");
        }
        stack.push(new ExpressionOperand(strTrim, operator));
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0048, code lost:
    
        r7 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int processOperator(java.lang.String r7, int r8, net.sourceforge.jeval.operator.Operator r9, java.util.Stack r10, java.util.Stack r11, boolean r12, net.sourceforge.jeval.operator.Operator r13) throws net.sourceforge.jeval.EvaluationException {
        /*
            r6 = this;
            r0 = 0
            if (r12 == 0) goto L28
            boolean r12 = r9 instanceof net.sourceforge.jeval.operator.OpenParenthesesOperator
            if (r12 == 0) goto L28
            net.sourceforge.jeval.NextOperator r8 = r6.processFunction(r7, r8, r11)
            net.sourceforge.jeval.operator.Operator r9 = r8.getOperator()
            int r8 = r8.getIndex()
            int r9 = r9.getLength()
            int r9 = r9 + r8
            net.sourceforge.jeval.NextOperator r7 = r6.getNextOperator(r7, r9, r0)
            if (r7 == 0) goto L27
            net.sourceforge.jeval.operator.Operator r9 = r7.getOperator()
            int r8 = r7.getIndex()
            goto L28
        L27:
            return r9
        L28:
            boolean r7 = r9 instanceof net.sourceforge.jeval.operator.OpenParenthesesOperator
            if (r7 == 0) goto L36
            net.sourceforge.jeval.ExpressionOperator r6 = new net.sourceforge.jeval.ExpressionOperator
            r6.<init>(r9, r13)
            r10.push(r6)
            goto Ld5
        L36:
            boolean r7 = r9 instanceof net.sourceforge.jeval.operator.ClosedParenthesesOperator
            if (r7 == 0) goto L9f
            int r7 = r10.size()
            if (r7 <= 0) goto L47
            java.lang.Object r7 = r10.peek()
            net.sourceforge.jeval.ExpressionOperator r7 = (net.sourceforge.jeval.ExpressionOperator) r7
            goto L48
        L47:
            r7 = r0
        L48:
            if (r7 == 0) goto L62
            net.sourceforge.jeval.operator.Operator r7 = r7.getOperator()
            boolean r7 = r7 instanceof net.sourceforge.jeval.operator.OpenParenthesesOperator
            if (r7 != 0) goto L62
            r6.processTree(r11, r10)
            int r7 = r10.size()
            if (r7 <= 0) goto L47
            java.lang.Object r7 = r10.peek()
            net.sourceforge.jeval.ExpressionOperator r7 = (net.sourceforge.jeval.ExpressionOperator) r7
            goto L48
        L62:
            boolean r7 = r10.isEmpty()
            java.lang.String r12 = "Expression is invalid."
            if (r7 != 0) goto L99
            java.lang.Object r7 = r10.pop()
            net.sourceforge.jeval.ExpressionOperator r7 = (net.sourceforge.jeval.ExpressionOperator) r7
            net.sourceforge.jeval.operator.Operator r10 = r7.getOperator()
            boolean r10 = r10 instanceof net.sourceforge.jeval.operator.OpenParenthesesOperator
            if (r10 == 0) goto L93
            net.sourceforge.jeval.operator.Operator r10 = r7.getUnaryOperator()
            if (r10 == 0) goto Ld5
            java.lang.Object r2 = r11.pop()
            net.sourceforge.jeval.ExpressionTree r10 = new net.sourceforge.jeval.ExpressionTree
            r4 = 0
            net.sourceforge.jeval.operator.Operator r5 = r7.getUnaryOperator()
            r3 = 0
            r0 = r10
            r1 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            r11.push(r10)
            goto Ld5
        L93:
            net.sourceforge.jeval.EvaluationException r6 = new net.sourceforge.jeval.EvaluationException
            r6.<init>(r12)
            throw r6
        L99:
            net.sourceforge.jeval.EvaluationException r6 = new net.sourceforge.jeval.EvaluationException
            r6.<init>(r12)
            throw r6
        L9f:
            int r7 = r10.size()
            if (r7 <= 0) goto Lcd
            java.lang.Object r7 = r10.peek()
            net.sourceforge.jeval.ExpressionOperator r7 = (net.sourceforge.jeval.ExpressionOperator) r7
        Lab:
            if (r7 == 0) goto Lcd
            net.sourceforge.jeval.operator.Operator r7 = r7.getOperator()
            int r7 = r7.getPrecedence()
            int r12 = r9.getPrecedence()
            if (r7 < r12) goto Lcd
            r6.processTree(r11, r10)
            int r7 = r10.size()
            if (r7 <= 0) goto Lcb
            java.lang.Object r7 = r10.peek()
            net.sourceforge.jeval.ExpressionOperator r7 = (net.sourceforge.jeval.ExpressionOperator) r7
            goto Lab
        Lcb:
            r7 = r0
            goto Lab
        Lcd:
            net.sourceforge.jeval.ExpressionOperator r6 = new net.sourceforge.jeval.ExpressionOperator
            r6.<init>(r9, r13)
            r10.push(r6)
        Ld5:
            int r6 = r9.getLength()
            int r6 = r6 + r8
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sourceforge.jeval.Evaluator.processOperator(java.lang.String, int, net.sourceforge.jeval.operator.Operator, java.util.Stack, java.util.Stack, boolean, net.sourceforge.jeval.operator.Operator):int");
    }

    private void processTree(Stack stack, Stack stack2) {
        stack.push(new ExpressionTree(this, stack.size() > 0 ? stack.pop() : null, stack.size() > 0 ? stack.pop() : null, ((ExpressionOperator) stack2.pop()).getOperator(), null));
    }

    private int processUnaryOperator(int i4, Operator operator) {
        return operator.getSymbol().length() + i4;
    }

    public void clearFunctions() {
        this.functions.clear();
        loadSystemFunctions();
    }

    public void clearVariables() throws IllegalArgumentException {
        this.variables.clear();
        loadSystemVariables();
    }

    public String evaluate(String str) throws EvaluationException {
        return evaluate(str, true, true);
    }

    public boolean getBooleanResult(String str) throws EvaluationException {
        return new Double(evaluate(str)).doubleValue() == 1.0d;
    }

    public Function getFunction(String str) {
        return (Function) this.functions.get(str);
    }

    public Map getFunctions() {
        return this.functions;
    }

    public boolean getLoadMathFunctions() {
        return this.loadMathFunctions;
    }

    public boolean getLoadStringFunctions() {
        return this.loadStringFunctions;
    }

    public double getNumberResult(String str) throws EvaluationException {
        try {
            return new Double(evaluate(str)).doubleValue();
        } catch (NumberFormatException e4) {
            throw new EvaluationException("Expression does not produce a number.", e4);
        }
    }

    public boolean getProcessNestedFunctions() {
        return this.processNestedFunctions;
    }

    public char getQuoteCharacter() {
        return this.quoteCharacter;
    }

    public VariableResolver getVariableResolver() {
        return this.variableResolver;
    }

    public String getVariableValue(String str) throws EvaluationException {
        String strResolveVariable;
        VariableResolver variableResolver = this.variableResolver;
        if (variableResolver != null) {
            try {
                strResolveVariable = variableResolver.resolveVariable(str);
            } catch (FunctionException e4) {
                throw new EvaluationException(e4.getMessage(), e4);
            }
        } else {
            strResolveVariable = null;
        }
        if (strResolveVariable == null) {
            strResolveVariable = (String) this.variables.get(str);
        }
        if (strResolveVariable != null) {
            return strResolveVariable;
        }
        throw new EvaluationException(g.n("Can not resolve variable with name equal to \"", str, "\"."));
    }

    public Map getVariables() {
        return this.variables;
    }

    public boolean isExpressionString(String str) throws EvaluationException {
        if (str.length() > 1 && str.charAt(0) == this.quoteCharacter && str.charAt(str.length() - 1) == this.quoteCharacter) {
            return true;
        }
        if (str.indexOf(this.quoteCharacter) < 0) {
            return false;
        }
        throw new EvaluationException("Invalid use of quotes.");
    }

    public boolean isLoadMathVariables() {
        return this.loadMathVariables;
    }

    public void isValidName(String str) throws IllegalArgumentException {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Variable is empty.");
        }
        char cCharAt = str.charAt(0);
        if (cCharAt >= '0' && cCharAt <= '9') {
            throw new IllegalArgumentException("A variable or function name can not start with a number.");
        }
        if (str.indexOf(39) > -1) {
            throw new IllegalArgumentException("A variable or function name can not contain a quote character.");
        }
        if (str.indexOf(34) > -1) {
            throw new IllegalArgumentException("A variable or function name can not contain a quote character.");
        }
        if (str.indexOf(123) > -1) {
            throw new IllegalArgumentException("A variable or function name can not contain an open brace character.");
        }
        if (str.indexOf(125) > -1) {
            throw new IllegalArgumentException("A variable or function name can not contain a closed brace character.");
        }
        if (str.indexOf(35) > -1) {
            throw new IllegalArgumentException("A variable or function name can not contain a pound sign character.");
        }
        Iterator it = this.operators.iterator();
        while (it.hasNext()) {
            if (str.indexOf(((Operator) it.next()).getSymbol()) > -1) {
                throw new IllegalArgumentException("A variable or function name can not contain an operator symbol.");
            }
        }
        if (str.indexOf("!") > -1) {
            throw new IllegalArgumentException("A variable or function name can not contain a special character.");
        }
        if (str.indexOf("~") > -1) {
            throw new IllegalArgumentException("A variable or function name can not contain a special character.");
        }
        if (str.indexOf("^") > -1) {
            throw new IllegalArgumentException("A variable or function name can not contain a special character.");
        }
        if (str.indexOf(",") > -1) {
            throw new IllegalArgumentException("A variable or function name can not contain a special character.");
        }
    }

    public void parse(String str) throws EvaluationException {
        int index;
        Operator operator;
        Operator operator2;
        boolean z4;
        boolean z5;
        int iProcessOperator;
        Operator operator3;
        if (str.equals(this.previousExpression)) {
            this.operatorStack = (Stack) this.previousOperatorStack.clone();
            this.operandStack = (Stack) this.previousOperandStack.clone();
            return;
        }
        this.previousExpression = str;
        try {
            this.operandStack = new Stack();
            this.operatorStack = new Stack();
            int length = str.length();
            Operator operator4 = null;
            boolean z6 = false;
            boolean z7 = false;
            int iProcessOperand = 0;
            while (iProcessOperand < length) {
                if (EvaluationHelper.isSpace(str.charAt(iProcessOperand))) {
                    iProcessOperand++;
                } else {
                    NextOperator nextOperator = getNextOperator(str, iProcessOperand, null);
                    if (nextOperator != null) {
                        Operator operator5 = nextOperator.getOperator();
                        index = nextOperator.getIndex();
                        operator = operator5;
                    } else {
                        index = -1;
                        operator = null;
                    }
                    if (index > iProcessOperand || index == -1) {
                        iProcessOperand = processOperand(str, iProcessOperand, index, this.operandStack, operator4);
                        operator2 = null;
                        z4 = false;
                        z5 = true;
                    } else {
                        z4 = z6;
                        z5 = z7;
                        operator2 = operator4;
                    }
                    if (index == iProcessOperand) {
                        if (nextOperator.getOperator().isUnary() && (z4 || iProcessOperand == 0)) {
                            iProcessOperator = processUnaryOperator(index, nextOperator.getOperator());
                            if (operator2 != null) {
                                throw new EvaluationException("Consecutive unary operators are not allowed (index=" + iProcessOperator + ").");
                            }
                            operator3 = nextOperator.getOperator();
                        } else {
                            iProcessOperator = processOperator(str, index, operator, this.operatorStack, this.operandStack, z5, operator2);
                            operator3 = null;
                        }
                        if (nextOperator.getOperator() instanceof ClosedParenthesesOperator) {
                            iProcessOperand = iProcessOperator;
                            operator4 = operator3;
                            z6 = z4;
                            z7 = z5;
                        } else {
                            iProcessOperand = iProcessOperator;
                            operator4 = operator3;
                            z7 = false;
                            z6 = true;
                        }
                    } else {
                        z6 = z4;
                        z7 = z5;
                        operator4 = operator2;
                    }
                }
            }
            this.previousOperatorStack = (Stack) this.operatorStack.clone();
            this.previousOperandStack = (Stack) this.operandStack.clone();
        } catch (Exception e4) {
            this.previousExpression = "";
            throw new EvaluationException(e4.getMessage(), e4);
        }
    }

    public String processNestedFunctions(String str) throws EvaluationException {
        StringBuffer stringBuffer = new StringBuffer();
        if (str.length() > 0) {
            Evaluator evaluator = new Evaluator(this.quoteCharacter, this.loadMathVariables, this.loadMathFunctions, this.loadStringFunctions, this.loadJudgeFunctions, this.processNestedFunctions);
            evaluator.setFunctions(getFunctions());
            evaluator.setVariables(getVariables());
            evaluator.setVariableResolver(getVariableResolver());
            ArgumentTokenizer argumentTokenizer = new ArgumentTokenizer(str, ',');
            ArrayList arrayList = new ArrayList();
            while (argumentTokenizer.hasMoreTokens()) {
                try {
                    arrayList.add(evaluator.evaluate(argumentTokenizer.nextToken().trim()));
                } catch (Exception e4) {
                    throw new EvaluationException(e4.getMessage(), e4);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(',');
                }
                stringBuffer.append((String) it.next());
            }
        }
        return stringBuffer.toString();
    }

    public void putFunction(Function function) throws IllegalArgumentException {
        isValidName(function.getName());
        if (((Function) this.functions.get(function.getName())) != null) {
            throw new IllegalArgumentException("A function with the same name already exists.");
        }
        this.functions.put(function.getName(), function);
    }

    public void putVariable(String str, String str2) throws IllegalArgumentException {
        isValidName(str);
        this.variables.put(str, str2);
    }

    public void removeFunction(String str) {
        if (!this.functions.containsKey(str)) {
            throw new IllegalArgumentException("The function does not exist.");
        }
        this.functions.remove(str);
    }

    public void removeVaraible(String str) {
        if (!this.variables.containsKey(str)) {
            throw new IllegalArgumentException("The variable does not exist.");
        }
        this.variables.remove(str);
    }

    public String replaceVariables(String str) throws EvaluationException {
        int iIndexOf = str.indexOf(EvaluationConstants.OPEN_VARIABLE);
        if (iIndexOf < 0) {
            return str;
        }
        while (iIndexOf >= 0) {
            if (iIndexOf >= 0) {
                String str2 = EvaluationConstants.CLOSED_VARIABLE;
                int iIndexOf2 = str.indexOf(str2, iIndexOf + 1);
                if (iIndexOf2 <= iIndexOf) {
                    break;
                }
                String str3 = EvaluationConstants.OPEN_VARIABLE;
                String strSubstring = str.substring(str3.length() + iIndexOf, iIndexOf2);
                try {
                    isValidName(strSubstring);
                    str = EvaluationHelper.replaceAll(str, str3 + strSubstring + str2, getVariableValue(strSubstring));
                } catch (IllegalArgumentException e4) {
                    throw new EvaluationException(g.n("Invalid variable name of \"", strSubstring, "\"."), e4);
                }
            }
            iIndexOf = str.indexOf(EvaluationConstants.OPEN_VARIABLE);
        }
        int iIndexOf3 = str.indexOf(EvaluationConstants.OPEN_VARIABLE);
        if (iIndexOf3 <= -1) {
            return str;
        }
        throw new EvaluationException(g.j("A variable has not been closed (index=", iIndexOf3, ")."));
    }

    public void setFunctions(Map map) {
        this.functions = map;
    }

    public void setQuoteCharacter(char c4) {
        if (c4 != '\'' && c4 != '\"') {
            throw new IllegalArgumentException("Invalid quote character.");
        }
        this.quoteCharacter = c4;
    }

    public void setVariableResolver(VariableResolver variableResolver) {
        this.variableResolver = variableResolver;
    }

    public void setVariables(Map map) {
        this.variables = map;
    }

    public Evaluator(char c4, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) throws IllegalArgumentException {
        this.operators = new ArrayList();
        this.functions = new HashMap();
        this.variables = new HashMap();
        this.quoteCharacter = '\'';
        this.openParenthesesOperator = new OpenParenthesesOperator();
        this.closedParenthesesOperator = new ClosedParenthesesOperator();
        this.previousExpression = null;
        this.previousOperatorStack = null;
        this.previousOperandStack = null;
        this.operatorStack = null;
        this.operandStack = null;
        this.variableResolver = null;
        installOperators();
        this.loadMathVariables = z4;
        loadSystemVariables();
        this.loadMathFunctions = z5;
        this.loadStringFunctions = z6;
        this.loadJudgeFunctions = z7;
        loadSystemFunctions();
        setQuoteCharacter(c4);
        this.processNestedFunctions = z8;
    }

    public String evaluate() throws EvaluationException {
        String str = this.previousExpression;
        if (str == null || str.length() == 0) {
            throw new EvaluationException("No expression has been specified.");
        }
        return evaluate(str, true, true);
    }

    public String evaluate(String str, boolean z4, boolean z5) throws EvaluationException {
        parse(str);
        String result = getResult(this.operatorStack, this.operandStack, z5);
        return (!isExpressionString(result) || z4) ? result : result.substring(1, result.length() - 1);
    }

    public String evaluate(boolean z4, boolean z5) throws EvaluationException {
        String str = this.previousExpression;
        if (str != null && str.length() != 0) {
            return evaluate(str, z4, z5);
        }
        throw new EvaluationException("No expression has been specified.");
    }
}
