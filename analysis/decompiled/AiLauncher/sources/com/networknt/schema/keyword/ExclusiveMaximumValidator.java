package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaException;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.utils.JsonNodeTypes;
import com.networknt.schema.utils.JsonType;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public class ExclusiveMaximumValidator extends BaseKeywordValidator {
    private final ThresholdMixin typedMaximum;

    public ExclusiveMaximumValidator(SchemaLocation schemaLocation, final JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.EXCLUSIVE_MAXIMUM, jsonNode, schemaLocation, schema, schemaContext);
        if (!jsonNode.isNumber()) {
            throw new SchemaException("exclusiveMaximum value is not a number");
        }
        final String strAsText = jsonNode.asText();
        if ((!jsonNode.isLong() && !jsonNode.isInt()) || !JsonType.INTEGER.toString().equals(getNodeFieldType())) {
            this.typedMaximum = new ThresholdMixin() { // from class: com.networknt.schema.keyword.ExclusiveMaximumValidator.2
                @Override // com.networknt.schema.keyword.ThresholdMixin
                public boolean crossesThreshold(JsonNode jsonNode2) {
                    if (jsonNode.isDouble() && jsonNode.doubleValue() == Double.POSITIVE_INFINITY) {
                        return false;
                    }
                    if (jsonNode.isDouble() && jsonNode.doubleValue() == Double.NEGATIVE_INFINITY) {
                        return true;
                    }
                    if (jsonNode2.isDouble() && jsonNode2.doubleValue() == Double.NEGATIVE_INFINITY) {
                        return false;
                    }
                    if (jsonNode2.isDouble() && jsonNode2.doubleValue() == Double.POSITIVE_INFINITY) {
                        return true;
                    }
                    int iCompareTo = new BigDecimal(jsonNode2.asText()).compareTo(new BigDecimal(strAsText));
                    return iCompareTo > 0 || iCompareTo == 0;
                }

                @Override // com.networknt.schema.keyword.ThresholdMixin
                public String thresholdValue() {
                    return strAsText;
                }
            };
        } else {
            final long jAsLong = jsonNode.asLong();
            this.typedMaximum = new ThresholdMixin() { // from class: com.networknt.schema.keyword.ExclusiveMaximumValidator.1
                @Override // com.networknt.schema.keyword.ThresholdMixin
                public boolean crossesThreshold(JsonNode jsonNode2) {
                    if (jsonNode2.isBigInteger()) {
                        int iCompareTo = jsonNode2.bigIntegerValue().compareTo(new BigInteger(jsonNode.asText()));
                        return iCompareTo > 0 || iCompareTo == 0;
                    }
                    if (jsonNode2.isTextual()) {
                        int iCompareTo2 = new BigDecimal(jsonNode2.asText()).compareTo(new BigDecimal(strAsText));
                        return iCompareTo2 > 0 || iCompareTo2 == 0;
                    }
                    long jAsLong2 = jsonNode2.asLong();
                    long j10 = jAsLong;
                    return j10 < jAsLong2 || j10 == jAsLong2;
                }

                @Override // com.networknt.schema.keyword.ThresholdMixin
                public String thresholdValue() {
                    return String.valueOf(jAsLong);
                }
            };
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (JsonNodeTypes.isNumber(jsonNode, this.schemaContext.getSchemaRegistryConfig()) && this.typedMaximum.crossesThreshold(jsonNode)) {
            executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(this.typedMaximum.thresholdValue()).build());
        }
    }
}
