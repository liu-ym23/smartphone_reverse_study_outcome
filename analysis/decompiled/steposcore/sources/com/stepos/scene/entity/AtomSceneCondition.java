package com.stepos.scene.entity;

import android.os.collector.base.StepOSBaseEntity;
import android.util.StepOSDateTimeUrlHelper;
import com.stepos.scene.entity.BaseCondition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class AtomSceneCondition extends BaseCondition<StepOSBaseEntity> {
    private String metric;
    private Operator operator;
    private Object threshold;

    public enum Operator {
        EQUALS("=="),
        NOT_EQUALS("!="),
        GREATER_THAN(">"),
        GREATER_THAN_OR_EQUALS(">="),
        LESS_THAN("<"),
        LESS_THAN_OR_EQUALS("<=");

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return this.symbol;
        }

        public static Operator fromSymbol(String symbol) {
            for (Operator op : values()) {
                if (op.symbol.equals(symbol)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Unknown operator symbol: " + symbol);
        }
    }

    public AtomSceneCondition() {
    }

    public AtomSceneCondition(String expression) {
        super(expression);
        parseExpression(expression);
    }

    public AtomSceneCondition(String metric, Operator operator, Object threshold) {
        this.type = BaseCondition.ConditionType.SIMPLE;
        this.metric = metric;
        this.operator = operator;
        this.threshold = threshold;
        this.expression = buildExpression();
    }

    @Override // com.stepos.scene.entity.BaseCondition
    protected BaseCondition<StepOSBaseEntity> createSubCondition(String subExpr) {
        return new AtomSceneCondition(subExpr);
    }

    private void parseExpression(String expr) {
        if (expr == null || expr.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }
        String expr2 = expr.trim();
        while (expr2.startsWith("(") && expr2.endsWith(")") && isMatchingParentheses(expr2)) {
            expr2 = expr2.substring(1, expr2.length() - 1).trim();
        }
        if (containsLogicOperator(expr2)) {
            parseComplexExpression(expr2);
        } else {
            parseSimpleExpression(expr2);
        }
    }

    private void parseComplexExpression(String expr) {
        String expr2 = expr.trim();
        int orPos = findMainLogicOperator(expr2, "OR");
        if (orPos != -1) {
            this.type = BaseCondition.ConditionType.LOGICAL_OR;
            String left = expr2.substring(0, orPos).trim();
            String right = expr2.substring(orPos + 2).trim();
            this.subConditions.add(new AtomSceneCondition(left));
            this.subConditions.add(new AtomSceneCondition(right));
            return;
        }
        int andPos = findMainLogicOperator(expr2, "AND");
        if (andPos != -1) {
            this.type = BaseCondition.ConditionType.LOGICAL_AND;
            String left2 = expr2.substring(0, andPos).trim();
            String right2 = expr2.substring(andPos + 3).trim();
            this.subConditions.add(new AtomSceneCondition(left2));
            this.subConditions.add(new AtomSceneCondition(right2));
            return;
        }
        if (expr2.startsWith("NOT ")) {
            this.type = BaseCondition.ConditionType.LOGICAL_NOT;
            String subExpr = expr2.substring(4).trim();
            String operand = extractNotOperand(subExpr);
            this.subConditions.add(new AtomSceneCondition(operand));
            return;
        }
        if (expr2.startsWith("(") && expr2.endsWith(")") && isMatchingParentheses(expr2)) {
            String inner = expr2.substring(1, expr2.length() - 1).trim();
            parseExpression(inner);
        } else {
            parseSimpleExpression(expr2);
        }
    }

    @Override // com.stepos.scene.entity.BaseCondition
    protected void parseSimpleExpression(String expr) {
        this.type = BaseCondition.ConditionType.SIMPLE;
        Operator[] operators = {Operator.GREATER_THAN_OR_EQUALS, Operator.LESS_THAN_OR_EQUALS, Operator.EQUALS, Operator.NOT_EQUALS, Operator.GREATER_THAN, Operator.LESS_THAN};
        for (Operator op : operators) {
            String symbol = op.getSymbol();
            int index = expr.indexOf(symbol);
            if (index > 0) {
                this.metric = expr.substring(0, index).trim();
                this.operator = op;
                String thresholdStr = expr.substring(symbol.length() + index).trim();
                this.threshold = parseThreshold(thresholdStr);
                return;
            }
        }
        throw new IllegalArgumentException("Invalid condition expression: " + expr);
    }

    private Object parseThreshold(String thresholdStr) {
        if ("true".equalsIgnoreCase(thresholdStr)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(thresholdStr)) {
            return Boolean.FALSE;
        }
        try {
            if (thresholdStr.contains(".")) {
                return Double.valueOf(Double.parseDouble(thresholdStr));
            }
            return Long.valueOf(Long.parseLong(thresholdStr));
        } catch (NumberFormatException e) {
            if (thresholdStr.startsWith("\"") && thresholdStr.endsWith("\"")) {
                return thresholdStr.substring(1, thresholdStr.length() - 1);
            }
            return thresholdStr;
        }
    }

    private String buildExpression() {
        if (this.type == BaseCondition.ConditionType.SIMPLE) {
            return (this.metric == null || this.operator == null || this.threshold == null) ? "" : this.metric + " " + this.operator.getSymbol() + " " + this.threshold;
        }
        if (this.type == BaseCondition.ConditionType.LOGICAL_NOT && !this.subConditions.isEmpty()) {
            return "NOT " + ((BaseCondition) this.subConditions.get(0)).getExpression();
        }
        if (this.type != BaseCondition.ConditionType.LOGICAL_AND || this.subConditions.size() < 2) {
            return (this.type != BaseCondition.ConditionType.LOGICAL_OR || this.subConditions.size() < 2) ? "" : ((BaseCondition) this.subConditions.get(0)).getExpression() + " OR " + ((BaseCondition) this.subConditions.get(1)).getExpression();
        }
        return ((BaseCondition) this.subConditions.get(0)).getExpression() + " AND " + ((BaseCondition) this.subConditions.get(1)).getExpression();
    }

    @Override // com.stepos.scene.entity.BaseCondition
    public boolean evaluate(StepOSBaseEntity data) throws Exception {
        if (this.type == BaseCondition.ConditionType.SIMPLE) {
            Object value = data.get(this.metric);
            return evaluateSimple(value);
        }
        Object value2 = this.type;
        if (value2 == BaseCondition.ConditionType.LOGICAL_NOT) {
            return evaluateNot(data);
        }
        if (this.type == BaseCondition.ConditionType.LOGICAL_AND) {
            return evaluateAnd(data);
        }
        if (this.type == BaseCondition.ConditionType.LOGICAL_OR) {
            return evaluateOr(data);
        }
        return false;
    }

    private boolean evaluateSimple(Object value) {
        if (this.operator == null || this.threshold == null || value == null) {
            return false;
        }
        try {
            switch (this.operator) {
                case EQUALS:
                    return equals(value, this.threshold);
                case NOT_EQUALS:
                    return !equals(value, this.threshold);
                case GREATER_THAN:
                    return compare(value, this.threshold) > 0;
                case GREATER_THAN_OR_EQUALS:
                    return compare(value, this.threshold) >= 0;
                case LESS_THAN:
                    return compare(value, this.threshold) < 0;
                case LESS_THAN_OR_EQUALS:
                    return compare(value, this.threshold) <= 0;
                default:
                    return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private boolean equals(Object value, Object threshold) {
        if (value == null && threshold == null) {
            return true;
        }
        if (value == null || threshold == null) {
            return false;
        }
        if (value.getClass().equals(threshold.getClass())) {
            return value.equals(threshold);
        }
        return value.toString().equals(threshold.toString());
    }

    private int compare(Object value, Object threshold) {
        if ((value instanceof Number) && (threshold instanceof Number)) {
            double v = ((Number) value).doubleValue();
            double t = ((Number) threshold).doubleValue();
            return Double.compare(v, t);
        }
        if ((value instanceof Comparable) && (threshold instanceof Comparable)) {
            try {
                return ((Comparable) value).compareTo(threshold);
            } catch (ClassCastException e) {
                return value.toString().compareTo(threshold.toString());
            }
        }
        return value.toString().compareTo(threshold.toString());
    }

    public String getMetric() {
        return this.metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
        this.expression = buildExpression();
    }

    public Operator getOperator() {
        return this.operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
        this.expression = buildExpression();
    }

    public Object getThreshold() {
        return this.threshold;
    }

    public void setThreshold(Object threshold) {
        this.threshold = threshold;
        this.expression = buildExpression();
    }

    public List<AtomSceneCondition> getAtomSubConditions() {
        List<AtomSceneCondition> result = new ArrayList<>();
        Iterator it = this.subConditions.iterator();
        while (it.hasNext()) {
            BaseCondition<StepOSBaseEntity> sub = (BaseCondition) it.next();
            if (sub instanceof AtomSceneCondition) {
                result.add((AtomSceneCondition) sub);
            }
        }
        return result;
    }

    @Override // com.stepos.scene.entity.BaseCondition
    public String getExpression() {
        if (this.expression == null || this.expression.isEmpty()) {
            this.expression = buildExpression();
        }
        return this.expression;
    }

    @Override // com.stepos.scene.entity.BaseCondition
    public void setExpression(String expression) {
        this.expression = expression;
        parseExpression(expression);
    }

    public List<String> getAllDataIds() {
        List<String> ids = new ArrayList<>();
        collectDataIds(ids);
        return ids;
    }

    private void collectDataIds(List<String> ids) {
        if (this.type == BaseCondition.ConditionType.SIMPLE && this.metric != null) {
            if (!ids.contains(this.metric)) {
                ids.add(this.metric);
            }
        } else {
            Iterator it = this.subConditions.iterator();
            while (it.hasNext()) {
                BaseCondition<StepOSBaseEntity> sub = (BaseCondition) it.next();
                if (sub instanceof AtomSceneCondition) {
                    ((AtomSceneCondition) sub).collectDataIds(ids);
                }
            }
        }
    }

    @Override // com.stepos.scene.entity.BaseCondition
    public String toString() {
        return toDetailedString(0);
    }

    private String toDetailedString(int indent) {
        StringBuilder sb = new StringBuilder();
        String indentStr = getIndent(indent);
        sb.append("SceneCondition {\n");
        sb.append(indentStr).append("    type: ").append(this.type).append("\n");
        sb.append(indentStr).append("    dataId: ");
        if (this.metric != null) {
            sb.append("\"").append(this.metric).append("\"");
        } else {
            sb.append("null");
        }
        sb.append("\n");
        sb.append(indentStr).append("    operator: ");
        if (this.operator != null) {
            sb.append(this.operator.name());
        } else {
            sb.append("null");
        }
        sb.append("\n");
        sb.append(indentStr).append("    threshold: ");
        if (this.threshold != null) {
            if (this.threshold instanceof String) {
                sb.append("\"").append(this.threshold).append("\"");
            } else {
                sb.append(this.threshold);
            }
        } else {
            sb.append("null");
        }
        sb.append("\n");
        sb.append(indentStr).append("    subConditions: ");
        if (this.subConditions.isEmpty()) {
            sb.append("[]");
        } else {
            sb.append("[\n");
            for (int i = 0; i < this.subConditions.size(); i++) {
                sb.append(indentStr).append("        ");
                BaseCondition<StepOSBaseEntity> subCond = (BaseCondition) this.subConditions.get(i);
                if (subCond instanceof AtomSceneCondition) {
                    sb.append(((AtomSceneCondition) subCond).toDetailedString(indent + 2));
                } else {
                    sb.append(subCond.toString());
                }
                if (i < this.subConditions.size() - 1) {
                    sb.append(StepOSDateTimeUrlHelper.COMMA_STRING);
                }
                sb.append("\n");
            }
            sb.append(indentStr).append("    ]");
        }
        sb.append("\n");
        sb.append(indentStr).append("}");
        return sb.toString();
    }

    private String getIndent(int level) {
        return "    ".repeat(Math.max(0, level));
    }
}
