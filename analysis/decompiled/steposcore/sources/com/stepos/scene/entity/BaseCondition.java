package com.stepos.scene.entity;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseCondition<T> {
    protected String expression;
    protected final List<BaseCondition<T>> subConditions = new ArrayList();
    protected ConditionType type;

    public enum ConditionType {
        SIMPLE,
        LOGICAL_AND,
        LOGICAL_OR,
        LOGICAL_NOT
    }

    protected abstract BaseCondition<T> createSubCondition(String str);

    public abstract boolean evaluate(T t) throws Exception;

    protected abstract void parseSimpleExpression(String str);

    public BaseCondition() {
    }

    public BaseCondition(String expression) {
        this.expression = expression;
    }

    protected boolean evaluateAnd(T context) throws Exception {
        if (this.subConditions.isEmpty()) {
            return false;
        }
        for (BaseCondition<T> sub : this.subConditions) {
            if (!sub.evaluate(context)) {
                return false;
            }
        }
        return true;
    }

    protected boolean evaluateOr(T context) throws Exception {
        if (this.subConditions.isEmpty()) {
            return false;
        }
        for (BaseCondition<T> sub : this.subConditions) {
            if (sub.evaluate(context)) {
                return true;
            }
        }
        return false;
    }

    protected boolean evaluateNot(T context) throws Exception {
        if (this.subConditions.isEmpty()) {
            return false;
        }
        return !this.subConditions.get(0).evaluate(context);
    }

    protected boolean containsLogicOperator(String expr) {
        int depth = 0;
        String expr2 = " " + expr + " ";
        for (int i = 0; i < expr2.length(); i++) {
            char c = expr2.charAt(i);
            if (c == '(') {
                depth++;
            } else if (c == ')') {
                depth--;
            } else if (depth != 0) {
                continue;
            } else {
                if (i + 4 < expr2.length() && expr2.startsWith(" AND", i) && (i + 4 >= expr2.length() || expr2.charAt(i + 4) == ' ')) {
                    return true;
                }
                if (i + 3 < expr2.length() && expr2.startsWith(" OR", i) && (i + 3 >= expr2.length() || expr2.charAt(i + 3) == ' ')) {
                    return true;
                }
                if (i == 0 && expr2.trim().startsWith("NOT ")) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean isMatchingParentheses(String expr) {
        if (!expr.startsWith("(") || !expr.endsWith(")")) {
            return false;
        }
        int depth = 0;
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') {
                depth++;
            } else if (expr.charAt(i) == ')' && depth - 1 == 0 && i < expr.length() - 1) {
                return false;
            }
        }
        return depth == 0;
    }

    protected int findMainLogicOperator(String expr, String operator) {
        int depth = 0;
        String searchPattern = " " + operator + " ";
        String expr2 = " " + expr + " ";
        for (int i = 0; i < (expr2.length() - searchPattern.length()) + 1; i++) {
            char c = expr2.charAt(i);
            if (c == '(') {
                depth++;
            } else if (c == ')') {
                depth--;
            } else if (depth == 0 && expr2.substring(i, searchPattern.length() + i).equals(searchPattern)) {
                return i;
            }
        }
        return -1;
    }

    protected String extractNotOperand(String expr) {
        String expr2 = expr.trim();
        if (expr2.startsWith("(")) {
            int depth = 0;
            for (int i = 0; i < expr2.length(); i++) {
                if (expr2.charAt(i) == '(') {
                    depth++;
                } else if (expr2.charAt(i) == ')' && depth - 1 == 0) {
                    return expr2.substring(0, i + 1);
                }
            }
        }
        int depth2 = 0;
        for (int i2 = 0; i2 < expr2.length(); i2++) {
            char c = expr2.charAt(i2);
            if (c == '(') {
                depth2++;
            } else if (c == ')') {
                depth2--;
            } else if (depth2 == 0 && i2 + 4 <= expr2.length() && expr2.substring(i2, Math.min(i2 + 5, expr2.length())).matches("\\s+(AND|OR)\\s+.*")) {
                return expr2.substring(0, i2).trim();
            }
        }
        return expr2;
    }

    public ConditionType getType() {
        return this.type;
    }

    public List<BaseCondition<T>> getSubConditions() {
        return this.subConditions;
    }

    public String getExpression() {
        return this.expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String toString() {
        return getClass().getSimpleName() + "{type=" + this.type + ", expression='" + this.expression + "', subConditions=" + this.subConditions.size() + '}';
    }
}
