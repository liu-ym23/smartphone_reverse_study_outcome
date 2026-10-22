package com.stepos.scene.entity;

import android.util.StepOSDateTimeUrlHelper;
import com.stepos.scene.entity.BaseCondition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CompositionSceneCondition extends BaseCondition<Map<Integer, Boolean>> {
    private int sceneId;

    public CompositionSceneCondition() {
        this.sceneId = -1;
    }

    public CompositionSceneCondition(String expression) {
        super(expression);
        this.sceneId = -1;
        parseExpression(expression);
    }

    @Override // com.stepos.scene.entity.BaseCondition
    protected BaseCondition<Map<Integer, Boolean>> createSubCondition(String subExpr) {
        return new CompositionSceneCondition(subExpr);
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
            this.subConditions.add(new CompositionSceneCondition(left));
            this.subConditions.add(new CompositionSceneCondition(right));
            return;
        }
        int andPos = findMainLogicOperator(expr2, "AND");
        if (andPos != -1) {
            this.type = BaseCondition.ConditionType.LOGICAL_AND;
            String left2 = expr2.substring(0, andPos).trim();
            String right2 = expr2.substring(andPos + 3).trim();
            this.subConditions.add(new CompositionSceneCondition(left2));
            this.subConditions.add(new CompositionSceneCondition(right2));
            return;
        }
        if (expr2.startsWith("NOT ")) {
            this.type = BaseCondition.ConditionType.LOGICAL_NOT;
            String subExpr = expr2.substring(4).trim();
            String operand = extractNotOperand(subExpr);
            this.subConditions.add(new CompositionSceneCondition(operand));
            return;
        }
        parseSimpleExpression(expr2);
    }

    @Override // com.stepos.scene.entity.BaseCondition
    protected void parseSimpleExpression(String expr) {
        this.type = BaseCondition.ConditionType.SIMPLE;
        String trimmed = expr.trim();
        try {
            this.sceneId = Integer.parseInt(trimmed);
            if (!isValidSceneId(this.sceneId)) {
                throw new IllegalArgumentException("Invalid scene ID: " + this.sceneId);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid scene ID (must be integer): " + trimmed);
        }
    }

    private boolean isValidSceneId(int sceneId) {
        return sceneId > 0;
    }

    private String buildExpression() {
        if (this.type == BaseCondition.ConditionType.SIMPLE) {
            return this.sceneId > 0 ? String.valueOf(this.sceneId) : "";
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
    public boolean evaluate(Map<Integer, Boolean> sceneStates) throws Exception {
        if (sceneStates == null || sceneStates.isEmpty()) {
            return false;
        }
        if (this.type == BaseCondition.ConditionType.SIMPLE) {
            Boolean state = sceneStates.get(Integer.valueOf(this.sceneId));
            return state != null && state.booleanValue();
        }
        if (this.type == BaseCondition.ConditionType.LOGICAL_NOT) {
            return evaluateNot(sceneStates);
        }
        if (this.type == BaseCondition.ConditionType.LOGICAL_AND) {
            return evaluateAnd(sceneStates);
        }
        if (this.type != BaseCondition.ConditionType.LOGICAL_OR) {
            return false;
        }
        return evaluateOr(sceneStates);
    }

    public List<Integer> getAllSceneIds() {
        List<Integer> ids = new ArrayList<>();
        collectSceneIds(ids);
        return ids;
    }

    private void collectSceneIds(List<Integer> ids) {
        if (this.type == BaseCondition.ConditionType.SIMPLE && this.sceneId > 0) {
            if (!ids.contains(Integer.valueOf(this.sceneId))) {
                ids.add(Integer.valueOf(this.sceneId));
            }
        } else {
            Iterator it = this.subConditions.iterator();
            while (it.hasNext()) {
                BaseCondition<Map<Integer, Boolean>> sub = (BaseCondition) it.next();
                if (sub instanceof CompositionSceneCondition) {
                    ((CompositionSceneCondition) sub).collectSceneIds(ids);
                }
            }
        }
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
        this.expression = buildExpression();
    }

    public List<CompositionSceneCondition> getCompositionSubConditions() {
        List<CompositionSceneCondition> result = new ArrayList<>();
        Iterator it = this.subConditions.iterator();
        while (it.hasNext()) {
            BaseCondition<Map<Integer, Boolean>> sub = (BaseCondition) it.next();
            if (sub instanceof CompositionSceneCondition) {
                result.add((CompositionSceneCondition) sub);
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

    @Override // com.stepos.scene.entity.BaseCondition
    public String toString() {
        return toDetailedString(0);
    }

    private String toDetailedString(int indent) {
        StringBuilder sb = new StringBuilder();
        String indentStr = getIndent(indent);
        sb.append("CompositionSceneCondition {\n");
        sb.append(indentStr).append("    type: ").append(this.type).append("\n");
        sb.append(indentStr).append("    sceneId: ");
        if (this.sceneId > 0) {
            sb.append(this.sceneId);
        } else {
            sb.append("-1 (not set)");
        }
        sb.append("\n");
        sb.append(indentStr).append("    expression: ");
        if (this.expression != null && !this.expression.isEmpty()) {
            sb.append("\"").append(this.expression).append("\"");
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
                BaseCondition<Map<Integer, Boolean>> subCond = (BaseCondition) this.subConditions.get(i);
                if (subCond instanceof CompositionSceneCondition) {
                    sb.append(((CompositionSceneCondition) subCond).toDetailedString(indent + 2));
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
