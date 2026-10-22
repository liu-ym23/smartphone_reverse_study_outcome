package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.utils.JsonNodeTypes;
import java.math.BigDecimal;

/* loaded from: classes2.dex */
public class MultipleOfValidator extends BaseKeywordValidator implements KeywordValidator {
    private final BigDecimal divisor;

    public MultipleOfValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.MULTIPLE_OF, jsonNode, schemaLocation, schema, schemaContext);
        this.divisor = getDivisor(jsonNode);
    }

    public BigDecimal getDividend(JsonNode jsonNode) {
        if (jsonNode.isNumber()) {
            return jsonNode.isBigDecimal() ? jsonNode.decimalValue() : BigDecimal.valueOf(jsonNode.doubleValue());
        }
        if (this.schemaContext.getSchemaRegistryConfig().isTypeLoose() && JsonNodeTypes.isNumber(jsonNode, this.schemaContext.getSchemaRegistryConfig())) {
            return new BigDecimal(jsonNode.textValue());
        }
        return null;
    }

    public BigDecimal getDivisor(JsonNode jsonNode) {
        if (!jsonNode.isNumber()) {
            return null;
        }
        double dDoubleValue = jsonNode.doubleValue();
        if (dDoubleValue != 0.0d) {
            return jsonNode.isBigDecimal() ? jsonNode.decimalValue() : BigDecimal.valueOf(dDoubleValue);
        }
        return null;
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        BigDecimal dividend;
        if (this.divisor == null || (dividend = getDividend(jsonNode)) == null || dividend.divideAndRemainder(this.divisor)[1].abs().compareTo(BigDecimal.ZERO) <= 0) {
            return;
        }
        executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(this.divisor).build());
    }
}
